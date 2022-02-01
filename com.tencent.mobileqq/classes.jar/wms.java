import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class wms
  extends wnj
{
  public static final String a;
  public static final String b = wjz.a("StorySvc.like_feed");
  protected wmx a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = wjz.a("StorySvc.feed_like_list_715");
  }
  
  public wms(wmx paramwmx, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wmx = paramwmx;
    this.c = this.jdField_a_of_type_Wmx.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    wnl.a().a(new wmv(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new wmw());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    wnl.a().a(new wmt(this, paramString, paramBoolean), new wmu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wms
 * JD-Core Version:    0.7.0.1
 */