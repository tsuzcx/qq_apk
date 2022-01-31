import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class ujw
  extends SimpleJob<Void>
{
  ujw(ujv paramujv, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    boolean bool = xmx.a(500L);
    if (this.a.a(bool)) {
      ujv.a(this.a, bool);
    }
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujw
 * JD-Core Version:    0.7.0.1
 */