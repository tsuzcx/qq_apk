import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class wzo
  extends SimpleJob<Object>
{
  wzo(wzn paramwzn, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.jdField_a_of_type_Wzq == null) {
      this.a.jdField_a_of_type_Wzq = new wzq(this.a, this.a.d);
    }
    this.a.jdField_a_of_type_JavaLangString = "";
    wzn.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzo
 * JD-Core Version:    0.7.0.1
 */