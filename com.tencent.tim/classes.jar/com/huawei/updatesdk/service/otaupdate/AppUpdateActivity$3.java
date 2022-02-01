package com.huawei.updatesdk.service.otaupdate;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.updatesdk.service.f.a;

class AppUpdateActivity$3
  implements com.huawei.updatesdk.service.f.b
{
  AppUpdateActivity$3(AppUpdateActivity paramAppUpdateActivity) {}
  
  public void a()
  {
    AppUpdateActivity.a(this.a).setProgress(0);
    AppUpdateActivity.a(this.a).setMax(0);
    AppUpdateActivity.b(this.a).setText("");
    AppUpdateActivity.c(this.a);
    if (AppUpdateActivity.d(this.a) != null) {
      AppUpdateActivity.d(this.a).a();
    }
    AppUpdateActivity.e(this.a).c();
    if (AppUpdateActivity.f(this.a))
    {
      AppUpdateActivity.a(this.a, AppUpdateActivity.g(this.a));
      return;
    }
    AppUpdateActivity.b(this.a, 4);
    this.a.finish();
  }
  
  public void b()
  {
    AppUpdateActivity.e(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.3
 * JD-Core Version:    0.7.0.1
 */