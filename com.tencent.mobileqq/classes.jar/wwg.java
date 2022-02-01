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

public class wwg
  implements Manager
{
  public int a;
  public ArrayList<wvn> a;
  wvs jdField_a_of_type_Wvs = new wvs(QQStoryContext.a(), this);
  wwx jdField_a_of_type_Wwx;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public wwg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static wwg a(QQAppInterface paramQQAppInterface)
  {
    return (wwg)paramQQAppInterface.getManager(251);
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
    //   96: invokestatic 113	zpn:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 118	bdkh:a	(Ljava/lang/Throwable;)V
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
  
  public static void a(wvn paramwvn, byte[] paramArrayOfByte)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramwvn.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramwvn.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramwvn.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramwvn.f;
    localEntityManager.persistOrReplace(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(wvn paramwvn)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramwvn.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramwvn.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localEntityManager.remove(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramwvn));
  }
  
  public static byte[] a(wvn paramwvn)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramwvn), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramwvn.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramwvn.jdField_a_of_type_Int + ", unionId=" + paramwvn.jdField_a_of_type_JavaLangString);
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
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramwvn.jdField_a_of_type_Int + ", unionId=" + paramwvn.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramwvn.jdField_a_of_type_Int + ", unionId=" + paramwvn.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(wvn paramwvn)
  {
    boolean bool2 = false;
    paramwvn = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramwvn), null, null, null, null, null);
    boolean bool1 = bool2;
    if (paramwvn != null)
    {
      bool1 = bool2;
      if (paramwvn.size() > 0)
      {
        paramwvn = (MsgTabNodeRecommendActivityReadEntity)paramwvn.get(0);
        bool1 = bool2;
        if (paramwvn != null)
        {
          bool1 = bool2;
          if (paramwvn.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void d(wvn paramwvn)
  {
    QQStoryContext.a().a().createEntityManager().persistOrReplace(new MsgTabNodeRecommendActivityReadEntity(paramwvn, 1));
  }
  
  public ArrayList<wvn> a()
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
      wvn localwvn = new wvn();
      if (localwvn.jdField_a_of_type_Int != 12) {
        localwvn.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localwvn);
    }
    Collections.sort(localArrayList, new wvo());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public wvn a()
  {
    List localList = ((wte)wth.a(5)).a(false);
    wvn localwvn = new wvn();
    localwvn.jdField_a_of_type_Int = 5;
    localwvn.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localwvn.jdField_b_of_type_Long = QQStoryContext.a().a();
    localwvn.jdField_d_of_type_Int = localList.size();
    localwvn.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localwvn.jdField_b_of_type_Boolean = false;
    localwvn.jdField_b_of_type_Int = localList.size();
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
        str1 = yuh.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = yuh.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = yuh.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        yuk.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = yuh.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localwvn.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localwvn.h = str1;
        yuk.b("VASH", "getUnUploadInfo %s", String.valueOf(localwvn));
        return localwvn;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public wvn a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Wvs.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        wvn localwvn = (wvn)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localwvn.jdField_a_of_type_JavaLangString)) {
          return localwvn;
        }
      }
    }
    return null;
  }
  
  public wvs a()
  {
    return this.jdField_a_of_type_Wvs;
  }
  
  public wwx a()
  {
    if (this.jdField_a_of_type_Wwx == null) {}
    try
    {
      if (this.jdField_a_of_type_Wwx == null) {
        this.jdField_a_of_type_Wwx = new wwx();
      }
      return this.jdField_a_of_type_Wwx;
    }
    finally {}
  }
  
  public void a()
  {
    String str = zof.a();
    yuk.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((wta)wth.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      znw.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().persistOrReplace(paramMsgTabNodeEntity);
  }
  
  public void a(List<wvn> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      wvn localwvn = (wvn)((Iterator)localObject).next();
      if ((localwvn.jdField_a_of_type_Int != 1) && (localwvn.jdField_a_of_type_Int != 2)) {
        paramList.add(localwvn.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public void a(wvn paramwvn)
  {
    paramwvn = paramwvn.a();
    if ((paramwvn.nodeType == 1) || (paramwvn.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramwvn));
  }
  
  public boolean a()
  {
    wvs localwvs = a();
    yuk.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localwvs.g), Boolean.valueOf(localwvs.e), Boolean.valueOf(localwvs.f));
    return localwvs.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Wvs.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        wvn localwvn = (wvn)((Iterator)localObject).next();
        if ((localwvn.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localwvn.jdField_a_of_type_JavaLangString))) {
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
      znw.a(bool);
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
  
  public void b(wvn paramwvn)
  {
    paramwvn = paramwvn.a();
    if ((paramwvn.nodeType == 1) || (paramwvn.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramwvn));
  }
  
  public boolean b()
  {
    wvs localwvs = a();
    yuk.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localwvs.g), Boolean.valueOf(localwvs.e), Boolean.valueOf(localwvs.f));
    return localwvs.e;
  }
  
  public void c(wvn paramwvn)
  {
    this.jdField_a_of_type_Wvs.a(paramwvn);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(zof.a(), (String)((wta)wth.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      wvs localwvs = a();
      yuk.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localwvs.h));
      return localwvs.h;
    }
    yuk.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Wvs != null) {
      this.jdField_a_of_type_Wvs.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwg
 * JD-Core Version:    0.7.0.1
 */