package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactEditComposeEmailView
  extends ContactEditItemView
{
  public ContactEditComposeEmailView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void hideLabel()
  {
    this.nodeLabel.setVisibility(8);
    findViewById(2131370458).setVisibility(8);
  }
  
  protected int initLayout()
  {
    return 2131559093;
  }
  
  protected void initViews()
  {
    this.nodeLabel = ((TextView)findViewById(2131365284));
    this.nodeInput = ((EditText)findViewById(2131365282));
    this.iconClear = ((ImageView)findViewById(2131365280));
    this.iconClear.setOnClickListener(new ContactEditComposeEmailView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditComposeEmailView
 * JD-Core Version:    0.7.0.1
 */