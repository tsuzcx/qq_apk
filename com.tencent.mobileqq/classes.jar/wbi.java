import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.dispatch.Dispatcher;

class wbi
  extends Job<Object, Object, Object>
{
  wbi(wbh paramwbh, String paramString, uvf paramuvf)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    umc.a().dispatch(this.jdField_a_of_type_Uvf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbi
 * JD-Core Version:    0.7.0.1
 */