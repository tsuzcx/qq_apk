package com.tencent.mobileqq.emoticonview;

import afmf;
import afqw;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class SystemEmoticonMiniPanel
  extends SystemEmoticonPanel
{
  public SystemEmoticonMiniPanel(Context paramContext, afmf paramafmf, boolean paramBoolean)
  {
    super(paramContext, paramafmf, paramBoolean);
  }
  
  protected void a(Context paramContext, afmf paramafmf)
  {
    this.d = ((EmoticonPagerRadioGroup)this.root.findViewById(2131376602));
    this.viewPager = ((ViewPager)this.root.findViewById(2131381896));
    this.d.setViewPager(this.viewPager);
    this.a = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new afqw(paramContext, paramafmf, 0, this.car));
    this.a.kv(localArrayList);
    this.viewPager.setAdapter(this.a);
    this.viewPager.setCurrentItem(0);
    this.d.MF(this.a.getCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonMiniPanel
 * JD-Core Version:    0.7.0.1
 */