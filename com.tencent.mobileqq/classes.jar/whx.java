import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class whx
  extends SimpleJob<Object>
{
  whx(whw paramwhw, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramJobContext = (ure)urr.a(19);
    paramVarArgs = paramJobContext.a(uxx.a(this.a.jdField_b_of_type_JavaLangString));
    boolean bool;
    uyb localuyb;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1))
    {
      bool = true;
      List localList = paramJobContext.a(this.a.jdField_b_of_type_JavaLangString, null, 10L);
      localuyb = new uyb(this.a.c, new ErrorMessage());
      localuyb.jdField_b_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
      localuyb.jdField_b_of_type_Boolean = true;
      localuyb.c = true;
      localuyb.e = true;
      localuyb.jdField_a_of_type_Boolean = false;
      localuyb.jdField_a_of_type_JavaUtilList = localList;
      if (localList.size() <= 0) {
        break label246;
      }
      paramJobContext = (VideoCollectionItem)localList.get(localList.size() - 1);
      label156:
      if (paramJobContext != null) {
        break label251;
      }
      localuyb.jdField_a_of_type_Boolean = true;
      this.a.jdField_b_of_type_Boolean = true;
      label174:
      uht.a().dispatch(localuyb);
      this.a.a(localList, false);
      if (!localuyb.jdField_a_of_type_Boolean) {
        break label294;
      }
    }
    label294:
    for (paramJobContext = "true";; paramJobContext = "false")
    {
      wsv.d("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
      this.a.d();
      return null;
      bool = false;
      break;
      label246:
      paramJobContext = null;
      break label156;
      label251:
      if ((paramVarArgs != null) && (paramJobContext.dbIndex >= paramVarArgs.maxCollectionIndex))
      {
        localuyb.jdField_a_of_type_Boolean = bool;
        this.a.jdField_b_of_type_Boolean = true;
        break label174;
      }
      localuyb.jdField_a_of_type_Boolean = false;
      break label174;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whx
 * JD-Core Version:    0.7.0.1
 */