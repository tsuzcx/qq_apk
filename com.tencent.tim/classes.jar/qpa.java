import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class qpa
  extends JobSegment<List<Bitmap>, Bitmap>
{
  private String TAG = "story.icon.BitmapListToIconSegment";
  private int bnt;
  private Context context;
  
  public qpa(Context paramContext, String paramString, int paramInt)
  {
    this.context = paramContext;
    this.TAG = (this.TAG + "[" + paramString + "]");
    this.bnt = paramInt;
  }
  
  protected void a(JobContext paramJobContext, List<Bitmap> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      notifyError(new ErrorMessage(-1, "bitmap list should not be empty"));
      return;
    }
    paramJobContext = (Bitmap[])paramList.toArray(new Bitmap[paramList.size()]);
    paramList = aqeq.a(this.bnt, Bitmap.Config.ARGB_8888, paramJobContext);
    qpb.b(this.TAG, "result bitmap = %s, child count = %d", paramList, Integer.valueOf(paramJobContext.length));
    notifyResult(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpa
 * JD-Core Version:    0.7.0.1
 */