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
public class vpd
  extends vpb
{
  private PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  public AddressItem a;
  private GeneralFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
  public String a;
  public vwm a;
  private vwo jdField_a_of_type_Vwo;
  public long b;
  public String b;
  public List<wft> b;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  private String p;
  
  public vpd(PublishVideoEntry paramPublishVideoEntry)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_d_of_type_Long = paramPublishVideoEntry.createTime;
    this.p = paramPublishVideoEntry.fakeVid;
    this.jdField_b_of_type_JavaLangString = paramPublishVideoEntry.thumbPath;
    this.jdField_d_of_type_JavaLangString = paramPublishVideoEntry.doodlePath;
    this.jdField_b_of_type_Long = paramPublishVideoEntry.videoDuration;
    this.jdField_d_of_type_Int = paramPublishVideoEntry.videoWidth;
    this.jdField_e_of_type_Int = paramPublishVideoEntry.videoHeight;
    if (!TextUtils.isEmpty(paramPublishVideoEntry.videoAddress)) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = AddressItem.convertFromJson(paramPublishVideoEntry.videoAddress);
      this.m = paramPublishVideoEntry.atDoodlePath;
      this.jdField_e_of_type_JavaLangString = a().getStringExtra("pl_pic", null);
      this.jdField_f_of_type_JavaLangString = a().getStringExtra("il_pic", null);
      this.jdField_a_of_type_Vwm = a().getLinkInfo();
      this.jdField_f_of_type_Int = paramPublishVideoEntry.getIntExtra("extra_capture_mode", -1);
      this.jdField_g_of_type_Int = paramPublishVideoEntry.publishFrom;
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
  
  public vpd(StoryVideoItem paramStoryVideoItem)
  {
    this.p = paramStoryVideoItem.mVid;
    this.h = paramStoryVideoItem.getVideoUrl();
    this.j = paramStoryVideoItem.getThumbUrl();
    this.i = paramStoryVideoItem.mOriginalMaskPicUrl;
    this.m = paramStoryVideoItem.mAtImagePath;
    this.jdField_a_of_type_JavaLangString = paramStoryVideoItem.mLocalVideoPath;
    this.jdField_b_of_type_JavaLangString = a().thumbPath;
    this.jdField_d_of_type_JavaLangString = a().doodlePath;
    this.jdField_b_of_type_Long = paramStoryVideoItem.mVideoDuration;
    this.jdField_d_of_type_Int = paramStoryVideoItem.mVideoWidth;
    this.jdField_e_of_type_Int = paramStoryVideoItem.mVideoHeight;
    this.jdField_d_of_type_Long = paramStoryVideoItem.mCreateTime;
    this.jdField_b_of_type_Int = paramStoryVideoItem.mRetryUploadTimes;
    this.jdField_g_of_type_JavaLangString = paramStoryVideoItem.mLastUploadVid;
    this.jdField_c_of_type_Int = paramStoryVideoItem.mUpLoadFailedError;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramStoryVideoItem.mLocation;
    this.k = paramStoryVideoItem.mPollThumbnailUrl;
    this.jdField_e_of_type_JavaLangString = paramStoryVideoItem.mPollThumbnailLocalPath;
    this.l = paramStoryVideoItem.mInteractThumbnailUrl;
    this.jdField_f_of_type_JavaLangString = paramStoryVideoItem.mInteractThumbnailLocalPath;
    this.jdField_a_of_type_Vwm = vwm.a(paramStoryVideoItem.mLinkInfoJson);
    this.n = paramStoryVideoItem.originalAuthorUnionId;
    this.o = paramStoryVideoItem.originalAuthorName;
  }
  
  public vpd(String paramString)
  {
    this.p = paramString;
    yos.a(paramString);
  }
  
  private int a()
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    byte[] arrayOfByte = a().readerConfBytes;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      qqstory_struct.VideoReaderConf localVideoReaderConf = new qqstory_struct.VideoReaderConf();
      try
      {
        localVideoReaderConf.mergeFrom(arrayOfByte);
        int i1 = new vkx(localAppInterface, localVideoReaderConf).jdField_a_of_type_Int;
        return i1;
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
  
  public static PublishVideoEntry a(String paramString)
  {
    Object localObject = null;
    List localList = a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
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
      ((PublishVideoEntry)localObject).multiFragmentGroupId = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf(((PublishVideoEntry)localObject).fragmentGroupId) });
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private yml a()
  {
    Object localObject = a().tagInfoBytes;
    if ((localObject != null) && (localObject.length > 0))
    {
      qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
      try
      {
        localTagInfoBase.mergeFrom((byte[])localObject);
        localObject = new yml(localTagInfoBase);
        return localObject;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    return null;
  }
  
  @NonNull
  public PublishVideoEntry a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = a(this.p);
    return this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  }
  
  public StoryVideoItem a()
  {
    StoryVideoItem localStoryVideoItem = new StoryVideoItem();
    localStoryVideoItem.mVid = this.p;
    localStoryVideoItem.mLastUploadVid = this.jdField_g_of_type_JavaLangString;
    localStoryVideoItem.mCreateTime = this.jdField_d_of_type_Long;
    localStoryVideoItem.mVideoIndex = this.jdField_e_of_type_Long;
    localStoryVideoItem.mSourceType = 0;
    localStoryVideoItem.mPublishDate = a().mLocalDate;
    if (TextUtils.isEmpty(localStoryVideoItem.mPublishDate)) {
      localStoryVideoItem.mPublishDate = xnp.a().format(new Date(this.jdField_d_of_type_Long));
    }
    localStoryVideoItem.mVideoUrl = this.h;
    localStoryVideoItem.mVideoThumbnailUrl = this.j;
    localStoryVideoItem.mAtJsonData = a().atJsonData;
    localStoryVideoItem.mAtImagePath = this.m;
    if (a().isPicture) {}
    for (int i1 = 1;; i1 = 0)
    {
      localStoryVideoItem.mIsPicture = i1;
      localStoryVideoItem.mLocalCreateTime = (a().videoCreateTime * 1000L);
      localStoryVideoItem.mLocalCreateLocation = a().localCreateCity;
      localStoryVideoItem.mLocation = this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      localStoryVideoItem.mUserSelectLocationText = a().videoLocationDescription;
      if (TextUtils.isEmpty(localStoryVideoItem.mUserSelectLocationText)) {
        localStoryVideoItem.mUserSelectLocationText = a().gpsFilterDescription;
      }
      localStoryVideoItem.mTimeZoneOffsetMillis = (a().timeZoneOffset / 1000L);
      if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
        localStoryVideoItem.mTimeZoneOffsetMillis *= 1000L;
      }
      localStoryVideoItem.mVideoLocalThumbnailPath = this.jdField_b_of_type_JavaLangString;
      localStoryVideoItem.mVideoLocalThumbnailOrigFakePath = this.jdField_c_of_type_JavaLangString;
      localStoryVideoItem.mLocalVideoPath = this.jdField_a_of_type_JavaLangString;
      localStoryVideoItem.mVideoDuration = this.jdField_b_of_type_Long;
      localStoryVideoItem.mVideoWidth = this.jdField_d_of_type_Int;
      localStoryVideoItem.mVideoHeight = this.jdField_e_of_type_Int;
      localStoryVideoItem.mDoodleText = a().videoDoodleDescription;
      localStoryVideoItem.mUploadStatus = this.jdField_a_of_type_Int;
      localStoryVideoItem.mRetryUploadTimes = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        localStoryVideoItem.mUpLoadFailedError = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      localStoryVideoItem.mOwnerUid = QQStoryContext.a().b();
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
      {
        localObject = ((vvj)vux.a(2)).a();
        if (localObject != null) {
          localStoryVideoItem.mOwnerName = ((QQUserUIItem)localObject).getDisplayName();
        }
      }
      localStoryVideoItem.mBanType = a();
      localStoryVideoItem.mVideoSpreadGroupList = a();
      localStoryVideoItem.mTagInfoBase = a();
      localStoryVideoItem.mPollLayoutJson = a().getStringExtra("pl", null);
      localStoryVideoItem.mPollThumbnailLocalPath = this.jdField_e_of_type_JavaLangString;
      localStoryVideoItem.mPollThumbnailUrl = this.k;
      localStoryVideoItem.mInteractLayoutJson = a().getStringExtra("i_l", null);
      localStoryVideoItem.mInteractThumbnailLocalPath = this.jdField_f_of_type_JavaLangString;
      localStoryVideoItem.mInteractThumbnailUrl = this.l;
      Object localObject = a().getJSONExtra("follow_capture_param");
      if (localObject != null) {
        localStoryVideoItem.comparedLevel = (((JSONObject)localObject).optInt("comparedLevel") + 1);
      }
      if (this.jdField_a_of_type_Vwm != null) {
        localStoryVideoItem.mLinkInfoJson = this.jdField_a_of_type_Vwm.a(false);
      }
      localStoryVideoItem.mGameInfoJson = a().getStringExtra("game", null);
      localStoryVideoItem.mGameInfo = vwk.a(localStoryVideoItem.mGameInfoJson);
      localStoryVideoItem.originalAuthorUnionId = this.n;
      localStoryVideoItem.originalAuthorName = this.o;
      boolean bool1 = a().getBooleanExtra("is_hw_encode", false);
      boolean bool2 = a().isLocalPublish;
      if ((bool1) || (bool2)) {
        yqs.a(localStoryVideoItem);
      }
      return localStoryVideoItem;
    }
  }
  
  public GeneralFeedItem a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
    }
    String str3 = a().mLocalDate;
    xnp localxnp = (xnp)vux.a(11);
    String str2 = localxnp.a(QQStoryContext.a().b(), str3);
    xvv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", str2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = VideoListFeedItem.makeFakeFeedId(QQStoryContext.a().b(), str3);
      xvv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", str1);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = ((GeneralFeedItem)localxnp.a(str1));
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = GeneralFeedItem.createFakeFeedItem(str3);
      localxnp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
      xvv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
  }
  
  public String a()
  {
    return this.p;
  }
  
  public vwo a()
  {
    qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList;
    if ((this.jdField_a_of_type_Vwo == null) && (a().spreadGroupBytes != null) && (a().spreadGroupBytes.length > 0)) {
      localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
    }
    try
    {
      localVideoSpreadGroupList.mergeFrom(a().spreadGroupBytes);
      this.jdField_a_of_type_Vwo = new vwo(localVideoSpreadGroupList);
      return this.jdField_a_of_type_Vwo;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        xvv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "decode spread group fail", localInvalidProtocolBufferMicroException);
      }
    }
  }
  
  public void a(String paramString)
  {
    GeneralFeedItem localGeneralFeedItem = new GeneralFeedItem();
    localGeneralFeedItem.copy(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
    localGeneralFeedItem.feedId = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localGeneralFeedItem;
    ((xnp)vux.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
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
      paramObject = (vpd)paramObject;
      if (this.p != null) {
        return this.p.equals(paramObject.p);
      }
    } while (paramObject.p == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.p != null) {
      return this.p.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "StoryVideoTaskInfo{createTime=" + this.jdField_d_of_type_Long + ", fakeVid='" + this.p + '\'' + ", vid='" + this.jdField_g_of_type_JavaLangString + '\'' + ", '" + super.toString() + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpd
 * JD-Core Version:    0.7.0.1
 */