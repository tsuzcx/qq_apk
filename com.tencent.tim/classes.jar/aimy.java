import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.table.LebaBannerLogic.1;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aimy
  implements View.OnClickListener
{
  private HashSet<Integer> ay = new HashSet();
  private Context mContext;
  public FrameLayout mRootLayout;
  
  public aimy(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, List<String> paramList, int paramInt)
  {
    int i = 0;
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (paramList = (String)paramList.get(0);; paramList = null)
    {
      if ("url".equals(paramString2))
      {
        i = 1;
        if (paramInt != 1) {
          break label113;
        }
        paramString2 = aims.a("banner_exp");
        paramString2.caq = i;
        paramString2.cgp = paramString3;
        paramString2.content_id = paramList;
        paramString2.r2 = paramString1;
        anny.b(null, paramString2);
      }
      label113:
      while (paramInt != 2)
      {
        return;
        if ("scheme".equals(paramString2))
        {
          i = 2;
          break;
        }
        if (!"miniapp".equals(paramString2)) {
          break;
        }
        i = 3;
        break;
      }
      paramString2 = aims.a("banner_clk");
      paramString2.caq = i;
      paramString2.cgp = paramString3;
      paramString2.content_id = paramList;
      paramString2.r2 = paramString1;
      anny.b(null, paramString2);
      return;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, BusinessInfoCheckUpdate.AppInfo paramAppInfo, View paramView)
  {
    ((LebaRoundLayout)paramView.findViewById(2131364055)).mRadius = aqnm.dip2px(16.0F);
    Object localObject = (LinearLayout)paramView.findViewById(2131370725);
    if (ThemeUtil.isNowThemeIsNight(paramAppRuntime, false, null))
    {
      ((LinearLayout)localObject).setBackgroundResource(2130841227);
      if ((((LinearLayout)localObject).getTag() == null) || (!(((LinearLayout)localObject).getTag() instanceof RedTouch))) {
        break label238;
      }
      paramView = (RedTouch)((LinearLayout)localObject).getTag();
    }
    for (;;)
    {
      if (paramAppInfo.red_display_info == null) {
        break label289;
      }
      localObject = paramAppInfo.red_display_info.red_type_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject).next();
        if ((localRedTypeInfo.red_type.get() == 5) || (localRedTypeInfo.red_type.get() == 4)) {
          try
          {
            JSONObject localJSONObject = new JSONObject(localRedTypeInfo.red_desc.get());
            localJSONObject.put("cr", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & this.mContext.getResources().getColor(2131167311)) }));
            localRedTypeInfo.red_desc.set(localJSONObject.toString());
          }
          catch (Exception localException)
          {
            QLog.i("Q.lebatab.LebaBannerLogic", 1, "parse json exception", localException);
          }
        }
      }
      ((LinearLayout)localObject).setBackgroundResource(2130839642);
      break;
      label238:
      paramView = paramView.findViewById(2131370632);
      paramView = new RedTouch(this.mContext, paramView).c(aqnm.dpToPx(5.0F)).b(aqnm.dpToPx(1.0F)).a(3).a();
      ((LinearLayout)localObject).setTag(paramView);
    }
    label289:
    paramView.e(paramAppInfo);
    if ((!this.ay.contains(Integer.valueOf(paramAppInfo.uiAppId.get()))) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.ay.add(Integer.valueOf(paramAppInfo.uiAppId.get()));
      ((altq)paramAppRuntime.getManager(36)).jq(paramAppInfo.uiAppId.get(), 30);
      paramAppRuntime = paramAppInfo.buffer.get();
      paramAppInfo = paramAppInfo.missions.get();
      QLog.i("Q.lebatab.LebaBannerLogic", 1, String.format("reportExposure buffer = %s missions = %s", new Object[] { paramAppRuntime, paramAppInfo }));
    }
    try
    {
      paramAppRuntime = new JSONObject(paramAppRuntime);
      a(paramAppRuntime.optString("_jump_url"), paramAppRuntime.optString("_jump_type"), paramAppRuntime.optString("_app_id"), paramAppInfo, 1);
      if (AppSetting.enableTalkBack) {
        aqcl.changeAccessibilityForView(paramView, paramView.yy(), Button.class.getName());
      }
      return;
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaBannerLogic", 1, "parse json exception", paramAppRuntime);
      }
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    QLog.i("Q.lebatab.LebaBannerLogic", 1, String.format("jump jumpUrl:%s ,jumpType:%s ,appId:%s ", new Object[] { paramString1, paramString2, paramString3 }));
    try
    {
      if ("url".equals(paramString2))
      {
        paramQQAppInterface = new Intent(this.mContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString1);
        this.mContext.startActivity(paramQQAppInterface);
        return;
      }
      paramQQAppInterface = aqik.c(paramQQAppInterface, this.mContext, paramString1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.ace();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("Q.lebatab.LebaBannerLogic", 1, "jump exception ", paramQQAppInterface);
      return;
    }
    QLog.i("Q.lebatab.LebaBannerLogic", 1, "jumpAction jAction == null");
  }
  
  public void dsU()
  {
    if (this.mRootLayout != null)
    {
      this.mRootLayout.setPadding(0, 0, 0, 0);
      this.mRootLayout.removeAllViews();
    }
  }
  
  public void notifyDataSetChanged()
  {
    ThreadManager.getUIHandler().post(new LebaBannerLogic.1(this));
  }
  
  public void onClick(View paramView)
  {
    if (this.mRootLayout == null) {
      QLog.i("Q.lebatab.LebaBannerLogic", 1, "onClick mRootLayout == null");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      dsU();
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        altq localaltq = (altq)localAppRuntime.getManager(36);
        if (localaltq != null)
        {
          Object localObject1 = localaltq.a(0, "100000");
          if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).exposure_max.get() >= 0))
          {
            String str1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();
            localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get();
            QLog.i("Q.lebatab.LebaBannerLogic", 1, String.format("onClick buffer = %s missions = %s time = %d", new Object[] { str1, localObject1, Long.valueOf(System.currentTimeMillis() - l) }));
            try
            {
              Object localObject2 = new JSONObject(str1);
              str1 = ((JSONObject)localObject2).optString("_jump_url");
              String str2 = ((JSONObject)localObject2).optString("_jump_type");
              localObject2 = ((JSONObject)localObject2).optString("_app_id");
              c((QQAppInterface)localAppRuntime, str1, str2, (String)localObject2);
              a(str1, str2, (String)localObject2, (List)localObject1, 2);
              localaltq.jq(100000, 31);
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.i("Q.lebatab.LebaBannerLogic", 1, "parse json exception ", localException);
              }
            }
          }
          else
          {
            QLog.i("Q.lebatab.LebaBannerLogic", 1, "onClick appInfo no new");
          }
        }
        else
        {
          QLog.i("Q.lebatab.LebaBannerLogic", 1, "onClick redTouchManager == null");
        }
      }
    }
  }
  
  public void onPause()
  {
    this.ay.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimy
 * JD-Core Version:    0.7.0.1
 */