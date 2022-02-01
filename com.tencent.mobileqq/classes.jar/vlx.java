import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class vlx
  extends SimpleJob<Object>
{
  vlx(vls paramvls, String paramString1, String paramString2, vmb paramvmb)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    vls.a(this.jdField_a_of_type_Vls, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vmb);
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlx
 * JD-Core Version:    0.7.0.1
 */