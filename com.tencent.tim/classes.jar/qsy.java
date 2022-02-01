import com.tencent.biz.qqstory.storyHome.model.FeedItem;

class qsy
  extends qbi
{
  qsy(qsw paramqsw, FeedItem paramFeedItem) {}
  
  public void onFinish()
  {
    super.onFinish();
    qsw.a(this.jdField_a_of_type_Qsw, null);
  }
  
  public void onSuccess(int paramInt)
  {
    super.onSuccess(paramInt);
    rar.a("home_page", "suc_share", 2, paramInt, new String[] { rar.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem) + "", rar.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem) + "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsy
 * JD-Core Version:    0.7.0.1
 */