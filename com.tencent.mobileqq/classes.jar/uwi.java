import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;

class uwi
  implements Runnable
{
  uwi(uwh paramuwh, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (DoodleMsgLayout.a(this.jdField_a_of_type_Uwh.a) != null)
    {
      PhotoProgressDrawable localPhotoProgressDrawable = new PhotoProgressDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, false);
      localPhotoProgressDrawable.setBounds(new Rect(0, 0, AIOUtils.a(19.0F, this.jdField_a_of_type_Uwh.a.getResources()), AIOUtils.a(19.0F, this.jdField_a_of_type_Uwh.a.getResources())));
      DoodleMsgLayout.a(this.jdField_a_of_type_Uwh.a).setImageDrawable(localPhotoProgressDrawable);
    }
    DoodleMsgLayout.b(this.jdField_a_of_type_Uwh.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwi
 * JD-Core Version:    0.7.0.1
 */