package com.scjp.demo;
import org.jspecify.annotations.Nullable;

public record Movie(Long id, String name, @Nullable Double rating) {
}