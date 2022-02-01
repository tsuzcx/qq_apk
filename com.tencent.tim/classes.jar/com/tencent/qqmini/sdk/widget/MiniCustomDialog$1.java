package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;

class MiniCustomDialog$1
  extends BaseAdapter
{
  MiniCustomDialog$1(MiniCustomDialog paramMiniCustomDialog) {}
  
  public int getCount()
  {
    if (this.this$0.items != null) {
      return this.this$0.items.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.this$0.inflater == null) {
      this.this$0.inflater = ((LayoutInflater)this.this$0.getContext().getSystemService("layout_inflater"));
    }
    MiniCustomDialog.Holder localHolder;
    if (paramView == null)
    {
      paramView = this.this$0.inflater.inflate(this.this$0.getDialogListItemLayout(), null);
      localHolder = new MiniCustomDialog.Holder(this.this$0, null);
      localHolder.text = ((TextView)paramView.findViewById(R.id.item_text));
      paramView.setTag(localHolder);
    }
    for (;;)
    {
      localHolder = (MiniCustomDialog.Holder)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localHolder.text != null)
      {
        localHolder.text.setText(this.this$0.items[paramInt]);
        localHolder.text.setOnClickListener(new MiniCustomDialog.CustomDialogItemOnClickListener(this.this$0, paramInt));
        i = localHolder.text.getPaddingTop();
        j = localHolder.text.getPaddingLeft();
        k = localHolder.text.getPaddingRight();
        m = localHolder.text.getPaddingBottom();
        if (this.this$0.items.length != 1) {
          break label239;
        }
        localHolder.text.setBackgroundResource(R.drawable.mini_sdk_custom_dialog_list_item_single_bg_selector);
      }
      for (;;)
      {
        localHolder.text.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label239:
        if (paramInt == 0) {
          localHolder.text.setBackgroundResource(R.drawable.mini_sdk_custom_dialog_list_item_up_bg_selector);
        } else if (paramInt == this.this$0.items.length - 1) {
          localHolder.text.setBackgroundResource(R.drawable.mini_sdk_custom_dialog_list_item_down_bg_selector);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog.1
 * JD-Core Version:    0.7.0.1
 */