package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import rxn.b;
import ryx;
import rze;
import sbf;
import sen;
import seo;
import seq;
import ser;
import ses;
import sqn;

public class SubscribePersonalBottomOpusFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private sbf d;
  protected ExtraTypeInfo mExtraTypeInfo;
  
  private void a(SubscribeBaseBottomPersonalFragment.a parama)
  {
    if (this.b == null) {}
    do
    {
      return;
      if ((parama == null) || ((parama.lb != null) && (parama.lb.size() > 0)))
      {
        this.b.setVisibility(8);
        return;
      }
    } while (parama.a == null);
    if (parama.a.poster.type.get() == 0) {
      if (rze.h(parama.a.poster.attr.get(), 6)) {
        this.b.r(new seq(this, parama));
      }
    }
    for (;;)
    {
      sqn.c(parama.a.poster.id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
      return;
      this.b.setHintImageFilePath(rze.no() + "/certified_account_feeds_empty.png");
      if (rze.h(parama.a.poster.attr.get(), 1))
      {
        this.b.x(acfp.m(2131720640), 13, getResources().getColor(2131167482));
      }
      else
      {
        this.b.x(acfp.m(2131713861), 13, getResources().getColor(2131167482));
        continue;
        if (rze.h(parama.a.poster.attr.get(), 1))
        {
          this.b.d(new ser(this, parama), new ses(this, parama));
        }
        else
        {
          this.b.setHintImageFilePath(rze.no() + "/certified_account_feeds_empty.png");
          this.b.x(acfp.m(2131713861), 13, getResources().getColor(2131167482));
        }
      }
    }
  }
  
  private void initData()
  {
    if (this.a != null)
    {
      if (this.a.lb != null)
      {
        b(this.a.lb, this.a.extInfo, this.a.isFinish);
        if (this.d != null) {
          this.d.setShareData("share_key_subscribe_user", new rxn.b(this.a.e));
        }
      }
      a(this.a);
    }
  }
  
  ExtraTypeInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (getActivity() != null)
    {
      localObject1 = localObject2;
      if (getActivity().getIntent() != null) {
        localObject1 = (ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ExtraTypeInfo();
    }
    this.mExtraTypeInfo = new ExtraTypeInfo(7002, ((ExtraTypeInfo)localObject2).sourceType);
    return this.mExtraTypeInfo;
  }
  
  public void a(String paramString, SubscribeBaseBottomPersonalFragment.a parama)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.a = parama;
      initData();
    }
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    if (this.d != null) {
      this.d.b(paramList, paramStCommonExt, paramBoolean);
    }
  }
  
  protected void initView()
  {
    this.d = new sbf(null);
    this.d.uv(false);
    this.d.uu(true);
    this.d.a(new sen(this));
    this.d.setOnLoadDataDelegate(new seo(this));
    this.c.a(this.d);
    this.c.start();
    initData();
  }
  
  public void yr(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment
 * JD-Core Version:    0.7.0.1
 */