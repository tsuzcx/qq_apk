import NS_MOBILE_OPERATION.operation_like_rsp;
import NS_QZONE_MQMSG.QzoneMessageBoxRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.contentbox.QZoneMsgManager.1;
import cooperation.qzone.contentbox.QZoneMsgManager.2;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class avto
  implements Manager, BusinessObserver
{
  private ArrayList<QZoneMsgEntityNew> EV;
  String cNH = null;
  private WeakReference<QQAppInterface> mAppRef;
  private String traceInfo;
  
  public avto(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
  }
  
  public void a(MQLikeCell paramMQLikeCell, long paramLong)
  {
    boolean bool = true;
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "likeFeed()");
    }
    if ((paramMQLikeCell == null) || (TextUtils.isEmpty(paramMQLikeCell.likeKey))) {
      return;
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "likeFeed app == null");
      return;
    }
    long l = localQQAppInterface.getLongAccountUin();
    Object localObject1 = paramMQLikeCell.likeKey;
    Object localObject2 = paramMQLikeCell.likeKey;
    int i;
    Bundle localBundle;
    if (!paramMQLikeCell.liked)
    {
      i = 0;
      localObject1 = new avtt(Long.valueOf(l), (String)localObject1, (String)localObject2, i, paramMQLikeCell.appid);
      ((avtt)localObject1).setType(100);
      localObject2 = new QzoneCommonIntent(localQQAppInterface.getApplication(), afaf.class);
      localBundle = new Bundle();
      if (paramMQLikeCell.liked) {
        break label194;
      }
    }
    for (;;)
    {
      localBundle.putBoolean("like_key", bool);
      localBundle.putLong("entity_pushtime", paramLong);
      ((QzoneCommonIntent)localObject2).putExtras(localBundle);
      ((QzoneCommonIntent)localObject2).setRequest((avpr)localObject1);
      ((QzoneCommonIntent)localObject2).setObserver(this);
      localQQAppInterface.startServlet((NewIntent)localObject2);
      return;
      i = 1;
      break;
      label194:
      bool = false;
    }
  }
  
  public void a(QZoneMsgEntityNew paramQZoneMsgEntityNew, int paramInt)
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "saveMsgToDB()");
    }
    if (paramQZoneMsgEntityNew == null)
    {
      QZLog.e("QZoneMsgManager", "saveMsgToDB error entity==null");
      return;
    }
    this.traceInfo = paramQZoneMsgEntityNew.trace_info;
    if (this.EV != null)
    {
      paramInt = 0;
      if (paramInt >= this.EV.size()) {
        break label183;
      }
      if (((QZoneMsgEntityNew)this.EV.get(paramInt)).pushTime == paramQZoneMsgEntityNew.pushTime)
      {
        paramQZoneMsgEntityNew.setId(((QZoneMsgEntityNew)this.EV.get(paramInt)).getId());
        paramQZoneMsgEntityNew.setStatus(((QZoneMsgEntityNew)this.EV.get(paramInt)).getStatus());
        this.EV.set(paramInt, paramQZoneMsgEntityNew);
      }
    }
    label183:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        this.EV.add(0, paramQZoneMsgEntityNew);
      }
      for (;;)
      {
        ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.2(this, paramQZoneMsgEntityNew));
        return;
        paramInt += 1;
        break;
        this.EV = new ArrayList();
        this.EV.add(paramQZoneMsgEntityNew);
      }
    }
  }
  
  public void c(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgInteractData == null) || (paramMQMsg.msgInteractData.likeCell == null) || (TextUtils.isEmpty(paramMQMsg.msgInteractData.likeCell.likeKey))) {}
    String str;
    do
    {
      return;
      str = paramMQMsg.msgInteractData.likeCell.likeKey;
    } while (this.EV == null);
    int i = 0;
    label58:
    QZoneMsgEntityNew localQZoneMsgEntityNew;
    MQMsg localMQMsg;
    if (i < this.EV.size())
    {
      localQZoneMsgEntityNew = (QZoneMsgEntityNew)this.EV.get(i);
      if ((localQZoneMsgEntityNew != null) && (localQZoneMsgEntityNew.ArkNes_vec != null) && (localQZoneMsgEntityNew.ArkNes_vec.get(0) != null))
      {
        localMQMsg = (MQMsg)localQZoneMsgEntityNew.ArkNes_vec.get(0);
        if ((localMQMsg != null) && (localMQMsg.msgInteractData != null) && (localMQMsg.msgInteractData.likeCell != null) && (!TextUtils.isEmpty(localMQMsg.msgInteractData.likeCell.likeKey))) {
          break label169;
        }
      }
    }
    label169:
    while (!str.equals(localMQMsg.msgInteractData.likeCell.likeKey))
    {
      i += 1;
      break label58;
      break;
    }
    localMQMsg.msgInteractData.likeCell.totalLike = paramMQMsg.msgInteractData.likeCell.totalLike;
    localMQMsg.msgInteractData.totalComment = paramMQMsg.msgInteractData.totalComment;
    localMQMsg.msgInteractData.likeCell.liked = paramMQMsg.msgInteractData.likeCell.liked;
    a(localQZoneMsgEntityNew, 0);
  }
  
  public void eBV()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "preLoadQZoneMsg()");
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QZLog.e("QZoneMsgManager", "preLoadQZoneMsg app == null");
    }
    do
    {
      return;
      if (this.EV == null) {
        break;
      }
    } while (!QZLog.isColorLevel());
    QZLog.i("QZoneMsgManager", "msgEntity != null, not need preLoadQZoneMsg");
    return;
    avtu localavtu = new avtu(localQQAppInterface.getLongAccountUin(), "", lw(0), 1);
    localavtu.setType(0);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localQQAppInterface.getApplication(), afaf.class);
    localQzoneCommonIntent.setRequest(localavtu);
    localQzoneCommonIntent.setObserver(this);
    localQQAppInterface.startServlet(localQzoneCommonIntent);
  }
  
  public void eBW()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "refreshQZoneMsg()");
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "refreshQZoneMsg app == null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.1(this, localQQAppInterface));
  }
  
  /* Error */
  public ArrayList<QZoneMsgEntityNew> eC()
  {
    // Byte code:
    //   0: invokestatic 40	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 42
    //   8: ldc_w 274
    //   11: invokestatic 48	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 153	avto:EV	Ljava/util/ArrayList;
    //   18: ifnull +8 -> 26
    //   21: aload_0
    //   22: getfield 153	avto:EV	Ljava/util/ArrayList;
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 63	avto:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnonnull +13 -> 45
    //   35: ldc 42
    //   37: ldc_w 276
    //   40: invokestatic 68	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aconst_null
    //   44: areturn
    //   45: aload_2
    //   46: invokevirtual 279	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   49: invokevirtual 285	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   52: astore_2
    //   53: aload_2
    //   54: ldc 146
    //   56: iconst_0
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: ldc_w 287
    //   64: ldc_w 289
    //   67: invokevirtual 295	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   70: astore_3
    //   71: aload_0
    //   72: new 155	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 206	java/util/ArrayList:<init>	()V
    //   79: putfield 153	avto:EV	Ljava/util/ArrayList;
    //   82: aload_3
    //   83: ifnull +68 -> 151
    //   86: aload_3
    //   87: invokeinterface 298 1 0
    //   92: ifle +59 -> 151
    //   95: iconst_1
    //   96: istore_1
    //   97: iload_1
    //   98: aload_3
    //   99: invokeinterface 298 1 0
    //   104: if_icmpge +47 -> 151
    //   107: aload_3
    //   108: iload_1
    //   109: invokeinterface 299 2 0
    //   114: checkcast 146	cooperation/qzone/contentbox/model/QZoneMsgEntityNew
    //   117: astore 4
    //   119: aload 4
    //   121: ifnull +23 -> 144
    //   124: aload 4
    //   126: invokevirtual 302	cooperation/qzone/contentbox/model/QZoneMsgEntityNew:readArkNewsFromBuffer	()V
    //   129: aload 4
    //   131: invokevirtual 305	cooperation/qzone/contentbox/model/QZoneMsgEntityNew:readBottomItemsFromBuffer	()V
    //   134: aload_0
    //   135: getfield 153	avto:EV	Ljava/util/ArrayList;
    //   138: aload 4
    //   140: invokevirtual 209	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -51 -> 97
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   159: aload_0
    //   160: getfield 153	avto:EV	Ljava/util/ArrayList;
    //   163: areturn
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_2
    //   167: ldc 42
    //   169: iconst_1
    //   170: aload_3
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 311	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   178: aload_2
    //   179: ifnull -20 -> 159
    //   182: aload_2
    //   183: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   186: goto -27 -> 159
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   200: aload_3
    //   201: athrow
    //   202: astore_3
    //   203: goto -11 -> 192
    //   206: astore_3
    //   207: goto -15 -> 192
    //   210: astore_3
    //   211: goto -44 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	avto
    //   96	52	1	i	int
    //   30	167	2	localObject1	Object
    //   70	38	3	localList	java.util.List
    //   164	7	3	localThrowable1	java.lang.Throwable
    //   189	12	3	localObject2	Object
    //   202	1	3	localObject3	Object
    //   206	1	3	localObject4	Object
    //   210	1	3	localThrowable2	java.lang.Throwable
    //   117	22	4	localQZoneMsgEntityNew	QZoneMsgEntityNew
    // Exception table:
    //   from	to	target	type
    //   45	53	164	java/lang/Throwable
    //   45	53	189	finally
    //   53	82	202	finally
    //   86	95	202	finally
    //   97	119	202	finally
    //   124	144	202	finally
    //   167	178	206	finally
    //   53	82	210	java/lang/Throwable
    //   86	95	210	java/lang/Throwable
    //   97	119	210	java/lang/Throwable
    //   124	144	210	java/lang/Throwable
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef != null) {
      return (QQAppInterface)this.mAppRef.get();
    }
    return null;
  }
  
  public int lw(int paramInt)
  {
    if (this.cNH == null) {
      this.cNH = QzoneConfig.getInstance().getConfig("QZoneSetting", "contentbox_load_num", "1_1_1");
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(this.cNH))
    {
      arrayOfString = this.cNH.split("_");
      if (arrayOfString.length == 3) {
        break label55;
      }
    }
    label55:
    while (TextUtils.isEmpty(arrayOfString[paramInt])) {
      return 2;
    }
    try
    {
      paramInt = Integer.parseInt(arrayOfString[paramInt]);
      return paramInt;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager", "getLoadNum error", localException);
    }
    return 2;
  }
  
  public void onDestroy()
  {
    this.EV = null;
    this.traceInfo = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QZLog.e("QZoneMsgManager", "onReceive app == null");
    }
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localObject1 = (JceStruct)paramBundle.getSerializable("key_response");
      int i = paramBundle.getInt("key_response_code");
      localObject2 = paramBundle.getString("key_response_msg");
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), localObject2, paramBundle.toString() }));
      }
      if ((localObject1 instanceof QzoneMessageBoxRsp))
      {
        localObject1 = QZoneMsgEntityNew.readFrom((QzoneMessageBoxRsp)localObject1);
        if (localObject1 != null)
        {
          paramBundle.putSerializable("key_response", (Serializable)localObject1);
          localQQAppInterface.notifyObservers(avtp.class, paramInt, true, paramBundle);
          a((QZoneMsgEntityNew)localObject1, paramInt);
          return;
        }
        localQQAppInterface.notifyObservers(avtp.class, paramInt, false, paramBundle);
        QZLog.e("QZoneMsgManager", "onReceive entity == null");
        return;
      }
      if (!(localObject1 instanceof operation_like_rsp)) {
        break;
      }
    } while (((operation_like_rsp)localObject1).ret != 0);
    paramBoolean = paramBundle.getBoolean("like_key");
    long l = paramBundle.getLong("entity_pushtime");
    if ((l > 0L) && (this.EV != null))
    {
      localObject1 = this.EV.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QZoneMsgEntityNew)((Iterator)localObject1).next();
        if ((((QZoneMsgEntityNew)localObject2).pushTime == l) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec.size() > 0))
        {
          ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell.liked = paramBoolean;
          MQLikeCell localMQLikeCell;
          if (paramBoolean) {
            localMQLikeCell = ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell;
          }
          for (localMQLikeCell.totalLike += 1;; localMQLikeCell.totalLike -= 1)
          {
            a((QZoneMsgEntityNew)localObject2, paramInt);
            break;
            localMQLikeCell = ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell;
          }
        }
      }
    }
    localQQAppInterface.notifyObservers(avtp.class, paramInt, true, paramBundle);
    return;
    localQQAppInterface.notifyObservers(avtp.class, paramInt, false, paramBundle);
    QZLog.e("QZoneMsgManager", "onReceive jceStruct error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avto
 * JD-Core Version:    0.7.0.1
 */