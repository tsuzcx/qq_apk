import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;

public class uyw
  implements View.OnClickListener
{
  public uyw(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    if (MixedMsgItemBuilder.a(this.a)) {
      return;
    }
    MixedMsgItemBuilder.a(this.a).onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyw
 * JD-Core Version:    0.7.0.1
 */