import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import java.util.Map;

class vmh
  extends Job<Object, Object, Object>
{
  vmh(vmg paramvmg, String paramString, vmp paramvmp)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.jdField_a_of_type_Vmp.jdField_a_of_type_Vmo.a(this.jdField_a_of_type_Vmp);
    this.jdField_a_of_type_Vmg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vmp.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Vmg.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Vmp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vmp);
    return null;
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmh
 * JD-Core Version:    0.7.0.1
 */