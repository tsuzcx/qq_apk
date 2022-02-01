package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.activity.contacts.watcher.ContactPhoneItemWatcher;

public class ContactDetailItemView
  extends ContactBaseItemView
{
  private TextView nodeContent;
  private ImageView nodeIcon;
  
  public ContactDetailItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactDetailItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactDetailItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ContactDetailItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
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
  
  protected int initLayout()
  {
    return 2131559089;
  }
  
  protected void initViews()
  {
    this.nodeContent = ((TextView)findViewById(2131365274));
    this.nodeIcon = ((ImageView)findViewById(2131365278));
    setBackgroundResource(2130841254);
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
    if (this.itemType == ContactBaseItemView.ContactItemType.TYPE_TEL) {}
    for (Object localObject = ContactPhoneItemWatcher.formatPhone(paramString);; localObject = paramString)
    {
      if (this.nodeContent != null)
      {
        if (paramBoolean)
        {
          localObject = new SpannableString((CharSequence)localObject);
          ((SpannableString)localObject).setSpan(new StyleSpan(1), 0, paramString.length(), 17);
          this.nodeContent.setText((CharSequence)localObject);
        }
      }
      else {
        return;
      }
      this.nodeContent.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void setItemType(ContactBaseItemView.ContactItemType paramContactItemType)
  {
    super.setItemType(paramContactItemType);
    this.nodeContent.setOnClickListener(new ContactDetailItemView.1(this));
    this.nodeContent.setLongClickable(true);
    this.nodeContent.setOnLongClickListener(new ContactDetailItemView.2(this));
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
  
  public void setNodeIcon(int paramInt)
  {
    if (paramInt != 0)
    {
      this.nodeIcon.setImageResource(paramInt);
      this.nodeIcon.setVisibility(0);
      return;
    }
    this.nodeIcon.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactDetailItemView
 * JD-Core Version:    0.7.0.1
 */