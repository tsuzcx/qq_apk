import com.tencent.biz.qqstory.notification.StoryPushMsg;

class uwt
  extends ssv
{
  uwt(uwq paramuwq) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new comment push: %s", new Object[] { paramStoryPushMsg });
      this.a.a(paramStoryPushMsg.d);
    }
    do
    {
      return;
      if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 18))
      {
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new like push: %s", new Object[] { paramStoryPushMsg });
        this.a.b(paramStoryPushMsg.d);
        return;
      }
      if (paramStoryPushMsg.a == 17)
      {
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete comment push: %s", new Object[] { paramStoryPushMsg });
        ((tbw)tcz.a(17)).a(paramStoryPushMsg.d, paramStoryPushMsg.c);
        return;
      }
    } while (paramStoryPushMsg.a != 16);
    ved.d("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete like push: %s", new Object[] { paramStoryPushMsg });
    this.a.b(paramStoryPushMsg.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwt
 * JD-Core Version:    0.7.0.1
 */