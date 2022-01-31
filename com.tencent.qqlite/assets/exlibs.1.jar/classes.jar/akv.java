import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class akv
  implements View.OnClickListener
{
  public akv(EditActivity paramEditActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     akv
 * JD-Core Version:    0.7.0.1
 */