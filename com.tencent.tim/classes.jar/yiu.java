import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.LocationShareTipsBar.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

public class yiu
  implements View.OnClickListener, aqdf.a, yjf
{
  private static long JZ;
  private aqdf a;
  private boolean bmN;
  private BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQBlurView jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView;
  private ViewGroup dx;
  private Runnable eF = new LocationShareTipsBar.1(this);
  private HashMap<String, ImageView> ha;
  
  public yiu(BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.ha = new HashMap(3);
    this.a = new aqdf(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.a.a(this);
  }
  
  private void c(String paramString, ImageView paramImageView)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity != BaseActivity.sTopActivity) {
      return;
    }
    Bitmap localBitmap = this.a.b(1, paramString);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setVisibility(4);
    this.ha.put(paramString, paramImageView);
    this.a.i(paramString, 200, true);
  }
  
  private void c(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity;
    if (this.dx == null)
    {
      this.dx = ((ViewGroup)View.inflate((Context)localObject, 2131561203, null));
      this.dx.setOnClickListener(this);
    }
    this.dx.setClickable(true);
    this.dx.findViewById(2131374828).setVisibility(8);
    this.dx.findViewById(2131374829).setVisibility(8);
    this.dx.findViewById(2131374830).setVisibility(8);
    TextView localTextView = (TextView)this.dx.findViewById(2131374827);
    if (ThemeUtil.isInNightMode(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app)) {
      localTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    cix();
    if (paramBoolean)
    {
      paramString = "你" + ((Activity)localObject).getString(2131698279);
      localTextView.setText(paramString);
      if (!this.bmN)
      {
        anot.a(null, "CliOper", "", "", "0X800A767", "0X800A767", 1, 0, "", "0", "0", "");
        this.bmN = true;
      }
      aitz.p(this.dx, paramString);
      if ((paramList.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramList.get(0)))) {
        c((String)paramList.get(0), (ImageView)this.dx.findViewById(2131374828));
      }
      if ((paramList.size() > 1) && (!TextUtils.isEmpty((CharSequence)paramList.get(1)))) {
        c((String)paramList.get(1), (ImageView)this.dx.findViewById(2131374829));
      }
      if ((paramList.size() > 2) && (!TextUtils.isEmpty((CharSequence)paramList.get(2)))) {
        c((String)paramList.get(2), (ImageView)this.dx.findViewById(2131374830));
      }
      this.dx.addOnAttachStateChangeListener(new yiv(this));
      ciy();
      return;
    }
    if (paramInt == 1) {}
    for (localObject = ((Activity)localObject).getString(2131698279);; localObject = String.format(((Activity)localObject).getString(2131698278), new Object[] { Integer.valueOf(paramInt) }))
    {
      String str = paramString + (String)localObject;
      aitz.c(paramString, (String)localObject, localTextView);
      if (!this.bmN)
      {
        anot.a(null, "CliOper", "", "", "0X800A767", "0X800A767", 2, 0, "", "0", "0", "");
        this.bmN = true;
      }
      aitz.p(this.dx, str + " 点击加入位置共享");
      break;
    }
  }
  
  @TargetApi(19)
  private void cix()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.dx.findViewById(2131374826));
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.iD(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mAIORootView);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.iE(this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.YI(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.bg(8.0F);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.YK(4);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onCreate();
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
    }
  }
  
  private void ciy()
  {
    View localView = this.dx.findViewById(2131374832);
    ImageView localImageView = (ImageView)this.dx.findViewById(2131374825);
    if (auvj.isNightMode())
    {
      localView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localImageView.setImageResource(2130839711);
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    }
    localImageView.setImageResource(2130839710);
  }
  
  public int[] E()
  {
    return new int[0];
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.dx;
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    c(paramBoolean, paramString, paramInt, paramList);
  }
  
  public int getType()
  {
    return 25;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000) {
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView != null)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.eF);
        ThreadManager.getUIHandlerV2().postDelayed(this.eF, 0L);
      }
    }
    while ((paramInt != 1003) || (this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView == null)) {
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.eF);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - JZ < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareTipsBar", 2, new Object[] { "onClick: invoked. ", " v: ", paramView });
      }
      JZ = System.currentTimeMillis();
      LocationShareFragment.c(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, 3);
      anot.a(null, "CliOper", "", "", "0X800A768", "0X800A768", 0, 0, "", "0", "0", "");
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.ha.get(paramString);
    if (paramString != null)
    {
      paramString.setImageBitmap(paramBitmap);
      paramString.setVisibility(0);
    }
  }
  
  public int wM()
  {
    return 60;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yiu
 * JD-Core Version:    0.7.0.1
 */