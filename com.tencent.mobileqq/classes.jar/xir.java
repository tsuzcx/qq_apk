import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class xir
  implements aysc
{
  public xir(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(aysz paramaysz)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + paramaysz.c);
    if (xiq.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      nav.a(xiq.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException paramaysz)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + paramaysz);
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xir
 * JD-Core Version:    0.7.0.1
 */