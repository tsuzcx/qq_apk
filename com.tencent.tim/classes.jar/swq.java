import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager.IAdapter;

public class swq
  implements SharedPreferencesProxyManager.IAdapter
{
  public swq(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public SharedPreferences getSystemSharedPreferences(String paramString, int paramInt)
  {
    return this.this$0.getSystemSharedPreferences(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swq
 * JD-Core Version:    0.7.0.1
 */