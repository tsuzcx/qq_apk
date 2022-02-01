import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class pns
  extends SimpleJob<Void>
{
  pns(pnr parampnr, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    boolean bool = rox.bc(500L);
    if (this.this$0.U(bool)) {
      pnr.a(this.this$0, bool);
    }
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pns
 * JD-Core Version:    0.7.0.1
 */