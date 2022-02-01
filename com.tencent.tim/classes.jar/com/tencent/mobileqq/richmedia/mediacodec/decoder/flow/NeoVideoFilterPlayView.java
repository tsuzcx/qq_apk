package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import alza;
import alze;
import alzf;
import alzg;
import alzh;
import alzi;
import alzj;
import alzw;
import alzx;
import alzy;
import alzy.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.a;
import com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import ram;
import rar;

@TargetApi(18)
public class NeoVideoFilterPlayView
  extends VideoFilterPlayView
{
  public boolean ENABLE;
  private alzg jdField_a_of_type_Alzg;
  private alzh jdField_a_of_type_Alzh;
  private alzy.a jdField_a_of_type_Alzy$a;
  private b jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$b = new a();
  private c jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c;
  private boolean cuB;
  private int dAS = -1;
  private int dAT;
  private AtomicBoolean dG = new AtomicBoolean(false);
  private Handler dm;
  
  public NeoVideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NeoVideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new HandlerThread("NeoVideoFilterPlayView");
    paramContext.start();
    this.dm = new Handler(paramContext.getLooper(), new alzw(this));
    this.jdField_a_of_type_Alzy$a = new alzx(this);
    if (this.ENABLE)
    {
      this.jdField_a_of_type_Alzh = new alzh();
      setEGLContextFactory(this.jdField_a_of_type_Alzh);
      super.dLN();
      rar.b("video_edit", "flow_view_create", 0, 0, new String[] { Build.MANUFACTURER, Build.MODEL, String.valueOf(Build.VERSION.SDK_INT) });
    }
    ram.w("FlowEdit_NeoVideoFilterPlayView", "Model=%s, Manufacture=%s, SDK=%d", new Object[] { Build.MODEL, Build.MANUFACTURER, Integer.valueOf(Build.VERSION.SDK_INT) });
  }
  
  private void e(GL10 paramGL10)
  {
    Object localObject = (alzy)this.jdField_a_of_type_Alze;
    paramGL10 = ((alzy)localObject).c();
    alzg localalzg = ((alzy)localObject).d();
    int k;
    int i;
    int m;
    int j;
    if (paramGL10 != null)
    {
      if ((Math.abs(paramGL10.gH()) > this.d.endTimeMillSecond * 1000L) || (Math.abs(paramGL10.gH()) < this.d.startTimeMillSecond)) {
        ram.w("FlowEdit_NeoVideoFilterPlayView", "find invalid frame : %s us, current config start - end : [%d - %d] ms", new Object[] { paramGL10, Long.valueOf(this.d.startTimeMillSecond), Long.valueOf(this.d.endTimeMillSecond) });
      }
      k = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c == null) || (paramGL10.Iv() != c.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c)))
      {
        k = 1;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$b.btC();
      }
      i = getSpeedType();
      m = 0;
      if ((this.dAS == -1) || (this.dAS != i))
      {
        m = 1;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$b.ed(this.dAS, i);
      }
      this.dAS = i;
      if (getSpeedType() == 1)
      {
        i = 2;
        j = 1;
      }
    }
    for (;;)
    {
      label201:
      if ((this.dG.compareAndSet(true, false)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c == null) || (k != 0) || (m != 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c = new c(SystemClock.uptimeMillis(), paramGL10.gH(), paramGL10.Iv(), null);
        ram.i("FlowEdit_NeoVideoFilterPlayView", "start render : " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c);
      }
      long l2 = SystemClock.uptimeMillis();
      long l3 = c.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c) + (paramGL10.gH() - c.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c)) * j / (i * 1000);
      long l1;
      if ((localalzg != null) && (localalzg.Iv() == paramGL10.Iv()))
      {
        l1 = c.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c) + (localalzg.gH() - c.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c)) * j / (i * 1000);
        label367:
        if (l2 >= l3 - 5L) {
          break label549;
        }
        paramGL10 = this.jdField_a_of_type_Alzg;
        l1 = l3 - l2;
        label391:
        if (paramGL10 != null)
        {
          Trace.beginSection("AVEditor:DrawFrameOnScreen");
          localObject = alzi.caculateCenterCropMvpMatrix(this.surfaceWidth, this.surfaceHeight, this.surfaceWidth, this.surfaceHeight);
          drawTexture(paramGL10.getTextureId(), paramGL10.dq, (float[])localObject);
          if ((this.jdField_a_of_type_Alzg != null) && (this.jdField_a_of_type_Alzg != paramGL10)) {
            this.jdField_a_of_type_Alzg.recycle();
          }
          this.jdField_a_of_type_Alzg = paramGL10;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$b.fq(paramGL10.gH());
          Trace.endSection();
        }
        this.dm.removeMessages(1);
        if (l1 >= 0L) {
          if (l1 <= 5L) {
            break label682;
          }
        }
      }
      label549:
      label682:
      for (l1 -= 5L;; l1 = 0L)
      {
        this.dm.sendEmptyMessageDelayed(1, l1);
        return;
        if (getSpeedType() != 2) {
          break label688;
        }
        i = 1;
        j = 2;
        break label201;
        l1 = 30L + l3;
        break label367;
        if (l2 < l1)
        {
          localObject = ((alzy)localObject).b();
          l2 = l1 - l2;
          l1 = l2;
          paramGL10 = (GL10)localObject;
          if (this.dAT <= 0) {
            break label391;
          }
          ram.b("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : drop %d frames, decoder is slow", Integer.valueOf(this.dAT));
          this.dAT = 0;
          l1 = l2;
          paramGL10 = (GL10)localObject;
          break label391;
        }
        paramGL10 = ((alzy)localObject).b();
        if (localalzg != null)
        {
          if (paramGL10 != null) {
            paramGL10.recycle();
          }
          for (;;)
          {
            this.dAT += 1;
            break;
            ram.w("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : peekNextDecodedFrame != null, but pollNextDecodedFrame == null");
          }
        }
        l1 = 0L;
        break label391;
        ram.d("FlowEdit_NeoVideoFilterPlayView", "drawFrameFlow : waiting ∞ ms ( no frame )");
        paramGL10 = null;
        l1 = -1L;
        break label391;
      }
      label688:
      i = 1;
      j = 1;
    }
  }
  
  public alze a()
  {
    this.ENABLE = alzf.aHn;
    ram.w("FlowEdit_NeoVideoFilterPlayView", "NeoVideoFilterPlayView ENABLE = %s", new Object[] { Boolean.valueOf(this.ENABLE) });
    if (this.ENABLE) {
      return new alzy();
    }
    return super.a();
  }
  
  public void dLN()
  {
    if (this.ENABLE) {
      return;
    }
    super.dLN();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.ENABLE)
    {
      c(this.mRunOnDraw);
      e(paramGL10);
      return;
    }
    super.onDrawFrame(paramGL10);
  }
  
  public void pausePlay()
  {
    if (this.ENABLE)
    {
      ram.d("FlowEdit_NeoVideoFilterPlayView", "pausePlay: ");
      this.cuB = true;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.pausePlay();
      return;
    }
    super.pausePlay();
  }
  
  public void resumePlay()
  {
    if (this.ENABLE)
    {
      this.cuB = false;
      this.dm.sendEmptyMessage(1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.resumePlay();
      return;
    }
    super.resumePlay();
  }
  
  public void setPlayListener(b paramb)
  {
    if (paramb != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$b = paramb;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$b = new a();
  }
  
  public void setSpeedType(int paramInt)
  {
    int j = 0;
    int k = this.d.speedType;
    super.setSpeedType(paramInt);
    if ((k == 3) && (paramInt != 3)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        i = j;
        if (k != 3)
        {
          i = j;
          if (paramInt != 3) {}
        }
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        startPlayAudio();
      }
      return;
    }
  }
  
  public void startPlay()
  {
    if (this.ENABLE)
    {
      ram.d("FlowEdit_NeoVideoFilterPlayView", "startPlay: ");
      if (TextUtils.isEmpty(this.d.inputFilePath)) {
        throw new RuntimeException("startPlay failed. videoFilePath is empty.");
      }
      this.jdField_a_of_type_Alze.stopDecode();
      EGLContext localEGLContext = this.jdField_a_of_type_Alzh.a();
      if (localEGLContext != null)
      {
        alzj localalzj = new alzj(this.d);
        localalzj.repeat = true;
        localalzj.a = localEGLContext;
        localalzj.decodeType = 1;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView$c = null;
        ((alzy)this.jdField_a_of_type_Alze).a(localalzj, this.jdField_a_of_type_Alzy$a);
        if (!TextUtils.isEmpty(this.b.audioFilePath)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.b);
        }
        return;
      }
      ram.e("FlowEdit_NeoVideoFilterPlayView", "eglContext is null, ignore start play", new Throwable());
      return;
    }
    super.startPlay();
  }
  
  public static class a
    implements NeoVideoFilterPlayView.b
  {
    public void btC()
    {
      ram.d("FlowEdit_NeoVideoFilterPlayView", "onResetAndStart");
    }
    
    public void ed(int paramInt1, int paramInt2)
    {
      ram.b("FlowEdit_NeoVideoFilterPlayView", "onSpeedChange, old=%d, new=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    
    public void fq(long paramLong) {}
  }
  
  public static abstract interface b
  {
    public abstract void btC();
    
    public abstract void ed(int paramInt1, int paramInt2);
    
    public abstract void fq(long paramLong);
  }
  
  static class c
  {
    private final long aij;
    private final long aik;
    private final int dAU;
    
    private c(long paramLong1, long paramLong2, int paramInt)
    {
      this.aij = paramLong1;
      this.aik = paramLong2;
      this.dAU = paramInt;
    }
    
    public String toString()
    {
      return "VideoTimeStamp{TIME-CLOCK=" + this.aij + ", TIME-FRAME=" + this.aik + ", CYCLE=" + this.dAU + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */