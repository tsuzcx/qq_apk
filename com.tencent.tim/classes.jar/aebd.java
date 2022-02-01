import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import mqq.app.AppRuntime;

public class aebd
{
  private aeaz mColorNoteCurd;
  
  public static void Hd(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putBoolean("color_note_recently_viewed_switch", paramBoolean).apply();
      if (!paramBoolean) {
        aeee.e(BaseApplicationImpl.getContext(), 5, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteRecentView", 0, "setRecentColorNoteSwitch: " + paramBoolean);
      }
    }
  }
  
  public static void He(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("color_recent_permission_shown", paramBoolean).apply();
    }
  }
  
  public static boolean agm()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("color_note_recently_viewed_switch", true);
    }
    return bool;
  }
  
  public static boolean agn()
  {
    SharedPreferences localSharedPreferences = k();
    if ((localSharedPreferences != null) && (!localSharedPreferences.getBoolean("color_note_recent_first_visit", false)))
    {
      localSharedPreferences.edit().putBoolean("color_note_recent_first_visit", true).apply();
      return true;
    }
    return false;
  }
  
  public static boolean ago()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("color_recent_permission_shown", false);
    }
    return bool;
  }
  
  private static SharedPreferences k()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "color_note_recent_view_switch" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 4);
  }
  
  public void a(aeaz paramaeaz)
  {
    this.mColorNoteCurd = paramaeaz;
  }
  
  public void l(ColorNote paramColorNote)
  {
    Object localObject = aebr.a();
    if ((localObject != null) && (((aebq)localObject).agp())) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (paramColorNote != null) && (this.mColorNoteCurd != null) && (aebu.a().agm()))
      {
        localObject = aebs.a(paramColorNote);
        this.mColorNoteCurd.l((ColorNote)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteRecentView", 0, "updateRecentNote: " + paramColorNote.toString());
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebd
 * JD-Core Version:    0.7.0.1
 */