package com.huawei.hms.update.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;
import com.huawei.hms.utils.b;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class UpdateManager
{
  private static void a(Activity paramActivity, ArrayList<Integer> paramArrayList)
  {
    if ((Util.isEMUI()) && (Util.isChinaROM()))
    {
      if ((a(paramActivity, "com.huawei.appmarket")) && (c(paramActivity)))
      {
        paramArrayList.add(Integer.valueOf(0));
        paramArrayList.add(Integer.valueOf(6));
        return;
      }
      paramArrayList.add(Integer.valueOf(6));
      return;
    }
    if ((a(paramActivity, "com.huawei.appmarket")) && (!"com.huawei.appmarket".equals(paramActivity.getPackageName())))
    {
      paramArrayList.add(Integer.valueOf(5));
      return;
    }
    if (a(paramActivity))
    {
      paramArrayList.add(Integer.valueOf(2));
      return;
    }
    paramArrayList.add(Integer.valueOf(6));
  }
  
  private static void a(Context paramContext, ArrayList<Integer> paramArrayList)
  {
    if ((Util.isEMUI()) && (Util.isChinaROM()))
    {
      if ((a(paramContext, "com.huawei.appmarket")) && (c(paramContext)))
      {
        paramArrayList.add(Integer.valueOf(0));
        paramArrayList.add(Integer.valueOf(6));
        return;
      }
      paramArrayList.add(Integer.valueOf(6));
      return;
    }
    if ((a(paramContext, "com.huawei.appmarket")) && (!"com.huawei.appmarket".equals(paramContext.getPackageName())))
    {
      paramArrayList.add(Integer.valueOf(5));
      return;
    }
    if (a(paramContext))
    {
      paramArrayList.add(Integer.valueOf(2));
      return;
    }
    paramArrayList.add(Integer.valueOf(6));
  }
  
  private static boolean a(Context paramContext)
  {
    return (a(paramContext, "com.android.vending")) && (b(paramContext));
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    paramContext = new PackageManagerHelper(paramContext).getPackageStates(paramString);
    HMSLog.i("UpdateManager", "app is: " + paramString + ";status is:" + paramContext);
    return PackageManagerHelper.PackageStates.ENABLED == paramContext;
  }
  
  private static void b(Activity paramActivity, ArrayList<Integer> paramArrayList)
  {
    if ((a(paramActivity, "com.huawei.appmarket")) && (!"com.huawei.appmarket".equals(paramActivity.getPackageName())))
    {
      paramArrayList.add(Integer.valueOf(5));
      return;
    }
    paramArrayList.add(Integer.valueOf(4));
  }
  
  private static void b(Context paramContext, ArrayList<Integer> paramArrayList)
  {
    if ((a(paramContext, "com.huawei.appmarket")) && (!"com.huawei.appmarket".equals(paramContext.getPackageName())))
    {
      paramArrayList.add(Integer.valueOf(5));
      return;
    }
    paramArrayList.add(Integer.valueOf(4));
  }
  
  private static boolean b(Context paramContext)
  {
    ResourceLoaderUtil.setmContext(paramContext);
    boolean bool = new a().a(1000L, TimeUnit.MILLISECONDS, ResourceLoaderUtil.getString("hms_base_google"));
    HMSLog.i("UpdateManager", "ping google status is:" + bool);
    return bool;
  }
  
  private static boolean c(Context paramContext)
  {
    int i = new PackageManagerHelper(paramContext).getPackageVersionCode("com.huawei.appmarket");
    HMSLog.i("UpdateManager", "getHiappVersion is " + i);
    return i >= 70203000L;
  }
  
  public static Intent getStartUpdateIntent(Activity paramActivity, UpdateBean paramUpdateBean)
  {
    if ((paramActivity == null) || (paramUpdateBean == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramUpdateBean.getClientAppName())) {
      a(paramActivity, localArrayList);
    }
    for (;;)
    {
      paramUpdateBean.setTypeList(localArrayList);
      paramActivity = BridgeActivity.getIntentStartBridgeActivity(paramActivity, com.huawei.hms.update.ui.a.a(((Integer)localArrayList.get(0)).intValue()));
      paramActivity.putExtra("intent.extra.update.info", paramUpdateBean);
      return paramActivity;
      b(paramActivity, localArrayList);
    }
  }
  
  public static Intent getStartUpdateIntent(Context paramContext, UpdateBean paramUpdateBean)
  {
    if ((paramContext == null) || (paramUpdateBean == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramUpdateBean.getClientAppName())) {
      a(paramContext, localArrayList);
    }
    for (;;)
    {
      paramUpdateBean.setTypeList(localArrayList);
      paramContext = BridgeActivity.getIntentStartBridgeActivity(paramContext, com.huawei.hms.update.ui.a.a(((Integer)localArrayList.get(0)).intValue()));
      paramContext.putExtra("intent.extra.update.info", paramUpdateBean);
      return paramContext;
      b(paramContext, localArrayList);
    }
  }
  
  public static void startUpdate(Activity paramActivity, int paramInt, UpdateBean paramUpdateBean)
  {
    paramUpdateBean = getStartUpdateIntent(paramActivity, paramUpdateBean);
    if (paramUpdateBean != null) {
      paramActivity.startActivityForResult(paramUpdateBean, paramInt);
    }
  }
  
  public static Intent startUpdateIntent(Activity paramActivity)
  {
    if (paramActivity == null) {
      return null;
    }
    UpdateBean localUpdateBean = new UpdateBean();
    localUpdateBean.setHmsOrApkUpgrade(true);
    localUpdateBean.setClientPackageName(b.a(paramActivity.getApplicationContext()).b());
    localUpdateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
    localUpdateBean.setClientAppId("C10132067");
    localUpdateBean.setNeedConfirm(false);
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    localUpdateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(localUpdateBean.getClientAppName()))
    {
      a(paramActivity, localArrayList);
      localUpdateBean.setTypeList(localArrayList);
      if (localArrayList.size() <= 1) {
        break label147;
      }
    }
    label147:
    for (paramActivity = BridgeActivity.getIntentStartBridgeActivity(paramActivity, com.huawei.hms.update.ui.a.a(((Integer)localArrayList.get(1)).intValue()));; paramActivity = BridgeActivity.getIntentStartBridgeActivity(paramActivity, com.huawei.hms.update.ui.a.a(((Integer)localArrayList.get(0)).intValue())))
    {
      paramActivity.putExtra("intent.extra.update.info", localUpdateBean);
      return paramActivity;
      b(paramActivity, localArrayList);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.manager.UpdateManager
 * JD-Core Version:    0.7.0.1
 */