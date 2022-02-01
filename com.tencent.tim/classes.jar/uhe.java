import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.content.Intent;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class uhe
  implements ausj.a
{
  public uhe(AuthDevActivity paramAuthDevActivity, String paramString1, long paramLong, String paramString2, int paramInt, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((AuthDevActivity.a(this.this$0) != null) && (AuthDevActivity.a(this.this$0).isShowing()) && (!this.this$0.isFinishing()))
      {
        AuthDevActivity.a(this.this$0).dismiss();
        AuthDevActivity.a(this.this$0).cancel();
        AuthDevActivity.a(this.this$0, null);
      }
      return;
      paramView = new Intent(this.this$0, AuthDevRenameActivity.class);
      paramView.putExtra(AuthDevRenameActivity.aLl, this.val$name);
      paramView.putExtra(AuthDevRenameActivity.aLm, this.Y);
      paramView.putExtra(AuthDevRenameActivity.aLn, AppSetting.getAppId());
      paramView.putExtra(AuthDevRenameActivity.aLo, NetConnInfoCenter.GUID);
      paramView.putExtra(AuthDevRenameActivity.aLp, this.val$phone);
      paramView.putExtra(AuthDevRenameActivity.aLq, ((SvcDevLoginInfo)AuthDevActivity.b(this.this$0).get(this.val$i)).strDeviceTypeInfo);
      paramView.putExtra(AuthDevRenameActivity.aLr, ((SvcDevLoginInfo)AuthDevActivity.b(this.this$0).get(this.val$i)).stDeviceItemDes.vecItemDes);
      paramView.putExtra(AuthDevRenameActivity.aLs, this.val$i);
      this.this$0.startActivity(paramView);
      continue;
      if (AuthDevActivity.a(this.this$0)) {
        for (;;)
        {
          try
          {
            if (!this.aRI) {
              break label352;
            }
            paramView = "0X800AC56";
            anot.a(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
            AuthDevActivity.a(this.this$0, this.val$phone, this.val$list, this.val$name, this.val$i, this.aRJ, this.aRK, this.Y);
          }
          catch (Throwable paramView)
          {
            QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "showDelDevActionSheet error : ", paramView.getMessage() });
          }
          break;
          label352:
          paramView = "0X800AC58";
        }
      }
      if (!aqiw.isNetSupport(this.this$0))
      {
        QQToast.a(this.this$0, this.this$0.getString(2131693404), 0).show(this.this$0.getTitleBarHeight());
      }
      else
      {
        QLog.d("Q.devlock.AuthDevActivity", 1, "OnClick.begin to del recent dev");
        if (afsf.a().a(this.this$0.app, this.val$name, this.val$list, this.val$i)) {
          AuthDevActivity.b(this.this$0);
        } else {
          QLog.d("Q.devlock.AuthDevActivity", 1, "OnClick del recent dev fail");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhe
 * JD-Core Version:    0.7.0.1
 */