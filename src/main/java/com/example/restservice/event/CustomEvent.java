package com.example.restservice.event;

import java.io.Serializable;

public record CustomEvent<T extends Serializable>(EventType type, T payload) {
}