import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class cjg
  implements View.OnClickListener
{
  public cjg(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    paramView = this.a.a.getText().toString();
    Intent localIntent = this.a.getIntent();
    localIntent.putExtra("result", paramView);
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjg
 * JD-Core Version:    0.7.0.1
 */