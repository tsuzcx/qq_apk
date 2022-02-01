import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.picocr.PicOcrManager.3;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import mqq.manager.Manager;

public class ahqt
  implements Manager
{
  private ahqt.a a;
  protected aooi a;
  protected aook a;
  boolean chV = false;
  private HashMap<String, ahqy> le = new HashMap();
  private QQAppInterface mApp;
  protected String uin;
  
  public ahqt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aook = new ahqu(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Aooi = paramQQAppInterface.a();
    this.mApp = paramQQAppInterface;
    this.uin = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(ahqw paramahqw, ahqt.a parama)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(parama.imagePath, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramahqw = new File(parama.imagePath);
    long l = paramahqw.length();
    int i;
    if (l < 6750000L)
    {
      parama.fileSize = paramahqw.length();
      parama.daK = ((BitmapFactory.Options)localObject).outWidth;
      parama.daL = ((BitmapFactory.Options)localObject).outHeight;
      parama.bLr = parama.bLq;
      parama.compressPath = parama.imagePath;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + parama.tc() + ", oriLength:" + paramahqw.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      parama = new HashMap();
      parama.put("param_type", i + "");
      parama.put("param_length", paramahqw.length() / 1024L + "");
      parama.put("param_width", String.valueOf(j));
      parama.put("param_height", String.valueOf(k));
      parama.put("param_size", j * k + "");
      anpc.a(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressType", true, 0L, 0L, parama, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = ahqz.b(parama.imagePath, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        parama.compressPath = ahqz.a((Bitmap)localObject, parama.imagePath, arrayOfInt);
        if (!aqhq.fileExistsAndNotEmpty(parama.compressPath)) {
          break label671;
        }
        parama.daK = arrayOfInt[0];
        parama.daL = arrayOfInt[1];
        parama.fileSize = new File(parama.compressPath).length();
        parama.bLr = ahqz.calcMD5(parama.compressPath);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramahqw.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", parama.fileSize / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(parama.daK));
        ((HashMap)localObject).put("param_compheight", String.valueOf(parama.daL));
        ((HashMap)localObject).put("param_compsize", parama.daK * parama.daL + "");
        anpc.a(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public ahqy a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.le.containsKey(paramString))) {
      return (ahqy)this.le.get(paramString);
    }
    return null;
  }
  
  public void a(ahqt.a parama, ahqw paramahqw)
  {
    ThreadManager.excute(new PicOcrManager.3(this, parama, paramahqw), 64, null, true);
  }
  
  public void a(ahqw paramahqw, ahqt.a parama)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramahqw.onUpdate(100, false, new ahqy());
    }
    do
    {
      return;
      this.jdField_a_of_type_Ahqt$a = parama;
      if ((!this.chV) && (this.jdField_a_of_type_Aook != null) && (this.jdField_a_of_type_Aooi != null))
      {
        this.jdField_a_of_type_Aook.addFilter(new Class[] { aojg.class });
        this.jdField_a_of_type_Aooi.a(this.jdField_a_of_type_Aook);
        this.chV = true;
      }
      parama.aaN = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + parama.tc());
      }
      ahqv localahqv = new ahqv(this, paramahqw, parama);
      paramahqw = new aool();
      paramahqw.mFileType = 24;
      paramahqw.dOM = 76;
      paramahqw.ckW = "picorcupload";
      paramahqw.b = localahqv;
      paramahqw.dQ = parama.compressPath;
      paramahqw.mSelfUin = this.uin;
      paramahqw.mPeerUin = this.uin;
      paramahqw.mUniseq = parama.aaN;
      paramahqw.cNy = true;
      parama = new Bdh_extinfo.CommFileExtReq();
      parama.uint32_action_type.set(0);
      parama.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramahqw.gb = parama.toByteArray();
    } while (this.jdField_a_of_type_Aooi == null);
    this.jdField_a_of_type_Aooi.a(paramahqw);
  }
  
  public void a(String paramString, ahqy paramahqy)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str;
    if (this.le.size() >= 10)
    {
      Iterator localIterator = this.le.keySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (str.equals(paramString));
    }
    for (;;)
    {
      this.le.remove(str);
      if ((TextUtils.isEmpty(paramString)) || (paramahqy == null)) {
        break;
      }
      this.le.put(paramString, paramahqy);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aooi != null)
    {
      this.jdField_a_of_type_Aooi.b(this.jdField_a_of_type_Aook);
      this.jdField_a_of_type_Aook = null;
    }
  }
  
  public static class a
  {
    public boolean aIG;
    public long aaN;
    public String bLp;
    public String bLq;
    public String bLr;
    public String bLs;
    public int chatType;
    public String compressPath;
    public int daK;
    public int daL;
    public long fileSize;
    public String imagePath;
    
    public void Ku(String paramString)
    {
      this.bLp = paramString;
    }
    
    public void Kw(boolean paramBoolean)
    {
      this.aIG = paramBoolean;
    }
    
    public boolean anV()
    {
      return (this.daK > 0) && (this.daL > 0) && (aqhq.fileExistsAndNotEmpty(this.compressPath));
    }
    
    public void reset()
    {
      this.compressPath = "";
      this.imagePath = "";
      this.bLs = "";
      this.bLp = "";
      this.bLq = "";
      this.bLr = "";
      this.aIG = false;
      this.aaN = 0L;
      this.fileSize = 0L;
      this.daK = 0;
      this.daL = 0;
    }
    
    public void setPath(String paramString)
    {
      this.imagePath = paramString;
    }
    
    public String tc()
    {
      return "OCRReqContext{chatType=" + this.chatType + ", imagePath='" + this.imagePath + '\'' + ", compressPath='" + this.compressPath + '\'' + ", oriMd5='" + this.bLq + '\'' + ", comMd5='" + this.bLr + '\'' + ", hasCrop=" + this.aIG + '\'' + ", comWidth=" + this.daK + '\'' + ", comHeiht=" + this.daL + '\'' + ", serverUrl=" + this.bLs + '\'' + ", seqNumber=" + this.aaN + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqt
 * JD-Core Version:    0.7.0.1
 */