import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class nrl
  extends nrc
  implements View.OnClickListener
{
  private ndi a;
  private final String anz = "0X80095D4";
  private boolean aum = true;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private nrl.a jdField_b_of_type_Nrl$a = new nrm(this);
  private final int bbA = 7;
  private final int bbB = 8;
  private final int bbu = 1;
  private final int bbv = 2;
  private final int bbw = 3;
  private final int bbx = 4;
  private final int bby = 5;
  private final int bbz = 6;
  private nng c;
  private LinearLayout en;
  private LinearLayout eo;
  private LinearLayout ep;
  private ImageView kT;
  private ImageView kU;
  private ImageView kV;
  private ImageView kW;
  private int mPosition;
  private View mW;
  
  public nrl(Activity paramActivity, ndi paramndi)
  {
    super(paramActivity);
    this.a = paramndi;
    this.c = new nng();
  }
  
  private boolean CD()
  {
    return aqiw.isNetworkAvailable(this.mActivity);
  }
  
  private boolean ab(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.publishUin > 0L) && (kxm.getLongAccountUin() == paramArticleInfo.publishUin);
  }
  
  private void baq()
  {
    if (eh("reportFeeds")) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyFeedbackPopupWindow.3(this));
    }
  }
  
  private void bar()
  {
    ausj localausj = ausj.b(this.mActivity);
    localausj.setMainTitle(2131718408);
    localausj.addButton(2131718407, 0);
    localausj.addCancelButton(2131721058);
    if (!localausj.isShowing()) {
      localausj.show();
    }
    localausj.a(new nrq(this, localausj));
  }
  
  private void bas()
  {
    if (!CD()) {}
    while (!eh("shieldFeeds")) {
      return;
    }
    nnc.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_Nrl$a);
  }
  
  private int dE(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 9;
    }
    return 10;
  }
  
  private boolean eh(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mArticleInfo is null." });
      return false;
    }
    return true;
  }
  
  private boolean ei(String paramString)
  {
    if ((eh(paramString)) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)) {
      return true;
    }
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mSocialFeedInfo is null" });
    return false;
  }
  
  private void reportData(String paramString, int paramInt)
  {
    Object localObject;
    if (ei("reportData")) {
      localObject = kxm.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    try
    {
      localObject = ((kxm.b)localObject).o(paramInt).d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId).build();
      kbp.a(null, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.publishUin), paramString, paramString, 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), (String)localObject, false);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("ReadInJoyBasePopupWindow", 1, "reportData json exception.");
      paramString.printStackTrace();
    }
  }
  
  private void tW(int paramInt)
  {
    if (!CD()) {
      return;
    }
    ((lcd)kxm.getAppRuntime().getManager(163)).b().a().a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt, this.jdField_b_of_type_Nrl$a);
  }
  
  public final void a(View paramView1, ArticleInfo paramArticleInfo, int paramInt, View paramView2)
  {
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "show, articleInfo = ", paramArticleInfo });
    if (!this.mHasInit) {
      initUI();
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.mW = paramView2;
    this.mPosition = paramInt;
    u(paramArticleInfo);
    dj(paramView1);
    this.aum = true;
  }
  
  public void aHq()
  {
    this.en.setOnClickListener(this);
    this.eo.setOnClickListener(this);
    this.ep.setOnClickListener(this);
    this.kV.setOnClickListener(this);
    this.kT.setOnClickListener(this);
    this.kU.setOnClickListener(this);
    this.kW.setOnClickListener(this);
    setOnDismissListener(new nrp(this));
  }
  
  public View b(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560261, null);
    this.en = ((LinearLayout)paramLayoutInflater.findViewById(2131378245));
    this.eo = ((LinearLayout)paramLayoutInflater.findViewById(2131377159));
    this.ep = ((LinearLayout)paramLayoutInflater.findViewById(2131365697));
    this.kT = ((ImageView)paramLayoutInflater.findViewById(2131378011));
    this.kU = ((ImageView)paramLayoutInflater.findViewById(2131375726));
    this.kV = ((ImageView)paramLayoutInflater.findViewById(2131382189));
    this.kW = ((ImageView)paramLayoutInflater.findViewById(2131371883));
    return paramLayoutInflater;
  }
  
  public void onClick(View paramView)
  {
    this.aum = false;
    dismiss();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bas();
      reportData("0X80095D4", 5);
      continue;
      baq();
      reportData("0X80095D4", 7);
      continue;
      bar();
      reportData("0X80095D4", 6);
      continue;
      tW(0);
      reportData("0X80095D4", 1);
      continue;
      tW(1);
      reportData("0X80095D4", 2);
      continue;
      tW(2);
      reportData("0X80095D4", 3);
      continue;
      tW(3);
      reportData("0X80095D4", 4);
    }
  }
  
  public void u(ArticleInfo paramArticleInfo)
  {
    if (ab(paramArticleInfo))
    {
      this.en.setVisibility(8);
      this.eo.setVisibility(8);
      this.ep.setVisibility(0);
      this.ep.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130843702));
      return;
    }
    this.en.setVisibility(0);
    this.eo.setVisibility(0);
    this.ep.setVisibility(8);
    this.en.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130843701));
    this.eo.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130843702));
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2);
    
    public abstract void w(boolean paramBoolean, String paramString);
    
    public abstract void x(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrl
 * JD-Core Version:    0.7.0.1
 */