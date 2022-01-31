import UserGrowth.stReportItem;
import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.GetMineWSPersonalRequest;
import com.tencent.biz.videostory.widget.view.MineWSPanel.3;
import com.tencent.biz.videostory.widget.view.MineWSPanel.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;
import mqq.app.MobileQQ;

public class wzm
  implements IEventReceiver
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GetMineWSPersonalRequest jdField_a_of_type_ComTencentBizVideostoryNetworkRequestGetMineWSPersonalRequest;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private String jdField_a_of_type_JavaLangString;
  private wpm jdField_a_of_type_Wpm;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public wzm(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Wpm = new wpm(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  @NonNull
  private WSDownloadParams a(int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 3;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = paramInt;
    stReportItem localstReportItem = rzu.a();
    localstReportItem.pagetype = 1;
    localstReportItem.optype = 115;
    localWSDownloadParams.mStReportItem = localstReportItem;
    return localWSDownloadParams;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.i("MineWSPanel", 2, "response is null");
      return;
    }
    ThreadManager.excute(new MineWSPanel.3(this, paramArrayOfByte), 32, null, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)))
    {
      QLog.i("MineWSPanel", 2, "setWeiShiPanelState isShow:" + paramBoolean);
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(paramBoolean);
    }
  }
  
  private void d()
  {
    String str = "weishi://profile?person_id=";
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      str = "weishi://profile?person_id=" + this.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (str = str + "&logsour=2020020031";; str = str + "&logsour=2020020029")
    {
      sak.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "biz_src_jc_gxl", str);
      return;
    }
  }
  
  private void e()
  {
    sak.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "biz_src_jc_gxl", "weishi://camera?logsour=2020020030");
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    QLog.i("MineWSPanel", 2, "requestWeiShiFeedListDataFromServer mUin=" + this.jdField_a_of_type_JavaLangString);
    if (!mpq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApplication().getApplicationContext())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestGetMineWSPersonalRequest = new GetMineWSPersonalRequest(this.jdField_a_of_type_JavaLangString + "", 1);
    VSNetworkHelper.a().a(this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestGetMineWSPersonalRequest, new wzq(this));
  }
  
  public void a(WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp, boolean paramBoolean)
  {
    if (paramstGetPersonalPageRsp == null) {
      QLog.i("MineWSPanel", 2, "rsp is null");
    }
    label171:
    for (;;)
    {
      return;
      int j = paramstGetPersonalPageRsp.feed_num.get();
      this.jdField_b_of_type_JavaLangString = paramstGetPersonalPageRsp.personid.get();
      int i;
      if (j > 0) {
        if (!paramBoolean)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            i = 1;
            wye.a("weishi_share_prof", "entry_exp", i, 0, new String[0]);
          }
        }
        else
        {
          b(true);
          if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(j + ajjy.a(2131640981));
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {
          break label171;
        }
        paramstGetPersonalPageRsp = paramstGetPersonalPageRsp.feeds.get();
        if ((paramstGetPersonalPageRsp != null) && (paramstGetPersonalPageRsp.size() != 0)) {
          break label173;
        }
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        return;
        i = 2;
        break;
        b(false);
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        }
      }
    }
    label173:
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    QLog.i("MineWSPanel", 2, "setData(),mIsCurrentUser=" + this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Wpm.a(paramstGetPersonalPageRsp, this.jdField_a_of_type_Boolean);
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131304482));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131302061);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304483));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304484));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131313681));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    localLinearLayoutManager.setRecycleChildrenOnDetach(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Wpm);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131304746));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new wzn(this));
    this.jdField_a_of_type_Wpm.a(new wzo(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      wye.a("weishi_share_prof", "entry_clk", i, 0, new String[0]);
      if (vnd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break label112;
      }
      wye.a("weishi_share_prof", "dl_clk", 0, 0, new String[0]);
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajjy.a(2131640980), 0).a();
      if (!this.jdField_a_of_type_Boolean) {
        break label105;
      }
    }
    label105:
    for (int i = 201;; i = 200)
    {
      WSDownloadParams localWSDownloadParams = a(i);
      rxu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localWSDownloadParams, false);
      return;
      i = 2;
      break;
    }
    label112:
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      e();
      wye.a("weishi_share_prof", "clk_ws", 1, 0, new String[0]);
      return;
    }
    d();
    wye.a("weishi_share_prof", "clk_ws", 2, 0, new String[0]);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.i("MineWSPanel", 2, "mMineWeiShiIcon is null");
      return;
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848945);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844851);
  }
  
  public void c()
  {
    ThreadManager.excute(new MineWSPanel.4(this), 32, null, true);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzm
 * JD-Core Version:    0.7.0.1
 */