package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.TextView;
import bpl;
import bpm;

public class ShareAioResultDialog
  extends Dialog
{
  public static final int a = 0;
  public static final int b = 1;
  private TextView a;
  private TextView b;
  
  public ShareAioResultDialog(Context paramContext)
  {
    super(paramContext, 2131624405);
    super.setContentView(2130903445);
    a();
  }
  
  public void a()
  {
    this.a = ((TextView)super.findViewById(2131231472));
    this.b = ((TextView)super.findViewById(2131231473));
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    Resources localResources = getContext().getResources();
    this.b.setContentDescription(localResources.getString(2131561316, new Object[] { localResources.getString(2131560587) }));
    this.b.setOnClickListener(new bpm(this, paramOnClickListener));
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.setText(paramString);
    Resources localResources = getContext().getResources();
    TextView localTextView = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setContentDescription(localResources.getString(2131561316, new Object[] { str }));
    this.a.setOnClickListener(new bpl(this, paramOnClickListener));
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareAioResultDialog
 * JD-Core Version:    0.7.0.1
 */