import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;

class uog
  implements Runnable
{
  uog(uof paramuof, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (DoodleMsgLayout.a(this.jdField_a_of_type_Uof.a) != null)
    {
      PhotoProgressDrawable localPhotoProgressDrawable = new PhotoProgressDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, false);
      localPhotoProgressDrawable.setBounds(new Rect(0, 0, AIOUtils.a(19.0F, this.jdField_a_of_type_Uof.a.getResources()), AIOUtils.a(19.0F, this.jdField_a_of_type_Uof.a.getResources())));
      DoodleMsgLayout.a(this.jdField_a_of_type_Uof.a).setImageDrawable(localPhotoProgressDrawable);
    }
    DoodleMsgLayout.b(this.jdField_a_of_type_Uof.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uog
 * JD-Core Version:    0.7.0.1
 */