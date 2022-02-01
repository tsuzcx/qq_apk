import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public class pox
  extends pov
{
  public long Ak;
  public String atImagePath;
  public String aua;
  public String aug;
  public String auh;
  private GeneralFeedItem b;
  public int bjK;
  public AddressItem c;
  public long createTime;
  private PublishVideoEntry f;
  private String fakeVid;
  public int mEntranceType;
  public String mInteractThumbnailLocalPath;
  public String mInteractThumbnailUrl;
  public String mPollThumbnailLocalPath;
  public String mPollThumbnailUrl;
  public pty mVideoLinkInfo;
  private ptz mVideoSpreadGroupList;
  public String maskPicUrl;
  public List<pzx.a> mt;
  public String originalAuthorName;
  public String originalAuthorUnionId;
  public String vid;
  public long videoBytes;
  public long videoDuration;
  public int videoHeight;
  public String videoLocalPath;
  public String videoThumbnailUrl;
  public String videoUrl;
  public int videoWidth;
  
  public pox(PublishVideoEntry paramPublishVideoEntry)
  {
    this.f = paramPublishVideoEntry;
    this.createTime = paramPublishVideoEntry.createTime;
    this.fakeVid = paramPublishVideoEntry.fakeVid;
    this.aug = paramPublishVideoEntry.thumbPath;
    this.aua = paramPublishVideoEntry.doodlePath;
    this.videoDuration = paramPublishVideoEntry.videoDuration;
    this.videoWidth = paramPublishVideoEntry.videoWidth;
    this.videoHeight = paramPublishVideoEntry.videoHeight;
    if (!TextUtils.isEmpty(paramPublishVideoEntry.videoAddress)) {}
    try
    {
      this.c = AddressItem.convertFromJson(paramPublishVideoEntry.videoAddress);
      this.atImagePath = paramPublishVideoEntry.atDoodlePath;
      this.mPollThumbnailLocalPath = a().getStringExtra("pl_pic", null);
      this.mInteractThumbnailLocalPath = a().getStringExtra("il_pic", null);
      this.mVideoLinkInfo = a().getLinkInfo();
      this.bjK = paramPublishVideoEntry.getIntExtra("extra_capture_mode", -1);
      this.mEntranceType = paramPublishVideoEntry.publishFrom;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public pox(StoryVideoItem paramStoryVideoItem)
  {
    this.fakeVid = paramStoryVideoItem.mVid;
    this.videoUrl = paramStoryVideoItem.getVideoUrl();
    this.videoThumbnailUrl = paramStoryVideoItem.getThumbUrl();
    this.maskPicUrl = paramStoryVideoItem.mOriginalMaskPicUrl;
    this.atImagePath = paramStoryVideoItem.mAtImagePath;
    this.videoLocalPath = paramStoryVideoItem.mLocalVideoPath;
    this.aug = a().thumbPath;
    this.aua = a().doodlePath;
    this.videoDuration = paramStoryVideoItem.mVideoDuration;
    this.videoWidth = paramStoryVideoItem.mVideoWidth;
    this.videoHeight = paramStoryVideoItem.mVideoHeight;
    this.createTime = paramStoryVideoItem.mCreateTime;
    this.retryTimes = paramStoryVideoItem.mRetryUploadTimes;
    this.vid = paramStoryVideoItem.mLastUploadVid;
    this.bjJ = paramStoryVideoItem.mUpLoadFailedError;
    this.c = paramStoryVideoItem.mLocation;
    this.mPollThumbnailUrl = paramStoryVideoItem.mPollThumbnailUrl;
    this.mPollThumbnailLocalPath = paramStoryVideoItem.mPollThumbnailLocalPath;
    this.mInteractThumbnailUrl = paramStoryVideoItem.mInteractThumbnailUrl;
    this.mInteractThumbnailLocalPath = paramStoryVideoItem.mInteractThumbnailLocalPath;
    this.mVideoLinkInfo = pty.a(paramStoryVideoItem.mLinkInfoJson);
    this.originalAuthorUnionId = paramStoryVideoItem.originalAuthorUnionId;
    this.originalAuthorName = paramStoryVideoItem.originalAuthorName;
  }
  
  public pox(String paramString)
  {
    this.fakeVid = paramString;
    rom.checkNotNull(paramString);
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private rmw.a a()
  {
    Object localObject = a().tagInfoBytes;
    if ((localObject != null) && (localObject.length > 0))
    {
      qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
      try
      {
        localTagInfoBase.mergeFrom((byte[])localObject);
        localObject = new rmw.a(localTagInfoBase);
        return localObject;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    return null;
  }
  
  public static PublishVideoEntry b(String paramString)
  {
    Object localObject = null;
    List localList = a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
    paramString = (String)localObject;
    if (localList != null)
    {
      paramString = (String)localObject;
      if (localList.size() > 0) {
        paramString = (PublishVideoEntry)localList.get(0);
      }
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = new PublishVideoEntry();
    }
    if ((TextUtils.isEmpty(((PublishVideoEntry)localObject).multiFragmentGroupId)) && (((PublishVideoEntry)localObject).fragmentGroupId != 0)) {
      ((PublishVideoEntry)localObject).multiFragmentGroupId = String.format("%s.%d", new Object[] { QQStoryContext.a().mi(), Integer.valueOf(((PublishVideoEntry)localObject).fragmentGroupId) });
    }
    return localObject;
  }
  
  private int sq()
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.c();
    byte[] arrayOfByte = a().readerConfBytes;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      qqstory_struct.VideoReaderConf localVideoReaderConf = new qqstory_struct.VideoReaderConf();
      try
      {
        localVideoReaderConf.mergeFrom(arrayOfByte);
        int i = new ply(localAppInterface, localVideoReaderConf).mBanType;
        return i;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "createFakeStoryVideoItem VideoReaderConf: " + QLog.getStackTraceString(localInvalidProtocolBufferMicroException));
        }
      }
    }
    return -1;
  }
  
  @NonNull
  public PublishVideoEntry a()
  {
    if (this.f != null) {
      return this.f;
    }
    this.f = b(this.fakeVid);
    return this.f;
  }
  
  public StoryVideoItem a()
  {
    StoryVideoItem localStoryVideoItem = new StoryVideoItem();
    localStoryVideoItem.mVid = this.fakeVid;
    localStoryVideoItem.mLastUploadVid = this.vid;
    localStoryVideoItem.mCreateTime = this.createTime;
    localStoryVideoItem.mVideoIndex = this.Ak;
    localStoryVideoItem.mSourceType = 0;
    localStoryVideoItem.mPublishDate = a().mLocalDate;
    if (TextUtils.isEmpty(localStoryVideoItem.mPublishDate)) {
      localStoryVideoItem.mPublishDate = qvf.c().format(new Date(this.createTime));
    }
    localStoryVideoItem.mVideoUrl = this.videoUrl;
    localStoryVideoItem.mVideoThumbnailUrl = this.videoThumbnailUrl;
    localStoryVideoItem.mAtJsonData = a().atJsonData;
    localStoryVideoItem.mAtImagePath = this.atImagePath;
    if (a().isPicture) {}
    for (int i = 1;; i = 0)
    {
      localStoryVideoItem.mIsPicture = i;
      localStoryVideoItem.mLocalCreateTime = (a().videoCreateTime * 1000L);
      localStoryVideoItem.mLocalCreateLocation = a().localCreateCity;
      localStoryVideoItem.mLocation = this.c;
      localStoryVideoItem.mUserSelectLocationText = a().videoLocationDescription;
      if (TextUtils.isEmpty(localStoryVideoItem.mUserSelectLocationText)) {
        localStoryVideoItem.mUserSelectLocationText = a().gpsFilterDescription;
      }
      localStoryVideoItem.mTimeZoneOffsetMillis = (a().timeZoneOffset / 1000L);
      if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
        localStoryVideoItem.mTimeZoneOffsetMillis *= 1000L;
      }
      localStoryVideoItem.mVideoLocalThumbnailPath = this.aug;
      localStoryVideoItem.mVideoLocalThumbnailOrigFakePath = this.auh;
      localStoryVideoItem.mLocalVideoPath = this.videoLocalPath;
      localStoryVideoItem.mVideoDuration = this.videoDuration;
      localStoryVideoItem.mVideoWidth = this.videoWidth;
      localStoryVideoItem.mVideoHeight = this.videoHeight;
      localStoryVideoItem.mDoodleText = a().videoDoodleDescription;
      localStoryVideoItem.mUploadStatus = this.status;
      localStoryVideoItem.mRetryUploadTimes = this.retryTimes;
      if (this.result != null) {
        localStoryVideoItem.mUpLoadFailedError = this.result.errorCode;
      }
      localStoryVideoItem.mOwnerUid = QQStoryContext.a().getCurrentUid();
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
      {
        localObject = ((ptf)psx.a(2)).a();
        if (localObject != null) {
          localStoryVideoItem.mOwnerName = ((QQUserUIItem)localObject).getDisplayName();
        }
      }
      localStoryVideoItem.mBanType = sq();
      localStoryVideoItem.mVideoSpreadGroupList = a();
      localStoryVideoItem.mTagInfoBase = a();
      localStoryVideoItem.mPollLayoutJson = a().getStringExtra("pl", null);
      localStoryVideoItem.mPollThumbnailLocalPath = this.mPollThumbnailLocalPath;
      localStoryVideoItem.mPollThumbnailUrl = this.mPollThumbnailUrl;
      localStoryVideoItem.mInteractLayoutJson = a().getStringExtra("i_l", null);
      localStoryVideoItem.mInteractThumbnailLocalPath = this.mInteractThumbnailLocalPath;
      localStoryVideoItem.mInteractThumbnailUrl = this.mInteractThumbnailUrl;
      Object localObject = a().getJSONExtra("follow_capture_param");
      if (localObject != null) {
        localStoryVideoItem.comparedLevel = (((JSONObject)localObject).optInt("comparedLevel") + 1);
      }
      if (this.mVideoLinkInfo != null) {
        localStoryVideoItem.mLinkInfoJson = this.mVideoLinkInfo.i(false);
      }
      localStoryVideoItem.mGameInfoJson = a().getStringExtra("game", null);
      localStoryVideoItem.mGameInfo = ptw.a(localStoryVideoItem.mGameInfoJson);
      localStoryVideoItem.originalAuthorUnionId = this.originalAuthorUnionId;
      localStoryVideoItem.originalAuthorName = this.originalAuthorName;
      boolean bool1 = a().getBooleanExtra("is_hw_encode", false);
      boolean bool2 = a().isLocalPublish;
      if ((bool1) || (bool2)) {
        rpv.s(localStoryVideoItem);
      }
      return localStoryVideoItem;
    }
  }
  
  public GeneralFeedItem a()
  {
    if (this.b != null) {
      return this.b;
    }
    String str3 = a().mLocalDate;
    qvf localqvf = (qvf)psx.a(11);
    String str2 = localqvf.ah(QQStoryContext.a().getCurrentUid(), str3);
    ram.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", str2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = VideoListFeedItem.makeFakeFeedId(QQStoryContext.a().getCurrentUid(), str3);
      ram.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", str1);
    }
    this.b = ((GeneralFeedItem)localqvf.a(str1));
    if (this.b == null)
    {
      this.b = GeneralFeedItem.createFakeFeedItem(str3);
      localqvf.a(this.b);
      ram.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", this.b.feedId);
    }
    return this.b;
  }
  
  public ptz a()
  {
    qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList;
    if ((this.mVideoSpreadGroupList == null) && (a().spreadGroupBytes != null) && (a().spreadGroupBytes.length > 0)) {
      localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
    }
    try
    {
      localVideoSpreadGroupList.mergeFrom(a().spreadGroupBytes);
      this.mVideoSpreadGroupList = new ptz(localVideoSpreadGroupList);
      return this.mVideoSpreadGroupList;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "decode spread group fail", localInvalidProtocolBufferMicroException);
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (pox)paramObject;
      if (this.fakeVid != null) {
        return this.fakeVid.equals(paramObject.fakeVid);
      }
    } while (paramObject.fakeVid == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.fakeVid != null) {
      return this.fakeVid.hashCode();
    }
    return 0;
  }
  
  public String mp()
  {
    return this.fakeVid;
  }
  
  public void rd(String paramString)
  {
    GeneralFeedItem localGeneralFeedItem = new GeneralFeedItem();
    localGeneralFeedItem.copy(this.b);
    localGeneralFeedItem.feedId = paramString;
    this.b = localGeneralFeedItem;
    ((qvf)psx.a(11)).a(this.b);
  }
  
  public String toString()
  {
    return "StoryVideoTaskInfo{createTime=" + this.createTime + ", fakeVid='" + this.fakeVid + '\'' + ", vid='" + this.vid + '\'' + ", '" + super.toString() + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pox
 * JD-Core Version:    0.7.0.1
 */