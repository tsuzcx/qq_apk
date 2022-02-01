import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.Vas.ColorFont.FreeTypeLib;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontManagerForTool.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResultCallback;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class kx
  extends Observable
{
  private static kx jdField_a_of_type_Kx;
  private AtomicBoolean H = new AtomicBoolean(false);
  private AtomicBoolean I = new AtomicBoolean(false);
  private AtomicBoolean J = new AtomicBoolean(false);
  private AtomicBoolean K = new AtomicBoolean(false);
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new ky(this);
  private EIPCResultCallback b = new kz(this);
  private ETEngine mEngine;
  public HandlerThread mHandlerThread = ThreadManager.newFreeHandlerThread("VasFont", 0);
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private ConcurrentHashMap<Integer, kt> q = new ConcurrentHashMap();
  
  private kx()
  {
    this.mHandlerThread.start();
  }
  
  public static kx a()
  {
    try
    {
      if (jdField_a_of_type_Kx == null) {
        jdField_a_of_type_Kx = new kx();
      }
      kx localkx = jdField_a_of_type_Kx;
      return localkx;
    }
    finally {}
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = d(4, paramBoolean1);
    if (paramBoolean1)
    {
      i.a().a().Z();
      this.J.set(true);
      if (paramBoolean2)
      {
        setChanged();
        notifyObservers(Integer.valueOf(1));
      }
    }
    return paramBoolean1;
  }
  
  private boolean d(int paramInt, boolean paramBoolean)
  {
    String str3 = "";
    String str4 = "";
    String str1 = str4;
    String str2 = str3;
    switch (paramInt)
    {
    default: 
      str2 = str3;
      str1 = str4;
    case 2: 
    case 3: 
      switch (aqnl.af(aqnl.getSoDir(), str2))
      {
      }
      break;
    }
    do
    {
      return false;
      str2 = "libvipfont808.so";
      str1 = ld.er;
      break;
      str2 = "libFounderColorFont_818.so";
      str1 = ld.es;
      break;
    } while (!paramBoolean);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", str1, null, this.b);
    return false;
    return true;
  }
  
  /* Error */
  private boolean f(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_0
    //   8: iconst_1
    //   9: iload_1
    //   10: invokespecial 108	kx:d	(IZ)Z
    //   13: ifeq +77 -> 90
    //   16: aload_0
    //   17: invokestatic 178	com/etrump/mixlayout/ETEngine:getInstance	()Lcom/etrump/mixlayout/ETEngine;
    //   20: putfield 180	kx:mEngine	Lcom/etrump/mixlayout/ETEngine;
    //   23: aload_0
    //   24: invokestatic 183	com/etrump/mixlayout/ETEngine:getInstanceForAnimation	()Lcom/etrump/mixlayout/ETEngine;
    //   27: putfield 185	kx:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   30: getstatic 188	com/etrump/mixlayout/ETEngine:isSOLoaded	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   33: iconst_1
    //   34: invokevirtual 124	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   37: iload 4
    //   39: istore_2
    //   40: aload_0
    //   41: getfield 180	kx:mEngine	Lcom/etrump/mixlayout/ETEngine;
    //   44: iconst_5
    //   45: ldc 189
    //   47: invokevirtual 193	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   50: istore 4
    //   52: iload_3
    //   53: istore_1
    //   54: iload 4
    //   56: ifeq +22 -> 78
    //   59: aload_0
    //   60: getfield 185	kx:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   63: iconst_3
    //   64: ldc 194
    //   66: invokevirtual 193	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   69: istore_2
    //   70: iload_3
    //   71: istore_1
    //   72: iload_2
    //   73: ifeq +5 -> 78
    //   76: iconst_1
    //   77: istore_1
    //   78: iload_1
    //   79: istore_2
    //   80: aload_0
    //   81: getfield 33	kx:H	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   84: iload_1
    //   85: invokevirtual 124	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   88: iload_1
    //   89: istore_2
    //   90: iload_2
    //   91: ireturn
    //   92: astore 5
    //   94: ldc 196
    //   96: iconst_1
    //   97: ldc 198
    //   99: aload 5
    //   101: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: iload_2
    //   105: ireturn
    //   106: astore 5
    //   108: iload 4
    //   110: istore_2
    //   111: goto -17 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	kx
    //   0	114	1	paramBoolean	boolean
    //   1	110	2	bool1	boolean
    //   6	65	3	bool2	boolean
    //   3	106	4	bool3	boolean
    //   92	8	5	localException1	java.lang.Exception
    //   106	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   40	52	92	java/lang/Exception
    //   80	88	92	java/lang/Exception
    //   59	70	106	java/lang/Exception
  }
  
  private boolean g(boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mUIHandler.post(new FontManagerForTool.3(this, paramBoolean));
      return false;
    }
    return b(paramBoolean, false);
  }
  
  public kt b(int paramInt1, int paramInt2)
  {
    int i = 1;
    kt localkt = (kt)this.q.get(Integer.valueOf(paramInt1));
    boolean bool;
    if (localkt == null)
    {
      bool = ku.d(paramInt1, paramInt2);
      localObject = ku.e(paramInt1, paramInt2);
      if (!bool)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("id", paramInt1);
        localBundle.putInt("font_type", paramInt2);
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", ld.et, localBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
      }
      switch (paramInt2)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return localkt;
          if (this.I.compareAndSet(false, true)) {
            f(true);
          }
        } while ((!this.H.get()) || (!bool));
        if ((this.mEngine.native_loadFont((String)localObject, paramInt1, false)) && (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont((String)localObject, paramInt1, false))) {}
        while (i != 0)
        {
          localObject = new kt(paramInt1, paramInt2, (String)localObject);
          this.q.put(Integer.valueOf(paramInt1), localObject);
          return localObject;
          i = 0;
        }
      } while (!bool);
      localkt = new kt(paramInt1, paramInt2, (String)localObject);
      localkt.mTypeface = Typeface.createFromFile((String)localObject);
      this.q.put(Integer.valueOf(paramInt1), localkt);
      return localkt;
      if (this.K.compareAndSet(false, true)) {
        g(true);
      }
    } while ((!this.J.get()) || (!bool));
    i.a().b(paramInt1, (String)localObject);
    Object localObject = new kt(paramInt1, 4, (String)localObject);
    this.q.put(Integer.valueOf(paramInt1), localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kx
 * JD-Core Version:    0.7.0.1
 */