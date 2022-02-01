package dov.com.tencent.mobileqq.richmedia.capture.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import axce;
import axcg;
import axiy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.a;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite;

public class CaptureQmcfSoDownloadActivity
  extends FragmentActivity
  implements CaptureQmcfSoDownloadFragment.a
{
  public static final String TAG = CaptureQmcfSoDownloadActivity.class.getSimpleName();
  private Bundle args;
  private String cYb;
  private Fragment e;
  private int eJd;
  private boolean hasRequest;
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean1);
    localIntent.putExtra("key_wait_download_result", paramBoolean2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean);
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
    if ((i == axcg.l.getId()) || (i == axcg.k.getId())) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void b(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.hasRequest)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561255);
    this.e = new CaptureQmcfSoDownloadFragment();
    this.cYb = getIntent().getStringExtra("pendingIntentClass");
    if (getIntent().getBooleanExtra("pendingIntentAllWait", false)) {
      this.e = new CaptureQmcfSoDownloadFragmentAllWaite();
    }
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131362045, this.e);
    paramBundle.commit();
    this.hasRequest = getIntent().hasExtra("pendingIntentRequest");
    if (this.hasRequest) {
      this.eJd = getIntent().getIntExtra("pendingIntentRequest", 0);
    }
    this.args = getIntent().getExtras();
    axce.a().Ya(true);
    axiy.i(TAG, "【Activity doOnCreate】");
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    axce.a().Ya(false);
    axiy.i(TAG, "【Activity doOnDestroy】");
  }
  
  public void onFinish()
  {
    if (!getIntent().getBooleanExtra("key_wait_download_result", false))
    {
      QLog.d("qqBaseActivity", 4, "in launch.");
      if ((BaseActivity.sTopActivity instanceof CaptureQmcfSoDownloadActivity))
      {
        QLog.d("qqBaseActivity", 4, "is top activity, hasRequest: " + this.hasRequest);
        this.args.putString("KEY_ISENTER_SO_DOWNLOAD", "true");
        if (this.hasRequest)
        {
          if ((this.e instanceof CaptureQmcfSoDownloadFragment)) {
            ((CaptureQmcfSoDownloadFragment)this.e).removeCallbacks();
          }
          QIMCameraCaptureActivity.a(this, this.args, this.eJd);
        }
      }
      else
      {
        return;
      }
      QIMCameraCaptureActivity.g(this, this.args);
      finish();
      return;
    }
    setResult(-1, null);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */