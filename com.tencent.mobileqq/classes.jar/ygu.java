import android.content.Context;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class ygu
  extends ypu
{
  public ygu(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void U_()
  {
    zpa localzpa = a().a("FeedSegment");
    if ((localzpa != null) && (localzpa.a() == 0))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygu
 * JD-Core Version:    0.7.0.1
 */