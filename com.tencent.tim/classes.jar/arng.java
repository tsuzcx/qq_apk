import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class arng
{
  public static Boolean aR;
  public static Boolean aS;
  private static Boolean aT = Boolean.valueOf(false);
  public static Integer au;
  public static String cAM = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
  public List<String> Jv = new ArrayList();
  boolean dcm = false;
  boolean dcn = false;
  int eeG = 200;
  
  static
  {
    aR = Boolean.valueOf(false);
    aS = Boolean.valueOf(false);
    au = Integer.valueOf(200);
  }
  
  public static void Q(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("sp_key_hook_switch", paramBoolean).apply();
    aR = Boolean.valueOf(paramBoolean);
    aT = Boolean.valueOf(true);
  }
  
  public static void R(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("sp_key_open_file_hook_switch", paramBoolean).apply();
    aS = Boolean.valueOf(paramBoolean);
    aT = Boolean.valueOf(true);
  }
  
  public static arng a()
  {
    return new arng();
  }
  
  public static arng a(String paramString)
  {
    try
    {
      localObject = new arng();
      paramString = new JSONObject(paramString);
      ((arng)localObject).dcm = paramString.optBoolean("switch", false);
      ((arng)localObject).dcn = paramString.optBoolean("open_file_switch", false);
      ((arng)localObject).eeG = paramString.optInt("sampling", 100);
      paramString = paramString.optJSONArray("exclude_path");
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        String str = (String)paramString.get(i);
        str = cAM + str;
        ((arng)localObject).Jv.add(str);
        i += 1;
      }
      paramString = (String)localObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        if (QLog.isColorLevel()) {
          QLog.e("ExternalDirOperationConfigProcessor", 2, paramString, new Object[0]);
        }
        paramString = null;
      }
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExternalDirOperationConfigProcessor", 2, new Object[] { localObject });
    }
    return localObject;
  }
  
  public static void aW(Context paramContext, int paramInt)
  {
    paramContext.getSharedPreferences("dt_sdk_start", 4).edit().putInt("sp_key_sampling", paramInt).apply();
    au = Integer.valueOf(paramInt);
    aT = Boolean.valueOf(true);
  }
  
  public static int bw(Context paramContext)
  {
    if (aT.booleanValue() == true)
    {
      au = Integer.valueOf(paramContext.getSharedPreferences("dt_sdk_start", 4).getInt("sp_key_sampling", 100));
      aT = Boolean.valueOf(false);
    }
    return au.intValue();
  }
  
  public static boolean co(Context paramContext)
  {
    if (aT.booleanValue() == true)
    {
      aR = Boolean.valueOf(paramContext.getSharedPreferences("dt_sdk_start", 4).getBoolean("sp_key_hook_switch", false));
      aT = Boolean.valueOf(false);
    }
    return aR.booleanValue();
  }
  
  public static boolean cp(Context paramContext)
  {
    if (aT.booleanValue() == true)
    {
      aS = Boolean.valueOf(paramContext.getSharedPreferences("dt_sdk_start", 4).getBoolean("sp_key_open_file_hook_switch", false));
      aT = Boolean.valueOf(false);
    }
    return aS.booleanValue();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ExternalDirOperationConfig={");
    localStringBuilder.append(" hookSwitch:");
    localStringBuilder.append(this.dcm);
    localStringBuilder.append(" openFileHookSwitch:");
    localStringBuilder.append(this.dcn);
    localStringBuilder.append(" sampling:");
    localStringBuilder.append(this.eeG);
    localStringBuilder.append(" excludePaths:");
    Iterator localIterator = this.Jv.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arng
 * JD-Core Version:    0.7.0.1
 */