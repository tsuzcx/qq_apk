package com.tencent.qqmail.bottle.fragment.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottleManager.ViewHolderTag;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.utilities.ui.AnimationListBaseAdapter;
import com.tencent.qqmail.utilities.ui.InsertionListView.OnRowAdditionAnimationListener;

public class BottleBeachAdapter
  extends AnimationListBaseAdapter<BottleBeach>
{
  static final int KILOMETER = 1000;
  static final int MAX_KM = 5;
  static final int[] bottle_beach_item_top_colors_resource = { 2130838969, 2130838970, 2130838971 };
  private BottleBeach[] mAnimationCompleteBottles = null;
  final BottleManager mBottleManager;
  private BottleBeach[] mBottles = null;
  final Context mContext;
  final LayoutInflater mInflater;
  private final OnDetailClickBridge mOnDetailClickListener = new OnDetailClickBridge();
  private InsertionListView.OnRowAdditionAnimationListener mOnRowAdditionAnimationListener;
  
  public BottleBeachAdapter(Context paramContext, BottleManager paramBottleManager)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    this.mBottleManager = paramBottleManager;
    this.mContext = paramContext;
  }
  
  public BottleBeach[] getBeachBottles()
  {
    return this.mBottles;
  }
  
  public int getCount()
  {
    if (this.mBottles == null) {
      return 0;
    }
    return this.mBottles.length;
  }
  
  public BottleBeach getItem(int paramInt)
  {
    int i = getCount();
    if ((paramInt < 0) || (paramInt >= i)) {
      return null;
    }
    return this.mBottles[paramInt];
  }
  
  public int getItemId(BottleBeach paramBottleBeach)
  {
    return paramBottleBeach.getBottleid().hashCode();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    if (paramInt == getCount() - 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = getView((BottleBeach)localObject, paramView, paramViewGroup, bool);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
  }
  
  View getView(BottleBeach paramBottleBeach, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      paramViewGroup = this.mInflater.inflate(2131558773, null);
      paramView = new ViewHolder();
      paramView.name = ((TextView)paramViewGroup.findViewById(2131372190));
      paramView.content = ((TextView)paramViewGroup.findViewById(2131363593));
      paramView.topcolor = paramViewGroup.findViewById(2131363596);
      paramView.geo = ((TextView)paramViewGroup.findViewById(2131363605));
      paramViewGroup.setTag(paramView);
    }
    int i = this.mContext.getResources().getDimensionPixelOffset(2131296675);
    if (paramBoolean)
    {
      paramViewGroup.setPadding(i, i, i, i);
      paramView = (ViewHolder)paramViewGroup.getTag();
      paramView.bottleid = paramBottleBeach.getBottleid();
      paramView.msgid = null;
      paramView.name.setText(BottleManager.formatNickName(paramBottleBeach.getName()));
      if (!paramBottleBeach.isMale()) {
        break label295;
      }
      paramView.name.setCompoundDrawablesWithIntrinsicBounds(null, null, this.mContext.getResources().getDrawable(2130838973), null);
    }
    for (;;)
    {
      this.mOnDetailClickListener.bindViewOnClickListener(paramView.name, paramBottleBeach.getBottler());
      i = this.mContext.getResources().getDimensionPixelSize(2131296673);
      this.mBottleManager.setContentWithEmoji(paramView.content, paramBottleBeach.getContent(), paramBottleBeach.getEmoji(), paramBottleBeach.getBottleid(), null, paramView, i);
      paramView.geo.setText(CommonUI.getFormatDistance(paramBottleBeach.getDistance(), paramBottleBeach.getCity()));
      i = bottle_beach_item_top_colors_resource[(paramBottleBeach.getTagColor() % bottle_beach_item_top_colors_resource.length)];
      paramView.topcolor.setBackgroundResource(i);
      return paramViewGroup;
      paramViewGroup.setPadding(i, i, i, 0);
      break;
      label295:
      paramView.name.setCompoundDrawablesWithIntrinsicBounds(null, null, this.mContext.getResources().getDrawable(2130838972), null);
    }
  }
  
  public void onRowAdditionAnimationEnd()
  {
    super.onRowAdditionAnimationEnd();
    if (this.mAnimationCompleteBottles != null)
    {
      update(this.mAnimationCompleteBottles);
      this.mAnimationCompleteBottles = null;
    }
    if (this.mOnRowAdditionAnimationListener != null) {
      this.mOnRowAdditionAnimationListener.onRowAdditionAnimationEnd();
    }
  }
  
  public void onRowAdditionAnimationStart()
  {
    super.onRowAdditionAnimationStart();
    if (this.mOnRowAdditionAnimationListener != null) {
      this.mOnRowAdditionAnimationListener.onRowAdditionAnimationStart();
    }
  }
  
  public void setOnDetailClickListener(OnDetailClickBridge.OnDetailClickListener paramOnDetailClickListener)
  {
    this.mOnDetailClickListener.setOnDetailClickListener(paramOnDetailClickListener);
  }
  
  public void setOnRowAdditionAnimationListener(InsertionListView.OnRowAdditionAnimationListener paramOnRowAdditionAnimationListener)
  {
    this.mOnRowAdditionAnimationListener = paramOnRowAdditionAnimationListener;
  }
  
  public void update(BottleBeach[] paramArrayOfBottleBeach)
  {
    if (isAnimating()) {
      if (this.mAnimationCompleteBottles != paramArrayOfBottleBeach) {
        this.mAnimationCompleteBottles = paramArrayOfBottleBeach;
      }
    }
    while (this.mBottles == paramArrayOfBottleBeach) {
      return;
    }
    this.mBottles = paramArrayOfBottleBeach;
    notifyDataSetChanged();
  }
  
  public void updateWithAnimation(BottleBeach[] paramArrayOfBottleBeach)
  {
    int j;
    if (paramArrayOfBottleBeach != null)
    {
      j = paramArrayOfBottleBeach.length;
      if (this.mBottles != null) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = this.mBottles.length)
    {
      notifyPrepareAnimation(j - i);
      update(paramArrayOfBottleBeach);
      return;
    }
  }
  
  static class ViewHolder
    extends BottleManager.ViewHolderTag
  {
    TextView content;
    TextView geo;
    TextView name;
    View topcolor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.adapter.BottleBeachAdapter
 * JD-Core Version:    0.7.0.1
 */