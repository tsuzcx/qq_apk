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

public class wsl
  implements Manager
{
  public int a;
  public ArrayList<wrs> a;
  wrx jdField_a_of_type_Wrx = new wrx(QQStoryContext.a(), this);
  wtc jdField_a_of_type_Wtc;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public wsl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static wsl a(QQAppInterface paramQQAppInterface)
  {
    return (wsl)paramQQAppInterface.getManager(251);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 54	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 57	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   6: invokevirtual 63	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 69	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: invokevirtual 74	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   17: iload_1
    //   18: ifeq +26 -> 44
    //   21: new 76	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   24: dup
    //   25: invokespecial 77	com/tencent/biz/qqstory/database/MsgTabNodeEntity:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: sipush 1001
    //   33: invokevirtual 81	com/tencent/biz/qqstory/database/MsgTabNodeEntity:setStatus	(I)V
    //   36: aload_2
    //   37: aload_3
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 85	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 89	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_0
    //   49: aload_0
    //   50: invokeinterface 95 1 0
    //   55: ifeq +55 -> 110
    //   58: aload_0
    //   59: invokeinterface 99 1 0
    //   64: checkcast 76	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 102	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   72: iconst_1
    //   73: if_icmpeq -24 -> 49
    //   76: aload_3
    //   77: getfield 102	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   80: iconst_2
    //   81: if_icmpeq -32 -> 49
    //   84: aload_2
    //   85: aload_3
    //   86: invokevirtual 106	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 108
    //   95: aload_0
    //   96: invokestatic 113	zls:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 118	bcrp:a	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 69	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   106: invokevirtual 121	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 69	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   114: invokevirtual 124	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   117: aload_2
    //   118: invokevirtual 69	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   121: invokevirtual 121	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 69	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   130: invokevirtual 121	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
  
  public static void a(wrs paramwrs, byte[] paramArrayOfByte)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramwrs.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramwrs.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramwrs.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramwrs.f;
    localEntityManager.persistOrReplace(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(wrs paramwrs)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramwrs.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramwrs.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localEntityManager.remove(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramwrs));
  }
  
  public static byte[] a(wrs paramwrs)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramwrs), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramwrs.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramwrs.jdField_a_of_type_Int + ", unionId=" + paramwrs.jdField_a_of_type_JavaLangString);
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
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramwrs.jdField_a_of_type_Int + ", unionId=" + paramwrs.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramwrs.jdField_a_of_type_Int + ", unionId=" + paramwrs.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(wrs paramwrs)
  {
    boolean bool2 = false;
    paramwrs = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramwrs), null, null, null, null, null);
    boolean bool1 = bool2;
    if (paramwrs != null)
    {
      bool1 = bool2;
      if (paramwrs.size() > 0)
      {
        paramwrs = (MsgTabNodeRecommendActivityReadEntity)paramwrs.get(0);
        bool1 = bool2;
        if (paramwrs != null)
        {
          bool1 = bool2;
          if (paramwrs.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void d(wrs paramwrs)
  {
    QQStoryContext.a().a().createEntityManager().persistOrReplace(new MsgTabNodeRecommendActivityReadEntity(paramwrs, 1));
  }
  
  public ArrayList<wrs> a()
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
      wrs localwrs = new wrs();
      if (localwrs.jdField_a_of_type_Int != 12) {
        localwrs.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localwrs);
    }
    Collections.sort(localArrayList, new wrt());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public wrs a()
  {
    List localList = ((wpj)wpm.a(5)).a(false);
    wrs localwrs = new wrs();
    localwrs.jdField_a_of_type_Int = 5;
    localwrs.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localwrs.jdField_b_of_type_Long = QQStoryContext.a().a();
    localwrs.jdField_d_of_type_Int = localList.size();
    localwrs.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localwrs.jdField_b_of_type_Boolean = false;
    localwrs.jdField_b_of_type_Int = localList.size();
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
        str1 = yqm.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = yqm.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = yqm.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        yqp.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = yqm.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localwrs.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localwrs.h = str1;
        yqp.b("VASH", "getUnUploadInfo %s", String.valueOf(localwrs));
        return localwrs;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public wrs a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Wrx.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        wrs localwrs = (wrs)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localwrs.jdField_a_of_type_JavaLangString)) {
          return localwrs;
        }
      }
    }
    return null;
  }
  
  public wrx a()
  {
    return this.jdField_a_of_type_Wrx;
  }
  
  public wtc a()
  {
    if (this.jdField_a_of_type_Wtc == null) {}
    try
    {
      if (this.jdField_a_of_type_Wtc == null) {
        this.jdField_a_of_type_Wtc = new wtc();
      }
      return this.jdField_a_of_type_Wtc;
    }
    finally {}
  }
  
  public void a()
  {
    String str = zkk.a();
    yqp.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((wpf)wpm.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zkb.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().persistOrReplace(paramMsgTabNodeEntity);
  }
  
  public void a(List<wrs> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      wrs localwrs = (wrs)((Iterator)localObject).next();
      if ((localwrs.jdField_a_of_type_Int != 1) && (localwrs.jdField_a_of_type_Int != 2)) {
        paramList.add(localwrs.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public void a(wrs paramwrs)
  {
    paramwrs = paramwrs.a();
    if ((paramwrs.nodeType == 1) || (paramwrs.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramwrs));
  }
  
  public boolean a()
  {
    wrx localwrx = a();
    yqp.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localwrx.g), Boolean.valueOf(localwrx.e), Boolean.valueOf(localwrx.f));
    return localwrx.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Wrx.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        wrs localwrs = (wrs)((Iterator)localObject).next();
        if ((localwrs.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localwrs.jdField_a_of_type_JavaLangString))) {
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
      zkb.a(bool);
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
  
  public void b(wrs paramwrs)
  {
    paramwrs = paramwrs.a();
    if ((paramwrs.nodeType == 1) || (paramwrs.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramwrs));
  }
  
  public boolean b()
  {
    wrx localwrx = a();
    yqp.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localwrx.g), Boolean.valueOf(localwrx.e), Boolean.valueOf(localwrx.f));
    return localwrx.e;
  }
  
  public void c(wrs paramwrs)
  {
    this.jdField_a_of_type_Wrx.a(paramwrs);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(zkk.a(), (String)((wpf)wpm.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      wrx localwrx = a();
      yqp.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localwrx.h));
      return localwrx.h;
    }
    yqp.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Wrx != null) {
      this.jdField_a_of_type_Wrx.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsl
 * JD-Core Version:    0.7.0.1
 */