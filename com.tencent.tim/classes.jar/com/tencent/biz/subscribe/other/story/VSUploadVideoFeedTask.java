package com.tencent.biz.subscribe.other.story;

import NS_QQ_STORY_CLIENT.CLIENT.StPublishStoryFeedRsp;
import NS_QQ_STORY_META.META.StImage;
import NS_QQ_STORY_META.META.StMusic;
import NS_QQ_STORY_META.META.StStoryFeed;
import NS_QQ_STORY_META.META.StUser;
import NS_QQ_STORY_META.META.StVideo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import aqhq;
import aqiw;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.PublishVideoFeedRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pog;
import poj;
import poj.a;
import psx;
import ram;
import sfd;
import sfl;
import sfo;
import sqn;

public class VSUploadVideoFeedTask
  extends BaseUploadVideoFeedTask
{
  protected long CQ = System.currentTimeMillis();
  
  public VSUploadVideoFeedTask(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    super(paramVSUploadVideoEntry);
  }
  
  private boolean MH()
  {
    if (isStop())
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "checkTaskIsStop() task already stop");
      ErrorMessage localErrorMessage = new ErrorMessage(6005, "任务取消");
      this.jdField_a_of_type_Sfd.b(this, null, localErrorMessage);
    }
    return isStop();
  }
  
  private META.StStoryFeed a(String paramString)
  {
    META.StStoryFeed localStStoryFeed = new META.StStoryFeed();
    localStStoryFeed.createTime.set(System.currentTimeMillis() / 1000L);
    localStStoryFeed.desc.set("大家好");
    Object localObject = new META.StUser();
    ((META.StUser)localObject).uin.set(Long.parseLong(QQStoryContext.a().mi()));
    ((META.StUser)localObject).nick.set(nx());
    localStStoryFeed.postUser.set((MessageMicro)localObject);
    localObject = new META.StVideo();
    META.StImage localStImage = new META.StImage();
    ((META.StVideo)localObject).fileId.set(paramString);
    paramString = "";
    if (this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.mLocalRawVideoDir)) {
        ((META.StVideo)localObject).fileSize.set((int)(aqhq.getFileSizes(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.mLocalRawVideoDir) / 8L));
      }
      localStImage.url.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.thumbPath);
      localStImage.width.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.videoWidth);
      localStImage.height.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.videoHeight);
      ((META.StVideo)localObject).duration.set((int)this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.videoDuration);
      ((META.StVideo)localObject).width.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.videoWidth);
      ((META.StVideo)localObject).height.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.videoHeight);
      paramString = this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.getStringExtra("all_doodle_text", null);
      META.StMusic localStMusic = new META.StMusic();
      localStMusic.uiSongId.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.getLongExtra("vs_publish_entry_json_key_music_id", 0L));
      localStMusic.strSongMid.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.getStringExtra("vs_publish_entry_json_key_music_mid_id", ""));
      localStMusic.strSongName.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.getStringExtra("vs_publish_entry_json_key_song_name", ""));
      localStMusic.strAlbumPic.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.getStringExtra("vs_publish_entry_json_key_music_album_pic", ""));
      localStMusic.iFrom.set(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry.getIntExtra("vs_publish_entry_json_key_music_source_from", 0));
      localStStoryFeed.storyMusic.set(localStMusic);
    }
    localStStoryFeed.storyVideo.set((MessageMicro)localObject);
    localStStoryFeed.coverImage.set(localStImage);
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new ArrayList();
      paramString = paramString.substring(1, paramString.length() - 1).split(",");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localStImage = paramString[i];
        ((List)localObject).add(localStImage.substring(1, localStImage.length() - 2));
        i += 1;
      }
      localStStoryFeed.vecText.set((List)localObject);
    }
    return localStStoryFeed;
  }
  
  private void a(VSUploadVideoEntry paramVSUploadVideoEntry, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.CQ;
    sqn.n("upload_publishing_feed", sqn.i(paramInt, l1 - l2));
    JSONObject localJSONObject;
    if (paramVSUploadVideoEntry != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("videoid", paramVSUploadVideoEntry.vid);
      localJSONObject.put("fail_code", paramInt);
      sqn.a("mystatus_post", "post_fail", 0, 0, new String[] { "", "", localJSONObject.toString() });
      return;
    }
    catch (JSONException paramVSUploadVideoEntry)
    {
      for (;;)
      {
        paramVSUploadVideoEntry.printStackTrace();
      }
    }
  }
  
  private void a(VSUploadVideoEntry paramVSUploadVideoEntry, CLIENT.StPublishStoryFeedRsp paramStPublishStoryFeedRsp)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.CQ;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret_code", "0");
    Object localObject;
    int i;
    if (paramVSUploadVideoEntry == null)
    {
      localObject = "0";
      localHashMap.put("type", localObject);
      localHashMap.put("time_cost", String.valueOf(l1 - l2));
      sqn.n("upload_publishing_feed", sqn.b(localHashMap));
      if ((paramVSUploadVideoEntry != null) && (paramVSUploadVideoEntry.originalEntry != null))
      {
        if (paramVSUploadVideoEntry.originalEntry.publishFrom != 120) {
          break label261;
        }
        i = 1;
        label105:
        if (!paramVSUploadVideoEntry.originalEntry.isLocalPublish) {
          break label266;
        }
      }
    }
    label261:
    label266:
    for (int j = 1;; j = 2)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("videoid", paramVSUploadVideoEntry.vid);
        if ((paramStPublishStoryFeedRsp != null) && (paramStPublishStoryFeedRsp.storyFeed != null)) {
          ((JSONObject)localObject).put("feedid", paramStPublishStoryFeedRsp.storyFeed.id.get());
        }
        ((JSONObject)localObject).put("video_duration", paramVSUploadVideoEntry.originalEntry.videoDuration);
      }
      catch (JSONException paramVSUploadVideoEntry)
      {
        for (;;)
        {
          paramVSUploadVideoEntry.printStackTrace();
        }
      }
      sqn.a("mystatus_post", "post_succ", i, 0, new String[] { j + "", "", ((JSONObject)localObject).toString() });
      return;
      if (paramVSUploadVideoEntry.retryTimes > 0)
      {
        localObject = "1";
        break;
      }
      localObject = "0";
      break;
      i = 2;
      break label105;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString, CLIENT.StPublishStoryFeedRsp paramStPublishStoryFeedRsp)
  {
    if (this.mTaskHandler == null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "mTaskHandler == null");
      return;
    }
    this.mTaskHandler.post(new VSUploadVideoFeedTask.2(this, paramBoolean, paramStPublishStoryFeedRsp, paramInt, paramString));
  }
  
  private void byn()
  {
    ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "switchUploadAction() startTask ==> fakeId:" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId + " , uploadStatus:" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus);
    int i = this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus;
    this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 1;
    this.jdField_a_of_type_Sfd.c(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry);
    switch (i)
    {
    case 11: 
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 12: 
      byo();
      return;
    case 3: 
    case 5: 
    case 7: 
      byp();
      return;
    case 6: 
    case 8: 
    case 10: 
      byq();
      return;
    }
    this.jdField_a_of_type_Sfd.b(this, null, new ErrorMessage());
  }
  
  private void byo()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 2;
    ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "[vs_publish_flow] compressMedia() composite start ==> fakeId:" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId + ", uploadStatus=" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.statusToInfo());
    if (MH()) {
      return;
    }
    sfl.a().qW(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
    long l = System.currentTimeMillis();
    Object localObject = ((poj)psx.a(14)).a(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
    l = System.currentTimeMillis() - l;
    if (((poj.a)localObject).b.isSuccess())
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "compressMedia()  composite success ====> compositeResult:" + ((poj.a)localObject).toString());
      sqn.n("merge_video_result_by_hardware", sqn.i(0L, l));
      this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.originalEntry = pog.a(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
      this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.localVideoPath = ((poj.a)localObject).videoUrl;
      this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 3;
      this.jdField_a_of_type_Sfd.c(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry);
      byp();
      return;
    }
    ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "compressMedia()  composite fail ====> fakeId:" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId + " , errorCode:" + ((poj.a)localObject).b.errorCode);
    sqn.n("merge_video_result_by_hardware", sqn.i(((poj.a)localObject).b.errorCode, l));
    this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 4;
    localObject = new ErrorMessage(((poj.a)localObject).b.errorCode, "视频合成失败");
    this.jdField_a_of_type_Sfd.b(this, null, (ErrorMessage)localObject);
  }
  
  private void byp()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 5;
    ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "[vs_publish_flow] uploadMedia()  upload MP4 start ==> fakeId:" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId + ", uploadStatus=" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.statusToInfo());
    if (MH()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.localVideoPath))
    {
      byr();
      return;
    }
    sfl.a().qX(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId)) {
      localBundle.putString("fakeVid", this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.localVideoPath)) {
      localBundle.putString("videoPath", this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.localVideoPath);
    }
    this.jdField_a_of_type_Sfd.c(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry);
  }
  
  private void byq()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 8;
    ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "sendProto()  uploadStatus=" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.statusToInfo());
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.vid))
    {
      byr();
      return;
    }
    sfl.a().qY(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
    cC(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.vid, this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
  }
  
  private void byr()
  {
    ErrorMessage localErrorMessage = new ErrorMessage(6003, "参数检测为空异常");
    this.jdField_a_of_type_Sfd.b(this, null, localErrorMessage);
  }
  
  private void cC(String paramString1, String paramString2)
  {
    ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "[vs_publish_flow] publishQQStoryFeed() send feed start ==> fakeId:" + paramString2 + " , vid:" + paramString1);
    if (MH()) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      byr();
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 8;
    this.jdField_a_of_type_Sfd.c(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry);
    paramString1 = new PublishVideoFeedRequest(a(paramString1));
    this.aDN = paramString1.getCmdName();
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "publishQQStoryFeed() publish feed not network");
      paramString1 = new ErrorMessage(6004, "网络环境异常");
      this.jdField_a_of_type_Sfd.b(this, null, paramString1);
      return;
    }
    this.CQ = System.currentTimeMillis();
    ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "publishQQStoryFeed() sendProto  sending...");
    VSNetworkHelper.a().a(paramString1, new sfo(this));
  }
  
  private String nx()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      String str = localQQAppInterface.getCurrentNickname();
      ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "getNickNameByUin() nickName:" + str);
      return localQQAppInterface.getCurrentNickname();
    }
    return "";
  }
  
  protected void h(String paramString, Bundle paramBundle)
  {
    int i;
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId)))
    {
      i = paramBundle.getInt("status", 0);
      this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = i;
    }
    switch (i)
    {
    default: 
      return;
    case 6: 
      sfl.a().qY(paramString);
      paramBundle = paramBundle.getString("vid", "");
      this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.vid = paramBundle;
      ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "onMediaEvent()  upload media success ===> fakeId:" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId + " , vid:" + paramBundle);
      this.jdField_a_of_type_Sfd.c(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry);
      cC(paramBundle, paramString);
      return;
    }
    paramString = new ErrorMessage();
    paramString.errorCode = paramBundle.getInt("errorCode", 0);
    paramString.errorMsg = paramBundle.getString("errMsg", "");
    ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "onMediaEvent()  upload media fail ===> fakeId:" + this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId + " , errorCode:" + paramString.errorCode + " , errorMsg:" + paramString.errorMsg);
    this.jdField_a_of_type_Sfd.b(this, null, paramString);
  }
  
  protected void startTask()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId)))
    {
      byr();
      return;
    }
    sfl.a().blZ();
    sfl.a().aw(this.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId, true);
    byn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoFeedTask
 * JD-Core Version:    0.7.0.1
 */