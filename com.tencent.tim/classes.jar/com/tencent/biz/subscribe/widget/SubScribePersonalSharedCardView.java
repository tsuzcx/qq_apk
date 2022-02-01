package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import acfp;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import ryz;
import rze;
import san;

public class SubScribePersonalSharedCardView
  extends AbsSubscribeShareCardView
{
  private RelativeLayout fZ;
  private SquareImageView k;
  private TextView mName;
  private ImageView og;
  private TextView wG;
  private TextView zT;
  private TextView zU;
  
  public SubScribePersonalSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubScribePersonalSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubScribePersonalSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(san paramsan, Bitmap paramBitmap, AbsSubscribeShareCardView.a parama)
  {
    super.a(paramsan, paramBitmap, parama);
    CertifiedAccountMeta.StUser localStUser;
    if ((paramsan != null) && (paramsan.a() != null) && (paramsan.a().poster != null))
    {
      localStUser = paramsan.a().poster;
      if (!TextUtils.isEmpty(localStUser.iconInfo.iconUrl.get())) {
        break label251;
      }
    }
    label251:
    for (paramsan = localStUser.icon.get();; paramsan = localStUser.iconInfo.iconUrl.get())
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(paramsan);
      localArrayList2.add(this.k);
      a(localArrayList1, localArrayList2, parama);
      this.mName.setText(localStUser.nick.get());
      parama = localStUser.desc.get();
      if ((!TextUtils.isEmpty(parama)) && (!parama.equals(acfp.m(2131720626))))
      {
        paramsan = parama;
        if (!TextUtils.isEmpty(parama.trim())) {}
      }
      else
      {
        paramsan = acfp.m(2131720625);
      }
      this.wG.setText(paramsan);
      paramsan = ryz.a();
      if (paramsan != null)
      {
        this.zU.setText(rze.ck(paramsan.fansCount.get()));
        this.zT.setText(rze.ck(paramsan.feedCount.get()));
        measure(bwU, bwW);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
      this.og.setImageBitmap(paramBitmap);
      return;
    }
  }
  
  protected URLImageView b()
  {
    return this.k;
  }
  
  public int getLayoutId()
  {
    return 2131558872;
  }
  
  public void u(View paramView)
  {
    this.pZ = paramView.findViewById(2131378221);
    this.k = ((SquareImageView)paramView.findViewById(2131378216));
    this.mName = ((TextView)paramView.findViewById(2131378223));
    this.wG = ((TextView)paramView.findViewById(2131378217));
    this.zT = ((TextView)paramView.findViewById(2131378224));
    this.zU = ((TextView)paramView.findViewById(2131378219));
    this.fZ = ((RelativeLayout)paramView.findViewById(2131378214));
    this.og = ((ImageView)paramView.findViewById(2131378215));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubScribePersonalSharedCardView
 * JD-Core Version:    0.7.0.1
 */