import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class utk
  extends SimpleJob<Object>
{
  utk(uth paramuth, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (tcp)tdc.a(19);
    paramVarArgs = paramJobContext.a(tji.a(this.jdField_a_of_type_Uth.b));
    utm localutm = new utm(this.jdField_a_of_type_Uth.c);
    ArrayList localArrayList = new ArrayList();
    localutm.jdField_a_of_type_JavaUtilList = paramJobContext.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    localutm.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localutm.jdField_a_of_type_Boolean = bool;
      ste.a().dispatch(localutm);
      veg.a("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localutm.jdField_a_of_type_JavaUtilList);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utk
 * JD-Core Version:    0.7.0.1
 */