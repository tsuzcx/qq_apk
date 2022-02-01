package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import pqw;
import psa;
import psx;
import qvf;
import qvt;
import qvt.e;

public class HomeFeedPresenter$GamePKCommentReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$GamePKCommentReceiver$1(qvt.e parame, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, pqw parampqw) {}
  
  public void run()
  {
    psa localpsa = (psa)psx.a(17);
    int i;
    if (qvt.b(this.e))
    {
      CommentEntry localCommentEntry = this.h;
      if (this.a.pbType == 0)
      {
        i = 3;
        localCommentEntry.type = i;
        localpsa.b(this.h);
      }
    }
    for (;;)
    {
      ((qvf)psx.a(11)).a(this.e);
      return;
      i = 4;
      break;
      localpsa.c(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1
 * JD-Core Version:    0.7.0.1
 */