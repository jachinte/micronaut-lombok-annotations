package com.example.locale;

import io.micronaut.http.HttpRequest;
import java.util.Locale;

public interface LocaleResolver {

    Locale resolve(HttpRequest<?> request);

    void setCurrentLocale(HttpRequest<?> request);

    Locale getCurrentLocale();

}
