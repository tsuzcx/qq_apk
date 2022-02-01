import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.vip.manager.MonitorManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public class awhe
  extends WebViewPlugin
{
  private volatile boolean auZ;
  public int eAB;
  private int eAC;
  public String lN = "";
  public int mFrom = 4;
  BroadcastReceiver mReceiver = new awhi(this);
  public int mSource = 0;
  public int mVipType;
  String type = "";
  
  public awhe()
  {
    this.mPluginNameSpace = "QzCover";
  }
  
  private void abh(String paramString)
  {
    for (;;)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        str = paramString.getString("from");
        if ((str.equals("qzone")) || (str.equals("userhome")))
        {
          this.mSource = 0;
          this.mFrom = Integer.parseInt(paramString.getString("page"));
          this.lN = paramString.getString("aid");
          str = paramString.optString("viptype", "COMMON_VIP");
          if ("STAR_VIP".equals(str))
          {
            this.mVipType = 3;
            this.eAB = paramString.optInt("openmonth", 0);
          }
        }
        else
        {
          this.mSource = 1;
          continue;
        }
        if (!"COMMON_VIP".equals(str)) {
          break label177;
        }
      }
      catch (JSONException paramString)
      {
        MonitorManager.a().d(1, 4, " parse json error " + paramString, false);
        QLog.e("CoverStore", 2, " handle exception " + paramString);
        return;
      }
      this.mVipType = 1;
      continue;
      label177:
      if ("NOBLE_VIP".equals(str)) {
        this.mVipType = 2;
      }
    }
  }
  
  private void abi(String paramString)
  {
    if ("MobileAlbum".equals(paramString)) {
      if ((this.mRuntime.a() != null) && (this.mRuntime.getActivity() != null)) {}
    }
    while ((!"QzoneAlbum".equals(paramString)) || (this.mRuntime.a() == null))
    {
      return;
      paramString = new Intent(this.mRuntime.getActivity(), NewPhotoListActivity.class);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
      paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      avpw.ay(paramString);
      paramString.putExtras((Bundle)localObject);
      ((AbsBaseWebViewActivity)this.mRuntime.getActivity()).a(this, paramString, (byte)2);
      return;
    }
    paramString = new Bundle();
    paramString.putInt("key_personal_album_enter_model", 2);
    Object localObject = avpw.d.a();
    ((avpw.d)localObject).cMP = this.mRuntime.a().getAccount();
    paramString.putString("keyAction", "actionSelectPicture");
    paramString.putBoolean("key_need_change_to_jpg", false);
    avpw.a(this.mRuntime.getActivity(), (avpw.d)localObject, paramString, lx(3));
  }
  
  private void abz(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    try
    {
      this.eAC = new JSONObject(paramString).optInt("source", 0);
      return;
    }
    catch (JSONException paramString)
    {
      MonitorManager.a().d(2, 4, " parse json error " + paramString, false);
      QLog.e("CoverStore", 2, " handle exception " + paramString);
    }
  }
  
  private void acq(int paramInt)
  {
    if ((this.mRuntime.a() == null) || (this.mRuntime.getActivity() == null)) {}
    int j;
    do
    {
      return;
      j = this.mRuntime.getActivity().getResources().getDimensionPixelSize(2131299627);
      if (!avpw.isBestPerformanceDevice()) {}
      for (int i = 1; i != 0; i = 0)
      {
        QQToast.a(this.mRuntime.getActivity(), 2131718253, 0).show(j);
        return;
      }
      registerBroadcast();
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        QLog.i("CoverStore", 1, "VIDEO_COVER click select qzone video.");
        avpw.d locald = avpw.d.a();
        locald.cMP = this.mRuntime.a().getCurrentAccountUin();
        BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo();
        localBaseBusinessAlbumInfo.mAlbumId = locald.cMP;
        localBaseBusinessAlbumInfo.mUin = this.mRuntime.a().getLongAccountUin();
        localBaseBusinessAlbumInfo.mAlbumType = 10;
        localBaseBusinessAlbumInfo.eyD = 10;
        localBaseBusinessAlbumInfo.mTitle = this.mRuntime.getActivity().getString(2131717741);
        avpw.b(this.mRuntime.getActivity(), locald, localBaseBusinessAlbumInfo, -1, "cover_mall_record_video");
        return;
      }
      QLog.i("CoverStore", 1, "VIDEO_COVER click select record video.");
    } while (!awdb.a(this.mRuntime.getActivity(), new awhg(this, j), 1));
    acr(j);
  }
  
  private void acr(int paramInt)
  {
    avqw.a(this.mRuntime.a().getLongAccountUin(), this.mRuntime.getActivity(), "cover_mall_record_video", new awhh(this, paramInt));
  }
  
  private void er(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label486:
    label496:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.i("CoverStore", 2, "video cover setting start,notify to h5");
          }
          for (;;)
          {
            try
            {
              i = paramIntent.getIntExtra("intent_cover_setting_type", 0);
              if (i != 0) {
                break label496;
              }
              i = paramIntent.getIntExtra("PhotoConst.VIDEO_TYPE", -1);
              str = paramIntent.getStringExtra("thumbnail_path");
              if (TextUtils.isEmpty(str)) {
                break;
              }
              localJSONObject = new JSONObject();
              if (i == 2)
              {
                localJSONObject.put("type", 1);
                localJSONObject.put("picurl", str);
                localJSONObject.put("videoid", paramIntent.getStringExtra("PhotoConst.QZONE_ALBUM_VIDEO_ID"));
                localJSONObject.put("videowidth", paramIntent.getIntExtra("thumbnail_width", 0));
                localJSONObject.put("videoheight", paramIntent.getIntExtra("thumbnail_height", 0));
                localJSONObject.put("videourl", paramIntent.getStringExtra("file_send_path"));
                paramIntent = "window.QZVideoCoverJSInterface.onSetCover(" + localJSONObject.toString() + ")";
                if (QLog.isColorLevel()) {
                  QLog.i("CoverStore", 2, "video cover notify h5:" + paramIntent);
                }
                callJs(paramIntent);
                return;
              }
            }
            catch (Exception paramIntent)
            {
              MonitorManager.a().d(2, 5, " exception notify H5 " + paramIntent, false);
              QLog.e("CoverStore", 2, " handle exception " + paramIntent);
              return;
            }
            if ((i != 0) && (1 != i)) {
              break label486;
            }
            Object localObject = awfn.a(str);
            if (localObject == null) {
              break;
            }
            double d = awfn.a((awfn.a)localObject);
            if (d > 0.0D)
            {
              ((awfn.a)localObject).width = ((int)(((awfn.a)localObject).width / d));
              ((awfn.a)localObject).height = ((int)(((awfn.a)localObject).height / d));
            }
            localObject = awfn.k(str, ((awfn.a)localObject).width, ((awfn.a)localObject).height);
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              QLog.w("CoverStore", 1, "video cover pic not exist,imageBase64 empty. path=" + str);
              return;
            }
            String str = "data:image/jpg;base64," + (String)localObject;
            localJSONObject.put("type", 0);
            localJSONObject.put("data", str);
            localJSONObject.put("videowidth", paramIntent.getIntExtra("thumbnail_width", 0));
            localJSONObject.put("videoheight", paramIntent.getIntExtra("thumbnail_height", 0));
          }
          QLog.w("CoverStore", 1, "unknown video type");
          return;
          if (i != 2) {
            break;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("coverid", paramIntent.getStringExtra("cover_id"));
          paramIntent = "window.QZVideoCoverJSInterface.CancelVideoCover(" + localJSONObject.toString() + ")";
          callJs(paramIntent);
        } while (!QLog.isColorLevel());
        QLog.i("CoverStore", 2, "video cover notify h5:" + paramIntent);
        return;
      } while (i != 1);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("coverid", paramIntent.getStringExtra("cover_id"));
      paramIntent = "window.QZVideoCoverJSInterface.onSetVideoCover(" + localJSONObject.toString() + ")";
      callJs(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.i("CoverStore", 2, "video cover notify h5:" + paramIntent);
  }
  
  private void fy(ArrayList<String> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        if (i < paramArrayList.size())
        {
          long l1 = System.currentTimeMillis();
          localObject1 = (String)paramArrayList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label336;
          }
          Object localObject2 = awfn.a((String)localObject1);
          if (localObject2 == null) {
            break label336;
          }
          double d = awfn.a((awfn.a)localObject2);
          if (d > 0.0D)
          {
            ((awfn.a)localObject2).width = ((int)(((awfn.a)localObject2).width / d));
            ((awfn.a)localObject2).height = ((int)(((awfn.a)localObject2).height / d));
          }
          localObject2 = awfn.k((String)localObject1, ((awfn.a)localObject2).width, ((awfn.a)localObject2).height);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label297;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("type", this.type);
          ((JSONObject)localObject1).put("data", "" + "data:image/jpg;base64," + (String)localObject2);
          callJs("window.QZImagePickerJSInterface.onReceive(" + ((JSONObject)localObject1).toString() + ")");
          j = 1;
          long l2 = System.currentTimeMillis();
          localObject1 = new Properties();
          if (j == 0) {
            break label330;
          }
          j = 1;
          ((Properties)localObject1).put("isSucc", Integer.valueOf(j));
          anol.a(BaseApplication.getContext()).reportTimeKVEvent("Qzone.EventTransformPhotoBase64", (Properties)localObject1, (int)(l2 - l1));
        }
      }
      catch (Exception paramArrayList)
      {
        QLog.e("CoverStore", 1, "toBase64: " + paramArrayList);
      }
      return;
      label297:
      QLog.e("CoverStore", 1, "toBase64 fail. path:" + (String)localObject1);
      int j = 0;
      continue;
      label330:
      j = 0;
      continue;
      label336:
      i += 1;
    }
  }
  
  private String getAid()
  {
    switch (this.mFrom)
    {
    case 4: 
    default: 
      return "jhan-cover1";
    case 1: 
      return "jhan-cover1";
    case 5: 
      return "jhan-cover1b";
    case 2: 
      return "jhan-cover2";
    case 6: 
      return "jhan-cover2b";
    case 3: 
      return "jhan-ziliaocover";
    }
    return "jhan-ziliaocoverb";
  }
  
  private int gf(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("widgetId");
      return i;
    }
    catch (JSONException paramString)
    {
      MonitorManager.a().d(2, 4, " parse json error " + paramString, false);
      QLog.e("CoverStore", 2, " handle exception " + paramString);
    }
    return 0;
  }
  
  private int lx(int paramInt)
  {
    aqzv localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    int i = paramInt;
    if ((localaqzv instanceof aran)) {
      i = ((aran)localaqzv).switchRequestCode(this, (byte)paramInt);
    }
    return i;
  }
  
  private void registerBroadcast()
  {
    if (this.auZ) {}
    IntentFilter localIntentFilter;
    Activity localActivity;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CoverStore", 2, "video cover registerBroadcast start");
        }
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING");
      } while (this.mRuntime == null);
      localActivity = this.mRuntime.getActivity();
    } while ((localActivity == null) || (this.auZ));
    try
    {
      localActivity.registerReceiver(this.mReceiver, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
      this.auZ = true;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CoverStore", 2, "regist receiver error:" + localException.toString());
    }
  }
  
  private String se(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.getString("type");
      try
      {
        String str = localJSONObject.getString("from");
        if ((str.equals("qzone")) || (str.equals("userhome"))) {}
        for (this.mSource = 0;; this.mSource = 1)
        {
          this.mFrom = Integer.parseInt(localJSONObject.getString("page"));
          return paramString;
        }
        QLog.e("CoverStore", 2, " handle exception " + localJSONException1);
      }
      catch (JSONException localJSONException1) {}
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        paramString = "";
      }
    }
    return paramString;
  }
  
  private boolean tX(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("enable");
      return bool;
    }
    catch (JSONException paramString)
    {
      MonitorManager.a().d(2, 4, " parse json error " + paramString, false);
      QLog.e("CoverStore", 2, " handle exception " + paramString);
    }
    return false;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934600L)
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Intent localIntent = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == lx(2)) || (i == lx(3)))
      {
        if (j == -1)
        {
          callJs("window.QZImagePickerJSInterface.doSelectPhoto");
          paramString = new ArrayList();
          paramMap = localIntent.getStringExtra("key_cover_selected_img_path");
          if (!TextUtils.isEmpty(paramMap))
          {
            paramString.add(paramMap);
            fy(paramString);
          }
        }
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!"QzCover".equals(paramString2)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramString3.equals("goToPhotoWall"));
    if (paramString3.equals("showStoreButton"))
    {
      if (this.mRuntime.getActivity() == null) {
        return false;
      }
      paramJsBridgeListener = (TextView)this.mRuntime.getActivity().findViewById(2131369612);
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setVisibility(0);
        paramJsBridgeListener.setTextColor(-1);
        paramJsBridgeListener.setText(acfp.m(2131713003));
        paramJsBridgeListener.setOnClickListener(new awhf(this));
      }
    }
    label809:
    do
    {
      for (;;)
      {
        return false;
        if (paramString3.equals("goToUserDefine"))
        {
          this.type = se(paramVarArgs[0]);
          abi(this.type);
          return true;
        }
        if ("forwardSelectVideoCover".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            abz(paramVarArgs[0]);
          }
          acq(this.eAC);
          return true;
        }
        if (paramString3.equals("setWidgetEnable"))
        {
          bool1 = tX(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.x(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 3);
          paramJsBridgeListener.putExtra("widgetEnable", bool1);
          if ((this.mRuntime.getActivity() != null) && (this.mRuntime.a() != null)) {
            QzonePluginProxyActivity.a(this.mRuntime.getActivity(), this.mRuntime.a().getAccount(), paramJsBridgeListener, lx(6));
          }
        }
        else if (paramString3.equals("setWidget"))
        {
          int i = gf(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.x(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 2);
          paramJsBridgeListener.putExtra("widgetId", i);
          if ((this.mRuntime.getActivity() != null) && (this.mRuntime.a() != null)) {
            QzonePluginProxyActivity.a(this.mRuntime.getActivity(), this.mRuntime.a().getAccount(), paramJsBridgeListener, lx(5));
          }
        }
        else if (paramString3.equals("openYellowDiamond"))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            abh(paramVarArgs[0]);
          }
          if ((this.mRuntime.a() == null) || (this.mRuntime.getActivity() == null)) {
            return false;
          }
          paramJsBridgeListener = this.mRuntime.a().getAccount();
          paramString1 = new Intent();
          paramString2 = acfp.m(2131713002);
          QzonePluginProxyActivity.x(paramString1, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
          if (TextUtils.isEmpty(this.lN)) {
            this.lN = getAid();
          }
          paramString1.putExtra("aid", this.lN);
          paramString1.putExtra("success_tips", paramString2);
          paramString1.putExtra("direct_go", true);
          paramString1.putExtra("viptype", this.mVipType);
          paramString1.putExtra("month", this.eAB);
          QzonePluginProxyActivity.a(this.mRuntime.getActivity(), paramJsBridgeListener, paramString1, lx(4), null, false, null, true);
        }
        else
        {
          if (!paramString3.equals("setCover")) {
            break label809;
          }
          bool1 = bool2;
          if (paramVarArgs == null) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(paramVarArgs[0])) {
            break;
          }
        }
        try
        {
          if (("PhotoWallCover".equals(new JSONObject(paramVarArgs[0]).getString("coverType"))) && (this.mRuntime.getActivity() != null))
          {
            paramJsBridgeListener = this.mRuntime.a();
            bool1 = bool2;
            if (paramJsBridgeListener != null) {
              break;
            }
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            QLog.e("CoverStore", 2, " handle exception " + paramJsBridgeListener);
            MonitorManager.a().d(2, 4, "set cover data exception " + paramJsBridgeListener, false);
          }
        }
      }
      paramJsBridgeListener = new Intent();
      QzonePluginProxyActivity.x(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
      paramJsBridgeListener.putExtra("open_what", 4);
      paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
      bool1 = bool2;
      if (this.mRuntime.getActivity() == null) {
        break;
      }
      bool1 = bool2;
      if (this.mRuntime.a() == null) {
        break;
      }
      QzonePluginProxyActivity.a(this.mRuntime.getActivity(), this.mRuntime.a().getAccount(), paramJsBridgeListener, lx(7));
      return true;
      if ("setLocalCover".equals(paramString3))
      {
        bool1 = bool2;
        if (paramVarArgs == null) {
          break;
        }
        bool1 = bool2;
        if (TextUtils.isEmpty(paramVarArgs[0])) {
          break;
        }
        paramJsBridgeListener = new Intent();
        QzonePluginProxyActivity.x(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
        paramJsBridgeListener.putExtra("open_what", 6);
        paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
        bool1 = bool2;
        if (this.mRuntime.getActivity() == null) {
          break;
        }
        bool1 = bool2;
        if (this.mRuntime.a() == null) {
          break;
        }
        QzonePluginProxyActivity.a(this.mRuntime.getActivity(), this.mRuntime.a().getAccount(), paramJsBridgeListener, lx(8));
        return true;
      }
      if (paramString3.equals("getWidgetEnable"))
      {
        if ((this.mRuntime.a() == null) || (this.mRuntime.getActivity() == null)) {
          return false;
        }
        paramString1 = "Widget_" + this.mRuntime.a().getCurrentAccountUin();
        paramJsBridgeListener.onComplete(Boolean.valueOf(this.mRuntime.getActivity().getSharedPreferences(paramString1, 4).getBoolean("WidgetShow", true)));
        return true;
      }
      if (paramString3.equals("leftButtonClick"))
      {
        if (this.mRuntime.getActivity() == null) {
          return false;
        }
        ((TextView)this.mRuntime.getActivity().findViewById(2131369579)).performClick();
        return true;
      }
    } while (!"Init".equals(paramString3));
    QLog.i("CoverStore", 2, "QzCover.Init called.");
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramInt == -1) {}
    Object localObject;
    switch (paramByte)
    {
    case 1: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    default: 
    case 7: 
    case 8: 
    case 4: 
      for (;;)
      {
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("need_jump", false)) && (this.mRuntime.getActivity() != null))
        {
          this.mRuntime.getActivity().finish();
          return;
          if ((paramIntent != null) && (paramIntent.getBooleanExtra("needJump", false)) && (this.mRuntime.getActivity() != null))
          {
            this.mRuntime.getActivity().finish();
            return;
            if (paramInt == -1)
            {
              localObject = this.mRuntime.getWebView();
              if (localObject != null)
              {
                ((CustomWebView)localObject).callJs("window.QzCoverJSInterface.onReceive({type:\"YellowInfo\",data:{vipType:\"normalVip\"}});");
                if (paramIntent != null) {
                  try
                  {
                    paramIntent = paramIntent.getExtras().getString("qzone_vip_open_succ_str");
                    if (!TextUtils.isEmpty(paramIntent))
                    {
                      paramIntent = new JSONObject(paramIntent);
                      dispatchJsEvent("openVipInfo", paramIntent, paramIntent);
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    QLog.e("CoverStore", 2, paramIntent.getMessage());
                    return;
                  }
                }
              }
            }
          }
        }
      }
    case 2: 
      callJs("window.QZImagePickerJSInterface.doSelectPhoto");
      localObject = new ArrayList();
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(paramIntent)) {
        ((ArrayList)localObject).add(paramIntent);
      }
      fy((ArrayList)localObject);
      return;
    }
    callJs("window.QZImagePickerJSInterface.doSelectPhoto");
    fy(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
  }
  
  public void onCreate()
  {
    super.onCreate();
    registerBroadcast();
  }
  
  public void onDestroy()
  {
    Activity localActivity = this.mRuntime.getActivity();
    if ((localActivity != null) && (this.auZ)) {}
    try
    {
      localActivity.unregisterReceiver(this.mReceiver);
      this.auZ = false;
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CoverStore", 2, localException, new Object[] { "unregisterReceiver exception" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhe
 * JD-Core Version:    0.7.0.1
 */