package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.StCommonExt;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;
import rxn;

public abstract class SubscribeBaseBottomPersonalFragment
  extends ReportV4Fragment
{
  public a a;
  protected StatusView b;
  protected BlockContainer c;
  protected View mRootView;
  
  abstract ExtraTypeInfo a();
  
  public abstract void a(String paramString, a parama);
  
  protected abstract void initView();
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mRootView = paramLayoutInflater.inflate(2131558848, paramViewGroup, false);
    this.c = ((BlockContainer)this.mRootView.findViewById(2131373014));
    this.b = ((StatusView)this.mRootView.findViewById(2131378742));
    this.c.a().setNestedScrollingEnabled(true);
    this.c.getBlockMerger().yf(2);
    this.c.setEnableRefresh(false);
    this.c.setEnableLoadMore(true);
    this.c.setExtraTypeInfo(a());
    this.c.setParentFragment(this);
    this.c.setLayoutManagerType(3, 2);
    initView();
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public abstract void yr(int paramInt);
  
  public static class a
  {
    public CertifiedAccountMeta.StFeed a;
    public CertifiedAccountRead.StGetMainPageRsp a;
    public String aDM;
    public boolean aLa;
    public CertifiedAccountMeta.StUser e;
    public COMM.StCommonExt extInfo;
    public boolean isFinish;
    public String key;
    public List<CertifiedAccountMeta.StFeed> lb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
 * JD-Core Version:    0.7.0.1
 */