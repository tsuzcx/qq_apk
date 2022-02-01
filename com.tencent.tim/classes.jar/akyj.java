import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class akyj
{
  private static List<String> EI;
  private static final String ERR_MSG = BaseApplication.getContext().getString(2131691943);
  
  private static akyl a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo != null) {}
    switch (paramCompressInfo.picType)
    {
    default: 
      return null;
    case 0: 
      if (paramCompressInfo.busiType == 1035) {
        return new akyq(paramCompressInfo);
      }
      if (paramCompressInfo.busiType == 1036) {
        return new akyn(paramCompressInfo);
      }
      return new akyp(paramCompressInfo);
    case 1: 
      return new akyo(paramCompressInfo);
    }
    return new akym(paramCompressInfo);
  }
  
  private static void a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.srcPath)) || (TextUtils.isEmpty(paramCompressInfo.destPath))) {
      akxe.b("CompressOperator", " checkAndLog()", "info == null || TextUtils.isEmpty(info.srcPath) || TextUtils.isEmpty(info.destPath)");
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        akxe.a("CompressOperator", paramCompressInfo.localUUID + " checkAndLog()", paramCompressInfo.toString());
        if (!paramCompressInfo.isSuccess) {
          break;
        }
      } while (paramBoolean);
      l1 = akyr.getFileSize(paramCompressInfo.srcPath);
      l2 = akyr.getFileSize(paramCompressInfo.destPath);
      akxe.a("CompressOperator", paramCompressInfo.localUUID + " checkAndLog()", "src File size:" + l1);
      akxe.a("CompressOperator", paramCompressInfo.localUUID + " checkAndLog()", "dest File size:" + l2);
    } while ((l1 <= 0L) || (l2 <= l1));
    if (zxa.iC(paramCompressInfo.srcPath))
    {
      akxe.a("CompressOperator", paramCompressInfo.localUUID + " checkAndLog()", "src is incompatible ,keep compress file");
      return;
    }
    if (l1 > 1024L)
    {
      aqhq.estimateFileType(paramCompressInfo.srcPath);
      akxe.a("CompressOperator", paramCompressInfo.localUUID + " checkAndLog()", ERR_MSG);
      paramCompressInfo.bUE = ("CompressOperator" + paramCompressInfo.localUUID + " checkAndLog()" + ERR_MSG);
      aqhq.deleteFile(paramCompressInfo.destPath);
      if (EI == null) {
        EI = new ArrayList();
      }
      if (!EI.contains(paramBoolean + paramCompressInfo.srcPath)) {
        EI.add(paramBoolean + paramCompressInfo.srcPath);
      }
      paramCompressInfo.destPath = paramCompressInfo.srcPath;
      akxe.b("CompressOperator", paramCompressInfo.localUUID + " checkAndLog()", " destSize > srcSize, info.destPath = info.srcPath");
      return;
    }
    akxe.a("CompressOperator", paramCompressInfo.localUUID + " checkAndLog()", "src length is too small");
    paramBoolean = "MI 6".equals(Build.MODEL);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "SendPicSrcProblem", paramBoolean, 0L, l1, null, "");
    return;
    paramCompressInfo.destPath = paramCompressInfo.srcPath;
    akxe.b("CompressOperator", paramCompressInfo.localUUID + " checkAndLog()", "info.isSuccess = false, info.destPath = info.srcPath");
  }
  
  private static boolean a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo == null) || (!aqhq.fileExistsAndNotEmpty(paramCompressInfo.srcPath)))
    {
      akxe.b("CompressOperator", " startImpl()", "info == null || TextUtils.isEmpty(info.srcPath)");
      return false;
    }
    Object localObject;
    if ((EI != null) && (EI.contains(paramBoolean + paramCompressInfo.srcPath)))
    {
      akxe.a("CompressOperator", paramCompressInfo.localUUID + " startImpl()", ERR_MSG);
      paramCompressInfo.bUE = ("CompressOperator" + paramCompressInfo.localUUID + " startImpl()" + ERR_MSG);
      paramCompressInfo.destPath = paramCompressInfo.srcPath;
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramCompressInfo.destPath, (BitmapFactory.Options)localObject);
      paramCompressInfo.dpx = ((BitmapFactory.Options)localObject).outWidth;
      paramCompressInfo.dpy = ((BitmapFactory.Options)localObject).outHeight;
      return true;
    }
    paramCompressInfo.networkType = aqiw.getNetworkType(BaseApplication.getContext());
    if (akyr.lP(paramCompressInfo.srcPath))
    {
      paramCompressInfo.picType = 2;
      if (QLog.isColorLevel()) {
        akxe.a("CompressOperator", " startImpl()", "info:" + paramCompressInfo);
      }
      localObject = a(paramCompressInfo);
      if (!paramBoolean) {
        break label335;
      }
    }
    label335:
    for (boolean bool = ((akyl)localObject).asV();; bool = ((akyl)localObject).start())
    {
      paramCompressInfo.isSuccess = bool;
      a(paramCompressInfo, paramBoolean);
      if (paramCompressInfo.destPath != null)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
      try
      {
        aqhu.d(paramCompressInfo.destPath, (BitmapFactory.Options)localObject);
        paramCompressInfo.dpx = ((BitmapFactory.Options)localObject).outWidth;
        paramCompressInfo.dpy = ((BitmapFactory.Options)localObject).outHeight;
        return paramCompressInfo.isSuccess;
      }
      catch (OutOfMemoryError paramCompressInfo) {}
      if (PhotoUtils.ip(paramCompressInfo.srcPath))
      {
        paramCompressInfo.picType = 1;
        break;
      }
      paramCompressInfo.picType = 0;
      break;
    }
    return false;
  }
  
  public static boolean b(CompressInfo paramCompressInfo)
  {
    boolean bool1;
    if (paramCompressInfo == null) {
      bool1 = false;
    }
    long l1;
    boolean bool2;
    do
    {
      return bool1;
      akxe.a("CompressOperator", paramCompressInfo.localUUID + " CompressOperator.start()", "processName = " + BaseApplicationImpl.sApplication.getQQProcessName() + ",srcPath = " + paramCompressInfo.srcPath);
      l1 = System.currentTimeMillis();
      int i = tzc.a().a(0, 1, 1, Process.myTid(), 2000, 203, 128L, Process.myTid(), "sendPic", true);
      bool2 = a(paramCompressInfo, false);
      long l2 = System.currentTimeMillis();
      paramCompressInfo = null;
      if (tzc.a().isSupported())
      {
        paramCompressInfo = new HashMap();
        paramCompressInfo.put("hcState", String.valueOf(tzc.a().getState()));
        paramCompressInfo.put("model", Build.MODEL);
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "AIOPicCompress", bool2, l2 - l1, 0L, paramCompressInfo, "");
      if (i != 0) {
        tzc.a().stop(i);
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("CompressOperator", 2, "pic compress cost=" + (System.currentTimeMillis() - l1));
    return bool2;
  }
  
  public static boolean c(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    akxe.a("CompressOperator", paramCompressInfo.localUUID + " startThumbnail()", "");
    return a(paramCompressInfo, true);
  }
  
  public static int iA(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    default: 
      return 0;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyj
 * JD-Core Version:    0.7.0.1
 */