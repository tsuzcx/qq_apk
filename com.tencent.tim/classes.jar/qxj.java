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
public class qxj
  extends qxn
  implements Handler.Callback
{
  protected LinkedHashMap<String, qxo> B = new LinkedHashMap();
  protected boolean aFX;
  protected Handler bj = new Handler(Looper.getMainLooper());
  private Handler bk;
  protected ErrorMessage i;
  protected Vector<qxo> m = new Vector();
  private String mKey = "ParallelStepExecutor";
  private Handler mWorkHandler = new Handler(paramLooper, this);
  public volatile int state = 0;
  
  public qxj(Looper paramLooper) {}
  
  private void sj(String paramString)
  {
    if (paramString == null) {
      ram.e("Q.qqstory.home.ParallelStepExecutor", "occur error ! step key is null!!");
    }
    do
    {
      return;
      ram.e("Q.qqstory.home.ParallelStepExecutor", "%s have been finish", new Object[] { paramString });
      this.B.remove(paramString);
    } while (this.B.size() != 0);
    ram.d("Q.qqstory.home.ParallelStepExecutor", "all step have finish");
    if (this.jdField_a_of_type_Qxn$a != null)
    {
      this.state = 2;
      this.bj.removeMessages(100);
      if (!this.aFX) {
        break label99;
      }
      this.jdField_a_of_type_Qxn$b.e(this.i);
    }
    for (;;)
    {
      completed();
      return;
      label99:
      this.jdField_a_of_type_Qxn$a.done();
    }
  }
  
  public qxj a(qxn.a parama)
  {
    this.jdField_a_of_type_Qxn$a = parama;
    return this;
  }
  
  public qxj a(qxn.b paramb)
  {
    this.jdField_a_of_type_Qxn$b = paramb;
    return this;
  }
  
  public qxj a(qxo paramqxo)
  {
    ram.b("Q.qqstory.home.ParallelStepExecutor", "add Step:%s", paramqxo.getKey());
    this.B.put(paramqxo.getKey(), paramqxo);
    this.state = 0;
    return this;
  }
  
  public void dump() {}
  
  public void e(ErrorMessage paramErrorMessage)
  {
    ram.e("Q.qqstory.home.ParallelStepExecutor", "occur error:%s", new Object[] { paramErrorMessage.getErrorMessage() });
    this.aFX = true;
    this.i = paramErrorMessage;
    si(paramErrorMessage.extraMsg);
  }
  
  public String getKey()
  {
    return this.mKey;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      sj((String)paramMessage.obj);
      continue;
      ((qxo)paramMessage.obj).run();
    }
  }
  
  public void reset()
  {
    try
    {
      this.state = 3;
      this.bj.removeMessages(100);
      if (this.bk != null) {
        this.bk.removeMessages(1);
      }
      if (this.mWorkHandler != null) {
        this.mWorkHandler.removeMessages(2);
      }
      ram.d("Q.qqstory.home.ParallelStepExecutor", "reset!");
      if (this.m.size() > 0)
      {
        ram.d("Q.qqstory.home.ParallelStepExecutor", "reset premissSteps");
        ((qxo)this.m.get(0)).reset();
        this.m.clear();
      }
      Iterator localIterator = this.B.entrySet().iterator();
      while (localIterator.hasNext())
      {
        qxo localqxo = (qxo)((Map.Entry)localIterator.next()).getValue();
        if (localqxo != null) {
          localqxo.reset();
        }
      }
      this.B.clear();
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 68
    //   4: ldc 220
    //   6: iconst_1
    //   7: anewarray 80	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 39	qxj:B	Ljava/util/LinkedHashMap;
    //   16: invokevirtual 91	java/util/LinkedHashMap:size	()I
    //   19: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic 229	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 58	qxj:state	I
    //   30: iconst_2
    //   31: if_icmpne +13 -> 44
    //   34: ldc 68
    //   36: ldc 231
    //   38: invokestatic 76	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 58	qxj:state	I
    //   49: aload_0
    //   50: getfield 178	qxj:bk	Landroid/os/Handler;
    //   53: ifnonnull +18 -> 71
    //   56: aload_0
    //   57: new 46	android/os/Handler
    //   60: dup
    //   61: invokestatic 234	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   64: aload_0
    //   65: invokespecial 61	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   68: putfield 178	qxj:bk	Landroid/os/Handler;
    //   71: aload_0
    //   72: getfield 39	qxj:B	Ljava/util/LinkedHashMap;
    //   75: invokevirtual 196	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   78: invokeinterface 202 1 0
    //   83: astore_1
    //   84: aload_1
    //   85: invokeinterface 208 1 0
    //   90: ifeq -49 -> 41
    //   93: aload_1
    //   94: invokeinterface 212 1 0
    //   99: checkcast 214	java/util/Map$Entry
    //   102: invokeinterface 217 1 0
    //   107: checkcast 131	qxo
    //   110: astore_2
    //   111: aload_2
    //   112: aload_0
    //   113: invokeinterface 237 2 0
    //   118: aload_2
    //   119: aload_0
    //   120: invokeinterface 240 2 0
    //   125: aload_0
    //   126: getfield 63	qxj:mWorkHandler	Landroid/os/Handler;
    //   129: iconst_2
    //   130: aload_2
    //   131: invokevirtual 244	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   134: invokevirtual 247	android/os/Message:sendToTarget	()V
    //   137: goto -53 -> 84
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	qxj
    //   83	11	1	localIterator	Iterator
    //   140	4	1	localObject	Object
    //   110	21	2	localqxo	qxo
    // Exception table:
    //   from	to	target	type
    //   2	41	140	finally
    //   44	71	140	finally
    //   71	84	140	finally
    //   84	137	140	finally
  }
  
  public void si(String paramString)
  {
    for (;;)
    {
      try
      {
        int j = this.state;
        if (j == 3) {
          return;
        }
        if (this.bk != null)
        {
          this.bk.obtainMessage(1, paramString).sendToTarget();
          continue;
        }
        ram.e("Q.qqstory.home.ParallelStepExecutor", "there is no mCompletedHandler !!!!");
      }
      finally {}
      sj(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxj
 * JD-Core Version:    0.7.0.1
 */