import android.opengl.GLES20;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class adkg
{
  public static final float[] bY = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  public static final String btI = acfp.m(2131707591);
  public static String btJ = "    //抠像逻辑片段\n";
  public static String btK = "    //用户定义，抠像后逻辑片段\n";
  public static String btL = "}\n";
  
  public static void checkGlError(String paramString)
  {
    if (QLog.isColorLevel())
    {
      int i = GLES20.glGetError();
      if (i != 0) {
        Log.e("KeyingUtil", paramString + ": glError 0x" + Integer.toHexString(i));
      }
    }
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = loadShader(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    checkGlError("glCreateProgram");
    if (k == 0) {
      Log.e("KeyingUtil", "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    checkGlError("glAttachShader");
    GLES20.glAttachShader(k, j);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("KeyingUtil", "Could not link program:" + GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public static String dI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        throw new IllegalArgumentException("invalid textureType!");
      }
      break;
    case 1: 
      return "#define TEXTURE_TYPE_OES\n";
    case 2: 
      return "#define TEXTURE_TYPE_SAMPLER2D\n";
    case 3: 
      return "#define TEXTURE_TYPE_Y_U_V\n";
    case 4: 
      return "#define TEXTURE_TYPE_Y_UV\n";
    }
    return "";
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    checkGlError("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("KeyingUtil", "Could not compile shader " + paramInt + ":" + GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkg
 * JD-Core Version:    0.7.0.1
 */