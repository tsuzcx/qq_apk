package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;

final class AGConnectServicesConfigImpl$1
  extends LazyInputStream
{
  AGConnectServicesConfigImpl$1(Context paramContext, InputStream paramInputStream)
  {
    super(paramContext);
  }
  
  public InputStream get(Context paramContext)
  {
    return this.val$input;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.config.impl.AGConnectServicesConfigImpl.1
 * JD-Core Version:    0.7.0.1
 */