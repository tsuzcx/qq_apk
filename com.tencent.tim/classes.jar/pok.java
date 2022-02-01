import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.io.File;

public class pok
  extends SimpleJob<String>
{
  pok(poj parampoj, String paramString1, String paramString2, long paramLong)
  {
    super(paramString1);
  }
  
  protected String a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "start composite vid:%s", new Object[] { this.atZ });
    paramJobContext = pog.a(this.atZ);
    paramVarArgs = plr.atc + System.currentTimeMillis() + ".mp4";
    new File(plr.atc).mkdirs();
    if (!TextUtils.isEmpty(paramJobContext.mbgmAudioFilePath)) {
      aycj.a().jT(paramJobContext.mAudioFilePath, paramJobContext.mbgmAudioFilePath);
    }
    new pog().a(paramJobContext, paramVarArgs, false, true, new pol(this, paramJobContext));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pok
 * JD-Core Version:    0.7.0.1
 */