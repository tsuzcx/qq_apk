import android.content.Context;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wnj
  extends wwj
{
  public wnj(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void X_()
  {
    xvp localxvp = a().a("FeedSegment");
    if ((localxvp != null) && (localxvp.a() == 0))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnj
 * JD-Core Version:    0.7.0.1
 */