import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.a;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class xcg
  implements CustomFrameAnimationDrawable.a
{
  xcg(xbu.b paramb, xbu.a parama, MessageForPoke paramMessageForPoke) {}
  
  public void onEnd()
  {
    this.jdField_a_of_type_Xbu$a.h.clearAnimation();
    this.jdField_a_of_type_Xbu$a.h.setVisibility(8);
    this.jdField_a_of_type_Xbu$a.h.setImageDrawable(null);
    this.jdField_a_of_type_Xbu$a.hD.setVisibility(0);
    if ((this.jdField_a_of_type_Xbu$a.pos == xbu.access$400()) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) && (!(this.jdField_a_of_type_Xbu$b.this$0.mContext instanceof ChatHistoryActivity)) && (!xbu.I(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke))) {
      this.jdField_a_of_type_Xbu$a.tb.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xbu$a.a.clearAnimation();
      this.jdField_a_of_type_Xbu$a.a.setVisibility(8);
      return;
      this.jdField_a_of_type_Xbu$a.tb.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xcg
 * JD-Core Version:    0.7.0.1
 */