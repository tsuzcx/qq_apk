import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.Comparator;

public class ycc
  implements Comparator<CommentEntry>
{
  public ycc(ycb paramycb) {}
  
  public int a(CommentEntry paramCommentEntry1, CommentEntry paramCommentEntry2)
  {
    if ((paramCommentEntry1.status == 0) && (paramCommentEntry2.status == 0)) {
      if (paramCommentEntry1.replyTime >= paramCommentEntry2.replyTime) {}
    }
    while ((paramCommentEntry1.status == 0) && (paramCommentEntry2.status != 0))
    {
      return -1;
      if (paramCommentEntry1.replyTime > paramCommentEntry2.replyTime) {
        return 1;
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycc
 * JD-Core Version:    0.7.0.1
 */