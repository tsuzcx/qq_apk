import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class rsa
  extends SimpleJob
{
  public rsa(SegmentList paramSegmentList, String paramString)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    this.this$0.a.bqO();
    if (SegmentList.a(this.this$0)) {
      return null;
    }
    SegmentList.a(this.this$0).sendMessage(SegmentList.a(this.this$0).obtainMessage(2));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsa
 * JD-Core Version:    0.7.0.1
 */