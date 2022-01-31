import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class wzu
  implements axrt
{
  public wzu(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(axsq paramaxsq)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + paramaxsq.c);
    if (wzt.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      mpx.a(wzt.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException paramaxsq)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + paramaxsq);
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzu
 * JD-Core Version:    0.7.0.1
 */