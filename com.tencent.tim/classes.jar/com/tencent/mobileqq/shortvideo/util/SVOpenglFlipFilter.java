package com.tencent.mobileqq.shortvideo.util;

import aavg;
import aavg.b;
import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

@TargetApi(17)
public class SVOpenglFlipFilter
{
  private EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
  private EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  private int arF;
  private EGLSurface jdField_b_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  private OffScreenInputSurface jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
  private int clc = -1;
  private int cld = -1;
  private EGLContext d = EGL14.EGL_NO_CONTEXT;
  private int dJm = -1;
  private int[] jJ = new int[1];
  private EGLContext mSharedContext;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public SVOpenglFlipFilter(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mSharedContext = paramEGLContext;
    this.jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
  }
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      throw new RuntimeException("glGetError encountered (see log)" + paramString + " :glGetError: 0x" + Integer.toHexString(i));
    }
  }
  
  public void QG(String paramString)
  {
    this.arF = aavg.b.x("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 textureCoordinateOut;\nvoid main()\n{\ntextureCoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", paramString);
    if (this.arF == 0) {
      throw new EGLCreateProgramException("initOpenGlAtrribute:createShaderProgram = 0");
    }
    GLES20.glUseProgram(this.arF);
    this.clc = GLES20.glGetAttribLocation(this.arF, "position");
    this.cld = GLES20.glGetAttribLocation(this.arF, "textureCoordinateIn");
    this.dJm = GLES20.glGetUniformLocation(this.arF, "inputImageTexture");
    aavg.a(this.jJ, this.clc, this.cld);
    checkGlError("createSquareVtx");
    GLES20.glDisable(2929);
    GLES20.glDisable(2884);
    GLES20.glDisable(3042);
  }
  
  public boolean a(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    return (this.mVideoWidth == paramInt1) && (this.mVideoHeight == paramInt2) && (this.mSharedContext != OffScreenInputSurface.b()) && (paramEGLContext.equals(this.mSharedContext));
  }
  
  public void bc(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glUseProgram(this.arF);
    GLES20.glUniform1i(this.dJm, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glDrawArrays(6, 0, 4);
    PtvFilterUtils.Qf(false);
  }
  
  public void dRo()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = new OffScreenInputSurface(this.mVideoWidth, this.mVideoHeight, this.mSharedContext);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.makeCurrent();
      QG(" precision highp float;\n varying vec2 textureCoordinateOut;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinateOut);\n}\n");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.makeCurrent();
  }
  
  public void releaseContext()
  {
    this.arF = 0;
    this.mSharedContext = EGL14.EGL_NO_CONTEXT;
    if (this.jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.release();
      this.jdField_b_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
    }
  }
  
  public static class EGLCreateProgramException
    extends RuntimeException
  {
    private static final long serialVersionUID = -7034897190745766934L;
    
    public EGLCreateProgramException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SVOpenglFlipFilter
 * JD-Core Version:    0.7.0.1
 */