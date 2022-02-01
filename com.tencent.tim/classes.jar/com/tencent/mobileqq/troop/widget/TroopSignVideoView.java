package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.View;
import anzc;
import apwj;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class TroopSignVideoView
  extends SpriteGLView
{
  private VideoSprite.c jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$c;
  private VideoSprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
  private boolean cSQ;
  private int cpP;
  private String mPath;
  
  public TroopSignVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "onVisibilityChanged: visibility = " + paramInt);
    }
    if (paramInt == 0) {
      resume();
    }
    for (;;)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
      if (paramInt == 4) {
        pause();
      } else if (paramInt == 8) {
        dTU();
      }
    }
  }
  
  public void pause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.pause();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->pause");
    }
  }
  
  public void play(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.isReleased()) || (!paramString.equals(this.mPath)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) {
        c(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
      }
      this.mPath = paramString;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = new SignVideoSprite(this, getContext(), true);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.isFullScreen = true;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.cKM = true;
      b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.setLooping(true);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.Go(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.setOnPlayedListener(new apwj(this));
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->play");
    }
  }
  
  public void resume()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) && (!this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.isReleased())) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.resume();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "SpriteGLView->resume");
      }
      return;
      if (this.mPath != null) {
        play(this.mPath);
      }
    }
  }
  
  public void setFilePath(String paramString)
  {
    this.mPath = paramString;
  }
  
  public void setOnPlayedListener(VideoSprite.c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$c = paramc;
  }
  
  public void setShowCover(boolean paramBoolean)
  {
    this.cSQ = paramBoolean;
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null)
    {
      c(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->stop");
    }
  }
  
  class SignVideoSprite
    extends VideoSprite
  {
    private int dXI = GLES20.glGetUniformLocation(this.mShaderProgram, "v_isShowCover");
    
    public SignVideoSprite(SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
    {
      super(paramContext, paramBoolean);
    }
    
    public void eC(int paramInt1, int paramInt2)
    {
      if (TroopSignVideoView.a(TroopSignVideoView.this) == 0) {
        TroopSignVideoView.a(TroopSignVideoView.this, paramInt2);
      }
      super.eC(paramInt1, TroopSignVideoView.a(TroopSignVideoView.this));
    }
    
    public void jH(int paramInt1, int paramInt2)
    {
      if (this.mVertexBuffer == null) {
        return;
      }
      eC(paramInt1, paramInt2);
      GLES20.glEnableVertexAttribArray(this.mPositionHandle);
      GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 0, this.mVertexBuffer);
      GLES20.glBindTexture(3553, this.mTextures[0]);
      GLES20.glUniform1i(this.mTextureParamHandle, 0);
      GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandle);
      GLES20.glVertexAttribPointer(this.mTextureCoordinateHandle, 4, 5126, false, 0, this.mTextureBuffer);
      if (this.mIsSupportAlpha)
      {
        GLES20.glUniform1i(this.mSupportAlphaHandle, 1);
        GLES20.glEnableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
        GLES20.glVertexAttribPointer(this.mTextureAlphaCoordinateHandle, 4, 5126, false, 0, this.mTextureBuffer2);
        paramInt2 = this.dXI;
        if (!TroopSignVideoView.a(TroopSignVideoView.this)) {
          break label205;
        }
      }
      label205:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        GLES20.glUniform1i(paramInt2, paramInt1);
        GLES20.glUniformMatrix4fv(this.mTextureTranformHandle, 1, false, this.dw, 0);
        GLES20.glDrawElements(4, sDrawOrder.length, 5123, this.mDrawListBuffer);
        GLES20.glDisableVertexAttribArray(this.mPositionHandle);
        GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandle);
        GLES20.glDisableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
        return;
        GLES20.glUniform1i(this.mSupportAlphaHandle, 0);
        break;
      }
    }
    
    public String nw()
    {
      return anzc.D(TroopSignVideoView.this.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShaderVideoForTroopSign.glsl");
    }
    
    public void setupGraphics()
    {
      super.setupGraphics();
      this.dXI = GLES20.glGetUniformLocation(this.mShaderProgram, "v_isShowCover");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSignVideoView
 * JD-Core Version:    0.7.0.1
 */