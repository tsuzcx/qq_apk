import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqjz
  implements CompoundButton.OnCheckedChangeListener
{
  aqjz(aqju paramaqju, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DialogInterface.OnClickListener localOnClickListener = this.val$pl;
    aqju localaqju = this.aG;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localOnClickListener.onClick(localaqju, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqjz
 * JD-Core Version:    0.7.0.1
 */