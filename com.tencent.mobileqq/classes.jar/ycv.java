import com.tencent.biz.qqstory.database.CommentEntry;

class ycv
{
  public int a;
  public CommentEntry a;
  private int b = -1;
  
  ycv(ycq paramycq)
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = null;
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.b = paramCommentEntry.commentId;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(CommentEntry paramCommentEntry)
  {
    return paramCommentEntry.commentId != this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycv
 * JD-Core Version:    0.7.0.1
 */