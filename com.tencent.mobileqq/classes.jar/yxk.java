import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class yxk
  implements bapx
{
  public yxk(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(baqw parambaqw)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + parambaqw.c);
    if (yxj.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      ndr.a(yxj.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException parambaqw)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + parambaqw);
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxk
 * JD-Core Version:    0.7.0.1
 */