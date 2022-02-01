package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import kjz;
import wja;

public class GameGiftsImageView
  extends FrameLayout
{
  private FrameLayout X;
  private FrameLayout Y;
  private FrameLayout Z;
  private ImageView ie;
  private ImageView jdField_if;
  private ImageView ig;
  private View rootView;
  
  public GameGiftsImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GameGiftsImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public GameGiftsImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(ViewGroup paramViewGroup, ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramViewGroup.setVisibility(0);
    kjz.a(paramImageView.getContext(), paramImageView, paramString, 0, wja.dp2px(16.0F, getResources()), -1);
  }
  
  private void init()
  {
    this.rootView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131560391, this);
    this.ie = ((ImageView)this.rootView.findViewById(2131368703));
    this.jdField_if = ((ImageView)this.rootView.findViewById(2131368704));
    this.ig = ((ImageView)this.rootView.findViewById(2131368705));
    this.X = ((FrameLayout)this.rootView.findViewById(2131365323));
    this.Y = ((FrameLayout)this.rootView.findViewById(2131365326));
    this.Z = ((FrameLayout)this.rootView.findViewById(2131365329));
  }
  
  public void setImages(ArrayList<String> paramArrayList)
  {
    int i = 0;
    if (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if (i == 0) {
        a(this.X, this.ie, str);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 1) {
          a(this.Y, this.jdField_if, str);
        } else if (i == 2) {
          a(this.Z, this.ig, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.GameGiftsImageView
 * JD-Core Version:    0.7.0.1
 */