package com.huawei.hms.push.c;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

public class e
  extends HmsClient
{
  public e(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    super(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
  
  public int getMinApkVersion()
  {
    return 30000000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.c.e
 * JD-Core Version:    0.7.0.1
 */