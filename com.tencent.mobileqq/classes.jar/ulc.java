import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.1;
import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.3;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import cooperation.qzone.LocalMultiProcConfig;

public class ulc
{
  private long jdField_a_of_type_Long = LocalMultiProcConfig.getLong("weishi_usergrowth", "key_red_dot_msg_uin", 0L);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private long a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    paramWSRedDotPushMsg = a(paramWSRedDotPushMsg);
    if (paramWSRedDotPushMsg != null) {
      return paramWSRedDotPushMsg.jdField_a_of_type_Long;
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
  
  public static ulc a()
  {
    return ule.a();
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_dot_msg_uin", this.jdField_a_of_type_Long);
  }
  
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong)
  {
    if (paramWSRedDotPushMsg == null)
    {
      uya.d("WSRedDotPreloadManager", "sendRequest wsPushMsgData: null");
      return;
    }
    uya.d("WSRedDotPreloadManager", "=====realPreloadRedData redDotUinSeq=" + paramLong + ", wsPushMsgData.mMsgData=" + paramWSRedDotPushMsg.mMsgData);
    uwt localuwt = new uwt(null, (byte)0, (byte)1, null, 8, null, null, null, paramWSRedDotPushMsg.mMsgData);
    localuwt.b = String.valueOf(paramLong);
    paramWSRedDotPushMsg = new urj(localuwt, null, new uld(this, paramWSRedDotPushMsg), 1001);
    this.jdField_a_of_type_Boolean = true;
    urc.a().a(paramWSRedDotPushMsg);
  }
  
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong, int paramInt)
  {
    uya.b("WSRedDotPreloadManager", "checkSendRequest checkCount: " + paramInt);
    if (paramInt == 0) {
      return;
    }
    boolean bool = uyo.a();
    uya.b("WSRedDotPreloadManager", "checkSendRequest inRealActionLoginB: " + bool);
    if (!bool)
    {
      a(paramWSRedDotPushMsg, paramLong);
      uya.b("WSRedDotPreloadManager", "checkSendRequest sendRequest!");
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new WSRedDotPreloadManager.1(this, paramWSRedDotPushMsg, paramLong, paramInt);
    urc.a().a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    uya.b("WSRedDotPreloadManager", "checkSendRequest postDelayed start!");
  }
  
  private void a(MessageForStructing paramMessageForStructing, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    WSPushPreloadModel localWSPushPreloadModel = a(paramWSRedDotPushMsg);
    if ((localWSPushPreloadModel == null) || (!localWSPushPreloadModel.jdField_a_of_type_Boolean))
    {
      uya.d("WSRedDotPreloadManager", "preloadData wsPushPreloadModel:" + localWSPushPreloadModel + ", mHadCleanPreCache:" + this.b);
      if (!this.b) {
        ulf.a().a();
      }
      this.b = true;
    }
    do
    {
      return;
      uya.b("WSRedDotPreloadManager", "preloadData mCurrentUniSeq=structMsg.uniSeq: " + paramMessageForStructing.uniseq);
      if (this.jdField_a_of_type_Long != paramMessageForStructing.uniseq) {
        break;
      }
    } while (this.jdField_a_of_type_Boolean);
    if (ulf.a().a())
    {
      uya.d("WSRedDotPreloadManager", "preloadData isRedCacheInValidDuration: true");
      return;
    }
    uya.d("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: " + localWSPushPreloadModel.b);
    if (!localWSPushPreloadModel.b)
    {
      uya.d("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: false");
      return;
      a(paramMessageForStructing.uniseq);
    }
    uya.d("WSRedDotPreloadManager", "preloadData mCurrentUniSeq: " + this.jdField_a_of_type_Long + ", mIsSendingRequest: " + this.jdField_a_of_type_Boolean);
    b();
    a(paramWSRedDotPushMsg, this.jdField_a_of_type_Long, 3);
  }
  
  private void b(MessageForStructing paramMessageForStructing, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramMessageForStructing.uniseq == this.jdField_a_of_type_Long) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = paramMessageForStructing.uniseq;
      LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_dot_msg_uin", this.jdField_a_of_type_Long);
      paramMessageForStructing = paramWSRedDotPushMsg.mStrategyInfo;
    } while ((TextUtils.isEmpty(paramWSRedDotPushMsg.mFeedIds)) || (paramMessageForStructing == null) || (paramMessageForStructing.getType() == 2) || (((WSPushStrategyInfo)paramMessageForStructing).mWSPushVideoModel == null));
    ThreadManager.executeOnSubThread(new WSRedDotPreloadManager.3(this, ((WSPushStrategyInfo)paramMessageForStructing).mWSPushVideoModel));
  }
  
  public void a()
  {
    for (;;)
    {
      WSRedDotPushMsg localWSRedDotPushMsg;
      try
      {
        uya.b("WSRedDotPreloadManager", "===startPreloadRedData===");
        Object localObject = uyo.a();
        if (localObject == null)
        {
          uya.d("WSRedDotPreloadManager", "preloadData weishiMgr: null");
          return;
        }
        localObject = ((plv)localObject).a();
        if (localObject == null) {
          continue;
        }
        localWSRedDotPushMsg = uyo.a((MessageForStructing)localObject);
        if (localWSRedDotPushMsg == null)
        {
          uya.d("WSRedDotPreloadManager", "preloadData wsPushMsgData: null");
          continue;
        }
        if (!umu.a().e()) {
          break label79;
        }
      }
      finally {}
      b(localMessageForStructing, localWSRedDotPushMsg);
      continue;
      label79:
      a(localMessageForStructing, localWSRedDotPushMsg);
      ukd.a().a();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      urc.a().b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
      uya.b("WSRedDotPreloadManager", "===== cancelPostDelayRunnable ! =====");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulc
 * JD-Core Version:    0.7.0.1
 */