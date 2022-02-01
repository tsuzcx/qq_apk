import android.database.DataSetObserver;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class xta
  extends DataSetObserver
{
  private xta(XViewPager paramXViewPager) {}
  
  public void onChanged()
  {
    this.a.b();
  }
  
  public void onInvalidated()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xta
 * JD-Core Version:    0.7.0.1
 */