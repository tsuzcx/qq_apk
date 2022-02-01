import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aheq
  implements Manager
{
  private String aWF = "";
  private String bKh = acfp.m(2131713936);
  private String bKi = acfp.m(2131713937);
  private boolean bXa;
  private int cZL = 0;
  private int cZM = 0;
  private boolean cgw;
  private boolean cgx;
  private ArrayList<Integer> wO = new ArrayList();
  
  public aheq(QQAppInterface paramQQAppInterface)
  {
    this.wO.clear();
    this.cgw = aqmj.aP(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static aheq a(QQAppInterface paramQQAppInterface)
  {
    return (aheq)paramQQAppInterface.getManager(286);
  }
  
  private void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = paramSharedPreferences.getString(paramString + "_" + "rich_text_chat_config_content", "");
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 2, "get content from sp:" + paramSharedPreferences);
    }
    if (!TextUtils.isEmpty(paramSharedPreferences)) {
      mL(paramSharedPreferences);
    }
  }
  
  private static ArrayList ag(ArrayList<Integer> paramArrayList)
  {
    Object localObject = new LinkedHashSet();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LinkedHashSet)localObject).add(Integer.valueOf(((Integer)localIterator.next()).intValue()));
    }
    paramArrayList.clear();
    localObject = ((LinkedHashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayList.add(((Iterator)localObject).next());
    }
    return paramArrayList;
  }
  
  private void cW(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.wO.contains(Integer.valueOf(2));
    QLog.d("RichTextChatManager", 2, "updateHiBoomSwith: enable=" + bool);
    paramQQAppInterface = (ahxs)paramQQAppInterface.getManager(219);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.KF(bool);
    }
  }
  
  private boolean mL(String paramString)
  {
    label241:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.cZL = paramString.optInt("first_insatll_entry", 0);
        if ((this.cZL < 0) || (this.cZL >= 6)) {
          this.cZL = 0;
        }
        Object localObject1 = new ArrayList();
        Object localObject2 = paramString.optJSONArray("enrty_orders");
        int i;
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            int j = ((JSONArray)localObject2).getInt(i);
            if ((j < 0) || (j >= 6)) {
              break label241;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(j));
            break label241;
          }
        }
        this.wO.clear();
        this.wO.addAll((Collection)localObject1);
        ag(this.wO);
        localObject1 = paramString.optString("zhitu_title");
        localObject2 = paramString.optString("zhitu_legal_wording");
        if (paramString.optInt("zhitu_legal_switch") == 1)
        {
          bool = true;
          this.cgx = bool;
          this.cZM = paramString.optInt("zhitu_style", 0);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            this.bKh = ((String)localObject1);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.bKi = ((String)localObject2);
          }
          this.bXa = true;
          return true;
        }
        boolean bool = false;
        continue;
        i += 1;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RichTextChatManager", 2, paramString, new Object[0]);
        }
        this.bXa = true;
        return false;
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList)
  {
    int j = aqmj.bt(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 2, "last Memoried Tab:" + j);
    }
    int i;
    if (j == -1) {
      if (!aqmj.aO(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
      {
        i = paramArrayList.indexOf(Integer.valueOf(d(paramQQAppInterface)));
        aqmj.z(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), true);
        if (QLog.isColorLevel()) {
          QLog.d("RichTextChatManager", 2, "Accourding to : selectedTab:" + j);
        }
        if (i == -1) {}
      }
    }
    do
    {
      return i;
      return 0;
      return 0;
      j = paramArrayList.indexOf(Integer.valueOf(j));
      if (QLog.isColorLevel()) {
        QLog.d("RichTextChatManager", 2, "Accourding to orderlist, currentTabPosition:" + j);
      }
      i = j;
    } while (-1 != j);
    return 0;
  }
  
  public ArrayList<Integer> a(AppRuntime paramAppRuntime)
  {
    h(paramAppRuntime);
    return this.wO;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Integer paramInteger, ConfigurationService.Config paramConfig)
  {
    int i = 0;
    int k = paramConfig.version.get();
    int j = aqmj.br(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = aqmj.bs(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int n = AppSetting.getAppId();
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 1, String.format("received richTextChat remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n) }));
    }
    if (m != n) {
      aqmj.aD(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), n);
    }
    for (;;)
    {
      if (k != i)
      {
        paramInteger = aevk.a(paramConfig, i, paramInteger.intValue());
        if (QLog.isColorLevel()) {
          QLog.d("RichTextChatManager", 1, "content:" + paramInteger);
        }
        if (TextUtils.isEmpty(paramInteger)) {
          break label218;
        }
        if (!mL(paramInteger)) {
          break label202;
        }
        aqmj.i(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), k, paramInteger);
        cW(paramQQAppInterface);
      }
      label202:
      label218:
      while (!QLog.isColorLevel())
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("RichTextChatManager", 1, "config content parse error , do nothing");
        return;
      }
      QLog.d("RichTextChatManager", 1, "config content is null , do nothing");
      return;
      i = j;
    }
  }
  
  public boolean aO(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a(paramQQAppInterface).a(paramQQAppInterface);
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    FlashChatManager localFlashChatManager = (FlashChatManager)paramQQAppInterface.getManager(217);
    localObject = ((ArrayList)localObject).iterator();
    int k = 0;
    if (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      if (i == 1) {
        if (localFlashChatManager.cS().size() > 0)
        {
          i = 1;
          label83:
          k = i | k;
        }
      }
    }
    for (;;)
    {
      break;
      int j = 0;
      break label83;
      if (j == 2)
      {
        ahxs.a(paramQQAppInterface);
        k = ahxs.aos() | k;
      }
      else if (j == 0)
      {
        k |= 0x1;
      }
      else if (j == 3)
      {
        k = 1;
      }
      else if (j == 4)
      {
        k = 1;
      }
      else if (j == 5)
      {
        k = 1;
        continue;
        return k;
      }
    }
  }
  
  public boolean aP(QQAppInterface paramQQAppInterface)
  {
    return (aO(paramQQAppInterface)) && (this.cgw);
  }
  
  public boolean anc()
  {
    return this.cgw;
  }
  
  public boolean and()
  {
    return this.cgx;
  }
  
  public int d(AppRuntime paramAppRuntime)
  {
    h(paramAppRuntime);
    return this.cZL;
  }
  
  public void h(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!this.bXa) || (!this.aWF.equals(str)))
      {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApplication());
        if (localSharedPreferences.contains(str + "_" + "rich_text_chat_config_version"))
        {
          a(localSharedPreferences, str);
          if ((paramAppRuntime instanceof QQAppInterface)) {
            cW((QQAppInterface)paramAppRuntime);
          }
        }
        this.aWF = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RichTextChatManager", 2, "first install entry:" + this.cZL + " mOder:" + this.wO);
    }
  }
  
  public boolean j(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime);
    boolean bool2;
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.iterator();
      boolean bool1 = false;
      bool2 = bool1;
      if (!paramAppRuntime.hasNext()) {
        break label50;
      }
      if (((Integer)paramAppRuntime.next()).intValue() != 0) {
        break label52;
      }
      bool1 = true;
    }
    label50:
    label52:
    for (;;)
    {
      break;
      bool2 = false;
      return bool2;
    }
  }
  
  public void onDestroy() {}
  
  public int wQ()
  {
    return this.cZM;
  }
  
  public String wg()
  {
    return this.bKh;
  }
  
  public String wh()
  {
    return this.bKi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aheq
 * JD-Core Version:    0.7.0.1
 */