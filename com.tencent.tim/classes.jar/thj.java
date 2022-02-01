import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5;
import java.lang.ref.WeakReference;

public final class thj
{
  private ArkAppMgr.IGetAppPathByNameCallback jdField_a_of_type_ComTencentArkOpenArkAppMgr$IGetAppPathByNameCallback = new thk(this);
  private thi jdField_a_of_type_Thi;
  private long aJ = -2147483648L;
  private WeakReference<thj.a> listener;
  private boolean notified;
  private volatile int status = 0;
  
  public thj(WeakReference<thj.a> paramWeakReference, thi paramthi, long paramLong)
  {
    this.listener = paramWeakReference;
    this.jdField_a_of_type_Thi = paramthi;
    this.aJ = paramLong;
    run();
  }
  
  private static boolean ar(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if ((paramInt2 != 1) && (paramInt2 != 1)) {}
    }
    else {
      do
      {
        return true;
        if (paramInt1 != 1) {
          break;
        }
      } while ((paramInt2 == 2) || (paramInt2 == 3));
    }
    do
    {
      do
      {
        tkw.e("GdtArkPreDownloadTask", String.format("checkStatus result:false oldStatus:%d newStatus:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        return false;
      } while (paramInt1 != 2);
      if (paramInt2 == 3) {
        break;
      }
    } while (paramInt2 != 4);
    return true;
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong)
  {
    AdThreadManager.INSTANCE.postDelayed(new GdtArkPreDownloadTask.3(this, paramInt1, paramInt2), 0, paramLong);
  }
  
  private void bnw()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.2(this), 0);
  }
  
  private String getPath()
  {
    String str = null;
    if (isValid()) {
      str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.jdField_a_of_type_Thi.appName, "", null, false);
    }
    tkw.i("GdtArkPreDownloadTask", String.format("getPath %s", new Object[] { str }));
    return str;
  }
  
  private boolean isValid()
  {
    return (this.jdField_a_of_type_Thi != null) && (this.jdField_a_of_type_Thi.isValid());
  }
  
  private void px()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.5(this), 4);
  }
  
  private void run()
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.1(this), 4);
  }
  
  /* Error */
  private void setStatus(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	thj:status	I
    //   4: istore_2
    //   5: iload_2
    //   6: iload_1
    //   7: if_icmpeq +30 -> 37
    //   10: aload_0
    //   11: monitorenter
    //   12: iload_2
    //   13: iload_1
    //   14: if_icmpeq +21 -> 35
    //   17: iload_2
    //   18: iload_1
    //   19: invokestatic 158	thj:ar	(II)Z
    //   22: ifeq +54 -> 76
    //   25: aload_0
    //   26: iload_1
    //   27: putfield 29	thj:status	I
    //   30: aload_0
    //   31: iload_1
    //   32: invokespecial 161	thj:zq	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: ldc 81
    //   39: ldc 163
    //   41: iconst_3
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload_2
    //   48: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: iload_1
    //   55: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: aload_0
    //   62: getfield 29	thj:status	I
    //   65: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: invokestatic 95	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   72: invokestatic 149	tkw:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: return
    //   76: aload_0
    //   77: iconst_1
    //   78: ldc 164
    //   80: lconst_0
    //   81: invokespecial 69	thj:b	(IIJ)V
    //   84: goto -49 -> 35
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	thj
    //   0	92	1	paramInt	int
    //   4	44	2	i	int
    //   87	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	35	87	finally
    //   35	37	87	finally
    //   76	84	87	finally
    //   88	90	87	finally
  }
  
  private void zq(int paramInt)
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.4(this, paramInt), 0);
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public static abstract interface a
  {
    public abstract void a(thi paramthi);
    
    public abstract void a(thi paramthi, int paramInt);
    
    public abstract void a(thi paramthi, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thj
 * JD-Core Version:    0.7.0.1
 */