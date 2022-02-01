package com.tencent.biz.subscribe.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import rwv;
import rxn.b;
import sbn;

public class SubscribePersonalBottomDraftsFragment
  extends SubscribeBaseBottomPersonalFragment
{
  private sbn b;
  private ExtraTypeInfo mExtraTypeInfo;
  
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
    this.mExtraTypeInfo = new ExtraTypeInfo(7005, ((ExtraTypeInfo)localObject2).sourceType);
    return this.mExtraTypeInfo;
  }
  
  public void a(String paramString, SubscribeBaseBottomPersonalFragment.a parama)
  {
    if ("share_key_subscribe_opus".equals(paramString))
    {
      this.a = parama;
      if (this.b != null) {
        this.b.setShareData("share_key_subscribe_opus", new rxn.b(this.a));
      }
    }
  }
  
  protected void initView()
  {
    this.b = new sbn(null);
    this.c.a(this.b);
    this.c.start();
    this.b.refreshData();
    if (this.a != null) {
      this.b.setShareData("share_key_subscribe_opus", new rxn.b(this.a));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    rwv.a().a(new SubDraftChangeEvent());
  }
  
  public void yr(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment
 * JD-Core Version:    0.7.0.1
 */