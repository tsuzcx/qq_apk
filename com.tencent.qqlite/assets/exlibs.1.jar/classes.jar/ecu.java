import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.EditActivity;
import java.util.ArrayList;
import java.util.Collections;

class ecu
  implements Animation.AnimationListener
{
  ecu(ect paramect) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    EditActivity.a(this.a.a).setVisibility(0);
    paramAnimation = new ArrayList();
    int i = 0;
    while (i < 6)
    {
      paramAnimation.add(Integer.valueOf(i));
      i += 1;
    }
    Collections.shuffle(paramAnimation);
    i = 0;
    if (i < 6)
    {
      View localView = EditActivity.a(this.a.a).getChildAt(((Integer)paramAnimation.get(i)).intValue());
      if (localView == null) {}
      for (;;)
      {
        i += 1;
        break;
        localView.postDelayed(new ecv(this, (ImageView)localView.findViewById(2131298217), (TextView)localView.findViewById(2131298218)), i * 100);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    EditActivity.a(this.a.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecu
 * JD-Core Version:    0.7.0.1
 */