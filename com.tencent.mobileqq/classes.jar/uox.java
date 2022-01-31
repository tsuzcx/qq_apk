import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class uox
  extends upo
{
  public static final String a;
  public static final String b = ume.a("StorySvc.like_feed");
  protected upc a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ume.a("StorySvc.feed_like_list_715");
  }
  
  public uox(upc paramupc, boolean paramBoolean)
  {
    this.jdField_a_of_type_Upc = paramupc;
    this.c = this.jdField_a_of_type_Upc.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    upq.a().a(new upa(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new upb());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    upq.a().a(new uoy(this, paramString, paramBoolean), new uoz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uox
 * JD-Core Version:    0.7.0.1
 */