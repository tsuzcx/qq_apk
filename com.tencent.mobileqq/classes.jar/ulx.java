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
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.4;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import java.util.List;
import org.json.JSONObject;

public class ulx
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
  private umb jdField_a_of_type_Umb;
  private umc jdField_a_of_type_Umc;
  private umd jdField_a_of_type_Umd;
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
  
  public ulx(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755340);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    requestWindowFeature(1);
    if (!VersionUtils.isHoneycomb()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
    for (;;)
    {
      setContentView(2131560253);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380154));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379769));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380137));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380121));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363868));
      this.e = ((TextView)findViewById(2131380210));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369356));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370604));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370610));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      uup.a(this.jdField_a_of_type_AndroidWidgetButton, AIOUtils.dp2px(6.0F, paramContext.getResources()), Color.parseColor("#EBEDF5"));
      uup.a(this.jdField_a_of_type_AndroidWidgetTextView, AIOUtils.dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      uup.a(this.jdField_b_of_type_AndroidWidgetTextView, AIOUtils.dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      uup.a(this.jdField_c_of_type_AndroidWidgetTextView, AIOUtils.dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      uup.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, AIOUtils.dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
      return;
      getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165709)));
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
      this.jdField_a_of_type_Umd = new umd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
      String str2 = "";
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t)) {
          str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t;
        }
      }
      this.jdField_a_of_type_Umd.a(this.jdField_a_of_type_JavaUtilList, new uly(this), str1);
      this.jdField_a_of_type_Umd.show();
    }
  }
  
  private void b()
  {
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Umd = new umd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
      String str2 = "";
      String str1 = str2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t)) {
          str1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t;
        }
      }
      this.jdField_a_of_type_Umd.a(this.jdField_c_of_type_JavaUtilList, new ulz(this), str1);
      this.jdField_a_of_type_Umd.show();
    }
  }
  
  private void c()
  {
    if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Umd = new umd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
      String str2 = "";
      String str1 = str2;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t)) {
          str1 = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t;
        }
      }
      this.jdField_a_of_type_Umd.a(this.jdField_d_of_type_JavaUtilList, new uma(this), str1);
      this.jdField_a_of_type_Umd.show();
    }
  }
  
  private void d()
  {
    ThreadManager.executeOnNetWorkThread(new GiftPackageDialog.4(this));
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null) && (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean != null))
    {
      uup.a(this.jdField_a_of_type_AndroidWidgetButton, AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Color.parseColor("#00CAFC"));
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      return;
    }
    uup.a(this.jdField_a_of_type_AndroidWidgetButton, AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Color.parseColor("#EBEDF5"));
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.jdField_a_of_type_Int = paramConfiguration.orientation;
    if (this.jdField_a_of_type_Umd != null) {
      this.jdField_a_of_type_Umd.dismiss();
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
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.t = anvx.a(2131704744);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdAdDataGiftServiceBean.v = "0";
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  public void a(umb paramumb)
  {
    this.jdField_a_of_type_Umb = paramumb;
  }
  
  public void a(umc paramumc)
  {
    this.jdField_a_of_type_Umc = paramumc;
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
      ueb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3, a());
      dismiss();
      continue;
      dismiss();
      if (this.jdField_a_of_type_Umc != null) {
        this.jdField_a_of_type_Umc.a();
      }
    }
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulx
 * JD-Core Version:    0.7.0.1
 */