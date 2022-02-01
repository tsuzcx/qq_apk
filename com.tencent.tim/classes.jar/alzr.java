import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.Nullable;

public class alzr
{
  public static void Uh(int paramInt)
  {
    d(paramInt, null);
  }
  
  public static void a(int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    GLES20.glBindTexture(paramInt2, paramInt1);
    checkGlError("glBindTexture " + paramInt1);
    GLES20.glTexParameterf(paramInt2, 10241, paramInt3);
    GLES20.glTexParameterf(paramInt2, 10240, paramInt4);
    GLES20.glTexParameteri(paramInt2, 10242, paramInt5);
    GLES20.glTexParameteri(paramInt2, 10243, paramInt6);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    checkGlError("glTexParameter");
  }
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      ram.e("FlowEdit_GlUtil", paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
  
  public static int createTexture(int paramInt)
  {
    return createTexture(paramInt, null, 9729, 9729, 33071, 33071);
  }
  
  public static int createTexture(int paramInt, Bitmap paramBitmap)
  {
    return createTexture(paramInt, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static int createTexture(int paramInt1, @Nullable Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    checkGlError("glGenTextures");
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    checkGlError("glBindTexture " + arrayOfInt[0]);
    GLES20.glTexParameterf(paramInt1, 10241, paramInt2);
    GLES20.glTexParameterf(paramInt1, 10240, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt4);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt5);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    checkGlError("glTexParameter");
    return arrayOfInt[0];
  }
  
  public static void d(int paramInt, @Nullable Bitmap paramBitmap)
  {
    a(paramInt, 3553, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static void deleteTexture(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    checkGlError("glDeleteTextures");
  }
  
  public static int[] o(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    GLES20.glGenTextures(paramInt, arrayOfInt, 0);
    checkGlError("glGenTextures");
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzr
 * JD-Core Version:    0.7.0.1
 */