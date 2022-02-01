import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

public class wli
  extends Job<Object, Object, Object>
{
  public wli(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, wlf paramwlf)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.jdField_a_of_type_Wlf.a().a(880001, "no network", null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wli
 * JD-Core Version:    0.7.0.1
 */