import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class ajqt
  implements aqdf.a
{
  ajqt(ajqp paramajqp) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    synchronized (this.this$0.bn)
    {
      if (this.this$0.bn.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyProxy", 2, "onDecodeTaskCompleted: reqUin=" + paramString + ", avatar=" + paramBitmap);
        }
        this.this$0.bn.remove(paramString);
        ajqp.a(this.this$0, 4161, new Object[] { Integer.valueOf(paramInt2), paramString, paramBitmap });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqt
 * JD-Core Version:    0.7.0.1
 */