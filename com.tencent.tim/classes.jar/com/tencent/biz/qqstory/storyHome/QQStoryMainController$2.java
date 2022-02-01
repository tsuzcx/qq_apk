package com.tencent.biz.qqstory.storyHome;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import qre;

class QQStoryMainController$2
  implements Runnable
{
  QQStoryMainController$2(QQStoryMainController paramQQStoryMainController) {}
  
  public void run()
  {
    if (QQStoryMainController.a(this.this$0)) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = this.this$0.a();
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setInputViewHideListener(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView);
    this.this$0.jdField_a_of_type_Qre.a(this.this$0.mApp, this.this$0.a(), this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView);
    QQStoryMainController.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b.l());
    QQStoryMainController.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$b.y());
    QQStoryMainController.a(this.this$0).setVisibility(8);
    QQStoryMainController.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.2
 * JD-Core Version:    0.7.0.1
 */