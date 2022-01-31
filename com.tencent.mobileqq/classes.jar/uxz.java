import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class uxz
  extends SimpleJob<Object>
{
  uxz(uxx paramuxx, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.jdField_a_of_type_Uya == null) {
      this.a.jdField_a_of_type_Uya = new uya(this.a, this.a.d);
    }
    this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Uya.jdField_a_of_type_JavaLangString;
    uxx.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxz
 * JD-Core Version:    0.7.0.1
 */