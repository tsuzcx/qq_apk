import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class uoy
{
  private static uoy jdField_a_of_type_Uoy = new uoy();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Map<String, uoz> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, List<upb>> b = new HashMap();
  
  public static uoy a()
  {
    return jdField_a_of_type_Uoy;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new StoryVideoUploadProgressManager.1(this, paramString, paramInt));
    }
    for (;;)
    {
      return;
      wxe.a("StoryVideoUploadProgressManager", "notifyListeners, id:%s, progress:%s", paramString, Integer.valueOf(paramInt));
      Object localObject = (List)this.b.get(paramString);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          upa localupa = ((upb)((Iterator)localObject).next()).a();
          if (localupa != null) {
            localupa.a(paramString, paramInt);
          }
        }
      }
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    int j = 0;
    int i = 0;
    int k;
    if (localIterator.hasNext())
    {
      uoz localuoz = (uoz)localIterator.next();
      if (!localuoz.jdField_a_of_type_Boolean) {
        break label83;
      }
      k = localuoz.jdField_b_of_type_Int + j;
      j = i + 1;
      i = k;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if (i > 0) {
        return j / i;
      }
      return -1;
      label83:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public int a(String paramString)
  {
    paramString = (uoz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      uoz localuoz = (uoz)localIterator.next();
      if ((localuoz.jdField_b_of_type_JavaLangString != null) && (localuoz.jdField_b_of_type_JavaLangString.equals(paramString))) {
        return localuoz.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public void a()
  {
    try
    {
      wxe.b("StoryVideoUploadProgressManager", "startANewUploadSeq");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((uoz)((Map.Entry)localIterator.next()).getValue()).b();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    this.b.clear();
  }
  
  public void a(String paramString)
  {
    try
    {
      wxe.a("StoryVideoUploadProgressManager", "preparedSuccess:%s", paramString);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        uoz localuoz = (uoz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localuoz.jdField_a_of_type_Int = 1;
        localuoz.jdField_b_of_type_Int = 0;
        a(paramString, localuoz.jdField_b_of_type_Int);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      wxe.a("StoryVideoUploadProgressManager", "sendProtoSuccess:%s", paramString1);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1))
      {
        uoz localuoz = (uoz)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
        localuoz.jdField_a_of_type_Int = 4;
        localuoz.jdField_b_of_type_Int = 100;
        localuoz.jdField_b_of_type_JavaLangString = paramString2;
        a(paramString1, localuoz.jdField_b_of_type_Int);
        localuoz.b();
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString, upa paramupa)
  {
    wxe.a("StoryVideoUploadProgressManager", "registerListener, id:%s, listener:%s", paramString, paramupa.getClass().getSimpleName());
    Object localObject1 = null;
    Object localObject3 = this.b.entrySet().iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
      Object localObject4 = (String)((Map.Entry)localObject2).getKey();
      localObject4 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      label84:
      if (((Iterator)localObject4).hasNext())
      {
        localObject2 = (upb)((Iterator)localObject4).next();
        if (((upb)localObject2).a() != paramupa) {
          break label205;
        }
        ((Iterator)localObject4).remove();
        localObject1 = localObject2;
      }
    }
    label205:
    for (;;)
    {
      break label84;
      break;
      localObject3 = (List)this.b.get(paramString);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ArrayList();
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new upb(paramupa);
      }
      ((List)localObject2).add(localObject3);
      this.b.put(paramString, localObject2);
      return;
    }
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: ldc 211
    //   6: aload_1
    //   7: invokestatic 169	wxe:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   10: aload_0
    //   11: getfield 25	uoy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   14: aload_1
    //   15: invokeinterface 172 2 0
    //   20: ifeq +62 -> 82
    //   23: aload_0
    //   24: getfield 25	uoy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 84 2 0
    //   33: checkcast 120	uoz
    //   36: astore_3
    //   37: aload_3
    //   38: aload_1
    //   39: putfield 139	uoz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_3
    //   43: ldc 141
    //   45: putfield 131	uoz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   48: aload_3
    //   49: iload_2
    //   50: putfield 123	uoz:jdField_a_of_type_Boolean	Z
    //   53: aload_3
    //   54: iconst_0
    //   55: putfield 174	uoz:jdField_a_of_type_Int	I
    //   58: aload_3
    //   59: iconst_0
    //   60: putfield 126	uoz:jdField_b_of_type_Int	I
    //   63: aload_3
    //   64: invokevirtual 213	uoz:a	()V
    //   67: aload_0
    //   68: getfield 25	uoy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   71: aload_1
    //   72: aload_3
    //   73: invokeinterface 208 3 0
    //   78: pop
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: new 120	uoz
    //   85: dup
    //   86: aload_0
    //   87: aconst_null
    //   88: invokespecial 216	uoz:<init>	(Luoy;Lcom/tencent/biz/qqstory/base/videoupload/StoryVideoUploadProgressManager$1;)V
    //   91: astore_3
    //   92: goto -55 -> 37
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	uoy
    //   0	100	1	paramString	String
    //   0	100	2	paramBoolean	boolean
    //   36	56	3	localuoz	uoz
    // Exception table:
    //   from	to	target	type
    //   2	37	95	finally
    //   37	79	95	finally
    //   82	92	95	finally
  }
  
  public void a(upa paramupa)
  {
    wxe.a("StoryVideoUploadProgressManager", "unregisterListener, listener:%s", paramupa.getClass().getSimpleName());
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((upb)((Iterator)localObject).next()).a() == paramupa) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      wxe.a("StoryVideoUploadProgressManager", "mergeVideoSuccess:%s", paramString);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        uoz localuoz = (uoz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localuoz.jdField_a_of_type_Int = 2;
        localuoz.jdField_b_of_type_Int = 60;
        a(paramString, localuoz.jdField_b_of_type_Int);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      wxe.a("StoryVideoUploadProgressManager", "uploadVideoSuccess:%s", paramString);
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        uoz localuoz = (uoz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localuoz.jdField_a_of_type_Int = 3;
        localuoz.jdField_b_of_type_Int = 95;
        a(paramString, localuoz.jdField_b_of_type_Int);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        uoz localuoz = (uoz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localuoz.jdField_a_of_type_Int = 5;
        localuoz.jdField_b_of_type_Int = 100;
        a(paramString, localuoz.jdField_b_of_type_Int);
        localuoz.b();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uoy
 * JD-Core Version:    0.7.0.1
 */