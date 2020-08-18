package com.example;

import com.example.locale.LocaleResolver;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Controller
@RequiredArgsConstructor(onConstructor_={@Inject})
@Secured(SecurityRule.IS_ANONYMOUS)
public class HomeController {

    @Named("header")
    private final Provider<LocaleResolver> resolver;

    @Named("default")
    private final LocaleResolver serverLocale;

    @Get
    public Locales index(HttpRequest<?> request) {
        this.resolver.get().setCurrentLocale(request);
        // Do stuff
        // Get the current locale--usually done somewhere else
        return new Locales(
            this.resolver.get().getCurrentLocale().getDisplayName(),
            this.serverLocale.getCurrentLocale().getDisplayName()
        );
    }

    @Introspected
    @Value
    private static class Locales {

        private final String request;

        private final String server;

    }

}
