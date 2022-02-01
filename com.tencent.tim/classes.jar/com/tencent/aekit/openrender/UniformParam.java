package com.tencent.aekit.openrender;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.aekit.openrender.util.GlUtil;
import java.util.Arrays;

public abstract class UniformParam
{
  public int handle;
  public String name;
  
  public UniformParam(String paramString)
  {
    this.name = paramString;
    this.handle = -1;
  }
  
  public void clear()
  {
    this.handle = -1;
  }
  
  public void initialParams(int paramInt)
  {
    this.handle = GLES20.glGetUniformLocation(paramInt, this.name);
  }
  
  public abstract void setParams(int paramInt);
  
  public String toString()
  {
    return this.name;
  }
  
  public static class Float1sParam
    extends UniformParam
  {
    float[] value;
    
    public Float1sParam(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.value = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        this.value[i] = paramArrayOfFloat[i];
        i += 1;
      }
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform1fv(this.handle, this.value.length, this.value, 0);
      GlUtil.checkGlError("FloatParam setParams");
    }
    
    public String toString()
    {
      return this.name + " = " + this.value;
    }
  }
  
  public static class Float2fParam
    extends UniformParam
  {
    public float x;
    public float y;
    
    public Float2fParam(String paramString, float paramFloat1, float paramFloat2)
    {
      super();
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform2f(this.handle, this.x, this.y);
      GlUtil.checkGlError("Float2fParam setParams");
    }
    
    public String toString()
    {
      return this.name + " = " + this.x + ", " + this.y;
    }
  }
  
  public static class Float2sParam
    extends UniformParam
  {
    float[] value;
    
    public Float2sParam(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.value = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        this.value[i] = paramArrayOfFloat[i];
        i += 1;
      }
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform2fv(this.handle, this.value.length / 2, this.value, 0);
      GlUtil.checkGlError("Float2sParam setParams");
    }
    
    public String toString()
    {
      return this.name + " = " + this.value;
    }
  }
  
  public static class Float3fParam
    extends UniformParam
  {
    float x;
    float y;
    float z;
    
    public Float3fParam(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      super();
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.z = paramFloat3;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform3f(this.handle, this.x, this.y, this.z);
      GlUtil.checkGlError("Float3fParam setParams");
    }
    
    public String toString()
    {
      return this.name + " = " + this.x + ", " + this.y + ", " + this.z;
    }
  }
  
  public static class Float4fParam
    extends UniformParam
  {
    float w;
    float x;
    float y;
    float z;
    
    public Float4fParam(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      super();
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.z = paramFloat3;
      this.w = paramFloat4;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform4f(this.handle, this.x, this.y, this.z, this.w);
      GlUtil.checkGlError("Float4fParam setParams: " + toString());
    }
    
    public String toString()
    {
      return this.name + " = " + this.x + ", " + this.y + ", " + this.z + ", " + this.w;
    }
  }
  
  public static class Float4sParam
    extends UniformParam
  {
    float[] value;
    
    public Float4sParam(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.value = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        this.value[i] = paramArrayOfFloat[i];
        i += 1;
      }
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform4fv(this.handle, this.value.length / 4, this.value, 0);
      GlUtil.checkGlError("Float4sParam setParams");
    }
    
    public String toString()
    {
      return this.name + " = " + this.value;
    }
  }
  
  public static class FloatParam
    extends UniformParam
  {
    float value;
    
    public FloatParam(String paramString, float paramFloat)
    {
      super();
      this.value = paramFloat;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform1f(this.handle, this.value);
      GlUtil.checkGlError("FloatParam setParams");
    }
    
    public String toString()
    {
      return this.name + " = " + this.value;
    }
    
    public float value()
    {
      return this.value;
    }
  }
  
  public static class FloatsParam
    extends UniformParam
  {
    float[] value;
    
    public FloatsParam(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.value = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        this.value[i] = paramArrayOfFloat[i];
        i += 1;
      }
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      switch (this.value.length)
      {
      default: 
        GLES20.glUniform1fv(this.handle, this.value.length, this.value, 0);
      }
      for (;;)
      {
        GlUtil.checkGlError("FloatsParam setParams");
        return;
        GLES20.glUniform1f(this.handle, this.value[0]);
        continue;
        GLES20.glUniform2fv(this.handle, 1, this.value, 0);
        continue;
        GLES20.glUniform3fv(this.handle, 1, this.value, 0);
        continue;
        GLES20.glUniform4fv(this.handle, 1, this.value, 0);
        continue;
        GLES20.glUniformMatrix3fv(this.handle, 1, false, this.value, 0);
        continue;
        GLES20.glUniformMatrix4fv(this.handle, 1, false, this.value, 0);
      }
    }
    
    public String toString()
    {
      return this.name + " = " + Arrays.toString(this.value);
    }
  }
  
  public static class Int1sParam
    extends UniformParam
  {
    int[] value;
    
    public Int1sParam(String paramString, int[] paramArrayOfInt)
    {
      super();
      this.value = new int[paramArrayOfInt.length];
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.value[i] = paramArrayOfInt[i];
        i += 1;
      }
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform1iv(this.handle, this.value.length, this.value, 0);
      GlUtil.checkGlError("FloatParam setParams");
    }
    
    public String toString()
    {
      return this.name + " = " + this.value;
    }
  }
  
  public static class Int2iParam
    extends UniformParam
  {
    int x;
    int y;
    
    public Int2iParam(String paramString, int paramInt1, int paramInt2)
    {
      super();
      this.x = paramInt1;
      this.y = paramInt2;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform2i(this.handle, this.x, this.y);
      GlUtil.checkGlError("IntParam setParams");
    }
    
    public String toString()
    {
      return this.name + " = [ x = " + this.x + ", y = " + this.y + "]";
    }
  }
  
  public static class IntParam
    extends UniformParam
  {
    int value;
    
    public IntParam(String paramString, int paramInt)
    {
      super();
      this.value = paramInt;
    }
    
    public void setParams(int paramInt)
    {
      if (this.handle < 0) {
        return;
      }
      GLES20.glUniform1i(this.handle, this.value);
      GlUtil.checkGlError("IntParam setParams: " + toString());
    }
    
    public String toString()
    {
      return this.name + " = " + this.value;
    }
  }
  
  public static class Mat4Param
    extends UniformParam
  {
    private final float[] mMatrix;
    
    public Mat4Param(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.mMatrix = paramArrayOfFloat;
    }
    
    public void setParams(int paramInt)
    {
      GLES20.glUniformMatrix4fv(this.handle, 1, false, this.mMatrix, 0);
    }
    
    public String toString()
    {
      return this.name + " = " + Arrays.toString(this.mMatrix);
    }
  }
  
  public static class TextureBitmapParam
    extends UniformParam.TextureParam
  {
    boolean needRecycle = false;
    Bitmap textureBitmap;
    boolean update;
    
    public TextureBitmapParam(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
    {
      super(0, paramInt);
      this.needRecycle = paramBoolean;
      this.textureBitmap = paramBitmap;
      paramBoolean = bool;
      if (paramBitmap != null)
      {
        paramBoolean = bool;
        if (!paramBitmap.isRecycled()) {
          paramBoolean = true;
        }
      }
      this.update = paramBoolean;
    }
    
    public void clear()
    {
      GLES20.glActiveTexture(this.textureId);
      GlUtil.glDeleteTextures(1, this.texture, 0);
      super.clear();
      if ((this.needRecycle) && (this.textureBitmap != null))
      {
        this.textureBitmap.recycle();
        this.textureBitmap = null;
      }
    }
    
    public Bitmap getTextureBitmap()
    {
      return this.textureBitmap;
    }
    
    public void initialParams(int paramInt)
    {
      super.initialParams(paramInt);
      GLES20.glActiveTexture(this.textureId);
      GlUtil.glGenTextures(1, this.texture, 0);
    }
    
    public void setParams(int paramInt)
    {
      if (this.update)
      {
        GLES20.glActiveTexture(this.textureId);
        GLES20.glBindTexture(3553, this.texture[0]);
      }
      try
      {
        GLUtils.texImage2D(3553, 0, this.textureBitmap, 0);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        super.setParams(paramInt);
        this.update = false;
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
        }
      }
    }
    
    public void swapTextureBitmap(Bitmap paramBitmap)
    {
      if ((this.needRecycle) && (this.textureBitmap != null) && (!this.textureBitmap.isRecycled())) {
        this.textureBitmap.recycle();
      }
      this.textureBitmap = paramBitmap;
      if ((this.textureBitmap != null) && (!this.textureBitmap.isRecycled())) {}
      for (boolean bool = true;; bool = false)
      {
        this.update = bool;
        return;
      }
    }
  }
  
  public static class TextureParam
    extends UniformParam
  {
    public int[] texture = { 0 };
    public int textureId;
    
    public TextureParam(String paramString, int paramInt1, int paramInt2)
    {
      super();
      this.textureId = paramInt2;
      this.texture[0] = paramInt1;
    }
    
    public void clear()
    {
      super.clear();
      this.texture[0] = 0;
    }
    
    public void setParams(int paramInt)
    {
      int i = 0;
      if ((this.handle < 0) || (this.texture[0] == 0)) {
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      GLES20.glBindTexture(3553, this.texture[0]);
      paramInt = i;
      switch (this.textureId)
      {
      default: 
        paramInt = i;
      }
      for (;;)
      {
        GLES20.glUniform1i(this.handle, paramInt);
        GlUtil.checkGlError("TextureParam setParams");
        return;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
        continue;
        paramInt = 4;
        continue;
        paramInt = 5;
        continue;
        paramInt = 6;
        continue;
        paramInt = 7;
      }
    }
    
    public String toString()
    {
      return this.name + " = " + this.texture[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam
 * JD-Core Version:    0.7.0.1
 */