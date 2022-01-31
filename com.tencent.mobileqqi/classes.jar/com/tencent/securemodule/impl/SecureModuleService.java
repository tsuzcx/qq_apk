package com.tencent.securemodule.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.securemodule.ac.a;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import com.tencent.securemodule.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecureModuleService
  implements ISecureModuleService
{
  private Context a;
  private List<CloudScanBroadcastReceiver> b;
  
  private SecureModuleService(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
  }
  
  public static String downloadFile(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = new z(paramContext);
    paramContext.g = paramString2;
    paramContext.h = paramInt;
    while (paramContext.a(paramString1) == -7) {}
    return paramContext.f + File.separator + paramContext.g;
  }
  
  public static String getCachePath(Context paramContext)
  {
    return paramContext.getCacheDir().getAbsolutePath();
  }
  
  public static String getFilesPath(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  public static SecureModuleService getInstance(Context paramContext)
  {
    return new SecureModuleService(paramContext);
  }
  
  public void cloudScan()
  {
    SecureService.a(this.a, "1000010");
  }
  
  public int register(ProductInfo paramProductInfo)
  {
    int i = 0;
    if (paramProductInfo == null) {
      i = -6;
    }
    do
    {
      return i;
      SharedPreferences.Editor localEditor = this.a.getSharedPreferences("secure_config", 0).edit();
      localEditor.putInt(String.format("%5d", new Object[] { Integer.valueOf(30003) }), paramProductInfo.getProductId());
      localEditor.putString(String.format("%5d", new Object[] { Integer.valueOf(30001) }), paramProductInfo.getVersion());
      localEditor.putInt(String.format("%5d", new Object[] { Integer.valueOf(30004) }), paramProductInfo.getBuildNo());
      localEditor.putInt(String.format("%5d", new Object[] { Integer.valueOf(30005) }), paramProductInfo.getSubPlatformId());
      localEditor.putString(String.format("%5d", new Object[] { Integer.valueOf(30002) }), paramProductInfo.getChannelId());
      localEditor.putString(String.format("%5d", new Object[] { Integer.valueOf(30006) }), paramProductInfo.getQq());
      localEditor.commit();
    } while (ac.a.a(this.a, "sm_mq"));
    return -1;
  }
  
  public void registerCloudScanListener(Context paramContext, CloudScanListener paramCloudScanListener)
  {
    Object localObject = this.b.iterator();
    int i = 0;
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        if (i == 0)
        {
          paramCloudScanListener = new CloudScanBroadcastReceiver(paramCloudScanListener);
          this.b.add(paramCloudScanListener);
          localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("1000030");
          ((IntentFilter)localObject).addAction("1000031");
          paramContext.registerReceiver(paramCloudScanListener, (IntentFilter)localObject);
        }
        return;
      }
      if (((CloudScanBroadcastReceiver)((Iterator)localObject).next()).a(paramCloudScanListener)) {
        i = 1;
      }
    }
  }
  
  public void unregisterCloudScanListener(Context paramContext, CloudScanListener paramCloudScanListener)
  {
    Iterator localIterator = this.b.iterator();
    Object localObject = null;
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (localObject != null)
        {
          this.b.remove(localObject);
          paramContext.unregisterReceiver(localObject);
        }
        return;
      }
      CloudScanBroadcastReceiver localCloudScanBroadcastReceiver = (CloudScanBroadcastReceiver)localIterator.next();
      if (localCloudScanBroadcastReceiver.a(paramCloudScanListener)) {
        localObject = localCloudScanBroadcastReceiver;
      }
    }
  }
  
  public class CloudScanBroadcastReceiver
    extends BroadcastReceiver
  {
    public CloudScanBroadcastReceiver() {}
    
    public final boolean a(CloudScanListener paramCloudScanListener)
    {
      if (SecureModuleService.this != null) {
        return SecureModuleService.this.equals(paramCloudScanListener);
      }
      return paramCloudScanListener == null;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("1000030".equals(paramIntent.getAction())) {
        SecureModuleService.this.onRiskFound();
      }
      while (!"1000031".equals(paramIntent.getAction())) {
        return;
      }
      int i = paramIntent.getIntExtra("key_errcode", 0);
      SecureModuleService.this.onFinish(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.impl.SecureModuleService
 * JD-Core Version:    0.7.0.1
 */