import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.widget.LocationDetailActivity;

public class ibn
  implements View.OnClickListener
{
  public ibn(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = LocationDetailActivity.b(this.a);
    paramView = new Intent(this.a.getIntent());
    paramView.putExtras((Intent)localObject);
    paramView.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = paramView.getStringExtra("pluginsdk_selfuin");
    QfavHelper.a(this.a, (String)localObject, paramView, 13321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ibn
 * JD-Core Version:    0.7.0.1
 */