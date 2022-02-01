import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class agxp
  implements View.OnClickListener
{
  agxp(agxo paramagxo) {}
  
  public void onClick(View paramView)
  {
    if (!agxo.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((ahav.amK()) && (agmz.fO() > agmx.fJ()))
      {
        ahal.a(SplashActivity.sTopActivity, 2131693826, 2131693832, new agxq(this));
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(agmz.D());
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
        agxo.b(this.a, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxp
 * JD-Core Version:    0.7.0.1
 */