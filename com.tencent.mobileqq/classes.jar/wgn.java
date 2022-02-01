import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import java.util.Map;

class wgn
  extends Job<Object, Object, Object>
{
  wgn(wgm paramwgm, String paramString, wgv paramwgv)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.jdField_a_of_type_Wgv.jdField_a_of_type_Wgu.a(this.jdField_a_of_type_Wgv);
    this.jdField_a_of_type_Wgm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wgv.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Wgm.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Wgv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wgv);
    return null;
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgn
 * JD-Core Version:    0.7.0.1
 */