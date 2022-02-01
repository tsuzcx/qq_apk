package com.tencent.token.ui.qqpim.okdownload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.aac;
import com.tencent.token.ui.ImageActivity;

public class LayoutAppKeyInfo
  extends LinearLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private Context f;
  
  public LayoutAppKeyInfo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext;
    paramContext = (LinearLayout)View.inflate(paramContext, 2131296301, null);
    this.a = ((TextView)paramContext.findViewById(2131166161));
    this.b = ((TextView)paramContext.findViewById(2131166190));
    this.c = ((TextView)paramContext.findViewById(2131166178));
    this.d = ((TextView)paramContext.findViewById(2131166179));
    this.e = ((TextView)paramContext.findViewById(2131166162));
    setGravity(1);
    addView(paramContext);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, final String paramString4, final String paramString5, final Activity paramActivity)
  {
    if (TextUtils.isEmpty(paramString1)) {
      this.a.setVisibility(8);
    } else {
      this.a.setText("开发者:".concat(String.valueOf(paramString1)));
    }
    if (TextUtils.isEmpty(paramString3))
    {
      this.b.setVisibility(8);
    }
    else
    {
      paramString1 = this.b;
      StringBuilder localStringBuilder = new StringBuilder("应用版本:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" | 应用名称:");
      localStringBuilder.append(paramString3);
      paramString1.setText(localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString4))
    {
      this.c.setVisibility(8);
      this.e.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramString5))
    {
      this.d.setVisibility(8);
      this.e.setVisibility(8);
    }
    int i = Color.parseColor("#4C000000");
    this.a.setTextColor(i);
    this.b.setTextColor(i);
    this.e.setTextColor(i);
    paramString1 = new SpannableStringBuilder("应用权限");
    paramString1.setSpan(new UnderlineSpan(), 0, 4, 33);
    paramString1.setSpan(new ForegroundColorSpan(i), 0, 4, 33);
    this.c.setText(paramString1);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        aac.b(paramActivity, paramString4, "应用权限");
      }
    });
    paramString1 = new SpannableStringBuilder("隐私政策");
    paramString1.setSpan(new UnderlineSpan(), 0, 4, 33);
    paramString1.setSpan(new ForegroundColorSpan(i), 0, 4, 33);
    this.d.setText(paramString1);
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (TextUtils.isEmpty(paramString5)) {
          return;
        }
        paramAnonymousView = paramString5.toLowerCase();
        if ((!paramAnonymousView.endsWith("png")) && (!paramAnonymousView.endsWith("jpg")) && (!paramAnonymousView.endsWith("jpeg")))
        {
          aac.b(paramActivity, paramString5, "隐私政策");
          return;
        }
        paramAnonymousView = new Intent(paramActivity, ImageActivity.class);
        paramAnonymousView.putExtra("url", paramString5);
        paramActivity.startActivity(paramAnonymousView);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.okdownload.LayoutAppKeyInfo
 * JD-Core Version:    0.7.0.1
 */