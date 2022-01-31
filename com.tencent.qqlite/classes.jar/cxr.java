import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.qphone.base.util.QLog;

public class cxr
  extends DiscussionObserver
{
  private cxr(UpdateDiscuss paramUpdateDiscuss) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "updateDiscussionList: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(6);
      return;
    }
    UpdateDiscuss.a(this.a).a.edit().putBoolean("isDiscussionlistok", true).commit();
    UpdateDiscuss.b(this.a).a(3, true, Integer.valueOf(3));
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cxr
 * JD-Core Version:    0.7.0.1
 */