import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class vch
  extends SimpleJob<Object>
{
  vch(vcg paramvcg, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.jdField_a_of_type_Vcj == null) {
      this.a.jdField_a_of_type_Vcj = new vcj(this.a, this.a.d);
    }
    this.a.jdField_a_of_type_JavaLangString = "";
    vcg.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vch
 * JD-Core Version:    0.7.0.1
 */