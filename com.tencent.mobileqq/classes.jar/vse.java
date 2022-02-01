import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class vse
  extends vsv
{
  public static final String a;
  public static final String b = vpl.a("StorySvc.like_feed");
  protected vsj a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = vpl.a("StorySvc.feed_like_list_715");
  }
  
  public vse(vsj paramvsj, boolean paramBoolean)
  {
    this.jdField_a_of_type_Vsj = paramvsj;
    this.c = this.jdField_a_of_type_Vsj.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    vsx.a().a(new vsh(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new vsi());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    vsx.a().a(new vsf(this, paramString, paramBoolean), new vsg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vse
 * JD-Core Version:    0.7.0.1
 */