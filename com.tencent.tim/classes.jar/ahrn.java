import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class ahrn
  implements ViewSwitcher.ViewFactory
{
  ahrn(ahrb.d paramd) {}
  
  public View makeView()
  {
    CornerImageView localCornerImageView = new CornerImageView(ahrb.d.a(this.a));
    localCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localCornerImageView.setRadius(wja.dp2px(30.0F, ahrb.d.a(this.a).getResources()) / 2);
    return localCornerImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrn
 * JD-Core Version:    0.7.0.1
 */