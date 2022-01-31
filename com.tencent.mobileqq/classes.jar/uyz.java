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

public class uyz
  implements Manager
{
  public int a;
  public ArrayList<uyg> a;
  uyl jdField_a_of_type_Uyl = new uyl(QQStoryContext.a(), this);
  uzq jdField_a_of_type_Uzq;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public uyz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static uyz a(QQAppInterface paramQQAppInterface)
  {
    return (uyz)paramQQAppInterface.getManager(251);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 54	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 57	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lawgg;
    //   6: invokevirtual 63	awgg:createEntityManager	()Lawgf;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 68	awgf:a	()Lawgh;
    //   14: invokevirtual 72	awgh:a	()V
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
    //   40: invokevirtual 82	awgf:a	(Lawge;Ljava/lang/String;[Ljava/lang/String;)Z
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
    //   86: invokevirtual 102	awgf:b	(Lawge;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 104
    //   95: aload_0
    //   96: invokestatic 109	xsh:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 114	azpo:a	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 68	awgf:a	()Lawgh;
    //   106: invokevirtual 116	awgh:b	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 68	awgf:a	()Lawgh;
    //   114: invokevirtual 118	awgh:c	()V
    //   117: aload_2
    //   118: invokevirtual 68	awgf:a	()Lawgh;
    //   121: invokevirtual 116	awgh:b	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 68	awgf:a	()Lawgh;
    //   130: invokevirtual 116	awgh:b	()V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramArrayList	ArrayList<MsgTabNodeEntity>
    //   0	135	1	paramBoolean	boolean
    //   9	118	2	localawgf	awgf
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
  
  public static void a(uyg paramuyg, byte[] paramArrayOfByte)
  {
    awgf localawgf = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramuyg.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramuyg.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramuyg.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramuyg.f;
    localawgf.b(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(uyg paramuyg)
  {
    awgf localawgf = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramuyg.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramuyg.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localawgf.a(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramuyg));
  }
  
  public static byte[] a(uyg paramuyg)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramuyg), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramuyg.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramuyg.jdField_a_of_type_Int + ", unionId=" + paramuyg.jdField_a_of_type_JavaLangString);
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
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramuyg.jdField_a_of_type_Int + ", unionId=" + paramuyg.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramuyg.jdField_a_of_type_Int + ", unionId=" + paramuyg.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(uyg paramuyg)
  {
    boolean bool2 = false;
    paramuyg = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramuyg), null, null, null, null, null);
    boolean bool1 = bool2;
    if (paramuyg != null)
    {
      bool1 = bool2;
      if (paramuyg.size() > 0)
      {
        paramuyg = (MsgTabNodeRecommendActivityReadEntity)paramuyg.get(0);
        bool1 = bool2;
        if (paramuyg != null)
        {
          bool1 = bool2;
          if (paramuyg.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void d(uyg paramuyg)
  {
    QQStoryContext.a().a().createEntityManager().b(new MsgTabNodeRecommendActivityReadEntity(paramuyg, 1));
  }
  
  public ArrayList<uyg> a()
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
      uyg localuyg = new uyg();
      if (localuyg.jdField_a_of_type_Int != 12) {
        localuyg.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localuyg);
    }
    Collections.sort(localArrayList, new uyh());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public uyg a()
  {
    List localList = ((uvx)uwa.a(5)).a(false);
    uyg localuyg = new uyg();
    localuyg.jdField_a_of_type_Int = 5;
    localuyg.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localuyg.jdField_b_of_type_Long = QQStoryContext.a().a();
    localuyg.jdField_d_of_type_Int = localList.size();
    localuyg.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localuyg.jdField_b_of_type_Boolean = false;
    localuyg.jdField_b_of_type_Int = localList.size();
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
        str1 = wxb.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = wxb.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = wxb.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        wxe.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = wxb.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localuyg.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localuyg.h = str1;
        wxe.b("VASH", "getUnUploadInfo %s", String.valueOf(localuyg));
        return localuyg;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public uyg a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Uyl.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        uyg localuyg = (uyg)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localuyg.jdField_a_of_type_JavaLangString)) {
          return localuyg;
        }
      }
    }
    return null;
  }
  
  public uyl a()
  {
    return this.jdField_a_of_type_Uyl;
  }
  
  public uzq a()
  {
    if (this.jdField_a_of_type_Uzq == null) {}
    try
    {
      if (this.jdField_a_of_type_Uzq == null) {
        this.jdField_a_of_type_Uzq = new uzq();
      }
      return this.jdField_a_of_type_Uzq;
    }
    finally {}
  }
  
  public void a()
  {
    String str = xqz.a();
    wxe.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((uvt)uwa.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().b(paramMsgTabNodeEntity);
  }
  
  public void a(List<uyg> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      uyg localuyg = (uyg)((Iterator)localObject).next();
      if ((localuyg.jdField_a_of_type_Int != 1) && (localuyg.jdField_a_of_type_Int != 2)) {
        paramList.add(localuyg.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public void a(uyg paramuyg)
  {
    paramuyg = paramuyg.a();
    if ((paramuyg.nodeType == 1) || (paramuyg.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramuyg));
  }
  
  public boolean a()
  {
    uyl localuyl = a();
    wxe.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localuyl.g), Boolean.valueOf(localuyl.e), Boolean.valueOf(localuyl.f));
    return localuyl.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Uyl.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        uyg localuyg = (uyg)((Iterator)localObject).next();
        if ((localuyg.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localuyg.jdField_a_of_type_JavaLangString))) {
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
      xqq.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    awgf localawgf = QQStoryContext.a().a().createEntityManager();
    paramMsgTabNodeEntity.setStatus(1001);
    localawgf.a(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
    localawgf.b(paramMsgTabNodeEntity);
  }
  
  public void b(uyg paramuyg)
  {
    paramuyg = paramuyg.a();
    if ((paramuyg.nodeType == 1) || (paramuyg.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramuyg));
  }
  
  public boolean b()
  {
    uyl localuyl = a();
    wxe.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localuyl.g), Boolean.valueOf(localuyl.e), Boolean.valueOf(localuyl.f));
    return localuyl.e;
  }
  
  public void c(uyg paramuyg)
  {
    this.jdField_a_of_type_Uyl.a(paramuyg);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(xqz.a(), (String)((uvt)uwa.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      uyl localuyl = a();
      wxe.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localuyl.h));
      return localuyl.h;
    }
    wxe.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Uyl != null) {
      this.jdField_a_of_type_Uyl.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyz
 * JD-Core Version:    0.7.0.1
 */