import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.SignatureView;

public class vet
  implements View.OnTouchListener
{
  public vet(RichStatItemBuilder paramRichStatItemBuilder, RichStatItemBuilder.Holder paramHolder) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((SignatureView)paramView).a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vet
 * JD-Core Version:    0.7.0.1
 */