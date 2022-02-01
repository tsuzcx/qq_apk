import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.10;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.6;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.7;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.8;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.9;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.LbsInfo;
import com.tencent.pb.now.NowNearbyVideoCommentProto.Comment;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.pb.now.ilive_feeds_read.FeedUserInfo;
import com.tencent.pb.now.ilive_feeds_read.FeedsInfo;
import com.tencent.pb.now.ilive_feeds_tmem.Chang;
import com.tencent.pb.now.ilive_feeds_tmem.ChangFeed;
import com.tencent.pb.now.ilive_feeds_tmem.FeedsTmemLike;
import com.tencent.pb.now.ilive_feeds_tmem.LiveFeed;
import com.tencent.pb.now.ilive_feeds_tmem.PicFeed;
import com.tencent.pb.now.ilive_feeds_tmem.PicInfo;
import com.tencent.pb.now.ilive_feeds_tmem.TextFeed;
import com.tencent.pb.now.ilive_feeds_tmem.VideoFeed;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class akio
  implements Manager
{
  private String bTu;
  protected DecimalFormat e = new DecimalFormat("#.##");
  private List<akio.c> jC = new CopyOnWriteArrayList();
  private QQAppInterface mApp;
  
  public akio(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private akjj a(ilive_feeds_read.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null) {
      return null;
    }
    Object localObject1;
    if (paramFeedsInfo.feed_type.get() == 5)
    {
      localObject1 = new akji();
      ((akji)localObject1).faceUrl = paramFeedsInfo.live_info.pic_url.get().toStringUtf8();
      ((akji)localObject1).agQ = paramFeedsInfo.live_info.desc.get().toStringUtf8();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((akjj)localObject1).feedType = paramFeedsInfo.feed_type.get();
        ((akjj)localObject1).uin = String.valueOf(paramFeedsInfo.publish_info.uin.get());
        ((akjj)localObject1).feedId = paramFeedsInfo.feeds_id.get().toStringUtf8();
        ((akjj)localObject1).headUrl = String.valueOf(paramFeedsInfo.publish_info.url.get().toStringUtf8());
        ((akjj)localObject1).jumpUrl = paramFeedsInfo.jump_url.get().toStringUtf8();
        boolean bool;
        label162:
        double d1;
        if (paramFeedsInfo.like.get() == 1)
        {
          bool = true;
          ((akjj)localObject1).isLiked = bool;
          ((akjj)localObject1).likeNum = paramFeedsInfo.like_info.like_number.get();
          ((akjj)localObject1).commentNum = paramFeedsInfo.comment_num.get();
          ((akjj)localObject1).adT = paramFeedsInfo.create_time.get();
          ((akjj)localObject1).bTx = akja.by(paramFeedsInfo.create_time.get() * 1000L);
          ((akjj)localObject1).lng = paramFeedsInfo.lbs_info.lng.get().toStringUtf8();
          ((akjj)localObject1).lat = paramFeedsInfo.lbs_info.lat.get().toStringUtf8();
          ((akjj)localObject1).city = paramFeedsInfo.lbs_info.city.get().toStringUtf8();
          ((akjj)localObject1).name = paramFeedsInfo.lbs_info.name.get().toStringUtf8();
          if (paramFeedsInfo.distance.has())
          {
            double d2 = paramFeedsInfo.distance.get();
            d1 = d2;
            if (d2 < 0.01D) {
              d1 = 0.01D;
            }
            if (d1 >= 100.0D) {
              break label1093;
            }
            ((akjj)localObject1).distance = (this.e.format(d1) + "km");
          }
          label375:
          if (TextUtils.isEmpty(paramFeedsInfo.lbs_info.name.get().toStringUtf8())) {
            break label1141;
          }
        }
        label1093:
        label1141:
        for (((akjj)localObject1).location = paramFeedsInfo.lbs_info.name.get().toStringUtf8();; ((akjj)localObject1).location = paramFeedsInfo.lbs_info.city.get().toStringUtf8())
        {
          Object localObject2 = paramFeedsInfo.comments.get();
          if (((List)localObject2).size() <= 0) {
            break label1168;
          }
          paramFeedsInfo = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            NowNearbyVideoCommentProto.Comment localComment = (NowNearbyVideoCommentProto.Comment)((Iterator)localObject2).next();
            akjh localakjh = new akjh();
            localakjh.adS = localComment.comment_id.get();
            localakjh.bTw = localComment.publish_info.anchor_name.get().toStringUtf8();
            localakjh.bSx = localComment.reply_info.anchor_name.get().toStringUtf8();
            localakjh.content = ((NowNearbyVideoCommentProto.CommentMsg)((NowNearbyVideoCommentProto.CommentMsgBody)localComment.content.get()).msgs.get().get(0)).msg.get().toStringUtf8();
            paramFeedsInfo.add(localakjh);
          }
          if ((paramFeedsInfo.feed_type.get() == 1) || (paramFeedsInfo.feed_type.get() == 3) || (paramFeedsInfo.feed_type.get() == 2))
          {
            localObject1 = new akjm();
            ((akjm)localObject1).faceUrl = paramFeedsInfo.feed_info.pic_url.get().toStringUtf8();
            ((akjm)localObject1).duration = paramFeedsInfo.feed_info.video_time.get();
            ((akjm)localObject1).width = paramFeedsInfo.feed_info.video_width.get();
            ((akjm)localObject1).height = paramFeedsInfo.feed_info.video_hight.get();
            ((akjm)localObject1).agQ = paramFeedsInfo.feed_info.desc.get().toStringUtf8();
            ((akjm)localObject1).viewCount = paramFeedsInfo.view_times.get();
            localObject1 = (akjm)ajws.a(paramFeedsInfo.topic_cfg.get(), (akjj)localObject1);
            break;
          }
          if (paramFeedsInfo.feed_type.get() == 4)
          {
            localObject1 = new akjk();
            localObject2 = paramFeedsInfo.pic_info.infos.get();
            if (((List)localObject2).size() > 0)
            {
              localObject2 = (ilive_feeds_tmem.PicInfo)((List)localObject2).get(0);
              ((akjk)localObject1).picUrl = ((ilive_feeds_tmem.PicInfo)localObject2).url.get().toStringUtf8();
              ((akjk)localObject1).width = ((ilive_feeds_tmem.PicInfo)localObject2).width.get();
              ((akjk)localObject1).height = ((ilive_feeds_tmem.PicInfo)localObject2).hight.get();
            }
            ((akjk)localObject1).agQ = paramFeedsInfo.pic_info.desc.get().toStringUtf8();
            localObject1 = (akjk)ajws.a(paramFeedsInfo.topic_cfg.get(), (akjj)localObject1);
            break;
          }
          if (paramFeedsInfo.feed_type.get() == 6)
          {
            localObject1 = new akjg();
            ((akjg)localObject1).faceUrl = paramFeedsInfo.chang_info.pic_url.get().toStringUtf8();
            ((akjg)localObject1).width = paramFeedsInfo.chang_info.width.get();
            ((akjg)localObject1).height = paramFeedsInfo.chang_info.hight.get();
            if (paramFeedsInfo.chang_info.chang.size() > 0) {
              ((akjg)localObject1).bTv = ((ilive_feeds_tmem.Chang)paramFeedsInfo.chang_info.chang.get(0)).id.get().toStringUtf8();
            }
            ((akjg)localObject1).agQ = paramFeedsInfo.chang_info.desc.get().toStringUtf8();
            ((akjg)localObject1).viewCount = paramFeedsInfo.view_times.get();
            ((akjg)localObject1).videoCount = paramFeedsInfo.chang_info.chang.size();
            break;
          }
          if (paramFeedsInfo.feed_type.get() != 10) {
            break label1171;
          }
          localObject1 = new akjn();
          ((akjn)localObject1).agQ = paramFeedsInfo.text_feed.text.get();
          localObject1 = (akjn)ajws.a(paramFeedsInfo.topic_cfg.get(), (akjj)localObject1);
          break;
          bool = false;
          break label162;
          this.e = new DecimalFormat("#");
          ((akjj)localObject1).distance = (this.e.format(d1) + "km");
          break label375;
        }
        ((akjj)localObject1).DV = paramFeedsInfo;
      }
      label1168:
      return localObject1;
      label1171:
      localObject1 = null;
    }
  }
  
  private void a(akjj paramakjj)
  {
    if ((paramakjj == null) || (TextUtils.isEmpty(paramakjj.agQ))) {
      return;
    }
    Matcher localMatcher = Pattern.compile("\\[:([^(:\\])]+):\\]").matcher(paramakjj.agQ);
    StringBuffer localStringBuffer = new StringBuffer();
    while (localMatcher.find()) {
      localMatcher.appendReplacement(localStringBuffer, "");
    }
    localMatcher.appendTail(localStringBuffer);
    paramakjj.agQ = localStringBuffer.toString();
  }
  
  private List<akjj> bn(List<ilive_feeds_read.FeedsInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      akjj localakjj = a((ilive_feeds_read.FeedsInfo)paramList.next());
      if (localakjj != null)
      {
        a(localakjj);
        localArrayList.add(localakjj);
      }
    }
    return localArrayList;
  }
  
  public void Np(String paramString)
  {
    akit.a(this.mApp, paramString, new akip(this, paramString));
  }
  
  public void Nq(String paramString)
  {
    akit.a(this.mApp, paramString, new akiq(this, paramString));
  }
  
  public void Nr(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.5(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void Ns(String paramString)
  {
    this.bTu = paramString;
  }
  
  public void Nt(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.6(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void Nu(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.10(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(akio.c paramc)
  {
    try
    {
      this.jC.add(paramc);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, akio.b paramb)
  {
    akit.a(this.mApp, paramString, paramLong, paramInt1, paramInt2, paramInt3, new akis(this, paramb));
  }
  
  public void a(String paramString, long paramLong, int paramInt, akio.a parama)
  {
    if (paramInt == 6) {
      paramInt = 10;
    }
    for (;;)
    {
      akit.a(this.mApp, paramString, paramLong, paramInt, new akir(this, parama));
      return;
    }
  }
  
  public void av(String paramString, long paramLong)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.7(this, paramString, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(akio.c paramc)
  {
    try
    {
      this.jC.remove(paramc);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void dBt()
  {
    if (!TextUtils.isEmpty(this.bTu)) {
      Nr(this.bTu);
    }
  }
  
  public void fs(String paramString, int paramInt)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.8(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void ft(String paramString, int paramInt)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.9(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jC.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static abstract interface a
  {
    public abstract void y(boolean paramBoolean, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void c(boolean paramBoolean1, List<akjj> paramList, boolean paramBoolean2, int paramInt);
  }
  
  public static abstract class c
  {
    public void Nm(String paramString) {}
    
    public void Nn(String paramString) {}
    
    public void No(String paramString) {}
    
    public void as(String paramString, long paramLong) {}
    
    public void at(String paramString, long paramLong) {}
    
    public void au(String paramString, long paramLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akio
 * JD-Core Version:    0.7.0.1
 */