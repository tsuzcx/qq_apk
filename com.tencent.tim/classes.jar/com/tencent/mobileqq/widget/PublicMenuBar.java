package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import arhu;
import com.tencent.biz.ui.CustomMenuBar;
import jqn;
import soo;

public class PublicMenuBar
  extends CustomMenuBar
{
  public PublicMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View a(soo paramsoo, int paramInt)
  {
    String str = paramsoo.getTitle();
    Drawable localDrawable = paramsoo.getIcon();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(paramInt, null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131371298);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131371289);
    TextView localTextView = (TextView)localView.findViewById(2131371301);
    if ((localImageView1 != null) && (paramsoo.hF() > 0))
    {
      localImageView1.setVisibility(0);
      if (localDrawable == null) {
        break label199;
      }
      localImageView2.setImageDrawable(localDrawable);
      label93:
      if (str == null) {
        break label219;
      }
      if (jqn.aC(str) <= 10) {
        break label209;
      }
      localTextView.setText(jqn.c(str, 10, "..."));
    }
    for (;;)
    {
      localView.setOnClickListener(new arhu(this, paramsoo.eo(), paramsoo.hF()));
      localView.setFocusable(true);
      localView.setClickable(true);
      paramsoo = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      paramsoo.gravity = 17;
      localView.setLayoutParams(paramsoo);
      this.cp.addView(localView);
      return localView;
      if (localImageView1 == null) {
        break;
      }
      localImageView1.setVisibility(8);
      break;
      label199:
      localImageView2.setVisibility(8);
      break label93;
      label209:
      localTextView.setText(str);
      continue;
      label219:
      localTextView.setVisibility(8);
    }
  }
  
  public void setSwitchButtonVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.oA.setVisibility(0);
      return;
    }
    this.oA.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PublicMenuBar
 * JD-Core Version:    0.7.0.1
 */