import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class ych
  extends SimpleJob<Object>
{
  ych(ycf paramycf, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.a == null) {
      this.a.a = new yci(this.a, this.a.c);
    }
    this.a.d = this.a.a.a;
    ycf.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ych
 * JD-Core Version:    0.7.0.1
 */