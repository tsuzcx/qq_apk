import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

final class kwc
  implements ViewFactory.FoundClickableViewListener
{
  kwc(int paramInt, Container paramContainer, lie paramlie, VafContext paramVafContext, aqdf paramaqdf, ndi paramndi, BaseArticleInfo paramBaseArticleInfo, ProteusItemView paramProteusItemView) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    lpi locallpi = (lpi)kvx.access$100().get(Integer.valueOf(this.aMg));
    if ((locallpi != null) && (locallpi.a(this.aMg, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_b_of_type_Lie, paramViewBase))) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
          } while ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null));
          i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
          if (QLog.isColorLevel()) {
            QLog.d("ProteusSupportUtil", 2, "configListener viewID : " + paramViewBase.getViewId() + ", cmd : " + i + ",, event : " + paramViewBase.getClickEvnet());
          }
          switch (i)
          {
          case 1035: 
          case 1167: 
          case 1168: 
          default: 
            paramViewBase.setOnClickListener(new kwj(this, i, paramViewBase));
            return;
          case 1001: 
            paramViewBase.setOnClickListener(new kwd(this, paramViewBase));
            return;
          }
        } while (!AdvertisementInfo.isAdvertisementInfo(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
        paramViewBase.setOnClickListener(new kwk(this));
        return;
        paramViewBase.setOnClickListener(new lqg((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new lrf((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_c_of_type_Ndi));
        return;
        paramViewBase.setOnClickListener(new lrg((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext));
        return;
        paramViewBase.setOnClickListener(new lqa((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext));
        return;
        paramViewBase.setOnClickListener(new lpz((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new lqz((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
        paramViewBase.setOnClickListener(new kwl(this));
        return;
        paramViewBase.setOnClickListener(new lra((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
        return;
      } while ((!kxm.i((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!kxm.j((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)));
      paramViewBase.getNativeView().setOnClickListener(new kwm(this));
      return;
      paramViewBase.setOnClickListener(new lpy((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_c_of_type_Ndi));
      return;
      paramViewBase.setOnClickListener(new lqf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new lqr((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.aMg));
      return;
      paramViewBase.setOnClickListener(new lqx((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new lqw((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new lqj((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_c_of_type_Ndi));
      return;
      paramViewBase.setOnClickListener(new lpx((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new lqq((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new lqu((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_c_of_type_Ndi));
      return;
      paramViewBase.setOnClickListener(new lqp((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_c_of_type_Ndi));
      return;
      paramViewBase.setOnClickListener(new lqo((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.aMg));
      return;
      paramViewBase.setOnClickListener(new lqh((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new lqc((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.aMg));
      return;
      paramViewBase.setOnClickListener(new lpv(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new kwn(this));
      return;
      paramViewBase.setOnClickListener(new lqe((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.aMg));
      return;
      paramViewBase.setOnClickListener(new lqy((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.aMg, paramViewBase.getEventAttachedData()));
      return;
      paramViewBase.setOnClickListener(new lqk((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
      return;
      paramViewBase.setOnClickListener(new lqi(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      return;
      paramViewBase.setOnClickListener(new kwo(this));
      return;
      paramViewBase.setOnClickListener(new kwp(this, paramViewBase));
      return;
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))
      {
        ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), 5);
        return;
      }
      paramViewBase.setOnClickListener(null);
      return;
      ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), 5);
      return;
      ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), 8);
      return;
      ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), kmr.cW(i));
      return;
      paramViewBase.setOnClickListener(new lqn((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), i, this.jdField_b_of_type_Lie.nh(), this.jdField_b_of_type_Lie.getPosition()));
      return;
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))
      {
        ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), 6);
        return;
      }
      paramViewBase.setOnClickListener(null);
      return;
    } while (!ods.ac((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
    paramViewBase.setOnClickListener(new kwq(this));
    return;
    paramViewBase.setOnClickListener(new lqd((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    paramViewBase.setOnClickListener(new kwr(this));
    return;
    paramViewBase.setOnClickListener(new kwe(this));
    return;
    paramViewBase.setOnClickListener(new lqb((ArticleInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    paramViewBase.setOnClickListener(new kwf(this));
    return;
    paramViewBase.setOnClickListener(new kwg(this));
    return;
    paramViewBase.setOnClickListener(new lpw(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext()));
    return;
    ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), 4);
    return;
    ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), 1);
    return;
    ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), 3);
    return;
    ods.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramViewBase, (Activity)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), (AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_b_of_type_Lie.b(), this.jdField_b_of_type_Lie.nh(), 1000);
    return;
    paramViewBase.setOnClickListener(new kwh(this));
    return;
    paramViewBase.setOnClickListener(new kwi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwc
 * JD-Core Version:    0.7.0.1
 */