import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class wbe
  extends SimpleJob<Object>
{
  wbe(wbd paramwbd, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.jdField_a_of_type_Wbg == null) {
      this.a.jdField_a_of_type_Wbg = new wbg(this.a, this.a.d);
    }
    this.a.jdField_a_of_type_JavaLangString = "";
    wbd.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbe
 * JD-Core Version:    0.7.0.1
 */