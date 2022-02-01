import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGroupVideoForward;
import com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.1;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class rnx
  implements Handler.Callback
{
  static final String CMD = ppf.fQ("StoryGroupSvc.do_group_video_forward");
  public MessageForTroopStory a;
  public String aBt;
  public String aBu;
  protected boolean aJc;
  achq b = new rnz(this);
  public int btL;
  jnm.b e = new rny(this);
  public QQAppInterface mApp;
  public String mCompatibleText;
  public String mFriendUin;
  public Handler mHandler;
  public String mMd5;
  public String mSenderUin;
  public String mSourceActionData;
  public String mSourceName;
  public String mThumbUrl;
  public String mUid;
  public int mUinType;
  public String mUnionId;
  public int mVideoHeight;
  public int mVideoWidth;
  
  private rnx(QQAppInterface paramQQAppInterface, Bundle paramBundle, SessionInfo paramSessionInfo)
    throws IllegalArgumentException
  {
    if (!a(paramBundle, paramSessionInfo)) {
      throw new IllegalArgumentException("params in bundle is Illegal");
    }
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.aJc = false;
  }
  
  private rnx(QQAppInterface paramQQAppInterface, MessageForTroopStory paramMessageForTroopStory)
  {
    this.a = paramMessageForTroopStory;
    this.mUid = String.valueOf(paramMessageForTroopStory.uid);
    this.mUnionId = paramMessageForTroopStory.unionId;
    this.mMd5 = paramMessageForTroopStory.md5;
    this.mThumbUrl = paramMessageForTroopStory.thumbUrl;
    this.aBt = paramMessageForTroopStory.doodleUrl;
    this.mVideoWidth = paramMessageForTroopStory.videoWidth;
    this.mVideoHeight = paramMessageForTroopStory.videoHeight;
    this.mSourceName = paramMessageForTroopStory.sourceName;
    this.aBu = paramMessageForTroopStory.sourceActionType;
    this.mSourceActionData = paramMessageForTroopStory.sourceActionData;
    this.mCompatibleText = paramMessageForTroopStory.compatibleText;
    this.btL = paramMessageForTroopStory.ctrVersion;
    this.mFriendUin = paramMessageForTroopStory.frienduin;
    this.mSenderUin = paramMessageForTroopStory.senderuin;
    this.mUinType = paramMessageForTroopStory.istroop;
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.aJc = true;
  }
  
  public static rnx a(QQAppInterface paramQQAppInterface, Bundle paramBundle, SessionInfo paramSessionInfo)
  {
    try
    {
      paramQQAppInterface = new rnx(paramQQAppInterface, paramBundle, paramSessionInfo);
      return paramQQAppInterface;
    }
    catch (IllegalArgumentException paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.troopstory.share", 2, "forward error", paramQQAppInterface);
      }
    }
    return null;
  }
  
  public static rnx a(QQAppInterface paramQQAppInterface, MessageForTroopStory paramMessageForTroopStory)
  {
    return new rnx(paramQQAppInterface, paramMessageForTroopStory);
  }
  
  private boolean a(Bundle paramBundle, SessionInfo paramSessionInfo)
  {
    this.mUid = String.valueOf(paramBundle.getLong("key_uid"));
    this.mUnionId = paramBundle.getString("key_union_id");
    this.mMd5 = paramBundle.getString("key_md5");
    this.mThumbUrl = paramBundle.getString("key_thumb_url");
    this.aBt = paramBundle.getString("key_doodle_url");
    this.mVideoWidth = paramBundle.getInt("key_video_width");
    this.mVideoHeight = paramBundle.getInt("key_video_height");
    this.mSourceName = paramBundle.getString("key_source_name");
    this.aBu = paramBundle.getString("key_source_action_type");
    this.mSourceActionData = paramBundle.getString("key_source_action_data");
    this.mCompatibleText = paramBundle.getString("key_compatible_text");
    this.btL = paramBundle.getInt("key_ctr_version");
    this.mFriendUin = paramSessionInfo.aTl;
    this.mSenderUin = paramSessionInfo.troopUin;
    this.mUinType = paramSessionInfo.cZ;
    return true;
  }
  
  public void bvF()
  {
    if (!this.aJc)
    {
      ThreadManager.executeOnSubThread(new TroopStoryForwardTask.1(this));
      return;
    }
    this.mApp.a().f(this.a, 0);
    this.mApp.b().as(this.a);
    this.mHandler.sendEmptyMessage(2);
  }
  
  public void bvG()
  {
    qqstory_group.ReqGroupVideoForward localReqGroupVideoForward = new qqstory_group.ReqGroupVideoForward();
    int i;
    switch (this.mUinType)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.troopstory.share", 2, "unsupport type:" + this.mUinType);
      }
      this.mHandler.sendEmptyMessage(5);
      return;
    case 1: 
      i = 1;
    }
    for (;;)
    {
      localReqGroupVideoForward.type.set(i);
      try
      {
        long l = Long.parseLong(this.mFriendUin);
        localReqGroupVideoForward.forward_to.set(l);
        localReqGroupVideoForward.vid.set(ByteStringMicro.copyFromUtf8(this.mMd5));
        localReqGroupVideoForward.time.set((int)this.a.time);
        jnm.a(this.mApp, this.e, localReqGroupVideoForward.toByteArray(), CMD);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.troopstory.share", 2, "uin parse error:" + this.mFriendUin);
        this.mHandler.sendEmptyMessage(5);
      }
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public void bvH()
  {
    this.mApp.b().b(this.a, this.b);
  }
  
  public void bvI()
  {
    this.mApp.a().e(this.a.frienduin, this.a.istroop, this.a.uniseq);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.troopstory.share", 2, "forward step=" + paramMessage.what + ", task=" + this);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      bvF();
      continue;
      bvG();
      continue;
      bvH();
      continue;
      bvI();
      continue;
      onFailed();
    }
  }
  
  public void onFailed()
  {
    this.mApp.a().e(this.a.frienduin, this.a.istroop, this.a.uniseq);
    this.mApp.b().as(this.a);
  }
  
  public void start()
  {
    this.mHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnx
 * JD-Core Version:    0.7.0.1
 */