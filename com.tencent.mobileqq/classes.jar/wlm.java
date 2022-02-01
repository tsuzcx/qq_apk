import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class wlm
  extends SimpleJob<Void>
{
  wlm(wll paramwll, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    boolean bool = zom.a(500L);
    if (this.a.a(bool)) {
      wll.a(this.a, bool);
    }
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlm
 * JD-Core Version:    0.7.0.1
 */