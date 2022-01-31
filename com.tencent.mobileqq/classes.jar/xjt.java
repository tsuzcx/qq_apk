import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;

class xjt
  implements Runnable
{
  xjt(xjs paramxjs, Object paramObject) {}
  
  public void run()
  {
    if (ThemeHbFragment.a(this.jdField_a_of_type_Xjs.a) != null) {
      ThemeHbFragment.a(this.jdField_a_of_type_Xjs.a).setBackgroundDrawable(null);
    }
    ThemeHbFragment.a(this.jdField_a_of_type_Xjs.a).setImageBitmap(ThemeHbFragment.a(this.jdField_a_of_type_Xjs.a, (Bitmap)this.jdField_a_of_type_JavaLangObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjt
 * JD-Core Version:    0.7.0.1
 */