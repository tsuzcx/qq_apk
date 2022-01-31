import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class utg
  extends utx
{
  public static final String a;
  public static final String b = uqn.a("StorySvc.like_feed");
  protected utl a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = uqn.a("StorySvc.feed_like_list_715");
  }
  
  public utg(utl paramutl, boolean paramBoolean)
  {
    this.jdField_a_of_type_Utl = paramutl;
    this.c = this.jdField_a_of_type_Utl.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    utz.a().a(new utj(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new utk());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    utz.a().a(new uth(this, paramString, paramBoolean), new uti(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     utg
 * JD-Core Version:    0.7.0.1
 */