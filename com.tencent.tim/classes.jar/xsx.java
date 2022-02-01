import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.a;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.24.1;

public class xsx
  implements AIOGalleryAdapter.a
{
  xsx(xsk paramxsk) {}
  
  public void db(int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.this$0.getRootView().findViewById(2131367844);
      if (localView != null) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          localView.setVisibility(0);
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAlphaAnimation.setDuration(300L);
          localView.startAnimation(localAlphaAnimation);
          localView.postDelayed(new AIOGalleryScene.24.1(this, localView), 8000L);
          return;
          if (1 != paramInt) {
            break;
          }
        } while ((this.this$0.a == null) || (((xsk.J(this.this$0) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)xsk.K(this.this$0)).biy)) || (this.this$0.biF));
        this.this$0.c(null);
        return;
        if (2 != paramInt) {
          break;
        }
        this.this$0.a(null);
      } while ((this.this$0.a == null) || (((xsk.L(this.this$0) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)xsk.M(this.this$0)).biy)) || (this.this$0.biF));
      this.this$0.a.e(this.this$0.b.c().e);
      return;
    } while (3 != paramInt);
    this.this$0.b.c().a.bjy = true;
    this.this$0.Ko.setText("");
    this.this$0.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsx
 * JD-Core Version:    0.7.0.1
 */