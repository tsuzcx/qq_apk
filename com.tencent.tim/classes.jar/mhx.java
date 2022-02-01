import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import tencent.im.oidb.articlesummary.articlesummary.RecommendAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListRsp;
import tencent.im.oidb.oidb_0xc2f.RecommendAccountInfo;

public class mhx
{
  public String ahE;
  public boolean amI;
  public byte[] bq;
  public int cardStyle;
  public boolean hasReport;
  public List<RecommendFollowInfo> iM = new ArrayList();
  public List<mhh> iQ = new ArrayList();
  public String jumpUrl;
  public HashMap<Long, RecommendFollowInfo> reportMap = new HashMap();
  
  public static mhx a(articlesummary.RecommendFollowInfos paramRecommendFollowInfos)
  {
    boolean bool = true;
    mhx localmhx = new mhx();
    if (paramRecommendFollowInfos.uint32_show_full_card.has()) {
      if (paramRecommendFollowInfos.uint32_show_full_card.get() != 1) {
        break label252;
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject1;
    for (;;)
    {
      localmhx.amI = bool;
      if (paramRecommendFollowInfos.bytes_account_next_cookie.has()) {
        localmhx.bq = paramRecommendFollowInfos.bytes_account_next_cookie.get().toByteArray();
      }
      localmhx.cardStyle = paramRecommendFollowInfos.uint32_card_style.get();
      localmhx.ahE = paramRecommendFollowInfos.bytes_card_title.get().toStringUtf8();
      localmhx.jumpUrl = paramRecommendFollowInfos.bytes_jump_url.get().toStringUtf8();
      if (!paramRecommendFollowInfos.rpt_recommend_account_info.has()) {
        return localmhx;
      }
      paramRecommendFollowInfos = paramRecommendFollowInfos.rpt_recommend_account_info.get();
      localObject2 = new HashMap();
      localObject3 = paramRecommendFollowInfos.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = RecommendFollowInfo.parseByPB((articlesummary.RecommendAccountInfo)((Iterator)localObject3).next());
        localmhx.iM.add(localRecommendFollowInfo);
        if ((localmhx.cardStyle == 2) && (!TextUtils.isEmpty(localRecommendFollowInfo.className)))
        {
          localObject1 = (List)((HashMap)localObject2).get(localRecommendFollowInfo.className);
          paramRecommendFollowInfos = (articlesummary.RecommendFollowInfos)localObject1;
          if (localObject1 == null)
          {
            paramRecommendFollowInfos = new ArrayList();
            ((HashMap)localObject2).put(localRecommendFollowInfo.className, paramRecommendFollowInfos);
          }
          if (paramRecommendFollowInfos.size() < 3) {
            paramRecommendFollowInfos.add(localRecommendFollowInfo);
          }
        }
      }
      label252:
      bool = false;
    }
    if (!((HashMap)localObject2).isEmpty())
    {
      paramRecommendFollowInfos = ((HashMap)localObject2).entrySet().iterator();
      while (paramRecommendFollowInfos.hasNext())
      {
        localObject1 = (Map.Entry)paramRecommendFollowInfos.next();
        localObject2 = (List)((Map.Entry)localObject1).getValue();
        if (((List)localObject2).size() == 3)
        {
          localObject3 = new mhh();
          ((mhh)localObject3).className = ((String)((Map.Entry)localObject1).getKey());
          ((mhh)localObject3).iM = ((List)localObject2);
          localmhx.iQ.add(localObject3);
        }
      }
    }
    return localmhx;
  }
  
  public static mhx a(oidb_0xc2f.GetFollowUserRecommendListRsp paramGetFollowUserRecommendListRsp)
  {
    mhx localmhx = new mhx();
    localmhx.jumpUrl = paramGetFollowUserRecommendListRsp.bytes_jump_url.get().toStringUtf8();
    if (paramGetFollowUserRecommendListRsp.rpt_msg_recommend_list.has())
    {
      paramGetFollowUserRecommendListRsp = paramGetFollowUserRecommendListRsp.rpt_msg_recommend_list.get().iterator();
      while (paramGetFollowUserRecommendListRsp.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = RecommendFollowInfo.parseByPB((oidb_0xc2f.RecommendAccountInfo)paramGetFollowUserRecommendListRsp.next());
        localmhx.iM.add(localRecommendFollowInfo);
      }
    }
    return localmhx;
  }
  
  public byte[] E()
  {
    articlesummary.RecommendFollowInfos localRecommendFollowInfos = new articlesummary.RecommendFollowInfos();
    if (this.amI) {
      localRecommendFollowInfos.uint32_show_full_card.set(1);
    }
    ArrayList localArrayList;
    for (;;)
    {
      if ((this.bq != null) && (this.bq.length > 0)) {
        localRecommendFollowInfos.bytes_account_next_cookie.set(ByteStringMicro.copyFrom(this.bq));
      }
      if (this.iM.size() <= 0) {
        break label132;
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.iM.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((RecommendFollowInfo)localIterator.next()).toPB());
      }
      localRecommendFollowInfos.uint32_show_full_card.set(0);
    }
    localRecommendFollowInfos.rpt_recommend_account_info.set(localArrayList);
    label132:
    localRecommendFollowInfos.uint32_card_style.set(this.cardStyle);
    if (this.ahE != null) {
      localRecommendFollowInfos.bytes_card_title.set(ByteStringMicro.copyFromUtf8(this.ahE));
    }
    if (this.jumpUrl != null) {
      localRecommendFollowInfos.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jumpUrl));
    }
    return localRecommendFollowInfos.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhx
 * JD-Core Version:    0.7.0.1
 */