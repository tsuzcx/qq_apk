import android.content.Context;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class uui
  extends vdi
{
  public uui(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void S_()
  {
    wco localwco = a().a("FeedSegment");
    if ((localwco != null) && (localwco.a() == 0))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uui
 * JD-Core Version:    0.7.0.1
 */