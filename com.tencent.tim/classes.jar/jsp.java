import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class jsp
  extends Observable
  implements Manager
{
  public static final int aCT;
  public static boolean abw;
  public String Uj = "";
  private String Uk;
  protected aprb.a a = new jsq(this);
  public int aCU = -1;
  public int aCV = -100;
  public boolean abu;
  public boolean abv = true;
  public char b = '0';
  HashMap<String, jsp.a> cT = new HashMap();
  Map<String, Long> jdField_do = new HashMap();
  QQAppInterface mApp;
  SharedPreferences sp = null;
  
  static
  {
    if (qwv.KG()) {}
    for (int i = 3050;; i = 6282)
    {
      aCT = i;
      return;
    }
  }
  
  public jsp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.sp = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.getCurrentAccountUin(), 0);
    azi();
  }
  
  private void azj() {}
  
  public jsp.a a(String paramString, long paramLong)
  {
    jsp.a locala2 = (jsp.a)this.cT.get(paramString + paramLong);
    jsp.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new jsp.a();
      locala1.uin = paramString;
      locala1.time = paramLong;
      this.cT.put(locala1.getKey(), locala1);
    }
    return locala1;
  }
  
  public void a(MessageForStructing paramMessageForStructing)
  {
    if (this.jdField_do.containsKey(paramMessageForStructing.frienduin))
    {
      long l = ((Long)this.jdField_do.get(paramMessageForStructing.frienduin)).longValue();
      if (paramMessageForStructing.time > l)
      {
        this.jdField_do.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
        this.sp.edit().putLong("time" + paramMessageForStructing.frienduin, paramMessageForStructing.time).commit();
      }
    }
    for (;;)
    {
      this.sp.edit().putLong("uid" + paramMessageForStructing.frienduin, paramMessageForStructing.msgUid).commit();
      return;
      this.jdField_do.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
      this.sp.edit().putLong("time" + paramMessageForStructing.frienduin, paramMessageForStructing.time).commit();
    }
  }
  
  public void a(Integer[] paramArrayOfInteger)
  {
    a(paramArrayOfInteger, true);
  }
  
  public void a(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = hT();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.fourTab", 2, "writeNowTabStateVal fullVal=" + (String)localObject2 + " vals:" + Arrays.toString(paramArrayOfInteger) + "     mNowTabShowState=" + this.aCU);
    }
    if ((localObject2 == null) || (((String)localObject2).length() > "00100".length()) || (paramArrayOfInteger == null) || (paramArrayOfInteger.length != 5))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.fourTab", 2, "writeNowTabStateVal valid val," + (String)localObject2 + "," + paramArrayOfInteger);
      }
      return;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).length() < "00100".length()) {
      localObject1 = (String)localObject2 + "00100".substring(((String)localObject2).length());
    }
    localObject1 = new StringBuilder((String)localObject1);
    int i = 0;
    label193:
    if (i < paramArrayOfInteger.length)
    {
      localObject2 = paramArrayOfInteger[i];
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break label193;
        if ((((Integer)localObject2).intValue() < 0) || (((Integer)localObject2).intValue() > 9))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qqstory.fourTab", 2, "writeNowTabStateVal wrong index,," + localObject2);
          return;
        }
        ((StringBuilder)localObject1).setCharAt(i, (char)(((Integer)localObject2).intValue() + 48));
      }
    }
    char c = ((StringBuilder)localObject1).charAt(2);
    if ('1' == ((StringBuilder)localObject1).charAt(0))
    {
      if ((((StringBuilder)localObject1).charAt(3) == '0') || (c == '0') || (c == '1'))
      {
        i = 0;
        label334:
        this.aCU = i;
        if (this.aCU != 0) {
          break label660;
        }
      }
      label660:
      for (bool = false;; bool = true)
      {
        this.abu = bool;
        zjq.cdv |= 0x2;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.fourTab", 2, "userChange mNowTabShowState=" + this.aCU + " result:" + localObject1 + "  plan=" + c);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.fourTab", 2, "uin:" + this.mApp.getCurrentAccountUin() + ",writeNowTabStateVal vals=" + Arrays.toString(paramArrayOfInteger) + ",mIsNowTabShow=" + this.aCU + ",isNowTabShow=" + this.abu);
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        this.Uk = ((String)localObject1);
        this.mApp.getApp().getSharedPreferences("now_tab_sp", 0).edit().putString("now_show_key" + this.mApp.getCurrentAccountUin(), (String)localObject1).apply();
        if (this.abu) {}
        localObject1 = SettingCloneUtil.readValue(this.mApp.getApplication(), this.mApp.getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
        if ((!paramBoolean) || (paramArrayOfInteger[0] == null) || (1 != paramArrayOfInteger[0].intValue()) || (((String)localObject1).charAt(0) != '0')) {
          break;
        }
        paramArrayOfInteger = new Integer[7];
        paramArrayOfInteger[0] = Integer.valueOf(1);
        this.mApp.b(paramArrayOfInteger, false);
        return;
        i = 1;
        break label334;
      }
    }
    if ((((StringBuilder)localObject1).charAt(1) == '0') || (c == '0') || (c == '1'))
    {
      i = 0;
      label692:
      this.aCU = i;
      if (this.aCU != 0) {
        break label794;
      }
    }
    label794:
    for (boolean bool = false;; bool = true)
    {
      this.abu = bool;
      if (this.abu) {
        zjq.cdv |= 0x2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.qqstory.fourTab", 2, "userNoChange mNowTabShowState=" + this.aCU + " result:" + localObject1 + "  plan=" + c);
      break;
      i = 1;
      break label692;
    }
  }
  
  public void azi()
  {
    boolean bool = false;
    this.abv = this.mApp.getApp().getSharedPreferences("now_tab_sp", 0).getBoolean("now_is_first_run_key", true);
    this.aCV = this.mApp.getApp().getSharedPreferences("now_tab_sp", 0).getInt("now_index_key", 3);
    this.Uj = this.mApp.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_name_key", "");
    if (this.aCU != -1) {}
    String str;
    do
    {
      return;
      str = hT();
      if (str != null) {
        this.b = str.charAt(2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.fourTab", 4, "initNowTabShowValue : " + str);
      }
      if ((str != null) && (str.length() <= "00100".length())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.qqstory.fourTab", 2, "isNowTabShow fullVal is null");
    return;
    Object localObject = str;
    if (str.length() < "00100".length()) {
      localObject = str + "00100".substring(str.length());
    }
    localObject = ((String)localObject).toCharArray();
    char c = localObject[2];
    int i;
    if (localObject[0] == '1') {
      if ((localObject[3] == '0') || (c == '0') || (c == '1'))
      {
        i = 0;
        label272:
        this.aCU = i;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.fourTab", 2, "uin:" + this.mApp.getCurrentAccountUin() + ",isNowTabShow mIsNowTabShow=" + this.aCU + " plan=" + c);
        }
        if (this.aCU != 0) {
          break label421;
        }
      }
    }
    for (;;)
    {
      this.abu = bool;
      if (!this.abu) {
        break;
      }
      zjq.cdv |= 0x2;
      if (!this.mApp.bJb) {
        break;
      }
      azj();
      return;
      i = 1;
      break label272;
      if ((localObject[1] == '0') || (c == '0') || (c == '1')) {}
      for (i = 0;; i = 1)
      {
        this.aCU = i;
        break;
      }
      label421:
      bool = true;
    }
  }
  
  public String hT()
  {
    if (this.Uk == null) {
      this.Uk = this.mApp.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.mApp.getCurrentAccountUin(), "00100");
    }
    return this.Uk;
  }
  
  public void onDestroy()
  {
    deleteObservers();
    this.mApp = null;
  }
  
  public boolean ym()
  {
    if (pmb.Ir())
    {
      int j = hT().charAt(2);
      if ((abw) && (this.abu)) {}
      for (int i = 1; (j != 48) && (i == 0); i = 0) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public boolean yn()
  {
    if (this.mApp == null) {}
    while (!ym()) {
      return false;
    }
    Iterator localIterator = ((altq)this.mApp.getManager(36)).fV().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
      if (localAppSetting.appid.get() == aCT) {
        return localAppSetting.setting.get();
      }
    }
    return true;
  }
  
  class a
  {
    List<String> fM = new ArrayList();
    String roomId;
    int state = -1;
    long time;
    String uin;
    
    a() {}
    
    public String getKey()
    {
      return this.uin + this.time;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsp
 * JD-Core Version:    0.7.0.1
 */