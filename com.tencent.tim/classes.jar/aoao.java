import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AutoVerticalScrollTextView;

public class aoao
{
  private View HC;
  private View HD;
  private View HE;
  private TextView ZG;
  private TextView ZH;
  private TextView ZI;
  private TextView ZJ;
  private TextView ZK;
  private TextView ZL;
  private AutoVerticalScrollTextView a;
  DiniFlyAnimationView animationView;
  private int dNN = 1;
  private TeamWorkFileImportInfo e;
  private RelativeLayout ff;
  Handler handler;
  private String[] hh = new String[2];
  private LinearLayout kI;
  private aqju m;
  private Activity mActivity;
  public AppInterface mApp;
  
  public aoao(RelativeLayout paramRelativeLayout, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.ff = paramRelativeLayout;
    this.mActivity = paramActivity;
    this.mApp = paramAppInterface;
  }
  
  private void dUd()
  {
    if ((this.m == null) || (this.m.isShowing())) {}
    try
    {
      this.m.dismiss();
      this.m = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("TeamWorkFileImportCover", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  public View a(Bundle paramBundle)
  {
    this.HE = LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131563165, this.ff, false);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.addRule(3, 2131377361);
    paramBundle.topMargin = (-getTitleBarHeight());
    this.HE.setLayoutParams(paramBundle);
    this.ff.addView(this.HE, 1);
    this.ff.findViewById(2131377361).setBackgroundColor(-1);
    this.HC = findViewById(2131379278);
    this.ZG = ((TextView)findViewById(2131379275));
    this.ZH = ((TextView)findViewById(2131379274));
    this.HD = findViewById(2131379279);
    this.animationView = ((DiniFlyAnimationView)findViewById(2131362725));
    paramBundle = (LinearLayout.LayoutParams)this.animationView.getLayoutParams();
    paramBundle.height = aqnm.dpToPx(60.0F);
    paramBundle.width = aqnm.dpToPx(60.0F);
    this.animationView.setLayoutParams(paramBundle);
    this.ZI = ((TextView)findViewById(2131379280));
    this.ZJ = ((TextView)findViewById(2131379283));
    this.ZK = ((TextView)findViewById(2131379281));
    this.ZL = ((TextView)findViewById(2131379282));
    this.a = ((AutoVerticalScrollTextView)findViewById(2131379276));
    this.hh[0] = this.mActivity.getString(2131720906);
    this.hh[1] = this.mActivity.getString(2131720907);
    this.a.setTextArray(this.hh);
    a(this.mActivity.getIntent(), this.mActivity);
    if (QLog.isColorLevel()) {
      QLog.i("teamConvert", 2, "show loading view start time [" + System.currentTimeMillis() / 1000L + "]");
    }
    this.kI = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131563161, this.ff, false));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(14, -1);
    paramBundle.addRule(12, -1);
    paramBundle.bottomMargin = aqnm.dpToPx(12.0F);
    this.ff.addView(this.kI, paramBundle);
    aobw.a(this.e, null, "0X8009ED4");
    return this.HE;
  }
  
  public void a(Intent paramIntent, Context paramContext)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      paramIntent.getExtras().setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
      this.e = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
      if (this.e != null)
      {
        if (!this.e.azu()) {
          break label213;
        }
        this.ZI.setText(paramContext.getString(2131720926));
        this.ZJ.setText(paramContext.getString(2131720929));
      }
    }
    for (;;)
    {
      this.dNN = 2;
      this.animationView.setAnimation("teamwork/tim_data_loading.json");
      this.animationView.loop(true);
      if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportCover", 2, "tencentdoc log:---FileImport start, fileName： " + this.e.fileName + " ---");
      }
      aodb.fy("cover_loading_time");
      aodb.fy("get_url_time");
      this.animationView.setVisibility(0);
      this.animationView.playAnimation();
      if ((this.e != null) && (this.e.dNQ == 9)) {
        aodb.aN(null, "0X800A4B4");
      }
      return;
      label213:
      if (this.e.dNR == 6)
      {
        this.ZI.setText(paramContext.getString(2131720925));
        this.ZJ.setText(paramContext.getString(2131720928));
      }
      else if (this.e.dNQ == 12)
      {
        this.ZI.setText(paramContext.getString(2131720975));
        this.ZJ.setText(paramContext.getString(2131720929));
      }
      else if (this.e.dNQ == 13)
      {
        this.ZI.setText(paramContext.getString(2131720952));
        this.ZJ.setVisibility(8);
        this.a.setVisibility(8);
        this.ZK.setVisibility(0);
        this.ZL.setVisibility(0);
      }
      else
      {
        this.ZI.setText(paramContext.getString(2131720924));
        this.ZJ.setText(paramContext.getString(2131720927));
      }
    }
    QQToast.a(paramContext, 2131696272, 0).show(getTitleBarHeight());
    dK(-1, null);
  }
  
  public void dK(int paramInt, String paramString)
  {
    this.dNN = 4;
    aobw.a(this.e, null, "0X800A2F2");
    if (this.mActivity == null)
    {
      QLog.i("teamConvert", 1, "showFailedView, but activity is null");
      return;
    }
    if (this.animationView != null)
    {
      this.animationView.cancelAnimation();
      this.animationView.setVisibility(8);
    }
    this.ZI.setVisibility(8);
    this.ZJ.setVisibility(8);
    this.a.setVisibility(8);
    this.HD.setVisibility(8);
    this.HC.setVisibility(0);
    label146:
    String str;
    if ((paramInt == 116) || (paramInt == -116))
    {
      this.ZG.setVisibility(0);
      if (paramInt == 116)
      {
        this.ZG.setText(this.mActivity.getResources().getString(2131720909));
        if (!TextUtils.isEmpty(paramString)) {
          break label281;
        }
        str = this.mActivity.getResources().getString(2131720916);
        label167:
        this.ZH.setText(str);
      }
    }
    for (;;)
    {
      this.ff.findViewById(2131377361).setBackgroundColor(Color.parseColor("#f6f7f9"));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("teamConvert", 2, "tencentdoc log:show failed view finish time [" + System.currentTimeMillis() / 1000L + "] error code = " + paramInt + " errorStr = " + paramString);
      return;
      if (paramInt != -116) {
        break label146;
      }
      this.ZG.setText(this.mActivity.getResources().getString(2131720938));
      break label146;
      label281:
      str = paramString;
      break label167;
      if (paramInt == 106)
      {
        str = this.mActivity.getResources().getString(2131720939);
        this.ZG.setVisibility(8);
        this.ZH.setText(str);
      }
      else
      {
        if ((Math.abs(paramInt) >= 100) && (Math.abs(paramInt) < 116))
        {
          if (TextUtils.isEmpty(paramString)) {}
          for (str = this.mActivity.getResources().getString(2131720916);; str = paramString)
          {
            this.ZG.setVisibility(8);
            this.ZH.setText(str);
            break;
          }
        }
        this.ZG.setVisibility(8);
        this.ZH.setText(this.mActivity.getResources().getString(2131720916));
      }
    }
  }
  
  public void dUe()
  {
    this.ff.findViewById(2131377361).setBackgroundColor(Color.parseColor("#f6f7f9"));
    this.HE.setVisibility(8);
    this.kI.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("teamConvert", 2, "hide loading view finish time [" + System.currentTimeMillis() / 1000L + "]");
    }
    long l = aodb.aO("cover_loading_time");
    if (this.e == null) {}
    for (String str = "";; str = this.e.traceId)
    {
      aodb.b(null, str, "0X8009E9C", String.valueOf(l), "", "");
      if (this.e == null) {
        break;
      }
      aodb.Q("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(l), this.e.traceId);
      return;
    }
    aodb.aX("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(l));
  }
  
  public void doOnDestroy()
  {
    if (isCoverVisible()) {
      aobw.a(this.e, null, "0X8009ED5");
    }
    this.mApp = null;
    this.mActivity = null;
    this.ff = null;
    if (this.a != null) {
      this.a.destroy();
    }
    this.animationView.cancelAnimation();
    this.animationView = null;
    dUd();
    this.handler = null;
    this.HE = null;
  }
  
  public View findViewById(int paramInt)
  {
    return this.mActivity.findViewById(paramInt);
  }
  
  public int getTitleBarHeight()
  {
    return this.mActivity.getResources().getDimensionPixelSize(2131299627);
  }
  
  public boolean isCoverVisible()
  {
    return (this.HE != null) && (this.HE.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoao
 * JD-Core Version:    0.7.0.1
 */