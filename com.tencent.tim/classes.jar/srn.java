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
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetMineWSPersonalRequest;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.MobileQQ;

public class srn
  implements IEventReceiver
{
  private TextView AS;
  private TextView AT;
  private GetMineWSPersonalRequest jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private boolean aMs;
  private soy b;
  private LinearLayout fy;
  private RecyclerView mRecyclerView;
  private View mRootView;
  private String mUin;
  private ImageView oG;
  private String personId;
  private View qA;
  
  public srn(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.b = new soy(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void V(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.i("MineWSPanel", 2, "response is null");
      return;
    }
    ThreadManager.excute(new MineWSPanel.3(this, paramArrayOfByte), 32, null, true);
  }
  
  @NonNull
  private WSDownloadParams a(int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 3;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = paramInt;
    stReportItem localstReportItem = ond.getInitialReportItem();
    localstReportItem.pagetype = 1;
    localstReportItem.optype = 115;
    localWSDownloadParams.mStReportItem = localstReportItem;
    return localWSDownloadParams;
  }
  
  private void bAd()
  {
    String str = "weishi://profile?person_id=";
    if (!TextUtils.isEmpty(this.personId)) {
      str = "weishi://profile?person_id=" + this.personId;
    }
    if (this.aMs) {}
    for (str = str + "&logsour=2020020031";; str = str + "&logsour=2020020029")
    {
      opb.p(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "biz_src_jc_gxl", str);
      return;
    }
  }
  
  private void bAe()
  {
    opb.p(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "biz_src_jc_gxl", "weishi://camera?logsour=2020020030");
  }
  
  private void uX(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)))
    {
      QLog.i("MineWSPanel", 2, "setWeiShiPanelState isShow:" + paramBoolean);
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).xk(paramBoolean);
    }
  }
  
  public TextView F()
  {
    return this.AS;
  }
  
  public void J(boolean paramBoolean, String paramString)
  {
    this.aMs = paramBoolean;
    this.mUin = paramString;
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
      this.personId = paramstGetPersonalPageRsp.personid.get();
      int i;
      if (j > 0) {
        if (!paramBoolean)
        {
          if (this.aMs)
          {
            i = 1;
            sqn.a("weishi_share_prof", "entry_exp", i, 0, new String[0]);
          }
        }
        else
        {
          uX(true);
          if (this.AT != null) {
            this.AT.setText(j + acfp.m(2131708344));
          }
        }
      }
      for (;;)
      {
        if (this.mRecyclerView == null) {
          break label171;
        }
        paramstGetPersonalPageRsp = paramstGetPersonalPageRsp.feeds.get();
        if ((paramstGetPersonalPageRsp != null) && (paramstGetPersonalPageRsp.size() != 0)) {
          break label173;
        }
        this.mRecyclerView.setVisibility(8);
        return;
        i = 2;
        break;
        uX(false);
        if (this.AT != null) {
          this.AT.setText("");
        }
      }
    }
    label173:
    this.mRecyclerView.setVisibility(0);
    QLog.i("MineWSPanel", 2, "setData(),mIsCurrentUser=" + this.aMs);
    this.b.setData(paramstGetPersonalPageRsp, this.aMs);
  }
  
  public void bAc()
  {
    QLog.i("MineWSPanel", 2, "requestWeiShiFeedListDataFromServer mUin=" + this.mUin);
    if (!jqi.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApplication().getApplicationContext())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest = new GetMineWSPersonalRequest(this.mUin + "", 1);
    VSNetworkHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest, new srn.b(this));
  }
  
  public void bAf()
  {
    if (this.qA == null)
    {
      QLog.i("MineWSPanel", 2, "mMineWeiShiIcon is null");
      return;
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.qA.setBackgroundResource(2130851281);
      return;
    }
    this.qA.setBackgroundResource(2130846681);
  }
  
  public void bAg()
  {
    ThreadManager.excute(new MineWSPanel.4(this), 32, null, true);
  }
  
  public void initUI(View paramView)
  {
    this.mRootView = paramView;
    this.mRootView.setVisibility(8);
    this.fy = ((LinearLayout)paramView.findViewById(2131371532));
    this.qA = paramView.findViewById(2131368698);
    this.AS = ((TextView)paramView.findViewById(2131371533));
    this.AT = ((TextView)paramView.findViewById(2131371534));
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(2131382339));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localLinearLayoutManager.setOrientation(0);
    this.mRecyclerView.setLayoutManager(localLinearLayoutManager);
    localLinearLayoutManager.setRecycleChildrenOnDetach(true);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setAdapter(this.b);
    this.oG = ((ImageView)paramView.findViewById(2131371933));
    this.fy.setOnClickListener(new sro(this));
    this.b.a(new srp(this));
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public ImageView p()
  {
    return this.oG;
  }
  
  public void uY(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    if (this.aMs)
    {
      i = 1;
      sqn.a("weishi_share_prof", "entry_clk", i, 0, new String[0]);
      if (rpw.isWeishiInstalled(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break label112;
      }
      sqn.a("weishi_share_prof", "dl_clk", 0, 0, new String[0]);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, acfp.m(2131708343), 0).show();
      if (!this.aMs) {
        break label105;
      }
    }
    label105:
    for (int i = 201;; i = 200)
    {
      WSDownloadParams localWSDownloadParams = a(i);
      oir.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localWSDownloadParams, false);
      return;
      i = 2;
      break;
    }
    label112:
    if ((this.aMs) && (paramBoolean))
    {
      bAe();
      sqn.a("weishi_share_prof", "clk_ws", 1, 0, new String[0]);
      return;
    }
    bAd();
    sqn.a("weishi_share_prof", "clk_ws", 2, 0, new String[0]);
  }
  
  public static abstract interface a
  {
    public abstract void a(soy.b paramb);
  }
  
  static final class b
    implements rxc.a<WEISHI.stGetPersonalPageRsp>
  {
    private final WeakReference<srn> an;
    
    public b(srn paramsrn)
    {
      this.an = new WeakReference(paramsrn);
    }
    
    public void a(boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
    {
      paramString = (srn)this.an.get();
      if (paramString == null) {}
      do
      {
        return;
        paramString.a(paramstGetPersonalPageRsp, false);
      } while (paramstGetPersonalPageRsp == null);
      srn.a(paramString, paramstGetPersonalPageRsp.toByteArray());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srn
 * JD-Core Version:    0.7.0.1
 */