package com.tencent.mobileqq.search.fragment;

import android.text.TextUtils;

class BaseSearchFragment$2$1
  implements Runnable
{
  BaseSearchFragment$2$1(BaseSearchFragment.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.isDetached()) {}
    do
    {
      return;
      this.a.this$0.hideLoading();
    } while ((TextUtils.isEmpty(this.a.this$0.keyword)) && (!this.a.cDz));
    this.a.this$0.Id(this.a.this$0.keyword);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.BaseSearchFragment.2.1
 * JD-Core Version:    0.7.0.1
 */