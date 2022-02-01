package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.AdReport;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ContentBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.VideoBannerItem;

public class TopBannerInfo
  extends Entity
{
  private static final String TAG = "TopBannerInfo";
  @notColumn
  public final List<c> dynamicItems = new ArrayList();
  @notColumn
  public final List<b> items = new ArrayList();
  public byte[] itemsByte;
  public int mChannelId = -1;
  public String mCookie;
  @notColumn
  public e moreChannelItem;
  
  public void addDynamicItem(c paramc)
  {
    this.dynamicItems.add(paramc);
  }
  
  public void addItem(b paramb)
  {
    this.items.add(paramb);
  }
  
  public boolean isBothEmpty()
  {
    return (this.items.isEmpty()) && (this.dynamicItems.isEmpty());
  }
  
  public boolean isDynamicItemsEmpty()
  {
    return this.dynamicItems.isEmpty();
  }
  
  public boolean isEmpty()
  {
    return (this.items.isEmpty()) && (this.dynamicItems.isEmpty());
  }
  
  public void postRead()
  {
    Iterator localIterator;
    Object localObject;
    if ((this.itemsByte != null) && (this.itemsByte.length > 0))
    {
      oidb_cmd0xbc9.BannerRoundRspBody localBannerRoundRspBody = new oidb_cmd0xbc9.BannerRoundRspBody();
      try
      {
        localBannerRoundRspBody.mergeFrom(this.itemsByte);
        if (localBannerRoundRspBody.rpt_msg_banner_list.has())
        {
          localIterator = localBannerRoundRspBody.rpt_msg_banner_list.get().iterator();
          while (localIterator.hasNext())
          {
            localObject = b.a((oidb_cmd0xbc9.BannerItem)localIterator.next());
            if (localObject != null)
            {
              this.items.add(localObject);
              continue;
              return;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        this.items.clear();
        QLog.d("TopBannerInfo", 1, "", localInvalidProtocolBufferMicroException);
      }
    }
    e locale;
    do
    {
      do
      {
        if ((localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.has()) && (localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.size() > 0))
        {
          localIterator = localInvalidProtocolBufferMicroException.rpt_msg_dynamic_banner_list.get().iterator();
          while (localIterator.hasNext())
          {
            localObject = c.a((oidb_cmd0xbc9.DynamicBannerItem)localIterator.next());
            if (localObject != null) {
              this.dynamicItems.addAll((Collection)localObject);
            }
          }
        }
      } while (!localInvalidProtocolBufferMicroException.msg_more_channel_item.has());
      locale = e.a((oidb_cmd0xbc9.MoreChannelItem)localInvalidProtocolBufferMicroException.msg_more_channel_item.get());
    } while (locale == null);
    this.moreChannelItem = locale;
  }
  
  public void prewrite()
  {
    if (!isBothEmpty())
    {
      oidb_cmd0xbc9.BannerRoundRspBody localBannerRoundRspBody = new oidb_cmd0xbc9.BannerRoundRspBody();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((b)localIterator.next()).a());
      }
      localBannerRoundRspBody.rpt_msg_banner_list.addAll(localArrayList);
      localArrayList = new ArrayList();
      localIterator = this.dynamicItems.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((c)localIterator.next()).a());
      }
      if (this.moreChannelItem != null) {
        localBannerRoundRspBody.msg_more_channel_item.set(this.moreChannelItem.a());
      }
      localBannerRoundRspBody.rpt_msg_dynamic_banner_list.addAll(localArrayList);
      this.itemsByte = localBannerRoundRspBody.toByteArray();
    }
  }
  
  public void setMoreChannelItem(e parame)
  {
    this.moreChannelItem = parame;
  }
  
  public String toString()
  {
    return "mCookie : " + this.mCookie + "  mChannelId: " + this.mChannelId + " items size: " + this.items.size();
  }
  
  public static class a
  {
    public String reportUrl;
    
    public static a a(oidb_cmd0xbc9.AdReport paramAdReport)
    {
      a locala = new a();
      locala.reportUrl = paramAdReport.bytes_report_url.get().toStringUtf8();
      return locala;
    }
    
    public oidb_cmd0xbc9.AdReport a()
    {
      oidb_cmd0xbc9.AdReport localAdReport = new oidb_cmd0xbc9.AdReport();
      localAdReport.bytes_report_url.set(ByteStringMicro.copyFromUtf8(this.reportUrl));
      return localAdReport;
    }
  }
  
  public static class b
  {
    public List<TopBannerInfo.a> adClickReports;
    public List<TopBannerInfo.a> adExposureReports;
    public String aiy;
    public String aiz;
    public long id;
    public String imgUrl;
    public boolean isAD;
    public String rowKey;
    public String title;
    public final int type;
    
    public b(int paramInt)
    {
      this.type = paramInt;
    }
    
    public static b a(oidb_cmd0xbc9.BannerItem paramBannerItem)
    {
      b localb = null;
      if (paramBannerItem.uint32_banner_type.has())
      {
        if (paramBannerItem.uint32_banner_type.get() == 2) {
          localb = TopBannerInfo.f.a(paramBannerItem);
        }
      }
      else {
        return localb;
      }
      return TopBannerInfo.d.a(paramBannerItem);
    }
    
    protected static void a(b paramb, oidb_cmd0xbc9.BannerItem paramBannerItem)
    {
      boolean bool = true;
      if (paramb != null)
      {
        if (paramBannerItem.uint32_is_ad.get() == 1) {}
        Object localObject;
        for (;;)
        {
          paramb.isAD = bool;
          paramb.id = paramBannerItem.uint64_banner_id.get();
          localObject = paramBannerItem.msg_ad_click_report.get();
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break;
          }
          paramb.adClickReports = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            oidb_cmd0xbc9.AdReport localAdReport = (oidb_cmd0xbc9.AdReport)((Iterator)localObject).next();
            paramb.adClickReports.add(TopBannerInfo.a.a(localAdReport));
          }
          bool = false;
        }
        paramBannerItem = paramBannerItem.msg_ad_exposure_report.get();
        if ((paramBannerItem != null) && (paramBannerItem.size() > 0))
        {
          paramb.adExposureReports = new ArrayList();
          paramBannerItem = paramBannerItem.iterator();
          while (paramBannerItem.hasNext())
          {
            localObject = (oidb_cmd0xbc9.AdReport)paramBannerItem.next();
            paramb.adExposureReports.add(TopBannerInfo.a.a((oidb_cmd0xbc9.AdReport)localObject));
          }
        }
      }
    }
    
    public static void a(oidb_cmd0xbc9.BannerItem paramBannerItem, b paramb)
    {
      if (paramBannerItem.bytes_superscript_color.has()) {
        paramb.aiy = paramBannerItem.bytes_superscript_color.get().toStringUtf8();
      }
      if (paramBannerItem.bytes_superscript_text.has()) {
        paramb.aiz = paramBannerItem.bytes_superscript_text.get().toStringUtf8();
      }
      if (paramBannerItem.bytes_banner_title.has()) {
        paramb.title = paramBannerItem.bytes_banner_title.get().toStringUtf8();
      }
    }
    
    public oidb_cmd0xbc9.BannerItem a()
    {
      oidb_cmd0xbc9.BannerItem localBannerItem = new oidb_cmd0xbc9.BannerItem();
      if (!TextUtils.isEmpty(this.aiz)) {
        localBannerItem.bytes_superscript_text.set(ByteStringMicro.copyFromUtf8(this.aiz));
      }
      if (!TextUtils.isEmpty(this.aiy)) {
        localBannerItem.bytes_superscript_color.set(ByteStringMicro.copyFromUtf8(this.aiy));
      }
      if (!TextUtils.isEmpty(this.title)) {
        localBannerItem.bytes_banner_title.set(ByteStringMicro.copyFromUtf8(this.title));
      }
      localBannerItem.uint32_banner_type.set(this.type);
      a(localBannerItem);
      return localBannerItem;
    }
    
    protected void a(oidb_cmd0xbc9.BannerItem paramBannerItem)
    {
      Object localObject = paramBannerItem.uint32_is_ad;
      if (this.isAD) {}
      Iterator localIterator;
      for (int i = 1;; i = 0)
      {
        ((PBUInt32Field)localObject).set(i);
        paramBannerItem.uint64_banner_id.set(this.id);
        if ((this.adClickReports == null) || (this.adClickReports.size() <= 0)) {
          break label114;
        }
        localObject = new ArrayList();
        localIterator = this.adClickReports.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject).add(((TopBannerInfo.a)localIterator.next()).a());
        }
      }
      paramBannerItem.msg_ad_click_report.addAll((Collection)localObject);
      label114:
      if ((this.adExposureReports != null) && (this.adExposureReports.size() > 0))
      {
        localObject = new ArrayList();
        localIterator = this.adExposureReports.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject).add(((TopBannerInfo.a)localIterator.next()).a());
        }
        paramBannerItem.msg_ad_exposure_report.addAll((Collection)localObject);
      }
    }
    
    public List<String> getUrls(List<TopBannerInfo.a> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((TopBannerInfo.a)paramList.next()).reportUrl);
      }
      return localArrayList;
    }
    
    public String toString()
    {
      return "rowkey:" + this.rowKey + " title:" + this.title + "tagText:" + this.aiz + "tagColor:" + this.aiy;
    }
  }
  
  public static class c
  {
    public String aiA;
    
    public static List<c> a(oidb_cmd0xbc9.DynamicBannerItem paramDynamicBannerItem)
    {
      localArrayList = new ArrayList();
      if (!paramDynamicBannerItem.bytes_dynamic_json.has()) {}
      for (;;)
      {
        return localArrayList;
        Object localObject = paramDynamicBannerItem.bytes_dynamic_json.get().toStringUtf8();
        try
        {
          JSONArray localJSONArray = new JSONArray((String)localObject);
          int i = 0;
          while (i < localJSONArray.length())
          {
            c localc = new c();
            localc.aiA = localJSONArray.get(i).toString();
            localArrayList.add(localc);
            i += 1;
          }
          return localArrayList;
        }
        catch (Exception localException)
        {
          QLog.d("TopBannerInfo", 4, "" + (String)localObject);
          localObject = new c();
          ((c)localObject).aiA = paramDynamicBannerItem.bytes_dynamic_json.get().toStringUtf8();
          localArrayList.add(localObject);
        }
      }
    }
    
    public oidb_cmd0xbc9.DynamicBannerItem a()
    {
      oidb_cmd0xbc9.DynamicBannerItem localDynamicBannerItem = new oidb_cmd0xbc9.DynamicBannerItem();
      if (!TextUtils.isEmpty(this.aiA)) {
        localDynamicBannerItem.bytes_dynamic_json.set(ByteStringMicro.copyFromUtf8(this.aiA));
      }
      return localDynamicBannerItem;
    }
  }
  
  public static class d
    extends TopBannerInfo.b
  {
    public String jumpUrl;
    
    public d(int paramInt)
    {
      super();
    }
    
    public static TopBannerInfo.b a(oidb_cmd0xbc9.BannerItem paramBannerItem)
    {
      if (!paramBannerItem.msg_article_content_item.has()) {
        return null;
      }
      oidb_cmd0xbc9.ContentBannerItem localContentBannerItem = paramBannerItem.msg_article_content_item;
      if (paramBannerItem.uint32_banner_type.has()) {}
      for (d locald = new d(paramBannerItem.uint32_banner_type.get());; locald = new d(4))
      {
        if (localContentBannerItem.bytes_image_url.has()) {
          locald.imgUrl = localContentBannerItem.bytes_image_url.get().toStringUtf8();
        }
        if (localContentBannerItem.bytes_link_url.has()) {
          locald.jumpUrl = localContentBannerItem.bytes_link_url.get().toStringUtf8();
        }
        if (localContentBannerItem.bytes_rowkey.has()) {
          locald.rowKey = localContentBannerItem.bytes_rowkey.get().toStringUtf8();
        }
        a(locald, paramBannerItem);
        a(paramBannerItem, locald);
        return locald;
      }
    }
    
    public oidb_cmd0xbc9.BannerItem a()
    {
      oidb_cmd0xbc9.BannerItem localBannerItem = super.a();
      oidb_cmd0xbc9.ContentBannerItem localContentBannerItem = new oidb_cmd0xbc9.ContentBannerItem();
      if (!TextUtils.isEmpty(this.imgUrl)) {
        localContentBannerItem.bytes_image_url.set(ByteStringMicro.copyFromUtf8(this.imgUrl));
      }
      if (!TextUtils.isEmpty(this.jumpUrl)) {
        localContentBannerItem.bytes_link_url.set(ByteStringMicro.copyFromUtf8(this.jumpUrl));
      }
      if (!TextUtils.isEmpty(this.rowKey)) {
        localContentBannerItem.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(this.rowKey));
      }
      localBannerItem.msg_article_content_item.set(localContentBannerItem);
      return localBannerItem;
    }
    
    public String toString()
    {
      return " jump: " + this.jumpUrl;
    }
  }
  
  public static class e
  {
    public String linkUrl;
    public String title;
    
    public static e a(oidb_cmd0xbc9.MoreChannelItem paramMoreChannelItem)
    {
      e locale = new e();
      locale.title = paramMoreChannelItem.bytes_title.get().toStringUtf8();
      locale.linkUrl = paramMoreChannelItem.bytes_link_url.get().toStringUtf8();
      return locale;
    }
    
    public oidb_cmd0xbc9.MoreChannelItem a()
    {
      oidb_cmd0xbc9.MoreChannelItem localMoreChannelItem = new oidb_cmd0xbc9.MoreChannelItem();
      if (!TextUtils.isEmpty(this.title))
      {
        localMoreChannelItem.bytes_title.set(ByteStringMicro.copyFromUtf8(this.title));
        localMoreChannelItem.bytes_link_url.set(ByteStringMicro.copyFromUtf8(this.linkUrl));
      }
      return localMoreChannelItem;
    }
  }
  
  public static class f
    extends TopBannerInfo.b
  {
    public int aDs;
    public int aTh;
    public int aTi;
    public String accountName = "";
    public String aiB = "";
    public long feedsId;
    public int feedsType;
    public String shareUrl = "";
    public long vT;
    public String vid = "";
    public int videoHeight;
    public int videoWidth;
    
    public f()
    {
      super();
    }
    
    public static TopBannerInfo.b a(oidb_cmd0xbc9.BannerItem paramBannerItem)
    {
      if (!paramBannerItem.msg_video_banner_item.has()) {
        return null;
      }
      oidb_cmd0xbc9.VideoBannerItem localVideoBannerItem = (oidb_cmd0xbc9.VideoBannerItem)paramBannerItem.msg_video_banner_item.get();
      f localf = new f();
      if (localVideoBannerItem.bytes_share_url.has()) {
        localf.shareUrl = localVideoBannerItem.bytes_share_url.get().toStringUtf8();
      }
      if (localVideoBannerItem.uint32_video_duration.has()) {
        localf.aTh = localVideoBannerItem.uint32_video_duration.get();
      }
      if (localVideoBannerItem.uint32_video_width.has()) {
        localf.videoWidth = localVideoBannerItem.uint32_video_width.get();
      }
      if (localVideoBannerItem.uint32_video_height.has()) {
        localf.videoHeight = localVideoBannerItem.uint32_video_height.get();
      }
      if (localVideoBannerItem.bytes_video_vid.has()) {
        localf.vid = localVideoBannerItem.bytes_video_vid.get().toStringUtf8();
      }
      if (localVideoBannerItem.bytes_video_cover.has()) {
        localf.imgUrl = localVideoBannerItem.bytes_video_cover.get().toStringUtf8();
      }
      if (localVideoBannerItem.bytes_inner_uinque_id.has()) {
        localf.rowKey = localVideoBannerItem.bytes_inner_uinque_id.get().toStringUtf8();
      }
      if (localVideoBannerItem.uint32_busi_type.has()) {
        localf.aDs = localVideoBannerItem.uint32_busi_type.get();
      }
      if (localVideoBannerItem.bytes_title.has()) {
        localf.aiB = localVideoBannerItem.bytes_title.get().toStringUtf8();
      }
      if (localVideoBannerItem.bytes_account_name.has()) {
        localf.accountName = localVideoBannerItem.bytes_account_name.get().toStringUtf8();
      }
      if (localVideoBannerItem.uint64_account_uin.has()) {
        localf.vT = localVideoBannerItem.uint64_account_uin.get();
      }
      if (localVideoBannerItem.uint32_is_ugc.has()) {
        localf.aTi = localVideoBannerItem.uint32_is_ugc.get();
      }
      if (localVideoBannerItem.uint64_feeds_id.has()) {
        localf.feedsId = localVideoBannerItem.uint64_feeds_id.get();
      }
      if (localVideoBannerItem.uint32_feeds_type.has()) {
        localf.feedsType = localVideoBannerItem.uint32_feeds_type.get();
      }
      a(localf, paramBannerItem);
      a(paramBannerItem, localf);
      return localf;
    }
    
    public boolean DE()
    {
      return this.aTi == 1;
    }
    
    public oidb_cmd0xbc9.BannerItem a()
    {
      oidb_cmd0xbc9.BannerItem localBannerItem = super.a();
      oidb_cmd0xbc9.VideoBannerItem localVideoBannerItem = new oidb_cmd0xbc9.VideoBannerItem();
      if (!TextUtils.isEmpty(this.shareUrl)) {
        localVideoBannerItem.bytes_share_url.set(ByteStringMicro.copyFromUtf8(this.shareUrl));
      }
      localVideoBannerItem.uint32_video_duration.set(this.aTh);
      localVideoBannerItem.uint32_video_width.set(this.videoWidth);
      localVideoBannerItem.uint32_video_height.set(this.videoHeight);
      if (!TextUtils.isEmpty(this.vid)) {
        localVideoBannerItem.bytes_video_vid.set(ByteStringMicro.copyFromUtf8(this.vid));
      }
      if (!TextUtils.isEmpty(this.imgUrl)) {
        localVideoBannerItem.bytes_video_cover.set(ByteStringMicro.copyFromUtf8(this.imgUrl));
      }
      if (!TextUtils.isEmpty(this.rowKey)) {
        localVideoBannerItem.bytes_inner_uinque_id.set(ByteStringMicro.copyFromUtf8(this.rowKey));
      }
      localVideoBannerItem.uint32_busi_type.set(this.aDs);
      if (!TextUtils.isEmpty(this.aiB)) {
        localVideoBannerItem.bytes_title.set(ByteStringMicro.copyFromUtf8(this.aiB));
      }
      if (!TextUtils.isEmpty(this.accountName)) {
        localVideoBannerItem.bytes_account_name.set(ByteStringMicro.copyFromUtf8(this.accountName));
      }
      localVideoBannerItem.uint64_account_uin.set(this.vT);
      localVideoBannerItem.uint32_is_ugc.set(this.aTi);
      localVideoBannerItem.uint64_feeds_id.set(this.feedsId);
      localVideoBannerItem.uint32_feeds_type.set(this.feedsType);
      localBannerItem.msg_video_banner_item.set(localVideoBannerItem);
      return localBannerItem;
    }
    
    public String toString()
    {
      return super.toString() + " vid: " + this.vid + " puin : " + this.vT + " busitype " + this.aDs + " accountName : " + this.accountName + "  shareUrl : " + this.shareUrl + " isUgc " + this.aTi + " feedsId " + this.feedsId + " feedsType " + this.feedsType + " videoTitle: " + this.aiB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo
 * JD-Core Version:    0.7.0.1
 */