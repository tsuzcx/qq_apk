package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import iqh;
import iqi;
import iqj;
import irc;

public class TextureProgram
{
  iqi[] a;
  int arT = -1;
  int arU = -1;
  int mProgram = -1;
  
  public TextureProgram()
  {
    this("uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;}", "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D  uTextureSampler0;void main() {gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);gl_FragColor *= uAlpha;}", new iqi[] { new iqh("aPosition"), new iqj("uMatrix"), new iqj("uAlpha"), new iqj("uTextureMatrix"), new iqj("uTextureSampler0") }, false);
  }
  
  protected TextureProgram(String paramString1, String paramString2, iqi[] paramArrayOfiqi, boolean paramBoolean)
  {
    this.arT = loadShader(35633, paramString1);
    this.arU = loadShader(35632, paramString2);
    this.a = paramArrayOfiqi;
    this.mProgram = a(this.arT, this.arU, this.a);
  }
  
  public static int a(int paramInt1, int paramInt2, iqi[] paramArrayOfiqi)
  {
    int i = 0;
    int j = GLES20.glCreateProgram();
    irc.lx();
    if (j == 0)
    {
      QLog.e("TextureProgram", 2, "Cannot create GL program: = " + GLES20.glGetError());
      return 0;
    }
    GLES20.glAttachShader(j, paramInt1);
    irc.lx();
    GLES20.glAttachShader(j, paramInt2);
    irc.lx();
    GLES20.glLinkProgram(j);
    irc.lx();
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(j, 35714, arrayOfInt, 0);
    paramInt1 = i;
    if (arrayOfInt[0] != 1)
    {
      GLES20.glDeleteProgram(j);
      return 0;
    }
    while (paramInt1 < paramArrayOfiqi.length)
    {
      paramArrayOfiqi[paramInt1].loadHandle(j);
      paramInt1 += 1;
    }
    return j;
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    irc.lx();
    GLES20.glCompileShader(paramInt);
    irc.lx();
    return paramInt;
  }
  
  public iqi[] a()
  {
    return this.a;
  }
  
  public int getId()
  {
    return this.mProgram;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.program.TextureProgram
 * JD-Core Version:    0.7.0.1
 */