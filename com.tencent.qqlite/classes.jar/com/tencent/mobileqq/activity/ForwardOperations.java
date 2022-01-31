package com.tencent.mobileqq.activity;

import ami;
import amm;
import amr;
import amu;
import amv;
import amw;
import amx;
import amy;
import amz;
import ana;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anf;
import ang;
import anh;
import ani;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.ShareToQZoneBack;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.observer.BusinessObserver;

public class ForwardOperations
  implements DialogInterface.OnDismissListener, ShareToQZoneBack
{
  public static final int A = 1;
  public static final int B = 2;
  public static final String B = "emoInputType";
  private static final int C = 100;
  private static final int D = 36;
  private static final int E = 0;
  public static final String E = "public_account";
  private static final int F = 1;
  public static final String F = "web_share";
  private static final String I = "k_qzone";
  private static final String J = "k_send";
  static final int jdField_a_of_type_Int = 20000;
  public static final String a = "ForwardOperations";
  public static final int b = 20001;
  public static final String b = "com.tencent.intent.QQLite_FORWARD";
  protected static final int c = 50001;
  public static final String c = "com.tencent.intent.QQLite_FORWARD";
  public static final int d = 45;
  public static final String d = "k_back";
  public static final int e = 60;
  public static final String e = "appid";
  public static final int f = 1;
  public static final String f = "UTF-8";
  public static final int g = 2;
  public static final String g = "com.qzone";
  protected static final int h = 0;
  public static final String h = "isFromFavorites";
  protected static final int i = -1;
  public static final String i = "isMigSdkShare";
  protected static final int j = 3;
  public static final String j = "MigSdkShareNotDone";
  protected static final int k = 3;
  public static final String k = "shareToQQ";
  protected static final int l = 1002;
  public static final String l = "shareToQzone";
  protected static final int m = 1003;
  public static final String m = "sendToMyComputer";
  protected static final int n = 1004;
  public static final String n = "addToQQFavorites";
  protected static final int o = 1005;
  public static final String o = "shareToTroopBar";
  protected static final int p = 0;
  public static final String p = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}";
  protected static final int q = 1;
  public static final String q = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel";
  protected static final int r = 2;
  protected static final String r = "targetUrl";
  protected static final int s = 16;
  protected static final String s = "audioUrl";
  protected static final int t = 1000;
  protected static final String t = "imageUrl";
  protected static final int u = 200;
  protected static final String u = "sourceUrl";
  protected static final String v = "sourceIcon";
  public static final int z = 0;
  public String A;
  public String C = null;
  public String D;
  public String G = "";
  public String H;
  private float jdField_a_of_type_Float;
  public long a;
  public Activity a;
  public Intent a;
  public Bundle a;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new anh(this);
  protected ResultReceiver a;
  private ani jdField_a_of_type_Ani = new ani(this);
  protected ShareResultDialog a;
  public ForwardOperations.CancelCallback a;
  SendMultiPictureHelper jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper;
  public QQAppInterface a;
  private ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  protected AbsShareMsg a;
  public QQCustomDialog a;
  protected QQProgressDialog a;
  public GetAppInfoProto.GetAppinfoResponse a;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  protected BusinessObserver a;
  public boolean a;
  public long b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  private boolean e;
  public int v;
  public int w;
  String w;
  public int x;
  public String x;
  int y;
  public String y;
  public String z;
  
  public ForwardOperations(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    this.jdField_w_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = null;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new amv(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.v = paramIntent.getIntExtra("forward_type", -1);
    this.jdField_w_of_type_Int = paramIntent.getIntExtra("req_type", 2147483647);
    this.jdField_x_of_type_JavaLangString = paramIntent.getStringExtra("forward_thumb");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("forward_urldrawable", false);
    this.jdField_y_of_type_JavaLangString = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
    this.z = paramIntent.getStringExtra("forward_urldrawable_big_url");
    this.A = paramIntent.getStringExtra("forward_text");
    this.jdField_y_of_type_Int = paramIntent.getIntExtra("FORWARD_EMOPGK_ID", -1);
    this.D = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
    if (this.v == 2)
    {
      this.A = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131362797);
      if (this.v == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo"));
      }
      this.e = paramIntent.getBooleanExtra("k_qzone", false);
      if ((!"com.tencent.intent.QQLite_FORWARD".equals(paramIntent.getAction())) && ((!this.e) || (!paramIntent.getBooleanExtra("k_send", true)))) {
        break label1024;
      }
    }
    label1024:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool;
        if (this.v == 2)
        {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
          if (this.jdField_a_of_type_Long > 0L) {
            Share.a(paramQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface.a(), this.jdField_a_of_type_Long, this.jdField_a_of_type_MqqObserverBusinessObserver);
          }
          e();
          paramActivity = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
          paramActivity.putInt("req_type", 1);
          paramActivity = StructMsgFactory.a(paramActivity);
          if ((paramActivity != null) && ((paramActivity instanceof AbsShareMsg))) {
            this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
          }
        }
        if (paramIntent.getBooleanExtra("frommqq_conversation_btn", false))
        {
          ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).setCanLock(false);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "msgtab_shortcut", "digital_camera", 0, 0, "", "", "", "");
        }
        f();
        i();
        return;
        if ((this.v == 0) || (this.v == 1))
        {
          paramActivity = paramIntent.getData();
          if (paramActivity == null) {
            break;
          }
          a(paramActivity);
          break;
        }
        if (this.v == -1)
        {
          if (this.A != null) {
            break;
          }
          paramActivity = (SpannableString)this.jdField_a_of_type_AndroidOsBundle.get("forward_text");
          if (paramActivity == null) {
            break;
          }
          this.A = paramActivity.toString();
          break;
        }
        if (this.v == -2)
        {
          paramActivity = paramIntent.getData();
          if (paramActivity == null) {
            break;
          }
          paramActivity = paramActivity.toString();
          paramActivity = paramActivity.substring(paramActivity.indexOf("geo:")).split(",");
          if (paramActivity.length <= 1) {
            break;
          }
          Double.parseDouble(paramActivity[0]);
          Double.parseDouble(paramActivity[1]);
          break;
        }
        if (this.v == -3)
        {
          paramActivity = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
          if ((paramActivity == null) || (!(paramActivity instanceof AbsShareMsg))) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
          break;
        }
        if (this.v != 11) {
          break label998;
        }
        this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
        this.G = "";
        paramActivity = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
        Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
        if ((this.jdField_w_of_type_Int == 5) && (TextUtils.isEmpty(paramActivity)) && (TextUtils.isEmpty((CharSequence)localObject)))
        {
          a(-1, "请选择图片", "分享的图片不存在");
          try
          {
            OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", paramQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享的图片不存在");
            return;
          }
          catch (Exception paramActivity)
          {
            return;
          }
        }
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
          e();
        }
        localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
        if (!TextUtils.isEmpty(paramActivity)) {
          ((Bundle)localObject).putString("image_url_remote", paramActivity);
        }
        paramActivity = StructMsgFactory.a((Bundle)localObject);
        if (!AbsShareMsg.class.isInstance(paramActivity))
        {
          a(-1, "分享类型错误", "类型错误");
          try
          {
            OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", paramQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "类型错误");
            return;
          }
          catch (Exception paramActivity)
          {
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
        if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name") != null))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          Share.a(paramQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface.a(), this.jdField_a_of_type_Long, this.jdField_a_of_type_MqqObserverBusinessObserver);
        }
        try
        {
          OpenSdkStatic.a().a(0, "SHARE_CHECK_AGENT", paramQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
        }
        catch (Exception paramActivity) {}
      }
      break;
      label998:
      if (this.v != 15) {
        break;
      }
      this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("choose_friend_callback"));
      break;
    }
  }
  
  private int a(int paramInt)
  {
    float f1 = 1.0F;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    }
    if (this.jdField_a_of_type_Float <= 1.5D) {
      return (int)(f1 * 9.0F);
    }
    if (this.jdField_a_of_type_Float <= 2.0D) {
      return (int)(f1 * 9.0F);
    }
    return (int)(f1 * 4.0F);
  }
  
  private Dialog a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    String str3 = paramActivity.getResources().getString(paramInt1);
    Object localObject = paramActivity.getResources().getString(paramInt2);
    String str2 = paramActivity.getResources().getString(paramInt3);
    String str1 = paramActivity.getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject, new Object[] { paramString });; paramString = (String)localObject)
    {
      paramActivity = new Dialog(paramActivity, 2131624119);
      paramActivity.setContentView(2130903135);
      localObject = (TextView)paramActivity.findViewById(2131296911);
      if (localObject != null) {
        ((TextView)localObject).setText(str3);
      }
      localObject = (TextView)paramActivity.findViewById(2131296470);
      if (localObject != null) {
        ((TextView)localObject).setText(paramString);
      }
      paramString = (TextView)paramActivity.findViewById(2131296914);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)paramActivity.findViewById(2131296915);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return paramActivity;
    }
  }
  
  private Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  private Drawable a(Bitmap paramBitmap)
  {
    Object localObject = null;
    Bitmap localBitmap = ImageUtil.a(paramBitmap, a(0));
    paramBitmap = localObject;
    if (localBitmap != null) {
      paramBitmap = new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), localBitmap);
    }
    return paramBitmap;
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    return a(SkinUtils.a(paramDrawable));
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i1 = paramContext.getColumnIndexOrThrow("_data");
        paramContext.moveToFirst();
        paramUri = paramContext.getString(i1);
        paramContext.close();
        return paramUri;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private String a(Uri paramUri)
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 19) {
      i1 = 1;
    }
    Object localObject;
    for (;;)
    {
      if (i1 != 0)
      {
        localObject = paramUri.getPathSegments();
        if ((((List)localObject).size() >= 2) && ("document".equals(((List)localObject).get(0))))
        {
          localObject = (String)((List)localObject).get(1);
          if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
          {
            localObject = ((String)localObject).split(":");
            if ("primary".equalsIgnoreCase(localObject[0]))
            {
              return Environment.getExternalStorageDirectory() + "/" + localObject[1];
              i1 = 0;
            }
          }
          else
          {
            if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority())) {
              return a(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf((String)localObject).longValue()), null, null);
            }
            if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
            {
              localObject = ((String)localObject).split(":");
              paramUri = localObject[0];
              if ("image".equals(paramUri)) {
                paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return a(paramUri, "_id=?", new String[] { localObject[1] });
      if ("video".equals(paramUri))
      {
        paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
      }
      else if ("audio".equals(paramUri))
      {
        paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        continue;
        if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority())) {}
        return a(this.jdField_a_of_type_AndroidAppActivity, paramUri);
        return a(this.jdField_a_of_type_AndroidAppActivity, paramUri);
      }
      else
      {
        paramUri = null;
      }
    }
  }
  
  public static String a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    Context localContext = BaseApplicationImpl.getContext();
    try
    {
      paramString = localContext.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      if ((paramString == null) || (paramString != null)) {
        paramString.close();
      }
    }
    finally
    {
      try
      {
        if (paramString.moveToFirst())
        {
          paramUri = paramString.getString(paramString.getColumnIndexOrThrow("_data"));
          if (paramString != null) {
            paramString.close();
          }
          return paramUri;
        }
        if (paramString != null) {
          paramString.close();
        }
        return null;
      }
      finally {}
      paramUri = finally;
      paramString = localObject;
    }
    throw paramUri;
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    Object localObject = "";
    String str2 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    paramBundle = (Bundle)localObject;
    if (!TextUtils.isEmpty(str2)) {
      paramBundle = "" + str2;
    }
    localObject = paramBundle;
    if (!TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(paramBundle)) {
        break label168;
      }
      paramBundle = paramBundle + "\n";
    }
    label168:
    for (localObject = paramBundle + str1; !TextUtils.isEmpty(paramString); localObject = str1)
    {
      paramBundle = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = (String)localObject + "\n";
        paramBundle = paramBundle + paramString;
      }
      return paramBundle;
    }
    return localObject;
  }
  
  public static final String a(EditText paramEditText)
  {
    if (paramEditText == null) {
      return null;
    }
    if ((paramEditText.getEditableText() instanceof QQTextBuilder))
    {
      QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getEditableText();
      if (localQQTextBuilder != null) {
        return localQQTextBuilder.a();
      }
    }
    return paramEditText.getEditableText().toString();
  }
  
  private void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, BookShareAdviceEditActivity.class);
    localIntent.putExtra("qrreceivername", paramString);
    localIntent.putExtras(paramIntent);
    paramActivity.startActivityForResult(localIntent, 20001);
  }
  
  public static final void a(Context paramContext, boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("sdk_share", 2, "sdk callback=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    if (paramBoolean) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), paramString })));
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqshare", 2, paramContext.getMessage());
      return;
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString })));
    }
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    boolean bool1;
    do
    {
      return;
      boolean bool2 = paramBundle.getBoolean("isFromFavorites");
      bool1 = bool2;
      if (!bool2)
      {
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(this.jdField_a_of_type_AndroidAppActivity.getString(2131362705))) {
            bool1 = true;
          }
        }
      }
    } while (!bool1);
    paramBundle.putBoolean("isBack2Root", true);
    paramBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131362950));
    paramIntent.putExtras(paramBundle);
  }
  
  private void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (paramQQCustomDialog == null) {}
    do
    {
      return;
      if (this.v != 2) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null);
    paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    return;
    if ((this.v == 1001) || (this.v == -4))
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
      if (localObject != null)
      {
        localObject = StructMsgFactory.a((byte[])localObject);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(-5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
    while (((this.v != -3) && (this.v != 11)) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ana(this, paramString, paramQQCustomDialog));
      return;
    }
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare)) {
      ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
    }
    for (;;)
    {
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), (LinearLayout.LayoutParams)localObject);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      } else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject = new Intent();
    if ((paramInt == 1000) || (paramInt == 1004) || (paramInt == 1020)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("troop_uin", this.jdField_w_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString2);
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramInt);
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", paramString3);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    if (this.v == 0) {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131362950));
    }
    if (AppConstants.T.equals(paramString2)) {
      if (this.v == 11) {
        h();
      }
    }
    ArrayList localArrayList;
    int i1;
    do
    {
      do
      {
        return;
        if (((Intent)localObject).getBooleanExtra("MigSdkShareNotDone", false))
        {
          h();
          return;
        }
        g();
        return;
        if (AppConstants.ac.equals(paramString2))
        {
          c();
          return;
        }
        if (this.v != 1) {
          break label526;
        }
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
        if (!a().getBooleanExtra("sendMultiple", false)) {
          break;
        }
        if (a().getBooleanExtra("isFromShare", false)) {
          this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper = new SendMultiPictureHelper((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
        }
        localObject = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      } while ((localObject == null) || (!(localObject instanceof ArrayList)));
      localObject = (ArrayList)localObject;
      localArrayList = new ArrayList();
      i1 = 0;
      while (i1 < ((ArrayList)localObject).size())
      {
        localArrayList.add(a((Uri)((ArrayList)localObject).get(i1)));
        i1 += 1;
      }
    } while (localArrayList.size() <= 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.a(paramString1, paramString2, paramInt, paramString3, this.v, this.jdField_a_of_type_AndroidOsBundle, localArrayList);
    return;
    paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
    if (a().getBooleanExtra("isFromShare", false))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
      paramString1.addFlags(268435456);
      paramString1.addFlags(67108864);
      paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      a(paramString1, this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
    }
    paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramString1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
      return;
      label526:
      if (this.v == 0)
      {
        paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        if (a().getBooleanExtra("isFromShare", false))
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
          paramString1.addFlags(268435456);
          paramString1.addFlags(67108864);
          paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          a(paramString1, this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
        }
        paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      }
      else if (this.v == 9)
      {
        paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        paramString1.addFlags(268435456);
        paramString1.addFlags(67108864);
        paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
      }
      else if (this.v == -1)
      {
        paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        if (a().getBooleanExtra("isFromShare", false))
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
          paramString1.addFlags(268435456);
          paramString1.addFlags(67108864);
          this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.A);
          paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          a(paramString1, this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
        }
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
        paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      }
      else
      {
        if (this.v != 10) {
          break;
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.A);
        paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    if (this.v == 11) {
      if ("-1010".equals(paramString2))
      {
        b();
        if (this.jdField_w_of_type_Int != 1) {
          break label1090;
        }
        paramString3 = "1";
        label902:
        paramString1 = "1";
        if (paramInt != 0) {
          break label1130;
        }
        paramString1 = "1";
        label914:
        if (!"-1010".equals(paramString2)) {
          break label1266;
        }
        paramString1 = "4";
      }
    }
    label1090:
    label1130:
    label1266:
    for (;;)
    {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", this.jdField_a_of_type_Long + "", "10", "12", "0", paramString3, paramString2, paramString1, false);
      return;
      a(paramString2, paramInt, paramString3);
      switch (paramInt)
      {
      default: 
        i1 = 1;
      }
      for (;;)
      {
        try
        {
          OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(i1), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
        }
        catch (Exception paramString1) {}
        break;
        i1 = 1;
        continue;
        i1 = 2;
        continue;
        i1 = 3;
      }
      if (this.jdField_w_of_type_Int == 2)
      {
        paramString3 = "3";
        break label902;
      }
      if (this.jdField_w_of_type_Int == 5)
      {
        paramString3 = "2";
        break label902;
      }
      paramString3 = "4";
      break label902;
      if (1 == paramInt)
      {
        paramString1 = "2";
        break label914;
      }
      if (3000 != paramInt) {
        break label914;
      }
      paramString1 = "3";
      break label914;
      if (this.v == 2)
      {
        a(paramString2, paramInt, paramString3);
        return;
      }
      if (this.v == -3)
      {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
        {
          StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, paramString2, paramInt);
          paramString1 = (String)localObject;
          break;
        }
        paramString1 = new Intent();
        paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        break;
      }
      paramString1 = new Intent();
      paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      break;
    }
  }
  
  private boolean a(Uri paramUri)
  {
    Object localObject = a(paramUri);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (this.v == 1) {}
      for (paramUri = this.jdField_a_of_type_AndroidAppActivity.getString(2131364097);; paramUri = this.jdField_a_of_type_AndroidAppActivity.getString(2131364098))
      {
        localObject = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624119);
        ((QQCustomDialog)localObject).setContentView(2130903139);
        ((QQCustomDialog)localObject).setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131363513));
        ((QQCustomDialog)localObject).setMessage(paramUri);
        ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomDialog)localObject).setCancelable(false);
        ((QQCustomDialog)localObject).setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131363113), new anf(this));
        ((QQCustomDialog)localObject).show();
        return false;
      }
    }
    paramUri = new File((String)localObject);
    long l1 = paramUri.length();
    if (l1 == 0L)
    {
      paramUri = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624119);
      paramUri.setContentView(2130903139);
      paramUri.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131363513));
      paramUri.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131364099));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131363113), new ang(this));
      paramUri.show();
      return false;
    }
    String str = paramUri.getName();
    if (!paramUri.canRead())
    {
      this.v = -1;
      this.A = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_type", -1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", (String)localObject);
    if (l1 < 1024L) {
      paramUri = l1 + " bytes";
    }
    for (;;)
    {
      if (this.v == 1) {
        this.jdField_x_of_type_JavaLangString = ((String)localObject);
      }
      this.A = (this.jdField_a_of_type_AndroidAppActivity.getString(2131363837) + str + "\n" + this.jdField_a_of_type_AndroidAppActivity.getString(2131363838) + paramUri);
      return true;
      if (l1 < 1048576L)
      {
        paramUri = l1 / 1024L + " KB";
      }
      else
      {
        paramUri = new DecimalFormat("##0.00");
        paramUri = paramUri.format(l1 / 1048576.0D) + " MB";
      }
    }
  }
  
  private void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
      }
      d();
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
      ami localami = new ami(this);
      amw localamw = new amw(this);
      paramString3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_text");
      paramString1 = paramString3;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1 = paramString3;
        if (SubString.a(paramString3, "UTF-8") > 105) {
          paramString1 = SubString.a(paramString3, 105, "UTF-8", "...");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131362752), paramString1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131362794), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131362753), localami, localamw);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new amx(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(null);
      a(this.jdField_x_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      this.jdField_w_of_type_JavaLangString = paramString2;
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private final void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 4096, this.jdField_a_of_type_Ani);
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    if (a().getBooleanExtra("isFromShare", false))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    }
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("MigSdkShareNotDone", false);
    Object localObject2;
    Object localObject1;
    if (a().getBooleanExtra("sendMultiple", false))
    {
      localObject2 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      localObject1 = new ArrayList();
      if (this.v == 12) {
        localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("PhotoConst.PHOTO_PATHS");
      }
    }
    for (;;)
    {
      switch (this.v)
      {
      default: 
        localIntent.putExtra("sendMultiple", true);
        localIntent.putStringArrayListExtra("dataline_forward_pathlist", (ArrayList)localObject1);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.setResult(0, localIntent);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        int i1 = 0;
        while (i1 < ((ArrayList)localObject2).size())
        {
          Uri localUri = (Uri)((ArrayList)localObject2).get(i1);
          ((ArrayList)localObject1).add(a(this.jdField_a_of_type_AndroidAppActivity, localUri));
          i1 += 1;
        }
        localIntent.putExtra("dataline_forward_type", 100);
        break;
        localIntent.putExtra("dataline_forward_type", 101);
        break;
        switch (this.v)
        {
        default: 
          break;
        case -1: 
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", this.A);
          break;
        case 0: 
          localIntent.putExtra("dataline_forward_type", 100);
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
          {
            localObject2 = a().getStringExtra("forward_filepath");
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
            }
            localIntent.putExtra("dataline_forward_path", (String)localObject1);
          }
          else
          {
            localIntent.putExtra("dataline_forward_path", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
          }
          break;
        case 1: 
          localIntent.putExtra("dataline_forward_type", 101);
          localObject2 = a().getStringExtra("forward_extra");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = a().getStringExtra("forward_filepath");
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
          }
          localIntent.putExtra("dataline_forward_path", (String)localObject1);
        }
      }
    }
  }
  
  private void h()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("audio_url");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_multi_pic");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_multi_pic_path_list");
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qdshare_file");
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
      switch (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"))
      {
      case 3: 
      case 4: 
      default: 
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", "无效的图片链接");
      }
    }
    Bundle localBundle;
    for (;;)
    {
      localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      localBundle.putBoolean("isBack2Root", false);
      localBundle.putBoolean("is_share_flag", true);
      localBundle.putLong("res_share_id", AppShareIDUtil.a(this.jdField_a_of_type_Long));
      localBundle.putString("res_pkg_name", str2);
      localBundle.putString("res_detail_url", str1);
      localBundle.putString("app_name", str3);
      localBundle.putString("image_url_remote", (String)localObject2);
      localBundle.putString("image_url", str5);
      if (!TextUtils.isEmpty(str4)) {
        localBundle.putString("audio_url", str4);
      }
      if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        str1 = Share.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
        if (((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl != null) {
          break label1058;
        }
        localObject1 = "";
        label368:
        localBundle.putString("struct_share_key_source_url", (String)localObject1);
        if (str1 != null) {
          break label1070;
        }
        localObject1 = "";
        label385:
        localBundle.putString("struct_share_key_source_icon", (String)localObject1);
        if (((GetAppInfoProto.AndroidInfo)localObject2).messagetail != null) {
          break label1076;
        }
        localObject1 = "";
        label405:
        localBundle.putString("struct_share_key_source_name", (String)localObject1);
        if (((GetAppInfoProto.AndroidInfo)localObject2).packName != null) {
          break label1088;
        }
        localObject1 = "";
        label425:
        localBundle.putString("struct_share_key_source_a_action_data", (String)localObject1);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), "shareToQQ" })));
      localIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject1, 268435456));
      if (((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
      }
      localIntent.setFlags(67108864);
      localIntent.addFlags(268435456);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        break label1100;
      }
      localBundle.putBoolean("MigSdkShareNotDone", false);
      localBundle.putBoolean("isMigSdkShare", true);
      localObject1 = (LiteActivity)this.jdField_a_of_type_AndroidAppActivity;
      localIntent.putExtras(localBundle);
      ((LiteActivity)localObject1).a(localIntent);
      return;
      if (bool2)
      {
        localIntent.putExtra("dataline_forward_type", 100);
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          localIntent.putExtra("dataline_forward_path", (String)localObject1);
        } else {
          localIntent.putExtra("dataline_forward_path", str5);
        }
      }
      else
      {
        localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, "");
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
        if (QLog.isColorLevel())
        {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send text:0X8004931.");
          continue;
          localIntent.putExtra("dataline_forward_type", 101);
          localIntent.putExtra("dataline_forward_path", str5);
          continue;
          localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, str4);
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", (String)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
            continue;
            if (bool1)
            {
              localIntent.putExtra("dataline_forward_type", 101);
              if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
                localIntent.putExtra("dataline_forward_path", (String)localObject1);
              } else {
                localIntent.putExtra("dataline_forward_path", str5);
              }
            }
            else
            {
              localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, str1);
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", (String)localObject1);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
              if (QLog.isColorLevel())
              {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                continue;
                if ((TextUtils.isEmpty(str5)) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
                  break;
                }
                localIntent.putExtra("dataline_forward_type", 101);
                localIntent.putExtra("dataline_forward_path", str5);
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      if (HttpUtil.a((String)localObject2)) {
        break label1127;
      }
      localObject1 = "无效的图片链接";
    }
    for (;;)
    {
      localIntent.putExtra("dataline_forward_type", 102);
      localIntent.putExtra("dataline_forward_text", (String)localObject1);
      break;
      localObject1 = str1;
      continue;
      label1058:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl.get();
      break label368;
      label1070:
      localObject1 = str1;
      break label385;
      label1076:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).messagetail.get();
      break label405;
      label1088:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).packName.get();
      break label425;
      label1100:
      localIntent.putExtras(localBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      a(0, "", "");
      return;
      label1127:
      localObject1 = localObject2;
    }
  }
  
  private void i()
  {
    Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    int i1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492959);
    int i2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492957);
    this.jdField_x_of_type_Int = ((localDisplay.getWidth() - i1 * 2 - i2 * 3) / 4);
  }
  
  public int a()
  {
    return this.v;
  }
  
  protected int a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return 1;
    }
    if (paramArrayList.size() > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.more than 5");
      }
      return 3;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (QfavUtil.a(str, -1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "gotoQfavShareMsg|image type.picture too big [" + str + "]");
        }
        QfavReport.a(null, "Net_AddFav", 8, 3, -3);
        return 2;
      }
    }
    return 0;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492887));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1045	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   4: ifnull +20 -> 24
    //   7: aload_0
    //   8: getfield 1045	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   11: invokevirtual 1048	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   14: ifeq +10 -> 24
    //   17: aload_0
    //   18: getfield 1045	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   21: invokevirtual 1292	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   24: aload_0
    //   25: invokevirtual 1056	com/tencent/mobileqq/activity/ForwardOperations:d	()V
    //   28: new 1310	amq
    //   31: dup
    //   32: aload_0
    //   33: iload_2
    //   34: aload_3
    //   35: iload 4
    //   37: aload 5
    //   39: invokespecial 1313	amq:<init>	(Lcom/tencent/mobileqq/activity/ForwardOperations;ILjava/lang/String;ILjava/lang/String;)V
    //   42: astore 7
    //   44: iload_2
    //   45: iconst_1
    //   46: if_icmpne +12 -> 58
    //   49: iload_1
    //   50: ifne +8 -> 58
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 162	com/tencent/mobileqq/activity/ForwardOperations:d	Z
    //   58: aload_0
    //   59: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   62: ifnonnull +176 -> 238
    //   65: aload_0
    //   66: new 1050	com/tencent/biz/widgets/ShareResultDialog
    //   69: dup
    //   70: aload_0
    //   71: getfield 181	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   74: invokespecial 1316	com/tencent/biz/widgets/ShareResultDialog:<init>	(Landroid/content/Context;)V
    //   77: putfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   80: aload_0
    //   81: getfield 181	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   84: ldc_w 992
    //   87: invokevirtual 780	android/app/Activity:getString	(I)Ljava/lang/String;
    //   90: astore 5
    //   92: aload 5
    //   94: astore_3
    //   95: aload_0
    //   96: getfield 212	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   99: ldc_w 778
    //   102: invokevirtual 265	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 412	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +32 -> 140
    //   111: new 630	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 631	java/lang/StringBuilder:<init>	()V
    //   118: aload 5
    //   120: invokevirtual 646	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: getfield 212	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   127: ldc_w 778
    //   130: invokevirtual 265	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 646	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 647	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore_3
    //   140: aload_0
    //   141: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   144: aload_3
    //   145: aload 7
    //   147: invokevirtual 1319	com/tencent/biz/widgets/ShareResultDialog:a	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   150: aload_0
    //   151: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   154: ldc_w 1320
    //   157: invokevirtual 1322	com/tencent/biz/widgets/ShareResultDialog:a	(I)V
    //   160: aload_0
    //   161: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   164: astore_3
    //   165: iload_1
    //   166: ifne +82 -> 248
    //   169: iconst_1
    //   170: istore 6
    //   172: aload_3
    //   173: iload 6
    //   175: invokevirtual 1324	com/tencent/biz/widgets/ShareResultDialog:a	(Z)V
    //   178: iload_2
    //   179: iconst_2
    //   180: if_icmpne +74 -> 254
    //   183: aload_0
    //   184: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   187: ldc_w 1325
    //   190: invokevirtual 1322	com/tencent/biz/widgets/ShareResultDialog:a	(I)V
    //   193: aload_0
    //   194: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   197: iconst_0
    //   198: invokevirtual 1326	com/tencent/biz/widgets/ShareResultDialog:b	(I)V
    //   201: aload_0
    //   202: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   205: ldc_w 1327
    //   208: invokevirtual 1329	com/tencent/biz/widgets/ShareResultDialog:c	(I)V
    //   211: aload_0
    //   212: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   215: aload_0
    //   216: getfield 181	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   219: ldc_w 1330
    //   222: invokevirtual 780	android/app/Activity:getString	(I)Ljava/lang/String;
    //   225: aload 7
    //   227: invokevirtual 1332	com/tencent/biz/widgets/ShareResultDialog:b	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   230: aload_0
    //   231: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   234: invokevirtual 1333	com/tencent/biz/widgets/ShareResultDialog:show	()V
    //   237: return
    //   238: aload_0
    //   239: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   242: invokevirtual 1054	com/tencent/biz/widgets/ShareResultDialog:dismiss	()V
    //   245: goto -165 -> 80
    //   248: iconst_0
    //   249: istore 6
    //   251: goto -79 -> 172
    //   254: iload_1
    //   255: ifne +60 -> 315
    //   258: aload_0
    //   259: getfield 223	com/tencent/mobileqq/activity/ForwardOperations:v	I
    //   262: bipush 11
    //   264: if_icmpne +39 -> 303
    //   267: invokestatic 424	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   270: iconst_0
    //   271: ldc_w 962
    //   274: aload_0
    //   275: getfield 183	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   278: invokevirtual 307	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   281: aload_0
    //   282: getfield 303	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_Long	J
    //   285: invokestatic 430	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   288: ldc_w 938
    //   291: invokestatic 436	android/os/SystemClock:elapsedRealtime	()J
    //   294: invokestatic 441	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   297: iconst_0
    //   298: iconst_1
    //   299: aconst_null
    //   300: invokevirtual 444	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   303: aload_0
    //   304: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   307: aconst_null
    //   308: aconst_null
    //   309: invokevirtual 1332	com/tencent/biz/widgets/ShareResultDialog:b	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   312: goto -82 -> 230
    //   315: iload_1
    //   316: sipush 1002
    //   319: if_icmpne +114 -> 433
    //   322: invokestatic 748	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +13 -> 338
    //   328: ldc_w 750
    //   331: iconst_2
    //   332: ldc_w 1335
    //   335: invokestatic 758	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload_0
    //   339: getfield 223	com/tencent/mobileqq/activity/ForwardOperations:v	I
    //   342: bipush 11
    //   344: if_icmpne +67 -> 411
    //   347: aload_0
    //   348: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   351: aload_0
    //   352: getfield 181	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   355: ldc_w 1336
    //   358: iconst_1
    //   359: anewarray 4	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: iload_1
    //   365: invokestatic 1341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: aastore
    //   369: invokevirtual 1344	android/app/Activity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   372: invokevirtual 1346	com/tencent/biz/widgets/ShareResultDialog:a	(Ljava/lang/String;)V
    //   375: invokestatic 424	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   378: iconst_1
    //   379: ldc_w 962
    //   382: aload_0
    //   383: getfield 183	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   386: invokevirtual 307	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 303	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_Long	J
    //   393: invokestatic 430	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   396: ldc_w 938
    //   399: invokestatic 436	android/os/SystemClock:elapsedRealtime	()J
    //   402: invokestatic 441	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   405: iload_1
    //   406: iconst_1
    //   407: aconst_null
    //   408: invokevirtual 444	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   411: aload_0
    //   412: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   415: aload_0
    //   416: getfield 181	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   419: ldc_w 1347
    //   422: invokevirtual 780	android/app/Activity:getString	(I)Ljava/lang/String;
    //   425: aload 7
    //   427: invokevirtual 1332	com/tencent/biz/widgets/ShareResultDialog:b	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   430: goto -200 -> 230
    //   433: iload_1
    //   434: sipush 1003
    //   437: if_icmpne +16 -> 453
    //   440: aload_0
    //   441: getfield 160	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   444: ldc_w 1348
    //   447: invokevirtual 1322	com/tencent/biz/widgets/ShareResultDialog:a	(I)V
    //   450: goto -112 -> 338
    //   453: iload_1
    //   454: sipush 1004
    //   457: if_icmpne +22 -> 479
    //   460: invokestatic 748	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq -125 -> 338
    //   466: ldc_w 750
    //   469: iconst_2
    //   470: ldc_w 1350
    //   473: invokestatic 758	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: goto -138 -> 338
    //   479: iload_1
    //   480: sipush 1005
    //   483: if_icmpne -145 -> 338
    //   486: invokestatic 748	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -151 -> 338
    //   492: ldc_w 750
    //   495: iconst_2
    //   496: ldc_w 1352
    //   499: invokestatic 758	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: goto -164 -> 338
    //   505: astore_3
    //   506: invokestatic 748	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq -272 -> 237
    //   512: ldc_w 750
    //   515: iconst_2
    //   516: ldc_w 1354
    //   519: invokestatic 758	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: return
    //   523: astore_3
    //   524: goto -113 -> 411
    //   527: astore_3
    //   528: goto -225 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	ForwardOperations
    //   0	531	1	paramInt1	int
    //   0	531	2	paramInt2	int
    //   0	531	3	paramString1	String
    //   0	531	4	paramInt3	int
    //   0	531	5	paramString2	String
    //   170	80	6	bool	boolean
    //   42	384	7	localamq	amq
    // Exception table:
    //   from	to	target	type
    //   230	237	505	java/lang/Exception
    //   375	411	523	java/lang/Exception
    //   267	303	527	java/lang/Exception
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    a(paramInt, 1, null, 0, null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    a(2131362484);
    new amm(this, paramString1, paramInt, paramString2).start();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((a() != null) && ((a().getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (a().getBooleanExtra("qqfav_extra_from_system_share", false))))
    {
      b(paramString1, paramInt, paramString2, paramString3);
      break label44;
    }
    label44:
    while ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    if (this.v == 1001)
    {
      if (this.jdField_w_of_type_Int == 13) {
        a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, paramString1);
      }
    }
    else
    {
      if (this.v == 14)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString1);
        this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramInt);
        this.jdField_a_of_type_AndroidOsBundle.putInt("FORWARD_EMOPGK_ID", this.jdField_y_of_type_Int);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
        this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        this.jdField_a_of_type_AndroidContentIntent.addFlags(268435456);
        this.jdField_a_of_type_AndroidContentIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("QQLite", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
        this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", "FORWARD_EMOPGK_ID");
        return;
      }
      if (this.v == 15)
      {
        paramString2 = new ArrayList();
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        if ((paramInt == 0) || (paramInt == 1004))
        {
          paramString2.add(paramString1);
          ((ArrayList)localObject1).add("");
          ((ArrayList)localObject2).add(paramString3);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
          {
            paramString1 = new Bundle();
            paramString1.putStringArrayList("choose_friend_uins", paramString2);
            paramString1.putStringArrayList("choose_friend_phones", (ArrayList)localObject1);
            paramString1.putStringArrayList("choose_friend_names", (ArrayList)localObject2);
            this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramString1);
          }
          if (this.jdField_a_of_type_AndroidAppActivity == null) {
            break;
          }
          this.jdField_a_of_type_AndroidAppActivity.setResult(1);
          this.jdField_a_of_type_AndroidAppActivity.finish();
          return;
          if (paramInt == 1006)
          {
            paramString2.add("");
            ((ArrayList)localObject1).add(paramString1);
            ((ArrayList)localObject2).add(paramString3);
          }
        }
      }
      if (this.v == 16)
      {
        a(2131363558);
        long l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("appid", -1L);
        UiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, new String[] { paramString1 }, new int[] { paramInt });
        return;
      }
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.v != 11)
    {
      localObject1 = localObject2;
      if (!"public_account".equals(this.D))
      {
        localObject1 = localObject2;
        if (!"web_share".equals(this.D))
        {
          localObject1 = localObject2;
          if (!"struct_msg_from_h5".equals(this.D)) {
            localObject1 = paramString3;
          }
        }
      }
    }
    if (AppConstants.T.equals(paramString1)) {
      localObject1 = paramString3;
    }
    this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", 0);
    if (this.v == 11)
    {
      if ((AppConstants.T.equals(paramString1)) || (AppConstants.ac.equals(paramString1))) {
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 0);
      }
    }
    else
    {
      label642:
      if (this.jdField_a_of_type_Long != 55901189L) {
        break label1250;
      }
      localObject1 = null;
    }
    label783:
    label1250:
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
      }
      d();
      paramString3 = new amy(this, paramString2, paramString1, paramInt, paramString3);
      localObject2 = new amz(this);
      paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", 0);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (paramString1 = "发送到 " + (String)localObject1;; paramString1 = (String)localObject1)
      {
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, paramString1, this.A, 2131362794, 2131363072, paramString3, (DialogInterface.OnClickListener)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
          if (this.v != 0) {
            break label1015;
          }
          if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
          {
            Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131364102), 1).show();
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageMaxLine(2);
          a(this.jdField_x_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
          this.jdField_w_of_type_JavaLangString = paramString2;
          if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          return;
          if ("-1010".equals(paramString1))
          {
            this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 1);
            break label642;
          }
          this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 2);
          break label642;
          if (paramInt == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, this.A, null, paramString3, (DialogInterface.OnClickListener)localObject2);
            break label783;
          }
          if (paramInt == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramString1, this.A, null, paramString3, (DialogInterface.OnClickListener)localObject2);
            break label783;
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, paramString1, this.A, 2131362794, 2131363072, paramString3, (DialogInterface.OnClickListener)localObject2);
          break label783;
          label1015:
          if (this.v == 1)
          {
            if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
            {
              Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131364102), 1).show();
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
            }
            if (!TextUtils.isEmpty(this.jdField_x_of_type_JavaLangString)) {
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
            }
          }
          else if (this.v == 12)
          {
            if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
            {
              Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131364102), 1).show();
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(this.A);
          }
          else if (this.v == -2)
          {
            paramString1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_location_string");
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString1);
          }
          else if (this.v == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithEmo(this.A, this.jdField_a_of_type_Float);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, HashMap paramHashMap)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(1003, 0, paramString1, paramInt, paramString2);
      return;
    }
    if ((this.jdField_w_of_type_Int != 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("image_url"))))
    {
      a(1002, 0, paramString1, paramInt, paramString2);
      return;
    }
    if (paramHashMap.containsKey("imageUrl"))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)paramHashMap.get("imageUrl"));
      this.jdField_a_of_type_AndroidOsBundle.remove("image_url");
    }
    if (paramHashMap.containsKey("audioUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("audio_url", (String)paramHashMap.get("audioUrl"));
    }
    if (paramHashMap.containsKey("targetUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("detail_url", (String)paramHashMap.get("targetUrl"));
    }
    if (paramHashMap.containsKey("sourceUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", (String)paramHashMap.get("sourceUrl"));
    }
    if (paramHashMap.containsKey("sourceIcon")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)paramHashMap.get("sourceIcon"));
    }
    paramHashMap = new Intent(this.jdField_a_of_type_AndroidAppActivity, MessageShareActivity.class);
    Bundle localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", paramInt);
    localBundle.putString("uinname", paramString2);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
      ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
    }
    paramHashMap.putExtras(localBundle);
    paramHashMap.setFlags(67108864);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramHashMap);
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_share2qq", 1, "", "", String.valueOf(this.jdField_a_of_type_Long));
    if (this.jdField_w_of_type_Int == 5) {}
    for (paramString2 = "connect_sharepic";; paramString2 = "connect_share2qq")
    {
      Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, "send", this.jdField_a_of_type_Long, b(), String.valueOf(paramInt));
      a(0, "", "");
      return;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    a(2131362484);
    new amr(this).start();
  }
  
  public int c()
  {
    for (;;)
    {
      long l1;
      Object localObject2;
      int i5;
      try
      {
        l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
      }
      catch (Exception localException1)
      {
        String str1;
        l1 = 0L;
      }
      try
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131362762);
        }
        i2 = 1;
        i3 = 1;
        i4 = 1;
        i5 = -1;
        if (this.v != -1) {
          break label232;
        }
        i2 = 1;
        if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title")))
        {
          i1 = i2;
          if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg"))) {
            break label700;
          }
        }
        i1 = i2;
        if (!QfavBuilder.a(null, false, this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg"), true, this.jdField_a_of_type_Long, (String)localObject1).a(l1, str1).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
          break label700;
        }
        i3 = 0;
        i2 = 0;
        i1 = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str2;
          ArrayList localArrayList;
          boolean bool;
          continue;
          i2 = 0;
          i3 = i4;
          break;
          i2 = 2;
          continue;
          i2 = 8;
          continue;
          i2 = 0;
          continue;
          i1 = 1;
        }
      }
      if (!a().getBooleanExtra("qqfav_extra_from_system_share", false)) {
        break;
      }
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", i1, 0, 67, i2, "", "");
      return i3;
      localException1.printStackTrace();
      str2 = "";
      continue;
      label232:
      i1 = i5;
      if (this.v != 11) {
        break label700;
      }
      i1 = i5;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {
        break label700;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
      {
        localObject2 = QfavUtil.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
        if (localObject2 == null) {
          break label724;
        }
        localArrayList = new ArrayList();
        localArrayList.add(((StructMsgItemImage)localObject2).h);
        i1 = a(localArrayList);
        if (i1 != 0) {}
        for (;;)
        {
          i2 = 1;
          i4 = 3;
          i3 = i1;
          i1 = i4;
          break;
          if (!QfavBuilder.a(localArrayList, true, a().getStringExtra("qqfav_extra_richmedia_title"), a().getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_a_of_type_Long, (String)localObject1).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            break label724;
          }
          i1 = 0;
        }
      }
      if (a().getBooleanExtra("qqfav_extra_pic_share", false))
      {
        i1 = 8;
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("qqfav_extra_multi_pic_path_list");
        bool = a().getBooleanExtra("qqfav_extra_only_pic", true);
        if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
          break label719;
        }
        i1 = a((ArrayList)localObject2);
        if (i1 != 0) {}
        for (;;)
        {
          if ((!bool) || (1 != ((ArrayList)localObject2).size())) {
            break label713;
          }
          i2 = 3;
          i4 = ((ArrayList)localObject2).size();
          i3 = i1;
          i1 = i2;
          i2 = i4;
          break;
          i1 = i2;
          if (QfavBuilder.a((ArrayList)localObject2, bool, a().getStringExtra("qqfav_extra_richmedia_title"), a().getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_a_of_type_Long, (String)localObject1).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            i1 = 0;
          }
        }
      }
      Object localObject1 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
      i3 = 0;
      if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
        break label708;
      }
      i3 = 2;
      i2 = 10;
      i1 = i2;
      if (!QfavBuilder.a(i3, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject1, true).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        break label700;
      }
      i3 = 0;
      i4 = 0;
      i1 = i2;
      i2 = i4;
    }
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", i1, 0, 68, i2, "", "");
    return i3;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new amu(this));
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void e()
  {
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("desc");
    Object localObject2 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject3;
      if (((String)localObject3).endsWith("...")) {
        localObject2 = ((String)localObject3).substring(0, ((String)localObject3).lastIndexOf("..."));
      }
    }
    localObject3 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = localObject1;
      if (((String)localObject1).endsWith("...")) {
        localObject3 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("..."));
      }
    }
    localObject1 = localObject2;
    if (SubString.a((String)localObject2, "UTF-8") > 45) {
      localObject1 = SubString.a((String)localObject2, 45, "UTF-8", null);
    }
    Object localObject4 = localObject3;
    if (SubString.a((String)localObject3, "UTF-8") > 90) {
      localObject4 = SubString.a((String)localObject3, 90, "UTF-8", null);
    }
    localObject2 = localObject4;
    if (SubString.a((String)localObject1, "UTF-8") + SubString.a((String)localObject4, "UTF-8") > 105) {
      localObject2 = SubString.a((String)localObject4, 105 - ((String)localObject1).length(), "UTF-8", "...");
    }
    if ((localObject1 != null) && (!((String)localObject1).endsWith("...")) && (!((String)localObject1).equals(this.jdField_a_of_type_AndroidOsBundle.getString("title")))) {
      localObject1 = (String)localObject1 + "...";
    }
    for (;;)
    {
      if ((localObject2 != null) && (!((String)localObject2).endsWith("...")) && (!((String)localObject2).equals(this.jdField_a_of_type_AndroidOsBundle.getString("desc")))) {
        localObject2 = (String)localObject2 + "...";
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("title", (String)localObject1);
        this.jdField_a_of_type_AndroidOsBundle.putString("desc", (String)localObject2);
        return;
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof DirectForwardActivity)) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004048", "0X8004048", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardOperations
 * JD-Core Version:    0.7.0.1
 */