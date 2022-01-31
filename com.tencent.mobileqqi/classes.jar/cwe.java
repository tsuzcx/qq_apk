import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HelloListActivity;
import com.tencent.mobileqq.activity.NearPeopleActivity;

public class cwe
  implements View.OnClickListener
{
  public cwe(HelloListActivity paramHelloListActivity) {}
  
  public void onClick(View paramView)
  {
    if (HelloListActivity.a(this.a) == HelloListActivity.b)
    {
      HelloListActivity.a(this.a);
      return;
    }
    this.a.startActivity(new Intent(this.a.getBaseContext(), NearPeopleActivity.class).putExtra(NearPeopleActivity.a, NearPeopleActivity.g));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwe
 * JD-Core Version:    0.7.0.1
 */