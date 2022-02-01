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
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import java.util.List;
import org.json.JSONObject;

public class kns
  extends ReportDialog
  implements View.OnClickListener
{
  private GiftServiceBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean;
  private kns.a jdField_a_of_type_Kns$a;
  private kns.b jdField_a_of_type_Kns$b;
  private knw jdField_a_of_type_Knw;
  private int aKk = 2;
  private String aae = "";
  private AdvertisementInfo advertisementInfo;
  private boolean agE = true;
  private boolean agF;
  private JSONObject ah;
  private String appid = "";
  private GiftServiceBean jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean;
  private AdData jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  private Button bM;
  private GiftServiceBean c;
  private LinearLayout du;
  private LinearLayout dv;
  private long ew;
  private List<GiftServiceBean> gl;
  private List<GiftServiceBean> gm;
  private List<GiftServiceBean> gn;
  private ImageView ij;
  private Context mContext;
  private String mPkgName;
  private TextView om;
  private TextView on;
  private TextView oo;
  private TextView op;
  private TextView oq;
  private int orientation;
  private List<GiftServiceBean> roleList;
  private String title = "";
  
  public kns(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755579);
    this.aKk = paramInt;
    this.mContext = paramContext;
    requestWindowFeature(1);
    if (!VersionUtils.isHoneycomb()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
    for (;;)
    {
      setContentView(2131560394);
      this.om = ((TextView)findViewById(2131380926));
      this.on = ((TextView)findViewById(2131380553));
      this.oo = ((TextView)findViewById(2131380905));
      this.op = ((TextView)findViewById(2131380891));
      this.bM = ((Button)findViewById(2131363825));
      this.oq = ((TextView)findViewById(2131380976));
      this.ij = ((ImageView)findViewById(2131369705));
      this.om.setOnClickListener(this);
      this.on.setOnClickListener(this);
      this.oo.setOnClickListener(this);
      this.bM.setOnClickListener(this);
      this.ij.setOnClickListener(this);
      this.op.setOnClickListener(this);
      this.du = ((LinearLayout)findViewById(2131370962));
      this.dv = ((LinearLayout)findViewById(2131370968));
      this.dv.setOnClickListener(this);
      this.du.setOnClickListener(this);
      odc.a(this.bM, wja.dp2px(6.0F, paramContext.getResources()), Color.parseColor("#EBEDF5"));
      odc.a(this.om, wja.dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      odc.a(this.on, wja.dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      odc.a(this.oo, wja.dp2px(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      odc.a(this.du, wja.dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
      return;
      getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165865)));
    }
  }
  
  private void aDU()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null) && (this.c != null))
    {
      odc.a(this.bM, wja.dp2px(6.0F, this.mContext.getResources()), Color.parseColor("#00CAFC"));
      this.bM.setClickable(true);
      return;
    }
    odc.a(this.bM, wja.dp2px(6.0F, this.mContext.getResources()), Color.parseColor("#EBEDF5"));
    this.bM.setClickable(false);
  }
  
  private String io()
  {
    if (this.aKk == 1) {}
    do
    {
      return "1";
      if (this.aKk == 2) {
        return "2";
      }
    } while (this.aKk != 3);
    return "0";
  }
  
  public void R(JSONObject paramJSONObject)
  {
    this.ah = paramJSONObject;
  }
  
  public void a(AdData paramAdData)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
  }
  
  public void a(List<GiftServiceBean> paramList1, List<GiftServiceBean> paramList2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.gl = paramList1;
    this.gm = paramList2;
    this.mPkgName = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      this.aae = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      this.title = paramString3;
      this.oq.setText(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      this.appid = paramString4;
    }
    if ((!TextUtils.isEmpty(paramString5)) && ("0".equals(paramString5))) {
      this.agE = false;
    }
    if (!this.agE)
    {
      this.oo.setVisibility(8);
      this.c = new GiftServiceBean();
      this.c.v = "0";
    }
  }
  
  public void a(kns.a parama)
  {
    this.jdField_a_of_type_Kns$a = parama;
  }
  
  public void a(kns.b paramb)
  {
    this.jdField_a_of_type_Kns$b = paramb;
  }
  
  public void ek(long paramLong)
  {
    this.ew = paramLong;
  }
  
  public void i(AdvertisementInfo paramAdvertisementInfo)
  {
    this.advertisementInfo = paramAdvertisementInfo;
  }
  
  public void mu(boolean paramBoolean)
  {
    this.agF = paramBoolean;
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
      if ((this.gl != null) && (this.gl.size() > 0))
      {
        this.jdField_a_of_type_Knw = new knw(this.mContext, this.du.getHeight());
        String str2 = "";
        String str1 = str2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t)) {
            str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t;
          }
        }
        this.jdField_a_of_type_Knw.a(this.gl, new knt(this), str1);
        this.jdField_a_of_type_Knw.show();
        continue;
        if ((this.gn != null) && (this.gn.size() > 0))
        {
          this.jdField_a_of_type_Knw = new knw(this.mContext, this.du.getHeight());
          str2 = "";
          str1 = str2;
          if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t)) {
              str1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t;
            }
          }
          this.jdField_a_of_type_Knw.a(this.gn, new knu(this), str1);
          this.jdField_a_of_type_Knw.show();
          continue;
          if ((this.roleList != null) && (this.roleList.size() > 0))
          {
            this.jdField_a_of_type_Knw = new knw(this.mContext, this.du.getHeight());
            str2 = "";
            str1 = str2;
            if (this.c != null)
            {
              str1 = str2;
              if (!TextUtils.isEmpty(this.c.t)) {
                str1 = this.c.t;
              }
            }
            this.jdField_a_of_type_Knw.a(this.roleList, new knv(this), str1);
            this.jdField_a_of_type_Knw.show();
            continue;
            ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.4(this));
            continue;
            kkn.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, 3, io());
            dismiss();
            continue;
            dismiss();
            if (this.jdField_a_of_type_Kns$b != null) {
              this.jdField_a_of_type_Kns$b.aDJ();
            }
          }
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.orientation = paramConfiguration.orientation;
    if (this.jdField_a_of_type_Knw != null) {
      this.jdField_a_of_type_Knw.dismiss();
    }
  }
  
  public void show()
  {
    super.show();
  }
  
  public static abstract interface a
  {
    public abstract void el(long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract void aDJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kns
 * JD-Core Version:    0.7.0.1
 */