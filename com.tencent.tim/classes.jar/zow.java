import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.13.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;

public class zow
  implements ausj.a
{
  public zow(AvatarPendantActivity paramAvatarPendantActivity, boolean paramBoolean, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        boolean bool;
        int i;
        int j;
        paramView.printStackTrace();
      }
      bool = VideoEnvironment.awT();
      if ((AudioHelper.aCm()) || (Build.MODEL.contains("Redmi 3")) || (Build.MODEL.contains("M3S")))
      {
        QQToast.a(this.this$0, acfp.m(2131702990), 0).show();
      }
      else if (bool)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.this$0.checkSelfPermission("android.permission.CAMERA") != 0)
          {
            paramInt = 1;
            if (this.this$0.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)
            {
              i = 1;
              if (this.this$0.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                continue;
              }
              j = 1;
              if ((paramInt == 0) && (i == 0) && (j == 0)) {
                continue;
              }
              this.this$0.requestPermissions(new zox(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" });
            }
          }
          else
          {
            paramInt = 0;
            continue;
          }
          i = 0;
          continue;
          j = 0;
          continue;
          DynamicAvatarRecordActivity.c(this.this$0, 1, 1);
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
        }
        else
        {
          DynamicAvatarRecordActivity.c(this.this$0, 1, 1);
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (!this.this$0.bsf)
        {
          ThreadManager.postImmediately(new AvatarPendantActivity.13.2(this), null, true);
          this.this$0.bsf = true;
        }
        QQToast.a(this.this$0, acfp.m(2131702994), 0).show();
        continue;
        this.this$0.cqQ();
        AvatarPendantActivity.b(this.this$0);
        continue;
        this.this$0.cqQ();
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.this$0.checkSelfPermission("android.permission.CAMERA") != 0)
          {
            paramInt = 1;
            if (this.this$0.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
            {
              i = 1;
              if ((paramInt == 0) && (i == 0)) {
                continue;
              }
              this.this$0.requestPermissions(new zoy(this), 2, new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" });
            }
          }
          else
          {
            paramInt = 0;
            continue;
          }
          i = 0;
          continue;
          this.this$0.x = ProfileActivity.a(this.this$0, 5);
          anot.a(this.this$0.app, "CliOper", "", "", "0X8004176", "0X8004176", this.this$0.c.bJa, 0, "", "", "", "");
        }
        else
        {
          this.this$0.x = ProfileActivity.a(this.this$0, 5);
          anot.a(this.this$0.app, "CliOper", "", "", "0X8004176", "0X8004176", this.this$0.c.bJa, 0, "", "", "", "");
          continue;
          if (this.bsg)
          {
            paramView = new Intent(this.this$0, QQBrowserActivity.class);
            paramView.putExtra("url", "https://ti.qq.com/avatarlist/public/index.html?_wv=3&_wwv=4");
            this.this$0.startActivity(paramView);
            anot.a(this.this$0.app, "dc00898", "", "", "0X8007C10", "0X8007C10", 0, 0, "", "", "", "");
          }
          else
          {
            aqep.a(this.this$0.app, this.this$0, this.this$0.b, this.this$0.c.uin, 0, 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zow
 * JD-Core Version:    0.7.0.1
 */