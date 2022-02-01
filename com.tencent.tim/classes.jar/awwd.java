import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.camera.core.AEEditorGenerateBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AEEditorGenerateBroadcastReceiver.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class awwd
  implements AEEditorGenerateBroadcastReceiver.a
{
  private final String TAG = "AEEditorManagerForQzone";
  private AEEditorGenerateBroadcastReceiver a = new AEEditorGenerateBroadcastReceiver(this);
  private List<awwd.a> mListenerList = new CopyOnWriteArrayList();
  private Map<String, LocalMediaInfo> qy = new ConcurrentHashMap();
  
  public static awwd a()
  {
    return awwd.b.a;
  }
  
  private void jJ(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      axiy.e("AEEditorManagerForQzone", "[sendBroadCast] action or missionID is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction(paramString1);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_mission", paramString2);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public void a(@Nullable awwd.a parama)
  {
    axiy.i("AEEditorManagerForQzone", "[addListener]");
    if ((parama != null) && (!this.mListenerList.contains(parama))) {
      this.mListenerList.add(parama);
    }
  }
  
  public void ace(@NonNull String paramString)
  {
    axiy.i("AEEditorManagerForQzone", "[cancel]");
    jJ("AEEDITOR_ORDER_CANCEL", paramString);
  }
  
  public void acf(String paramString)
  {
    axiy.i("AEEditorManagerForQzone", "[save]");
    jJ("AEEDITOR_ORDER_SAVE", paramString);
  }
  
  public void acg(String paramString)
  {
    axiy.i("AEEditorManagerForQzone", "[retry]");
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), PeakService.class);
    localIntent.putExtra("ServiceAction", 4);
    localIntent.putExtra("generate_mission", paramString);
    BaseApplicationImpl.getApplication().startService(localIntent);
  }
  
  public void b(@Nullable awwd.a parama)
  {
    axiy.i("AEEditorManagerForQzone", "[removeListener]");
    if ((parama != null) && (this.mListenerList.contains(parama))) {
      this.mListenerList.remove(parama);
    }
  }
  
  public void bF(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      axiy.e("AEEditorManagerForQzone", "[onAETavSessionExportCompleted] mission is null");
    }
    for (;;)
    {
      return;
      paramString2 = axof.a(paramString2, paramString3);
      if (paramString2 == null)
      {
        onAETavSessionExportError(paramString1, -4);
        return;
      }
      this.qy.put(paramString1, paramString2);
      paramString3 = this.mListenerList.iterator();
      while (paramString3.hasNext()) {
        ((awwd.a)paramString3.next()).onAETavSessionExportCompleted(paramString1, paramString2);
      }
    }
  }
  
  public LocalMediaInfo d(String paramString)
  {
    paramString = (LocalMediaInfo)this.qy.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public void init()
  {
    axiy.i("AEEditorManagerForQzone", "[init]");
    this.a.gE(BaseApplicationImpl.getContext());
  }
  
  public void onAETavSessionExportError(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      axiy.e("AEEditorManagerForQzone", "[onAETavSessionExportError] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.qy.get(paramString);
    if (localObject == null)
    {
      localObject = axof.a(0, 0, null, null, paramString);
      this.qy.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.mListenerList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((awwd.a)((Iterator)localObject).next()).onAETavSessionExportError(paramString, paramInt);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString))
    {
      axiy.e("AEEditorManagerForQzone", "[onAETavSessionExporting] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.qy.get(paramString);
    if (localObject == null)
    {
      localObject = axof.a(0, 0, null, null, paramString);
      this.qy.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.mListenerList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((awwd.a)((Iterator)localObject).next()).onAETavSessionExporting(paramString, paramFloat);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo);
    
    public abstract void onAETavSessionExportError(String paramString, int paramInt);
    
    public abstract void onAETavSessionExporting(String paramString, float paramFloat);
  }
  
  static class b
  {
    static final awwd a = new awwd(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwd
 * JD-Core Version:    0.7.0.1
 */