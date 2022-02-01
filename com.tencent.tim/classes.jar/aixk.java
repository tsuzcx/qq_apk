import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.1;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.2;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class aixk
  implements aixg, Manager
{
  public aixo a;
  public aqvc c;
  ConcurrentHashMap<String, aixq> fM;
  public HashMap<Long, Boolean> lp;
  public QQAppInterface mApp;
  public Handler mHandler;
  
  @SuppressLint({"UseSparseArrays"})
  public aixk(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.mApp = paramQQAppInterface;
    this.mHandler = a(this);
    this.a = new aixo();
    this.fM = new ConcurrentHashMap();
    this.lp = new HashMap();
    this.c = ((aqva)this.mApp.getManager(47)).a(1);
  }
  
  public static Handler a(aixg paramaixg)
  {
    return new aixk.b(paramaixg);
  }
  
  aixi a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func getPngFrameDrawable begins,epId:" + paramString + ",pos:" + paramInt + ",showProcess:" + paramBoolean);
    }
    String str = "PngFrameManager_" + paramString + "_" + paramInt;
    Object localObject = a(paramString);
    if (localObject == null)
    {
      paramString = null;
      return paramString;
    }
    paramString = BaseApplicationImpl.sImageCache.get(str);
    if ((paramString instanceof aixi)) {}
    for (paramString = (aixi)paramString;; paramString = null)
    {
      if ((paramString == null) || (paramBoolean) || (!paramString.isValid()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
        }
        ((aixq)localObject).cmw = paramBoolean;
        localObject = new aixi((aixq)localObject, this.mApp.getApplication().getResources());
        BaseApplicationImpl.sImageCache.put(str, localObject);
        ((aixi)localObject).Qr(paramInt);
      }
      for (;;)
      {
        paramString = (String)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PngFrameManager", 2, "func getPngFrameDrawable ends");
        return localObject;
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, drawable exists in map,pos:" + paramInt);
          localObject = paramString;
        }
      }
    }
  }
  
  public aixq a(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.fM == null)) {
      localObject = null;
    }
    aixq localaixq;
    do
    {
      return localObject;
      localaixq = (aixq)this.fM.get(paramString);
      localObject = localaixq;
    } while (localaixq != null);
    return b(paramString);
  }
  
  void a(aixk.c paramc)
  {
    if ((paramc != null) && (paramc.c != null) && (paramc.tag == paramc.c.tag) && (paramc.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramc.a.zt(true);
    }
  }
  
  @SuppressLint({"InlinedApi"})
  void a(MarketFaceItemBuilder.b paramb, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramb.image.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramb = (RelativeLayout.LayoutParams)paramb.image.getLayoutParams();
    paramb.width = i;
    paramb.height = j;
  }
  
  public void a(String paramString, MarketFaceItemBuilder.b paramb, long paramLong, boolean paramBoolean1, boolean paramBoolean2, aixk.a parama)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramb == null)) {
      if (parama != null) {
        parama.zt(true);
      }
    }
    for (;;)
    {
      return;
      a(paramb, paramBoolean2);
      aixk.c localc = new aixk.c();
      localc.a = parama;
      localc.epId = paramb.c.e.epId;
      localc.c = paramb;
      localc.tag = paramLong;
      localc.cmx = paramBoolean1;
      localc.dgd = aixo.ds(paramString);
      if (localc.c.progressBar == null) {
        localc.c.progressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localc.c.sS == null) {
        localc.c.sS = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = aixo.dr(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + localc.dgd + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramb.rscType = i;
      switch (i)
      {
      }
      while ((localc.c.bc != null) && (this.mHandler != null))
      {
        this.mHandler.postDelayed(new PngFrameManager.1(this, localc), 1000L);
        return;
        a(localc);
        continue;
        c(localc);
        continue;
        b(localc);
      }
    }
  }
  
  public void aL(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        paramMessage = (aixk.c)paramMessage.obj;
        paramMessage.c.rscType = paramMessage.type;
        if (paramMessage.type == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.type != 1);
      c(paramMessage);
      return;
      paramMessage = (aixk.c)paramMessage.obj;
      paramMessage.c.sS.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (aixk.c)paramMessage.obj;
      paramMessage.c.progressBar.setVisibility(8);
      paramMessage.c.image.setImageResource(2130847983);
      return;
      paramMessage = (aixk.c)paramMessage.obj;
    } while (paramMessage.tag != paramMessage.c.tag);
    paramMessage.c.progressBar.setVisibility(8);
    paramMessage.c.sS.setVisibility(0);
    paramMessage.c.image.setImageBitmap((Bitmap)paramMessage.object);
  }
  
  public aixq b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    aixq localaixq;
    do
    {
      return localObject;
      localaixq = this.a.c(paramString);
      localObject = localaixq;
    } while (localaixq == null);
    this.fM.put(paramString, localaixq);
    return localaixq;
  }
  
  void b(aixk.c paramc)
  {
    paramc.c.progressBar.setVisibility(0);
    paramc.c.image.setImageResource(2130847982);
    ThreadManager.post(new PngFrameManager.2(this, paramc), 5, null, true);
  }
  
  void c(aixk.c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + paramc);
    }
    if (new File(afnu.bEC.replace("[epId]", paramc.epId)).exists())
    {
      f(paramc);
      return;
    }
    int i = aqiw.getSystemNetwork(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramc);
      return;
    }
    paramc.c.progressBar.setVisibility(0);
    paramc.c.image.setImageResource(2130847982);
    e(paramc);
  }
  
  /* Error */
  public boolean ck(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	aixk:lp	Ljava/util/HashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 70	java/util/HashMap
    //   13: dup
    //   14: invokespecial 71	java/util/HashMap:<init>	()V
    //   17: putfield 73	aixk:lp	Ljava/util/HashMap;
    //   20: aload_0
    //   21: getfield 73	aixk:lp	Ljava/util/HashMap;
    //   24: lload_1
    //   25: invokestatic 426	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 427	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 429	java/lang/Boolean
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: getfield 58	aixk:mHandler	Landroid/os/Handler;
    //   41: ifnull +29 -> 70
    //   44: aload_0
    //   45: getfield 58	aixk:mHandler	Landroid/os/Handler;
    //   48: new 431	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: invokespecial 434	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5:<init>	(Laixk;J)V
    //   57: ldc2_w 435
    //   60: invokevirtual 329	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   63: pop
    //   64: iconst_1
    //   65: istore_3
    //   66: aload_0
    //   67: monitorexit
    //   68: iload_3
    //   69: ireturn
    //   70: iconst_0
    //   71: istore_3
    //   72: goto -6 -> 66
    //   75: astore 4
    //   77: aload_0
    //   78: monitorexit
    //   79: aload 4
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	aixk
    //   0	82	1	paramLong	long
    //   65	7	3	bool	boolean
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   20	64	75	finally
  }
  
  void d(aixk.c paramc)
  {
    String str = afnu.bEt.replace("[epId]", paramc.epId).replace("[eId]", paramc.c.c.e.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramc.object = localBitmap;
      try
      {
        if (this.mHandler != null) {
          this.mHandler.obtainMessage(227, paramc).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramc.c.progressBar.setVisibility(0);
    paramc.c.image.setImageResource(2130847982);
    ThreadManager.post(new PngFrameManager.3(this, str, paramc), 5, null, true);
  }
  
  void e(aixk.c paramc)
  {
    ThreadManager.post(new PngFrameManager.4(this, paramc), 5, null, true);
  }
  
  void f(aixk.c paramc)
  {
    Object localObject = a(paramc.epId);
    if ((localObject == null) || (!((aixq)localObject).apQ())) {}
    do
    {
      return;
      localObject = a(paramc.epId, paramc.dgd, paramc.cmx);
      if ((paramc.c != null) && (paramc.c.tag == paramc.tag)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramc.c.progressBar.setVisibility(8);
      paramc.c.image.setImageDrawable((Drawable)localObject);
      return;
    }
    try
    {
      if (this.mHandler != null) {
        this.mHandler.obtainMessage(226, paramc).sendToTarget();
      }
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【onDestroy】  ");
    }
    if (this.fM != null)
    {
      this.fM.clear();
      this.fM = null;
    }
    if (this.lp != null)
    {
      this.lp.clear();
      this.lp = null;
    }
    this.mHandler = null;
    this.c = null;
  }
  
  public static abstract interface a
  {
    public abstract void e(MarketFaceItemBuilder.b paramb);
    
    public abstract void zt(boolean paramBoolean);
  }
  
  static final class b
    extends Handler
  {
    java.lang.ref.WeakReference<aixg> mRef;
    
    public b(aixg paramaixg)
    {
      super();
      this.mRef = new mqq.util.WeakReference(paramaixg);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.mRef == null) {}
      aixg localaixg;
      do
      {
        return;
        localaixg = (aixg)this.mRef.get();
      } while (localaixg == null);
      localaixg.aL(paramMessage);
    }
  }
  
  public class c
  {
    public aixk.a a;
    public MarketFaceItemBuilder.b c;
    public boolean cmx;
    public int dgd;
    public String epId;
    public Object object;
    public long tag;
    public int type;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixk
 * JD-Core Version:    0.7.0.1
 */