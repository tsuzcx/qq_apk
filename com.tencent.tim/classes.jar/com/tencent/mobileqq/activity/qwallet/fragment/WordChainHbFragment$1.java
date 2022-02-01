package com.tencent.mobileqq.activity.qwallet.fragment;

import aabf;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import rpq;

public class WordChainHbFragment$1
  implements Runnable
{
  WordChainHbFragment$1(WordChainHbFragment paramWordChainHbFragment) {}
  
  public void run()
  {
    if ((WordChainHbFragment.a(this.this$0) != null) && (WordChainHbFragment.a(this.this$0).size() > 0) && (WordChainHbFragment.a(this.this$0) != null))
    {
      Iterator localIterator = WordChainHbFragment.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        WordChainHbFragment.b localb = (WordChainHbFragment.b)localIterator.next();
        TextView localTextView = new TextView(this.this$0.mActivity);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.leftMargin = rpq.dip2px(this.this$0.mActivity, 5.0F);
        localMarginLayoutParams.rightMargin = rpq.dip2px(this.this$0.mActivity, 5.0F);
        localMarginLayoutParams.bottomMargin = rpq.dip2px(this.this$0.mActivity, 10.0F);
        WordChainHbFragment.a(this.this$0).addView(localTextView, localMarginLayoutParams);
        localTextView.setText(localb.name);
        localTextView.setPadding(rpq.dip2px(this.this$0.mActivity, 16.0F), rpq.dip2px(this.this$0.mActivity, 5.0F), rpq.dip2px(this.this$0.mActivity, 16.0F), rpq.dip2px(this.this$0.mActivity, 5.0F));
        localTextView.setTextColor(Color.parseColor("#03081A"));
        localTextView.setTag(localb);
        localTextView.setBackgroundDrawable(this.this$0.getResources().getDrawable(2130848161));
        localTextView.setOnClickListener(new aabf(this, localTextView, localb));
      }
      WordChainHbFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.1
 * JD-Core Version:    0.7.0.1
 */