import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SimpleChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.readinjoy.Readinjoy.ArticleSummary;
import localpb.readinjoy.Readinjoy.ChannelInfo;
import localpb.readinjoy.Readinjoy.VideoData;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ArticleSummary;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ChannelInfo;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.VideoData;

public class myo
{
  public static BaseVideoArticleInfo a(Readinjoy.ArticleSummary paramArticleSummary)
  {
    boolean bool = true;
    if (paramArticleSummary != null) {}
    WeiShiVideoArticleInfo localWeiShiVideoArticleInfo;
    for (;;)
    {
      try
      {
        localWeiShiVideoArticleInfo = new WeiShiVideoArticleInfo();
        if (paramArticleSummary.uint64_article_id.has()) {
          localWeiShiVideoArticleInfo.articleID = paramArticleSummary.uint64_article_id.get();
        }
        if (paramArticleSummary.bytes_rowkey.has()) {
          localWeiShiVideoArticleInfo.rowkey = paramArticleSummary.bytes_rowkey.get().toStringUtf8();
        }
        if (paramArticleSummary.uint32_is_ugc.has())
        {
          if (paramArticleSummary.uint32_is_ugc.get() == 1) {
            localWeiShiVideoArticleInfo.isUgc = bool;
          }
        }
        else
        {
          if (paramArticleSummary.uint32_uptime.has()) {
            localWeiShiVideoArticleInfo.uptime = paramArticleSummary.uint32_uptime.get();
          }
          if (paramArticleSummary.uint32_feeds_type.has()) {
            localWeiShiVideoArticleInfo.feedsType = paramArticleSummary.uint32_feeds_type.get();
          }
          if (paramArticleSummary.uint32_video_count.has()) {
            localWeiShiVideoArticleInfo.videoCount = paramArticleSummary.uint32_video_count.get();
          }
          if (paramArticleSummary.uint32_strategy_id.has()) {
            localWeiShiVideoArticleInfo.strategyID = paramArticleSummary.uint32_strategy_id.get();
          }
          if (paramArticleSummary.bytes_article_title.has()) {
            localWeiShiVideoArticleInfo.title = paramArticleSummary.bytes_article_title.get().toStringUtf8();
          }
          if (paramArticleSummary.bytes_article_summary.has()) {
            localWeiShiVideoArticleInfo.summary = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
          }
          if (paramArticleSummary.bytes_first_page_pic_url.has()) {
            localWeiShiVideoArticleInfo.pagePicUrl = paramArticleSummary.bytes_first_page_pic_url.get().toStringUtf8();
          }
          if (paramArticleSummary.bytes_article_content_url.has()) {
            localWeiShiVideoArticleInfo.articleContentUrl = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
          }
          if (paramArticleSummary.uint64_time.has()) {
            localWeiShiVideoArticleInfo.time = paramArticleSummary.uint64_time.get();
          }
          if (paramArticleSummary.uint32_comment_count.has()) {
            localWeiShiVideoArticleInfo.commentCount = paramArticleSummary.uint32_comment_count.get();
          }
          if (paramArticleSummary.bytes_name.has()) {
            localWeiShiVideoArticleInfo.subscribeName = paramArticleSummary.bytes_name.get().toStringUtf8();
          }
          if (paramArticleSummary.bytes_icon.has()) {
            localWeiShiVideoArticleInfo.subscribeIcon = paramArticleSummary.bytes_icon.get().toStringUtf8();
          }
          if (paramArticleSummary.bytes_uin.has()) {
            localWeiShiVideoArticleInfo.subscribeID = paramArticleSummary.bytes_uin.get().toStringUtf8();
          }
          if (paramArticleSummary.uint64_recommend_time.has()) {
            localWeiShiVideoArticleInfo.recommendTime = paramArticleSummary.uint64_recommend_time.get();
          }
          if (paramArticleSummary.uint64_recommend_seq.has()) {
            localWeiShiVideoArticleInfo.recommendSeq = paramArticleSummary.uint64_recommend_seq.get();
          }
          if (paramArticleSummary.uint64_algorithm_id.has()) {
            localWeiShiVideoArticleInfo.algorithmID = paramArticleSummary.uint64_algorithm_id.get();
          }
          if (paramArticleSummary.bytes_recommend_reason.has()) {
            localWeiShiVideoArticleInfo.recommendReason = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
          }
          if (paramArticleSummary.msg_video_data.has())
          {
            localObject1 = paramArticleSummary.msg_video_data;
            localObject2 = new min();
            localWeiShiVideoArticleInfo.videoData = ((min)localObject2);
            if (((Readinjoy.VideoData)localObject1).uint32_busi_type.has()) {
              ((min)localObject2).busiType = ((Readinjoy.VideoData)localObject1).uint32_busi_type.get();
            }
            if (((Readinjoy.VideoData)localObject1).uint32_duration.has()) {
              ((min)localObject2).duration = ((Readinjoy.VideoData)localObject1).uint32_duration.get();
            }
            if (((Readinjoy.VideoData)localObject1).uint32_width.has()) {
              ((min)localObject2).width = ((Readinjoy.VideoData)localObject1).uint32_width.get();
            }
            if (((Readinjoy.VideoData)localObject1).uint32_height.has()) {
              ((min)localObject2).height = ((Readinjoy.VideoData)localObject1).uint32_height.get();
            }
            if (((Readinjoy.VideoData)localObject1).bytes_vid.has()) {
              ((min)localObject2).vid = ((Readinjoy.VideoData)localObject1).bytes_vid.get().toStringUtf8();
            }
            if (((Readinjoy.VideoData)localObject1).uint32_file_size.has()) {
              ((min)localObject2).fileSize = ((Readinjoy.VideoData)localObject1).uint32_file_size.get();
            }
            if (((Readinjoy.VideoData)localObject1).bytes_video_url.has()) {
              ((min)localObject2).videoUrl = ((Readinjoy.VideoData)localObject1).bytes_video_url.get().toStringUtf8();
            }
          }
          if ((paramArticleSummary.msg_channel_info.has()) && (paramArticleSummary.msg_channel_info.get() != null))
          {
            if (paramArticleSummary.msg_channel_info.uint32_channel_id.has()) {
              localWeiShiVideoArticleInfo.channelID = paramArticleSummary.msg_channel_info.uint32_channel_id.get();
            }
            if (paramArticleSummary.msg_channel_info.uint32_channel_type.has()) {
              localWeiShiVideoArticleInfo.channelType = paramArticleSummary.msg_channel_info.uint32_channel_type.get();
            }
          }
          if (paramArticleSummary.bytes_push_context.has()) {
            localWeiShiVideoArticleInfo.pushContext = paramArticleSummary.bytes_push_context.get().toStringUtf8();
          }
          if (paramArticleSummary.uint32_play_count.has()) {
            localWeiShiVideoArticleInfo.videoPlayCount = paramArticleSummary.uint32_play_count.get();
          }
          if (!paramArticleSummary.rpt_label_list.has()) {
            break;
          }
          localWeiShiVideoArticleInfo.labelList = new ArrayList();
          Object localObject1 = paramArticleSummary.rpt_label_list.get().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject2 = (Readinjoy.ChannelInfo)((Iterator)localObject1).next();
          localWeiShiVideoArticleInfo.labelList.add(a((Readinjoy.ChannelInfo)localObject2));
          continue;
          return null;
        }
      }
      catch (Throwable paramArticleSummary)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoProtoHelper", 0, "cmd0xbedToWeiShiVideoArticleInfo error:" + paramArticleSummary);
        }
      }
      bool = false;
    }
    if (paramArticleSummary.uint32_ads_jump_type.has()) {
      localWeiShiVideoArticleInfo.adsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
    }
    if (paramArticleSummary.bytes_ads_jump_url.has()) {
      localWeiShiVideoArticleInfo.adsJumpUrl = paramArticleSummary.bytes_ads_jump_url.get().toStringUtf8();
    }
    if (paramArticleSummary.bytes_video_report_info.has()) {
      localWeiShiVideoArticleInfo.videoReportInfo = paramArticleSummary.bytes_video_report_info.get().toStringUtf8();
    }
    if (paramArticleSummary.uint32_article_style.has()) {
      localWeiShiVideoArticleInfo.articleStyle = paramArticleSummary.uint32_article_style.get();
    }
    if (paramArticleSummary.bytes_business_info.has()) {
      localWeiShiVideoArticleInfo.businessInfo = paramArticleSummary.bytes_business_info.get().toByteArray();
    }
    if (paramArticleSummary.bytes_video_subscript_txt.has()) {
      localWeiShiVideoArticleInfo.videoSubscriptTxt = paramArticleSummary.bytes_video_subscript_txt.get().toStringUtf8();
    }
    if (paramArticleSummary.bytes_video_subscript_color.has()) {
      localWeiShiVideoArticleInfo.videoSubscriptColor = paramArticleSummary.bytes_video_subscript_color.get().toStringUtf8();
    }
    return localWeiShiVideoArticleInfo;
  }
  
  private static SimpleChannelInfo a(Readinjoy.ChannelInfo paramChannelInfo)
  {
    SimpleChannelInfo localSimpleChannelInfo = new SimpleChannelInfo();
    if ((paramChannelInfo != null) && (paramChannelInfo.has()))
    {
      if (paramChannelInfo.bytes_channel_name.has()) {
        localSimpleChannelInfo.name = paramChannelInfo.bytes_channel_name.get().toStringUtf8();
      }
      if (paramChannelInfo.uint32_channel_type.has()) {
        localSimpleChannelInfo.vL = paramChannelInfo.uint32_channel_type.get();
      }
      if (paramChannelInfo.uint32_channel_id.has()) {
        localSimpleChannelInfo.channelID = paramChannelInfo.uint32_channel_id.get();
      }
    }
    return localSimpleChannelInfo;
  }
  
  private static SimpleChannelInfo a(oidb_cmd0xbed.ChannelInfo paramChannelInfo)
  {
    SimpleChannelInfo localSimpleChannelInfo = new SimpleChannelInfo();
    if ((paramChannelInfo != null) && (paramChannelInfo.has()))
    {
      if (paramChannelInfo.bytes_channel_name.has()) {
        localSimpleChannelInfo.name = paramChannelInfo.bytes_channel_name.get().toStringUtf8();
      }
      if (paramChannelInfo.uint32_channel_type.has()) {
        localSimpleChannelInfo.vL = paramChannelInfo.uint32_channel_type.get();
      }
      if (paramChannelInfo.uint32_channel_id.has()) {
        localSimpleChannelInfo.channelID = paramChannelInfo.uint32_channel_id.get();
      }
    }
    return localSimpleChannelInfo;
  }
  
  public static WeiShiVideoArticleInfo a(oidb_cmd0xbed.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    WeiShiVideoArticleInfo localWeiShiVideoArticleInfo;
    Object localObject1;
    Object localObject2;
    if (paramArticleSummary != null)
    {
      localWeiShiVideoArticleInfo = new WeiShiVideoArticleInfo();
      for (;;)
      {
        try
        {
          if (paramArticleSummary.uint64_article_id.has()) {
            localWeiShiVideoArticleInfo.articleID = paramArticleSummary.uint64_article_id.get();
          }
          if (paramArticleSummary.bytes_rowkey.has()) {
            localWeiShiVideoArticleInfo.rowkey = paramArticleSummary.bytes_rowkey.get().toStringUtf8();
          }
          if (paramArticleSummary.uint32_is_ugc.has())
          {
            if (paramArticleSummary.uint32_is_ugc.get() == 1) {
              localWeiShiVideoArticleInfo.isUgc = bool;
            }
          }
          else
          {
            if (paramArticleSummary.uint32_uptime.has()) {
              localWeiShiVideoArticleInfo.uptime = paramArticleSummary.uint32_uptime.get();
            }
            if (paramArticleSummary.uint32_feeds_type.has()) {
              localWeiShiVideoArticleInfo.feedsType = paramArticleSummary.uint32_feeds_type.get();
            }
            if (paramArticleSummary.uint32_video_count.has()) {
              localWeiShiVideoArticleInfo.videoCount = paramArticleSummary.uint32_video_count.get();
            }
            if (paramArticleSummary.uint32_strategy_id.has()) {
              localWeiShiVideoArticleInfo.strategyID = paramArticleSummary.uint32_strategy_id.get();
            }
            if (paramArticleSummary.bytes_article_title.has()) {
              localWeiShiVideoArticleInfo.title = paramArticleSummary.bytes_article_title.get().toStringUtf8();
            }
            if (paramArticleSummary.bytes_article_summary.has()) {
              localWeiShiVideoArticleInfo.summary = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
            }
            if (paramArticleSummary.bytes_first_page_pic_url.has()) {
              localWeiShiVideoArticleInfo.pagePicUrl = paramArticleSummary.bytes_first_page_pic_url.get().toStringUtf8();
            }
            if (paramArticleSummary.bytes_article_content_url.has()) {
              localWeiShiVideoArticleInfo.articleContentUrl = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
            }
            if (paramArticleSummary.uint64_time.has()) {
              localWeiShiVideoArticleInfo.time = paramArticleSummary.uint64_time.get();
            }
            if (paramArticleSummary.uint32_comment_count.has()) {
              localWeiShiVideoArticleInfo.commentCount = paramArticleSummary.uint32_comment_count.get();
            }
            if (paramArticleSummary.bytes_name.has()) {
              localWeiShiVideoArticleInfo.subscribeName = paramArticleSummary.bytes_name.get().toStringUtf8();
            }
            if (paramArticleSummary.bytes_icon.has()) {
              localWeiShiVideoArticleInfo.subscribeIcon = paramArticleSummary.bytes_icon.get().toStringUtf8();
            }
            if (paramArticleSummary.bytes_uin.has()) {
              localWeiShiVideoArticleInfo.subscribeID = paramArticleSummary.bytes_uin.get().toStringUtf8();
            }
            if (paramArticleSummary.uint64_recommend_time.has()) {
              localWeiShiVideoArticleInfo.recommendTime = paramArticleSummary.uint64_recommend_time.get();
            }
            if (paramArticleSummary.uint64_recommend_seq.has()) {
              localWeiShiVideoArticleInfo.recommendSeq = paramArticleSummary.uint64_recommend_seq.get();
            }
            if (paramArticleSummary.uint64_algorithm_id.has()) {
              localWeiShiVideoArticleInfo.algorithmID = paramArticleSummary.uint64_algorithm_id.get();
            }
            if (paramArticleSummary.bytes_recommend_reason.has()) {
              localWeiShiVideoArticleInfo.recommendReason = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
            }
            if (paramArticleSummary.msg_video_data.has())
            {
              localObject1 = paramArticleSummary.msg_video_data;
              localObject2 = new min();
              localWeiShiVideoArticleInfo.videoData = ((min)localObject2);
              if (((oidb_cmd0xbed.VideoData)localObject1).uint32_busi_type.has()) {
                ((min)localObject2).busiType = ((oidb_cmd0xbed.VideoData)localObject1).uint32_busi_type.get();
              }
              if (((oidb_cmd0xbed.VideoData)localObject1).uint32_duration.has()) {
                ((min)localObject2).duration = ((oidb_cmd0xbed.VideoData)localObject1).uint32_duration.get();
              }
              if (((oidb_cmd0xbed.VideoData)localObject1).uint32_width.has()) {
                ((min)localObject2).width = ((oidb_cmd0xbed.VideoData)localObject1).uint32_width.get();
              }
              if (((oidb_cmd0xbed.VideoData)localObject1).uint32_height.has()) {
                ((min)localObject2).height = ((oidb_cmd0xbed.VideoData)localObject1).uint32_height.get();
              }
              if (((oidb_cmd0xbed.VideoData)localObject1).bytes_vid.has()) {
                ((min)localObject2).vid = ((oidb_cmd0xbed.VideoData)localObject1).bytes_vid.get().toStringUtf8();
              }
              if (((oidb_cmd0xbed.VideoData)localObject1).uint32_file_size.has()) {
                ((min)localObject2).fileSize = ((oidb_cmd0xbed.VideoData)localObject1).uint32_file_size.get();
              }
              if (((oidb_cmd0xbed.VideoData)localObject1).bytes_video_url.has()) {
                ((min)localObject2).videoUrl = ((oidb_cmd0xbed.VideoData)localObject1).bytes_video_url.get().toStringUtf8();
              }
            }
            localWeiShiVideoArticleInfo.channelID = paramInt1;
            localWeiShiVideoArticleInfo.channelType = paramInt2;
            if ((paramArticleSummary.msg_channel_info.has()) && (paramArticleSummary.msg_channel_info.get() != null))
            {
              if (paramArticleSummary.msg_channel_info.uint32_channel_id.has()) {
                localWeiShiVideoArticleInfo.channelID = paramArticleSummary.msg_channel_info.uint32_channel_id.get();
              }
              if (paramArticleSummary.msg_channel_info.uint32_channel_type.has()) {
                localWeiShiVideoArticleInfo.channelType = paramArticleSummary.msg_channel_info.uint32_channel_type.get();
              }
            }
            if (paramArticleSummary.bytes_push_context.has()) {
              localWeiShiVideoArticleInfo.pushContext = paramArticleSummary.bytes_push_context.get().toStringUtf8();
            }
            if (paramArticleSummary.uint32_play_count.has()) {
              localWeiShiVideoArticleInfo.videoPlayCount = paramArticleSummary.uint32_play_count.get();
            }
            if (!paramArticleSummary.rpt_label_list.has()) {
              break;
            }
            localWeiShiVideoArticleInfo.labelList = new ArrayList();
            localObject1 = paramArticleSummary.rpt_label_list.get().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = a((oidb_cmd0xbed.ChannelInfo)((Iterator)localObject1).next());
            if (localObject2 == null) {
              continue;
            }
            localWeiShiVideoArticleInfo.labelList.add(localObject2);
            continue;
            return localWeiShiVideoArticleInfo;
          }
        }
        catch (Throwable paramArticleSummary)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoProtoHelper", 0, "cmd0xbedToWeiShiVideoArticleInfo error:" + kxm.getStackTrace(paramArticleSummary));
          }
        }
        bool = false;
      }
      if (paramArticleSummary.uint32_ads_jump_type.has()) {
        localWeiShiVideoArticleInfo.adsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
      }
      if (paramArticleSummary.bytes_ads_jump_url.has()) {
        localWeiShiVideoArticleInfo.adsJumpUrl = paramArticleSummary.bytes_ads_jump_url.get().toStringUtf8();
      }
      if (paramArticleSummary.bytes_video_report_info.has()) {
        localWeiShiVideoArticleInfo.videoReportInfo = paramArticleSummary.bytes_video_report_info.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_article_style.has()) {
        localWeiShiVideoArticleInfo.articleStyle = paramArticleSummary.uint32_article_style.get();
      }
      if (paramArticleSummary.bytes_business_info.has()) {
        localWeiShiVideoArticleInfo.businessInfo = paramArticleSummary.bytes_business_info.get().toByteArray();
      }
      label1157:
      if (paramArticleSummary.rpt_article_list.has())
      {
        localWeiShiVideoArticleInfo.articleList = new ArrayList();
        paramInt1 = 0;
        label1101:
        if (paramInt1 < paramArticleSummary.rpt_article_list.get().size())
        {
          localObject1 = (oidb_cmd0xbed.ArticleSummary)((oidb_cmd0xbed.ArticleSummary)paramArticleSummary.rpt_article_list.get(paramInt1)).get();
          localObject2 = a(paramArticleSummary.msg_channel_info);
          if (localObject2 == null) {
            break label1261;
          }
          paramInt2 = (int)((SimpleChannelInfo)localObject2).channelID;
          if (localObject2 == null) {
            break label1266;
          }
        }
      }
    }
    label1254:
    label1261:
    label1266:
    for (int i = (int)((SimpleChannelInfo)localObject2).vL;; i = 0)
    {
      localObject1 = a((oidb_cmd0xbed.ArticleSummary)localObject1, paramInt2, i);
      if (localObject1 != null)
      {
        localWeiShiVideoArticleInfo.articleList.add(localObject1);
        break label1254;
        if (paramArticleSummary.bytes_video_subscript_txt.has()) {
          localWeiShiVideoArticleInfo.videoSubscriptTxt = paramArticleSummary.bytes_video_subscript_txt.get().toStringUtf8();
        }
        if (!paramArticleSummary.bytes_video_subscript_color.has()) {
          break;
        }
        localWeiShiVideoArticleInfo.videoSubscriptColor = paramArticleSummary.bytes_video_subscript_color.get().toStringUtf8();
        break;
        return null;
      }
      paramInt1 += 1;
      break label1101;
      paramInt2 = 0;
      break label1157;
    }
  }
  
  public static Readinjoy.ArticleSummary a(BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    Readinjoy.ArticleSummary localArticleSummary = new Readinjoy.ArticleSummary();
    for (;;)
    {
      try
      {
        localArticleSummary.uint64_article_id.set(paramBaseVideoArticleInfo.articleID);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.rowkey)) {
          localArticleSummary.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.rowkey));
        }
        Object localObject = localArticleSummary.uint32_is_ugc;
        if (!paramBaseVideoArticleInfo.isUgc) {
          continue;
        }
        i = 1;
        ((PBUInt32Field)localObject).set(i);
        localArticleSummary.uint32_uptime.set(paramBaseVideoArticleInfo.uptime);
        localArticleSummary.uint32_feeds_type.set(paramBaseVideoArticleInfo.feedsType);
        localArticleSummary.uint32_video_count.set(paramBaseVideoArticleInfo.videoCount);
        localArticleSummary.uint32_strategy_id.set(paramBaseVideoArticleInfo.strategyID);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.title)) {
          localArticleSummary.bytes_article_title.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.title));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.summary)) {
          localArticleSummary.bytes_article_summary.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.summary));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.articleContentUrl)) {
          localArticleSummary.bytes_article_content_url.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.articleContentUrl));
        }
        localArticleSummary.uint64_time.set(paramBaseVideoArticleInfo.time);
        localArticleSummary.uint32_comment_count.set(paramBaseVideoArticleInfo.commentCount);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.subscribeName)) {
          localArticleSummary.bytes_name.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.subscribeName));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.subscribeIcon)) {
          localArticleSummary.bytes_icon.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.subscribeIcon));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.subscribeID)) {
          localArticleSummary.bytes_uin.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.subscribeID));
        }
        localArticleSummary.uint64_recommend_time.set(paramBaseVideoArticleInfo.recommendTime);
        localArticleSummary.uint64_recommend_seq.set(paramBaseVideoArticleInfo.recommendSeq);
        localArticleSummary.uint64_algorithm_id.set(paramBaseVideoArticleInfo.algorithmID);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.recommendReason)) {
          localArticleSummary.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.recommendReason));
        }
        if (paramBaseVideoArticleInfo.videoData != null) {
          localArticleSummary.msg_video_data.set(a(paramBaseVideoArticleInfo.videoData));
        }
        localObject = new Readinjoy.ChannelInfo();
        ((Readinjoy.ChannelInfo)localObject).uint32_channel_id.set(paramBaseVideoArticleInfo.channelID);
        ((Readinjoy.ChannelInfo)localObject).uint32_channel_type.set(paramBaseVideoArticleInfo.channelType);
        localArticleSummary.msg_channel_info.set((MessageMicro)localObject);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.pushContext)) {
          localArticleSummary.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.pushContext));
        }
        localArticleSummary.uint32_play_count.set(paramBaseVideoArticleInfo.videoPlayCount);
        localArticleSummary.uint32_ads_jump_type.set(paramBaseVideoArticleInfo.adsJumpType);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.adsJumpUrl)) {
          localArticleSummary.bytes_ads_jump_url.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.adsJumpUrl));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.videoReportInfo)) {
          localArticleSummary.bytes_video_report_info.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.videoReportInfo));
        }
        localArticleSummary.uint32_article_style.set(paramBaseVideoArticleInfo.articleStyle);
        if (paramBaseVideoArticleInfo.businessInfo != null) {
          localArticleSummary.bytes_business_info.set(ByteStringMicro.copyFrom(paramBaseVideoArticleInfo.businessInfo));
        }
        if ((paramBaseVideoArticleInfo instanceof WeiShiVideoArticleInfo))
        {
          if (!TextUtils.isEmpty(((WeiShiVideoArticleInfo)paramBaseVideoArticleInfo).videoSubscriptTxt)) {
            localArticleSummary.bytes_video_subscript_txt.set(ByteStringMicro.copyFromUtf8(((WeiShiVideoArticleInfo)paramBaseVideoArticleInfo).videoSubscriptTxt));
          }
          if (!TextUtils.isEmpty(((WeiShiVideoArticleInfo)paramBaseVideoArticleInfo).videoSubscriptColor)) {
            localArticleSummary.bytes_video_subscript_color.set(ByteStringMicro.copyFromUtf8(((WeiShiVideoArticleInfo)paramBaseVideoArticleInfo).videoSubscriptColor));
          }
        }
      }
      catch (Throwable paramBaseVideoArticleInfo)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("VideoProtoHelper", 0, "videoArticleinfoCovert2LocalPB error:" + kxm.getStackTrace(paramBaseVideoArticleInfo));
      }
      return localArticleSummary;
      i = 0;
    }
    return localArticleSummary;
  }
  
  public static Readinjoy.VideoData a(min parammin)
  {
    Object localObject;
    if (parammin == null) {
      localObject = null;
    }
    Readinjoy.VideoData localVideoData;
    do
    {
      return localObject;
      localVideoData = new Readinjoy.VideoData();
      localVideoData.uint32_busi_type.set(parammin.busiType);
      localVideoData.uint32_duration.set(parammin.duration);
      localVideoData.uint32_width.set(parammin.width);
      localVideoData.uint32_height.set(parammin.height);
      if (!TextUtils.isEmpty(parammin.vid)) {
        localVideoData.bytes_vid.set(ByteStringMicro.copyFromUtf8(parammin.vid));
      }
      localVideoData.uint32_file_size.set(parammin.fileSize);
      localObject = localVideoData;
    } while (TextUtils.isEmpty(parammin.videoUrl));
    localVideoData.bytes_video_url.set(ByteStringMicro.copyFromUtf8(parammin.videoUrl));
    return localVideoData;
  }
  
  public static min a(Readinjoy.VideoData paramVideoData)
  {
    Object localObject = null;
    if (paramVideoData == null) {}
    min localmin;
    do
    {
      do
      {
        return localObject;
      } while (!paramVideoData.has());
      localmin = new min();
      if (paramVideoData.uint32_busi_type.has()) {
        localmin.busiType = paramVideoData.uint32_busi_type.get();
      }
      if (paramVideoData.uint32_duration.has()) {
        localmin.duration = paramVideoData.uint32_duration.get();
      }
      if (paramVideoData.uint32_width.has()) {
        localmin.width = paramVideoData.uint32_width.get();
      }
      if (paramVideoData.uint32_height.has()) {
        localmin.height = paramVideoData.uint32_height.get();
      }
      if (paramVideoData.bytes_vid.has()) {
        localmin.vid = paramVideoData.bytes_vid.get().toStringUtf8();
      }
      if (paramVideoData.uint32_file_size.has()) {
        localmin.fileSize = paramVideoData.uint32_file_size.get();
      }
      localObject = localmin;
    } while (!paramVideoData.bytes_video_url.has());
    localmin.videoUrl = paramVideoData.bytes_video_url.get().toStringUtf8();
    return localmin;
  }
  
  public static List<WeiShiVideoArticleInfo> b(List<oidb_cmd0xbed.ArticleSummary> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((oidb_cmd0xbed.ArticleSummary)paramList.next(), paramInt1, paramInt2));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myo
 * JD-Core Version:    0.7.0.1
 */