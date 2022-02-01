import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class mrf
  extends mqv
{
  private String Dh;
  private String ajD;
  private String ajE;
  private String ajF;
  aook jdField_b_of_type_Aook = new mrg(this);
  private aool jdField_b_of_type_Aool;
  private String mVideoPath;
  private long ww;
  private long wx;
  
  public mrf(Context paramContext, QQAppInterface paramQQAppInterface, mqv.a parama, String paramString)
  {
    super(paramContext, paramQQAppInterface, parama);
    this.mVideoPath = paramString;
  }
  
  private void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("VideoUploadController", 2, "finish: retCode - " + paramInt + " fileUrl : " + paramString1);
    this.wx = System.currentTimeMillis();
    sl(paramInt);
    if (this.jdField_b_of_type_Mqv$a != null) {
      this.jdField_b_of_type_Mqv$a.e(paramInt, paramString1, paramString2, paramString3);
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
      localanpc.collectPerformance(str, "actReadInJoyDeliverVideoUploadVideo", bool, this.wx - this.ww, 0L, localHashMap, "");
      return;
    }
  }
  
  public void ah(String paramString, boolean paramBoolean)
  {
    this.Dh = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "startUploadVideo path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo empty path!");
      }
      f(1001, null, null, null);
      return;
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo file not exist, path=" + paramString);
      }
      f(1002, null, null, null);
      return;
    }
    if (!aqiw.isNetworkAvailable(this.context))
    {
      QLog.d("VideoUploadController", 2, "upload: network not available");
      f(1003, null, null, null);
      return;
    }
    if ((!paramBoolean) && (!aqiw.isWifiConnected(this.context)))
    {
      QLog.d("VideoUploadController", 2, "upload: wifi not connected and not upload with mobile");
      return;
    }
    aooi localaooi = this.app.a();
    if (this.jdField_b_of_type_Aook.getFilter().size() == 0) {
      this.jdField_b_of_type_Aook.addFilter(new Class[] { aojg.class });
    }
    localaooi.a(this.jdField_b_of_type_Aook);
    if (this.jdField_b_of_type_Aool == null)
    {
      this.jdField_b_of_type_Aool = new aool();
      this.jdField_b_of_type_Aool.cNy = true;
      this.jdField_b_of_type_Aool.dOM = 54;
      this.jdField_b_of_type_Aool.dQ = paramString;
      this.jdField_b_of_type_Aool.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_b_of_type_Aool.mPeerUin = "0";
      this.jdField_b_of_type_Aool.mSelfUin = this.app.getCurrentAccountUin();
      this.jdField_b_of_type_Aool.mFileType = 24;
      this.jdField_b_of_type_Aool.ckW = "KandianUGCVideoUpload";
    }
    localaooi.a(this.jdField_b_of_type_Aool);
  }
  
  public void cancel()
  {
    super.cancel();
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "cancelUploadVideo");
    }
    Object localObject = this.app.a();
    if ((localObject != null) && (this.jdField_b_of_type_Aool != null))
    {
      localObject = (aojn)((aooi)localObject).a(this.jdField_b_of_type_Aool.mPeerUin, this.jdField_b_of_type_Aool.mUniseq);
      if (localObject != null)
      {
        ((aojn)localObject).cancel();
        this.jdField_b_of_type_Aool = null;
      }
    }
  }
  
  public void onDestroy()
  {
    this.app.a().b(this.jdField_b_of_type_Aook);
    ThreadManager.executeOnFileThread(new VideoUploadController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrf
 * JD-Core Version:    0.7.0.1
 */