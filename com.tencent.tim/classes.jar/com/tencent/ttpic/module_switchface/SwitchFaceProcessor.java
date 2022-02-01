package com.tencent.ttpic.module_switchface;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.RGBATexSaveProcess;
import com.tencent.ttpic.openapi.util.SwitchFaceUtil;
import iwl;
import iwn;
import java.util.List;

public class SwitchFaceProcessor
{
  private static final long FACE_DETECT_DURATION = 2000L;
  private static final String TAG = "SwitchFaceProcessor";
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private long mCurFaceDetectTime;
  private SwitchFaceFilter mFilter;
  private RGBATexSaveProcess mRGBATexSaveProcess;
  private iwl[] mSwitchFaceItem = new iwl[2];
  
  public SwitchFaceProcessor()
  {
    int i = 0;
    while (i < this.mSwitchFaceItem.length)
    {
      this.mSwitchFaceItem[i] = new iwl();
      i += 1;
    }
    SwitchFaceUtil.setAllGrayImagePath(iwn.GRAY_FILE_ALL);
  }
  
  private void faceDetect()
  {
    long l = System.currentTimeMillis();
    if ((this.mSwitchFaceItem[0].a(this.mRGBATexSaveProcess)) && (this.mSwitchFaceItem[1].a(this.mRGBATexSaveProcess))) {
      ThreadManager.post(new SwitchFaceProcessor.1(this, this.mSwitchFaceItem[0].fz, this.mSwitchFaceItem[0].mWidth, this.mSwitchFaceItem[0].mHeight, this.mSwitchFaceItem[1].fz, this.mSwitchFaceItem[1].mWidth, this.mSwitchFaceItem[1].mHeight), 5, null, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process two face detect cost " + (System.currentTimeMillis() - l));
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SwitchFaceProcessor", 2, "WL_DEBUG process retrieve data1 error");
      }
    }
  }
  
  public static void setBlendMode(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      return;
    }
    GLES20.glDisable(3042);
  }
  
  private void setDiff()
  {
    this.mSwitchFaceItem[0].hD = (this.mSwitchFaceItem[1].hA - this.mSwitchFaceItem[0].hA);
    this.mSwitchFaceItem[0].hE = (this.mSwitchFaceItem[1].hB - this.mSwitchFaceItem[0].hB);
    this.mSwitchFaceItem[0].hF = (this.mSwitchFaceItem[1].hC - this.mSwitchFaceItem[0].hC);
    this.mSwitchFaceItem[1].hD = (this.mSwitchFaceItem[0].hA - this.mSwitchFaceItem[1].hA);
    this.mSwitchFaceItem[1].hE = (this.mSwitchFaceItem[0].hB - this.mSwitchFaceItem[1].hB);
    this.mSwitchFaceItem[1].hF = (this.mSwitchFaceItem[0].hC - this.mSwitchFaceItem[1].hC);
  }
  
  public void destroy()
  {
    this.mCopyFilter.ClearGLSL();
    this.mFilter.ClearGLSL();
    int i = 0;
    while (i < this.mSwitchFaceItem.length)
    {
      this.mSwitchFaceItem[i].mCopyFrame.clear();
      i += 1;
    }
    this.mRGBATexSaveProcess.clear();
  }
  
  public void init()
  {
    this.mFilter = new SwitchFaceFilter();
    this.mCopyFilter.apply();
    this.mFilter.ApplyGLSLFilter();
    int i = 0;
    while (i < this.mSwitchFaceItem.length)
    {
      this.mSwitchFaceItem[i].mCopyFrame = new Frame();
      i += 1;
    }
    this.mRGBATexSaveProcess = new RGBATexSaveProcess();
  }
  
  public int[] process(int paramInt1, List<PointF> paramList1, int paramInt2, int paramInt3, int paramInt4, List<PointF> paramList2, int paramInt5, int paramInt6)
  {
    long l = System.currentTimeMillis();
    this.mSwitchFaceItem[0].mTextureId = paramInt1;
    this.mSwitchFaceItem[0].fz = paramList1;
    this.mSwitchFaceItem[0].mWidth = paramInt2;
    this.mSwitchFaceItem[0].mHeight = paramInt3;
    this.mSwitchFaceItem[1].mTextureId = paramInt4;
    this.mSwitchFaceItem[1].fz = paramList2;
    this.mSwitchFaceItem[1].mWidth = paramInt5;
    this.mSwitchFaceItem[1].mHeight = paramInt6;
    if (l - this.mCurFaceDetectTime > 2000L)
    {
      faceDetect();
      this.mCurFaceDetectTime = l;
    }
    setBlendMode(true);
    this.mCopyFilter.RenderProcess(this.mSwitchFaceItem[0].mTextureId, this.mSwitchFaceItem[0].mWidth, this.mSwitchFaceItem[0].mHeight, -1, 0.0D, this.mSwitchFaceItem[0].mCopyFrame);
    this.mFilter.updateFaceParams(this.mSwitchFaceItem[0], this.mSwitchFaceItem[1]);
    this.mCopyFilter.RenderProcess(this.mSwitchFaceItem[1].mTextureId, this.mSwitchFaceItem[1].mWidth, this.mSwitchFaceItem[1].mHeight, -1, 0.0D, this.mSwitchFaceItem[1].mCopyFrame);
    this.mFilter.updateFaceParams(this.mSwitchFaceItem[1], this.mSwitchFaceItem[0]);
    setBlendMode(false);
    return new int[] { this.mSwitchFaceItem[0].mCopyFrame.getTextureId(), this.mSwitchFaceItem[1].mCopyFrame.getTextureId() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.module_switchface.SwitchFaceProcessor
 * JD-Core Version:    0.7.0.1
 */