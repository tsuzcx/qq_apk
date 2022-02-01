import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lpb
  implements View.OnClickListener
{
  lpb(lot paramlot, lie paramlie, Container paramContainer, ndi paramndi) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.b.a();
    ((ArticleInfo)localObject).click_area = 8;
    kxm.b(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), (ArticleInfo)localObject, (int)((ArticleInfo)localObject).mChannelID);
    QLog.d("PgcShortContentProteusItem", 1, "click single image blank area");
    localObject = this.jdField_c_of_type_Ndi.a();
    if (localObject != null) {
      ((ndi.d)localObject).a(paramView, this.b.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpb
 * JD-Core Version:    0.7.0.1
 */