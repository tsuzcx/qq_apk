package com.tencent.mobileqq.magicface.view;

import aiyo;
import aiyp;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.qphone.base.util.QLog;

public class MagicFaceGLView
  extends GLSurfaceView
  implements aiyp, SurfaceHolder.Callback
{
  public volatile boolean Zf;
  private MagicfaceView.a a;
  private aiyo b;
  private volatile boolean mIsFullScreen;
  
  public MagicFaceGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] MagicFaceGLView begins");
    }
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    this.b = new aiyo();
    setRenderer(this.b);
    setRenderMode(0);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] MagicFaceGLView ends");
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] frameDataGL begins, srcwidth:" + paramInt1 + ",srcheight:" + paramInt2 + ",degree:" + paramFloat);
    }
    b(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] frameDataGL ends");
    }
  }
  
  public boolean apT()
  {
    return this.Zf;
  }
  
  public void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.b == null) {
      return;
    }
    this.b.b(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, getWidth(), getHeight(), paramFloat, this.mIsFullScreen);
    requestRender();
  }
  
  public void b(int[] paramArrayOfInt, int paramInt1, int paramInt2) {}
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    this.mIsFullScreen = paramBoolean;
  }
  
  public void setSurfaceCreatelistener(MagicfaceView.a parama)
  {
    this.a = parama;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] surfaceCreated begins");
    }
    super.surfaceCreated(paramSurfaceHolder);
    this.Zf = true;
    if (this.a != null) {
      this.a.surfaceCreated();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] surfaceCreated ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicFaceGLView
 * JD-Core Version:    0.7.0.1
 */