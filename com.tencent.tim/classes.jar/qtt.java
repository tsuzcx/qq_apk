import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class qtt
  extends SimpleJob<Object>
{
  qtt(qts paramqts, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramJobContext = (psn)psx.a(19);
    paramVarArgs = paramJobContext.a(pxg.fT(this.b.mUin));
    boolean bool;
    pxg.b localb;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1))
    {
      bool = true;
      List localList = paramJobContext.a(this.b.mUin, null, 10L);
      localb = new pxg.b(this.b.mContext, new ErrorMessage());
      localb.uin = this.b.mUin;
      localb.aCu = true;
      localb.isFirstPage = true;
      localb.isUpdated = true;
      localb.isEnd = false;
      localb.mL = localList;
      if (localList.size() <= 0) {
        break label246;
      }
      paramJobContext = (VideoCollectionItem)localList.get(localList.size() - 1);
      label156:
      if (paramJobContext != null) {
        break label251;
      }
      localb.isEnd = true;
      this.b.aFu = true;
      label174:
      pmi.a().dispatch(localb);
      this.b.L(localList, false);
      if (!localb.isEnd) {
        break label294;
      }
    }
    label294:
    for (paramJobContext = "true";; paramJobContext = "false")
    {
      ram.w("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { paramJobContext, Long.valueOf(System.currentTimeMillis() - l) });
      this.b.bqF();
      return null;
      bool = false;
      break;
      label246:
      paramJobContext = null;
      break label156;
      label251:
      if ((paramVarArgs != null) && (paramJobContext.dbIndex >= paramVarArgs.maxCollectionIndex))
      {
        localb.isEnd = bool;
        this.b.aFu = true;
        break label174;
      }
      localb.isEnd = false;
      break label174;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtt
 * JD-Core Version:    0.7.0.1
 */