import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class qsx
  extends qbi
{
  qsx(qsw paramqsw) {}
  
  public void onFinish()
  {
    super.onFinish();
    qsw.a(this.a, null);
  }
  
  public void onSuccess(int paramInt)
  {
    super.onSuccess(paramInt);
    rar.a("home_page", "suc_share", 2, paramInt, new String[] { rar.b(qsw.a(this.a).d) + "", rar.a(qsw.a(this.a).d) + "", qsw.a(this.a).d.feedId });
  }
  
  public void vU(int paramInt)
  {
    super.vU(paramInt);
    rar.a("home_page", "share_chanel", 2, paramInt, new String[] { rar.b(qsw.a(this.a).d) + "", rar.a(qsw.a(this.a).d) + "", qsw.a(this.a).d.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsx
 * JD-Core Version:    0.7.0.1
 */