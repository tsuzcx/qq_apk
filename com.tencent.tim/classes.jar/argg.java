import android.view.View;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

public class argg
  extends URLDrawableDownListener.Adapter
{
  public argg(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramURLDrawable.getCurrDrawable();
    if ((paramView instanceof ApngDrawable)) {
      VasFaceManager.a(null, (ApngDrawable)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argg
 * JD-Core Version:    0.7.0.1
 */