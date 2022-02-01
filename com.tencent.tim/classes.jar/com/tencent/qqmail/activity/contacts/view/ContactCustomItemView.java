package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContactCustomItemView
  extends ContactBaseItemView
{
  private Button deleteButton;
  private RelativeLayout iconDelete;
  private ImageView keyIconClear;
  private EditText keyNodeInput;
  private TextView keyNodeLabel;
  private ContactsScrollItemView mScrollerView;
  private ImageView valueIconClear;
  private EditText valueNodeInput;
  private TextView valueNodeLabel;
  
  public ContactCustomItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactCustomItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactCustomItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ContactCustomItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void removeSelf()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ContactTableView))) {
      ContactUIHelper.startRemoveItemAnimation(this, new ContactCustomItemView.9(this, (ContactTableView)localViewParent));
    }
    if (this.keyNodeInput != null) {
      this.keyNodeInput.setOnFocusChangeListener(null);
    }
    if (this.valueNodeInput != null) {
      this.valueNodeInput.setOnFocusChangeListener(null);
    }
  }
  
  public String getCustomKeyInputText()
  {
    String str = "";
    if (this.keyNodeInput != null) {
      str = this.keyNodeInput.getText().toString();
    }
    return str;
  }
  
  public String getCustomValueInputText()
  {
    String str = "";
    if (this.valueNodeInput != null) {
      str = this.valueNodeInput.getText().toString();
    }
    return str;
  }
  
  protected int initLayout()
  {
    return 2131559088;
  }
  
  protected void initViews()
  {
    this.mScrollerView = ((ContactsScrollItemView)findViewById(2131377772));
    this.iconDelete = ((RelativeLayout)findViewById(2131365281));
    this.iconDelete.setOnClickListener(new ContactCustomItemView.1(this));
    this.deleteButton = ((Button)this.mScrollerView.findViewById(2131365277));
    this.deleteButton.setOnClickListener(new ContactCustomItemView.2(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131365275);
    this.keyNodeLabel = ((TextView)localRelativeLayout.findViewById(2131365284));
    this.keyNodeLabel.setText(2131692021);
    this.keyNodeInput = ((EditText)localRelativeLayout.findViewById(2131365282));
    this.keyNodeInput.setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });
    this.keyIconClear = ((ImageView)localRelativeLayout.findViewById(2131365280));
    this.keyIconClear.setOnClickListener(new ContactCustomItemView.3(this));
    localRelativeLayout = (RelativeLayout)findViewById(2131365276);
    this.valueNodeLabel = ((TextView)localRelativeLayout.findViewById(2131365284));
    this.valueNodeLabel.setText(2131692020);
    this.valueNodeInput = ((EditText)localRelativeLayout.findViewById(2131365282));
    this.valueIconClear = ((ImageView)localRelativeLayout.findViewById(2131365280));
    this.valueIconClear.setOnClickListener(new ContactCustomItemView.4(this));
    this.keyNodeInput.setOnFocusChangeListener(new ContactCustomItemView.5(this));
    this.keyNodeInput.addTextChangedListener(new ContactCustomItemView.6(this));
    this.valueNodeInput.setOnFocusChangeListener(new ContactCustomItemView.7(this));
    this.valueNodeInput.addTextChangedListener(new ContactCustomItemView.8(this));
  }
  
  public void setCustomKeyInputText(int paramInt)
  {
    if (this.keyNodeInput != null) {
      this.keyNodeInput.setText(paramInt);
    }
  }
  
  public void setCustomKeyInputText(String paramString)
  {
    if (this.keyNodeInput != null) {
      this.keyNodeInput.setText(paramString);
    }
  }
  
  public void setCustomValueInputText(int paramInt)
  {
    if (this.valueNodeInput != null) {
      this.valueNodeInput.setText(this.context.getString(paramInt));
    }
  }
  
  public void setCustomValueInputText(String paramString)
  {
    if (this.valueNodeInput != null) {
      this.valueNodeInput.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactCustomItemView
 * JD-Core Version:    0.7.0.1
 */