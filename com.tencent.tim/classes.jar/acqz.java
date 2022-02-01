import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class acqz
{
  private static Random sRandom = new Random();
  private static List<acqz.a> xY = new ArrayList(32);
  
  public static void ad(String paramString, long paramLong)
  {
    if (Math.abs(sRandom.nextInt() % 10000) < 10)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString, true, paramLong, 0L, localHashMap, "");
    }
  }
  
  public static void cNY()
  {
    synchronized (xY)
    {
      Iterator localIterator = xY.iterator();
      if (localIterator.hasNext())
      {
        acqz.a locala = (acqz.a)localIterator.next();
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", String.valueOf(locala.czj));
        localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        localHashMap.put("msgType", String.valueOf(locala.msgType));
        localHashMap.put("uinType", String.valueOf(locala.uinType));
        anpc.a(BaseApplication.getContext()).collectPerformance(locala.uin, "actBelatedMsg", false, locala.delay, 0L, localHashMap, "");
      }
    }
    acqz.a.bz(xY);
    xY.clear();
  }
  
  public static void e(MessageRecord arg0, QQAppInterface paramQQAppInterface)
  {
    if (!paramQQAppInterface.getCurrentUin().endsWith("77")) {}
    long l;
    do
    {
      return;
      l = NetConnInfoCenter.getServerTime() - ???.time;
    } while ((l < 30L) || ((paramQQAppInterface.QE != 0L) && (???.time < paramQQAppInterface.QE)));
    if (???.time < paramQQAppInterface.QD) {}
    for (int i = 1;; i = 2)
    {
      paramQQAppInterface = acqz.a.a(i, paramQQAppInterface.getCurrentUin(), l, ???.msgtype, ???.istroop);
      synchronized (xY)
      {
        xY.add(paramQQAppInterface);
        if (xY.size() >= 32) {
          cNY();
        }
        return;
      }
    }
  }
  
  public static void p(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (!paramQQAppInterface.getCurrentUin().endsWith("7")) {
      return;
    }
    paramQQAppInterface = new HashMap();
    paramQQAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
    paramQQAppInterface.put("uinType", String.valueOf(paramInt));
    paramQQAppInterface.put("convUin", String.valueOf(paramString));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actNoCachedLastMsg", true, 0L, 0L, paramQQAppInterface, "");
  }
  
  public static class a
  {
    private static LinkedList<a> P = new LinkedList();
    int czj;
    long delay;
    int msgType;
    String uin;
    int uinType;
    
    /* Error */
    public static a a(int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: getstatic 27	acqz$a:P	Ljava/util/LinkedList;
      //   6: invokevirtual 34	java/util/LinkedList:size	()I
      //   9: ifle +53 -> 62
      //   12: getstatic 27	acqz$a:P	Ljava/util/LinkedList;
      //   15: iconst_0
      //   16: invokevirtual 38	java/util/LinkedList:remove	(I)Ljava/lang/Object;
      //   19: checkcast 2	acqz$a
      //   22: astore 6
      //   24: aload 6
      //   26: iload_0
      //   27: putfield 40	acqz$a:czj	I
      //   30: aload 6
      //   32: aload_1
      //   33: putfield 42	acqz$a:uin	Ljava/lang/String;
      //   36: aload 6
      //   38: lload_2
      //   39: putfield 44	acqz$a:delay	J
      //   42: aload 6
      //   44: iload 4
      //   46: putfield 46	acqz$a:msgType	I
      //   49: aload 6
      //   51: iload 5
      //   53: putfield 48	acqz$a:uinType	I
      //   56: ldc 2
      //   58: monitorexit
      //   59: aload 6
      //   61: areturn
      //   62: new 2	acqz$a
      //   65: dup
      //   66: invokespecial 49	acqz$a:<init>	()V
      //   69: astore 6
      //   71: goto -47 -> 24
      //   74: astore_1
      //   75: ldc 2
      //   77: monitorexit
      //   78: aload_1
      //   79: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	paramInt1	int
      //   0	80	1	paramString	String
      //   0	80	2	paramLong	long
      //   0	80	4	paramInt2	int
      //   0	80	5	paramInt3	int
      //   22	48	6	locala	a
      // Exception table:
      //   from	to	target	type
      //   3	24	74	finally
      //   24	56	74	finally
      //   62	71	74	finally
    }
    
    /* Error */
    public static void bz(List<a> paramList)
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: getstatic 27	acqz$a:P	Ljava/util/LinkedList;
      //   6: invokevirtual 34	java/util/LinkedList:size	()I
      //   9: istore_1
      //   10: iload_1
      //   11: bipush 100
      //   13: if_icmplt +7 -> 20
      //   16: ldc 2
      //   18: monitorexit
      //   19: return
      //   20: aload_0
      //   21: invokeinterface 57 1 0
      //   26: astore_0
      //   27: aload_0
      //   28: invokeinterface 63 1 0
      //   33: ifeq -17 -> 16
      //   36: aload_0
      //   37: invokeinterface 67 1 0
      //   42: checkcast 2	acqz$a
      //   45: astore_2
      //   46: getstatic 27	acqz$a:P	Ljava/util/LinkedList;
      //   49: aload_2
      //   50: invokevirtual 71	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   53: pop
      //   54: getstatic 27	acqz$a:P	Ljava/util/LinkedList;
      //   57: invokevirtual 34	java/util/LinkedList:size	()I
      //   60: istore_1
      //   61: iload_1
      //   62: bipush 100
      //   64: if_icmplt -37 -> 27
      //   67: goto -51 -> 16
      //   70: astore_0
      //   71: ldc 2
      //   73: monitorexit
      //   74: aload_0
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	paramList	List<a>
      //   9	56	1	i	int
      //   45	5	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   3	10	70	finally
      //   20	27	70	finally
      //   27	61	70	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqz
 * JD-Core Version:    0.7.0.1
 */