package com.tencent.qqmail.activity.contacts.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ContactTableView
  extends LinearLayout
{
  private Context context;
  
  public ContactTableView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ContactTableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public ContactTableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  @TargetApi(21)
  public ContactTableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    int i = getResources().getDimensionPixelSize(2131297005);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(0, i, 0, 0);
    setLayoutParams(paramContext);
    setOrientation(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactTableView
 * JD-Core Version:    0.7.0.1
 */