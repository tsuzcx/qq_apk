import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

public class bzp
  implements View.OnClickListener
{
  public bzp(AIOImageListScene paramAIOImageListScene) {}
  
  public void onClick(View paramView)
  {
    AIOImageListScene.a(this.a, ((TextView)paramView).getText().toString());
    AIOImageListScene.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzp
 * JD-Core Version:    0.7.0.1
 */