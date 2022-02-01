package com.tencent.mobileqq.activity.selectmember;

import aayq;
import aayq.b;
import aayq.c;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;

public class TroopListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, AbsListView.e
{
  TextView GT = null;
  private aayq b;
  int bMG;
  Context context;
  SlideDetectListView j;
  ArrayList<Entity> sx;
  
  public TroopListInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    this.bMG = paramContext.getResources().getDimensionPixelSize(2131299688);
  }
  
  private void BR(int paramInt)
  {
    this.GT.setVisibility(0);
    if ((paramInt == 0) && (this.j.getChildAt(0) != null) && (this.j.getChildAt(0).getBottom() == this.bMG)) {
      this.GT.setVisibility(4);
    }
    do
    {
      return;
      localObject1 = this.b.getItem(paramInt);
    } while (!(localObject1 instanceof aayq.b));
    Object localObject2 = (aayq.b)localObject1;
    Object localObject1 = null;
    switch (((aayq.b)localObject2).itemType)
    {
    default: 
      label132:
      if (paramInt + 1 < this.b.getCount())
      {
        localObject2 = (aayq.b)this.b.getItem(paramInt + 1);
        if (((localObject2 == null) || (((aayq.b)localObject2).itemType != 6)) && (((aayq.b)localObject2).itemType != 4) && (((aayq.b)localObject2).itemType != 2) && (((aayq.b)localObject2).itemType != 8)) {
          break label441;
        }
        localObject2 = this.j.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.GT.getLayoutParams();
          if (paramInt >= this.bMG) {
            break label433;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.bMG);
          label244:
          this.GT.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.GT.requestLayout();
        }
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.GT.setVisibility(0);
      this.GT.setText((CharSequence)localObject1);
      return;
      localObject1 = this.context.getString(2131698428, new Object[] { String.valueOf(this.b.cmH) });
      break label132;
      localObject1 = this.context.getString(2131698448, new Object[] { String.valueOf(this.b.cmG) });
      break label132;
      localObject1 = this.context.getString(2131698361, new Object[] { String.valueOf(this.b.cmE) });
      break label132;
      localObject1 = this.context.getString(2131698400, new Object[] { String.valueOf(this.b.cmF) });
      break label132;
      localObject1 = this.context.getString(2131698543, new Object[] { String.valueOf(this.b.cmI) });
      break label132;
      label433:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break label244;
      label441:
      localObject2 = (RelativeLayout.LayoutParams)this.GT.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.GT.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.GT.requestLayout();
      }
    }
  }
  
  private void cAq()
  {
    this.sx = ((TroopManager)this.e.getManager(52)).cE();
    if (this.sx == null) {
      this.sx = new ArrayList();
    }
  }
  
  public ContactSearchFragment a()
  {
    return null;
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, "", "");
  }
  
  public void notifyDataSetChanged()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (aayq.c)paramView.getTag();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (((aayq.c)localObject1).g != null))
    {
      localObject2 = ((aayq.c)localObject1).g;
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", ((TroopInfo)localObject2).troopuin);
      localBundle.putString("group_name", ((TroopInfo)localObject2).getTroopName());
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(6, localBundle);
      switch (((aayq.c)localObject1).itemType)
      {
      case 2: 
      case 4: 
      case 6: 
      case 8: 
      default: 
        i = 0;
        anot.a(this.e, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((TroopInfo)localObject2).troopuin + "", String.valueOf(i), "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      if ((localObject1 != null) && (((aayq.c)localObject1).c != null))
      {
        localObject1 = ((aayq.c)localObject1).c;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("group_uin", ((DiscussionInfo)localObject1).uin);
        ((Bundle)localObject2).putString("group_name", ((DiscussionInfo)localObject1).discussionName);
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(7, (Bundle)localObject2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131560613);
    this.j = ((SlideDetectListView)findViewById(2131382384));
    this.GT = ((TextView)findViewById(2131380396));
    this.j.setSelector(2131167595);
    this.b = new aayq(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.e, this.j, 4, false, this);
    this.j.setAdapter(this.b);
    cAq();
    this.b.c(this.e, this.sx);
    this.j.setOnScrollGroupFloatingListener(this);
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      this.b.destroy();
    }
    super.onDestroy();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b != null) {
      BR(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public String qN()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame
 * JD-Core Version:    0.7.0.1
 */