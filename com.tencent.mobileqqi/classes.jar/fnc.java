import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.qphone.base.util.QLog;

public class fnc
  extends TroopObserver
{
  private fnc(UpdateTroop paramUpdateTroop) {}
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "updateTroopList:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(6);
      return;
    }
    UpdateTroop.a(this.a).a.edit().putBoolean("isTrooplistok", true).commit();
    UpdateTroop.b(this.a).a(3, true, Integer.valueOf(2));
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fnc
 * JD-Core Version:    0.7.0.1
 */