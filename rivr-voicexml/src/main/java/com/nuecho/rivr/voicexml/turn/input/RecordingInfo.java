/*
 * Copyright (c) 2004 Nu Echo Inc. All rights reserved.
 */
package com.nuecho.rivr.voicexml.turn.input;

import javax.json.*;

import com.nuecho.rivr.core.util.*;
import com.nuecho.rivr.voicexml.servlet.*;
import com.nuecho.rivr.voicexml.util.json.*;

/**
 * @author Nu Echo Inc.
 */
public final class RecordingInfo implements JsonSerializable {

    private static final String DURATION_PROPERTY = "duration";
    private static final String MAX_TIME_PROPERTY = "maxTime";
    private static final String DTMF_TERM_PROPERTY = "dtmfTerm";

    private final FileUpload mFile;
    private final TimeValue mDuration;
    private final boolean mMaxTime;
    private final String mDtmfTerm;

    public RecordingInfo(FileUpload file, TimeValue duration, boolean maxTime, String dtmfTerm) {
        mFile = file;
        mDuration = duration;
        mMaxTime = maxTime;
        mDtmfTerm = dtmfTerm;
    }

    public FileUpload getFile() {
        return mFile;
    }

    public boolean isMaxTime() {
        return mMaxTime;
    }

    public String getDtmfTerm() {
        return mDtmfTerm;
    }

    public TimeValue getDuration() {
        return mDuration;
    }

    @Override
    public String toString() {
        return asJson().toString();
    }

    @Override
    public JsonValue asJson() {
        JsonObjectBuilder builder = JsonUtils.createObjectBuilder();
        JsonUtils.add(builder, DTMF_TERM_PROPERTY, mDtmfTerm);
        builder.add(MAX_TIME_PROPERTY, mMaxTime);
        builder.add(DURATION_PROPERTY, mDuration.getMilliseconds());
        JsonUtils.add(builder, "file", mFile);
        return builder.build();
    }
}