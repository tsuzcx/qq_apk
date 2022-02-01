package com.huawei.hms.aaid.b;

import android.content.Context;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import java.util.Arrays;

public class e
  extends AbstractClientBuilder<d, Api.ApiOptions.NoOptions>
{
  public d buildClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    paramClientSettings.setApiName(Arrays.asList(new String[] { "HuaweiPush.API", "Core.API" }));
    return new d(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.b.e
 * JD-Core Version:    0.7.0.1
 */