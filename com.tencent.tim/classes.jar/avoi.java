import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class avoi
  extends avnj
{
  avoi(Context paramContext) {}
  
  public void c(@NonNull avnk paramavnk)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    paramavnk = paramavnk.f();
    boolean bool1 = bool2;
    if (paramavnk != null)
    {
      paramavnk = avoh.b("on_off", paramavnk);
      if (paramavnk == null) {
        bool1 = bool2;
      }
    }
    else
    {
      avog.Z(this.val$context, bool1);
      return;
    }
    if (((Integer)paramavnk).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avoi
 * JD-Core Version:    0.7.0.1
 */