import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class kkg
  extends kkk
{
  private NativeAdDownloadView b;
  private TextView desc;
  private ImageView icon;
  private ImageView ih;
  private TextView of;
  private TextView title;
  
  public kkg(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void aDW()
  {
    AdvertisementInfo localAdvertisementInfo = kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    if (localAdvertisementInfo.mAdvertisementSoftInfo.sourceId == 0) {
      ods.a(this.context, localAdvertisementInfo, null, 2, true);
    }
    while ((TextUtils.isEmpty(localAdvertisementInfo.mAdvertisementSoftInfo.aax)) && (!TextUtils.isEmpty(localAdvertisementInfo.mAdvertisementSoftInfo.aaw)) && (ods.a(localAdvertisementInfo.mAdvertisementSoftInfo.aaw, (Activity)this.context))) {
      return;
    }
    kmx.g(this.context, localAdvertisementInfo.mAdvertisementSoftInfo.jmpUrl, localAdvertisementInfo.mAdvertisementSoftInfo.aax, "");
    doReport(0);
  }
  
  private void aDX()
  {
    if ((this.context == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.aC == null)) {
      return;
    }
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.aC.optString("adImg", "");
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.aC.optString("goodsName", "");
    String str3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.aC.optString("buttonTxt", "");
    kjz.a(this.context, this.icon, str1, 8, 30, -1);
    this.title.setText(str2);
    this.desc.setText(str3);
    aDT();
    this.b.setStyle(2);
  }
  
  private void doReport(int paramInt)
  {
    int i = kjz.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState, false);
    kjz.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, jzk.aEJ, paramInt, i, 7);
  }
  
  public void Nx()
  {
    b(new View[] { this.icon, this.title, this.desc, this.of, this.b, this.ih });
    this.rootView.setOnClickListener(new kkh(this));
  }
  
  public void a(AdData paramAdData)
  {
    super.a(paramAdData);
    aDX();
  }
  
  public void a(kjt paramkjt)
  {
    super.a(paramkjt);
    if ((this.jdField_a_of_type_Kjt != null) && (this.jdField_a_of_type_Kjt.a != null))
    {
      this.jdField_a_of_type_Kjt.a(new kki(this));
      this.jdField_a_of_type_Kjt.a.a(new kkj(this));
      aDT();
    }
  }
  
  public void aDK()
  {
    this.of.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  public void aDL()
  {
    this.of.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void aDR()
  {
    if ((this.rootView == null) || (this.context == null)) {
      return;
    }
    this.icon = ((ImageView)this.rootView.findViewById(2131368698));
    this.title = ((TextView)this.rootView.findViewById(2131379769));
    this.desc = ((TextView)this.rootView.findViewById(2131365721));
    this.of = ((TextView)this.rootView.findViewById(2131366071));
    this.b = ((NativeAdDownloadView)this.rootView.findViewById(2131366091));
    this.ih = ((ImageView)this.rootView.findViewById(2131366979));
  }
  
  public void aDT()
  {
    super.aDT();
    if (this.jdField_a_of_type_Kjt == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Kjt.in();
    } while ((TextUtils.isEmpty(str)) || (this.of == null));
    this.of.setText(str);
  }
  
  public void aaV()
  {
    if (this.afX) {
      return;
    }
    kjz.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, jzk.aEK, 0, 0, 7);
    super.aaV();
  }
  
  public void close() {}
  
  public int nn()
  {
    return 2131563101;
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
      aDW();
      continue;
      this.jdField_a_of_type_Kjt.pf(1);
      continue;
      this.jdField_a_of_type_Kjt.pg(1);
      continue;
      this.afW = true;
      if (this.jdField_a_of_type_Kkb != null) {
        this.jdField_a_of_type_Kkb.Hj();
      }
      doReport(3);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.b.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkg
 * JD-Core Version:    0.7.0.1
 */