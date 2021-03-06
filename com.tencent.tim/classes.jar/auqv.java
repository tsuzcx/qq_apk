import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils.1;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class auqv
{
  private static void VZ(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
    if (paramBoolean) {}
    for (String str = "qqsetting_auto_save_path_pic_key";; str = "qqsetting_auto_save_path_video_key")
    {
      localEditor.putStringSet(str, new HashSet());
      localEditor.commit();
      return;
    }
  }
  
  private static Set<String> a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4);
    if (paramBoolean) {}
    for (String str = "qqsetting_auto_save_path_pic_key";; str = "qqsetting_auto_save_path_video_key") {
      return aqmk.a(localSharedPreferences, str, new HashSet());
    }
  }
  
  public static void aX(boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      return;
    }
    ab(paramBoolean, Collections.singletonList(paramString));
  }
  
  public static void aY(boolean paramBoolean, String paramString)
  {
    HashSet localHashSet;
    SharedPreferences.Editor localEditor;
    if (bI(paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoSaveUtils", 2, "addAutoSavePath: isPic " + paramBoolean + ",tempPath=" + paramString);
      }
      localHashSet = new HashSet(a(paramBoolean));
      localHashSet.add(paramString);
      localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (paramString = "qqsetting_auto_save_path_pic_key";; paramString = "qqsetting_auto_save_path_video_key")
    {
      aqmk.a(localEditor, paramString, localHashSet);
      localEditor.commit();
      return;
    }
  }
  
  public static void ab(boolean paramBoolean, List<String> paramList)
  {
    if ((paramList == null) && (paramList.size() == 0)) {}
    while (!bI(paramBoolean)) {
      return;
    }
    Set localSet = a(paramBoolean);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("AutoSaveUtils", 2, "autoSaveMediaInSp: isPic " + paramBoolean + ",path=" + str);
      }
      if (localSet.contains(str)) {
        dK(str, paramBoolean);
      }
    }
    VZ(paramBoolean);
  }
  
  public static boolean bI(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (String str = "qqsetting_auto_save_pic_key";; str = "qqsetting_auto_save_video_key") {
      return localSharedPreferences.getBoolean(str + BaseApplicationImpl.getApplication().getRuntime().getAccount(), false);
    }
  }
  
  public static void cI(boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1) {}
    for (String str = "qqsetting_auto_save_pic_key";; str = "qqsetting_auto_save_video_key")
    {
      localEditor.putBoolean(str + BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramBoolean2);
      localEditor.commit();
      return;
    }
  }
  
  public static void dK(String paramString, boolean paramBoolean)
  {
    r(paramString, paramBoolean, false);
  }
  
  public static void r(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (bI(paramBoolean1))
    {
      paramString = new AutoSaveUtils.1(paramString, paramBoolean1);
      if (paramBoolean2) {
        paramString.run();
      }
    }
    else
    {
      return;
    }
    ThreadManagerV2.executeOnFileThread(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqv
 * JD-Core Version:    0.7.0.1
 */