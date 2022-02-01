import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class wqn
  extends wre
{
  public static final String a;
  public static final String b = wnu.a("StorySvc.like_feed");
  protected wqs a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = wnu.a("StorySvc.feed_like_list_715");
  }
  
  public wqn(wqs paramwqs, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wqs = paramwqs;
    this.c = this.jdField_a_of_type_Wqs.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    wrg.a().a(new wqq(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new wqr());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    wrg.a().a(new wqo(this, paramString, paramBoolean), new wqp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqn
 * JD-Core Version:    0.7.0.1
 */