package com.tencent.mobileqq.adapter;

import abdv;
import abdv.a;
import android.view.View;

public class BaseWhatASmoothAdapter$1
  implements Runnable
{
  public BaseWhatASmoothAdapter$1(abdv paramabdv, View paramView, Object paramObject1, Object paramObject2, int paramInt, abdv.a parama) {}
  
  public void run()
  {
    Object localObject = this.Az.getTag();
    if ((this.val$result != null) && (this.val$tag != null) && ((this.val$tag.equals(localObject)) || (localObject == null)))
    {
      this.this$0.s(this.Az, this.val$result);
      this.Az.setTag(this.this$0.bft + this.val$position);
    }
    abdv.a.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter.1
 * JD-Core Version:    0.7.0.1
 */