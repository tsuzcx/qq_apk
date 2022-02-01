import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class amde
{
  public static void hj(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith(acbn.oM)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("src_file_path", paramString1);
      localHashMap.put("des_file_path", paramString2);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "qq_images_file_delete", true, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amde
 * JD-Core Version:    0.7.0.1
 */