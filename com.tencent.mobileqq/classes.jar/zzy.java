import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mfsdk.MagnifierSDK;

public class zzy
{
  public static int a;
  private static long a;
  public static SparseArray<zzz> a;
  
  static
  {
    jdField_a_of_type_Long = Math.round((float)(System.currentTimeMillis() / 86400000L));
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(18);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new zzz(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new zzz(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, new zzz(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, new zzz(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, new zzz(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(9, new zzz(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new zzz(0L, 0));
  }
  
  public static void a()
  {
    long l;
    if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      l = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_start_date", 0L);
    }
    int[] arrayOfInt;
    int j;
    int i;
    int k;
    for (;;)
    {
      if ((jdField_a_of_type_Long - l > 0L) && (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null))
      {
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("last_start_date", jdField_a_of_type_Long);
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_today_reported", 0);
        arrayOfInt = zzq.jdField_a_of_type_ArrayOfInt;
        j = arrayOfInt.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            k = arrayOfInt[i];
            MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_plugin_" + String.valueOf(k), 0);
            jdField_a_of_type_AndroidUtilSparseArray.put(k, new zzz(0L, 0));
            i += 1;
            continue;
            l = jdField_a_of_type_Long;
            break;
          }
        }
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      }
    }
    for (;;)
    {
      return;
      if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        jdField_a_of_type_Int = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("count_today_reported", 0);
        if (jdField_a_of_type_Int >= zzq.jdField_a_of_type_Int) {
          break;
        }
        arrayOfInt = zzq.jdField_a_of_type_ArrayOfInt;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          k = arrayOfInt[i];
          int m = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("count_plugin_" + String.valueOf(k), 0);
          jdField_a_of_type_AndroidUtilSparseArray.put(k, new zzz(0L, m));
          i += 1;
        }
      }
    }
  }
  
  public static void a(int paramInt)
  {
    zzz localzzz = (zzz)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localzzz == null) {
      return;
    }
    localzzz.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zzy
 * JD-Core Version:    0.7.0.1
 */