import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MiniAppConfBean.1;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class aeku
{
  private boolean bUL = true;
  private boolean bUM = true;
  private boolean bUN;
  private boolean bUO;
  private boolean bUP;
  private boolean bUQ;
  private boolean bUR;
  private boolean bUS;
  private String byT = "";
  private String byU = "";
  private String byV = "";
  private String byW = "";
  private String byX = "";
  private String byY = "";
  private String byZ = "";
  private int cNH = 60;
  private ArrayList<Integer> vF = new MiniAppConfBean.1(this);
  
  public static aeku a(aeic[] paramArrayOfaeic)
  {
    aeku localaeku = new aeku();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (i < paramArrayOfaeic.length)
        {
          String str1 = paramArrayOfaeic[i].content;
          if (str1 == null) {
            break label671;
          }
          Object localObject = new JSONObject(str1);
          if (((JSONObject)localObject).has("aio_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("aio_mini_app_on", 1) != 1) {
              break label685;
            }
            bool = true;
            localaeku.bUL = bool;
          }
          if (((JSONObject)localObject).has("mini_app_local_search"))
          {
            if (((JSONObject)localObject).optInt("mini_app_local_search", 1) != 1) {
              break label691;
            }
            bool = true;
            localaeku.bUM = bool;
          }
          if (((JSONObject)localObject).has("mini_app_refresh_time")) {
            localaeku.cNH = ((JSONObject)localObject).optInt("mini_app_refresh_time", 60);
          }
          if (((JSONObject)localObject).has("popBarShowMiniAppStore"))
          {
            if (((JSONObject)localObject).optInt("popBarShowMiniAppStore", 0) != 1) {
              break label697;
            }
            bool = true;
            localaeku.bUN = bool;
          }
          if (((JSONObject)localObject).has("minigame_splash")) {
            SplashMiniGameUtil.saveConfigData(str1);
          }
          if (((JSONObject)localObject).has("mini_app_entry_auto_show"))
          {
            if (((JSONObject)localObject).optInt("mini_app_entry_auto_show", 0) != 1) {
              break label703;
            }
            bool = true;
            localaeku.bUO = bool;
          }
          if (((JSONObject)localObject).has("contact_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("contact_mini_app_on", 0) != 1) {
              break label709;
            }
            bool = true;
            localaeku.bUQ = bool;
          }
          if (((JSONObject)localObject).has("more_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("more_mini_app_on", 0) != 1) {
              break label715;
            }
            bool = true;
            localaeku.bUP = bool;
          }
          if (((JSONObject)localObject).has("group_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("group_mini_app_on", 0) != 1) {
              break label721;
            }
            bool = true;
            localaeku.bUR = bool;
          }
          if (((JSONObject)localObject).has("avatar_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("avatar_mini_app_on", 0) != 1) {
              break label727;
            }
            bool = true;
            localaeku.bUS = bool;
            if (((JSONObject)localObject).has("avatar_mini_app_url")) {
              localaeku.byT = ((JSONObject)localObject).optString("avatar_mini_app_url");
            }
          }
          if (((JSONObject)localObject).has("back_to_home_scene_list"))
          {
            if (localaeku.vF == null) {
              localaeku.vF = new ArrayList();
            }
            localaeku.vF.clear();
            String[] arrayOfString = ((JSONObject)localObject).optString("back_to_home_scene_list", "1044|1007|1008|2003").split("\\|");
            int k = arrayOfString.length;
            j = 0;
            if (j < k)
            {
              String str2 = arrayOfString[j];
              if (TextUtils.isEmpty(str2)) {
                break label678;
              }
              localaeku.vF.add(Integer.valueOf(str2));
              break label678;
            }
          }
          if (1 == ((JSONObject)localObject).optInt("enable_c2c_plus_panel", 0))
          {
            localaeku.byU = ((JSONObject)localObject).optString("url", "");
            localaeku.byV = ((JSONObject)localObject).optString("icon", "");
            localaeku.byW = ((JSONObject)localObject).optString("icon_night", "");
            localaeku.byX = ((JSONObject)localObject).optString("simple_icon", "");
            localaeku.byY = ((JSONObject)localObject).optString("simple_icon_night", "");
            localaeku.byZ = ((JSONObject)localObject).optString("name", BaseApplicationImpl.sApplication.getString(2131700628));
            localObject = BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject instanceof QQAppInterface))
            {
              localObject = (QQAppInterface)localObject;
              xry.a((QQAppInterface)localObject).a((QQAppInterface)localObject, localaeku);
            }
          }
          localStringBuilder.append("config: ").append(str1).append(",");
        }
      }
      catch (Exception paramArrayOfaeic)
      {
        QLog.d("MiniAppConfProcessor", 2, "parse, failed!");
        paramArrayOfaeic.printStackTrace();
        return null;
      }
      QLog.e("MiniAppConfProcessor", 2, "parse, content:" + localStringBuilder.toString());
      return localaeku;
      label671:
      i += 1;
      continue;
      label678:
      j += 1;
      continue;
      label685:
      boolean bool = false;
      continue;
      label691:
      bool = false;
      continue;
      label697:
      bool = false;
      continue;
      label703:
      bool = false;
      continue;
      label709:
      bool = false;
      continue;
      label715:
      bool = false;
      continue;
      label721:
      bool = false;
      continue;
      label727:
      bool = false;
    }
  }
  
  public int Cp()
  {
    return this.cNH;
  }
  
  public boolean agN()
  {
    return this.bUL;
  }
  
  public boolean agO()
  {
    return this.bUM;
  }
  
  public boolean agP()
  {
    return this.bUN;
  }
  
  public boolean agQ()
  {
    return this.bUO;
  }
  
  public boolean agR()
  {
    return this.bUQ;
  }
  
  public boolean agS()
  {
    return this.bUP;
  }
  
  public boolean agT()
  {
    return this.bUR;
  }
  
  public boolean agU()
  {
    return this.bUS;
  }
  
  public ArrayList<Integer> cQ()
  {
    return this.vF;
  }
  
  public String tl()
  {
    return this.byT;
  }
  
  public String tm()
  {
    return this.byU;
  }
  
  public String tn()
  {
    return this.byV;
  }
  
  public String to()
  {
    return this.byW;
  }
  
  public String toString()
  {
    new StringBuilder().append("miniAppEntryEnable:").append(this.bUL).append(", miniAppRefreshTime:").append(this.cNH).append(",miniAppLocalSearchEnable").append(this.bUM);
    return super.toString();
  }
  
  public String tp()
  {
    return this.byX;
  }
  
  public String tq()
  {
    return this.byY;
  }
  
  public String tr()
  {
    return this.byZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeku
 * JD-Core Version:    0.7.0.1
 */