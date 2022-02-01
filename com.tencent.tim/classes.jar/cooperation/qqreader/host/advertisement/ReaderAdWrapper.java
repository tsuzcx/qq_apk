package cooperation.qqreader.host.advertisement;

import android.text.TextUtils;
import aqiz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo;
import tgg;

public class ReaderAdWrapper
{
  public static final int PRODUCT_TYPE_APP = 12;
  private List<ImageData> LE = new ArrayList();
  private String Wb;
  private ImageData a;
  private long azH;
  private long azI = -1L;
  private int bQs;
  private GdtAd c;
  private String cMh;
  private String cMi;
  private String cMj;
  private boolean dnz;
  private ReaderAdWrapper e;
  private boolean gr;
  private long mCreateTime;
  private String mImageUrl;
  private String mVideoUrl;
  
  ReaderAdWrapper(GdtAd paramGdtAd, String paramString)
  {
    this.cMh = paramString;
    this.c = paramGdtAd;
    this.azH = this.c.getAId();
    paramGdtAd = this.c.getImageData();
    if (paramGdtAd != null)
    {
      this.mImageUrl = paramGdtAd.url;
      this.a = new ImageData(paramGdtAd);
    }
    this.mVideoUrl = this.c.getVideoUrl();
    this.Wb = this.c.getText();
    this.cMj = this.c.getUrlForImpression();
    if (!this.c.info.display_info.button_info.get().isEmpty()) {
      this.cMi = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)this.c.info.display_info.button_info.get(0)).txt.get();
    }
    int i = 0;
    while (i < this.c.info.display_info.muti_pic_text_info.image.size())
    {
      paramGdtAd = this.c.getImageData(i);
      if ((paramGdtAd != null) && (paramGdtAd.isValid())) {
        this.LE.add(new ImageData(paramGdtAd));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(this.mVideoUrl)) {
      bool = true;
    }
    this.dnz = bool;
    this.mCreateTime = new Date().getTime();
  }
  
  GdtAd a()
  {
    return this.c;
  }
  
  public long getAId()
  {
    return this.azH;
  }
  
  public ImageData getBasicImageData()
  {
    return this.a;
  }
  
  public String getExposureReportUrl()
  {
    return this.cMj;
  }
  
  public ReaderAdWrapper getExtraData()
  {
    return this.e;
  }
  
  public String getImageUrl()
  {
    return this.mImageUrl;
  }
  
  public List<ImageData> getMultiImageData()
  {
    return this.LE;
  }
  
  public String getPosId()
  {
    return this.cMh;
  }
  
  public String getProcessedBtnTxt()
  {
    if (isAppType())
    {
      if (isAdAppInstalled()) {
        return "立即打开";
      }
      return "立即下载";
    }
    if (TextUtils.isEmpty(this.cMi)) {
      return "查看详情";
    }
    return this.cMi;
  }
  
  public String getTxt()
  {
    return this.Wb;
  }
  
  public int getUsedCount()
  {
    return this.bQs;
  }
  
  public long getVideoStartPos()
  {
    return this.azI;
  }
  
  public String getVideoUrl()
  {
    return this.mVideoUrl;
  }
  
  public void increaseUsedCount()
  {
    this.bQs += 1;
  }
  
  public boolean isAdAppInstalled()
  {
    return aqiz.isAppInstalled(BaseApplicationImpl.getApplication().getBaseContext(), this.c.getAppPackageName());
  }
  
  public boolean isAppType()
  {
    return this.c.getProductType() == 12;
  }
  
  public boolean isDataValid()
  {
    return this.c != null;
  }
  
  public boolean isExpired()
  {
    return new Date().getTime() - this.mCreateTime > 3600000L;
  }
  
  public boolean isLocalBook()
  {
    return this.gr;
  }
  
  public boolean isVideoAd()
  {
    return this.dnz;
  }
  
  public void setExtraData(ReaderAdWrapper paramReaderAdWrapper)
  {
    this.e = paramReaderAdWrapper;
  }
  
  public void setLocalBook(boolean paramBoolean)
  {
    this.gr = paramBoolean;
  }
  
  public void setVideoStartPos(long paramLong)
  {
    this.azI = paramLong;
  }
  
  public static class ImageData
  {
    public int height;
    public String url;
    public int width;
    
    ImageData(tgg paramtgg)
    {
      this.url = paramtgg.url;
      this.width = paramtgg.width;
      this.height = paramtgg.height;
    }
    
    public boolean isValid()
    {
      return (!TextUtils.isEmpty(this.url)) && (this.width >= 0) && (this.height >= 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderAdWrapper
 * JD-Core Version:    0.7.0.1
 */