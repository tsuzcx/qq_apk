import android.database.DataSetObserver;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class vvu
  extends DataSetObserver
{
  private vvu(XViewPager paramXViewPager) {}
  
  public void onChanged()
  {
    this.a.b();
  }
  
  public void onInvalidated()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvu
 * JD-Core Version:    0.7.0.1
 */