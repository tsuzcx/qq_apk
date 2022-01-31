package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.open.base.LogUtility;
import hok;
import hol;
import java.lang.ref.WeakReference;

public class MyAppDialog
  extends Dialog
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected final WeakReference a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  
  public MyAppDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2130903338);
  }
  
  public Activity a()
  {
    Activity localActivity2 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = null;
    }
    return localActivity1;
  }
  
  public MyAppDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new hok(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public MyAppDialog a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 100;
    LogUtility.c("MyAppApi", "updateView--progress--" + paramInt1 + " state = " + paramInt2);
    Object localObject = getContext().getResources();
    switch (paramInt2)
    {
    default: 
      localObject = null;
      if (paramInt1 < 0)
      {
        i = 0;
        label113:
        if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.e.setVisibility(0);
        }
        if (paramInt2 != 3) {
          break label274;
        }
        this.c.setVisibility(0);
        this.c.setText(null);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      this.e.setText((CharSequence)localObject);
      return;
      localObject = ((Resources)localObject).getString(2131560011, new Object[] { Integer.valueOf(paramInt1) });
      break;
      localObject = ((Resources)localObject).getString(2131560012);
      break;
      localObject = ((Resources)localObject).getString(2131560013, new Object[] { Integer.valueOf(paramInt1) });
      break;
      localObject = ((Resources)localObject).getString(2131560014);
      paramInt1 = 100;
      break;
      localObject = ((Resources)localObject).getString(2131560013);
      break;
      if (paramInt1 > 100) {
        break label113;
      }
      i = paramInt1;
      break label113;
      label274:
      this.c.setVisibility(4);
    }
  }
  
  public MyAppDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new hol(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public MyAppDialog b(String paramString)
  {
    if (paramString != null) {
      this.b.setText(paramString);
    }
    return this;
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
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231469));
    this.b = ((TextView)findViewById(2131231029));
    this.c = ((TextView)findViewById(2131231472));
    this.c.getPaint().setFakeBoldText(true);
    this.d = ((TextView)findViewById(2131231473));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131232134));
    this.e = ((TextView)findViewById(2131232135));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog
 * JD-Core Version:    0.7.0.1
 */