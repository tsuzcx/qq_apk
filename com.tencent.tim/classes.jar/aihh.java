import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin.1;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.ResultInfo;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenIdentify;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenStart;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aihh
  extends WebViewPlugin
  implements aihr.a, Handler.Callback, View.OnClickListener, EIPCResultCallback
{
  private TogetherBusinessServlet.RspOpenIdentify jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify;
  private TogetherBusinessServlet.RspOpenStart jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart;
  private String bNK;
  private String bgD;
  private boolean ckn = true;
  private Button gr;
  private String mAppId;
  private String mCallBack;
  private int mSessionType = -1;
  private Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  private long mUin = -1L;
  private View xR;
  
  public aihh()
  {
    this.mPluginNameSpace = "together_business";
    aihr.a().a(this);
    try
    {
      QIPCClientHelper.getInstance().register(aihu.a());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TogetherBusinessForWebPlugin", 1, new Object[] { "register WatchTogetherClientIPCModule ipc module error.", localException.getMessage() });
    }
  }
  
  private boolean D(Bundle paramBundle)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.confirmText))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button confirmText is empty");
      }
      return false;
    }
    Message localMessage = this.mUIHandler.obtainMessage(2);
    localMessage.obj = new aihh.a(null, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.confirmText, new aihi(this, paramBundle));
    this.mUIHandler.sendMessage(localMessage);
    return true;
  }
  
  private void Ld(String paramString)
  {
    if (this.xR != null)
    {
      this.xR.setVisibility(0);
      if (this.gr != null) {
        this.gr.setText(paramString);
      }
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.mRuntime.b() != null)
    {
      localObject1 = (ViewGroup)LayoutInflater.from(this.mRuntime.getActivity()).inflate(2131560156, null);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      if (this.mRuntime.b().a.mRootView != null) {
        this.mRuntime.b().a.mRootView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
    }
    for (;;)
    {
      this.xR = ((ViewGroup)this.mRuntime.getActivity().findViewById(2131373751));
      if (this.xR == null) {
        break;
      }
      this.xR.setBackgroundColor(this.xR.getResources().getColor(2131167278));
      localObject1 = this.xR.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = wja.dp2px(75.0F, this.xR.getResources());
      this.xR.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.xR.setVisibility(0);
      ((ImageView)this.mRuntime.getActivity().findViewById(2131365990)).setVisibility(8);
      localObject1 = (ViewGroup)this.mRuntime.getActivity().findViewById(2131363642);
      int i = wja.dp2px(16.0F, ((ViewGroup)localObject1).getResources());
      ((ViewGroup)localObject1).setPadding(i, 0, i, 0);
      localObject2 = new Button(this.mRuntime.getActivity());
      ((Button)localObject2).setText(paramString);
      ((Button)localObject2).setGravity(17);
      ((Button)localObject2).setTextColor(this.mRuntime.getActivity().getResources().getColor(2131167335));
      ((Button)localObject2).setBackground(this.mRuntime.getActivity().getDrawable(2130839524));
      ((Button)localObject2).setTextSize(1, 17.0F);
      this.gr = ((Button)localObject2);
      this.gr.setOnClickListener(this);
      paramString = new RelativeLayout.LayoutParams(-1, wja.dp2px(45.0F, this.xR.getResources()));
      paramString.addRule(15);
      ((ViewGroup)localObject1).addView((View)localObject2, paramString);
      return;
      localObject1 = ((ViewStub)this.mRuntime.getActivity().findViewById(2131372784)).inflate();
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = -2;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  private void V(String... paramVarArgs)
  {
    try
    {
      this.mCallBack = new JSONObject(paramVarArgs[0]).optString("callback", "");
      return;
    }
    catch (JSONException paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherBusinessForWebPlugin", 2, paramVarArgs, new Object[0]);
      return;
    }
    catch (Throwable paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherBusinessForWebPlugin", 2, paramVarArgs, new Object[0]);
    }
  }
  
  private Bundle a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("uinType", -1);
    if (j == -1) {
      j = paramIntent.getIntExtra("curtype", -1);
    }
    for (;;)
    {
      int i;
      switch (j)
      {
      default: 
        paramIntent = null;
        i = -1;
        if ((TextUtils.isEmpty(paramIntent)) || (i == -1)) {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "curType or uin is error: uinType=" + j + " chatId=" + paramIntent);
          }
        }
        break;
      }
      for (;;)
      {
        return null;
        paramIntent = paramIntent.getStringExtra("friend_uin");
        i = 2;
        break;
        i = 1;
        paramIntent = paramIntent.getStringExtra("groupUin");
        break;
        try
        {
          l = Long.parseLong(paramIntent);
          if (l != -1L)
          {
            a(l, i, paramString1, paramString2, paramString3);
            paramIntent = new Bundle();
            paramIntent.putString("req_data", paramString1);
            paramIntent.putString("req_sign", paramString2);
            paramIntent.putInt("session_type", i);
            paramIntent.putLong("uin", l);
            paramIntent.putString("appid", paramString3);
            return paramIntent;
          }
        }
        catch (NumberFormatException paramIntent)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "uin string to long error");
            }
            long l = -1L;
          }
        }
      }
    }
  }
  
  private Bundle a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    Object localObject;
    String str;
    Intent localIntent;
    for (;;)
    {
      return null;
      try
      {
        localObject = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject).optString("req_data");
        localObject = ((JSONObject)localObject).optString("req_sign");
        if (((TextUtils.isEmpty(paramVarArgs)) || (TextUtils.isEmpty((CharSequence)localObject))) && (QLog.isColorLevel())) {
          QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam param error" + " data=" + paramVarArgs + " sign=" + (String)localObject);
        }
        str = new JSONObject(paramVarArgs).optString("appid");
        localIntent = getIntent();
        if (localIntent == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
          return null;
        }
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return null;
      }
    }
    paramVarArgs = a(paramVarArgs, (String)localObject, str, localIntent);
    return paramVarArgs;
  }
  
  private void a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mUin = paramLong;
    this.mSessionType = paramInt;
    this.bgD = paramString1;
    this.bNK = paramString2;
    this.mAppId = paramString3;
  }
  
  private boolean a(TogetherBusinessServlet.ResultInfo paramResultInfo)
  {
    if ((paramResultInfo == null) || (!paramResultInfo.showErrorMsg)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button resultInfo is empty or no need showErrorMsg");
      }
    }
    do
    {
      return false;
      if (!TextUtils.isEmpty(paramResultInfo.errorMsg)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button errorMsg is empty");
    return false;
    Message localMessage = this.mUIHandler.obtainMessage(1);
    localMessage.obj = paramResultInfo.errorMsg;
    localMessage.arg1 = 0;
    this.mUIHandler.sendMessage(localMessage);
    return true;
  }
  
  private void aL(int paramInt, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.a(localBaseApplication, paramInt, paramString, 1).show(localBaseApplication.getResources().getDimensionPixelSize(2131299627));
  }
  
  private boolean aoX()
  {
    if (!aqiw.isNetSupport(null))
    {
      Message localMessage = this.mUIHandler.obtainMessage(1);
      localMessage.obj = "当前网络不可用，请检查网络设置。";
      localMessage.arg1 = 1;
      this.mUIHandler.sendMessage(localMessage);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button network not well");
      }
      return true;
    }
    return false;
  }
  
  private String b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "getShowButtonCallBack isShow=" + paramBoolean + " text=" + paramString);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("is_show_button", paramBoolean);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("button_text", paramString);
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void d(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null)) {
      return;
    }
    aqju localaqju = new aqju(this.mRuntime.getActivity(), 2131756467);
    localaqju.setContentView(2131559151);
    if (!TextUtils.isEmpty(paramString1)) {
      localaqju.setTitle(paramString1);
    }
    for (;;)
    {
      localaqju.setMessage(paramString2);
      localaqju.setCanceledOnTouchOutside(false);
      localaqju.setCancelable(false);
      localaqju.setNegativeButton(this.mRuntime.getActivity().getString(2131691040), new aihj(this, localaqju));
      localaqju.setPositiveButton(this.mRuntime.getActivity().getString(2131691042), paramOnClickListener);
      localaqju.show();
      return;
      localaqju.setTitle(null);
    }
  }
  
  private Intent getIntent()
  {
    if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null)) {
      return null;
    }
    return this.mRuntime.getActivity().getIntent();
  }
  
  private JSONObject j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "quitOrCloseMsg type=" + paramInt);
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("type", paramInt);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private boolean m(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return true;
    }
    try
    {
      boolean bool = new JSONObject(paramVarArgs[0]).optBoolean("draw_button_by_qq", true);
      return bool;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return true;
  }
  
  public void PN(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("closeOrQuitBusiness ");
      localStringBuilder.append("type=").append(paramInt);
      QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
    }
    dispatchJsEvent("close_business", j(paramInt), null);
  }
  
  public void PO(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("playOrPauseVideo ");
      localStringBuilder.append("type=").append(paramInt);
      QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
    }
    dispatchJsEvent("play_control", j(paramInt), null);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934595L) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("ti.qq.com/sportslive/mini/room")))
    {
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder().append("handleEvent type =");
        if (paramLong != 8589934595L) {
          break label82;
        }
      }
      label82:
      for (paramString = "load_error";; paramString = "http_error")
      {
        QLog.d("TogetherBusinessForWebPlugin", 2, paramString);
        aihr.a().PP(2);
        return true;
      }
    }
    if (paramLong == 8589934623L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "handleEvent type =init_webview_complete");
      }
      aihr.a().dsv();
      return true;
    }
    if ((paramLong == 8589934600L) && (paramMap != null))
    {
      if ((paramMap.get("requestCode") == null) || (!(paramMap.get("requestCode") instanceof Integer))) {
        return false;
      }
      Integer localInteger = (Integer)paramMap.get("requestCode");
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "handleEvent type =on activityResult requestCode=" + localInteger);
      }
      if (localInteger.intValue() == 200)
      {
        aihr.a().a(null);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "Call TogetherBusinessForWebPlugin handleJsRequest, url=" + paramString1 + " pkgName=" + paramString2 + " method=" + paramString3);
    }
    if ("together_business".equals(paramString2))
    {
      if ("show_together_button".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherBusinessForWebPlugin", 2, "call show_together_button");
        }
        a(-1L, -1, null, null, null);
        this.ckn = true;
        this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify = null;
        paramJsBridgeListener = a(paramVarArgs);
        V(paramVarArgs);
        if (paramJsBridgeListener != null)
        {
          this.ckn = m(paramVarArgs);
          QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_identify", paramJsBridgeListener, this);
        }
      }
      for (;;)
      {
        return true;
        if ("click_together_button".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button mRspOpenIdentify=" + this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify);
          }
          this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = null;
          a(-1L, -1, null, null, null);
          paramString1 = a(paramVarArgs);
          if ((paramString1 == null) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify == null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
            }
            return true;
          }
          paramString1.putInt("business_type", this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType);
          if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2) {
            if (this.mSessionType != 2) {
              break label344;
            }
          }
          label344:
          for (paramJsBridgeListener = "c2c_AIO";; paramJsBridgeListener = "Grp_AIO")
          {
            anot.a(null, "dc00899", paramJsBridgeListener, "", "video_tab", "clk_share_grp", 0, 0, this.mUin + "", this.mAppId, "", "");
            if (!aoX()) {
              break;
            }
            return true;
          }
          if (a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.resultInfo)) {
            return true;
          }
          if (D(paramString1)) {
            return true;
          }
          QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", paramString1, this);
        }
        else if ("dispear_together_button".equals(paramString3))
        {
          this.mUIHandler.sendEmptyMessage(4);
        }
        else
        {
          int i;
          double d1;
          double d2;
          if ("show_floating_window".equals(paramString3))
          {
            WatchTogetherFloatingData localWatchTogetherFloatingData;
            for (;;)
            {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                paramString2 = paramJsBridgeListener.optString("uin");
                paramString3 = paramJsBridgeListener.optString("url");
                i = paramJsBridgeListener.optInt("aio_type");
                boolean bool = paramJsBridgeListener.optBoolean("author");
                d1 = paramJsBridgeListener.optDouble("video_width", 0.0D);
                d2 = paramJsBridgeListener.optDouble("video_height", 0.0D);
                paramVarArgs = paramJsBridgeListener.optString("callback", "");
                String str = paramJsBridgeListener.optString("from", "watchroom");
                localWatchTogetherFloatingData = new WatchTogetherFloatingData();
                localWatchTogetherFloatingData.setSmallUrl(paramString3);
                localWatchTogetherFloatingData.setCurUin(paramString2);
                localWatchTogetherFloatingData.setCurType(i);
                localWatchTogetherFloatingData.setIsAdm(bool);
                localWatchTogetherFloatingData.setFrom(str);
                paramString1 = "";
                if ((this.mRuntime == null) || (this.mRuntime.b() == null)) {
                  break label841;
                }
                paramJsBridgeListener = this.mRuntime.b().getCurrentUrl();
                localWatchTogetherFloatingData.setBigUrl(paramJsBridgeListener);
                if ((d1 > 0.0D) && (d2 > 0.0D))
                {
                  localWatchTogetherFloatingData.setVideoWidth(d1);
                  localWatchTogetherFloatingData.setVideoHeight(d2);
                }
                if (QLog.isColorLevel())
                {
                  paramString1 = new StringBuilder("SHOW_FLOATING_WINDOW ");
                  paramString1.append("uin=").append(paramString2).append(" roomUrl=").append(paramString3).append(" sessionType=").append(i).append(" author=").append(bool).append(" videoWidth").append(d1).append(" videoHeight=").append(d2).append(" methodName=").append(paramVarArgs).append(" bigUrl").append(paramJsBridgeListener).append(" from=").append(str);
                  QLog.d("TogetherBusinessForWebPlugin", 2, paramString1.toString());
                }
                if (!"watchroom".equals(str)) {
                  break label876;
                }
                i = aihr.a().a(BaseApplication.getContext(), localWatchTogetherFloatingData);
                if (i != 1) {
                  callJs(paramVarArgs, new String[] { "" });
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("TogetherBusinessForWebPlugin", 2, "SHOW_FLOATING_WINDOW resultCode=" + i);
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
              break;
              label841:
              paramJsBridgeListener = paramString1;
              if (this.mRuntime != null)
              {
                paramJsBridgeListener = paramString1;
                if (this.mRuntime.getWebView() != null) {
                  paramJsBridgeListener = this.mRuntime.getWebView().getUrl();
                }
              }
            }
            label876:
            aihr.a().a(localWatchTogetherFloatingData);
          }
          else if ("close_floating_window".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString1.optString("uin");
              i = paramString1.optInt("aio_type");
              paramString1 = new WatchTogetherFloatingData();
              paramString1.setCurUin(paramJsBridgeListener);
              paramString1.setCurType(i);
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder("CLOSE_FLOATING_WINDOW ");
                paramString1.append("uin=").append(paramJsBridgeListener).append(" sessionType=").append(i);
                QLog.d("TogetherBusinessForWebPlugin", 2, paramString1.toString());
              }
              paramJsBridgeListener = new TogetherBusinessForWebPlugin.1(this);
              ThreadManager.getUIHandlerV2().postDelayed(paramJsBridgeListener, 500L);
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if ("loading_status_notify".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              i = paramJsBridgeListener.optInt("status");
              d1 = paramJsBridgeListener.optDouble("video_width", 0.0D);
              d2 = paramJsBridgeListener.optDouble("video_height", 0.0D);
              if (QLog.isColorLevel())
              {
                paramJsBridgeListener = new StringBuilder("LOAD_STATUS_NOTIFY ");
                paramJsBridgeListener.append("videoWidth=").append(d1).append(" videoHeight=").append(d2).append(" status=").append(i);
                QLog.d("TogetherBusinessForWebPlugin", 2, paramJsBridgeListener.toString());
              }
              aihr.a().d(d1, d2);
              aihr.a().PP(i);
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      String str = (String)paramMessage.obj;
      aL(paramMessage.arg1, str);
      return true;
    }
    if (paramMessage.what == 2)
    {
      paramMessage = (aihh.a)paramMessage.obj;
      d(paramMessage.title, paramMessage.content, paramMessage.Q);
      return true;
    }
    if (paramMessage.what == 3)
    {
      Ld((String)paramMessage.obj);
      return true;
    }
    if (paramMessage.what == 4)
    {
      if (this.xR != null) {
        this.xR.setVisibility(8);
      }
      return true;
    }
    return false;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null)) {}
    label53:
    do
    {
      do
      {
        return;
        Serializable localSerializable = paramEIPCResult.data.getSerializable("QQAIOMediaSvc.open_identify");
        if (localSerializable != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify = ((TogetherBusinessServlet.RspOpenIdentify)localSerializable);
          boolean bool;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText))
          {
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "callback from CMD_OPEN_IDENTIFY isShowButton=" + bool + " mDrawButtonByQQ=" + this.ckn);
            }
            if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2)) {
              if (this.mSessionType != 2) {
                break label262;
              }
            }
          }
          for (paramEIPCResult = "c2c_AIO";; paramEIPCResult = "Grp_AIO")
          {
            anot.a(null, "dc00899", paramEIPCResult, "", "video_tab", "exp_share_grp", 0, 0, this.mUin + "", this.mAppId, "", "");
            paramEIPCResult = b(bool, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText);
            if (!TextUtils.isEmpty(this.mCallBack)) {
              callJs(this.mCallBack, new String[] { paramEIPCResult });
            }
            if ((!bool) || (!this.ckn)) {
              break;
            }
            paramEIPCResult = this.mUIHandler.obtainMessage(3);
            paramEIPCResult.obj = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText;
            this.mUIHandler.sendMessage(paramEIPCResult);
            return;
            bool = false;
            break label53;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("TogetherBusinessForWebPlugin", 2, "callback from CMD_OPEN_START ");
        }
        paramEIPCResult = paramEIPCResult.data.getSerializable("QQAIOMediaSvc.open_start");
      } while (paramEIPCResult == null);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = ((TogetherBusinessServlet.RspOpenStart)paramEIPCResult);
    } while (!a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart.resultInfo));
    label262:
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = null;
    Object localObject = getIntent();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
      }
    }
    Bundle localBundle;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localBundle = a(this.bgD, this.bNK, this.mAppId, (Intent)localObject);
      if ((localBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify != null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
      }
    }
    localBundle.putInt("business_type", this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2) {
      if (this.mSessionType != 2) {
        break label219;
      }
    }
    label219:
    for (localObject = "c2c_AIO";; localObject = "Grp_AIO")
    {
      anot.a(null, "dc00899", (String)localObject, "", "video_tab", "clk_share_grp", 0, 0, this.mUin + "", this.mAppId, "", "");
      if ((aoX()) || (a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.resultInfo)) || (D(localBundle))) {
        break;
      }
      QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", localBundle, this);
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
    aihr.a().b(this);
    QIPCClientHelper.getInstance().getClient().unRegisterModule(aihu.a());
  }
  
  class a
  {
    DialogInterface.OnClickListener Q;
    String content;
    String title;
    
    public a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.title = paramString1;
      this.content = paramString2;
      this.Q = paramOnClickListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihh
 * JD-Core Version:    0.7.0.1
 */