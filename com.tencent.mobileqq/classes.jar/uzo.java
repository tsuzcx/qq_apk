import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

@Deprecated
public class uzo
  extends uzv
  implements Handler.Callback
{
  public volatile int a;
  protected Handler a;
  protected ErrorMessage a;
  private String a;
  protected LinkedHashMap<String, uzy> a;
  protected Vector<uzy> a;
  protected boolean a;
  private Handler b = new Handler(paramLooper, this);
  private Handler c;
  
  public uzo(Looper paramLooper)
  {
    this.jdField_a_of_type_JavaLangString = "ParallelStepExecutor";
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = 0;
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {
      ved.e("Q.qqstory.home.ParallelStepExecutor", "occur error ! step key is null!!");
    }
    do
    {
      return;
      ved.e("Q.qqstory.home.ParallelStepExecutor", "%s have been finish", new Object[] { paramString });
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
    } while (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() != 0);
    ved.b("Q.qqstory.home.ParallelStepExecutor", "all step have finish");
    if (this.jdField_a_of_type_Uzw != null)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      if (!this.jdField_a_of_type_Boolean) {
        break label99;
      }
      this.jdField_a_of_type_Uzx.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    }
    for (;;)
    {
      d();
      return;
      label99:
      this.jdField_a_of_type_Uzw.a();
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public uzo a(uzw paramuzw)
  {
    this.jdField_a_of_type_Uzw = paramuzw;
    return this;
  }
  
  public uzo a(uzx paramuzx)
  {
    this.jdField_a_of_type_Uzx = paramuzx;
    return this;
  }
  
  public uzo a(uzy paramuzy)
  {
    ved.a("Q.qqstory.home.ParallelStepExecutor", "add Step:%s", paramuzy.a());
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramuzy.a(), paramuzy);
    this.jdField_a_of_type_Int = 0;
    return this;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 61
    //   4: ldc 133
    //   6: iconst_1
    //   7: anewarray 73	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 33	uzo:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   16: invokevirtual 84	java/util/LinkedHashMap:size	()I
    //   19: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic 141	ved:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 52	uzo:jdField_a_of_type_Int	I
    //   30: iconst_2
    //   31: if_icmpne +13 -> 44
    //   34: ldc 61
    //   36: ldc 143
    //   38: invokestatic 69	ved:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 52	uzo:jdField_a_of_type_Int	I
    //   49: aload_0
    //   50: getfield 145	uzo:c	Landroid/os/Handler;
    //   53: ifnonnull +18 -> 71
    //   56: aload_0
    //   57: new 40	android/os/Handler
    //   60: dup
    //   61: invokestatic 148	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   64: aload_0
    //   65: invokespecial 55	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   68: putfield 145	uzo:c	Landroid/os/Handler;
    //   71: aload_0
    //   72: getfield 33	uzo:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   75: invokevirtual 152	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   78: invokeinterface 158 1 0
    //   83: astore_1
    //   84: aload_1
    //   85: invokeinterface 164 1 0
    //   90: ifeq -49 -> 41
    //   93: aload_1
    //   94: invokeinterface 168 1 0
    //   99: checkcast 170	java/util/Map$Entry
    //   102: invokeinterface 173 1 0
    //   107: checkcast 122	uzy
    //   110: astore_2
    //   111: aload_2
    //   112: aload_0
    //   113: invokeinterface 176 2 0
    //   118: aload_2
    //   119: aload_0
    //   120: invokeinterface 179 2 0
    //   125: aload_0
    //   126: getfield 57	uzo:b	Landroid/os/Handler;
    //   129: iconst_2
    //   130: aload_2
    //   131: invokevirtual 183	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   134: invokevirtual 188	android/os/Message:sendToTarget	()V
    //   137: goto -53 -> 84
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	uzo
    //   83	11	1	localIterator	Iterator
    //   140	4	1	localObject	Object
    //   110	21	2	localuzy	uzy
    // Exception table:
    //   from	to	target	type
    //   2	41	140	finally
    //   44	71	140	finally
    //   71	84	140	finally
    //   84	137	140	finally
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    ved.e("Q.qqstory.home.ParallelStepExecutor", "occur error:%s", new Object[] { paramErrorMessage.getErrorMessage() });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    a(paramErrorMessage.extraMsg);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_Int;
        if (i == 3) {
          return;
        }
        if (this.c != null)
        {
          this.c.obtainMessage(1, paramString).sendToTarget();
          continue;
        }
        ved.e("Q.qqstory.home.ParallelStepExecutor", "there is no mCompletedHandler !!!!");
      }
      finally {}
      b(paramString);
    }
  }
  
  public void b() {}
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      if (this.c != null) {
        this.c.removeMessages(1);
      }
      if (this.b != null) {
        this.b.removeMessages(2);
      }
      ved.b("Q.qqstory.home.ParallelStepExecutor", "reset!");
      if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
      {
        ved.b("Q.qqstory.home.ParallelStepExecutor", "reset premissSteps");
        ((uzy)this.jdField_a_of_type_JavaUtilVector.get(0)).c();
        this.jdField_a_of_type_JavaUtilVector.clear();
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        uzy localuzy = (uzy)((Map.Entry)localIterator.next()).getValue();
        if (localuzy != null) {
          localuzy.c();
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    finally {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b((String)paramMessage.obj);
      continue;
      ((uzy)paramMessage.obj).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzo
 * JD-Core Version:    0.7.0.1
 */