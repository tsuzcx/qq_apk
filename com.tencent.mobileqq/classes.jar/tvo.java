import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.dispatch.Dispatcher;

class tvo
  extends Job<Object, Object, Object>
{
  tvo(tvn paramtvn, String paramString, spl paramspl)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    sgi.a().dispatch(this.jdField_a_of_type_Spl);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvo
 * JD-Core Version:    0.7.0.1
 */