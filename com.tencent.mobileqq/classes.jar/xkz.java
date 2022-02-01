import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class xkz
  extends SimpleJob<Object>
{
  xkz(xkw paramxkw, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (vuk)vux.a(19);
    paramVarArgs = paramJobContext.a(wbd.a(this.jdField_a_of_type_Xkw.b));
    xlb localxlb = new xlb(this.jdField_a_of_type_Xkw.c);
    ArrayList localArrayList = new ArrayList();
    localxlb.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localxlb.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localxlb.jdField_a_of_type_Boolean = bool;
      vli.a().dispatch(localxlb);
      xvv.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localxlb.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkz
 * JD-Core Version:    0.7.0.1
 */