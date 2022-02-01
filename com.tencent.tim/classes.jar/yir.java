import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.1;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.2;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.os.MqqHandler;

public class yir
  implements View.OnClickListener, yjf
{
  private yjh a;
  public String aYi;
  public String aYj;
  private QQAppInterface app;
  private boolean bmM = true;
  private BitmapDrawable e;
  private long lastClickTime;
  private Activity mActivity;
  private SessionInfo mSessionInfo;
  private View xK;
  
  public yir(QQAppInterface paramQQAppInterface, yjh paramyjh, SessionInfo paramSessionInfo, Activity paramActivity)
  {
    this.app = paramQQAppInterface;
    this.a = paramyjh;
    this.mSessionInfo = paramSessionInfo;
    this.mActivity = paramActivity;
    ThreadManager.post(new LightalkBlueTipsBar.1(this), 5, null, true);
  }
  
  public static boolean TE()
  {
    boolean bool = false;
    if (yis.a() != null) {
      bool = true;
    }
    return bool;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "getBarView()");
    }
    if (this.xK == null)
    {
      this.xK = LayoutInflater.from(this.mActivity).inflate(2131558669, null);
      paramVarArgs = (ImageView)this.xK.findViewById(2131370424);
      if (this.e != null)
      {
        paramVarArgs.setImageDrawable(this.e);
        paramVarArgs = (TextView)this.xK.findViewById(2131370428);
        if (this.aYi == null) {
          break label322;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "getBarView() mTextWording =" + this.aYi);
        }
        paramVarArgs.setText(this.aYi);
        paramVarArgs.setContentDescription(this.aYi + acfp.m(2131707661));
        paramVarArgs.setOnClickListener(this);
        paramVarArgs = (ImageView)this.xK.findViewById(2131370427);
        if (AppSetting.enableTalkBack) {
          paramVarArgs.setContentDescription(acfp.m(2131707660));
        }
        paramVarArgs.setOnClickListener(this);
      }
    }
    for (;;)
    {
      for (;;)
      {
        return this.xK;
        File localFile = new File(yis.aYm);
        if ((localFile != null) && (localFile.exists())) {}
        try
        {
          this.e = new BitmapDrawable(this.mActivity.getResources(), aqcu.decodeFile(yis.aYm));
          if (QLog.isDevelopLevel()) {
            QLog.i("LightalkBlueTipsBar", 4, "load icon to bitmap ");
          }
          if (this.e != null) {
            paramVarArgs.setImageDrawable(this.e);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("LightalkBlueTipsBar", 2, "decodeFile Failed!", localThrowable);
            }
            this.e = ((BitmapDrawable)this.mActivity.getResources().getDrawable(2130845741));
            localThrowable.printStackTrace();
          }
        }
      }
      return null;
      label322:
      return null;
      this.bmM = false;
    }
  }
  
  public int getType()
  {
    return 12;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    label7:
    do
    {
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              break label7;
              break label7;
              break label7;
              do
              {
                return;
              } while (this.mSessionInfo.cZ != 0);
              if (QLog.isColorLevel()) {
                QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW");
              }
              paramVarArgs = this.app.getPreferences();
            } while (!paramVarArgs.getBoolean("lightalk_tip_" + this.app.getCurrentAccountUin(), false));
            str = paramVarArgs.getString("Lightalk_tips_frdUin", null);
          } while ((str == null) || (!str.equals(this.mSessionInfo.aTl)));
          paramInt = paramVarArgs.getInt("LT_tip_show_times" + this.app.getCurrentAccountUin(), 0);
          if (QLog.isColorLevel()) {
            QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====> tipsum = " + paramInt);
          }
          if (paramInt < 3) {
            break;
          }
        } while (!(this.a.a() instanceof yir));
        this.a.ciA();
        return;
      } while (!this.a.a(this, new Object[0]));
      anot.a(this.app, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "" + (paramInt + 1), "", "", "");
    } while (!this.bmM);
    ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.2(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.a.ciA();
      ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.3(this));
      long l;
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        l = System.currentTimeMillis();
      } while (l - this.lastClickTime < 200L);
      this.lastClickTime = l;
      Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("url", this.aYj);
      this.mActivity.startActivity(localIntent);
      anot.a(this.app, "CliOper", "", "", "0X8005111", "0X8005111", 0, 0, "", "", "", "");
      continue;
      anot.a(this.app, "CliOper", "", "", "0X8005110", "0X8005110", 0, 0, "", "", "", "");
    }
  }
  
  public int wM()
  {
    return 45;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yir
 * JD-Core Version:    0.7.0.1
 */