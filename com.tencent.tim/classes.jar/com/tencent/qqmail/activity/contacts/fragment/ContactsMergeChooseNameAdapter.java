package com.tencent.qqmail.activity.contacts.fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.MailContact;
import java.util.List;

public class ContactsMergeChooseNameAdapter
  extends BaseAdapter
{
  private List<MailContact> mContacts;
  private boolean[] mWhichNameChoose;
  
  ContactsMergeChooseNameAdapter(List<MailContact> paramList, boolean[] paramArrayOfBoolean)
  {
    this.mContacts = paramList;
    this.mWhichNameChoose = paramArrayOfBoolean;
  }
  
  public int getCount()
  {
    return this.mContacts.size();
  }
  
  public Object getItem(int paramInt)
  {
    return ((MailContact)this.mContacts.get(paramInt)).getName();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559099, paramViewGroup, false);
      paramView = new ViewHolder(localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.bindData((String)getItem(paramInt), paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  class ViewHolder
  {
    private ImageView imageView;
    private View itemView;
    private TextView nameTextView;
    
    public ViewHolder(View paramView)
    {
      this.imageView = ((ImageView)paramView.findViewById(2131365302));
      this.nameTextView = ((TextView)paramView.findViewById(2131365308));
      this.itemView = paramView;
    }
    
    public void bindData(String paramString, int paramInt)
    {
      if (TextUtils.isEmpty(paramString)) {
        this.nameTextView.setText(QMApplicationContext.sharedInstance().getString(2131692061));
      }
      while (ContactsMergeChooseNameAdapter.this.mWhichNameChoose[paramInt] != 0)
      {
        this.imageView.setVisibility(0);
        return;
        this.nameTextView.setText(paramString);
      }
      this.imageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeChooseNameAdapter
 * JD-Core Version:    0.7.0.1
 */