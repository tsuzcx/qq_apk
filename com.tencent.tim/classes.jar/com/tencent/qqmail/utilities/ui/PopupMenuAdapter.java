package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class PopupMenuAdapter
  extends BaseAdapter
{
  private Context context;
  private List<QMPopupWindow.PopupMenuItem> list;
  
  public PopupMenuAdapter(Context paramContext, List<QMPopupWindow.PopupMenuItem> paramList)
  {
    this.list = paramList;
    this.context = paramContext;
    pickupInvisiableItem();
  }
  
  private void pickupInvisiableItem()
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      if (!((QMPopupWindow.PopupMenuItem)localIterator.next()).isVisiable()) {
        localIterator.remove();
      }
    }
  }
  
  public int getCount()
  {
    return this.list.size();
  }
  
  public QMPopupWindow.PopupMenuItem getItem(int paramInt)
  {
    return (QMPopupWindow.PopupMenuItem)this.list.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return ((QMPopupWindow.PopupMenuItem)this.list.get(paramInt)).getButtonId();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QMPopupWindow.PopupMenuItem localPopupMenuItem = getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131559771, null);
      paramView = new ViewHolder(null);
      paramView.imageView = ((ImageView)localView.findViewById(2131373492));
      paramView.textView = ((TextView)localView.findViewById(2131373495));
      localView.setTag(paramView);
      localView.setId(localPopupMenuItem.getButtonId());
      paramView.textView.setText(localPopupMenuItem.getTitle());
      if (paramInt != getCount() - 1) {
        break label146;
      }
      QMUIHelper.setBackgroundResource(localView, 2130850551);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
      break;
      label146:
      QMUIHelper.setBackgroundResource(localView, 2130850548);
    }
  }
  
  public void notifyDataSetChanged()
  {
    pickupInvisiableItem();
    super.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    pickupInvisiableItem();
    super.notifyDataSetInvalidated();
  }
  
  class ViewHolder
  {
    public ImageView imageView;
    public TextView textView;
    
    private ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.PopupMenuAdapter
 * JD-Core Version:    0.7.0.1
 */