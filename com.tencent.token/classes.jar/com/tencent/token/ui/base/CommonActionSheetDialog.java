package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class CommonActionSheetDialog
  extends Dialog
{
  private Context a;
  private a b;
  private LinearLayout c;
  private String[] d;
  
  public CommonActionSheetDialog(Activity paramActivity, int paramInt, a parama, String[] paramArrayOfString)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
    this.d = paramArrayOfString;
    this.b = parama;
  }
  
  private void a()
  {
    if ((this.d == null) || (this.d.length < 2)) {
      return;
    }
    Button localButton1 = (Button)findViewById(2131558783);
    localButton1.setText(this.d[0]);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CommonActionSheetDialog.a(CommonActionSheetDialog.this).a(0);
      }
    });
    localButton1 = (Button)findViewById(2131558784);
    localButton1.setText(this.d[1]);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CommonActionSheetDialog.a(CommonActionSheetDialog.this).a(1);
      }
    });
    final int i = 2;
    while (i < this.d.length)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localButton1.getLayoutParams();
      Button localButton2 = new Button(this.a);
      localButton2.setLayoutParams(localLayoutParams);
      localButton2.setTextAppearance(this.a, 2131362186);
      localButton2.setText(this.d[i]);
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CommonActionSheetDialog.a(CommonActionSheetDialog.this).a(i);
        }
      });
      this.c.addView(localButton2);
      i += 1;
    }
    this.c.invalidate();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968635);
    this.c = ((LinearLayout)findViewById(2131558782));
    setCanceledOnTouchOutside(true);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837730);
    paramBundle.getAttributes().width = -1;
    paramBundle.setGravity(80);
    a();
  }
  
  public void show()
  {
    super.show();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.CommonActionSheetDialog
 * JD-Core Version:    0.7.0.1
 */