import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class zov
  extends SimpleJob
{
  public zov(SegmentList paramSegmentList, String paramString)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    this.a.a.f();
    if (SegmentList.a(this.a)) {
      return null;
    }
    SegmentList.a(this.a).sendMessage(SegmentList.a(this.a).obtainMessage(2));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zov
 * JD-Core Version:    0.7.0.1
 */