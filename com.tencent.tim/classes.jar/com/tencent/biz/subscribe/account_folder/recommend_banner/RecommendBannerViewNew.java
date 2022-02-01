package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import rwv;
import rwx;
import rze;
import rzv;
import sab;
import sad;
import sae.a;
import sam;
import sqn;

public class RecommendBannerViewNew
  extends LinearLayout
  implements View.OnClickListener, rwx
{
  private sad jdField_a_of_type_Sad;
  private sae.a jdField_a_of_type_Sae$a;
  private boolean avA;
  private ImageView ji;
  private ImageView nR;
  private RecyclerView p;
  private View pB;
  private TextView zF;
  private TextView zG;
  
  public RecommendBannerViewNew(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public RecommendBannerViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  private void yi(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_Sad.getItemCount())
    {
      this.jdField_a_of_type_Sad.remove(paramInt);
      if ((!this.jdField_a_of_type_Sad.Mt()) && (!this.jdField_a_of_type_Sad.Ms()) && (this.jdField_a_of_type_Sae$a != null)) {
        this.jdField_a_of_type_Sae$a.ie();
      }
      bxD();
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<sam> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Sad != null)
    {
      this.jdField_a_of_type_Sad.setIsFinish(paramBoolean);
      this.jdField_a_of_type_Sad.a(paramStEntry, paramList);
      this.p.smoothScrollToPosition(0);
    }
  }
  
  public void bxD()
  {
    if ((this.jdField_a_of_type_Sad.Ms()) && (this.zF.getVisibility() == 0))
    {
      this.nR.setVisibility(8);
      this.zF.setVisibility(8);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(RecommendFeedbackEvent.class);
    return localArrayList;
  }
  
  protected void initView(Context paramContext)
  {
    this.avA = rze.Mp();
    setOrientation(1);
    inflate(paramContext, 2131558865, this);
    this.p = ((RecyclerView)findViewById(2131363284));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.p.setLayoutManager(paramContext);
    this.p.addItemDecoration(new rzv());
    this.jdField_a_of_type_Sad = new sad(this.p);
    this.jdField_a_of_type_Sad.setInNightMode(this.avA);
    this.jdField_a_of_type_Sad.setInNewFolderPage(true);
    this.p.setAdapter(this.jdField_a_of_type_Sad);
    this.jdField_a_of_type_Sad.a(new sab(this));
    this.ji = ((ImageView)findViewById(2131369705));
    this.pB = findViewById(2131365997);
    this.zG = ((TextView)findViewById(2131376935));
    this.nR = ((ImageView)findViewById(2131376891));
    this.zF = ((TextView)findViewById(2131376892));
    this.zF.setOnClickListener(this);
    this.nR.setOnClickListener(this);
    if (this.avA)
    {
      this.nR.setImageDrawable(getResources().getDrawable(2130839196));
      this.ji.setImageDrawable(getResources().getDrawable(2130839141));
      this.pB.setBackgroundColor(-9211021);
      this.zG.setTextColor(-10132123);
      this.zF.setTextColor(-10132123);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if ((this.jdField_a_of_type_Sad != null) && (this.jdField_a_of_type_Sae$a != null))
    {
      if ((this.jdField_a_of_type_Sad.Mr()) || (this.jdField_a_of_type_Sad.Ms())) {
        break label110;
      }
      this.jdField_a_of_type_Sae$a.ie();
    }
    for (;;)
    {
      bxD();
      sqn.b(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_discover", "change_clk", 0, 0, new String[0]);
      break;
      label110:
      this.p.smoothScrollToPosition(0);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof RecommendFeedbackEvent)) || (this.jdField_a_of_type_Sad == null)) {}
    label188:
    for (;;)
    {
      return;
      int i = 0;
      int j;
      if (i < this.jdField_a_of_type_Sad.getDatas().size()) {
        if ((((RecommendFeedbackEvent)paramSimpleBaseEvent).type == 1) && (((RecommendFeedbackEvent)paramSimpleBaseEvent).user != null) && (TextUtils.equals(((sam)this.jdField_a_of_type_Sad.getDatas().get(i)).user.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).user.id.get()))) {
          j = i;
        }
      }
      for (;;)
      {
        if (j == -1) {
          break label188;
        }
        yi(j);
        return;
        if ((((RecommendFeedbackEvent)paramSimpleBaseEvent).type == 2) && (((RecommendFeedbackEvent)paramSimpleBaseEvent).feed != null))
        {
          j = i;
          if (TextUtils.equals(((sam)this.jdField_a_of_type_Sad.getDatas().get(i)).feed.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).feed.id.get())) {}
        }
        else
        {
          i += 1;
          break;
          j = -1;
        }
      }
    }
  }
  
  public void setPresenter(sae.a parama)
  {
    this.jdField_a_of_type_Sae$a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew
 * JD-Core Version:    0.7.0.1
 */