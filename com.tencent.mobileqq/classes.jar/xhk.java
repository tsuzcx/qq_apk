import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class xhk
{
  public static int a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    return arrayOfInt[0];
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      Object localObject;
      localOutOfMemoryError1.printStackTrace();
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        localObject = new int[1];
        GLES20.glGenFramebuffers(1, (int[])localObject, 0);
        GLES20.glBindFramebuffer(36160, localObject[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
        localObject = ByteBuffer.allocateDirect(paramInt2 * paramInt3 * 4);
        ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject);
        ((ByteBuffer)localObject).rewind();
        localBitmap.copyPixelsFromBuffer((Buffer)localObject);
        GLES20.glBindFramebuffer(36160, 0);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        Bitmap localBitmap;
        break label95;
      }
      localOutOfMemoryError1 = localOutOfMemoryError1;
      localBitmap = null;
    }
    label95:
    return localBitmap;
  }
  
  public static void a(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xhk
 * JD-Core Version:    0.7.0.1
 */