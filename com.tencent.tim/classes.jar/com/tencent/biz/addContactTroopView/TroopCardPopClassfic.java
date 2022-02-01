package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import job;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopItem;

public class TroopCardPopClassfic
  extends BaseTroopCardView
{
  public popclassifc.PopCard a;
  protected RecyclerView.Adapter<a> mAdapter = new job(this);
  public int mItemWidth;
  
  public TroopCardPopClassfic(ContactBaseView.a parama)
  {
    super(parama);
  }
  
  private void nZ(int paramInt)
  {
    popclassifc.PopItem localPopItem = (popclassifc.PopItem)((popclassifc.PopCard)this.a.get()).rpt_pop_items.get(paramInt);
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", localPopItem.str_transfer_url.get());
    this.mContext.startActivity(localIntent);
    anot.a(this.mApp, "dc00899", "Grp_find_new", "", "grptab", "Clk_hotcal", 0, 0, "", String.valueOf(paramInt), "", "");
  }
  
  public void setData(popclassifc.PopCard paramPopCard)
  {
    if (paramPopCard != null)
    {
      this.a = paramPopCard;
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    public ImageView hi;
    public TextView nk;
    
    public a(View paramView)
    {
      super();
      this.nk = ((TextView)paramView.findViewById(2131373494));
      this.hi = ((ImageView)paramView.findViewById(2131373489));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        this.hi.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
        return;
      }
      this.hi.setColorFilter(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic
 * JD-Core Version:    0.7.0.1
 */