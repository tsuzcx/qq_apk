package mqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.qphone.base.util.QLog;
import java.io.DataOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class NativeUtil
{
  private static boolean sLoadSO;
  
  static
  {
    try
    {
      System.loadLibrary("mqq");
      sLoadSO = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("mqq", 2, "load mqq.so error!" + localThrowable.toString());
    }
  }
  
  private static native byte[] getFrameBuffer();
  
  private static native int getHeight();
  
  private static native int getWidth();
  
  public static Bitmap screenshot(Context paramContext)
  {
    paramContext = null;
    if (sLoadSO) {}
    for (;;)
    {
      try
      {
        Object localObject = getFrameBuffer();
        paramContext = (Context)localObject;
        if (localObject == null)
        {
          paramContext = Runtime.getRuntime().exec("su");
          localObject = new DataOutputStream(paramContext.getOutputStream());
          ((DataOutputStream)localObject).writeBytes("chmod 666 /dev/graphics/fb0\n");
          ((DataOutputStream)localObject).writeBytes("exit\n");
          ((DataOutputStream)localObject).flush();
          new NativeUtil.1(paramContext).start();
          paramContext = getFrameBuffer();
        }
        if (paramContext != null)
        {
          int i = getWidth();
          int j = getHeight();
          localObject = ByteBuffer.wrap(paramContext);
          paramContext = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          paramContext.copyPixelsFromBuffer((Buffer)localObject);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.util.NativeUtil
 * JD-Core Version:    0.7.0.1
 */