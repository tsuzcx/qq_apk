import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aazo
  implements ausj.a
{
  public aazo(ShortVideoPlayActivity paramShortVideoPlayActivity, ausj paramausj, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.c.dismiss();
    paramView = this.c.getContent(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.akz)) {
        break label213;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
      }
      paramView = this.this$0;
      Bundle localBundle = ShortVideoPlayActivity.a(this.this$0).getExtras();
      localBundle.putInt("forward_type", 21);
      localBundle.putBoolean("forward_need_sendmsg", true);
      localBundle.putString("forward_thumb", ShortVideoUtils.bw(this.this$0.aIf, "jpg"));
      localBundle.putString("file_send_path", this.beY);
      if (aqhq.fileExistsAndNotEmpty(this.beY))
      {
        localBundle.putBoolean("k_dataline", true);
        localBundle.putString("forward_extra", this.beY);
        localBundle.putBoolean("direct_send_if_dataline_forward", true);
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      ahgq.P(paramView, localIntent);
      ShortVideoPlayActivity.b(this.this$0);
      if (this.this$0.biF) {
        ajlg.report("0X8009ABC");
      }
      anot.a(this.this$0.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
    }
    label213:
    do
    {
      return;
      if (paramView.equals(this.akA))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "click menu to share to qzone, finalVideoExists=" + this.apT);
        }
        if (this.apT)
        {
          ShortVideoPlayActivity.c(this.this$0);
          return;
        }
        QQToast.a(this.this$0.mContext, 0, 2131720229, 0).show(this.this$0.mContext.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      if (paramView.equals(this.akB))
      {
        if (!this.apT)
        {
          QQToast.a(this.this$0.mContext, 0, 2131720229, 0).show(this.this$0.mContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
        if (this.this$0.mHandler.get() != null) {
          ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.beZ, (MqqHandler)this.this$0.mHandler.get(), this.this$0.mMd5 + ".mp4", false));
        }
        if (this.this$0.mUinType == 0)
        {
          anot.a(this.this$0.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
          this.this$0.bBq = true;
        }
        for (;;)
        {
          new alyr(BaseApplication.getContext()).a(this.this$0.app, 2002, this.this$0.cmR, this.this$0.beO);
          if (!this.this$0.biF) {
            break;
          }
          ajlg.report("0X8009ABD");
          return;
          if (this.this$0.mUinType == 3000)
          {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
            this.this$0.bBq = true;
          }
          else if (this.this$0.mUinType == 1)
          {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
            this.this$0.bBq = true;
          }
          else
          {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
            this.this$0.bBq = true;
          }
        }
      }
    } while (!paramView.equals(this.akC));
    if (!this.apT)
    {
      QQToast.a(this.this$0.mContext, 0, 2131720229, 0).show(this.this$0.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.beZ), "video/*");
    this.this$0.startActivity(paramView);
    if (this.this$0.mUinType == 0)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      this.this$0.bBq = true;
      return;
    }
    if (this.this$0.mUinType == 3000)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      this.this$0.bBq = true;
      return;
    }
    if (this.this$0.mUinType == 1)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      this.this$0.bBq = true;
      return;
    }
    anot.a(this.this$0.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
    this.this$0.bBq = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazo
 * JD-Core Version:    0.7.0.1
 */