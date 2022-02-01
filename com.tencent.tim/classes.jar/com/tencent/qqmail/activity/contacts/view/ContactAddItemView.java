package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;

public class ContactAddItemView
  extends ContactBaseItemView
{
  private ImageButton addIcon;
  private TextView addText;
  
  public ContactAddItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactAddItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactAddItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ContactAddItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected int initLayout()
  {
    return 2131559086;
  }
  
  protected void initViews()
  {
    this.addIcon = ((ImageButton)findViewById(2131365279));
    this.addIcon.setClickable(false);
    this.addIcon.setDuplicateParentStateEnabled(true);
    this.addText = ((TextView)findViewById(2131365285));
    setOnClickListener(new ContactAddItemView.1(this));
  }
  
  public void setText(int paramInt)
  {
    String str = this.context.getString(paramInt);
    if (str != null) {
      this.addText.setText(str);
    }
  }
  
  public void setText(String paramString)
  {
    if (paramString != null) {
      this.addText.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactAddItemView
 * JD-Core Version:    0.7.0.1
 */