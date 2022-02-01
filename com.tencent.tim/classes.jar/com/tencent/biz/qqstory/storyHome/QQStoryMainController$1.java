package com.tencent.biz.qqstory.storyHome;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import pma;

class QQStoryMainController$1
  implements Runnable
{
  QQStoryMainController$1(QQStoryMainController paramQQStoryMainController) {}
  
  public void run()
  {
    ((pma)QQStoryContext.a().getBusinessHandler(98)).notifyUI(2001, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.1
 * JD-Core Version:    0.7.0.1
 */