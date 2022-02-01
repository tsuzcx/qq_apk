package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import psa;
import psx;
import qvf;
import qvt;
import qvt.k;

public class HomeFeedPresenter$SendVidRateDataResultReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$SendVidRateDataResultReceiver$1(qvt.k paramk, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry) {}
  
  public void run()
  {
    psa localpsa = (psa)psx.a(17);
    if (qvt.b(this.e))
    {
      this.i.type = 3;
      localpsa.b(this.i);
    }
    for (;;)
    {
      ((qvf)psx.a(11)).a(this.e);
      return;
      localpsa.c(this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1
 * JD-Core Version:    0.7.0.1
 */