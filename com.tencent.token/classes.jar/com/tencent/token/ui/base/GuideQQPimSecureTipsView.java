package com.tencent.token.ui.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.fk;

public class GuideQQPimSecureTipsView
  extends RelativeLayout
{
  public static boolean a = false;
  TextView b;
  TextView c;
  private String d;
  
  public GuideQQPimSecureTipsView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public GuideQQPimSecureTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968677, this, true);
    this.b = ((TextView)findViewById(2131558967));
    this.c = ((TextView)findViewById(2131558968));
    paramContext = fk.b("guide_qqpimsecure_tips_line1", "");
    String str = fk.b("guide_qqpimsecure_tips_line2", "");
    if (!TextUtils.isEmpty(paramContext)) {
      this.b.setText(paramContext);
    }
    if (!TextUtils.isEmpty(str)) {
      this.c.setText(str);
    }
    setOnClickListener(new bd(this));
  }
  
  public void a()
  {
    if ((getVisibility() == 0) && (a)) {
      setVisibility(8);
    }
  }
  
  public void setDownloadUrl(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GuideQQPimSecureTipsView
 * JD-Core Version:    0.7.0.1
 */