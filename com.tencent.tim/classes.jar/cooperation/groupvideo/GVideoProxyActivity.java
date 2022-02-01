package cooperation.groupvideo;

import acfp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import arhz;
import avfg;
import avfw;
import avfw.d;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.PluginInfo;

public class GVideoProxyActivity
  extends PluginProxyActivity
{
  public FlingHandler mFlingHandler;
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new arhz(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299627));
    paramActivity.setMessage(acfp.m(2131707109));
    paramActivity.setOnDismissListener(new avfg());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    avfw.d locald = new avfw.d(1);
    locald.mPluginID = "group_video_plugin.apk";
    locald.mPluginName = PluginInfo.cKI;
    locald.mUin = paramString2;
    locald.cKu = paramString1;
    locald.K = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    locald.mIntent = paramString1;
    locald.mDialog = paramDialog;
    locald.mIntent.putExtra("userQqResources", 2);
    locald.mIntent.putExtra("param_plugin_gesturelock", true);
    locald.mRequestCode = paramInt;
    locald.mTimeOut = 20000;
    locald.cKv = null;
    avfw.a(paramActivity, locald);
  }
  
  public String getPluginID()
  {
    return "group_video_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return GVideoProxyActivity.class;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (getIntent().getExtras() != null) {
      this.mFlingHandler = new a(this);
    }
    super.onCreate(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.mFlingHandler.onStart();
  }
  
  public static class a
    extends FlingGestureHandler
  {
    boolean ctm = true;
    
    public a(Activity paramActivity)
    {
      super();
    }
    
    public void flingLToR()
    {
      if (this.ctm) {
        super.flingLToR();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.groupvideo.GVideoProxyActivity
 * JD-Core Version:    0.7.0.1
 */