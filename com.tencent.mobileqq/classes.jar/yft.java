import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class yft
  extends SimpleJob<Object>
{
  yft(yfq paramyfq, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (woz)wpm.a(19);
    paramVarArgs = paramJobContext.a(wvs.a(this.jdField_a_of_type_Yfq.b));
    yfv localyfv = new yfv(this.jdField_a_of_type_Yfq.c);
    ArrayList localArrayList = new ArrayList();
    localyfv.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localyfv.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localyfv.jdField_a_of_type_Boolean = bool;
      wfo.a().dispatch(localyfv);
      yqp.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localyfv.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yft
 * JD-Core Version:    0.7.0.1
 */