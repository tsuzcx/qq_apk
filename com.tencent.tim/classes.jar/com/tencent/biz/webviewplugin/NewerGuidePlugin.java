package com.tencent.biz.webviewplugin;

import acfp;
import affz;
import afjy;
import ajrb;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import apuh;
import aqep;
import aqhu;
import arhz;
import ausj;
import auss;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import stl;
import stm;
import stn;
import sto;
import stp;
import stq;
import str;
import sts;
import stt;
import stu;
import stv;

public class NewerGuidePlugin
  extends WebViewPlugin
{
  private int byY;
  private int byZ;
  private int bza;
  private Uri k;
  private BroadcastReceiver mAvatarReceiver = new stm(this);
  private boolean mAvatarReceiverRegistered;
  private Client.b mOnRemoteResp = new stl(this);
  private int mSelectedIndex;
  private arhz r;
  
  public NewerGuidePlugin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "NewerGuidePlugin this=" + this);
    }
    this.mPluginNameSpace = "newerguide";
  }
  
  /* Error */
  private void K(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +29 -> 41
    //   15: ldc 52
    //   17: iconst_2
    //   18: ldc 85
    //   20: iconst_2
    //   21: anewarray 87	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: iload_1
    //   27: invokestatic 93	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: aload_2
    //   34: aastore
    //   35: invokestatic 99	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: new 101	org/json/JSONObject
    //   44: dup
    //   45: invokespecial 102	org/json/JSONObject:<init>	()V
    //   48: astore 7
    //   50: iload_1
    //   51: ifeq +146 -> 197
    //   54: iconst_1
    //   55: istore_3
    //   56: aload 7
    //   58: ldc 104
    //   60: iload_3
    //   61: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   64: pop
    //   65: iload_1
    //   66: ifeq +288 -> 354
    //   69: aload_2
    //   70: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   73: ifne +281 -> 354
    //   76: new 116	java/io/File
    //   79: dup
    //   80: aload_2
    //   81: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore 8
    //   86: aload 8
    //   88: invokevirtual 122	java/io/File:exists	()Z
    //   91: ifeq +263 -> 354
    //   94: aload 8
    //   96: invokevirtual 126	java/io/File:length	()J
    //   99: l2i
    //   100: newarray byte
    //   102: astore 6
    //   104: new 128	java/io/FileInputStream
    //   107: dup
    //   108: aload 8
    //   110: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: astore_2
    //   114: new 133	java/io/BufferedInputStream
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 136	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore 4
    //   124: aload 4
    //   126: aload 6
    //   128: invokevirtual 140	java/io/BufferedInputStream:read	([B)I
    //   131: ifle +17 -> 148
    //   134: aload 7
    //   136: ldc 142
    //   138: aload 6
    //   140: iconst_0
    //   141: invokestatic 148	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   144: invokevirtual 151	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload 8
    //   150: invokevirtual 154	java/io/File:delete	()Z
    //   153: pop
    //   154: aload_2
    //   155: astore 5
    //   157: aload 4
    //   159: astore_2
    //   160: aload 5
    //   162: ifnull +8 -> 170
    //   165: aload 5
    //   167: invokevirtual 157	java/io/FileInputStream:close	()V
    //   170: aload_2
    //   171: ifnull +7 -> 178
    //   174: aload_2
    //   175: invokevirtual 158	java/io/BufferedInputStream:close	()V
    //   178: aload_0
    //   179: ldc 160
    //   181: iconst_1
    //   182: anewarray 95	java/lang/String
    //   185: dup
    //   186: iconst_0
    //   187: aload 7
    //   189: invokevirtual 161	org/json/JSONObject:toString	()Ljava/lang/String;
    //   192: aastore
    //   193: invokevirtual 165	com/tencent/biz/webviewplugin/NewerGuidePlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   196: return
    //   197: iconst_0
    //   198: istore_3
    //   199: goto -143 -> 56
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_2
    //   206: ldc 52
    //   208: iconst_1
    //   209: ldc 167
    //   211: aload 5
    //   213: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 157	java/io/FileInputStream:close	()V
    //   226: aload_2
    //   227: ifnull -49 -> 178
    //   230: aload_2
    //   231: invokevirtual 158	java/io/BufferedInputStream:close	()V
    //   234: goto -56 -> 178
    //   237: astore_2
    //   238: goto -60 -> 178
    //   241: astore 4
    //   243: aconst_null
    //   244: astore_2
    //   245: aload_2
    //   246: ifnull +7 -> 253
    //   249: aload_2
    //   250: invokevirtual 157	java/io/FileInputStream:close	()V
    //   253: aload 5
    //   255: ifnull +8 -> 263
    //   258: aload 5
    //   260: invokevirtual 158	java/io/BufferedInputStream:close	()V
    //   263: aload 4
    //   265: athrow
    //   266: astore 4
    //   268: goto -98 -> 170
    //   271: astore_2
    //   272: goto -94 -> 178
    //   275: astore 4
    //   277: goto -51 -> 226
    //   280: astore_2
    //   281: goto -28 -> 253
    //   284: astore_2
    //   285: goto -22 -> 263
    //   288: astore 4
    //   290: goto -45 -> 245
    //   293: astore 6
    //   295: aload 4
    //   297: astore 5
    //   299: aload 6
    //   301: astore 4
    //   303: goto -58 -> 245
    //   306: astore 5
    //   308: aload 4
    //   310: astore 6
    //   312: aload 5
    //   314: astore 4
    //   316: aload_2
    //   317: astore 5
    //   319: aload 6
    //   321: astore_2
    //   322: goto -77 -> 245
    //   325: astore 5
    //   327: aconst_null
    //   328: astore 6
    //   330: aload_2
    //   331: astore 4
    //   333: aload 6
    //   335: astore_2
    //   336: goto -130 -> 206
    //   339: astore 5
    //   341: aload_2
    //   342: astore 6
    //   344: aload 4
    //   346: astore_2
    //   347: aload 6
    //   349: astore 4
    //   351: goto -145 -> 206
    //   354: aconst_null
    //   355: astore 5
    //   357: aload 6
    //   359: astore_2
    //   360: goto -200 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	NewerGuidePlugin
    //   0	363	1	paramBoolean	boolean
    //   0	363	2	paramString	String
    //   55	144	3	i	int
    //   1	221	4	localBufferedInputStream	java.io.BufferedInputStream
    //   241	23	4	localObject1	Object
    //   266	1	4	localException1	Exception
    //   275	1	4	localException2	Exception
    //   288	8	4	localObject2	Object
    //   301	49	4	localObject3	Object
    //   4	162	5	str1	String
    //   202	57	5	localException3	Exception
    //   297	1	5	localObject4	Object
    //   306	7	5	localObject5	Object
    //   317	1	5	str2	String
    //   325	1	5	localException4	Exception
    //   339	1	5	localException5	Exception
    //   355	1	5	localObject6	Object
    //   7	132	6	arrayOfByte	byte[]
    //   293	7	6	localObject7	Object
    //   310	48	6	localObject8	Object
    //   48	140	7	localJSONObject	JSONObject
    //   84	65	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   56	65	202	java/lang/Exception
    //   69	114	202	java/lang/Exception
    //   230	234	237	java/lang/Exception
    //   56	65	241	finally
    //   69	114	241	finally
    //   165	170	266	java/lang/Exception
    //   174	178	271	java/lang/Exception
    //   221	226	275	java/lang/Exception
    //   249	253	280	java/lang/Exception
    //   258	263	284	java/lang/Exception
    //   114	124	288	finally
    //   124	148	293	finally
    //   148	154	293	finally
    //   206	216	306	finally
    //   114	124	325	java/lang/Exception
    //   124	148	339	java/lang/Exception
    //   148	154	339	java/lang/Exception
  }
  
  private void aj(int paramInt1, int paramInt2, int paramInt3)
  {
    int m;
    int j;
    int i;
    if ((paramInt1 >= 1897) && (paramInt2 >= 1) && (paramInt2 <= 12) && (paramInt3 >= 1))
    {
      m = paramInt1;
      j = paramInt2;
      i = paramInt3;
      if (paramInt3 <= 31) {}
    }
    else
    {
      QLog.d("NewerGuidePlugin", 1, String.format("showDatePicker invalid params year=%s month=%s day=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      m = 1900;
      i = 1;
      j = 1;
    }
    Object localObject1 = this.mRuntime.getActivity();
    IphonePickerView localIphonePickerView = (IphonePickerView)((Activity)localObject1).getLayoutInflater().inflate(2131561390, null);
    localIphonePickerView.a(new a(-1));
    localObject1 = ausj.d((Context)localObject1);
    ((ausj)localObject1).setCloseAutoRead(true);
    ((ausj)localObject1).setActionContentView(localIphonePickerView, null);
    Object localObject2 = (DispatchActionMoveScrollView)((ausj)localObject1).findViewById(2131362014);
    ((DispatchActionMoveScrollView)localObject2).cZW = true;
    ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject2 = ((ausj)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setFlags(16777216, 16777216);
      }
    }
    localIphonePickerView.setPickListener(new str(this, localIphonePickerView, (ausj)localObject1));
    this.byY = (m - 1897);
    this.byZ = (j - 1);
    this.bza = (i - 1);
    localIphonePickerView.setSelection(0, this.byY);
    localIphonePickerView.setSelection(1, this.byZ);
    localIphonePickerView.setSelection(2, this.bza);
    try
    {
      ((ausj)localObject1).show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void al(JSONObject paramJSONObject)
    throws JSONException
  {
    int i = Integer.parseInt(paramJSONObject.getString("type"));
    try
    {
      String str = paramJSONObject.getString("uin");
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuidePlugin", 2, String.format("handleJumpCard type=%s uin=%s", new Object[] { Integer.valueOf(i), str }));
      }
      if ((i != 5) && (TextUtils.isEmpty(str))) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localObject = null;
        }
        switch (i)
        {
        default: 
          return;
        case 1: 
          paramJSONObject = QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "getPhoneBindState", null);
        }
      } while (!paramJSONObject.isSuccess());
      int j = paramJSONObject.data.getInt("selfBindState");
      i = 34;
      if (j <= 5) {
        i = 29;
      }
      paramJSONObject = new ProfileActivity.AllInOne((String)localObject, i);
      paramJSONObject.bJa = 100;
      localObject = new Intent(this.mRuntime.getActivity(), FriendProfileCardActivity.class);
      ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
      ((Intent)localObject).putExtra("from_newer_guide", true);
      startActivityForResult((Intent)localObject, (byte)1);
      return;
      paramJSONObject = new Intent(this.mRuntime.getActivity(), AccountDetailActivity.class);
      paramJSONObject.putExtra("uin", (String)localObject);
      paramJSONObject.putExtra("from_newer_guide", true);
      this.mRuntime.getActivity().overridePendingTransition(2130772004, 2130772005);
      startActivityForResult(paramJSONObject, (byte)i);
      return;
      localObject = TroopInfoActivity.c(String.valueOf(localObject), 35);
      ((Bundle)localObject).putString("authSig", paramJSONObject.optString("authSig"));
      ((Bundle)localObject).putBoolean("from_newer_guide", true);
      apuh.a(this.mRuntime.getActivity(), (Bundle)localObject, 2, 3);
      return;
      long l = Long.parseLong((String)localObject);
      paramJSONObject = new ProfileActivity.AllInOne("0", 41);
      paramJSONObject.bJa = 100;
      localObject = new Intent(this.mRuntime.getActivity(), NearbyPeopleProfileActivity.class);
      ((Intent)localObject).putExtra("param_mode", 3);
      ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
      ((Intent)localObject).putExtra("param_tiny_id", l);
      ((Intent)localObject).putExtra("from_newer_guide", true);
      startActivityForResult((Intent)localObject, (byte)i);
      return;
    }
    paramJSONObject = new ProfileActivity.AllInOne(this.mRuntime.a().getCurrentAccountUin(), 0);
    paramJSONObject.nickname = this.mRuntime.a().getCurrentNickname();
    paramJSONObject.bJa = 100;
    Object localObject = new Intent(this.mRuntime.getActivity(), FriendProfileCardActivity.class);
    ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
    ((Intent)localObject).putExtra("from_newer_guide", true);
    this.mRuntime.getActivity().startActivity((Intent)localObject);
  }
  
  private void am(JSONObject paramJSONObject)
    throws JSONException
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleUploadContacts");
    }
    Activity localActivity = this.mRuntime.getActivity();
    if ((localActivity != null) && ((localActivity instanceof BaseActivity)))
    {
      if (((BaseActivity)localActivity).checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
        an(paramJSONObject);
      }
    }
    else {
      return;
    }
    ((BaseActivity)localActivity).requestPermissions(new sts(this, paramJSONObject, localActivity), 1, new String[] { "android.permission.READ_CONTACTS" });
  }
  
  private void an(JSONObject paramJSONObject)
    throws JSONException
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("uploadContacts args=%s", new Object[] { paramJSONObject }));
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putString("key_action", "uploadContacts");
    paramJSONObject = affz.a("ipc_newer_guide", null, this.mOnRemoteResp.key, paramJSONObject);
    afjy.a().cq(paramJSONObject);
  }
  
  private void ao(JSONObject paramJSONObject)
    throws JSONException
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleGetRecommended");
    }
    Activity localActivity = this.mRuntime.getActivity();
    if ((localActivity != null) && ((localActivity instanceof BaseActivity))) {
      if (Build.VERSION.SDK_INT < 23) {
        break label92;
      }
    }
    label92:
    for (int i = ((BaseActivity)localActivity).checkSelfPermission("android.permission.READ_CONTACTS");; i = 0)
    {
      if (i == 0)
      {
        ap(paramJSONObject);
        return;
      }
      ((BaseActivity)localActivity).requestPermissions(new stt(this, paramJSONObject, localActivity), 1, new String[] { "android.permission.READ_CONTACTS" });
      return;
    }
  }
  
  private void ap(JSONObject paramJSONObject)
    throws JSONException
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("getRecommended args=%s", new Object[] { paramJSONObject }));
    }
    int i = Integer.parseInt(paramJSONObject.getString("wantCount"));
    paramJSONObject = new Bundle();
    paramJSONObject.putString("key_action", "getRecommendedList");
    paramJSONObject.putInt("wantCount", i);
    paramJSONObject = affz.a("ipc_newer_guide", null, this.mOnRemoteResp.key, paramJSONObject);
    afjy.a().cq(paramJSONObject);
  }
  
  private void aq(JSONObject paramJSONObject)
    throws JSONException
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("getRecommendedNew args=%s", new Object[] { paramJSONObject }));
    }
    long l = Long.parseLong(paramJSONObject.getString("uin"));
    int i = Integer.parseInt(paramJSONObject.getString("startIndex"));
    int j = Integer.parseInt(paramJSONObject.getString("num"));
    paramJSONObject = paramJSONObject.getString("callback");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_action", "getRecommendedListNew");
    localBundle.putLong("uin", l);
    localBundle.putInt("startIndex", i);
    localBundle.putInt("num", j);
    localBundle.putString("callback", paramJSONObject);
    paramJSONObject = affz.a("ipc_newer_guide", null, this.mOnRemoteResp.key, localBundle);
    afjy.a().cq(paramJSONObject);
  }
  
  private void b(String[] paramArrayOfString, int paramInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      QLog.d("NewerGuidePlugin", 1, "showSelector invalid params");
      return;
    }
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < paramArrayOfString.length) {}
    }
    else
    {
      i = 0;
    }
    Object localObject = this.mRuntime.getActivity();
    IphonePickerView localIphonePickerView = (IphonePickerView)((Activity)localObject).getLayoutInflater().inflate(2131561390, null);
    localIphonePickerView.a(new stp(this, paramArrayOfString));
    paramArrayOfString = ausj.d((Context)localObject);
    paramArrayOfString.setCloseAutoRead(true);
    paramArrayOfString.setActionContentView(localIphonePickerView, null);
    localObject = (DispatchActionMoveScrollView)paramArrayOfString.findViewById(2131362014);
    ((DispatchActionMoveScrollView)localObject).cZW = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = paramArrayOfString.getWindow();
      if (localObject != null) {
        ((Window)localObject).setFlags(16777216, 16777216);
      }
    }
    localIphonePickerView.setPickListener(new stq(this, paramArrayOfString));
    this.mSelectedIndex = i;
    localIphonePickerView.setSelection(0, i);
    try
    {
      paramArrayOfString.show();
      return;
    }
    catch (Exception paramArrayOfString) {}
  }
  
  private void bAI()
  {
    if (!this.mAvatarReceiverRegistered)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuidePlugin", 2, "registerAvatarReceiver");
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
      this.mRuntime.getActivity().registerReceiver(this.mAvatarReceiver, localIntentFilter);
      this.mAvatarReceiverRegistered = true;
    }
  }
  
  private void bAJ()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.getActivity();
    if (localBaseActivity != null)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label94;
      }
      int i = localBaseActivity.checkSelfPermission("android.permission.CAMERA");
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuidePlugin", 2, String.format("handleSetAvatar permission=%s", new Object[] { Integer.valueOf(i) }));
      }
      if (i == 0) {
        bAK();
      }
    }
    else
    {
      return;
    }
    localBaseActivity.requestPermissions(new stn(this, localBaseActivity), 1, new String[] { "android.permission.CAMERA" });
    return;
    label94:
    bAK();
  }
  
  private void bAK()
  {
    Activity localActivity = this.mRuntime.getActivity();
    String[] arrayOfString = localActivity.getResources().getStringArray(2130968638);
    ausj localausj = (ausj)auss.a(localActivity, null);
    localausj.addButton(arrayOfString[22]);
    localausj.addButton(arrayOfString[24]);
    localausj.addButton(arrayOfString[13]);
    localausj.addCancelButton(arrayOfString[16]);
    localausj.a(new sto(this, localActivity, localausj));
    if (!localActivity.isFinishing()) {}
    try
    {
      localausj.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static JSONObject k(String paramString)
  {
    paramString = ajrb.a("upload_for_new_guide", paramString, 4).getString("upload_for_new_guide", "");
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void unregisterAvatarReceiver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "unregisterAvatarReceiver");
    }
    this.mRuntime.getActivity().unregisterReceiver(this.mAvatarReceiver);
    this.mAvatarReceiverRegistered = false;
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("callJs func=%s", new Object[] { paramString }));
    }
    super.callJs(paramString, paramVarArgs);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("handleJsRequest pkgName=%s method=%s url=%s args=%s", new Object[] { paramString2, paramString3, paramString1, Arrays.toString(paramVarArgs) }));
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("newerguide".equals(paramString2))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString3))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString1))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            if (paramString3.equals("uploadContacts")) {
              am(paramJsBridgeListener);
            } else if (paramString3.equals("getRecommendedList")) {
              ao(paramJsBridgeListener);
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("NewerGuidePlugin", 1, "handleJsRequest fail", paramJsBridgeListener);
          }
          if (paramString3.equals("getRecommendedListNew"))
          {
            aq(paramJsBridgeListener);
          }
          else
          {
            int j;
            int i;
            if (paramString3.equals("skipGuide"))
            {
              j = 0;
              paramJsBridgeListener = QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "getPhoneBindState", null);
              i = j;
              if (paramJsBridgeListener.isSuccess())
              {
                i = j;
                if (paramJsBridgeListener.data.getInt("selfBindState") <= 5)
                {
                  paramJsBridgeListener = this.mRuntime.getActivity();
                  paramString1 = new Intent(paramJsBridgeListener, BindNumberActivity.class);
                  paramString1.putExtra("kSrouce", 10);
                  paramJsBridgeListener.startActivity(paramString1);
                  i = 1;
                }
              }
              if (i == 0)
              {
                paramJsBridgeListener = new Intent(this.mRuntime.getActivity(), SplashActivity.class);
                paramJsBridgeListener.putExtra("main_tab_id", 1);
                paramJsBridgeListener.setFlags(603979776);
                this.mRuntime.getActivity().startActivity(paramJsBridgeListener);
              }
            }
            else if (paramString3.equals("addFriend"))
            {
              paramString1 = QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "getPhoneBindState", null);
              if (paramString1.isSuccess())
              {
                i = 3006;
                j = 11;
                if (paramString1.data.getInt("selfBindState") <= 5)
                {
                  i = 3075;
                  j = 3;
                }
                paramString1 = paramJsBridgeListener.getString("uin");
                paramJsBridgeListener = paramJsBridgeListener.getString("name");
                paramJsBridgeListener = AddFriendLogicActivity.a(this.mRuntime.getActivity(), 2, paramString1, null, i, j, paramJsBridgeListener, null, null, null, null);
                paramJsBridgeListener.putExtra("from_newer_guide", true);
                startActivityForResult(paramJsBridgeListener, (byte)7);
              }
            }
            else if (paramString3.equals("followPublicAccount"))
            {
              paramJsBridgeListener = paramJsBridgeListener.getString("uin");
              paramString1 = new Bundle();
              paramString1.putString("key_action", "followPublicAccount");
              paramString1.putString("uin", paramJsBridgeListener);
              paramJsBridgeListener = affz.a("ipc_newer_guide", null, this.mOnRemoteResp.key, paramString1);
              afjy.a().cq(paramJsBridgeListener);
            }
            else if (paramString3.equals("joinTroop"))
            {
              paramString1 = paramJsBridgeListener.getString("uin");
              paramString2 = paramJsBridgeListener.getString("name");
              paramJsBridgeListener = paramJsBridgeListener.optString("authSig");
              paramString3 = new Bundle();
              paramString3.putString("key_action", "joinTroop");
              paramString3.putString("uin", paramString1);
              paramString3.putString("name", paramString2);
              paramString3.putString("authSig", paramJsBridgeListener);
              paramJsBridgeListener = affz.a("ipc_newer_guide", null, this.mOnRemoteResp.key, paramString3);
              afjy.a().cq(paramJsBridgeListener);
            }
            else if (paramString3.equals("joinTroopByTap"))
            {
              paramString1 = paramJsBridgeListener.getString("uin");
              paramString2 = paramJsBridgeListener.getString("name");
              paramJsBridgeListener = paramJsBridgeListener.optString("authSig");
              paramString3 = new Bundle();
              paramString3.putString("key_action", "joinTroopByTap");
              paramString3.putString("uin", paramString1);
              paramString3.putString("name", paramString2);
              paramString3.putString("authSig", paramJsBridgeListener);
              paramJsBridgeListener = affz.a("ipc_newer_guide", null, this.mOnRemoteResp.key, paramString3);
              afjy.a().cq(paramJsBridgeListener);
            }
            else if (paramString3.equals("sayHi"))
            {
              long l = Long.parseLong(paramJsBridgeListener.getString("uin"));
              paramJsBridgeListener = new Bundle();
              paramJsBridgeListener.putString("key_action", "sayHi");
              paramJsBridgeListener.putLong("tinyId", l);
              paramJsBridgeListener = affz.a("ipc_newer_guide", null, this.mOnRemoteResp.key, paramJsBridgeListener);
              afjy.a().cq(paramJsBridgeListener);
            }
            else if (paramString3.equals("jumpCard"))
            {
              al(paramJsBridgeListener);
            }
            else if (paramString3.equals("setAvatar"))
            {
              bAJ();
            }
            else
            {
              int m;
              if (paramString3.equals("selector"))
              {
                paramString1 = null;
                j = paramJsBridgeListener.getInt("index");
                paramString2 = paramJsBridgeListener.getJSONArray("options");
                paramJsBridgeListener = paramString1;
                if (paramString2 != null)
                {
                  paramJsBridgeListener = paramString1;
                  if (paramString2.length() > 0)
                  {
                    m = paramString2.length();
                    paramString1 = new String[m];
                    i = 0;
                    for (;;)
                    {
                      paramJsBridgeListener = paramString1;
                      if (i >= m) {
                        break;
                      }
                      paramString1[i] = paramString2.getString(i);
                      i += 1;
                    }
                  }
                }
                b(paramJsBridgeListener, j);
              }
              else if (paramString3.equals("datePicker"))
              {
                aj(paramJsBridgeListener.getInt("year"), paramJsBridgeListener.getInt("month"), paramJsBridgeListener.getInt("date"));
              }
              else if (paramString3.equals("queryUploadProgress"))
              {
                paramJsBridgeListener = paramJsBridgeListener.getString("callback");
                j = 0;
                i = 0;
                int n = 0;
                m = 0;
                paramString1 = k(this.mRuntime.a().getAccount());
                if (paramString1 != null)
                {
                  j = paramString1.optInt("state");
                  i = paramString1.optInt("total");
                  n = paramString1.optInt("curPer");
                  m = paramString1.optInt("expPer");
                }
                if (QLog.isColorLevel()) {
                  QLog.i("NewerGuidePlugin", 2, String.format("METHOD_QUERY_UPLOAD_PROGRESS [%s, %s, %s, %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(m) }));
                }
                double d = n / 100.0F;
                m = (int)(i * d);
                paramString1 = new JSONObject();
                paramString1.put("state", j);
                paramString1.put("total", i);
                paramString1.put("progress", d);
                paramString1.put("upload_count", m);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              else if (paramString3.equals("profileAvatar"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.getActivity(), AvatarPendantActivity.class);
                paramJsBridgeListener.putExtra("AllInOne", new ProfileActivity.AllInOne(this.mRuntime.a().getCurrentAccountUin(), 0));
                paramJsBridgeListener.putExtra("showActionSheet", true);
                this.mRuntime.getActivity().startActivity(paramJsBridgeListener);
              }
              else if (paramString3.equals("profileSex"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.getActivity(), FriendProfileMoreInfoActivity.class);
                paramJsBridgeListener.putExtra("profile_jump_to_edit", 1);
                this.mRuntime.getActivity().startActivity(paramJsBridgeListener);
              }
              else if (paramString3.equals("profileBirthday"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.getActivity(), FriendProfileMoreInfoActivity.class);
                paramJsBridgeListener.putExtra("profile_jump_to_edit", 2);
                this.mRuntime.getActivity().startActivity(paramJsBridgeListener);
              }
              else if (paramString3.equals("profileLocation"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.getActivity(), FriendProfileMoreInfoActivity.class);
                paramJsBridgeListener.putExtra("profile_jump_to_edit", 3);
                this.mRuntime.getActivity().startActivity(paramJsBridgeListener);
              }
              else if (paramString3.equals("profileSchool"))
              {
                paramJsBridgeListener = new Intent(this.mRuntime.getActivity(), FriendProfileMoreInfoActivity.class);
                paramJsBridgeListener.putExtra("profile_jump_to_edit", 4);
                this.mRuntime.getActivity().startActivity(paramJsBridgeListener);
              }
            }
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onActivityResult requestCode=%s resultCode=%s intent=%s", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt), paramIntent }));
    }
    Object localObject;
    if ((paramByte != 100) || ((paramInt == -1) && (paramIntent != null)))
    {
      try
      {
        K(true, paramIntent.getStringExtra("key_photo_file_path"));
        return;
      }
      catch (Exception paramIntent)
      {
        String str;
        Intent localIntent;
        QLog.e("NewerGuidePlugin", 1, "onActivityResult fail, requestCode=" + paramByte, paramIntent);
        return;
      }
      if (paramByte == 101)
      {
        if (paramInt == -1)
        {
          paramIntent = this.mRuntime.getActivity();
          localObject = aqhu.getRealPathFromContentURI(paramIntent, this.k);
          str = aqep.BR();
          paramInt = aqep.w(paramIntent);
          localIntent = new Intent();
          localIntent.setClass(paramIntent, PhotoCropForPortraitActivity.class);
          localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
          localIntent.putExtra("Business_Origin", 100);
          localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
          localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
          localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
          localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localObject);
          localIntent.putExtra("PhotoConst.TARGET_PATH", str);
          localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt);
          localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt);
          localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
          localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
          paramIntent.startActivity(localIntent);
        }
      }
      else if ((paramInt == -1) && (paramIntent != null))
      {
        localObject = new JSONObject();
        paramInt = i;
        if (paramIntent.getBooleanExtra("has_operation", false)) {
          paramInt = 1;
        }
        paramIntent = paramIntent.getStringExtra("uin");
        ((JSONObject)localObject).put("result", paramInt);
        ((JSONObject)localObject).put("uin", paramIntent);
        paramIntent = null;
        switch (paramByte)
        {
        }
      }
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        callJs(paramIntent, new String[] { ((JSONObject)localObject).toString() });
        return;
        paramIntent = "respCard";
        ((JSONObject)localObject).put("type", paramByte);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("NewerGuidePlugin", 1, "onActivityResult no result");
        }
      }
      return;
      continue;
      paramIntent = "respTroop";
      continue;
      paramIntent = "respFriend";
      continue;
      paramIntent = "respSayHi";
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "onCreate this=" + this);
    }
    afjy.a().a(this.mOnRemoteResp);
    bAI();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "onDestroy this=" + this);
    }
    super.onDestroy();
    afjy.a().b(this.mOnRemoteResp);
    unregisterAvatarReceiver();
  }
  
  public static final class PhoneInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<PhoneInfo> CREATOR = new stu();
    public String aGB;
    public String aGC;
    public String aGD;
    public String aGE;
    
    public PhoneInfo() {}
    
    public PhoneInfo(Parcel paramParcel)
    {
      this.aGB = paramParcel.readString();
      this.aGC = paramParcel.readString();
      this.aGD = paramParcel.readString();
      this.aGE = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.aGB);
      paramParcel.writeString(this.aGC);
      paramParcel.writeString(this.aGD);
      paramParcel.writeString(this.aGE);
    }
  }
  
  public static final class RecommendedListResp
    implements Parcelable
  {
    public static final Parcelable.Creator<RecommendedListResp> CREATOR = new stv();
    public long Dt;
    public int mEnd;
    public int mResult;
    public List<NewerGuidePlugin.PhoneInfo> pA = new ArrayList();
    
    public RecommendedListResp() {}
    
    public RecommendedListResp(Parcel paramParcel)
    {
      this.mResult = paramParcel.readInt();
      this.mEnd = paramParcel.readInt();
      this.Dt = paramParcel.readLong();
      this.pA = paramParcel.createTypedArrayList(NewerGuidePlugin.PhoneInfo.CREATOR);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mResult);
      paramParcel.writeInt(this.mEnd);
      paramParcel.writeLong(this.Dt);
      paramParcel.writeTypedList(this.pA);
    }
  }
  
  public class a
    implements IphonePickerView.d
  {
    private int bzb;
    
    public a(int paramInt)
    {
      if (paramInt < 1897)
      {
        this$1 = Calendar.getInstance();
        NewerGuidePlugin.this.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        this.bzb = NewerGuidePlugin.this.get(1);
        return;
      }
      this.bzb = paramInt;
    }
    
    public String d(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return "";
      case 0: 
        return paramInt2 + 1897 + acfp.m(2131708979);
      case 1: 
        return paramInt2 + 1 + acfp.m(2131708980);
      }
      return paramInt2 + 1 + acfp.m(2131708974);
    }
    
    public int getColumnCount()
    {
      return 3;
    }
    
    public int t(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        return this.bzb - 1897 + 1;
      case 1: 
        return 12;
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(1, NewerGuidePlugin.b(NewerGuidePlugin.this) + 1897);
      localCalendar.set(2, NewerGuidePlugin.c(NewerGuidePlugin.this));
      localCalendar.set(5, 1);
      return localCalendar.getActualMaximum(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin
 * JD-Core Version:    0.7.0.1
 */