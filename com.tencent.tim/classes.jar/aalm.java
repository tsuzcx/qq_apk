import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class aalm
  implements Manager
{
  private Map<Integer, aalj> iG = new HashMap();
  private QQAppInterface mApp;
  
  public aalm(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public aalj a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	aalm:iG	Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 39 2 0
    //   15: ifeq +24 -> 39
    //   18: aload_0
    //   19: getfield 21	aalm:iG	Ljava/util/Map;
    //   22: iload_1
    //   23: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokeinterface 43 2 0
    //   31: checkcast 45	aalj
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: iload_1
    //   40: invokestatic 50	aaln:b	(I)Laalj;
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 21	aalm:iG	Ljava/util/Map;
    //   48: iload_1
    //   49: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aload_2
    //   53: invokeinterface 54 3 0
    //   58: pop
    //   59: goto -24 -> 35
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	aalm
    //   0	67	1	paramInt	int
    //   34	19	2	localaalj	aalj
    //   62	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	62	finally
    //   39	59	62	finally
  }
  
  public void onDestroy()
  {
    this.iG.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalm
 * JD-Core Version:    0.7.0.1
 */