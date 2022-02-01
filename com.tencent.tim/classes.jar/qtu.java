import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class qtu
  extends SimpleJob<Object>
{
  qtu(qts paramqts, String paramString, VideoCollectionItem paramVideoCollectionItem)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramJobContext = (psn)psx.a(19);
    MemoryInfoEntry localMemoryInfoEntry = paramJobContext.a(pxg.fT(this.b.mUin));
    boolean bool1;
    boolean bool2;
    label56:
    List localList;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1))
    {
      bool1 = true;
      if (this.c != null) {
        break label250;
      }
      bool2 = true;
      if (this.b.aFu) {
        break label414;
      }
      localList = paramJobContext.a(this.b.mUin, this.c, 10L);
      paramVarArgs = new pxg.b(this.b.mContext, new ErrorMessage());
      paramVarArgs.uin = this.b.mUin;
      paramVarArgs.aCu = true;
      paramVarArgs.isFirstPage = bool2;
      paramVarArgs.isUpdated = true;
      paramVarArgs.isEnd = bool1;
      paramVarArgs.mL = localList;
      if (localList.size() <= 0) {
        break label256;
      }
      paramJobContext = (VideoCollectionItem)localList.get(localList.size() - 1);
      label177:
      if (paramJobContext != null) {
        break label285;
      }
      this.b.aFu = true;
      if (!bool2) {
        break label261;
      }
      this.b.a.a(null, 0);
      label206:
      if (this.c != null) {
        break label274;
      }
    }
    label256:
    label261:
    label274:
    for (paramJobContext = "null";; paramJobContext = this.c.key)
    {
      ram.w("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , not found in db , start get from net , spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
      return null;
      bool1 = false;
      break;
      label250:
      bool2 = false;
      break label56;
      paramJobContext = null;
      break label177;
      this.b.a.aPh();
      break label206;
    }
    label285:
    if ((localMemoryInfoEntry != null) && (paramJobContext.dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
    {
      paramVarArgs.isEnd = bool1;
      this.b.aFu = true;
      label317:
      pmi.a().dispatch(paramVarArgs);
      this.b.L(localList, false);
      if (this.c != null) {
        break label397;
      }
      paramJobContext = "null";
      label346:
      if (!paramVarArgs.isEnd) {
        break label408;
      }
    }
    label397:
    label408:
    for (paramVarArgs = "true";; paramVarArgs = "false")
    {
      ram.w("Q.qqstory.memories:MemoryDataPuller", "Req local data ,start key: %s , isEnd = %s ,spend time = %d", new Object[] { paramJobContext, paramVarArgs, Long.valueOf(System.currentTimeMillis() - l) });
      break;
      paramVarArgs.isEnd = false;
      break label317;
      paramJobContext = this.c.key;
      break label346;
    }
    label414:
    if (bool2) {
      this.b.a.a(null, 0);
    }
    for (;;)
    {
      ram.w("Q.qqstory.memories:MemoryDataPuller", String.format("Req from net ,  spend time = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      break;
      this.b.a.aPh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtu
 * JD-Core Version:    0.7.0.1
 */