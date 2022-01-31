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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class uuq
  implements Manager
{
  public int a;
  public ArrayList<utx> a;
  uuc jdField_a_of_type_Uuc = new uuc(QQStoryContext.a(), this);
  uvh jdField_a_of_type_Uvh;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public uuq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static uuq a(QQAppInterface paramQQAppInterface)
  {
    return (uuq)paramQQAppInterface.getManager(251);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 54	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 57	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lawbx;
    //   6: invokevirtual 63	awbx:createEntityManager	()Lawbw;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 68	awbw:a	()Lawby;
    //   14: invokevirtual 72	awby:a	()V
    //   17: iload_1
    //   18: ifeq +26 -> 44
    //   21: new 74	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   24: dup
    //   25: invokespecial 75	com/tencent/biz/qqstory/database/MsgTabNodeEntity:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: sipush 1001
    //   33: invokevirtual 79	com/tencent/biz/qqstory/database/MsgTabNodeEntity:setStatus	(I)V
    //   36: aload_2
    //   37: aload_3
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 82	awbw:a	(Lawbv;Ljava/lang/String;[Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 86	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_0
    //   49: aload_0
    //   50: invokeinterface 92 1 0
    //   55: ifeq +55 -> 110
    //   58: aload_0
    //   59: invokeinterface 96 1 0
    //   64: checkcast 74	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 99	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   72: iconst_1
    //   73: if_icmpeq -24 -> 49
    //   76: aload_3
    //   77: getfield 99	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   80: iconst_2
    //   81: if_icmpeq -32 -> 49
    //   84: aload_2
    //   85: aload_3
    //   86: invokevirtual 102	awbw:b	(Lawbv;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 104
    //   95: aload_0
    //   96: invokestatic 109	xny:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 114	azlf:a	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 68	awbw:a	()Lawby;
    //   106: invokevirtual 116	awby:b	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 68	awbw:a	()Lawby;
    //   114: invokevirtual 118	awby:c	()V
    //   117: aload_2
    //   118: invokevirtual 68	awbw:a	()Lawby;
    //   121: invokevirtual 116	awby:b	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 68	awbw:a	()Lawby;
    //   130: invokevirtual 116	awby:b	()V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramArrayList	ArrayList<MsgTabNodeEntity>
    //   0	135	1	paramBoolean	boolean
    //   9	118	2	localawbw	awbw
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
  
  public static void a(utx paramutx, byte[] paramArrayOfByte)
  {
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramutx.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramutx.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramutx.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramutx.f;
    localawbw.b(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(utx paramutx)
  {
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramutx.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramutx.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localawbw.a(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramutx));
  }
  
  public static byte[] a(utx paramutx)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramutx), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramutx.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramutx.jdField_a_of_type_Int + ", unionId=" + paramutx.jdField_a_of_type_JavaLangString);
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
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramutx.jdField_a_of_type_Int + ", unionId=" + paramutx.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramutx.jdField_a_of_type_Int + ", unionId=" + paramutx.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(utx paramutx)
  {
    boolean bool2 = false;
    paramutx = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramutx), null, null, null, null, null);
    boolean bool1 = bool2;
    if (paramutx != null)
    {
      bool1 = bool2;
      if (paramutx.size() > 0)
      {
        paramutx = (MsgTabNodeRecommendActivityReadEntity)paramutx.get(0);
        bool1 = bool2;
        if (paramutx != null)
        {
          bool1 = bool2;
          if (paramutx.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void d(utx paramutx)
  {
    QQStoryContext.a().a().createEntityManager().b(new MsgTabNodeRecommendActivityReadEntity(paramutx, 1));
  }
  
  public ArrayList<utx> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeEntity.class);
    if (localObject == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeEntity localMsgTabNodeEntity = (MsgTabNodeEntity)((Iterator)localObject).next();
      utx localutx = new utx();
      if (localutx.jdField_a_of_type_Int != 12) {
        localutx.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localutx);
    }
    Collections.sort(localArrayList, new uty());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public utx a()
  {
    List localList = ((uro)urr.a(5)).a(false);
    utx localutx = new utx();
    localutx.jdField_a_of_type_Int = 5;
    localutx.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localutx.jdField_b_of_type_Long = QQStoryContext.a().a();
    localutx.jdField_d_of_type_Int = localList.size();
    localutx.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localutx.jdField_b_of_type_Boolean = false;
    localutx.jdField_b_of_type_Int = localList.size();
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
        str1 = wss.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = wss.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = wss.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        wsv.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = wss.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localutx.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localutx.h = str1;
        wsv.b("VASH", "getUnUploadInfo %s", String.valueOf(localutx));
        return localutx;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public utx a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Uuc.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        utx localutx = (utx)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localutx.jdField_a_of_type_JavaLangString)) {
          return localutx;
        }
      }
    }
    return null;
  }
  
  public uuc a()
  {
    return this.jdField_a_of_type_Uuc;
  }
  
  public uvh a()
  {
    if (this.jdField_a_of_type_Uvh == null) {}
    try
    {
      if (this.jdField_a_of_type_Uvh == null) {
        this.jdField_a_of_type_Uvh = new uvh();
      }
      return this.jdField_a_of_type_Uvh;
    }
    finally {}
  }
  
  public void a()
  {
    String str = xmq.a();
    wsv.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((urk)urr.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      xmh.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().b(paramMsgTabNodeEntity);
  }
  
  public void a(List<utx> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      utx localutx = (utx)((Iterator)localObject).next();
      if ((localutx.jdField_a_of_type_Int != 1) && (localutx.jdField_a_of_type_Int != 2)) {
        paramList.add(localutx.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public void a(utx paramutx)
  {
    paramutx = paramutx.a();
    if ((paramutx.nodeType == 1) || (paramutx.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramutx));
  }
  
  public boolean a()
  {
    uuc localuuc = a();
    wsv.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localuuc.g), Boolean.valueOf(localuuc.e), Boolean.valueOf(localuuc.f));
    return localuuc.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Uuc.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        utx localutx = (utx)((Iterator)localObject).next();
        if ((localutx.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localutx.jdField_a_of_type_JavaLangString))) {
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
      xmh.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    paramMsgTabNodeEntity.setStatus(1001);
    localawbw.a(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
    localawbw.b(paramMsgTabNodeEntity);
  }
  
  public void b(utx paramutx)
  {
    paramutx = paramutx.a();
    if ((paramutx.nodeType == 1) || (paramutx.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramutx));
  }
  
  public boolean b()
  {
    uuc localuuc = a();
    wsv.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localuuc.g), Boolean.valueOf(localuuc.e), Boolean.valueOf(localuuc.f));
    return localuuc.e;
  }
  
  public void c(utx paramutx)
  {
    this.jdField_a_of_type_Uuc.a(paramutx);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(xmq.a(), (String)((urk)urr.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      uuc localuuc = a();
      wsv.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localuuc.h));
      return localuuc.h;
    }
    wsv.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Uuc != null) {
      this.jdField_a_of_type_Uuc.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuq
 * JD-Core Version:    0.7.0.1
 */