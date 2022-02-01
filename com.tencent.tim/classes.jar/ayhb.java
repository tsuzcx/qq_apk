import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class ayhb
  extends SimpleJob<Object>
{
  ayhb(aygz paramaygz, String paramString1, String paramString2, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    rar.a("video_edit", this.azN, this.ben, this.bmS, this.val$args);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhb
 * JD-Core Version:    0.7.0.1
 */