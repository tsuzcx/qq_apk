import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class wmi
  extends SimpleJob<Object>
{
  wmi(wmf paramwmf, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (uvn)uwa.a(19);
    paramVarArgs = paramJobContext.a(vcg.a(this.jdField_a_of_type_Wmf.b));
    wmk localwmk = new wmk(this.jdField_a_of_type_Wmf.c);
    ArrayList localArrayList = new ArrayList();
    localwmk.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localwmk.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localwmk.jdField_a_of_type_Boolean = bool;
      umc.a().dispatch(localwmk);
      wxe.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localwmk.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmi
 * JD-Core Version:    0.7.0.1
 */