import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.qphone.base.util.QLog;

public class ttv
  extends ssv
{
  public ttv(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(boolean paramBoolean, ssq paramssq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyVideoVisiblePersonPageView", 2, "onGetVideoReaderConfig: isSuccess " + paramBoolean + ", QQStoryBanInfo = " + paramssq);
    }
    if (paramBoolean)
    {
      if (paramssq != null) {
        this.a.a(paramssq.a);
      }
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ttv
 * JD-Core Version:    0.7.0.1
 */