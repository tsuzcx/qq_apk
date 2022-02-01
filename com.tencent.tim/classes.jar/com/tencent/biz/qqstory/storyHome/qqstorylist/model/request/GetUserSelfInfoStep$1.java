package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import psr;
import psx;
import qwm;
import qwy;
import qxh;
import qxh.b;
import ram;

public class GetUserSelfInfoStep$1
  implements Runnable
{
  public GetUserSelfInfoStep$1(qxh paramqxh, qxh.b paramb) {}
  
  public void run()
  {
    boolean bool = true;
    ram.b("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self info: %s", this.a);
    Object localObject = qxh.a(this.this$0).a();
    if (this.a.isVip == 1) {}
    for (;;)
    {
      ((qwm)localObject).isVip = bool;
      qxh.a(this.this$0).a().fansCount = this.a.fansCount;
      qxh.a(this.this$0).a().blJ = this.a.aPg;
      qxh.a(this.this$0).a().Bs = this.a.bot;
      qxh.a(this.this$0).a().ayX = this.a.ayX;
      qxh.a(this.this$0).a().ayY = this.a.ayY;
      qxh.a(this.this$0).a().atv = this.a.unionId;
      localObject = (psr)psx.a(10);
      ((psr)localObject).n("qqstory_my_fans_count", Integer.valueOf(this.a.fansCount));
      ((psr)localObject).n("qqstory_i_am_vip", Integer.valueOf(this.a.isVip));
      ((psr)localObject).n("qqstory_my_vidoe_count", Integer.valueOf(this.a.aPg));
      ((psr)localObject).n("qqstory_my_visiter_count", Integer.valueOf(this.a.bot));
      ((psr)localObject).n("qqstory_my_newest_video_cover", this.a.ayX);
      ((psr)localObject).n("qqstory_my_newest_video_vid", this.a.ayY);
      QQStoryContext.a().qL(this.a.unionId);
      this.this$0.completed();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1
 * JD-Core Version:    0.7.0.1
 */