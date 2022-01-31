import android.content.Context;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wja
  extends wsa
{
  public wja(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void aa_()
  {
    xrg localxrg = a().a("FeedSegment");
    if ((localxrg != null) && (localxrg.a() == 0))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wja
 * JD-Core Version:    0.7.0.1
 */