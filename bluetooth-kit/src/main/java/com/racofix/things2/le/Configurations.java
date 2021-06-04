package com.racofix.things2.le;

import android.app.Application;

import com.racofix.things2.le.util.Preconditions;

public class Configurations {

    private Builder builder;

    private Configurations(Builder builder) {
        this.builder = builder;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getServiceUuid() {
        return Preconditions.checkNotNull(builder.serviceUuid);
    }

    public String getCharacterUuid() {
        return Preconditions.checkNotNull(builder.characterUuid);
    }

    public Application getApplication() {
        return Preconditions.checkNotNull(builder.application);
    }

    public Operation getTrigger() {
        return Preconditions.checkNotNull(builder.operation);
    }

    public boolean isSplit() {
        return Preconditions.checkNotNull(builder.split);
    }

    public final static class Builder {
        private String serviceUuid;
        private String characterUuid;
        private Application application;
        private Operation operation;
        private boolean split;

        public Builder serviceUuid(String serviceUuid) {
            this.serviceUuid = serviceUuid;
            return this;
        }

        public Builder characterUuid(String characterUuid) {
            this.characterUuid = characterUuid;
            return this;
        }

        public Builder application(Application application) {
            this.application = application;
            return this;
        }

        public Builder operation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public Builder split(boolean split) {
            this.split = split;
            return this;
        }

        public Configurations newInstance() {
            return new Configurations(this);
        }
    }
}
