import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;

public abstract interface vrv
{
  public abstract void a();
  
  public abstract void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2);
  
  public abstract void a(@NonNull wiq paramwiq, ErrorMessage paramErrorMessage);
  
  public abstract boolean a(MotionEvent paramMotionEvent);
  
  public abstract void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrv
 * JD-Core Version:    0.7.0.1
 */