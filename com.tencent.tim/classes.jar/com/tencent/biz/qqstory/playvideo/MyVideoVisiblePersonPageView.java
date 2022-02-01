package com.tencent.biz.qqstory.playvideo;

import acff;
import acfp;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiw;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import pma;
import pmd;
import ppf;
import psx;
import ptf;
import qem;
import qfd;
import qfe;
import qff;
import qfg;
import qfh;
import qfi;
import qoj;
import qwo;

public class MyVideoVisiblePersonPageView
  extends RelativeLayout
  implements View.OnClickListener
{
  public int Hy = -1;
  qoj a;
  protected qwo a;
  acff b;
  pmd c = new qfg(this);
  TextView ht;
  QQAppInterface mApp;
  int mBanType = -1;
  public Context mContext;
  public Dialog mDialog;
  public GestureDetector mGestureDetector = new GestureDetector(this.mContext, new qfi(this));
  XListView mListView;
  View mLoadingLayout;
  String mVid;
  View of;
  TextView xf;
  TextView xg;
  
  public MyVideoVisiblePersonPageView(Dialog paramDialog, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Qwo = new qfh(this);
    LayoutInflater.from(paramContext).inflate(2131562039, this, true);
    this.b = ((acff)qem.getQQAppInterface().getManager(51));
    this.mDialog = paramDialog;
    this.mContext = paramContext;
    this.mVid = paramString;
    this.mBanType = paramInt;
    this.mApp = qem.getQQAppInterface();
    this.mApp.addObserver(this.c);
    initView();
    paramDialog = ((ptf)psx.a(2)).b(QQStoryContext.a().getCurrentUid());
    if ((paramDialog != null) && (paramDialog.isVip))
    {
      boc();
      return;
    }
    if (this.mBanType == 1000)
    {
      boc();
      return;
    }
    if (this.mBanType == 0)
    {
      bob();
      return;
    }
    if (this.mBanType == 1)
    {
      boa();
      return;
    }
    bnX();
  }
  
  void bnX()
  {
    if (aqiw.isNetSupport(this.mContext))
    {
      bnY();
      ((pma)this.mApp.getBusinessHandler(98)).qP(this.mVid);
      return;
    }
    bnZ();
  }
  
  void bnY()
  {
    this.mListView.setVisibility(8);
    this.xf.setVisibility(8);
    this.of.setVisibility(8);
    this.mLoadingLayout.setVisibility(0);
    this.ht.setVisibility(0);
  }
  
  public void bnZ()
  {
    this.mListView.setVisibility(8);
    this.ht.setVisibility(8);
    this.of.setVisibility(8);
    this.mLoadingLayout.setVisibility(0);
    this.xf.setVisibility(0);
  }
  
  void boa()
  {
    this.mLoadingLayout.setVisibility(8);
    this.ht.setVisibility(8);
    this.xf.setVisibility(8);
    this.mListView.setVisibility(8);
    this.of.setVisibility(0);
    this.xg.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130847771), null, null);
    this.xg.setText(acfp.m(2131708628));
  }
  
  void bob()
  {
    this.mLoadingLayout.setVisibility(8);
    this.ht.setVisibility(8);
    this.xf.setVisibility(8);
    this.mListView.setVisibility(8);
    this.of.setVisibility(0);
    this.xg.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130847769), null, null);
    this.xg.setText(ppf.getString(2131701923));
  }
  
  void boc()
  {
    this.mLoadingLayout.setVisibility(8);
    this.ht.setVisibility(8);
    this.xf.setVisibility(8);
    this.mListView.setVisibility(8);
    this.of.setVisibility(0);
    this.xg.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130847773), null, null);
    this.xg.setText(acfp.m(2131708632));
  }
  
  public void en(List<QQUserUIItem> paramList)
  {
    this.mLoadingLayout.setVisibility(8);
    this.ht.setVisibility(8);
    this.xf.setVisibility(8);
    this.of.setVisibility(8);
    this.mListView.setVisibility(0);
    if ((this.jdField_a_of_type_Qoj != null) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
        Friends localFriends = this.b.e(String.valueOf(localQQUserUIItem.qq));
        if (localFriends != null)
        {
          localQQUserUIItem.mComparePartInt = localFriends.mComparePartInt;
          localQQUserUIItem.mCompareSpell = localFriends.mCompareSpell;
        }
      }
      Collections.sort(paramList, new qff(this));
      this.jdField_a_of_type_Qoj.setData(paramList);
      this.jdField_a_of_type_Qoj.notifyDataSetChanged();
    }
  }
  
  void initView()
  {
    this.mListView = ((XListView)findViewById(2131370527));
    this.mLoadingLayout = findViewById(2131375096);
    this.ht = ((TextView)findViewById(2131375183));
    this.xf = ((TextView)findViewById(2131377225));
    this.xf.setOnClickListener(this);
    this.xg = ((TextView)findViewById(2131382306));
    this.of = findViewById(2131377524);
    this.jdField_a_of_type_Qoj = new qoj(this.mContext, null);
    this.jdField_a_of_type_Qoj.wr(2131562038);
    this.jdField_a_of_type_Qoj.a(this.jdField_a_of_type_Qwo);
    this.mListView.setAdapter(this.jdField_a_of_type_Qoj);
    this.mListView.setVisibility(0);
    this.mListView.setOnScrollListener(new qfd(this));
    qfe localqfe = new qfe(this);
    this.mListView.setOnTouchListener(localqfe);
    this.mLoadingLayout.setOnTouchListener(localqfe);
    this.of.setOnTouchListener(localqfe);
  }
  
  public String mK()
  {
    String str = acfp.m(2131708629);
    if ((this.mBanType == 1000) || (this.mBanType == 0) || (this.mBanType == 1) || (this.mBanType == 2)) {
      str = acfp.m(2131708631);
    }
    while (this.mBanType != 3) {
      return str;
    }
    return acfp.m(2131708630);
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
      bnX();
    }
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView
 * JD-Core Version:    0.7.0.1
 */