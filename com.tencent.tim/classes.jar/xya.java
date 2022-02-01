import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class xya
  extends BaseChatPie
{
  static int bXU = 100100;
  static int bXV = 10;
  static int bXW = 11;
  public static boolean bkE;
  public static ConcurrentHashMap<Integer, MessageRecord> cY = new ConcurrentHashMap(20);
  protected Boolean ad = Boolean.valueOf(false);
  BroadcastReceiver ar = new xyh(this);
  public int bXS;
  int bXT = 0;
  boolean bkB = false;
  boolean bkC = false;
  boolean bkD = false;
  boolean bkF = false;
  boolean bkG = false;
  private boolean bkH;
  public volatile boolean hasRegisterReceiver;
  public String mVideoPath = "";
  int operType = 0;
  private ImageView tZ;
  
  public xya(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  public static boolean N(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = cY.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq == paramMessageRecord.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  public static void b(int paramInt, MessageRecord paramMessageRecord)
  {
    cY.put(Integer.valueOf(paramInt), paramMessageRecord);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt("num", 1);
      int j = paramString2.optInt("face", 1);
      int k = paramString2.optInt("mediaSize", 1);
      int m = paramString2.optInt("mediaType", 1);
      int n = paramString2.optInt("scaling", 1);
      int i1 = paramString2.optInt("orientation", 1);
      int i2 = paramString2.optInt("color", 1);
      int i3 = paramString2.optInt("quality", 1);
      localBundle.putInt("copies", i);
      localBundle.putInt("duplexMode", j);
      localBundle.putInt("mediaSize", k);
      localBundle.putInt("mediaType", m);
      localBundle.putInt("scaling", n);
      localBundle.putInt("orientation", i1);
      localBundle.putInt("color", i2);
      localBundle.putInt("quality", i3);
      ((szy)paramQQAppInterface.getBusinessHandler(49)).a().a(szy.aIk, paramString1, paramArrayList, localBundle);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceMsgChatPie", 2, "getString from json JSONException error:" + paramString2.getMessage());
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceMsgChatPie", 2, "getString from json Exception error:" + paramString2.getMessage());
        }
      }
    }
  }
  
  private void cr(Intent paramIntent)
  {
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
    Object localObject1 = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
    int k = paramIntent.getExtras().getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = 0;
    Object localObject2 = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject2).a(Long.parseLong(this.sessionInfo.aTl));
    int i = j;
    Object localObject3;
    if (localDeviceInfo != null)
    {
      localObject3 = ((syw)localObject2).a(localDeviceInfo.productId);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((ProductInfo)localObject3).isSupportFuncMsgType(1)) {
          i = 1;
        }
      }
    }
    long l = 0L;
    j = 0;
    if (localDeviceInfo != null)
    {
      l = localDeviceInfo.din;
      j = localDeviceInfo.productId;
    }
    if ((i == 0) && (this.operType != 4) && (this.operType != 3))
    {
      paramIntent = (szy)this.app.getBusinessHandler(49);
      tar.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, j);
    }
    do
    {
      do
      {
        return;
        localObject3 = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            ((ArrayList)localObject3).add(new FileInfo(str));
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
        if ((this.operType == 4) || (this.operType == 3))
        {
          paramIntent = (syw)this.app.getBusinessHandler(51);
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext()) {
            ((syw)localObject2).c((String)paramIntent.next(), 2154);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "prcessExtraData: send:" + ((List)localObject1).size());
          }
          finish();
          return;
        }
        if (this.operType != 9) {
          break;
        }
      } while (((ArrayList)localObject3).size() <= 0);
      localObject1 = new Intent();
      ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
      ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject1).putExtra(aqfx.REQUEST_CODE, paramIntent.getIntExtra(aqfx.REQUEST_CODE, -1));
      ((Intent)localObject1).putExtra("filetype", "pic");
      ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      awjb.a().a(this.mActivity, this.app, this.app.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
      localObject2 = (szy)this.app.getBusinessHandler(49);
      if ((bkE) && (this.bkD))
      {
        ((szy)localObject2).a().o(this.sessionInfo.aTl, (List)localObject1);
        tar.a(this.app, l, "Usr_AIO_SendGroupMsg", 3, 0, j);
        return;
      }
      if (!this.bkG) {
        break;
      }
    } while (((ArrayList)localObject3).size() <= 0);
    localObject1 = new Intent();
    ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
    ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
    ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
    ((Intent)localObject1).putExtra(aqfx.REQUEST_CODE, paramIntent.getIntExtra(aqfx.REQUEST_CODE, -1));
    ((Intent)localObject1).putExtra("filetype", "pic");
    ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
    awjb.a().a(this.mActivity, this.app, this.app.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
    return;
    if (k == 2)
    {
      gt((List)localObject1);
      return;
    }
    gu((List)localObject1);
  }
  
  private void cs(Intent paramIntent)
  {
    if (!((DeviceFileHandler)this.app.getBusinessHandler(50)).bq(Long.parseLong(this.sessionInfo.aTl))) {
      QQToast.a(this.mContext, acfp.m(2131704970), 2000).show();
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      } while ((localObject == null) || (((ArrayList)localObject).size() <= 0));
      localArrayList = new ArrayList();
      Object localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((FileInfo)((Iterator)localObject).next()).getPath());
      }
      paramIntent = paramIntent.getStringExtra("sPrintParam");
      if (aqiw.isWifiEnabled(this.mContext)) {
        break;
      }
      paramIntent = aqha.a(this.mActivity, 230, this.mContext.getString(2131699824), this.mContext.getString(2131699611), acfp.m(2131704985), acfp.m(2131704986), new xyf(this, localArrayList, paramIntent), new xyg(this));
    } while (paramIntent.isShowing());
    paramIntent.show();
    return;
    c(this.app, this.sessionInfo.aTl, localArrayList, paramIntent);
  }
  
  private void initView()
  {
    int i = 1;
    Object localObject2;
    if (!this.mActivity.isFinishing())
    {
      localObject1 = (szy)this.app.getBusinessHandler(49);
      ((szy)localObject1).a().bCh();
      ((szy)localObject1).a().bCd();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
      if (VersionUtils.isHoneycomb()) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
      }
      cfU();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("SmartDevice_DeviceUnBindRst");
      ((IntentFilter)localObject1).addAction("SmartDevice_ProductFetchRst");
      ((IntentFilter)localObject1).addAction("SmartDevice_receiveVasFlagResult");
      ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgProgress");
      ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgSendRet");
      this.mActivity.registerReceiver(this.ar, (IntentFilter)localObject1);
      this.hasRegisterReceiver = true;
      localObject2 = this.mActivity.getIntent().getExtras();
      if (localObject2 != null)
      {
        this.ad = Boolean.valueOf(((Bundle)localObject2).getBoolean("bFromLightApp", false));
        this.operType = ((Bundle)localObject2).getInt("operType", 0);
        this.bXT = ((Bundle)localObject2).getInt("jumpTab", 0);
      }
      localObject1 = (ImageView)this.mAIORootView.findViewById(2131369594);
      if (localObject1 == null) {
        break label656;
      }
      ((ImageView)localObject1).setImageResource(2130840077);
    }
    label651:
    label656:
    for (Object localObject1 = (RelativeLayout)((ImageView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject3 = (ImageView)this.mAIORootView.findViewById(2131369588);
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setImageResource(2130840076);
        ((ImageView)localObject3).setOnClickListener(new xyc(this));
      }
      long l = Long.parseLong(this.sessionInfo.aTl);
      localObject3 = (syw)this.app.getBusinessHandler(51);
      boolean bool;
      if ((((syw)localObject3).bn(l)) && (((syw)localObject3).i(l, 17)))
      {
        bool = true;
        this.bkG = bool;
        if (this.bkG) {
          ((syw)localObject3).a(l, "", "", "", 0, null);
        }
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("PhotoConst.PHOTO_PATHS");
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            cr(this.mActivity.getIntent());
          }
          localObject2 = this.mActivity.getIntent().getParcelableArrayListExtra("sFilesSelected");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            cs(this.mActivity.getIntent());
          }
        }
        bool = BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).getBoolean("ota_showupdatereddot", true);
        localObject2 = BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0);
        if ((afsf.a().a(this.app, BaseApplicationImpl.getApplication()) == 0) || (((SharedPreferences)localObject2).getBoolean(this.sessionInfo.aTl + "_" + "lock_red_dot_show" + "_" + this.app.getCurrentAccountUin(), false))) {
          break label651;
        }
      }
      for (;;)
      {
        if (((bool) && (((syw)localObject3).bo(l))) || (i != 0))
        {
          this.tZ = new ImageView(this.mContext);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131369594);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131369594);
          if (localObject1 != null)
          {
            ((RelativeLayout)localObject1).addView(this.tZ, (ViewGroup.LayoutParams)localObject2);
            this.tZ.setImageResource(2130851401);
          }
          this.tZ.setVisibility(0);
        }
        return;
        bool = false;
        break;
        i = 0;
      }
    }
  }
  
  public void Ib()
  {
    this.TAG = "DeviceMsgChatPie";
  }
  
  public boolean OM()
  {
    Object localObject = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject).a(Long.parseLong(this.sessionInfo.aTl));
    if (localDeviceInfo != null)
    {
      localObject = ((syw)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 6)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean ON()
  {
    Object localObject = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject).a(Long.parseLong(this.sessionInfo.aTl));
    if (localDeviceInfo != null)
    {
      localObject = ((syw)localObject).a(localDeviceInfo.productId);
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 1) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 1)) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 2)) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 3)) {
          return true;
        }
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 9) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean SZ()
  {
    Object localObject = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject).a(Long.parseLong(this.sessionInfo.aTl));
    if (localDeviceInfo != null)
    {
      localObject = ((syw)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean Ta()
  {
    Object localObject = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject).a(Long.parseLong(this.sessionInfo.aTl));
    if (localDeviceInfo != null)
    {
      localObject = ((syw)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(8))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean Tb()
  {
    if (Ta()) {
      return true;
    }
    try
    {
      l = Long.parseLong(this.sessionInfo.aTl);
      syw localsyw = (syw)this.app.getBusinessHandler(51);
      if ((localsyw != null) && (localsyw.bn(l)) && (localsyw.i(l, 17))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
      }
    }
    return false;
  }
  
  public boolean Tc()
  {
    Object localObject = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject).a(Long.parseLong(this.sessionInfo.aTl));
    if (localDeviceInfo != null)
    {
      localObject = ((syw)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(1))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean Td()
  {
    Object localObject = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject).a(Long.parseLong(this.sessionInfo.aTl));
    if (localDeviceInfo != null)
    {
      localObject = ((syw)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public QQRecorder.RecorderParam a()
  {
    Object localObject = ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(this.sessionInfo.aTl));
    localObject = new tao().a((DeviceInfo)localObject);
    if ((localObject != null) && (((LightAppSettingInfo)localObject).gs.get(Integer.valueOf(11007)) != null)) {}
    try
    {
      String str = (String)((LightAppSettingInfo)localObject).gs.get(Integer.valueOf(11007));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      if (new JSONObject(((String)localObject).replace("&quot;", "\"")).optString("Audio", "").toLowerCase().equals("slk"))
      {
        localObject = new QQRecorder.RecorderParam(aqlv.dZR, 16000, 1);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "getString from json JSONException error:" + localJSONException.getMessage());
      }
      return new QQRecorder.RecorderParam(aqlv.dZQ, 0, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "getString from json Exception error:" + localException.getMessage());
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (!this.bkB) {
      return;
    }
    if (paramRecorderParam.mUserData == null)
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label298;
      }
      anqo.cU(paramString, false);
      anqo.Rl(paramString);
      label33:
      if (new File(paramString).exists()) {
        break label528;
      }
      paramInt1 = 0;
      paramRecorderParam = paramString;
      label53:
      if (paramInt1 >= aqxu.edz) {
        break label522;
      }
      paramRecorderParam = aqxu.aM(paramString, paramInt1);
      if (!new File(paramRecorderParam).exists()) {
        break label306;
      }
      paramString = paramRecorderParam;
    }
    label522:
    label528:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      syw localsyw = null;
      paramRecorderParam = localsyw;
      if (!TextUtils.isEmpty(paramString))
      {
        paramRecorderParam = localsyw;
        if (this.sessionInfo != null) {
          if (paramLong == 0L) {
            break label315;
          }
        }
      }
      label298:
      label306:
      label315:
      for (paramRecorderParam = this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong);; paramRecorderParam = syz.a(this.app, paramString, this.sessionInfo.cZ, this.sessionInfo.aTl, this.sessionInfo.troopUin, -2L))
      {
        if (paramRecorderParam == null) {
          break label350;
        }
        super.d(0, paramString, paramRecorderParam.uniseq);
        if ((!bkE) || (!this.bkD)) {
          break label467;
        }
        if ((aqiw.isNetSupport(BaseApplication.getContext())) || (!(paramRecorderParam instanceof MessageForDevPtt))) {
          break label352;
        }
        paramString = (MessageForDevPtt)paramRecorderParam;
        paramString.fileSize = -1L;
        paramString.extraflag = 32768;
        paramString.extStr = "device_groupchat";
        paramString.serial();
        this.app.b().c(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
        return;
        paramInt1 = 0;
        break;
        alid.nZ(paramString);
        break label33;
        paramInt1 += 1;
        break label53;
      }
      label350:
      break;
      label352:
      localsyw = (syw)this.app.getBusinessHandler(51);
      paramInt1 = localsyw.a(Long.parseLong(this.sessionInfo.aTl), paramString, QQRecorder.d(paramInt2));
      if ((paramRecorderParam instanceof MessageForDevPtt)) {
        ((MessageForDevPtt)paramRecorderParam).voiceLength = QQRecorder.d(paramInt2);
      }
      cY.put(Integer.valueOf(paramInt1), paramRecorderParam);
      paramString = localsyw.a(Long.parseLong(this.sessionInfo.aTl));
      if (paramString == null) {
        break;
      }
      tar.a(this.app, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
      return;
      label467:
      ((szy)this.app.getBusinessHandler(49)).a().a(szy.aIn, paramString, Long.parseLong(this.sessionInfo.aTl), paramRecorderParam.uniseq, paramRecorderParam.istroop, QQRecorder.d(paramInt2));
      paramLong = paramRecorderParam.uniseq;
      return;
      paramString = paramRecorderParam;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    Object localObject2 = (syw)this.app.getBusinessHandler(51);
    Object localObject1 = ((syw)localObject2).a(Long.parseLong(this.sessionInfo.aTl));
    if (localObject1 != null)
    {
      localObject2 = ((syw)localObject2).a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportMainMsgType(2))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      long l = 0L;
      int i = 0;
      if (localObject1 != null)
      {
        l = ((DeviceInfo)localObject1).din;
        i = ((DeviceInfo)localObject1).productId;
      }
      tar.a(this.app, l, "Usr_AIO_SendMsg", 1, 0, i);
      this.bkB = bool;
      if (!bool)
      {
        paramString = (szy)this.app.getBusinessHandler(49);
        tar.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "onRecorderPerpare path = " + paramString);
      }
      localObject1 = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
      if (paramRecorderParam.mUserData == null)
      {
        i = 1;
        label205:
        if (i != 0) {
          break label276;
        }
        anqo.a(this.app, paramRecorderParam.mAudioType, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        anqo.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
        label243:
        if (paramString == null) {
          break label292;
        }
        if (paramBoolean) {
          break label294;
        }
        this.Fq = 0L;
        zX(2131230758);
      }
      for (;;)
      {
        aG(true, false);
        return;
        i = 0;
        break label205;
        label276:
        alid.nY(paramString);
        alid.a(paramString, (byte[])localObject1, localObject1.length);
        break label243;
        label292:
        break;
        label294:
        paramString = syz.a(this.app, paramString, this.sessionInfo.cZ, this.sessionInfo.aTl, this.sessionInfo.troopUin, -2L);
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.Fq = paramString.uniseq;
        }
        zX(2131230746);
      }
    }
  }
  
  public boolean af(boolean paramBoolean)
  {
    this.aSJ = false;
    this.aSY = false;
    if (this.mActivity.getIntent().getExtras() == null)
    {
      super.finish();
      return true;
    }
    super.af(paramBoolean);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!aczy.bd(this.mActivity))
      {
        CheckPermission.requestStorePermission(this.mActivity, new xyb(this));
        return true;
      }
      initView();
      return true;
    }
    initView();
    return true;
  }
  
  public void bGS()
  {
    super.bGS();
    if ((this.operType == 1) || (this.operType == 3) || (this.operType == 9)) {
      if ((PanelIconLinearLayout)this.mAIORootView.findViewById(2131372847) != null) {
        k(Integer.valueOf(4));
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          break label53;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d(this.TAG, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.operType + "], find view panelicons failed!!");
          return;
          if ((this.operType != 2) && (this.operType != 4)) {
            break;
          }
          if ((PanelIconLinearLayout)this.mAIORootView.findViewById(2131372847) != null)
          {
            k(Integer.valueOf(5));
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.TAG, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.operType + "], find view panelicons failed!!");
        return;
      } while (this.operType == 5);
      if (this.operType == 6)
      {
        xro.a(this.app, this, this.sessionInfo);
        return;
      }
      ahau.a locala;
      if (this.operType == 7)
      {
        locala = new ahau.a();
        locala.bJE = "send_file";
        locala.cYX = 1;
        ahau.a(this.app.getCurrentAccountUin(), locala);
        wmj.a(this.app, a(), this.sessionInfo, this.bXT, false);
        return;
      }
      if (this.operType == 8)
      {
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(2);
        return;
      }
      if (this.operType == 10)
      {
        locala = new ahau.a();
        locala.bJE = "send_file";
        locala.cYX = 1;
        ahau.a(this.app.getCurrentAccountUin(), locala);
        wmj.c(this.app, a(), this.sessionInfo);
        return;
      }
    } while (this.operType != 11);
    k(Integer.valueOf(13));
  }
  
  public void bGT()
  {
    if (this.ps != null)
    {
      if (ixa.a().cD(this.app.getCurrentAccountUin())) {
        this.ps.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.ps.setVisibility(8);
  }
  
  public void bGY()
  {
    if (this.sessionInfo.aTl.equals(acbn.bkv))
    {
      localIntent = new Intent();
      localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_menu/aioSet.html");
      awjb.a().a(this.mActivity, this.app, this.app.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareSettingActivity", bXU, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      localObject = ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(this.sessionInfo.aTl));
      int i = 0;
      long l = 0L;
      if (localObject != null)
      {
        i = ((DeviceInfo)localObject).productId;
        l = ((DeviceInfo)localObject).din;
      }
      tar.a(this.app, l, "Usr_AIO_Menu", 1, 0, i);
    } while (localObject == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("device_info", (Parcelable)localObject);
    localIntent.putExtra("isPublicDevice", true);
    Object localObject = new tao(this.mActivity).a((DeviceInfo)localObject);
    if (localObject != null) {
      localIntent.putExtra("lightapp_setting", (Parcelable)localObject);
    }
    awjb.a().a(this.mActivity, this.app, this.app.getAccount(), localIntent, "com.tencent.device.activities.DeviceSettingActivity", bXU, null, SmartDevicePluginProxyActivity.class);
    if (this.tZ != null) {
      this.tZ.setVisibility(8);
    }
    BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit().putBoolean(this.sessionInfo.aTl + "_" + "lock_red_dot_show" + "_" + this.app.getCurrentAccountUin(), true).commit();
    BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
  }
  
  public void bGZ()
  {
    if (this.pp != null)
    {
      a(this.pp, 2130840077, 2130840077);
      this.pp.setContentDescription(this.mActivity.getText(2131698657));
    }
  }
  
  public void bHy()
  {
    aqjc.edW();
    this.jdField_a_of_type_Wvm.CS(20);
    wja.yn(false);
    this.aL = false;
    this.du = true;
    this.aSq = false;
    this.aSr = false;
    this.aSt = false;
    this.aSu = false;
    this.aSV = true;
    this.aSY = false;
    this.aSc = true;
    this.aSd = false;
    if (this.f != null)
    {
      this.f.removeAllViews();
      this.A = null;
    }
    if (this.jdField_a_of_type_Yjh != null) {
      this.jdField_a_of_type_Yjh.ciA();
    }
    if (this.rE != null)
    {
      this.rE.setVisibility(4);
      this.rE = null;
    }
    if (this.c != null)
    {
      this.c.onDestory();
      this.c = null;
    }
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.exR();
    }
  }
  
  public void bu(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward_type", 2147483647);
    if (i == 2147483647) {}
    String str;
    szy localszy;
    do
    {
      return;
      paramIntent.removeExtra("forward_type");
      if (i != -1) {
        break;
      }
      str = paramIntent.getStringExtra("forward_text");
      localszy = (szy)this.app.getBusinessHandler(49);
    } while (TextUtils.isEmpty(str));
    this.sessionInfo.aTl = paramIntent.getStringExtra("uin");
    this.sessionInfo.cZ = paramIntent.getIntExtra("uintype", -1);
    paramIntent = this.app;
    SessionInfo localSessionInfo = this.sessionInfo;
    if ((bkE) && (this.bkD)) {}
    for (boolean bool = true;; bool = false)
    {
      localszy.a(paramIntent, localSessionInfo, str, bool);
      return;
    }
    super.bu(paramIntent);
  }
  
  public void cfU()
  {
    int i = (int)(6.0F * this.mActivity.getResources().getDisplayMetrics().density);
    Object localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).leftMargin = i;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject1 = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject1).a(Long.parseLong(this.sessionInfo.aTl));
    ProductInfo localProductInfo;
    if (localDeviceInfo != null)
    {
      localProductInfo = ((syw)localObject1).a(localDeviceInfo.productId);
      if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(4)))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
        }
        ((FrameLayout.LayoutParams)localObject2).leftMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.bXS = localDeviceInfo.productId;
    }
    for (;;)
    {
      bkE = ((syw)localObject1).a(Long.parseLong(this.sessionInfo.aTl)).booleanValue();
      boolean bool1 = SettingCloneUtil.readValue(this.mActivity, this.sessionInfo.aTl, null, "devicemsg_showsupporttips_first", true);
      boolean bool2 = SettingCloneUtil.readValue(this.mActivity, this.sessionInfo.aTl, null, "devicemsg_openchat_firsttrue", false);
      if (localProductInfo != null)
      {
        if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
          this.bkC = true;
        }
        if ((!bool2) && ((localDeviceInfo.SSOBid_Platform == 1027) || ((!aqmr.isEmpty(localDeviceInfo.SSOBid_Version)) && (Double.valueOf(localDeviceInfo.SSOBid_Version).doubleValue() >= 1.1D))))
        {
          this.bkD = true;
          SettingCloneUtil.writeValue(this.mActivity, this.sessionInfo.aTl, null, "devicemsg_openchat_firsttrue", true);
        }
      }
      else
      {
        if ((this.bkC) && (this.bkD) && (localDeviceInfo != null)) {
          tar.a(this.app, localDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, localDeviceInfo.productId);
        }
        if ((localProductInfo != null) && (bool1))
        {
          if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
            break label565;
          }
          localObject1 = this.app.getApp().getString(2131692607);
          label380:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = (szy)this.app.getBusinessHandler(49);
            if ((this.bkC) && (localDeviceInfo.isAdmin == 1) && (this.bkD) && (!bkE))
            {
              localObject2 = this.app.getApp().getString(2131692632);
              ((szy)localObject1).a(this.sessionInfo.aTl, (String)localObject2, anaz.gQ(), true, false, true);
            }
            SettingCloneUtil.writeValue(this.mActivity, this.sessionInfo.aTl, null, "devicemsg_showsupporttips_first", false);
          }
        }
        if (QLog.isColorLevel())
        {
          if (localProductInfo == null) {
            break label907;
          }
          QLog.d(this.TAG, 2, "support msg type maintype" + localProductInfo.supportMainMsgType + ", FuncMsgType:" + localProductInfo.supportFuncMsgType);
        }
      }
      for (;;)
      {
        cfV();
        return;
        if ((!bool2) && (!bkE)) {
          break;
        }
        this.bkD = true;
        break;
        label565:
        localObject2 = this.app.getApp().getString(2131692630);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131692631) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.app.getApp().getString(2131692558) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131692563) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1)) {
          localObject2 = (String)localObject1 + this.app.getApp().getString(2131692611) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2)) {
          localObject1 = (String)localObject2 + this.app.getApp().getString(2131692634) + "、";
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = (String)localObject2 + this.app.getApp().getString(2131692629);
        break label380;
        label907:
        QLog.d(this.TAG, 2, "product is null");
      }
      localProductInfo = null;
    }
  }
  
  void cfV()
  {
    int i = (int)(6.0F * this.mActivity.getResources().getDisplayMetrics().density);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    Object localObject = (syw)this.app.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = ((syw)localObject).a(Long.parseLong(this.sessionInfo.aTl));
    if (localDeviceInfo != null) {}
    for (localObject = ((syw)localObject).a(localDeviceInfo.productId);; localObject = null)
    {
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
        }
        for (;;)
        {
          if (!((ProductInfo)localObject).isSupportMainMsgType(1)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          }
          return;
          if (((ProductInfo)localObject).isSupportMainMsgType(15))
          {
            if ((((ProductInfo)localObject).isSupportFuncMsgType(3)) || (((ProductInfo)localObject).isSupportFuncMsgType(1)) || (!((ProductInfo)localObject).isSupportFuncMsgType(2))) {}
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(8))
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (VersionUtils.isHoneycomb()) {
              this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
            }
            localLayoutParams.leftMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 3)
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (VersionUtils.isHoneycomb()) {
              this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
            }
            localLayoutParams.leftMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(1))
          {
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else
            {
              this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
              if (VersionUtils.isHoneycomb()) {
                this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
              }
              localLayoutParams.leftMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(2))
          {
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.mActivity.getResources().getString(2131721570));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.mActivity.getResources().getColor(2131167532));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.mActivity.getResources().getString(2131721570));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.mActivity.getResources().getColor(2131167532));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.mActivity.getResources().getString(2131721570));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.mActivity.getResources().getColor(2131167532));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
              this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
              if (VersionUtils.isHoneycomb()) {
                this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
              }
              this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (VersionUtils.isHoneycomb()) {
              this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
            }
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.mActivity.getResources().getString(2131721570));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.mActivity.getResources().getColor(2131167532));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.mActivity.getResources().getString(2131721570));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.mActivity.getResources().getColor(2131167532));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.mActivity.getResources().getString(2131721570));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.mActivity.getResources().getColor(2131167532));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_b_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
  }
  
  /* Error */
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: invokespecial 1340	com/tencent/mobileqq/activity/BaseChatPie:doOnActivityResult	(IILandroid/content/Intent;)V
    //   7: bipush 84
    //   9: iload_1
    //   10: if_icmpne +190 -> 200
    //   13: aload_3
    //   14: ifnull +186 -> 200
    //   17: aload_0
    //   18: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: bipush 51
    //   23: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   26: checkcast 268	syw
    //   29: aload_0
    //   30: getfield 272	xya:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   33: getfield 277	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   36: invokestatic 283	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   39: invokevirtual 286	syw:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   42: astore 9
    //   44: aload_3
    //   45: ldc_w 347
    //   48: invokevirtual 448	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   51: astore 10
    //   53: new 247	android/content/Intent
    //   56: dup
    //   57: invokespecial 345	android/content/Intent:<init>	()V
    //   60: astore 11
    //   62: aload 11
    //   64: ldc_w 347
    //   67: aload 10
    //   69: invokevirtual 351	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   72: pop
    //   73: aload 11
    //   75: ldc_w 353
    //   78: iconst_1
    //   79: invokevirtual 357	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   82: pop
    //   83: aload 11
    //   85: ldc_w 359
    //   88: aload 9
    //   90: invokevirtual 362	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   93: pop
    //   94: aload 11
    //   96: ldc_w 382
    //   99: ldc_w 384
    //   102: invokevirtual 380	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   105: pop
    //   106: aload 11
    //   108: ldc_w 375
    //   111: ldc_w 1342
    //   114: invokevirtual 380	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   117: pop
    //   118: invokestatic 389	awjb:a	()Lawjb;
    //   121: aload_0
    //   122: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   125: aload_0
    //   126: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: aload_0
    //   130: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   133: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   136: aload 11
    //   138: ldc_w 398
    //   141: bipush 102
    //   143: aconst_null
    //   144: ldc_w 400
    //   147: invokevirtual 403	awjb:a	(Landroid/app/Activity;Lmqq/app/AppRuntime;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;ILandroid/content/DialogInterface$OnDismissListener;Ljava/lang/Class;)V
    //   150: iload_1
    //   151: tableswitch	default:+25 -> 176, 81:+602->753, 82:+25->176, 83:+670->821
    //   177: getfield 71	xya:operType	I
    //   180: iconst_4
    //   181: if_icmpne +18 -> 199
    //   184: iload_2
    //   185: iconst_m1
    //   186: if_icmpne +13 -> 199
    //   189: iload_1
    //   190: iconst_1
    //   191: if_icmpne +8 -> 199
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 79	xya:bkF	Z
    //   199: return
    //   200: iload_1
    //   201: bipush 102
    //   203: if_icmpne +20 -> 223
    //   206: iload_2
    //   207: iconst_m1
    //   208: if_icmpne -58 -> 150
    //   211: aload_3
    //   212: ifnull -62 -> 150
    //   215: aload_0
    //   216: aload_3
    //   217: invokespecial 622	xya:cs	(Landroid/content/Intent;)V
    //   220: goto -70 -> 150
    //   223: bipush 81
    //   225: iload_1
    //   226: if_icmpeq +9 -> 235
    //   229: bipush 83
    //   231: iload_1
    //   232: if_icmpne +441 -> 673
    //   235: aload_0
    //   236: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   239: bipush 51
    //   241: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   244: checkcast 268	syw
    //   247: astore 10
    //   249: aload 10
    //   251: aload_0
    //   252: getfield 272	xya:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   255: getfield 277	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   258: invokestatic 283	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   261: invokevirtual 286	syw:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   264: astore 9
    //   266: aload 9
    //   268: ifnull +834 -> 1102
    //   271: aload 10
    //   273: aload 9
    //   275: getfield 291	com/tencent/device/datadef/DeviceInfo:productId	I
    //   278: invokevirtual 294	syw:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   281: astore 10
    //   283: aload 10
    //   285: ifnull +817 -> 1102
    //   288: aload 10
    //   290: iconst_2
    //   291: invokevirtual 300	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   294: ifeq +808 -> 1102
    //   297: iconst_1
    //   298: istore 4
    //   300: lconst_0
    //   301: lstore 6
    //   303: iconst_0
    //   304: istore 5
    //   306: aload 9
    //   308: ifnull +17 -> 325
    //   311: aload 9
    //   313: getfield 303	com/tencent/device/datadef/DeviceInfo:din	J
    //   316: lstore 6
    //   318: aload 9
    //   320: getfield 291	com/tencent/device/datadef/DeviceInfo:productId	I
    //   323: istore 5
    //   325: iload 4
    //   327: ifne +34 -> 361
    //   330: aload_0
    //   331: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: bipush 49
    //   336: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   339: checkcast 193	szy
    //   342: astore_3
    //   343: aload_0
    //   344: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: lload 6
    //   349: ldc_w 305
    //   352: bipush 7
    //   354: iconst_0
    //   355: iload 5
    //   357: invokestatic 310	tar:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   360: return
    //   361: aload_0
    //   362: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   365: aload_0
    //   366: getfield 272	xya:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   369: getfield 277	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   372: aconst_null
    //   373: ldc_w 1344
    //   376: iconst_1
    //   377: invokestatic 1223	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   380: istore 8
    //   382: getstatic 405	xya:bkE	Z
    //   385: ifeq +61 -> 446
    //   388: iload 8
    //   390: ifeq +56 -> 446
    //   393: aload_0
    //   394: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   397: bipush 49
    //   399: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   402: checkcast 193	szy
    //   405: aload_0
    //   406: getfield 272	xya:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   409: getfield 277	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   412: ldc_w 1345
    //   415: invokestatic 436	acfp:m	(I)Ljava/lang/String;
    //   418: invokestatic 1266	anaz:gQ	()J
    //   421: iconst_1
    //   422: iconst_0
    //   423: iconst_1
    //   424: invokevirtual 1269	szy:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   427: aload_0
    //   428: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   431: aload_0
    //   432: getfield 272	xya:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   435: getfield 277	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   438: aconst_null
    //   439: ldc_w 1344
    //   442: iconst_0
    //   443: invokestatic 1250	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   446: getstatic 948	android/os/Build$VERSION:SDK_INT	I
    //   449: bipush 10
    //   451: if_icmpgt -301 -> 150
    //   454: aconst_null
    //   455: astore 10
    //   457: aload_0
    //   458: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   461: invokevirtual 1349	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   464: aload_3
    //   465: invokevirtual 1353	android/content/Intent:getData	()Landroid/net/Uri;
    //   468: ldc_w 1355
    //   471: invokevirtual 1361	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   474: astore 9
    //   476: aload 9
    //   478: ifnull +135 -> 613
    //   481: aload 9
    //   483: invokevirtual 1367	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   486: astore 9
    //   488: new 1369	java/io/FileOutputStream
    //   491: dup
    //   492: new 779	java/io/File
    //   495: dup
    //   496: aload_0
    //   497: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   500: invokevirtual 1373	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   503: invokestatic 1379	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   506: ldc_w 1381
    //   509: ldc 59
    //   511: invokeinterface 1383 3 0
    //   516: invokespecial 780	java/io/File:<init>	(Ljava/lang/String;)V
    //   519: invokespecial 1386	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   522: astore 11
    //   524: sipush 1024
    //   527: newarray byte
    //   529: astore 13
    //   531: aload 9
    //   533: aload 13
    //   535: invokevirtual 1392	java/io/FileInputStream:read	([B)I
    //   538: istore 4
    //   540: aload 11
    //   542: astore 12
    //   544: aload 9
    //   546: astore 10
    //   548: iload 4
    //   550: ifle +69 -> 619
    //   553: aload 11
    //   555: aload 13
    //   557: iconst_0
    //   558: iload 4
    //   560: invokevirtual 1396	java/io/FileOutputStream:write	([BII)V
    //   563: goto -32 -> 531
    //   566: astore 12
    //   568: aload 9
    //   570: astore 10
    //   572: aload 11
    //   574: astore 9
    //   576: aload 12
    //   578: astore 11
    //   580: aload 11
    //   582: invokevirtual 701	java/lang/Exception:printStackTrace	()V
    //   585: aload 10
    //   587: ifnull +8 -> 595
    //   590: aload 10
    //   592: invokevirtual 1399	java/io/FileInputStream:close	()V
    //   595: aload 9
    //   597: ifnull -447 -> 150
    //   600: aload 9
    //   602: invokevirtual 1400	java/io/FileOutputStream:close	()V
    //   605: goto -455 -> 150
    //   608: astore 9
    //   610: goto -460 -> 150
    //   613: aconst_null
    //   614: astore 10
    //   616: aconst_null
    //   617: astore 12
    //   619: aload 10
    //   621: ifnull +8 -> 629
    //   624: aload 10
    //   626: invokevirtual 1399	java/io/FileInputStream:close	()V
    //   629: aload 12
    //   631: ifnull -481 -> 150
    //   634: aload 12
    //   636: invokevirtual 1400	java/io/FileOutputStream:close	()V
    //   639: goto -489 -> 150
    //   642: astore 9
    //   644: goto -494 -> 150
    //   647: astore_3
    //   648: aconst_null
    //   649: astore 9
    //   651: aload 9
    //   653: ifnull +8 -> 661
    //   656: aload 9
    //   658: invokevirtual 1399	java/io/FileInputStream:close	()V
    //   661: aload 10
    //   663: ifnull +8 -> 671
    //   666: aload 10
    //   668: invokevirtual 1400	java/io/FileOutputStream:close	()V
    //   671: aload_3
    //   672: athrow
    //   673: iload_1
    //   674: getstatic 47	xya:bXU	I
    //   677: if_icmpne -527 -> 150
    //   680: iload_2
    //   681: getstatic 49	xya:bXV	I
    //   684: if_icmpne +54 -> 738
    //   687: aload_0
    //   688: invokevirtual 343	xya:finish	()V
    //   691: aload_0
    //   692: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   695: bipush 51
    //   697: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   700: checkcast 268	syw
    //   703: aload_0
    //   704: getfield 272	xya:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   707: getfield 277	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   710: invokestatic 283	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   713: invokevirtual 286	syw:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   716: invokestatic 1405	tas:a	(Lcom/tencent/device/datadef/DeviceInfo;)Ljava/lang/String;
    //   719: astore 9
    //   721: aload 9
    //   723: ifnull -573 -> 150
    //   726: aload_0
    //   727: getfield 1408	xya:mTitleText	Landroid/widget/TextView;
    //   730: aload 9
    //   732: invokevirtual 1413	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   735: goto -585 -> 150
    //   738: iload_2
    //   739: getstatic 51	xya:bXW	I
    //   742: if_icmpne -51 -> 691
    //   745: aload_0
    //   746: iconst_1
    //   747: putfield 132	xya:bkH	Z
    //   750: goto -59 -> 691
    //   753: iload_2
    //   754: iconst_m1
    //   755: if_icmpne -579 -> 176
    //   758: aload_3
    //   759: ifnull -583 -> 176
    //   762: aload_3
    //   763: ldc_w 1415
    //   766: invokevirtual 448	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   769: astore_3
    //   770: aload_3
    //   771: ifnull -595 -> 176
    //   774: aload_3
    //   775: invokevirtual 344	java/util/ArrayList:size	()I
    //   778: ifle -602 -> 176
    //   781: aload_0
    //   782: aload_3
    //   783: iconst_0
    //   784: invokevirtual 1418	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   787: checkcast 1420	com/dataline/util/file/SendInfo
    //   790: invokevirtual 1421	com/dataline/util/file/SendInfo:getPath	()Ljava/lang/String;
    //   793: putfield 61	xya:mVideoPath	Ljava/lang/String;
    //   796: aload_0
    //   797: getfield 266	xya:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   800: aload_0
    //   801: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   804: aload_0
    //   805: getfield 272	xya:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   808: getfield 277	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   811: aload_0
    //   812: getfield 61	xya:mVideoPath	Ljava/lang/String;
    //   815: invokestatic 1427	szc:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   818: goto -642 -> 176
    //   821: aload_0
    //   822: aload_0
    //   823: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   826: invokevirtual 1373	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   829: invokestatic 1379	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   832: ldc_w 1381
    //   835: ldc 59
    //   837: invokeinterface 1383 3 0
    //   842: putfield 61	xya:mVideoPath	Ljava/lang/String;
    //   845: aload_0
    //   846: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   849: invokevirtual 1373	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   852: invokestatic 1379	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   855: invokeinterface 1046 1 0
    //   860: ldc_w 1381
    //   863: invokeinterface 1431 2 0
    //   868: invokeinterface 1055 1 0
    //   873: pop
    //   874: iload_2
    //   875: iconst_m1
    //   876: if_icmpne +139 -> 1015
    //   879: aload_0
    //   880: getfield 61	xya:mVideoPath	Ljava/lang/String;
    //   883: invokestatic 728	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   886: ifne -710 -> 176
    //   889: aload_0
    //   890: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   893: sipush 230
    //   896: invokestatic 1434	aqha:a	(Landroid/content/Context;I)Laqju;
    //   899: astore_3
    //   900: aload_3
    //   901: ldc_w 1435
    //   904: new 1437	xyd
    //   907: dup
    //   908: aload_0
    //   909: invokespecial 1438	xyd:<init>	(Lxya;)V
    //   912: invokevirtual 1442	aqju:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Laqju;
    //   915: pop
    //   916: aload_3
    //   917: ldc_w 1443
    //   920: new 1445	xye
    //   923: dup
    //   924: aload_0
    //   925: invokespecial 1446	xye:<init>	(Lxya;)V
    //   928: invokevirtual 1449	aqju:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Laqju;
    //   931: pop
    //   932: aload_3
    //   933: ldc_w 1450
    //   936: invokestatic 436	acfp:m	(I)Ljava/lang/String;
    //   939: invokevirtual 1454	aqju:setTitle	(Ljava/lang/String;)Laqju;
    //   942: pop
    //   943: new 779	java/io/File
    //   946: dup
    //   947: aload_0
    //   948: getfield 61	xya:mVideoPath	Ljava/lang/String;
    //   951: invokespecial 780	java/io/File:<init>	(Ljava/lang/String;)V
    //   954: astore 9
    //   956: aload_0
    //   957: getfield 393	xya:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   960: aload 9
    //   962: invokevirtual 1456	java/io/File:length	()J
    //   965: invokestatic 1462	com/tencent/mobileqq/shortvideo/ShortVideoUtils:g	(Landroid/content/Context;J)Ljava/lang/String;
    //   968: astore 9
    //   970: aload_3
    //   971: new 213	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 1463
    //   981: invokestatic 436	acfp:m	(I)Ljava/lang/String;
    //   984: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: aload 9
    //   989: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: ldc_w 1464
    //   995: invokestatic 436	acfp:m	(I)Ljava/lang/String;
    //   998: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokevirtual 1468	aqju:setMessage	(Ljava/lang/CharSequence;)Laqju;
    //   1007: pop
    //   1008: aload_3
    //   1009: invokevirtual 493	aqju:show	()V
    //   1012: goto -836 -> 176
    //   1015: aload_0
    //   1016: getfield 61	xya:mVideoPath	Ljava/lang/String;
    //   1019: invokestatic 728	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1022: ifne +11 -> 1033
    //   1025: aload_0
    //   1026: getfield 61	xya:mVideoPath	Ljava/lang/String;
    //   1029: invokestatic 1473	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   1032: pop
    //   1033: aload_0
    //   1034: ldc 59
    //   1036: putfield 61	xya:mVideoPath	Ljava/lang/String;
    //   1039: goto -863 -> 176
    //   1042: astore 9
    //   1044: goto -373 -> 671
    //   1047: astore_3
    //   1048: goto -397 -> 651
    //   1051: astore_3
    //   1052: aload 11
    //   1054: astore 10
    //   1056: goto -405 -> 651
    //   1059: astore_3
    //   1060: aload 10
    //   1062: astore 11
    //   1064: aload 9
    //   1066: astore 10
    //   1068: aload 11
    //   1070: astore 9
    //   1072: goto -421 -> 651
    //   1075: astore 11
    //   1077: aconst_null
    //   1078: astore 10
    //   1080: aconst_null
    //   1081: astore 9
    //   1083: goto -503 -> 580
    //   1086: astore 11
    //   1088: aconst_null
    //   1089: astore 12
    //   1091: aload 9
    //   1093: astore 10
    //   1095: aload 12
    //   1097: astore 9
    //   1099: goto -519 -> 580
    //   1102: iconst_0
    //   1103: istore 4
    //   1105: goto -805 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1108	0	this	xya
    //   0	1108	1	paramInt1	int
    //   0	1108	2	paramInt2	int
    //   0	1108	3	paramIntent	Intent
    //   298	806	4	i	int
    //   304	52	5	j	int
    //   301	47	6	l	long
    //   380	9	8	bool	boolean
    //   42	559	9	localObject1	Object
    //   608	1	9	localException1	Exception
    //   642	1	9	localException2	Exception
    //   649	339	9	localObject2	Object
    //   1042	23	9	localException3	Exception
    //   1070	28	9	localObject3	Object
    //   51	1043	10	localObject4	Object
    //   60	1009	11	localObject5	Object
    //   1075	1	11	localException4	Exception
    //   1086	1	11	localException5	Exception
    //   542	1	12	localObject6	Object
    //   566	11	12	localException6	Exception
    //   617	479	12	localObject7	Object
    //   529	27	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   524	531	566	java/lang/Exception
    //   531	540	566	java/lang/Exception
    //   553	563	566	java/lang/Exception
    //   590	595	608	java/lang/Exception
    //   600	605	608	java/lang/Exception
    //   624	629	642	java/lang/Exception
    //   634	639	642	java/lang/Exception
    //   457	476	647	finally
    //   481	488	647	finally
    //   656	661	1042	java/lang/Exception
    //   666	671	1042	java/lang/Exception
    //   488	524	1047	finally
    //   524	531	1051	finally
    //   531	540	1051	finally
    //   553	563	1051	finally
    //   580	585	1059	finally
    //   457	476	1075	java/lang/Exception
    //   481	488	1075	java/lang/Exception
    //   488	524	1086	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    if (this.aSY) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      super.doOnDestroy();
      try
      {
        this.mActivity.unregisterReceiver(this.ar);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    } while (!QLog.isColorLevel());
    QLog.w(this.TAG, 2, " already unregisterReceiver" + localIllegalArgumentException);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.operType == 3) || (this.operType == 4))
    {
      if (!this.bkF) {
        this.bkF = true;
      }
    }
    else {
      return;
    }
    super.finish();
  }
  
  public void gt(List<String> paramList)
  {
    szy localszy = (szy)this.app.getBusinessHandler(49);
    if ((bkE) && (this.bkD))
    {
      localszy.a().o(this.sessionInfo.aTl, paramList);
      paramList = ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(this.sessionInfo.aTl));
      tar.a(this.app, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localszy.a().a(szy.aIl, this.sessionInfo.aTl, paramList);
  }
  
  public void gu(List<String> paramList)
  {
    Intent localIntent = new Intent();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (!"".equals(str)))
      {
        localIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", str);
        localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
        localIntent.putExtra("uin", this.sessionInfo.aTl);
        localIntent.putExtra("uintype", this.sessionInfo.cZ);
        localIntent.putExtra("troop_uin", this.sessionInfo.troopUin);
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        akxq localakxq1 = akxj.a(2, 1007);
        akxj.a(1007, localIntent);
        akxq localakxq2 = akxj.a(1, 1007);
        localakxq2.NS(localakxq1.localUUID);
        if (localakxq2.a(akxj.b(1007, localIntent)))
        {
          localakxq2.a = new xya.a(this);
          akxj.a(localakxq2, this.app);
        }
        else
        {
          yq(str);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.uiHandler.removeMessages(20);
      this.uiHandler.sendEmptyMessageDelayed(20, 10000L);
      continue;
      this.uiHandler.removeMessages(20);
    }
  }
  
  public void k(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int i = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i + "currentID=" + this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm());
    }
    if (i == this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm())
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      return;
    }
    switch (i)
    {
    }
    do
    {
      for (;;)
      {
        super.k(paramObject);
        return;
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
        wmj.a(this.app, a(), this.sessionInfo, 2, true);
        continue;
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
        bID();
        continue;
        xro.i(this.app, "0X800407C", this.sessionInfo.cZ);
        Object localObject = new ahau.a();
        ((ahau.a)localObject).bJE = "send_file";
        ((ahau.a)localObject).cYX = 1;
        ahau.a(this.app.getCurrentAccountUin(), (ahau.a)localObject);
        localObject = (syw)this.app.getBusinessHandler(51);
        long l = Long.parseLong(this.sessionInfo.aTl);
        if ((localObject != null) && (((syw)localObject).bn(l)) && (((syw)localObject).i(l, 17))) {
          wmj.c(this.app, a(), this.sessionInfo);
        } else {
          wmj.a(this.app, a(), this.sessionInfo);
        }
      }
    } while (!this.bkG);
    wmj.a(this.app, super.a(), this.sessionInfo, null, null);
  }
  
  public void refresh(int paramInt)
  {
    super.refresh(paramInt);
    this.uiHandler.sendEmptyMessage(20);
  }
  
  public void send()
  {
    boolean bool = true;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      akxo.NQ((String)localObject1);
      if ((localObject1 != null) && (((String)localObject1).length() > 3478))
      {
        ChatActivityUtils.h(this.mActivity, 2131719509, 1);
        return;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      Object localObject3 = (syw)this.app.getBusinessHandler(51);
      Object localObject2 = ((syw)localObject3).a(Long.parseLong(this.sessionInfo.aTl));
      if (localObject2 != null)
      {
        localObject3 = ((syw)localObject3).a(((DeviceInfo)localObject2).productId);
        if ((localObject3 == null) || (!((ProductInfo)localObject3).isSupportMainMsgType(1))) {}
      }
      for (int i = 1;; i = 0)
      {
        long l = 0L;
        if (localObject2 != null) {
          l = ((DeviceInfo)localObject2).din;
        }
        for (int j = ((DeviceInfo)localObject2).productId;; j = 0)
        {
          if (i == 0)
          {
            localObject1 = (szy)this.app.getBusinessHandler(49);
            tar.a(this.app, l, "Usr_AIO_SendMsg", 7, 0, j);
            return;
          }
          localObject2 = (szy)this.app.getBusinessHandler(49);
          SessionInfo localSessionInfo;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = this.app;
            localSessionInfo = this.sessionInfo;
            if ((!bkE) || (!this.bkD)) {
              break label267;
            }
          }
          for (;;)
          {
            ((szy)localObject2).a((QQAppInterface)localObject3, localSessionInfo, (String)localObject1, bool);
            tar.a(this.app, l, "Usr_AIO_SendMsg", 6, 0, j);
            return;
            label267:
            bool = false;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public void vd(String paramString)
  {
    if (this.bkB) {
      super.vd(paramString);
    }
  }
  
  public void yq(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    gt(localArrayList);
  }
  
  static class a
    extends xuj.a
  {
    final String TAG = xya.class.getSimpleName();
    WeakReference<xya> activityRef;
    
    public a(xya paramxya)
    {
      this.activityRef = new WeakReference(paramxya);
    }
    
    public void a(CompressInfo paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "DeviceMsgChatPie, compress success, localUUID:" + paramCompressInfo.localUUID);
      }
    }
    
    public void b(CompressInfo paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "DeviceMsgChatPie, compress fail, localUUID:" + paramCompressInfo.localUUID);
      }
    }
    
    public void c(CompressInfo paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "DeviceMsgChatPie, compress complete, localUUID:" + paramCompressInfo.localUUID);
      }
      xya localxya = (xya)this.activityRef.get();
      if (localxya == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "onCompressComplete, error: activity is null");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "onCompressComplete, new path:" + paramCompressInfo.destPath);
      }
      localxya.yq(paramCompressInfo.destPath);
      xya.a(localxya).aJS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xya
 * JD-Core Version:    0.7.0.1
 */