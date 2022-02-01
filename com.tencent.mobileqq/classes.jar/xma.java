import android.content.Context;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class xma
  extends xva
{
  public xma(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void O_()
  {
    ysg localysg = a().a("FeedSegment");
    if ((localysg != null) && (localysg.a() == 0))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xma
 * JD-Core Version:    0.7.0.1
 */