package cooperation.qzone;

import afsi;
import afxv;
import afxx;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Window;
import aqha;
import aqju;
import avqh;
import avqi;
import avqj;
import avqk;
import avql;
import avqm;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import mqq.os.MqqHandler;

public class QZoneNavigateToQQTransparentFragment
  extends PublicBaseFragment
{
  private boolean dnX;
  
  private static void a(FragmentActivity paramFragmentActivity, String paramString)
  {
    if ((paramFragmentActivity == null) || (!paramFragmentActivity.isResume()))
    {
      QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showToast() activity is null or is not onResume() just return");
      return;
    }
    QQToast.a(paramFragmentActivity, paramString, 0).show(paramFragmentActivity.getTitleBarHeight());
    ThreadManager.getUIHandler().postDelayed(new QZoneNavigateToQQTransparentFragment.7(paramFragmentActivity), 0L);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if ((paramFragmentActivity == null) || (!paramFragmentActivity.isResume()))
    {
      QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showCampusVerifyDialog() activity is null or is not onResume() just return");
      return;
    }
    aqju localaqju = aqha.a(paramFragmentActivity, 230);
    localaqju.setOnDismissListener(new avqi(paramFragmentActivity));
    localaqju.setMessage(paramFragmentActivity.getString(2131701191)).setNegativeButton(paramFragmentActivity.getString(2131701189), new avqk()).setPositiveButton(paramFragmentActivity.getString(2131701190), new avqj(paramBoolean, paramFragmentActivity, paramInt, paramString1, paramString2)).show();
  }
  
  public static void b(FragmentActivity paramFragmentActivity, String paramString1, String paramString2)
  {
    if (paramFragmentActivity == null) {
      return;
    }
    Intent localIntent = new Intent(paramFragmentActivity, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("entrance", 23);
    localIntent.putExtra("uintype", 1045);
    localIntent.putExtras(new Bundle());
    paramFragmentActivity.startActivity(localIntent);
    paramFragmentActivity.finish();
  }
  
  private static void e(FragmentActivity paramFragmentActivity)
  {
    if ((paramFragmentActivity == null) || (!paramFragmentActivity.isResume()))
    {
      QLog.d("QZoneNavigateToQQTransparentFragment", 1, "showMatchCountDialog() activity is null or is not onResume() just return");
      return;
    }
    aqju localaqju = aqha.a(paramFragmentActivity, 230);
    localaqju.setOnDismissListener(new avql(paramFragmentActivity));
    localaqju.setMessage(paramFragmentActivity.getString(2131701193)).setPositiveButton(paramFragmentActivity.getString(2131701192), new avqm()).show();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.requestWindowFeature(1);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    if (paramBundle != null) {
      paramBundle.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
  }
  
  public boolean onBackEvent()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
    return super.onBackEvent();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.dnX)
    {
      this.dnX = true;
      parseIntent();
    }
  }
  
  protected void parseIntent()
  {
    String str2 = null;
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {}
    String str1;
    for (Object localObject = localFragmentActivity.getIntent();; str1 = null)
    {
      Bundle localBundle;
      if (localObject != null)
      {
        localBundle = ((Intent)localObject).getExtras();
        if (localBundle != null) {}
      }
      else
      {
        return;
      }
      int i = localBundle.getInt("request_code");
      switch (i)
      {
      default: 
        QZLog.i("QZoneNavigateToQQTransparentFragment", "parseIntent: wrong code " + i);
        return;
      }
      long l = localBundle.getLong("uin");
      String str3 = localBundle.getString("nickname");
      String str4 = localBundle.getString("extend_friend_campus_aio_code");
      QZLog.i("QZoneNavigateToQQTransparentFragment", "parseIntent: " + l + " " + str3 + " " + str4);
      localObject = str2;
      if (!TextUtils.isEmpty(str4)) {}
      try
      {
        localObject = Base64.decode(str4, 0);
        afxx.a(localFragmentActivity.app).a(localFragmentActivity.app, String.valueOf(l), str3, (byte[])localObject, 1, new avqh(this, localFragmentActivity));
        localObject = localBundle.getString("extend_friend_campus_algorithm_id");
        str2 = localBundle.getString("extend_friend_campus_current_tab", afsi.DEFAULT_TAG);
        afxv.a().c(1, String.valueOf(l), "", "0", (String)localObject, str2);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.d("QZoneNavigateToQQTransparentFragment", 2, "[open limit chat] parse strKuolieCampusAIOKey error! " + str4, localThrowable);
          str1 = str2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneNavigateToQQTransparentFragment
 * JD-Core Version:    0.7.0.1
 */