package com.tencent.qqmail.inquirymail.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;

public class InquiryMailListAdapter
  extends BaseAdapter
{
  private static final int ITEM_VIEW_TYPE_LOAD_MORE = 2;
  private static final int ITEM_VIEW_TYPE_MAIL = 0;
  private static final int ITEM_VIEW_TYPE_MAIL_LAST = 1;
  private Context context;
  private InquiryMailListCursor cursor;
  private LayoutInflater inflater;
  private ListView listView;
  
  public InquiryMailListAdapter(Context paramContext, ListView paramListView, InquiryMailListCursor paramInquiryMailListCursor)
  {
    this.context = paramContext;
    this.inflater = LayoutInflater.from(paramContext);
    this.listView = paramListView;
    this.cursor = paramInquiryMailListCursor;
  }
  
  public int getCount()
  {
    if (this.cursor == null) {
      return -1;
    }
    if (this.cursor.canLoadMore()) {
      return this.cursor.getCount() + 1;
    }
    return this.cursor.getCount();
  }
  
  public InquiryMail getItem(int paramInt)
  {
    if (this.cursor == null) {}
    while (paramInt >= this.cursor.getCount()) {
      return null;
    }
    return this.cursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    InquiryMail localInquiryMail = getItem(paramInt);
    if (localInquiryMail != null) {
      return localInquiryMail.getId();
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt > 0) && (paramInt >= this.cursor.getCount()) && (this.cursor.canLoadMore())) {
      return 2;
    }
    if (paramInt == this.cursor.getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 2)
    {
      if ((paramView != null) && ((paramView instanceof MailListMoreItemView))) {
        break label381;
      }
      paramView = new MailListMoreItemView(this.context);
    }
    label345:
    label368:
    label375:
    label381:
    for (;;)
    {
      Object localObject = (MailListMoreItemView)paramView;
      if (this.cursor.getState() == 2)
      {
        ((MailListMoreItemView)localObject).showLoading(true);
        ((MailListMoreItemView)localObject).setEnabled(false);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        ((MailListMoreItemView)localObject).showLoading(false);
        ((MailListMoreItemView)localObject).setEnabled(true);
      }
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = this.inflater.inflate(2131559436, paramViewGroup, false);
        localObject = new InquiryMailViewHolder();
        ((InquiryMailViewHolder)localObject).senderNameView = ((TextView)paramView.findViewById(2131369309));
        ((InquiryMailViewHolder)localObject).dateView = ((TextView)paramView.findViewById(2131369308));
        ((InquiryMailViewHolder)localObject).subjectView = ((TextView)paramView.findViewById(2131369311));
        ((InquiryMailViewHolder)localObject).statusView = ((TextView)paramView.findViewById(2131369310));
        paramView.setTag(localObject);
      }
      for (;;)
      {
        localObject = (InquiryMailViewHolder)paramView.getTag();
        InquiryMail localInquiryMail = getItem(paramInt);
        if (localInquiryMail != null)
        {
          ((InquiryMailViewHolder)localObject).senderNameView.setText(localInquiryMail.getSenderName());
          ((InquiryMailViewHolder)localObject).dateView.setText(DateExtension.getIcsYMDFormat(localInquiryMail.getTime() * 1000L));
          ((InquiryMailViewHolder)localObject).subjectView.setText(localInquiryMail.getSubject());
          if (!localInquiryMail.isIntercept()) {
            break label345;
          }
          ((InquiryMailViewHolder)localObject).statusView.setTextColor(this.context.getResources().getColor(2131166582));
        }
        for (;;)
        {
          ((InquiryMailViewHolder)localObject).statusView.setText(localInquiryMail.getStatus());
          if (!(paramView instanceof KeepPressedRelativeLayout)) {
            break label375;
          }
          localObject = (KeepPressedRelativeLayout)paramView;
          ((KeepPressedRelativeLayout)localObject).setDrawDivider(false, true);
          if (i != 0) {
            break label368;
          }
          ((KeepPressedRelativeLayout)localObject).updateDividerInsetLeft(0, this.context.getResources().getDimensionPixelSize(2131297032));
          break;
          ((InquiryMailViewHolder)localObject).statusView.setTextColor(this.context.getResources().getColor(2131166574));
        }
        ((KeepPressedRelativeLayout)localObject).updateDividerInsetLeft(0, 0);
        break;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void setMoreLoading()
  {
    int j = this.listView.getFirstVisiblePosition();
    int i = this.listView.getLastVisiblePosition();
    while (i >= j)
    {
      View localView = this.listView.getChildAt(i - j);
      if ((localView instanceof MailListMoreItemView))
      {
        ((MailListMoreItemView)localView).showLoading(true);
        localView.setEnabled(false);
        localView.invalidate();
      }
      i -= 1;
    }
  }
  
  public void setMoreLoadingNormal(boolean paramBoolean)
  {
    int j = this.listView.getFirstVisiblePosition();
    int k = this.listView.getLastVisiblePosition();
    int i = j;
    while (i <= k)
    {
      View localView = this.listView.getChildAt(i - j);
      if ((localView instanceof MailListMoreItemView))
      {
        ((MailListMoreItemView)localView).showError(paramBoolean);
        localView.setEnabled(true);
        localView.invalidate();
      }
      i += 1;
    }
  }
  
  class InquiryMailViewHolder
  {
    TextView dateView;
    TextView senderNameView;
    TextView statusView;
    TextView subjectView;
    
    InquiryMailViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.adapter.InquiryMailListAdapter
 * JD-Core Version:    0.7.0.1
 */