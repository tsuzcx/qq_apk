package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import anyv;
import com.tencent.qphone.base.util.QLog;

public class Texture$3
  implements Runnable
{
  public Texture$3(anyv paramanyv) {}
  
  public void run()
  {
    if (this.this$0.textureId != 0)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.this$0.textureId;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      GLES20.glFlush();
      if (QLog.isColorLevel()) {
        QLog.d("Texture", 2, "Texture->release real: textureId = " + this.this$0.textureId + ", filePath = " + anyv.a(this.this$0));
      }
      this.this$0.textureId = 0;
    }
    if ((this.this$0.bitmap != null) && (!this.this$0.bitmap.isRecycled()))
    {
      this.this$0.bitmap.recycle();
      this.this$0.bitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Texture.3
 * JD-Core Version:    0.7.0.1
 */