import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;

class cqx
  implements Runnable
{
  cqx(cqw paramcqw, Bitmap paramBitmap) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap);
    int i = this.jdField_a_of_type_Cqw.a.getResources().getDimensionPixelSize(2131427612);
    IndividuationSetActivity.a(this.jdField_a_of_type_Cqw.a).setRightIcon(localBitmapDrawable, i, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqx
 * JD-Core Version:    0.7.0.1
 */