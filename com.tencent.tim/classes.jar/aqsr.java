import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemView;
import com.tencent.mobileqq.vas.quickupdate.PobingUpdateCallback.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class aqsr
  extends aqsm
{
  public static final aqsr a = new aqsr();
  public static final HashMap<Integer, String> ph = new PobingUpdateCallback.1();
  
  public static NinePatchDrawable a(Resources paramResources, Bitmap paramBitmap)
  {
    int i = 0;
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = (paramBitmap.getWidth() / 2);
    arrayOfInt1[1] = (paramBitmap.getWidth() / 2 + 1);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = (paramBitmap.getHeight() / 2);
    arrayOfInt2[1] = (paramBitmap.getHeight() / 2 + 1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfInt1.length * 4 + arrayOfInt2.length * 4 + 36 + 32).order(ByteOrder.nativeOrder());
    localByteBuffer.put((byte)1);
    localByteBuffer.put((byte)2);
    localByteBuffer.put((byte)2);
    localByteBuffer.put((byte)9);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(0);
    localByteBuffer.putInt(arrayOfInt1[0]);
    localByteBuffer.putInt(arrayOfInt1[1]);
    localByteBuffer.putInt(arrayOfInt2[0]);
    localByteBuffer.putInt(arrayOfInt2[1]);
    while (i < 9)
    {
      localByteBuffer.putInt(1);
      i += 1;
    }
    return new NinePatchDrawable(paramResources, paramBitmap, localByteBuffer.array(), new Rect(), "");
  }
  
  public static String gm(int paramInt)
  {
    return "pobing.preview.cache." + paramInt;
  }
  
  public static boolean isEnable()
  {
    return false;
  }
  
  public Bitmap a(Context paramContext, int paramInt, String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = 320;
    paramContext = getDir(paramContext, getScid(paramInt));
    paramContext = paramContext + File.separator + paramString;
    paramString = new aqcu.a();
    aqcu.a(paramContext, localOptions, paramString);
    if (paramString.iResult != 0)
    {
      QLog.e("PobingUpdateCallback", 1, paramContext + " decodeFail: " + paramString.iResult);
      return null;
    }
    return paramString.bmp;
  }
  
  public long getBID()
  {
    return 40L;
  }
  
  protected String getRootDir()
  {
    return "newComeCard";
  }
  
  protected String getScidPrefix()
  {
    return "newComeCard.";
  }
  
  public boolean i(Context paramContext, int paramInt)
  {
    Object localObject = "newComeCard." + paramInt;
    paramContext = a.getDir(paramContext, (String)localObject);
    if (!new File(paramContext).exists()) {
      return false;
    }
    if (paramInt == 2000) {
      return new File(paramContext, "addgroup_preview.png").exists();
    }
    localObject = TroopPobingItemView.gR.values().iterator();
    File localFile;
    while (((Iterator)localObject).hasNext())
    {
      localFile = new File(paramContext, (String)((Iterator)localObject).next());
      if (!localFile.exists())
      {
        QLog.e("PobingUpdateCallback", 1, "missing: " + localFile.getAbsolutePath());
        return false;
      }
    }
    localObject = ph.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localFile = new File(paramContext, (String)((Iterator)localObject).next());
      if (!localFile.exists())
      {
        QLog.e("PobingUpdateCallback", 1, "missing: " + localFile.getAbsolutePath());
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsr
 * JD-Core Version:    0.7.0.1
 */