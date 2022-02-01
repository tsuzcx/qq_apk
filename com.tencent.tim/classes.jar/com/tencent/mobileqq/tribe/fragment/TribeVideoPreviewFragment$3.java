package com.tencent.mobileqq.tribe.fragment;

import acfp;
import com.tencent.mobileqq.widget.QQToast;

class TribeVideoPreviewFragment$3
  implements Runnable
{
  TribeVideoPreviewFragment$3(TribeVideoPreviewFragment paramTribeVideoPreviewFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.cOi)
    {
      QQToast.a(this.this$0.getActivity(), 2, acfp.m(2131715455), 0).show();
      return;
    }
    QQToast.a(this.this$0.getActivity(), 1, acfp.m(2131715476), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */