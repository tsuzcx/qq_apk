import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashMap;
import java.util.Map;

public class qdk
{
  public final String TAG = "Q.qqstory.share." + getClass().getSimpleName();
  public int blL;
  public StoryVideoItem f;
  public Map<String, String> fQ = new HashMap();
  
  public final void ct(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.fQ.put(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdk
 * JD-Core Version:    0.7.0.1
 */