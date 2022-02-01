import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yje
  implements View.OnClickListener, yjf
{
  private yjh a;
  private QQAppInterface mApp;
  private Context mContext;
  private String mUrl;
  
  public yje(QQAppInterface paramQQAppInterface, Context paramContext, yjh paramyjh)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.a = paramyjh;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = ((wjw)this.mApp.getManager(218)).a();
    this.mUrl = paramVarArgs.tipsUrl;
    paramVarArgs = paramVarArgs.tipsMsg;
    View localView = LayoutInflater.from(this.mContext).inflate(2131558702, null);
    ((TextView)localView.findViewById(2131362561)).setText(paramVarArgs);
    localView.setOnClickListener(this);
    localView.findViewById(2131362559).setOnClickListener(this);
    return localView;
  }
  
  public int getType()
  {
    return 18;
  }
  
  public void h(int paramInt, Object... paramVarArgs) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TimTipsBar", 2, "click tips, jump");
      }
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.mUrl);
      localIntent.putExtra("hide_operation_bar", true);
      this.mContext.startActivity(localIntent);
      anot.a(null, "dc00898", "", "", "0X8008948", "0X8008948", 0, 0, "", "", "", "");
      this.a.ciA();
    }
  }
  
  public int wM()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yje
 * JD-Core Version:    0.7.0.1
 */