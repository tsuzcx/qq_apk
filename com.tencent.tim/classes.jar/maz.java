import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.a;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.c;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.j;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class maz
  implements AdapterView.c
{
  public maz(ComponentContentGridImage paramComponentContentGridImage) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((ComponentContentGridImage.a(this.a) == 62) || (ComponentContentGridImage.a(this.a) == 63) || (ComponentContentGridImage.a(this.a) == 64) || (ComponentContentGridImage.a(this.a) == 65))
    {
      if (ComponentContentGridImage.a(this.a) != null) {
        ComponentContentGridImage.a(this.a).rr(paramInt);
      }
      return;
    }
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 1) && (((lis)this.a.aO).a().mSocialFeedInfo != null) && (((lis)this.a.aO).a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (((lis)this.a.aO).a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM) && (((lis)this.a.aO).a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j != null)) {
      try
      {
        kxm.a(this.a.getContext(), ((lis)this.a.aO).a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.a.jumpUrl, null);
        return;
      }
      catch (Exception paramAdapterView)
      {
        QLog.e("ComponentContentGridImage", 1, paramAdapterView.getLocalizedMessage());
        return;
      }
    }
    ComponentContentGridImage.a(this.a, paramInt, ComponentContentGridImage.a(this.a).getImageList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     maz
 * JD-Core Version:    0.7.0.1
 */