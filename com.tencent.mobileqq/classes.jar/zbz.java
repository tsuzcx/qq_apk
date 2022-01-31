import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class zbz
  implements baug
{
  public zbz(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(bavf parambavf)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + parambavf.c);
    if (zby.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      ndr.a(zby.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException parambavf)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + parambavf);
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zbz
 * JD-Core Version:    0.7.0.1
 */