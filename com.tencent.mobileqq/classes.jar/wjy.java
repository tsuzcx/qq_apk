import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class wjy
  extends SimpleJob<Object>
{
  wjy(wjt paramwjt, String paramString1, String paramString2, wkc paramwkc)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    wjt.a(this.jdField_a_of_type_Wjt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wkc);
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjy
 * JD-Core Version:    0.7.0.1
 */