package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.android.tpush.logging.TLogger;

abstract class h
  extends a
{
  protected d d;
  protected String e = "PopupMessageTemplate";
  protected Intent f;
  
  protected h(Activity paramActivity, d paramd, Intent paramIntent)
  {
    super(paramActivity);
    this.d = paramd;
    this.f = paramIntent;
    a();
  }
  
  private ImageView a(Context paramContext)
  {
    paramContext = b(this.b);
    new f(this.d.h(), paramContext, this.b, 0).execute(new Void[0]);
    return paramContext;
  }
  
  private void a(String paramString)
  {
    try
    {
      TLogger.i(this.e, "jumpUrl targetActivity :" + paramString);
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.setFlags(268435456);
      this.b.startActivity(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      TLogger.e(this.e, "openUrl error.", paramString);
    }
  }
  
  private ImageView b(Context paramContext)
  {
    ImageView localImageView = new ImageView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.d.i(), this.d.j());
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = SizeUtil.dipTopx(paramContext, 24.0F);
    localLayoutParams.leftMargin = SizeUtil.dipTopx(paramContext, 24.0F);
    localLayoutParams.rightMargin = SizeUtil.dipTopx(paramContext, 24.0F);
    localImageView.setLayoutParams(localLayoutParams);
    return localImageView;
  }
  
  private RelativeLayout b(RelativeLayout paramRelativeLayout)
  {
    if ((this.d.v() != null) && (!TextUtils.isEmpty(this.d.v())))
    {
      ShapeDrawable localShapeDrawable = new ShapeDrawable();
      localShapeDrawable.setShape(i.a(this.d.g()));
      localShapeDrawable.getPaint().setColor(Color.parseColor(this.d.v()));
      paramRelativeLayout.setBackground(localShapeDrawable);
    }
    if ((this.d.H() != null) && (!TextUtils.isEmpty(this.d.H())))
    {
      paramRelativeLayout.setBackgroundColor(-1);
      new f(this.d.H(), paramRelativeLayout, this.b, this.d.g()).execute(new Void[0]);
    }
    return paramRelativeLayout;
  }
  
  private void b(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      TLogger.i(this.e, "jumpIntent targetActivity:" + paramString);
      paramString = Uri.parse(paramString);
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(paramString);
      if (localIntent.resolveActivity(this.b.getPackageManager()) != null) {
        this.b.startActivity(localIntent);
      }
      return;
    }
    catch (Throwable paramString)
    {
      TLogger.e(this.e, "jumpIntent error.", paramString);
    }
  }
  
  private TextView c(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setPadding(SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F), 0);
    localTextView.setText(this.d.x());
    localTextView.setTextColor(Color.parseColor(this.d.y()));
    localTextView.setTextSize(2, this.d.A());
    localTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    localTextView.setSingleLine(true);
    switch (this.d.z())
    {
    default: 
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      switch (this.d.B())
      {
      }
      break;
    }
    for (;;)
    {
      localTextView.setLayoutParams(paramContext);
      return localTextView;
      localTextView.setTypeface(Typeface.DEFAULT);
      break;
      localTextView.setTypeface(Typeface.DEFAULT_BOLD);
      break;
      localTextView.setTypeface(null, 2);
      break;
      localTextView.getPaint().setFlags(8);
      break;
      paramContext.gravity = 3;
      continue;
      paramContext.gravity = 1;
      continue;
      paramContext.gravity = 5;
    }
  }
  
  private View d(Context paramContext)
  {
    Object localObject1;
    Object localObject2;
    if (this.d.f() == 1)
    {
      localObject1 = new Button(paramContext);
      localObject2 = new LinearLayout.LayoutParams(-1, SizeUtil.dipTopx(paramContext, 48.0F));
      ((LinearLayout.LayoutParams)localObject2).setMargins(SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F));
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((Button)localObject1).setBackgroundColor(Color.parseColor(this.d.I()));
      paramContext = new GradientDrawable();
      paramContext.setShape(0);
      paramContext.setCornerRadius(this.d.l());
      paramContext.setColor(Color.parseColor(this.d.I()));
      ((Button)localObject1).setBackground(paramContext);
      ((Button)localObject1).setText(this.d.w());
      ((Button)localObject1).setTextColor(Color.parseColor(this.d.J()));
      ((Button)localObject1).setTextSize(this.d.k());
      ((Button)localObject1).setOnClickListener(new h.1(this));
      return localObject1;
    }
    if (this.d.f() == 2)
    {
      localObject1 = new LinearLayout(paramContext);
      localObject2 = new LinearLayout.LayoutParams(-1, SizeUtil.dipTopx(paramContext, 48.0F));
      ((LinearLayout.LayoutParams)localObject2).setMargins(SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F));
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setOrientation(0);
      localObject2 = new Button(paramContext);
      Object localObject3 = new LinearLayout.LayoutParams(0, -1, 1.0F);
      ((LinearLayout.LayoutParams)localObject3).gravity = 3;
      ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((Button)localObject2).setBackgroundColor(Color.parseColor(this.d.I()));
      ((Button)localObject2).setText(this.d.w());
      ((Button)localObject2).setTextColor(Color.parseColor(this.d.J()));
      ((Button)localObject2).setTextSize(this.d.k());
      localObject3 = new GradientDrawable();
      ((GradientDrawable)localObject3).setShape(0);
      ((GradientDrawable)localObject3).setCornerRadius(this.d.l());
      ((GradientDrawable)localObject3).setColor(Color.parseColor(this.d.I()));
      ((Button)localObject2).setBackground((Drawable)localObject3);
      ((Button)localObject2).setOnClickListener(new h.2(this));
      ((LinearLayout)localObject1).addView((View)localObject2);
      localObject2 = new View(paramContext);
      ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.2F));
      ((LinearLayout)localObject1).addView((View)localObject2);
      paramContext = new Button(paramContext);
      localObject2 = new LinearLayout.LayoutParams(0, -1, 1.0F);
      ((LinearLayout.LayoutParams)localObject2).gravity = 5;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramContext.setBackgroundColor(Color.parseColor(this.d.u()));
      paramContext.setText(this.d.t());
      paramContext.setTextColor(Color.parseColor(this.d.s()));
      paramContext.setTextSize(this.d.r());
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setShape(0);
      ((GradientDrawable)localObject2).setCornerRadius(this.d.q());
      ((GradientDrawable)localObject2).setColor(Color.parseColor(this.d.u()));
      paramContext.setBackground((Drawable)localObject2);
      paramContext.setOnClickListener(new h.3(this));
      ((LinearLayout)localObject1).addView(paramContext);
      return localObject1;
    }
    return null;
  }
  
  private TextView e(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    switch (this.d.D())
    {
    }
    for (;;)
    {
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setPadding(SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F), SizeUtil.dipTopx(paramContext, 24.0F), 0);
      localTextView.setText(this.d.F());
      localTextView.setTextColor(Color.parseColor(this.d.G()));
      localTextView.setTextSize(2, this.d.C());
      localTextView.setMaxLines(8);
      localTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
      switch (this.d.E())
      {
      default: 
        return localTextView;
        localLayoutParams.gravity = 3;
        continue;
        localLayoutParams.gravity = 1;
        continue;
        localLayoutParams.gravity = 5;
      }
    }
    localTextView.setTypeface(Typeface.DEFAULT);
    return localTextView;
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    return localTextView;
    localTextView.setTypeface(null, 2);
    return localTextView;
    localTextView.getPaint().setFlags(8);
    return localTextView;
  }
  
  private void g()
  {
    try
    {
      Intent localIntent1 = new Intent();
      localIntent1.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent1.putExtra("android.provider.extra.APP_PACKAGE", this.b.getPackageName());
      localIntent1.putExtra("android.intent.extra.CHANNEL_ID", this.b.getApplicationInfo().uid);
      localIntent1.putExtra("app_package", this.b.getPackageName());
      localIntent1.putExtra("app_uid", this.b.getApplicationInfo().uid);
      this.b.startActivity(localIntent1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Intent localIntent2 = new Intent();
      localIntent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent2.setData(Uri.fromParts("package", this.b.getPackageName(), null));
      this.b.startActivity(localIntent2);
    }
  }
  
  @RequiresApi(api=23)
  void a(RelativeLayout paramRelativeLayout)
  {
    ScrollView localScrollView = new ScrollView(this.b);
    localScrollView.setVerticalScrollBarEnabled(false);
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout = new LinearLayout(this.b);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.setOrientation(1);
    localObject = this.d.a(1);
    if (("Title.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.x())))
    {
      localLinearLayout.addView(c(this.b));
      localObject = this.d.a(2);
      if ((!"Title.Location".equals(localObject)) || (TextUtils.isEmpty(this.d.x()))) {
        break label376;
      }
      localLinearLayout.addView(c(this.b));
      label144:
      localObject = this.d.a(3);
      if ((!"Title.Location".equals(localObject)) || (TextUtils.isEmpty(this.d.x()))) {
        break label499;
      }
      localLinearLayout.addView(c(this.b));
      label190:
      localObject = this.d.a(4);
      if ((!"Title.Location".equals(localObject)) || (TextUtils.isEmpty(this.d.x()))) {
        break label622;
      }
      localLinearLayout.addView(c(this.b));
    }
    for (;;)
    {
      b(paramRelativeLayout);
      localScrollView.addView(localLinearLayout);
      paramRelativeLayout.addView(localScrollView);
      return;
      if (("Message.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.F())))
      {
        localLinearLayout.addView(e(this.b));
        break;
      }
      if (("Media.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.h())))
      {
        localLinearLayout.addView(a(this.b));
        break;
      }
      if ((!"Button.Location".equals(localObject)) || (this.d.f() <= 0)) {
        break;
      }
      localObject = d(this.b);
      if (localObject == null) {
        break;
      }
      localLinearLayout.addView((View)localObject);
      break;
      label376:
      if (("Message.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.F())))
      {
        localLinearLayout.addView(e(this.b));
        break label144;
      }
      if (("Media.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.h())))
      {
        localLinearLayout.addView(a(this.b));
        break label144;
      }
      if ((!"Button.Location".equals(localObject)) || (this.d.f() <= 0)) {
        break label144;
      }
      localObject = d(this.b);
      if (localObject == null) {
        break label144;
      }
      localLinearLayout.addView((View)localObject);
      break label144;
      label499:
      if (("Message.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.F())))
      {
        localLinearLayout.addView(e(this.b));
        break label190;
      }
      if (("Media.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.h())))
      {
        localLinearLayout.addView(a(this.b));
        break label190;
      }
      if ((!"Button.Location".equals(localObject)) || (this.d.f() <= 0)) {
        break label190;
      }
      localObject = d(this.b);
      if (localObject == null) {
        break label190;
      }
      localLinearLayout.addView((View)localObject);
      break label190;
      label622:
      if (("Message.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.F())))
      {
        localLinearLayout.addView(e(this.b));
      }
      else if (("Media.Location".equals(localObject)) && (!TextUtils.isEmpty(this.d.h())))
      {
        localLinearLayout.addView(a(this.b));
      }
      else if (("Button.Location".equals(localObject)) && (this.d.f() > 0))
      {
        localObject = d(this.b);
        if (localObject != null) {
          localLinearLayout.addView((View)localObject);
        }
      }
    }
  }
  
  protected boolean c()
  {
    return this.d.e() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.h
 * JD-Core Version:    0.7.0.1
 */