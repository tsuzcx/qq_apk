import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

final class ukg
  extends SimpleJob<Void>
{
  ukg(String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = ukd.a();
    wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", this.a + " : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(i) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukg
 * JD-Core Version:    0.7.0.1
 */