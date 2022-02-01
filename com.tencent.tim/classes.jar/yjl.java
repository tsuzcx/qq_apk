import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

public class yjl
  implements View.OnClickListener, yjf
{
  private final String TAG;
  private yjh a;
  private QQAppInterface app;
  private Context mContext;
  private float mDensity;
  private SessionInfo sessionInfo;
  private View xL;
  
  public yjl(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, yjh paramyjh, Context paramContext)
  {
    this.TAG = ("TogetherWatchTroopTipsBar." + paramSessionInfo.cZ + "." + paramSessionInfo.aTl);
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.a = paramyjh;
    this.mContext = paramContext;
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void ciD()
  {
    Object localObject;
    ImageView localImageView;
    if (this.xL == null)
    {
      this.xL = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131558704, null);
      this.xL.setId(2131379971);
      this.xL.setPadding(0, (int)(this.mDensity * 2.0F), 0, (int)(this.mDensity * 2.0F));
      this.xL.setClickable(true);
      this.xL.setOnClickListener(this);
      localObject = (ThemeImageView)this.xL.findViewById(2131368708);
      localObject = (TextView)this.xL.findViewById(2131380973);
      localImageView = (ImageView)this.xL.findViewById(2131368707);
      if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        break label147;
      }
      this.xL.setBackgroundResource(2130839720);
    }
    for (;;)
    {
      ((TextView)localObject).setText(acfp.m(2131715380));
      return;
      label147:
      this.xL.setBackgroundColor(2130839714);
      ((TextView)localObject).setTextColor(-1);
      localImageView.setImageDrawable(this.mContext.getResources().getDrawable(2130839713));
    }
  }
  
  public int[] E()
  {
    return new int[2];
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.xL;
  }
  
  public int getType()
  {
    return 24;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 1000) && (this.sessionInfo.cZ == 1))
    {
      paramVarArgs = ((TroopManager)this.app.getManager(52)).a(this.sessionInfo.aTl);
      if ((paramVarArgs != null) && (paramVarArgs.isTroopOwner(this.app.getCurrentUin())))
      {
        paramVarArgs = aohy.a(this.app).a(this.sessionInfo.aTl);
        if (paramVarArgs == null) {
          break label160;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, new Object[] { "troop ", paramVarArgs.troopuin, " newNum=", Integer.valueOf(paramVarArgs.dXV), " unreadNum=", Integer.valueOf(paramVarArgs.nUnreadMsgNum) });
        }
        ciD();
        this.a.a(this, new Object[0]);
      }
    }
    label160:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.TAG, 2, "Admin but Not message");
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://qvideo.qq.com/qq/together-signing/index.html");
    this.mContext.startActivity(localIntent);
    this.a.ciA();
    aohy.a(this.app).RS(this.sessionInfo.aTl);
    anot.a(this.app, "dc00899", "Grp_AIO", "", "video_tab", "clk_whitebar", 0, 1, this.app.getCurrentUin(), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public int wM()
  {
    return 67;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjl
 * JD-Core Version:    0.7.0.1
 */