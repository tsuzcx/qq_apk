package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QMTextField
  extends LinearLayout
{
  public static final String TAG = "QMTextField";
  private QMTextFieldCallback callback;
  private int iType;
  private TextView prefixTV;
  private EditText textFieldET;
  private TextView textFieldTV;
  
  public QMTextField(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMTextField(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void initViews()
  {
    this.prefixTV = ((TextView)findViewById(2131365187));
    this.textFieldTV = ((TextView)findViewById(2131365188));
    this.textFieldET = ((EditText)findViewById(2131365186));
    this.textFieldET.setFocusable(true);
    this.textFieldET.setFocusableInTouchMode(true);
    this.textFieldET.setOnFocusChangeListener(new QMTextField.1(this));
    this.textFieldET.setOnTouchListener(new QMTextField.2(this));
    this.textFieldET.setOnEditorActionListener(new QMTextField.3(this));
  }
  
  public QMTextFieldCallback getCallback()
  {
    return this.callback;
  }
  
  public TextView getPrefixTV()
  {
    return this.prefixTV;
  }
  
  public String getText()
  {
    return this.textFieldET.getText().toString();
  }
  
  public EditText getTextFieldET()
  {
    return this.textFieldET;
  }
  
  public int getiType()
  {
    return this.iType;
  }
  
  public boolean hasFocusCursor()
  {
    return this.textFieldET.isFocused();
  }
  
  public void init()
  {
    initViews();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Log.i("QMTextField", "onKeyDown " + paramInt);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setCallback(QMTextFieldCallback paramQMTextFieldCallback)
  {
    this.callback = paramQMTextFieldCallback;
  }
  
  public void setFocused(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.textFieldET.requestFocus();
      return;
    }
    this.textFieldET.clearFocus();
  }
  
  public void setPrefixTV(TextView paramTextView)
  {
    this.prefixTV = paramTextView;
  }
  
  public void setText(String paramString)
  {
    this.textFieldET.setText(paramString);
    this.textFieldTV.setText(paramString);
  }
  
  public void setTextFieldET(EditText paramEditText)
  {
    this.textFieldET = paramEditText;
  }
  
  public void setUnChangeable()
  {
    setEnabled(false);
    this.prefixTV.setEnabled(false);
    this.textFieldET.setVisibility(8);
    this.textFieldTV.setVisibility(0);
  }
  
  public void setiType(int paramInt)
  {
    this.iType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("QMTextField: ");
    if (this.prefixTV != null) {}
    for (Object localObject = this.prefixTV.getText();; localObject = "") {
      return localObject;
    }
  }
  
  public static abstract interface QMTextFieldCallback
  {
    public abstract void onClickChange(QMTextField paramQMTextField);
    
    public abstract void onFocusChange(QMTextField paramQMTextField, boolean paramBoolean);
    
    public abstract void onKeyNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMTextField
 * JD-Core Version:    0.7.0.1
 */