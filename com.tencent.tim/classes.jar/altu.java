import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo.2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class altu
{
  public String bYn;
  public String buffer;
  public String buttonText;
  public BusinessInfoCheckUpdate.AppInfo c;
  public String content;
  public long duration;
  public int dxz;
  public String iconUrl;
  public long leftTime;
  public String link;
  public int type;
  
  public static void a(QQAppInterface paramQQAppInterface, altq.a parama)
  {
    if (parama == null) {
      label4:
      return;
    } else {
      do
      {
        do
        {
          paramQQAppInterface = (altq)paramQQAppInterface.getManager(36);
        } while (paramQQAppInterface == null);
        paramQQAppInterface = paramQQAppInterface.aj(3);
      } while (paramQQAppInterface == null);
    }
    Object localObject;
    label78:
    do
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      break label78;
      if (!paramQQAppInterface.hasNext()) {
        break label4;
      }
      localObject = b((BusinessInfoCheckUpdate.AppInfo)paramQQAppInterface.next());
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      localObject = ((List)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!parama.a((altu)((Iterator)localObject).next()));
  }
  
  public static List<altu> b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = altt.a(paramAppInfo);
    ArrayList localArrayList;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localArrayList = new ArrayList();
      try
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (JSONObject)((Map.Entry)localObject2).getValue();
          if ((str != null) && (localObject2 != null) && (((JSONObject)localObject2).has("blue_bar_stat")))
          {
            altu localaltu = new altu();
            localaltu.c = paramAppInfo;
            localaltu.dxz = ((JSONObject)localObject2).getInt("blue_bar_stat");
            localaltu.content = ((JSONObject)localObject2).getString("blue_content");
            localaltu.type = ((JSONObject)localObject2).getInt("blue_type");
            localaltu.bYn = str;
            localaltu.duration = (((JSONObject)localObject2).getLong("duration") * 1000L);
            localaltu.buffer = ((JSONObject)localObject2).getString("blue_aid");
            localaltu.link = ((JSONObject)localObject2).getString("link");
            localaltu.iconUrl = ((JSONObject)localObject2).getString("blue_icon_url");
            localaltu.buttonText = ((JSONObject)localObject2).getString("blue_button_text");
            localArrayList.add(localaltu);
            continue;
            return null;
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public static void l(Conversation paramConversation)
  {
    if ((paramConversation == null) || (paramConversation.a.fL(23) != 0)) {}
    SharedPreferences localSharedPreferences;
    MqqHandler localMqqHandler;
    do
    {
      return;
      localSharedPreferences = paramConversation.a().getSharedPreferences("mobileQQ", 0);
      localMqqHandler = paramConversation.a.b();
    } while ((localMqqHandler == null) || ((altq)paramConversation.app.getManager(36) == null));
    paramConversation = new WeakReference(paramConversation.app);
    ThreadManager.getFileThreadHandler().post(new VipBannerInfo.2(paramConversation, localSharedPreferences, localMqqHandler));
  }
  
  public static void m(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.a.fL(23) != 0))
    {
      paramConversation = paramConversation.a.b();
      if (paramConversation != null)
      {
        paramConversation.removeMessages(9);
        paramConversation.sendEmptyMessage(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altu
 * JD-Core Version:    0.7.0.1
 */