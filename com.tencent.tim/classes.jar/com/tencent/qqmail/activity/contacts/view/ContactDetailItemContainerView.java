package com.tencent.qqmail.activity.contacts.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactDetailItemContainerView
  extends ContactBaseItemView
{
  private LinearLayout containerLayout;
  private TextView nodeLabel;
  
  public ContactDetailItemContainerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactDetailItemContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactDetailItemContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public ContactDetailItemContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void addContentNode(ContactDetailItemView paramContactDetailItemView)
  {
    if (paramContactDetailItemView != null)
    {
      this.containerLayout.addView(paramContactDetailItemView);
      this.nodeLabel.getLayoutParams().height = (getResources().getDimensionPixelSize(2131297616) * this.containerLayout.getChildCount());
    }
  }
  
  public int getContentNodeCount()
  {
    if (this.containerLayout != null) {
      return this.containerLayout.getChildCount();
    }
    return 0;
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
    return 2131559090;
  }
  
  protected void initViews()
  {
    this.nodeLabel = ((TextView)findViewById(2131365284));
    this.containerLayout = ((LinearLayout)findViewById(2131365273));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactDetailItemContainerView
 * JD-Core Version:    0.7.0.1
 */