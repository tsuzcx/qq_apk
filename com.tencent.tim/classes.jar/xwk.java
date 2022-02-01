import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.AppletsChatPie.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;

public class xwk
  extends BaseChatPie
{
  private View mEmptyView;
  
  public xwk(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void cfp()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    this.rC.setVisibility(8);
    this.rz.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  private void hideEmptyView()
  {
    if (this.mEmptyView != null) {
      this.mEmptyView.setVisibility(8);
    }
  }
  
  private void showEmptyView()
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioshowemptyview", 1) == 1) {
      i = 1;
    }
    for (;;)
    {
      AnyScaleTypeImageView localAnyScaleTypeImageView;
      Object localObject;
      if (i != 0) {
        if (this.mEmptyView == null)
        {
          this.mEmptyView = LayoutInflater.from(this.mContext).inflate(2131558634, null);
          if (this.mEmptyView != null)
          {
            localAnyScaleTypeImageView = (AnyScaleTypeImageView)this.mEmptyView.findViewById(2131366414);
            if (localAnyScaleTypeImageView != null) {
              localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptybackgroundurl", "https://qzonestyle.gtimg.cn/aoi/sola/20190329164016_N0Y2CuctLc.png");
            }
          }
        }
      }
      try
      {
        localAnyScaleTypeImageView.setImageURL((String)localObject);
        localObject = (TextView)this.mEmptyView.findViewById(2131366434);
        if (localObject != null) {
          ((TextView)localObject).setText(QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptytips", "还没收到过小程序通知哦"));
        }
        if (this.fs != null) {
          this.fs.addView(this.mEmptyView, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.mEmptyView != null) {
          this.mEmptyView.setVisibility(0);
        }
        return;
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AppletsChatPie", 1, "initEmptyLayout set image error! url: " + (String)localObject, localThrowable);
        }
      }
    }
  }
  
  public void aQ()
  {
    if ((this.sessionInfo != null) && (this.sessionInfo.entrance == 22))
    {
      this.uiHandler.post(new AppletsChatPie.1(this));
      return;
    }
    super.aQ();
  }
  
  public boolean af(boolean paramBoolean)
  {
    return super.af(paramBoolean);
  }
  
  public void bGE()
  {
    super.bGE();
    cfp();
  }
  
  public void bGZ()
  {
    super.bGZ();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130841224, 2130841224);
  }
  
  public void bHE()
  {
    super.bHE();
    if ((this.jdField_a_of_type_Wki == null) || (this.jdField_a_of_type_Wki.getCount() < 1))
    {
      showEmptyView();
      return;
    }
    hideEmptyView();
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PublicFragmentActivity.start(a(), AppletsSettingFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwk
 * JD-Core Version:    0.7.0.1
 */