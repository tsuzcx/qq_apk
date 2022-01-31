import android.database.DataSetObserver;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class ucw
  extends DataSetObserver
{
  private ucw(XViewPager paramXViewPager) {}
  
  public void onChanged()
  {
    this.a.b();
  }
  
  public void onInvalidated()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucw
 * JD-Core Version:    0.7.0.1
 */