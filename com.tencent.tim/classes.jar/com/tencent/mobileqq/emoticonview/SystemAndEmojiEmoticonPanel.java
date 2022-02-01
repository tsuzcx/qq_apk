package com.tencent.mobileqq.emoticonview;

import afma;
import afmf;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class SystemAndEmojiEmoticonPanel
  extends SystemEmoticonPanel
{
  public SystemAndEmojiEmoticonPanel(Context paramContext, afmf paramafmf)
  {
    super(paramContext, paramafmf);
  }
  
  protected void a(Context paramContext, afmf paramafmf)
  {
    this.d = ((EmoticonPagerRadioGroup)this.root.findViewById(2131376602));
    this.viewPager = ((ViewPager)this.root.findViewById(2131381896));
    this.a = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    paramContext = new afma(paramContext, paramafmf, 9);
    localArrayList.add(paramContext);
    this.a.kv(localArrayList);
    this.viewPager.setAdapter(this.a);
    this.d.setViewPager(this.viewPager);
    this.d.MG(paramContext.Dh());
    this.viewPager.setCurrentItem(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */