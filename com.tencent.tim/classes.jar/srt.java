import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class srt
  implements aolm.b
{
  public srt(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(aomh paramaomh)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + paramaomh.dPy);
    if (srs.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      jqp.b(srs.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException paramaomh)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + paramaomh);
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srt
 * JD-Core Version:    0.7.0.1
 */