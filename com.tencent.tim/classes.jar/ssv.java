import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ssv
  extends WebViewPlugin
{
  private static int counter = 1;
  private SparseArray<WeakReference<ssv.a>> bj;
  
  public ssv()
  {
    this.mPluginNameSpace = "redEnvelope";
  }
  
  private void g(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("portal_type_key", paramInt1);
    paramString1.putExtra("portal_agrs", paramString2);
    paramString1.putExtra("bc_seq", paramInt2);
    if (this.mRuntime.getActivity() != null) {
      this.mRuntime.getActivity().sendBroadcast(paramString1, "com.tencent.tim.msg.permission.pushnotify");
    }
  }
  
  private static int uu()
  {
    int i = counter;
    counter = i + 1;
    return i;
  }
  
  ssv.a a(int paramInt)
  {
    if (this.bj == null) {
      this.bj = new SparseArray(12);
    }
    Object localObject = new ssv.a(null);
    ((ssv.a)localObject).seq = paramInt;
    localObject = new WeakReference(localObject);
    this.bj.put(paramInt, localObject);
    return (ssv.a)((WeakReference)localObject).get();
  }
  
  void a(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    paramString = new IntentFilter(paramString);
    if (this.mRuntime.getActivity() != null) {
      this.mRuntime.getActivity().registerReceiver(paramBroadcastReceiver, paramString, "com.tencent.tim.msg.permission.pushnotify", null);
    }
  }
  
  int bq(String paramString)
  {
    if ("getRankingList".endsWith(paramString)) {
      return 1008;
    }
    if ("getHead".endsWith(paramString)) {
      return 1009;
    }
    if ("getJumpBtnState".endsWith(paramString)) {
      return 1010;
    }
    if ("getNick".endsWith(paramString)) {
      return 1011;
    }
    if ("takePhoto".endsWith(paramString)) {
      return 1012;
    }
    return -1;
  }
  
  boolean fn(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    if (this.bj == null) {
      return false;
    }
    Object localObject = (WeakReference)this.bj.get(paramInt);
    if (localObject == null) {
      return false;
    }
    localObject = (ssv.a)((WeakReference)localObject).get();
    if (localObject == null) {
      return false;
    }
    try
    {
      this.mRuntime.getActivity().unregisterReceiver((BroadcastReceiver)localObject);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  void h(String paramString, String... paramVarArgs)
  {
    callJs(paramString, paramVarArgs);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("PortalManager.HbEventPlugin", 2, "handleJsRequest: " + paramString3 + "," + paramVarArgs);
    }
    boolean bool1 = bool2;
    int i;
    if ("redEnvelope".endsWith(paramString2)) {
      if ((!"getRankingList".endsWith(paramString3)) && (!"getHead".endsWith(paramString3)) && (!"getJumpBtnState".endsWith(paramString3)) && (!"getNick".endsWith(paramString3)))
      {
        bool1 = bool2;
        if (!"takePhoto".endsWith(paramString3)) {}
      }
      else
      {
        i = uu();
        paramJsBridgeListener = a(i);
        a(paramJsBridgeListener, "com.tencent.portal.resp.action");
        if (paramVarArgs == null) {}
      }
    }
    try
    {
      if (paramVarArgs.length > 0)
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener.aGl = paramString1.getString("callback");
        paramJsBridgeListener.aGm = paramString1.getJSONObject("params").toString();
      }
      g("com.tencent.portal.req.action", bq(paramString3), i, paramJsBridgeListener.aGm);
      bool1 = true;
      return bool1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.bj != null) && (this.bj.size() > 0))
    {
      int i = 0;
      while (i < this.bj.size())
      {
        ssv.a locala = (ssv.a)((WeakReference)this.bj.get(i)).get();
        if (locala != null) {
          fn(locala.seq);
        }
        i += 1;
      }
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    public String aGl;
    public String aGm;
    public int seq;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("bc_seq", -1);
      if (i < 0) {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive sequence = " + i + "| wrong seq");
        }
      }
      byte[] arrayOfByte;
      do
      {
        do
        {
          return;
          if (i == this.seq) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive sequence != seq | miss hit");
        return;
        paramContext = paramIntent.getExtras();
        arrayOfByte = paramContext.getByteArray("bc_data");
        i = paramIntent.getIntExtra("portal_type_key", -1);
        if (arrayOfByte != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive data = null");
      return;
      if (QLog.isColorLevel())
      {
        if (i != 1009) {
          break label286;
        }
        paramContext = "REQ_TYPE_GET_HEAD returned";
      }
      for (;;)
      {
        QLog.d("PortalManager.HbEventPlugin", 2, "DataReceiver.onReceive | " + i + "," + this.seq + "," + this.aGl + "," + paramContext);
        switch (i)
        {
        default: 
          return;
        }
        ssv.this.fn(this.seq);
        paramIntent = alab.x(arrayOfByte);
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = new JSONObject();
        }
        try
        {
          paramContext.put("errorCode", -1);
          paramContext = paramContext.toString();
          ssv.this.h(this.aGl, new String[] { paramContext });
          return;
          label286:
          paramContext = paramContext.toString();
        }
        catch (JSONException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            paramContext = paramIntent;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssv
 * JD-Core Version:    0.7.0.1
 */