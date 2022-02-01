import android.graphics.Bitmap;
import mqq.app.QQPermissionCallback;

class wlk
  implements QQPermissionCallback
{
  wlk(wlh paramwlh, Bitmap paramBitmap) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(wlh.a(this.this$0), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.this$0.C(this.val$bitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wlk
 * JD-Core Version:    0.7.0.1
 */