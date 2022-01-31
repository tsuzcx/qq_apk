import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;

public class vdk
  implements View.OnClickListener
{
  public vdk(GrayTipsItemBuilder paramGrayTipsItemBuilder, long paramLong) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uinType", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a.a);
    localIntent.putExtra("uniseq", this.jdField_a_of_type_Long);
    PublicFragmentActivity.Launcher.a(paramView.getContext(), localIntent, PublicTransFragmentActivity.class, ScoreQAVFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdk
 * JD-Core Version:    0.7.0.1
 */