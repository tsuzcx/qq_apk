package com.tencent.biz.qqstory.playvideo;

import java.util.List;
import ram;

class VideoCoverListBar$3
  implements Runnable
{
  VideoCoverListBar$3(VideoCoverListBar paramVideoCoverListBar, int paramInt) {}
  
  public void run()
  {
    this.this$0.smoothScrollToPositionFromTop(this.bml, VideoCoverListBar.a(this.this$0) + VideoCoverListBar.b(this.this$0));
    ram.b("Q.qqstory.player:VideoCoverListBar", "notify cover list changed , new index = %d , total size = %d", Integer.valueOf(this.bml), Integer.valueOf(VideoCoverListBar.a(this.this$0).size()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar.3
 * JD-Core Version:    0.7.0.1
 */