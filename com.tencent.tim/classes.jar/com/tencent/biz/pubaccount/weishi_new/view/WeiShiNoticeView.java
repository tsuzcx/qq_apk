package com.tencent.biz.pubaccount.weishi_new.view;

import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import azbx;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.ArrayList;
import okp;
import ong;
import ooz;
import opn;

public class WeiShiNoticeView
  extends LinearLayout
{
  private LinearLayout eB;
  private RoundImageView i;
  private RoundImageView j;
  private RoundImageView k;
  private ImageView lz;
  private Context mContext;
  private TextView mText;
  ArrayList<RoundImageView> mh = new ArrayList();
  private int type;
  
  public WeiShiNoticeView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public WeiShiNoticeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void aI(int paramInt, String paramString)
  {
    RoundImageView localRoundImageView;
    if (this.mh.size() > paramInt)
    {
      localRoundImageView = (RoundImageView)this.mh.get(paramInt);
      if (TextUtils.isEmpty(paramString)) {
        break label78;
      }
      Drawable localDrawable = this.mContext.getResources().getDrawable(2130847230);
      opn.a(localRoundImageView, paramString, localDrawable, localDrawable, "avatar" + paramInt);
    }
    for (;;)
    {
      localRoundImageView.setVisibility(0);
      return;
      label78:
      localRoundImageView.setImageResource(2130847230);
    }
  }
  
  private void initView()
  {
    this.i = ((RoundImageView)findViewById(2131363186));
    this.i.setBorderColor(Color.parseColor("#c1c1c1"));
    this.i.setBorderWidth(1);
    this.j = ((RoundImageView)findViewById(2131363187));
    this.j.setBorderColor(Color.parseColor("#c1c1c1"));
    this.j.setBorderWidth(1);
    this.k = ((RoundImageView)findViewById(2131363188));
    this.k.setBorderColor(Color.parseColor("#c1c1c1"));
    this.k.setBorderWidth(1);
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
    this.mh.add(this.i);
    this.mh.add(this.j);
    this.mh.add(this.k);
    this.eB = ((LinearLayout)findViewById(2131372533));
    this.lz = ((ImageView)findViewById(2131372527));
    ViewGroup.LayoutParams localLayoutParams = this.lz.getLayoutParams();
    int m = azbx.SCREEN_WIDTH * 120 / 750;
    if (m > 0)
    {
      localLayoutParams.height = m;
      this.lz.setLayoutParams(localLayoutParams);
    }
    this.mText = ((TextView)findViewById(2131380705));
  }
  
  private void pV(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Drawable localDrawable = this.mContext.getResources().getDrawable(2130842541);
      opn.a(this.lz, paramString, localDrawable, localDrawable, "banner");
      return;
    }
    this.lz.setImageResource(2130842541);
  }
  
  public void b(stNotificationRsp paramstNotificationRsp, okp paramokp)
  {
    int m = 0;
    if (paramstNotificationRsp == null)
    {
      hide();
      return;
    }
    this.type = paramstNotificationRsp.type;
    setVisibility(0);
    ong.W(6, this.type, paramstNotificationRsp.cid);
    WSPublicAccReport.getInstance().reportMsgEntry("gzh_exposure", this.type, 0, paramstNotificationRsp.cid, paramstNotificationRsp.trace_id);
    if (this.type == 6)
    {
      pV(paramstNotificationRsp.imgurl);
      this.lz.setVisibility(0);
      this.eB.setVisibility(8);
      return;
    }
    this.lz.setVisibility(8);
    this.eB.setVisibility(0);
    if (!TextUtils.isEmpty(paramstNotificationRsp.text))
    {
      this.mText.setTextColor(-16777216);
      this.mText.setText(paramstNotificationRsp.text);
    }
    paramstNotificationRsp = paramstNotificationRsp.persons;
    while (m < paramstNotificationRsp.size())
    {
      paramokp = (stSimpleMetaPerson)paramstNotificationRsp.get(m);
      if ((paramokp != null) && (!TextUtils.isEmpty(paramokp.avatar))) {
        aI(m, paramokp.avatar);
      }
      m += 1;
    }
    ooz.i("813", "mAvatar1 :" + this.i.getVisibility());
    ooz.i("813", "mAvatar2 :" + this.j.getVisibility());
    ooz.i("813", "mAvatar3 :" + this.k.getVisibility());
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void hide()
  {
    setVisibility(8);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView
 * JD-Core Version:    0.7.0.1
 */