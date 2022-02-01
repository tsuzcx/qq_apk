package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class EmoticonPackage
  extends Entity
  implements Serializable
{
  public static final int BUSINESS_GUIDE_FLAG = 4;
  public static final String EMOTION_RSC_TYPE = "rscType";
  public static final int EmoticonPkgNeverUpdateBit = 2;
  public static final int EmoticonPkgRedPointBit = 4;
  public static final int EmoticonPkgUpdateBit = 1;
  public static final int FEE_TYEE_ACTIVITY = 6;
  public static final int FEE_TYEE_FREE = 1;
  public static final int FEE_TYEE_LIMIT_FREE = 3;
  public static final int FEE_TYEE_PAY = 2;
  public static final int FEE_TYEE_SVIP = 5;
  public static final int FEE_TYEE_VIP = 4;
  public static final int JOB_H5_MAGIC = 5;
  public static final int JOB_MAGIC = 3;
  public static final int JOB_NORMAL = 0;
  public static final int JOB_QFACE = 2;
  public static final int JOB_QFACE_MATERIAL = 1;
  public static final int JOB_SMALL = 4;
  public static final String MAGIC_FACE_EPID = "100000";
  public static final int ORIGINAL_FLAG = 1;
  public static final int RSC_TYPE_APNG = 2;
  public static final int RSC_TYPE_GIF = 0;
  public static final int RSC_TYPE_PNGZIP = 1;
  public static final int RSC_TYPE_UNKNOWN = -1;
  public static final int SUBTYPE_DIY = 4;
  public static final int SUBTYPE_SOUND = 1;
  public static final int TAB_TYPE_GIF = 3;
  public static final int TAB_TYPE_H5_MAGIC = 4;
  public static final int TAB_TYPE_MAGIC = 1;
  public static final int TAB_TYPE_PNG = 2;
  public static final int TYPE_MAGIC = 1;
  public static final int WIFI_AUTODOWNLOAD_CLOSE = -3;
  public static final int WIFI_AUTO_DOWNLOAD_FLAG = 2;
  private static final long serialVersionUID = -3944948432927289738L;
  public boolean aio;
  public String author;
  public long beginTime;
  public String businessExtra;
  public String buttonWording;
  public String childEpId;
  public String comeFom;
  public String copywritingContent;
  public int copywritingType;
  public String diversionName;
  public int downloadCount;
  public long endTime;
  @unique
  public String epId;
  public long expiretime;
  public int extraFlags;
  public String firstEmotionId;
  public boolean hasIpProduct;
  public boolean hasReadUpdatePage;
  public boolean hasSound;
  public String imageUrl;
  public String ipDetail;
  public String ipJumpUrl;
  public long ipLastReqTime;
  public String ipName;
  public String ipOpName;
  public long ipReqTime;
  public VipIPSiteInfo ipSiteInfo;
  public byte[] ipSiteInfoBytes;
  public String ipUrl;
  public int isAPNG;
  public boolean isMagicFaceDownloading;
  public boolean isRecommendation;
  public int jobType;
  @defaultzero
  public int jsonVersion;
  public String jumpUrl;
  public boolean kandian;
  public String kinId;
  public int latestVersion;
  public int localVersion;
  public String mark;
  public String minQQVersion;
  public int mobileFeetype;
  public String name;
  public boolean newSoundEp;
  public long richIPLastReqTime;
  public long richIPReqTime;
  public int rscType = 0;
  public int status;
  public int subType;
  public String supportSize;
  public int type;
  public int updateFlag;
  public String updateTip;
  public int upperLeftLable;
  public boolean valid;
  public long wordingId;
  
  public boolean isNewVoiceType()
  {
    return this.newSoundEp;
  }
  
  public String toString()
  {
    return "EmoticonPackage [epId=" + this.epId + ", wordingId=" + this.wordingId + ", childEpId=" + this.childEpId + ", minQQVersion=" + this.minQQVersion + ", name=" + this.name + ", mark=" + this.mark + ", type=" + this.type + ", author=" + this.author + ", expiretime=" + this.expiretime + ", status=" + this.status + ", hasSound=" + this.hasSound + ", jobType=" + this.jobType + ", kinId=" + this.kinId + ", valid=" + this.valid + ", downloadCount=" + this.downloadCount + ", mobileFeetype=" + this.mobileFeetype + ", isRecommendation=" + this.isRecommendation + ", isMagicFaceDownloading=" + this.isMagicFaceDownloading + ", firstEmotionId=" + this.firstEmotionId + ", upperLeftLable=" + this.upperLeftLable + ", localVersion=" + this.localVersion + ", latestVersion=" + this.latestVersion + ", jsonVersion=" + this.jsonVersion + ", updateFlag=" + this.updateFlag + ", updateTip=" + this.updateTip + ", hasReadUpdatePage=" + this.hasReadUpdatePage + ", rscType=" + this.rscType + ", supportSize=" + this.supportSize + ", isAPNG = " + this.isAPNG + "， aio =" + this.aio + ", kandian = " + this.kandian + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmoticonPackage
 * JD-Core Version:    0.7.0.1
 */