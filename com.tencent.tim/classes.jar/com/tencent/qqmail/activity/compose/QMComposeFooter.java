package com.tencent.qqmail.activity.compose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class QMComposeFooter
  extends LinearLayout
{
  public static int COMPOSE_FOOTER_TYPE_MAIL = 1;
  public static int COMPOSE_FOOTER_TYPE_NOTE = 2;
  private Button addButton;
  private QMComposeFooterCallback callback;
  private int composeFooterType = 0;
  private Button editButton;
  private ImageView errorFlag;
  
  public QMComposeFooter(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMComposeFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean hasAttach()
  {
    String str = this.addButton.getText().toString();
    return (str != null) && (!"".equals(str));
  }
  
  private void initView(int paramInt)
  {
    this.composeFooterType = paramInt;
    this.addButton = ((Button)findViewById(2131365156));
    this.editButton = ((Button)findViewById(2131365158));
    this.errorFlag = ((ImageView)findViewById(2131366506));
    if (paramInt == COMPOSE_FOOTER_TYPE_NOTE) {
      this.addButton.setBackgroundResource(2130839036);
    }
    this.addButton.setOnClickListener(new QMComposeFooter.1(this));
    this.editButton.setOnClickListener(new QMComposeFooter.2(this));
  }
  
  @SuppressLint({"NewApi"})
  public void changeAttachButtonBackground(boolean paramBoolean)
  {
    if (this.addButton == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.composeFooterType == COMPOSE_FOOTER_TYPE_NOTE)
      {
        this.addButton.setBackgroundResource(2130839037);
        return;
      }
      this.addButton.setBackgroundResource(2130839104);
      this.addButton.setTextColor(-1);
      return;
    }
    if (this.composeFooterType == COMPOSE_FOOTER_TYPE_NOTE)
    {
      this.addButton.setBackgroundResource(2130839036);
      return;
    }
    if (hasAttach()) {
      this.addButton.setBackgroundResource(2130839105);
    }
    for (;;)
    {
      this.addButton.setTextColor(-15370535);
      return;
      this.addButton.setBackgroundResource(2130839103);
    }
  }
  
  public int getAttachAmount()
  {
    String str = this.addButton.getText().toString();
    if (str.equals("")) {
      return 0;
    }
    return Integer.parseInt(str);
  }
  
  public QMComposeFooterCallback getCallback()
  {
    return this.callback;
  }
  
  public void hideErrorFlag()
  {
    this.errorFlag.setVisibility(8);
  }
  
  public void hiedEditButton()
  {
    this.editButton.setVisibility(8);
  }
  
  public void init(int paramInt)
  {
    initView(paramInt);
  }
  
  public void recycle()
  {
    this.callback = null;
    this.addButton = null;
  }
  
  public void setAttachNum(int paramInt)
  {
    if (paramInt > 0)
    {
      this.addButton.setText("" + paramInt);
      return;
    }
    this.addButton.setText("");
  }
  
  public void setButtonEnabled(boolean paramBoolean)
  {
    if (this.addButton != null) {
      this.addButton.setEnabled(paramBoolean);
    }
  }
  
  public void setCallback(QMComposeFooterCallback paramQMComposeFooterCallback)
  {
    this.callback = paramQMComposeFooterCallback;
  }
  
  public void showAttaches()
  {
    if (this.callback != null) {
      this.callback.onAddAttaches(this, this.addButton);
    }
  }
  
  public void showEditButton()
  {
    this.editButton.setVisibility(0);
  }
  
  public void showErrorFlag()
  {
    this.errorFlag.setVisibility(0);
  }
  
  public static abstract interface QMComposeFooterCallback
  {
    public abstract void onAddAttaches(QMComposeFooter paramQMComposeFooter, View paramView);
    
    public abstract boolean onChangeKeyBoardState(QMComposeFooter paramQMComposeFooter, View paramView);
    
    public abstract void onEditContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeFooter
 * JD-Core Version:    0.7.0.1
 */