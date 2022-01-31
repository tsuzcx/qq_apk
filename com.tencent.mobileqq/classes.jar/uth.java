import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class uth
  extends SimpleJob<Object>
{
  uth(ute paramute, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (tcm)tcz.a(19);
    paramVarArgs = paramJobContext.a(tjf.a(this.jdField_a_of_type_Ute.b));
    utj localutj = new utj(this.jdField_a_of_type_Ute.c);
    ArrayList localArrayList = new ArrayList();
    localutj.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localutj.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localutj.jdField_a_of_type_Boolean = bool;
      stb.a().dispatch(localutj);
      ved.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localutj.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uth
 * JD-Core Version:    0.7.0.1
 */