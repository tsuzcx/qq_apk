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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class wmr
  implements Manager
{
  public int a;
  public ArrayList<wly> a;
  wmd jdField_a_of_type_Wmd = new wmd(QQStoryContext.a(), this);
  wni jdField_a_of_type_Wni;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public wmr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static wmr a(QQAppInterface paramQQAppInterface)
  {
    return (wmr)paramQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 59	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 62	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   6: invokevirtual 68	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: invokevirtual 79	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   17: iload_1
    //   18: ifeq +26 -> 44
    //   21: new 81	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   24: dup
    //   25: invokespecial 82	com/tencent/biz/qqstory/database/MsgTabNodeEntity:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: sipush 1001
    //   33: invokevirtual 86	com/tencent/biz/qqstory/database/MsgTabNodeEntity:setStatus	(I)V
    //   36: aload_2
    //   37: aload_3
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 90	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 94	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_0
    //   49: aload_0
    //   50: invokeinterface 100 1 0
    //   55: ifeq +55 -> 110
    //   58: aload_0
    //   59: invokeinterface 104 1 0
    //   64: checkcast 81	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 107	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   72: iconst_1
    //   73: if_icmpeq -24 -> 49
    //   76: aload_3
    //   77: getfield 107	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   80: iconst_2
    //   81: if_icmpeq -32 -> 49
    //   84: aload_2
    //   85: aload_3
    //   86: invokevirtual 111	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 113
    //   95: aload_0
    //   96: invokestatic 118	zfc:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 123	bdjw:a	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   106: invokevirtual 126	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   114: invokevirtual 129	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   117: aload_2
    //   118: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   121: invokevirtual 126	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   130: invokevirtual 126	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
  
  public static void a(wly paramwly, byte[] paramArrayOfByte)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramwly.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramwly.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramwly.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramwly.f;
    localEntityManager.persistOrReplace(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(wly paramwly)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramwly.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramwly.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localEntityManager.remove(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramwly));
  }
  
  public static byte[] a(wly paramwly)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramwly), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramwly.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramwly.jdField_a_of_type_Int + ", unionId=" + paramwly.jdField_a_of_type_JavaLangString);
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
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramwly.jdField_a_of_type_Int + ", unionId=" + paramwly.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramwly.jdField_a_of_type_Int + ", unionId=" + paramwly.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(wly paramwly)
  {
    boolean bool2 = false;
    paramwly = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramwly), null, null, null, null, null);
    boolean bool1 = bool2;
    if (paramwly != null)
    {
      bool1 = bool2;
      if (paramwly.size() > 0)
      {
        paramwly = (MsgTabNodeRecommendActivityReadEntity)paramwly.get(0);
        bool1 = bool2;
        if (paramwly != null)
        {
          bool1 = bool2;
          if (paramwly.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void d(wly paramwly)
  {
    QQStoryContext.a().a().createEntityManager().persistOrReplace(new MsgTabNodeRecommendActivityReadEntity(paramwly, 1));
  }
  
  public ArrayList<wly> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeEntity.class);
    if (localObject == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeEntity localMsgTabNodeEntity = (MsgTabNodeEntity)((Iterator)localObject).next();
      wly localwly = new wly();
      if (localwly.jdField_a_of_type_Int != 12) {
        localwly.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localwly);
    }
    Collections.sort(localArrayList, new wlz());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public wly a()
  {
    List localList = ((wjp)wjs.a(5)).a(false);
    wly localwly = new wly();
    localwly.jdField_a_of_type_Int = 5;
    localwly.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localwly.jdField_b_of_type_Long = QQStoryContext.a().a();
    localwly.jdField_d_of_type_Int = localList.size();
    localwly.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localwly.jdField_b_of_type_Boolean = false;
    localwly.jdField_b_of_type_Int = localList.size();
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
        str1 = ykn.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = ykn.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = ykn.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        ykq.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = ykn.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localwly.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localwly.h = str1;
        ykq.b("VASH", "getUnUploadInfo %s", String.valueOf(localwly));
        return localwly;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public wly a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Wmd.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        wly localwly = (wly)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localwly.jdField_a_of_type_JavaLangString)) {
          return localwly;
        }
      }
    }
    return null;
  }
  
  public wmd a()
  {
    return this.jdField_a_of_type_Wmd;
  }
  
  public wni a()
  {
    if (this.jdField_a_of_type_Wni == null) {}
    try
    {
      if (this.jdField_a_of_type_Wni == null) {
        this.jdField_a_of_type_Wni = new wni();
      }
      return this.jdField_a_of_type_Wni;
    }
    finally {}
  }
  
  public void a()
  {
    String str = zdu.a();
    ykq.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((wjl)wjs.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().persistOrReplace(paramMsgTabNodeEntity);
  }
  
  public void a(List<wly> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      wly localwly = (wly)((Iterator)localObject).next();
      if ((localwly.jdField_a_of_type_Int != 1) && (localwly.jdField_a_of_type_Int != 2)) {
        paramList.add(localwly.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public void a(wly paramwly)
  {
    paramwly = paramwly.a();
    if ((paramwly.nodeType == 1) || (paramwly.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramwly));
  }
  
  public boolean a()
  {
    wmd localwmd = a();
    ykq.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localwmd.g), Boolean.valueOf(localwmd.e), Boolean.valueOf(localwmd.f));
    return localwmd.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Wmd.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        wly localwly = (wly)((Iterator)localObject).next();
        if ((localwly.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localwly.jdField_a_of_type_JavaLangString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramMsgTabNodeEntity.setStatus(1001);
    localEntityManager.remove(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
    localEntityManager.remove(paramMsgTabNodeEntity);
  }
  
  public void b(wly paramwly)
  {
    paramwly = paramwly.a();
    if ((paramwly.nodeType == 1) || (paramwly.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramwly));
  }
  
  public boolean b()
  {
    wmd localwmd = a();
    ykq.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localwmd.g), Boolean.valueOf(localwmd.e), Boolean.valueOf(localwmd.f));
    return localwmd.e;
  }
  
  public void c(wly paramwly)
  {
    this.jdField_a_of_type_Wmd.a(paramwly);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(zdu.a(), (String)((wjl)wjs.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      wmd localwmd = a();
      ykq.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localwmd.h));
      return localwmd.h;
    }
    ykq.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Wmd != null) {
      this.jdField_a_of_type_Wmd.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmr
 * JD-Core Version:    0.7.0.1
 */