import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class wgz
  extends whq
{
  public static final String a;
  public static final String b = weg.a("StorySvc.like_feed");
  protected whe a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = weg.a("StorySvc.feed_like_list_715");
  }
  
  public wgz(whe paramwhe, boolean paramBoolean)
  {
    this.jdField_a_of_type_Whe = paramwhe;
    this.c = this.jdField_a_of_type_Whe.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    whs.a().a(new whc(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new whd());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    whs.a().a(new wha(this, paramString, paramBoolean), new whb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgz
 * JD-Core Version:    0.7.0.1
 */