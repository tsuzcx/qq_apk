package com.tencent.mobileqq.troop.widget;

import android.util.Pair;
import android.widget.ImageView;
import apuy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import java.util.HashMap;
import java.util.Queue;
import mqq.os.MqqHandler;

public class HotChatPostItemView$1$1
  implements Runnable
{
  public HotChatPostItemView$1$1(apuy paramapuy) {}
  
  public void run()
  {
    if (((this.this$0.val$imageView.getTag() instanceof String)) && (!((String)this.this$0.val$imageView.getTag()).endsWith(this.this$0.val$imageUrl))) {
      return;
    }
    try
    {
      Pair localPair1 = NearbyImgLoader.a().a(null, HotChatPostItemView.b(this.this$0.g), 1);
      ThreadManager.getUIHandler().post(new HotChatPostItemView.1.1.1(this, localPair1));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        HotChatPostItemView.L.clear();
        HotChatPostItemView.oI.clear();
        Pair localPair2 = NearbyImgLoader.a().a(null, HotChatPostItemView.b(this.this$0.g), 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView.1.1
 * JD-Core Version:    0.7.0.1
 */