package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.activity.contacts.watcher.ContactPhoneItemWatcher;
import java.lang.ref.WeakReference;

public class ContactEditItemView
  extends ContactBaseItemView
{
  protected Button deleteButton;
  protected ImageView iconClear;
  protected RelativeLayout iconDelete;
  protected ContactsScrollItemView mScrollerView;
  protected EditText nodeInput;
  protected TextView nodeLabel;
  
  public ContactEditItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactEditItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactEditItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ContactEditItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void removeSelf()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ContactTableView))) {
      ContactUIHelper.startRemoveItemAnimation(this, new ContactEditItemView.4(this, (ContactTableView)localViewParent));
    }
    if (this.nodeInput != null) {
      this.nodeInput.setOnFocusChangeListener(null);
    }
  }
  
  public ImageView getIconClear()
  {
    return this.iconClear;
  }
  
  public EditText getNodeInput()
  {
    return this.nodeInput;
  }
  
  public String getNodeInputText()
  {
    String str = "";
    if (this.nodeInput != null) {
      str = this.nodeInput.getText().toString();
    }
    return str;
  }
  
  public String getNodeLabel()
  {
    String str = "";
    if (this.nodeLabel != null) {
      str = this.nodeLabel.getText().toString();
    }
    return str;
  }
  
  protected int initLayout()
  {
    return 2131559092;
  }
  
  protected void initViews()
  {
    this.mScrollerView = ((ContactsScrollItemView)findViewById(2131377772));
    this.iconDelete = ((RelativeLayout)this.mScrollerView.findViewById(2131365281));
    this.iconDelete.setOnClickListener(new ContactEditItemView.1(this));
    this.deleteButton = ((Button)this.mScrollerView.findViewById(2131365277));
    this.deleteButton.setOnClickListener(new ContactEditItemView.2(this));
    this.nodeLabel = ((TextView)findViewById(2131365284));
    this.nodeInput = ((EditText)findViewById(2131365282));
    this.iconClear = ((ImageView)findViewById(2131365280));
    this.iconClear.setOnClickListener(new ContactEditItemView.3(this));
  }
  
  public void setItemType(ContactBaseItemView.ContactItemType paramContactItemType)
  {
    super.setItemType(paramContactItemType);
    setOnTextChangeListener();
  }
  
  public void setNodeInputText(int paramInt)
  {
    if (this.nodeInput != null) {
      this.nodeInput.setText(this.context.getString(paramInt));
    }
  }
  
  public void setNodeInputText(String paramString)
  {
    if (this.nodeInput != null) {
      this.nodeInput.setText(paramString);
    }
  }
  
  public void setNodeLabel(int paramInt)
  {
    if (this.nodeLabel != null) {
      this.nodeLabel.setText(this.context.getString(paramInt));
    }
  }
  
  public void setNodeLabel(String paramString)
  {
    if (this.nodeLabel != null) {
      this.nodeLabel.setText(paramString);
    }
  }
  
  protected void setOnTextChangeListener()
  {
    if (this.itemType == ContactBaseItemView.ContactItemType.TYPE_TEL)
    {
      this.nodeInput.addTextChangedListener(new ContactPhoneItemWatcher(new WeakReference(this.nodeInput)));
      this.nodeInput.setInputType(3);
    }
    if (this.itemType == ContactBaseItemView.ContactItemType.TYPE_EMAIL) {
      this.nodeInput.setInputType(33);
    }
    this.nodeInput.setOnFocusChangeListener(new ContactEditItemView.5(this));
    this.nodeInput.addTextChangedListener(new ContactEditItemView.6(this));
  }
  
  public void setRequestFocus()
  {
    if (this.nodeInput != null)
    {
      this.nodeInput.requestFocus();
      this.nodeInput.setSelection(this.nodeInput.getText().toString().length());
    }
  }
  
  public void toggleIconDelete(boolean paramBoolean)
  {
    if (this.iconDelete != null)
    {
      if (paramBoolean)
      {
        this.iconDelete.setVisibility(0);
        this.iconDelete.setClickable(true);
      }
    }
    else {
      return;
    }
    this.iconDelete.setVisibility(4);
    this.iconDelete.setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditItemView
 * JD-Core Version:    0.7.0.1
 */