import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.activity.Leba;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class asq
  implements SearchProtocol.SearchObserver
{
  public asq(Leba paramLeba) {}
  
  public void a(int paramInt, SearchProtocol.WordItem paramWordItem)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramWordItem.a)))
    {
      Leba.a(this.a).setHint(paramWordItem.a);
      Leba.a(this.a).setTag(paramWordItem.b);
    }
  }
  
  public void a(int paramInt, ArrayList paramArrayList) {}
  
  public void a(int paramInt, List paramList) {}
  
  public void a(int paramInt, JSONArray paramJSONArray) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asq
 * JD-Core Version:    0.7.0.1
 */