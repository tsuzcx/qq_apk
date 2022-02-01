import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class xvc
  extends SimpleJob<Void>
{
  public xvc(StoryTransitionActivity paramStoryTransitionActivity, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    ykq.d("StoryTransitionActivity", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(wcn.a()) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvc
 * JD-Core Version:    0.7.0.1
 */