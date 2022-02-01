import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

public class vqu
  extends Job<Object, Object, Object>
{
  public vqu(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, vqr paramvqr)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.jdField_a_of_type_Vqr.a().a(880001, "no network", null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqu
 * JD-Core Version:    0.7.0.1
 */