package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
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
import android.os.Handler.Callback;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import clj;
import clk;
import cln;
import clo;
import clp;
import clq;
import clr;
import clw;
import clx;
import cly;
import clz;
import cmd;
import cme;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.ShareToQZoneBack;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountManager;
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
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.observer.BusinessObserver;

public class ForwardOperations
  implements DialogInterface.OnDismissListener, ShareToQZoneBack
{
  public static final int A = 2;
  private static final int jdField_B_of_type_Int = 100;
  private static final String jdField_B_of_type_JavaLangString = "k_qzone";
  private static final int jdField_C_of_type_Int = 36;
  private static final String jdField_C_of_type_JavaLangString = "k_send";
  private static final int D = 0;
  private static final int E = 1;
  static final int jdField_a_of_type_Int = 20000;
  public static final String a = "ForwardOperations";
  public static final int b = 20001;
  public static final String b = "com.tencent.intent.QQI_FORWARD";
  protected static final int c = 50001;
  public static final String c = "com.tencent.intent.QQI_FORWARD";
  public static final int d = 45;
  public static final String d = "k_back";
  public static final int e = 60;
  public static final String e = "UTF-8";
  public static final int f = 1;
  public static final String f = "com.qzone";
  public static final int g = 2;
  public static final String g = "isFromFavorites";
  protected static final int h = 0;
  public static final String h = "shareToQQ";
  protected static final int i = -1;
  public static final String i = "shareToQzone";
  protected static final int j = 3;
  public static final String j = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}";
  protected static final int k = 3;
  public static final String k = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel";
  protected static final int l = 1002;
  protected static final String l = "audioUrl";
  protected static final int m = 1003;
  protected static final String m = "imageUrl";
  protected static final int n = 1004;
  protected static final String n = "sourceUrl";
  protected static final int o = 1005;
  protected static final String o = "sourceIcon";
  protected static final int p = 0;
  protected static final int q = 1;
  protected static final int r = 2;
  protected static final int s = 16;
  protected static final int t = 1000;
  public static final String u = "emoInputType";
  public static final String x = "public_account";
  public static final int y = 0;
  public static final String y = "web_share";
  public static final int z = 1;
  public String A;
  private float jdField_a_of_type_Float;
  public long a;
  public Activity a;
  public Intent a;
  public Bundle a;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new cly(this);
  private cme jdField_a_of_type_Cme = new cme(this);
  protected ShareResultDialog a;
  public ForwardOperations.CancelCallback a;
  SendMultiPictureHelper jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper;
  public QQAppInterface a;
  private ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  protected AbsShareMsg a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
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
  String p = null;
  public String q;
  public String r;
  public String s;
  public String t;
  public int u;
  public int v;
  public String v;
  public int w;
  public String w;
  int x;
  public String z = "";
  
  public ForwardOperations(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    this.jdField_v_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = null;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new clo(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.u = paramIntent.getIntExtra("forward_type", -1);
    this.jdField_v_of_type_Int = paramIntent.getIntExtra("req_type", 2147483647);
    this.q = paramIntent.getStringExtra("forward_thumb");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("forward_urldrawable", false);
    this.r = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
    this.s = paramIntent.getStringExtra("forward_urldrawable_big_url");
    this.t = paramIntent.getStringExtra("forward_text");
    this.x = paramIntent.getIntExtra("FORWARD_EMOPGK_ID", -1);
    this.jdField_w_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
    if (this.u == 2)
    {
      this.t = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131563197);
      if (this.u == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo"));
      }
      this.e = paramIntent.getBooleanExtra("k_qzone", false);
      if ((!"com.tencent.intent.QQI_FORWARD".equals(paramIntent.getAction())) && ((!this.e) || (!paramIntent.getBooleanExtra("k_send", true)))) {
        break label903;
      }
    }
    label903:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.u == 2)
      {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
        if (this.jdField_a_of_type_Long > 0L) {
          Share.a(paramQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface.a(), this.jdField_a_of_type_Long, this.jdField_a_of_type_MqqObserverBusinessObserver);
        }
        f();
        paramActivity = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
        paramActivity.putInt("req_type", 1);
        paramActivity = StructMsgFactory.a(paramActivity);
        if ((paramActivity != null) && ((paramActivity instanceof AbsShareMsg))) {
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
        }
      }
      if (paramIntent.getBooleanExtra("frommqq_conversation_btn", false))
      {
        ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).e(false);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "msgtab_shortcut", "digital_camera", 0, 0, "", "", "", "");
      }
      g();
      j();
      return;
      if ((this.u == 0) || (this.u == 1))
      {
        paramActivity = paramIntent.getData();
        if (paramActivity == null) {
          break;
        }
        a(paramActivity);
        break;
      }
      if (this.u == -1)
      {
        if (this.t != null) {
          break;
        }
        paramActivity = (SpannableString)this.jdField_a_of_type_AndroidOsBundle.get("forward_text");
        if (paramActivity == null) {
          break;
        }
        this.t = paramActivity.toString();
        break;
      }
      if (this.u == -2)
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
      if (this.u == -3)
      {
        paramActivity = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
        if ((paramActivity == null) || (!(paramActivity instanceof AbsShareMsg))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
        break;
      }
      if (this.u != 11) {
        break;
      }
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
      this.z = "";
      paramActivity = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
      Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
      if ((this.jdField_v_of_type_Int == 5) && (TextUtils.isEmpty(paramActivity)) && (TextUtils.isEmpty((CharSequence)localObject)))
      {
        a(-1, BaseApplicationImpl.getContext().getString(2131559066), BaseApplicationImpl.getContext().getString(2131559067));
        return;
      }
      f();
      localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      if (!TextUtils.isEmpty(paramActivity)) {
        ((Bundle)localObject).putString("image_url_remote", paramActivity);
      }
      paramActivity = StructMsgFactory.a((Bundle)localObject);
      if (!AbsShareMsg.class.isInstance(paramActivity))
      {
        a(-1, BaseApplicationImpl.getContext().getString(2131559068), BaseApplicationImpl.getContext().getString(2131559069));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
      if ((this.jdField_a_of_type_Long <= 0L) || (this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name") == null)) {
        break;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      Share.a(paramQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface.a(), this.jdField_a_of_type_Long, this.jdField_a_of_type_MqqObserverBusinessObserver);
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
  
  private String a(Context paramContext, Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str.equals("content")) && (Build.VERSION.SDK_INT >= 24))
    {
      paramContext = paramContext.getContentResolver();
      try
      {
        paramContext = paramContext.openFileDescriptor(paramUri, "r");
        if (paramContext != null)
        {
          paramContext = a(paramContext.getFileDescriptor(), paramUri);
          return paramContext;
        }
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
      return "";
    }
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramContext = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
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
  
  /* Error */
  private static String a(java.io.FileDescriptor paramFileDescriptor, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: invokevirtual 543	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   7: astore 8
    //   9: ldc 136
    //   11: astore_1
    //   12: aload 8
    //   14: invokeinterface 549 1 0
    //   19: iconst_2
    //   20: if_icmplt +23 -> 43
    //   23: aload 8
    //   25: aload 8
    //   27: invokeinterface 549 1 0
    //   32: iconst_1
    //   33: isub
    //   34: invokeinterface 554 2 0
    //   39: checkcast 269	java/lang/String
    //   42: astore_1
    //   43: new 508	java/io/File
    //   46: dup
    //   47: getstatic 645	com/tencent/mobileqq/app/AppConstants:br	Ljava/lang/String;
    //   50: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: new 569	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 570	java/lang/StringBuilder:<init>	()V
    //   62: getstatic 645	com/tencent/mobileqq/app/AppConstants:br	Ljava/lang/String;
    //   65: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 586	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_1
    //   76: aload 8
    //   78: invokevirtual 648	java/io/File:exists	()Z
    //   81: ifne +9 -> 90
    //   84: aload 8
    //   86: invokevirtual 651	java/io/File:mkdir	()Z
    //   89: pop
    //   90: new 508	java/io/File
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 648	java/io/File:exists	()Z
    //   103: ifne +8 -> 111
    //   106: aload_1
    //   107: invokevirtual 654	java/io/File:createNewFile	()Z
    //   110: pop
    //   111: new 656	java/io/FileInputStream
    //   114: dup
    //   115: aload_0
    //   116: invokespecial 659	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   119: astore_0
    //   120: new 661	java/io/FileOutputStream
    //   123: dup
    //   124: aload_1
    //   125: invokespecial 664	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   128: astore 7
    //   130: aload_0
    //   131: invokevirtual 667	java/io/FileInputStream:available	()I
    //   134: i2l
    //   135: lstore 5
    //   137: lload 5
    //   139: ldc2_w 668
    //   142: ldiv
    //   143: l2d
    //   144: invokestatic 675	java/lang/Math:floor	(D)D
    //   147: d2i
    //   148: istore_3
    //   149: lload 5
    //   151: l2i
    //   152: ldc_w 676
    //   155: irem
    //   156: istore 4
    //   158: iload_3
    //   159: ifle +57 -> 216
    //   162: iconst_0
    //   163: istore_2
    //   164: iload_2
    //   165: iload_3
    //   166: if_icmpge +50 -> 216
    //   169: ldc_w 676
    //   172: newarray byte
    //   174: astore 8
    //   176: aload_0
    //   177: aload 8
    //   179: iconst_0
    //   180: ldc_w 676
    //   183: invokevirtual 680	java/io/FileInputStream:read	([BII)I
    //   186: pop
    //   187: aload 7
    //   189: aload 8
    //   191: invokevirtual 684	java/io/FileOutputStream:write	([B)V
    //   194: aload 7
    //   196: invokevirtual 687	java/io/FileOutputStream:flush	()V
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: goto -39 -> 164
    //   206: astore 8
    //   208: aload 8
    //   210: invokevirtual 688	java/io/IOException:printStackTrace	()V
    //   213: goto -102 -> 111
    //   216: iload 4
    //   218: newarray byte
    //   220: astore 8
    //   222: aload_0
    //   223: aload 8
    //   225: iconst_0
    //   226: iload 4
    //   228: invokevirtual 680	java/io/FileInputStream:read	([BII)I
    //   231: pop
    //   232: aload 7
    //   234: aload 8
    //   236: invokevirtual 684	java/io/FileOutputStream:write	([B)V
    //   239: aload 7
    //   241: invokevirtual 687	java/io/FileOutputStream:flush	()V
    //   244: aload_1
    //   245: invokevirtual 517	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   248: astore_1
    //   249: aload_0
    //   250: invokevirtual 689	java/io/FileInputStream:close	()V
    //   253: aload 7
    //   255: invokevirtual 690	java/io/FileOutputStream:close	()V
    //   258: aload_1
    //   259: areturn
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_0
    //   263: aload 7
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual 689	java/io/FileInputStream:close	()V
    //   270: aload_0
    //   271: invokevirtual 690	java/io/FileOutputStream:close	()V
    //   274: ldc 136
    //   276: areturn
    //   277: astore_0
    //   278: ldc 136
    //   280: areturn
    //   281: astore_1
    //   282: aconst_null
    //   283: astore 7
    //   285: aconst_null
    //   286: astore_0
    //   287: aload_0
    //   288: invokevirtual 689	java/io/FileInputStream:close	()V
    //   291: aload 7
    //   293: invokevirtual 690	java/io/FileOutputStream:close	()V
    //   296: aload_1
    //   297: athrow
    //   298: astore_0
    //   299: goto -3 -> 296
    //   302: astore_1
    //   303: aconst_null
    //   304: astore 7
    //   306: goto -19 -> 287
    //   309: astore_1
    //   310: goto -23 -> 287
    //   313: astore_1
    //   314: aconst_null
    //   315: astore 7
    //   317: aload_0
    //   318: astore_1
    //   319: aload 7
    //   321: astore_0
    //   322: goto -56 -> 266
    //   325: astore_1
    //   326: aload_0
    //   327: astore_1
    //   328: aload 7
    //   330: astore_0
    //   331: goto -65 -> 266
    //   334: astore_0
    //   335: aload_1
    //   336: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramFileDescriptor	java.io.FileDescriptor
    //   0	337	1	paramUri	Uri
    //   163	40	2	i1	int
    //   148	19	3	i2	int
    //   156	71	4	i3	int
    //   135	15	5	l1	long
    //   1	328	7	localFileOutputStream	java.io.FileOutputStream
    //   7	183	8	localObject	Object
    //   206	3	8	localIOException	java.io.IOException
    //   220	15	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   106	111	206	java/io/IOException
    //   111	120	260	java/lang/Exception
    //   266	274	277	java/lang/Exception
    //   111	120	281	finally
    //   287	296	298	java/lang/Exception
    //   120	130	302	finally
    //   130	149	309	finally
    //   169	199	309	finally
    //   216	249	309	finally
    //   120	130	313	java/lang/Exception
    //   130	149	325	java/lang/Exception
    //   169	199	325	java/lang/Exception
    //   216	249	325	java/lang/Exception
    //   249	258	334	java/lang/Exception
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
          if (str.equals(this.jdField_a_of_type_AndroidAppActivity.getString(2131560810))) {
            bool1 = true;
          }
        }
      }
    } while (!bool1);
    paramBundle.putBoolean("isBack2Root", true);
    paramBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131561807));
    paramIntent.putExtras(paramBundle);
  }
  
  private void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (paramQQCustomDialog == null) {}
    do
    {
      return;
      if (this.u != 2) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null);
    paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    return;
    if (this.u == 1001)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
      if (localObject != null)
      {
        localObject = StructMsgFactory.a((byte[])localObject);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        if ((localObject instanceof AbsShareMsg))
        {
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
          localLayoutParams.setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(-5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
        }
      }
    }
    while (((this.u != -3) && (this.u != 11)) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new clr(this, paramString, paramQQCustomDialog));
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
      this.jdField_a_of_type_AndroidOsBundle.putString("troop_uin", this.p);
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString2);
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramInt);
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", paramString3);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    if (this.u == 0) {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131561807));
    }
    if (AppConstants.P.equals(paramString2)) {
      if (this.u == 11) {
        i();
      }
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        h();
        return;
        if (AppConstants.Y.equals(paramString2))
        {
          d();
          return;
        }
        if ((this.u != 0) && (this.u != 1)) {
          break label566;
        }
        if (this.u == 1) {
          this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
        }
        if (!a().getBooleanExtra("sendMultiple", false)) {
          break;
        }
        if (a().getBooleanExtra("isFromShare", false)) {
          this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", BaseApplicationImpl.getContext().getString(2131559070));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper = new SendMultiPictureHelper((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
        }
        localObject = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      } while ((localObject == null) || (!(localObject instanceof ArrayList)));
      localObject = (ArrayList)localObject;
      localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < ((ArrayList)localObject).size())
      {
        localArrayList.add(a((Uri)((ArrayList)localObject).get(i1)));
        i1 += 1;
      }
    } while (localArrayList.size() <= 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.a(paramString1, paramString2, paramInt, paramString3, this.u, this.jdField_a_of_type_AndroidOsBundle, localArrayList);
    return;
    if (paramInt == 1008)
    {
      paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountManager.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (a().getBooleanExtra("isFromShare", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", BaseApplicationImpl.getContext().getString(2131559070));
        paramString1.addFlags(268435456);
        paramString1.addFlags(67108864);
        paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        a(paramString1, this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
      }
      paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramString1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
      return;
      paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      break;
      label566:
      if (this.u == 9)
      {
        paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        paramString1.addFlags(268435456);
        paramString1.addFlags(67108864);
        paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
      }
      else
      {
        if (this.u == -1)
        {
          if (paramInt == 1008) {}
          for (paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountManager.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));; paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class))
          {
            if (a().getBooleanExtra("isFromShare", false))
            {
              this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", BaseApplicationImpl.getContext().getString(2131559070));
              paramString1.addFlags(268435456);
              paramString1.addFlags(67108864);
              this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.t);
              paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
              a(paramString1, this.jdField_a_of_type_AndroidOsBundle);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
            }
            this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
            paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
            break;
          }
        }
        if (this.u == 10)
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.t);
          paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
          paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        }
        else
        {
          if (this.u == 11)
          {
            if ("-1010".equals(paramString2))
            {
              b();
              return;
            }
            a(paramString2, paramInt, paramString3);
            return;
          }
          if (this.u == 2)
          {
            a(paramString2, paramInt, paramString3);
            return;
          }
          if (this.u == -3)
          {
            this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
            if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
            {
              StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, paramString2, paramInt);
              paramString1 = (String)localObject;
            }
            else
            {
              paramString1 = new Intent();
              paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
            }
          }
          else
          {
            paramString1 = new Intent();
            paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
    }
  }
  
  private boolean a(Uri paramUri)
  {
    Object localObject = a(paramUri);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (this.u == 1) {}
      for (paramUri = this.jdField_a_of_type_AndroidAppActivity.getString(2131562614);; paramUri = this.jdField_a_of_type_AndroidAppActivity.getString(2131563032))
      {
        localObject = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624405);
        ((QQCustomDialog)localObject).setContentView(2130903165);
        ((QQCustomDialog)localObject).setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131562517));
        ((QQCustomDialog)localObject).setMessage(paramUri);
        ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomDialog)localObject).setCancelable(false);
        ((QQCustomDialog)localObject).setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131561692), new clw(this));
        ((QQCustomDialog)localObject).show();
        return false;
      }
    }
    paramUri = new File((String)localObject);
    long l1 = paramUri.length();
    if (l1 == 0L)
    {
      paramUri = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624405);
      paramUri.setContentView(2130903165);
      paramUri.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131562517));
      paramUri.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131563070));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131561692), new clx(this));
      paramUri.show();
      return false;
    }
    String str = paramUri.getName();
    if (!paramUri.canRead())
    {
      this.u = -1;
      this.t = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_type", -1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", (String)localObject);
    if (l1 < 1024L) {
      paramUri = l1 + " bytes";
    }
    for (;;)
    {
      if (this.u == 1) {
        this.q = ((String)localObject);
      }
      this.t = (this.jdField_a_of_type_AndroidAppActivity.getString(2131562105) + str + "\n" + this.jdField_a_of_type_AndroidAppActivity.getString(2131562106) + paramUri);
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
  
  private final void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 4096, this.jdField_a_of_type_Cme);
  }
  
  private void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    if (a().getBooleanExtra("isFromShare", false))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", BaseApplicationImpl.getContext().getString(2131559070));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    }
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    Object localObject2;
    Object localObject1;
    if (a().getBooleanExtra("sendMultiple", false))
    {
      localObject2 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      localObject1 = new ArrayList();
      if (this.u == 12) {
        localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("PhotoConst.PHOTO_PATHS");
      }
    }
    for (;;)
    {
      switch (this.u)
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
        switch (this.u)
        {
        default: 
          break;
        case -1: 
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", this.t);
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
  
  private void i()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("audio_url");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    Object localObject1;
    if ((!TextUtils.isEmpty(str5)) && (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localIntent.putExtra("dataline_forward_type", 101);
      localIntent.putExtra("dataline_forward_path", str5);
      Bundle localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
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
        if (((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl == null)
        {
          localObject1 = "";
          label283:
          localBundle.putString("struct_share_key_source_url", (String)localObject1);
          if (str1 != null) {
            break label537;
          }
          localObject1 = "";
          label299:
          localBundle.putString("struct_share_key_source_icon", (String)localObject1);
          if (((GetAppInfoProto.AndroidInfo)localObject2).messagetail != null) {
            break label542;
          }
          localObject1 = "";
          label318:
          localBundle.putString("struct_share_key_source_name", (String)localObject1);
          if (((GetAppInfoProto.AndroidInfo)localObject2).packName != null) {
            break label553;
          }
          localObject1 = "";
          label337:
          localBundle.putString("struct_share_key_source_a_action_data", (String)localObject1);
        }
      }
      else
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), "shareToQQ" })));
        localIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject1, 268435456));
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
          ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
        }
        localIntent.setFlags(67108864);
        localIntent.addFlags(268435456);
        localIntent.putExtras(localBundle);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        a(0, "", "");
      }
    }
    else if (TextUtils.isEmpty(str1))
    {
      if (HttpUtil.a((String)localObject2)) {
        break label564;
      }
      localObject1 = BaseApplicationImpl.getContext().getString(2131559071);
    }
    for (;;)
    {
      localIntent.putExtra("dataline_forward_type", 102);
      localIntent.putExtra("dataline_forward_text", (String)localObject1);
      break;
      localObject1 = str1;
      continue;
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl.get();
      break label283;
      label537:
      localObject1 = str1;
      break label299;
      label542:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).messagetail.get();
      break label318;
      label553:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).packName.get();
      break label337;
      label564:
      localObject1 = localObject2;
    }
  }
  
  private void j()
  {
    Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    int i1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131427461);
    int i2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131427459);
    this.jdField_w_of_type_Int = ((localDisplay.getWidth() - i1 * 2 - i2 * 3) / 4);
  }
  
  public int a()
  {
    return this.u;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    e();
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131427376));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    e();
    cmd localcmd = new cmd(this, paramInt2, paramString1, paramInt3, paramString2);
    if ((paramInt2 == 1) && (paramInt1 == 0)) {
      this.d = true;
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = new ShareResultDialog(this.jdField_a_of_type_AndroidAppActivity);
    }
    for (;;)
    {
      paramString2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131561692);
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"))) {
        paramString1 = paramString2 + this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      }
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(paramString1, localcmd);
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131560459);
      paramString1 = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog;
      boolean bool;
      if (paramInt1 == 0)
      {
        bool = true;
        label172:
        paramString1.a(bool);
        if (paramInt2 != 2) {
          break label254;
        }
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131560800);
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(0);
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.c(2131560799);
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131560801), localcmd);
      }
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.show();
          return;
          this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
          break;
          bool = false;
          break label172;
          label254:
          if (paramInt1 != 0) {
            break label270;
          }
          this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(null, null);
        }
        label270:
        if (paramInt1 == 1002) {
          if (QLog.isColorLevel()) {
            QLog.d("sdk_share", 2, "!!!upload image fail---------------------------------");
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131562862), localcmd);
          break;
          if (paramInt1 == 1003) {
            this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131560593);
          } else if (paramInt1 == 1004)
          {
            if (QLog.isColorLevel()) {
              QLog.d("sdk_share", 2, "!!!skey not ready fail---------------------------------");
            }
          }
          else if ((paramInt1 == 1005) && (QLog.isColorLevel())) {
            QLog.d("sdk_share", 2, "!!!vkey not ready fail---------------------------------");
          }
        }
      }
      catch (Exception paramString1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("sdk_share", 2, "resultDlg.show() failed");
      }
    }
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
    a(2131560592);
    new clz(this, paramString1, paramInt, paramString2).start();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    if (this.u == 1001)
    {
      if (this.jdField_v_of_type_Int == 13) {
        a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, paramString1);
      }
    }
    else
    {
      if (this.u == 13)
      {
        localObject1 = new clj(this);
        if ((paramInt == 0) || (paramInt == 1004)) {
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, paramString1, paramString3, "", true, paramString2, true, true, (Handler.Callback)localObject1, "");
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "10", "", "", "");
          return;
          if (paramInt == 1006) {
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, "0", paramString3, paramString1, true, paramString2, true, true, (Handler.Callback)localObject1, "");
          }
        }
      }
      if (this.u == 14)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString1);
        this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramInt);
        this.jdField_a_of_type_AndroidOsBundle.putInt("FORWARD_EMOPGK_ID", this.x);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
        this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        this.jdField_a_of_type_AndroidContentIntent.addFlags(268435456);
        this.jdField_a_of_type_AndroidContentIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQi", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
        this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", "FORWARD_EMOPGK_ID");
        return;
      }
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.u != 11)
    {
      localObject1 = localObject2;
      if (!"public_account".equals(this.jdField_w_of_type_JavaLangString))
      {
        localObject1 = localObject2;
        if (!"web_share".equals(this.jdField_w_of_type_JavaLangString))
        {
          localObject1 = localObject2;
          if (!"struct_msg_from_h5".equals(this.jdField_w_of_type_JavaLangString)) {
            localObject1 = paramString3;
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", 0);
    if (this.u == 11)
    {
      if ((AppConstants.P.equals(paramString1)) || (AppConstants.Y.equals(paramString1))) {
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 0);
      }
    }
    else
    {
      label474:
      if (this.jdField_a_of_type_Long != 55901189L) {
        break label1045;
      }
      localObject1 = null;
    }
    label1045:
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
      }
      e();
      paramString1 = new clp(this, paramString2, paramString1, paramInt, paramString3);
      paramString3 = new clq(this);
      paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", 0);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, (String)localObject1, this.t, 2131561746, 2131562857, paramString1, paramString3);
        label584:
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
        if (this.u != 0) {
          break label816;
        }
        if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
        {
          Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131562918), 1).show();
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageMaxLine(2);
        a(this.q, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
        this.p = paramString2;
        if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
        if ("-1010".equals(paramString1))
        {
          this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 1);
          break label474;
        }
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 2);
        break label474;
        if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, this.t, null, paramString1, paramString3);
          break label584;
        }
        if (paramInt == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, this.t, null, paramString1, paramString3);
          break label584;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, (String)localObject1, this.t, 2131561746, 2131562857, paramString1, paramString3);
        break label584;
        label816:
        if (this.u == 1)
        {
          if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
          {
            Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131562918), 1).show();
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
          }
          if (!TextUtils.isEmpty(this.q)) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
          }
        }
        else if (this.u == 12)
        {
          if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
          {
            Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131562918), 1).show();
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(this.t);
        }
        else if (this.u == -2)
        {
          paramString1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_location_string");
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString1);
        }
        else if (this.u == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithEmo(this.t, this.jdField_a_of_type_Float);
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
    if ((this.jdField_v_of_type_Int != 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("image_url"))))
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
    if (this.jdField_v_of_type_Int == 5) {}
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
    a(2131560592);
    new clk(this).start();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new cln(this));
  }
  
  protected void d()
  {
    int i3 = 1;
    int i1 = 1;
    int i2 = -1;
    Object localObject1;
    label119:
    Object localObject2;
    if (this.u == -1)
    {
      if (!QfavBuilder.a(this.t).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        break label512;
      }
      i3 = 0;
      i2 = i1;
      i1 = i3;
      if (i1 == 0) {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 63, i2);
      }
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    }
    else if (this.u == 1)
    {
      i3 = 3;
      if (a().getBooleanExtra("sendMultiple", false))
      {
        localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
        i1 = 0;
        if (i1 >= ((ArrayList)localObject1).size()) {
          break label533;
        }
        localObject2 = (Uri)((ArrayList)localObject1).get(i1);
        if (QfavBuilder.c(a(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {}
      }
    }
    label512:
    label533:
    for (i1 = -1;; i1 = 0)
    {
      i2 = i3;
      break;
      i1 += 1;
      break label119;
      if (this.q == null) {}
      for (localObject1 = a().getStringExtra("forward_filepath");; localObject1 = this.q)
      {
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
          }
        }
        i1 = i2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          i1 = i2;
          if (QfavBuilder.c(this.q).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            i1 = 0;
          }
        }
        i2 = i3;
        break;
      }
      if ((this.u == 11) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
        {
          i3 = 3;
          localObject1 = QfavUtil.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
          i1 = i2;
          if (localObject1 != null)
          {
            i1 = i2;
            if (QfavBuilder.c(((StructMsgItemImage)localObject1).h).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              i1 = 0;
            }
          }
          i2 = i3;
          break;
        }
        localObject1 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare))
        {
          i2 = 10;
          i1 = 2;
        }
        for (;;)
        {
          i3 = i2;
          if (QfavBuilder.a(i1, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
          {
            i1 = 0;
            break;
            a(i1, 2, null, 0, null);
            return;
          }
          i1 = -1;
          i2 = i3;
          break;
          i1 = 0;
          i2 = 2;
        }
      }
      i2 = -1;
      i1 = -1;
      break;
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void f()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardOperations
 * JD-Core Version:    0.7.0.1
 */