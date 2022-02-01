import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class axis
{
  private static final List<Pair<String, Integer>> MI = new LinkedList();
  
  static
  {
    MI.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", Integer.valueOf(0)));
    MI.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", Integer.valueOf(4)));
    MI.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", Integer.valueOf(4)));
    MI.add(new Pair("CameraModuleSvc.GetPlayShowCatMatTree", Integer.valueOf(4)));
  }
  
  private axis()
  {
    Object localObject = axis.b.getString("key_app_version", "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!AppSetting.nT().equals(localObject)))
    {
      localObject = MI.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (4 == ((Integer)localPair.second).intValue()) {
          axis.b.remove((String)localPair.first);
        } else {
          axis.a.remove((String)localPair.first);
        }
      }
      axis.b.putString("key_app_version", AppSetting.nT());
    }
  }
  
  public static axis a()
  {
    return axis.c.b();
  }
  
  @NonNull
  public SharedPreferences G()
  {
    return axis.a.H();
  }
  
  public void aY(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2)
    {
      axis.b.putInt(paramString, paramInt1);
      return;
    }
    axis.a.putInt(paramString, paramInt1);
  }
  
  public void ai(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt)
    {
      axis.b.putString(paramString1, paramString2);
      return;
    }
    axis.a.putString(paramString1, paramString2);
  }
  
  public boolean ay(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt) {
      return axis.b.contains(paramString);
    }
    return axis.a.contains(paramString);
  }
  
  public long b(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt) {
      return axis.b.getLong(paramString, paramLong);
    }
    return axis.a.getLong(paramString, paramLong);
  }
  
  public boolean c(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt) {
      return axis.b.getBoolean(paramString, paramBoolean);
    }
    return axis.a.getBoolean(paramString, paramBoolean);
  }
  
  public void hh(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt)
    {
      axis.b.remove(paramString);
      return;
    }
    axis.a.remove(paramString);
  }
  
  public int l(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2) {
      return axis.b.getInt(paramString, paramInt1);
    }
    return axis.a.getInt(paramString, paramInt1);
  }
  
  public void n(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt)
    {
      axis.b.putBoolean(paramString, paramBoolean);
      return;
    }
    axis.a.putBoolean(paramString, paramBoolean);
  }
  
  @Nullable
  public String t(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt) {
      return axis.b.getString(paramString1, paramString2);
    }
    return axis.a.getString(paramString1, paramString2);
  }
  
  public void w(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt)
    {
      axis.b.putLong(paramString, paramLong);
      return;
    }
    axis.a.putLong(paramString, paramLong);
  }
  
  static class a
  {
    private static final SharedPreferences aj = ;
    
    static boolean contains(@NonNull String paramString)
    {
      return aj.contains(paramString);
    }
    
    static boolean getBoolean(@NonNull String paramString, boolean paramBoolean)
    {
      return aj.getBoolean(paramString, paramBoolean);
    }
    
    static int getInt(@NonNull String paramString, int paramInt)
    {
      return aj.getInt(paramString, paramInt);
    }
    
    static long getLong(@NonNull String paramString, long paramLong)
    {
      return aj.getLong(paramString, paramLong);
    }
    
    @Nullable
    static String getString(@NonNull String paramString1, String paramString2)
    {
      return aj.getString(paramString1, paramString2);
    }
    
    static void putBoolean(@NonNull String paramString, boolean paramBoolean)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.putBoolean(paramString, paramBoolean);
      localEditor.apply();
    }
    
    static void putInt(@NonNull String paramString, int paramInt)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.putInt(paramString, paramInt);
      localEditor.apply();
    }
    
    static void putLong(@NonNull String paramString, long paramLong)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.putLong(paramString, paramLong);
      localEditor.apply();
    }
    
    static void putString(@NonNull String paramString1, String paramString2)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.apply();
    }
    
    static void remove(@NonNull String paramString)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.remove(paramString);
      localEditor.apply();
    }
  }
  
  static class b
  {
    private static final SharedPreferences aj = BaseApplicationImpl.getApplication().getSharedPreferences("ae_camera_multi_process_sp", 4);
    
    static boolean contains(@NonNull String paramString)
    {
      return aj.contains(paramString);
    }
    
    static boolean getBoolean(@NonNull String paramString, boolean paramBoolean)
    {
      return aj.getBoolean(paramString, paramBoolean);
    }
    
    static int getInt(@NonNull String paramString, int paramInt)
    {
      return aj.getInt(paramString, paramInt);
    }
    
    static long getLong(@NonNull String paramString, long paramLong)
    {
      return aj.getLong(paramString, paramLong);
    }
    
    @Nullable
    static String getString(@NonNull String paramString1, String paramString2)
    {
      return aj.getString(paramString1, paramString2);
    }
    
    static void putBoolean(@NonNull String paramString, boolean paramBoolean)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.putBoolean(paramString, paramBoolean);
      localEditor.apply();
    }
    
    static void putInt(@NonNull String paramString, int paramInt)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.putInt(paramString, paramInt);
      localEditor.apply();
    }
    
    static void putLong(@NonNull String paramString, long paramLong)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.putLong(paramString, paramLong);
      localEditor.apply();
    }
    
    static void putString(@NonNull String paramString1, String paramString2)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.apply();
    }
    
    static void remove(@NonNull String paramString)
    {
      SharedPreferences.Editor localEditor = aj.edit();
      localEditor.remove(paramString);
      localEditor.apply();
    }
  }
  
  static class c
  {
    private static final axis a = new axis(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axis
 * JD-Core Version:    0.7.0.1
 */