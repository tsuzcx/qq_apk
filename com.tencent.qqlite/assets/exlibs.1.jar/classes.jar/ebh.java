import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import java.util.HashMap;

class ebh
  implements Runnable
{
  ebh(ebg paramebg, Bitmap paramBitmap) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_Ebg.a.a.get("map_key_face");
    if (localImageView != null) {
      localImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebh
 * JD-Core Version:    0.7.0.1
 */