import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.VideoInviteActivity.3.1;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class jel
  implements ausj.a
{
  public jel(VideoInviteActivity paramVideoInviteActivity, ausj paramausj, boolean paramBoolean, long paramLong) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.t.dismiss();
    if ((this.this$0.M != null) && (this.this$0.N != null))
    {
      this.this$0.M.setEnabled(true);
      this.this$0.N.setEnabled(true);
    }
    VideoInviteActivity.3.1 local1;
    switch (paramInt)
    {
    default: 
      paramView = null;
      this.this$0.O(this.kQ, true);
      this.this$0.b().a(this.this$0.mUinType, this.this$0.mPeerUin, this.this$0.OE, this.this$0.OD, paramView, this.this$0.Yo);
      if ((this.this$0.Yo) && (aqlr.isScreenLocked(VideoInviteActivity.d(this.this$0))))
      {
        paramView = this.this$0.mApp.getHandler();
        local1 = new VideoInviteActivity.3.1(this);
        if (!GesturePWDUtils.getJumpLock(this.this$0, this.this$0.mApp.getCurrentAccountUin())) {
          break label630;
        }
      }
      break;
    }
    label630:
    for (long l = 500L;; l = 0L)
    {
      paramView.postDelayed(local1, l);
      return;
      if (this.Yq)
      {
        if (this.this$0.VL) {}
        for (paramView = "0X80043A0";; paramView = "0X80043B2")
        {
          anot.a(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.this$0.mOnlineStatus), Integer.toString(this.this$0.axP), Integer.toString(this.this$0.axQ), "");
          paramView = VideoInviteActivity.a(this.this$0).getString(2131697849);
          break;
        }
      }
      if (this.this$0.VL) {}
      for (paramView = "0X80043A6";; paramView = "0X80043AC") {
        break;
      }
      if (this.Yq)
      {
        if (this.this$0.VL) {}
        for (paramView = "0X80043A1";; paramView = "0X80043B3")
        {
          anot.a(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.this$0.mOnlineStatus), Integer.toString(this.this$0.axP), "", "");
          paramView = VideoInviteActivity.b(this.this$0).getString(2131697851);
          break;
        }
      }
      if (this.this$0.VL) {}
      for (paramView = "0X80043A7";; paramView = "0X80043AD") {
        break;
      }
      if (this.Yq)
      {
        if (this.this$0.VL) {}
        for (paramView = "0X80043A2";; paramView = "0X80043B4")
        {
          anot.a(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.this$0.mOnlineStatus), Integer.toString(this.this$0.axP), "", "");
          paramView = VideoInviteActivity.c(this.this$0).getString(2131697850);
          break;
        }
      }
      if (this.this$0.VL) {}
      for (paramView = "0X80043A8";; paramView = "0X80043AE") {
        break;
      }
      this.this$0.Yo = true;
      if (this.Yq)
      {
        if (this.this$0.VL) {}
        for (paramView = "0X80043A3";; paramView = "0X80043B5")
        {
          anot.a(null, "CliOper", "", "", paramView, paramView, 0, 0, Integer.toString(this.this$0.mOnlineStatus), Integer.toString(this.this$0.axP), "", "");
          paramView = null;
          break;
        }
      }
      if (this.this$0.VL) {}
      for (paramView = "0X80043A9";; paramView = "0X80043AF") {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jel
 * JD-Core Version:    0.7.0.1
 */