import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.LbsInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.PicInfo;
import com.tencent.pb.now.FeedsProtocol.RichTitleElement;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.TextFeed;
import com.tencent.pb.now.FeedsProtocol.TopicCfg;
import com.tencent.pb.now.FeedsProtocol.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ajwe
{
  public QQAppInterface app;
  protected ajwe.a b;
  protected ArrayList<VideoData> mDataList = new ArrayList();
  protected boolean mIsEnd;
  protected int mTotalCount;
  
  protected static VideoData a(int paramInt, List<FeedsProtocol.TopicCfg> paramList, FeedsProtocol.PicFeedsInfo paramPicFeedsInfo, ArrayList<VideoData> paramArrayList)
  {
    boolean bool2 = false;
    VideoData localVideoData = new VideoData();
    localVideoData.id = paramPicFeedsInfo.feeds_id.get().toStringUtf8();
    localVideoData.time = paramPicFeedsInfo.create_time.get();
    localVideoData.shareUrl = paramPicFeedsInfo.share_url.get().toStringUtf8();
    localVideoData.bSG = paramPicFeedsInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.ads = paramPicFeedsInfo.user_info.uid.get();
    localVideoData.adt = paramPicFeedsInfo.user_info.explicit_uid.get();
    localVideoData.dlx = paramPicFeedsInfo.user_info.id_type.get();
    localVideoData.bSH = paramPicFeedsInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.adu = paramPicFeedsInfo.user_info.uid.get();
    localVideoData.adv = paramPicFeedsInfo.user_info.explicit_uid.get();
    localVideoData.dlz = paramPicFeedsInfo.user_info.id_type.get();
    localVideoData.bSI = paramPicFeedsInfo.user_info.head_img_url.get().toStringUtf8();
    if (paramPicFeedsInfo.is_listen.get() != 0) {}
    Object localObject;
    for (boolean bool1 = true;; bool1 = false)
    {
      localVideoData.isFollowed = bool1;
      bool1 = bool2;
      if (paramPicFeedsInfo.is_like.get() != 0) {
        bool1 = true;
      }
      localVideoData.isLike = bool1;
      localVideoData.dlw = paramPicFeedsInfo.like_num.get();
      localVideoData.headerUrl = paramPicFeedsInfo.user_info.head_img_url.get().toStringUtf8();
      localVideoData.dly = paramPicFeedsInfo.view_times.get();
      localVideoData.age = paramPicFeedsInfo.user_info.age.get();
      localVideoData.gender = paramPicFeedsInfo.user_info.user_gender.get();
      localVideoData.adw = paramPicFeedsInfo.user_info.uid.get();
      localVideoData.adx = paramPicFeedsInfo.user_info.explicit_uid.get();
      localVideoData.dlA = paramPicFeedsInfo.user_info.id_type.get();
      localVideoData.bSJ = "";
      localVideoData.feedType = paramPicFeedsInfo.feed_type.get();
      localVideoData.dlC = paramInt;
      localIterator = paramPicFeedsInfo.pic_infos.get().iterator();
      while (localIterator.hasNext())
      {
        localObject = (FeedsProtocol.PicInfo)localIterator.next();
        localVideoData.yf.add(new ajwh(((FeedsProtocol.PicInfo)localObject).url.get().toStringUtf8(), ((FeedsProtocol.PicInfo)localObject).width.get(), ((FeedsProtocol.PicInfo)localObject).hight.get()));
      }
    }
    Iterator localIterator = paramPicFeedsInfo.rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      localObject = (FeedsProtocol.RichTitleElement)localIterator.next();
      if (((FeedsProtocol.RichTitleElement)localObject).type.get() == 1) {
        localVideoData.bSJ += ((FeedsProtocol.RichTitleElement)localObject).text.get().toStringUtf8();
      } else if (((FeedsProtocol.RichTitleElement)localObject).type.get() == 2) {
        localVideoData.bSJ = (localVideoData.bSJ + "#" + ((FeedsProtocol.RichTitleElement)localObject).text.get().toStringUtf8() + "#");
      }
    }
    if (paramPicFeedsInfo.lbs_info != null)
    {
      paramPicFeedsInfo = (FeedsProtocol.LbsInfo)paramPicFeedsInfo.lbs_info.get();
      localVideoData.a = new LocationInfo();
      localVideoData.a.init(paramPicFeedsInfo.lng.get().toStringUtf8(), paramPicFeedsInfo.lat.get().toStringUtf8(), paramPicFeedsInfo.city.get().toStringUtf8(), paramPicFeedsInfo.name.get().toStringUtf8());
    }
    for (;;)
    {
      paramArrayList.add(ajws.a(paramList, localVideoData));
      return localVideoData;
      localVideoData.a = new LocationInfo();
    }
  }
  
  protected static VideoData a(int paramInt, List<FeedsProtocol.TopicCfg> paramList, FeedsProtocol.ShortVideoInfo paramShortVideoInfo, ArrayList<VideoData> paramArrayList)
  {
    boolean bool2 = false;
    VideoData localVideoData = new VideoData();
    localVideoData.id = paramShortVideoInfo.feeds_id.get().toStringUtf8();
    localVideoData.type = 2;
    localVideoData.time = paramShortVideoInfo.create_time.get();
    localVideoData.doodleUrl = paramShortVideoInfo.doodle_pic_url.get().toStringUtf8();
    localVideoData.shareUrl = paramShortVideoInfo.share_url.get().toStringUtf8();
    localVideoData.coverUrl = paramShortVideoInfo.pic_url.get().toStringUtf8();
    localVideoData.videoUrl = paramShortVideoInfo.video_url.get().toStringUtf8();
    localVideoData.bSG = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).anchor_name.get().toStringUtf8();
    localVideoData.ads = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).uid.get();
    localVideoData.adt = paramShortVideoInfo.anchor_info.explicit_uid.get();
    localVideoData.dlx = paramShortVideoInfo.anchor_info.id_type.get();
    localVideoData.bSH = paramShortVideoInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.adu = paramShortVideoInfo.user_info.uid.get();
    localVideoData.adv = paramShortVideoInfo.user_info.explicit_uid.get();
    localVideoData.dlz = paramShortVideoInfo.user_info.id_type.get();
    localVideoData.bSI = paramShortVideoInfo.user_info.head_img_url.get().toStringUtf8();
    boolean bool1;
    Iterator localIterator;
    if (paramShortVideoInfo.is_listen.get() != 0)
    {
      bool1 = true;
      localVideoData.isFollowed = bool1;
      bool1 = bool2;
      if (paramShortVideoInfo.is_like.get() != 0) {
        bool1 = true;
      }
      localVideoData.isLike = bool1;
      localVideoData.dlw = paramShortVideoInfo.like_num.get();
      localVideoData.headerUrl = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).head_img_url.get().toStringUtf8();
      localVideoData.dly = paramShortVideoInfo.view_times.get();
      localVideoData.age = paramShortVideoInfo.user_info.age.get();
      localVideoData.gender = paramShortVideoInfo.user_info.user_gender.get();
      localVideoData.adw = paramShortVideoInfo.user_info.uid.get();
      localVideoData.adx = paramShortVideoInfo.user_info.explicit_uid.get();
      localVideoData.dlA = paramShortVideoInfo.user_info.id_type.get();
      localVideoData.bSJ = "";
      localVideoData.feedType = paramShortVideoInfo.feed_type.get();
      localVideoData.videoHeight = paramShortVideoInfo.video_hight.get();
      localVideoData.videoWidth = paramShortVideoInfo.video_width.get();
      localVideoData.AC = paramShortVideoInfo.video_time.get();
      localVideoData.dlC = paramInt;
      localIterator = paramShortVideoInfo.rpt_msg_rich_title.get().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label648;
      }
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      if (localRichTitleElement.type.get() == 1)
      {
        localVideoData.bSJ += localRichTitleElement.text.get().toStringUtf8();
        continue;
        bool1 = false;
        break;
      }
      if (localRichTitleElement.type.get() == 2) {
        localVideoData.bSJ = (localVideoData.bSJ + "#" + localRichTitleElement.text.get().toStringUtf8() + "#");
      }
    }
    label648:
    if (paramShortVideoInfo.lbs_info.get() != null)
    {
      paramShortVideoInfo = (FeedsProtocol.LbsInfo)paramShortVideoInfo.lbs_info.get();
      localVideoData.a = new LocationInfo();
      localVideoData.a.init(paramShortVideoInfo.lng.get().toStringUtf8(), paramShortVideoInfo.lat.get().toStringUtf8(), paramShortVideoInfo.city.get().toStringUtf8(), paramShortVideoInfo.name.get().toStringUtf8());
    }
    for (;;)
    {
      paramArrayList.add(ajws.a(paramList, localVideoData));
      return localVideoData;
      localVideoData.a = new LocationInfo();
    }
  }
  
  public static void a(int paramInt, List<FeedsProtocol.TopicCfg> paramList, FeedsProtocol.TextFeed paramTextFeed, ArrayList<VideoData> paramArrayList)
  {
    boolean bool2 = false;
    VideoData localVideoData = new VideoData();
    localVideoData.id = paramTextFeed.feeds_id.get();
    localVideoData.time = paramTextFeed.create_time.get();
    localVideoData.shareUrl = paramTextFeed.share_url.get();
    localVideoData.type = 6;
    localVideoData.bSG = paramTextFeed.user_info.anchor_name.get().toStringUtf8();
    localVideoData.ads = paramTextFeed.user_info.uid.get();
    localVideoData.adt = paramTextFeed.user_info.explicit_uid.get();
    localVideoData.dlx = paramTextFeed.user_info.id_type.get();
    localVideoData.bSH = paramTextFeed.user_info.anchor_name.get().toStringUtf8();
    localVideoData.adu = paramTextFeed.user_info.uid.get();
    localVideoData.adv = paramTextFeed.user_info.explicit_uid.get();
    localVideoData.dlz = paramTextFeed.user_info.id_type.get();
    localVideoData.bSI = paramTextFeed.user_info.head_img_url.get().toStringUtf8();
    localVideoData.headerUrl = paramTextFeed.user_info.head_img_url.get().toStringUtf8();
    localVideoData.age = paramTextFeed.user_info.age.get();
    localVideoData.gender = paramTextFeed.user_info.user_gender.get();
    localVideoData.adw = paramTextFeed.user_info.uid.get();
    localVideoData.adx = paramTextFeed.user_info.explicit_uid.get();
    localVideoData.dlA = paramTextFeed.user_info.id_type.get();
    boolean bool1;
    Iterator localIterator;
    if (paramTextFeed.is_listen.get() != 0)
    {
      bool1 = true;
      localVideoData.isFollowed = bool1;
      bool1 = bool2;
      if (paramTextFeed.is_like.get() != 0) {
        bool1 = true;
      }
      localVideoData.isLike = bool1;
      localVideoData.dlw = paramTextFeed.like_num.get();
      localVideoData.headerUrl = paramTextFeed.user_info.head_img_url.get().toStringUtf8();
      localVideoData.dly = paramTextFeed.view_times.get();
      localVideoData.feedType = 6;
      localVideoData.dlC = paramInt;
      localVideoData.bSJ = "";
      localIterator = paramTextFeed.rpt_msg_rich_title.get().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label545;
      }
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      if (localRichTitleElement.type.get() == 1)
      {
        localVideoData.bSJ += localRichTitleElement.text.get().toStringUtf8();
        continue;
        bool1 = false;
        break;
      }
      if (localRichTitleElement.type.get() == 2) {
        new StringBuilder().append("#").append(localRichTitleElement.text.get().toStringUtf8()).append("#").toString();
      }
    }
    label545:
    if (paramTextFeed.lbs_info != null)
    {
      paramTextFeed = (FeedsProtocol.LbsInfo)paramTextFeed.lbs_info.get();
      localVideoData.a = new LocationInfo();
      localVideoData.a.init(paramTextFeed.lng.get().toStringUtf8(), paramTextFeed.lat.get().toStringUtf8(), paramTextFeed.city.get().toStringUtf8(), paramTextFeed.name.get().toStringUtf8());
    }
    for (;;)
    {
      paramArrayList.add(ajws.a(paramList, localVideoData));
      return;
      localVideoData.a = new LocationInfo();
    }
  }
  
  public void Ms(boolean paramBoolean)
  {
    this.mIsEnd = paramBoolean;
  }
  
  public void a(ajwe.a parama)
  {
    this.b = parama;
  }
  
  public abstract void dd(Bundle paramBundle);
  
  public void dui()
  {
    if (this.mIsEnd) {}
  }
  
  public void dzO() {}
  
  public void gL(String paramString1, String paramString2) {}
  
  public ArrayList<VideoData> getDataList()
  {
    return this.mDataList;
  }
  
  public int getTotalCount()
  {
    return this.mTotalCount;
  }
  
  public boolean isEnd()
  {
    return this.mIsEnd;
  }
  
  public static abstract interface a
  {
    public abstract void a(VideoData paramVideoData);
    
    public abstract void iQ(int paramInt1, int paramInt2);
    
    @Deprecated
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwe
 * JD-Core Version:    0.7.0.1
 */