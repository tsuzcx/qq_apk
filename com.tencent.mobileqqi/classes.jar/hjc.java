import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser.SearchResultAdapter;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class hjc
  implements ImageLoader.ImageLoadListener
{
  public hjc(FriendChooser.SearchResultAdapter paramSearchResultAdapter, ImageView paramImageView) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hjc
 * JD-Core Version:    0.7.0.1
 */