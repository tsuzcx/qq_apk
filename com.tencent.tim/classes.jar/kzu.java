import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kzu
  implements AladdinConfigHandler
{
  private static final Set<Integer> S = new HashSet();
  private static boolean aiN = ((Boolean)awit.f("readinjjoy_feeds_card_whitelist", Boolean.valueOf(false))).booleanValue();
  
  static
  {
    initWhiteList();
  }
  
  private static void cA(int paramInt1, int paramInt2)
  {
    while (paramInt1 <= paramInt2)
    {
      S.add(Integer.valueOf(paramInt1));
      paramInt1 += 1;
    }
  }
  
  private static void initWhiteList()
  {
    cA(1, 6);
    cA(10, 11);
    cA(19, 26);
    cA(28, 32);
    cA(28, 32);
    cA(36, 40);
    cA(43, 43);
    cA(48, 48);
    cA(51, 52);
    cA(60, 60);
    cA(67, 69);
    cA(71, 72);
    cA(78, 79);
    cA(81, 81);
    cA(84, 84);
    cA(102, 102);
    cA(1001, 1004);
    cA(1001, 1004);
    cA(1008, 1008);
    cA(1019, 1020);
    cA(1023, 1027);
    cA(1029, 1037);
    cA(1038, 1042);
    cA(2001, 2006);
  }
  
  public static boolean z(ArticleInfo paramArticleInfo)
  {
    boolean bool = false;
    if (!aiN) {
      QLog.d("WhiteListBidConfigHandler", 1, "isWhiteListCardAndShow: close");
    }
    do
    {
      do
      {
        return true;
        if (paramArticleInfo == null) {
          return false;
        }
      } while (((paramArticleInfo.mChannelID != 0L) && (paramArticleInfo.mChannelID != 70L) && (!kys.dv((int)paramArticleInfo.mChannelID))) || ((paramArticleInfo instanceof AdvertisementInfo)) || (paramArticleInfo.mFeedType == 29));
      i = kxm.a(paramArticleInfo);
      if (!S.contains(Integer.valueOf(i))) {
        break;
      }
    } while (!kxm.B(paramArticleInfo));
    int i = loj.i(paramArticleInfo);
    if ((i == 1) || (i == 2)) {
      bool = true;
    }
    return bool;
    QLog.d("WhiteListBidConfigHandler", 1, "isWhiteListCardAndShow: " + i + " is not white list card: " + paramArticleInfo);
    return false;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("WhiteListBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    Map localMap = kye.i(paramString);
    Object localObject2 = localMap.keySet();
    paramString = "";
    Object localObject1 = "";
    Iterator localIterator = ((Set)localObject2).iterator();
    String str;
    boolean bool;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localObject2 = (String)localMap.get(str);
      QLog.d("WhiteListBidConfigHandler", 2, "[onReceiveConfig] key=" + str + ", value=" + (String)localObject2);
      if (TextUtils.equals(str, "kandian_feeds_card_whitelist")) {
        if (Integer.valueOf((String)localObject2).intValue() == 1)
        {
          bool = true;
          label153:
          aiN = bool;
          awit.H("readinjjoy_feeds_card_whitelist", Boolean.valueOf(bool));
        }
      }
    }
    for (;;)
    {
      break;
      bool = false;
      break label153;
      if (TextUtils.equals(str, "kandian_feeds_card_whitelist_bid"))
      {
        awit.jD("default_feeds_proteus_offline_bid", (String)localObject2);
        new npl().ot("default_feeds");
        localObject1 = localObject2;
      }
      else if (TextUtils.equals(str, "kandian_feeds_card_cdn_url"))
      {
        paramString = (String)localObject2;
        continue;
        npx.bO((String)localObject1, paramString);
        return true;
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("WhiteListBidConfigHandler", 1, "[onWipeConfig]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzu
 * JD-Core Version:    0.7.0.1
 */