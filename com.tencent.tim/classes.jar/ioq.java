import com.tencent.av.VideoController;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.BeautyNative;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ioq
{
  BeautyRender a = null;
  int ard = 0;
  int are = 0;
  Beauty20Render mBeauty20Render = null;
  
  public ioq()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "AVSDKBeautyRender");
    }
  }
  
  public Beauty20Render a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.are = 0;
      return null;
    }
    if (this.mBeauty20Render == null) {
      this.mBeauty20Render = new Beauty20Render(VideoController.a().getAppContext());
    }
    if (paramInt == this.are) {
      return this.mBeauty20Render;
    }
    this.mBeauty20Render.setBeautyLevel(paramInt * 1.0F / 100.0F);
    this.are = paramInt;
    return this.mBeauty20Render;
  }
  
  public BeautyRender a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.ard = 0;
      return null;
    }
    if (this.a == null) {
      this.a = new BeautyRender(VideoController.a().getAppContext(), igg.gB());
    }
    if (paramInt == this.ard) {
      return this.a;
    }
    this.a.setBeautyLevel(paramInt * 1.0F / 100.0F * iou.Q());
    this.ard = paramInt;
    return this.a;
  }
  
  public ipc a(int paramInt1, int paramInt2, ipc paramipc, FilterDesc paramFilterDesc, int paramInt3)
  {
    if (!iou.uB()) {}
    BeautyRender localBeautyRender;
    do
    {
      do
      {
        return paramipc;
      } while ((paramFilterDesc != null) && (paramFilterDesc.id == 3));
      localBeautyRender = a(paramInt3);
    } while (localBeautyRender == null);
    GraphicRenderMgr.getInstance().setBeautyFlag(2);
    if ((paramFilterDesc != null) && ((paramFilterDesc.id == 1) || (paramFilterDesc.id == 2))) {
      localBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      paramipc = localBeautyRender.process(paramipc.arC, paramipc.arB, paramInt1, paramInt2);
      return ipc.a(paramipc.getFbo(), paramipc.getTextureId());
      localBeautyRender.setNeedSkinColor(true);
    }
  }
  
  public byte[] a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, FilterDesc paramFilterDesc, int paramInt3)
  {
    if (iou.uB()) {}
    while ((paramFilterDesc != null) && (paramFilterDesc.id == 3)) {
      return paramArrayOfByte;
    }
    if (paramInt2 * paramInt1 * 3 / 2 != paramArrayOfByte.length)
    {
      igd.aL("AVSDKBeautyRender", "(mHeight * mWidth * 3 / 2) != yuvData.length");
      return paramArrayOfByte;
    }
    paramFilterDesc = a(paramInt3);
    EffectFrame localEffectFrame1;
    if (paramFilterDesc != null)
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(1);
      localEffectFrame1 = new EffectFrame();
      localEffectFrame1.frameData = paramArrayOfByte;
      localEffectFrame1.frameWidth = paramInt2;
      localEffectFrame1.frameHeight = paramInt1;
      if (ilj.aoD == 17)
      {
        paramArrayOfByte = ColorFormat.NV21;
        localEffectFrame1.frameFormat = paramArrayOfByte;
        EffectFrame localEffectFrame2 = paramFilterDesc.processData(localEffectFrame1);
        paramFilterDesc = localEffectFrame2.frameData;
        paramArrayOfByte = paramFilterDesc;
        if (localEffectFrame2.frameFormat != ColorFormat.I420) {}
      }
    }
    for (;;)
    {
      try
      {
        if (ilj.aoD == 17)
        {
          paramArrayOfByte = BeautyNative.convertI420ToNV21(paramFilterDesc, paramInt2, paramInt1);
          return paramArrayOfByte;
          paramArrayOfByte = ColorFormat.NV12;
          break;
        }
        paramArrayOfByte = BeautyNative.convertI420ToNV12(paramFilterDesc, paramInt2, paramInt1);
      }
      catch (Throwable paramArrayOfByte)
      {
        igd.aL("AVSDKBeautyRender", "convertI420ToNV21 or convertI420ToNV12 e = " + paramArrayOfByte.getMessage());
        paramArrayOfByte = localEffectFrame1.frameData;
      }
    }
  }
  
  public void clear()
  {
    GraphicRenderMgr.getInstance().setBeautyFlag(0);
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "clear");
    }
  }
  
  public boolean cq(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (iou.uB())
    {
      bool1 = bool2;
      if (paramInt > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void destroy()
  {
    clear();
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
    if (this.mBeauty20Render != null)
    {
      this.mBeauty20Render.destroy();
      this.mBeauty20Render = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "destroy");
    }
  }
  
  public void ll(int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (!AudioHelper.aCz()) {
        return;
      }
      QLog.w("AVSDKBeautyRender", 1, "setBeautyLevel, UnsatisfiedLinkError");
      return;
      GraphicRenderMgr.getInstance().setBeautyFlag(1);
    }
    if (iou.uB())
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioq
 * JD-Core Version:    0.7.0.1
 */