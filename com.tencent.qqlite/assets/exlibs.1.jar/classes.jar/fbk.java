import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser.GridViewAdapter;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class fbk
  implements ImageLoader.ImageLoadListener
{
  public fbk(FriendChooser.GridViewAdapter paramGridViewAdapter, ImageView paramImageView) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fbk
 * JD-Core Version:    0.7.0.1
 */