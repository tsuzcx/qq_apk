import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.qphone.base.util.QLog;

public class vin
  extends uhn
{
  public vin(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(boolean paramBoolean, uhi paramuhi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyVideoVisiblePersonPageView", 2, "onGetVideoReaderConfig: isSuccess " + paramBoolean + ", QQStoryBanInfo = " + paramuhi);
    }
    if (paramBoolean)
    {
      if (paramuhi != null) {
        this.a.a(paramuhi.a);
      }
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vin
 * JD-Core Version:    0.7.0.1
 */