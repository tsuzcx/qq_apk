import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.AdTagInfo;
import com.tencent.biz.pubaccount.VideoInfo.ClassInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.VideoInfo.KdTagItem;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.ClassInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.KdTagItem;
import tencent.im.oidb.cmd0x885.oidb_0x885.PosAdInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;

public class jzq
{
  public static ArrayList<oidb_0x885.AdTagInfo> V(ArrayList<VideoInfo.AdTagInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (VideoInfo.AdTagInfo)paramArrayList.next();
      oidb_0x885.AdTagInfo localAdTagInfo = new oidb_0x885.AdTagInfo();
      localAdTagInfo.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(((VideoInfo.AdTagInfo)localObject1).rowkey));
      localAdTagInfo.int32_display_ad_flag.set(((VideoInfo.AdTagInfo)localObject1).aHj);
      localAdTagInfo.int32_pos.set(((VideoInfo.AdTagInfo)localObject1).pos);
      if (!TextUtils.isEmpty(((VideoInfo.AdTagInfo)localObject1).WK)) {
        localAdTagInfo.string_ad_feature_info.set(((VideoInfo.AdTagInfo)localObject1).WK);
      }
      Object localObject3 = ((VideoInfo.AdTagInfo)localObject1).jU;
      Object localObject2;
      if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty()))
      {
        localObject2 = new ArrayList(((ArrayList)localObject3).size());
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          VideoInfo.KdTagItem localKdTagItem = (VideoInfo.KdTagItem)((Iterator)localObject3).next();
          oidb_0x885.KdTagItem localKdTagItem1 = new oidb_0x885.KdTagItem();
          localKdTagItem1.bytes_name.set(ByteStringMicro.copyFromUtf8(localKdTagItem.name));
          localKdTagItem1.uint64_tagid.set(localKdTagItem.rE);
          ((ArrayList)localObject2).add(localKdTagItem1);
        }
        localAdTagInfo.rpt_kd_tag_list.set((List)localObject2);
      }
      localObject1 = ((VideoInfo.AdTagInfo)localObject1).a;
      if (localObject1 != null)
      {
        localObject2 = new oidb_0x885.ClassInfo();
        ((oidb_0x885.ClassInfo)localObject2).string_ch1.set(((VideoInfo.ClassInfo)localObject1).WN);
        ((oidb_0x885.ClassInfo)localObject2).uint64_ch1_id.set(((VideoInfo.ClassInfo)localObject1).rB);
        ((oidb_0x885.ClassInfo)localObject2).string_ch2.set(((VideoInfo.ClassInfo)localObject1).WO);
        ((oidb_0x885.ClassInfo)localObject2).uint64_ch2_id.set(((VideoInfo.ClassInfo)localObject1).rC);
        ((oidb_0x885.ClassInfo)localObject2).string_ch3.set(((VideoInfo.ClassInfo)localObject1).WP);
        ((oidb_0x885.ClassInfo)localObject2).uint64_ch3_id.set(((VideoInfo.ClassInfo)localObject1).rD);
        localAdTagInfo.msg_class_info.set((MessageMicro)localObject2);
      }
      localArrayList.add(localAdTagInfo);
    }
    return localArrayList;
  }
  
  public static void a(oidb_0x6cf.ArticleSummary paramArticleSummary, VideoInfo paramVideoInfo)
  {
    if (paramArticleSummary.msg_kd_tag_info.has())
    {
      paramVideoInfo.a = new VideoInfo.AdTagInfo();
      if (paramArticleSummary.msg_kd_tag_info.bytes_rowkey.has()) {
        paramVideoInfo.a.rowkey = paramArticleSummary.msg_kd_tag_info.bytes_rowkey.get().toStringUtf8();
      }
      if (paramArticleSummary.msg_kd_tag_info.int32_display_ad_flag.has()) {
        paramVideoInfo.a.aHj = paramArticleSummary.msg_kd_tag_info.int32_display_ad_flag.get();
      }
      if (paramVideoInfo.a.aHj == 0)
      {
        Object localObject2;
        Object localObject3;
        Object localObject1;
        if (paramArticleSummary.msg_kd_tag_info.msg_class_info.has())
        {
          localObject2 = (oidb_0x885.ClassInfo)paramArticleSummary.msg_kd_tag_info.msg_class_info.get();
          paramVideoInfo.a.a = new VideoInfo.ClassInfo();
          localObject3 = paramVideoInfo.a.a;
          if (((oidb_0x885.ClassInfo)localObject2).string_ch1.has())
          {
            localObject1 = ((oidb_0x885.ClassInfo)localObject2).string_ch1.get();
            ((VideoInfo.ClassInfo)localObject3).WN = ((String)localObject1);
            localObject3 = paramVideoInfo.a.a;
            if (!((oidb_0x885.ClassInfo)localObject2).string_ch2.has()) {
              break label527;
            }
            localObject1 = ((oidb_0x885.ClassInfo)localObject2).string_ch2.get();
            label203:
            ((VideoInfo.ClassInfo)localObject3).WO = ((String)localObject1);
            localObject3 = paramVideoInfo.a.a;
            if (!((oidb_0x885.ClassInfo)localObject2).string_ch3.has()) {
              break label534;
            }
            localObject1 = ((oidb_0x885.ClassInfo)localObject2).string_ch3.get();
            label240:
            ((VideoInfo.ClassInfo)localObject3).WP = ((String)localObject1);
            localObject1 = paramVideoInfo.a.a;
            if (!((oidb_0x885.ClassInfo)localObject2).uint64_ch1_id.has()) {
              break label541;
            }
            l = ((oidb_0x885.ClassInfo)localObject2).uint64_ch1_id.get();
            label276:
            ((VideoInfo.ClassInfo)localObject1).rB = l;
            localObject1 = paramVideoInfo.a.a;
            if (!((oidb_0x885.ClassInfo)localObject2).uint64_ch2_id.has()) {
              break label546;
            }
            l = ((oidb_0x885.ClassInfo)localObject2).uint64_ch2_id.get();
            label311:
            ((VideoInfo.ClassInfo)localObject1).rC = l;
            localObject1 = paramVideoInfo.a.a;
            if (!((oidb_0x885.ClassInfo)localObject2).uint64_ch3_id.has()) {
              break label551;
            }
            l = ((oidb_0x885.ClassInfo)localObject2).uint64_ch3_id.get();
            label346:
            ((VideoInfo.ClassInfo)localObject1).rD = l;
          }
        }
        else
        {
          if (paramArticleSummary.msg_kd_tag_info.string_ad_feature_info.has()) {
            paramVideoInfo.a.WK = paramArticleSummary.msg_kd_tag_info.string_ad_feature_info.get();
          }
          if (!paramArticleSummary.msg_kd_tag_info.rpt_kd_tag_list.has()) {
            return;
          }
          localObject1 = new ArrayList(paramArticleSummary.msg_kd_tag_info.rpt_kd_tag_list.size());
          paramArticleSummary = paramArticleSummary.msg_kd_tag_info.rpt_kd_tag_list.get().iterator();
          label430:
          if (!paramArticleSummary.hasNext()) {
            break label561;
          }
          localObject2 = (oidb_0x885.KdTagItem)paramArticleSummary.next();
          localObject3 = new VideoInfo.KdTagItem();
          if (((oidb_0x885.KdTagItem)localObject2).bytes_name.has()) {
            ((VideoInfo.KdTagItem)localObject3).name = kxm.a(((oidb_0x885.KdTagItem)localObject2).bytes_name);
          }
          if (!((oidb_0x885.KdTagItem)localObject2).uint64_tagid.has()) {
            break label556;
          }
        }
        label527:
        label534:
        label541:
        label546:
        label551:
        label556:
        for (long l = ((oidb_0x885.KdTagItem)localObject2).uint64_tagid.get();; l = 0L)
        {
          ((VideoInfo.KdTagItem)localObject3).rE = l;
          ((ArrayList)localObject1).add(localObject3);
          break label430;
          localObject1 = "";
          break;
          localObject1 = "";
          break label203;
          localObject1 = "";
          break label240;
          l = 0L;
          break label276;
          l = 0L;
          break label311;
          l = 0L;
          break label346;
        }
        label561:
        paramVideoInfo.a.jU = ((ArrayList)localObject1);
      }
    }
  }
  
  public static void a(oidb_0x6cf.RspBody paramRspBody, Bundle paramBundle, long paramLong)
  {
    Object localObject3;
    try
    {
      if (paramRspBody.msg_ad_rsp.has())
      {
        QLog.d("VideoFeedsAdTagHelper", 2, "rspBody.rpt_msg_pos_ad_info is not null");
        paramRspBody = (oidb_0x885.RspBody)paramRspBody.msg_ad_rsp.get();
        if ((!paramRspBody.rpt_msg_pos_ad_info.has()) || (paramRspBody.rpt_msg_pos_ad_info.get().isEmpty())) {
          break label452;
        }
        Object localObject1 = paramRspBody.rpt_msg_pos_ad_info.get();
        QLog.d("VideoFeedsAdTagHelper", 2, "rspBody.rpt_msg_pos_ad_info posAdInfos size >>" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          paramRspBody = new ArrayList(((List)localObject1).size());
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label436;
            }
            Object localObject4 = (oidb_0x885.PosAdInfo)((Iterator)localObject1).next();
            if ((((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.has()) && (!((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.isEmpty()))
            {
              localObject3 = (oidb_0x885.AdInfo)((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.get(0);
              Object localObject2 = ((oidb_0x885.AdInfo)localObject3).bytes_rowkey.get().toStringUtf8();
              localObject3 = kjs.a((oidb_0x885.AdInfo)localObject3);
              int i = ((oidb_0x885.PosAdInfo)localObject4).enum_pos_layout.get();
              long l1 = ((oidb_0x885.PosAdInfo)localObject4).uint64_pos_id.get();
              long l2 = ((oidb_0x885.PosAdInfo)localObject4).is_auto_play.get();
              ((AdvertisementInfo)localObject3).mAdFetchTime = paramLong;
              ((AdvertisementInfo)localObject3).mAdPosLayout = i;
              ((AdvertisementInfo)localObject3).mAdPosID = l1;
              ((AdvertisementInfo)localObject3).mADVideoAutoPlay = l2;
              ((AdvertisementInfo)localObject3).mRowKey = ((String)localObject2);
              if (((AdvertisementInfo)localObject3).mSoftAdType != 1) {
                break;
              }
              localObject4 = ((AdvertisementInfo)localObject3).mAdExt;
              try
              {
                localObject2 = new VideoInfo.GameAdComData((String)localObject2, new JSONObject((String)localObject4));
                if ((TextUtils.isEmpty(((VideoInfo.GameAdComData)localObject2).Xk)) || (TextUtils.isEmpty(((VideoInfo.GameAdComData)localObject2).WX))) {
                  continue;
                }
                ((AdvertisementInfo)localObject3).gameAdComData = ((VideoInfo.GameAdComData)localObject2);
                paramRspBody.add(localObject3);
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel()) {
                QLog.d("VideoFeedsAdTagHelper", 2, localException.getMessage());
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramRspBody)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsAdTagHelper", 2, "handleGetRecommendList: parse game ad info error, e= " + paramRspBody.getMessage());
      }
    }
    label436:
    label452:
    do
    {
      do
      {
        if (((AdvertisementInfo)localObject3).mAdPosID <= 0L) {
          ((AdvertisementInfo)localObject3).mAdPosID = 1L;
        }
        paramRspBody.add(localObject3);
        break;
      } while (paramRspBody.isEmpty());
      paramBundle.putParcelableArrayList("value_msg_game_ad_info", paramRspBody);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsAdTagHelper", 2, "rspBody.rpt_msg_pos_ad_info null ");
  }
  
  public static void c(Bundle paramBundle, ArrayList<VideoInfo> paramArrayList)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!paramArrayList.isEmpty())
        {
          ArrayList localArrayList = new ArrayList(paramArrayList.size());
          i = 0;
          if (i < paramArrayList.size())
          {
            VideoInfo localVideoInfo = (VideoInfo)paramArrayList.get(i);
            if ((localVideoInfo.a != null) && (localVideoInfo.a.aHj == 0))
            {
              localVideoInfo.a.pos = i;
              localArrayList.add(localVideoInfo.a);
            }
          }
          else
          {
            paramBundle.putParcelableArrayList("value_msg_kd_tag_info", localArrayList);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsAdTagHelper", 2, "handleGetRecommendList: parse tag info error,e=" + paramBundle.getMessage());
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzq
 * JD-Core Version:    0.7.0.1
 */