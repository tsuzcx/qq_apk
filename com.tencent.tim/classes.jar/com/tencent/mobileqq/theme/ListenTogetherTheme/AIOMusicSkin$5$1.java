package com.tencent.mobileqq.theme.ListenTogetherTheme;

import aogk;
import aqsq;
import com.tencent.mobileqq.activity.ChatFragment;
import java.util.concurrent.ConcurrentHashMap;

class AIOMusicSkin$5$1
  implements Runnable
{
  AIOMusicSkin$5$1(AIOMusicSkin.5 param5, boolean paramBoolean) {}
  
  public void run()
  {
    aogk.a(this.a.this$0, this.val$isShow);
    if ((aogk.a(this.a.this$0) != null) && (aogk.a(this.a.this$0).b != null) && (aogk.a(this.a.this$0).mActivity != null))
    {
      if (this.val$isShow)
      {
        Object localObject = aqsq.a;
        localObject = ((aqsq)localObject).getDir(aogk.a(this.a.this$0).getActivity(), ((aqsq)localObject).getScid(aogk.b(this.a.this$0)));
        this.a.this$0.RP((String)localObject);
        aogk.a(this.a.this$0).put(Integer.valueOf(aogk.b(this.a.this$0)), localObject);
      }
      aogk.a(this.a.this$0, aogk.a(this.a.this$0).b);
      this.a.this$0.p(aogk.a(this.a.this$0).mContext, aogk.a(this.a.this$0).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.5.1
 * JD-Core Version:    0.7.0.1
 */