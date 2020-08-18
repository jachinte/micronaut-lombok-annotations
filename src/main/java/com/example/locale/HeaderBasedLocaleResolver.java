package com.example.locale;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.runtime.http.scope.RequestScope;
import java.util.Locale;
import javax.inject.Named;

@Named("header")
@RequestScope
public class HeaderBasedLocaleResolver implements LocaleResolver {

    private static final String DEFAULT_LANG = "en";

    private transient Locale current =
        Locale.forLanguageTag(HeaderBasedLocaleResolver.DEFAULT_LANG);

    @Override
    public Locale resolve(final HttpRequest<?> request) {
        return Locale.forLanguageTag(
            request.getHeaders()
                .findFirst(HttpHeaders.ACCEPT_LANGUAGE)
                .orElse(HeaderBasedLocaleResolver.DEFAULT_LANG)
        );
    }

    @Override
    public void setCurrentLocale(final HttpRequest<?> request) {
        this.current = this.resolve(request);
    }

    @Override
    public Locale getCurrentLocale() {
        return this.current;
    }

}
