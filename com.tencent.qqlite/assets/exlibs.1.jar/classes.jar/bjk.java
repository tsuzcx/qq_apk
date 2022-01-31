import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import java.util.ArrayList;

public class bjk
  extends TroopObserver
{
  public bjk(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if ((paramBoolean) && (paramString.equals(SetTroopAdminsActivity.a(this.a))) && (paramInt > 0))
    {
      SetTroopAdminsActivity.a(this.a, paramInt);
      paramString = SetTroopAdminsActivity.c(this.a);
      localStringBuilder = new StringBuilder(this.a.getString(2131362840)).append("(");
      if (SetTroopAdminsActivity.a(this.a).size() <= 0) {
        break label116;
      }
    }
    label116:
    for (int i = SetTroopAdminsActivity.a(this.a).size();; i = 0)
    {
      paramString.setText(i + "/" + paramInt + ")");
      return;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.getSharedPreferences("last_update_time" + this.a.app.a(), 0).edit().putLong("key_last_update_time" + SetTroopAdminsActivity.a(this.a), System.currentTimeMillis()).commit();
      this.a.a.removeMessages(2);
      ArrayList localArrayList = this.a.a();
      this.a.a.sendMessage(this.a.a.obtainMessage(1, localArrayList));
    }
    this.a.a.sendMessage(this.a.a.obtainMessage(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjk
 * JD-Core Version:    0.7.0.1
 */