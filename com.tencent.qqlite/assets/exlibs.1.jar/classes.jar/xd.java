import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;

public class xd
  implements View.OnClickListener
{
  public xd(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.getText().toString().length() > 30)
    {
      paramView = new Dialog(this.a, 2131624119);
      paramView.setContentView(2130903615);
      ((TextView)paramView.findViewById(2131296470)).setText(this.a.getString(2131363513));
      ((ProgressBar)paramView.findViewById(2131296469)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131298746)).setImageResource(2130837991);
      paramView.show();
      return;
    }
    this.a.a(this.a.a.getText().toString().trim(), false);
    this.a.a(this.a.a.getText().toString().trim(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xd
 * JD-Core Version:    0.7.0.1
 */