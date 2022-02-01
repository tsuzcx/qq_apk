import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class abuf
  extends aquy
{
  public abuf(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(aquz paramaquz)
  {
    if (paramaquz == null) {
      return;
    }
    try
    {
      ??? = paramaquz.getParams().getString("path");
      String str = paramaquz.getParams().getString("url");
      paramaquz = this.this$0.k((String)???);
      str = arwv.toMD5(str);
      synchronized (ApolloCardWindow.jc)
      {
        ApolloCardWindow.jc.put(str, paramaquz);
        return;
      }
      return;
    }
    catch (Exception paramaquz)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", paramaquz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuf
 * JD-Core Version:    0.7.0.1
 */