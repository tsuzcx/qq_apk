package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class ContactEditBirthdayItemView
  extends ContactEditItemView
{
  protected TextView nodeTextViewInput;
  
  public ContactEditBirthdayItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactEditBirthdayItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactEditBirthdayItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ContactEditBirthdayItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public String getNodeInputText()
  {
    String str = "";
    if (this.nodeTextViewInput != null) {
      str = this.nodeTextViewInput.getText().toString();
    }
    return str;
  }
  
  protected void initViews()
  {
    super.initViews();
    this.nodeTextViewInput = ((TextView)findViewById(2131365286));
    this.nodeTextViewInput.setVisibility(0);
    this.nodeInput.setVisibility(8);
  }
  
  public void setNodeInputText(String paramString)
  {
    if (this.nodeTextViewInput != null)
    {
      this.nodeTextViewInput.setText(paramString);
      if (!StringExtention.isNullOrEmpty(paramString)) {
        this.iconClear.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.iconClear.setVisibility(8);
  }
  
  protected void setOnTextChangeListener()
  {
    if (this.itemType == ContactBaseItemView.ContactItemType.TYPE_BIRTHDAY) {
      this.nodeTextViewInput.setOnClickListener(new ContactEditBirthdayItemView.1(this));
    }
    this.iconClear.setOnClickListener(new ContactEditBirthdayItemView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditBirthdayItemView
 * JD-Core Version:    0.7.0.1
 */