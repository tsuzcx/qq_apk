import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class klj
  implements ViewBase.OnClickListener
{
  klj(kli paramkli, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int k = 1;
    int m;
    int i;
    int j;
    if ((klh.a.a(this.jdField_a_of_type_Kli.jdField_a_of_type_Klh$a) instanceof ProteusItemData))
    {
      m = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      switch (m)
      {
      default: 
        i = 0;
        j = -1;
      }
    }
    for (;;)
    {
      if (kmx.h((AdData)this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
        if (m != 1087) {
          break label452;
        }
      }
      label452:
      for (i = k;; i = 0)
      {
        j = kjz.i(((AdData)this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).downloadState, false);
        paramViewBase = kne.a((AdData)this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        kjz.a((Activity)this.jdField_a_of_type_Kli.val$context, paramViewBase);
        kjz.a(this.jdField_a_of_type_Kli.val$context, (AdData)this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, jzk.aEJ, i, j, 2);
        do
        {
          return;
          if (this.jdField_a_of_type_Kli.val$context == null) {
            break label465;
          }
          nno.a(this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.jdField_a_of_type_Kli.val$context);
          j = 8;
          i = 0;
          break;
          i = 1;
          j = 5;
          break;
          i = 1;
          j = 4;
          break;
          if (kmx.g((AdData)this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
          {
            kmx.a(this.jdField_a_of_type_Kli.val$context, (AdData)this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, 8);
            return;
          }
          j = 8;
          i = 1;
          break;
          i = 1;
          j = 1;
          break;
          i = 1;
          j = 3;
          break;
          i = 1;
          j = 1000;
          break;
          paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.findViewBaseByName("id_view_AdDownloadView");
          if (!(paramViewBase instanceof kox)) {
            break label457;
          }
          i = kjz.a(paramViewBase, this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
          ((kox)paramViewBase).doDownload();
          kjz.a(this.jdField_a_of_type_Kli.val$context, (AdData)this.jdField_a_of_type_Kli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, jzk.aEJ, 1, i, 2);
          return;
        } while ((i == 0) || (m == -1));
        klh.a.a(this.jdField_a_of_type_Kli.jdField_a_of_type_Klh$a, this.jdField_a_of_type_Kli.b);
        nnb.a(this.jdField_a_of_type_Kli.val$context, klh.a.a(this.jdField_a_of_type_Kli.jdField_a_of_type_Klh$a), true, j);
        return;
      }
      label457:
      j = 8;
      i = 1;
      continue;
      label465:
      j = 8;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     klj
 * JD-Core Version:    0.7.0.1
 */