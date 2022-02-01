package com.tencent.mobileqq.minicode.recog;

import adjj;
import alzr;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.Matrix;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.minicode.GlUtil;
import com.tencent.mobileqq.minicode.RecogProxy;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MiniCodeRecog
{
  private final String TAG = "MiniRecog.recog";
  private boolean inited;
  private float inputTextAspect;
  private final Object mLock = new Object();
  private long mNativeObj;
  private RenderBuffer miniFbo;
  private MiniParam miniParam;
  private float[] scale_to_keep_aspect;
  private int texture31In = -1;
  private TextureRender textureRender;
  
  public MiniCodeRecog(MiniParam paramMiniParam)
  {
    this.miniParam = paramMiniParam;
    this.scale_to_keep_aspect = new float[16];
    this.textureRender = new TextureRender();
    this.texture31In = GlUtil.createTexture31(paramMiniParam.netWidth, paramMiniParam.netHeight);
    this.miniFbo = new RenderBuffer(paramMiniParam.netWidth, paramMiniParam.netHeight);
    RecogUtil.markMiniScanError(false);
    this.mNativeObj = RecogProxy.QCodeInit(this.miniParam.runType, this.miniParam.netHeight, this.miniParam.netWidth, this.miniParam.modelString, this.miniParam.paramPath, this.miniParam.anchorPath, this.miniParam.kernelBinaryIndex, 0.35F);
    QLog.i("MiniRecog.recog", 1, String.format("RecogProxy.QCodeInit native_handler=0x%x", new Object[] { Long.valueOf(this.mNativeObj) }));
    if (this.mNativeObj != 0L) {
      RecogUtil.clearMiniScanError(false);
    }
    this.inited = true;
  }
  
  private Rect getRect2Src(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if (paramInt1 > paramInt2)
    {
      i = 0;
      paramArrayOfFloat[i] = ((paramArrayOfFloat[i] - 0.5F) / this.inputTextAspect + 0.5F);
      paramArrayOfFloat[(i + 2)] = ((paramArrayOfFloat[(i + 2)] - 0.5F) / this.inputTextAspect + 0.5F);
      float f1 = paramArrayOfFloat[0];
      float f2 = paramArrayOfFloat[1];
      float f3 = paramArrayOfFloat[2];
      float f4 = paramArrayOfFloat[3];
      paramArrayOfFloat[0] = (1.0F - (f1 - 0.02F) * 2.0F);
      paramArrayOfFloat[1] = ((f2 - 0.02F) * 2.0F - 1.0F);
      paramArrayOfFloat[2] = (1.0F - 2.0F * (f3 + 0.02F));
      paramArrayOfFloat[3] = (2.0F * (f4 + 0.02F) - 1.0F);
      i = 0;
      label121:
      if (i >= 4) {
        break label175;
      }
      if (paramArrayOfFloat[i] <= 1.0F) {
        break label156;
      }
      paramArrayOfFloat[i] = 1.0F;
    }
    for (;;)
    {
      i += 1;
      break label121;
      i = 1;
      break;
      label156:
      if (paramArrayOfFloat[i] < -1.0F) {
        paramArrayOfFloat[i] = -1.0F;
      }
    }
    label175:
    int j = (int)(paramArrayOfFloat[0] * 0.5F * paramInt2);
    int k = (int)(paramArrayOfFloat[2] * 0.5F * paramInt2);
    int i = (int)(paramArrayOfFloat[1] * 0.5F * paramInt1);
    int m = (int)(paramArrayOfFloat[3] * 0.5F * paramInt1);
    int n = Math.abs(m - i);
    int i1 = Math.abs(k - j);
    if (i < m) {
      if (j <= k) {
        break label322;
      }
    }
    for (;;)
    {
      paramInt1 = (int)(i + paramInt1 * 0.5F);
      paramInt2 = (int)(paramInt2 * 0.5F - j);
      paramArrayOfFloat = new Rect();
      paramArrayOfFloat.left = paramInt1;
      paramArrayOfFloat.top = paramInt2;
      paramArrayOfFloat.right = (paramInt1 + n);
      paramArrayOfFloat.bottom = (paramInt2 + i1);
      return paramArrayOfFloat;
      i = m;
      break;
      label322:
      j = k;
    }
  }
  
  public List<adjj> detect(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    if (!this.inited) {
      return null;
    }
    Matrix.setIdentityM(this.scale_to_keep_aspect, 0);
    ArrayList localArrayList;
    if (paramInt2 > paramInt3)
    {
      this.inputTextAspect = (paramInt3 / paramInt2);
      Matrix.scaleM(this.scale_to_keep_aspect, 0, this.inputTextAspect, 1.0F, 1.0F);
      Matrix.rotateM(this.scale_to_keep_aspect, 0, 180.0F, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.scale_to_keep_aspect, 0, -90.0F, 0.0F, 0.0F, 1.0F);
      this.miniFbo.setUserTextureId(this.texture31In);
      this.miniFbo.bind();
      GLES31.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES31.glClear(16384);
      this.textureRender.drawTexture(3553, paramInt1, null, this.scale_to_keep_aspect);
      this.miniFbo.unbind();
      GLES20.glFlush();
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.mLock)
      {
        if (this.mNativeObj != 0L)
        {
          RecogProxy.QCodeProcess(this.mNativeObj, this.texture31In, 0);
          j = RecogProxy.getBoxCnt(this.mNativeObj);
          int i = j;
          if (j < 2) {
            break label681;
          }
          i = 2;
          break label681;
          if (j < i)
          {
            localObject2 = new float[5];
            Object tmp207_205 = localObject2;
            tmp207_205[0] = 0.0F;
            Object tmp211_207 = tmp207_205;
            tmp211_207[1] = 0.0F;
            Object tmp215_211 = tmp211_207;
            tmp215_211[2] = 0.0F;
            Object tmp219_215 = tmp215_211;
            tmp219_215[3] = 0.0F;
            Object tmp223_219 = tmp219_215;
            tmp223_219[4] = 0.0F;
            tmp223_219;
            int k = RecogProxy.getBox(this.mNativeObj, j, (float[])localObject2);
            int m = RecogProxy.getBoxType(this.mNativeObj, j);
            if ((k < 0) || (m < 0))
            {
              j += 1;
              continue;
              this.inputTextAspect = (paramInt2 / paramInt3);
              Matrix.scaleM(this.scale_to_keep_aspect, 0, 1.0F, this.inputTextAspect, 1.0F);
              break;
            }
            if (QLog.isDevelopLevel()) {
              QLog.i("MiniRecog.recog", 2, String.format("debug_minicode_point=[%f,%f,%f,%f,%f,%d]", new Object[] { Float.valueOf(localObject2[0]), Float.valueOf(localObject2[1]), Float.valueOf(localObject2[2]), Float.valueOf(localObject2[3]), Float.valueOf(localObject2[4]), Integer.valueOf(m) }));
            }
            Rect localRect = getRect2Src(paramInt2, paramInt3, (float[])localObject2);
            adjj localadjj = new adjj();
            localadjj.rect.set(localRect);
            localadjj.type = m;
            localadjj.score = localObject2[4];
            localArrayList.add(localadjj);
          }
        }
      }
      if (paramBoolean)
      {
        Matrix.setIdentityM(this.scale_to_keep_aspect, 0);
        if (paramInt2 <= paramInt3) {
          break label659;
        }
        Matrix.scaleM(this.scale_to_keep_aspect, 0, this.inputTextAspect, 1.0F, 1.0F);
      }
      for (;;)
      {
        this.miniFbo.setUserTextureId(this.texture31In);
        this.miniFbo.bind();
        GLES31.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES31.glClear(16384);
        this.textureRender.drawTexture(3553, paramInt1, null, this.scale_to_keep_aspect);
        this.miniFbo.unbind();
        GLES20.glFlush();
        try
        {
          ??? = GlUtil.convertTexToBitmap(this.texture31In, this.miniParam.netWidth, this.miniParam.netHeight);
          localObject2 = new SimpleDateFormat("MM-dd HH:mm:ss", BaseApplicationImpl.getContext().getResources().getConfiguration().locale);
          localObject2 = paramLong + "-" + ((SimpleDateFormat)localObject2).format(new Date(paramLong));
          RecogUtil.validBmpData((Bitmap)???, (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.recog", 2, String.format("debug_minicode_validBmpData %s", new Object[] { localObject2 }));
          }
          label656:
          return localList;
          label659:
          Matrix.scaleM(this.scale_to_keep_aspect, 0, 1.0F, this.inputTextAspect, 1.0F);
        }
        catch (Throwable localThrowable)
        {
          break label656;
        }
      }
      label681:
      int j = 0;
    }
  }
  
  public void finish()
  {
    if (this.textureRender != null) {
      this.textureRender.release();
    }
    if (this.texture31In >= 0)
    {
      alzr.deleteTexture(this.texture31In);
      this.texture31In = -1;
    }
    if (this.miniFbo != null) {
      this.miniFbo.destroy();
    }
    if (this.mNativeObj != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.recog", 2, String.format("RecogProxy.QCodeDestroy native_handler=0x%x", new Object[] { Long.valueOf(this.mNativeObj) }));
      }
      RecogProxy.QCodeDestroy(this.mNativeObj);
      this.mNativeObj = 0L;
    }
  }
  
  public boolean isInitSuc()
  {
    return this.mNativeObj != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.recog.MiniCodeRecog
 * JD-Core Version:    0.7.0.1
 */