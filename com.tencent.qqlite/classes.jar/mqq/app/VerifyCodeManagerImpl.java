package mqq.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.VerifyCodeManager;
import mqq.observer.HttpVerifyHandler;
import mqq.observer.ServerNotifyObserver;

public class VerifyCodeManagerImpl
  implements VerifyCodeManager
{
  public static final int MANAGER_HTTPVERIFYCODE_CHANGE = 2;
  public static final int MANAGER_VERIFYCODE_CLOSE = 1;
  public static final int MANAGER_VERIFYCODE_RECEIVE = 0;
  private final AppRuntime app;
  ConcurrentHashMap<String, HttpVerifyCodeWrapper> httpVerifyCodeWrapperMap = new ConcurrentHashMap();
  private final Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
        ((ServerNotifyObserver)paramAnonymousMessage[0]).onReceiveVerifyCode((String)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue(), (String)paramAnonymousMessage[3], (byte[])paramAnonymousMessage[4]);
        return;
      }
      ((ServerNotifyObserver)((Object[])(Object[])paramAnonymousMessage.obj)[0]).onVerifyClose();
    }
  };
  ConcurrentHashMap<Integer, VerifyCodeWrapper> verifyCodeWrapperMap = new ConcurrentHashMap();
  
  public VerifyCodeManagerImpl(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  private FromServiceMsg createVerifyCodeCancelResp(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getAppId(), paramToServiceMsg.getAppSeq(), paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    localFromServiceMsg.setBusinessFail(2006, "");
    return localFromServiceMsg;
  }
  
  private void notifyApp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.app.getService().onRecvVerifyManagerCallback(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void notifyHttpVerifyCodeActivity(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Object localObject = (HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramString1);
    if ((localObject != null) && (((HttpVerifyCodeWrapper)localObject).serverNotifyObserver != null))
    {
      Message localMessage = this.mHandler.obtainMessage();
      localMessage.obj = new Object[] { ((HttpVerifyCodeWrapper)localObject).serverNotifyObserver, paramString1, Integer.valueOf(0), paramString2, paramArrayOfByte };
      localMessage.what = 0;
      localMessage.sendToTarget();
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).putExtra("key", paramString1);
    ((Intent)localObject).putExtra("note", paramString2);
    ((Intent)localObject).putExtra("image", paramArrayOfByte);
    ((Intent)localObject).setData(Uri.parse("mqqverifycode://puzzle_verify_code_qqlite/VERIFYCODEQQLITE?"));
    this.app.getApplication().startActivity((Intent)localObject);
  }
  
  private void notifyVerifyCodeActivity(ToServiceMsg paramToServiceMsg, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    int i = paramToServiceMsg.getRequestSsoSeq();
    String str = String.valueOf(paramToServiceMsg.getAttribute("process"));
    paramToServiceMsg = (VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(i));
    if (paramToServiceMsg.serverNotifyObserver != null)
    {
      localObject = this.mHandler.obtainMessage();
      ((Message)localObject).obj = new Object[] { paramToServiceMsg.serverNotifyObserver, "", Integer.valueOf(i), paramString1, paramArrayOfByte, paramString2 };
      ((Message)localObject).what = 0;
      ((Message)localObject).sendToTarget();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    paramToServiceMsg = "android.intent.action.VIEW";
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = "PUZZLEVERIFYCODEQQLITE";
      localIntent.putExtra("seq", i);
      localIntent.putExtra("url", paramString2);
      localIntent.putExtra("business", 2097152L);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("isSubaccount", true);
      localIntent.putExtra("isShowAd", false);
      paramString2 = paramToServiceMsg;
      localIntent.setAction(paramString2);
      if (!TextUtils.isEmpty(paramString1))
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("mqqverifycode://puzzle_verify_code_qqlite/");
        paramToServiceMsg.append(paramString1);
        paramToServiceMsg.append("?");
        localIntent.setData(Uri.parse(paramToServiceMsg.toString()));
      }
      this.app.getApplication().startActivity(localIntent);
      return;
    }
    if ("com.tencent.qqlite:openSdk".equals(str)) {
      paramString2 = "mqql.opensdk.intent.action.VERIFYCODE";
    }
    for (paramToServiceMsg = (ToServiceMsg)localObject;; paramToServiceMsg = (ToServiceMsg)localObject)
    {
      localIntent.putExtra("seq", i);
      localIntent.putExtra("note", paramString1);
      localIntent.putExtra("image", paramArrayOfByte);
      paramString1 = paramToServiceMsg;
      break;
      localObject = "VERIFYCODEQQLITE";
      paramString2 = paramToServiceMsg;
    }
  }
  
  private void notifyVerifyCodeActivityClose(ServerNotifyObserver paramServerNotifyObserver, String paramString)
  {
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.obj = new Object[] { paramServerNotifyObserver, paramString };
    localMessage.what = 1;
    localMessage.sendToTarget();
  }
  
  public void cancelVerifyCode(ServerNotifyObserver paramServerNotifyObserver)
  {
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject = (HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramServerNotifyObserver.getKey());
      if ((localObject != null) && (localObject != null))
      {
        HashMap localHashMap = ((HttpVerifyCodeWrapper)localObject).attr;
        ((HttpVerifyCodeWrapper)localObject).httpVerifyHandler.cancelVerifyCode(paramServerNotifyObserver.getKey(), localHashMap);
      }
    }
    do
    {
      return;
      paramServerNotifyObserver = (VerifyCodeWrapper)this.verifyCodeWrapperMap.remove(Integer.valueOf(paramServerNotifyObserver.getSeq()));
    } while (paramServerNotifyObserver == null);
    Object localObject = createVerifyCodeCancelResp(paramServerNotifyObserver.srcTo);
    notifyApp(paramServerNotifyObserver.srcTo, (FromServiceMsg)localObject);
  }
  
  public boolean checkVerifyCodeResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramFromServiceMsg.getBusinessFailCode() == 2002)
    {
      if (!this.verifyCodeWrapperMap.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
      {
        this.verifyCodeWrapperMap.putIfAbsent(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), new VerifyCodeWrapper(paramToServiceMsg.getRequestSsoSeq()));
        ((VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).srcTo = paramToServiceMsg;
      }
      paramFromServiceMsg = VerifyCodeInfo.getVerifyCodeInfo(paramFromServiceMsg);
      ((VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).verifyCodeInfo = paramFromServiceMsg;
      notifyVerifyCodeActivity(paramToServiceMsg, paramFromServiceMsg.verifyNote, paramFromServiceMsg.verifyimage, paramFromServiceMsg.verifyurl);
      bool1 = false;
    }
    VerifyCodeWrapper localVerifyCodeWrapper;
    do
    {
      do
      {
        return bool1;
        if (paramFromServiceMsg.getBusinessFailCode() == 2003) {
          break;
        }
        bool1 = bool2;
      } while (!this.verifyCodeWrapperMap.containsKey(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq())));
      localVerifyCodeWrapper = (VerifyCodeWrapper)this.verifyCodeWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
      paramToServiceMsg = "";
      if (!paramFromServiceMsg.isSuccess()) {
        paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      }
      if (localVerifyCodeWrapper.serverNotifyObserver != null) {
        notifyVerifyCodeActivityClose(localVerifyCodeWrapper.serverNotifyObserver, paramToServiceMsg);
      }
      bool1 = bool2;
    } while (paramFromServiceMsg.getBusinessFailCode() == 2016);
    paramFromServiceMsg.setMsfCommand(localVerifyCodeWrapper.srcTo.getMsfCommand());
    notifyApp(localVerifyCodeWrapper.srcTo, paramFromServiceMsg);
    return false;
  }
  
  public void onDestroy() {}
  
  public void onHttpVerifyCodeFail(String paramString1, String paramString2)
  {
    paramString1 = (HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramString1);
    if (paramString1 != null) {
      notifyVerifyCodeActivityClose(paramString1.serverNotifyObserver, paramString2);
    }
  }
  
  public void onHttpVerifyCodeSucc(String paramString)
  {
    paramString = (HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramString);
    if (paramString != null) {
      notifyVerifyCodeActivityClose(paramString.serverNotifyObserver, "");
    }
  }
  
  public void onRecvHttpVerifyCode(HttpVerifyHandler paramHttpVerifyHandler, byte[] paramArrayOfByte, String paramString, HashMap paramHashMap)
  {
    String str = (String)paramHashMap.get("key");
    if (!this.httpVerifyCodeWrapperMap.containsKey(str)) {
      this.httpVerifyCodeWrapperMap.putIfAbsent(str, new HttpVerifyCodeWrapper(str));
    }
    HttpVerifyCodeWrapper localHttpVerifyCodeWrapper = (HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(str);
    if (localHttpVerifyCodeWrapper != null)
    {
      localHttpVerifyCodeWrapper.httpVerifyHandler = paramHttpVerifyHandler;
      localHttpVerifyCodeWrapper.attr = paramHashMap;
      notifyHttpVerifyCodeActivity(str, paramString, paramArrayOfByte);
    }
  }
  
  public void refreVerifyCode(ServerNotifyObserver paramServerNotifyObserver)
  {
    Object localObject;
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject = (HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramServerNotifyObserver.getKey());
      if (localObject != null)
      {
        ((HttpVerifyCodeWrapper)localObject).serverNotifyObserver = paramServerNotifyObserver;
        HashMap localHashMap = ((HttpVerifyCodeWrapper)localObject).attr;
        ((HttpVerifyCodeWrapper)localObject).httpVerifyHandler.refreVerifyCode(paramServerNotifyObserver.getKey(), localHashMap);
      }
    }
    do
    {
      return;
      int i = paramServerNotifyObserver.getSeq();
      localObject = (VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(i));
      if (localObject != null)
      {
        ((VerifyCodeWrapper)localObject).serverNotifyObserver = paramServerNotifyObserver;
        paramServerNotifyObserver = this.app.getService().msfSub.getRefreVerifyCodeMsg(((VerifyCodeWrapper)localObject).verifyCodeInfo);
        paramServerNotifyObserver.setAppSeq(((VerifyCodeWrapper)localObject).verifyCodeInfo.appSeq);
        this.app.getService().msfSub.sendMsg(paramServerNotifyObserver);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VerifyCodeManager", 2, "wrapper is null");
  }
  
  public void submitPuzzleVerifyCodeTicket(int paramInt, String paramString)
  {
    Object localObject2 = (VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramInt));
    if (localObject2 != null)
    {
      Object localObject1 = ((VerifyCodeWrapper)localObject2).srcTo;
      paramString = this.app.getService().msfSub.getSubmitPuzzleVerifyCodeTicketMsg(paramString, ((VerifyCodeWrapper)localObject2).verifyCodeInfo);
      paramString.setAppSeq(((VerifyCodeWrapper)localObject2).verifyCodeInfo.appSeq);
      if (((ToServiceMsg)localObject1).getAttribute("from_where") != null)
      {
        localObject2 = (String)((ToServiceMsg)localObject1).getAttribute("from_where");
        localObject1 = (String)((ToServiceMsg)localObject1).getAttribute("mainaccount");
        paramString.addAttribute("from_where", localObject2);
        paramString.addAttribute("mainaccount", localObject1);
      }
      this.app.getService().msfSub.sendMsg(paramString);
    }
  }
  
  public void submitVerifyCode(ServerNotifyObserver paramServerNotifyObserver, String paramString)
  {
    Object localObject;
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject = (HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramServerNotifyObserver.getKey());
      if (localObject != null)
      {
        HashMap localHashMap = ((HttpVerifyCodeWrapper)localObject).attr;
        ((HttpVerifyCodeWrapper)localObject).serverNotifyObserver = paramServerNotifyObserver;
        ((HttpVerifyCodeWrapper)localObject).httpVerifyHandler.submitVerifyCode(paramServerNotifyObserver.getKey(), localHashMap, paramString);
      }
    }
    do
    {
      return;
      localObject = (VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramServerNotifyObserver.getSeq()));
    } while (localObject == null);
    ((VerifyCodeWrapper)localObject).serverNotifyObserver = paramServerNotifyObserver;
    paramServerNotifyObserver = ((VerifyCodeWrapper)localObject).srcTo;
    paramString = this.app.getService().msfSub.getSubmitVerifyCodeMsg(paramString, ((VerifyCodeWrapper)localObject).verifyCodeInfo);
    paramString.setAppSeq(((VerifyCodeWrapper)localObject).verifyCodeInfo.appSeq);
    if (paramServerNotifyObserver.getAttribute("from_where") != null)
    {
      localObject = (String)paramServerNotifyObserver.getAttribute("from_where");
      paramServerNotifyObserver = (String)paramServerNotifyObserver.getAttribute("mainaccount");
      paramString.addAttribute("from_where", localObject);
      paramString.addAttribute("mainaccount", paramServerNotifyObserver);
    }
    this.app.getService().msfSub.sendMsg(paramString);
  }
  
  class HttpVerifyCodeWrapper
  {
    HashMap attr;
    HttpVerifyHandler httpVerifyHandler;
    String key;
    ServerNotifyObserver serverNotifyObserver;
    
    public HttpVerifyCodeWrapper(String paramString)
    {
      this.key = paramString;
    }
  }
  
  class VerifyCodeWrapper
  {
    HashMap attr;
    int seq;
    ServerNotifyObserver serverNotifyObserver;
    ToServiceMsg srcTo;
    VerifyCodeInfo verifyCodeInfo;
    
    public VerifyCodeWrapper(int paramInt)
    {
      this.seq = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.app.VerifyCodeManagerImpl
 * JD-Core Version:    0.7.0.1
 */