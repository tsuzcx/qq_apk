package com.tencent.biz.pubaccount;

import acff;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqnm;
import awit;
import ayxa;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import kcb;
import kcc;
import kcd;
import kce;
import kcf;
import kcg;
import kch;
import kci;
import kcj;
import kck;
import kcl;
import kcm;
import kcn;
import kco;
import muj;
import nss;
import org.json.JSONObject;
import wja;

public class VideoInfo
  implements Parcelable, nss
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new kcb();
  public HashSet<String> F = new HashSet();
  public String Gx;
  public String WA;
  public String WB;
  public String WC;
  public String WD;
  public String WE;
  public String WF;
  public String WG;
  public String WH;
  public String WI;
  public String WJ;
  public String Wz;
  public AdTagInfo a;
  public DownloadBarInfo a;
  public ECommerceEntranceInfo a;
  public InterruptedWeishiAd a;
  public LikeActionDownloadBar a;
  public SoftAdDownloadBarInfo a;
  public TopBarInfo a;
  public a a;
  public b a;
  public VideoColumnInfo a;
  public MessageForShortVideo a;
  public int aHb;
  public int aHc;
  public int aHd;
  public int aHe;
  public int aHf;
  public int aHg;
  public int aHh;
  public int aHi;
  public String accountName;
  public boolean adB;
  public boolean adC;
  public boolean adD;
  private boolean adE = true;
  public boolean adF = true;
  public boolean adG = true;
  public boolean adH;
  public boolean adI;
  public boolean adJ;
  public boolean adK;
  public boolean adL;
  public boolean adM;
  public int adsJumpType;
  public AdvertisementInfo advertisementInfo;
  public String aioShareUrl;
  public long algorithmID;
  public ArticleInfo articleInfo;
  public VideoAdInfo b;
  public a b;
  public int busiType;
  public int commentCount;
  public String coverUrl;
  public String createTime;
  public int duration;
  public int feedType;
  public String hH;
  public int height;
  public boolean isAD;
  public boolean isFavorite;
  public boolean isFollowed;
  public boolean isForbidReprint;
  public boolean isUseGif;
  public boolean isVerified;
  public ArrayList<ChannelInfo> jQ;
  public ArrayList<DislikeInfo> jR;
  public ArrayList<String> jS = new ArrayList();
  public ArrayList<VideoInfo> jT;
  private Object[] l;
  public int likeCount;
  public int playCount;
  public int qU = 1;
  public String qzoneShareUrl;
  public long rA;
  public String recommendReason;
  public long recommendSeq;
  public long rx;
  public long ry;
  public long rz;
  public int strategyID;
  public String summary;
  public String thirdAction;
  public String thirdUinName;
  public String title;
  public String vIconUrl;
  public String vid;
  public String videoReportInfo;
  public String videoUrl;
  public String webUrl;
  public String wechatShareUrl;
  public int width;
  
  public VideoInfo() {}
  
  public VideoInfo(Parcel paramParcel)
  {
    this.busiType = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramParcel.readParcelable(MessageForShortVideo.class.getClassLoader()));
    this.vid = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.coverUrl = paramParcel.readString();
    this.title = paramParcel.readString();
    this.summary = paramParcel.readString();
    this.createTime = paramParcel.readString();
    this.rx = paramParcel.readLong();
    this.webUrl = paramParcel.readString();
    this.Wz = paramParcel.readString();
    this.recommendReason = paramParcel.readString();
    this.jQ = paramParcel.createTypedArrayList(ChannelInfo.CREATOR);
    this.ry = paramParcel.readLong();
    this.WA = paramParcel.readString();
    this.commentCount = paramParcel.readInt();
    this.jR = paramParcel.createTypedArrayList(DislikeInfo.CREATOR);
    this.hH = paramParcel.readString();
    this.accountName = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.isVerified = bool1;
      if (paramParcel.readByte() == 0) {
        break label870;
      }
      bool1 = true;
      label253:
      this.adB = bool1;
      this.rz = paramParcel.readLong();
      this.WB = paramParcel.readString();
      this.aHb = paramParcel.readInt();
      this.thirdAction = paramParcel.readString();
      this.WC = paramParcel.readString();
      this.thirdUinName = paramParcel.readString();
      this.videoUrl = paramParcel.readString();
      this.rA = paramParcel.readLong();
      this.feedType = paramParcel.readInt();
      this.articleInfo = ((ArticleInfo)paramParcel.readParcelable(ArticleInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label875;
      }
      bool1 = true;
      label356:
      this.isAD = bool1;
      this.qU = paramParcel.readInt();
      this.b = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
      this.jS = paramParcel.createStringArrayList();
      if (paramParcel.readByte() == 0) {
        break label880;
      }
      bool1 = true;
      label403:
      this.isFavorite = bool1;
      if (paramParcel.readByte() == 0) {
        break label885;
      }
      bool1 = true;
      label417:
      this.adC = bool1;
      if (paramParcel.readByte() == 0) {
        break label890;
      }
      bool1 = true;
      label431:
      this.adD = bool1;
      this.aHd = paramParcel.readInt();
      this.adsJumpType = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((TopBarInfo)paramParcel.readParcelable(TopBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = ((InterruptedWeishiAd)paramParcel.readParcelable(InterruptedWeishiAd.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = ((DownloadBarInfo)paramParcel.readParcelable(DownloadBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = ((ECommerceEntranceInfo)paramParcel.readParcelable(ECommerceEntranceInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label895;
      }
      bool1 = true;
      label525:
      this.adE = bool1;
      this.aHe = paramParcel.readInt();
      this.algorithmID = paramParcel.readLong();
      this.strategyID = paramParcel.readInt();
      this.playCount = paramParcel.readInt();
      this.likeCount = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label900;
      }
      bool1 = true;
      label579:
      this.isFollowed = bool1;
      if (paramParcel.readByte() == 0) {
        break label905;
      }
      bool1 = true;
      label593:
      this.adM = bool1;
      this.aHi = paramParcel.readInt();
      this.WH = paramParcel.readString();
      this.WI = paramParcel.readString();
      this.videoReportInfo = paramParcel.readString();
      this.WJ = paramParcel.readString();
      this.recommendSeq = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label910;
      }
      bool1 = true;
      label655:
      this.isUseGif = bool1;
      this.Gx = paramParcel.readString();
      if (paramParcel.readByte() != 0) {
        break label915;
      }
      bool1 = true;
      label677:
      this.adF = bool1;
      this.jT = paramParcel.createTypedArrayList(CREATOR);
      this.aHf = paramParcel.readInt();
      this.aHg = paramParcel.readInt();
      this.WE = paramParcel.readString();
      this.vIconUrl = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = ((LikeActionDownloadBar)paramParcel.readParcelable(LikeActionDownloadBar.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = ((VideoColumnInfo)paramParcel.readParcelable(VideoColumnInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = ((SoftAdDownloadBarInfo)paramParcel.readParcelable(SoftAdDownloadBarInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label920;
      }
      bool1 = true;
      label783:
      this.adI = bool1;
      this.WF = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label925;
      }
      bool1 = true;
      label805:
      this.adJ = bool1;
      this.WG = paramParcel.readString();
      this.aioShareUrl = paramParcel.readString();
      this.qzoneShareUrl = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label930;
      }
    }
    label900:
    label905:
    label910:
    label915:
    label920:
    label925:
    label930:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isForbidReprint = bool1;
      this.wechatShareUrl = paramParcel.readString();
      this.aHc = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      label870:
      bool1 = false;
      break label253;
      label875:
      bool1 = false;
      break label356;
      label880:
      bool1 = false;
      break label403;
      label885:
      bool1 = false;
      break label417;
      label890:
      bool1 = false;
      break label431;
      label895:
      bool1 = false;
      break label525;
      bool1 = false;
      break label579;
      bool1 = false;
      break label593;
      bool1 = false;
      break label655;
      bool1 = false;
      break label677;
      bool1 = false;
      break label783;
      bool1 = false;
      break label805;
    }
  }
  
  private void aA(Activity paramActivity)
  {
    this.l = muj.a(paramActivity, getWidth(), getHeight());
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder("VideoInfo innerInitVideoAreaHeightInfo() ");
      paramActivity.append("videoAreaHeightInfo[0]=").append(this.l[0]).append(", videoAreaHeightInfo[1]=").append(this.l[1]).append(", videoAreaHeightInfo[2]=").append(this.l[2]);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramActivity.toString());
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.busiType = paramVideoInfo.busiType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    this.vid = paramVideoInfo.vid;
    this.width = paramVideoInfo.width;
    this.height = paramVideoInfo.height;
    this.duration = paramVideoInfo.duration;
    this.coverUrl = paramVideoInfo.coverUrl;
    this.title = paramVideoInfo.title;
    this.summary = paramVideoInfo.summary;
    this.createTime = paramVideoInfo.createTime;
    this.rx = paramVideoInfo.rx;
    this.webUrl = paramVideoInfo.webUrl;
    this.Wz = paramVideoInfo.Wz;
    this.recommendReason = paramVideoInfo.recommendReason;
    this.jQ = paramVideoInfo.jQ;
    this.ry = paramVideoInfo.ry;
    this.WA = paramVideoInfo.WA;
    this.commentCount = paramVideoInfo.commentCount;
    this.jR = paramVideoInfo.jR;
    this.hH = paramVideoInfo.hH;
    this.accountName = paramVideoInfo.accountName;
    this.isVerified = paramVideoInfo.isVerified;
    this.adB = paramVideoInfo.adB;
    this.rz = paramVideoInfo.rz;
    this.WB = paramVideoInfo.WB;
    this.aHb = paramVideoInfo.aHb;
    this.thirdAction = paramVideoInfo.thirdAction;
    this.WC = paramVideoInfo.WC;
    this.thirdUinName = paramVideoInfo.thirdUinName;
    this.videoUrl = paramVideoInfo.videoUrl;
    this.rA = paramVideoInfo.rA;
    this.feedType = paramVideoInfo.feedType;
    this.articleInfo = paramVideoInfo.articleInfo;
    this.isAD = paramVideoInfo.isAD;
    this.qU = paramVideoInfo.qU;
    this.b = paramVideoInfo.b;
    this.jS = paramVideoInfo.jS;
    this.isFavorite = paramVideoInfo.isFavorite;
    this.adC = paramVideoInfo.adC;
    this.adD = paramVideoInfo.adD;
    this.aHd = paramVideoInfo.aHd;
    this.adsJumpType = paramVideoInfo.adsJumpType;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
    this.adE = paramVideoInfo.adE;
    this.aHe = paramVideoInfo.aHe;
    this.algorithmID = paramVideoInfo.algorithmID;
    this.strategyID = paramVideoInfo.strategyID;
    this.playCount = paramVideoInfo.playCount;
    this.likeCount = paramVideoInfo.likeCount;
    this.isFollowed = paramVideoInfo.isFollowed;
    this.adM = paramVideoInfo.adM;
    this.aHi = paramVideoInfo.aHi;
    this.WH = paramVideoInfo.WH;
    this.WI = paramVideoInfo.WI;
    this.videoReportInfo = paramVideoInfo.videoReportInfo;
    this.WJ = paramVideoInfo.WJ;
    this.recommendSeq = paramVideoInfo.recommendSeq;
    this.isUseGif = paramVideoInfo.isUseGif;
    this.Gx = paramVideoInfo.Gx;
    this.adF = paramVideoInfo.adF;
    this.aHg = paramVideoInfo.aHg;
    if (this.articleInfo != null) {
      this.articleInfo.mArticleID = this.rz;
    }
    this.WE = paramVideoInfo.WE;
    this.vIconUrl = paramVideoInfo.vIconUrl;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo;
    this.aioShareUrl = paramVideoInfo.aioShareUrl;
    this.qzoneShareUrl = paramVideoInfo.qzoneShareUrl;
    this.isForbidReprint = paramVideoInfo.isForbidReprint;
    this.wechatShareUrl = paramVideoInfo.wechatShareUrl;
    this.aHc = paramVideoInfo.aHc;
  }
  
  public int[] a(Activity paramActivity, boolean paramBoolean)
  {
    int j = -1;
    int i = k(paramActivity);
    int k = aqnm.dip2px(50.0F);
    switch (i)
    {
    case 1: 
    default: 
      i = -1;
    }
    for (;;)
    {
      return new int[] { i, j };
      int m = wja.dp2px(10.0F, paramActivity.getResources());
      j = m;
      i = k;
      if (ayxa.isLiuHaiUseValid())
      {
        i = k + ayxa.getNotchInScreenHeight(paramActivity);
        j = m;
        continue;
        if (!paramBoolean)
        {
          int n = j(paramActivity);
          int i1 = muj.c(paramActivity)[1];
          if (i1 < n) {
            break;
          }
          m = wja.dp2px(10.0F, paramActivity.getResources());
          if (k(paramActivity))
          {
            j = m;
            i = k;
            if ((i1 - n) / 2 <= k) {
              continue;
            }
            i = (i1 - n) / 2 + wja.dp2px(32.0F, paramActivity.getResources());
            j = m;
            continue;
          }
          i = (i1 - n) / 2 + wja.dp2px(10.0F, paramActivity.getResources());
          j = m;
          continue;
        }
        if (getHeight() != 0) {
          break label240;
        }
        i = -1;
      }
    }
    label240:
    i = muj.c(paramActivity)[1];
    j = muj.c(paramActivity)[0];
    float f = getWidth() / getHeight();
    j = (int)(j * f);
    if (j <= i) {}
    for (j = (i - j) / 2 + wja.dp2px(16.0F, paramActivity.getResources());; j = wja.dp2px(16.0F, paramActivity.getResources()))
    {
      i = wja.dp2px(16.0F, paramActivity.getResources());
      break;
    }
  }
  
  public void aBD()
  {
    this.l = null;
  }
  
  public URL d()
  {
    if ((this.busiType == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return ShortVideoUtils.j(ShortVideoUtils.bw(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, "jpg"));
    }
    try
    {
      URL localURL = new URL(this.coverUrl);
      return localURL;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean d(QQAppInterface paramQQAppInterface)
  {
    if ((this.adB) && (!TextUtils.isEmpty(this.hH)) && (paramQQAppInterface != null))
    {
      if (this.hH.equals(paramQQAppInterface.getCurrentUin())) {
        return true;
      }
      if (((acff)paramQQAppInterface.getManager(51)).isFriend(this.hH)) {
        return true;
      }
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  public int getDuration()
  {
    if ((this.busiType == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime;
    }
    return this.duration;
  }
  
  public int getHeight()
  {
    if ((this.busiType == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight;
    }
    return this.height;
  }
  
  public int getWidth()
  {
    if ((this.busiType == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth;
    }
    return this.width;
  }
  
  public String hY()
  {
    if ((this.busiType == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    if (!TextUtils.isEmpty(this.Wz)) {
      return this.Wz;
    }
    return this.vid;
  }
  
  public String hZ()
  {
    return this.Gx;
  }
  
  public int i(Activity paramActivity)
  {
    if (this.l == null) {
      aA(paramActivity);
    }
    return ((Integer)this.l[1]).intValue();
  }
  
  public String ia()
  {
    return null;
  }
  
  public int j(Activity paramActivity)
  {
    if (this.l == null) {
      aA(paramActivity);
    }
    return ((Integer)this.l[2]).intValue();
  }
  
  public boolean j(Activity paramActivity)
  {
    if (this.l == null) {
      aA(paramActivity);
    }
    return ((Boolean)this.l[0]).booleanValue();
  }
  
  public int k(Activity paramActivity)
  {
    int[] arrayOfInt = muj.c(paramActivity);
    if (paramActivity == null) {}
    int j;
    do
    {
      do
      {
        do
        {
          return 0;
          if (!this.isAD) {
            break;
          }
        } while ((!k(paramActivity)) || (arrayOfInt[0] == 0) || (arrayOfInt[1] / arrayOfInt[0] <= 1.777778F));
        return 2;
      } while ((!j(paramActivity)) || (getWidth() <= 0) || (getHeight() <= 0));
      int i = (int)(getWidth() / getHeight() * arrayOfInt[1]);
      j = (int)(getHeight() / getWidth() * arrayOfInt[0]);
      if ((i > arrayOfInt[0]) && (i / arrayOfInt[0] <= 1.22D)) {
        return 2;
      }
    } while ((j <= arrayOfInt[1]) || (j / arrayOfInt[1] > 1.22D));
    return 2;
  }
  
  public boolean k(Activity paramActivity)
  {
    if (this.l == null) {
      aA(paramActivity);
    }
    return ((Boolean)this.l[3]).booleanValue();
  }
  
  public int nb()
  {
    if (this.busiType == 0) {
      return 1;
    }
    if ((this.isAD) && (this.qU == 1)) {
      return 3;
    }
    if ((this.isAD) && (this.qU == 2)) {
      return 4;
    }
    return 2;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.coverUrl = paramString;
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    localStringBuilder1.append("VideoInfo[");
    localStringBuilder1.append("busiType=").append(this.busiType).append(", ");
    localStringBuilder1.append("width=").append(getWidth()).append(", ");
    localStringBuilder1.append("height=").append(getHeight()).append(", ");
    StringBuilder localStringBuilder2;
    if (this.busiType == 0)
    {
      localStringBuilder2 = localStringBuilder1.append("msg=");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
      {
        localObject = "null ERROR";
        localStringBuilder2.append((String)localObject);
        label114:
        if (this.busiType == 6)
        {
          localStringBuilder1.append("video_url=").append(this.videoUrl).append(", ");
          localStringBuilder1.append("feedId=").append(this.rA).append(", ");
          localStringBuilder1.append("feedType=").append(this.feedType).append(", ");
          localStringBuilder2 = localStringBuilder1.append("articleInfo.mArticleID=");
          if (this.articleInfo != null) {
            break label916;
          }
        }
      }
    }
    label916:
    for (Object localObject = "articleInfo null";; localObject = Long.valueOf(this.articleInfo.mArticleID))
    {
      localStringBuilder2.append(localObject).append(", ");
      localStringBuilder1.append("isAD=").append(this.isAD).append(", ");
      localStringBuilder1.append("adType=").append(this.qU).append(", ");
      localStringBuilder1.append("recommendBarrageList=[");
      if (this.jS == null) {
        break label930;
      }
      localObject = this.jS.iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder1.append((String)((Iterator)localObject).next()).append(", ");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.toLogString();
      break;
      localStringBuilder1.append("vid=").append(this.vid).append(", ");
      localStringBuilder1.append("articleID=").append(this.Wz).append(", ");
      localStringBuilder1.append("title=").append(this.title).append(", ");
      localStringBuilder1.append("duration=").append(this.duration).append(", ");
      localStringBuilder1.append("coverUrl=").append(this.coverUrl).append(", ");
      localStringBuilder1.append("summary=").append(this.summary).append(", ");
      localStringBuilder1.append("createTime=").append(this.createTime).append(", ");
      localStringBuilder1.append("createTimeStamp=").append(this.rx).append(", ");
      localStringBuilder1.append("webUrl=").append(this.webUrl).append(", ");
      localStringBuilder1.append("recommendReason=").append(this.recommendReason).append(", ");
      localStringBuilder1.append("accountUin=").append(this.hH).append(", ");
      localStringBuilder1.append("accountName=").append(this.accountName).append(", ");
      localStringBuilder1.append("isVerified=").append(this.isVerified).append(", ");
      localStringBuilder1.append("biuCount=").append(this.aHb).append(", ");
      localStringBuilder1.append("commentCount=").append(this.commentCount).append(", ");
      localStringBuilder1.append("playCount=").append(this.playCount).append(", ");
      localStringBuilder1.append("likeCount=").append(this.likeCount).append(", ");
      localStringBuilder1.append("isDianZan=").append(this.adM).append(", ");
      localStringBuilder1.append("dianZanCount=").append(this.aHi).append(", ");
      localStringBuilder1.append("thirdAction=").append(this.thirdAction).append(", ");
      localStringBuilder1.append("thirdIconUrl=").append(this.WC).append(", ");
      localStringBuilder1.append("XGFileSize=").append(this.ry).append(", ");
      localStringBuilder1.append("articleSubsText").append(this.WH).append(", ");
      localStringBuilder1.append("articleSubsColor=").append(this.WI).append(", ");
      localStringBuilder1.append("isUgc=").append(this.adB).append(", ");
      localStringBuilder1.append("isFollowed=").append(this.isFollowed).append(", ");
      localStringBuilder1.append("aioShareUrl=").append(this.aioShareUrl).append(", ");
      localStringBuilder1.append("qzoneShareUrl=").append(this.qzoneShareUrl).append(", ");
      break label114;
    }
    label930:
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("topBarInfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo != null) {
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo.toString());
    }
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("interruptedWeishiAd=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) {
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.toString());
    }
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("commerceEntranceInfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo != null) {
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.toString());
    }
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("downloadBarinfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo != null) {
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo.toString());
    }
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("videoReportInfo=").append(this.videoReportInfo).append(", ");
    localStringBuilder1.append("avatarJumpUrl=").append(this.WJ).append(", ");
    localStringBuilder1.append("dynamicInsertTriggerSec=").append(this.aHg).append(", ");
    localStringBuilder1.append("videoLogoUrl=").append(this.WE).append(", ");
    localStringBuilder1.append("vIconUrl=").append(this.vIconUrl).append(", ");
    localStringBuilder1.append("likeActionDownloadBar=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar).append(", ");
    localStringBuilder1.append("videoColumnInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).append(", ");
    localStringBuilder1.append("columnId=").append(this.aHc).append(", ");
    localStringBuilder1.append("isColumnVideo()=").append(yV()).append(", ");
    localStringBuilder1.append("softAdDownloadBarInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).append(", ");
    localStringBuilder1.append("redpacketId=").append(this.WF).append(", ");
    localStringBuilder1.append("wechatShareUrl=").append(this.wechatShareUrl).append(", ");
    localStringBuilder1.append("]");
    localStringBuilder1.append("isUseGif=").append(this.isUseGif).append(", ").append("gifUrl=").append(this.Gx).append(", ").append("isShowCover=").append(this.adF).append("]");
    localStringBuilder1.append("isForbidReprint=").append(this.isForbidReprint);
    return localStringBuilder1.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeInt(this.busiType);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramInt);
    paramParcel.writeString(this.vid);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.duration);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.createTime);
    paramParcel.writeLong(this.rx);
    paramParcel.writeString(this.webUrl);
    paramParcel.writeString(this.Wz);
    paramParcel.writeString(this.recommendReason);
    paramParcel.writeTypedList(this.jQ);
    paramParcel.writeLong(this.ry);
    paramParcel.writeString(this.WA);
    paramParcel.writeInt(this.commentCount);
    paramParcel.writeTypedList(this.jR);
    paramParcel.writeString(this.hH);
    paramParcel.writeString(this.accountName);
    int i;
    if (this.isVerified)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      if (!this.adB) {
        break label758;
      }
      i = 1;
      label196:
      paramParcel.writeByte((byte)i);
      paramParcel.writeLong(this.rz);
      paramParcel.writeString(this.WB);
      paramParcel.writeInt(this.aHb);
      paramParcel.writeString(this.thirdAction);
      paramParcel.writeString(this.WC);
      paramParcel.writeString(this.thirdUinName);
      paramParcel.writeString(this.videoUrl);
      paramParcel.writeLong(this.rA);
      paramParcel.writeInt(this.feedType);
      paramParcel.writeParcelable(this.articleInfo, paramInt);
      if (!this.isAD) {
        break label763;
      }
      i = 1;
      label292:
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.qU);
      paramParcel.writeParcelable(this.b, paramInt);
      paramParcel.writeStringList(this.jS);
      if (!this.isFavorite) {
        break label768;
      }
      i = 1;
      label332:
      paramParcel.writeByte((byte)i);
      if (!this.adC) {
        break label773;
      }
      i = 1;
      label347:
      paramParcel.writeByte((byte)i);
      if (!this.adD) {
        break label778;
      }
      i = 1;
      label362:
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.aHd);
      paramParcel.writeInt(this.adsJumpType);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt);
      if (!this.adE) {
        break label783;
      }
      i = 1;
      label429:
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.aHe);
      paramParcel.writeLong(this.algorithmID);
      paramParcel.writeInt(this.strategyID);
      paramParcel.writeInt(this.playCount);
      paramParcel.writeInt(this.likeCount);
      if (!this.isFollowed) {
        break label788;
      }
      i = 1;
      label484:
      paramParcel.writeByte((byte)i);
      if (!this.adM) {
        break label793;
      }
      i = 1;
      label499:
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.aHi);
      paramParcel.writeString(this.WH);
      paramParcel.writeString(this.WI);
      paramParcel.writeString(this.videoReportInfo);
      paramParcel.writeString(this.WJ);
      paramParcel.writeLong(this.recommendSeq);
      if (!this.isUseGif) {
        break label798;
      }
      i = 1;
      label562:
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.Gx);
      if (!this.adF) {
        break label803;
      }
      i = 0;
      label585:
      paramParcel.writeByte((byte)i);
      paramParcel.writeTypedList(this.jT);
      paramParcel.writeInt(this.aHf);
      paramParcel.writeInt(this.aHg);
      paramParcel.writeString(this.WE);
      paramParcel.writeString(this.vIconUrl);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo, paramInt);
      if (!this.adI) {
        break label808;
      }
      paramInt = 1;
      label667:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.WF);
      if (!this.adJ) {
        break label813;
      }
      paramInt = 1;
      label690:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.WG);
      paramParcel.writeString(this.aioShareUrl);
      paramParcel.writeString(this.qzoneShareUrl);
      if (!this.isForbidReprint) {
        break label818;
      }
    }
    label768:
    label773:
    label778:
    label783:
    label788:
    label793:
    label798:
    label803:
    label808:
    label813:
    label818:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt((byte)paramInt);
      paramParcel.writeString(this.wechatShareUrl);
      paramParcel.writeInt(this.aHc);
      return;
      i = 0;
      break;
      label758:
      i = 0;
      break label196;
      label763:
      i = 0;
      break label292;
      i = 0;
      break label332;
      i = 0;
      break label347;
      i = 0;
      break label362;
      i = 0;
      break label429;
      i = 0;
      break label484;
      i = 0;
      break label499;
      i = 0;
      break label562;
      i = 1;
      break label585;
      paramInt = 0;
      break label667;
      paramInt = 0;
      break label690;
    }
  }
  
  public boolean yR()
  {
    return (!TextUtils.isEmpty(this.Wz)) && (this.articleInfo != null);
  }
  
  public boolean yS()
  {
    return this.isUseGif;
  }
  
  public boolean yT()
  {
    return this.adF;
  }
  
  public boolean yU()
  {
    return false;
  }
  
  public boolean yV()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aTm == 0) && (awit.aMD());
  }
  
  public static class AdTagInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<AdTagInfo> CREATOR = new kcc();
    public String WK = "";
    public VideoInfo.ClassInfo a;
    public int aHj;
    public ArrayList<VideoInfo.KdTagItem> jU;
    public int pos;
    public String rowkey = "";
    
    public AdTagInfo() {}
    
    public AdTagInfo(Parcel paramParcel)
    {
      this.rowkey = paramParcel.readString();
      this.jU = paramParcel.createTypedArrayList(VideoInfo.KdTagItem.CREATOR);
      this.aHj = paramParcel.readInt();
      this.pos = paramParcel.readInt();
      this.a = ((VideoInfo.ClassInfo)paramParcel.readParcelable(VideoInfo.ClassInfo.class.getClassLoader()));
      this.WK = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.rowkey);
      paramParcel.writeTypedList(this.jU);
      paramParcel.writeInt(this.aHj);
      paramParcel.writeInt(this.pos);
      paramParcel.writeParcelable(this.a, paramInt);
      paramParcel.writeString(this.WK);
    }
  }
  
  public static class ChannelInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ChannelInfo> CREATOR = new kcd();
    public String WL;
    public String WM;
    public int aHk;
    public int channelID;
    public String channelName;
    public int channelType;
    
    public ChannelInfo() {}
    
    public ChannelInfo(Parcel paramParcel)
    {
      this.channelID = paramParcel.readInt();
      this.channelType = paramParcel.readInt();
      this.channelName = paramParcel.readString();
      this.WL = paramParcel.readString();
      this.WM = paramParcel.readString();
      this.aHk = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "ChannelInfo{channelID=" + this.channelID + ", channelType=" + this.channelType + ", channelName='" + this.channelName + '\'' + ", channelDisplayName='" + this.WL + '\'' + ", channelURL='" + this.WM + '\'' + ", isTopic=" + this.aHk + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.channelID);
      paramParcel.writeInt(this.channelType);
      paramParcel.writeString(this.channelName);
      paramParcel.writeString(this.WL);
      paramParcel.writeString(this.WM);
      paramParcel.writeInt(this.aHk);
    }
  }
  
  public static class ClassInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ClassInfo> CREATOR = new kce();
    public String WN = "";
    public String WO = "";
    public String WP = "";
    public long rB;
    public long rC;
    public long rD;
    
    public ClassInfo() {}
    
    public ClassInfo(Parcel paramParcel)
    {
      this.rB = paramParcel.readLong();
      this.WN = paramParcel.readString();
      this.rC = paramParcel.readLong();
      this.WO = paramParcel.readString();
      this.rD = paramParcel.readLong();
      this.WP = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.rB);
      paramParcel.writeString(this.WN);
      paramParcel.writeLong(this.rC);
      paramParcel.writeString(this.WO);
      paramParcel.writeLong(this.rD);
      paramParcel.writeString(this.WP);
    }
  }
  
  public static class DownloadBarInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<DownloadBarInfo> CREATOR = new kcf();
    public String WQ;
    public String WR;
    public String WT;
    public UrlJumpInfo a;
    public int aHl;
    public int appearTime;
    public String logoUrl;
    
    public DownloadBarInfo() {}
    
    public DownloadBarInfo(Parcel paramParcel)
    {
      this.appearTime = paramParcel.readInt();
      this.logoUrl = paramParcel.readString();
      this.WQ = paramParcel.readString();
      this.WR = paramParcel.readString();
      this.aHl = paramParcel.readInt();
      this.a = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.WT = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "DownloadBarInfo{appearTime=" + this.appearTime + ", logoUrl='" + this.logoUrl + '\'' + ", downloadBtnText='" + this.WQ + '\'' + ", openBtnText='" + this.WR + '\'' + ", buttonBgColor=" + this.aHl + ", jumpInfo=" + this.a + ", commonData='" + this.WT + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.appearTime);
      paramParcel.writeString(this.logoUrl);
      paramParcel.writeString(this.WQ);
      paramParcel.writeString(this.WR);
      paramParcel.writeInt(this.aHl);
      paramParcel.writeParcelable(this.a, paramInt);
      paramParcel.writeString(this.WT);
    }
  }
  
  public static class ECommerceEntranceInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ECommerceEntranceInfo> CREATOR = new kcg();
    public String WQ;
    public String WR;
    public String WT;
    public String WU;
    public String WV;
    public int aHm = -1;
    public int aHn;
    public int aHo;
    public int aHp;
    public UrlJumpInfo b;
    public int[] da;
    public int jumpType;
    public String jumpUrl;
    public int playTime = -1;
    public int style;
    public String subTitle;
    public String title;
    public int videoSource;
    
    public ECommerceEntranceInfo() {}
    
    public ECommerceEntranceInfo(Parcel paramParcel)
    {
      this.title = paramParcel.readString();
      this.subTitle = paramParcel.readString();
      this.WU = paramParcel.readString();
      this.WV = paramParcel.readString();
      this.jumpType = paramParcel.readInt();
      this.jumpUrl = paramParcel.readString();
      this.da = paramParcel.createIntArray();
      this.aHm = paramParcel.readInt();
      this.playTime = paramParcel.readInt();
      this.WT = paramParcel.readString();
      this.aHn = paramParcel.readInt();
      this.aHo = paramParcel.readInt();
      this.aHp = paramParcel.readInt();
      this.videoSource = paramParcel.readInt();
      this.style = paramParcel.readInt();
      this.b = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.WQ = paramParcel.readString();
      this.WR = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("commerceEntranceInfo{title='").append(this.title).append('\'').append(", subTitle='").append(this.subTitle).append('\'').append(", thumbnailUrl='").append(this.WU).append('\'').append(", linkIconUrl='").append(this.WV).append('\'').append(", jumpType=").append(this.jumpType).append(", jumpUrl='").append(this.jumpUrl).append('\'').append(", showPosition=").append(Arrays.toString(this.da)).append(", showPercent=").append(this.aHm).append(", playTime=").append(this.playTime).append(", commonData=").append(this.WT).append(", displayCountsVersion=").append(this.aHn).append(", sessionDisplayCounts=").append(this.aHo).append(", oneDayMaxDisplayCounts=").append(this.aHp).append(", videoSource=").append(this.videoSource).append(", style=").append(this.style).append(", appInfo=");
      if (this.b == null) {}
      for (String str = "null";; str = this.b.toString()) {
        return str + ", downloadBtnText=" + this.WQ + ", openBtnText=" + this.WR + '}';
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.subTitle);
      paramParcel.writeString(this.WU);
      paramParcel.writeString(this.WV);
      paramParcel.writeInt(this.jumpType);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeIntArray(this.da);
      paramParcel.writeInt(this.aHm);
      paramParcel.writeInt(this.playTime);
      paramParcel.writeString(this.WT);
      paramParcel.writeInt(this.aHn);
      paramParcel.writeInt(this.aHo);
      paramParcel.writeInt(this.aHp);
      paramParcel.writeInt(this.videoSource);
      paramParcel.writeInt(this.style);
      paramParcel.writeParcelable(this.b, paramInt);
      paramParcel.writeString(this.WQ);
      paramParcel.writeString(this.WR);
    }
  }
  
  public static class EntranceDownloadInfo
    implements Parcelable, nss
  {
    public static final Parcelable.Creator<EntranceDownloadInfo> CREATOR = new kch();
    public String WT;
    public UrlJumpInfo a;
    public String iconUrl;
    public boolean isUseGif;
    public String smallIconUrl;
    
    public EntranceDownloadInfo() {}
    
    public EntranceDownloadInfo(Parcel paramParcel)
    {
      this.iconUrl = paramParcel.readString();
      this.smallIconUrl = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.isUseGif = bool;
        this.WT = paramParcel.readString();
        this.a = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getCoverUrl()
    {
      return this.iconUrl;
    }
    
    public String hZ()
    {
      return this.iconUrl;
    }
    
    public String ia()
    {
      return this.smallIconUrl;
    }
    
    public void setCoverUrl(String paramString)
    {
      this.iconUrl = paramString;
    }
    
    public String toString()
    {
      return "EntranceDownloadInfo{iconUrl='" + this.iconUrl + '\'' + ", smallIconUrl='" + this.smallIconUrl + '\'' + ", isUseGif='" + this.isUseGif + '\'' + ", commonData='" + this.WT + '\'' + ", jumpInfo='" + this.a + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.smallIconUrl);
      if (this.isUseGif) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeString(this.WT);
        paramParcel.writeParcelable(this.a, paramInt);
        return;
      }
    }
    
    public boolean yS()
    {
      return this.isUseGif;
    }
    
    public boolean yT()
    {
      return !TextUtils.isEmpty(this.iconUrl);
    }
    
    public boolean yU()
    {
      return !TextUtils.isEmpty(this.smallIconUrl);
    }
  }
  
  public static class GameAdComData
    implements Parcelable
  {
    public static final Parcelable.Creator<GameAdComData> CREATOR = new kci();
    public String WW;
    public String WX;
    public String WY;
    public String WZ;
    public String Xa;
    public String Xb;
    public String Xc;
    public String Xd;
    public String Xe;
    public String Xf;
    public String Xg;
    public String Xh;
    public String Xi;
    public String Xj;
    public String Xk;
    public String Xl;
    public String Xm;
    public String Xn;
    public String Xo;
    public String Xp;
    public String Xq;
    public String Xr;
    public String Xs;
    public String Xt;
    public VideoInfo.GameAdDownloadInfo a;
    public int aHq;
    public int downloadState;
    public int progress;
    public String rowKey;
    public String sAppid;
    public String sGameName;
    
    public GameAdComData(Parcel paramParcel)
    {
      this.rowKey = paramParcel.readString();
      this.WW = paramParcel.readString();
      this.aHq = paramParcel.readInt();
      this.sGameName = paramParcel.readString();
      this.WX = paramParcel.readString();
      this.WY = paramParcel.readString();
      this.WZ = paramParcel.readString();
      this.sAppid = paramParcel.readString();
      this.Xa = paramParcel.readString();
      this.Xb = paramParcel.readString();
      this.Xc = paramParcel.readString();
      this.Xd = paramParcel.readString();
      this.Xe = paramParcel.readString();
      this.Xf = paramParcel.readString();
      this.Xg = paramParcel.readString();
      this.Xh = paramParcel.readString();
      this.Xi = paramParcel.readString();
      this.Xj = paramParcel.readString();
      this.Xk = paramParcel.readString();
      this.Xl = paramParcel.readString();
      this.Xm = paramParcel.readString();
      this.Xn = paramParcel.readString();
      this.Xo = paramParcel.readString();
      this.Xp = paramParcel.readString();
      this.Xq = paramParcel.readString();
      this.Xr = paramParcel.readString();
      this.Xs = paramParcel.readString();
      this.Xt = paramParcel.readString();
    }
    
    public GameAdComData(String paramString, JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {}
      do
      {
        return;
        this.rowKey = paramString;
        this.WW = paramJSONObject.optString("sAdID", "");
        this.aHq = paramJSONObject.optInt("sDeliveryMode", 0);
        this.sGameName = paramJSONObject.optString("sGameName", "");
        this.WX = paramJSONObject.optString("sPackageName", "");
        this.WY = paramJSONObject.optString("sBusiness_type", "");
        this.WZ = paramJSONObject.optString("sPlat_form", "");
        this.sAppid = paramJSONObject.optString("sAppid", "");
        this.Xa = paramJSONObject.optString("sAppleid", "");
        this.Xb = paramJSONObject.optString("sSlogan", "");
        this.Xc = paramJSONObject.optString("sGameIcon", "");
        this.Xd = paramJSONObject.optString("sOperType", "");
        this.Xe = paramJSONObject.optString("sGameStage", "");
        this.Xf = paramJSONObject.optString("sGameKind", "");
        this.Xg = paramJSONObject.optString("sGameSubKind", "");
        this.Xh = paramJSONObject.optString("sDetailUrl", "");
        this.Xi = paramJSONObject.optString("sActivityUrl", "");
        this.Xj = paramJSONObject.optString("sGameStatus", "");
        this.Xk = paramJSONObject.optString("sComponentType", "");
        this.Xl = paramJSONObject.optString("stDownloadInfo", "");
        if (TextUtils.isEmpty(this.Xl)) {
          this.Xl = new JSONObject().toString();
        }
        this.Xm = paramJSONObject.optString("sGiftInfo", "");
        if (TextUtils.isEmpty(this.Xm)) {
          this.Xm = new JSONObject().toString();
        }
        this.Xn = paramJSONObject.optString("sButtonDesc", "");
        this.Xo = paramJSONObject.optString("sWordTitle", "");
        this.Xp = paramJSONObject.optString("sWordContentWifi", "");
        this.Xq = paramJSONObject.optString("sWordContentNoWifi", "");
        this.Xr = paramJSONObject.optString("sWordHighlight", "");
        this.Xs = paramJSONObject.optString("sWordHighlightColor", "");
        this.Xt = paramJSONObject.optString("mExtendGameInfo", "");
      } while (!TextUtils.isEmpty(this.Xt));
      this.Xt = new JSONObject().toString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.rowKey);
      paramParcel.writeString(this.WW);
      paramParcel.writeInt(this.aHq);
      paramParcel.writeString(this.sGameName);
      paramParcel.writeString(this.WX);
      paramParcel.writeString(this.WY);
      paramParcel.writeString(this.WZ);
      paramParcel.writeString(this.sAppid);
      paramParcel.writeString(this.Xa);
      paramParcel.writeString(this.Xb);
      paramParcel.writeString(this.Xc);
      paramParcel.writeString(this.Xd);
      paramParcel.writeString(this.Xe);
      paramParcel.writeString(this.Xf);
      paramParcel.writeString(this.Xg);
      paramParcel.writeString(this.Xh);
      paramParcel.writeString(this.Xi);
      paramParcel.writeString(this.Xj);
      paramParcel.writeString(this.Xk);
      paramParcel.writeString(this.Xl);
      paramParcel.writeString(this.Xm);
      paramParcel.writeString(this.Xn);
      paramParcel.writeString(this.Xo);
      paramParcel.writeString(this.Xp);
      paramParcel.writeString(this.Xq);
      paramParcel.writeString(this.Xr);
      paramParcel.writeString(this.Xs);
      paramParcel.writeString(this.Xt);
    }
  }
  
  public static class GameAdDownloadInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<GameAdDownloadInfo> CREATOR = new kcj();
    public String Xu;
    public String Xv;
    public String Xw;
    public int aHr;
    public String sVersionCode;
    
    public GameAdDownloadInfo(Parcel paramParcel)
    {
      this.Xu = paramParcel.readString();
      this.Xv = paramParcel.readString();
      this.Xw = paramParcel.readString();
      this.sVersionCode = paramParcel.readString();
      this.aHr = paramParcel.readInt();
    }
    
    public GameAdDownloadInfo(JSONObject paramJSONObject)
    {
      this.Xu = paramJSONObject.optString("sGameDownloadUrl");
      this.Xv = paramJSONObject.optString("lGameSize");
      this.Xw = paramJSONObject.optString("sApkMd5");
      this.sVersionCode = paramJSONObject.optString("sVersionCode");
      this.aHr = paramJSONObject.optInt("iGameType");
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.Xu);
      paramParcel.writeString(this.Xv);
      paramParcel.writeString(this.Xw);
      paramParcel.writeString(this.sVersionCode);
      paramParcel.writeInt(this.aHr);
    }
  }
  
  public static class InterruptedWeishiAd
    implements Parcelable
  {
    public static final Parcelable.Creator<InterruptedWeishiAd> CREATOR = new kck();
    public String WQ;
    public String WR;
    public int aHs = -1;
    public boolean adN;
    public boolean adO;
    public String adUrl;
    public String appIconUrl;
    public String appName;
    public UrlJumpInfo b;
    public int[] db;
    public int type;
    
    public InterruptedWeishiAd() {}
    
    public InterruptedWeishiAd(Parcel paramParcel)
    {
      this.db = paramParcel.createIntArray();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.adN = bool1;
        if (paramParcel.readByte() == 0) {
          break label109;
        }
      }
      label109:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.adO = bool1;
        this.aHs = paramParcel.readInt();
        this.adUrl = paramParcel.readString();
        this.type = paramParcel.readInt();
        this.WQ = paramParcel.readString();
        this.WR = paramParcel.readString();
        this.b = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
        return;
        bool1 = false;
        break;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = null;
      if (this.type == 0)
      {
        localObject = "弹出式web页面";
        localStringBuilder = new StringBuilder().append("InterruptedWeishiAd{showPositon=").append(Arrays.toString(this.db)).append(", isShowInSwitch=").append(this.adN).append(", isShowInPlayEnd=").append(this.adO).append(", showAfterPlayTime=").append(this.aHs).append(", adUrl='").append(this.adUrl).append('\'').append(", type=").append((String)localObject).append(", downloadBtnText=").append(this.WQ).append(", openBtnText=").append(this.WR).append(", appInfo=");
        if (this.b != null) {
          break label165;
        }
      }
      label165:
      for (Object localObject = "null";; localObject = this.b.toString())
      {
        return (String)localObject + '}';
        localObject = localStringBuilder;
        if (this.type != 1) {
          break;
        }
        localObject = localStringBuilder;
        break;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 1;
      paramParcel.writeIntArray(this.db);
      if (this.adN)
      {
        i = 1;
        paramParcel.writeByte((byte)i);
        if (!this.adO) {
          break label97;
        }
      }
      label97:
      for (int i = j;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeInt(this.aHs);
        paramParcel.writeString(this.adUrl);
        paramParcel.writeInt(this.type);
        paramParcel.writeString(this.WQ);
        paramParcel.writeString(this.WR);
        paramParcel.writeParcelable(this.b, paramInt);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public static class KdTagItem
    implements Parcelable
  {
    public static final Parcelable.Creator<KdTagItem> CREATOR = new kcl();
    public String name = "";
    public long rE;
    
    public KdTagItem() {}
    
    public KdTagItem(Parcel paramParcel)
    {
      this.name = paramParcel.readString();
      this.rE = paramParcel.readLong();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.name);
      paramParcel.writeLong(this.rE);
    }
  }
  
  public static class LikeActionDownloadBar
    implements Parcelable
  {
    public static final Parcelable.Creator<LikeActionDownloadBar> CREATOR = new kcm();
    public String WT;
    public String Xx;
    public UrlJumpInfo c;
    public String logoUrl;
    
    public LikeActionDownloadBar() {}
    
    public LikeActionDownloadBar(Parcel paramParcel)
    {
      this.logoUrl = paramParcel.readString();
      this.Xx = paramParcel.readString();
      this.c = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.WT = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "LikeActionDownloadBar{logoUrl=" + this.logoUrl + ", downloadBarText='" + this.Xx + '\'' + ", jumpInfo=" + this.c + ", commonData='" + this.WT + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.logoUrl);
      paramParcel.writeString(this.Xx);
      paramParcel.writeParcelable(this.c, paramInt);
      paramParcel.writeString(this.WT);
    }
  }
  
  public static class SoftAdDownloadBarInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<VideoInfo.DownloadBarInfo> CREATOR = new kcn();
    public String Xy;
    public int aHt;
    public UrlJumpInfo c;
    public String smallIconUrl;
    public String subTitle;
    public String title;
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "SoftAdDownloadBarInfo{title=" + this.title + ", subTitle='" + this.subTitle + '\'' + ", smallIconUrl='" + this.smallIconUrl + '\'' + ", bigIconUrl='" + this.Xy + '\'' + ", changeBiggerPositionPercent='" + this.aHt + '\'' + ", urlJumpInfo=" + this.c + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.subTitle);
      paramParcel.writeString(this.smallIconUrl);
      paramParcel.writeString(this.Xy);
      paramParcel.writeInt(this.aHt);
      paramParcel.writeParcelable(this.c, paramInt);
    }
  }
  
  public static class TopBarInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TopBarInfo> CREATOR = new kco();
    public String WT;
    public UrlJumpInfo a;
    public String backgroundUrl;
    public String iconUrl;
    public int logoId;
    public String title;
    
    public TopBarInfo() {}
    
    public TopBarInfo(Parcel paramParcel)
    {
      this.logoId = paramParcel.readInt();
      this.iconUrl = paramParcel.readString();
      this.title = paramParcel.readString();
      this.backgroundUrl = paramParcel.readString();
      this.a = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.WT = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "TopBarInfo{logoId=" + this.logoId + ", iconUrl='" + this.iconUrl + '\'' + ", title='" + this.title + '\'' + ", backgroundUrl='" + this.backgroundUrl + '\'' + ", jumpInfo=" + this.a + ", commonData='" + this.WT + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.logoId);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.backgroundUrl);
      paramParcel.writeParcelable(this.a, paramInt);
      paramParcel.writeString(this.WT);
    }
  }
  
  public static class a
  {
    public String XA;
    public String XB;
    public String XC;
    public String XD;
    public String XE;
    public String XF;
    public String XG;
    public String XH;
    public String XI;
    public String XJ;
    public String XK;
    public String XL;
    public String XM;
    public String Xz;
    public int aHu = 5;
    public int aHv = 10;
    public int aHw;
  }
  
  public static class b
  {
    public boolean adP;
    public boolean isComment;
    public boolean isLike;
    public long rF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo
 * JD-Core Version:    0.7.0.1
 */