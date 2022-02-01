import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class alcu
  extends VasWebviewJsPlugin
{
  private final int MENU_ITEM_SELECT_PHOTO = 0;
  public List<aldq> V = Collections.synchronizedList(new ArrayList());
  ausj am = null;
  public AtomicInteger bD = new AtomicInteger(-1);
  public AtomicInteger bE = new AtomicInteger(0);
  private boolean cwf;
  private aqva d;
  public int drV = -1;
  private final int drW = 1;
  private final int drX = 2;
  private BroadcastReceiver receiver = new alcv(this);
  
  public alcu()
  {
    this.mPluginNameSpace = "card";
  }
  
  private void SH(int paramInt)
  {
    if (!this.cwf)
    {
      this.cwf = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.closeWeb");
      this.mRuntime.getActivity().registerReceiver(this.receiver, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      dFc();
      czA();
      anot.a(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "1", "", "", "");
      return;
    case 1: 
      dFd();
      czA();
      anot.a(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "2", "", "", "");
      return;
    }
    czA();
    anot.a(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "3", "", "", "");
  }
  
  /* Error */
  private void czA()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	alcu:am	Lausj;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 58	alcu:am	Lausj;
    //   11: invokevirtual 141	ausj:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 58	alcu:am	Lausj;
    //   21: invokevirtual 144	ausj:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 58	alcu:am	Lausj;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 58	alcu:am	Lausj;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 58	alcu:am	Lausj;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	alcu
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  private void dFb()
  {
    czA();
    this.am = ausj.d(this.mRuntime.getActivity());
    this.am.addButton(this.mRuntime.getActivity().getResources().getString(2131719488));
    this.am.addButton(this.mRuntime.getActivity().getResources().getString(2131719499));
    this.am.addButton(this.mRuntime.getActivity().getResources().getString(2131721058));
    this.am.a(new alcw(this));
    this.am.setCanceledOnTouchOutside(true);
    try
    {
      this.am.show();
      anot.a(null, "CliOper", "", "", "card_mall", "0X80066C9", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
  
  private void dFc()
  {
    sendRemoteReq(affz.a("selectPhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  private void dFd()
  {
    sendRemoteReq(affz.a("takePhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  public int Ht()
  {
    if (this.V == null) {
      return -1;
    }
    if (this.bD.get() < 0)
    {
      if (this.V.size() > 0)
      {
        this.bD.set(0);
        return 0;
      }
      return -1;
    }
    if ((this.bD.get() >= this.V.size()) || (this.bD.get() < 0))
    {
      this.bD.set(-1);
      return -2;
    }
    int i = this.bD.get() + 1;
    while (i < this.V.size())
    {
      this.bD.set(i);
      if (((aldq)this.V.get(i)).ao == aldq.ai) {
        return 0;
      }
      i += 1;
    }
    return -1;
  }
  
  public void callPJs(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardWebviewPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  public void dFa()
  {
    if (this.bE.get() == 1) {}
    String str;
    for (;;)
    {
      return;
      try
      {
        if (Ht() == 0)
        {
          localObject = (aldq)this.V.get(this.bD.get());
          str = ((aldq)localObject).callback;
          Long localLong = ((aldq)localObject).Z;
          if (((aldq)localObject).cwl)
          {
            ((aldq)localObject).cwl = false;
            this.bE.set(1);
            localObject = affz.a("card_download_wzry_template", str, this.mOnRemoteResp.key, new Bundle());
            ((Bundle)localObject).putLong("bgId", localLong.longValue());
            sendRemoteReq((Bundle)localObject, false, false);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.bE.set(1);
    Object localObject = affz.a("card_download", str, this.mOnRemoteResp.key, new Bundle());
    ((Bundle)localObject).putLong("bgId", localException.longValue());
    sendRemoteReq((Bundle)localObject, false, false);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("card"))) {
      return false;
    }
    Object localObject2;
    Object localObject1;
    long l1;
    String str;
    int j;
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      if (paramString1 == null) {
        return false;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardWebviewPlugin", 2, "Failed to parse json str,json=" + paramVarArgs[0]);
        }
        paramString1 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardWebviewPlugin", 2, "method:" + paramString3 + ", json:" + paramString1.toString());
      }
      paramJsBridgeListener = "callback";
      localObject2 = new JSONObject();
      paramVarArgs = new JSONObject();
      localObject1 = this.mRuntime.getActivity().getApplicationContext();
      try
      {
        paramString2 = paramString1.optString("callback");
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("getInfo"))
        {
          paramJsBridgeListener = paramString2;
          sendRemoteReq(affz.a("card_getinfo", paramString2, this.mOnRemoteResp.key, new Bundle()), false, false);
        }
        else
        {
          paramJsBridgeListener = paramString2;
          if (paramString3.equals("setSummaryCard"))
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("DIYProfileTemplate.ProfileCardWebviewPlugin", 1, "setSummaryCard :" + paramString1);
            }
            paramJsBridgeListener = paramString2;
            paramString3 = affz.a("card_setSummaryCard", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString3.putInt("styleId", paramString1.getInt("styleId"));
            paramJsBridgeListener = paramString2;
            paramString3.putInt("bgId", paramString1.optInt("bgId", 0));
            paramJsBridgeListener = paramString2;
            paramString3.putLong("cardId", paramString1.optLong("cardId", 0L));
            paramJsBridgeListener = paramString2;
            paramString3.putString("extInfo", paramString1.optString("extInfo"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("renderInfo", paramString1.optString("renderInfo"));
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString3, false, false);
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        try
        {
          paramVarArgs.put("result", -1);
          paramVarArgs.put("message", "ProfileCardWebviewPlugin Exception");
          callPJs(paramJsBridgeListener, paramVarArgs.toString());
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("download"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = paramString1.getString("image_url");
          paramJsBridgeListener = paramString2;
          localObject2 = paramString1.optString("dynamicZip");
          paramJsBridgeListener = paramString2;
          i = paramString1.optInt("id");
          paramJsBridgeListener = paramString2;
          if (alco.b((Context)localObject1, i, "cardPreview.jpg"))
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("ProfileCardWebviewPlugin", 2, "handleJsRequest bg exists, dynamicZip = " + (String)localObject2);
            }
            paramJsBridgeListener = paramString2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("result", 0);
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("message", "local has");
              paramJsBridgeListener = paramString2;
              callPJs(paramString2, paramVarArgs.toString());
              return true;
            }
            paramJsBridgeListener = paramString2;
            if (alco.b((Context)localObject1, i, ".dynamic"))
            {
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("result", 0);
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("message", "local has");
              paramJsBridgeListener = paramString2;
              callPJs(paramString2, paramVarArgs.toString());
              return true;
            }
          }
          paramJsBridgeListener = paramString2;
          if (!aqiw.isNetSupport(this.mRuntime.getActivity().getApplicationContext()))
          {
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -2);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "no network");
            paramJsBridgeListener = paramString2;
            callPJs(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          l1 = aqep.hD();
          if (l1 < 102400)
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("ProfileCardWebviewPlugin", 2, "Insufficient SDCard space, reserved:" + 102400 + "|available:" + l1);
            }
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -3);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "Insufficient SDCard space.");
            paramJsBridgeListener = paramString2;
            callPJs(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          if (this.bE.get() == 1)
          {
            paramJsBridgeListener = paramString2;
            if (((aldq)this.V.get(this.bD.get())).ao == aldq.al)
            {
              paramJsBridgeListener = paramString2;
              if (((aldq)this.V.get(this.bD.get())).bgUrl.equalsIgnoreCase(paramString3))
              {
                paramJsBridgeListener = paramString2;
                if (paramString1.getLong("id") == ((aldq)this.V.get(this.bD.get())).Z.longValue())
                {
                  paramJsBridgeListener = paramString2;
                  ((aldq)this.V.get(this.bD.get())).ao = aldq.aj;
                  paramJsBridgeListener = paramString2;
                  ((aldq)this.V.get(this.bD.get())).callback = paramString2;
                  return true;
                }
              }
            }
          }
          paramJsBridgeListener = paramString2;
          paramString1 = new aldq();
          paramJsBridgeListener = paramString2;
          paramString1.Z = Long.valueOf(i);
          paramJsBridgeListener = paramString2;
          paramString1.bgUrl = paramString3;
          paramJsBridgeListener = paramString2;
          paramString1.strZipUrl = ((String)localObject2);
          paramJsBridgeListener = paramString2;
          paramString1.callback = paramString2;
          paramJsBridgeListener = paramString2;
          paramString1.am = Integer.valueOf(0);
          paramJsBridgeListener = paramString2;
          paramString1.ao = aldq.ai;
          paramJsBridgeListener = paramString2;
          this.V.add(paramString1);
          paramJsBridgeListener = paramString2;
          if (this.bE.get() != 0) {
            break label3637;
          }
          paramJsBridgeListener = paramString2;
          dFa();
          break label3637;
        }
        paramJsBridgeListener = paramString2;
        if (!paramString3.equals("queryDownloadInfo")) {
          break label1741;
        }
      }
      paramJsBridgeListener = paramString2;
      paramString3 = paramString1.getString("image_url");
      paramJsBridgeListener = paramString2;
      str = paramString1.optString("dynamicZip");
      paramJsBridgeListener = paramString2;
      j = paramString1.optInt("id");
      paramJsBridgeListener = paramString2;
      if (!alco.b((Context)localObject1, j, "cardPreview.jpg")) {
        break label1217;
      }
    }
    paramJsBridgeListener = paramString2;
    if (!TextUtils.isEmpty(str))
    {
      paramJsBridgeListener = paramString2;
      if (!alco.b((Context)localObject1, j, ".dynamic")) {}
    }
    else
    {
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 3);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 100);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
    }
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("data", localObject2);
      paramJsBridgeListener = paramString2;
      callPJs(paramString2, paramVarArgs.toString());
      break label3637;
      label1217:
      paramJsBridgeListener = paramString2;
      if (this.bD.get() >= 0) {
        break;
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
    }
    paramJsBridgeListener = paramString2;
    int i = this.bD.get();
    paramJsBridgeListener = paramString2;
    if (i < this.V.size())
    {
      paramJsBridgeListener = paramString2;
      if (!((aldq)this.V.get(i)).bgUrl.equalsIgnoreCase(paramString3)) {
        break label3639;
      }
      paramJsBridgeListener = paramString2;
      if (j != ((aldq)this.V.get(i)).Z.longValue()) {
        break label3639;
      }
      paramJsBridgeListener = paramString2;
      if (((aldq)this.V.get(i)).ao == aldq.al) {
        break label3639;
      }
      paramJsBridgeListener = paramString2;
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = paramString2;
        QLog.i("ProfileCardWebviewPlugin", 2, "mIndex:" + this.bD.get() + ",id:" + ((aldq)this.V.get(i)).Z + "status:" + ((aldq)this.V.get(i)).ao);
      }
      paramJsBridgeListener = paramString2;
      if (((aldq)this.V.get(i)).ao != aldq.ai)
      {
        paramJsBridgeListener = paramString2;
        if (((aldq)this.V.get(i)).ao != aldq.aj) {}
      }
      else
      {
        paramJsBridgeListener = paramString2;
        paramString1 = affz.a("card_query_download", paramString2, this.mOnRemoteResp.key, new Bundle());
        paramJsBridgeListener = paramString2;
        paramString1.putInt("bgId", j);
        paramJsBridgeListener = paramString2;
        sendRemoteReq(paramString1, false, false);
        return true;
      }
      paramJsBridgeListener = paramString2;
      if (((aldq)this.V.get(i)).ao != aldq.ak) {
        break label1714;
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", ((aldq)this.V.get(i)).am);
    }
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", ((aldq)this.V.get(i)).an);
      paramJsBridgeListener = paramString2;
      if (i < this.V.size()) {
        break;
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
      break;
      label1714:
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 0);
    }
    label1741:
    paramJsBridgeListener = paramString2;
    label1976:
    label2751:
    int k;
    if (paramString3.equals("preview"))
    {
      paramJsBridgeListener = paramString2;
      paramString3 = new Intent(this.mRuntime.getActivity(), VipProfileCardPreviewActivity.class);
      paramJsBridgeListener = paramString2;
      paramString3.putExtra("preview", paramString1.toString());
      paramJsBridgeListener = paramString2;
      super.startActivityForResult(paramString3, (byte)1);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("message", "ok");
      paramJsBridgeListener = paramString2;
      callPJs(paramString2, paramVarArgs.toString());
    }
    else
    {
      paramJsBridgeListener = paramString2;
      if (paramString3.equals("getTime"))
      {
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("data", NetConnInfoCenter.getServerTimeMillis());
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("result", 0);
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("message", "");
        paramJsBridgeListener = paramString2;
        callPJs(paramString2, paramVarArgs.toString());
      }
      else
      {
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("cancelDownload"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = paramString1.getString("image_url");
          paramJsBridgeListener = paramString2;
          l1 = paramString1.getLong("id");
          paramJsBridgeListener = paramString2;
          if (this.bD.get() == -1)
          {
            paramJsBridgeListener = paramString2;
            this.bD.set(0);
          }
          paramJsBridgeListener = paramString2;
          i = this.bD.get();
          paramJsBridgeListener = paramString2;
          if (i < this.V.size())
          {
            paramJsBridgeListener = paramString2;
            if (((aldq)this.V.get(i)).Z.longValue() != l1) {
              break label3648;
            }
            paramJsBridgeListener = paramString2;
            if (!((aldq)this.V.get(i)).bgUrl.equalsIgnoreCase(paramString3)) {
              break label3648;
            }
            paramJsBridgeListener = paramString2;
            if (((aldq)this.V.get(i)).ao == aldq.al) {
              break label3648;
            }
            paramJsBridgeListener = paramString2;
            paramString1 = affz.a("card_cancel_download", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString1.putLong("bgId", l1);
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString1, false, false);
            paramJsBridgeListener = paramString2;
            this.bE.set(0);
            paramJsBridgeListener = paramString2;
            ((aldq)this.V.get(i)).ao = aldq.al;
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", 0);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "ok");
          }
          paramJsBridgeListener = paramString2;
          if (i == this.V.size())
          {
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -2);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "cancel download fail， bgId:" + l1);
          }
          paramJsBridgeListener = paramString2;
          callPJs(paramString2, paramVarArgs.toString());
          paramJsBridgeListener = paramString2;
          paramString1 = new JSONObject();
          paramJsBridgeListener = paramString2;
          try
          {
            paramString1.put("result", -1);
            paramJsBridgeListener = paramString2;
            paramString1.put("message", "cancel download bgUrl:" + ((aldq)this.V.get(i)).bgUrl);
            paramJsBridgeListener = paramString2;
            callPJs(((aldq)this.V.get(i)).callback, paramString1.toString());
          }
          catch (JSONException paramString1)
          {
            paramJsBridgeListener = paramString2;
            paramString1.printStackTrace();
          }
        }
        else
        {
          paramJsBridgeListener = paramString2;
          if (paramString3.equals("report"))
          {
            paramJsBridgeListener = paramString2;
            paramString3 = affz.a("card_getVipInfo", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString3.putString("op_name", paramString1.getString("op_name"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext1", paramString1.getString("ext1"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext2", paramString1.getString("ext2"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext3", paramString1.getString("ext3"));
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString3, false, false);
          }
          else
          {
            paramJsBridgeListener = paramString2;
            if (paramString3.equals("openView"))
            {
              paramJsBridgeListener = paramString2;
              paramString1 = paramString1.getString("ADTAG");
              paramJsBridgeListener = paramString2;
              paramString3 = this.mRuntime.getActivity();
              if (paramString3 != null)
              {
                paramJsBridgeListener = paramString2;
                localObject1 = new Intent(paramString3, QQBrowserActivity.class);
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("uin", this.mRuntime.a().getAccount());
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("isShowAd", false);
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("url", aqqj.o(paramString3, "card", paramString1));
                paramJsBridgeListener = paramString2;
                paramString3.startActivity((Intent)localObject1);
              }
            }
            else
            {
              paramJsBridgeListener = paramString2;
              if (paramString3.equals("clickPhotoWall"))
              {
                paramJsBridgeListener = paramString2;
                paramString1 = this.mRuntime.a(this.mRuntime.getActivity());
                if (paramString1 != null)
                {
                  paramJsBridgeListener = paramString2;
                  if ((paramString1 instanceof ardm.o))
                  {
                    paramJsBridgeListener = paramString2;
                    paramString1 = ((ardm.o)paramString1).getCurrentUrl();
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty(paramString1)) {
                      break label2751;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!paramString1.contains("entryId")) {
                      break label2751;
                    }
                    paramJsBridgeListener = paramString2;
                  }
                }
                for (this.drV = aurr.getInt(aurr.getArgumentsFromURL(paramString1), "entryId", 2);; this.drV = 2)
                {
                  paramJsBridgeListener = paramString2;
                  paramString1 = this.mRuntime.a().getAccount();
                  paramJsBridgeListener = paramString2;
                  paramString3 = avpw.d.a();
                  paramJsBridgeListener = paramString2;
                  paramString3.cMP = paramString1;
                  paramJsBridgeListener = paramString2;
                  avpw.a(this.mRuntime.getActivity(), paramString3, null, paramString1, getRequestCode((byte)2));
                  break;
                  paramJsBridgeListener = paramString2;
                }
              }
              paramJsBridgeListener = paramString2;
              if (paramString3.equals("uploadBackground"))
              {
                paramJsBridgeListener = paramString2;
                dFb();
                paramJsBridgeListener = paramString2;
                paramVarArgs.put("result", 0);
                paramJsBridgeListener = paramString2;
                paramVarArgs.put("message", "ok");
                paramJsBridgeListener = paramString2;
                callPJs(paramString2, paramVarArgs.toString());
              }
              else
              {
                paramJsBridgeListener = paramString2;
                if (paramString3.equals("setGameHonour"))
                {
                  paramJsBridgeListener = paramString2;
                  paramString3 = affz.a("card_set_custom_honor", paramString2, this.mOnRemoteResp.key, new Bundle());
                  paramJsBridgeListener = paramString2;
                  paramString3.putString("honor_data", paramString1.toString());
                  paramJsBridgeListener = paramString2;
                  sendRemoteReq(paramString3, false, false);
                }
                else
                {
                  paramJsBridgeListener = paramString2;
                  if (paramString3.equals("downloadWzResource"))
                  {
                    paramJsBridgeListener = paramString2;
                    l1 = paramString1.optLong("id");
                    paramJsBridgeListener = paramString2;
                    localObject2 = paramString1.optString("bgUrl");
                    paramJsBridgeListener = paramString2;
                    paramString1.optString("dynamicZip");
                    paramJsBridgeListener = paramString2;
                    paramString3 = paramString1.optString("wzHeroUrl");
                    paramJsBridgeListener = paramString2;
                    if (!aldx.cz(paramString1.optInt("styleId"))) {
                      break label3657;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!aldx.W((Context)localObject1, "cardWZ.zip")) {
                      break label3657;
                    }
                    i = 1;
                    label2974:
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label3663;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!alco.b((Context)localObject1, l1, "wzJoinImage.png")) {
                      break label3663;
                    }
                    j = 1;
                    label3002:
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty(paramString3)) {
                      break label3669;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!alco.b((Context)localObject1, l1, "wzMainImage.png")) {
                      break label3669;
                    }
                    k = 1;
                    label3030:
                    if ((i != 0) && (j != 0))
                    {
                      bool = true;
                      paramJsBridgeListener = paramString2;
                      if (!TextUtils.isEmpty(paramString3))
                      {
                        paramJsBridgeListener = paramString2;
                        bool = alco.b((Context)localObject1, l1, "wzMainImage.png");
                      }
                      if (bool)
                      {
                        paramJsBridgeListener = paramString2;
                        paramVarArgs.put("result", 0);
                        paramJsBridgeListener = paramString2;
                        paramVarArgs.put("progress", 100);
                        paramJsBridgeListener = paramString2;
                        callJs(paramString2, new String[] { paramVarArgs.toString() });
                        return true;
                      }
                    }
                    paramJsBridgeListener = paramString2;
                    if (!aqiw.isNetSupport(this.mRuntime.getActivity().getApplicationContext()))
                    {
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("result", -2);
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("message", "no network");
                      paramJsBridgeListener = paramString2;
                      callPJs(paramString2, paramVarArgs.toString());
                      return true;
                    }
                    paramJsBridgeListener = paramString2;
                    long l2 = aqep.hD();
                    if (l2 < 102400)
                    {
                      paramJsBridgeListener = paramString2;
                      if (QLog.isColorLevel())
                      {
                        paramJsBridgeListener = paramString2;
                        QLog.d("ProfileCardWebviewPlugin", 2, "Insufficient SDCard space, reserved:" + 102400 + "|available:" + l2);
                      }
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("result", -3);
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("message", "Insufficient SDCard space.");
                      paramJsBridgeListener = paramString2;
                      callPJs(paramString2, paramVarArgs.toString());
                      return true;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!this.V.isEmpty())
                    {
                      paramJsBridgeListener = paramString2;
                      if (this.bD.get() >= 0)
                      {
                        paramJsBridgeListener = paramString2;
                        if (this.bD.get() < this.V.size())
                        {
                          paramJsBridgeListener = paramString2;
                          paramString1 = (aldq)this.V.get(this.bD.get());
                          paramJsBridgeListener = paramString2;
                          if (this.bE.get() == 1)
                          {
                            paramJsBridgeListener = paramString2;
                            if (paramString1.ao.equals(aldq.al))
                            {
                              paramJsBridgeListener = paramString2;
                              if (paramString1.bgUrl.equalsIgnoreCase((String)localObject2))
                              {
                                paramJsBridgeListener = paramString2;
                                if (l1 == paramString1.Z.longValue())
                                {
                                  paramJsBridgeListener = paramString2;
                                  paramString1.ao = aldq.aj;
                                  paramJsBridgeListener = paramString2;
                                  paramString1.callback = paramString2;
                                  return true;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    paramJsBridgeListener = paramString2;
                    localObject1 = new aldq();
                    paramJsBridgeListener = paramString2;
                    ((aldq)localObject1).Z = Long.valueOf(l1);
                    paramJsBridgeListener = paramString2;
                    ((aldq)localObject1).bgUrl = ((String)localObject2);
                    paramJsBridgeListener = paramString2;
                    ((aldq)localObject1).callback = paramString2;
                    if (k == 0) {
                      break label3675;
                    }
                    paramString1 = null;
                    label3475:
                    paramJsBridgeListener = paramString2;
                    ((aldq)localObject1).bVT = paramString1;
                    if (i != 0) {
                      break label3681;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label3637:
    label3639:
    label3648:
    label3657:
    label3663:
    label3669:
    label3675:
    label3681:
    for (boolean bool = true;; bool = false)
    {
      paramJsBridgeListener = paramString2;
      ((aldq)localObject1).cwl = bool;
      paramJsBridgeListener = paramString2;
      ((aldq)localObject1).cwk = true;
      paramJsBridgeListener = paramString2;
      ((aldq)localObject1).am = Integer.valueOf(0);
      paramJsBridgeListener = paramString2;
      ((aldq)localObject1).ao = aldq.ai;
      paramJsBridgeListener = paramString2;
      this.V.add(localObject1);
      paramJsBridgeListener = paramString2;
      if (this.bE.get() == 0)
      {
        paramJsBridgeListener = paramString2;
        dFa();
        break label3637;
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("setSwitchOfKingGlory"))
        {
          paramJsBridgeListener = paramString2;
          i = paramString1.optInt("status");
          paramJsBridgeListener = paramString2;
          paramString1 = new Bundle();
          paramJsBridgeListener = paramString2;
          paramString1.putInt("status", i);
          paramJsBridgeListener = paramString2;
          sendRemoteReq(affz.a("ipc_plateofking_switch", paramString2, this.mOnRemoteResp.key, paramString1), false, false);
        }
        else
        {
          return false;
        }
      }
      return true;
      i += 1;
      break;
      i += 1;
      break label1976;
      i = 0;
      break label2974;
      j = 0;
      break label3002;
      k = 0;
      break label3030;
      paramString1 = paramString3;
      break label3475;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, "ProfileCardWebviewPlugin onActivityResult,requestCode = " + paramByte + ", resultCode = " + paramInt + ", data = " + paramIntent);
    }
    if (paramInt != -1) {}
    while (paramIntent == null) {
      return;
    }
    if ((paramByte == 1) || (paramByte == 2)) {}
    try
    {
      if (this.drV != 0)
      {
        Object localObject2 = paramIntent.getStringExtra("uin");
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.mRuntime.a().getCurrentAccountUin();
        }
        localObject2 = new Intent(this.mRuntime.getActivity(), FriendProfileCardActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", new ProfileActivity.AllInOne((String)localObject1, 0));
        this.mRuntime.getActivity().startActivity((Intent)localObject2);
      }
      paramIntent.putExtra("closeSpecialLogic", true);
      this.mRuntime.getActivity().setResult(-1, paramIntent);
      this.mRuntime.getActivity().finish();
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.d = new aqva(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d.onDestroy();
    try
    {
      if (this.cwf) {
        this.mRuntime.getActivity().unregisterReceiver(this.receiver);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ProfileCardWebviewPlugin", 2, "unregister receiver exception:" + localException.toString());
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        String str2;
        String str1;
        Bundle localBundle;
        try
        {
          if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            break;
          }
          localObject2 = new JSONObject();
          localObject1 = new JSONObject();
          str2 = paramBundle.getString("cmd");
          str1 = paramBundle.getString("callbackid");
          localBundle = paramBundle.getBundle("response");
          if (str2 == null) {
            break;
          }
          if ("card_getinfo".equals(str2))
          {
            long l1 = localBundle.getLong("currentId");
            long l2 = localBundle.getLong("styleId");
            int j = localBundle.getInt("result");
            paramBundle = localBundle.getString("diy_url");
            i = 0;
            if ((l2 == alcs.agh) || (l2 == alcs.agc) || (l2 == alcs.agj)) {
              break label811;
            }
            ((JSONObject)localObject2).put("currentId", l1);
            ((JSONObject)localObject2).put("styleId", l2);
            ((JSONObject)localObject2).put("isPhotoWall", i);
            ((JSONObject)localObject2).put("url", paramBundle);
            ((JSONObject)localObject1).put("data", localObject2);
            ((JSONObject)localObject1).put("result", j);
            callPJs(str1, ((JSONObject)localObject1).toString());
            return;
          }
          if ("card_setSummaryCard".equals(str2))
          {
            i = localBundle.getInt("result");
            paramBundle = localBundle.getString("message");
            ((JSONObject)localObject1).put("result", i);
            ((JSONObject)localObject1).put("message", paramBundle);
            callPJs(str1, ((JSONObject)localObject1).toString());
            return;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        if ("card_getVipInfo".equals(str2))
        {
          anot.a(null, "P_CliOper", "Vip_SummaryCard", "", paramBundle.getString("op_name"), paramBundle.getString("op_name"), 0, 0, paramBundle.getString("ext1"), paramBundle.getString("ext2"), paramBundle.getString("ext3"), localBundle.getString("vip_info"));
          ((JSONObject)localObject1).put("result", 0);
          ((JSONObject)localObject1).put("message", "ok");
          callPJs(str1, ((JSONObject)localObject1).toString());
          return;
        }
        if (("selectPhoto".equals(str2)) || ("takePhoto".equals(str2))) {
          break;
        }
        if ("card_download_wzry_template".equals(str2))
        {
          i = localBundle.getInt("result");
          localObject2 = localBundle.getString("message");
          if (i != 0)
          {
            ((JSONObject)localObject1).put("result", -1);
            ((JSONObject)localObject1).put("message", localObject2);
            callPJs(str1, ((JSONObject)localObject1).toString());
            this.bE.set(0);
            return;
          }
          localObject1 = affz.a("card_download", str1, this.mOnRemoteResp.key, new Bundle());
          ((Bundle)localObject1).putLong("bgId", paramBundle.getLong("bgId"));
          sendRemoteReq((Bundle)localObject1, false, false);
          return;
        }
        if ("card_download".equals(str2))
        {
          ((JSONObject)localObject1).put("result", localBundle.getInt("result"));
          ((JSONObject)localObject1).put("message", "onHttpEnd");
          if (((aldq)this.V.get(this.bD.get())).ao != aldq.al) {
            ((aldq)this.V.get(this.bD.get())).ao = aldq.ak;
          }
          ((aldq)this.V.get(this.bD.get())).am = Integer.valueOf(100);
          callPJs(str1, ((JSONObject)localObject1).toString());
          this.bE.set(0);
          dFa();
          return;
        }
        if (!"card_query_download".equals(str2)) {
          break;
        }
        ((JSONObject)localObject1).put("result", 0);
        ((JSONObject)localObject2).put("status", 2);
        int i = localBundle.getInt("progress");
        ((JSONObject)localObject2).put("progress", i);
        if (((aldq)this.V.get(this.bD.get())).ao != aldq.ak) {
          ((aldq)this.V.get(this.bD.get())).am = Integer.valueOf(i);
        }
        ((JSONObject)localObject1).put("data", localObject2);
        callPJs(str1, ((JSONObject)localObject1).toString());
        return;
        label811:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alcu
 * JD-Core Version:    0.7.0.1
 */