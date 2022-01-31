import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser.GridViewAdapter;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class hnf
  implements ImageLoader.ImageLoadListener
{
  public hnf(FriendChooser.GridViewAdapter paramGridViewAdapter, ImageView paramImageView) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hnf
 * JD-Core Version:    0.7.0.1
 */