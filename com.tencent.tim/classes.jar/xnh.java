import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class xnh
  implements ausj.a
{
  public xnh(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.a parama, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      if ((this.i.uiOperatorFlag == 1) && (this.i.videoFileStatus == 1004)) {
        ShortVideoUtils.fW("0X800A7F0", this.this$0.sessionInfo.cZ);
      }
      if (this.i.uiOperatorFlag == 2)
      {
        this.this$0.b(this.i, this.a);
      }
      else if ((this.i.uiOperatorFlag == 1) && (this.i.md5 == null))
      {
        if (!ShortVideoRealItemBuilder.access$200())
        {
          ShortVideoRealItemBuilder.a(this.this$0, this.i, this.a, true, true);
        }
        else if (!ShortVideoRealItemBuilder.access$100().containsKey(Long.valueOf(this.i.uniseq)))
        {
          ShortVideoRealItemBuilder.access$100().put(Long.valueOf(this.i.uniseq), this.i);
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + ShortVideoRealItemBuilder.access$100().size() + ", [" + this.i.uniseq + "] added, mEncoding:" + ShortVideoRealItemBuilder.access$200());
          }
        }
      }
      else if ((!TextUtils.isEmpty(this.i.md5)) && (this.i.videoFileStatus == 1004) && (this.this$0.app.a().A(this.i.frienduin, this.i.uniseq)))
      {
        ShortVideoRealItemBuilder.a(this.this$0);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "onErrorIconClick resumeSending!");
        }
      }
      else
      {
        this.this$0.a(this.i, this.a);
        ShortVideoRealItemBuilder.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnh
 * JD-Core Version:    0.7.0.1
 */