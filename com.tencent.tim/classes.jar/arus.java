import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class arus
{
  protected static Map<Integer, List<BaseInterface>> oL = new HashMap();
  
  public static void a(List<BaseInterface> paramList, WebView paramWebView, String paramString, aiim paramaiim)
  {
    if (!arwx.isEmpty(paramString))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseInterface localBaseInterface = (BaseInterface)localIterator.next();
        paramaiim.a(localBaseInterface, localBaseInterface.getInterfaceName());
        arum.pP.put(localBaseInterface.getInterfaceName(), localBaseInterface.getClass());
        localBaseInterface.setCurrentUrl(paramString);
      }
    }
    oL.put(Integer.valueOf(paramWebView.hashCode()), paramList);
  }
  
  public static void c(WebView paramWebView, String paramString)
  {
    try
    {
      int i = paramWebView.hashCode();
      paramWebView = ((List)oL.get(Integer.valueOf(i))).iterator();
      while (paramWebView.hasNext())
      {
        BaseInterface localBaseInterface = (BaseInterface)paramWebView.next();
        if (localBaseInterface != null) {
          localBaseInterface.setCurrentUrl(paramString);
        }
      }
      return;
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
    }
  }
  
  public static void h(WebView paramWebView)
  {
    int i;
    try
    {
      i = paramWebView.hashCode();
      paramWebView = (List)oL.get(Integer.valueOf(i));
      if (paramWebView == null) {
        return;
      }
      Iterator localIterator = paramWebView.iterator();
      while (localIterator.hasNext()) {
        ((BaseInterface)localIterator.next()).destroy();
      }
      paramWebView.clear();
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
      return;
    }
    oL.remove(Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arus
 * JD-Core Version:    0.7.0.1
 */