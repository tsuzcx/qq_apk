import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.view.RendererUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

@TargetApi(17)
public class ioz
{
  static int ary = -1;
  final String TAG = "FilterProcessRender_" + AudioHelper.hG();
  private boolean TL = true;
  boolean TM = true;
  public boolean TN;
  private boolean TO;
  private boolean TP;
  AVRedPacketManager jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager;
  DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
  LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
  private iom jdField_a_of_type_Iom;
  private ioq jdField_a_of_type_Ioq;
  private ior jdField_a_of_type_Ior;
  final ioy jdField_a_of_type_Ioy = new ioy();
  private ipa jdField_a_of_type_Ipa;
  private ipc jdField_a_of_type_Ipc;
  private ipe jdField_a_of_type_Ipe;
  private iph jdField_a_of_type_Iph = new iph();
  private final ipj jdField_a_of_type_Ipj = new ipj();
  private jke jdField_a_of_type_Jke;
  byte[] aT;
  byte[] aU;
  byte[] aV;
  int aqX = -1;
  int aqY = -1;
  int arr = -1;
  int ars = -1;
  int art = -1;
  int aru = -1;
  int arv = -1;
  private int arw = -1;
  private int arx = 0;
  private ipc b;
  public int[] cz = new int[8];
  ByteBuffer e = null;
  private Context mContext;
  int mHeight = 0;
  private boolean mIsInited;
  private FloatBuffer mVertexBuffer;
  int mWidth = 0;
  
  public ioz(Context paramContext, ikk paramikk, VideoAppInterface paramVideoAppInterface)
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Jke = new jke();
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)paramVideoAppInterface.a(6));
    this.jdField_a_of_type_Ior = paramVideoAppInterface.a();
    atao.init();
    awtj.init();
    this.jdField_a_of_type_Ipj.a = paramikk;
    this.aqY = -1;
    aoZ();
    this.mContext = paramContext;
  }
  
  private boolean H(boolean paramBoolean)
  {
    if (!ipd.uJ()) {}
    while ((!this.TN) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private ipc a(ipc paramipc)
  {
    if (!ipd.vc()) {
      this.cz[3] = 0;
    }
    do
    {
      return paramipc;
      if (!this.TN)
      {
        this.cz[3] = 0;
        return paramipc;
      }
      localObject = a();
    } while (localObject == null);
    this.arx |= 0x4;
    paramipc = ((DenoiseRender)localObject).process(paramipc.arC, paramipc.arB, this.mWidth, this.mHeight);
    paramipc = ipc.a(paramipc.getFbo(), paramipc.getTextureId());
    this.cz[3] = 1;
    Object localObject = this.cz;
    localObject[5] += 1;
    return paramipc;
  }
  
  private ipc a(ipc paramipc, boolean paramBoolean)
  {
    if (!ipd.uJ()) {
      this.cz[0] = 0;
    }
    do
    {
      return paramipc;
      if ((!this.TN) || (paramBoolean))
      {
        this.cz[0] = 0;
        return paramipc;
      }
      localObject = a();
    } while (localObject == null);
    this.arx |= 0x2;
    paramipc = ((LowLightRender)localObject).process(paramipc.arC, paramipc.arB, this.mWidth, this.mHeight);
    paramipc = ipc.a(paramipc.getFbo(), paramipc.getTextureId());
    this.cz[0] = 1;
    Object localObject = this.cz;
    localObject[2] += 1;
    return paramipc;
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = iqg.a(5);
    iqi[] arrayOfiqi = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.getId());
    ipn.enableBlending(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfiqi[4].handle, 0);
    GLES20.glUniform1f(arrayOfiqi[2].handle, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfiqi[1].handle, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOfiqi[3].handle, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfiqi[0].handle, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfiqi[0].handle);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, byte[] paramArrayOfByte, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ByteBuffer paramByteBuffer, FloatBuffer paramFloatBuffer)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt1 * paramInt2 * 3 / 2) || (paramByteBuffer.capacity() < paramInt1 * paramInt2 * 3 / 2)) {
      return;
    }
    paramByteBuffer.position(0);
    paramByteBuffer.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
    paramByteBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt4);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, paramByteBuffer);
    paramByteBuffer.position(0);
    paramByteBuffer.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
    paramByteBuffer.position(0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramInt5);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6410, paramInt1 / 2, paramInt2 / 2, 0, 6410, 5121, paramByteBuffer);
    GLES20.glBindFramebuffer(36160, paramInt6);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    paramArrayOfByte = iqg.a(1);
    paramByteBuffer = paramArrayOfByte.a();
    GLES20.glUseProgram(paramArrayOfByte.getId());
    GLES20.glUniform1f(paramByteBuffer[2].handle, 1.0F);
    GLES20.glUniform1f(paramByteBuffer[7].handle, paramInt1);
    GLES20.glUniform1f(paramByteBuffer[8].handle, paramInt2);
    GLES20.glUniformMatrix4fv(paramByteBuffer[9].handle, 1, false, paramArrayOfFloat, 0);
    if (paramInt3 == 17)
    {
      GLES20.glUniform1i(paramByteBuffer[10].handle, 3);
      GLES20.glUniform1i(paramByteBuffer[11].handle, 0);
      GLES20.glDisable(3042);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt4);
      GLES20.glUniform1i(paramByteBuffer[4].handle, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, paramInt5);
      GLES20.glUniform1i(paramByteBuffer[5].handle, 1);
      if (paramInt7 % 4 != 1) {
        break label553;
      }
      GLES20.glUniformMatrix4fv(paramByteBuffer[1].handle, 1, false, AVGLUtils.matrixVRotate90, 0);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(paramByteBuffer[3].handle, 1, false, AVGLUtils.matrix, 0);
      GLES20.glVertexAttribPointer(paramByteBuffer[0].handle, 2, 5126, false, 8, paramFloatBuffer);
      GLES20.glEnableVertexAttribArray(paramByteBuffer[0].handle);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(paramByteBuffer[0].handle);
      GLES20.glBindFramebuffer(36160, 0);
      return;
      GLES20.glUniform1i(paramByteBuffer[10].handle, 1);
      break;
      label553:
      GLES20.glUniformMatrix4fv(paramByteBuffer[1].handle, 1, false, AVGLUtils.matrixVRotate270, 0);
    }
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte, ipc paramipc1, ipc paramipc2)
  {
    if ((this.jdField_a_of_type_Ipa != null) && (this.jdField_a_of_type_Ipa.mDebugMode))
    {
      this.jdField_a_of_type_Ipa.a(this, paramInt, paramArrayOfByte, paramipc2.arB, paramipc2.arC);
      this.jdField_a_of_type_Ipa.w(paramInt, paramipc2.arB, paramipc2.arC);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { ipa.aL(paramInt), Integer.valueOf(paramipc1.arB), Integer.valueOf(paramipc2.arB), Integer.valueOf(paramipc1.arC), Integer.valueOf(paramipc2.arC) }));
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if ((ipd.uJ()) || (ipd.vc()))
    {
      this.arx |= 0x1;
      paramArrayOfByte = a(this.TAG, paramArrayOfByte, (int)paramLong, 60, 0.75F);
      j = paramArrayOfByte[0];
      i = paramArrayOfByte[1];
    }
    paramArrayOfByte = this.cz;
    if (j == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.TN) && (bool))
      {
        if (!paramBoolean) {
          paramArrayOfByte[1] += 1;
        }
        paramArrayOfByte[4] += 1;
        igd.aH(this.TAG, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        igd.aH(this.TAG, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
      }
      paramArrayOfByte[6] = i;
      if (j == 0)
      {
        paramArrayOfByte[0] = 0;
        paramArrayOfByte[3] = 0;
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(paramArrayOfByte);
      }
      paramArrayOfByte[7] = ((int)paramLong);
      this.TN = bool;
      return;
    }
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    if (ilj.aoB * ilj.aoC * 3 / 2 != paramArrayOfByte.length)
    {
      igd.aL(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt1, ilj.aoB, ilj.aoC, 60, 0.75F);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "DetectLowlightprocess", paramString);
        paramString = arrayOfInt;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "DetectLowlightprocess", paramString);
        paramString = arrayOfInt;
      }
    }
  }
  
  public static void aoZ()
  {
    if (!iow.uW()) {
      return;
    }
    VideoPrefsUtil.setMaterialMute(true);
  }
  
  private void apa()
  {
    this.TM = jkn.xJ();
    QLog.d(this.TAG, 1, "initUseRBG2I420Switch useRGB2I420Shader = " + this.TM + ",yuvCenterTextureId = " + this.aqY);
    if (this.TM)
    {
      String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.useRGB2I420ShaderCfg.name(), "1");
      QLog.d(this.TAG, 1, "initUseRBG2I420Switch dpcValue = " + str);
      if (str.equals("0")) {
        this.TM = false;
      }
    }
    if (AudioHelper.jY(21) == 1) {
      this.TM = true;
    }
    for (;;)
    {
      QLog.d(this.TAG, 1, "initUseRBG2I420Switch,after getDebugValue, initial useRGB2I420Shader = " + this.TM + ",yuvCenterTextureId = " + this.aqY + ",Build.MODEL = " + Build.MODEL);
      return;
      if (AudioHelper.jY(21) == 0) {
        this.TM = false;
      }
    }
  }
  
  private void apb()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "saveTexture2I420DataBuffer called");
    }
    Object localObject = ByteBuffer.wrap(this.aU);
    GLES20.glBindFramebuffer(36160, this.arv);
    GLES20.glReadPixels(0, 0, this.mHeight * 2 / 8, this.mWidth, 6408, 5121, (Buffer)localObject);
    localObject = this.aV;
    ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject);
    GLES20.glReadPixels(this.mHeight * 2 / 8, 0, this.mHeight * 1 / 8, this.mWidth, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    System.arraycopy(localObject, 0, this.aU, this.mHeight * this.mWidth, localObject.length);
  }
  
  private void apc()
  {
    if (this.mVertexBuffer != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-0.5F + 0.0F);
    arrayOfFloat[1] = (-0.5F + 0.0F);
    arrayOfFloat[2] = (0.5F + 0.0F);
    arrayOfFloat[3] = (-0.5F + 0.0F);
    arrayOfFloat[4] = (-0.5F + 0.0F);
    arrayOfFloat[5] = (0.5F + 0.0F);
    arrayOfFloat[6] = (0.5F + 0.0F);
    arrayOfFloat[7] = (0.5F + 0.0F);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put(arrayOfFloat);
    this.mVertexBuffer.position(0);
  }
  
  private void apd()
  {
    if ((this.jdField_a_of_type_Ipc != this.b) && (this.jdField_a_of_type_Ipc != null))
    {
      this.jdField_a_of_type_Ipc.recycle();
      this.jdField_a_of_type_Ipc = null;
    }
    this.jdField_a_of_type_Ipc = this.b;
  }
  
  static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = iqg.a(6);
    iqi[] arrayOfiqi = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.getId());
    ipn.enableBlending(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfiqi[4].handle, 0);
    GLES20.glUniform1f(arrayOfiqi[2].handle, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfiqi[1].handle, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOfiqi[3].handle, 1, false, AVGLUtils.matrix, 0);
    GLES20.glUniform1f(arrayOfiqi[7].handle, paramInt1);
    GLES20.glUniform1f(arrayOfiqi[8].handle, paramInt2);
    GLES20.glVertexAttribPointer(arrayOfiqi[0].handle, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfiqi[0].handle);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      ahbj.f(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static int j(boolean paramBoolean)
  {
    int j = 1;
    if (ary == -1)
    {
      ioj localioj = ioj.a();
      if ((localioj == null) || (!localioj.uI())) {
        break label47;
      }
    }
    label47:
    for (ary = 1;; ary = 0)
    {
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (ary != 1) {
          i = 3;
        }
      }
      return i;
    }
  }
  
  private void s(long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || ((this.mWidth == paramInt1) && (this.mHeight == paramInt2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "innerUpdatePreviewSize, width[" + this.mWidth + "->" + paramInt1 + "], height[" + this.mHeight + "->" + paramInt2 + "], seq[" + paramLong + "]");
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.aqX = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.aqY);
    if (this.TM) {
      this.arv = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.arw);
    }
    for (;;)
    {
      apc();
      atao.init();
      if (this.jdField_a_of_type_Iom == null) {
        break;
      }
      this.jdField_a_of_type_Iom.updateWidthHeight(paramInt1, paramInt2);
      return;
      this.aru = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.art);
    }
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private boolean vb()
  {
    if (!ipd.vc()) {}
    while (!this.TN) {
      return false;
    }
    return true;
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(VideoController.a().getAppContext());
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(ipd.S());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(VideoController.a().getAppContext());
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  public ioz.a a(ios paramios, FilterDesc paramFilterDesc, VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PendantItem paramPendantItem, iow paramiow)
  {
    if (this.jdField_a_of_type_Ipa != null) {
      this.jdField_a_of_type_Ipa.ape();
    }
    if (this.jdField_a_of_type_Jke != null) {
      this.jdField_a_of_type_Jke.axq();
    }
    long l = System.currentTimeMillis();
    s(0L, paramios.height, paramios.width);
    int k = paramios.width;
    int m = paramios.height;
    Object localObject = paramios.data;
    int j = j(paramios.TF);
    if ((paramBoolean1) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.vv())) {}
    int i;
    for (boolean bool2 = true;; bool2 = false)
    {
      i = this.jdField_a_of_type_Ior.at("BEAUTY_SKIN");
      this.jdField_a_of_type_Iph.a(this.TAG, paramios.mo, k, m, paramios.angle, paramBoolean1, paramFilterDesc, paramVideoMaterial, paramPendantItem, paramios, i);
      if ((this.mWidth != 0) && (this.mHeight != 0) && (localObject != null) && (this.aqX != -1) && (this.mIsInited)) {
        break;
      }
      return null;
    }
    this.TO = true;
    jjo localjjo = paramios.b;
    if (localjjo != null) {
      localjjo.nI(j);
    }
    this.jdField_a_of_type_Ioy.clear(k, m);
    if (this.jdField_a_of_type_Ipa != null)
    {
      this.jdField_a_of_type_Ipa.apg();
      this.jdField_a_of_type_Ipa.a(this, 0, (byte[])localObject, -1, -1);
    }
    boolean bool1;
    if (this.jdField_a_of_type_Ioq != null)
    {
      this.jdField_a_of_type_Ioq.ll(i);
      if (this.jdField_a_of_type_Iom != null) {
        this.jdField_a_of_type_Iom.a(null);
      }
      bool1 = this.jdField_a_of_type_Ioq.cq(i);
      paramBoolean1 = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Jke != null) {
        this.jdField_a_of_type_Jke.kK("checkLowLight");
      }
      a((byte[])localObject, paramios.mn, paramios.TF);
      if (localjjo != null) {
        localjjo.axm();
      }
      if (this.jdField_a_of_type_Jke != null) {
        this.jdField_a_of_type_Jke.kL("checkLowLight");
      }
      if (this.jdField_a_of_type_Ioq != null)
      {
        if (this.jdField_a_of_type_Jke != null) {
          this.jdField_a_of_type_Jke.kK("applyBeauty20");
        }
        paramios.data = this.jdField_a_of_type_Ioq.a(this.mWidth, this.mHeight, (byte[])localObject, paramFilterDesc, i);
        if (paramios.data != localObject) {
          this.arx |= 0x8;
        }
        if (localjjo != null) {
          if (paramios.data == localObject) {
            break label699;
          }
        }
      }
      label699:
      for (boolean bool3 = true;; bool3 = false)
      {
        localjjo.lc(bool3);
        if (this.jdField_a_of_type_Jke != null) {
          this.jdField_a_of_type_Jke.kL("applyBeauty20");
        }
        if (this.jdField_a_of_type_Ipa != null) {
          this.jdField_a_of_type_Ipa.a(this, 11, paramios.data, -1, -1);
        }
        if (((paramFilterDesc != null) || (paramVideoMaterial != null) || (bool2) || (bool1) || (paramBoolean1) || (this.TN)) && (iow.uW()) && (ikx.tM())) {
          break label705;
        }
        paramios.width = this.mHeight;
        paramios.height = this.mWidth;
        if (this.jdField_a_of_type_Ipa != null)
        {
          this.jdField_a_of_type_Ipa.a(this, 5, paramios.data, -1, -1);
          this.jdField_a_of_type_Ipa.aph();
        }
        this.TO = false;
        paramios.ari = ((int)(System.currentTimeMillis() - l));
        paramios.arj = this.arx;
        if (this.e != null) {
          this.e.clear();
        }
        this.e = null;
        this.aT = null;
        if (this.TM)
        {
          this.aU = null;
          this.aV = null;
        }
        if (this.jdField_a_of_type_Jke != null) {
          this.jdField_a_of_type_Jke.ed(paramios.mo);
        }
        ird.a().lu(this.arx);
        return new ioz.a(paramios, null, null, null, (short)0, (short)0);
        if (this.jdField_a_of_type_Iom == null) {
          break label2311;
        }
        paramBoolean1 = this.jdField_a_of_type_Iom.a(this.jdField_a_of_type_Ior);
        bool1 = false;
        break;
      }
      label705:
      j = k * m * 3 / 2;
      if (this.TM)
      {
        if ((this.aU == null) || (this.aU.length != j)) {
          this.aU = new byte[j];
        }
        k = k * m * 1 / 2;
        if ((this.aV == null) || (this.aV.length != k)) {
          this.aV = new byte[k];
        }
        if ((this.e != null) && (this.e.capacity() != j))
        {
          this.e.clear();
          this.e = null;
        }
        if (this.e == null) {
          this.e = ByteBuffer.allocate(j);
        }
        if (this.jdField_a_of_type_Jke != null) {
          this.jdField_a_of_type_Jke.kK("preRender");
        }
        c(paramios);
        if (this.b != null) {
          break label2256;
        }
        this.b = ipc.a(this.aqX, this.aqY);
        label876:
        if (this.jdField_a_of_type_Jke != null) {
          this.jdField_a_of_type_Jke.kL("preRender");
        }
        if (this.jdField_a_of_type_Ipa != null)
        {
          this.jdField_a_of_type_Ipa.w(9, this.aqX, this.aqY);
          this.jdField_a_of_type_Ipa.w(10, this.aru, this.art);
          this.jdField_a_of_type_Ipa.a(this, 1, paramios.data, this.aqX, this.aqY);
        }
        apd();
        if (vb())
        {
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kK("appleVideoDenoise");
          }
          this.b = a(this.jdField_a_of_type_Ipc);
          if (localjjo != null)
          {
            if (this.b.arC == this.jdField_a_of_type_Ipc.arC) {
              break label2281;
            }
            bool1 = true;
            label1020:
            localjjo.ld(bool1);
          }
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kL("appleVideoDenoise");
          }
          a(6, null, this.jdField_a_of_type_Ipc, this.b);
        }
        apd();
        if (H(paramios.TF))
        {
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kK("appleLowlightEnhance");
          }
          this.b = a(this.jdField_a_of_type_Ipc, paramios.TF);
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kL("appleLowlightEnhance");
          }
          a(7, null, this.jdField_a_of_type_Ipc, this.b);
        }
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.cz);
        if (localjjo != null)
        {
          if (this.b.arC == this.jdField_a_of_type_Ipc.arC) {
            break label2287;
          }
          bool1 = true;
          label1174:
          localjjo.le(bool1);
        }
        apd();
        if (this.jdField_a_of_type_Ioq != null)
        {
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kK("applyBeauty30");
          }
          this.b = this.jdField_a_of_type_Ioq.a(this.mWidth, this.mHeight, this.jdField_a_of_type_Ipc, paramFilterDesc, i);
          if (this.b.arC != this.jdField_a_of_type_Ipc.arC) {
            this.arx |= 0x8;
          }
          if (localjjo != null)
          {
            if (this.b.arC == this.jdField_a_of_type_Ipc.arC) {
              break label2293;
            }
            bool1 = true;
            label1288:
            localjjo.lf(bool1);
          }
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kL("applyBeauty30");
          }
          a(8, null, this.jdField_a_of_type_Ipc, this.b);
        }
        bool3 = false;
        bool1 = bool3;
        if (paramPendantItem != null)
        {
          bool1 = bool3;
          if (paramVideoMaterial != null) {
            bool1 = paramPendantItem.needHMirror;
          }
        }
        apd();
        if ((this.jdField_a_of_type_Iom != null) && ((paramBoolean1) || (paramFilterDesc != null) || (paramPendantItem != null) || (paramVideoMaterial != null) || (bool2)))
        {
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kK("drawFrameInGL");
          }
          this.jdField_a_of_type_Ioy.needHMirror = bool1;
          if ((bool1) && (this.jdField_a_of_type_Ipe != null))
          {
            if (this.jdField_a_of_type_Jke != null) {
              this.jdField_a_of_type_Jke.kK("mirrorIn");
            }
            localObject = this.jdField_a_of_type_Ipe.a(this.jdField_a_of_type_Ipc, this.mWidth, this.mHeight);
            if (localObject != null)
            {
              a(12, null, this.jdField_a_of_type_Ipc, (ipc)localObject);
              this.jdField_a_of_type_Ipc.arB = ((ipc)localObject).arB;
              this.jdField_a_of_type_Ipc.arC = ((ipc)localObject).arC;
              ((ipc)localObject).recycle();
            }
            if (this.jdField_a_of_type_Jke != null) {
              this.jdField_a_of_type_Jke.kL("mirrorIn");
            }
          }
          this.jdField_a_of_type_Iom.a(paramFilterDesc);
          this.jdField_a_of_type_Iom.a(paramPendantItem, paramVideoMaterial);
          this.jdField_a_of_type_Iom.iC(bool2);
          this.jdField_a_of_type_Iom.bE(this.aqX, this.aqY);
          this.b = ipc.a(this.jdField_a_of_type_Ipc.arB, this.jdField_a_of_type_Ipc.arC);
          this.b.arC = this.jdField_a_of_type_Iom.a(this.jdField_a_of_type_Ipc.arC, false, this.jdField_a_of_type_Ioy, paramBoolean2);
          if (this.jdField_a_of_type_Iom.uN()) {
            this.arx |= 0x80;
          }
          if (paramFilterDesc != null) {
            this.arx |= 0x10;
          }
          if ((paramPendantItem != null) || (paramVideoMaterial != null)) {
            this.arx |= 0x20;
          }
          if (this.jdField_a_of_type_Iom.isNeedFaceDetect()) {
            this.arx |= 0x40;
          }
          if (paramBoolean1) {
            this.arx |= 0x8;
          }
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kL("drawFrameInGL");
          }
          if (localjjo != null)
          {
            if (paramFilterDesc == null) {
              break label2299;
            }
            paramBoolean2 = true;
            label1756:
            if (paramVideoMaterial == null) {
              break label2305;
            }
          }
        }
      }
      label2305:
      for (bool3 = true;; bool3 = false)
      {
        localjjo.b(paramBoolean2, bool3, bool2, paramBoolean1);
        a(2, null, this.jdField_a_of_type_Ipc, this.b);
        if ((this.TP) && (this.jdField_a_of_type_Ipe != null))
        {
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kK("mirrorOut");
          }
          paramFilterDesc = this.jdField_a_of_type_Ipe.a(this.b, this.mWidth, this.mHeight);
          if (paramFilterDesc != null)
          {
            a(13, null, this.b, paramFilterDesc);
            this.b.arB = paramFilterDesc.arB;
            this.b.arC = paramFilterDesc.arC;
            paramFilterDesc.recycle();
          }
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kL("mirrorOut");
          }
        }
        this.TP = bool1;
        if ((bool2) || (paramVideoMaterial != null))
        {
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kK("faceDetect");
          }
          if ((this.jdField_a_of_type_Ioy.facecount > 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.vv()))
          {
            if ((this.jdField_a_of_type_Ioy.fm != null) && (this.jdField_a_of_type_Ioy.fm.size() > 0) && (this.jdField_a_of_type_Ioy.faceAngles != null) && (this.jdField_a_of_type_Ioy.faceAngles.length > 0)) {
              this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_a_of_type_Ioy.fm, this.jdField_a_of_type_Ioy.faceAngles);
            }
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.A(this.aqY, this.mWidth, this.mHeight);
          }
          if (this.jdField_a_of_type_Iom != null) {
            this.jdField_a_of_type_Iom.a(paramiow, this.jdField_a_of_type_Ioy);
          }
          if (this.jdField_a_of_type_Jke != null) {
            this.jdField_a_of_type_Jke.kL("faceDetect");
          }
        }
        if (this.jdField_a_of_type_Jke != null) {
          this.jdField_a_of_type_Jke.kK("postRender");
        }
        paramFilterDesc = a(paramios, this.b, this.jdField_a_of_type_Ioy);
        if (this.jdField_a_of_type_Jke != null) {
          this.jdField_a_of_type_Jke.kL("postRender");
        }
        if ((paramFilterDesc != null) && (this.jdField_a_of_type_Ipa != null))
        {
          this.jdField_a_of_type_Ipa.a(this, 4, null, this.aru, this.art);
          this.jdField_a_of_type_Ipa.aph();
        }
        this.TO = false;
        if (paramFilterDesc != null)
        {
          paramFilterDesc.ari = ((int)(System.currentTimeMillis() - l));
          paramFilterDesc.arj = this.arx;
        }
        if (this.jdField_a_of_type_Jke != null) {
          this.jdField_a_of_type_Jke.ed(paramios.mo);
        }
        ird.a().lu(this.arx);
        return paramFilterDesc;
        k = k * m * 4;
        if ((this.aT != null) && (this.aT.length == k)) {
          break;
        }
        this.aT = new byte[k];
        break;
        label2256:
        this.b.arB = this.aqX;
        this.b.arC = this.aqY;
        break label876;
        label2281:
        bool1 = false;
        break label1020;
        label2287:
        bool1 = false;
        break label1174;
        label2293:
        bool1 = false;
        break label1288;
        label2299:
        paramBoolean2 = false;
        break label1756;
      }
      label2311:
      paramBoolean1 = false;
      bool1 = false;
    }
  }
  
  ioz.a a(ios paramios, ipc paramipc, ioy paramioy)
  {
    if (this.TM)
    {
      b(this.mWidth, this.mHeight, paramipc.arC, this.arv, this.mVertexBuffer);
      apb();
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, paramios.width, paramios.height);
      paramipc = null;
      if (!this.TL)
      {
        paramios.data = this.aT;
        paramios.width = this.mHeight;
        paramios.height = this.mWidth;
        paramios.format = 21;
        if (this.TM)
        {
          paramios.format = 100;
          paramios.data = this.aU;
        }
        paramios.angle = ((paramios.angle - j(paramios.TF) - 1 + 4) % 4);
        paramipc = new ioz.a(paramios, paramioy.aQ, paramioy.aR, paramioy.aS, paramioy.A, paramioy.B);
      }
      this.TL = false;
      return paramipc;
      a(this.mWidth, this.mHeight, paramipc.arC, this.aru, this.mVertexBuffer);
      saveTextureToRgbaBuffer(this.aru, this.mHeight, this.mWidth, this.aT);
    }
  }
  
  void aoJ()
  {
    if (this.jdField_a_of_type_Iom != null) {
      this.jdField_a_of_type_Iom.aoJ();
    }
  }
  
  void c(ios paramios)
  {
    a(this.mHeight, this.mWidth, ilj.aoD, YUVTexture.ab, paramios.data, this.arr, this.ars, this.aqX, j(paramios.TF), this.e, this.mVertexBuffer);
    GLES20.glViewport(0, 0, paramios.width, paramios.height);
  }
  
  void cp(long paramLong)
  {
    if (this.jdField_a_of_type_Iom != null)
    {
      this.jdField_a_of_type_Iom.cp(paramLong);
      return;
    }
    this.jdField_a_of_type_Ipj.cp(paramLong);
  }
  
  public void ct(long paramLong)
  {
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "initial, szie[" + this.mWidth + ", " + this.mHeight + "], id[" + this.aqY + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Ipa != null) {
      this.jdField_a_of_type_Ipa.ape();
    }
    apa();
    this.mIsInited = true;
    this.TO = false;
    if (this.aqY != -1) {
      return;
    }
    label192:
    label239:
    int[] arrayOfInt;
    if (iow.uW()) {
      if (this.jdField_a_of_type_Iom == null)
      {
        boolean bool = AEFilterSupport.uP();
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "initial, usePtuNew[" + bool + "]");
        }
        if (bool)
        {
          this.jdField_a_of_type_Iom = new ion(this.jdField_a_of_type_Ipj);
          this.jdField_a_of_type_Iom.initInGL(this.mWidth, this.mHeight);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Iom.uO()) {
          break label338;
        }
        if (this.jdField_a_of_type_Ioq == null) {
          this.jdField_a_of_type_Ioq = new ioq();
        }
        arrayOfInt = new int[4];
        GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
        this.aqY = arrayOfInt[0];
        this.arr = arrayOfInt[2];
        this.ars = arrayOfInt[3];
        if (!this.TM) {
          break label374;
        }
        this.arw = arrayOfInt[1];
      }
    }
    for (;;)
    {
      this.arx = 0;
      if (this.jdField_a_of_type_Ipe != null) {
        break;
      }
      this.jdField_a_of_type_Ipe = new ipe();
      return;
      this.jdField_a_of_type_Iom = new ioo(this.mContext, this.jdField_a_of_type_Ipj);
      break label192;
      label338:
      if (this.jdField_a_of_type_Ioq != null) {
        this.jdField_a_of_type_Ioq.destroy();
      }
      this.jdField_a_of_type_Ioq = null;
      break label239;
      this.jdField_a_of_type_Ioq = new ioq();
      break label239;
      label374:
      this.art = arrayOfInt[1];
    }
  }
  
  public void cu(long paramLong)
  {
    QLog.w(this.TAG, 1, "clear, seq[" + paramLong + "]");
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.aqX != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.aqX }, 0);
      this.aqX = -1;
    }
    int[] arrayOfInt;
    if (this.aqY != -1)
    {
      arrayOfInt = new int[3];
      arrayOfInt[0] = this.aqY;
      arrayOfInt[1] = this.arr;
      arrayOfInt[2] = this.ars;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.arr = -1;
      this.ars = -1;
      this.aqY = -1;
    }
    if (this.TM)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.arw;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.arw = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.arv }, 0);
      this.arv = -1;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.destroy();
        this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender.destroy();
        this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
      }
      if (this.jdField_a_of_type_Ioq != null)
      {
        this.jdField_a_of_type_Ioq.destroy();
        this.jdField_a_of_type_Ioq = null;
      }
      if (this.jdField_a_of_type_Iom != null)
      {
        this.jdField_a_of_type_Iom.aoI();
        this.jdField_a_of_type_Iom = null;
      }
      if (this.jdField_a_of_type_Ipe != null)
      {
        this.jdField_a_of_type_Ipe.aoI();
        this.jdField_a_of_type_Ipe = null;
      }
      this.jdField_a_of_type_Ipj.cp(paramLong);
      return;
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.art;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.art = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.aru }, 0);
      this.aru = -1;
    }
  }
  
  public void r(long paramLong, int paramInt1, int paramInt2) {}
  
  void uninit()
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "uninit, mIsInited[" + this.mIsInited + "], mIsRendering[" + this.TO + "], seq[" + l + "]");
    if (!this.mIsInited) {}
    do
    {
      return;
      this.mIsInited = false;
      if (this.jdField_a_of_type_Ipa != null) {
        this.jdField_a_of_type_Ipa.apf();
      }
      this.aT = null;
      if (this.TM)
      {
        this.aU = null;
        this.aV = null;
      }
      if (this.e != null)
      {
        this.e.clear();
        this.e = null;
      }
      cp(l);
      if (this.jdField_a_of_type_Ioq != null) {
        this.jdField_a_of_type_Ioq.clear();
      }
      if (this.jdField_a_of_type_Iom != null) {
        this.jdField_a_of_type_Iom.aoH();
      }
    } while (this.jdField_a_of_type_Jke == null);
    this.jdField_a_of_type_Jke.apf();
  }
  
  public static class a
    extends ios
  {
    short C;
    short D;
    byte[] aQ;
    byte[] aR;
    byte[] aS;
    
    a(ios paramios, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
    {
      super();
      this.aQ = paramArrayOfByte1;
      this.aR = paramArrayOfByte2;
      this.aS = paramArrayOfByte3;
      this.C = paramShort1;
      this.D = paramShort2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioz
 * JD-Core Version:    0.7.0.1
 */