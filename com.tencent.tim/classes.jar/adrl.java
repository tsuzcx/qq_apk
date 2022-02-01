import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.List;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class adrl
{
  private static final SimpleDateFormat A = new SimpleDateFormat("yyyyMMdd");
  public static int cJD = 5;
  public static int cJE = 3;
  public static int cJF = 1;
  public static int cJG = 3;
  public static int cJH = 3;
  public static int cJI = 10;
  public static int cJJ = 1;
  private adpi a;
  private boolean bQz;
  private BaseChatPie c;
  protected WeakReference<QQAppInterface> gj;
  
  public adrl(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    if (this.c != null) {
      this.gj = new WeakReference(this.c.app);
    }
    ArkAppCenter.setupArkEnvironment(false);
  }
  
  public static boolean a(Node paramNode, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramNode == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        String str = paramNode.getNodeName();
        NodeList localNodeList = paramNode.getChildNodes();
        JSONObject localJSONObject = new JSONObject();
        int i = 0;
        int k;
        for (int j = 0;; j = k)
        {
          if (i < localNodeList.getLength())
          {
            Node localNode = localNodeList.item(i);
            if ((localNode instanceof Element))
            {
              a(localNode, localJSONObject);
              k = 1;
            }
            else
            {
              k = j;
              if ((localNode instanceof Text))
              {
                paramJSONObject.put(str, paramNode.getFirstChild().getNodeValue());
                k = j;
              }
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            paramJSONObject.put(str, localJSONObject);
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramNode) {}
    }
  }
  
  public void R(List<adqa> paramList, int paramInt)
  {
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkRecommendController", 2, "showAppPanel.mChatPie is null");
      }
      return;
    }
    if (this.a == null) {
      this.a = new adpi(c());
    }
    this.a.bT();
    this.a.a(paramList, paramInt, null);
  }
  
  public View aR()
  {
    if (this.a != null) {
      return this.a.bT();
    }
    return null;
  }
  
  BaseChatPie c()
  {
    return this.c;
  }
  
  public void cUa()
  {
    if (this.a != null) {
      this.a.cTD();
    }
  }
  
  public void cUb()
  {
    this.bQz = true;
  }
  
  public void doOnDestroy()
  {
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
    this.c = null;
  }
  
  public void hC(int paramInt1, int paramInt2)
  {
    if (this.a != null)
    {
      if ((paramInt2 == 22) || (paramInt1 != 22)) {
        break label27;
      }
      this.a.cTD();
    }
    label27:
    while ((paramInt2 != 22) || (paramInt1 == 22)) {
      return;
    }
    this.a.cTE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrl
 * JD-Core Version:    0.7.0.1
 */