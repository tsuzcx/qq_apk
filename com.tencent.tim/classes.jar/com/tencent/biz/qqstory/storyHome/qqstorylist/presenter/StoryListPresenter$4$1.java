package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import acfp;
import android.app.Activity;
import psr;
import qxq;
import qxu;
import qxv;
import qxw;
import qxx;
import qzy;
import rar;

public class StoryListPresenter$4$1
  implements Runnable
{
  StoryListPresenter$4$1(StoryListPresenter.4 param4, String paramString) {}
  
  public void run()
  {
    if ((this.a.this$0.context != null) && (this.a.this$0.context.isFinishing())) {
      return;
    }
    this.a.this$0.jdField_a_of_type_Psr.n("key_story_has_show_rename_guide", Boolean.valueOf(true));
    this.a.this$0.jdField_a_of_type_Qzy = new qzy(this.a.this$0.context, 2131756561);
    this.a.this$0.jdField_a_of_type_Qzy.a(this.aze).b(true).a(true).c(acfp.m(2131714898)).d(acfp.m(2131714862)).b(new qxv(this)).e("立即拍摄").a(new qxu(this));
    this.a.this$0.jdField_a_of_type_Qzy.c(new qxw(this));
    this.a.this$0.jdField_a_of_type_Qzy.setCanceledOnTouchOutside(false);
    this.a.this$0.jdField_a_of_type_Qzy.setCancelable(false);
    this.a.this$0.jdField_a_of_type_Qzy.setOnDismissListener(new qxx(this));
    this.a.this$0.jdField_a_of_type_Qzy.show();
    rar.a("home_page", "exp_up", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4.1
 * JD-Core Version:    0.7.0.1
 */