import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class xzu
  extends SimpleJob<Object>
{
  xzu(xzr paramxzr, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (wjf)wjs.a(19);
    paramVarArgs = paramJobContext.a(wpy.a(this.jdField_a_of_type_Xzr.b));
    xzw localxzw = new xzw(this.jdField_a_of_type_Xzr.c);
    ArrayList localArrayList = new ArrayList();
    localxzw.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localxzw.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localxzw.jdField_a_of_type_Boolean = bool;
      wad.a().dispatch(localxzw);
      ykq.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localxzw.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzu
 * JD-Core Version:    0.7.0.1
 */