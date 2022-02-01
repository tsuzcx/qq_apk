package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import pmi;
import pqs;
import psm;
import qmo;
import qvf;

public class BottomVideoInfoWidget$3
  implements Runnable
{
  public BottomVideoInfoWidget$3(qmo paramqmo, boolean paramBoolean, LikeEntry paramLikeEntry, VideoListFeedItem paramVideoListFeedItem) {}
  
  public void run()
  {
    if (this.ajX) {
      qmo.a(this.this$0).b(this.a);
    }
    for (;;)
    {
      qmo.a(this.this$0).a(this.d);
      pqs localpqs = new pqs(1, this.d.feedId, 3, this.d);
      pmi.a().dispatch(localpqs);
      return;
      qmo.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */