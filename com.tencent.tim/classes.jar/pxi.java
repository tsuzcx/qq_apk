import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class pxi
  extends SimpleJob<Object>
{
  pxi(pxg parampxg, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.a == null) {
      this.a.a = new pxg.a(this.a, this.a.avK);
    }
    this.a.avJ = this.a.a.mCookie;
    pxg.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxi
 * JD-Core Version:    0.7.0.1
 */