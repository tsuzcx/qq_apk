package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqnm;
import com.tencent.biz.subscribe.account_folder.passive_bubble.PassiveBubbleView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView;
import java.util.List;
import sae.a;
import sae.b;
import sam;

public class TopPanelView
  extends RelativeLayout
  implements sae.b
{
  private PassiveBubbleView jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView;
  private sae.a jdField_a_of_type_Sae$a;
  private RecommendBannerView b;
  private TextView zH;
  
  public TopPanelView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public TopPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public TopPanelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  public void b(CertifiedAccountMeta.StEntry paramStEntry, List<sam> paramList, boolean paramBoolean)
  {
    if (((paramList == null) || (paramList.size() == 0)) && (paramStEntry == null)) {
      bxG();
    }
    do
    {
      return;
      if (this.b != null) {
        this.b.a(paramStEntry, paramList, paramBoolean);
      }
      aqnm.setViewVisibility(this.b, 0);
      aqnm.setViewVisibility(this.zH, 0);
    } while (((paramList != null) && (paramList.size() >= 10)) || (!paramBoolean));
    this.b.bxD();
  }
  
  public void bxF()
  {
    aqnm.setViewVisibility(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 8);
  }
  
  public void bxG()
  {
    aqnm.setViewVisibility(this.b, 8);
    aqnm.setViewVisibility(this.zH, 8);
  }
  
  protected void initView(Context paramContext)
  {
    inflate(paramContext, 2131558841, this);
    setBackgroundResource(2130839642);
    this.b = ((RecommendBannerView)findViewById(2131376890));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView = ((PassiveBubbleView)findViewById(2131372883));
    this.zH = ((TextView)findViewById(2131378968));
  }
  
  public void setPresenter(sae.a parama)
  {
    this.jdField_a_of_type_Sae$a = parama;
    if (this.b != null) {
      this.b.setPresenter(parama);
    }
  }
  
  public void yj(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView.yh(paramInt);
      aqnm.setViewVisibility(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView
 * JD-Core Version:    0.7.0.1
 */