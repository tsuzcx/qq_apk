import android.content.Context;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class qug
  extends qzx
{
  public qug(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramInt2);
  }
  
  protected void bqN()
  {
    rsd localrsd = a().a("FeedSegment");
    if ((localrsd != null) && (localrsd.getCount() == 0))
    {
      this.isDisplay = true;
      return;
    }
    this.isDisplay = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qug
 * JD-Core Version:    0.7.0.1
 */