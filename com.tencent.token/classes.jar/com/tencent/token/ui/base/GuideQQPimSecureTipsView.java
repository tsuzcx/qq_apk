package com.tencent.token.ui.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.i;
import com.tencent.token.utils.a;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;

public class GuideQQPimSecureTipsView
  extends RelativeLayout
{
  public static boolean a = false;
  TextView b;
  TextView c;
  ImageView d;
  
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
    this.b = ((TextView)findViewById(2131558968));
    this.c = ((TextView)findViewById(2131558969));
    this.d = ((ImageView)findViewById(2131558967));
  }
  
  public void a()
  {
    if ((getVisibility() == 0) && (a)) {}
  }
  
  public void a(final String paramString1, String paramString2, String paramString3, String paramString4, final ArrayList<String> paramArrayList, final boolean paramBoolean)
  {
    this.b.setText(paramString2);
    this.c.setText(paramString3);
    if (!TextUtils.isEmpty(paramString4)) {
      new a(this.d).execute(new String[] { paramString4 });
    }
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        i.a().a(GuideQQPimSecureTipsView.this.getContext(), paramString1, paramArrayList);
        GuideQQPimSecureTipsView.this.setVisibility(8);
        GuideQQPimSecureTipsView.a = true;
        if (paramBoolean)
        {
          TMSDKContext.SaveStringData(1150166, paramString1);
          return;
        }
        TMSDKContext.SaveStringData(1150164, paramString1);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GuideQQPimSecureTipsView
 * JD-Core Version:    0.7.0.1
 */