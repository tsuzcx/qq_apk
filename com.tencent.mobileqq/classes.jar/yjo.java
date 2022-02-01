import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class yjo
  extends SimpleJob<Object>
{
  yjo(yjl paramyjl, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (wsu)wth.a(19);
    paramVarArgs = paramJobContext.a(wzn.a(this.jdField_a_of_type_Yjl.b));
    yjq localyjq = new yjq(this.jdField_a_of_type_Yjl.c);
    ArrayList localArrayList = new ArrayList();
    localyjq.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localyjq.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localyjq.jdField_a_of_type_Boolean = bool;
      wjj.a().dispatch(localyjq);
      yuk.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localyjq.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjo
 * JD-Core Version:    0.7.0.1
 */