import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class anyo
  extends anyu
{
  private anyv[] a;
  private LinkedList<anyv> ab = new LinkedList();
  private boolean bQR;
  private boolean cKF;
  public int dNv;
  public anyo.a e;
  private String[] hf;
  public boolean isLoop;
  private int mCurrentFrameIndex = -1;
  private int mFps = 10;
  private boolean mIsReleased;
  private boolean mIsStart;
  private long mStartTime;
  
  public anyo(SpriteGLView paramSpriteGLView, String[] paramArrayOfString)
  {
    this.b = paramSpriteGLView;
    this.hf = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfAnyv = new anyv[paramArrayOfString.length];
    setFps(10);
  }
  
  private void VC(int paramInt)
  {
    try
    {
      if ((this.ab != null) && (this.jdField_a_of_type_ArrayOfAnyv != null) && (this.jdField_a_of_type_ArrayOfAnyv.length > paramInt) && (this.jdField_a_of_type_ArrayOfAnyv[paramInt] != null))
      {
        this.ab.add(this.jdField_a_of_type_ArrayOfAnyv[paramInt]);
        this.jdField_a_of_type_ArrayOfAnyv[paramInt].decode();
      }
      return;
    }
    finally {}
  }
  
  private anyv a(int paramInt)
  {
    try
    {
      if (this.ab != null)
      {
        this.ab.remove(this.jdField_a_of_type_ArrayOfAnyv[paramInt]);
        anyv localanyv = this.jdField_a_of_type_ArrayOfAnyv[paramInt];
        return localanyv;
      }
      return null;
    }
    finally {}
  }
  
  private void a(int paramInt, anyv paramanyv)
  {
    if ((this.jdField_a_of_type_ArrayOfAnyv != null) && (this.jdField_a_of_type_ArrayOfAnyv.length > paramInt)) {
      this.jdField_a_of_type_ArrayOfAnyv[paramInt] = paramanyv;
    }
  }
  
  private void dTM()
  {
    try
    {
      if (this.ab != null)
      {
        int i = 0;
        while (i < this.ab.size())
        {
          ((anyv)this.ab.get(i)).release();
          i += 1;
        }
        this.ab.clear();
      }
      return;
    }
    finally {}
  }
  
  public void GK(boolean paramBoolean)
  {
    this.bQR = paramBoolean;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    int i;
    if ((this.mIsStart) && (this.jdField_a_of_type_ArrayOfAnyv != null))
    {
      i = (int)((float)(System.currentTimeMillis() - this.mStartTime) / (1000.0F / this.mFps));
      if (i <= this.mCurrentFrameIndex) {
        break label370;
      }
      if (i <= this.mCurrentFrameIndex + 1) {
        break label220;
      }
      this.mCurrentFrameIndex += 1;
      if (this.mCurrentFrameIndex >= this.jdField_a_of_type_ArrayOfAnyv.length) {
        break label268;
      }
      if ((this.jdField_a_of_type_ArrayOfAnyv[this.mCurrentFrameIndex] == null) || (!this.jdField_a_of_type_ArrayOfAnyv[this.mCurrentFrameIndex].cKL)) {
        break label229;
      }
      if (this.jdField_a_of_type_Anyv != null) {
        this.jdField_a_of_type_Anyv.release();
      }
      this.jdField_a_of_type_Anyv = a(this.mCurrentFrameIndex);
      if (QLog.isColorLevel()) {
        QLog.d("FrameSprite", 2, "FrameSprite: mTexture = " + this.jdField_a_of_type_Anyv);
      }
      init();
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      if (QLog.isColorLevel()) {
        QLog.d("FrameSprite", 2, "FrameSprite: draw1:" + this.mCurrentFrameIndex);
      }
    }
    label220:
    label229:
    label370:
    do
    {
      for (;;)
      {
        return;
        this.mCurrentFrameIndex = i;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: mTexture = null:" + this.mCurrentFrameIndex);
        }
        dTM();
        return;
        if (this.bQR)
        {
          super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
          if (QLog.isColorLevel()) {
            QLog.d("FrameSprite", 2, "FrameSprite: draw3:" + this.mCurrentFrameIndex);
          }
        }
        while (this.e != null)
        {
          this.e.byj();
          this.e = null;
          return;
          this.mIsStart = false;
          if (this.jdField_a_of_type_Anyv != null) {
            this.jdField_a_of_type_Anyv.release();
          }
        }
      }
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    } while (!QLog.isColorLevel());
    label268:
    QLog.d("FrameSprite", 2, "FrameSprite: draw2:" + this.mCurrentFrameIndex);
  }
  
  public void a(Context paramContext, SpriteGLView paramSpriteGLView)
  {
    ThreadManager.post(new FrameSprite.1(this, paramContext, paramSpriteGLView), 8, null, true);
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.mIsStart)
    {
      int i = (int)((float)(System.currentTimeMillis() - this.mStartTime) / (1000.0F / this.mFps));
      if (i >= this.jdField_a_of_type_ArrayOfAnyv.length) {
        break label67;
      }
      this.jdField_a_of_type_Anyv = this.jdField_a_of_type_ArrayOfAnyv[i];
    }
    for (;;)
    {
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      return;
      label67:
      if (this.isLoop)
      {
        this.mStartTime = System.currentTimeMillis();
        this.jdField_a_of_type_Anyv = this.jdField_a_of_type_ArrayOfAnyv[0];
      }
      else if (this.bQR)
      {
        this.jdField_a_of_type_Anyv = this.jdField_a_of_type_ArrayOfAnyv[(this.jdField_a_of_type_ArrayOfAnyv.length - 1)];
      }
      else
      {
        this.jdField_a_of_type_Anyv = null;
        if (this.e != null)
        {
          this.e.byj();
          this.e = null;
        }
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.hf != null) {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    }
    while (this.jdField_a_of_type_ArrayOfAnyv == null) {
      return;
    }
    b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
  }
  
  public void dTN()
  {
    this.mIsStart = true;
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_ArrayOfAnyv != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAnyv.length)
      {
        if (this.jdField_a_of_type_ArrayOfAnyv[i] != null)
        {
          this.jdField_a_of_type_ArrayOfAnyv[i].release();
          this.jdField_a_of_type_ArrayOfAnyv[i] = null;
        }
        i += 1;
      }
    }
    try
    {
      if (this.ab != null) {
        this.ab.clear();
      }
      this.ab = null;
      this.jdField_a_of_type_ArrayOfAnyv = null;
      this.mIsReleased = true;
      this.e = null;
      super.release();
      return;
    }
    finally {}
  }
  
  public void setFps(int paramInt)
  {
    this.mFps = paramInt;
    this.dNv = ((int)(this.mFps * 0.8D));
  }
  
  public static abstract interface a
  {
    public abstract void byj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyo
 * JD-Core Version:    0.7.0.1
 */