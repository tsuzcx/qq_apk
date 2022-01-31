import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.ShareSelectionFriendListAdapter;
import com.tencent.mobileqq.util.ImageLoader;

public class bhg
  implements ImageLoader
{
  public bhg(ShareSelectionFriendListAdapter paramShareSelectionFriendListAdapter) {}
  
  public void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhg
 * JD-Core Version:    0.7.0.1
 */