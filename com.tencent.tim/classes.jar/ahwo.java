import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_ctrl.ResvResvInfo;
import org.json.JSONObject;

public class ahwo
{
  public static volatile boolean ciI;
  
  public static int Fp()
  {
    int i = 1;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication == null) {
      return 0;
    }
    if (e(localBaseApplication, 1)) {}
    for (;;)
    {
      int j = i;
      if (e(localBaseApplication, 2)) {
        j = i | 0x2;
      }
      return j;
      i = 0;
    }
  }
  
  public static Pair<StringBuilder, StringBuilder> a(Context paramContext, File paramFile)
  {
    if (ciI) {
      return null;
    }
    ciI = true;
    paramContext = rvx.a(Uri.parse("file://" + paramFile.getAbsolutePath()), paramContext);
    ciI = false;
    return paramContext;
  }
  
  public static msg_ctrl.MsgCtrl a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    msg_ctrl.MsgCtrl localMsgCtrl = new msg_ctrl.MsgCtrl();
    msg_ctrl.ResvResvInfo localResvResvInfo = new msg_ctrl.ResvResvInfo();
    Object localObject2;
    long l2;
    if ((ahwy.a().aoj()) && (!TextUtils.isEmpty(paramString)))
    {
      localHashMap.put("param_qO", "1");
      localHashMap.put("param_hU", "0");
      if (new File(paramString).exists())
      {
        localObject1 = null;
        l1 = System.currentTimeMillis();
        localObject2 = a(BaseApplicationImpl.getContext(), new File(paramString));
        l2 = System.currentTimeMillis();
        localHashMap.put("param_rqC", String.valueOf(l2 - l1));
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, rq tc = " + (l2 - l1));
        }
        if (localObject2 != null) {
          localObject1 = ((StringBuilder)((Pair)localObject2).first).toString();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, qu = " + (String)localObject1);
          }
          try
          {
            localObject1 = am((String)localObject1, 128);
            localResvResvInfo.bytes_reserv1.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set  r1 = " + (String)localObject1);
            }
            localHashMap.put("param_hU", "1");
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              int i;
              long l3;
              localException1.printStackTrace();
            }
          }
          if ((!ahwy.a().aol()) || (!aod())) {
            break label1258;
          }
          localHashMap.put("param_aPO", "1");
          l1 = System.currentTimeMillis();
          i = Fp();
          localResvResvInfo.uint32_flag.set(1);
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set f = 1");
          }
          localResvResvInfo.uint64_reserv2.set(i);
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set r2 = " + i);
          }
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, ap t c = " + (l2 - l1));
          }
          localHashMap.put("param_aPC", String.valueOf(l2 - l1));
          localHashMap.put("param_aI", String.valueOf(i));
          label440:
          if (!ahwy.a().aok()) {
            break label1403;
          }
          localHashMap.put("param_rEO", "1");
          l3 = System.currentTimeMillis();
          if ((JpegExifReader.isCrashJpeg(paramString)) || (!PhotoUtils.isJPEGImage(paramString))) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localExifInterface = new ExifInterface(paramString);
        l1 = 0L;
        if (!TextUtils.isEmpty(localExifInterface.getAttribute("GPSLatitude"))) {
          l1 = 0L | 1L;
        }
        paramString = localExifInterface.getAttribute("Make");
        l2 = l1;
        if (paramString != null)
        {
          l2 = l1;
          if (!TextUtils.isEmpty(paramString)) {
            l2 = l1 | 0x2;
          }
        }
        localResvResvInfo.uint64_reserv3.set(l2);
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set r3  = " + l2);
        }
        localHashMap.put("param_pF", String.valueOf(l2));
      }
      catch (Exception paramString)
      {
        ExifInterface localExifInterface;
        label683:
        paramString.printStackTrace();
        continue;
        localHashMap.put("param_hasPL", "0");
        continue;
      }
      try
      {
        paramString = localExifInterface.getAttribute("DateTime");
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        i = (int)(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(paramString).getTime() / 1000L);
        localResvResvInfo.uint32_create_time.set(i);
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set ct  = " + i);
        }
        localHashMap.put("param_hPT", "1");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = localExifInterface.getAttribute("ImageDescription");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "decrip = " + (String)localObject2);
          }
          localObject1 = new JSONObject((String)localObject2);
          paramString = ((JSONObject)localObject1).getString("ImageLength");
        }
      }
      catch (Throwable localThrowable1)
      {
        label908:
        label914:
        label1007:
        str2 = null;
        paramString = null;
        continue;
      }
      try
      {
        localObject1 = ((JSONObject)localObject1).getString("ImageWidth");
        try
        {
          if (!TextUtils.isEmpty(paramString))
          {
            localResvResvInfo.uint32_pic_height.set(Integer.valueOf(paramString).intValue());
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set _pc  = " + Integer.valueOf(paramString));
            }
            localHashMap.put("param_hasPL", "1");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              continue;
            }
            localResvResvInfo.uint32_pic_width.set(Integer.valueOf((String)localObject1).intValue());
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set _pw  = " + Integer.valueOf((String)localObject1));
            }
            localHashMap.put("param_hasPW", "1");
            localObject2 = paramString;
            paramString = (String)localObject1;
            bool = TextUtils.isEmpty((CharSequence)localObject2);
            if (!bool) {}
          }
        }
        catch (Throwable localThrowable3)
        {
          boolean bool;
          localObject2 = localException1;
          str1 = paramString;
          paramString = (String)localObject2;
          localObject2 = localThrowable3;
        }
      }
      catch (Throwable localThrowable2)
      {
        str2 = paramString;
        paramString = null;
        continue;
      }
      try
      {
        localObject1 = localExifInterface.getAttribute("ImageLength");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localResvResvInfo.uint32_pic_height.set(Integer.valueOf((String)localObject1).intValue());
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set ph  = " + Integer.valueOf((String)localObject1));
        }
        localHashMap.put("param_hasPL", "1");
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        continue;
        localHashMap.put("param_hasPW", "0");
      }
    }
    bool = TextUtils.isEmpty(paramString);
    if (bool) {}
    try
    {
      paramString = localExifInterface.getAttribute("ImageWidth");
      if (TextUtils.isEmpty(paramString)) {
        break label1381;
      }
      localResvResvInfo.uint32_pic_width.set(Integer.valueOf(paramString).intValue());
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set pw  = " + Integer.valueOf(paramString));
      }
      localHashMap.put("param_hasPW", "1");
    }
    catch (Exception paramString)
    {
      label1381:
      for (;;)
      {
        label1258:
        paramString.printStackTrace();
      }
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, re, t c = " + (l1 - l3));
    }
    localHashMap.put("param_rEC", String.valueOf(l1 - l3));
    for (;;)
    {
      localMsgCtrl.resv_resv_info.set(localResvResvInfo);
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set ri");
      }
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "act_getMsgCtrlForPicMsg", true, 0L, 0L, localHashMap, "");
      return localMsgCtrl;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, u null");
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("CheckForward.JumpShareUtils", 1, "file not exists!");
      break;
      localHashMap.put("param_qO", "0");
      break;
      localHashMap.put("param_aPO", "0");
      break label440;
      localHashMap.put("param_hPT", "0");
      break label683;
      String str1;
      ((Throwable)localObject2).printStackTrace();
      localObject2 = str1;
      break label914;
      localHashMap.put("param_hasPW", "0");
      break label908;
      localHashMap.put("param_hasPL", "0");
      break label1007;
      label1403:
      localHashMap.put("param_rEO", "0");
    }
  }
  
  public static msg_ctrl.MsgCtrl a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    msg_ctrl.MsgCtrl localMsgCtrl = new msg_ctrl.MsgCtrl();
    msg_ctrl.ResvResvInfo localResvResvInfo = new msg_ctrl.ResvResvInfo();
    Object localObject = paramString2;
    if (paramString2 == null) {
      if (TextUtils.isEmpty(paramString1)) {
        break label455;
      }
    }
    label187:
    label449:
    label455:
    for (localObject = new File(paramString1);; localObject = null)
    {
      if ((localObject == null) || (!((File)localObject).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("CheckForward.JumpShareUtils", 1, "file not exists!");
        }
        return null;
      }
      if (ahwy.a().aom())
      {
        localObject = a(BaseApplicationImpl.getContext(), (File)localObject);
        if (localObject == null)
        {
          localObject = paramString2;
          if (QLog.isColorLevel())
          {
            QLog.w("CheckForward.JumpShareUtils", 1, "calc file faild!");
            localObject = paramString2;
          }
          paramString2 = am((String)localObject, 128);
          if (TextUtils.isEmpty(paramString2)) {
            break label449;
          }
          localResvResvInfo.bytes_reserv1.set(ByteStringMicro.copyFromUtf8(paramString2));
        }
      }
      for (int j = 1;; j = 0)
      {
        int i;
        if ((ahwy.a().aoo()) && (aod()))
        {
          localResvResvInfo.uint32_flag.set(1);
          localResvResvInfo.uint64_reserv2.set(Fp());
          i = 1;
          if (!ahwy.a().aon()) {
            break label411;
          }
          paramString2 = e(paramString1);
          if (paramString2 != null)
          {
            localResvResvInfo.uint64_reserv3.set(((Integer)paramString2.first).intValue());
            localResvResvInfo.uint32_create_time.set(((Integer)paramString2.second).intValue());
          }
          if (paramInt1 != 0)
          {
            j = paramInt1;
            i = paramInt2;
            if (paramInt2 != 0) {}
          }
          else
          {
            paramString1 = d(paramString1);
            j = paramInt1;
            i = paramInt2;
            if (paramString1 != null)
            {
              j = ((Integer)paramString1.first).intValue();
              i = ((Integer)paramString1.second).intValue();
            }
          }
          localResvResvInfo.uint32_pic_width.set(j);
          localResvResvInfo.uint32_pic_height.set(i);
          paramInt1 = 1;
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            break label436;
          }
          return null;
          if (((Pair)localObject).first != null)
          {
            localObject = ((StringBuilder)((Pair)localObject).first).toString();
            break;
          }
          localObject = "";
          break;
          paramString2 = "";
          localObject = paramString2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
          localObject = paramString2;
          break;
          i = j;
          if (!QLog.isColorLevel()) {
            break label187;
          }
          QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
          i = j;
          break label187;
          paramInt1 = i;
          if (QLog.isColorLevel())
          {
            QLog.i("IMG_FILE_QR", 1, "ZhuoXusManager exif switch is false!");
            paramInt1 = i;
          }
        }
        localMsgCtrl.resv_resv_info.set(localResvResvInfo);
        return localMsgCtrl;
      }
    }
  }
  
  private static String am(String paramString, int paramInt)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        i = paramString.getBytes("UTF-8").length;
        if (i < paramInt) {}
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i;
        for (;;)
        {
          StringBuffer localStringBuffer;
          char c;
          int k;
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
    localStringBuffer = new StringBuffer();
    i = 0;
    if (i < paramInt)
    {
      c = paramString.charAt(i);
      localStringBuffer.append(c);
    }
    try
    {
      k = String.valueOf(c).getBytes("UTF-8").length;
      j += k;
      if (j <= paramInt) {
        break label118;
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static boolean aod()
  {
    Object localObject = ahwy.a();
    if (!((ahwy)localObject).aoi()) {}
    String str;
    do
    {
      return false;
      str = ((ahwy)localObject).wK();
      localObject = ((ahwy)localObject).wL();
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)));
    return true;
  }
  
  public static Pair<Integer, Integer> d(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.JumpShareUtils", 2, "getImgFileWH " + i + " | " + j);
      }
      paramString = new Pair(Integer.valueOf(i), Integer.valueOf(j));
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  private static Pair<Integer, Integer> e(String paramString)
  {
    m = 0;
    if (JpegExifReader.isCrashJpeg(paramString)) {
      return null;
    }
    if (!PhotoUtils.isJPEGImage(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new ExifInterface(paramString);
        bool = TextUtils.isEmpty(paramString.getAttribute("GPSLatitude"));
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        boolean bool;
        int j;
        int k;
        SimpleDateFormat localSimpleDateFormat;
        long l;
        int i = 0;
        continue;
        i = 0;
        continue;
      }
      try
      {
        bool = TextUtils.isEmpty(paramString.getAttribute("Make"));
        if (bool) {
          continue;
        }
        i |= 0x2;
      }
      catch (Exception paramString)
      {
        continue;
        continue;
      }
      try
      {
        paramString = paramString.getAttribute("DateTime");
        j = m;
        k = i;
        if (!TextUtils.isEmpty(paramString)) {
          localSimpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        j = m;
        k = i;
        continue;
      }
      try
      {
        l = localSimpleDateFormat.parse(paramString).getTime() / 1000L;
        j = (int)l;
        k = i;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        j = m;
        k = i;
      }
    }
    return new Pair(Integer.valueOf(k), Integer.valueOf(j));
  }
  
  public static boolean e(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return false;
    }
    ahwy localahwy = ahwy.a();
    if (!localahwy.aoi()) {
      return false;
    }
    String str = null;
    if (paramInt == 1) {
      str = localahwy.wK();
    }
    while (TextUtils.isEmpty(str))
    {
      return false;
      if (paramInt == 2) {
        str = localahwy.wL();
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 256);
      if (paramContext != null) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label72:
      break label72;
    }
  }
  
  /* Error */
  public static String getSHA1(String paramString)
  {
    // Byte code:
    //   0: new 471	java/io/BufferedInputStream
    //   3: dup
    //   4: new 473	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 474	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 477	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 10240
    //   19: newarray byte
    //   21: astore_3
    //   22: ldc_w 479
    //   25: invokestatic 485	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore_2
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 491	java/io/InputStream:read	([B)I
    //   34: istore_1
    //   35: iload_1
    //   36: ifle +34 -> 70
    //   39: aload_2
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_1
    //   43: invokevirtual 495	java/security/MessageDigest:update	([BII)V
    //   46: goto -17 -> 29
    //   49: astore_2
    //   50: aload_0
    //   51: ifnull +7 -> 58
    //   54: aload_0
    //   55: invokevirtual 498	java/io/InputStream:close	()V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_2
    //   61: aload_2
    //   62: invokevirtual 499	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   65: aconst_null
    //   66: astore_2
    //   67: goto -38 -> 29
    //   70: aload_0
    //   71: ifnull +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 498	java/io/InputStream:close	()V
    //   78: aload_2
    //   79: ifnull +53 -> 132
    //   82: aload_2
    //   83: invokevirtual 503	java/security/MessageDigest:digest	()[B
    //   86: invokestatic 509	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   89: astore_2
    //   90: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +29 -> 122
    //   96: ldc 127
    //   98: iconst_2
    //   99: new 25	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 511
    //   109: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_2
    //   113: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 498	java/io/InputStream:close	()V
    //   130: aload_2
    //   131: areturn
    //   132: aload_0
    //   133: ifnull -75 -> 58
    //   136: aload_0
    //   137: invokevirtual 498	java/io/InputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_0
    //   143: aconst_null
    //   144: areturn
    //   145: astore_0
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: ifnull -91 -> 58
    //   152: aload_0
    //   153: invokevirtual 498	java/io/InputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_0
    //   159: aconst_null
    //   160: areturn
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 498	java/io/InputStream:close	()V
    //   172: aload_2
    //   173: athrow
    //   174: astore_3
    //   175: goto -97 -> 78
    //   178: astore_0
    //   179: goto -49 -> 130
    //   182: astore_0
    //   183: aconst_null
    //   184: areturn
    //   185: astore_0
    //   186: goto -14 -> 172
    //   189: astore_2
    //   190: goto -26 -> 164
    //   193: astore_2
    //   194: goto -46 -> 148
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_0
    //   200: goto -150 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramString	String
    //   34	9	1	i	int
    //   28	12	2	localMessageDigest	java.security.MessageDigest
    //   49	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   60	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   66	65	2	str	String
    //   161	12	2	localObject1	Object
    //   189	1	2	localObject2	Object
    //   193	1	2	localThrowable	Throwable
    //   21	20	3	arrayOfByte	byte[]
    //   174	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   16	22	49	java/io/FileNotFoundException
    //   22	29	49	java/io/FileNotFoundException
    //   29	35	49	java/io/FileNotFoundException
    //   39	46	49	java/io/FileNotFoundException
    //   61	65	49	java/io/FileNotFoundException
    //   74	78	49	java/io/FileNotFoundException
    //   82	122	49	java/io/FileNotFoundException
    //   22	29	60	java/security/NoSuchAlgorithmException
    //   136	140	142	java/io/IOException
    //   0	16	145	java/lang/Throwable
    //   152	156	158	java/io/IOException
    //   0	16	161	finally
    //   74	78	174	java/io/IOException
    //   126	130	178	java/io/IOException
    //   54	58	182	java/io/IOException
    //   168	172	185	java/io/IOException
    //   16	22	189	finally
    //   22	29	189	finally
    //   29	35	189	finally
    //   39	46	189	finally
    //   61	65	189	finally
    //   74	78	189	finally
    //   82	122	189	finally
    //   16	22	193	java/lang/Throwable
    //   22	29	193	java/lang/Throwable
    //   29	35	193	java/lang/Throwable
    //   39	46	193	java/lang/Throwable
    //   61	65	193	java/lang/Throwable
    //   74	78	193	java/lang/Throwable
    //   82	122	193	java/lang/Throwable
    //   0	16	197	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwo
 * JD-Core Version:    0.7.0.1
 */