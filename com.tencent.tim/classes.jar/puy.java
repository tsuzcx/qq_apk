import android.os.Looper;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.MsgTabNodeEntity;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager.1;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager.2;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class puy
  implements Manager
{
  pum jdField_a_of_type_Pum = new pum(QQStoryContext.a(), this);
  pvi jdField_a_of_type_Pvi;
  public int bkA;
  public int bkB;
  public int bkC;
  public int bkD;
  public int bkx;
  public int bky;
  public int bkz;
  public ArrayList<puh> mJ = new ArrayList();
  
  public puy(QQAppInterface paramQQAppInterface) {}
  
  public static puy a(QQAppInterface paramQQAppInterface)
  {
    return (puy)paramQQAppInterface.getManager(251);
  }
  
  public static void a(puh parampuh, byte[] paramArrayOfByte)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = parampuh.nodeType;
    localMsgTabNodeVidListEntity.unionId = parampuh.unionId;
    localMsgTabNodeVidListEntity.reqTimeStamp = parampuh.reqTimeStamp;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = parampuh.source;
    localEntityManager.persistOrReplace(localMsgTabNodeVidListEntity);
  }
  
  public static byte[] a(puh parampuh)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().getEntityManagerFactory().createEntityManager().query(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(parampuh), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == parampuh.reqTimeStamp)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + parampuh.nodeType + ", unionId=" + parampuh.unionId);
        }
        arrayOfByte = ((MsgTabNodeVidListEntity)localObject).rspData;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return arrayOfByte;
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + parampuh.nodeType + ", unionId=" + parampuh.unionId);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + parampuh.nodeType + ", unionId=" + parampuh.unionId);
    return null;
  }
  
  public static boolean g(puh parampuh)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = parampuh.nodeType;
    localMsgTabNodeVidListEntity.unionId = parampuh.unionId;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localEntityManager.remove(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(parampuh));
  }
  
  public static final boolean h(puh parampuh)
  {
    boolean bool2 = false;
    parampuh = QQStoryContext.a().getEntityManagerFactory().createEntityManager().query(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(parampuh), null, null, null, null, null);
    boolean bool1 = bool2;
    if (parampuh != null)
    {
      bool1 = bool2;
      if (parampuh.size() > 0)
      {
        parampuh = (MsgTabNodeRecommendActivityReadEntity)parampuh.get(0);
        bool1 = bool2;
        if (parampuh != null)
        {
          bool1 = bool2;
          if (parampuh.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void m(puh parampuh)
  {
    QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace(new MsgTabNodeRecommendActivityReadEntity(parampuh, 1));
  }
  
  /* Error */
  public static void q(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 54	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 58	com/tencent/biz/qqstory/app/QQStoryContext:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   6: invokevirtual 64	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 193	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: invokevirtual 198	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   17: iload_1
    //   18: ifeq +26 -> 44
    //   21: new 200	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   24: dup
    //   25: invokespecial 201	com/tencent/biz/qqstory/database/MsgTabNodeEntity:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: sipush 1001
    //   33: invokevirtual 202	com/tencent/biz/qqstory/database/MsgTabNodeEntity:setStatus	(I)V
    //   36: aload_2
    //   37: aload_3
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 172	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 206	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_0
    //   49: aload_0
    //   50: invokeinterface 211 1 0
    //   55: ifeq +55 -> 110
    //   58: aload_0
    //   59: invokeinterface 215 1 0
    //   64: checkcast 200	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 216	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   72: iconst_1
    //   73: if_icmpeq -24 -> 49
    //   76: aload_3
    //   77: getfield 216	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   80: iconst_2
    //   81: if_icmpeq -32 -> 49
    //   84: aload_2
    //   85: aload_3
    //   86: invokevirtual 99	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 218
    //   95: aload_0
    //   96: invokestatic 224	rpl$a:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 230	annt:e	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 193	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   106: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 193	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   114: invokevirtual 236	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   117: aload_2
    //   118: invokevirtual 193	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   121: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 193	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   130: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramArrayList	ArrayList<MsgTabNodeEntity>
    //   0	135	1	paramBoolean	boolean
    //   9	118	2	localEntityManager	EntityManager
    //   28	58	3	localMsgTabNodeEntity	MsgTabNodeEntity
    // Exception table:
    //   from	to	target	type
    //   21	44	92	java/lang/NullPointerException
    //   44	49	92	java/lang/NullPointerException
    //   49	89	92	java/lang/NullPointerException
    //   110	117	92	java/lang/NullPointerException
    //   21	44	125	finally
    //   44	49	125	finally
    //   49	89	125	finally
    //   93	102	125	finally
    //   110	117	125	finally
  }
  
  public void A(List<puh> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      puh localpuh = (puh)((Iterator)localObject).next();
      if ((localpuh.nodeType != 1) && (localpuh.nodeType != 2)) {
        paramList.add(localpuh.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public boolean Jc()
  {
    pum localpum = a();
    ram.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localpum.mHasRedPoint), Boolean.valueOf(localpum.aBK), Boolean.valueOf(localpum.aBL));
    return localpum.mHasRedPoint;
  }
  
  public boolean Jd()
  {
    pum localpum = a();
    ram.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localpum.mHasRedPoint), Boolean.valueOf(localpum.aBK), Boolean.valueOf(localpum.aBL));
    return localpum.aBK;
  }
  
  public boolean Je()
  {
    if (!TextUtils.equals(roq.getDateString(), (String)((psr)psx.a(10)).c("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      pum localpum = a();
      ram.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localpum.aBM));
      return localpum.aBM;
    }
    ram.d("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public puh a()
  {
    List localList = ((psu)psx.a(5)).g(false);
    puh localpuh = new puh();
    localpuh.nodeType = 5;
    localpuh.unionId = QQStoryContext.a().getCurrentUid();
    localpuh.uid = QQStoryContext.a().dE();
    localpuh.bkt = localList.size();
    localpuh.nodeInfoTimeStamp = (System.currentTimeMillis() / 1000L);
    localpuh.isUploading = false;
    localpuh.unreadCount = localList.size();
    int i = 0;
    String str2 = "";
    boolean bool = false;
    String str1 = "";
    StoryVideoItem localStoryVideoItem;
    if (i < localList.size())
    {
      localStoryVideoItem = (StoryVideoItem)localList.get(i);
      if (!localStoryVideoItem.isUploading()) {
        break label288;
      }
      bool = true;
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        str1 = raj.a.gb(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = raj.a.gb(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = raj.a.gb(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        ram.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = raj.a.gb(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localpuh.isUploading = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localpuh.avv = str1;
        ram.d("VASH", "getUnUploadInfo %s", String.valueOf(localpuh));
        return localpuh;
        str1 = str2;
      }
    }
  }
  
  public pum a()
  {
    return this.jdField_a_of_type_Pum;
  }
  
  public pvi a()
  {
    if (this.jdField_a_of_type_Pvi == null) {}
    try
    {
      if (this.jdField_a_of_type_Pvi == null) {
        this.jdField_a_of_type_Pvi = new pvi();
      }
      return this.jdField_a_of_type_Pvi;
    }
    finally {}
  }
  
  public void b(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace(paramMsgTabNodeEntity);
  }
  
  public void bmR()
  {
    String str = roq.getDateString();
    ram.b("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((psr)psx.a(10)).n("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public ArrayList<puh> bs()
  {
    Object localObject = QQStoryContext.a().getEntityManagerFactory().createEntityManager().query(MsgTabNodeEntity.class);
    if (localObject == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeEntity localMsgTabNodeEntity = (MsgTabNodeEntity)((Iterator)localObject).next();
      puh localpuh = new puh();
      if (localpuh.nodeType != 12) {
        localpuh.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localpuh);
    }
    Collections.sort(localArrayList, new pui());
    this.mJ = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public void c(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    paramMsgTabNodeEntity.setStatus(1001);
    localEntityManager.remove(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
    localEntityManager.remove(paramMsgTabNodeEntity);
  }
  
  @UiThread
  public puh d(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Pum.mG;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        puh localpuh = (puh)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localpuh.unionId)) {
          return localpuh;
        }
      }
    }
    return null;
  }
  
  @UiThread
  public boolean fh(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Pum.mG;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        puh localpuh = (puh)((Iterator)localObject).next();
        if ((localpuh.nodeType == 12) && (TextUtils.equals(paramString, localpuh.unionId))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void j(puh parampuh)
  {
    parampuh = parampuh.a();
    if ((parampuh.nodeType == 1) || (parampuh.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, parampuh));
  }
  
  public void k(puh parampuh)
  {
    parampuh = parampuh.a();
    if ((parampuh.nodeType == 1) || (parampuh.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, parampuh));
  }
  
  public void l(puh parampuh)
  {
    this.jdField_a_of_type_Pum.g(parampuh);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Pum != null) {
      this.jdField_a_of_type_Pum.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puy
 * JD-Core Version:    0.7.0.1
 */