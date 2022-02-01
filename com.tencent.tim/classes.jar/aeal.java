import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeal
  implements CompoundButton.OnCheckedChangeListener
{
  public aeal(CampusCircleReplyActivity paramCampusCircleReplyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.this$0.getResources();
    TextView localTextView = CampusCircleReplyActivity.a(this.this$0);
    if (paramBoolean) {}
    for (localObject = ((Resources)localObject).getColorStateList(2131166615);; localObject = ((Resources)localObject).getColorStateList(2131166617))
    {
      localTextView.setTextColor((ColorStateList)localObject);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeal
 * JD-Core Version:    0.7.0.1
 */