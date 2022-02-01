import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class pqr
  extends qbi
{
  pqr(pqo parampqo) {}
  
  public void onFinish()
  {
    super.onFinish();
    pqn.a(this.a.a, null);
  }
  
  public void onSuccess(int paramInt)
  {
    super.onSuccess(paramInt);
    rar.a("home_page", "suc_share", 1, paramInt, new String[] { rar.b(this.a.a.a) + "", rar.a(this.a.a.a) + "", this.a.a.a.feedId });
  }
  
  public void vU(int paramInt)
  {
    super.vU(paramInt);
    rar.a("home_page", "share_chanel", 1, paramInt, new String[] { rar.b(this.a.a.a) + "", rar.a(this.a.a.a) + "", this.a.a.a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqr
 * JD-Core Version:    0.7.0.1
 */