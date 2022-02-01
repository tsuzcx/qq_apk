import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager.2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class afgw
  extends affy<CameraEmotionData>
{
  private acck b = new afgx(this);
  private volatile String bDn = "";
  volatile String bDo = null;
  private volatile boolean bXZ;
  HashMap<CameraEmotionData, afgw.a> kk = new HashMap();
  
  public afgw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.mApp.addObserver(this.b);
  }
  
  protected int CR()
  {
    return 70;
  }
  
  public void HQ(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "";; str = "has_value")
    {
      this.bDo = str;
      aqfe.J(this.mApp.getApp().getApplicationContext(), this.mApp.getCurrentUin() + "camera_emo_guide_tag", this.bDo);
      return;
    }
  }
  
  public void HR(String paramString)
  {
    if (paramString == null) {
      return;
    }
    aqfe.J(this.mApp.getApp().getApplicationContext(), this.mApp.getCurrentUin() + "camera_emo_list_version", paramString);
    this.bDn = paramString;
  }
  
  protected acdd<CameraEmotionData> a()
  {
    return (accj)this.mApp.getBusinessHandler(160);
  }
  
  protected affx<CameraEmotionData> a()
  {
    return (afhc)this.mApp.getManager(333);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData)
  {
    if (this.mApp == null)
    {
      QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start, app is null");
      b(100, paramCameraEmotionData);
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start, net not support");
      b(12, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start");
    aool localaool = new aool();
    localaool.mFileType = 24;
    localaool.dOM = 70;
    localaool.ckW = "camera_emo_upload";
    localaool.mSelfUin = this.uin;
    localaool.mPeerUin = this.uin;
    localaool.cNy = true;
    localaool.mUniseq = paramCameraEmotionData.emoId;
    localaool.dQ = paramCameraEmotionData.emoPath;
    Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
    localCommFileExtReq.uint32_action_type.set(0);
    localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramCameraEmotionData.resid.getBytes()));
    localaool.gb = localCommFileExtReq.toByteArray();
    paramCameraEmotionData = new afgy(this, ThreadManagerV2.getSubThreadLooper(), paramCameraEmotionData);
    paramCameraEmotionData.addFilter(new Class[] { aojg.class });
    this.mApp.a().a(paramCameraEmotionData);
    this.mApp.a().a(localaool);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, afgw.a parama)
  {
    if (aqmr.isEmpty(paramCameraEmotionData.emoPath))
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo error, path is null");
      parama.c(10, paramCameraEmotionData);
      return;
    }
    if (this.mApp == null)
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo, app is null");
      parama.c(100, paramCameraEmotionData);
      return;
    }
    long l = getFileLength(paramCameraEmotionData.emoPath);
    aasq localaasq = b(paramCameraEmotionData.emoPath);
    if ((aqmr.isEmpty(paramCameraEmotionData.md5)) || (l == 0L) || (localaasq.getHeight() == 0) || (localaasq.getWidth() == 0))
    {
      QLog.d("CameraEmoRoamingManager", 1, new Object[] { "uploadCameraEmo params error, md5:", paramCameraEmotionData.md5, " size:", Long.valueOf(l), " width:", Integer.valueOf(localaasq.getWidth()), " height:", Integer.valueOf(localaasq.getHeight()) });
      parama.c(14, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo start");
    this.kk.put(paramCameraEmotionData, parama);
    ((accj)this.mApp.getBusinessHandler(160)).a(paramCameraEmotionData, localaasq.getWidth(), localaasq.getHeight(), l);
  }
  
  public boolean ajj()
  {
    if ((this.bDo == null) && (this.mApp != null))
    {
      this.bDo = aqfe.get(this.mApp.getApp().getApplicationContext(), this.mApp.getCurrentUin() + "camera_emo_guide_tag");
      if (this.bDo == null) {
        this.bDo = "";
      }
    }
    return (aqmr.isEmpty(this.bDo)) && (ajk());
  }
  
  public boolean ajk()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public aasq b(String paramString)
  {
    int j = 0;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    label53:
    for (;;)
    {
      try
      {
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = localOptions.outHeight;
        int k;
        QLog.e("CameraEmoRoamingManager", 1, "getImageSize has exception", paramString);
      }
      catch (Exception paramString)
      {
        try
        {
          k = localOptions.outWidth;
          j = k;
          return new aasq(j, i);
        }
        catch (Exception paramString)
        {
          break label53;
        }
        paramString = paramString;
        i = 0;
      }
    }
  }
  
  public void b(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    afgw.a locala = (afgw.a)this.kk.get(paramCameraEmotionData);
    if (locala != null)
    {
      locala.c(paramInt, paramCameraEmotionData);
      this.kk.remove(paramCameraEmotionData);
    }
  }
  
  public void b(CameraEmotionData paramCameraEmotionData)
  {
    paramCameraEmotionData.increaseClickNum();
    a().b(paramCameraEmotionData);
  }
  
  public void c(CameraEmotionData paramCameraEmotionData)
  {
    paramCameraEmotionData.increaseExposeNum();
    a().b(paramCameraEmotionData);
  }
  
  public void cZq()
  {
    if (this.mApp == null) {}
    accj localaccj;
    do
    {
      return;
      localaccj = (accj)this.mApp.getBusinessHandler(160);
    } while (localaccj == null);
    ThreadManager.post(new CameraEmoRoamingManager.2(this, (afhc)this.mApp.getManager(333), localaccj), 5, null, true);
  }
  
  public long getFileLength(String paramString)
  {
    long l = 0L;
    try
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        l = paramString.length();
      }
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.b != null) && (this.mApp != null)) {
      this.mApp.removeObserver(this.b);
    }
    Iterator localIterator = this.kk.entrySet().iterator();
    while (localIterator.hasNext()) {
      b(15, (CameraEmotionData)((Map.Entry)localIterator.next()).getKey());
    }
    this.kk.clear();
    this.mApp = null;
  }
  
  public String us()
  {
    if (!this.bXZ)
    {
      this.bDn = aqfe.get(this.mApp.getApp().getApplicationContext(), this.mApp.getCurrentUin() + "camera_emo_list_version");
      this.bXZ = true;
    }
    return this.bDn;
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt, CameraEmotionData paramCameraEmotionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgw
 * JD-Core Version:    0.7.0.1
 */