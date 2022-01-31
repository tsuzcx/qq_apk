import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class ugo
  extends SimpleJob<Object>
{
  ugo(ugl paramugl, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (spt)sqg.a(19);
    paramVarArgs = paramJobContext.a(swm.a(this.jdField_a_of_type_Ugl.b));
    ugq localugq = new ugq(this.jdField_a_of_type_Ugl.c);
    ArrayList localArrayList = new ArrayList();
    localugq.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localugq.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localugq.jdField_a_of_type_Boolean = bool;
      sgi.a().dispatch(localugq);
      urk.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localugq.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugo
 * JD-Core Version:    0.7.0.1
 */