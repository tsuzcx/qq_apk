import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.b;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.10;
import java.util.HashMap;

public class aboe
  extends abyn
{
  public aboe(CmGameSubProcessHandler.10 param10) {}
  
  public void httpCallBack(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 200)
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
      localObject = Bitmap.createBitmap(paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      localCanvas.drawBitmap(paramArrayOfByte, 0.0F, 0.0F, null);
      localCanvas.save();
      paramArrayOfByte.recycle();
      if (localObject != null)
      {
        this.a.a.f((Bitmap)localObject, 200);
        aboc.b(this.a.this$0).put(this.a.bgB, localObject);
      }
      return;
    }
    this.a.a.f(null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aboe
 * JD-Core Version:    0.7.0.1
 */