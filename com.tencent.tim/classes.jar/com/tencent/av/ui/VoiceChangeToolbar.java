package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import aqnm;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import iiv;
import iwu;
import java.util.ArrayList;
import jcc;
import jcc.a;
import jfp;
import jfp.a;
import jfq;
import jfr;
import wja;

public class VoiceChangeToolbar
  extends BaseToolbar
  implements View.OnClickListener
{
  public static String TAG = "VoiceChangeToolbar";
  private static VoiceChangeToolbar mToolbarInstance;
  jcc mAdapter;
  Button mEarbackBtn = null;
  ArrayList<QavListItemBase.c> mItemInfo;
  HorizontalListView mListView;
  BaseToolbar.a mUIInfo = null;
  jcc.a mVoiceClickCallback = new jfr(this);
  
  public VoiceChangeToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<QavListItemBase.c> getList()
  {
    jfp.a[] arrayOfa = jfp.a().a();
    if (arrayOfa == null) {}
    ArrayList localArrayList;
    for (int i = 1;; i = arrayOfa.length + 1)
    {
      localArrayList = new ArrayList(i);
      Object localObject = new QavListItemBase.c();
      ((QavListItemBase.c)localObject).id = "-1";
      localArrayList.add(localObject);
      if (arrayOfa == null) {
        break;
      }
      i = 0;
      while (i < arrayOfa.length)
      {
        localObject = arrayOfa[i];
        QavListItemBase.c localc = new QavListItemBase.c();
        localc.type = 2;
        localc.id = (((jfp.a)localObject).type + "");
        localc.name = ((jfp.a)localObject).name;
        localc.iconurl = ((jfp.a)localObject).RP;
        localc.vipLevel = ((jfp.a)localObject).vipLevel;
        localc.desc = ((jfp.a)localObject).name;
        localc.usable = true;
        localc.ax = localObject;
        localArrayList.add(localc);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void setEffectConfigItem(long paramLong, String paramString)
  {
    if ((mToolbarInstance == null) || (mToolbarInstance.isOutOfArray(paramString))) {
      return;
    }
    mToolbarInstance.setSelectedItem(paramString);
    QavListItemBase.c localc = new QavListItemBase.c();
    localc.id = paramString;
    mToolbarInstance.mVoiceClickCallback.a(paramLong, localc);
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130843159;
    if (this.mApp.b().b().Rm) {
      i = 2130843160;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected BaseToolbar.a getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.a();
      this.mUIInfo.avw = 5;
      this.mUIInfo.avy = 2131559983;
      this.mUIInfo.avx = 2130843141;
      this.mUIInfo.QZ = this.mApp.getApp().getString(2131698144);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return "";
  }
  
  public boolean isOutOfArray(String paramString)
  {
    if ((this.mListView == null) || (this.mAdapter == null) || (this.mItemInfo == null)) {}
    for (;;)
    {
      return true;
      int i = 1;
      while (i < this.mItemInfo.size())
      {
        if (((QavListItemBase.c)this.mItemInfo.get(i)).id.equals(paramString)) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    iiv localiiv = this.mApp.b().b();
    boolean bool;
    if (!this.mApp.b().b().Rm)
    {
      bool = true;
      label61:
      localiiv.Rm = bool;
      if (this.mApp.b().b().YN != 0) {
        this.mApp.b().enableLoopback(this.mApp.b().b().Rm);
      }
      updateEarbackBtn();
      if (this.mApp.b().b().Rm) {
        break label162;
      }
      iwu.b(this.mApp, 1017);
      jfq.reportClickEvent("0X8007EF4", "");
    }
    for (;;)
    {
      EffectSettingUi.a(this.mApp, -1010L);
      break;
      bool = false;
      break label61;
      label162:
      jfq.reportClickEvent("0X8007EF3", "");
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    mToolbarInstance = this;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368682));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mItemInfo = getList();
    this.mAdapter = new jcc(this.mApp, paramAVActivity, this.mItemInfo, this.mListView);
    this.mAdapter.jU(true);
    this.mAdapter.jV(true);
    this.mAdapter.a(this.mVoiceClickCallback);
    this.mListView.setAdapter(this.mAdapter);
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364433));
    this.mEarbackBtn.setTextSize(aqnm.pxTosp(wja.dp2px(12.0F, paramAVActivity.getResources())));
    this.mEarbackBtn.setOnClickListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(jcc.a(paramAVActivity.getResources(), this.mAdapter.ad(), 0.1666667F), 0, 0, 0);
    this.mEarbackBtn.setLayoutParams(localLayoutParams);
    updateEarbackBtn();
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    mToolbarInstance = null;
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    if ((this.mItemInfo == null) || (this.mItemInfo.size() == 1))
    {
      this.mItemInfo = getList();
      if ((this.mItemInfo != null) && (this.mItemInfo.size() > 1) && (this.mAdapter != null))
      {
        this.mAdapter.bE(this.mItemInfo);
        this.mAdapter.notifyDataSetChanged();
      }
    }
    setSelectedItem(this.mApp.b().b().YN + "");
    updateEarbackBtn();
  }
  
  public void setSelectedItem(String paramString)
  {
    if ((this.mListView == null) || (this.mAdapter == null) || (this.mItemInfo == null)) {
      return;
    }
    int i = 1;
    if (i < this.mItemInfo.size()) {
      if (!((QavListItemBase.c)this.mItemInfo.get(i)).id.equals(paramString)) {}
    }
    for (;;)
    {
      setSelectedListViewItemAndShow(this.mListView, this.mAdapter, i);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void update(Object[] paramArrayOfObject)
  {
    if ((this.mListView == null) || (this.mAdapter == null)) {
      return;
    }
    this.mItemInfo = getList();
    this.mAdapter.bE(this.mItemInfo);
    setSelectedItem(this.mApp.b().b().YN + "");
    this.mAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar
 * JD-Core Version:    0.7.0.1
 */