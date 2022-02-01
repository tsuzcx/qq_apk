import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import java.util.Map;

class wbc
  extends Job<Object, Object, Object>
{
  wbc(wbb paramwbb, String paramString, wbk paramwbk)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.jdField_a_of_type_Wbk.jdField_a_of_type_Wbj.a(this.jdField_a_of_type_Wbk);
    this.jdField_a_of_type_Wbb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wbk.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Wbb.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Wbk.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wbk);
    return null;
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbc
 * JD-Core Version:    0.7.0.1
 */