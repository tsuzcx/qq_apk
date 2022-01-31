import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.dispatch.Dispatcher;

class vwz
  extends Job<Object, Object, Object>
{
  vwz(vwy paramvwy, String paramString, uqw paramuqw)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    uht.a().dispatch(this.jdField_a_of_type_Uqw);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwz
 * JD-Core Version:    0.7.0.1
 */