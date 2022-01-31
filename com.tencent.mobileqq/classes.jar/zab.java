import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class zab
  implements View.OnClickListener
{
  public zab(ApolloGuestsStateActivity paramApolloGuestsStateActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    this.a.setResult(2, paramView);
    VipUtils.a(this.a.app, "cmshow", "Apollo", "dresscheckai", this.a.d, 0, new String[0]);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zab
 * JD-Core Version:    0.7.0.1
 */