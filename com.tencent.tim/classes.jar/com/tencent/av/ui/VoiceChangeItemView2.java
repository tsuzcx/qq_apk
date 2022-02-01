package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import aqbn;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import wja;

public class VoiceChangeItemView2
  extends QavListItemBase
{
  AVListImageView c = null;
  ImageView gQ = null;
  Context mContext;
  
  public VoiceChangeItemView2(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.c paramc, QavListItemBase.a parama)
  {
    super.a(paramInt, parama);
    setId(paramInt);
    setTag(paramc);
    if (!TextUtils.isEmpty(paramc.iconurl))
    {
      parama = URLDrawable.URLDrawableOptions.obtain();
      paramInt = wja.dp2px(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131166111));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      parama.mRequestWidth = paramInt;
      parama.mRequestHeight = paramInt;
      parama.mFailedDrawable = localGradientDrawable;
      parama.mLoadingDrawable = localGradientDrawable;
      parama = URLDrawable.getDrawable(paramc.iconurl, parama);
      parama.setTag(aqbn.e(paramInt, paramInt));
      parama.setDecodeHandler(aqbn.b);
      this.c.setImageDrawable(parama);
    }
    switch (paramc.vipLevel)
    {
    default: 
      this.gQ.setVisibility(8);
    }
    for (;;)
    {
      setHighlight(paramBoolean1);
      return;
      this.gQ.setImageResource(2130843161);
      this.gQ.setVisibility(0);
      continue;
      this.gQ.setImageResource(2130843161);
      this.gQ.setVisibility(0);
      continue;
      this.gQ.setImageResource(2130843161);
      this.gQ.setVisibility(0);
    }
  }
  
  public void bX(int paramInt1, int paramInt2)
  {
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131559997, this);
    this.c = ((AVListImageView)findViewById(2131373984));
    this.gQ = ((ImageView)findViewById(2131382064));
    this.c.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void mE(int paramInt) {}
  
  public void setHighlight(boolean paramBoolean)
  {
    this.c.setHighlight(paramBoolean);
  }
  
  public void updateSize(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(2131382062);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    if ((this.c != null) && (paramInt1 < getResources().getDimensionPixelSize(2131298131)))
    {
      localObject = this.c.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = paramInt1;
      ((ViewGroup.LayoutParams)localObject).height = paramInt1;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView2
 * JD-Core Version:    0.7.0.1
 */