import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

public class zzq
{
  public static int a;
  public static SparseArray<zzr> a;
  public static boolean a;
  public static final int[] a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public static boolean i;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 101, 102, 103, 104, 105, 106, 107, 108, 109, 119, 121, 123, 124, 126, 129 };
    jdField_a_of_type_Boolean = true;
    b = true;
    c = true;
    d = true;
    e = true;
    f = true;
    g = true;
    h = true;
    i = true;
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new zzr(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new zzr(0.001F, 100, 10, 0.01F, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, new zzr(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, new zzr(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, new zzr(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(9, new zzr(0.001F, 85, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new zzr(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_Int = 100;
  }
  
  public static void a()
  {
    boolean bool2 = true;
    zzy.a();
    if (MagnifierSDK.jdField_a_of_type_Aaak != null)
    {
      SparseArray localSparseArray = MagnifierSDK.jdField_a_of_type_Aaak.a();
      if ((localSparseArray != null) && (localSparseArray.size() > 0)) {
        jdField_a_of_type_AndroidUtilSparseArray = localSparseArray;
      }
    }
    if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      int j = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_reporter_type", 0);
      if (j > 0) {
        ReporterMachine.a(j);
      }
      j = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_switch", 0);
      if (j > 0)
      {
        if ((j & 0x1) <= 0) {
          break label151;
        }
        bool1 = true;
        jdField_a_of_type_Boolean = bool1;
        if ((j & 0x2) <= 0) {
          break label156;
        }
        bool1 = true;
        label95:
        b = bool1;
        if ((j & 0x4) <= 0) {
          break label161;
        }
        bool1 = true;
        label107:
        c = bool1;
        if ((j & 0x8) <= 0) {
          break label166;
        }
        bool1 = true;
        label120:
        g = bool1;
        if ((j & 0x10) <= 0) {
          break label171;
        }
        bool1 = true;
        label133:
        h = bool1;
        if ((j & 0x20) <= 0) {
          break label176;
        }
      }
    }
    label151:
    label156:
    label161:
    label166:
    label171:
    label176:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      i = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label95;
      bool1 = false;
      break label107;
      bool1 = false;
      break label120;
      bool1 = false;
      break label133;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Config", 2, "loadLocalConfigsparseConfig obj=" + paramJSONObject + "");
    }
    if (paramJSONObject.getInt("pid") != MagnifierSDK.jdField_a_of_type_Int) {
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    label55:
    Object localObject;
    int j;
    label145:
    label159:
    label173:
    label188:
    label203:
    label250:
    int n;
    label256:
    label262:
    label268:
    label274:
    float f1;
    int k;
    float f2;
    int m;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if ("host".equals(localObject))
      {
        j = paramJSONObject.getInt((String)localObject);
        ReporterMachine.a(j);
        if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
          MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("config_reporter_type", j);
        }
      }
      else
      {
        if ("switch".equals(localObject))
        {
          j = paramJSONObject.getInt((String)localObject);
          if ((j & 0x1) > 0)
          {
            bool = true;
            jdField_a_of_type_Boolean = bool;
            if ((j & 0x2) <= 0) {
              break label250;
            }
            bool = true;
            b = bool;
            if ((j & 0x4) <= 0) {
              break label256;
            }
            bool = true;
            c = bool;
            if ((j & 0x8) <= 0) {
              break label262;
            }
            bool = true;
            g = bool;
            if ((j & 0x10) <= 0) {
              break label268;
            }
            bool = true;
            h = bool;
            if ((j & 0x20) <= 0) {
              break label274;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            i = bool;
            if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor == null) {
              break;
            }
            MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("config_switch", j);
            break;
            bool = false;
            break label145;
            bool = false;
            break label159;
            bool = false;
            break label173;
            bool = false;
            break label188;
            bool = false;
            break label203;
          }
        }
        if (((String)localObject).startsWith("p_"))
        {
          n = Integer.parseInt(((String)localObject).replace("p_", ""));
          zzr localzzr = (zzr)jdField_a_of_type_AndroidUtilSparseArray.get(n);
          f1 = localzzr.jdField_a_of_type_Float;
          j = localzzr.jdField_a_of_type_Int;
          k = localzzr.jdField_b_of_type_Int;
          f2 = localzzr.jdField_b_of_type_Float;
          m = localzzr.c;
          localObject = paramJSONObject.getString((String)localObject).split(",");
          if (localObject.length >= 5)
          {
            if (TextUtils.isEmpty(localObject[0])) {
              break label540;
            }
            f1 = Float.parseFloat(localObject[0]);
          }
        }
      }
    }
    label540:
    for (;;)
    {
      if (!TextUtils.isEmpty(localObject[1])) {
        j = Integer.parseInt(localObject[1]);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localObject[2])) {
          k = Integer.parseInt(localObject[2]);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(localObject[3])) {
            f2 = Float.parseFloat(localObject[3]);
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(localObject[4])) {
              m = Integer.parseInt(localObject[4]);
            }
            for (;;)
            {
              localObject = new zzr(f1, j, k, f2, m);
              jdField_a_of_type_AndroidUtilSparseArray.setValueAt(jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(n), localObject);
              break label55;
              if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
                MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
              }
              if (MagnifierSDK.jdField_a_of_type_Aaak == null) {
                break;
              }
              MagnifierSDK.jdField_a_of_type_Aaak.a(jdField_a_of_type_AndroidUtilSparseArray);
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zzq
 * JD-Core Version:    0.7.0.1
 */