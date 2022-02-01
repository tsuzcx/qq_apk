import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout.a;
import com.tencent.qphone.base.util.QLog;

public class vnr
  implements SwipePostTableLayout.a
{
  public vnr(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void On()
  {
    QLog.d("WebLog_QQBrowserActivity", 1, "onPageSwipeClose");
  }
  
  public void Oo()
  {
    QLog.d("WebLog_QQBrowserActivity", 1, "onPageSwipeNotClose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnr
 * JD-Core Version:    0.7.0.1
 */