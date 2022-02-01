import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.module_switchface.SwitchFaceProcessor;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class iwo
{
  private boolean VG;
  private SwitchFaceProcessor jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor;
  private iwp[] jdField_a_of_type_ArrayOfIwp = new iwp[2];
  private WeakReference<VideoLayerUIBase> bB;
  
  public iwo()
  {
    ankq.aM(VideoEnvironment.getContext());
    atao.init();
    awtj.init();
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor = new SwitchFaceProcessor();
    int i = 0;
    while (i < 2)
    {
      this.jdField_a_of_type_ArrayOfIwp[i] = new iwp();
      i += 1;
    }
  }
  
  private void a(iwo.b paramb)
  {
    if (this.VG) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.VG = false;
      int i = 0;
      while (i < paramb.a.length)
      {
        if (paramb.a[i].b != null) {
          paramb.a[i].b.G(0, 0, 0);
        }
        this.jdField_a_of_type_ArrayOfIwp[i].onPause();
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
  
  private void bC(List<PointF> paramList)
  {
    float f1 = ((PointF)paramList.get(55)).x;
    float f2 = (((PointF)paramList.get(63)).x - ((PointF)paramList.get(55)).x) / 2.0F;
    float f3 = ((PointF)paramList.get(55)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(63)).y - ((PointF)paramList.get(55)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(23)).x;
    f2 = (((PointF)paramList.get(31)).x - ((PointF)paramList.get(23)).x) / 2.0F;
    f3 = ((PointF)paramList.get(23)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(31)).y - ((PointF)paramList.get(23)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(59)).x;
    f2 = (((PointF)paramList.get(77)).x - ((PointF)paramList.get(59)).x) / 2.0F;
    f3 = ((PointF)paramList.get(59)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(77)).y - ((PointF)paramList.get(59)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(35)).x;
    f2 = ((PointF)paramList.get(35)).x;
    f3 = ((PointF)paramList.get(6)).x;
    float f4 = ((PointF)paramList.get(35)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(35)).y - ((PointF)paramList.get(6)).y + f4));
    f1 = ((PointF)paramList.get(64)).x;
    f2 = ((PointF)paramList.get(64)).x;
    f3 = ((PointF)paramList.get(9)).x;
    f4 = ((PointF)paramList.get(64)).y;
    paramList.add(new PointF(f1 + (f2 - f3) * 1.4F, (((PointF)paramList.get(64)).y - ((PointF)paramList.get(9)).y) * 1.4F + f4));
    f1 = ((PointF)paramList.get(45)).x;
    f2 = ((PointF)paramList.get(45)).x;
    f3 = ((PointF)paramList.get(12)).x;
    f4 = ((PointF)paramList.get(45)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(45)).y - ((PointF)paramList.get(12)).y + f4));
    f1 = ((PointF)paramList.get(83)).x;
    f2 = ((PointF)paramList.get(83)).x;
    f3 = ((PointF)paramList.get(59)).x;
    f4 = ((PointF)paramList.get(83)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y + f4));
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, ipm paramipm)
  {
    long l5 = System.currentTimeMillis();
    long l3 = 0L;
    long l4 = 0L;
    if (this.bB != null) {}
    long l2;
    long l1;
    iwo.b localb;
    int m;
    int k;
    int j;
    Object localObject;
    int n;
    int i;
    for (VideoLayerUIBase localVideoLayerUIBase = (VideoLayerUIBase)this.bB.get();; localVideoLayerUIBase = null)
    {
      l2 = l3;
      l1 = l4;
      if (localVideoLayerUIBase == null) {
        break label1689;
      }
      localb = new iwo.b();
      localb.c = paramipm;
      m = 0;
      k = 1;
      j = 0;
      while (j < localVideoLayerUIBase.a.length)
      {
        paramipm = localVideoLayerUIBase.a[j];
        localObject = paramipm.getUin();
        int i1 = paramipm.getRotation();
        if (m >= localb.a.length) {
          break;
        }
        n = k;
        i = m;
        if (paramipm.getVisibility() == 0)
        {
          n = k;
          i = m;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localb.a[m].b = paramipm;
            m += 1;
            n = k;
            i = m;
            if (i1 != 0)
            {
              n = 0;
              i = m;
            }
          }
        }
        j += 1;
        k = n;
        m = i;
      }
    }
    boolean bool;
    if ((m == localb.a.length) && (k != 0) && (paramVideoAppInterface != null) && (paramVideoAppInterface.ch(3)))
    {
      paramVideoAppInterface = (FaceItem)((ijv)paramVideoAppInterface.a(3)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId())) && ("huanlian".equalsIgnoreCase(paramVideoAppInterface.getId())))
      {
        bool = true;
        if (QLog.isColorLevel())
        {
          paramipm = new StringBuilder().append("WL_DEBUG isSelectedSwitchFace = ").append(bool).append("|");
          if (paramVideoAppInterface != null) {
            break label1155;
          }
          paramVideoAppInterface = "null";
          label311:
          QLog.d("SwitchFaceView", 2, paramVideoAppInterface);
        }
        if (!bool) {
          break label1969;
        }
        i = 0;
        label333:
        if (i >= 2) {
          break label1312;
        }
        paramVideoAppInterface = localb.a[i].b.a();
        localb.a[i].bb = paramVideoAppInterface.y();
        localb.a[i].auT = paramVideoAppInterface.lw();
        localb.a[i].auR = paramVideoAppInterface.ls();
        localb.a[i].auS = paramVideoAppInterface.lt();
        localb.a[i].auU = paramVideoAppInterface.lv();
        if (localb.a[i].auU % 2 != 0) {
          break label1163;
        }
        localb.a[i].srcWidth = localb.a[i].auR;
        localb.a[i].srcHeight = localb.a[i].auS;
        label489:
        paramipm = localb.a[i].b.getUin();
        paramVideoAppInterface = paramVideoAppInterface.A();
        if (paramVideoAppInterface == null) {
          break label2021;
        }
      }
    }
    label579:
    label2021:
    for (paramVideoAppInterface = new iwj(paramVideoAppInterface);; paramVideoAppInterface = null)
    {
      float f1;
      if ((paramVideoAppInterface != null) && (paramVideoAppInterface.aZ != null))
      {
        localObject = ByteBuffer.wrap(paramVideoAppInterface.aZ);
        localb.a[i].iF = new ArrayList();
        if (localVideoLayerUIBase.mApp.b().getPeerTerminalType(paramipm) != 2) {
          break label1210;
        }
        j = 1;
        if (localb.a[i].srcWidth * paramVideoAppInterface.height >= localb.a[i].srcHeight * paramVideoAppInterface.E) {
          break label1216;
        }
        k = paramVideoAppInterface.E * localb.a[i].srcHeight / paramVideoAppInterface.height;
        m = (localb.a[i].srcWidth - k) / 2;
        k = 0;
        f1 = localb.a[i].srcHeight / paramVideoAppInterface.height / 1000000.0F;
        n = 0;
      }
      for (;;)
      {
        if (n < ((ByteBuffer)localObject).capacity())
        {
          paramVideoAppInterface = new PointF();
          paramVideoAppInterface.x = (m + ((ByteBuffer)localObject).getInt(n) * f1);
          paramVideoAppInterface.y = (k + ((ByteBuffer)localObject).getInt(n + 4) * f1);
          if (j != 0) {
            paramVideoAppInterface.x = (localb.a[i].srcWidth - paramVideoAppInterface.x);
          }
          if ((paramVideoAppInterface.x < 0.0F) || (paramVideoAppInterface.x > localb.a[i].srcWidth) || (paramVideoAppInterface.y < 0.0F) || (paramVideoAppInterface.y > localb.a[i].srcHeight)) {
            localb.a[i].iF = null;
          }
        }
        else
        {
          if (localb.a[i].iF != null)
          {
            if (localb.a[i].iF.size() == 83) {
              bC(localb.a[i].iF);
            }
            f1 = Math.abs(((PointF)localb.a[i].iF.get(0)).x - ((PointF)localb.a[i].iF.get(64)).x);
            float f2 = Math.abs(((PointF)localb.a[i].iF.get(18)).x - ((PointF)localb.a[i].iF.get(64)).x);
            float f3 = Math.abs(((PointF)localb.a[i].iF.get(89)).y - ((PointF)localb.a[i].iF.get(64)).y);
            float f4 = Math.abs(((PointF)localb.a[i].iF.get(9)).y - ((PointF)localb.a[i].iF.get(64)).y);
            if ((6.0F * f1 < f2) || (f1 > f2 * 6.0F) || (6.0F * f3 < f4) || (f3 > f4 * 6.0F)) {
              localb.a[i].iF = null;
            }
          }
          i += 1;
          break label333;
          bool = false;
          break;
          paramVideoAppInterface = paramVideoAppInterface.getId();
          break label311;
          localb.a[i].srcWidth = localb.a[i].auS;
          localb.a[i].srcHeight = localb.a[i].auR;
          break label489;
          j = 0;
          break label579;
          k = paramVideoAppInterface.height * localb.a[i].srcWidth / paramVideoAppInterface.E;
          m = 0;
          k = (localb.a[i].srcHeight - k) / 2;
          f1 = localb.a[i].srcWidth / paramVideoAppInterface.E / 1000000.0F;
          break label681;
        }
        localb.a[i].iF.add(paramVideoAppInterface);
        n += 8;
      }
      i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfIwp[i].a(localb.a[i].auR, localb.a[i].auS, localb.a[i].auT, localb.a[i].bb, localb.a[i].auU);
        i += 1;
      }
      for (;;)
      {
        try
        {
          if ((GLES20.glCheckFramebufferStatus(36160) == 36053) && (!CollectionUtils.isEmpty(localb.a[0].iF)) && (!CollectionUtils.isEmpty(localb.a[1].iF))) {
            l2 = System.currentTimeMillis();
          }
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          l2 = 0L;
          l1 = 0L;
        }
        try
        {
          if ((!this.VG) && (iow.va()) && (ahbj.isFileExists(iwn.GRAY_FILE_ALL)))
          {
            this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.init();
            this.VG = true;
          }
          paramVideoAppInterface = this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.process(this.jdField_a_of_type_ArrayOfIwp[0].lL(), localb.a[0].iF, localb.a[0].srcWidth, localb.a[0].srcHeight, this.jdField_a_of_type_ArrayOfIwp[1].lL(), localb.a[1].iF, localb.a[1].srcWidth, localb.a[1].srcHeight);
          l1 = System.currentTimeMillis();
          i = 0;
          if (i >= 2) {}
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          for (;;)
          {
            l1 = 0L;
          }
        }
        try
        {
          localb.a[i].b.G(paramVideoAppInterface[i], localb.a[i].srcWidth, localb.a[i].srcHeight);
          i += 1;
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          break label1847;
          l1 = 0L;
          l2 = 0L;
        }
      }
      l3 = l1;
      l4 = l2;
      if ((localb.c instanceof ipn))
      {
        GLES20.glViewport(0, 0, ((ipn)localb.c).lq(), ((ipn)localb.c).lr());
        l4 = l2;
        l3 = l1;
      }
      l1 = l3;
      l2 = l4;
      for (;;)
      {
        l3 = System.currentTimeMillis();
        if ((QLog.isColorLevel()) && (l2 != 0L) && (l1 != 0L))
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal before SwitchFaceProcessor.process cost = " + (l2 - l5));
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal SwitchFaceProcessor.process cost = " + (l1 - l2));
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal after SwitchFaceProcessor.process cost = " + (l3 - l1));
        }
        return;
        i = 0;
        while (i < 2)
        {
          localb.a[i].b.G(0, 0, 0);
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal e = " + paramVideoAppInterface);
          paramipm = paramVideoAppInterface.getStackTrace();
          paramVideoAppInterface = "";
          j = paramipm.length;
          i = 0;
          while (i < j)
          {
            paramVideoAppInterface = paramVideoAppInterface + "WL_DEBUG processFrame_internal ste[" + i + "]" + paramipm[i].toString() + "\n";
            i += 1;
          }
          QLog.e("SwitchFaceView", 2, paramVideoAppInterface);
        }
        break;
        a(localb);
        l3 = 0L;
        l4 = 0L;
        break label1681;
        a(localb);
        l2 = l3;
        l1 = l4;
      }
    }
  }
  
  public void a(VideoLayerUIBase paramVideoLayerUIBase)
  {
    this.bB = new WeakReference(paramVideoLayerUIBase);
  }
  
  public void akO()
  {
    int i = 0;
    while (i < 2)
    {
      this.jdField_a_of_type_ArrayOfIwp[i].akO();
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    if (this.VG) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.VG = false;
      this.bB = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
  
  public void onPause()
  {
    if (this.VG) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.VG = false;
      int i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfIwp[i].onPause();
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
  
  class a
  {
    int auR;
    int auS;
    int auT;
    int auU;
    izm jdField_b_of_type_Izm;
    byte[] bb;
    ArrayList<PointF> iF = new ArrayList();
    int srcHeight;
    int srcWidth;
    
    a() {}
  }
  
  class b
  {
    iwo.a[] a = new iwo.a[2];
    ipm c;
    
    b()
    {
      int i = 0;
      while (i < this.a.length)
      {
        this.a[i] = new iwo.a(iwo.this);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwo
 * JD-Core Version:    0.7.0.1
 */