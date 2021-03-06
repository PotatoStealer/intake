package com.sk89q.intake.bukkit.parametric.annotation;

import com.sk89q.intake.bukkit.parametric.Type;
import com.sk89q.intake.parametric.annotation.Classifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Define the fetching behaviour of {@link Player}s
 * on the local server.
 *
 * If not defined, the default is {@link Type#THROW}.
 */
@Classifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Player {
    Type value();
}
