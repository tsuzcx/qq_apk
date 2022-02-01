import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kdg
  implements aehx<String>
{
  private String Ye = "";
  private String Yf = "";
  private String Yg = "";
  private String Yh = "";
  private String Yi = "";
  private String Yj = "";
  private int aHM;
  private int aHN;
  private int aHO;
  private int aHP;
  private int aHQ;
  private int aHR;
  private int aHS;
  private int aHT;
  private int aHU;
  private boolean adS;
  private boolean adT;
  private boolean adU;
  private boolean adV;
  private boolean adW;
  private boolean adX;
  private boolean adY;
  private boolean adZ;
  private boolean aea;
  private boolean aeb;
  private boolean aec;
  private boolean aed;
  private boolean aee;
  private boolean aef;
  private boolean aeg = true;
  private boolean aeh;
  private ArrayList<String> jZ = new ArrayList();
  private boolean oA;
  private long rL = 3000L;
  
  public static kdg a()
  {
    kdg localkdg = new kdg();
    localkdg.Ye = obt.Ye;
    localkdg.Yf = obt.Yf;
    localkdg.adT = obt.adT;
    localkdg.adU = obt.adU;
    localkdg.adS = obt.adS;
    localkdg.adV = obt.adV;
    localkdg.adW = obt.adW;
    localkdg.adX = obt.adX;
    localkdg.adY = obt.adY;
    localkdg.adZ = obt.adZ;
    localkdg.aea = obt.aea;
    localkdg.aeb = obt.aeb;
    localkdg.Yg = obt.Yg;
    localkdg.rL = obt.rL;
    localkdg.aec = obt.aec;
    localkdg.aHM = obt.aHM;
    localkdg.Yh = obt.Yh;
    localkdg.aed = obt.aed;
    localkdg.aee = obt.aee;
    localkdg.aef = obt.aef;
    localkdg.jZ = obt.jZ;
    localkdg.aHN = obt.aHN;
    localkdg.aHO = obt.aHO;
    localkdg.aHP = obt.aHP;
    localkdg.aeg = obt.aeg;
    Object localObject = obt.Yi;
    localkdg.Yi = ((String)localObject);
    localkdg.Yj = obt.Yj;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("useNewLogic")) {
          b(localkdg, (JSONObject)localObject);
        }
        if (((JSONObject)localObject).has("releaseServiceMinMem")) {
          a(localkdg, (JSONObject)localObject);
        }
      }
      return localkdg;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localkdg;
  }
  
  private kdg a(kdg paramkdg, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return this;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("service_folder_name")) {
          this.Ye = paramkdg.Ye;
        }
        if (paramString.has("service_folder_icon")) {
          this.Yf = paramkdg.Yf;
        }
        if (paramString.has("service_folder_redspots")) {
          this.adS = paramkdg.adS;
        }
        if (paramString.has("service_folder_delete")) {
          this.adT = paramkdg.adT;
        }
        if (paramString.has("ServiceFolder_RedClean_After_Enter")) {
          this.adU = paramkdg.adU;
        }
        if (paramString.has("readInJoy_feeds_preload")) {
          this.adV = paramkdg.adV;
        }
        if (paramString.has("readInJoy_feeds_preload_wifi")) {
          this.adW = paramkdg.adW;
        }
        if (paramString.has("readInJoy_feeds_preload_4G")) {
          this.adX = paramkdg.adX;
        }
        if (paramString.has("readInJoy_feeds_preload_3G")) {
          this.adY = paramkdg.adY;
        }
        if (paramString.has("readInJoy_feeds_preload_2G")) {
          this.adZ = paramkdg.adZ;
        }
        if (paramString.has("pub_account_bottom_bar")) {
          this.aea = paramkdg.aea;
        }
        if (paramString.has("readInJoy_feeds_image_preload")) {
          this.aeb = paramkdg.aeb;
        }
        if (paramString.has("kandian_feeds_fling_LToR_host")) {
          this.Yg = paramkdg.Yg;
        }
        if (paramString.has("kandian_ad_background_showtime")) {
          this.rL = paramkdg.rL;
        }
        if (paramString.has("readInJoy_ip_connect")) {
          this.aec = paramkdg.aec;
        }
        if ((paramString.has("readInJoy_ip_connect_full_report")) && (paramString.has("readInJoy_ip_connect_report_tail")))
        {
          this.aHM = paramkdg.aHM;
          this.Yh = paramkdg.Yh;
        }
        if (paramString.has("readInJoy_load_img")) {
          this.aed = paramkdg.aed;
        }
        if (paramString.has("service_account_folder_redspots_delete")) {
          this.aee = paramkdg.aee;
        }
        int i = 0;
        if (paramString.has("disable_big_data_channel"))
        {
          this.aef = paramkdg.aef;
          i = 1;
        }
        if ((i != 0) && (paramString.has("host_white_list"))) {
          this.jZ = paramkdg.jZ;
        }
        if (paramString.has("album_predown_enable")) {
          this.aHN = paramkdg.aHN;
        }
        if (paramString.has("album_predown_photo_rule")) {
          this.aHO = paramkdg.aHO;
        }
        if (paramString.has("album_predown_slide_photocounts")) {
          this.aHP = paramkdg.aHP;
        }
        if (paramString.has("preload_tool_process")) {
          this.aeg = paramkdg.aeg;
        }
        if (paramString.has("useNewLogic"))
        {
          this.Yi = paramkdg.Yi;
          this.aeh = paramkdg.aeh;
          this.aHQ = paramkdg.aHQ;
          this.aHR = paramkdg.aHR;
          this.aHS = paramkdg.aHS;
          this.aHT = paramkdg.aHT;
        }
        if (paramString.has("releaseServiceMinMem"))
        {
          this.Yj = paramkdg.Yj;
          this.aHU = paramkdg.aHU;
          return this;
        }
      }
      catch (JSONException paramkdg)
      {
        paramkdg.printStackTrace();
      }
    }
    return this;
  }
  
  public static kdg a(aeic[] paramArrayOfaeic)
  {
    Object localObject1 = new kdg();
    Object localObject2 = localObject1;
    label95:
    Object localObject3;
    if (paramArrayOfaeic != null)
    {
      localObject2 = localObject1;
      if (paramArrayOfaeic.length > 0)
      {
        int i = 0;
        String str;
        for (;;)
        {
          if (i >= paramArrayOfaeic.length) {
            break label95;
          }
          str = paramArrayOfaeic[i].content;
          try
          {
            localObject2 = ((kdg)localObject1).a((kdg)aeij.a(str, kdg.class), str);
            localObject1 = localObject2;
          }
          catch (QStorageInstantiateException localQStorageInstantiateException)
          {
            for (;;)
            {
              QLog.i("ServiceAccountFolderConfProcessor", 1, "loadConfig l :" + str, localQStorageInstantiateException);
            }
          }
          i += 1;
        }
        localObject3 = localObject1;
      }
    }
    return localObject3;
  }
  
  private static void a(kdg paramkdg, JSONObject paramJSONObject)
  {
    paramkdg.aHU = paramJSONObject.optInt("releaseServiceMinMem", 80);
  }
  
  private static void b(kdg paramkdg, JSONObject paramJSONObject)
  {
    paramkdg.aeh = paramJSONObject.optBoolean("useNewLogic", false);
    paramkdg.aHQ = paramJSONObject.optInt("minTotalMem", 1024);
    paramkdg.aHR = paramJSONObject.optInt("minAvailableMem", 100);
    paramkdg.aHS = paramJSONObject.optInt("minCpuNum", 2);
    paramkdg.aHT = paramJSONObject.optInt("minCpuFreq", 1000);
  }
  
  private void refresh(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendEmptyMessage(1009);
        }
      }
    }
  }
  
  public void aBF()
  {
    obt.Ye = this.Ye;
    obt.Yf = this.Yf;
    obt.adT = this.adT;
    obt.adU = this.adU;
    obt.adS = this.adS;
    obt.adV = this.adV;
    obt.adW = this.adW;
    obt.adX = this.adX;
    obt.adY = this.adY;
    obt.adZ = this.adZ;
    obt.aea = this.aea;
    obt.aeb = this.aeb;
    obt.Yg = this.Yg;
    obt.rL = this.rL;
    obt.aec = this.aec;
    obt.aHM = this.aHM;
    obt.Yh = this.Yh;
    obt.aed = this.aed;
    obt.aee = this.aee;
    obt.aef = this.aef;
    obt.jZ = this.jZ;
    obt.aHN = this.aHN;
    obt.aHO = this.aHO;
    obt.aHP = this.aHP;
    obt.aeg = this.aeg;
    obt.Yi = this.Yi;
    obt.Yj = this.Yj;
  }
  
  public void aBG()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      obt.az((QQAppInterface)localAppRuntime);
    }
  }
  
  public void aBH()
  {
    refresh(this.oA);
  }
  
  public void lR(String paramString)
  {
    Object localObject;
    String str;
    label48:
    label123:
    boolean bool;
    label182:
    int k;
    label237:
    label890:
    int i13;
    label296:
    label355:
    int i14;
    label414:
    label473:
    label1394:
    int i19;
    label532:
    label591:
    label983:
    label1512:
    int i;
    label650:
    label709:
    label1101:
    label1627:
    int j;
    label770:
    label831:
    int n;
    label1042:
    label1210:
    int i1;
    label1160:
    label1335:
    int i2;
    label1453:
    int i3;
    label1568:
    int i4;
    int i5;
    int i6;
    int i9;
    int i10;
    int i11;
    int i12;
    int i15;
    int i16;
    int i17;
    int i7;
    int i18;
    int i8;
    int m;
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.has("service_folder_name")) {
        break label2022;
      }
      localObject = localJSONObject.getString("service_folder_name");
      if (!localJSONObject.has("service_folder_icon")) {
        break label2029;
      }
      str = localJSONObject.getString("service_folder_icon");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {
        break label1908;
      }
      this.Ye = ((String)localObject);
      this.Yf = str;
      if (!QLog.isColorLevel()) {
        break label1913;
      }
      QLog.d("ServiceAccountFolderConfProcessor", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:" + (String)localObject + " SERVICE_ACCOUNT_FOLDER_ICON:" + str);
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      QLog.e("ServiceAccountFolderConfProcessor", 1, "handleFlashChatConfig failed", paramString);
      return;
    }
    if (localJSONObject.has("service_folder_redspots"))
    {
      this.adS = localJSONObject.getBoolean("service_folder_redspots");
      if (!QLog.isColorLevel()) {
        break label1918;
      }
      QLog.d("ServiceAccountFolderConfProcessor", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:" + this.adS);
      break label1918;
      if (localJSONObject.has("service_folder_delete"))
      {
        bool = localJSONObject.getBoolean("service_folder_delete");
        this.adT = bool;
        QLog.d("ServiceAccountFolderConfProcessor", 1, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:" + bool);
        k = 1;
        if (localJSONObject.has("ServiceFolder_RedClean_After_Enter"))
        {
          this.adU = localJSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
          if (!QLog.isColorLevel()) {
            break label1923;
          }
          QLog.d("ServiceAccountFolderConfProcessor", 2, "ServiceFolder_RedClean_After_Enter = " + this.adU);
          break label1923;
          if (localJSONObject.has("readInJoy_feeds_preload"))
          {
            this.adV = localJSONObject.getBoolean("readInJoy_feeds_preload");
            if (!QLog.isColorLevel()) {
              break label1929;
            }
            QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload:" + this.adV);
            break label1929;
            if (localJSONObject.has("readInJoy_feeds_preload_wifi"))
            {
              this.adW = localJSONObject.getBoolean("readInJoy_feeds_preload_wifi");
              if (!QLog.isColorLevel()) {
                break label1935;
              }
              QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload wifi:" + this.adW);
              break label1935;
              if (localJSONObject.has("readInJoy_feeds_preload_4G"))
              {
                this.adX = localJSONObject.getBoolean("readInJoy_feeds_preload_4G");
                if (!QLog.isColorLevel()) {
                  break label1941;
                }
                QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 4G:" + this.adX);
                break label1941;
                if (localJSONObject.has("readInJoy_feeds_preload_3G"))
                {
                  this.adY = localJSONObject.getBoolean("readInJoy_feeds_preload_3G");
                  if (!QLog.isColorLevel()) {
                    break label1947;
                  }
                  QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 3G:" + this.adY);
                  break label1947;
                  if (localJSONObject.has("readInJoy_feeds_preload_2G"))
                  {
                    this.adZ = localJSONObject.getBoolean("readInJoy_feeds_preload_2G");
                    if (!QLog.isColorLevel()) {
                      break label1953;
                    }
                    QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds preload 2G:" + this.adZ);
                    break label1953;
                    if (localJSONObject.has("pub_account_bottom_bar"))
                    {
                      this.aea = localJSONObject.getBoolean("pub_account_bottom_bar");
                      if (!QLog.isColorLevel()) {
                        break label1959;
                      }
                      QLog.d("ServiceAccountFolderConfProcessor", 2, "needPABottomBar: " + this.aea);
                      break label1959;
                      if (localJSONObject.has("readInJoy_feeds_image_preload"))
                      {
                        this.aeb = localJSONObject.getBoolean("readInJoy_feeds_image_preload");
                        if (!QLog.isColorLevel()) {
                          break label1965;
                        }
                        QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy feeds image preload" + this.aeb);
                        break label1965;
                        if (localJSONObject.has("kandian_feeds_fling_LToR_host"))
                        {
                          this.Yg = localJSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
                          if (!QLog.isColorLevel()) {
                            break label1971;
                          }
                          QLog.d("ServiceAccountFolderConfProcessor", 2, "kandian_feeds_fling_LToR_host" + this.Yg);
                          break label1971;
                          if (localJSONObject.has("kandian_ad_background_showtime"))
                          {
                            this.rL = localJSONObject.optLong("kandian_ad_background_showtime", 3000L);
                            if (!QLog.isColorLevel()) {
                              break label1977;
                            }
                            QLog.d("ServiceAccountFolderConfProcessor", 2, "kandian_ad_background_showtime" + this.rL);
                            break label1977;
                            if (localJSONObject.has("readInJoy_ip_connect"))
                            {
                              this.aec = localJSONObject.getBoolean("readInJoy_ip_connect");
                              if (!QLog.isColorLevel()) {
                                break label1983;
                              }
                              QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy_ip_connect:" + this.aec);
                              break label1983;
                              if ((localJSONObject.has("readInJoy_ip_connect_full_report")) && (localJSONObject.has("readInJoy_ip_connect_report_tail")))
                              {
                                this.aHM = localJSONObject.getInt("readInJoy_ip_connect_full_report");
                                this.Yh = localJSONObject.getString("readInJoy_ip_connect_report_tail");
                                if (!QLog.isColorLevel()) {
                                  break label1989;
                                }
                                QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoy_ip_connect_full_report:" + this.aHM + ", readInJoy_ip_connect_report_tail:" + this.Yh);
                                break label1989;
                                if (localJSONObject.has("readInJoy_load_img"))
                                {
                                  this.aed = localJSONObject.getBoolean("readInJoy_load_img");
                                  if (!QLog.isColorLevel()) {
                                    break label1995;
                                  }
                                  QLog.d("ServiceAccountFolderConfProcessor", 2, "readInJoyLoadImg:" + this.aed);
                                  break label1995;
                                  if (localJSONObject.has("service_account_folder_redspots_delete"))
                                  {
                                    this.aee = localJSONObject.getBoolean("service_account_folder_redspots_delete");
                                    if (!QLog.isColorLevel()) {
                                      break label2001;
                                    }
                                    QLog.d("ServiceAccountFolderConfProcessor", 2, "service_account_folder_redspots_delete:" + this.aee);
                                    break label2001;
                                    if (localJSONObject.has("disable_big_data_channel"))
                                    {
                                      this.aef = localJSONObject.getBoolean("disable_big_data_channel");
                                      if (!QLog.isColorLevel()) {
                                        break label2007;
                                      }
                                      QLog.d("ServiceAccountFolderConfProcessor", 2, "disable big data channel is " + this.aef);
                                      break label2007;
                                      if ((i13 != 0) && (localJSONObject.has("host_white_list")))
                                      {
                                        localObject = localJSONObject.optJSONArray("host_white_list");
                                        this.jZ = new ArrayList();
                                        this.jZ.clear();
                                        if (localObject != null)
                                        {
                                          i14 = 0;
                                          if (i14 < ((JSONArray)localObject).length())
                                          {
                                            this.jZ.add(((JSONArray)localObject).getString(i14));
                                            if (!QLog.isColorLevel()) {
                                              break label2013;
                                            }
                                            QLog.d("ServiceAccountFolderConfProcessor", 2, " big data channel white host is " + ((JSONArray)localObject).getString(i14));
                                            break label2013;
                                          }
                                        }
                                      }
                                      if (localJSONObject.has("album_predown_enable"))
                                      {
                                        this.aHN = localJSONObject.getInt("album_predown_enable");
                                        if (!QLog.isColorLevel()) {
                                          break label2036;
                                        }
                                        QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadEnable is " + this.aHN);
                                        break label2036;
                                        if (localJSONObject.has("album_predown_photo_rule"))
                                        {
                                          this.aHO = localJSONObject.getInt("album_predown_photo_rule");
                                          if (!QLog.isColorLevel()) {
                                            break label2042;
                                          }
                                          QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadCoverEnable is " + this.aHO);
                                          break label2042;
                                          if (localJSONObject.has("album_predown_slide_photocounts"))
                                          {
                                            this.aHP = localJSONObject.getInt("album_predown_slide_photocounts");
                                            if (!QLog.isColorLevel()) {
                                              break label2048;
                                            }
                                            QLog.d("ServiceAccountFolderConfProcessor", 2, "imageCollectionPreloadImageEnable is " + this.aHP);
                                            break label2048;
                                            if (localJSONObject.has("preload_tool_process"))
                                            {
                                              this.aeg = localJSONObject.getBoolean("preload_tool_process");
                                              if (!QLog.isColorLevel()) {
                                                break label2054;
                                              }
                                              QLog.d("ServiceAccountFolderConfProcessor", 2, "preload tool progress is " + this.aeg);
                                              break label2054;
                                              if (localJSONObject.has("useNewLogic"))
                                              {
                                                this.Yi = paramString;
                                                b(this, localJSONObject);
                                                if (!QLog.isColorLevel()) {
                                                  break label2060;
                                                }
                                                QLog.d("ServiceAccountFolderConfProcessor", 2, "read in joy preload tool progress config is " + paramString);
                                                break label2060;
                                                i19 = 0;
                                                if (localJSONObject.has("releaseServiceMinMem"))
                                                {
                                                  this.Yj = paramString;
                                                  a(this, localJSONObject);
                                                  if (!QLog.isColorLevel()) {
                                                    break label2066;
                                                  }
                                                  QLog.d("ServiceAccountFolderConfProcessor", 2, "release web service config is " + paramString);
                                                  break label2066;
                                                }
                                                aBF();
                                                if ((i != 0) || (j != 0) || (k != 0) || (n != 0) || (i1 != 0) || (i2 != 0) || (i3 != 0) || (i4 != 0) || (i5 != 0) || (i6 != 0) || (i9 != 0) || (i10 != 0) || (i11 != 0) || (i12 != 0) || (i13 != 0) || (i14 != 0) || (i15 != 0) || (i16 != 0) || (i17 != 0) || (i7 != 0) || (i18 != 0) || (i8 != 0) || (i19 != 0)) {
                                                  break label2072;
                                                }
                                                if (m != 0) {
                                                  break label2072;
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.oA = bool;
      return;
      bool = false;
      continue;
      i18 = 0;
      break label1568;
      i17 = 0;
      break label1512;
      i16 = 0;
      break label1453;
      i15 = 0;
      break label1394;
      i14 = 0;
      break label1335;
      i13 = 0;
      break label1160;
      i12 = 0;
      break label1101;
      i11 = 0;
      break label1042;
      i10 = 0;
      break label983;
      i9 = 0;
      break label890;
      i8 = 0;
      break label831;
      i7 = 0;
      break label770;
      i6 = 0;
      break label709;
      i5 = 0;
      break label650;
      i4 = 0;
      break label591;
      i3 = 0;
      break label532;
      i2 = 0;
      break label473;
      i1 = 0;
      break label414;
      n = 0;
      break label355;
      m = 0;
      break label296;
      k = 0;
      break label237;
      j = 0;
      break label182;
      label1908:
      i = 0;
      break label123;
      label1913:
      i = 1;
      break label123;
      label1918:
      j = 1;
      break label182;
      label1923:
      m = 1;
      break label296;
      label1929:
      n = 1;
      break label355;
      label1935:
      i1 = 1;
      break label414;
      label1941:
      i2 = 1;
      break label473;
      label1947:
      i3 = 1;
      break label532;
      label1953:
      i4 = 1;
      break label591;
      label1959:
      i5 = 1;
      break label650;
      label1965:
      i6 = 1;
      break label709;
      label1971:
      i7 = 1;
      break label770;
      label1977:
      i8 = 1;
      break label831;
      label1983:
      i9 = 1;
      break label890;
      label1989:
      i10 = 1;
      break label983;
      label1995:
      i11 = 1;
      break label1042;
      label2001:
      i12 = 1;
      break label1101;
      label2007:
      i13 = 1;
      break label1160;
      label2013:
      i14 += 1;
      break label1210;
      label2022:
      localObject = "";
      break;
      label2029:
      str = "";
      break label48;
      label2036:
      i14 = 1;
      break label1335;
      label2042:
      i15 = 1;
      break label1394;
      label2048:
      i16 = 1;
      break label1453;
      label2054:
      i17 = 1;
      break label1512;
      label2060:
      i18 = 1;
      break label1568;
      label2066:
      i19 = 1;
      break label1627;
      label2072:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdg
 * JD-Core Version:    0.7.0.1
 */