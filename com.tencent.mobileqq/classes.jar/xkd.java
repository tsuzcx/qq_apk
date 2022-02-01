import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.qphone.base.util.QLog;

public class xkd
  extends wjd
{
  public xkd(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(boolean paramBoolean, wiy paramwiy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyVideoVisiblePersonPageView", 2, "onGetVideoReaderConfig: isSuccess " + paramBoolean + ", QQStoryBanInfo = " + paramwiy);
    }
    if (paramBoolean)
    {
      if (paramwiy != null) {
        this.a.a(paramwiy.a);
      }
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkd
 * JD-Core Version:    0.7.0.1
 */