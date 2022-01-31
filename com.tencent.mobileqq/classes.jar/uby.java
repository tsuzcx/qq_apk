import android.text.TextUtils;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow.LoadGifRunnable;
import java.util.Comparator;

public class uby
  implements Comparator<String>
{
  public uby(QCirclePolymorphicLikePopWindow.LoadGifRunnable paramLoadGifRunnable) {}
  
  public int a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.lastIndexOf("."));
      paramString2 = paramString2.substring(paramString2.lastIndexOf("/") + 1, paramString2.lastIndexOf("."));
      return Integer.valueOf(paramString1).intValue() - Integer.valueOf(paramString2).intValue();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uby
 * JD-Core Version:    0.7.0.1
 */