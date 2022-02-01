import android.os.Handler;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.PicUploadInfo.1;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class akxy
  extends akxh
{
  public akwt.a a;
  public akxx a;
  public akxy.b a;
  public long aeH;
  public long aeI;
  public long aeJ;
  public long aeK;
  public long aeL;
  public long aeM;
  public PhotoSendParams b;
  public String bUM;
  public int ceG;
  public boolean cuY = true;
  public boolean cuZ;
  public boolean cva;
  public boolean cvb;
  public boolean cvc;
  public int dpI;
  public int dpJ;
  public int dpK;
  public int dpL;
  public int dpM;
  public int dpN;
  public int entrance = 0;
  public int extLong;
  public String extStr;
  public int from;
  public String iconUrl;
  public int imageBizType;
  public boolean isBlessPic;
  public boolean isQzonePic;
  public boolean isStoryPhoto;
  public String localPath;
  public Object message;
  public String packageName;
  public int protocolType = -1;
  public String source;
  public boolean sync2Story;
  public int thumbHeight;
  public String thumbPath;
  public int thumbWidth;
  public int topicId;
  public String webUrl;
  public ArrayList<Integer> yv;
  
  public boolean check()
  {
    int i = 1;
    if (this.isQzonePic)
    {
      if ((this.b == null) || (TextUtils.isEmpty(this.b.rawMd5)) || (!aqhq.fileExistsAndNotEmpty(this.b.thumbPath)))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("qzone md5 invalid, md5:");
        if (this.b != null) {}
        for (localObject = this.b.rawMd5;; localObject = "")
        {
          gT("checkPicInfo", (String)localObject);
          return false;
        }
      }
      if (((this.uinType == 1000) || (this.uinType == 1020) || (this.uinType == 1004)) && (this.bUG == null))
      {
        gT("checkPicInfo", "secondId invalid,uinType:" + this.uinType + ",secondId:" + this.bUG);
        return false;
      }
      if (getProtocolType() == -1)
      {
        gT("PicBaseInfo.check", "protocolType invalid,protocolType:" + this.protocolType);
        return false;
      }
      return super.check();
    }
    if (!aqhq.fileExistsAndNotEmpty(this.localPath))
    {
      gT("checkPicInfo", "path invalid,localPath:" + this.localPath);
      return false;
    }
    if (((this.uinType == 1000) || (this.uinType == 1020) || (this.uinType == 1004)) && (this.bUG == null))
    {
      gT("checkPicInfo", "secondId invalid,uinType:" + this.uinType + ",secondId:" + this.bUG);
      return false;
    }
    if (getProtocolType() == -1)
    {
      gT("PicBaseInfo.check", "protocolType invalid,protocolType:" + this.protocolType);
      return false;
    }
    Object localObject = zxa.a(this.localPath);
    if (localObject != null)
    {
      if (this.protocolType == 1)
      {
        localObject = ((zxa)localObject).pZ();
        if (localObject != null) {
          this.localPath = ((String)localObject);
        }
      }
      while (i == 0)
      {
        ThreadManagerV2.getUIHandlerV2().post(new PicUploadInfo.1(this));
        return false;
        gT("PicBaseInfo.check", "incompatible photo generate jpg fail");
        for (;;)
        {
          i = 0;
          break;
          if (this.busiType != 1006) {
            break label477;
          }
          localObject = ((zxa)localObject).pZ();
          if (localObject != null)
          {
            this.localPath = ((String)localObject);
            break;
          }
          gT("PicBaseInfo.check", "incompatible photo generate jpg fail");
        }
        label477:
        gT("PicBaseInfo.check", "incompatible file,and not PROTOCOL_RAW_PIC:" + this.protocolType);
        i = 0;
      }
    }
    return super.check();
  }
  
  public int getProtocolType()
  {
    if (this.protocolType != -1) {
      return this.protocolType;
    }
    if (this.localPath != null)
    {
      if (GifDrawable.isGifFile(new File(this.localPath)))
      {
        this.protocolType = 0;
        return this.protocolType;
      }
    }
    else {
      akxe.b("PIC_TAG_ERROR", "PicUploadInfo.getProtocolType", "localPath == null");
    }
    if (this.ceG == 2) {}
    for (this.protocolType = 1;; this.protocolType = 0) {
      return this.protocolType;
    }
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.localPath);
    localStringBuilder.append("\n |-").append("protocolType:").append(this.protocolType);
    localStringBuilder.append("\n |-").append("md5:").append(this.md5);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.ceG);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.thumbPath);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.thumbWidth);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.thumbHeight);
    localStringBuilder.append("\n |-").append("source_image_width:").append(this.dpI);
    localStringBuilder.append("\n |-").append("source_image_height:").append(this.dpJ);
    localStringBuilder.append("\n |-").append("source_image_filesize:").append(this.aeI);
    localStringBuilder.append("\n |-").append("source_image_filesizeflag:").append(this.dpK);
    localStringBuilder.append("\n |-").append("source_image_type:").append(this.dpL);
    localStringBuilder.append("\n |-").append("entrance:").append(this.entrance);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
  
  String xN()
  {
    int i = 65537;
    if (this.protocol == null)
    {
      akxe.b("PIC_TAG_ERROR", "PicUploadInfo.getUrlString", "protocol == null");
      return null;
    }
    if ("chatthumb".equals(this.protocol)) {}
    for (;;)
    {
      URL localURL = aoop.a(this, i, null);
      if (localURL == null) {
        break;
      }
      return localURL.toString();
      if ("chatimg".equals(this.protocol)) {
        i = 1;
      } else if ("chatraw".equals(this.protocol)) {
        i = 131075;
      }
    }
    return null;
  }
  
  public static class a
    extends akxy
  {
    public void DY(int paramInt)
    {
      this.thumbWidth = paramInt;
    }
    
    public void DZ(int paramInt)
    {
      this.thumbHeight = paramInt;
    }
    
    public void NP(String paramString)
    {
      this.peerUin = paramString;
    }
    
    public void NT(String paramString)
    {
      this.bUG = paramString;
    }
    
    public void Nv(boolean paramBoolean)
    {
      this.sync2Story = paramBoolean;
    }
    
    public void Nw(boolean paramBoolean)
    {
      this.isStoryPhoto = paramBoolean;
    }
    
    public void So(int paramInt)
    {
      this.busiType = paramInt;
    }
    
    public void Sp(int paramInt)
    {
      this.uinType = paramInt;
    }
    
    public void Sr(int paramInt)
    {
      this.ceG = paramInt;
    }
    
    public void Ss(int paramInt)
    {
      this.dpK = paramInt;
    }
    
    public void St(int paramInt)
    {
      this.topicId = paramInt;
    }
    
    public void Su(int paramInt)
    {
      this.imageBizType = paramInt;
    }
    
    public akxy a()
    {
      return this;
    }
    
    public void a(akxx paramakxx)
    {
      this.jdField_a_of_type_Akxx = paramakxx;
    }
    
    public void a(akxy.b paramb)
    {
      this.jdField_a_of_type_Akxy$b = paramb;
    }
    
    public void aA(String paramString)
    {
      this.thumbPath = paramString;
    }
    
    public void kc(String paramString)
    {
      this.selfUin = paramString;
    }
    
    public void kx(long paramLong)
    {
      this.aeM = paramLong;
    }
    
    public void setEntrance(int paramInt)
    {
      this.entrance = paramInt;
    }
    
    public void setFileSize(long paramLong)
    {
      this.aeI = paramLong;
    }
    
    public void setHeight(int paramInt)
    {
      this.dpJ = paramInt;
    }
    
    public void setImageType(int paramInt)
    {
      this.dpL = paramInt;
    }
    
    public void setLocalPath(String paramString)
    {
      this.localPath = paramString;
    }
    
    public void setMd5(String paramString)
    {
      this.md5 = paramString;
    }
    
    public void setProtocolType(int paramInt)
    {
      this.protocolType = paramInt;
    }
    
    public void setWidth(int paramInt)
    {
      this.dpI = paramInt;
    }
  }
  
  public static class b
  {
    public long msgUid;
    public long msgseq;
    public long shmsgseq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxy
 * JD-Core Version:    0.7.0.1
 */