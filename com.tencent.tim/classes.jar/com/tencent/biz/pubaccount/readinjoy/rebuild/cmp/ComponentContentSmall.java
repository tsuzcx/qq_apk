package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.o;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.q;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.util.Pair;
import java.net.URL;
import java.util.ArrayList;
import kwz;
import kxm;
import lie;
import lpl;
import lwk;
import lwm.a;
import mas;
import mde;
import muj;

public class ComponentContentSmall
  extends RelativeLayout
  implements lwk
{
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  mas jdField_a_of_type_Mas;
  private Drawable cD;
  KandianUrlImageView v;
  
  public ComponentContentSmall(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.jdField_a_of_type_Mas = new mas();
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    lie locallie;
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof lie))
    {
      locallie = (lie)paramObject;
      this.jdField_a_of_type_Mas.setModel(locallie);
      aNf();
      localArticleInfo = locallie.a();
      if (localArticleInfo != null) {
        break label41;
      }
    }
    label41:
    do
    {
      return;
      URL localURL2 = localArticleInfo.mSinglePicture;
      URL localURL1;
      if (locallie.getCellType() == 94) {
        localURL1 = kxm.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q.coverUrl);
      }
      for (;;)
      {
        kwz.a(this.v, localURL1, getContext());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView == null) {
          break;
        }
        if ((locallie.getCellType() != 10) && (locallie.getCellType() != 16) && (locallie.getCellType() != 83)) {
          break label269;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718332);
        if (this.cD == null)
        {
          this.cD = getContext().getResources().getDrawable(2130843561);
          this.cD.setBounds(new Rect(0, 0, this.cD.getIntrinsicWidth(), this.cD.getIntrinsicHeight()));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(this.cD, null, null, null);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
        if (locallie.getCellType() != 74)
        {
          localURL1 = localURL2;
          if (locallie.getCellType() != 75) {}
        }
        else
        {
          Pair localPair = lpl.a(localArticleInfo);
          localURL1 = localURL2;
          if (localPair != null) {
            localURL1 = kxm.b((String)localPair.second);
          }
        }
      }
      if ((locallie.getCellType() != 74) && (locallie.getCellType() != 75)) {
        break;
      }
      paramObject = lpl.a(((lie)paramObject).a());
      if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
        return;
      }
    } while ((paramObject == null) || (((Boolean)paramObject.first).booleanValue()));
    label269:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    return;
    if (locallie.getCellType() == 132)
    {
      if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ != null) && (!localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ.isEmpty()))
      {
        paramObject = (SocializeFeedsInfo.o)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ.get(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(muj.av(paramObject.duration * 1000L));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public KandianUrlImageView a()
  {
    return this.v;
  }
  
  public void a(lwm.a parama)
  {
    this.jdField_a_of_type_Mas.b(parama);
  }
  
  public void aHq() {}
  
  public void aNf()
  {
    mde.a(getContext(), this.v, false);
  }
  
  public void cG(View paramView)
  {
    this.v = ((KandianUrlImageView)paramView.findViewById(2131368896));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131365461));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560305, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall
 * JD-Core Version:    0.7.0.1
 */