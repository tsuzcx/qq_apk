package com.tencent.mobileqq.activity.aio.item;

import ajdq;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqsr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.PobingDecoder;
import com.tencent.mobileqq.vas.PobingDecoder.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import xqh;
import xqh.a;

public class TroopPobingItemView
  extends RelativeLayout
  implements ajdq<PobingDecoder.a>, View.OnClickListener
{
  public static final HashMap<Integer, String> gR = new TroopPobingItemView.1();
  private xqh.a b;
  private boolean bbe;
  private View rootView;
  int templateId;
  
  public TroopPobingItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopPobingItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131562196, this);
    findViewById(2131373440).setOnClickListener(this);
    findViewById(2131373434).setOnClickListener(this);
  }
  
  private void b(PobingDecoder.a parama)
  {
    Resources localResources = getContext().getResources();
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      int j = localView.getId();
      BitmapDrawable localBitmapDrawable1 = new BitmapDrawable(localResources, (Bitmap)parama.pg.get(Integer.valueOf(j)));
      switch (j)
      {
      default: 
        localView.setBackgroundDrawable(localBitmapDrawable1);
      case 2131373432: 
        for (;;)
        {
          i += 1;
          break;
          localObject = (Bitmap)parama.pg.get(Integer.valueOf(j));
          ((TextView)localView).setTextColor(parama.textColor);
          ((TextView)localView).setMaxWidth(localBitmapDrawable1.getIntrinsicWidth());
          localView.setBackgroundDrawable(aqsr.a(getResources(), (Bitmap)localObject));
        }
      case 2131373431: 
        localView.setBackgroundDrawable(localBitmapDrawable1);
        if (this.bbe) {}
        for (j = 8;; j = 0)
        {
          localView.setVisibility(j);
          break;
        }
      }
      Object localObject = new StateListDrawable();
      BitmapDrawable localBitmapDrawable2 = new BitmapDrawable(localResources, (Bitmap)parama.pg.get(Integer.valueOf(j)));
      localBitmapDrawable2.setColorFilter(0, PorterDuff.Mode.CLEAR);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localBitmapDrawable1);
      ((StateListDrawable)localObject).addState(new int[] { 0 }, localBitmapDrawable2);
      localView.setBackgroundDrawable((Drawable)localObject);
      if (this.bbe) {}
      for (j = 8;; j = 0)
      {
        localView.setVisibility(j);
        ((TextView)localView).setTextColor(parama.textColor);
        break;
      }
    }
    xqh.B(this.rootView, true);
    anot.a(null, "dc00898", "", "", "qq_vip", "0X800A4F6", 0, 0, "", "", "", "");
  }
  
  static String cG(int paramInt)
  {
    return "pobing.bitmap.cache." + paramInt;
  }
  
  public void a(View paramView, xqh.a parama)
  {
    this.rootView = paramView;
    this.b = parama;
  }
  
  public void a(PobingDecoder.a parama)
  {
    BaseApplicationImpl.sImageCache.put(cG(parama.id), parama);
    if (parama.id == this.templateId) {
      b(parama);
    }
  }
  
  public void aP(int paramInt, boolean paramBoolean)
  {
    this.bbe = paramBoolean;
    this.templateId = paramInt;
    PobingDecoder.a locala = (PobingDecoder.a)BaseApplicationImpl.sImageCache.get(cG(paramInt));
    if (locala != null)
    {
      b(locala);
      return;
    }
    new PobingDecoder(paramInt, gR, this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b != null) {
        this.b.fx(this);
      }
      anot.a(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 2, 0, "", "", "", "");
      continue;
      Context localContext = getContext();
      String str = QzoneConfig.getInstance().getConfig("qqsetting", "addgroupvasjumpurl", "https://m.vip.qq.com/freedom/newbird.html?_cwv=1&_wv=553648133&g_ch=aio");
      Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localContext.startActivity(localIntent);
      anot.a(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 3, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemView
 * JD-Core Version:    0.7.0.1
 */