import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;

class cxe
  implements Runnable
{
  cxe(cxd paramcxd, Bitmap paramBitmap) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap);
    int i = this.jdField_a_of_type_Cxd.a.getResources().getDimensionPixelSize(2131427609);
    IndividuationSetActivity.a(this.jdField_a_of_type_Cxd.a).setRightIcon(localBitmapDrawable, i, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cxe
 * JD-Core Version:    0.7.0.1
 */