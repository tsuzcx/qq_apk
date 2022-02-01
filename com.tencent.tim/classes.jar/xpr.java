import android.os.Bundle;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.b;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.qphone.base.util.QLog;

public class xpr
  extends aquy
{
  public xpr(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, TribeShortVideoItemBuilder.b paramb, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void onDone(aquz paramaquz)
  {
    String str = paramaquz.getParams().getString("filePath");
    if (paramaquz.errCode == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TribeShortVideoItemBuilder", 2, "download video success! videoFile:" + str);
      }
      this.a.isPlaying = true;
      this.a.b.bwe();
      this.a.b.setVisibility(8);
      this.this$0.a(this.a.a, this.b.uniseq, this.b.videoWidth, this.b.videoHeight, this.b.coverImgUrl, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpr
 * JD-Core Version:    0.7.0.1
 */