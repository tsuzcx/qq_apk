import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anvg
  implements View.OnClickListener
{
  anvg(anvf paramanvf) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (aqiw.getSystemNetwork(localContext) == 1)
    {
      anvf.a(this.this$0, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        anot.a(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!aqiw.isNetworkAvailable(localContext))
      {
        QQToast.a(localContext, 2131693404, 0).show();
      }
      else
      {
        Resources localResources = localContext.getResources();
        aqha.a(localContext, 232, "", acfp.m(2131715010), localResources.getString(2131721058), localResources.getString(2131721079), new anvh(this, localContext, paramView), new anvi(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvg
 * JD-Core Version:    0.7.0.1
 */