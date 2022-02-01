import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class mlv
  implements mlu.a
{
  mlv(mlu parammlu, Bitmap[] paramArrayOfBitmap) {}
  
  public void a(Bitmap paramBitmap, mlu parammlu)
  {
    this.g[0] = paramBitmap;
    mlu.a(this.b);
  }
  
  public void aPX()
  {
    mlu.a(this.b);
    if (mlu.a(this.b) <= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTask", 2, "onCaptureFailed try angin tryCount:" + mlu.a(this.b) + "  CaptureTask:" + this.b);
      }
      this.b.b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mlv
 * JD-Core Version:    0.7.0.1
 */