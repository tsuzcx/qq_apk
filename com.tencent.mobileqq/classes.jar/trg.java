import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import java.util.List;
import org.json.JSONObject;

public class trg
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private GiftServiceBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean;
  private String jdField_a_of_type_JavaLangString;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private trk jdField_a_of_type_Trk;
  private trl jdField_a_of_type_Trl;
  private trm jdField_a_of_type_Trm;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 3;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private GiftServiceBean jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean;
  private String jdField_b_of_type_JavaLangString = "";
  private List<GiftServiceBean> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private GiftServiceBean jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean;
  private String jdField_c_of_type_JavaLangString = "";
  private List<GiftServiceBean> jdField_c_of_type_JavaUtilList;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  private List<GiftServiceBean> jdField_d_of_type_JavaUtilList;
  private TextView e;
  
  public trg(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755339);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    requestWindowFeature(1);
    if (!VersionUtils.isHoneycomb()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
    for (;;)
    {
      setContentView(2131560200);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380080));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379678));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380060));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380044));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363767));
      this.e = ((TextView)findViewById(2131380141));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369171));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370453));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370459));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      uad.a(this.jdField_a_of_type_AndroidWidgetButton, agej.a(6.0F, paramContext.getResources()), Color.parseColor("#EBEDF5"));
      uad.a(this.jdField_a_of_type_AndroidWidgetTextView, agej.a(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      uad.a(this.jdField_b_of_type_AndroidWidgetTextView, agej.a(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      uad.a(this.jdField_c_of_type_AndroidWidgetTextView, agej.a(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      uad.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, agej.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
      return;
      getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165692)));
    }
  }
  
  private String a()
  {
    if (this.jdField_b_of_type_Int == 4) {}
    do
    {
      return "1";
      if (this.jdField_b_of_type_Int == 3) {
        return "2";
      }
    } while (this.jdField_b_of_type_Int != 5);
    return "0";
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Trm = new trm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
      String str2 = "";
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t)) {
          str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t;
        }
      }
      this.jdField_a_of_type_Trm.a(this.jdField_a_of_type_JavaUtilList, new trh(this), str1);
      this.jdField_a_of_type_Trm.show();
    }
  }
  
  private void b()
  {
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Trm = new trm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
      String str2 = "";
      String str1 = str2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t)) {
          str1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t;
        }
      }
      this.jdField_a_of_type_Trm.a(this.jdField_c_of_type_JavaUtilList, new tri(this), str1);
      this.jdField_a_of_type_Trm.show();
    }
  }
  
  private void c()
  {
    if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Trm = new trm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
      String str2 = "";
      String str1 = str2;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t)) {
          str1 = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t;
        }
      }
      this.jdField_a_of_type_Trm.a(this.jdField_d_of_type_JavaUtilList, new trj(this), str1);
      this.jdField_a_of_type_Trm.show();
    }
  }
  
  private void d()
  {
    ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.4(this));
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null) && (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null))
    {
      uad.a(this.jdField_a_of_type_AndroidWidgetButton, agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Color.parseColor("#00CAFC"));
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      return;
    }
    uad.a(this.jdField_a_of_type_AndroidWidgetButton, agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Color.parseColor("#EBEDF5"));
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.jdField_a_of_type_Int = paramConfiguration.orientation;
    if (this.jdField_a_of_type_Trm != null) {
      this.jdField_a_of_type_Trm.dismiss();
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
  }
  
  public void a(List<GiftServiceBean> paramList1, List<GiftServiceBean> paramList2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_b_of_type_JavaLangString = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      this.jdField_d_of_type_JavaLangString = paramString3;
      this.e.setText(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      this.jdField_c_of_type_JavaLangString = paramString4;
    }
    if ((!TextUtils.isEmpty(paramString5)) && ("0".equals(paramString5))) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean = new GiftServiceBean();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t = anzj.a(2131704164);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.v = "0";
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  public void a(trk paramtrk)
  {
    this.jdField_a_of_type_Trk = paramtrk;
  }
  
  public void a(trl paramtrl)
  {
    this.jdField_a_of_type_Trl = paramtrl;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      continue;
      b();
      continue;
      c();
      continue;
      d();
      continue;
      tkt.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3, a());
      dismiss();
      continue;
      dismiss();
      if (this.jdField_a_of_type_Trl != null) {
        this.jdField_a_of_type_Trl.a();
      }
    }
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trg
 * JD-Core Version:    0.7.0.1
 */