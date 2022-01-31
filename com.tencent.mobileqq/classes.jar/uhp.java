import android.content.Context;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class uhp
  extends uqp
{
  public uhp(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void U_()
  {
    vpv localvpv = a().a("FeedSegment");
    if ((localvpv != null) && (localvpv.a() == 0))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhp
 * JD-Core Version:    0.7.0.1
 */