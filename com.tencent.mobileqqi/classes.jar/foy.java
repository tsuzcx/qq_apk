import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.emoticonview.HorizonEmoticonTabs;

public class foy
  implements Runnable
{
  public foy(HorizonEmoticonTabs paramHorizonEmoticonTabs, int paramInt, Drawable paramDrawable) {}
  
  public void run()
  {
    Object localObject = HorizonEmoticonTabs.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs).getChildAt(this.jdField_a_of_type_Int);
    if (localObject == null) {
      return;
    }
    localObject = (ImageView)((View)localObject).findViewById(2131231654);
    ((ImageView)localObject).setAdjustViewBounds(false);
    ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((ImageView)localObject).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     foy
 * JD-Core Version:    0.7.0.1
 */