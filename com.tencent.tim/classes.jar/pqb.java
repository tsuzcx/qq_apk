import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.Map;

public class pqb
  extends SimpleJob<Void>
{
  public pqb(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = this.val$bundle.getInt("storySeq");
    paramJobContext = (ppw)QQStoryCmdHandler.a(this.b).remove(Integer.valueOf(i));
    if (paramJobContext == null)
    {
      ram.w("Q.qqstory.net:QQStoryCmdHandler", "can't find request");
      return null;
    }
    QQStoryCmdHandler.a(this.b, paramJobContext, this.val$data, this.val$bundle);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqb
 * JD-Core Version:    0.7.0.1
 */