package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.R.style;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public final class d
  extends ReportDialog
  implements View.OnClickListener
{
  TextView a;
  TextView b;
  TextView c;
  TextView d;
  View e;
  Bundle f;
  private boolean g;
  private boolean h;
  
  public d(@NonNull Context paramContext)
  {
    super(paramContext, R.style.b);
    a(paramContext);
  }
  
  private void a(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.a, null);
    setContentView(paramContext);
    this.a = ((TextView)paramContext.findViewById(R.id.t));
    this.b = ((TextView)paramContext.findViewById(R.id.s));
    this.c = ((TextView)paramContext.findViewById(R.id.q));
    this.d = ((TextView)paramContext.findViewById(R.id.r));
    this.e = paramContext.findViewById(R.id.p);
  }
  
  public Bundle a()
  {
    return this.f;
  }
  
  public void a(Bundle paramBundle)
  {
    this.f = paramBundle;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    this.h = false;
    this.g = false;
    if (this.a != null)
    {
      this.a.setText(paramString1);
      this.a.setContentDescription(paramString1);
    }
    if (this.b != null)
    {
      this.b.setText(paramString2);
      this.b.setContentDescription(paramString2);
    }
    if ((this.c == null) || (!TextUtils.isEmpty(paramString4))) {}
    try
    {
      this.c.setTextColor(Color.parseColor(paramString4));
      label83:
      this.c.setText(paramString3);
      this.c.setContentDescription(paramString3);
      if (paramOnClickListener != null) {
        this.c.setOnClickListener(paramOnClickListener);
      }
      for (;;)
      {
        if ((!paramBoolean) || ((this.d == null) || (!TextUtils.isEmpty(paramString6)))) {}
        try
        {
          this.d.setTextColor(Color.parseColor(paramString6));
          label145:
          this.d.setText(paramString5);
          this.d.setContentDescription(paramString5);
          if (paramOnClickListener != null) {
            this.d.setOnClickListener(paramOnClickListener);
          }
          for (;;)
          {
            show();
            return;
            this.c.setOnClickListener(this);
            break;
            this.d.setOnClickListener(this);
            continue;
            if (this.d != null) {
              this.d.setVisibility(8);
            }
            if (this.e != null) {
              this.e.setVisibility(8);
            }
          }
        }
        catch (IllegalArgumentException paramString1)
        {
          break label145;
        }
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      break label83;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.q)
    {
      b(true);
      dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == R.id.r)
      {
        a(true);
        dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.d
 * JD-Core Version:    0.7.0.1
 */