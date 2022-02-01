package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.e;

public abstract class AbstractNetAdapter
{
  protected static final int CONNECT_TIMEOUT = 30000;
  protected static final int READ_TIMEOUT = 10000;
  
  public abstract void request(JceRequestEntity paramJceRequestEntity, Callback<byte[]> paramCallback);
  
  public abstract void request(e parame, Callback<BResponse> paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.adapter.AbstractNetAdapter
 * JD-Core Version:    0.7.0.1
 */