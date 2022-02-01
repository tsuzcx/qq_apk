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
    Object localObject = this.d;
    if (localObject != null)
    {
      int j = localObject.length;
      final int i = 2;
      if (j < 2) {
        return;
      }
      localObject = (Button)findViewById(2131165251);
      ((Button)localObject).setText(this.d[0]);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CommonActionSheetDialog.a(CommonActionSheetDialog.this).a(0);
        }
      });
      localObject = (Button)findViewById(2131165252);
      ((Button)localObject).setText(this.d[1]);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CommonActionSheetDialog.a(CommonActionSheetDialog.this).a(1);
        }
      });
      while (i < this.d.length)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((Button)localObject).getLayoutParams();
        Button localButton = new Button(this.a);
        localButton.setLayoutParams(localLayoutParams);
        localButton.setTextAppearance(this.a, 2131558795);
        localButton.setText(this.d[i]);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            CommonActionSheetDialog.a(CommonActionSheetDialog.this).a(i);
          }
        });
        this.c.addView(localButton);
        i += 1;
      }
      this.c.invalidate();
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296315);
    this.c = ((LinearLayout)findViewById(2131165253));
    setCanceledOnTouchOutside(true);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2131099876);
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