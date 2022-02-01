package com.tencent.qqmail.popularize.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class Popularize
  implements Comparable<Popularize>
{
  public static final String TAG = "Popularize";
  private String abstracts;
  private int action;
  private String adXml;
  private PopularizeAppConfig appConfig;
  private int appInstallAction;
  private String avatar_url;
  private String avatar_url_md5;
  private double bannerHeight;
  private int bannerPosition;
  private boolean commercialConfigHead;
  private boolean commercialConfigList;
  private boolean commercialConfigMark;
  private boolean commercialConfigTool;
  private String commercialFromEmail;
  private String commercialFromNick;
  private int condition;
  private String content;
  private double duration;
  private double endTime;
  private int id;
  private String imageMd5;
  private String imageUrl;
  private boolean isCancel;
  private boolean isClick;
  private boolean isOpen;
  private boolean isPopByNewMail;
  private boolean isRead = false;
  private boolean isRender;
  private boolean isStop;
  private long lastRenderTime;
  private int move;
  private boolean needQQAccount;
  private boolean needWifi;
  private String openUrl;
  private int page;
  private String popularizeAppName;
  private String popularizeAppVersion;
  private int productId;
  private int relatedId;
  private int reportId;
  private int resourceType;
  private int serverId;
  private int sessionType;
  private int showType;
  private double startTime;
  private String subImageMd5;
  private String subImageUrl;
  private String subInformation;
  private String subInformationData;
  private ArrayList<PopularizeSubItem> subItems;
  private String sub_abstracts;
  private String sub_fromnick;
  private String sub_subject;
  private String subject;
  private int turnId;
  private int type;
  private int weight;
  
  public static int generateId(int paramInt1, int paramInt2, int paramInt3)
  {
    return QMMath.hashPositivetInt(paramInt1 + ":" + paramInt2 + ":" + paramInt3);
  }
  
  public int compareTo(Popularize paramPopularize)
  {
    return getServerId() - paramPopularize.getServerId();
  }
  
  public String getAbstracts()
  {
    return this.abstracts;
  }
  
  public int getAction()
  {
    return this.action;
  }
  
  public String getAdXml()
  {
    return this.adXml;
  }
  
  public PopularizeAppConfig getAppConfig()
  {
    return this.appConfig;
  }
  
  public int getAppInstallAction()
  {
    return this.appInstallAction;
  }
  
  public String getAvatar_url()
  {
    return this.avatar_url;
  }
  
  public String getAvatar_url_md5()
  {
    return this.avatar_url_md5;
  }
  
  public double getBannerHeight()
  {
    return this.bannerHeight;
  }
  
  public int getBannerPosition()
  {
    return this.bannerPosition;
  }
  
  public CommercialAdvertiseEnum getCommercialAdvertiseType()
  {
    if (this.type != 9) {
      return CommercialAdvertiseEnum.UNKNOWN;
    }
    if (TextUtils.isEmpty(this.adXml)) {
      return CommercialAdvertiseEnum.VIRTURE_MAIL;
    }
    if (!TextUtils.isEmpty(this.avatar_url))
    {
      Bitmap localBitmap = PopularizeThumbManager.sharedInstance().getPopularizeThumb(this.avatar_url);
      QMLog.log(4, "Popularize", "Avatar for maillist ads = " + localBitmap);
      if (localBitmap == null) {
        PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(getAvatar_url(), getAvatar_url_md5(), null);
      }
      if ((!TextUtils.isEmpty(this.sub_abstracts)) && (!TextUtils.isEmpty(this.sub_fromnick)) && (!TextUtils.isEmpty(this.sub_subject)) && (localBitmap != null)) {
        return CommercialAdvertiseEnum.NATIVE_ADS_PRO;
      }
      return CommercialAdvertiseEnum.NATIVE_ADS;
    }
    return CommercialAdvertiseEnum.NATIVE_ADS;
  }
  
  public String getCommercialFromEmail()
  {
    return this.commercialFromEmail;
  }
  
  public String getCommercialFromNick()
  {
    return this.commercialFromNick;
  }
  
  public int getCondition()
  {
    return this.condition;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public double getDuration()
  {
    return this.duration;
  }
  
  public double getEndTime()
  {
    return this.endTime;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getImageMd5()
  {
    return this.imageMd5;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public long getLastRenderTime()
  {
    return this.lastRenderTime;
  }
  
  public int getMove()
  {
    return this.move;
  }
  
  public String getOpenUrl()
  {
    return this.openUrl;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public String getPopularizeAppName()
  {
    return this.popularizeAppName;
  }
  
  public String getPopularizeAppVersion()
  {
    return this.popularizeAppVersion;
  }
  
  public int getProductId()
  {
    return this.productId;
  }
  
  public int getRelatedId()
  {
    return this.relatedId;
  }
  
  public int getReportId()
  {
    return this.reportId;
  }
  
  public int getResourceType()
  {
    return this.resourceType;
  }
  
  public int getServerId()
  {
    return this.serverId;
  }
  
  public int getSessionType()
  {
    return this.sessionType;
  }
  
  public int getShowType()
  {
    return this.showType;
  }
  
  public double getStartTime()
  {
    return this.startTime;
  }
  
  public String getSubImageMd5()
  {
    return this.subImageMd5;
  }
  
  public String getSubImageUrl()
  {
    return this.subImageUrl;
  }
  
  public String getSubInformation()
  {
    return this.subInformation;
  }
  
  public String getSubInformationData()
  {
    return this.subInformationData;
  }
  
  public ArrayList<PopularizeSubItem> getSubItems()
  {
    return this.subItems;
  }
  
  public String getSub_abstracts()
  {
    return this.sub_abstracts;
  }
  
  public String getSub_fromnick()
  {
    return this.sub_fromnick;
  }
  
  public String getSub_subject()
  {
    return this.sub_subject;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public int getTurnId()
  {
    return this.turnId;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getWeight()
  {
    return this.weight;
  }
  
  public boolean isCancel()
  {
    return this.isCancel;
  }
  
  public boolean isClick()
  {
    return this.isClick;
  }
  
  public boolean isCommercialConfigHead()
  {
    return this.commercialConfigHead;
  }
  
  public boolean isCommercialConfigList()
  {
    return this.commercialConfigList;
  }
  
  public boolean isCommercialConfigMark()
  {
    return this.commercialConfigMark;
  }
  
  public boolean isCommercialConfigTool()
  {
    return this.commercialConfigTool;
  }
  
  public boolean isExpire()
  {
    long l1 = System.currentTimeMillis();
    long l2 = getStartTime();
    long l3 = getEndTime();
    return (l2 * 1000L > l1) || (l1 >= l3 * 1000L);
  }
  
  public boolean isFutureOrCurrentPopularize()
  {
    return System.currentTimeMillis() < getEndTime() * 1000L;
  }
  
  public boolean isNeedQQAccount()
  {
    return this.needQQAccount;
  }
  
  public boolean isNeedWifi()
  {
    return this.needWifi;
  }
  
  public boolean isOpen()
  {
    return this.isOpen;
  }
  
  public boolean isPopByNewMail()
  {
    return this.isPopByNewMail;
  }
  
  public boolean isRead()
  {
    return this.isRead;
  }
  
  public boolean isRender()
  {
    return this.isRender;
  }
  
  public boolean isStop()
  {
    return this.isStop;
  }
  
  public void setAbstracts(String paramString)
  {
    this.abstracts = paramString;
  }
  
  public void setAction(int paramInt)
  {
    this.action = paramInt;
  }
  
  public void setAdXml(String paramString)
  {
    this.adXml = paramString;
  }
  
  public void setAppConfig(PopularizeAppConfig paramPopularizeAppConfig)
  {
    this.appConfig = paramPopularizeAppConfig;
  }
  
  public void setAppInstallAction(int paramInt)
  {
    this.appInstallAction = paramInt;
  }
  
  public void setAvatar_url(String paramString)
  {
    this.avatar_url = paramString;
  }
  
  public void setAvatar_url_md5(String paramString)
  {
    this.avatar_url_md5 = paramString;
  }
  
  public void setBannerHeight(double paramDouble)
  {
    this.bannerHeight = paramDouble;
  }
  
  public void setBannerPosition(int paramInt)
  {
    this.bannerPosition = paramInt;
  }
  
  public void setCancel(boolean paramBoolean)
  {
    this.isCancel = paramBoolean;
  }
  
  public void setClick(boolean paramBoolean)
  {
    this.isClick = paramBoolean;
  }
  
  public void setCommercialConfigHead(boolean paramBoolean)
  {
    this.commercialConfigHead = paramBoolean;
  }
  
  public void setCommercialConfigList(boolean paramBoolean)
  {
    this.commercialConfigList = paramBoolean;
  }
  
  public void setCommercialConfigMark(boolean paramBoolean)
  {
    this.commercialConfigMark = paramBoolean;
  }
  
  public void setCommercialConfigTool(boolean paramBoolean)
  {
    this.commercialConfigTool = paramBoolean;
  }
  
  public void setCommercialFromEmail(String paramString)
  {
    this.commercialFromEmail = paramString;
  }
  
  public void setCommercialFromNick(String paramString)
  {
    this.commercialFromNick = paramString;
  }
  
  public void setCondition(int paramInt)
  {
    this.condition = paramInt;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setDuration(double paramDouble)
  {
    this.duration = paramDouble;
  }
  
  public void setEndTime(double paramDouble)
  {
    this.endTime = paramDouble;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImageMd5(String paramString)
  {
    this.imageMd5 = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public void setIsOpen(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
  }
  
  public void setIsRead(boolean paramBoolean)
  {
    this.isRead = paramBoolean;
  }
  
  public void setLastRenderTime(long paramLong)
  {
    this.lastRenderTime = paramLong;
  }
  
  public void setMove(int paramInt)
  {
    this.move = paramInt;
  }
  
  public void setNeedQQAccount(boolean paramBoolean)
  {
    this.needQQAccount = paramBoolean;
  }
  
  public void setNeedWifi(boolean paramBoolean)
  {
    this.needWifi = paramBoolean;
  }
  
  public void setOpenUrl(String paramString)
  {
    this.openUrl = paramString;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setPopByNewMail(boolean paramBoolean)
  {
    this.isPopByNewMail = paramBoolean;
  }
  
  public void setPopularizeAppName(String paramString)
  {
    this.popularizeAppName = paramString;
  }
  
  public void setPopularizeAppVersion(String paramString)
  {
    this.popularizeAppVersion = paramString;
  }
  
  public void setProductId(int paramInt)
  {
    this.productId = paramInt;
  }
  
  public void setRelatedId(int paramInt)
  {
    this.relatedId = paramInt;
  }
  
  public void setRender(boolean paramBoolean)
  {
    this.isRender = paramBoolean;
  }
  
  public void setReportId(int paramInt)
  {
    this.reportId = paramInt;
  }
  
  public void setResourceType(int paramInt)
  {
    this.resourceType = paramInt;
  }
  
  public void setServerId(int paramInt)
  {
    this.serverId = paramInt;
  }
  
  public void setSessionType(int paramInt)
  {
    this.sessionType = paramInt;
  }
  
  public void setShowType(int paramInt)
  {
    this.showType = paramInt;
  }
  
  public void setStartTime(double paramDouble)
  {
    this.startTime = paramDouble;
  }
  
  public void setStop(boolean paramBoolean)
  {
    this.isStop = paramBoolean;
  }
  
  public void setSubImageMd5(String paramString)
  {
    this.subImageMd5 = paramString;
  }
  
  public void setSubImageUrl(String paramString)
  {
    this.subImageUrl = paramString;
  }
  
  public void setSubInformation(String paramString)
  {
    this.subInformation = paramString;
  }
  
  public void setSubInformationData(String paramString)
  {
    this.subInformationData = paramString;
  }
  
  public void setSubItems(ArrayList<PopularizeSubItem> paramArrayList)
  {
    this.subItems = paramArrayList;
  }
  
  public void setSub_abstracts(String paramString)
  {
    this.sub_abstracts = paramString;
  }
  
  public void setSub_fromnick(String paramString)
  {
    this.sub_fromnick = paramString;
  }
  
  public void setSub_subject(String paramString)
  {
    this.sub_subject = paramString;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setTurnId(int paramInt)
  {
    this.turnId = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setWeight(int paramInt)
  {
    this.weight = paramInt;
  }
  
  public String toString()
  {
    return "Popularize{id=" + this.id + ", serverId=" + this.serverId + ", reportId=" + this.reportId + ", type=" + this.type + ", page=" + this.page + ", bannerPosition=" + this.bannerPosition + ", bannerHeight=" + this.bannerHeight + ", showType=" + this.showType + ", action=" + this.action + ", imageUrl='" + this.imageUrl + '\'' + ", imageMd5='" + this.imageMd5 + '\'' + ", openUrl='" + this.openUrl + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", duration=" + this.duration + ", subject='" + this.subject + '\'' + ", abstracts='" + this.abstracts + '\'' + ", content='" + this.content + '\'' + ", subInformation='" + this.subInformation + '\'' + ", subInformationData='" + this.subInformationData + '\'' + ", subImageUrl='" + this.subImageUrl + '\'' + ", subImageMd5='" + this.subImageMd5 + '\'' + ", needQQAccount=" + this.needQQAccount + ", isRender=" + this.isRender + ", isClick=" + this.isClick + ", isCancel=" + this.isCancel + ", isOpen=" + this.isOpen + ", needWifi=" + this.needWifi + ", popularizeAppName='" + this.popularizeAppName + '\'' + ", appInstallAction=" + this.appInstallAction + ", popularizeAppVersion='" + this.popularizeAppVersion + '\'' + ", weight=" + this.weight + ", lastRenderTime=" + this.lastRenderTime + ", subItems=" + this.subItems + ", relatedId=" + this.relatedId + ", condition=" + this.condition + ", move=" + this.move + ", resourceType=" + this.resourceType + ", commercialFromEmail='" + this.commercialFromEmail + '\'' + ", commercialFromNick='" + this.commercialFromNick + '\'' + ", commercialConfigHead=" + this.commercialConfigHead + ", commercialConfigTool=" + this.commercialConfigTool + ", commercialConfigList=" + this.commercialConfigList + ", commercialConfigMark=" + this.commercialConfigMark + ", isRead=" + this.isRead + ", sessionType=" + this.sessionType + ", appConfig=" + this.appConfig + ", avatar_url='" + this.avatar_url + '\'' + ", avatar_url_md5='" + this.avatar_url_md5 + '\'' + ", isPopByNewMail=" + this.isPopByNewMail + ", isStop=" + this.isStop + ", sub_fromnick='" + this.sub_fromnick + '\'' + ", sub_subject='" + this.sub_subject + '\'' + ", sub_abstracts='" + this.sub_abstracts + '\'' + ", adXml='" + this.adXml + '\'' + ", turnId=" + this.turnId + ", productId=" + this.productId + '}';
  }
  
  public void updateAbstractsReplacement(@NonNull String paramString1, String paramString2)
  {
    if (getAbstracts().contains(paramString1))
    {
      paramString1 = Matcher.quoteReplacement(paramString1);
      setAbstracts(getAbstracts().replaceAll(paramString1, paramString2));
    }
  }
  
  public void updateContentReplacement(@NonNull String paramString1, String paramString2)
  {
    if (getContent().contains(paramString1))
    {
      paramString1 = Matcher.quoteReplacement(paramString1);
      setContent(getContent().replaceAll(paramString1, paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.model.Popularize
 * JD-Core Version:    0.7.0.1
 */