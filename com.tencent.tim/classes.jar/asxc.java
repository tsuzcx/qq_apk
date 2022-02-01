import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class asxc
  implements awoe
{
  asxc(asxb paramasxb) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    Object localObject1;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localObject1 = asxb.d(this.a).entrySet().iterator();
      label78:
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayList = (Map.Entry)((Iterator)localObject1).next();
        if (paramArrayList != null) {}
        for (paramArrayList = (AsyncResult)paramArrayList.getValue();; paramArrayList = null)
        {
          if (paramArrayList == null) {
            break label78;
          }
          paramArrayList.onReceiveResult(false, null);
          break;
        }
      }
      asxb.d(this.a).clear();
    }
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (WadlResult)paramArrayList.next();
        localObject1 = ((WadlResult)localObject2).a;
        String str = ((WadlParams)localObject1).appId;
        if ((str != null) && (localObject1 != null)) {
          asxb.e(this.a).put(str, localObject1);
        }
        if ((str != null) && (asxb.d(this.a).containsKey(str)))
        {
          localObject1 = (AsyncResult)asxb.d(this.a).remove(str);
          if (localObject1 != null) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("appid", str);
              localJSONObject.put("status", ((WadlResult)localObject2).bBa);
              localJSONObject.put("downloadSize", ((WadlResult)localObject2).DZ);
              localJSONObject.put("totalSize", ((WadlResult)localObject2).fileSize);
              localJSONObject.put("progress", ((WadlResult)localObject2).DZ * 100L / ((WadlResult)localObject2).fileSize);
              if (((WadlResult)localObject2).a != null) {
                localJSONObject.put("versionCode", ((WadlResult)localObject2).a.versionCode);
              }
              if (((WadlResult)localObject2).bBa == 6)
              {
                localObject2 = ((WadlResult)localObject2).aJb;
                if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
                {
                  localJSONObject.put("status", 0);
                  localJSONObject.put("progress", 0);
                }
              }
              ((AsyncResult)localObject1).onReceiveResult(true, localJSONObject);
            }
            catch (Throwable localThrowable)
            {
              ((AsyncResult)localObject1).onReceiveResult(false, null);
            }
          }
        }
      }
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null)) {
      asbt.e("ThirdAppProxyImpl", "onWadlTaskStatusChanged error wadlResult is null");
    }
    String str;
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            WadlParams localWadlParams = paramWadlResult.a;
            str = localWadlParams.appId;
            i = ascc.kR(paramWadlResult.bBa);
            asbx.XD(localWadlParams.appId);
            QLog.i("ThirdAppProxyImpl", 1, "onWadlTaskStatusChanged:" + paramWadlResult + ",localStatus:" + i);
            switch (i)
            {
            case 3: 
            case 9: 
            case 10: 
            case 20: 
            default: 
              QLog.e("ThirdAppProxyImpl", 1, "download status not response!");
              return;
            case 4: 
              asxb.a(this.a).remove(str);
              if ((asxb.b(this.a) != null) && (asxb.b(this.a).containsKey(str)) && (asxb.b(this.a).get(str) != null)) {
                ((ThirdAppProxy.AppDownloadListener)asxb.b(this.a).get(str)).onDownloadComplete();
              }
              asxb.b(this.a).remove(str);
              return;
            }
          } while (!asxb.c(this.a).containsKey(str));
          paramWadlResult = (AsyncResult)asxb.c(this.a).remove(str);
        } while (paramWadlResult == null);
        paramWadlResult.onReceiveResult(true, null);
        return;
        i = ascc.kS(paramWadlResult.errCode);
        ascc.gy(i);
        asxb.a(this.a).remove(str);
        if ((asxb.b(this.a) != null) && (asxb.b(this.a).containsKey(str)) && (asxb.b(this.a).get(str) != null)) {
          ((ThirdAppProxy.AppDownloadListener)asxb.b(this.a).get(str)).onDownloadFailed(i, i, "failed");
        }
        asxb.b(this.a).remove(str);
        return;
      } while ((asxb.b(this.a) == null) || (!asxb.b(this.a).containsKey(str)) || (asxb.b(this.a).get(str) == null));
      i = 0;
      if (asxb.a(this.a).containsKey(str)) {
        i = ((Integer)asxb.a(this.a).get(str)).intValue();
      }
      j = (int)(paramWadlResult.DZ * 100L / paramWadlResult.fileSize);
    } while (j - i < 1);
    ((ThirdAppProxy.AppDownloadListener)asxb.b(this.a).get(str)).onDownloadProgress(paramWadlResult.DZ, paramWadlResult.fileSize, j);
    asxb.a(this.a).put(str, Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxc
 * JD-Core Version:    0.7.0.1
 */