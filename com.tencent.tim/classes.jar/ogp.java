import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.1;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import cooperation.qzone.LocalMultiProcConfig;

public class ogp
{
  private boolean awY;
  private boolean awZ;
  private Runnable mRunnable;
  private long yK = LocalMultiProcConfig.getLong("weishi_usergrowth", "key_red_dot_msg_uin", 0L);
  
  private long a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    paramWSRedDotPushMsg = a(paramWSRedDotPushMsg);
    if (paramWSRedDotPushMsg != null) {
      return paramWSRedDotPushMsg.zg;
    }
    return 7200000L;
  }
  
  private WSPushPreloadModel a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramWSRedDotPushMsg == null) {}
    while (!(paramWSRedDotPushMsg.mStrategyInfo instanceof WSPushStrategyInfo)) {
      return null;
    }
    return ((WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo).mWSPushPreloadModel;
  }
  
  public static ogp a()
  {
    return ogp.a.b();
  }
  
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong)
  {
    if (paramWSRedDotPushMsg == null)
    {
      ooz.e("WSRedDotPreloadManager", "sendRequest wsPushMsgData: null");
      return;
    }
    ooz.e("WSRedDotPreloadManager", "=====realPreloadRedData redDotUinSeq=" + paramLong + ", wsPushMsgData.mMsgData=" + paramWSRedDotPushMsg.mMsgData);
    onz localonz = new onz(null, (byte)0, (byte)1, null, 8, null, null, null, paramWSRedDotPushMsg.mMsgData);
    localonz.mRequestId = String.valueOf(paramLong);
    paramWSRedDotPushMsg = new okz(localonz, null, new ogq(this, paramWSRedDotPushMsg), 1001);
    this.awY = true;
    oks.a().b(paramWSRedDotPushMsg);
  }
  
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong, int paramInt)
  {
    ooz.d("WSRedDotPreloadManager", "checkSendRequest checkCount: " + paramInt);
    if (paramInt == 0) {
      return;
    }
    boolean bool = opn.He();
    ooz.d("WSRedDotPreloadManager", "checkSendRequest inRealActionLoginB: " + bool);
    if (!bool)
    {
      a(paramWSRedDotPushMsg, paramLong);
      ooz.d("WSRedDotPreloadManager", "checkSendRequest sendRequest!");
      return;
    }
    this.mRunnable = new WSRedDotPreloadManager.1(this, paramWSRedDotPushMsg, paramLong, paramInt);
    oks.a().postDelayed(this.mRunnable, 30000L);
    ooz.d("WSRedDotPreloadManager", "checkSendRequest postDelayed start!");
  }
  
  private void a(MessageForStructing paramMessageForStructing, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    WSPushPreloadModel localWSPushPreloadModel = a(paramWSRedDotPushMsg);
    if ((localWSPushPreloadModel == null) || (!localWSPushPreloadModel.axP))
    {
      ooz.e("WSRedDotPreloadManager", "preloadData wsPushPreloadModel:" + localWSPushPreloadModel + ", mHadCleanPreCache:" + this.awZ);
      if (!this.awZ) {
        ogr.a().beC();
      }
      this.awZ = true;
    }
    do
    {
      return;
      ooz.d("WSRedDotPreloadManager", "preloadData mCurrentUniSeq=structMsg.uniSeq: " + paramMessageForStructing.uniseq);
      if (this.yK != paramMessageForStructing.uniseq) {
        break;
      }
    } while (this.awY);
    if (ogr.a().GJ())
    {
      ooz.e("WSRedDotPreloadManager", "preloadData isRedCacheInValidDuration: true");
      return;
    }
    ooz.e("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: " + localWSPushPreloadModel.axQ);
    if (!localWSPushPreloadModel.axQ)
    {
      ooz.e("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: false");
      return;
      eX(paramMessageForStructing.uniseq);
    }
    ooz.e("WSRedDotPreloadManager", "preloadData mCurrentUniSeq: " + this.yK + ", mIsSendingRequest: " + this.awY);
    beB();
    a(paramWSRedDotPushMsg, this.yK, 3);
  }
  
  private void eX(long paramLong)
  {
    this.yK = paramLong;
    this.awY = false;
    LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_dot_msg_uin", this.yK);
  }
  
  public void beA()
  {
    for (;;)
    {
      try
      {
        ooz.d("WSRedDotPreloadManager", "===startPreloadRedData===");
        Object localObject = opn.a();
        if (localObject == null)
        {
          ooz.e("WSRedDotPreloadManager", "preloadData weishiMgr: null");
          return;
        }
        localObject = ((lcr)localObject).c();
        if (localObject == null) {
          continue;
        }
        WSRedDotPushMsg localWSRedDotPushMsg = opn.a((MessageForStructing)localObject);
        if (localWSRedDotPushMsg == null)
        {
          ooz.e("WSRedDotPreloadManager", "preloadData wsPushMsgData: null");
          continue;
        }
        a(localMessageForStructing, localWSRedDotPushMsg);
      }
      finally {}
      oft.a().bem();
    }
  }
  
  public void beB()
  {
    if (this.mRunnable != null)
    {
      oks.a().removeCallbacks(this.mRunnable);
      this.mRunnable = null;
      ooz.d("WSRedDotPreloadManager", "===== cancelPostDelayRunnable ! =====");
    }
  }
  
  static class a
  {
    private static final ogp a = new ogp(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogp
 * JD-Core Version:    0.7.0.1
 */