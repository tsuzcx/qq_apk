import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiso
  implements View.OnClickListener
{
  aiso(aisj paramaisj, Activity paramActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    aisj.a(this.this$0).setClickable(false);
    aisj.a(this.this$0).setImageDrawable(this.val$activity.getResources().getDrawable(2130841358));
    aisj.a(this.this$0).Lv(true);
    aisj.a(this.this$0, aisj.a(this.this$0).c());
    if (this.bi.getText().length() > 0) {
      this.bi.setText("");
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.Iq("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiso
 * JD-Core Version:    0.7.0.1
 */