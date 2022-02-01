import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator.1;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.view.RendererUtils;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class rig
  extends rhz
{
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  rif jdField_a_of_type_Rif = null;
  boolean aHZ = false;
  boolean aIa = false;
  boolean aIb = false;
  public boolean aIc;
  boolean aId = true;
  boolean aIe = false;
  public boolean aIf;
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  rhw jdField_b_of_type_Rhw;
  int brQ = 0;
  public int brR = this.mWidth;
  ConcurrentHashMap<String, VideoFilterBase> cl = new ConcurrentHashMap();
  Frame e = new Frame();
  protected int[] ed = new int[2];
  int[] ee = new int[1];
  int[] ef = new int[1];
  int[] eg = new int[1];
  Frame f = new Frame();
  Frame g = new Frame();
  protected double mAspectRatio = 0.75D;
  int mCount = 0;
  public int mHeight;
  Frame mTempFrame = new Frame();
  public int mWidth;
  int mWindowHeight = 480;
  int mWindowWidth = 320;
  VideoMaterial material;
  
  public rig(rhw paramrhw)
  {
    this.jdField_b_of_type_Rhw = paramrhw;
  }
  
  public static VideoFilterBase a(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    do
    {
      return null;
      if (paramVideoMaterial.getShaderType() == 13) {
        return b(paramVideoMaterial);
      }
      if (paramVideoMaterial.getShaderType() == 15) {
        return c(paramVideoMaterial);
      }
    } while (paramVideoMaterial.getShaderType() != 14);
    return d(paramVideoMaterial);
  }
  
  static VideoFilterBase b(VideoMaterial paramVideoMaterial)
  {
    rie localrie = null;
    DoodleItem localDoodleItem = paramVideoMaterial.getDoodleItem();
    if (localDoodleItem != null) {
      localrie = new rie(localDoodleItem, paramVideoMaterial.getDataPath());
    }
    return localrie;
  }
  
  static VideoFilterBase c(VideoMaterial paramVideoMaterial)
  {
    return new ric();
  }
  
  static VideoFilterBase d(VideoMaterial paramVideoMaterial)
  {
    return new rid(paramVideoMaterial.getDoodleItem(), paramVideoMaterial.getDataPath());
  }
  
  public void ApplyGLSLFilter(String paramString)
  {
    if (this.cl.isEmpty()) {
      return;
    }
    paramString = (VideoFilterBase)this.cl.get(paramString);
    paramString.ApplyGLSLFilter();
    paramString.setRenderMode(1);
  }
  
  public void a(int paramInt1, int paramInt2, rif paramrif)
  {
    if ((this.cl == null) || (this.cl.size() < 1)) {
      return;
    }
    Frame localFrame = new Frame(this.e.getFBO(), this.e.getTextureId(), paramInt1, paramInt2);
    GlUtil.setBlendMode(true);
    GLES20.glBindFramebuffer(36160, this.e.getFBO());
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramrif.mCacheFrame.getTextureId(), paramInt1, paramInt2, this.e.getTextureId(), 1.0D, localFrame);
    GlUtil.setBlendMode(false);
    paramrif.aHV = true;
  }
  
  public void a(Frame paramFrame, int paramInt1, int paramInt2, rif paramrif)
  {
    if ((this.cl == null) || (this.cl.size() < 1)) {
      return;
    }
    GlUtil.setBlendMode(true);
    GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
    ArrayList localArrayList = new ArrayList();
    boolean bool = paramrif.aHX;
    localArrayList.addAll(paramrif.w);
    Object localObject = (VideoFilterBase)this.cl.get(paramrif.mId);
    if ((localObject instanceof rie))
    {
      localObject = (rie)localObject;
      ((rie)localObject).setTouchPoints(localArrayList);
      ((rie)localObject).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
      if (bool)
      {
        this.e.bindFrame(this.ef[0], paramInt1, paramInt2, 1.0D);
        GLES20.glBindFramebuffer(36160, this.e.getFBO());
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        ((rie)localObject).setTouchPoints(paramrif.w);
        ((rie)localObject).renderTexture(this.e.getTextureId(), paramInt1, paramInt2);
        paramrif.buI();
      }
    }
    for (;;)
    {
      GlUtil.setBlendMode(false);
      if ((!paramrif.aHX) || (!paramrif.aHW)) {
        break;
      }
      paramFrame = paramrif.b(paramInt1, paramInt2);
      t(paramFrame.getFBO(), paramFrame.getTextureId(), paramInt1, paramInt2);
      return;
      if ((localObject instanceof ric))
      {
        localObject = (ric)localObject;
        ((ric)localObject).buF();
        ((ric)localObject).a(localArrayList, bool, paramrif);
        GLES20.glViewport(0, 0, paramInt1, paramInt2);
        GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
        ((ric)localObject).renderTexture(paramFrame.getTextureId(), paramInt1, paramInt2);
        if (bool)
        {
          this.e.bindFrame(this.ef[0], paramInt1, paramInt2, 1.0D);
          GLES20.glBindFramebuffer(36160, this.e.getFBO());
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          ((ric)localObject).xy(this.e.getTextureId());
          paramrif.buI();
        }
      }
      else if ((localObject instanceof rid))
      {
        localObject = (rid)localObject;
        ((rid)localObject).setTouchPoints(localArrayList);
        rih.a(this.f, this.eg[0], paramInt1, paramInt2, true);
        ((rid)localObject).Lz();
        rih.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, paramFrame, this.f, this.eg[0], paramInt1, paramInt2);
        if (bool)
        {
          ((rid)localObject).setTouchPoints(paramrif.w);
          this.e.bindFrame(this.ef[0], paramInt1, paramInt2, 1.0D);
          rih.a(this.jdField_a_of_type_ComTencentFilterBaseFilter, this.e, this.f, this.eg[0], paramInt1, paramInt2);
          paramrif.buI();
        }
      }
    }
  }
  
  public void a(rif paramrif)
  {
    if ((paramrif.aHX) && (paramrif.aHV)) {}
    do
    {
      do
      {
        return;
      } while (this.aIa);
      if ((!paramrif.aHV) && (paramrif.UL))
      {
        if (paramrif.aHW) {
          a(this.mWidth, this.mHeight, paramrif);
        }
        this.aIe = true;
        return;
      }
    } while (paramrif.w.size() <= 1);
    a(this.mTempFrame, this.mWidth, this.mHeight, paramrif);
  }
  
  public void apk()
  {
    this.aHZ = true;
    this.mCount = 0;
    if (this.jdField_b_of_type_Rhw != null) {
      this.jdField_b_of_type_Rhw.buo();
    }
  }
  
  public void buJ()
  {
    this.mTempFrame.bindFrame(this.ed[0], this.mWidth, this.mHeight, this.mAspectRatio);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.mTempFrame.getTextureId(), this.mWidth, this.mHeight, 0, this.mAspectRatio, this.g);
    if (!this.aIa)
    {
      if (!this.aHZ) {
        break label122;
      }
      this.e.bindFrame(this.ef[0], this.mWidth, this.mHeight, 1.0D);
      rih.buM();
      this.aHZ = false;
    }
    for (;;)
    {
      this.aIe = false;
      return;
      label122:
      t(this.mTempFrame.getFBO(), this.mTempFrame.getTextureId(), this.mWidth, this.mHeight);
    }
  }
  
  public void buK()
  {
    if (this.aIe) {
      t(this.mTempFrame.getFBO(), this.mTempFrame.getTextureId(), this.mWidth, this.mHeight);
    }
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.mTempFrame.getTextureId(), this.mWindowWidth, this.mWindowHeight, 0, this.mAspectRatio, this.g);
    if ((this.jdField_b_of_type_Rhw != null) && ((this.jdField_b_of_type_Rhw instanceof rhy))) {
      ((rhy)this.jdField_b_of_type_Rhw).bus();
    }
    Object localObject4;
    Object localObject5;
    Bitmap localBitmap1;
    long l1;
    if (this.aIf)
    {
      this.aIf = false;
      localObject4 = null;
      localObject5 = null;
      localBitmap1 = null;
      if (QLog.isColorLevel()) {
        QLog.d("PersonalityOperator", 2, "capture personality start");
      }
      l1 = System.currentTimeMillis();
      localObject3 = localObject4;
      localObject2 = localObject5;
    }
    try
    {
      Bitmap localBitmap2 = c(0, 0, this.mWindowWidth, this.mWindowHeight);
      if (localBitmap2 != null)
      {
        localObject3 = localObject4;
        localObject2 = localObject5;
        localBitmap1 = rop.b(localBitmap2, 1.0F * this.brR / this.mWindowWidth, true);
      }
      localObject3 = localBitmap1;
      localObject2 = localBitmap1;
      this.aIc = false;
      if (this.jdField_b_of_type_Rhw != null) {
        this.jdField_b_of_type_Rhw.v(localBitmap1);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        long l2;
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject3;
          QLog.e("Personality", 2, localThrowable, new Object[0]);
        }
        if (this.jdField_b_of_type_Rhw != null) {
          this.jdField_b_of_type_Rhw.v((Bitmap)localObject3);
        }
      }
    }
    finally
    {
      if (this.jdField_b_of_type_Rhw == null) {
        break label331;
      }
      this.jdField_b_of_type_Rhw.v((Bitmap)localObject2);
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PersonalityOperator", 2, "capture personality end " + (l2 - l1));
    }
  }
  
  public void buL()
  {
    this.aIa = true;
    if (this.jdField_b_of_type_Rhw != null) {
      this.jdField_b_of_type_Rhw.buo();
    }
  }
  
  public void bum()
  {
    this.aHZ = true;
    this.mCount -= 1;
    if (this.jdField_b_of_type_Rhw != null) {
      this.jdField_b_of_type_Rhw.buo();
    }
  }
  
  public Bitmap c(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = RendererUtils.saveTexture(this.mTempFrame.getTextureId(), paramInt1, paramInt2);
    if (localBitmap != null)
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(1.0F, (float)-this.mAspectRatio);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      localBitmap.recycle();
      return rop.b((Bitmap)localObject, this.mWindowWidth, this.mWindowHeight, true);
    }
    return null;
  }
  
  public Bitmap c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = new int[(paramInt2 + paramInt4) * paramInt3];
    int[] arrayOfInt2 = new int[paramInt3 * paramInt4];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    GLES20.glReadPixels(0, 0, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
    paramInt2 = 0;
    paramInt1 = 0;
    boolean bool = true;
    int i;
    label64:
    int j;
    int i1;
    int m;
    int n;
    int k;
    if (paramInt1 < paramInt4)
    {
      i = 0;
      if (i < paramInt3)
      {
        j = arrayOfInt1[(paramInt1 * paramInt3 + i)];
        i1 = j >>> 24;
        m = j >> 16 & 0xFF;
        n = j >> 8 & 0xFF;
        int i2 = j & 0xFF;
        k = Color.argb(i1, i2, n, m);
        j = k;
        if (i1 > 0)
        {
          j = k;
          if (i1 != 255)
          {
            j = (int)(i2 * 1.0F / (i1 * 1.0F) * 255.0F);
            if (j <= 255) {
              break label365;
            }
            j = 255;
          }
        }
      }
    }
    label365:
    for (;;)
    {
      k = (int)(n * 1.0F / (i1 * 1.0F) * 255.0F);
      if (k > 255) {
        k = 255;
      }
      for (;;)
      {
        n = (int)(m * 1.0F / (i1 * 1.0F) * 255.0F);
        m = n;
        if (n > 255) {
          m = 255;
        }
        j = Color.argb(i1, j, k, m);
        arrayOfInt2[((paramInt4 - paramInt2 - 1) * paramInt3 + i)] = j;
        if (j > 0) {
          bool = false;
        }
        for (;;)
        {
          i += 1;
          break label64;
          paramInt2 += 1;
          paramInt1 += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("PersonalityOperator", 2, "saveTextureToBitmap blank:" + bool);
          }
          if (!bool) {
            return Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
          }
          return null;
        }
      }
    }
  }
  
  public void clear()
  {
    this.mCount = 0;
    this.g.clear();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    if (this.aId)
    {
      this.aId = false;
      if (!this.cl.isEmpty())
      {
        Iterator localIterator = this.cl.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).clearGLSLSelf();
        }
        this.cl.clear();
      }
    }
    this.e.clear();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    GLES20.glDeleteTextures(this.ee.length, this.ee, 0);
    GLES20.glDeleteTextures(this.ef.length, this.ef, 0);
    GLES20.glDeleteTextures(this.eg.length, this.eg, 0);
  }
  
  public void d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    paramFloat1 = this.mWidth / this.mWindowWidth;
    localPointF.x *= paramFloat1;
    localPointF.y = (paramFloat1 * localPointF.y);
    localPointF = new PointF(localPointF.x - this.mWidth * 0.5F, localPointF.y - this.mHeight * 0.5F);
    this.jdField_a_of_type_Rif.w.add(localPointF);
    this.jdField_a_of_type_Rif.aHX = paramBoolean;
  }
  
  public void onDestroy()
  {
    this.mTempFrame.clear();
    GLES20.glDeleteTextures(this.ed.length, this.ed, 0);
  }
  
  public void onInit()
  {
    clear();
    GLES20.glGenTextures(this.ed.length, this.ed, 0);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    GLES20.glGenTextures(this.ee.length, this.ee, 0);
    GLES20.glGenTextures(this.ef.length, this.ef, 0);
    GLES20.glGenTextures(this.eg.length, this.eg, 0);
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    float f1 = Math.min(720.0F / Math.min(paramInt1, paramInt2), 1.0F);
    this.mWidth = ((int)(paramInt1 * f1));
    this.mHeight = ((int)(f1 * paramInt2));
    if (!this.cl.isEmpty()) {
      updateVideoSize(this.mWidth, this.mHeight, 1.0D);
    }
    this.mWindowWidth = paramInt1;
    this.mWindowHeight = paramInt2;
    if ((this.aIb) && ((this.jdField_b_of_type_Rhw instanceof rhy)))
    {
      ((rhy)this.jdField_b_of_type_Rhw).buu();
      tO(true);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.cl.isEmpty()) {}
    do
    {
      return true;
      if ((this.mCount + 1 <= 50) || (this.jdField_a_of_type_Rif == null) || (!this.jdField_a_of_type_Rif.aHX)) {
        break;
      }
    } while (paramMotionEvent.getAction() != 0);
    QQStoryContext.a();
    QQToast.a(QQStoryContext.c().getApp(), acfp.m(2131709475), 0).show();
    return true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 2) {
      if (this.jdField_a_of_type_Rif != null)
      {
        d(f1, f2, false);
        int i = this.brQ + 1;
        this.brQ = i;
        this.brQ = (i % 4);
        if (this.brQ != 0) {}
      }
    }
    for (;;)
    {
      this.aIc = true;
      if (this.jdField_b_of_type_Rhw == null) {
        break;
      }
      this.jdField_b_of_type_Rhw.buo();
      return true;
      if (paramMotionEvent.getAction() == 0)
      {
        if ((this.material != null) && (!TextUtils.isEmpty(this.material.getId())))
        {
          this.jdField_a_of_type_Rif = new rif(102, this.material.getId());
          this.mCount += 1;
          this.jdField_a_of_type_Rif.aHW = true;
          if (this.jdField_b_of_type_Rhw != null) {
            this.jdField_b_of_type_Rhw.a(this.jdField_a_of_type_Rif);
          }
          d(f1, f2, false);
          this.brQ = 0;
        }
      }
      else if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.jdField_a_of_type_Rif != null)) {
        d(f1, f2, true);
      }
    }
  }
  
  public void setVideoFilter(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      if (!this.cl.containsKey(paramVideoMaterial.getId()))
      {
        VideoFilterBase localVideoFilterBase = a(paramVideoMaterial);
        if (localVideoFilterBase != null) {
          this.cl.put(paramVideoMaterial.getId(), localVideoFilterBase);
        }
      }
      this.material = paramVideoMaterial;
      paramVideoMaterial = new PersonalityOperator.1(this, paramVideoMaterial);
      if (this.jdField_b_of_type_Rhw != null) {
        this.jdField_b_of_type_Rhw.N(paramVideoMaterial);
      }
      return;
    }
    ram.d("PersonalityOperator", "material is null!");
  }
  
  public void t(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.cl == null) || (this.cl.size() < 1)) {
      return;
    }
    Frame localFrame = new Frame(paramInt1, paramInt2, paramInt3, paramInt4);
    GlUtil.setBlendMode(true);
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    this.e.bindFrame(this.ef[0], paramInt3, paramInt4, 1.0D);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.e.getTextureId(), paramInt3, paramInt4, paramInt2, 1.0D, localFrame);
    GlUtil.setBlendMode(false);
  }
  
  public void tO(boolean paramBoolean)
  {
    boolean bool = true;
    this.aIa = false;
    this.aHZ = true;
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.aIb = paramBoolean;
      if (this.jdField_b_of_type_Rhw != null) {
        this.jdField_b_of_type_Rhw.buo();
      }
      return;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramInt1 / paramInt2 > 0.75D) {
      paramInt2 = (int)(paramInt1 / 0.75D);
    }
    while (this.cl.isEmpty())
    {
      return;
      paramInt1 = (int)(paramInt2 * 0.75D);
    }
    Iterator localIterator = this.cl.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)((Map.Entry)localIterator.next()).getValue()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.ee[0]);
    GLES20.glTexImage2D(3553, 0, 6402, paramInt1, paramInt2, 0, 6402, 5123, null);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10241, 9728);
  }
  
  public void xt(int paramInt)
  {
    this.aIf = true;
    this.brR = paramInt;
    if (this.jdField_b_of_type_Rhw != null) {
      this.jdField_b_of_type_Rhw.buo();
    }
  }
  
  public void xz(int paramInt)
  {
    try
    {
      this.aIf = true;
      this.brR = paramInt;
      Bitmap localBitmap = c(this.mWidth, this.mHeight);
      if (localBitmap == null)
      {
        this.aIf = false;
        ram.e("PersonalityOperator", "saveTextureToBitmap failed, bitmapFromTexture is null");
        return;
      }
      localBitmap = rop.b(localBitmap, 1.0F * this.brR / this.mWindowWidth, true);
      this.aIc = false;
      if (this.jdField_b_of_type_Rhw != null)
      {
        this.jdField_b_of_type_Rhw.v(localBitmap);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Personality", 2, localOutOfMemoryError, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rig
 * JD-Core Version:    0.7.0.1
 */