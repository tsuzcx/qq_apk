import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class mqw
  extends mqv
{
  private Long E = Long.valueOf(0L);
  private Long F = Long.valueOf(0L);
  aool a;
  private String ajB;
  private String ajC;
  aook c = new mqx(this);
  private String mImagePath;
  private String mImageUrl;
  private long wn;
  private long wo;
  private long wp;
  private long wq;
  
  public mqw(Context paramContext, QQAppInterface paramQQAppInterface, mqv.a parama)
  {
    super(paramContext, paramQQAppInterface, parama);
  }
  
  private void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    sk(paramInt);
    sl(paramInt);
    if (this.b != null) {
      this.b.e(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  private void rS(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = this.wo;
    long l2 = this.wn;
    anpc localanpc = anpc.a(this.context);
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void sk(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("cover_size_before_compression", this.E.toString());
    localHashMap.put("cover_size_after_compression", this.F.toString());
    anpc localanpc = anpc.a(this.context);
    String str = kxm.getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyDeliverVideoCompressCover", bool, this.wo - this.wn, 0L, localHashMap, "");
      return;
    }
  }
  
  private void sl(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    anpc localanpc = anpc.a(this.context);
    String str = kxm.getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyDeliverVideoUploadCover", bool, this.wp - this.wq, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "startUploadPic path=" + paramString);
    }
    this.ajC = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "startUploadPic empty path!");
      }
      f(1001, null, null, null);
      return;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "startUploadPic file not exist, path=" + paramString);
      }
      f(1002, null, null, null);
      return;
    }
    this.E = Long.valueOf(((File)localObject).length());
    if (!jqi.isNetworkAvailable(this.context))
    {
      f(1003, null, null, null);
      return;
    }
    this.mImagePath = "";
    this.ajB = "";
    this.mImageUrl = "";
    this.wn = System.currentTimeMillis();
    localObject = new CompressInfo(paramString, paramInt);
    ((CompressInfo)localObject).picType = 0;
    if (!akyj.b((CompressInfo)localObject)) {
      rS(1001);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "startUploadPic compressPath=" + ((CompressInfo)localObject).destPath + ", originPath=" + paramString + ", outWidth=" + ((CompressInfo)localObject).dpx + ", outHeight=" + ((CompressInfo)localObject).dpy);
    }
    if (TextUtils.isEmpty(((CompressInfo)localObject).destPath)) {}
    for (;;)
    {
      this.mImagePath = paramString;
      this.F = Long.valueOf(new File(this.mImagePath).length());
      this.wo = System.currentTimeMillis();
      paramString = this.app.a();
      this.c.addFilter(new Class[] { aojg.class });
      paramString.a(this.c);
      this.a = new aool();
      this.a.cNy = true;
      this.a.dOM = 10;
      this.a.dQ = this.mImagePath;
      this.a.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.a.mPeerUin = "0";
      this.a.mFileType = 24;
      this.a.ckW = "KandianUGCPicUpload";
      paramString.a(this.a);
      return;
      paramString = ((CompressInfo)localObject).destPath;
    }
  }
  
  public void ah(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, 0);
  }
  
  public void onDestroy()
  {
    this.app.a().b(this.c);
    if ((!TextUtils.isEmpty(this.ajC)) && (!TextUtils.isEmpty(this.mImagePath)) && (!this.ajC.equals(this.mImagePath)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "clearTempFile(image), origin:" + this.ajC + ", compress:" + this.mImagePath);
      }
      File localFile = new File(this.mImagePath);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqw
 * JD-Core Version:    0.7.0.1
 */