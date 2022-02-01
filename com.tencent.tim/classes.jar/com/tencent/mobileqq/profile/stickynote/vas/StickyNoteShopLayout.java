package com.tencent.mobileqq.profile.stickynote.vas;

import QC.GetSuixintieSigFontReq;
import QC.GetSuixintieSigFontRsp;
import alfj;
import alfk;
import alfl;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import ankt;
import aqve;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class StickyNoteShopLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String CACHE_PATH = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "sticky_list_cache";
  private alfl a;
  private String bWj = "";
  private boolean cwB;
  public int dsM = 2;
  private int dsN;
  private int mAppId;
  private RecyclerView mRecyclerView;
  private RecyclerView.OnScrollListener mScrollListener = new alfk(this);
  
  public StickyNoteShopLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public StickyNoteShopLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public StickyNoteShopLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int m = paramArrayOfInt.length;
    int j = 0;
    if (j < m)
    {
      int k = paramArrayOfInt[j];
      if (k <= i) {
        break label39;
      }
      i = k;
    }
    label39:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private void init()
  {
    View.inflate(getContext(), 2131561622, this);
    this.mRecyclerView = ((RecyclerView)findViewById(2131378779));
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
    this.mRecyclerView.setLayoutManager(localStaggeredGridLayoutManager);
    this.a = new alfl(getContext(), null);
    this.a.b(this);
    this.mRecyclerView.setAdapter(this.a);
    this.mRecyclerView.setOnScrollListener(this.mScrollListener);
    this.mRecyclerView.setBackgroundColor(-1);
    findViewById(2131380676).setOnClickListener(this);
    findViewById(2131368901).setOnClickListener(this);
    initData();
  }
  
  public void NI(boolean paramBoolean)
  {
    QLog.d("StickyNoteShopLayout", 2, " appId:" + this.mAppId + " mIsLoadLast:" + this.cwB + " isLoadMore:" + paramBoolean + " mStrAttachInfo:" + this.bWj);
    if (this.cwB) {
      break label68;
    }
    label68:
    while ((this.dsM == 2) && (this.a.Hv() >= 30) && (paramBoolean)) {
      return;
    }
    aqve localaqve = new aqve("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetSuixintieSigFontReq");
    GetSuixintieSigFontReq localGetSuixintieSigFontReq = new GetSuixintieSigFontReq(aqve.a(), this.mAppId, this.dsN, "", this.bWj);
    if (this.dsM == 1) {}
    for (String str = "getSuixintieSigFont";; str = "getExtendFriendSigFont")
    {
      localaqve.a(str, localGetSuixintieSigFontReq, new GetSuixintieSigFontRsp(), new alfj(this, paramBoolean), false);
      if (paramBoolean) {
        break;
      }
      ThreadManagerV2.executeOnFileThread(new StickyNoteShopLayout.2(this));
      return;
    }
  }
  
  public alfl a()
  {
    return this.a;
  }
  
  public void hide()
  {
    setVisibility(8);
    iG(0);
  }
  
  public int iG(int paramInt)
  {
    if (paramInt > ankt.cIE / 4) {}
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.height = paramInt;
      setMinimumHeight(localLayoutParams.height);
      setLayoutParams(localLayoutParams);
      return paramInt;
      paramInt = ankt.cIE / 3;
    }
  }
  
  public void initData()
  {
    this.mRecyclerView.setAdapter(this.a);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.dFz();
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
      NI(false);
      continue;
      NI(false);
    }
  }
  
  public void setAppId(int paramInt)
  {
    this.mAppId = paramInt;
    if (this.a != null) {
      this.a.setAppId(paramInt);
    }
  }
  
  public void setItemId(int paramInt)
  {
    this.a.setItemId(paramInt);
  }
  
  public void setShopCallback(a parama)
  {
    this.a.a(parama);
  }
  
  public void setUseId(int paramInt)
  {
    this.dsM = paramInt;
  }
  
  public void setUsingItem(int paramInt)
  {
    this.dsN = paramInt;
  }
  
  public void show(int paramInt)
  {
    setVisibility(paramInt);
    if (this.a.getItemCount() == 0) {
      NI(false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void hU(int paramInt1, int paramInt2);
    
    public abstract void setFont(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout
 * JD-Core Version:    0.7.0.1
 */