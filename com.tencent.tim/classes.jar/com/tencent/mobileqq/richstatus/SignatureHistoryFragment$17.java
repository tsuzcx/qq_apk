package com.tencent.mobileqq.richstatus;

import android.widget.RelativeLayout;
import com.tencent.widget.XListView;

class SignatureHistoryFragment$17
  implements Runnable
{
  SignatureHistoryFragment$17(SignatureHistoryFragment paramSignatureHistoryFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.mListView.smoothScrollBy(this.dBM - (this.dBN - this.val$height), 100);
    if (this.cCC) {
      SignatureHistoryFragment.a(this.this$0).addOnLayoutChangeListener(this.this$0.mLayoutChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.17
 * JD-Core Version:    0.7.0.1
 */