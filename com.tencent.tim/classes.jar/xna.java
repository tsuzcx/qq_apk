import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class xna
  implements ausj.a
{
  public xna(ShortVideoItemBuilder paramShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.b paramb, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        this.val$actionSheet.dismiss();
        return;
        if (this.b.uiOperatorFlag != 2) {
          break;
        }
        this.this$0.a(this.a, 10, false);
        this.this$0.d(this.b, this.a);
      }
    } while (this.b.uiOperatorFlag != 1);
    if (this.b.videoFileStatus == 1004) {
      ShortVideoUtils.fW("0X800A375", this.this$0.sessionInfo.cZ);
    }
    ShortVideoItemBuilder.a(this.this$0, this.a, true, this.this$0);
    this.b.isPause = false;
    if ((!TextUtils.isEmpty(this.b.md5)) && (this.b.videoFileStatus == 1004) && (this.this$0.app.a().A(this.b.frienduin, this.b.uniseq)))
    {
      this.b.videoFileStatus = 1002;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "onErrorIconClick resumeSending!");
      }
    }
    for (;;)
    {
      ShortVideoItemBuilder.a(this.this$0);
      break;
      if ((this.b.md5 == null) && ((this.b.videoFileStatus == 1005) || (this.b.videoFileStatus == 1004)))
      {
        this.a.progressBar.setVisibility(8);
        this.a.JP.setVisibility(8);
        this.a.JO.setVisibility(8);
        paramView = new angw.a(this.this$0.app, this.this$0.mContext, this.b, ShortVideoItemBuilder.a(this.this$0));
        angw.a().a(this.b.uniseq, paramView);
      }
      else
      {
        this.this$0.a(this.a, 10, false);
        this.this$0.c(this.b, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xna
 * JD-Core Version:    0.7.0.1
 */