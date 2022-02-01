package com.tencent.mobileqq.nearby;

import ajpu;
import ajpu.b;
import android.os.Handler;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import java.util.List;

public class NearbyFragmentEnterAdapter$1
  implements Runnable
{
  public NearbyFragmentEnterAdapter$1(ajpu paramajpu) {}
  
  public void run()
  {
    if (this.this$0.Dv != null)
    {
      ajpu.b localb = this.this$0.a();
      if (localb != null)
      {
        Object localObject = this.this$0;
        ((ajpu)localObject).dkn += 1;
        if (this.this$0.dkn >= this.this$0.Dv.size()) {
          this.this$0.dkn = 0;
        }
        localObject = (ilive_feeds_near_anchor.NearAnchorInfo)this.this$0.Dv.get(this.this$0.dkn);
        this.this$0.a(localb, (ilive_feeds_near_anchor.NearAnchorInfo)localObject);
      }
    }
    this.this$0.mHandler.postDelayed(this, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.1
 * JD-Core Version:    0.7.0.1
 */