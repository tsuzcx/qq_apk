import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.pcpush.MessageContent.MsgContent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class asbe
  implements aryx
{
  protected static List<asbe.a> JI;
  protected static asbe a;
  protected asbd a;
  protected int elv = 111;
  protected ConcurrentHashMap<String, asbe.b> jr = new ConcurrentHashMap(10);
  protected Handler mWorkHandler = new asbe.c(ThreadManager.getSubThreadLooper());
  
  protected asbe()
  {
    JI = new ArrayList(10);
    this.jdField_a_of_type_Asbd = new asbd();
    this.mWorkHandler.sendEmptyMessage(1);
    aryy.a().a(this);
  }
  
  public static asbe a()
  {
    try
    {
      if (jdField_a_of_type_Asbe == null) {
        jdField_a_of_type_Asbe = new asbe();
      }
      asbe localasbe = jdField_a_of_type_Asbe;
      return localasbe;
    }
    finally {}
  }
  
  protected String DH()
  {
    Object localObject = aroi.a().getContext();
    if (localObject != null)
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()) && (((NetworkInfo)localObject).isAvailable())) {
          return "ANDROIDQQ.PCPUSH.AUTO";
        }
      }
    }
    if (this.elv == 111) {
      return "ANDROIDQQ.PCPUSH.SINGLEDETAIL";
    }
    if (this.elv == 112) {
      return "ANDROIDQQ.PCPUSH.MUTIDETAIL";
    }
    if (this.elv == 113) {
      return "ANDROIDQQ.PCPUSH.UNREADPOP";
    }
    return "ANDROIDQQ.PCPUSH.AUTO";
  }
  
  public void F(int paramInt)
  {
    this.elv = paramInt;
  }
  
  public void IL(String paramString)
  {
    arwt.d("PCPushProxy", "--> pause key = " + paramString);
    asbe.b localb = (asbe.b)this.jr.get(paramString);
    if (localb == null)
    {
      arwt.e("PCPushProxy", "pause error because entry = null, key = " + paramString);
      return;
    }
    paramString = new Bundle();
    paramString.putString(aryv.PARAM_SNG_APPID, localb.appid);
    paramString.putString(aryv.PARAM_URL, localb.appUrl);
    paramString.putString(aryv.PARAM_TASK_PACKNAME, localb.pkgName);
    paramString.putString(aryv.PARAM_VIA, localb.via);
    paramString.putString(aryv.PARAM_APPNAME, localb.appName);
    String str = aryv.PARAM_IS_APK;
    if (localb.fileType == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(aryv.PARAM_ACTIONCODE, 3);
      aryr.d(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public void Xz(String paramString)
  {
    arwt.d("PCPushProxy", "--> install key = " + paramString);
    asbe.b localb = (asbe.b)this.jr.get(paramString);
    if (localb == null)
    {
      arwt.e("PCPushProxy", "install error because entry = null, key = " + paramString);
      return;
    }
    if (localb.fileType != 1)
    {
      arwt.e("PCPushProxy", "The file to be installing is not a apk file");
      return;
    }
    paramString = new Bundle();
    paramString.putString(aryv.PARAM_SNG_APPID, localb.appid);
    paramString.putString(aryv.PARAM_URL, localb.appUrl);
    paramString.putString(aryv.PARAM_TASK_PACKNAME, localb.pkgName);
    paramString.putString(aryv.PARAM_VIA, localb.via);
    paramString.putString(aryv.PARAM_APPNAME, localb.appName);
    String str = aryv.PARAM_IS_APK;
    if (localb.fileType == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(aryv.PARAM_ACTIONCODE, 5);
      aryr.d(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public asbe.b a(byte[] paramArrayOfByte)
  {
    arwt.d("PCPushProxy", "--> parse");
    Object localObject = new MessageContent.MsgContent();
    try
    {
      ((MessageContent.MsgContent)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new asbe.b();
      paramArrayOfByte.appid = String.valueOf(((MessageContent.MsgContent)localObject).appid.get());
      paramArrayOfByte.appName = ((MessageContent.MsgContent)localObject).appname.get();
      paramArrayOfByte.cEa = ((MessageContent.MsgContent)localObject).appsize.get();
      paramArrayOfByte.appUrl = ((MessageContent.MsgContent)localObject).appurl.get();
      paramArrayOfByte.fileType = ((MessageContent.MsgContent)localObject).filetype.get();
      paramArrayOfByte.iconUrl = ((MessageContent.MsgContent)localObject).iconurl.get();
      paramArrayOfByte.pkgName = ((MessageContent.MsgContent)localObject).pkgname.get();
      paramArrayOfByte.source = ((MessageContent.MsgContent)localObject).source.get();
      paramArrayOfByte.cEb = ((MessageContent.MsgContent)localObject).srciconurl.get();
      paramArrayOfByte.versionCode = ((MessageContent.MsgContent)localObject).versioncode.get();
      paramArrayOfByte.via = ((MessageContent.MsgContent)localObject).via.get();
      paramArrayOfByte.key = generateKey(paramArrayOfByte.appUrl);
      if (paramArrayOfByte.fileType != 1)
      {
        paramArrayOfByte.appid = ("unapk" + SystemClock.currentThreadTimeMillis() + "#" + paramArrayOfByte.appid);
        paramArrayOfByte.pkgName = paramArrayOfByte.appName;
      }
      boolean bool = this.jr.containsKey(paramArrayOfByte.key);
      arwt.d("PCPushProxy", "add entry to mPkgEntryMap, hasKey = " + bool);
      if (!bool)
      {
        arwt.d("PCPushProxy", "add entry to mPkgEntryMap, key = " + paramArrayOfByte.key);
        this.jr.put(paramArrayOfByte.key, paramArrayOfByte);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = paramArrayOfByte.key;
      this.mWorkHandler.sendMessage((Message)localObject);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void a(asbe.a parama)
  {
    arwt.d("PCPushProxy", "registerDownloadLitener dataline register listeners");
    if (!JI.contains(parama)) {
      JI.add(parama);
    }
  }
  
  public void b(asbe.a parama)
  {
    if (JI.contains(parama)) {
      JI.remove(parama);
    }
  }
  
  public void delete(String paramString)
  {
    arwt.d("PCPushProxy", "--> delete key = " + paramString);
    Object localObject = (asbe.b)this.jr.get(paramString);
    if (localObject == null)
    {
      arwt.e("PCPushProxy", "delete error because entry = null, key = " + paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_SNG_APPID, ((asbe.b)localObject).appid);
    localBundle.putString(aryv.PARAM_URL, ((asbe.b)localObject).appUrl);
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, ((asbe.b)localObject).pkgName);
    localBundle.putString(aryv.PARAM_VIA, ((asbe.b)localObject).via);
    localBundle.putString(aryv.PARAM_APPNAME, ((asbe.b)localObject).appName);
    String str = aryv.PARAM_IS_APK;
    if (((asbe.b)localObject).fileType == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean(str, bool);
      localBundle.putInt(aryv.PARAM_ACTIONCODE, 10);
      aryr.d(null, localBundle, "5", null, 0);
      this.jr.remove(paramString);
      localObject = Message.obtain();
      ((Message)localObject).what = 3;
      ((Message)localObject).obj = paramString;
      this.mWorkHandler.sendMessage((Message)localObject);
      return;
    }
  }
  
  protected String generateKey(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    return "p" + paramString.hashCode();
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    arwt.d("PCPushProxy", "--> installSucceed packageName = " + paramString2);
    paramString1 = null;
    Iterator localIterator = this.jr.values().iterator();
    if (localIterator.hasNext())
    {
      asbe.b localb = (asbe.b)localIterator.next();
      if ((!paramString2.equals(localb.pkgName)) || (localb.elw != 0)) {
        break label136;
      }
      localb.elw = 1;
      paramString1 = localb;
    }
    label136:
    for (;;)
    {
      break;
      if (paramString1 == null) {}
      for (;;)
      {
        return;
        paramString2 = JI.iterator();
        while (paramString2.hasNext()) {
          ((asbe.a)paramString2.next()).f(6, paramString1.key);
        }
      }
    }
  }
  
  public boolean isInstalled(String paramString)
  {
    arwt.d("PCPushProxy", "--> isInstalled key = " + paramString);
    asbe.b localb = (asbe.b)this.jr.get(paramString);
    if (localb == null)
    {
      arwt.d("PCPushProxy", "--> key : " + paramString + " 's entry is not exist.");
      return false;
    }
    return arxn.appIsExists(localb.pkgName);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    arwt.d("PCPushProxy", "--> onDownloadCancel info = " + paramDownloadInfo.toString());
    paramDownloadInfo = generateKey(paramDownloadInfo.urlStr);
    Iterator localIterator = JI.iterator();
    while (localIterator.hasNext()) {
      ((asbe.a)localIterator.next()).f(5, paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramDownloadInfo != null)
    {
      arwt.d("PCPushProxy", "--> onDownloadError info = " + paramDownloadInfo.toString() + " errorCode = " + paramInt1 + " errorMsg = " + paramString + " state = " + paramInt2);
      localObject = generateKey(paramDownloadInfo.urlStr);
      paramDownloadInfo = (asbe.b)this.jr.get(localObject);
      if (paramDownloadInfo == null)
      {
        arwt.e("PCPushProxy", "onDownloadError error because entry = null, key = " + (String)localObject);
        return;
      }
      paramDownloadInfo.state = 105;
    }
    for (;;)
    {
      localObject = JI.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((asbe.a)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt1, paramString, paramInt2);
      }
      break;
      paramDownloadInfo = null;
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    arwt.d("PCPushProxy", "--> onDownloadFinish info = " + paramDownloadInfo.toString());
    paramDownloadInfo = generateKey(paramDownloadInfo.urlStr);
    Object localObject = (asbe.b)this.jr.get(paramDownloadInfo);
    if (localObject == null) {
      arwt.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((asbe.b)localObject).state = 102;
      localObject = JI.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((asbe.a)((Iterator)localObject).next()).f(4, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    arwt.d("PCPushProxy", "--> onDownloadPause info = " + paramDownloadInfo.toString());
    paramDownloadInfo = generateKey(paramDownloadInfo.urlStr);
    Object localObject = (asbe.b)this.jr.get(paramDownloadInfo);
    if (localObject == null) {
      arwt.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((asbe.b)localObject).state = 105;
      localObject = JI.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((asbe.a)((Iterator)localObject).next()).f(2, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    arwt.d("PCPushProxy", "--> onDownloadUpdate infos = " + paramList.toString());
    ArrayList localArrayList = new ArrayList(10);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      String str = generateKey(((DownloadInfo)localObject).urlStr);
      asbe.b localb = (asbe.b)this.jr.get(str);
      if (localb == null)
      {
        arwt.e("PCPushProxy", "onDownloadUpdate error because entry = null, key = " + str);
      }
      else
      {
        int i = localb.state;
        switch (((DownloadInfo)localObject).getState())
        {
        }
        for (;;)
        {
          localb.progress = ((DownloadInfo)localObject).progress;
          if ((i == 101) || (localb.state != 101)) {
            break;
          }
          localObject = JI.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((asbe.a)((Iterator)localObject).next()).f(1, str);
          }
          localb.state = 104;
          continue;
          localb.state = 101;
          continue;
          if (localb.elw == 1)
          {
            localb.state = 103;
          }
          else
          {
            localb.state = 102;
            continue;
            localb.state = 105;
            continue;
            localb.state = 100;
          }
        }
        localArrayList.add(localb);
      }
    }
    paramList = JI.iterator();
    while (paramList.hasNext()) {
      ((asbe.a)paramList.next()).onDownloadUpdate(localArrayList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    arwt.d("PCPushProxy", "--> onDownloadWait info = " + paramDownloadInfo.toString());
    paramDownloadInfo = generateKey(paramDownloadInfo.urlStr);
    Iterator localIterator = JI.iterator();
    while (localIterator.hasNext()) {
      ((asbe.a)localIterator.next()).f(3, paramDownloadInfo);
    }
  }
  
  public int open(String paramString)
  {
    arwt.d("PCPushProxy", "--> open key = " + paramString);
    Object localObject1 = (asbe.b)this.jr.get(paramString);
    if (localObject1 == null)
    {
      arwt.e("PCPushProxy", "open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = " + paramString);
      return 1;
    }
    if (((asbe.b)localObject1).fileType != 1)
    {
      localObject2 = qO(paramString);
      if ((localObject2 == null) || (((String)localObject2).trim().equals("")) || (!new File((String)localObject2).exists()))
      {
        arwt.e("PCPushProxy", "open fail, error : file not exist or be deleted, key = " + paramString);
        return 2;
      }
    }
    Object localObject2 = Message.obtain();
    ((Message)localObject2).what = 4;
    ((Message)localObject2).obj = paramString;
    this.mWorkHandler.sendMessage((Message)localObject2);
    paramString = aroi.a().getContext();
    if (paramString == null)
    {
      arwt.d("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    localObject2 = paramString.getPackageManager();
    if (localObject2 == null)
    {
      arwt.d("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    if (((asbe.b)localObject1).fileType == 1) {}
    for (;;)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getLaunchIntentForPackage(((asbe.b)localObject1).pkgName);
        if (localObject2 == null)
        {
          arwt.d("PCPushProxy", "open fail, because package not found, package = " + ((asbe.b)localObject1).pkgName);
          return 4;
        }
        ((Intent)localObject2).addFlags(268435456);
        paramString.startActivity((Intent)localObject2);
        arwt.d("PCPushProxy", "open success");
        return 0;
      }
      catch (Exception paramString)
      {
        arwt.d("PCPushProxy", "open fail, error : ", paramString);
        return 4;
      }
      localObject1 = aryy.a().c(((asbe.b)localObject1).appid);
      if (localObject1 == null) {
        return 4;
      }
      localObject1 = asbc.a(paramString, new File(((DownloadInfo)localObject1).filePath));
      if (localObject1 != null)
      {
        localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 0);
        if ((localObject2 == null) || (((List)localObject2).size() == 0))
        {
          arwt.d("PCPushProxy", "open fail, error : OPEN_FAIL_NO_RESPONSE_APP");
          return 3;
        }
        paramString.startActivity((Intent)localObject1);
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public String qO(String paramString)
  {
    if (!this.jr.containsKey(paramString)) {
      return null;
    }
    asbe.b localb = (asbe.b)this.jr.get(paramString);
    if (localb == null)
    {
      arwt.e("PCPushProxy", "getDownloadPath error because entry = null, key = " + paramString);
      return null;
    }
    paramString = aryy.a().c(localb.appid);
    if (paramString != null) {
      return paramString.filePath;
    }
    return null;
  }
  
  public void report(int paramInt)
  {
    this.mWorkHandler.sendEmptyMessage(paramInt);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
  
  public boolean y(String paramString)
  {
    boolean bool2 = true;
    arwt.d("PCPushProxy", "--> start key = " + paramString);
    if (!aryy.a().b().contains(this))
    {
      aryy.a().a(this);
      arwt.d("PCPushProxy", "PCPushProxy has not register, register download listener");
    }
    asbe.b localb = (asbe.b)this.jr.get(paramString);
    boolean bool1;
    if (localb == null)
    {
      arwt.e("PCPushProxy", "start error because entry = null, key = " + paramString);
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (localb.state == 101);
      bool1 = bool2;
    } while (localb.state == 104);
    label273:
    int i;
    if (localb.state != 105)
    {
      if (!localb.via.startsWith("ANDROIDQQ.PCPUSH.")) {
        localb.via = (DH() + "." + localb.via);
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString(aryv.PARAM_SNG_APPID, localb.appid);
      paramString.putString(aryv.PARAM_URL, localb.appUrl);
      paramString.putString(aryv.PARAM_TASK_PACKNAME, localb.pkgName);
      paramString.putString(aryv.PARAM_VIA, localb.via);
      paramString.putString(aryv.PARAM_APPNAME, localb.appName);
      String str = aryv.PARAM_IS_APK;
      if (localb.fileType != 1) {
        break label456;
      }
      bool1 = true;
      paramString.putBoolean(str, bool1);
      if (localb.fileType != 1) {
        break label466;
      }
      if (localb.downloadType != 2) {
        break label461;
      }
      i = 12;
    }
    for (;;)
    {
      paramString.putInt(aryv.PARAM_ACTIONCODE, i);
      aryr.d(null, paramString, "5", null, 0);
      return true;
      if (localb.via.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
        i = "ANDROIDQQ.PCPUSH.AUTO".length();
      }
      for (;;)
      {
        localb.via = (DH() + localb.via.substring(i));
        break;
        if (localb.via.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.SINGLEDETAIL".length();
        } else if (localb.via.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.MUTIDETAIL".length();
        } else if (localb.via.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
          i = "ANDROIDQQ.PCPUSH.UNREADPOP".length();
        } else {
          i = "ANDROIDQQ.PCPUSH".length();
        }
      }
      label456:
      bool1 = false;
      break label273;
      label461:
      i = 2;
      continue;
      label466:
      i = 2;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(asbe.b paramb, int paramInt1, String paramString, int paramInt2);
    
    public abstract void f(int paramInt, String paramString);
    
    public abstract void onDownloadUpdate(List<asbe.b> paramList);
  }
  
  public static class b
  {
    public String appName;
    public String appUrl;
    public String appid;
    public String cEa;
    public String cEb;
    public int downloadType;
    public int elw;
    public int fileType;
    public String iconUrl;
    public String key;
    public String pkgName;
    public int progress;
    public String source;
    public int state;
    public int versionCode;
    public String via;
  }
  
  class c
    extends Handler
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      String str1 = null;
      arwt.i("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
      String str2;
      asbe.b localb;
      switch (paramMessage.what)
      {
      default: 
        str2 = (String)paramMessage.obj;
        if (str2 != null)
        {
          localb = (asbe.b)asbe.this.jr.get(str2);
          if (localb == null) {
            arwt.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
          }
        }
        break;
      }
      do
      {
        do
        {
          return;
          arxt.br("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
          return;
          arxt.br("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
          return;
          if (localb.fileType != 1) {
            str1 = localb.appid.substring(localb.appid.indexOf("#") + 1);
          }
          for (;;)
          {
            switch (paramMessage.what)
            {
            default: 
              return;
            case 1: 
              asbe.this.a.h(asbe.this.jr);
              return;
              str1 = localb.appid;
              continue;
              arwt.e("PCPushProxy", "handleMessage get key = null");
              localb = null;
            }
          }
        } while (localb == null);
        if (localb.via.startsWith("ANDROIDQQ.PCPUSH.")) {
          arxt.br("100", localb.via, str1);
        }
        for (;;)
        {
          asbe.this.a.a(localb);
          return;
          arxt.br("100", "ANDROIDQQ.PCPUSH." + localb.via, str1);
        }
        asbe.this.a.Xy(str2);
        return;
      } while (localb == null);
      arxt.br("500", localb.via, str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbe
 * JD-Core Version:    0.7.0.1
 */