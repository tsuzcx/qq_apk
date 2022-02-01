package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import java.util.ArrayList;

public class ComposeGroupAddrView
  extends RelativeLayout
{
  private ComposeAddrView.ComposeAddrViewCallback callback;
  private MailGroupContact groupContact;
  
  public ComposeGroupAddrView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComposeGroupAddrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void addContact(MailGroupContact paramMailGroupContact)
  {
    setGroupToWithContact(paramMailGroupContact);
  }
  
  public ArrayList<Object> getContactList()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.groupContact != null) {
      localArrayList.add(this.groupContact);
    }
    return localArrayList;
  }
  
  public boolean hasContact()
  {
    return this.groupContact != null;
  }
  
  public void init()
  {
    setOnClickListener(new ComposeGroupAddrView.1(this));
  }
  
  public void setCallback(ComposeAddrView.ComposeAddrViewCallback paramComposeAddrViewCallback)
  {
    this.callback = paramComposeAddrViewCallback;
  }
  
  public void setGroupToWithContact(MailGroupContact paramMailGroupContact)
  {
    this.groupContact = paramMailGroupContact;
    ((TextView)findViewById(2131365129)).setText(paramMailGroupContact.getName());
    ((TextView)findViewById(2131365128)).setText(2131694509);
  }
  
  public void setUnChangeable()
  {
    setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeGroupAddrView
 * JD-Core Version:    0.7.0.1
 */