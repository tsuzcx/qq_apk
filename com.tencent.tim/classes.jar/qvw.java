import com.tencent.biz.qqstory.notification.StoryPushMsg;

class qvw
  extends pmd
{
  qvw(qvt paramqvt) {}
  
  public void b(StoryPushMsg paramStoryPushMsg)
  {
    if ((paramStoryPushMsg.type == 15) || (paramStoryPushMsg.type == 19))
    {
      ram.w("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new comment push: %s", new Object[] { paramStoryPushMsg });
      this.this$0.se(paramStoryPushMsg.mFeedId);
    }
    do
    {
      return;
      if ((paramStoryPushMsg.type == 14) || (paramStoryPushMsg.type == 18))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive new like push: %s", new Object[] { paramStoryPushMsg });
        this.this$0.sf(paramStoryPushMsg.mFeedId);
        return;
      }
      if (paramStoryPushMsg.type == 17)
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete comment push: %s", new Object[] { paramStoryPushMsg });
        ((psa)psx.a(17)).bo(paramStoryPushMsg.mFeedId, paramStoryPushMsg.blO);
        return;
      }
    } while (paramStoryPushMsg.type != 16);
    ram.w("Q.qqstory.home.data.HomeFeedPresenter", "!!!Receive delete like push: %s", new Object[] { paramStoryPushMsg });
    this.this$0.sf(paramStoryPushMsg.mFeedId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvw
 * JD-Core Version:    0.7.0.1
 */