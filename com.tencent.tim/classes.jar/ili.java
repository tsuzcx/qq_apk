import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class ili
  extends ild
{
  protected volatile boolean Ij;
  private WeakReference<ili.a> br;
  private Map<String, ili.c> cT = new HashMap();
  private long lH;
  
  public ili(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    super(paramLong, paramVideoAppInterface);
  }
  
  private void d(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject1 = ioh.a(paramArrayOfByte);
    paramArrayOfByte = (iog)((SparseArray)localObject1).get(1);
    Object localObject2 = (iog)((SparseArray)localObject1).get(4);
    int i;
    if (localObject2 != null)
    {
      paramArrayOfByte = ((iog)localObject2).getValue();
      i = 1;
    }
    for (;;)
    {
      int j;
      int k;
      int m;
      label162:
      int n;
      float f1;
      label192:
      float f2;
      if (paramArrayOfByte != null)
      {
        localObject1 = (iog)((SparseArray)localObject1).get(3);
        if (localObject1 != null)
        {
          localObject1 = ((iog)localObject1).getValue();
          j = localObject1[0];
          k = (short)(localObject1[1] & 0xFF | j << 8);
          m = (short)(localObject1[2] << 8 | localObject1[3] & 0xFF);
          j = (short)(localObject1[4] << 8 | localObject1[5] & 0xFF);
          j = localObject1[6];
          j = (short)(localObject1[7] & 0xFF | j << 8);
          if (i != 0)
          {
            j = 4;
            n = j * 81 * 2;
            paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
            if (i == 0) {
              break label472;
            }
            f1 = paramArrayOfByte.getInt(n) / 1000000;
            if (i == 0) {
              break label483;
            }
            f2 = paramArrayOfByte.getInt(n + j) / 1000000;
            label212:
            localObject1 = new PointF(f1, f2);
            if (this.mApp.b().getPeerTerminalType(paramString) == 4) {
              break label588;
            }
            f1 = m - f1;
          }
        }
      }
      label290:
      label310:
      label588:
      for (;;)
      {
        localObject2 = new PointF(f1 / m, f2 / k);
        k = j * 73 * 2;
        PointF localPointF1;
        label347:
        label367:
        PointF localPointF2;
        if (i != 0)
        {
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label509;
          }
          f2 = paramArrayOfByte.getInt(k + j) / 1000000;
          localPointF1 = new PointF(f1, f2);
          k = j * 65 * 2;
          if (i == 0) {
            break label524;
          }
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label535;
          }
          f2 = paramArrayOfByte.getInt(k + j) / 1000000;
          localPointF2 = new PointF(f1, f2);
          k = j * 66 * 2;
          if (i == 0) {
            break label550;
          }
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label561;
          }
        }
        for (f2 = paramArrayOfByte.getInt(j + k) / 1000000;; f2 = paramArrayOfByte.getShort(j + k))
        {
          a(paramString, (PointF)localObject2, ilf.a(localPointF2, new PointF(f1, f2), (PointF)localObject1, localPointF1));
          return;
          if (paramArrayOfByte == null) {
            break label591;
          }
          paramArrayOfByte = paramArrayOfByte.getValue();
          i = 0;
          break;
          j = 2;
          break label162;
          label472:
          f1 = paramArrayOfByte.getShort(n);
          break label192;
          label483:
          f2 = paramArrayOfByte.getShort(n + j);
          break label212;
          f1 = paramArrayOfByte.getShort(k);
          break label290;
          label509:
          f2 = paramArrayOfByte.getShort(k + j);
          break label310;
          f1 = paramArrayOfByte.getShort(k);
          break label347;
          f2 = paramArrayOfByte.getShort(k + j);
          break label367;
          f1 = paramArrayOfByte.getShort(k);
          break label404;
        }
        jc(paramString);
        return;
        jc(paramString);
        return;
      }
      label404:
      label535:
      label550:
      label561:
      label591:
      paramArrayOfByte = null;
      label524:
      i = 0;
    }
  }
  
  private void in(boolean paramBoolean)
  {
    igd.aJ("ARZimuTask_SpitZimuTask", "onSmallScreenMoveChanged");
    ili.b localb = a();
    if (localb == null) {
      return;
    }
    igd.aJ("ARZimuTask_SpitZimuTask", "taskPlayer has");
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localb.setDrawParticle(paramBoolean);
      localb.io(false);
      return;
    }
  }
  
  PointF a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    if (this.cT.containsKey(paramString)) {}
    for (paramString = (ili.c)this.cT.get(paramString);; paramString = null)
    {
      if (paramString == null)
      {
        igd.aJ("ARZimuTask_SpitZimuTask", "tryGetMouthInfoByUin info == null");
        return null;
      }
      if (!paramString.tR())
      {
        igd.aJ("ARZimuTask_SpitZimuTask", "tryGetMouthInfoByUin info.checkIsOpenMouth() = false");
        paramString.clear();
        return null;
      }
      PointF localPointF = paramString.I;
      paramString.clear();
      paramString = localPointF;
      if (paramBoolean) {
        break;
      }
      paramString = localPointF;
      if (localPointF == null) {
        break;
      }
      return ild.a(localPointF);
    }
  }
  
  ili.a a()
  {
    if (this.br == null) {
      return null;
    }
    return (ili.a)this.br.get();
  }
  
  ili.b a()
  {
    ild.c localc = super.a();
    if ((localc == null) || (!(localc instanceof ili.b))) {
      return null;
    }
    return (ili.b)localc;
  }
  
  protected List<ilc> a(ijn paramijn, boolean paramBoolean)
  {
    anO();
    ArrayList localArrayList = new ArrayList();
    paramijn = new ilh(paramijn, paramBoolean);
    paramijn.setRecycle(paramBoolean);
    paramijn.Sa = true;
    paramijn.a(this.mTypeface, 32, null);
    localArrayList.add(paramijn);
    return localArrayList;
  }
  
  void a(ilc paramilc)
  {
    igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, begin");
    ili.b localb = a();
    if (localb == null)
    {
      igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, taskPlayer is null");
      return;
    }
    igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, taskPlayer has");
    if ((paramilc instanceof ilh)) {
      paramilc = (ilh)paramilc;
    }
    for (;;)
    {
      Object localObject1;
      if (paramilc == null)
      {
        igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, spitZimuItemTask is null");
        return;
        paramilc = this.fj.iterator();
        do
        {
          if (!paramilc.hasNext()) {
            break;
          }
          localObject1 = (ilc)paramilc.next();
        } while ((!((ilc)localObject1).isVisible()) || (!(localObject1 instanceof ilh)));
        paramilc = (ilh)localObject1;
      }
      else
      {
        localObject1 = gR();
        Object localObject2 = gS();
        String str = paramilc.a.uin;
        boolean bool;
        if ((localObject1 != null) && (str.equals(localObject1))) {
          bool = true;
        }
        for (;;)
        {
          localObject1 = a((String)localObject1, bool);
          if (localObject1 != null) {
            break label400;
          }
          localb.io(bool);
          igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, mouthPoint is null");
          return;
          if ((localObject2 != null) && (str.equals(localObject2)))
          {
            localObject1 = localObject2;
            bool = false;
          }
          else
          {
            if (localObject1 != null)
            {
              igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, uin not equal currentPlayUin=" + (String)localObject1 + " taskUin=" + str);
              paramilc.Sa = false;
              return;
            }
            if (localObject2 != null)
            {
              igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, uin not equal smallScreenUin=" + (String)localObject2 + " taskUin=" + str);
              paramilc.Sa = false;
              return;
            }
            localObject1 = this.mApp.getCurrentAccountUin();
            if ((localObject1 == null) || (!str.equals(localObject1))) {
              break;
            }
            igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, uin not equal currentPlayUin&smallScreenUin=null selfUin=" + (String)localObject1 + " taskUin=" + str);
            bool = true;
          }
        }
        igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, uin not equal currentPlayUin&smallScreenUin&selfUin=null taskUin=" + str);
        paramilc.Sa = false;
        return;
        label400:
        igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, spitZimuItemTask=" + paramilc.a.l);
        localb.c(((PointF)localObject1).x, ((PointF)localObject1).y, bool);
        igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, updateEmitterLocation=" + ((PointF)localObject1).x + "|" + ((PointF)localObject1).y);
        localObject1 = paramilc.I();
        if (localObject1 != null)
        {
          int i = ((Bitmap)localObject1).getWidth();
          int j = ((Bitmap)localObject1).getHeight();
          int k = ((Bitmap)localObject1).getByteCount();
          localObject2 = ByteBuffer.allocate(k);
          ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject2);
          localb.a(((ByteBuffer)localObject2).array(), i, j, bool);
          igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, updateParticleTexture=" + i + "|" + j + "|" + k);
          paramilc.Sa = false;
        }
        while (paramilc.a.isEnd())
        {
          localb.io(bool);
          igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, isEnd");
          return;
          igd.aJ("ARZimuTask_SpitZimuTask", "requestRender, bitmap is null");
        }
        break;
        paramilc = null;
      }
    }
  }
  
  public void a(ili.a parama)
  {
    QLog.w("ARZimuTask_SpitZimuTask", 1, "setMouthDetectorWeakReference, detector[" + parama + "]");
    this.br = new WeakReference(parama);
  }
  
  void a(String paramString, PointF paramPointF, boolean paramBoolean)
  {
    if (this.cT.containsKey(paramString))
    {
      localObject1 = (ili.c)this.cT.get(paramString);
      Object localObject2 = ((ili.c)localObject1).I;
      StringBuilder localStringBuilder = new StringBuilder().append("updateMouthInfo, temp[");
      boolean bool;
      if (localObject2 == null)
      {
        bool = true;
        QLog.w("ARZimuTask_SpitZimuTask", 1, bool + "], uin[" + paramString + "], isOpenMouth[" + paramBoolean + "], pointF[" + paramPointF.x + "->" + paramPointF.y + "]");
        ((ili.c)localObject1).a(paramPointF);
        ((ili.c)localObject1).Sg = paramBoolean;
        if (!paramBoolean) {
          break label276;
        }
        ((ili.c)localObject1).lastOpenTime = System.currentTimeMillis();
        if ((paramPointF.x < 0.0F) || (paramPointF.y < 0.0F)) {
          break label182;
        }
        a(paramString, (ili.c)localObject1);
      }
      label182:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  bool = false;
                  break;
                  paramPointF = a();
                } while (paramPointF == null);
                localObject1 = gR();
                localObject2 = gS();
                if ((localObject1 != null) && (((String)localObject1).equals(paramString)))
                {
                  paramPointF.io(true);
                  return;
                }
                if ((localObject2 != null) && (((String)localObject2).equals(paramString)))
                {
                  paramPointF.io(false);
                  return;
                }
                localObject1 = this.mApp.getCurrentAccountUin();
              } while ((localObject1 == null) || (!((String)localObject1).equals(paramString)));
              paramPointF.io(true);
              return;
              if (System.currentTimeMillis() - ((ili.c)localObject1).lastOpenTime <= 1500L) {
                break label386;
              }
              paramPointF = a();
            } while (paramPointF == null);
            localObject1 = gR();
            localObject2 = gS();
            if ((localObject1 != null) && (((String)localObject1).equals(paramString)))
            {
              paramPointF.io(true);
              return;
            }
            if ((localObject2 != null) && (((String)localObject2).equals(paramString)))
            {
              paramPointF.io(false);
              return;
            }
            localObject1 = this.mApp.getCurrentAccountUin();
          } while ((localObject1 == null) || (!((String)localObject1).equals(paramString)));
          paramPointF.io(true);
          return;
          if ((paramPointF.x > 0.0F) && (paramPointF.y > 0.0F))
          {
            a(paramString, (ili.c)localObject1);
            return;
          }
          paramPointF = a();
        } while (paramPointF == null);
        localObject1 = gR();
        localObject2 = gS();
        if ((localObject1 != null) && (((String)localObject1).equals(paramString)))
        {
          paramPointF.io(true);
          return;
        }
        if ((localObject2 != null) && (((String)localObject2).equals(paramString)))
        {
          paramPointF.io(false);
          return;
        }
        localObject1 = this.mApp.getCurrentAccountUin();
      } while ((localObject1 == null) || (!((String)localObject1).equals(paramString)));
      label276:
      paramPointF.io(true);
      label386:
      return;
    }
    Object localObject1 = new ili.c();
    ((ili.c)localObject1).a(paramPointF);
    ((ili.c)localObject1).Sg = paramBoolean;
    if (paramBoolean) {
      ((ili.c)localObject1).lastOpenTime = System.currentTimeMillis();
    }
    this.cT.put(paramString, localObject1);
    QLog.w("ARZimuTask_SpitZimuTask", 1, "updateMouthInfo, uin[" + paramString + "], isOpenMouth[" + paramBoolean + "], pointF[" + paramPointF.x + "->" + paramPointF.y + "]");
  }
  
  void a(String paramString, ili.c paramc)
  {
    if (paramString == null) {}
    ili.b localb;
    ili.c localc;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localb = a();
          } while (localb == null);
          localc = paramc;
          if (paramc == null)
          {
            localc = paramc;
            if (this.cT.containsKey(paramString)) {
              localc = (ili.c)this.cT.get(paramString);
            }
          }
        } while (localc == null);
        paramc = gR();
        if ((paramc == null) || (!paramc.equals(paramString))) {
          break;
        }
      } while (!localc.tR());
      localb.c(localc.I.x, localc.I.y, true);
      return;
      paramc = this.mApp.getCurrentAccountUin();
    } while ((paramc == null) || (!paramc.equals(paramString)) || (!localc.tR()));
    localb.c(localc.I.x, localc.I.y, true);
  }
  
  protected void b(Observable paramObservable, Object paramObject)
  {
    super.b(paramObservable, paramObject);
    paramObservable = (Object[])paramObject;
    int i = ((Integer)paramObservable[0]).intValue();
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              d((String)paramObservable[1], (byte[])paramObservable[2]);
              return;
              in(((Boolean)paramObservable[1]).booleanValue());
              return;
            } while (this.a == null);
            igd.aJ("ARZimuTask_SpitZimuTask", "handleSubNotify msgType:" + i);
          } while (!this.Ij);
          this.a.doOnResume();
          this.Ij = false;
          return;
        } while (this.a == null);
        this.a.doOnPause();
        this.Ij = true;
        return;
      } while (this.a == null);
      paramObservable = a();
    } while (paramObservable == null);
    paramObservable.io(true);
    paramObservable.io(false);
  }
  
  public String getID()
  {
    return "spit";
  }
  
  protected void ig(boolean paramBoolean)
  {
    Object localObject = a();
    VideoController localVideoController;
    if (localObject != null)
    {
      localVideoController = ((ili.a)localObject).b();
      if (localVideoController != null) {
        if (!paramBoolean) {
          break label72;
        }
      }
    }
    label72:
    for (localObject = "START";; localObject = "STOP")
    {
      igd.aJ("ARZimuTask_SpitZimuTask", "requestFaceFeatureExp:" + paramBoolean + "|" + (String)localObject);
      localVideoController.d(6, (String)localObject);
      return;
    }
  }
  
  public void init()
  {
    super.init();
    kM(0);
    kM(1);
    ig(true);
    this.lH = (System.currentTimeMillis() / 1000L);
  }
  
  void jc(String paramString)
  {
    ili.b localb;
    String str2;
    if (this.cT.containsKey(paramString))
    {
      ((ili.c)this.cT.get(paramString)).clear();
      localb = a();
      if (localb != null)
      {
        String str1 = gR();
        str2 = gS();
        if (!str1.equals(paramString)) {
          break label63;
        }
        localb.io(true);
      }
    }
    label63:
    while (!str2.equals(paramString)) {
      return;
    }
    localb.io(false);
  }
  
  public void kL(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((ili.a)localObject).b();
      if (localObject != null)
      {
        localObject = ((VideoController)localObject).a(((VideoController)localObject).getAppContext());
        if (localObject != null) {
          ((iow)localObject).lo(paramInt);
        }
      }
    }
  }
  
  public void kM(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((ili.a)localObject).b();
      if (localObject != null)
      {
        localObject = ((VideoController)localObject).a(((VideoController)localObject).getAppContext());
        if (localObject != null) {
          ((iow)localObject).lm(paramInt);
        }
        return;
      }
      QLog.w("ARZimuTask_SpitZimuTask", 1, "setExp, controller为空, type[" + paramInt + "]", new Throwable("打印调用栈"));
      return;
    }
    QLog.w("ARZimuTask_SpitZimuTask", 1, "setExp, IMouthDetector为空, type[" + paramInt + "]", new Throwable("打印调用栈"));
  }
  
  public int kX()
  {
    return 300;
  }
  
  public void stop()
  {
    super.stop();
    kL(0);
    kL(1);
    ig(false);
    this.cT.clear();
    ili.b localb = a();
    if (localb != null)
    {
      localb.io(true);
      localb.io(false);
    }
  }
  
  public static abstract interface a
  {
    public abstract VideoController b();
  }
  
  public static abstract interface b
    extends ild.c
  {
    public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
    
    public abstract void c(float paramFloat1, float paramFloat2, boolean paramBoolean);
    
    public abstract void io(boolean paramBoolean);
    
    public abstract void setDrawParticle(boolean paramBoolean);
  }
  
  public static class c
  {
    PointF I = null;
    boolean Sg = false;
    long lastOpenTime;
    
    public void a(PointF paramPointF)
    {
      this.I = paramPointF;
    }
    
    public void clear()
    {
      QLog.w("ARZimuTask_SpitZimuTask", 1, "MouthLoactionInfo.clear");
      this.I = null;
      this.Sg = false;
    }
    
    public boolean tR()
    {
      if (this.Sg) {}
      while (System.currentTimeMillis() - this.lastOpenTime <= 1500L) {
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ili
 * JD-Core Version:    0.7.0.1
 */