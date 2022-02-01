import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yjp
  implements View.OnClickListener, yjf
{
  public static String aYa = "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=";
  private yjh a;
  private QQAppInterface mApp;
  private Context mContext;
  private String mTroopUin;
  
  public yjp(QQAppInterface paramQQAppInterface, Context paramContext, yjh paramyjh)
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
    paramVarArgs = LayoutInflater.from(this.mContext).inflate(2131558703, null);
    paramVarArgs.setOnClickListener(this);
    return paramVarArgs;
  }
  
  public int getType()
  {
    return 21;
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
        QLog.d("UpgradeBigTroopTipsBar", 2, "click tips, jump");
      }
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", aYa + this.mTroopUin + "&from=aio");
      localIntent.putExtra("hide_operation_bar", true);
      this.mContext.startActivity(localIntent);
      ((TroopManager)this.mApp.getManager(52)).dM(this.mTroopUin, 3);
      this.a.ciA();
      anot.a(this.mApp, "dc00899", "Grp_up", "", "Grp_AIO", "clk", 0, 0, this.mTroopUin, "", "", "");
    }
  }
  
  public int wM()
  {
    return 25;
  }
  
  public void yJ(String paramString)
  {
    this.mTroopUin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjp
 * JD-Core Version:    0.7.0.1
 */