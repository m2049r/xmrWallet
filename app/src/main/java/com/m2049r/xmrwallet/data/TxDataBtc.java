/*
 * Copyright (c) 2017 m2049r
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.m2049r.xmrwallet.data;

import android.os.Parcel;

import androidx.annotation.NonNull;

import lombok.Getter;
import lombok.Setter;

public class TxDataBtc extends TxData {
    @Getter
    @Setter
    private String xmrtoOrderId; // shown in success screen
    @Getter
    @Setter
    private String btcAddress;
    @Getter
    @Setter
    private double btcAmount;

    public TxDataBtc() {
        super();
    }

    public TxDataBtc(TxDataBtc txDataBtc) {
        super(txDataBtc);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeString(xmrtoOrderId);
        out.writeString(btcAddress);
        out.writeDouble(btcAmount);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Creator<TxDataBtc> CREATOR = new Creator<TxDataBtc>() {
        public TxDataBtc createFromParcel(Parcel in) {
            return new TxDataBtc(in);
        }

        public TxDataBtc[] newArray(int size) {
            return new TxDataBtc[size];
        }
    };

    protected TxDataBtc(Parcel in) {
        super(in);
        xmrtoOrderId = in.readString();
        btcAddress = in.readString();
        btcAmount = in.readDouble();
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("xmrtoOrderId:");
        sb.append(xmrtoOrderId);
        sb.append(",btcAddress:");
        sb.append(btcAddress);
        sb.append(",btcAmount:");
        sb.append(btcAmount);
        return sb.toString();
    }
}
