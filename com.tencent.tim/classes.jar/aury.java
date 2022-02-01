import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.InflaterInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class aury
  extends accg
  implements Handler.Callback
{
  private boolean djI;
  private Handler mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private boolean mHasInit;
  private HashMap<String, aury.a> ql;
  
  public aury(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private HashMap<String, aury.a> ag()
  {
    int i = 0;
    for (;;)
    {
      HashMap localHashMap2;
      try
      {
        if (this.mHasInit) {
          break label414;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NCtr", 2, "[init]");
        }
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("config_prefile", 0);
        this.djI = localSharedPreferences.getBoolean("config_should_limit_" + this.app.getAccount(), false);
        Object localObject2 = localSharedPreferences.getString("extra_limit_uins_" + this.app.getAccount(), "");
        if (QLog.isColorLevel()) {
          QLog.d("NCtr", 2, "LimitUins:[" + ((String)localObject2).toString() + "]");
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label409;
        }
        localObject2 = ((String)localObject2).split(",");
        localHashMap2 = new HashMap();
        int j = localObject2.length;
        if (i < j)
        {
          Object localObject3 = localObject2[i];
          Object localObject4 = localSharedPreferences.getString("extra_limit_entry_" + this.mApp.getAccount() + "_" + (String)localObject3, "");
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject3 = ((String)localObject4).split(",");
            localObject4 = new aury.a(localObject3[0], Integer.valueOf(localObject3[1]).intValue(), Integer.valueOf(localObject3[2]).intValue(), Long.valueOf(localObject3[3]).longValue(), Integer.valueOf(localObject3[4]).intValue());
            localHashMap2.put(localObject3[0], localObject4);
            if (QLog.isColorLevel()) {
              QLog.d("NCtr", 2, "LimitEntry:[" + ((aury.a)localObject4).toString() + "]");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("NCtr", 2, "LimitEntry is null [" + (String)localObject3 + "]");
          }
        }
      }
      finally {}
      this.ql = localHashMap2;
      label409:
      this.mHasInit = true;
      label414:
      HashMap localHashMap1 = this.ql;
      return localHashMap1;
      i += 1;
    }
  }
  
  private void dg(Context paramContext, String paramString)
  {
    if ((this.ql != null) && (this.ql.containsKey(paramString)))
    {
      aury.a locala = (aury.a)this.ql.get(paramString);
      paramContext = paramContext.getSharedPreferences("config_prefile", 0).edit();
      paramContext.putString("extra_limit_entry_" + this.mApp.getAccount() + "_" + paramString, locala.toString());
      paramContext.apply();
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NCtr", 2, "[updateLimitEntrySP]" + paramString + " " + bool);
      }
      return;
    }
  }
  
  public static Long f()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(14, 1);
    return Long.valueOf(new Timestamp(localCalendar.getTimeInMillis()).getTime());
  }
  
  public void aV(String paramString, int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramString;
    localMessage.what = 0;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void aW(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1;
    HashMap localHashMap;
    Object localObject2;
    int m;
    boolean bool;
    int j;
    int k;
    int i;
    Object localObject3;
    label156:
    String str;
    for (;;)
    {
      try
      {
        localObject1 = ag();
        if (localObject1 != null)
        {
          localObject1 = (HashMap)((HashMap)localObject1).clone();
          localHashMap = new HashMap();
          if (QLog.isColorLevel()) {
            QLog.i("NCtr", 1, "sourceString : " + paramString);
          }
          localObject2 = XmlPullParserFactory.newInstance().newPullParser();
          ((XmlPullParser)localObject2).setInput(new StringReader(paramString));
          m = ((XmlPullParser)localObject2).getEventType();
          bool = false;
          paramString = "";
          j = 0;
          k = 0;
          i = 50;
          if (m == 1) {
            break label917;
          }
          localObject3 = ((XmlPullParser)localObject2).getName();
        }
        switch (m)
        {
        case 0: 
          this.djI = bool;
          localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("config_prefile", 0).edit();
          localObject3 = this.mApp.getAccount();
          ((SharedPreferences.Editor)localObject2).putInt("config_version_" + (String)localObject3, paramInt1);
          ((SharedPreferences.Editor)localObject2).putInt("config_appid_" + (String)localObject3, paramInt2);
          ((SharedPreferences.Editor)localObject2).apply();
          ((SharedPreferences.Editor)localObject2).putBoolean("config_should_limit_" + (String)localObject3, bool);
          if ((localObject1 == null) || (((HashMap)localObject1).size() <= 0)) {
            break label650;
          }
          localObject1 = ((HashMap)localObject1).keySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label650;
          }
          str = (String)((Iterator)localObject1).next();
          ((SharedPreferences.Editor)localObject2).remove("extra_limit_entry_" + (String)localObject3 + "_" + paramString);
          continue;
          localObject1 = null;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NCtr", 1, "parse fail", paramString);
        }
        return;
      }
      continue;
      break label920;
      if (((String)localObject3).equalsIgnoreCase("body"))
      {
        if (Integer.valueOf(((XmlPullParser)localObject2).getAttributeValue(0)).intValue() != 1) {
          break label931;
        }
        bool = true;
        break label928;
      }
      if (((String)localObject3).equalsIgnoreCase("puin"))
      {
        paramString = ((XmlPullParser)localObject2).nextText();
        break label920;
      }
      if (((String)localObject3).equalsIgnoreCase("day"))
      {
        j = Integer.valueOf(((XmlPullParser)localObject2).nextText()).intValue();
        break label920;
      }
      if (!((String)localObject3).equalsIgnoreCase("enableTimes")) {
        break label920;
      }
      k = Integer.valueOf(((XmlPullParser)localObject2).nextText()).intValue();
      break label920;
      if (!((String)localObject3).equalsIgnoreCase("entry")) {
        break label920;
      }
      if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramString)))
      {
        localObject3 = (aury.a)((HashMap)localObject1).get(paramString);
        ((HashMap)localObject1).remove(paramString);
        if ((j == ((aury.a)localObject3).esf) && (k == ((aury.a)localObject3).esg))
        {
          localHashMap.put(paramString, localObject3);
          break label937;
        }
        localHashMap.put(paramString, new aury.a(paramString, j, k, 0L, 0));
        break label937;
      }
      localHashMap.put(paramString, new aury.a(paramString, j, k, 0L, 0));
      break label937;
    }
    label650:
    label917:
    label920:
    label928:
    label931:
    label937:
    label953:
    for (;;)
    {
      m = ((XmlPullParser)localObject2).next();
      break;
      paramString = new StringBuilder();
      if (localHashMap.size() > 0)
      {
        localObject1 = localHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          aury.a locala = (aury.a)localHashMap.get(str);
          ((SharedPreferences.Editor)localObject2).putString("extra_limit_entry_" + (String)localObject3 + "_" + str, locala.toString());
          paramString.append(str).append(",");
          if (QLog.isColorLevel()) {
            QLog.d("NCtr", 2, "LimitEntry:[" + locala.toString() + "]");
          }
        }
        ((SharedPreferences.Editor)localObject2).putString("extra_limit_uins_" + (String)localObject3, paramString.substring(0, paramString.length() - 1));
        if (QLog.isColorLevel()) {
          QLog.d("NCtr", 2, "LimitUins:[" + paramString.substring(0, paramString.length() - 1) + "].mShouldLimit" + this.djI);
        }
      }
      ((SharedPreferences.Editor)localObject2).apply();
      this.ql = localHashMap;
      return;
      break label156;
      for (;;)
      {
        if (i > 0) {
          break label953;
        }
        break;
        for (;;)
        {
          break;
          bool = false;
        }
        paramString = "";
        j = 0;
        k = 0;
        i -= 1;
      }
    }
  }
  
  public boolean ax(String paramString, int paramInt)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    for (;;)
    {
      long l;
      try
      {
        if (!QLog.isColorLevel()) {
          break label523;
        }
        QLog.d("NCtr", 2, "shouldNotify uin " + paramString + " type " + paramInt);
      }
      finally {}
      Object localObject = ag();
      boolean bool2 = bool3;
      if (this.djI)
      {
        bool2 = bool3;
        if (localObject != null)
        {
          bool2 = bool3;
          if (((HashMap)localObject).containsKey(paramString))
          {
            l = f().longValue();
            localObject = (aury.a)((HashMap)localObject).get(paramString);
            if (QLog.isColorLevel()) {
              QLog.d("NCtr", 2, "todayBeginTime = " + new Date(l) + "----" + l + " ，entry.mBaseLineTime = " + new Date(((aury.a)localObject).ayW) + "----" + ((aury.a)localObject).ayW);
            }
            if (((aury.a)localObject).ayW >= 1L) {
              continue;
            }
            if (((aury.a)localObject).esg <= 0) {
              continue;
            }
            ((aury.a)localObject).ayW = l;
            ((aury.a)localObject).cPi += 1;
            paramInt = 1;
            bool2 = bool1;
            if (paramInt != 0)
            {
              localObject = Message.obtain();
              ((Message)localObject).what = 1;
              ((Message)localObject).obj = paramString;
              this.mHandler.sendMessage((Message)localObject);
              bool2 = bool1;
            }
          }
        }
      }
      if (!bool2) {
        anot.a(this.app, "dc00898", "", paramString, "0X8009995", "0X8009995", 0, 0, "" + System.currentTimeMillis(), "", "", "");
      }
      anot.a(this.app, "dc00898", "", paramString, "0X8009996", "0X8009996", 0, 0, "" + System.currentTimeMillis(), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("NCtr", 2, "uin " + paramString + " shouldNotify is " + bool2);
      }
      label416:
      return bool2;
      paramInt = 0;
      bool1 = false;
      continue;
      if ((int)((l - ((aury.a)localObject).ayW) / 86400000L) >= ((aury.a)localObject).esf)
      {
        ((aury.a)localObject).ayW = l;
        ((aury.a)localObject).cPi = 0;
        paramInt = 1;
        if ((((aury.a)localObject).esg > 0) && (((aury.a)localObject).cPi < ((aury.a)localObject).esg))
        {
          ((aury.a)localObject).cPi += 1;
          paramInt = 1;
        }
        else
        {
          bool1 = false;
        }
      }
      else
      {
        paramInt = 0;
        continue;
        label523:
        do
        {
          bool2 = true;
          break label416;
          if ((paramInt == 7200) || (paramInt == 1008)) {
            break;
          }
        } while (paramInt != 7220);
      }
    }
  }
  
  public int bM(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("config_prefile", 0).getInt("config_appid_" + paramString, 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      aW((String)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      paramMessage = (String)paramMessage.obj;
      dg(BaseApplicationImpl.getContext(), paramMessage);
    }
  }
  
  public int k(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("config_prefile", 0).getInt("config_version_" + paramString, 0);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void pf(String paramString)
  {
    int i = 0;
    Object localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("config_prefile", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("extra_limit_uins_" + paramString, "");
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).remove("config_version_" + paramString);
    ((SharedPreferences.Editor)localObject1).remove("config_appid_" + paramString);
    ((SharedPreferences.Editor)localObject1).remove("config_should_limit_" + paramString);
    ((SharedPreferences.Editor)localObject1).remove("extra_limit_uins__" + paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split(",");
      int j = localObject2.length;
      while (i < j)
      {
        String str = localObject2[i];
        ((SharedPreferences.Editor)localObject1).remove("extra_limit_entry_" + paramString + "_" + str);
        i += 1;
      }
    }
    ((SharedPreferences.Editor)localObject1).apply();
  }
  
  public byte[] v(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NCtr", 1, "inflateConfigString fail", paramArrayOfByte);
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  public class a
  {
    long ayW;
    int cPi;
    int esf;
    int esg;
    String mUin;
    
    public a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
    {
      this.mUin = paramString;
      this.esf = paramInt1;
      this.esg = paramInt2;
      this.ayW = paramLong;
      this.cPi = paramInt3;
    }
    
    public String toString()
    {
      return this.mUin + "," + this.esf + "," + this.esg + "," + this.ayW + "," + this.cPi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aury
 * JD-Core Version:    0.7.0.1
 */