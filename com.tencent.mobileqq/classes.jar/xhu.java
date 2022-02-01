import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashMap;
import java.util.Map;

public class xhu
{
  public int a;
  public StoryVideoItem a;
  public Map<String, String> a = new HashMap();
  public final String b = "Q.qqstory.share." + getClass().getSimpleName();
  
  public final void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.a.put(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhu
 * JD-Core Version:    0.7.0.1
 */