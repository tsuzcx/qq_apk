import android.opengl.GLES20;
import cooperation.qzone.util.QZLog;

public class avxb
{
  private static int compileShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt == 0)
    {
      QZLog.e("ShaderUtil", "glCreateShader: fail 0 ");
      return 0;
    }
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    paramString = new int[1];
    GLES20.glGetShaderiv(paramInt, 35713, paramString, 0);
    QZLog.e("ShaderUtil", "glGetShaderiv: " + GLES20.glGetShaderInfoLog(paramInt));
    if (paramString[0] == 0)
    {
      GLES20.glDeleteShader(paramInt);
      QZLog.e("ShaderUtil", "glGetShaderiv: fail 0 ");
      return 0;
    }
    return paramInt;
  }
  
  private static int fY(String paramString)
  {
    return compileShader(35633, paramString);
  }
  
  private static int fZ(String paramString)
  {
    return compileShader(35632, paramString);
  }
  
  public static int getProgramId()
  {
    return linkProgram(fY("attribute vec4 aPosition;\nuniform mat4 uProjectMatrix;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main(){\n\tgl_Position = uProjectMatrix * aPosition;\n    vTextureCoord = aTextureCoord;\n}"), fZ("precision mediump float;\nuniform sampler2D uTexture;\nvarying vec2 vTextureCoord;\nvoid main(){\n\tgl_FragColor = texture2D(uTexture, vTextureCoord);\n}"));
  }
  
  private static int linkProgram(int paramInt1, int paramInt2)
  {
    int i = GLES20.glCreateProgram();
    if (i == 0)
    {
      QZLog.e("ShaderUtil", "glCreateProgram: fail");
      return 0;
    }
    GLES20.glAttachShader(i, paramInt1);
    GLES20.glAttachShader(i, paramInt2);
    GLES20.glLinkProgram(i);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(i, 35714, arrayOfInt, 0);
    QZLog.e("ShaderUtil", "glGetShaderiv: " + GLES20.glGetShaderInfoLog(i));
    if (arrayOfInt[0] == 0)
    {
      GLES20.glDeleteProgram(i);
      QZLog.e("ShaderUtil", "glGetProgramiv: fail 0 ");
      return 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxb
 * JD-Core Version:    0.7.0.1
 */