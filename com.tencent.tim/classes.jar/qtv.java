import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class qtv
  extends SimpleJob<Object>
{
  qtv(qts paramqts, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (psn)psx.a(19);
    paramVarArgs = paramJobContext.a(pxg.fT(this.b.mUin));
    qts.b localb = new qts.b(this.b.mContext);
    ArrayList localArrayList = new ArrayList();
    localb.ok = paramJobContext.a(this.val$uin, localArrayList);
    localb.ni = localArrayList;
    if ((paramVarArgs != null) && (paramVarArgs.isEnd == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      localb.mIsEnd = bool;
      pmi.a().dispatch(localb);
      ram.b("Q.qqstory.memories:MemoryDataPuller", "Get memory key list %s", localb.ok);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtv
 * JD-Core Version:    0.7.0.1
 */