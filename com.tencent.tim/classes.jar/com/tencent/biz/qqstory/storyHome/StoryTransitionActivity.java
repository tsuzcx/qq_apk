package com.tencent.biz.qqstory.storyHome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import jsp;
import org.json.JSONException;
import org.json.JSONObject;
import pma;
import pso;
import psr;
import psx;
import qqy;
import qrh;
import qwf;
import ram;
import rnq;

public class StoryTransitionActivity
  extends QQStoryBaseActivity
{
  private qwf a;
  private int bnM;
  
  public static final Intent a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.w("zivonchen", 2, "getMainIntent() isNowTabAdded = " + jsp.abw);
    }
    if (jsp.abw)
    {
      ((pso)psx.a(18)).IH();
      paramContext = new Intent(paramContext, SplashActivity.class);
      paramContext.putExtra("fragment_id", 1);
      paramContext.putExtra("tab_index", MainFragment.bIp);
      paramContext.putExtra("open_now_tab_fragment", true);
      paramContext.putExtra("extra_from_share", true);
      paramContext.setFlags(335544320);
      return paramContext;
    }
    paramContext = new Intent(paramContext, QQStoryMainActivity.class);
    paramContext.setFlags(335544320);
    return paramContext;
  }
  
  private qwf a(@NonNull String paramString)
  {
    try
    {
      paramString = getClassLoader().loadClass(paramString);
      if ((qwf.class.isAssignableFrom(paramString)) && (qwf.class != paramString))
      {
        paramString = (qwf)paramString.newInstance();
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ram.e("StoryTransitionActivity", "createTargetObjectByName error", paramString);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    a(paramContext, paramString, paramBundle, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramString == null)) {
      throw new NullPointerException("param should not be null");
    }
    if ((paramInt >= 0) && (!(paramContext instanceof Activity))) {
      throw new IllegalArgumentException("context should be an instance of Activity");
    }
    ram.b("StoryTransitionActivity", "startAsProxy %s", paramString);
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.putExtra("jump_action", 5);
    localIntent.putExtra("target_name", paramString);
    localIntent.putExtra("target_args", paramBundle);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 21)) {
      localIntent.addFlags(524288);
    }
    if (paramInt >= 0)
    {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      return;
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void c(Context paramContext, String paramString, Bundle paramBundle)
  {
    a(paramContext, paramString, paramBundle, -1);
  }
  
  public static final void cD(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("jump_action", 2);
    paramContext.startActivity(localIntent);
  }
  
  public static final void cE(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.putExtra("jump_action", 3);
    paramContext.startActivity(localIntent);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    rnq localrnq = rnq.a();
    if (localrnq.isSupport())
    {
      paramString1 = new Bundle();
      paramString1.putInt("entrance_type", paramInt);
      paramString1.putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1.putString("video_tag_info", paramString2);
      localrnq.g(this, paramString1);
      overridePendingTransition(2130772306, 2130772079);
      return true;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (ShortVideoUtils.m(this.app)))
    {
      bool = true;
      paramString2 = new qqy(this.app).a(this, paramBoolean1, bool);
      paramString2.putExtra("entrance_type", paramInt);
      if (paramString1 != null) {
        paramString2.putExtra("launch_take_video_view_extra_value_key", paramString1);
      }
      if (!bool) {
        break label216;
      }
      paramString2.putExtra("start_time", l);
      paramString2.putExtra("story_default_label", getIntent().getStringExtra("story_default_label"));
      startActivity(paramString2);
      if (!paramBoolean2) {
        break label207;
      }
      super.overridePendingTransition(2130772306, 2130772079);
    }
    for (;;)
    {
      ram.d("StoryTransitionActivity", "launchNewVideoTakeActivity end");
      return true;
      bool = false;
      break;
      label207:
      super.overridePendingTransition(0, 0);
    }
    label216:
    startActivity(paramString2);
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    rnq localrnq = rnq.a();
    if (localrnq.isSupport())
    {
      paramString1 = new Bundle();
      paramString1.putInt("entrance_type", paramInt1);
      paramString1.putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1.putString("video_tag_info", paramString2);
      localrnq.a(this, paramString1, paramInt2);
      overridePendingTransition(2130772306, 2130772079);
      return true;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (ShortVideoUtils.m(this.app)))
    {
      bool = true;
      paramString2 = new qqy(this.app).a(this, paramBoolean1, bool);
      paramString2.putExtra("entrance_type", paramInt1);
      if (paramString1 != null) {
        paramString2.putExtra("launch_take_video_view_extra_value_key", paramString1);
      }
      if (!bool) {
        break label230;
      }
      paramString2.putExtra("start_time", l);
      paramString2.putExtra("story_default_label", getIntent().getStringExtra("story_default_label"));
      paramString1 = (psr)psx.a(10);
      startActivityForResult(paramString2, paramInt2);
      if (!paramBoolean2) {
        break label221;
      }
      super.overridePendingTransition(2130772306, 2130772079);
    }
    for (;;)
    {
      ram.d("StoryTransitionActivity", "launchNewVideoTakeActivity end");
      return true;
      bool = false;
      break;
      label221:
      super.overridePendingTransition(0, 0);
    }
    label230:
    startActivityForResult(paramString2, paramInt2);
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    qwf localqwf = this.a;
    if (localqwf != null) {
      localqwf.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1882323: 
      if (paramInt2 == -1)
      {
        finish();
        startActivity(a(this));
        return;
      }
      finish();
      return;
    }
    if ((paramInt2 == -1) && (this.bnM == 1)) {
      startActivity(a(this));
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int i = 15;
    super.doOnCreate(paramBundle);
    if (this.app == null)
    {
      ram.d("StoryTransitionActivity", "StoryTransitionActivity app is null!!!!!!");
      finish();
      return false;
    }
    int j = getIntent().getIntExtra("jump_action", 0);
    if (1 == j)
    {
      paramBundle = getIntent().getStringExtra("video_tag");
      if (!TextUtils.isEmpty(paramBundle))
      {
        try
        {
          boolean bool = "web_medal".equals(new JSONObject(paramBundle).optString("src_type"));
          if (bool) {
            i = 18;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ram.b("StoryTransitionActivity", "parse tag json error, json:%s, error:%s", paramBundle, localJSONException);
          }
        }
        a(false, true, i, null, getIntent().getStringExtra("video_tag"), 1882323);
      }
    }
    for (;;)
    {
      return true;
      a(false, true, 15, null, getIntent().getStringExtra("video_tag"));
      finish();
      continue;
      if (2 == j)
      {
        Bosses.get().postJob(new qrh(this, "StoryTransitionActivity"));
        finish();
      }
      else if (3 == j)
      {
        finish();
        startActivity(a(this));
      }
      else if (4 == j)
      {
        ram.d("StoryTransitionActivity", "update story config from server.");
        ((pma)((QQAppInterface)getAppInterface()).getBusinessHandler(98)).blO();
        finish();
      }
      else
      {
        Object localObject;
        if (5 == j)
        {
          localObject = getIntent().getStringExtra("target_name");
          ram.b("StoryTransitionActivity", "ACTION_START_AS_PROXY  target = %s", localObject);
          if (localObject != null) {
            this.a = a((String)localObject);
          }
          if (this.a == null)
          {
            ram.e("StoryTransitionActivity", "can not create TransitionCode object");
            finish();
          }
          else
          {
            this.a.onAttach(this);
            this.a.a(paramBundle, getIntent().getBundleExtra("target_args"));
          }
        }
        else if (6 == j)
        {
          this.bnM = getIntent().getIntExtra("web_target_type", 0);
          paramBundle = rnq.a();
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("resource_need_all_wait", true);
          ((Bundle)localObject).putInt("entrance_type", 104);
          paramBundle.a(this, (Bundle)localObject, 100);
          overridePendingTransition(2130772306, 2130772079);
          ram.i("StoryTransitionActivity", "web to story  dealType:" + this.bnM);
        }
        else if (7 == j)
        {
          paramBundle = getIntent().getExtras();
          paramBundle.putBoolean("resource_need_all_wait", true);
          rnq.a().a(this, paramBundle, 11000);
          overridePendingTransition(2130772306, 2130772079);
          finish();
        }
        else
        {
          ram.d("StoryTransitionActivity", "StoryTransitionActivity unknow jumpAction is " + j);
          finish();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    qwf localqwf = this.a;
    if (localqwf != null)
    {
      localqwf.onDestroy();
      localqwf.onDetach();
      this.a = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    qwf localqwf = this.a;
    if (localqwf != null) {
      localqwf.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    qwf localqwf = this.a;
    if (localqwf != null) {
      localqwf.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.StoryTransitionActivity
 * JD-Core Version:    0.7.0.1
 */