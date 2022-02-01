import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class arzh
  implements EIPCResultCallback
{
  arzh(arzg paramarzg) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    arwt.d("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
    if (paramEIPCResult == null) {
      return;
    }
    Object localObject1 = paramEIPCResult.data;
    if (localObject1 == null)
    {
      arwt.d("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
      return;
    }
    paramEIPCResult = ((Bundle)localObject1).getString("PackageName");
    int i = ((Bundle)localObject1).getInt("VersionCode");
    arzg.a(this.this$0).put(arzg.a(this.this$0, paramEIPCResult, i), Boolean.valueOf(false));
    String str1 = ((Bundle)localObject1).getString("Code");
    boolean bool = ((Bundle)localObject1).getBoolean("IsSuccess");
    arwt.d("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + paramEIPCResult + " versionCode|" + i + " isSuc|" + bool + " code|" + str1);
    for (;;)
    {
      aryo localaryo;
      Bundle localBundle;
      try
      {
        localObject1 = arzg.a(this.this$0, paramEIPCResult, i);
        String str2 = (String)arzg.a(this.this$0).get(localObject1);
        Object localObject2 = (List)arzg.b(this.this$0).get(localObject1);
        if (localObject2 == null) {
          break label315;
        }
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localaryo = (aryo)((Iterator)localObject2).next();
        if (localaryo == null) {
          continue;
        }
        localBundle = new Bundle();
        if (TextUtils.isEmpty(str2))
        {
          localaryo.a(paramEIPCResult, i, str1, bool, localBundle);
          continue;
        }
        localBundle.putString(aryv.PARAM_TICKET, str2);
      }
      finally {}
      localaryo.a(paramEIPCResult, i, str1, bool, localBundle);
    }
    arzg.b(this.this$0).remove(localObject1);
    for (;;)
    {
      return;
      label315:
      arwt.d("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzh
 * JD-Core Version:    0.7.0.1
 */