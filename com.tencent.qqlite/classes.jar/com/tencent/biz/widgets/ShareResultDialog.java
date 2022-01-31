package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qphone.base.util.QLog;
import tb;
import tc;

public class ShareResultDialog
  extends Dialog
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public ShareResultDialog(Context paramContext)
  {
    super(paramContext, 2131624120);
    super.setContentView(2130903195);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296915));
    this.b = ((TextView)super.findViewById(2131296916));
    this.c = ((TextView)super.findViewById(2131297108));
    this.d = ((TextView)super.findViewById(2131297109));
    this.e = ((TextView)super.findViewById(2131297110));
  }
  
  private void b(boolean paramBoolean)
  {
    int j = 8;
    QLog.i("ShareToQZone", 2, "width:" + this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width);
    TextView localTextView;
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      localTextView = this.d;
      if (!this.jdField_a_of_type_Boolean) {
        break label126;
      }
      i = 8;
      label65:
      localTextView.setVisibility(i);
      localTextView = this.c;
      if (!this.jdField_a_of_type_Boolean) {
        break label131;
      }
      i = 0;
      label86:
      localTextView.setVisibility(i);
      localTextView = this.e;
      if (!this.jdField_a_of_type_Boolean) {
        break label137;
      }
    }
    label131:
    label137:
    for (int i = j;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
      this.b.setVisibility(8);
      break;
      label126:
      i = 0;
      break label65;
      i = 8;
      break label86;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.d != null) {
      this.d.setText(paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.d != null) && (TextUtils.isEmpty(paramString))) {
      this.d.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new tb(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    if (this.e != null)
    {
      if (paramInt != 0) {
        this.e.setText(paramInt);
      }
    }
    else {
      return;
    }
    this.e.setText("");
  }
  
  public void b(String paramString)
  {
    if ((this.e != null) && (TextUtils.isEmpty(paramString))) {
      this.e.setText(paramString);
    }
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      b(false);
      return;
    }
    b(true);
    this.b.setText(paramString);
    this.b.setOnClickListener(new tc(this, paramOnClickListener));
  }
  
  public void c(int paramInt)
  {
    if (this.c != null) {
      this.c.setText(paramInt);
    }
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
  
  public void onBackPressed()
  {
    QLog.i("ShareResultDialog", 2, "onBackPressed");
    super.onBackPressed();
    ForwardRecentActivity localForwardRecentActivity;
    if (ForwardRecentActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext))
    {
      localForwardRecentActivity = (ForwardRecentActivity)this.jdField_a_of_type_AndroidContentContext;
      if (!localForwardRecentActivity.isFinishing())
      {
        if (this.b.getVisibility() != 0) {
          break label63;
        }
        QLog.i("ShareResultDialog", 2, "onBackPressed err");
        localForwardRecentActivity.a(false);
      }
    }
    return;
    label63:
    QLog.i("ShareResultDialog", 2, "onBackPressed suc");
    localForwardRecentActivity.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareResultDialog
 * JD-Core Version:    0.7.0.1
 */