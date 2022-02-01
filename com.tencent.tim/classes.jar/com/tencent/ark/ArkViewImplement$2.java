package com.tencent.ark;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class ArkViewImplement$2
  implements View.OnLayoutChangeListener
{
  ArkViewImplement$2(ArkViewImplement paramArkViewImplement) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramView != this.this$0.mArkView) || ((paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt2 == paramInt6) && (paramInt4 == paramInt8))) {
      return;
    }
    if (this.this$0.mInputCallback != null)
    {
      this.this$0.mInputCallback.onHideMenu(this.this$0.mArkView);
      this.this$0.mInputCallback.onSelectChanged(this.this$0.mArkView, 0, 0, 0, 0);
    }
    this.this$0.mIpnutNeedHide = true;
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkViewImplement.2.1(this), 800L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement.2
 * JD-Core Version:    0.7.0.1
 */