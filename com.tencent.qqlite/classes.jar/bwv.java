import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;

public class bwv
  implements View.OnClickListener
{
  public bwv(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (MixedMsgItemBuilder.a(this.a)) {
      return;
    }
    MixedMsgItemBuilder.a(this.a).onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bwv
 * JD-Core Version:    0.7.0.1
 */