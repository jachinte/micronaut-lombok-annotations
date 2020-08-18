package com.example.locale;

import io.micronaut.http.HttpRequest;
import java.util.Locale;
import javax.inject.Named;
import javax.inject.Singleton;

@Named("default")
@Singleton
public class DefaultLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolve(final HttpRequest<?> ignored) {
        return this.getCurrentLocale();
    }

    @Override
    public void setCurrentLocale(final HttpRequest<?> ignored) {
        // Do nothing
    }

    @Override
    public Locale getCurrentLocale() {
        return Locale.getDefault();
    }

}
