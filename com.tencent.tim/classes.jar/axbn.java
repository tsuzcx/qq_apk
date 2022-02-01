import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class axbn
  implements axic.d
{
  axbn(axbm paramaxbm, ToServiceMsg paramToServiceMsg) {}
  
  public void onFail(int paramInt)
  {
    axbm.a(this.this$0, null, null);
  }
  
  public void p(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = axbm.b(this.this$0.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        axbm.a(this.this$0, null, null);
        return;
      }
      axbm.a(this.this$0, this.f, paramBitmap);
      return;
    }
    axbm.a(this.this$0, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbn
 * JD-Core Version:    0.7.0.1
 */