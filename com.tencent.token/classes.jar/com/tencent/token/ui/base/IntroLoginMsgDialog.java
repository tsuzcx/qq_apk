package com.tencent.token.ui.base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.token.global.b;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.t;

public class IntroLoginMsgDialog
  extends Dialog
{
  private CharSequence a;
  private CharSequence b;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((b.d()) && (paramKeyEvent.getAction() == 0)) {}
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    t.h();
    dismiss();
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903107);
    Object localObject2 = getWindow();
    ((Window)localObject2).setBackgroundDrawableResource(2130837639);
    View localView = findViewById(2131296702);
    Object localObject1 = findViewById(2131296703);
    paramBundle = findViewById(2131296706);
    Object localObject3 = new bg(this);
    localView.setOnClickListener((View.OnClickListener)localObject3);
    ((View)localObject1).setOnClickListener((View.OnClickListener)localObject3);
    paramBundle.setOnClickListener((View.OnClickListener)localObject3);
    localObject3 = (TextView)findViewById(2131296704);
    TextView localTextView = (TextView)findViewById(2131296705);
    ((TextView)localObject3).setText(this.a);
    localTextView.setText(this.b);
    int i = (((Window)localObject2).getWindowManager().getDefaultDisplay().getHeight() - IndexActivity.S_STATUS_HEIGHT - IndexActivity.S_TAB_HEIGHT) / 5;
    int j = ((Window)localObject2).getWindowManager().getDefaultDisplay().getWidth();
    localObject2 = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).height = (i * 3);
    ((ViewGroup.MarginLayoutParams)localObject2).width = j;
    localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).height = i;
    ((ViewGroup.MarginLayoutParams)localObject1).width = j;
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle.getLayoutParams();
    paramBundle.height = (i + IndexActivity.S_TAB_HEIGHT);
    paramBundle.width = j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.IntroLoginMsgDialog
 * JD-Core Version:    0.7.0.1
 */