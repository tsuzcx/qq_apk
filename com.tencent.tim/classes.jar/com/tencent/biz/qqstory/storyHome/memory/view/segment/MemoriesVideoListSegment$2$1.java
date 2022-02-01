package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import java.util.ArrayList;
import qgg;
import qtr;
import qul;
import qun;
import ram;
import rar;

public class MemoriesVideoListSegment$2$1
  implements Runnable
{
  public MemoriesVideoListSegment$2$1(qun paramqun, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(qul.a(this.a.this$0).mUid, (String)this.ng.get(this.val$index), this.a.val$vid, String.valueOf(qul.a(this.a.this$0).hashCode()), this.nf, qul.a(this.a.this$0).aFt, 0), StoryMemoriesFragment.dX(this.a.this$0.mSource));
    ((OpenPlayerBuilder)localObject).a(qul.a(this.a.this$0));
    ((OpenPlayerBuilder)localObject).c();
    qgg.a((Activity)qul.a(this.a.this$0), ((OpenPlayerBuilder)localObject).b(), this.a.val$view);
    if (this.d == null)
    {
      ram.w("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { qul.a(this.a.this$0).mUid });
      return;
    }
    int i = StoryMemoriesFragment.dX(this.a.this$0.mSource);
    if (this.d.isMe()) {}
    for (localObject = "1";; localObject = "2")
    {
      rar.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.a.val$vid });
      ram.d("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.a.aye, this.ng, this.a.val$vid, Integer.valueOf(this.val$index), Integer.valueOf(this.a.val$position), this.nf });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */