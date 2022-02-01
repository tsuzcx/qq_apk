import com.tencent.biz.qqstory.notification.StoryPushMsg;

class yna
  extends wjd
{
  yna(ymx paramymx) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new comment push: %s", new Object[] { paramStoryPushMsg });
      this.a.a(paramStoryPushMsg.d);
    }
    do
    {
      return;
      if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 18))
      {
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new like push: %s", new Object[] { paramStoryPushMsg });
        this.a.b(paramStoryPushMsg.d);
        return;
      }
      if (paramStoryPushMsg.a == 17)
      {
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete comment push: %s", new Object[] { paramStoryPushMsg });
        ((wse)wth.a(17)).a(paramStoryPushMsg.d, paramStoryPushMsg.c);
        return;
      }
    } while (paramStoryPushMsg.a != 16);
    yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete like push: %s", new Object[] { paramStoryPushMsg });
    this.a.b(paramStoryPushMsg.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yna
 * JD-Core Version:    0.7.0.1
 */