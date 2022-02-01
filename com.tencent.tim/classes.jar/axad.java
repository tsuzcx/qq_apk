import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

public class axad
  extends awwn
{
  private AlphaAnimation H = new AlphaAnimation(1.0F, 0.0F);
  private ImageView HY;
  private View Mq;
  private TextView agZ;
  private Animation.AnimationListener z = new axae(this);
  
  public axad(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public void b(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    eHc();
    if (!paramBoolean)
    {
      this.H.setAnimationListener(null);
      this.H.cancel();
      this.Mq.clearAnimation();
      this.Mq.setVisibility(8);
      return;
    }
    this.Mq.setVisibility(0);
    this.agZ.setVisibility(0);
    this.agZ.setText(paramString);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.HY.setImageBitmap(paramBitmap);
      this.HY.setVisibility(0);
    }
    for (;;)
    {
      this.H.reset();
      this.H.setAnimationListener(this.z);
      this.H.setStartOffset(2000L);
      this.H.setDuration(200L);
      this.Mq.setAnimation(this.H);
      this.H.startNow();
      return;
      this.HY.setVisibility(8);
    }
  }
  
  public void hide()
  {
    if (!aOe()) {
      return;
    }
    this.H.cancel();
    this.Mq.setVisibility(8);
  }
  
  protected void jm(View paramView)
  {
    this.Mq = paramView.findViewById(2131372471);
    this.HY = ((ImageView)paramView.findViewById(2131372472));
    this.agZ = ((TextView)paramView.findViewById(2131372470));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axad
 * JD-Core Version:    0.7.0.1
 */