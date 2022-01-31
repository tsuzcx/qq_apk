import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class whz
  extends SimpleJob<Object>
{
  whz(whw paramwhw, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (ure)urr.a(19);
    paramVarArgs = paramJobContext.a(uxx.a(this.jdField_a_of_type_Whw.b));
    wib localwib = new wib(this.jdField_a_of_type_Whw.c);
    ArrayList localArrayList = new ArrayList();
    localwib.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localwib.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localwib.jdField_a_of_type_Boolean = bool;
      uht.a().dispatch(localwib);
      wsv.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localwib.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whz
 * JD-Core Version:    0.7.0.1
 */