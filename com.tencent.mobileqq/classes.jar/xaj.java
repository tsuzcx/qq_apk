import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.qphone.base.util.QLog;

public class xaj
  extends vzx
{
  public xaj(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(boolean paramBoolean, vzs paramvzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyVideoVisiblePersonPageView", 2, "onGetVideoReaderConfig: isSuccess " + paramBoolean + ", QQStoryBanInfo = " + paramvzs);
    }
    if (paramBoolean)
    {
      if (paramvzs != null) {
        this.a.a(paramvzs.a);
      }
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xaj
 * JD-Core Version:    0.7.0.1
 */