import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.ByteUtils;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;

@TargetApi(18)
public class iow
  extends ipb
  implements iov
{
  public static String TAG = "EffectsRenderController";
  static boolean TI;
  static boolean TJ;
  static final int[] cy = { 2, 13, 14 };
  private String PD;
  private ikk jdField_a_of_type_Ikk;
  ill jdField_a_of_type_Ill = new iox(this);
  iow.a jdField_a_of_type_Iow$a = new iow.a();
  public ioz a;
  private int arp;
  private BitSet c;
  boolean isInitial = false;
  private VideoAppInterface mApp;
  Context mContext;
  
  public iow(VideoAppInterface paramVideoAppInterface, GLRootView paramGLRootView)
  {
    QLog.w(TAG, 1, "EffectsRenderController, constructor, app[" + paramVideoAppInterface + "], mContext[" + this.mContext + "]", new Throwable("打印调用栈"));
    this.mApp = paramVideoAppInterface;
    this.mContext = paramVideoAppInterface.getApplication();
    this.jdField_a_of_type_Ikk = new ikk(this.mContext);
    this.jdField_a_of_type_Ioz = new ioz(this.mContext, this.jdField_a_of_type_Ikk, this.mApp);
    this.c = new BitSet();
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    iou.br(this.mContext);
  }
  
  private void a(ios paramios, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramios != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramios.width, (short)paramios.height);
      if (paramios.b != null) {
        paramios.b.finish();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramios.data, paramios.format, paramios.width, paramios.height, paramios.angle, paramios.rotation, paramios.timestamp, paramios.TF, VideoController.a().K, paramArrayOfByte1, paramios.ari, paramios.arj);
    }
  }
  
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = imm.getNumCores();
    if (i < paramInt)
    {
      QLog.w(TAG, 1, "isSupportOfDevice fail, cpuCount[" + i + " < " + paramInt + "]");
      return false;
    }
    long l = imm.getMaxCpuFreq();
    if ((l != 0L) && (l < paramLong1))
    {
      QLog.w(TAG, 1, "isSupportOfDevice fail, cpuFrequency[" + l + " < " + paramLong1 + "]");
      return false;
    }
    paramLong1 = aqgz.getSystemTotalMemory();
    if (paramLong1 < paramLong2)
    {
      QLog.w(TAG, 1, "isSupportOfDevice fail, mem[" + paramLong1 + " < " + paramLong2 + "]");
      return false;
    }
    return true;
  }
  
  private void aoX()
  {
    if (this.jdField_a_of_type_Ioz != null) {
      this.jdField_a_of_type_Ioz.aoJ();
    }
  }
  
  private void aoY()
  {
    if (this.mApp.ch(2)) {
      ((ikl)this.mApp.a(2)).clear();
    }
    if (this.jdField_a_of_type_Ioz != null) {
      this.jdField_a_of_type_Ioz.uninit();
    }
  }
  
  private void b(ios paramios)
  {
    short s1 = 0;
    byte[] arrayOfByte = paramios.data;
    ilo.a().d(arrayOfByte, 3);
    if ((this.c.get(0)) || (this.c.get(1))) {}
    int i;
    Object localObject2;
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      i = 0;
      localObject2 = null;
      for (localObject1 = null;; localObject1 = localObject3)
      {
        if (i >= cy.length) {
          break label413;
        }
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (!this.mApp.ch(cy[i])) {
          break label402;
        }
        localObject3 = (iki)this.mApp.a(cy[i]);
        if (localObject3 != null) {
          break;
        }
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        i += 1;
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
    }
    Object localObject4 = ((iki)localObject3).a(paramios.height, paramios.width);
    if (localObject4 != null)
    {
      localObject1 = ((iki.a)localObject4).a;
      localObject2 = ((iki.a)localObject4).b;
    }
    if (localObject2 != null) {
      ((iki)localObject3).a(this.jdField_a_of_type_Ikk);
    }
    localObject4 = localObject2;
    Object localObject3 = localObject1;
    if (localObject2 != null)
    {
      localObject4 = localObject2;
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      if (this.mApp.ch(1)) {}
      for (localObject3 = ((iju)this.mApp.a(1)).a();; localObject3 = null)
      {
        jjo localjjo = paramios.b;
        localjjo.axk();
        localObject4 = this.jdField_a_of_type_Ioz.a(paramios, (FilterDesc)localObject3, (VideoMaterial)localObject2, bool, false, (PendantItem)localObject1, this);
        localjjo.axl();
        ilo.a().d(arrayOfByte, 0);
        i = ikl.a((PendantItem)localObject1, false);
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
        short s2;
        if (localObject4 != null)
        {
          localObject1 = ((ioz.a)localObject4).aQ;
          localObject2 = ((ioz.a)localObject4).aR;
          localObject3 = ((ioz.a)localObject4).aS;
          s1 = ((ioz.a)localObject4).C;
          s2 = ((ioz.a)localObject4).D;
          paramios = (ios)localObject4;
        }
        for (;;)
        {
          paramios.b = localjjo;
          a(paramios, (byte[])localObject1, (byte[])localObject2, (byte[])localObject3, s1, s2);
          return;
          s2 = 0;
          localObject3 = null;
          localObject2 = null;
          localObject1 = null;
        }
      }
      label402:
      localObject1 = localObject4;
      localObject2 = localObject3;
      break;
      label413:
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  private void cq(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 1, "realyInit, isInitial[" + this.isInitial + "], soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "], seq[" + paramLong + "]");
    }
    if (this.isInitial) {}
    do
    {
      return;
      this.isInitial = true;
      super.init();
      this.jdField_a_of_type_Ioz.ct(paramLong);
    } while (!ilj.isCameraOpened);
    this.jdField_a_of_type_Ioz.r(paramLong, ilj.aoC, ilj.aoB);
  }
  
  private void cr(long paramLong)
  {
    if (!this.isInitial) {
      return;
    }
    this.isInitial = false;
    if (AudioHelper.aCz()) {
      QLog.w(TAG, 1, "realyTerminate, seq[" + paramLong + "]");
    }
    if (this.mApp.ch(2)) {
      ((ikl)this.mApp.a(2)).clear();
    }
    if (this.jdField_a_of_type_Ioz != null) {
      this.jdField_a_of_type_Ioz.cu(paramLong);
    }
    super.terminate();
  }
  
  public static boolean k(int paramInt, long paramLong)
  {
    if (tK()) {
      return true;
    }
    int i = aqgz.getOsVersion();
    if (i < 17)
    {
      igd.aJ(TAG, "isUserEffectFace error  OSversion:" + i);
      return false;
    }
    return a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean tK()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  public static boolean uW()
  {
    return (awtj.isSupported()) && (ankq.axZ());
  }
  
  public static boolean uX()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      return false;
    }
    return a(2, 1200000L, 1073741824L);
  }
  
  public static boolean uY()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 1, "isUserAfterTreatmentPower android.os.Build.VERSION.SDK_INT <= 15");
      }
    }
    do
    {
      return false;
      if (iop.uR()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 1, "isUserAfterTreatmentPower isMachineSupportAfterTreatment=false");
    return false;
    return true;
  }
  
  public static boolean uZ()
  {
    if (TJ) {
      return true;
    }
    ioj localioj = ioj.a();
    if ((localioj != null) && (localioj.uG()))
    {
      TJ = true;
      return true;
    }
    if (!uX()) {
      return false;
    }
    if ((a(4, 1400000L, 1073741824L)) || (a(8, 1200000L, 1073741824L))) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    if ((localioj != null) && (!localioj.uF()))
    {
      igd.aL(TAG, "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
      return false;
    }
    TJ = true;
    return TJ;
  }
  
  public static boolean va()
  {
    boolean bool1 = true;
    if (!TI)
    {
      TI = ikx.b(VideoController.a().a());
      if (!TI)
      {
        QLog.w(TAG, 1, "isLoadedSO, 加载so失败");
        bool1 = false;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while (GraphicRenderMgr.soloadedPTV);
      GraphicRenderMgr.loadPtuSO();
      QLog.w(TAG, 1, "isLoadedSO, soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "]");
      bool2 = GraphicRenderMgr.soloadedPTV;
      bool1 = bool2;
    } while (!GraphicRenderMgr.soloadedPTV);
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject != null) {
      ((iow)localObject).aoW();
    }
    VideoController.a().hL(GraphicRenderMgr.soloadedPTV);
    return bool2;
  }
  
  public void a(ios paramios)
  {
    this.jdField_a_of_type_Iow$a.a(paramios.data, paramios.width, paramios.height, paramios.format, paramios.angle, paramios.mn, paramios.TF, paramios.mo);
    if ((paramios.data == null) || (paramios.width == 0) || (paramios.height == 0)) {
      return;
    }
    if (this.mHandler.hasMessages(3))
    {
      this.mHandler.removeMessages(3);
      ilo.a().bB(2, 0);
    }
    ilo.a().d(paramios.data, 2);
    this.mHandler.obtainMessage(3, paramios).sendToTarget();
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    label320:
    label337:
    int i;
    if ((this.c.get(0)) || (this.c.get(1)) || (this.c.get(2)) || (this.c.get(3))) {
      if ((this.c.get(2)) || (this.c.get(3)))
      {
        paramShort1 = VideoController.a().g(false);
        igd.aJ(TAG, "buildExtInfo volume :" + paramShort1 + this.c.get(1) + "|" + this.c.get(0));
        if (paramShort1 < 100)
        {
          localObject = new byte[2];
          ByteUtils.Word2Byte((byte[])localObject, 0, (short)paramShort1);
          localObject = new iog((short)2, (short)2, (byte[])localObject);
          if (this.c.get(3))
          {
            localArrayList.add(localObject);
            paramShort2 = 0 + ((iog)localObject).ln();
            if (!this.c.get(0))
            {
              paramShort1 = paramShort2;
              if (!this.c.get(1)) {}
            }
            else
            {
              igd.aJ(TAG, "buildExtInfo face :" + paramArrayOfByte1 + "|" + this.c.get(1) + "|" + this.c.get(0));
              if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
              {
                paramShort1 = paramShort2;
                if (paramArrayOfByte3 == null) {}
              }
              else
              {
                if (paramArrayOfByte1 == null) {
                  break label643;
                }
                paramArrayOfByte1 = new iog((short)1, (short)paramArrayOfByte1.length, paramArrayOfByte1);
                if (paramArrayOfByte2 == null) {
                  break label648;
                }
                paramArrayOfByte2 = new iog((short)4, (short)paramArrayOfByte2.length, paramArrayOfByte2);
                if (paramArrayOfByte3 == null) {
                  break label653;
                }
                i = 1;
                label344:
                if (!this.c.get(1)) {
                  break label749;
                }
                if (i == 0) {
                  break label659;
                }
                paramArrayOfByte1 = new iog((short)6, (short)paramArrayOfByte3.length, paramArrayOfByte3);
                localArrayList.add(paramArrayOfByte1);
                paramShort1 = paramArrayOfByte1.ln() + paramShort2;
                label390:
                paramArrayOfByte1 = new byte[8];
                if (i == 0) {
                  break label733;
                }
                paramShort2 = paramShort4;
                label404:
                if (i == 0) {
                  break label741;
                }
                i = paramShort3;
                label413:
                paramArrayOfByte1[0] = ((byte)(paramShort2 >> 8));
                paramArrayOfByte1[1] = ((byte)(paramShort2 >> 0));
                paramArrayOfByte1[2] = ((byte)(i >> 8));
                paramArrayOfByte1[3] = ((byte)(i >> 0));
                paramArrayOfByte1[4] = ((byte)(paramShort3 >> 8));
                paramArrayOfByte1[5] = ((byte)(paramShort3 >> 0));
                paramArrayOfByte1[6] = ((byte)(paramShort4 >> 8));
                paramArrayOfByte1[7] = ((byte)(paramShort4 >> 0));
                paramArrayOfByte1 = new iog((short)3, (short)paramArrayOfByte1.length, paramArrayOfByte1);
                localArrayList.add(paramArrayOfByte1);
                paramShort1 = paramArrayOfByte1.ln() + paramShort1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label512:
      paramShort2 = paramShort1;
      if (this.c.get(4))
      {
        paramArrayOfByte1 = ije.a(this.mApp);
        paramShort2 = paramShort1;
        if (paramArrayOfByte1 != null) {
          paramShort2 = paramShort1 + paramArrayOfByte1.l(localArrayList);
        }
      }
      if (paramShort2 > 0)
      {
        paramArrayOfByte1 = ByteBuffer.allocate(paramShort2);
        paramShort2 = localArrayList.size();
        paramShort1 = 0;
        for (;;)
        {
          if (paramShort1 < paramShort2)
          {
            paramArrayOfByte1.put(ioh.a((iog)localArrayList.get(paramShort1)));
            paramShort1 += 1;
            continue;
            if (this.c.get(2))
            {
              localObject = ioh.a((iog)localObject);
              e(this.PD, (byte[])localObject);
            }
            paramShort2 = 0;
            break;
            label643:
            paramArrayOfByte1 = null;
            break label320;
            label648:
            paramArrayOfByte2 = null;
            break label337;
            label653:
            i = 0;
            break label344;
            label659:
            if (((ikt)this.mApp.a(5)).k(3, "SUPPORT_SWITCH_FACE") == 1) {}
            for (paramShort1 = 1;; paramShort1 = 0)
            {
              if (paramShort1 != 0) {
                break label714;
              }
              localArrayList.add(paramArrayOfByte1);
              paramShort1 = paramArrayOfByte1.ln() + paramShort2;
              break;
            }
            label714:
            localArrayList.add(paramArrayOfByte2);
            paramShort1 = paramArrayOfByte2.ln() + paramShort2;
            break label390;
            label733:
            paramShort2 = 320;
            break label404;
            label741:
            i = 240;
            break label413;
            label749:
            paramShort1 = paramShort2;
            if (!this.c.get(0)) {
              break label512;
            }
            paramArrayOfByte1 = ioh.a(paramArrayOfByte1);
            e(this.PD, paramArrayOfByte1);
            paramShort1 = paramShort2;
            break label512;
          }
        }
        return paramArrayOfByte1.array();
      }
      return null;
      paramShort1 = 0;
    }
  }
  
  protected void ai(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      cq(jlc.a(paramMessage.obj));
      return;
    case 2: 
      cr(jlc.a(paramMessage.obj));
      return;
    case 3: 
      b((ios)paramMessage.obj);
      return;
    case 4: 
      r(jlc.a(paramMessage.obj), ilj.aoC, ilj.aoB);
      return;
    case 5: 
      aoY();
      return;
    }
    aoX();
  }
  
  public void aoW()
  {
    this.mHandler.obtainMessage(6).sendToTarget();
  }
  
  public void cp(long paramLong)
  {
    if (this.jdField_a_of_type_Ioz != null) {
      this.jdField_a_of_type_Ioz.cp(paramLong);
    }
  }
  
  void e(String paramString, byte[] paramArrayOfByte)
  {
    if (this.mApp != null) {
      this.mApp.l(new Object[] { Integer.valueOf(130), paramString, paramArrayOfByte });
    }
  }
  
  public void init()
  {
    long l = AudioHelper.hG();
    Message localMessage = this.mHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
    CameraUtils.a(this.mContext).addObserver(this.jdField_a_of_type_Ill);
  }
  
  public void lm(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (!this.c.get(paramInt)) {
        QLog.w(TAG, 1, "setExtInfo, flag[" + paramInt + "]", new Throwable("打印调用栈"));
      }
      this.c.set(paramInt);
    }
    while (paramInt < 5) {
      return;
    }
    throw new IllegalArgumentException("setExtInfo fail, EXP_BIT_MAX[5" + acfp.m(2131705765));
  }
  
  public void ln(int paramInt)
  {
    this.arp = paramInt;
  }
  
  public void lo(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (this.c.get(paramInt)) {
        QLog.w(TAG, 1, "clearExtInfo, flag[" + paramInt + "]", new Throwable("打印调用栈"));
      }
      this.c.clear(paramInt);
    }
  }
  
  public int lp()
  {
    return this.arp;
  }
  
  void r(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ioz.ct(paramLong);
    this.jdField_a_of_type_Ioz.r(paramLong, paramInt1, paramInt2);
  }
  
  public void setApp(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.PD = this.mApp.getCurrentAccountUin();
    this.jdField_a_of_type_Ikk.d(paramVideoAppInterface);
  }
  
  public void terminate()
  {
    long l = AudioHelper.hG();
    CameraUtils.a(this.mContext).deleteObserver(this.jdField_a_of_type_Ill);
    Message localMessage = this.mHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
  }
  
  public void uninit()
  {
    this.mHandler.obtainMessage(5).sendToTarget();
  }
  
  static class a
  {
    boolean TK = false;
    int arq = 0;
    int mFormat = 0;
    int mHeight = 0;
    int mWidth = 0;
    long mx = 0L;
    
    void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, boolean paramBoolean, long paramLong2)
    {
      String str;
      StringBuilder localStringBuilder;
      if ((paramArrayOfByte == null) || (this.mWidth == 0) || (this.mHeight == 0) || (this.mWidth != paramInt1) || (this.mHeight != paramInt2) || (this.mFormat != paramInt3) || (this.arq != paramInt4) || (this.mx != paramLong1) || (this.TK != paramBoolean)) {
        if (QLog.isColorLevel())
        {
          str = iow.TAG;
          localStringBuilder = new StringBuilder().append("onProcessFrame, data[");
          if (paramArrayOfByte == null) {
            break label299;
          }
        }
      }
      label299:
      for (boolean bool = true;; bool = false)
      {
        QLog.d(str, 1, bool + "], frameIndex[" + paramLong2 + "], width[" + this.mWidth + "->" + paramInt1 + "], height[" + this.mHeight + "->" + paramInt2 + "], format[" + this.mFormat + "->" + paramInt3 + "], angle[" + this.arq + "->" + paramInt4 + "], FPS[" + this.mx + "->" + paramLong1 + "], isFront[" + this.TK + "->" + paramBoolean + "]");
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        this.mFormat = paramInt3;
        this.arq = paramInt4;
        this.mx = paramLong1;
        this.TK = paramBoolean;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iow
 * JD-Core Version:    0.7.0.1
 */