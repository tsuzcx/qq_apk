package com.tencent.mobileqq.mini.out.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class POIAdapter
  extends BaseAdapter
{
  protected int blueColor;
  public boolean hasMore = true;
  protected LayoutInflater mInflater;
  public int nextBegin;
  protected List<LBSShare.POI> poiList = new ArrayList();
  public int selectPos = -1;
  protected int textBlack;
  protected int textGray;
  
  public POIAdapter(Context paramContext)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    this.blueColor = Color.rgb(0, 121, 255);
    ThemeUtil.getCurrentThemeInfo().getString("themeId");
    this.textGray = paramContext.getResources().getColor(2131167379);
    this.textBlack = paramContext.getResources().getColor(2131167304);
  }
  
  public void addPoiList(List<LBSShare.POI> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.hasMore = paramBoolean;
      this.nextBegin += 1;
      this.poiList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    if (this.poiList == null) {
      return 0;
    }
    return this.poiList.size();
  }
  
  public LBSShare.POI getItem(int paramInt)
  {
    if (this.poiList == null) {}
    int i;
    do
    {
      return null;
      i = this.poiList.size();
    } while ((i <= 0) || (paramInt <= -1) || (paramInt >= i));
    return (LBSShare.POI)this.poiList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new PoiItemViewHolder();
      paramView = this.mInflater.inflate(2131562168, null);
      ((PoiItemViewHolder)localObject).nameTextView = ((TextView)paramView.findViewById(2131372209));
      ((PoiItemViewHolder)localObject).addrTextView = ((TextView)paramView.findViewById(2131362250));
      ((PoiItemViewHolder)localObject).chooseView = paramView.findViewById(2131377941);
      ((PoiItemViewHolder)localObject).chooseView.setVisibility(4);
      ((PoiItemViewHolder)localObject).detailView = paramView;
      paramView.setTag(localObject);
    }
    LBSShare.POI localPOI;
    for (;;)
    {
      localPOI = getItem(paramInt);
      if (localPOI != null) {
        break;
      }
      localObject = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (PoiItemViewHolder)paramView.getTag();
    }
    ((PoiItemViewHolder)localObject).poi = localPOI;
    ((PoiItemViewHolder)localObject).nameTextView.setText(localPOI.name.get());
    ((PoiItemViewHolder)localObject).addrTextView.setText(localPOI.addr.get());
    if (paramInt == this.selectPos)
    {
      ((PoiItemViewHolder)localObject).nameTextView.setTextColor(this.blueColor);
      ((PoiItemViewHolder)localObject).addrTextView.setTextColor(this.blueColor);
      ((PoiItemViewHolder)localObject).chooseView.setVisibility(0);
    }
    for (;;)
    {
      localObject = paramView;
      break;
      ((PoiItemViewHolder)localObject).nameTextView.setTextColor(this.textBlack);
      ((PoiItemViewHolder)localObject).addrTextView.setTextColor(this.textGray);
      ((PoiItemViewHolder)localObject).chooseView.setVisibility(4);
    }
  }
  
  public void reset()
  {
    this.nextBegin = 0;
    this.selectPos = -1;
    this.hasMore = true;
    this.poiList.clear();
    notifyDataSetChanged();
  }
  
  public void select(int paramInt)
  {
    if (paramInt >= this.poiList.size()) {}
    while (paramInt == this.selectPos) {
      return;
    }
    this.selectPos = paramInt;
    notifyDataSetChanged();
  }
  
  public static class PoiItemViewHolder
  {
    public TextView addrTextView;
    public View chooseView;
    public View detailView;
    public TextView nameTextView;
    public LBSShare.POI poi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.POIAdapter
 * JD-Core Version:    0.7.0.1
 */