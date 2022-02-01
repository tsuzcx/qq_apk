package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import arlb;
import arlc;
import arld;
import arle;
import arlg;
import arlh;
import arln;
import arlp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class FloatingScreenManager
{
  private static final String QQFS_LOCATION_CENTER_X = "qqfs_floating_center_x";
  private static final String QQFS_LOCATION_CENTER_Y = "qqfs_floating_center_y";
  public static final String QQFS_SP_NAME = "qqfs_floating_sp";
  private static final String TAG = "FloatingScreenManager";
  private static FloatingScreenManager mFloatingManager;
  private arlp mWrapperFactory = new arlp();
  
  public static FloatingScreenManager getInstance()
  {
    if (mFloatingManager == null) {}
    try
    {
      if (mFloatingManager == null) {
        mFloatingManager = new FloatingScreenManager();
      }
      return mFloatingManager;
    }
    finally {}
  }
  
  private static void sendWindowClosedBroadcastWithId(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_concern_floating_type", 0);
    localIntent.putExtra("param_curr_window_status", 104);
    localIntent.putExtra("param_busitype", paramInt);
    localIntent.putExtra("param_ignored_processid", BaseApplicationImpl.sProcessId);
    paramContext.sendBroadcast(localIntent);
  }
  
  public int enterFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams, int paramInt)
  {
    int i = 1;
    if ((paramContext == null) || (paramView == null)) {
      i = 2;
    }
    for (;;)
    {
      return i;
      try
      {
        arlb.Za(paramInt);
        if (!FloatingScreenPermission.checkPermission(paramContext)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenManager", 2, new Object[] { "enterFloatingScree:", paramView.toString() });
        }
        sendWindowClosedBroadcastWithId(paramContext, paramInt);
        arlc.y(BaseApplicationImpl.getContext(), 50, 2);
        FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
        if (paramFloatingScreenParams == null) {
          localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(2).build();
        }
        paramFloatingScreenParams = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4);
        i = paramFloatingScreenParams.getInt("qqfs_floating_center_x", -2147483648);
        int j = paramFloatingScreenParams.getInt("qqfs_floating_center_y", -2147483648);
        if ((i != -2147483648) && (j != -2147483648))
        {
          localFloatingScreenParams.setFloatingCenterX(i);
          localFloatingScreenParams.setFloatingCenterY(j);
        }
        paramContext = this.mWrapperFactory.a(paramContext, 0);
        if (paramContext == null)
        {
          i = 3;
          continue;
        }
        j = paramContext.a(localFloatingScreenParams, paramView);
        i = j;
        if (j != 0) {
          continue;
        }
        arlb.YZ(paramInt);
        i = j;
      }
      finally {}
    }
  }
  
  public int enterLocationFloatingScreen(Context paramContext, View paramView, FloatingScreenParams paramFloatingScreenParams)
  {
    int i = 1;
    if ((paramContext == null) || (paramView == null)) {
      i = 2;
    }
    for (;;)
    {
      return i;
      try
      {
        if (!FloatingScreenPermission.checkPermission(paramContext)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenManager", 2, new Object[] { "enterLocationFloatingScreen:", paramView.toString() });
        }
        FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
        if (paramFloatingScreenParams == null) {
          localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).build();
        }
        paramContext = this.mWrapperFactory.a(paramContext, 1);
        if (paramContext == null)
        {
          i = 3;
          continue;
        }
        if ((paramContext instanceof arlh)) {
          ((arlh)paramContext).b(localFloatingScreenParams);
        }
        i = paramContext.a(localFloatingScreenParams, paramView);
      }
      finally {}
    }
  }
  
  public int enterWatchTogetherFloatingScreen(Context paramContext, WatchTogetherFloatingView paramWatchTogetherFloatingView, FloatingScreenParams paramFloatingScreenParams)
  {
    int i = 1;
    if ((paramContext == null) || (paramWatchTogetherFloatingView == null)) {
      i = 2;
    }
    for (;;)
    {
      return i;
      try
      {
        if (!FloatingScreenPermission.checkPermission(paramContext)) {
          continue;
        }
        if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool"))
        {
          QQToast.a(paramContext, 2131701820, 0).show();
          i = -1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenManager", 2, new Object[] { "enterLocationFloatingScreen:", paramWatchTogetherFloatingView.toString() });
        }
        FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
        if (paramFloatingScreenParams == null) {
          localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).build();
        }
        paramContext = this.mWrapperFactory.a(paramContext, 2);
        if (paramContext == null)
        {
          i = 3;
          continue;
        }
        if ((paramContext instanceof arln)) {
          ((arln)paramContext).b(localFloatingScreenParams);
        }
        i = paramContext.a(localFloatingScreenParams, paramWatchTogetherFloatingView);
      }
      finally {}
    }
  }
  
  public void quitFloatingScreen()
  {
    arlg localarlg = this.mWrapperFactory.a(null, 0);
    if (localarlg != null) {
      localarlg.Ze(4);
    }
  }
  
  public void quitFloatingScreen(int paramInt)
  {
    arlg localarlg = this.mWrapperFactory.a(null, paramInt);
    if (localarlg != null) {
      localarlg.Ze(4);
    }
  }
  
  public void saveFloatingCenter(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
    localEditor.putInt("qqfs_floating_center_x", paramInt1);
    localEditor.putInt("qqfs_floating_center_y", paramInt2);
    localEditor.commit();
  }
  
  public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    IVideoOuterStatusListener localIVideoOuterStatusListener = null;
    arlg localarlg = this.mWrapperFactory.a(null, 0);
    if (localarlg != null) {
      localIVideoOuterStatusListener = localarlg.a(paramIVideoInnerStatusListener);
    }
    return localIVideoOuterStatusListener;
  }
  
  public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener paramIVideoInnerStatusListener, int paramInt)
  {
    IVideoOuterStatusListener localIVideoOuterStatusListener = null;
    arlg localarlg = this.mWrapperFactory.a(null, paramInt);
    if (localarlg != null) {
      localIVideoOuterStatusListener = localarlg.a(paramIVideoInnerStatusListener);
    }
    return localIVideoOuterStatusListener;
  }
  
  @Deprecated
  public void setFullScreenListener(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    arlg localarlg = this.mWrapperFactory.a(null, 0);
    if (localarlg != null) {
      localarlg.a(paramIFullScreenEnterListener);
    }
  }
  
  public void setFullScreenViewClickListener(arld paramarld)
  {
    arlg localarlg = this.mWrapperFactory.a(null, 0);
    if (localarlg != null) {
      localarlg.setFullScreenViewClickListener(paramarld);
    }
  }
  
  public void setWindowClickListener(int paramInt, arle paramarle)
  {
    arlg localarlg = this.mWrapperFactory.a(null, paramInt);
    if (localarlg != null) {
      localarlg.a(paramarle);
    }
  }
  
  public void updateFloatingWindowRatio(float paramFloat, int paramInt)
  {
    arlg localarlg = this.mWrapperFactory.a(null, paramInt);
    if (localarlg != null) {
      localarlg.bh(paramFloat);
    }
  }
  
  public void updateFloatingWindowShape(int paramInt1, int paramInt2)
  {
    arlg localarlg = this.mWrapperFactory.a(null, paramInt2);
    if (localarlg != null) {
      localarlg.YY(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager
 * JD-Core Version:    0.7.0.1
 */