import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class ljq
{
  private TroopMemberApiService b;
  private HashMap<String, ljq.a> dW = new HashMap();
  private AppRuntime mApp;
  
  public ljq(AppRuntime paramAppRuntime, TroopMemberApiService paramTroopMemberApiService)
  {
    this.mApp = paramAppRuntime;
    this.b = paramTroopMemberApiService;
  }
  
  public void aA(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive load skin cmd");
    }
    if ((this.mApp == null) || (this.b == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy", 4, "mApp == null || mService == null");
      }
    }
    String str1;
    boolean bool;
    do
    {
      return;
      localObject = (mfs)this.mApp.getManager(261);
      str1 = paramBundle.getString("skinId");
      long l1 = paramBundle.getLong("skinSeq");
      String str2 = paramBundle.getString("skinName");
      String str3 = paramBundle.getString("skinUrl");
      long l2 = paramBundle.getLong("startTime");
      long l3 = paramBundle.getLong("endTime");
      ljq.a locala = new ljq.a(this.mApp, str1, paramBundle, this.b);
      this.dW.put(str1, locala);
      bool = ((mfs)localObject).a(str1, str2, str3, l1, l2, l3, locala);
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy", 4, "downloadResult：" + bool);
      }
    } while (!bool);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("seq", paramBundle.getInt("seq"));
    ((Bundle)localObject).putInt("retCode", 0);
    ((Bundle)localObject).putInt("rate", 100);
    ((Bundle)localObject).putString("skinId", str1);
    this.b.j(107, (Bundle)localObject);
  }
  
  public void aB(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive cancel load skin cmd");
    }
    if ((this.mApp == null) || (this.b == null)) {
      return;
    }
    Object localObject = (mfs)this.mApp.getManager(261);
    String str = paramBundle.getString("skinId");
    paramBundle.getString("skinUrl");
    boolean bool = ((mfs)localObject).dT(str);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("seq", paramBundle.getInt("seq"));
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      ((Bundle)localObject).putInt("retCode", i);
      ((Bundle)localObject).putString("skinId", str);
      this.b.j(108, (Bundle)localObject);
      return;
    }
  }
  
  public void ay(Bundle paramBundle)
  {
    if ((this.mApp == null) || (this.b == null)) {}
    while (!(this.mApp instanceof AppInterface)) {
      return;
    }
    String str = ((mfs)this.mApp.getManager(261)).jM();
    if (!mfk.dS(str)) {
      str = "";
    }
    for (;;)
    {
      boolean bool = aqmj.aJ(((AppInterface)this.mApp).getApp().getApplicationContext(), ((AppInterface)this.mApp).getCurrentAccountUin());
      Bundle localBundle = new Bundle();
      localBundle.putInt("seq", paramBundle.getInt("seq"));
      localBundle.putInt("retCode", 0);
      localBundle.putString("skinId", str);
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        localBundle.putInt("volumeIsOn", i);
        this.b.j(110, localBundle);
        return;
      }
    }
  }
  
  public void az(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive set skin cmd");
    }
    if ((this.mApp == null) || (this.b == null)) {
      return;
    }
    Object localObject1 = (mfs)this.mApp.getManager(261);
    String str1 = paramBundle.getString("skinId");
    long l1 = paramBundle.getLong("skinSeq");
    Object localObject2 = paramBundle.getString("skinName");
    String str2 = paramBundle.getString("skinUrl");
    long l2 = paramBundle.getLong("startTime");
    long l3 = paramBundle.getLong("endTime");
    boolean bool;
    if (paramBundle.getInt("volumeIsOn") == 1)
    {
      bool = true;
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals("null"))) {
        break label208;
      }
      str1 = "";
    }
    label208:
    for (localObject1 = ((mfs)localObject1).a(0, "", l1, (String)localObject2, str2, l2, l3, bool);; localObject1 = ((mfs)localObject1).a(1, str1, l1, (String)localObject2, str2, l2, l3, bool))
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("seq", paramBundle.getInt("seq"));
      ((Bundle)localObject2).putInt("retCode", ((ErrorMessage)localObject1).errorCode);
      ((Bundle)localObject2).putString("skinId", str1);
      this.b.j(109, (Bundle)localObject2);
      return;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    QLog.d("ReadInJoySkinHelper", 1, "onDestroy");
    mfs localmfs = (mfs)this.mApp.getManager(261);
    Iterator localIterator = this.dW.entrySet().iterator();
    while (localIterator.hasNext()) {
      localmfs.b((aquy)((Map.Entry)localIterator.next()).getValue());
    }
    this.mApp = null;
    this.b = null;
  }
  
  public static class a
    extends aquy
  {
    private String afn;
    private WeakReference<TroopMemberApiService> cg;
    private AppRuntime mApp;
    private Bundle mData;
    
    public a(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, TroopMemberApiService paramTroopMemberApiService)
    {
      this.mApp = paramAppRuntime;
      this.afn = paramString;
      this.mData = paramBundle;
      this.cg = new WeakReference(paramTroopMemberApiService);
    }
    
    public void onCancel(aquz paramaquz)
    {
      super.onCancel(paramaquz);
      Object localObject = paramaquz.getParams().getString("resId");
      paramaquz = (TroopMemberApiService)this.cg.get();
      if (TextUtils.equals((CharSequence)localObject, this.afn))
      {
        ((mfs)this.mApp.getManager(261)).b(this);
        if (paramaquz != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("seq", this.mData.getInt("seq"));
          ((Bundle)localObject).putInt("retCode", -1);
          ((Bundle)localObject).putString("skinId", this.afn);
          ((Bundle)localObject).putInt("rate", 0);
          paramaquz.j(107, (Bundle)localObject);
          if (QLog.isDebugVersion()) {
            QLog.d("ReadInJoySkinHelper", 4, "onCancel rsp:" + ((Bundle)localObject).toString());
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy", 4, "SkinDownloadListener onCancel");
      }
    }
    
    public void onDone(aquz paramaquz)
    {
      super.onDone(paramaquz);
      Object localObject = paramaquz.getParams().getString("resId");
      TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.cg.get();
      if (TextUtils.equals((CharSequence)localObject, this.afn))
      {
        ((mfs)this.mApp.getManager(261)).b(this);
        if (localTroopMemberApiService != null)
        {
          localObject = new Bundle();
          if (paramaquz.errCode != 0) {
            break label169;
          }
          ((Bundle)localObject).putInt("seq", this.mData.getInt("seq"));
          ((Bundle)localObject).putInt("retCode", 0);
          ((Bundle)localObject).putString("skinId", this.afn);
          ((Bundle)localObject).putInt("rate", 100);
          localTroopMemberApiService.j(107, (Bundle)localObject);
        }
      }
      for (;;)
      {
        if (QLog.isDebugVersion()) {
          QLog.d("ReadInJoySkinHelper", 4, "onDone rsp:" + ((Bundle)localObject).toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("readinjoy", 4, "SkinDownloadListener onDone");
        }
        return;
        label169:
        ((Bundle)localObject).putInt("seq", this.mData.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", paramaquz.errCode);
        ((Bundle)localObject).putString("skinId", this.afn);
        ((Bundle)localObject).putInt("rate", 0);
        localTroopMemberApiService.j(107, (Bundle)localObject);
      }
    }
    
    public void onProgress(aquz paramaquz)
    {
      super.onProgress(paramaquz);
      Object localObject = paramaquz.getParams().getString("resId");
      TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.cg.get();
      if ((TextUtils.equals((CharSequence)localObject, this.afn)) && (localTroopMemberApiService != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("seq", this.mData.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", 0);
        ((Bundle)localObject).putString("skinId", this.afn);
        int i = (int)(paramaquz.atU * 100L / paramaquz.maxSize);
        ((Bundle)localObject).putInt("rate", i);
        if (i != 100) {
          localTroopMemberApiService.j(107, (Bundle)localObject);
        }
      }
    }
    
    public boolean onStart(aquz paramaquz)
    {
      return super.onStart(paramaquz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljq
 * JD-Core Version:    0.7.0.1
 */