import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zfs
  implements View.OnClickListener
{
  zfs(zfr paramzfr, zfr.a parama) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.jdField_a_of_type_Zfr$a.textView.getText());
    zfr.a(this.jdField_a_of_type_Zfr, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfs
 * JD-Core Version:    0.7.0.1
 */