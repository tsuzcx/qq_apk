package com.tencent.token.ui;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import java.util.ArrayList;

final class zm
  extends PagerAdapter
{
  zm(SettingPageActivity paramSettingPageActivity) {}
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {}
  
  public final int getCount()
  {
    if (this.a.bannerlist == null) {
      return 0;
    }
    return this.a.bannerlist.size();
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.a.bannerlist == null) || (this.a.bannerlist.size() == 0)) {
      return null;
    }
    ImageView localImageView = new ImageView(RqdApplication.i());
    com.tencent.token.utils.a locala = new com.tencent.token.utils.a(localImageView);
    e.b(((com.tencent.token.core.bean.a)this.a.bannerlist.get(paramInt)).a);
    locala.execute(new String[] { ((com.tencent.token.core.bean.a)this.a.bannerlist.get(paramInt)).a });
    localImageView.setTag(Integer.valueOf(paramInt));
    localImageView.setOnClickListener(new zn(this));
    paramViewGroup.addView(localImageView);
    return localImageView;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zm
 * JD-Core Version:    0.7.0.1
 */