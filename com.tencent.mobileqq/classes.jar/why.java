import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class why
  extends SimpleJob<Object>
{
  why(whw paramwhw, String paramString, VideoCollectionItem paramVideoCollectionItem)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramJobContext = (ure)urr.a(19);
    MemoryInfoEntry localMemoryInfoEntry = paramJobContext.a(uxx.a(this.jdField_a_of_type_Whw.jdField_b_of_type_JavaLangString));
    boolean bool1;
    boolean bool2;
    label56:
    List localList;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1))
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem != null) {
        break label250;
      }
      bool2 = true;
      if (this.jdField_a_of_type_Whw.jdField_b_of_type_Boolean) {
        break label414;
      }
      localList = paramJobContext.a(this.jdField_a_of_type_Whw.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem, 10L);
      paramVarArgs = new uyb(this.jdField_a_of_type_Whw.c, new ErrorMessage());
      paramVarArgs.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Whw.jdField_b_of_type_JavaLangString;
      paramVarArgs.jdField_b_of_type_Boolean = true;
      paramVarArgs.c = bool2;
      paramVarArgs.e = true;
      paramVarArgs.jdField_a_of_type_Boolean = bool1;
      paramVarArgs.jdField_a_of_type_JavaUtilList = localList;
      if (localList.size() <= 0) {
        break label256;
      }
      paramJobContext = (VideoCollectionItem)localList.get(localList.size() - 1);
      label177:
      if (paramJobContext != null) {
        break label285;
      }
      this.jdField_a_of_type_Whw.jdField_b_of_type_Boolean = true;
      if (!bool2) {
        break label261;
      }
      this.jdField_a_of_type_Whw.a.a(null, 0);
      label206:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem != null) {
        break label274;
      }
    }
    label256:
    label261:
    label274:
    for (paramJobContext = "null";; paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.key)
    {
      wsv.d("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , not found in db , start get from net , spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
      return null;
      bool1 = false;
      break;
      label250:
      bool2 = false;
      break label56;
      paramJobContext = null;
      break label177;
      this.jdField_a_of_type_Whw.a.c();
      break label206;
    }
    label285:
    if ((localMemoryInfoEntry != null) && (paramJobContext.dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
    {
      paramVarArgs.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Whw.jdField_b_of_type_Boolean = true;
      label317:
      uht.a().dispatch(paramVarArgs);
      this.jdField_a_of_type_Whw.a(localList, false);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem != null) {
        break label397;
      }
      paramJobContext = "null";
      label346:
      if (!paramVarArgs.jdField_a_of_type_Boolean) {
        break label408;
      }
    }
    label397:
    label408:
    for (paramVarArgs = "true";; paramVarArgs = "false")
    {
      wsv.d("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , isEnd = %s ,spend time = %d", new Object[] { paramJobContext, paramVarArgs, Long.valueOf(System.currentTimeMillis() - l) });
      break;
      paramVarArgs.jdField_a_of_type_Boolean = false;
      break label317;
      paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.key;
      break label346;
    }
    label414:
    if (bool2) {
      this.jdField_a_of_type_Whw.a.a(null, 0);
    }
    for (;;)
    {
      wsv.d("Q.qqstory.memories:MemoryDataPuller", String.format("Req from net ,  spend time = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      break;
      this.jdField_a_of_type_Whw.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     why
 * JD-Core Version:    0.7.0.1
 */