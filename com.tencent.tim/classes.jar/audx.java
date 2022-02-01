import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.filemanager.util.FileManagerUtil.1;
import com.tencent.tim.filemanager.util.FileManagerUtil.10;
import com.tencent.tim.filemanager.util.FileManagerUtil.15;
import com.tencent.tim.filemanager.util.FileManagerUtil.2;
import com.tencent.tim.filemanager.util.FileManagerUtil.3;
import com.tencent.tim.filemanager.util.FileManagerUtil.8;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;
import tencent.cloud.history_file_extension.history_file_extension.FileExtension;

public class audx
{
  private static final String UU = new String(i);
  private static Drawable eR;
  private static final char[] i = { '…' };
  private static HashMap<String, String> kP;
  private static HashMap<String, Integer> kQ;
  private static ArrayList<Long> wM;
  private static ArrayList<Long> wN = new ArrayList();
  
  public static boolean B(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 8: 
    case 14: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "unknow errCode:" + String.valueOf(paramInt));
      }
      bool = false;
    case 0: 
      return bool;
    case 1: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694128));
      return true;
    case 2: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 3: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694128));
      return true;
    case 4: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694128));
      return true;
    case 5: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 6: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 7: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 9: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 10: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 11: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 17: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 12: 
      if (QLog.isDevelopLevel()) {
        ti();
      }
      auds.OS(2131694154);
      return true;
    case 16: 
      auds.OS(2131694119);
      return true;
    case 13: 
      auds.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    }
    auds.OS(2131696564);
    return true;
  }
  
  /* Error */
  public static byte[] B(String paramString)
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 132	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore 5
    //   7: aload 5
    //   9: ifnonnull +32 -> 41
    //   12: aconst_null
    //   13: astore_0
    //   14: iconst_0
    //   15: ifeq +11 -> 26
    //   18: new 134	java/lang/NullPointerException
    //   21: dup
    //   22: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   25: athrow
    //   26: aload_0
    //   27: areturn
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 138	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   35: aconst_null
    //   36: astore 5
    //   38: goto -31 -> 7
    //   41: new 140	java/io/BufferedInputStream
    //   44: dup
    //   45: new 142	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   53: invokespecial 147	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore 4
    //   58: sipush 10240
    //   61: newarray byte
    //   63: astore 6
    //   65: iconst_0
    //   66: istore_1
    //   67: aload_0
    //   68: invokestatic 153	ahav:getFileSizes	(Ljava/lang/String;)J
    //   71: lstore_2
    //   72: iload_1
    //   73: sipush 1024
    //   76: if_icmpge +25 -> 101
    //   79: aload 5
    //   81: aload 6
    //   83: iconst_0
    //   84: aload 4
    //   86: aload 6
    //   88: invokevirtual 159	java/io/InputStream:read	([B)I
    //   91: invokevirtual 163	java/security/MessageDigest:update	([BII)V
    //   94: iload_1
    //   95: iconst_1
    //   96: iadd
    //   97: istore_1
    //   98: goto -26 -> 72
    //   101: aload 4
    //   103: lload_2
    //   104: ldc2_w 164
    //   107: ldiv
    //   108: ldc2_w 166
    //   111: lsub
    //   112: ldc2_w 168
    //   115: lsub
    //   116: invokevirtual 173	java/io/InputStream:skip	(J)J
    //   119: pop2
    //   120: iconst_0
    //   121: istore_1
    //   122: iload_1
    //   123: sipush 1024
    //   126: if_icmpge +25 -> 151
    //   129: aload 5
    //   131: aload 6
    //   133: iconst_0
    //   134: aload 4
    //   136: aload 6
    //   138: invokevirtual 159	java/io/InputStream:read	([B)I
    //   141: invokevirtual 163	java/security/MessageDigest:update	([BII)V
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -26 -> 122
    //   151: aload 4
    //   153: lload_2
    //   154: ldc2_w 164
    //   157: ldiv
    //   158: ldc2_w 174
    //   161: lsub
    //   162: lconst_1
    //   163: ladd
    //   164: invokevirtual 173	java/io/InputStream:skip	(J)J
    //   167: pop2
    //   168: iconst_0
    //   169: istore_1
    //   170: iload_1
    //   171: sipush 1024
    //   174: if_icmpge +25 -> 199
    //   177: aload 5
    //   179: aload 6
    //   181: iconst_0
    //   182: aload 4
    //   184: aload 6
    //   186: invokevirtual 159	java/io/InputStream:read	([B)I
    //   189: invokevirtual 163	java/security/MessageDigest:update	([BII)V
    //   192: iload_1
    //   193: iconst_1
    //   194: iadd
    //   195: istore_1
    //   196: goto -26 -> 170
    //   199: bipush 8
    //   201: newarray byte
    //   203: astore_0
    //   204: iconst_0
    //   205: istore_1
    //   206: goto +152 -> 358
    //   209: aload 5
    //   211: aload_0
    //   212: iconst_0
    //   213: bipush 8
    //   215: invokevirtual 163	java/security/MessageDigest:update	([BII)V
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 178	java/io/InputStream:close	()V
    //   228: aload 5
    //   230: ifnull +30 -> 260
    //   233: aload 5
    //   235: invokevirtual 182	java/security/MessageDigest:digest	()[B
    //   238: astore 5
    //   240: aload 5
    //   242: astore_0
    //   243: aload 4
    //   245: ifnull -219 -> 26
    //   248: aload 4
    //   250: invokevirtual 178	java/io/InputStream:close	()V
    //   253: aload 5
    //   255: areturn
    //   256: astore_0
    //   257: aload 5
    //   259: areturn
    //   260: aconst_null
    //   261: astore_0
    //   262: aload 4
    //   264: ifnull -238 -> 26
    //   267: aload 4
    //   269: invokevirtual 178	java/io/InputStream:close	()V
    //   272: aconst_null
    //   273: areturn
    //   274: astore_0
    //   275: aconst_null
    //   276: areturn
    //   277: astore_0
    //   278: aconst_null
    //   279: astore_0
    //   280: aload_0
    //   281: ifnull +7 -> 288
    //   284: aload_0
    //   285: invokevirtual 178	java/io/InputStream:close	()V
    //   288: aconst_null
    //   289: areturn
    //   290: astore_0
    //   291: aconst_null
    //   292: astore 4
    //   294: aload 4
    //   296: ifnull -8 -> 288
    //   299: aload 4
    //   301: invokevirtual 178	java/io/InputStream:close	()V
    //   304: goto -16 -> 288
    //   307: astore_0
    //   308: goto -20 -> 288
    //   311: astore_0
    //   312: aconst_null
    //   313: astore 4
    //   315: aload 4
    //   317: ifnull +8 -> 325
    //   320: aload 4
    //   322: invokevirtual 178	java/io/InputStream:close	()V
    //   325: aload_0
    //   326: athrow
    //   327: astore_0
    //   328: aconst_null
    //   329: areturn
    //   330: astore_0
    //   331: goto -103 -> 228
    //   334: astore_0
    //   335: goto -47 -> 288
    //   338: astore 4
    //   340: goto -15 -> 325
    //   343: astore_0
    //   344: goto -29 -> 315
    //   347: astore_0
    //   348: goto -54 -> 294
    //   351: astore_0
    //   352: aload 4
    //   354: astore_0
    //   355: goto -75 -> 280
    //   358: iload_1
    //   359: bipush 8
    //   361: if_icmpge -152 -> 209
    //   364: aload_0
    //   365: bipush 8
    //   367: iload_1
    //   368: isub
    //   369: iconst_1
    //   370: isub
    //   371: lload_2
    //   372: bipush 64
    //   374: iload_1
    //   375: iconst_1
    //   376: iadd
    //   377: bipush 8
    //   379: imul
    //   380: isub
    //   381: lshr
    //   382: ldc2_w 183
    //   385: land
    //   386: l2i
    //   387: i2b
    //   388: bastore
    //   389: iload_1
    //   390: iconst_1
    //   391: iadd
    //   392: istore_1
    //   393: goto -35 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramString	String
    //   66	327	1	j	int
    //   71	301	2	l	long
    //   28	3	4	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   56	265	4	localBufferedInputStream	java.io.BufferedInputStream
    //   338	15	4	localIOException	IOException
    //   5	253	5	localObject	Object
    //   63	122	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	7	28	java/security/NoSuchAlgorithmException
    //   248	253	256	java/io/IOException
    //   267	272	274	java/io/IOException
    //   0	7	277	java/io/FileNotFoundException
    //   30	35	277	java/io/FileNotFoundException
    //   41	58	277	java/io/FileNotFoundException
    //   0	7	290	java/io/IOException
    //   30	35	290	java/io/IOException
    //   41	58	290	java/io/IOException
    //   299	304	307	java/io/IOException
    //   0	7	311	finally
    //   30	35	311	finally
    //   41	58	311	finally
    //   18	26	327	java/io/IOException
    //   223	228	330	java/io/IOException
    //   284	288	334	java/io/IOException
    //   320	325	338	java/io/IOException
    //   58	65	343	finally
    //   67	72	343	finally
    //   79	94	343	finally
    //   101	120	343	finally
    //   129	144	343	finally
    //   151	168	343	finally
    //   177	192	343	finally
    //   199	204	343	finally
    //   209	218	343	finally
    //   223	228	343	finally
    //   233	240	343	finally
    //   58	65	347	java/io/IOException
    //   67	72	347	java/io/IOException
    //   79	94	347	java/io/IOException
    //   101	120	347	java/io/IOException
    //   129	144	347	java/io/IOException
    //   151	168	347	java/io/IOException
    //   177	192	347	java/io/IOException
    //   199	204	347	java/io/IOException
    //   209	218	347	java/io/IOException
    //   233	240	347	java/io/IOException
    //   58	65	351	java/io/FileNotFoundException
    //   67	72	351	java/io/FileNotFoundException
    //   79	94	351	java/io/FileNotFoundException
    //   101	120	351	java/io/FileNotFoundException
    //   129	144	351	java/io/FileNotFoundException
    //   151	168	351	java/io/FileNotFoundException
    //   177	192	351	java/io/FileNotFoundException
    //   199	204	351	java/io/FileNotFoundException
    //   209	218	351	java/io/FileNotFoundException
    //   223	228	351	java/io/FileNotFoundException
    //   233	240	351	java/io/FileNotFoundException
  }
  
  public static long H(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 1004: 
      return 105L;
    case 1000: 
      return 104L;
    case 1001: 
      return 100L;
    case 1006: 
      return 102L;
    case 1010: 
      return 109L;
    }
    return 124L;
  }
  
  public static String H(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return String.valueOf(0);
    case 3: 
      return String.valueOf(1);
    case 1: 
      if (paramInt2 == 0) {
        return String.valueOf(2);
      }
      return String.valueOf(4);
    case 0: 
      return String.valueOf(7);
    }
    return String.valueOf(3);
  }
  
  public static void H(TextView paramTextView)
  {
    if ((paramTextView != null) && (eR != null))
    {
      ((Animatable)eR).stop();
      eR = null;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void H(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.nFileType == -1) || (paramFileManagerEntity.nFileType == 5))
    {
      if (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) {
        paramFileManagerEntity.nFileType = ahav.getFileType(paramFileManagerEntity.getFilePath());
      }
    }
    else {
      return;
    }
    if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5))
    {
      paramFileManagerEntity.nFileType = ahav.getFileType(paramFileManagerEntity.fileName);
      return;
    }
    if ((paramFileManagerEntity.strSrcName != null) && (paramFileManagerEntity.strSrcName.length() > 0))
    {
      paramFileManagerEntity.nFileType = ahav.getFileType(paramFileManagerEntity.strSrcName);
      return;
    }
    paramFileManagerEntity.nFileType = ahav.getFileType(paramFileManagerEntity.fileName);
  }
  
  public static void I(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    boolean bool;
    do
    {
      return;
      bool = aueh.isFileExists(paramFileManagerEntity.getFilePath());
      if ((bool) && ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 16) || (paramFileManagerEntity.nOpType == 14) || (paramFileManagerEntity.nOpType == 15) || (paramFileManagerEntity.nOpType == 17) || (paramFileManagerEntity.nOpType == 18) || (paramFileManagerEntity.nOpType == 19) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 5) || (paramFileManagerEntity.nOpType == -1) || (paramFileManagerEntity.nOpType == 33)))
      {
        paramFileManagerEntity.cloudType = 3;
        paramFileManagerEntity.status = 1;
        return;
      }
    } while ((paramFileManagerEntity.getCloudType() != 3) || ((bool) && ((paramFileManagerEntity.nOpType == 0) || (paramFileManagerEntity.nOpType == 6))));
    if (paramFileManagerEntity.nFileType == 5) {
      audt.G(paramFileManagerEntity);
    }
    if (paramFileManagerEntity.status == 1)
    {
      if (paramFileManagerEntity.peerType == 6000)
      {
        paramFileManagerEntity.setCloudType(6);
        paramFileManagerEntity.status = 16;
        return;
      }
      if ((paramFileManagerEntity.Uuid != null) && (paramFileManagerEntity.Uuid.length() > 0))
      {
        paramFileManagerEntity.setCloudType(1);
        paramFileManagerEntity.status = -1;
        return;
      }
      if ((paramFileManagerEntity.WeiYunFileId != null) && (paramFileManagerEntity.WeiYunFileId.length() > 0))
      {
        paramFileManagerEntity.setCloudType(2);
        paramFileManagerEntity.status = -1;
        return;
      }
      paramFileManagerEntity.status = 16;
      return;
    }
    paramFileManagerEntity.status = 16;
  }
  
  public static void J(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity.nFileType == 0) {
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        auef.d(paramFileManagerEntity.getFilePath(), (BitmapFactory.Options)localObject);
        if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
          break label184;
        }
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject).outHeight;
        int j = aoop.eI(paramFileManagerEntity.getFilePath());
        if ((j == 90) || (j == 270))
        {
          paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject).outHeight;
          paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject).outWidth;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "localPic[" + paramFileManagerEntity.nSessionId + "] get thumbsize success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    label184:
    do
    {
      do
      {
        for (;;)
        {
          paramFileManagerEntity = auef.a(paramFileManagerEntity);
          if (paramFileManagerEntity != null) {
            aoop.getDrawable(paramFileManagerEntity).downloadImediatly();
          }
          return;
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
          }
        }
      } while (paramFileManagerEntity.nFileType != 2);
      localObject = ahav.a(paramFileManagerEntity.getFilePath());
    } while (((ahav.e)localObject).retCode == -1);
    paramFileManagerEntity.strLargeThumPath = ((ahav.e)localObject).bN;
    if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    for (;;)
    {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "localvideo[" + paramFileManagerEntity.nSessionId + "] create thumb success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      return;
      paramFileManagerEntity.imgWidth = ((ahav.e)localObject).mThumbWidth;
      paramFileManagerEntity.imgHeight = ((ahav.e)localObject).gP;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "]get local video,(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
  }
  
  public static void JI(String paramString)
  {
    auds.JD(paramString);
  }
  
  public static void K(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    int j;
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        if (paramFileManagerEntity == null)
        {
          localStringBuilder.append("entity is nll,stack:" + ti());
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        j = paramFileManagerEntity.nFileType;
        if ((j != 2) && (j != 0))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is not pic or video, return");
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          continue;
        }
        if (paramFileManagerEntity.imgHeight <= 0) {
          break;
        }
      }
      finally {}
      if (paramFileManagerEntity.imgWidth <= 0) {
        break;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("] OK, return!");
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    Object localObject1 = paramFileManagerEntity.getFilePath();
    if (aueh.fileExistsAndNotEmpty((String)localObject1))
    {
      if (j == 2) {
        bool1 = false;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is local, use local calc size!");
    }
    Object localObject2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label422;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is No LoaclFile,No LargeThumb,No middleThumb,so return");
      QLog.e("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      localObject1 = paramFileManagerEntity.strLargeThumPath;
      if (aueh.fileExistsAndNotEmpty((String)localObject1))
      {
        localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloude , use largThumb calc size!");
        bool1 = bool2;
      }
      else
      {
        localObject1 = paramFileManagerEntity.strMiddleThumPath;
        if (aueh.fileExistsAndNotEmpty((String)localObject1))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloud , use middleThumb calc size!,becarefull middle must createByLarge!!!");
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if (j == 2)
          {
            localObject2 = paramFileManagerEntity.strThumbPath;
            bool1 = bool2;
            localObject1 = localObject2;
            if (aueh.fileExistsAndNotEmpty((String)localObject2))
            {
              localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] video is cloud , use thumb calc size!");
              bool1 = bool2;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label422:
    if (bool1)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      auef.d((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
      j = aoop.eI((String)localObject1);
      if ((j == 90) || (j == 270))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outHeight;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outWidth;
      }
    }
    for (;;)
    {
      localStringBuilder.append(" calc size over size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("]");
      localStringBuilder.append("useImageCreateThumb:").append(bool1);
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      if (j == 2) {
        ahav.J(paramFileManagerEntity);
      } else {
        localStringBuilder.append("!!!!!!!!FILETYPE ERROR!!!!!!!");
      }
    }
  }
  
  public static void L(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString1 = "qlink_new_flag_" + paramString1 + "_" + paramString2;
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  public static long N(long paramLong)
  {
    return 2863315899L << 31 | paramLong;
  }
  
  public static void T(Activity paramActivity, String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      auds.OS(2131694147);
      return;
    }
    ThreadManager.post(new FileManagerUtil.2(paramString, paramActivity, localFile), 8, null, true);
  }
  
  public static ahbm a(QQAppInterface paramQQAppInterface)
  {
    return new audz(paramQQAppInterface);
  }
  
  public static ahbm a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new audy(paramQQAppInterface, paramInt);
  }
  
  private static Bitmap a(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int k = paramBitmap.getWidth() - paramInt1;
    int j = paramBitmap.getHeight() - paramInt2;
    Object localObject1;
    Object localObject2;
    if ((k < 0) || (j < 0)) {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        k = Math.max(0, k / 2);
        j = Math.max(0, j / 2);
        localObject2 = new Rect(k, j, Math.min(paramInt1, paramBitmap.getWidth()) + k, Math.min(paramInt2, paramBitmap.getHeight()) + j);
        j = (paramInt1 - ((Rect)localObject2).width()) / 2;
        k = (paramInt2 - ((Rect)localObject2).height()) / 2;
        paramMatrix.drawBitmap(paramBitmap, (Rect)localObject2, new Rect(j, k, paramInt1 - j, paramInt2 - k), null);
        return localObject1;
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        return null;
      }
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        label224:
        if (paramMatrix == null) {
          break label376;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
          if (paramMatrix != paramBitmap) {
            paramBitmap.recycle();
          }
          j = Math.max(0, paramMatrix.getWidth() - paramInt1);
          k = Math.max(0, paramMatrix.getHeight() - paramInt2);
        }
        catch (OutOfMemoryError paramMatrix)
        {
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
          return null;
        }
        try
        {
          localObject2 = Bitmap.createBitmap(paramMatrix, j / 2, k / 2, paramInt1, paramInt2);
          localObject1 = localObject2;
          if (localObject2 == paramMatrix) {
            break;
          }
          localObject1 = localObject2;
          if (paramMatrix == paramBitmap) {
            break;
          }
          paramMatrix.recycle();
          return localObject2;
        }
        catch (OutOfMemoryError paramMatrix)
        {
          label376:
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        }
      }
      paramMatrix = null;
      break label224;
      f1 = paramInt1 / f1;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        break label224;
      }
      paramMatrix = null;
      break label224;
      paramMatrix = paramBitmap;
    }
    return null;
  }
  
  public static StateListDrawable a(Context paramContext, int paramInt)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    try
    {
      Object localObject = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      Bitmap localBitmap = Bitmap.createBitmap(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), Bitmap.Config.ARGB_8888);
      ColorMatrix localColorMatrix = new ColorMatrix();
      localColorMatrix.set(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -67, 0.0F, 1.0F, 0.0F, 0.0F, -67, 0.0F, 0.0F, 1.0F, 0.0F, -67, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
      Paint localPaint = new Paint();
      localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
      new Canvas(localBitmap).drawBitmap((Bitmap)localObject, 0.0F, 0.0F, localPaint);
      localObject = new BitmapDrawable(localBitmap);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
      localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      paramContext = paramContext.getResources().getDrawable(paramInt);
      localStateListDrawable.addState(new int[] { 16842910 }, paramContext);
      return localStateListDrawable;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 2, paramContext, new Object[] { "decodeResource caused this error, null will be returned" });
    }
    return null;
  }
  
  public static SpannableString a(String paramString1, String paramString2, audx.c paramc)
  {
    int j = paramString1.indexOf(paramString2);
    int k = paramString2.length() + j;
    paramString1 = new SpannableString(paramString1);
    paramString2 = new aued(paramc);
    try
    {
      paramString1.setSpan(new ForegroundColorSpan(Color.parseColor("#1E6FFF")), j, k, 33);
      paramString1.setSpan(paramString2, j, k, 33);
      return paramString1;
    }
    catch (Exception paramString2) {}
    return paramString1;
  }
  
  public static atkw a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    Object localObject3 = null;
    Object localObject1;
    switch (paramCloudHistoryInfo.sourceType)
    {
    case 7: 
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((atkw)localObject1).a(paramCloudHistoryInfo, paramObject))
        {
          ((atkw)localObject1).fileName = paramCloudHistoryInfo.fileName;
          ((atkw)localObject1).fileSize = paramCloudHistoryInfo.fileSize;
          ((atkw)localObject1).lastTime = paramCloudHistoryInfo.operateTime;
          ((atkw)localObject1).relatedType = paramCloudHistoryInfo.sourceType;
          ((atkw)localObject1).operateType = paramCloudHistoryInfo.operateType;
          ((atkw)localObject1).cGT = paramCloudHistoryInfo.localPath;
          ((atkw)localObject1).jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo = paramCloudHistoryInfo;
          if (paramCloudHistoryInfo.fileExtInfo == null) {}
        }
      }
      try
      {
        paramObject = new history_file_extension.FileExtension();
        paramObject.mergeFrom(paramCloudHistoryInfo.fileExtInfo);
        ((atkw)localObject1).jdField_a_of_type_TencentCloudHistory_file_extensionHistory_file_extension$FileExtension = paramObject;
        localObject2 = localObject1;
        return localObject2;
      }
      catch (InvalidProtocolBufferMicroException paramCloudHistoryInfo)
      {
        paramCloudHistoryInfo.printStackTrace();
      }
      localObject1 = new atkq();
      continue;
      localObject1 = new atks();
      continue;
      localObject1 = new atld();
      continue;
      localObject1 = new atkz();
      continue;
      localObject1 = new atla();
      continue;
      localObject1 = new atkx();
      continue;
      localObject1 = new atkv();
    }
    return null;
  }
  
  public static FileManagerEntity a(apcy paramapcy)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramapcy.FileName;
    if (aueh.isFileExists(paramapcy.LocalFile)) {
      localFileManagerEntity.setFilePath(paramapcy.LocalFile);
    }
    if (aueh.isFileExists(paramapcy.ThumbnailFile_Large)) {
      localFileManagerEntity.strLargeThumPath = paramapcy.ThumbnailFile_Large;
    }
    if (aueh.isFileExists(paramapcy.ThumbnailFile_Small))
    {
      localFileManagerEntity.strThumbPath = paramapcy.ThumbnailFile_Small;
      localFileManagerEntity.fileSize = paramapcy.ProgressTotal;
      localFileManagerEntity.nFileType = ahav.getFileType(paramapcy.FileName);
      if ((6 <= paramapcy.Status) && (13 != paramapcy.Status)) {
        break label232;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (paramapcy.Id != null) {
        localFileManagerEntity.strTroopFileID = paramapcy.Id.toString();
      }
      localFileManagerEntity.strTroopFilePath = paramapcy.FilePath;
      localFileManagerEntity.strTroopFileSha1 = paramapcy.sha1;
      localFileManagerEntity.busId = paramapcy.BusId;
      localFileManagerEntity.TroopUin = paramapcy.TroopUin;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(paramapcy.TroopUin);
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().v(localFileManagerEntity);
      return localFileManagerEntity;
      if (!aueh.isFileExists(paramapcy.coc)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = paramapcy.coc;
      break;
      label232:
      if (12 == paramapcy.Status) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    Object localObject = localFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      localFileManagerEntity = paramQQAppInterface.a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("FileManager", 2, "QueryFileEntityByuniseq return null, create new! sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], messageId[" + String.valueOf(localFileManagerEntity.uniseq) + "], peerUin[" + ahav.kZ(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      }
      localObject = paramQQAppInterface.a().createEntityManager();
      TransFileInfo localTransFileInfo = (TransFileInfo)((EntityManager)localObject).find(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessageForFile.frienduin });
      ((EntityManager)localObject).close();
      localFileManagerEntity.status = ahav.hM(paramMessageForFile.status);
      if (!paramMessageForFile.isSend()) {
        break label442;
      }
      localFileManagerEntity.setCloudType(3);
      if (!TextUtils.isEmpty(paramMessageForFile.url)) {
        break label430;
      }
      localFileManagerEntity.status = 16;
      if (localTransFileInfo != null)
      {
        if (localTransFileInfo.uuid == null) {
          break label492;
        }
        localObject = new String(localTransFileInfo.uuid);
        label277:
        localFileManagerEntity.Uuid = ((String)localObject);
      }
      localFileManagerEntity.fileName = paramMessageForFile.fileName;
      localFileManagerEntity.fileSize = paramMessageForFile.fileSize;
      if (!paramMessageForFile.isSend()) {
        break label499;
      }
    }
    label430:
    label442:
    label492:
    label499:
    for (int j = 0;; j = 1)
    {
      localFileManagerEntity.nOpType = j;
      localFileManagerEntity.peerUin = paramMessageForFile.frienduin;
      localFileManagerEntity.peerType = paramMessageForFile.istroop;
      localFileManagerEntity.peerNick = ahav.a(paramQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, paramMessageForFile.istroop);
      localFileManagerEntity.srvTime = (paramMessageForFile.time * 1000L);
      localFileManagerEntity.strServerPath = paramMessageForFile.urlAtServer;
      localFileManagerEntity.setfProgress((float)paramQQAppInterface.a().a(paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
      paramQQAppInterface.a().v(localFileManagerEntity);
      localFileManagerEntity.bDelInFM = true;
      localObject = localFileManagerEntity;
      return localObject;
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.lastTime = (paramMessageForFile.time * 1000L + 604800000L);
      if (localFileManagerEntity.status != 1) {
        break;
      }
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localObject = "";
      break label277;
    }
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileName = paramFileInfo.getName();
    localFileManagerEntity.setFilePath(paramFileInfo.getPath());
    localFileManagerEntity.fileSize = paramFileInfo.getSize();
    if (paramFileInfo.getType() == 5) {}
    for (localFileManagerEntity.nFileType = 5;; localFileManagerEntity.nFileType = ahav.getFileType(paramFileInfo.getName()))
    {
      localFileManagerEntity.status = -1;
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().v(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.Uuid = paramOfflineFileInfo.bHK;
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.strThumbPath = paramOfflineFileInfo.bIz;
    localFileManagerEntity.peerUin = String.valueOf(paramOfflineFileInfo.uFriendUin);
    localFileManagerEntity.peerNick = a(localQQAppInterface, localFileManagerEntity.peerUin, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.fileName = paramOfflineFileInfo.strFileName;
    localFileManagerEntity.fileSize = paramOfflineFileInfo.nFileSize;
    localFileManagerEntity.nFileType = ahav.getFileType(paramOfflineFileInfo.strFileName);
    localFileManagerEntity.lastTime = paramOfflineFileInfo.Zm;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = paramOfflineFileInfo.Zn;
    localFileManagerEntity.bSend = paramOfflineFileInfo.bSend;
    if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
      localFileManagerEntity.nWeiYunSrcType = -1;
    }
    localQQAppInterface.a().v(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static WeiYunFileInfo a(FileManagerEntity paramFileManagerEntity)
  {
    WeiYunFileInfo localWeiYunFileInfo = null;
    if (paramFileManagerEntity != null)
    {
      localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.bIk = paramFileManagerEntity.WeiYunFileId;
      localWeiYunFileInfo.strFileName = paramFileManagerEntity.fileName;
      localWeiYunFileInfo.nFileSize = paramFileManagerEntity.fileSize;
      localWeiYunFileInfo.bIz = paramFileManagerEntity.strThumbPath;
      localWeiYunFileInfo.cYi = paramFileManagerEntity.nWeiYunSrcType;
      localWeiYunFileInfo.mtime = paramFileManagerEntity.lastTime;
      localWeiYunFileInfo.md5 = paramFileManagerEntity.strFileMd5;
      localWeiYunFileInfo.dirKey = paramFileManagerEntity.WeiYunDirKey;
      localWeiYunFileInfo.sha = paramFileManagerEntity.strFileSHA;
    }
    return localWeiYunFileInfo;
  }
  
  public static CharSequence a(FileManagerEntity paramFileManagerEntity)
  {
    return auem.bu(paramFileManagerEntity.srvTime) + "  " + e(paramFileManagerEntity);
  }
  
  public static String a(Context paramContext, CloudHistoryInfo paramCloudHistoryInfo)
  {
    if (paramCloudHistoryInfo == null) {
      return "";
    }
    if (paramCloudHistoryInfo.sourceType == 6) {
      return paramContext.getString(2131691650);
    }
    if (paramCloudHistoryInfo.sourceType == 5) {
      return paramContext.getString(2131691649);
    }
    switch (paramCloudHistoryInfo.operateType)
    {
    case 3: 
    default: 
      return "";
    case 1: 
    case 2: 
      return paramContext.getString(2131691670);
    case 4: 
    case 5: 
      return paramContext.getString(2131691651);
    }
    return paramContext.getString(2131691652);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (acbn.bkw.equalsIgnoreCase(paramString1)) {
      return "我的电脑";
    }
    if (acbn.bkx.equalsIgnoreCase(paramString1)) {
      return "我的iPad";
    }
    if (acbn.bks.equalsIgnoreCase(paramString1)) {
      return "";
    }
    return aqgv.e(paramQQAppInterface, paramString1, paramInt);
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramTextPaint == null) || (paramInt1 <= 0))
    {
      localObject = "";
      return localObject;
    }
    int k;
    char[] arrayOfChar;
    int m;
    label54:
    int i1;
    int n;
    if (paramInt2 > 1)
    {
      k = paramInt2;
      arrayOfChar = paramString.toCharArray();
      localObject = new StringBuilder();
      j = 0;
      m = 0;
      if (j >= arrayOfChar.length) {
        break label399;
      }
      ((StringBuilder)localObject).append(arrayOfChar[j]);
      i1 = j;
      n = m;
      if (paramTextPaint.measureText(((StringBuilder)localObject).toString()) <= paramInt1) {
        break label273;
      }
      i1 = j - 1;
      j = m + 1;
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      n = j;
      if (j < k) {
        break label273;
      }
    }
    label393:
    label399:
    for (int j = 1;; j = 0)
    {
      localObject = paramString;
      if (j == 0) {
        break;
      }
      if (paramBoolean)
      {
        k = 6;
        label150:
        if (paramString.length() >= k) {
          break label293;
        }
        localObject = paramString;
        label162:
        StringBuilder localStringBuilder = new StringBuilder((String)localObject);
        n = 0;
        m = 0;
        j = 0;
        label182:
        if (n >= arrayOfChar.length - k) {
          break label393;
        }
        localStringBuilder.append(arrayOfChar[n]);
        if (paramTextPaint.measureText(localStringBuilder.toString()) <= paramInt1 * paramInt2) {
          break label313;
        }
      }
      for (paramInt1 = n - 2;; paramInt1 = j)
      {
        if (paramInt1 > 0) {}
        for (;;)
        {
          if (m != 0) {
            break label368;
          }
          return paramString.substring(0, paramInt1) + UU + (String)localObject;
          k = 1;
          break;
          label273:
          j = i1 + 1;
          m = n;
          break label54;
          k = 15;
          break label150;
          label293:
          localObject = paramString.substring(paramString.length() - k, paramString.length());
          break label162;
          label313:
          if (paramString.substring(n, n + 1).equals(UU)) {
            m = 1;
          }
          if (n == arrayOfChar.length - k - 1) {
            j = n - 2;
          }
          n += 1;
          break label182;
          paramInt1 = 0;
        }
        label368:
        return paramString.substring(0, paramInt1) + (String)localObject;
      }
    }
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile)
  {
    long l = paramFile.lastModified();
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l + "|1";
    try
    {
      paramString = new URL("fileassistantimage", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public static ArrayList<FileInfo> a(boolean paramBoolean, int paramInt)
  {
    int j = 0;
    Object localObject2 = new File(wc()).listFiles();
    if (localObject2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject1;
    if (j < localObject2.length)
    {
      FileInfo localFileInfo = localObject2[j];
      localObject3 = localFileInfo.getPath();
      if ((!paramBoolean) && (localFileInfo.getName().startsWith("."))) {}
      for (;;)
      {
        j += 1;
        break;
        try
        {
          localFileInfo = new FileInfo((String)localObject3);
          if (localFileInfo != null) {
            localArrayList.add(localFileInfo);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            localFileNotFoundException.printStackTrace();
            localObject1 = null;
          }
        }
      }
    }
    try
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
          if (aueh.isFileExists((String)localObject2))
          {
            localObject2 = new File((String)localObject2);
            localObject3 = new FileInfo();
            ((FileInfo)localObject3).setName(((File)localObject2).getName());
            ((FileInfo)localObject3).setDirectory(((File)localObject2).isDirectory());
            ((FileInfo)localObject3).setPath(((File)localObject2).getPath());
            ((FileInfo)localObject3).setSize(((File)localObject2).length());
            ((FileInfo)localObject3).setDate(((File)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      if (paramInt != 0) {
        break label291;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Collections.sort(localArrayList, new aueh.a());
    for (;;)
    {
      return localArrayList;
      label291:
      Collections.sort(localArrayList, new audv());
    }
  }
  
  public static LinkedHashMap a(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "jsonToMap but jsonString is null!");
      }
      return localLinkedHashMap;
    }
    Object localObject = paramString.replace("\"", "");
    paramString = (String)localObject;
    if (((String)localObject).startsWith("{")) {
      paramString = ((String)localObject).substring(1);
    }
    localObject = paramString;
    if (paramString.endsWith("}")) {
      localObject = paramString.substring(0, paramString.length() - 1);
    }
    paramString = ((String)localObject).split(",");
    int j = 0;
    if (j < paramString.length)
    {
      localObject = paramString[j].split(":");
      if (localObject.length == 1) {
        localLinkedHashMap.put(localObject[0].toLowerCase(), "");
      }
      for (;;)
      {
        j += 1;
        break;
        localLinkedHashMap.put(localObject[0].toLowerCase(), localObject[1]);
      }
    }
    return localLinkedHashMap;
  }
  
  public static void a(Activity paramActivity, String paramString, audx.d paramd)
  {
    if ((paramString == null) || (!aueh.isFileExists(paramString)))
    {
      auds.OS(2131694128);
      return;
    }
    String str = aopl.F(paramActivity, paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    FileProvider7Helper.setIntentDataAndType(paramActivity, localIntent, str, new File(paramString));
    paramString = paramActivity.getPackageManager().queryIntentActivities(localIntent, 65536);
    if ((paramString.size() == 1) && (((ResolveInfo)paramString.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {}
    for (int j = 1;; j = 0)
    {
      if ((paramString.size() > 0) && (j == 0)) {}
      for (;;)
      {
        try
        {
          paramActivity.startActivity(localIntent);
          if (paramd == null) {
            break;
          }
          paramd.euA();
          return;
        }
        catch (ActivityNotFoundException paramActivity)
        {
          auds.OS(2131695388);
          continue;
        }
        auds.OS(2131695388);
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    if ((paramTextView != null) && (eR == null))
    {
      eR = paramBaseActivity.getResources().getDrawable(2130839649);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(eR, null, null, null);
      ((Animatable)eR).start();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str1 = str2;
      if (paramString2 != null) {
        str1 = str2;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        paramString2 = str1;
      }
      catch (Exception localException)
      {
        label74:
        break label74;
      }
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("param_Server", String.valueOf(paramString2));
      localHashMap.put("param_ftnIP", String.valueOf(paramString2));
      localHashMap.put("param_PeerUin", paramString3);
      localHashMap.put("param_uuid", paramString4);
      localHashMap.put("param_MD5", paramString5);
      localHashMap.put("param_fsized", String.valueOf(paramLong4));
      localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
      localHashMap.put("param_retry", String.valueOf(paramInt));
      localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
      localHashMap.put("param_errMsg", String.valueOf(paramString6));
      anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString6);
      if (QLog.isColorLevel()) {
        QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(true) + "], nSessionId[" + String.valueOf(paramLong1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong3) + "], transfSize[" + String.valueOf(paramLong4) + "], fileSize[" + String.valueOf(paramLong5) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString6) + "]");
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    long l = paramLong2;
    if (paramLong2 == 0L) {
      l = System.currentTimeMillis();
    }
    if (l < 1L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str3 = "";
      String str1 = str3;
      if (paramString2 != null) {
        str1 = str3;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        if (paramLong2 < 0L)
        {
          paramLong2 = 0L;
          k = 0;
          j = k;
          if (paramString9 != null)
          {
            j = k;
            if (paramString9.length() > 0)
            {
              if (paramString9.indexOf("Network is unreachable") <= 0) {
                break label916;
              }
              j = 1;
            }
          }
          if (aqiw.isNetSupport(BaseApplication.getContext()))
          {
            paramString2 = paramString9;
            if (j == 0) {}
          }
          else
          {
            paramLong3 = 9004L;
            paramString2 = paramString9 + "_NotNetWork";
          }
          paramString9 = paramString2;
          if (!paramQQAppInterface.isLogin())
          {
            paramLong3 = 9004L;
            paramString9 = paramString2 + "_NotLogin";
          }
          paramString2 = new HashMap();
          paramString2.put("serverip", String.valueOf(str1));
          paramString2.put("param_Server", String.valueOf(str1));
          paramString2.put("param_ftnIP", String.valueOf(str1));
          paramString2.put("param_PeerUin", String.valueOf(paramString3));
          paramString2.put("param_uuid", String.valueOf(paramString4));
          paramString2.put("param_MD5", paramString5);
          paramString2.put("param_FailCode", Long.toString(paramLong3));
          paramString2.put("param_errorDesc", String.valueOf(paramString6));
          paramString2.put("param_fsized", String.valueOf(paramLong5));
          paramString2.put("param_fsizeo", String.valueOf(paramLong6));
          paramString2.put("param_url", String.valueOf(paramString7));
          paramString2.put("param_rspHeader", String.valueOf(paramString8));
          paramString2.put("param_retry", String.valueOf(paramInt));
          paramString2.put("param_errMsg", String.valueOf(paramString9 + "uin[" + paramQQAppInterface.getCurrentAccountUin() + "]"));
          paramString2.put("param_nSessionId", String.valueOf(paramLong1));
          anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), paramString1, false, paramLong2, paramLong4, paramString2, paramString10);
          if (QLog.isColorLevel()) {
            QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], startTime[" + String.valueOf(l) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong4) + "], transfSize[" + String.valueOf(paramLong5) + "], fileSize[" + String.valueOf(paramLong6) + "], param_errorDesc[" + String.valueOf(paramString6) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString10) + "]");
          }
          if (QLog.isColorLevel()) {
            QLog.e("@@@@@@@", 2, "ReportFilemanagerInfo Color Log actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], errMsg[" + String.valueOf(paramString9) + "]");
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            int k;
            int j;
            paramString2 = paramQQAppInterface.a().c(paramLong1);
            paramString3 = new audw.a();
            if (paramString1 == "actDiscussFileUp")
            {
              paramString3.biz = "讨论组文件上传";
              paramString3.LE = paramLong3;
              paramString3.filename = paramString2.fileName;
              paramString3.sessionId = paramLong1;
              paramString3.uin = paramQQAppInterface.getCurrentUin();
              paramString3.qi = new HashMap();
              paramString3.qi.put("errMsg", String.valueOf(paramString9));
              paramString3.qi.put("uuid", String.valueOf(paramString4));
              paramString3.qi.put("sIp", String.valueOf(str1));
              audw.a(paramString3);
              return;
              paramLong2 = System.currentTimeMillis() - l;
              break;
              label916:
              if (paramString9.indexOf("No route to host") > 0)
              {
                j = 1;
                continue;
              }
              j = k;
              if (paramString9.indexOf("MalformedURLException") <= 0) {
                continue;
              }
              j = 1;
              continue;
            }
            if (paramString1 == "actFileDiscDownLoad")
            {
              paramString3.biz = "讨论组文件下载";
            }
            else if (paramString1 == "actFileUp")
            {
              paramString3.biz = "好友文件上传";
            }
            else if (paramString1 == "actFileDown")
            {
              paramString3.biz = "好友文件下载";
            }
            else if (paramString1 == "actFileDisc2Wy")
            {
              paramString3.biz = "讨论组转微云";
            }
            else if (paramString1 == "actFileOf2Wy")
            {
              paramString3.biz = "离线转微云";
            }
            else if (paramString1 == "actFileOf2Of")
            {
              paramString3.biz = "离线转离线";
            }
            else if (paramString1 == "actFileOf2Disc")
            {
              paramString3.biz = "离线转讨论组";
            }
            else if (paramString1 == "actFileWy2Of")
            {
              paramString3.biz = "微云转离线";
            }
            else if (paramString1 == "actFileWy2Disc")
            {
              paramString3.biz = "微云转讨论组";
            }
            else if (paramString1 == "actFileWyUp")
            {
              paramString3.biz = "微云文件上传";
            }
            else if (paramString1 == "actFileWyDown")
            {
              paramString3.biz = "微云文件下载";
            }
            else
            {
              paramString3.biz = paramString1;
              continue;
              localException = localException;
              String str2 = paramString2;
            }
          }
          catch (Exception paramQQAppInterface) {}
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    label312:
    label314:
    label324:
    label466:
    do
    {
      do
      {
        int k;
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                acff localacff = (acff)paramQQAppInterface.getManager(51);
                Object localObject = paramFileManagerEntity.peerUin;
                if (paramFileManagerEntity.peerType == 3000) {
                  localObject = paramFileManagerEntity.selfUin;
                }
                localObject = localacff.e((String)localObject);
                int j = -1;
                if (localObject != null) {
                  j = ((Friends)localObject).iTermType;
                }
                k = fM(paramFileManagerEntity.fileName);
                if (k == 0) {
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] PicFile, from device[" + j + "] size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
                for (;;)
                {
                  if ((!atvz.alL()) && (amK())) {
                    break label312;
                  }
                  if (k != 0) {
                    break label466;
                  }
                  if (!auef.u(paramFileManagerEntity)) {
                    break label324;
                  }
                  paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 7);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is badPic Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
                  return;
                  if (k != 2) {
                    break label314;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] VideoFile, from device[" + j + "] Preload VideoThumb size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
              }
              QLog.i("FileManagerUtil<FileAssistant>", 1, "not pic or video!");
              return;
              paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 5);
              if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] Preload 384 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
              }
            } while (amK());
            paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 7);
          } while (!QLog.isColorLevel());
          QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is Wi-Fi Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
          return;
        } while (k != 2);
        if (paramFileManagerEntity.peerType != 3000) {
          break;
        }
        paramQQAppInterface = paramQQAppInterface.a().b(paramFileManagerEntity);
      } while (paramQQAppInterface == null);
      paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
      return;
      paramQQAppInterface = paramQQAppInterface.a().a(paramFileManagerEntity);
    } while (paramQQAppInterface == null);
    paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, ti());
      }
      return;
    }
    int j = (int)H(paramFileManagerEntity.peerType);
    paramFileManagerEntity.tmpSessionType = j;
    paramFileManagerEntity.tmpSessionSig = a(paramQQAppInterface, paramFileManagerEntity.peerUin, j);
    switch (j)
    {
    case 103: 
    default: 
      return;
    case 102: 
      paramFileManagerEntity.tmpSessionFromPhone = paramString1;
      paramFileManagerEntity.tmpSessionToPhone = paramString2;
      return;
    }
    paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
  }
  
  public static void a(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    H(paramFileManagerEntity);
    String str = paramFileManagerEntity.getFilePath();
    if (paramFileManagerEntity.nFileType == 0) {
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        str = paramFileManagerEntity.strMiddleThumPath;
      }
    }
    for (;;)
    {
      a(paramAsyncImageView, str, paramFileManagerEntity.nFileType);
      return;
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
      {
        str = paramFileManagerEntity.strLargeThumPath;
      }
      else if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        str = paramFileManagerEntity.getFilePath();
        ThreadManager.executeOnSubThread(new FileManagerUtil.1(paramFileManagerEntity));
        continue;
        if (paramFileManagerEntity.nFileType == 2) {
          if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
            str = paramFileManagerEntity.strLargeThumPath;
          } else {
            str = null;
          }
        }
      }
    }
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      paramAsyncImageView.setImageResource(hL(paramInt));
    }
    do
    {
      do
      {
        return;
        paramAsyncImageView.setDefaultImage(2130845173);
        paramAsyncImageView.setAsyncImage(paramString);
        return;
        paramAsyncImageView.setDefaultImage(2130845117);
      } while (!aueh.fileExistsAndNotEmpty(paramString));
      paramAsyncImageView.setApkIconAsyncImage(paramString);
      return;
      paramAsyncImageView.setDefaultImage(2130845245);
    } while (!aueh.fileExistsAndNotEmpty(paramString));
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = aueh.getExtension(paramString);
    if (str == null) {
      paramAsyncImageView.setImageResource(2130845244);
    }
    do
    {
      return;
      paramAsyncImageView.setImageResource(r(paramString));
    } while (!paramBoolean);
    switch (ahav.getFileType(str))
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramAsyncImageView.setDefaultImage(2130845173);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
    }
    paramAsyncImageView.setDefaultImage(2130845245);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    Object localObject = c();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "none select!why you can preview!");
      }
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.p(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.Oj(3);
    localForwardFileInfo.setType(10007);
    localObject = new Intent(paramBaseFileAssistantActivity, FileBrowserActivity.class);
    ((Intent)localObject).putExtra("FromEditBarPreview", true);
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    ((Intent)localObject).putExtra("from_qlink_enter_recent", paramBaseFileAssistantActivity.akM());
    paramBaseFileAssistantActivity.startActivityForResult((Intent)localObject, 102);
  }
  
  @TargetApi(10)
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, audx.b paramb)
  {
    ThreadManager.post(new FileManagerUtil.10(paramString, paramInt3, paramBoolean, paramb, paramInt1, paramInt2), 8, null, true);
  }
  
  public static boolean a(agsd paramagsd)
  {
    int j = paramagsd.getCloudType();
    int k = paramagsd.bF();
    String str = paramagsd.getUuid();
    paramagsd = paramagsd.getFileId();
    return (j == 3) && (k == 1) && ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramagsd)));
  }
  
  public static boolean a(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    return (ahav.bm(paramContext)) && ((paramFileManagerEntity.fileSize > ahav.d(((BaseFileAssistantActivity)paramContext).app, paramFileManagerEntity.fileName)) || (!ahav.aZ(paramFileManagerEntity.fileName, ((BaseFileAssistantActivity)paramContext).bGo)) || ((!atwb.b(paramFileManagerEntity)) && (atwb.db().size() != 0)));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, agsd paramagsd)
  {
    paramQQAppInterface = atvz.j(paramQQAppInterface.getApplication().getBaseContext(), paramagsd.getFileName(), "PreviewMode");
    int k = -1;
    int j = k;
    if (paramQQAppInterface != null)
    {
      j = k;
      if (paramQQAppInterface.length() > 0) {
        j = k;
      }
    }
    do
    {
      try
      {
        k = Integer.parseInt(paramQQAppInterface);
        j = k;
        int m = paramagsd.bF();
        j = k;
        if (m == 16)
        {
          bool = false;
          return bool;
        }
      }
      catch (NumberFormatException paramQQAppInterface) {}
      boolean bool = ahav.jP(j);
    } while (aqiw.isNetSupport(BaseApplicationImpl.getContext()));
    return false;
  }
  
  public static boolean a(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    for (long l = 0L; paramArrayList.hasNext(); l += l) {
      if (audk.a((FileManagerEntity)paramArrayList.next()).bd(paramBoolean)) {
        return true;
      }
    }
    return l > atvz.fJ();
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return paramQQAppInterface.a().T(paramString);
    case 102: 
      return paramQQAppInterface.a().M(paramString);
    case 109: 
      return paramQQAppInterface.a().W(paramString);
    }
    return paramQQAppInterface.a().K(paramString);
  }
  
  /* Error */
  public static byte[] a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 142	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: lload_1
    //   14: ldc2_w 1788
    //   17: lcmp
    //   18: ifge +28 -> 46
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: lload_1
    //   26: invokestatic 1794	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   29: astore_0
    //   30: aload_0
    //   31: astore_3
    //   32: aload 4
    //   34: ifnull +10 -> 44
    //   37: aload 4
    //   39: invokevirtual 1795	java/io/FileInputStream:close	()V
    //   42: aload_0
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: ldc2_w 1788
    //   49: lstore_1
    //   50: goto -29 -> 21
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 1796	java/io/IOException:printStackTrace	()V
    //   58: ldc 60
    //   60: iconst_1
    //   61: new 62	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 1798
    //   71: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_3
    //   75: invokevirtual 1799	java/io/IOException:toString	()Ljava/lang/String;
    //   78: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: areturn
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: astore_3
    //   95: ldc 60
    //   97: iconst_1
    //   98: new 62	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 1801
    //   108: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 5
    //   113: invokevirtual 1799	java/io/IOException:toString	()Ljava/lang/String;
    //   116: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload 6
    //   127: astore_3
    //   128: aload_0
    //   129: ifnull -85 -> 44
    //   132: aload_0
    //   133: invokevirtual 1795	java/io/FileInputStream:close	()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 1796	java/io/IOException:printStackTrace	()V
    //   143: ldc 60
    //   145: iconst_1
    //   146: new 62	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 1798
    //   156: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: invokevirtual 1799	java/io/IOException:toString	()Ljava/lang/String;
    //   163: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: areturn
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_3
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 1795	java/io/FileInputStream:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_3
    //   188: aload_3
    //   189: invokevirtual 1796	java/io/IOException:printStackTrace	()V
    //   192: ldc 60
    //   194: iconst_1
    //   195: new 62	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 1798
    //   205: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_3
    //   209: invokevirtual 1799	java/io/IOException:toString	()Ljava/lang/String;
    //   212: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: goto -36 -> 185
    //   224: astore_0
    //   225: goto -48 -> 177
    //   228: astore 5
    //   230: aload 4
    //   232: astore_0
    //   233: goto -140 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramString	String
    //   0	236	1	paramLong	long
    //   23	22	3	localObject1	Object
    //   53	22	3	localIOException1	IOException
    //   94	88	3	localObject2	Object
    //   187	22	3	localIOException2	IOException
    //   11	220	4	localFileInputStream	java.io.FileInputStream
    //   89	23	5	localIOException3	IOException
    //   228	1	5	localIOException4	IOException
    //   1	125	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	53	java/io/IOException
    //   3	13	89	java/io/IOException
    //   132	136	138	java/io/IOException
    //   3	13	174	finally
    //   181	185	187	java/io/IOException
    //   24	30	224	finally
    //   95	125	224	finally
    //   24	30	228	java/io/IOException
  }
  
  public static String al(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.getBytes().length < paramInt)) {
      return "";
    }
    int k = paramInt / 2;
    int j = paramInt / 4;
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramInt = 0;
    if (paramInt < arrayOfChar.length)
    {
      localStringBuilder1.append(arrayOfChar[paramInt]);
      if (localStringBuilder1.toString().getBytes().length <= k) {}
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      k = arrayOfChar.length;
      paramInt = arrayOfChar.length - 1;
      label94:
      if (paramInt <= 0) {
        break label168;
      }
      localStringBuilder2.append(arrayOfChar[paramInt]);
      if (localStringBuilder2.toString().getBytes().length <= j) {
        break label161;
      }
    }
    for (;;)
    {
      return localStringBuilder1.toString() + UU + paramString.substring(paramInt);
      paramInt += 1;
      break;
      label161:
      paramInt -= 1;
      break label94;
      label168:
      paramInt = k - 1;
    }
  }
  
  public static boolean amK()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static int b(FileManagerEntity paramFileManagerEntity)
  {
    int m = 0;
    if ((-1 == paramFileManagerEntity.status) || (1 == paramFileManagerEntity.status)) {}
    int k;
    for (int j = 1;; j = 0)
    {
      k = m;
      if (paramFileManagerEntity.bSend)
      {
        k = m;
        if (8 != paramFileManagerEntity.nOpType)
        {
          k = m;
          if (5 != paramFileManagerEntity.nOpType)
          {
            k = m;
            if (1 != paramFileManagerEntity.nOpType) {
              k = 1;
            }
          }
        }
      }
      if (3 != paramFileManagerEntity.getCloudType()) {
        break label135;
      }
      if ((k != 0) && ((k == 0) || (j == 0))) {
        break label133;
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) || (paramFileManagerEntity.peerType == 6000)) {
        break;
      }
      return 1;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
      return 2;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
      return 4;
    }
    label133:
    return 3;
    label135:
    if (((2 == paramFileManagerEntity.getCloudType()) || (1 == paramFileManagerEntity.getCloudType()) || ((4 == paramFileManagerEntity.getCloudType()) && (paramFileManagerEntity.nOpType != 24))) && (k != 0) && (j == 0) && (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return 3;
    }
    return paramFileManagerEntity.getCloudType();
  }
  
  public static int b(List<FileInfo> paramList, long paramLong)
  {
    int j = 0;
    int k = paramList.size() - 1;
    int m = j;
    if (j <= k)
    {
      m = j + k >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(m);
      if (localFileInfo.getDate() > paramLong)
      {
        m += 1;
        j = k;
        k = m;
      }
      for (;;)
      {
        m = k;
        k = j;
        j = m;
        break;
        if (localFileInfo.getDate() >= paramLong) {
          break label103;
        }
        m -= 1;
        k = j;
        j = m;
      }
    }
    label103:
    return m;
  }
  
  public static ahbm b(QQAppInterface paramQQAppInterface)
  {
    return new auea(paramQQAppInterface);
  }
  
  public static FileManagerEntity b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.WeiYunFileId = paramWeiYunFileInfo.bIk;
    localFileManagerEntity.fileName = paramWeiYunFileInfo.strFileName;
    localFileManagerEntity.fileSize = paramWeiYunFileInfo.nFileSize;
    localFileManagerEntity.nFileType = fM(paramWeiYunFileInfo.strFileName);
    localFileManagerEntity.strThumbPath = paramWeiYunFileInfo.bIz;
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nWeiYunSrcType = paramWeiYunFileInfo.cYi;
    localFileManagerEntity.lastTime = paramWeiYunFileInfo.mtime;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.strFileMd5 = paramWeiYunFileInfo.md5;
    localFileManagerEntity.WeiYunDirKey = paramWeiYunFileInfo.dirKey;
    localFileManagerEntity.strFileSHA = paramWeiYunFileInfo.sha;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramWeiYunFileInfo = localQQAppInterface.a().d(paramWeiYunFileInfo.bIk);
    if (paramWeiYunFileInfo != null)
    {
      localFileManagerEntity.imgWidth = paramWeiYunFileInfo.imgWidth;
      localFileManagerEntity.imgHeight = paramWeiYunFileInfo.imgHeight;
    }
    localQQAppInterface.a().v(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static String b(long paramLong, int paramInt, boolean paramBoolean)
  {
    long l2 = 604800000L;
    long l1 = l2;
    int j;
    int k;
    label136:
    label171:
    String str2;
    switch (paramInt)
    {
    default: 
      l1 = l2;
    case 0: 
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l1 + paramLong);
      paramInt = localCalendar.get(1);
      j = localCalendar.get(2) + 1;
      k = localCalendar.get(5);
      str1 = paramInt + "-";
      if (j < 10)
      {
        str1 = str1 + "0" + j;
        if (k >= 10) {
          break label346;
        }
        str1 = str1 + "-0" + k;
        str2 = str1;
        if (paramBoolean)
        {
          paramInt = localCalendar.get(11);
          j = localCalendar.get(12);
          str1 = str1 + " ";
          if (paramInt >= 10) {
            break label377;
          }
        }
      }
      break;
    }
    label346:
    label377:
    for (String str1 = str1 + "0" + paramInt;; str1 = str1 + paramInt)
    {
      str1 = str1 + ":";
      if (j >= 10) {
        break label401;
      }
      str2 = str1 + "0" + j;
      return str2;
      l1 = 2592000000L;
      break;
      str1 = str1 + j;
      break label136;
      str1 = str1 + "-" + k;
      break label171;
    }
    label401:
    return str1 + j;
  }
  
  public static void b(@NonNull QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new FileManagerUtil.15(paramContext, paramInt, paramString1, paramQQAppInterface, paramString2), 2, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<FileManagerEntity> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    int j;
    do
    {
      return;
      atgc localatgc = (atgc)paramQQAppInterface.getManager(373);
      ateh localateh = (ateh)paramQQAppInterface.getBusinessHandler(180);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((FileManagerEntity)localIterator.next()).fileSize > localatgc.iu()) {
          auds.JG(paramQQAppInterface.getApp().getResources().getString(2131689762, new Object[] { athu.c((float)localatgc.iu()) }));
        }
      }
      localIterator = paramList.iterator();
      j = 0;
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (localFileManagerEntity.fileSize > localatgc.iu())
        {
          j += 1;
        }
        else if (aueh.isFileExists(localFileManagerEntity.getFilePath()))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(athu.a(paramQQAppInterface, localFileManagerEntity, true));
          localateh.a(localatgc.aG(), localArrayList);
        }
        else if ((localFileManagerEntity.pDirKey != null) && (localFileManagerEntity.cloudId != null))
        {
          atgi.a().getCloudItemById(localFileManagerEntity.cloudId, new aueb(localFileManagerEntity, localatgc, localateh, paramQQAppInterface));
        }
        else if ((!TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (localFileManagerEntity.srvTime + 604800000L > NetConnInfoCenter.getServerTime()))
        {
          if (localFileManagerEntity.peerType == 3000) {
            localateh.c(localFileManagerEntity, true);
          } else {
            localateh.a(localFileManagerEntity, true);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("FileManagerUtil<FileAssistant>", 2, "can't save to cloudfile, fileName:" + localFileManagerEntity.fileName + " sessionId:" + localFileManagerEntity.nSessionId);
        }
      }
      anpc.report("tim_mine_tab_file_click_save_cloud_file");
    } while ((!paramBoolean) || (j >= paramList.size()));
    if (paramList.size() == 1) {
      paramList = paramQQAppInterface.getApp().getString(2131700601);
    }
    for (;;)
    {
      QQToast.a(paramQQAppInterface.getApp(), paramList, 0).show(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299627));
      return;
      if (j == 0) {
        paramList = paramQQAppInterface.getApp().getString(2131700608, new Object[] { Integer.valueOf(paramList.size()) });
      } else {
        paramList = paramQQAppInterface.getApp().getString(2131700607);
      }
    }
  }
  
  public static boolean b(agsd paramagsd)
  {
    int j = paramagsd.getCloudType();
    int k = paramagsd.bF();
    return (j == 3) && (k == 1);
  }
  
  public static boolean b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = atvz.j(paramContext, paramString, "FileMaxSize");
    if (paramContext == null) {}
    while (Integer.parseInt(paramContext) * 1048576 < paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, agsd paramagsd)
  {
    boolean bool = true;
    FileManagerEntity localFileManagerEntity = paramagsd.b();
    if (localFileManagerEntity == null) {
      return false;
    }
    int j;
    int k;
    label61:
    int m;
    label106:
    int n;
    label118:
    int i1;
    if ((a(paramQQAppInterface, paramagsd)) && (!localFileManagerEntity.isZipInnerFile))
    {
      j = 1;
      if ((paramagsd.DW() == 6000) || (paramagsd.getCloudType() == 7)) {
        break label162;
      }
      k = 1;
      if ((paramagsd.getCloudType() == 3) && (localFileManagerEntity.strTroopFilePath == null) && (localFileManagerEntity.Uuid == null) && (localFileManagerEntity.WeiYunFileId == null) && (localFileManagerEntity.cloudId == null)) {
        break label167;
      }
      m = 1;
      if (paramagsd.getCloudType() == 0) {
        break label173;
      }
      n = 1;
      if (paramagsd.getCloudType() == 5) {
        break label179;
      }
      i1 = 1;
      label131:
      if ((j == 0) || (k == 0) || (m == 0) || (n == 0) || (i1 == 0)) {
        break label185;
      }
    }
    for (;;)
    {
      return bool;
      j = 0;
      break;
      label162:
      k = 0;
      break label61;
      label167:
      m = 0;
      break label106;
      label173:
      n = 0;
      break label118;
      label179:
      i1 = 0;
      break label131;
      label185:
      bool = false;
    }
  }
  
  public static long bA()
  {
    int j = amzo.seq;
    amzo.seq = j + 1;
    return (short)(int)((int)(j & 0xFFFFFFFF) & 0xFFFF);
  }
  
  public static boolean ba(String paramString1, String paramString2)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_new_flag_" + paramString1 + "_" + paramString2, true);
  }
  
  public static int c(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static FileManagerEntity c()
  {
    Object localObject3 = atwb.db();
    Object localObject2 = atwb.ep();
    Object localObject1 = atwb.dd();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).getType() == 0) {
          return a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (fM(((WeiYunFileInfo)localObject2).strFileName) == 0) {
          return b((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  public static FileManagerEntity c(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity.nSessionId = d().longValue();
    paramFileManagerEntity.bSend = false;
    paramFileManagerEntity.status = -1;
    paramFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    paramFileManagerEntity.setCloudType(9);
    if (paramFileManagerEntity.cloudFile != null)
    {
      paramFileManagerEntity.strFileSHA = atwx.t(paramFileManagerEntity.cloudFile.fileSha);
      paramFileManagerEntity.imgWidth = paramFileManagerEntity.cloudFile.width;
      paramFileManagerEntity.imgHeight = paramFileManagerEntity.cloudFile.height;
      paramFileManagerEntity.cloudIdHex = aqhs.bytes2HexStr(paramFileManagerEntity.cloudId);
    }
    if (TextUtils.isEmpty(paramFileManagerEntity.strThumbPath))
    {
      aths.a().c(paramFileManagerEntity, 640);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerUtil<FileAssistant>", 2, "entity strThumbPath is null");
      }
    }
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().v(paramFileManagerEntity);
    return paramFileManagerEntity;
  }
  
  @TargetApi(9)
  public static int cZ(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      j = -1;
    }
    Object localObject;
    do
    {
      return j;
      localObject = aueh.getFileDirectoryOf(paramString);
    } while (wc().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -2;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return 0;
  }
  
  public static int d(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static Long d()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static String d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramFileManagerEntity = "";
    }
    for (;;)
    {
      return paramFileManagerEntity;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FileManagerEntity info, ");
        localStringBuilder.append("], nSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append("], fileName[");
        localStringBuilder.append(paramFileManagerEntity.fileName);
        localStringBuilder.append("], cloudType[");
        localStringBuilder.append(paramFileManagerEntity.getCloudType());
        localStringBuilder.append("], uniseq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.uniseq));
        localStringBuilder.append("], nRelatedSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nRelatedSessionId);
        localStringBuilder.append("], bDelInAio[");
        localStringBuilder.append(paramFileManagerEntity.bDelInAio);
        localStringBuilder.append("], bDelInFM[");
        localStringBuilder.append(paramFileManagerEntity.bDelInFM);
        localStringBuilder.append("], fileSize[");
        localStringBuilder.append(paramFileManagerEntity.fileSize);
        localStringBuilder.append("], fProgress[");
        localStringBuilder.append(paramFileManagerEntity.getfProgress());
        localStringBuilder.append("], lastTime[");
        localStringBuilder.append(paramFileManagerEntity.lastTime);
        localStringBuilder.append("], msgSeq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgSeq));
        localStringBuilder.append("], msgUid[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgUid));
        localStringBuilder.append("], msgTime[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgTime));
        localStringBuilder.append("], nFileType[");
        localStringBuilder.append(paramFileManagerEntity.nFileType);
        localStringBuilder.append("], nOpType[");
        localStringBuilder.append(paramFileManagerEntity.nOpType);
        localStringBuilder.append("], nWeiYunSrcType[");
        localStringBuilder.append(paramFileManagerEntity.nWeiYunSrcType);
        localStringBuilder.append("], peerNick[");
        localStringBuilder.append(paramFileManagerEntity.peerNick);
        localStringBuilder.append("], peerType[");
        localStringBuilder.append(paramFileManagerEntity.peerType);
        localStringBuilder.append("], peerUin[");
        localStringBuilder.append(ahav.kZ(paramFileManagerEntity.peerUin));
        localStringBuilder.append("], selfUin[");
        localStringBuilder.append(ahav.kZ(paramFileManagerEntity.selfUin));
        localStringBuilder.append("], srvTime[");
        localStringBuilder.append(paramFileManagerEntity.srvTime);
        localStringBuilder.append("], status[");
        localStringBuilder.append(paramFileManagerEntity.status);
        localStringBuilder.append("], strFilePath[");
        localStringBuilder.append(paramFileManagerEntity.getFilePath());
        localStringBuilder.append("], strServerPath[");
        localStringBuilder.append(paramFileManagerEntity.strServerPath);
        localStringBuilder.append("], strThumbPath[");
        localStringBuilder.append(paramFileManagerEntity.strThumbPath);
        localStringBuilder.append("], Uuid[");
        localStringBuilder.append(paramFileManagerEntity.Uuid);
        localStringBuilder.append("], WeiYunFileId[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunFileId);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], strFileMd5[");
        localStringBuilder.append(paramFileManagerEntity.strFileMd5);
        localStringBuilder.append("], strFileSHA[");
        localStringBuilder.append(paramFileManagerEntity.strFileSHA);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], WeiYunDirKey[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunDirKey);
        localStringBuilder.append("], _status[");
        localStringBuilder.append(paramFileManagerEntity.getStatus());
        localStringBuilder.append("], bOnceSuccess[");
        localStringBuilder.append(paramFileManagerEntity.bOnceSuccess);
        localStringBuilder.append("], imgHeight[");
        localStringBuilder.append(paramFileManagerEntity.imgHeight);
        localStringBuilder.append("], imgWidth[");
        localStringBuilder.append(paramFileManagerEntity.imgWidth);
        localStringBuilder.append("]");
        paramFileManagerEntity = localStringBuilder.toString();
      }
      finally {}
    }
  }
  
  public static int da(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      j = -1;
    }
    Object localObject;
    do
    {
      return j;
      localObject = aueh.getFileDirectoryOf(paramString);
    } while (wc().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  public static int dc(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("qlink_new_count_" + paramString, 0);
  }
  
  public static void dkT()
  {
    ThreadManager.post(new FileManagerUtil.3(), 8, null, false);
  }
  
  public static boolean dm(long paramLong)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {}
    while ((amK()) || (paramLong >= 3145728L)) {
      return false;
    }
    return true;
  }
  
  public static String e(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject6 = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject1;
    label282:
    Object localObject2;
    label291:
    Object localObject5;
    switch (paramFileManagerEntity.nOpType)
    {
    default: 
      localObject1 = null;
      if (paramFileManagerEntity.getCloudType() == 0) {
        localObject1 = localBaseApplication.getString(2131693552);
      }
      if (paramFileManagerEntity.getCloudType() != 5) {
        break label1128;
      }
      if (paramFileManagerEntity.bSend)
      {
        localObject1 = localBaseApplication.getString(2131693587);
        localObject4 = paramFileManagerEntity.peerNick;
        localObject2 = localObject1;
        localObject1 = localObject4;
        if ((localObject2 == null) || (((String)localObject2).equals(localBaseApplication.getString(2131693560))) || (((String)localObject2).equals(localBaseApplication.getString(2131693553)))) {
          break label1122;
        }
        localObject5 = paramFileManagerEntity.peerNick;
        label331:
        localObject1 = localObject2;
        if (paramFileManagerEntity.nOpType == 1)
        {
          localObject1 = localObject2;
          if (paramFileManagerEntity.bSend) {
            localObject1 = localBaseApplication.getString(2131693587);
          }
        }
        localObject4 = localObject5;
      }
      break;
    }
    try
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject4 = localObject5;
      localObject2 = ahav.a(localQQAppInterface, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
    }
    catch (Exception localException1)
    {
      label438:
      label475:
      label477:
      do
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface;
          localObject3 = localObject4;
        }
        if ((localObject1 != null) && (localObject3 != null)) {
          return (String)localObject1 + " " + localObject3;
        }
        paramFileManagerEntity = (FileManagerEntity)localObject1;
      } while (localObject1 != null);
      return localObject3;
    }
    try
    {
      if (paramFileManagerEntity.TroopUin == 0L) {
        break label1119;
      }
      localObject4 = ((TroopManager)localQQAppInterface.getManager(52)).b(String.valueOf(paramFileManagerEntity.TroopUin));
      if ((localObject4 != null) && (((TroopInfo)localObject4).troopname != null)) {
        break label895;
      }
      localObject2 = "";
      localObject4 = localObject2;
      if (!paramFileManagerEntity.bSend) {
        break label938;
      }
      localObject4 = localObject2;
      localObject2 = localBaseApplication.getString(2131693517) + (String)localObject2;
      localObject1 = null;
    }
    catch (Exception localException2)
    {
      break label1060;
      break label477;
    }
    Object localObject4 = localObject2;
    if (localObject1 != null) {
      localObject4 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (((String)localObject1).equals(localBaseApplication.getString(2131693560))) {
          localObject4 = null;
        }
        localObject2 = localObject4;
        if (paramFileManagerEntity.peerType != 3000) {
          continue;
        }
        if (localObject1 != null)
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localBaseApplication.getString(2131693560))) {}
        }
        else
        {
          localObject2 = localObject4;
          if (paramFileManagerEntity.nOpType != 28) {
            continue;
          }
        }
        localObject2 = localObject4;
        localObject5 = ((acdu)localQQAppInterface.getManager(53)).a(String.valueOf(paramFileManagerEntity.peerUin));
        if (localObject5 == null) {
          break label1135;
        }
        localObject2 = localObject4;
        if (((DiscussionInfo)localObject5).discussionName != null) {
          continue;
        }
      }
      catch (Exception localException3)
      {
        label895:
        continue;
        label938:
        localObject3 = localObject1;
        label1060:
        localObject1 = localException3;
        continue;
      }
      localObject2 = localObject4;
      if (paramFileManagerEntity.bSend)
      {
        localObject2 = localObject4;
        localObject4 = localBaseApplication.getString(2131693516) + (String)localObject4;
        localObject1 = localObject4;
        localObject2 = localObject6;
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
        if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(localBaseApplication.getString(2131693553))) || (!paramFileManagerEntity.bSend)) {
          continue;
        }
        paramFileManagerEntity = localBaseApplication.getString(2131693587) + " " + (String)localObject2;
        return paramFileManagerEntity;
        localObject1 = localBaseApplication.getString(2131693552);
        break;
        localObject1 = localBaseApplication.getString(2131693560);
        break;
        localObject1 = localBaseApplication.getString(2131693587);
        break;
        localObject1 = localBaseApplication.getString(2131693553);
        break;
        if (paramFileManagerEntity.bSend)
        {
          localObject1 = localBaseApplication.getString(2131693587);
          break;
        }
        localObject1 = localBaseApplication.getString(2131693552);
        break;
        localObject1 = localBaseApplication.getString(2131721506);
        break;
        localObject1 = localBaseApplication.getString(2131721507);
        break;
        localObject1 = localBaseApplication.getString(2131721513);
        break;
        localObject1 = localBaseApplication.getString(2131721510);
        break;
        localObject1 = localBaseApplication.getString(2131721509);
        break;
        localObject1 = localBaseApplication.getString(2131721511);
        break;
        localObject1 = localBaseApplication.getString(2131721514);
        break;
        localObject1 = localBaseApplication.getString(2131721512);
        break;
        localObject1 = localBaseApplication.getString(2131721508);
        break;
        localObject1 = localBaseApplication.getString(2131693552);
        break label282;
        if ((localObject4 != null) && (((TroopInfo)localObject4).troopname != null) && (((TroopInfo)localObject4).troopname.length() > 14))
        {
          localObject4 = ((TroopInfo)localObject4).troopname;
          localObject2 = localObject4;
          break label438;
        }
        localObject4 = ((TroopInfo)localObject4).troopname;
        localObject2 = localObject4;
        break label438;
        localObject4 = localObject2;
        localObject2 = localBaseApplication.getString(2131693515) + (String)localObject2;
        break label475;
        if (localObject5 != null)
        {
          localObject2 = localObject4;
          if (((DiscussionInfo)localObject5).discussionName != null)
          {
            localObject2 = localObject4;
            if (((DiscussionInfo)localObject5).discussionName.length() > 14)
            {
              localObject2 = localObject4;
              localObject4 = ((DiscussionInfo)localObject5).discussionName;
              continue;
            }
          }
        }
        localObject2 = localObject4;
        localObject4 = ((DiscussionInfo)localObject5).discussionName;
        continue;
      }
      localObject2 = localObject4;
      localObject4 = localBaseApplication.getString(2131693514) + (String)localObject4;
      localObject1 = localObject4;
      localObject2 = localObject6;
      continue;
      label1119:
      label1122:
      localObject5 = localObject1;
      break label331;
      label1128:
      Object localObject3 = localObject1;
      localObject1 = null;
      break label291;
      label1135:
      String str = "";
    }
  }
  
  public static String e(ByteStringMicro paramByteStringMicro)
  {
    try
    {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
      if (paramByteStringMicro == null) {
        return "";
      }
    }
    catch (Exception paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
      return "";
    }
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int j = 0;
    while (j < paramByteStringMicro.length)
    {
      int k = paramByteStringMicro[j];
      localStringBuffer.append(arrayOfChar[(k >>> 4 & 0xF)]);
      localStringBuffer.append(arrayOfChar[(k & 0xF)]);
      j += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ShortcutManager localShortcutManager;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localShortcutManager = (ShortcutManager)paramContext.getSystemService(ShortcutManager.class);
      if ((localShortcutManager != null) && (!isShortcutCreated_O(paramString2, localShortcutManager))) {
        break label35;
      }
    }
    label35:
    while (!localShortcutManager.isRequestPinShortcutSupported()) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.putExtra(paramString1, true);
    localIntent.setClassName(paramContext, JumpActivity.class.getName());
    localIntent.setFlags(337641472);
    String str = "my-shortcut";
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = str;
      if (paramString2.equals(paramContext.getString(2131695446))) {
        paramString1 = "my-dataline-shortcut";
      }
    }
    localShortcutManager.requestPinShortcut(new ShortcutInfo.Builder(paramContext, paramString1).setShortLabel(paramString2).setIcon(Icon.createWithResource(paramContext, paramInt)).setIntent(localIntent).build(), PendingIntent.getBroadcast(paramContext, 0, new Intent("com.tencent.fileassistant.createshrotcut"), 134217728).getIntentSender());
  }
  
  public static void eI(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString = "qlink_new_count_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public static String el(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return "other";
    case 0: 
      return "image";
    case 1: 
      return "audio";
    case 2: 
      return "video";
    case 3: 
      return "doc";
    case 4: 
      return "zip";
    case 5: 
      return "apk";
    case 6: 
      return "excel";
    case 7: 
      return "ppt";
    case 8: 
      return "html";
    case 9: 
      return "pdf";
    case 10: 
      return "txt";
    }
    return "psd";
  }
  
  public static int fM(String paramString)
  {
    for (;;)
    {
      try
      {
        String str1 = aueh.getExtension(paramString);
        if (str1 != null)
        {
          j = str1.length();
          if (j != 0) {}
        }
        else
        {
          j = -1;
          return j;
        }
        if (kQ == null) {
          kQ = new HashMap();
        }
        try
        {
          Object localObject = Class.forName("android.media.MediaFile").getDeclaredField("sFileTypeMap");
          ((Field)localObject).setAccessible(true);
          localObject = ((HashMap)((Field)localObject).get(null)).keySet().iterator();
          if (((Iterator)localObject).hasNext())
          {
            String str2 = (String)((Iterator)localObject).next();
            str2 = "." + str2;
            kQ.put(str2.toLowerCase(), Integer.valueOf(1));
            continue;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
          kQ.remove(".flv");
          kQ.remove(".m");
          kQ.remove(".webp");
          kQ.remove(".vcf");
          kQ.put(".bmp", Integer.valueOf(0));
          kQ.put(".jpg", Integer.valueOf(0));
          kQ.put(".jpeg", Integer.valueOf(0));
          kQ.put(".png", Integer.valueOf(0));
          kQ.put(".gif", Integer.valueOf(0));
          kQ.put(".webp", Integer.valueOf(0));
          kQ.put(".psd", Integer.valueOf(12));
          kQ.put(".swf", Integer.valueOf(2));
          kQ.put(".mov", Integer.valueOf(2));
          kQ.put(".mp4", Integer.valueOf(2));
          kQ.put(".3gp", Integer.valueOf(2));
          kQ.put(".avi", Integer.valueOf(2));
          kQ.put(".rmvb", Integer.valueOf(2));
          kQ.put(".mpg", Integer.valueOf(2));
          kQ.put(".rm", Integer.valueOf(2));
          kQ.put(".asf", Integer.valueOf(2));
          kQ.put(".mpeg", Integer.valueOf(2));
          kQ.put(".mkv", Integer.valueOf(2));
          kQ.put(".wmv", Integer.valueOf(2));
          kQ.put(".flv", Integer.valueOf(2));
          kQ.put(".f4v", Integer.valueOf(2));
          kQ.put(".webm", Integer.valueOf(2));
          kQ.put(".mod", Integer.valueOf(2));
          kQ.put(".mpe", Integer.valueOf(2));
          kQ.put(".fla", Integer.valueOf(2));
          kQ.put(".m4r", Integer.valueOf(2));
          kQ.put(".m4u", Integer.valueOf(2));
          kQ.put(".m4v", Integer.valueOf(2));
          kQ.put(".vob", Integer.valueOf(2));
          kQ.put(".doc", Integer.valueOf(3));
          kQ.put(".docx", Integer.valueOf(3));
          kQ.put(".wps", Integer.valueOf(3));
          kQ.put(".pages", Integer.valueOf(3));
          kQ.put(".zip", Integer.valueOf(4));
          kQ.put(".rar", Integer.valueOf(4));
          kQ.put(".7z", Integer.valueOf(4));
          kQ.put(".tar", Integer.valueOf(4));
          kQ.put(".iso", Integer.valueOf(4));
          kQ.put("gz", Integer.valueOf(4));
          kQ.put(".apk", Integer.valueOf(5));
          kQ.put(".apk.rename", Integer.valueOf(5));
          kQ.put(".xls", Integer.valueOf(6));
          kQ.put(".xlsx", Integer.valueOf(6));
          kQ.put(".csv", Integer.valueOf(6));
          kQ.put(".numbers", Integer.valueOf(6));
          kQ.put(".et", Integer.valueOf(6));
          kQ.put(".ppt", Integer.valueOf(7));
          kQ.put(".pptx", Integer.valueOf(7));
          kQ.put(".pps", Integer.valueOf(7));
          kQ.put(".dps", Integer.valueOf(7));
          kQ.put(".keynotes", Integer.valueOf(7));
          kQ.put(".htm", Integer.valueOf(8));
          kQ.put(".html", Integer.valueOf(8));
          kQ.put(".php", Integer.valueOf(8));
          kQ.put(".pdf", Integer.valueOf(9));
          kQ.put(".txt", Integer.valueOf(10));
          kQ.put(".rtf", Integer.valueOf(10));
          kQ.put(".epub", Integer.valueOf(10));
          kQ.put(".c", Integer.valueOf(10));
          kQ.put(".conf", Integer.valueOf(10));
          kQ.put(".cpp", Integer.valueOf(10));
          kQ.put(".h", Integer.valueOf(10));
          kQ.put(".java", Integer.valueOf(10));
          kQ.put(".log", Integer.valueOf(10));
          kQ.put(".prop", Integer.valueOf(10));
          kQ.put(".rc", Integer.valueOf(10));
          kQ.put(".sh", Integer.valueOf(10));
          kQ.put(".csv", Integer.valueOf(10));
          kQ.put(".xml", Integer.valueOf(10));
          if (kQ.containsKey(str1.toLowerCase())) {
            j = ((Integer)kQ.get(str1.toLowerCase())).intValue();
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          localClassNotFoundException.printStackTrace();
          continue;
        }
        catch (Exception localException)
        {
          if (kQ == null)
          {
            j = 11;
            continue;
          }
          kQ.put(".mp3", Integer.valueOf(1));
          kQ.put(".wav", Integer.valueOf(1));
          kQ.put(".m4a", Integer.valueOf(1));
          kQ.put(".wave", Integer.valueOf(1));
          kQ.put(".midi", Integer.valueOf(1));
          kQ.put(".wma", Integer.valueOf(1));
          kQ.put(".ogg", Integer.valueOf(1));
          kQ.put(".ape", Integer.valueOf(1));
          kQ.put(".acc", Integer.valueOf(1));
          kQ.put(".aac", Integer.valueOf(1));
          kQ.put(".aiff", Integer.valueOf(1));
          kQ.put(".mid", Integer.valueOf(1));
          kQ.put(".xmf", Integer.valueOf(1));
          kQ.put(".rtttl", Integer.valueOf(1));
          kQ.put(".flac", Integer.valueOf(1));
          kQ.put(".amr", Integer.valueOf(1));
          kQ.put(".mp2", Integer.valueOf(1));
          kQ.put(".m3u", Integer.valueOf(1));
          kQ.put(".m4b", Integer.valueOf(1));
          kQ.put(".m4p", Integer.valueOf(1));
          kQ.put(".mpga", Integer.valueOf(1));
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label1576;
        }
      }
      finally {}
      QLog.w("FileManagerUtil<FileAssistant>", 2, "Unknow file Type[" + paramString + "]");
      label1576:
      int j = 11;
    }
  }
  
  public static int g(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    int j;
    do
    {
      return 8;
      j = paramFileManagerEntity.peerType;
      if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
        return 5;
      }
    } while ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) && (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())));
    switch (j)
    {
    default: 
      return 1;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public static String g(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.nFileType == 0))
    {
      String str = paramFileManagerEntity.zipInnerPath;
      paramFileManagerEntity = (String)paramFileManagerEntity.mContext;
      paramFileManagerEntity = atad.toMD5(paramFileManagerEntity + str);
      return audn.a().wb() + "x-zip-" + paramFileManagerEntity;
    }
    return "";
  }
  
  public static String gC(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return "文件";
    case 1: 
      return "音乐";
    case 0: 
      return "图片";
    case 2: 
      return "视频";
    case 3: 
    case 6: 
    case 7: 
    case 9: 
      return "文档";
    }
    return "应用";
  }
  
  public static long ge()
  {
    return anbk.I(anbk.Ji());
  }
  
  public static String getFileName(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      ti();
      localObject = "";
      return localObject;
    }
    int m = paramString.length();
    int j = paramString.lastIndexOf('/');
    int k = paramString.lastIndexOf('\\');
    if (k > j) {
      j = k;
    }
    for (;;)
    {
      if (j < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "filepath without / ?");
        }
        j = 0;
      }
      String str2;
      String str1;
      for (;;)
      {
        str2 = paramString.substring(j, m);
        if ((QLog.isColorLevel()) && (str2.startsWith("."))) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
        }
        for (str1 = str2; str1.startsWith("."); str1 = str1.replaceFirst(".", "")) {}
        j += 1;
      }
      localObject = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      localObject = "InvaildName";
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
      return "InvaildName";
    }
  }
  
  public static long getFileSizes(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getFileSizes: filePath is null");
      return 0L;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " is not exists");
      return 0L;
    }
    long l = localFile.length();
    if (0L == l) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " len is 0");
    }
    return l;
  }
  
  public static String h(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    int j;
    Object localObject2;
    do
    {
      return null;
      localObject1 = new File(audn.a().wb());
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      localObject1 = audn.a().wb() + ahav.getFileName(paramString) + ".JPG";
      if (aueh.fileExistsAndNotEmpty((String)localObject1)) {
        return localObject1;
      }
      j = ahav.getFileType(paramString);
      if (j != 0) {
        break label277;
      }
      localObject2 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject2).getThread()) {
        break;
      }
      localObject2 = dz.a(paramString, paramInt1, paramInt2);
    } while (localObject2 == null);
    for (;;)
    {
      try
      {
        aueh.f((Bitmap)localObject2, (String)localObject1);
        ((Bitmap)localObject2).recycle();
        dz.e((String)localObject1, dz.l(paramString));
        return localObject1;
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramString.getMessage());
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramString.getMessage());
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramString.getMessage());
        return null;
      }
      audx.a.getExecutor().execute(new FileManagerUtil.8((String)localObject1, paramString, paramInt1, paramInt2));
      continue;
      label277:
      if (j != 2) {
        break;
      }
      a(paramString, true, paramInt1, paramInt2, 3, new auee((String)localObject1, paramString));
    }
  }
  
  public static int hL(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return 2130839375;
    case 2: 
      return 2130845245;
    case 0: 
      return 2130845173;
    case 1: 
      return 2130845188;
    case 3: 
      return 2130845138;
    case 4: 
      return 2130839395;
    case 6: 
      return 2130845255;
    case 5: 
      return 2130845117;
    case 7: 
      return 2130845203;
    case 8: 
      return 2130845146;
    case 9: 
      return 2130845201;
    case 10: 
      return 2130845233;
    }
    return 2130845210;
  }
  
  public static int hM(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1000: 
    case 2000: 
    case 2008: 
    default: 
      return -1;
    case 1003: 
    case 2003: 
      return 1;
    case 1005: 
    case 2005: 
      return 0;
    case 1004: 
    case 2004: 
    case 4001: 
      return 3;
    case 1001: 
    case 1002: 
    case 2001: 
    case 2002: 
      return 2;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  public static boolean isLocalFile(String paramString)
  {
    return aueh.fileExistsAndNotEmpty(paramString);
  }
  
  @RequiresApi(api=25)
  public static boolean isShortcutCreated_O(String paramString, ShortcutManager paramShortcutManager)
  {
    if (paramShortcutManager == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
      do
      {
        if (!paramShortcutManager.hasNext()) {
          break;
        }
      } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getShortLabel()));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean jP(int paramInt)
  {
    return paramInt == atwa.cXS;
  }
  
  public static void jQ(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().b(paramLong);
    if (localFileManagerEntity == null) {
      return;
    }
    switch (localFileManagerEntity.nOpType)
    {
    case -1: 
    case 0: 
    case 3: 
    case 7: 
    case 2: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return;
    case 1: 
    case 5: 
    case 8: 
      String str = kY(localFileManagerEntity.fileName);
      auds.JF(str + BaseApplicationImpl.getContext().getString(2131693561) + audn.a().vZ());
      atgi.a().a(localFileManagerEntity, localFileManagerEntity.strFilePath, true);
      return;
    }
    auds.JF(kY(localFileManagerEntity.fileName) + BaseApplicationImpl.getContext().getString(2131694103));
  }
  
  /* Error */
  public static void jR(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 2770	audx:wM	Ljava/util/ArrayList;
    //   6: ifnonnull +13 -> 19
    //   9: new 45	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 47	java/util/ArrayList:<init>	()V
    //   16: putstatic 2770	audx:wM	Ljava/util/ArrayList;
    //   19: getstatic 2770	audx:wM	Ljava/util/ArrayList;
    //   22: lload_0
    //   23: invokestatic 2069	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: invokevirtual 2773	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 2770	audx:wM	Ljava/util/ArrayList;
    //   41: lload_0
    //   42: invokestatic 2069	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 1120	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -18 -> 34
    //   55: ldc_w 2775
    //   58: iconst_2
    //   59: new 62	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 2777
    //   69: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_0
    //   73: invokestatic 783	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   76: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 2779
    //   82: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto -57 -> 34
    //   94: astore_3
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_3
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramLong	long
    //   29	2	2	bool	boolean
    //   94	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	94	finally
    //   19	30	94	finally
    //   38	91	94	finally
  }
  
  /* Error */
  @TargetApi(9)
  public static Map<String, File> k(Context paramContext)
  {
    // Byte code:
    //   0: new 1312	java/util/HashMap
    //   3: dup
    //   4: bipush 10
    //   6: invokespecial 2790	java/util/HashMap:<init>	(I)V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 2792
    //   16: invokestatic 2798	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   19: invokeinterface 2799 3 0
    //   24: pop
    //   25: aload_0
    //   26: ldc_w 2801
    //   29: invokevirtual 2804	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 2806	android/os/storage/StorageManager
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 2810	java/lang/Object:getClass	()Ljava/lang/Class;
    //   42: ldc_w 2812
    //   45: iconst_0
    //   46: anewarray 2262	java/lang/Class
    //   49: invokevirtual 2816	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   52: aload 5
    //   54: iconst_0
    //   55: anewarray 4	java/lang/Object
    //   58: invokevirtual 2822	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 2824	[Ljava/lang/String;
    //   64: checkcast 2824	[Ljava/lang/String;
    //   67: astore 5
    //   69: aload 5
    //   71: arraylength
    //   72: istore_3
    //   73: iconst_0
    //   74: istore_1
    //   75: iload_1
    //   76: iload_3
    //   77: if_icmpge +135 -> 212
    //   80: aload 5
    //   82: iload_1
    //   83: aaload
    //   84: astore 6
    //   86: new 451	java/io/File
    //   89: dup
    //   90: aload 6
    //   92: invokespecial 452	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore 7
    //   97: getstatic 2054	android/os/Build$VERSION:SDK_INT	I
    //   100: bipush 9
    //   102: if_icmple +322 -> 424
    //   105: aload 7
    //   107: invokevirtual 2827	java/io/File:getUsableSpace	()J
    //   110: lconst_0
    //   111: lcmp
    //   112: ifgt +6 -> 118
    //   115: goto +309 -> 424
    //   118: aload 4
    //   120: invokeinterface 2829 1 0
    //   125: ifne +64 -> 189
    //   128: aload 4
    //   130: invokeinterface 2830 1 0
    //   135: invokeinterface 2384 1 0
    //   140: astore 8
    //   142: aload 8
    //   144: invokeinterface 1147 1 0
    //   149: ifeq +270 -> 419
    //   152: aload 4
    //   154: aload 8
    //   156: invokeinterface 1151 1 0
    //   161: checkcast 37	java/lang/String
    //   164: invokeinterface 2831 2 0
    //   169: checkcast 451	java/io/File
    //   172: invokevirtual 1110	java/io/File:getPath	()Ljava/lang/String;
    //   175: aload 6
    //   177: invokevirtual 1034	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   180: iconst_1
    //   181: if_icmpne -39 -> 142
    //   184: iconst_1
    //   185: istore_2
    //   186: goto +245 -> 431
    //   189: aload 4
    //   191: ldc_w 2833
    //   194: aload 7
    //   196: invokeinterface 2799 3 0
    //   201: pop
    //   202: goto +222 -> 424
    //   205: astore 5
    //   207: aload 5
    //   209: invokevirtual 2834	java/lang/IllegalArgumentException:printStackTrace	()V
    //   212: aload 4
    //   214: ldc_w 2833
    //   217: invokeinterface 2835 2 0
    //   222: ifne +109 -> 331
    //   225: aload_0
    //   226: aconst_null
    //   227: invokevirtual 2839	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   230: astore_0
    //   231: aload_0
    //   232: ifnull +142 -> 374
    //   235: ldc 60
    //   237: iconst_1
    //   238: new 62	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 2841
    //   248: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: invokevirtual 1110	java/io/File:getPath	()Ljava/lang/String;
    //   255: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_0
    //   265: invokevirtual 2844	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   268: aload 4
    //   270: ldc_w 2792
    //   273: invokeinterface 2831 2 0
    //   278: checkcast 451	java/io/File
    //   281: invokevirtual 2844	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   284: invokevirtual 2846	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   287: ifne +44 -> 331
    //   290: ldc 60
    //   292: iconst_1
    //   293: new 62	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 2848
    //   303: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: invokevirtual 1110	java/io/File:getPath	()Ljava/lang/String;
    //   310: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 4
    //   321: ldc_w 2833
    //   324: aload_0
    //   325: invokeinterface 2799 3 0
    //   330: pop
    //   331: aload 4
    //   333: areturn
    //   334: astore 5
    //   336: aload 5
    //   338: invokevirtual 2849	java/lang/IllegalAccessException:printStackTrace	()V
    //   341: goto -129 -> 212
    //   344: astore 5
    //   346: aload 5
    //   348: invokevirtual 2850	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   351: goto -139 -> 212
    //   354: astore 5
    //   356: aload 5
    //   358: invokevirtual 2851	java/lang/NoSuchMethodException:printStackTrace	()V
    //   361: goto -149 -> 212
    //   364: astore 5
    //   366: aload 5
    //   368: invokevirtual 1180	java/lang/Exception:printStackTrace	()V
    //   371: goto -159 -> 212
    //   374: ldc 60
    //   376: iconst_1
    //   377: ldc_w 2853
    //   380: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload 4
    //   385: areturn
    //   386: astore_0
    //   387: ldc 60
    //   389: iconst_1
    //   390: new 62	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 2855
    //   400: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: invokevirtual 2856	java/lang/Exception:toString	()Ljava/lang/String;
    //   407: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload 4
    //   418: areturn
    //   419: iconst_0
    //   420: istore_2
    //   421: goto +10 -> 431
    //   424: iload_1
    //   425: iconst_1
    //   426: iadd
    //   427: istore_1
    //   428: goto -353 -> 75
    //   431: iload_2
    //   432: iconst_1
    //   433: if_icmpeq -9 -> 424
    //   436: goto -247 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	paramContext	Context
    //   74	354	1	j	int
    //   185	249	2	k	int
    //   72	6	3	m	int
    //   9	408	4	localHashMap	HashMap
    //   35	46	5	localObject	Object
    //   205	3	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   334	3	5	localIllegalAccessException	java.lang.IllegalAccessException
    //   344	3	5	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   354	3	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   364	3	5	localException	Exception
    //   84	92	6	str	String
    //   95	100	7	localFile	File
    //   140	15	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   11	73	205	java/lang/IllegalArgumentException
    //   86	115	205	java/lang/IllegalArgumentException
    //   118	142	205	java/lang/IllegalArgumentException
    //   142	184	205	java/lang/IllegalArgumentException
    //   189	202	205	java/lang/IllegalArgumentException
    //   11	73	334	java/lang/IllegalAccessException
    //   86	115	334	java/lang/IllegalAccessException
    //   118	142	334	java/lang/IllegalAccessException
    //   142	184	334	java/lang/IllegalAccessException
    //   189	202	334	java/lang/IllegalAccessException
    //   11	73	344	java/lang/reflect/InvocationTargetException
    //   86	115	344	java/lang/reflect/InvocationTargetException
    //   118	142	344	java/lang/reflect/InvocationTargetException
    //   142	184	344	java/lang/reflect/InvocationTargetException
    //   189	202	344	java/lang/reflect/InvocationTargetException
    //   11	73	354	java/lang/NoSuchMethodException
    //   86	115	354	java/lang/NoSuchMethodException
    //   118	142	354	java/lang/NoSuchMethodException
    //   142	184	354	java/lang/NoSuchMethodException
    //   189	202	354	java/lang/NoSuchMethodException
    //   11	73	364	java/lang/Exception
    //   86	115	364	java/lang/Exception
    //   118	142	364	java/lang/Exception
    //   142	184	364	java/lang/Exception
    //   189	202	364	java/lang/Exception
    //   225	231	386	java/lang/Exception
    //   235	331	386	java/lang/Exception
    //   374	383	386	java/lang/Exception
  }
  
  public static String kW(String paramString)
  {
    int j = paramString.lastIndexOf(File.separator);
    int k = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (j > 0)
    {
      if ((k <= 0) || (k <= j)) {
        break label161;
      }
      localObject1 = paramString.substring(j, k);
    }
    for (str1 = paramString.substring(k);; str1 = str2)
    {
      str2 = paramString.substring(0, j);
      localObject2 = localObject1;
      localObject1 = str2;
      File localFile = new File(paramString);
      j = 1;
      str2 = paramString;
      paramString = localFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + j + ")" + str1;
        paramString = new File(str2);
        j += 1;
      }
      label161:
      localObject1 = paramString.substring(j);
    }
    return str2;
  }
  
  public static String kX(String paramString)
  {
    if (kP == null)
    {
      kP = new HashMap();
      kP.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
      kP.put("OnlinePreViewLocalPreviewFunctionalSwitch", "0");
      kP.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
      kP.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
      kP.put("OnlinePreViewAutoPreview3GMaxSize", "0");
      kP.put("OnlinePreViewAutoPreviewWiFiGroupMaxSize", "1000");
      kP.put("OnlinePreViewAutoPreview3GGroupMaxSize", "0");
      kP.put("OnlinePreViewdocFileMaxSize", "10");
      kP.put("OnlinePreViewdocFileType", "1");
      kP.put("OnlinePreViewdocInterfacePage", "qq_document_previewer_v2.html");
      kP.put("OnlinePreViewdocPreviewMode", "0");
      kP.put("OnlinePreViewdocxFileMaxSize", "10");
      kP.put("OnlinePreViewdocxFileType", "2");
      kP.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer_v2.html");
      kP.put("OnlinePreViewdocxPreviewMode", "0");
      kP.put("OnlinePreViewrtfFileMaxSize", "10");
      kP.put("OnlinePreViewrtfFileType", "7");
      kP.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer_v2.html");
      kP.put("OnlinePreViewrtfPreviewMode", "0");
      kP.put("OnlinePreViewpptFileMaxSize", "10");
      kP.put("OnlinePreViewpptFileType", "5");
      kP.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer_v2.html");
      kP.put("OnlinePreViewpptPreviewMode", "4");
      kP.put("OnlinePreViewpptxFileMaxSize", "10");
      kP.put("OnlinePreViewpptxFileType", "6");
      kP.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer_v2.html");
      kP.put("OnlinePreViewpptxPreviewMode", "5");
      kP.put("OnlinePreViewpdfFileMaxSize", "10");
      kP.put("OnlinePreViewpdfFileType", "8");
      kP.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer_v2.html");
      kP.put("OnlinePreViewpdfPreviewMode", "3");
      kP.put("OnlinePreViewzipFileMaxSize", "100");
      kP.put("OnlinePreViewzipFileType", "13");
      kP.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer_v2.html");
      kP.put("OnlinePreViewzipPreviewMode", "1");
      kP.put("OnlinePreViewrarFileMaxSize", "100");
      kP.put("OnlinePreViewrarFileType", "14");
      kP.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer_v2.html");
      kP.put("OnlinePreViewrarPreviewMode", "1");
      kP.put("OnlinePreView7zFileMaxSize", "100");
      kP.put("OnlinePreView7zFileType", "15");
      kP.put("OnlinePreView7zInterfacePage", "qq_compress_previewer_v2.html");
      kP.put("OnlinePreView7zPreviewMode", "1");
      kP.put("OnlinePreViewtxtFileMaxSize", "10");
      kP.put("OnlinePreViewtxtFileType", "16");
      kP.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer_v2.html");
      kP.put("OnlinePreViewtxtPreviewMode", "2");
      kP.put("OfflineConfigFlowSize", "1024");
      kP.put("OfflineConfigFlowTime", "30");
      kP.put("OfflineConfigFtnThumbMaxSize", "32768");
    }
    String str = (String)kP.get(paramString);
    if ((str == null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil<FileAssistant>", 2, "key[" + paramString + "],value null!");
    }
    return str;
  }
  
  public static String kY(String paramString)
  {
    int j = 3;
    String str;
    if ((paramString == null) || (paramString.length() == 0))
    {
      str = "";
      return str;
    }
    boolean bool = mH(paramString);
    if (acej.aV() >= 20.0F) {
      if (bool) {
        j = 7;
      }
    }
    for (;;)
    {
      str = paramString;
      if (paramString.length() <= 16 - j) {
        break;
      }
      int k = paramString.length();
      str = paramString.substring(0, (16 - j) / 2);
      paramString = paramString.substring(k - (16 - j) / 2);
      return str + "..." + paramString;
      if (acej.aV() >= 18.0F)
      {
        if (bool) {
          j = 5;
        } else {
          j = 2;
        }
      }
      else if (acej.aV() >= 17.0F)
      {
        if (!bool) {
          j = 1;
        }
      }
      else {
        j = 0;
      }
    }
  }
  
  public static String kZ(String paramString)
  {
    int j = 0;
    String str;
    if (paramString == null)
    {
      str = "";
      return str;
    }
    label180:
    for (;;)
    {
      try
      {
        ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(paramString.length());
        str = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        if (!paramString.equals(null))
        {
          int k = 0;
          if (k < paramString.length())
          {
            if (j <= "AnDrDQ_Fm_String".length() - 1) {
              break label180;
            }
            j %= "AnDrDQ_Fm_String".length();
            int n = paramString.codePointAt(k) + "AnDrDQ_Fm_String".codePointAt(j);
            int m = n;
            if (n > 65535) {
              m = n % 65535;
            }
            localByteArrayBuffer.append(m);
            k += 1;
            j += 1;
            continue;
          }
        }
        paramString = HexUtil.bytes2HexStr(localByteArrayBuffer.toByteArray());
        str = "#_#" + paramString + "O_O";
        break;
      }
      finally {}
    }
  }
  
  public static String lb(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int j = paramString.lastIndexOf(".");
    if ((j > 0) && (j < paramString.length() - 1)) {
      return paramString.substring(j + 1).toUpperCase();
    }
    return "";
  }
  
  public static String lc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.replace("ftn_compress_getfile", "ftn_compress_getabs");
    return paramString + "size=750&";
  }
  
  public static boolean mH(String paramString)
  {
    return Pattern.compile("[一-龥]").matcher(paramString).find();
  }
  
  public static boolean mI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static String mapToJson(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
  
  public static void n(long paramLong, int paramInt, String paramString)
  {
    FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().b(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              switch (localFileManagerEntity.nOpType)
              {
              case -1: 
              default: 
                return;
              }
            } while (B(paramInt, localFileManagerEntity.fileName));
            if ((paramString == null) || (paramString.length() <= 0)) {
              break;
            }
            JI(paramString);
            return;
            if ((paramString != null) && (paramString.length() > 0))
            {
              JI(paramString);
              return;
            }
          } while (B(paramInt, localFileManagerEntity.fileName));
          B(13, localFileManagerEntity.fileName);
          return;
        } while (B(paramInt, localFileManagerEntity.fileName));
        if ((paramString != null) && (paramString.length() > 0))
        {
          JI(paramString);
          return;
        }
        JI(kY(localFileManagerEntity.fileName) + BaseApplicationImpl.getContext().getString(2131694100));
        return;
      } while (B(paramInt, localFileManagerEntity.fileName));
      if ((paramString != null) && (paramString.length() > 0))
      {
        JI(paramString);
        return;
      }
      B(17, localFileManagerEntity.fileName);
      return;
    } while (B(paramInt, localFileManagerEntity.fileName));
    if ((paramString != null) && (paramString.length() > 0))
    {
      JI(paramString);
      return;
    }
    B(11, localFileManagerEntity.fileName);
    return;
    if ((paramString != null) && (paramString.length() > 0))
    {
      JI(paramString);
      return;
    }
    B(13, localFileManagerEntity.fileName);
    return;
    B(13, localFileManagerEntity.fileName);
    return;
    B(paramInt, null);
  }
  
  public static boolean o(FileManagerEntity paramFileManagerEntity)
  {
    long l2 = 604800000L;
    if (paramFileManagerEntity == null) {
      return false;
    }
    long l3 = paramFileManagerEntity.srvTime;
    long l1 = l2;
    switch (paramFileManagerEntity.peerType)
    {
    }
    for (l1 = l2; l1 + l3 <= anaz.gQ() * 1000L; l1 = 2592000000L) {
      return true;
    }
    return false;
  }
  
  public static boolean q(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {}
    do
    {
      do
      {
        return false;
      } while (paramFileManagerEntity.isZipInnerFile);
      switch (b(paramFileManagerEntity))
      {
      case 5: 
      case 7: 
      case 8: 
      default: 
        return false;
      case 1: 
      case 2: 
      case 4: 
      case 9: 
        return true;
      }
    } while (paramFileManagerEntity.nFileType != 0);
    return true;
    if (paramFileManagerEntity.nFileType == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static int r(String paramString)
  {
    paramString = aueh.getExtension(paramString);
    if (paramString == null) {
      return 2130845244;
    }
    return hL(ahav.getFileType(paramString));
  }
  
  public static byte[] t(String paramString)
  {
    return a(paramString, getFileSizes(paramString));
  }
  
  public static String ti()
  {
    for (;;)
    {
      try
      {
        localObject1 = Thread.getAllStackTraces();
        localObject4 = Thread.currentThread();
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          localObject4 = Looper.getMainLooper().getThread().getStackTrace();
          int k = localObject4.length;
          localObject1 = "";
          j = 0;
          localObject5 = localObject1;
          if (j >= k) {
            continue;
          }
          localObject5 = localObject4[j];
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        int j;
        localObject4 = "";
        localObject4 = (String)localObject4 + "printStack Exception:";
        Object localObject5 = (String)localObject4 + localException1.toString();
        QLog.e("FMERROR", 1, localException1.toString());
        return localObject5;
      }
      finally {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FMERROR", 1, ((StackTraceElement)localObject5).toString());
        }
        localObject5 = (String)localObject1 + ((StackTraceElement)localObject5).toString() + "\n";
        j += 1;
        localObject1 = localObject5;
      }
      catch (Exception localException2)
      {
        localObject4 = localObject2;
        Object localObject3 = localException2;
        continue;
      }
      localObject4 = (StackTraceElement[])((Map)localObject1).get(localObject4);
    }
  }
  
  public static String wc()
  {
    return audn.a().vZ();
  }
  
  /* Error */
  public static byte[] x(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 140	java/io/BufferedInputStream
    //   5: dup
    //   6: new 142	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 147	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray byte
    //   23: astore 4
    //   25: ldc 126
    //   27: invokestatic 132	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   30: astore_2
    //   31: aload_0
    //   32: aload 4
    //   34: invokevirtual 159	java/io/InputStream:read	([B)I
    //   37: istore_1
    //   38: iload_1
    //   39: ifle +39 -> 78
    //   42: aload_2
    //   43: aload 4
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 163	java/security/MessageDigest:update	([BII)V
    //   50: goto -19 -> 31
    //   53: astore_2
    //   54: aload_3
    //   55: astore_2
    //   56: aload_0
    //   57: ifnull +9 -> 66
    //   60: aload_0
    //   61: invokevirtual 178	java/io/InputStream:close	()V
    //   64: aload_3
    //   65: astore_2
    //   66: aload_2
    //   67: areturn
    //   68: astore_2
    //   69: aload_2
    //   70: invokevirtual 138	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   73: aconst_null
    //   74: astore_2
    //   75: goto -44 -> 31
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 178	java/io/InputStream:close	()V
    //   86: aload_2
    //   87: ifnull +25 -> 112
    //   90: aload_2
    //   91: invokevirtual 182	java/security/MessageDigest:digest	()[B
    //   94: astore_2
    //   95: aload_2
    //   96: astore_3
    //   97: aload_3
    //   98: astore_2
    //   99: aload_0
    //   100: ifnull -34 -> 66
    //   103: aload_0
    //   104: invokevirtual 178	java/io/InputStream:close	()V
    //   107: aload_3
    //   108: areturn
    //   109: astore_0
    //   110: aload_3
    //   111: areturn
    //   112: aload_3
    //   113: astore_2
    //   114: aload_0
    //   115: ifnull -49 -> 66
    //   118: aload_0
    //   119: invokevirtual 178	java/io/InputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: aconst_null
    //   126: areturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_3
    //   131: astore_2
    //   132: aload_0
    //   133: ifnull -67 -> 66
    //   136: aload_0
    //   137: invokevirtual 178	java/io/InputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_0
    //   143: aconst_null
    //   144: areturn
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: ifnull +7 -> 156
    //   152: aload_0
    //   153: invokevirtual 178	java/io/InputStream:close	()V
    //   156: aload_2
    //   157: athrow
    //   158: astore 4
    //   160: goto -74 -> 86
    //   163: astore_0
    //   164: aconst_null
    //   165: areturn
    //   166: astore_0
    //   167: goto -11 -> 156
    //   170: astore_2
    //   171: goto -23 -> 148
    //   174: astore_2
    //   175: goto -45 -> 130
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_0
    //   181: goto -127 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   37	10	1	j	int
    //   30	13	2	localMessageDigest	java.security.MessageDigest
    //   53	1	2	localFileNotFoundException	FileNotFoundException
    //   55	12	2	localObject1	Object
    //   68	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   74	58	2	localObject2	Object
    //   145	12	2	localObject3	Object
    //   170	1	2	localObject4	Object
    //   174	1	2	localIOException1	IOException
    //   1	130	3	localObject5	Object
    //   23	21	4	arrayOfByte	byte[]
    //   158	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   18	25	53	java/io/FileNotFoundException
    //   25	31	53	java/io/FileNotFoundException
    //   31	38	53	java/io/FileNotFoundException
    //   42	50	53	java/io/FileNotFoundException
    //   69	73	53	java/io/FileNotFoundException
    //   82	86	53	java/io/FileNotFoundException
    //   90	95	53	java/io/FileNotFoundException
    //   25	31	68	java/security/NoSuchAlgorithmException
    //   103	107	109	java/io/IOException
    //   118	122	124	java/io/IOException
    //   2	18	127	java/io/IOException
    //   136	140	142	java/io/IOException
    //   2	18	145	finally
    //   82	86	158	java/io/IOException
    //   60	64	163	java/io/IOException
    //   152	156	166	java/io/IOException
    //   18	25	170	finally
    //   25	31	170	finally
    //   31	38	170	finally
    //   42	50	170	finally
    //   69	73	170	finally
    //   82	86	170	finally
    //   90	95	170	finally
    //   18	25	174	java/io/IOException
    //   25	31	174	java/io/IOException
    //   31	38	174	java/io/IOException
    //   42	50	174	java/io/IOException
    //   69	73	174	java/io/IOException
    //   90	95	174	java/io/IOException
    //   2	18	178	java/io/FileNotFoundException
  }
  
  public static class a
  {
    static Executor executor;
    
    static
    {
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.poolThreadName = "fileassistant_pool";
      localThreadPoolParams.corePoolsize = 2;
      localThreadPoolParams.maxPooolSize = 2;
      localThreadPoolParams.priority = 8;
      localThreadPoolParams.queue = new LinkedBlockingQueue();
      localThreadPoolParams.keepAliveTime = 10;
      executor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
    }
    
    public static Executor getExecutor()
    {
      return executor;
    }
  }
  
  public static abstract interface b
  {
    public abstract void p(Bitmap paramBitmap);
  }
  
  public static abstract interface c
  {
    public abstract void onClick(View paramView);
  }
  
  public static abstract interface d
  {
    public abstract void euA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     audx
 * JD-Core Version:    0.7.0.1
 */