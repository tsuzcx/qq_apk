import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.SingleUndealMsg;
import com.tencent.biz.qqcircle.eevee.QCircleEeveeMananger.2;
import com.tencent.biz.qqcircle.events.QCirclePushToastEvent;
import com.tencent.biz.qqcircle.events.QCircleRedPointEvent;
import com.tencent.biz.qqcircle.requests.QCircleEeveeUndealMsgRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudEeveeBase.ClientInfo;
import feedcloud.FeedCloudEeveeUndealmsg.BizUndealMsg;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import feedcloud.FeedCloudEeveeUndealmsg.IntervalControl;
import feedcloud.FeedCloudEeveeUndealmsg.SignalMsg;
import feedcloud.FeedCloudToastshowsvr.StGetToastDetailRsp;
import feedcloud.FeedCloudToastshowsvr.StShowControl;
import feedcloud.FeedCloudToastshowsvr.StShowTime;
import feedcloud.FeedCloudToastshowsvr.StToast;
import feedcloud.FeedCloudToastshowsvr.StToastContent;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleCounter.CountInfoRsp;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class viy
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static viy jdField_a_of_type_Viy;
  public long a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QCircleEeveeMananger.2(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b = 5000L;
  private long c;
  
  viy()
  {
    this.jdField_a_of_type_Long = 60000L;
    a();
  }
  
  /* Error */
  private EntityManager a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	viy:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 43	viy:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: invokestatic 49	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 53	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +11 -> 37
    //   29: ldc 55
    //   31: iconst_1
    //   32: ldc 57
    //   34: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_1
    //   38: instanceof 65
    //   41: ifne +16 -> 57
    //   44: ldc 55
    //   46: iconst_1
    //   47: ldc 67
    //   49: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aconst_null
    //   53: astore_1
    //   54: goto -40 -> 14
    //   57: aload_1
    //   58: invokevirtual 73	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   61: ifnonnull +16 -> 77
    //   64: ldc 55
    //   66: iconst_1
    //   67: ldc 75
    //   69: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -60 -> 14
    //   77: aload_0
    //   78: aload_1
    //   79: checkcast 65	com/tencent/mobileqq/app/QQAppInterface
    //   82: invokevirtual 78	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   85: invokevirtual 83	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: putfield 43	viy:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   91: aload_0
    //   92: getfield 43	viy:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   95: astore_1
    //   96: goto -82 -> 14
    //   99: astore_1
    //   100: ldc 55
    //   102: iconst_1
    //   103: new 85	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   110: ldc 88
    //   112: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aconst_null
    //   126: astore_1
    //   127: goto -113 -> 14
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	viy
    //   13	83	1	localObject1	Object
    //   99	17	1	localException	java.lang.Exception
    //   126	1	1	localObject2	Object
    //   130	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   77	96	99	java/lang/Exception
    //   2	14	130	finally
    //   18	25	130	finally
    //   29	37	130	finally
    //   37	52	130	finally
    //   57	72	130	finally
    //   77	96	130	finally
    //   100	125	130	finally
  }
  
  private MqqHandler a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {}
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("eevee_timer", 0);
        localHandlerThread.start();
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      }
      return this.jdField_a_of_type_MqqOsMqqHandler;
    }
    finally {}
  }
  
  public static viy a()
  {
    if (jdField_a_of_type_Viy == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Viy == null) {
        jdField_a_of_type_Viy = new viy();
      }
      return jdField_a_of_type_Viy;
    }
  }
  
  private void a()
  {
    QLog.e("QCircleEeveeMananger", 1, "scheduleEeveeTask pollingInterval= " + this.jdField_a_of_type_Long);
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
  }
  
  private void a(FeedCloudEeveeUndealmsg.BizUndealMsg paramBizUndealMsg)
  {
    int i = paramBizUndealMsg.mainType.get();
    paramBizUndealMsg = paramBizUndealMsg.bufferData.get();
    if (paramBizUndealMsg != null) {}
    for (paramBizUndealMsg = paramBizUndealMsg.toByteArray();; paramBizUndealMsg = null)
    {
      switch (i)
      {
      }
      for (;;)
      {
        a(i, paramBizUndealMsg);
        return;
        StringBuilder localStringBuilder;
        try
        {
          QQCircleCounter.CountInfoRsp localCountInfoRsp = new QQCircleCounter.CountInfoRsp();
          localCountInfoRsp.mergeFrom(paramBizUndealMsg);
          QLog.d("QCircleEeveeMananger", 1, "handleBizUndealMsg mainType " + i + ", " + localCountInfoRsp.rptRedPoint.size());
          Object localObject1 = localCountInfoRsp.rptRedPoint.get();
          if (localObject1 == null) {
            break label391;
          }
          localStringBuilder = new StringBuilder();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (QQCircleCounter.RedPointInfo)((Iterator)localObject1).next();
            localStringBuilder.append("[handleBizUndealMsg] receive redpoint. appid: ").append(((QQCircleCounter.RedPointInfo)localObject2).appid.get()).append(", redType: ").append(((QQCircleCounter.RedPointInfo)localObject2).redType.get()).append(", redTotalNum: ").append(((QQCircleCounter.RedPointInfo)localObject2).redTotalNum.get()).append(", extend: ").append(((QQCircleCounter.RedPointInfo)localObject2).extend.get());
            localObject2 = ((QQCircleCounter.RedPointInfo)localObject2).rptRedInfo.get();
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              localStringBuilder.append(", uinInfo: ");
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                QQCircleCounter.RedDisplayInfo localRedDisplayInfo = (QQCircleCounter.RedDisplayInfo)((Iterator)localObject2).next();
                localStringBuilder.append("(").append(localRedDisplayInfo.headImg.get()).append(",").append(localRedDisplayInfo.num.get()).append(")");
              }
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          QLog.e("QCircleEeveeMananger", 1, "handleBizUndealMsg error: mainType " + i, localInvalidProtocolBufferMicroException1);
        }
        QLog.d("QCircleEeveeMananger", 1, new Object[] { localStringBuilder });
        label391:
        zwp.a().a(new QCircleRedPointEvent(i, localInvalidProtocolBufferMicroException1));
        continue;
        try
        {
          FeedCloudToastshowsvr.StGetToastDetailRsp localStGetToastDetailRsp = new FeedCloudToastshowsvr.StGetToastDetailRsp();
          localStGetToastDetailRsp.mergeFrom(paramBizUndealMsg);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[handleBizUndealMsg] receive toast. showPageType: ").append(localStGetToastDetailRsp.toastInfo.showControl.showPageType.get()).append(", showTimeType: ").append(localStGetToastDetailRsp.toastInfo.showControl.showTime.showTimeType.get()).append(", showTime: ").append(localStGetToastDetailRsp.toastInfo.showControl.showTime.value.get()).append(", showDuration: ").append(localStGetToastDetailRsp.toastInfo.showControl.showTime.showDuration.get()).append(", title: ").append(localStGetToastDetailRsp.toastInfo.toastContent.title.get()).append(", content: ").append(localStGetToastDetailRsp.toastInfo.toastContent.content.get());
          QLog.d("QCircleEeveeMananger", 1, new Object[] { localStringBuilder });
          zwp.a().a(new QCirclePushToastEvent(localStGetToastDetailRsp));
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          localInvalidProtocolBufferMicroException2.printStackTrace();
        }
      }
    }
  }
  
  private void a(FeedCloudEeveeUndealmsg.IntervalControl paramIntervalControl)
  {
    if (paramIntervalControl == null) {
      return;
    }
    int i = paramIntervalControl.pollingInterval.get();
    if (i > 0) {
      this.jdField_a_of_type_Long = (i * 1000L);
    }
    int j = paramIntervalControl.sceneSwitchInterval.get();
    if (j > 0) {
      this.b = (j * 1000L);
    }
    QLog.e("QCircleEeveeMananger", 1, "saveInterval pollingInterval= " + i + "sceneSwitchInterval =" + j);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QzoneConfig.getInstance();
    if (QzoneConfig.isQQCircleShowLebaEntrance())
    {
      QzoneConfig.getInstance();
      if (QzoneConfig.isEeveeSysTemPolling()) {}
    }
    else
    {
      return;
    }
    Object localObject = new FeedCloudEeveeUndealmsg.SignalMsg();
    label120:
    FeedCloudEeveeBase.ClientInfo localClientInfo;
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 999: 
    default: 
      localClientInfo = new FeedCloudEeveeBase.ClientInfo();
      localClientInfo.clientAppVersion.set(blru.a());
      if (!vri.b()) {
        break;
      }
    }
    for (int i = 2;; i = 1)
    {
      localObject = new QCircleEeveeUndealMsgRequest(localClientInfo, paramInt, i, (FeedCloudEeveeUndealmsg.SignalMsg)localObject);
      QLog.e("QCircleEeveeMananger", 1, "request traceid" + ((QCircleEeveeUndealMsgRequest)localObject).getTraceId() + "visitScene= " + paramInt + " extinfo =" + paramString1 + " msgId = " + paramString2 + " isQQCircleActive() = " + vri.b());
      VSNetworkHelper.a().a((VSBaseRequest)localObject, new viz(this, paramInt, paramString2));
      a();
      return;
      if (System.currentTimeMillis() - this.c < this.b) {
        break;
      }
      this.c = System.currentTimeMillis();
      break label120;
      if (!TextUtils.isEmpty(paramString1)) {
        ((FeedCloudEeveeUndealmsg.SignalMsg)localObject).signalBuff.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      if (TextUtils.isEmpty(paramString2)) {
        break label120;
      }
      ((FeedCloudEeveeUndealmsg.SignalMsg)localObject).msgid.set(paramString2);
      break label120;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.e("QCircleEeveeMananger", 1, "saveBizUndealMsgBuffer type=" + paramInt);
    paramArrayOfByte = new SingleUndealMsg(paramInt, paramArrayOfByte);
    if (a() != null)
    {
      a().delete(SingleUndealMsg.class.getSimpleName(), "mType = ?", new String[] { paramArrayOfByte.mType + "" });
      a().persistOrReplace(paramArrayOfByte);
    }
  }
  
  public void a(FeedCloudEeveeUndealmsg.FcUndealMsgsRsp paramFcUndealMsgsRsp, int paramInt)
  {
    if (paramFcUndealMsgsRsp != null)
    {
      Object localObject = paramFcUndealMsgsRsp.msgs.get();
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedCloudEeveeUndealmsg.BizUndealMsg localBizUndealMsg = (FeedCloudEeveeUndealmsg.BizUndealMsg)((Iterator)localObject).next();
          a(localBizUndealMsg);
          if (paramInt == 1000) {
            vqz.a(500, 15, 1, null, null, null, localBizUndealMsg.msgid.get(), paramInt);
          } else {
            vqz.a(500, 20, 1, null, null, null, localBizUndealMsg.msgid.get(), paramInt);
          }
        }
      }
      a(paramFcUndealMsgsRsp.intervalCtl);
    }
  }
  
  public byte[] a(int paramInt)
  {
    Object localObject2 = null;
    QLog.e("QCircleEeveeMananger", 1, "getBizUndealMsgBuffer type=" + paramInt);
    Object localObject1 = localObject2;
    if (a() != null)
    {
      List localList = a().query(SingleUndealMsg.class, SingleUndealMsg.class.getSimpleName(), true, "mType = ?", new String[] { paramInt + "" }, null, null, null, null);
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() > 0) {
          localObject1 = ((SingleUndealMsg)localList.get(0)).mBizBufferData;
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     viy
 * JD-Core Version:    0.7.0.1
 */