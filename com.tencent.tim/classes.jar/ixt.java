import android.graphics.Bitmap;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.a;

class ixt
  implements BaseGaInvite.GetGaFaceRunnable.a
{
  ixt(ixs paramixs) {}
  
  public boolean b(Bitmap paramBitmap, String paramString)
  {
    boolean bool = false;
    if (this.this$0.a != null)
    {
      this.this$0.a.setImg(paramBitmap);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixt
 * JD-Core Version:    0.7.0.1
 */