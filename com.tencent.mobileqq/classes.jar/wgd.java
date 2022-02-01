import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class wgd
  extends SimpleJob<Object>
{
  wgd(wfy paramwfy, String paramString1, String paramString2, wgh paramwgh)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    wfy.a(this.jdField_a_of_type_Wfy, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wgh);
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgd
 * JD-Core Version:    0.7.0.1
 */