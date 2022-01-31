import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.richstatus.IIconListener;

public class ydc
  implements IIconListener
{
  private ydc(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 200))
    {
      if (this.b.d != 0) {
        this.b.b = true;
      }
    }
    else {
      return;
    }
    this.b.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ydc
 * JD-Core Version:    0.7.0.1
 */