import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class tjh
  extends SimpleJob<Object>
{
  tjh(tjf paramtjf, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.jdField_a_of_type_Tji == null) {
      this.a.jdField_a_of_type_Tji = new tji(this.a, this.a.d);
    }
    this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Tji.jdField_a_of_type_JavaLangString;
    tjf.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjh
 * JD-Core Version:    0.7.0.1
 */