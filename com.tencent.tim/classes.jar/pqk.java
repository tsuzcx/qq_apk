import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;

class pqk
  extends pqh.d
{
  pqk(pqj parampqj) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    this.b.notifyDataSetChanged();
    if (paramBoolean) {
      this.b.a(true, paramCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqk
 * JD-Core Version:    0.7.0.1
 */