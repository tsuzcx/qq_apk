package com.tencent.biz.qqstory.base;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import puh;
import qgg;
import rar;

class StoryHaloManager$2$1
  implements Runnable
{
  StoryHaloManager$2$1(StoryHaloManager.2 param2, puh parampuh) {}
  
  public void run()
  {
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new MsgTabPlayInfo(this.jdField_a_of_type_Puh.unionId, 1, this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.b.qx(), "", ""), 111);
    qgg.a((Activity)this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.nY.getContext(), localOpenPlayerBuilder.b(), null);
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.b.haloState == -1) {}
    for (int i = 1;; i = 0)
    {
      rar.a("msg_tab", "circle_clk", 0, i, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager$2.b.qx() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager.2.1
 * JD-Core Version:    0.7.0.1
 */