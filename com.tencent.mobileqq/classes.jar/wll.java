import com.tencent.biz.qqstory.notification.StoryPushMsg;

class wll
  extends uhn
{
  wll(wli paramwli) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new comment push: %s", new Object[] { paramStoryPushMsg });
      this.a.a(paramStoryPushMsg.d);
    }
    do
    {
      return;
      if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 18))
      {
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new like push: %s", new Object[] { paramStoryPushMsg });
        this.a.b(paramStoryPushMsg.d);
        return;
      }
      if (paramStoryPushMsg.a == 17)
      {
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete comment push: %s", new Object[] { paramStoryPushMsg });
        ((uqo)urr.a(17)).a(paramStoryPushMsg.d, paramStoryPushMsg.c);
        return;
      }
    } while (paramStoryPushMsg.a != 16);
    wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete like push: %s", new Object[] { paramStoryPushMsg });
    this.a.b(paramStoryPushMsg.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wll
 * JD-Core Version:    0.7.0.1
 */