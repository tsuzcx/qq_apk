package com.tencent.jalpha.videoplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.jalpha.common.Logger;

public class AlphaBlendRender
  extends BaseRender
{
  private static final String TAG = "VideoPlayer|SurfaceTextureBlendRender";
  private int mHeightParamHandleOES;
  private int mOffsetParamHandleOES;
  private float mOffsetX = 0.001333333F;
  private int mPositionHandleOES;
  private int mShaderProgramOES;
  private int mTextureCoordinateHandleOES;
  private int mTextureParamHandleOES;
  private int mTextureTransformHandleOES;
  private float mTextureWidth = 750.0F;
  private int[] mTexturesOES = new int[1];
  private Surface mVideoSurface;
  private int mWidthParamHandleOES;
  private SurfaceTexture videoTexture;
  
  public AlphaBlendRender()
  {
    super(1);
  }
  
  private void releaseSurface()
  {
    if (this.mVideoSurface != null)
    {
      this.mVideoSurface.release();
      this.mVideoSurface = null;
      Logger.v("VideoPlayer|SurfaceTextureBlendRender", " release  surface");
    }
  }
  
  private void releaseSurfaceTexture()
  {
    if (this.videoTexture != null)
    {
      this.videoTexture.release();
      this.videoTexture = null;
      Logger.v("VideoPlayer|SurfaceTextureBlendRender", " release  surface texture");
    }
  }
  
  public void destroy()
  {
    GLES20.glDeleteTextures(1, this.mTexturesOES, 0);
    GLES20.glDeleteProgram(this.mShaderProgramOES);
    releaseSurface();
    releaseSurfaceTexture();
  }
  
  public void draw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      GLES20.glUseProgram(this.mShaderProgramOES);
      GLES20.glClear(16384);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      GLES20.glBindTexture(36197, this.mTexturesOES[0]);
      GLES20.glActiveTexture(33984);
      GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
      GLES20.glUniform1f(this.mWidthParamHandleOES, this.mTextureWidth);
      GLES20.glUniform1f(this.mOffsetParamHandleOES, this.mOffsetX);
      if (this.videoTexture != null)
      {
        this.videoTexture.updateTexImage();
        this.videoTexture.getTransformMatrix(this.mTextureTransform);
        GLES20.glEnableVertexAttribArray(this.mPositionHandleOES);
        GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, this.mVertexBuffer);
        GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleOES);
        GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleOES, 4, 5126, false, 0, this.mTextureCoordsBuffer);
        GLES20.glUniformMatrix4fv(this.mTextureTransformHandleOES, 1, false, this.mTextureTransform, 0);
        GLES20.glDrawElements(5, this.mDrawOrder.length, 5123, this.mDrawListBuffer);
        GLES20.glDisableVertexAttribArray(this.mPositionHandleOES);
        GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleOES);
        GLES20.glDisable(3042);
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
        return;
      }
      GLES20.glUseProgram(0);
      GLES20.glBindTexture(36197, 0);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Logger.v("VideoPlayer|SurfaceTextureBlendRender", " Exception in draw oes");
      paramArrayOfByte.printStackTrace();
      GLES20.glBindTexture(36197, 0);
      GLES20.glUseProgram(0);
    }
  }
  
  public Surface getSurface()
  {
    return this.mVideoSurface;
  }
  
  public SurfaceTexture getVideoTexture()
  {
    return this.videoTexture;
  }
  
  public void setup()
  {
    Logger.v("VideoPlayer|SurfaceTextureBlendRender", "setup OES");
    checkGlError(" setup OES ");
    setupVertexBuffer();
    setupTextureCoordsBuffer();
    this.mShaderProgramOES = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision highp float;\nprecision highp int;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nvarying highp vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision highp int;\nuniform highp float width;\nuniform highp float offset;\nuniform samplerExternalOES texture;\nvarying highp vec2 v_TexCoordinate;\nint iter_mod(int x, int y) {\n    for(int i=0; i>-1; i++) {\n        if(x < y) break;\n        x = x - y;\n    }\n    return x;\n}\nbool equals(float x, float y) {\n    if(x -y < 0.015 && x-y > -0.015 ) {\n       return true;\n    }\n    return false;\n}\nvoid main () {\n     vec4 color = texture2D(texture, v_TexCoordinate);\n     highp int posx =int(v_TexCoordinate.x * width);\n     vec4 color1;\n     if ( iter_mod(posx, 2) ==0 ) {  \n         color1 = texture2D(texture, v_TexCoordinate + vec2( offset, 0.0));   \n        if ( equals(color.r, color1.r) && equals(color.g, color1.g) && equals(color.b,color1.b)) {\n           color1 = texture2D(texture, v_TexCoordinate + vec2( offset * 0.99, 0.0));   \n       \n}     } else {\n        color1 = texture2D(texture, v_TexCoordinate - vec2( offset, 0.0));   \n        if ( equals(color.r, color1.r) && equals(color.g, color1.g) && equals(color.b,color1.b) ) {\n           color1 = texture2D(texture, v_TexCoordinate - vec2( offset * 0.99, 0.0) );   \n       \n}     }\n     float y1 = (0.299 * color.r + 0.587 * color.g + 0.114 * color.b) * 255.0; \n     float u1 = (-0.169 * color.r -0.331 * color.g + 0.500 * color.b) * 255.0; \n     float v1 = (0.500 * color.r - 0.419 * color.g - 0.081 * color.b) * 255.0; \n     float y2 = (0.299 * color1.r + 0.587 * color1.g + 0.114 * color1.b) * 255.0;\n     float ry;\n     float ay;\n     if ( iter_mod(posx, 2) ==0 ) {\n        ay = y1;\n        ry = y2;\n     } else {\n        ay = y2;\n        ry = y1;\n     }\n     if ( ay <= ry ) {\n        float temp = ay;\n        ay = ry;\n        ry = temp;\n     } \n     float r = (ry +  1.403 * v1)* 3.0 ;\n     float g = (ry  -0.344 * u1  -0.714 * v1 ) * 3.0; \n     float b = (ry + 1.770 * u1 )* 3.0; \n      float a = (ay - 86.0) * 3.0;\n     color.a = a/ 255.0;\n     color.r = r / 255.0; \n     color.g = g / 255.0; \n     color.b = b / 255.0; \n     gl_FragColor = color;\n}\n"), new String[] { "texture", "offset", "width", "vPosition", "vTexCoordinate", "textureTransform" });
    GLES20.glUseProgram(this.mShaderProgramOES);
    this.mTextureParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "texture");
    this.mWidthParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "width");
    this.mOffsetParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "offset");
    this.mTextureCoordinateHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vTexCoordinate");
    this.mPositionHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vPosition");
    this.mTextureTransformHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "textureTransform");
    GLES20.glUniform1f(this.mWidthParamHandleOES, this.mTextureWidth);
    GLES20.glUniform1f(this.mOffsetParamHandleOES, this.mOffsetX);
    GLES20.glUseProgram(0);
    checkGlError("Texture generate OES>>");
    GLES20.glGenTextures(1, this.mTexturesOES, 0);
    GLES20.glBindTexture(36197, this.mTexturesOES[0]);
    checkGlError("Texture bind");
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9728.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    this.videoTexture = new SurfaceTexture(this.mTexturesOES[0]);
    this.mVideoSurface = new Surface(this.videoTexture);
    GLES20.glBindTexture(36197, 0);
    GLES20.glBindTexture(3553, 0);
  }
  
  public void updateSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Logger.v("VideoPlayer|SurfaceTextureBlendRender", "updateSize: viewWidth " + paramInt1 + " viewHeight " + paramInt2 + " textureWidth " + paramInt3 + "," + paramInt4);
    this.mTextureWidth = paramInt3;
    this.mOffsetX = ((float)(1.0D / this.mTextureWidth));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.render.AlphaBlendRender
 * JD-Core Version:    0.7.0.1
 */