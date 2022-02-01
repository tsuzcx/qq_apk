package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.TextView;

public class ContactDetailItemSingleView
  extends ContactBaseItemView
{
  private TextView nodeContent;
  private TextView nodeLabel;
  
  public ContactDetailItemSingleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactDetailItemSingleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactDetailItemSingleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ContactDetailItemSingleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public String getContent()
  {
    String str = "";
    if (this.nodeContent != null) {
      str = this.nodeContent.getText().toString();
    }
    return str;
  }
  
  public String getLabel()
  {
    String str = "";
    if (this.nodeLabel != null) {
      str = this.nodeLabel.getText().toString();
    }
    return str;
  }
  
  protected int initLayout()
  {
    return 2131559091;
  }
  
  protected void initViews()
  {
    this.nodeLabel = ((TextView)findViewById(2131365284));
    this.nodeContent = ((TextView)findViewById(2131365274));
  }
  
  public void setContent(int paramInt)
  {
    setContent(this.context.getString(paramInt), false);
  }
  
  public void setContent(int paramInt, boolean paramBoolean)
  {
    setContent(this.context.getString(paramInt), paramBoolean);
  }
  
  public void setContent(String paramString)
  {
    setContent(paramString, false);
  }
  
  public void setContent(String paramString, boolean paramBoolean)
  {
    if (this.nodeContent != null)
    {
      if (paramBoolean)
      {
        SpannableString localSpannableString = new SpannableString(paramString);
        localSpannableString.setSpan(new StyleSpan(1), 0, paramString.length(), 17);
        this.nodeContent.setText(localSpannableString);
      }
    }
    else {
      return;
    }
    this.nodeContent.setText(paramString);
  }
  
  public void setItemType(ContactBaseItemView.ContactItemType paramContactItemType)
  {
    super.setItemType(paramContactItemType);
    this.nodeContent.setOnClickListener(new ContactDetailItemSingleView.1(this));
    this.nodeContent.setLongClickable(true);
    this.nodeContent.setOnLongClickListener(new ContactDetailItemSingleView.2(this));
  }
  
  public void setLabel(int paramInt)
  {
    if (this.nodeLabel != null) {
      this.nodeLabel.setText(this.context.getString(paramInt));
    }
  }
  
  public void setLabel(String paramString)
  {
    if (this.nodeLabel != null) {
      this.nodeLabel.setText(paramString);
    }
  }
  
  public void setLinkContent(boolean paramBoolean)
  {
    if (this.nodeContent != null)
    {
      if (paramBoolean) {
        this.nodeContent.setTextColor(getResources().getColorStateList(2131165489));
      }
    }
    else {
      return;
    }
    this.nodeContent.setTextColor(getResources().getColor(2131166572));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactDetailItemSingleView
 * JD-Core Version:    0.7.0.1
 */