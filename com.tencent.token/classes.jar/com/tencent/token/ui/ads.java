package com.tencent.token.ui;

import android.widget.ListView;

final class ads
  implements Runnable
{
  ads(adr paramadr, int paramInt) {}
  
  public final void run()
  {
    UtilsGameLockActivity.access$300(this.b.a).requestFocusFromTouch();
    UtilsGameLockActivity.access$300(this.b.a).setSelection(this.a);
    UtilsGameLockActivity.access$300(this.b.a).requestFocus();
    UtilsGameLockActivity.access$202(this.b.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ads
 * JD-Core Version:    0.7.0.1
 */