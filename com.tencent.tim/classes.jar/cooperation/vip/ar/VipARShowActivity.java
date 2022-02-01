package cooperation.vip.ar;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;
import awkv;
import awlg;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;

public class VipARShowActivity
  extends AppActivity
  implements QQPermissionCallback
{
  private awkv a;
  private ViewGroup as;
  
  private void eEe()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      if (checkSelfPermission("android.permission.CAMERA") == 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      }
      return;
    }
  }
  
  private void eEf()
  {
    this.a = new awkv(this, this.as);
    this.a.eEh();
    Intent localIntent = getIntent();
    this.a.jE(localIntent.getStringExtra("modelResUrl"), localIntent.getStringExtra("modelResMd5"));
  }
  
  private void initData()
  {
    if ("value_refer_aio".equalsIgnoreCase(getIntent().getStringExtra("key_refer"))) {
      awlg.jF("ar_aio_click", "1");
    }
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Toast.makeText(this, 2131697834, 0).show();
    ThreadManager.getUIHandler().postDelayed(new VipARShowActivity.1(this), 2000L);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    eEe();
    initData();
    setContentView(2131558522);
    this.as = ((ViewGroup)findViewById(2131362900));
    eEf();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.a != null) {
      this.a.onActivityDestroy();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.a != null) {
      this.a.onActivityPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.a != null) {
      this.a.onActivityResume();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.a != null) {
      this.a.onActivityStop();
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.eEi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ar.VipARShowActivity
 * JD-Core Version:    0.7.0.1
 */