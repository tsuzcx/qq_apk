import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.b;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;

class szm
  implements ausj.a
{
  szm(szl paramszl, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.b paramb, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      this.this$0.b(this.b);
      if ((aqiw.isNetSupport(BaseApplication.getContext())) && (this.a != null) && (this.a.a != null))
      {
        this.a.a.setFailedIconVisable(false, this.this$0);
        szl.a(this.this$0, this.a, ShortVideoUtils.aL(this.b.videoFileProgress, 10), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szm
 * JD-Core Version:    0.7.0.1
 */