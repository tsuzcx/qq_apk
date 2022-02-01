import UserGrowth.stGetCollectionRsp;
import java.util.List;

public class oqn
{
  private String mAttachInfo;
  private boolean mIsFinished;
  
  public static oqn a()
  {
    return oqn.a.b();
  }
  
  private void a(okz paramokz, oqm paramoqm)
  {
    if (!paramokz.succeeded())
    {
      ooz.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] failed code:" + paramokz.bfj + ", msg:" + paramokz.msg);
      if (paramoqm != null) {
        paramoqm.onFailed(paramokz.bfj, paramokz.msg);
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramokz.bb instanceof stGetCollectionRsp)) {
          break;
        }
        paramokz = (stGetCollectionRsp)paramokz.bb;
        this.mAttachInfo = paramokz.attachInfo;
        this.mIsFinished = paramokz.isFinished;
        paramokz = paramokz.feedList;
        paramokz = oqp.a().e(paramokz);
        ooz.bY("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] itemDataList size:" + paramokz.size() + ", mIsFinished:" + this.mIsFinished);
      } while (paramoqm == null);
      paramoqm.onSuccess(paramokz);
      return;
      ooz.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (paramoqm == null);
    paramoqm.onFailed(paramokz.mResultCode, paramokz.msg);
  }
  
  public void a(String paramString, int paramInt, oqm paramoqm)
  {
    if (this.mIsFinished)
    {
      ooz.bY("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramoqm = new oqo(this, paramoqm);
    paramString = new okz(new ood(paramString, this.mAttachInfo, paramInt), null, paramoqm, 4011);
    oks.a().b(paramString);
  }
  
  public void reset()
  {
    this.mAttachInfo = "";
    this.mIsFinished = false;
  }
  
  static class a
  {
    private static final oqn b = new oqn(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqn
 * JD-Core Version:    0.7.0.1
 */