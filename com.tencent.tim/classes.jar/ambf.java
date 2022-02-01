import android.graphics.Bitmap.CompressFormat;
import android.opengl.GLES20;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ThumbnailUtil.1;
import java.nio.Buffer;
import java.nio.IntBuffer;

public class ambf
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, amae paramamae, ambf.b paramb)
  {
    int[] arrayOfInt1 = new int[paramInt2 * paramInt3];
    int[] arrayOfInt2 = new int[paramInt2 * paramInt3];
    Object localObject1 = IntBuffer.wrap(arrayOfInt1);
    ((IntBuffer)localObject1).position(0);
    Object localObject2;
    if (paramInt1 != 0)
    {
      localObject2 = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject2, 0);
      GLES20.glBindFramebuffer(36160, localObject2[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject1);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject2, 0);
      localObject2[0] = 0;
      localObject2 = paramamae.a;
      if (localObject2 == null) {
        break label169;
      }
      paramamae = ((ambf.a)localObject2).filePath;
      localObject1 = ((ambf.a)localObject2).compressFormat;
    }
    for (paramInt1 = ((ambf.a)localObject2).quality;; paramInt1 = 100)
    {
      ThreadManager.executeOnFileThread(new ThumbnailUtil.1(paramInt3, paramInt2, arrayOfInt1, arrayOfInt2, paramamae, (Bitmap.CompressFormat)localObject1, paramInt1, paramb));
      return;
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject1);
      break;
      label169:
      paramamae = na(paramamae.outputFilePath);
      localObject1 = Bitmap.CompressFormat.PNG;
    }
  }
  
  public static String na(String paramString)
  {
    return paramString + ".thumb.png";
  }
  
  public static class a
  {
    public Bitmap.CompressFormat compressFormat;
    public String filePath;
    public int quality;
  }
  
  public static abstract interface b
  {
    public abstract void y(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambf
 * JD-Core Version:    0.7.0.1
 */