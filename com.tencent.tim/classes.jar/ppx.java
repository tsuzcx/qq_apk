import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class ppx
  extends SimpleJob<Void>
{
  public ppx(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = ((psr)psx.a(10)).mv();
    if (!TextUtils.isEmpty(paramJobContext)) {
      this.b.re(paramJobContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppx
 * JD-Core Version:    0.7.0.1
 */