import android.content.Context;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class uul
  extends vdl
{
  public uul(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void S_()
  {
    wcr localwcr = a().a("FeedSegment");
    if ((localwcr != null) && (localwcr.a() == 0))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uul
 * JD-Core Version:    0.7.0.1
 */