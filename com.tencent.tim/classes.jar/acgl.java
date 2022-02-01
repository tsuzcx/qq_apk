import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Xml;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

public class acgl
  implements Manager
{
  static boolean DEBUG = true;
  public boolean bHR;
  String bos;
  List<WeakReference<acgl.b>> jC = new ArrayList();
  QQAppInterface mApp;
  Comparator<acgl.c> mComparator = null;
  HashMap<String, acgl.d> mConfigs = new HashMap(1);
  
  public acgl(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  @TargetApi(11)
  private String[] J()
  {
    label126:
    do
    {
      try
      {
        localObject4 = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp());
        if (Build.VERSION.SDK_INT < 11) {
          break label126;
        }
        localObject1 = ((SharedPreferences)localObject4).getStringSet("hotchat_scene_config", new HashSet());
        if ((localObject1 == null) || (((Set)localObject1).size() <= 0)) {
          break label237;
        }
        localObject1 = (String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]);
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            Object localObject2;
            int j;
            int i;
            localObject2[i] = ((SharedPreferences)localObject4).getString("hotchat_scene_config_" + i, "");
            i += 1;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject4;
            localObject1 = localObject3;
            Object localObject3 = localThrowable2;
            continue;
          }
          localThrowable1 = localThrowable1;
          Object localObject1 = null;
          localThrowable1.printStackTrace();
          continue;
          localObject3 = Integer.valueOf(localObject1.length);
          continue;
          localObject4 = "";
          continue;
          localObject1 = null;
        }
      }
      if (QLog.isColorLevel())
      {
        if (localObject1 != null) {
          break label208;
        }
        localObject2 = "null";
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label218;
        }
        localObject4 = localObject1[0];
        ajrk.m("HotchatSCMng", new Object[] { "getConfigs", localObject2, localObject4 });
      }
      return localObject1;
      j = ((SharedPreferences)localObject4).getInt("hotchat_scene_config_count", 0);
      if (j <= 0) {
        break label237;
      }
      localObject2 = new String[j];
      i = 0;
      localObject1 = localObject2;
    } while (i >= j);
  }
  
  @TargetApi(11)
  private void k(Set<String> paramSet)
  {
    try
    {
      localEditor = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).edit();
      if (Build.VERSION.SDK_INT < 11) {
        break label73;
      }
      localEditor.putStringSet("hotchat_scene_config", paramSet);
      localEditor.commit();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SharedPreferences.Editor localEditor;
        label73:
        Iterator localIterator;
        int i;
        localThrowable.printStackTrace();
        continue;
        paramSet = Integer.valueOf(paramSet.size());
      }
    }
    if (QLog.isColorLevel())
    {
      if (paramSet == null)
      {
        paramSet = "null";
        ajrk.m("HotchatSCMng", new Object[] { "saveConfigs", paramSet });
      }
    }
    else
    {
      return;
      localEditor.putInt("hotchat_scene_config_count", paramSet.size());
      localIterator = paramSet.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.putString("hotchat_scene_config_" + i, str);
        i += 1;
      }
    }
  }
  
  public acgl.c a(String paramString, int paramInt, long paramLong)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      localObject2 = localObject1;
      if (QLog.isDevelopLevel())
      {
        ajrk.f("HotchatSCMng", "getHotchatNote", new Object[] { "id is null or empty" });
        localObject2 = localObject1;
      }
    }
    acgl.d locald;
    label267:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject2;
              locald = (acgl.d)this.mConfigs.get(paramString);
              localObject2 = localObject1;
            } while (locald == null);
            localObject2 = localObject1;
          } while (locald.tf.size() <= 0);
          if (locald.curIndex < 0)
          {
            if (this.mComparator == null) {
              this.mComparator = new acgm(this);
            }
            Collections.sort(locald.tf, this.mComparator);
            if (QLog.isDevelopLevel()) {
              ajrk.f("HotchatSCMng", "sort start", new Object[] { paramString });
            }
            i = 0;
            if (i < locald.tf.size())
            {
              localObject2 = (acgl.c)locald.tf.get(i);
              if (localObject2 == null) {}
              for (;;)
              {
                i += 1;
                break;
                if ((locald.curIndex < 0) && (paramLong <= ((acgl.c)localObject2).endtime)) {}
                for (locald.curIndex = i;; locald.curIndex = i) {
                  do
                  {
                    if (!QLog.isDevelopLevel()) {
                      break label267;
                    }
                    ajrk.f("HotchatSCMng", String.valueOf(i), new Object[] { localObject2 });
                    break;
                  } while ((paramLong > ((acgl.c)localObject2).endtime) || (!((acgl.c)localObject2).hasShow));
                }
              }
            }
            if (locald.curIndex < 0) {
              locald.curIndex = locald.tf.size();
            }
            if (QLog.isDevelopLevel()) {
              ajrk.f("HotchatSCMng", "sort end", new Object[] { paramString });
            }
            if (QLog.isDevelopLevel()) {
              ajrk.f("HotchatSCMng", "getHotchatNote", new Object[] { Integer.valueOf(locald.curIndex) });
            }
          }
          localObject2 = localObject1;
        } while (locald.curIndex < 0);
        localObject2 = localObject1;
      } while (locald.curIndex >= locald.tf.size());
      switch (paramInt)
      {
      default: 
        localObject1 = localObject3;
        localObject2 = localObject1;
      }
    } while (!QLog.isDevelopLevel());
    ajrk.f("HotchatSCMng", "getHotchatNote", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(locald.curIndex), localObject1 });
    return localObject1;
    int i = locald.curIndex;
    if (i < locald.tf.size())
    {
      localObject1 = (acgl.c)locald.tf.get(i);
      if (localObject1 == null) {}
      while ((((acgl.c)localObject1).hasShow) || (paramLong < ((acgl.c)localObject1).stime) || (paramLong > ((acgl.c)localObject1).endtime) || (!b((acgl.c)localObject1)))
      {
        i += 1;
        break;
      }
      locald.curIndex = i;
    }
    for (;;)
    {
      break;
      localObject2 = (acgl.c)locald.tf.get(locald.curIndex);
      localObject1 = localObject3;
      if (paramLong < ((acgl.c)localObject2).stime) {
        break;
      }
      localObject1 = localObject3;
      if (paramLong > ((acgl.c)localObject2).endtime) {
        break;
      }
      localObject1 = localObject3;
      if (!b((acgl.c)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      break;
      i = locald.curIndex;
      localObject1 = localObject3;
      if (i >= locald.tf.size()) {
        break;
      }
      localObject1 = (acgl.c)locald.tf.get(i);
      if (localObject1 == null) {}
      while (((acgl.c)localObject1).hasShow)
      {
        i += 1;
        break;
      }
      break;
      localObject1 = null;
    }
  }
  
  public void a(acgl.b paramb)
  {
    if (paramb == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jC)
      {
        if (this.jC.size() > 0)
        {
          Iterator localIterator = this.jC.iterator();
          if (!localIterator.hasNext()) {
            break label105;
          }
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() != paramb)) {
            continue;
          }
          i = 1;
          if (i == 0)
          {
            paramb = new WeakReference(paramb);
            this.jC.add(paramb);
          }
        }
        return;
      }
      label105:
      int i = 0;
    }
  }
  
  public boolean a(acgl.a parama, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (parama != null)
    {
      if (TextUtils.isEmpty(parama.url)) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    if (QLog.isColorLevel()) {
      ajrk.m("HotchatSCMng", new Object[] { "download", parama });
    }
    paramString = new File(paramString + "/" + parama.fileName);
    String str;
    if (paramString.exists()) {
      if (!TextUtils.isEmpty(parama.md5))
      {
        str = MD5.getFileMD5(paramString);
        bool2 = parama.md5.equals(str);
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            ajrk.m("download", new Object[] { "cache md5 confilict", str, parama.md5 });
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      label167:
      if (!bool1)
      {
        bool2 = HttpDownloadUtil.a(this.mApp, parama.url, paramString);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(parama.md5))
          {
            str = MD5.getFileMD5(paramString);
            bool2 = parama.md5.equals(str);
            bool1 = bool2;
            if (!bool2)
            {
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                ajrk.m("download", new Object[] { "md5 conflict", parama.md5, str });
                bool1 = bool2;
              }
            }
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          bool2 = bool1;
          try
          {
            if (!paramString.exists()) {
              break;
            }
            paramString.delete();
            return bool1;
          }
          catch (Exception parama)
          {
            parama.printStackTrace();
            return bool1;
          }
        }
        bool1 = true;
        break label167;
      }
      bool1 = false;
    }
  }
  
  public boolean a(ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null) {
      return false;
    }
    String str1;
    synchronized (this.mConfigs)
    {
      this.mConfigs.clear();
      str1 = rC();
      if (str1 == null) {
        return false;
      }
    }
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject3 = new File(str1);
        if (((File)localObject3).exists())
        {
          localObject4 = ((File)localObject3).list();
          if ((localObject4 != null) && (localObject4.length > 0)) {
            localObject3 = new ArrayList(localObject4.length);
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject3;
        Object localObject4;
        int j;
        int i;
        String str2;
        acgl.a locala;
        boolean bool3;
        Object localObject2;
        continue;
        if (bool2) {
          continue;
        }
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        j = localObject4.length;
        i = 0;
        localObject1 = localObject3;
        if (i < j)
        {
          localObject1 = localObject4[i];
          if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
            ((List)localObject3).add(localObject1);
          }
          i += 1;
          continue;
          localObject1 = null;
        }
        localObject3 = new HashSet();
        if (!paramConfig.content_list.has()) {
          continue;
        }
        localObject4 = paramConfig.content_list.get();
        if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
          continue;
        }
        bool1 = true;
        i = 0;
      }
      catch (Exception localException3)
      {
        localObject2 = localObject3;
        localObject3 = localException3;
        continue;
        i += 1;
        continue;
      }
      bool2 = bool1;
      if (i >= ((List)localObject4).size()) {
        continue;
      }
      str2 = (String)((List)localObject4).get(i);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 49,content: " + str2 + ",version: " + paramConfig.version.get());
      }
      if (str2 == null) {
        continue;
      }
      if (str2.length() != 0) {
        continue;
      }
      continue;
      ((Exception)localObject3).printStackTrace();
    }
    locala = acgl.a.a(str2);
    if (locala != null)
    {
      ((Set)localObject3).add(str2);
      bool3 = a(locala, str1);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject1).remove(locala.fileName);
      }
      bool2 = bool3;
      if (this.bHR)
      {
        parse(str1 + "/" + locala.fileName);
        bool2 = bool3;
        break label619;
        if (!QLog.isColorLevel()) {
          break label636;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 49,content_list is empty ,version: " + paramConfig.version.get());
        break label636;
        k((Set)localObject3);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramConfig = ((List)localObject1).iterator();
          while (paramConfig.hasNext())
          {
            localObject1 = (String)paramConfig.next();
            try
            {
              new File(str1 + "/" + (String)localObject1).delete();
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
        }
        if (QLog.isDevelopLevel()) {
          ajrk.f("HotchatSCMng", "updateHotChatSceneConfig", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(this.bHR) });
        }
        return bool2;
      }
    }
  }
  
  public void b(acgl.b paramb)
  {
    if (paramb == null) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jC)
      {
        if (this.jC.size() > 0)
        {
          i = this.jC.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)this.jC.get(i);
            if ((localWeakReference == null) || (localWeakReference.get() != paramb)) {
              break label91;
            }
            this.jC.remove(i);
            break label91;
          }
        }
        return;
      }
      label91:
      i -= 1;
    }
  }
  
  public boolean b(acgl.c paramc)
  {
    boolean bool;
    if ((paramc == null) || (TextUtils.isEmpty(paramc.url))) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        ajrk.m("HotchatSCMng", new Object[] { "checkHasGrabHbTask", paramc, Boolean.valueOf(bool) });
      }
      return bool;
      PortalManager localPortalManager = (PortalManager)this.mApp.getManager(79);
      if ((localPortalManager != null) && (localPortalManager.atf())) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void onDestroy()
  {
    this.mConfigs.clear();
  }
  
  public void parse(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("HotchatSCMng", "parse", new Object[] { paramString });
    }
    BufferedInputStream localBufferedInputStream;
    String str2;
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      try
      {
        paramString = new FileInputStream(paramString);
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        Object localObject1;
        paramString = null;
      }
      for (;;)
      {
        try
        {
          localBufferedInputStream = new BufferedInputStream(paramString);
          str2 = paramString;
          if (localBufferedInputStream == null) {
            continue;
          }
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          Object localObject2;
          boolean bool;
          Object localObject6;
          Object localObject5;
          continue;
          continue;
          if (i == 1) {
            continue;
          }
          switch (i)
          {
          }
          String str1 = paramString;
          paramString = localFileNotFoundException2;
          Object localObject3 = str1;
          break;
          str1 = paramString;
          paramString = localObject3;
          localObject3 = str1;
          break;
          str1 = paramString;
          paramString = localObject3;
          localObject3 = str1;
          break;
          str1 = paramString;
          paramString = localObject3;
          localObject3 = str1;
          break;
          str1 = "not null";
          continue;
        }
        try
        {
          localXmlPullParser = Xml.newPullParser();
          localXmlPullParser.setInput(localBufferedInputStream, "UTF-8");
          i = localXmlPullParser.getEventType();
          localObject1 = null;
          paramString = null;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          ajrk.m("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
        }
      }
      i = localXmlPullParser.next();
      Object localObject4 = paramString;
      paramString = localObject1;
      localObject1 = localObject4;
      break label913;
      localFileNotFoundException1.printStackTrace();
      localBufferedInputStream = null;
      str2 = paramString;
      continue;
      localObject4 = paramString;
      paramString = localFileNotFoundException1;
      localObject2 = localObject4;
      continue;
      localObject4 = localXmlPullParser.getName();
      if ("activity".equals(localObject4))
      {
        if (paramString == null)
        {
          localObject4 = new acgl.d();
          paramString = (String)localObject2;
          localObject2 = localObject4;
        }
        else
        {
          paramString.reset();
          localObject4 = paramString;
          paramString = (String)localObject2;
          localObject2 = localObject4;
        }
      }
      else if ("note".equals(localObject4))
      {
        localObject4 = new acgl.c();
        localObject2 = paramString;
        paramString = (String)localObject4;
      }
      else if ("activityid".equals(localObject4))
      {
        if (paramString == null) {
          break label948;
        }
        paramString.id = localXmlPullParser.nextText();
        localObject4 = paramString;
        paramString = (String)localObject2;
        localObject2 = localObject4;
      }
      else if ("stime".equals(localObject4))
      {
        localObject4 = localXmlPullParser.nextText();
        if (localObject2 == null) {
          break label948;
        }
        ((acgl.c)localObject2).stime = acgl.c.aa((String)localObject4);
        localObject4 = paramString;
        paramString = (String)localObject2;
        localObject2 = localObject4;
      }
      else
      {
        bool = "content".equals(localObject4);
        if (bool)
        {
          try
          {
            localObject6 = localXmlPullParser.nextText();
            localObject4 = localObject6;
            if (localObject6 != null) {
              localObject4 = ((String)localObject6).trim();
            }
            if (localObject2 != null) {
              ((acgl.c)localObject2).content = ((String)localObject4);
            }
            localObject4 = paramString;
            paramString = (String)localObject2;
            localObject2 = localObject4;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            if (!QLog.isColorLevel()) {
              break label961;
            }
          }
          ajrk.m("HotchatSCMng", new Object[] { "parseNotice exception", localException1.toString() });
          break label961;
        }
        else if ("endtime".equals(localException1))
        {
          localObject5 = localXmlPullParser.nextText();
          if (localObject2 == null) {
            break label948;
          }
          ((acgl.c)localObject2).endtime = acgl.c.aa((String)localObject5);
          localObject5 = paramString;
          paramString = (String)localObject2;
          localObject2 = localObject5;
        }
        else
        {
          bool = "url".equals(localObject5);
          if (!bool) {
            break label948;
          }
          try
          {
            localObject6 = localXmlPullParser.nextText();
            localObject5 = localObject6;
            if (localObject6 != null) {
              localObject5 = ((String)localObject6).trim();
            }
            if ((localObject5 == null) || (((String)localObject5).startsWith("http://")) || (((String)localObject5).contains("&"))) {
              break label910;
            }
            localObject5 = new String(Base64.decode(((String)localObject5).getBytes(), 0));
            if (localObject2 != null) {
              ((acgl.c)localObject2).url = ((String)localObject5);
            }
            localObject5 = paramString;
            paramString = (String)localObject2;
            localObject2 = localObject5;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            if (!QLog.isColorLevel()) {
              break label974;
            }
          }
          ajrk.m("HotchatSCMng", new Object[] { "parseNotice exception", localException2.toString() });
          break label974;
          if ("activity".equals(localXmlPullParser.getName()))
          {
            if ((paramString == null) || (TextUtils.isEmpty(paramString.id))) {
              break label948;
            }
            localObject6 = (acgl.d)this.mConfigs.get(paramString.id);
            if (DEBUG)
            {
              if (localObject6 != null) {
                break label1000;
              }
              str1 = "null";
              ajrk.f("HotchatSCMng", "parse", new Object[] { str1, paramString });
            }
            if (localObject6 == null)
            {
              this.mConfigs.put(paramString.id, paramString);
              paramString = null;
              break label987;
            }
            ((acgl.d)localObject6).curIndex = -1;
            ((acgl.d)localObject6).tf.addAll(paramString.tf);
            paramString.reset();
            break label987;
          }
          if ((!"note".equals(localXmlPullParser.getName())) || (localObject2 == null) || (paramString == null)) {
            break label948;
          }
          paramString.tf.add(localObject2);
          localObject2 = paramString;
          paramString = null;
        }
      }
    }
    if (localBufferedInputStream != null) {}
    try
    {
      localBufferedInputStream.close();
      if (str2 == null) {}
    }
    catch (Exception paramString)
    {
      try
      {
        do
        {
          str2.close();
          return;
          paramString = paramString;
          paramString.printStackTrace();
        } while (!QLog.isColorLevel());
        ajrk.m("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
      }
      catch (Exception paramString)
      {
        do
        {
          paramString.printStackTrace();
        } while (!QLog.isColorLevel());
        ajrk.m("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
        return;
      }
    }
  }
  
  public void qh()
  {
    if (this.bHR) {
      return;
    }
    synchronized (this.mConfigs)
    {
      if (this.bHR) {
        return;
      }
    }
    String[] arrayOfString = J();
    if (QLog.isColorLevel()) {
      if (arrayOfString != null) {
        break label103;
      }
    }
    label103:
    for (Object localObject2 = "null";; localObject2 = Integer.valueOf(arrayOfString.length))
    {
      ajrk.m("HotchatSCMng", new Object[] { "initCache", localObject2 });
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label365;
      }
      localObject2 = rC();
      if (localObject2 != null) {
        break;
      }
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.length() > 0))
        {
          acgl.a locala = acgl.a.a(str);
          if (locala != null)
          {
            for (;;)
            {
              try
              {
                if (new File((String)localObject2 + "/" + locala.fileName).exists()) {
                  break label290;
                }
                bool = a(locala, (String)localObject2);
                if (!bool) {
                  break;
                }
                parse((String)localObject2 + "/" + locala.fileName);
              }
              catch (Exception localException)
              {
                if (!QLog.isColorLevel()) {
                  break label408;
                }
              }
              ajrk.m("HotchatSCMng", new Object[] { "initCache", "parse config xml fail", localException.toString() });
              break label408;
              label290:
              boolean bool = true;
            }
            if (QLog.isColorLevel()) {
              ajrk.m("HotchatSCMng", new Object[] { "initCache", "download config xml fail", locala });
            }
          }
          else if (QLog.isColorLevel())
          {
            ajrk.m("HotchatSCMng", new Object[] { "initCache", "parse ConfigData fail", localException });
          }
        }
      }
      else
      {
        label365:
        this.bHR = true;
        if (QLog.isColorLevel()) {
          ajrk.m("HotchatSCMng", new Object[] { "initCache", Integer.valueOf(this.mConfigs.size()) });
        }
        return;
      }
      label408:
      i += 1;
    }
  }
  
  /* Error */
  public String rC()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	acgl:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_2
    //   18: invokevirtual 72	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull -10 -> 13
    //   26: aload_0
    //   27: getfield 537	acgl:bos	Ljava/lang/String;
    //   30: ifnull +13 -> 43
    //   33: aload_0
    //   34: getfield 537	acgl:bos	Ljava/lang/String;
    //   37: invokevirtual 344	java/lang/String:length	()I
    //   40: ifgt +105 -> 145
    //   43: aload_0
    //   44: aload_2
    //   45: invokevirtual 543	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 546	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: putfield 537	acgl:bos	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 537	acgl:bos	Ljava/lang/String;
    //   58: ldc_w 296
    //   61: invokevirtual 549	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   64: ifne +30 -> 94
    //   67: aload_0
    //   68: new 135	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   75: aload_0
    //   76: getfield 537	acgl:bos	Ljava/lang/String;
    //   79: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 296
    //   85: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: putfield 537	acgl:bos	Ljava/lang/String;
    //   94: aload_0
    //   95: new 135	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   102: aload_0
    //   103: getfield 537	acgl:bos	Ljava/lang/String;
    //   106: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 86
    //   111: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: putfield 537	acgl:bos	Ljava/lang/String;
    //   120: getstatic 38	acgl:DEBUG	Z
    //   123: ifeq +22 -> 145
    //   126: ldc 119
    //   128: ldc_w 551
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: getfield 537	acgl:bos	Ljava/lang/String;
    //   141: aastore
    //   142: invokestatic 223	ajrk:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 537	acgl:bos	Ljava/lang/String;
    //   149: astore_1
    //   150: goto -137 -> 13
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	acgl
    //   1	149	1	str	String
    //   153	4	1	localObject1	Object
    //   8	37	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	153	finally
    //   17	22	153	finally
    //   26	43	153	finally
    //   43	94	153	finally
    //   94	145	153	finally
    //   145	150	153	finally
  }
  
  public static class a
  {
    String fileName;
    String md5;
    String url;
    
    public static a a(String paramString)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        paramString = null;
      }
      for (;;)
      {
        return paramString;
        try
        {
          a locala = new a();
          paramString = new JSONObject(paramString);
          locala.url = paramString.getString("url");
          if (locala.url != null)
          {
            locala.url = locala.url.trim();
            locala.fileName = MD5.toMD5(locala.url);
          }
          locala.md5 = paramString.getString("md5");
          if (locala.md5 != null) {
            locala.md5 = locala.md5.trim();
          }
          paramString = locala;
          if (QLog.isDevelopLevel())
          {
            ajrk.f("HotchatSCMng", "parse ConfigData", new Object[] { locala });
            return locala;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return null;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
      }
      return null;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("[url:").append(this.url).append(",").append("md5:").append(this.md5).append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface b {}
  
  public static class c
  {
    static SimpleDateFormat w = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static SimpleDateFormat x = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public String content;
    public long endtime;
    public boolean hasShow;
    public long stime;
    public String url;
    
    public static long aa(String paramString)
    {
      try
      {
        l = w.parse(paramString).getTime();
        return l;
      }
      catch (Exception localException)
      {
        long l;
        localException.printStackTrace();
        try
        {
          l = x.parse(paramString).getTime();
          return l;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      return 0L;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("[").append(this.content).append(",").append(this.url).append(",").append(this.stime).append(",").append(this.endtime).append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static class d
  {
    int curIndex = -1;
    String id;
    ArrayList<acgl.c> tf = new ArrayList();
    
    public void reset()
    {
      this.curIndex = -1;
      this.id = null;
      this.tf.clear();
    }
    
    public String toString()
    {
      int i = 2000;
      int j = this.tf.size() * 100;
      if (j > 2000) {}
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(i);
        localStringBuilder.append("[").append(this.id).append(",").append(this.tf.size()).append(",");
        if (this.tf.size() > 0)
        {
          localStringBuilder.append("{");
          Iterator localIterator = this.tf.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localStringBuilder.append((acgl.c)localIterator.next()).append(",");
              continue;
              if (j >= 100) {
                break label155;
              }
              i = 100;
              break;
            }
          }
          localStringBuilder.append("}");
        }
        localStringBuilder.append("]");
        return localStringBuilder.toString();
        label155:
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgl
 * JD-Core Version:    0.7.0.1
 */