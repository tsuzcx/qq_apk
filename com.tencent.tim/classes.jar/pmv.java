import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class pmv
  extends SimpleJob<Object>
{
  pmv(pmq parampmq, String paramString1, String paramString2, pmq.b paramb)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    pmq.a(this.jdField_a_of_type_Pmq, this.val$vid, this.jdField_a_of_type_Pmq$b);
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmv
 * JD-Core Version:    0.7.0.1
 */