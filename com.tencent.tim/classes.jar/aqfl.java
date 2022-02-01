import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.b;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.SystemDragUtils.2;
import com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aqfl
{
  private static boolean EX;
  private static aqfl.c a = new aqfl.c();
  private static final Boolean aK;
  private static final String csB = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/SharedIn/";
  private static final String csC = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/SharedOut/";
  private static final String csD = acfp.m(2131715101);
  public static int dYV = -1;
  public static float lastX;
  public static float lastY;
  
  static
  {
    aK = Boolean.valueOf(false);
  }
  
  private static aqfl.b a(Context paramContext, BaseBubbleBuilder.e parame)
  {
    long l = 0L;
    Object localObject1;
    if ((parame instanceof xle.a))
    {
      localObject1 = ahbr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), parame.mMessage);
      l = aqhq.getFileSizes((String)localObject1);
      parame = parame.E;
    }
    for (;;)
    {
      label75:
      Object localObject2;
      Object localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("SystemDragUtils", 1, "startDrag: no file " + (String)localObject1);
        return null;
        if ((parame instanceof xlb.a))
        {
          localObject1 = ahbr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), parame.mMessage);
          l = aqhq.getFileSizes((String)localObject1);
          parame = ((xlb.a)parame).c;
          continue;
        }
        if ((parame instanceof xlf.a))
        {
          localObject1 = ahbr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), parame.mMessage);
          l = aqhq.getFileSizes((String)localObject1);
          parame = ((xlf.a)parame).c;
          continue;
        }
        if ((parame instanceof xah.b))
        {
          localObject2 = (MessageForPic)parame.mMessage;
          localObject3 = ((MessageForPic)localObject2).getBiggestFilePath();
          String str = ahav.getFileName((String)localObject3);
          int i = avfp.fR((String)localObject3);
          localObject1 = ".jpg";
          if (i == 1001) {
            localObject1 = ".png";
          }
          for (;;)
          {
            localObject1 = csC + str + (String)localObject1;
            if (QLog.isColorLevel()) {
              QLog.d("SystemDragUtils", 2, "startDrag orgPath= " + (String)localObject3 + "  ,imageType=" + i + ",filePath=" + (String)localObject1);
            }
            if ((!aqhq.copyFile(((MessageForPic)localObject2).getBiggestFilePath(), (String)localObject1)) || (TextUtils.isEmpty(str))) {
              break label75;
            }
            l = ((MessageForPic)localObject2).size;
            parame = ((xah.b)parame).c;
            break;
            if (i == 1005) {
              localObject1 = ".bmp";
            } else if (i == 2000) {
              localObject1 = ".gif";
            }
          }
        }
        if ((parame instanceof ShortVideoItemBuilder.b))
        {
          localObject2 = (MessageForShortVideo)parame.mMessage;
          localObject1 = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
          l = ((MessageForShortVideo)localObject2).videoFileSize;
          parame = ((ShortVideoItemBuilder.b)parame).a;
          continue;
        }
        if ((parame instanceof ShortVideoRealItemBuilder.a))
        {
          localObject2 = (MessageForShortVideo)parame.mMessage;
          localObject1 = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
          l = ((MessageForShortVideo)localObject2).videoFileSize;
          parame = ((ShortVideoRealItemBuilder.a)parame).b;
        }
      }
      else
      {
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists())
        {
          QLog.e("SystemDragUtils", 1, "startDrag: no file " + (String)localObject1);
          return null;
        }
        if (((File)localObject2).length() < l)
        {
          QLog.e("SystemDragUtils", 1, "startDrag: Incomplete file " + (String)localObject1);
          return null;
        }
        if (parame == null)
        {
          QLog.e("SystemDragUtils", 1, "DragTrigger.onLongLongClick: dragView is null");
          return null;
        }
        QLog.d("SystemDragUtils", 1, "Start drag, path=" + (String)localObject1);
        localObject1 = FileProvider.getUriForFile(paramContext, "com.tencent.tim.fileprovider", (File)localObject2);
        localObject3 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject3).addCategory("android.intent.category.HOME");
        localObject3 = paramContext.getPackageManager().queryIntentActivities((Intent)localObject3, 65536).iterator();
        while (((Iterator)localObject3).hasNext()) {
          paramContext.grantUriPermission(((ResolveInfo)((Iterator)localObject3).next()).activityInfo.packageName, (Uri)localObject1, 3);
        }
        return new aqfl.b((File)localObject2, parame, ClipData.newUri(paramContext.getContentResolver(), "uri", (Uri)localObject1));
      }
      parame = null;
      localObject1 = null;
    }
  }
  
  /* Error */
  private static File a(Context paramContext, java.io.InputStream paramInputStream, String paramString1, String paramString2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: ifnull +183 -> 187
    //   7: sipush 8192
    //   10: newarray byte
    //   12: astore 7
    //   14: new 42	java/io/File
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 223	java/io/File:exists	()Z
    //   27: ifne +8 -> 35
    //   30: aload_0
    //   31: invokevirtual 317	java/io/File:mkdir	()Z
    //   34: pop
    //   35: new 42	java/io/File
    //   38: dup
    //   39: aload_2
    //   40: aload_3
    //   41: invokespecial 320	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 223	java/io/File:exists	()Z
    //   51: ifeq +9 -> 60
    //   54: aload 5
    //   56: invokevirtual 323	java/io/File:delete	()Z
    //   59: pop
    //   60: new 325	java/io/FileOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 328	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: astore_0
    //   70: aload_0
    //   71: astore_2
    //   72: aload_1
    //   73: aload 7
    //   75: invokevirtual 334	java/io/InputStream:read	([B)I
    //   78: istore 4
    //   80: iload 4
    //   82: iconst_m1
    //   83: if_icmpeq +47 -> 130
    //   86: aload_0
    //   87: astore_2
    //   88: aload_0
    //   89: aload 7
    //   91: iconst_0
    //   92: iload 4
    //   94: invokevirtual 340	java/io/OutputStream:write	([BII)V
    //   97: goto -27 -> 70
    //   100: astore_3
    //   101: aload 5
    //   103: astore_1
    //   104: aload_0
    //   105: astore_2
    //   106: ldc 128
    //   108: iconst_1
    //   109: ldc_w 342
    //   112: aload_3
    //   113: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_1
    //   117: astore_2
    //   118: aload_0
    //   119: ifnull +9 -> 128
    //   122: aload_0
    //   123: invokevirtual 348	java/io/OutputStream:close	()V
    //   126: aload_1
    //   127: astore_2
    //   128: aload_2
    //   129: areturn
    //   130: aload_0
    //   131: astore_2
    //   132: aload_0
    //   133: invokevirtual 351	java/io/OutputStream:flush	()V
    //   136: aload 5
    //   138: astore_2
    //   139: aload_0
    //   140: ifnull -12 -> 128
    //   143: aload_0
    //   144: invokevirtual 348	java/io/OutputStream:close	()V
    //   147: aload 5
    //   149: areturn
    //   150: astore_0
    //   151: aload 6
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 348	java/io/OutputStream:close	()V
    //   162: aload_0
    //   163: athrow
    //   164: astore_0
    //   165: aload_2
    //   166: astore_1
    //   167: goto -13 -> 154
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_1
    //   175: goto -71 -> 104
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_0
    //   181: aload 5
    //   183: astore_1
    //   184: goto -80 -> 104
    //   187: aconst_null
    //   188: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramContext	Context
    //   0	189	1	paramInputStream	java.io.InputStream
    //   0	189	2	paramString1	String
    //   0	189	3	paramString2	String
    //   78	15	4	i	int
    //   44	138	5	localFile	File
    //   1	151	6	localObject	Object
    //   12	78	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   72	80	100	java/io/IOException
    //   88	97	100	java/io/IOException
    //   132	136	100	java/io/IOException
    //   7	35	150	finally
    //   35	46	150	finally
    //   46	60	150	finally
    //   60	70	150	finally
    //   72	80	164	finally
    //   88	97	164	finally
    //   106	116	164	finally
    //   132	136	164	finally
    //   7	35	170	java/io/IOException
    //   35	46	170	java/io/IOException
    //   46	60	178	java/io/IOException
    //   60	70	178	java/io/IOException
  }
  
  /* Error */
  public static String a(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload 5
    //   5: astore 4
    //   7: aload_1
    //   8: invokevirtual 360	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   11: ifnull +40 -> 51
    //   14: aload_0
    //   15: invokevirtual 299	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: aload_1
    //   19: invokevirtual 366	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   22: astore_1
    //   23: aload_1
    //   24: astore 4
    //   26: aload_0
    //   27: aload_1
    //   28: aload_2
    //   29: aload_3
    //   30: invokestatic 368	aqfl:a	(Landroid/content/Context;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   33: invokevirtual 371	java/io/File:getPath	()Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: astore 4
    //   40: aload_1
    //   41: ifnull +10 -> 51
    //   44: aload_1
    //   45: invokevirtual 372	java/io/InputStream:close	()V
    //   48: aload_0
    //   49: astore 4
    //   51: aload 4
    //   53: areturn
    //   54: astore_1
    //   55: ldc 128
    //   57: iconst_1
    //   58: ldc_w 374
    //   61: aload_1
    //   62: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: astore 4
    //   73: aload_0
    //   74: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   77: aload 5
    //   79: astore 4
    //   81: aload_1
    //   82: ifnull -31 -> 51
    //   85: aload_1
    //   86: invokevirtual 372	java/io/InputStream:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: ldc 128
    //   94: iconst_1
    //   95: ldc_w 374
    //   98: aload_0
    //   99: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: aconst_null
    //   106: astore 4
    //   108: aload 4
    //   110: ifnull +8 -> 118
    //   113: aload 4
    //   115: invokevirtual 372	java/io/InputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_1
    //   121: ldc 128
    //   123: iconst_1
    //   124: ldc_w 374
    //   127: aload_1
    //   128: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   131: goto -13 -> 118
    //   134: astore_0
    //   135: goto -27 -> 108
    //   138: astore_0
    //   139: goto -69 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramContext	Context
    //   0	142	1	paramUri	Uri
    //   0	142	2	paramString1	String
    //   0	142	3	paramString2	String
    //   5	109	4	localObject1	Object
    //   1	77	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	48	54	java/lang/Exception
    //   14	23	67	java/lang/Exception
    //   85	89	91	java/lang/Exception
    //   14	23	104	finally
    //   113	118	120	java/lang/Exception
    //   26	37	134	finally
    //   73	77	134	finally
    //   26	37	138	java/lang/Exception
  }
  
  public static String a(Uri paramUri, ContentResolver paramContentResolver)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "_data";
    try
    {
      paramUri = alld.query(paramContentResolver, paramUri, arrayOfString, null, null, null);
      if (paramUri != null)
      {
        paramUri.moveToFirst();
        paramContentResolver = paramUri.getString(paramUri.getColumnIndex(arrayOfString[0]));
        paramUri.close();
        return paramContentResolver;
      }
      return null;
    }
    catch (Exception paramUri)
    {
      QLog.e("SystemDragUtils", 1, "getFilePathFromContentUri exception", paramUri);
    }
    return null;
  }
  
  private static String a(Uri paramUri, Context paramContext)
  {
    if (paramUri == null) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = new String[1];
      arrayOfString[0] = "_display_name";
      paramUri = alld.query(paramContext.getContentResolver(), paramUri, arrayOfString, null, null, null);
    } while (paramUri == null);
    paramUri.moveToFirst();
    paramContext = paramUri.getString(paramUri.getColumnIndex(arrayOfString[0]));
    paramUri.close();
    return paramContext;
  }
  
  public static void a(Context paramContext, aqfl.a parama, wlz paramwlz)
  {
    a.iq = new WeakReference(paramContext);
    a.h = paramwlz;
    parama.a(paramwlz);
    parama.a(new aqfn());
  }
  
  @RequiresApi(api=16)
  public static void a(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Context paramContext, SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo.cZ != 1) && (paramSessionInfo.cZ != 3000) && (paramSessionInfo.cZ != 0) && (!top.fw(paramSessionInfo.cZ)))
    {
      QLog.d("SystemDragUtils", 1, "unsupported UinType:" + paramSessionInfo.cZ);
      return;
    }
    ImageView localImageView = new ImageView(paramContext);
    ColorDrawable localColorDrawable1 = new ColorDrawable(Color.parseColor("#33000000"));
    ColorDrawable localColorDrawable2 = new ColorDrawable(Color.parseColor("#7F000000"));
    localImageView.setImageDrawable(localColorDrawable1);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramViewGroup.setOnDragListener(new aqfm(localImageView, localColorDrawable1, paramViewGroup, localColorDrawable2, paramContext, paramQQAppInterface, paramSessionInfo));
  }
  
  private static void a(ArrayList<String> paramArrayList, HashMap<Integer, SendVideoActivity.SendVideoInfo> paramHashMap, Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (!paramHashMap.isEmpty()) {
      localIntent.putExtra("PhotoConst.VIDEO_INFOS", paramHashMap);
    }
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", paramArrayList.size());
    localIntent.putExtra("uin", paramSessionInfo.aTl);
    localIntent.putExtra("uintype", paramSessionInfo.cZ);
    localIntent.putExtra("troop_uin", paramSessionInfo.troopUin);
    localIntent.putExtra("key_confess_topicid", paramSessionInfo.topicId);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", paramSessionInfo.entrance);
    if (paramArrayList.size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList);
    }
    paramContext.startActivity(localIntent);
  }
  
  private static boolean a(DragEvent paramDragEvent, ImageView paramImageView, ColorDrawable paramColorDrawable1, ViewGroup paramViewGroup, ColorDrawable paramColorDrawable2, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramDragEvent.getLocalState() != null) && ("QQ_AIO_DRAG".equals(paramDragEvent.getLocalState().toString())))
    {
      QLog.d("SystemDragUtils", 1, "local state is available");
      return false;
    }
    switch (paramDragEvent.getAction())
    {
    default: 
      return false;
    case 1: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_STARTED");
      paramImageView.setImageDrawable(paramColorDrawable1);
      if (paramViewGroup.indexOfChild(paramImageView) == -1) {
        paramViewGroup.addView(paramImageView, paramImageView.getLayoutParams());
      }
      return true;
    case 4: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_ENDED");
      if (paramViewGroup.indexOfChild(paramImageView) != -1) {
        paramViewGroup.removeView(paramImageView);
      }
      return true;
    case 2: 
      return true;
    case 5: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_ENTERED");
      paramImageView.setImageDrawable(paramColorDrawable2);
      return true;
    case 6: 
      QLog.d("SystemDragUtils", 1, "drag ACTION_DRAG_EXITED");
      paramImageView.setImageDrawable(paramColorDrawable1);
      return true;
    }
    QLog.d("SystemDragUtils", 1, "drag ACTION_DROP");
    if (paramViewGroup.indexOfChild(paramImageView) != -1) {
      paramViewGroup.removeView(paramImageView);
    }
    paramDragEvent = paramDragEvent.getClipData();
    if (paramDragEvent == null)
    {
      QLog.d("SystemDragUtils", 1, "drag clipData is null");
      return true;
    }
    paramImageView = paramDragEvent.getDescription();
    if (QLog.isColorLevel()) {
      QLog.d("SystemDragUtils", 2, "drag description.description=" + paramImageView.toString());
    }
    int j = paramImageView.getMimeTypeCount();
    if (j == 0)
    {
      QLog.d("SystemDragUtils", 1, "drag description.mimetype is null");
      return true;
    }
    int i = 0;
    if (i < j)
    {
      paramColorDrawable1 = paramImageView.getMimeType(i).split("/");
      if ((paramColorDrawable1 == null) || (paramColorDrawable1.length == 0)) {
        QLog.d("SystemDragUtils", 1, "drag description.mimetype is null");
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.d("SystemDragUtils", 2, "drag description.mimetype=" + Arrays.toString(paramColorDrawable1));
      }
    }
    paramImageView = new ReportProgressDialog(paramContext, 2131756467);
    paramImageView.setCancelable(true);
    paramImageView.setContentView(2131559761);
    ((TextView)paramImageView.findViewById(2131373180)).setText(acfp.m(2131715100));
    ThreadManager.executeOnFileThread(new SystemDragUtils.2(paramDragEvent, paramContext, paramQQAppInterface, paramSessionInfo, paramImageView));
    return true;
  }
  
  private static boolean aCa()
  {
    boolean bool2;
    if (aK.booleanValue()) {
      bool2 = true;
    }
    do
    {
      return bool2;
      if ((Build.VERSION.SDK_INT <= 28) || (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {
        break label122;
      }
      try
      {
        Method localMethod = Class.forName("com.huawei.android.pc.HwPCManagerEx").getDeclaredMethod("isInWindowsCastMode", new Class[0]);
        if (localMethod == null) {
          break;
        }
        bool1 = ((Boolean)localMethod.invoke(null, new Object[0])).booleanValue();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("SystemDragUtils", 1, "isInWindowsCastMode", localException);
          boolean bool1 = false;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.e("SystemDragUtils", 2, "isInWindowsCastMode = " + bool1);
    return bool1;
    label122:
    return false;
  }
  
  public static boolean bx(boolean paramBoolean)
  {
    if ((dYV == -1) || (paramBoolean)) {
      if (!aCa()) {
        break label32;
      }
    }
    label32:
    for (int i = 1;; i = 0)
    {
      dYV = i;
      if (dYV != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static class a
    implements wlz
  {
    List<View.OnTouchListener> IG = new ArrayList();
    List<View.OnLongClickListener> IH = new ArrayList();
    List<wlz> II = new ArrayList();
    
    void a(View.OnTouchListener paramOnTouchListener)
    {
      this.IG.add(paramOnTouchListener);
    }
    
    void a(wlz paramwlz)
    {
      this.II.add(paramwlz);
    }
    
    public boolean onLongClick(View paramView)
    {
      for (int i = 0;; i = 0) {
        try
        {
          while (i < this.IH.size())
          {
            ((View.OnLongClickListener)this.IH.get(i)).onLongClick(paramView);
            i += 1;
            continue;
            while (i < this.II.size())
            {
              ((View.OnLongClickListener)this.II.get(i)).onLongClick(paramView);
              i += 1;
            }
            return false;
          }
        }
        finally {}
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      for (int i = 0;; i = 0) {
        try
        {
          while (i < this.IG.size())
          {
            ((View.OnTouchListener)this.IG.get(i)).onTouch(paramView, paramMotionEvent);
            i += 1;
            continue;
            while (i < this.II.size())
            {
              ((wlz)this.II.get(i)).onTouch(paramView, paramMotionEvent);
              i += 1;
            }
            return false;
          }
        }
        finally {}
      }
    }
  }
  
  public static class b
  {
    public View IY;
    File ba;
    public ClipData d;
    
    b(File paramFile, View paramView, ClipData paramClipData)
    {
      this.ba = paramFile;
      this.IY = paramView;
      this.d = paramClipData;
    }
    
    public boolean isValid()
    {
      return (this.ba.exists()) && (this.IY != null) && (this.d != null);
    }
  }
  
  public static class c
    extends Handler
  {
    static int dYW = -1;
    public wlz h;
    public WeakReference<Context> iq;
    
    private void b(wlz paramwlz)
    {
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu Called");
      if ((paramwlz instanceof wki.a))
      {
        QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is BubbleOnlongClickListener");
        paramwlz = ((wki.a)paramwlz).a;
        if ((paramwlz != null) && (paramwlz.isShow()))
        {
          QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper dismiss");
          paramwlz.dismiss();
          return;
        }
        QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper notshow");
        return;
      }
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is: " + paramwlz.getClass());
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if ((paramMessage.what == dYW) && ((paramMessage.obj instanceof View)) && (this.iq.get() != null))
      {
        paramMessage = (BaseBubbleBuilder.e)wja.a((View)paramMessage.obj);
        QLog.d("SystemDragUtils", 1, "DRAG TRIGGER: holder is: " + paramMessage.getClass());
        if (paramMessage.mMessage != null) {
          ThreadManager.executeOnFileThread(new SystemDragUtils.TouchHandler.1(this, paramMessage));
        }
      }
      else
      {
        return;
      }
      QLog.e("SystemDragUtils", 1, "DRAG TRIGGER: holder message is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfl
 * JD-Core Version:    0.7.0.1
 */