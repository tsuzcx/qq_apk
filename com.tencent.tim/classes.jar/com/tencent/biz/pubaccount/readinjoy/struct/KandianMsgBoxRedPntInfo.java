package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import kxm;
import mhm;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgBody;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgContent;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgFolderInfo;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetRsp;

public class KandianMsgBoxRedPntInfo
  implements Serializable
{
  public static final int DATA_TYPE_CARD = 1;
  public static final int DATA_TYPE_TIPS = 0;
  public static final String ENABLE_RECEIVE_RED_PNT_SWITCH = "sp_msg_box_80a_enable_receive";
  public static final String SP_KEY = "kandian_msg_box_sp_key_new";
  private static final long serialVersionUID = -3014381608481056753L;
  public boolean canDoAnimation = true;
  public int dataType = 0;
  public String feedsID;
  public int feedsType;
  public boolean isExpose;
  public boolean isFromNotification;
  public boolean isRead;
  public String mArticlePicUrl;
  public String mCardSummary;
  public String mExtraData;
  public String mIconUrl;
  public String mJumpUrl;
  public int mMsgCnt;
  public String mMsgId;
  public long mMsgTime;
  public int mMsgType;
  public boolean mNeedShowInFolder;
  public String mOrangeWord;
  public int mRedType;
  public long mSeq;
  public String mSummary;
  public long mUin;
  public int messageType;
  public int sysMsgFrom;
  public String sysMsgID;
  
  public static KandianMsgBoxRedPntInfo createFromJSON(String paramString)
  {
    try
    {
      KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = new KandianMsgBoxRedPntInfo();
      paramString = new JSONObject(paramString);
      localKandianMsgBoxRedPntInfo.mSeq = paramString.getLong("_red_ext_seq");
      localKandianMsgBoxRedPntInfo.mUin = paramString.getLong("_red_ext_from_uin");
      localKandianMsgBoxRedPntInfo.mMsgType = paramString.getInt("_red_ext_msg_type");
      localKandianMsgBoxRedPntInfo.mMsgTime = paramString.getLong("_red_ext_msg_time");
      localKandianMsgBoxRedPntInfo.mIconUrl = paramString.getString("_red_ext_pic_url");
      localKandianMsgBoxRedPntInfo.mJumpUrl = paramString.getString("_red_ext_jump_url");
      localKandianMsgBoxRedPntInfo.mNeedShowInFolder = false;
      localKandianMsgBoxRedPntInfo.mRedType = paramString.getInt("_red_ext_red_type");
      localKandianMsgBoxRedPntInfo.mOrangeWord = paramString.getString("_red_ext_orange_word");
      localKandianMsgBoxRedPntInfo.mSummary = paramString.getString("_red_ext_summary");
      if ((!TextUtils.isEmpty(localKandianMsgBoxRedPntInfo.mSummary)) && (!TextUtils.isEmpty(localKandianMsgBoxRedPntInfo.mOrangeWord))) {
        localKandianMsgBoxRedPntInfo.mNeedShowInFolder = true;
      }
      localKandianMsgBoxRedPntInfo.mMsgCnt = paramString.getInt("_red_ext_unread");
      return localKandianMsgBoxRedPntInfo;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public static KandianMsgBoxRedPntInfo createFromPB(oidb_cmd0xbe4.MsgGetRsp paramMsgGetRsp)
  {
    if (paramMsgGetRsp == null) {
      return null;
    }
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = new KandianMsgBoxRedPntInfo();
    localKandianMsgBoxRedPntInfo.mMsgCnt = ((int)paramMsgGetRsp.uint64_unread.get());
    oidb_cmd0xbe4.MsgBody localMsgBody = (oidb_cmd0xbe4.MsgBody)paramMsgGetRsp.msg_body.get();
    if (localMsgBody == null) {
      return null;
    }
    localKandianMsgBoxRedPntInfo.mSeq = localMsgBody.uint64_seq.get();
    localKandianMsgBoxRedPntInfo.mMsgType = localMsgBody.uint32_msg_type.get();
    localKandianMsgBoxRedPntInfo.mMsgTime = localMsgBody.uint64_msg_time.get();
    if (localMsgBody.bytes_pic_url.has()) {
      localKandianMsgBoxRedPntInfo.mIconUrl = localMsgBody.bytes_pic_url.get().toStringUtf8();
    }
    if (localMsgBody.bytes_jump_url.has()) {
      localKandianMsgBoxRedPntInfo.mJumpUrl = localMsgBody.bytes_jump_url.get().toStringUtf8();
    }
    if (localMsgBody.str_msgid.has()) {
      localKandianMsgBoxRedPntInfo.mMsgId = localMsgBody.str_msgid.get();
    }
    localKandianMsgBoxRedPntInfo.mUin = localMsgBody.uint64_from_uin.get();
    boolean bool;
    label219:
    label243:
    oidb_cmd0xbe4.MsgContent localMsgContent;
    if (localMsgBody.msg_folder_info.has())
    {
      paramMsgGetRsp = (oidb_cmd0xbe4.MsgFolderInfo)localMsgBody.msg_folder_info.get();
      if (paramMsgGetRsp.uint32_show_folder.get() == 1)
      {
        bool = true;
        localKandianMsgBoxRedPntInfo.mNeedShowInFolder = bool;
        if (!paramMsgGetRsp.bytes_summary.has()) {
          break label437;
        }
        localKandianMsgBoxRedPntInfo.mSummary = paramMsgGetRsp.bytes_summary.get().toStringUtf8();
        if (!paramMsgGetRsp.bytes_orange_word.has()) {
          break label445;
        }
        localKandianMsgBoxRedPntInfo.mOrangeWord = paramMsgGetRsp.bytes_orange_word.get().toStringUtf8();
      }
    }
    else if (localMsgBody.msg_content.has())
    {
      localKandianMsgBoxRedPntInfo.dataType = 1;
      localMsgContent = (oidb_cmd0xbe4.MsgContent)localMsgBody.msg_content.get();
      if (!localMsgContent.str_desc.has()) {
        break label453;
      }
      paramMsgGetRsp = localMsgContent.str_desc.get();
      label290:
      localKandianMsgBoxRedPntInfo.mCardSummary = paramMsgGetRsp;
      if (!localMsgContent.str_feeds_pic.has()) {
        break label460;
      }
      paramMsgGetRsp = localMsgContent.str_feeds_pic.get();
      label315:
      localKandianMsgBoxRedPntInfo.mArticlePicUrl = paramMsgGetRsp;
      localKandianMsgBoxRedPntInfo.sysMsgFrom = localMsgContent.uint32_sys_from.get();
      if (!localMsgContent.string_sys_activityid.has()) {
        break label467;
      }
      paramMsgGetRsp = localMsgContent.string_sys_activityid.get();
      label352:
      localKandianMsgBoxRedPntInfo.sysMsgID = paramMsgGetRsp;
      if (!localMsgContent.string_feeds_id.has()) {
        break label474;
      }
    }
    label437:
    label445:
    label453:
    label460:
    label467:
    label474:
    for (paramMsgGetRsp = localMsgContent.string_feeds_id.get();; paramMsgGetRsp = "")
    {
      localKandianMsgBoxRedPntInfo.feedsID = paramMsgGetRsp;
      localKandianMsgBoxRedPntInfo.feedsType = localMsgContent.uint32_feed_type.get();
      localKandianMsgBoxRedPntInfo.messageType = localMsgContent.uint32_type.get();
      if (localMsgBody.bytes_ext_data.has()) {
        localKandianMsgBoxRedPntInfo.mExtraData = localMsgBody.bytes_ext_data.get().toStringUtf8();
      }
      return localKandianMsgBoxRedPntInfo;
      bool = false;
      break;
      localKandianMsgBoxRedPntInfo.mNeedShowInFolder = false;
      break label219;
      localKandianMsgBoxRedPntInfo.mNeedShowInFolder = false;
      break label243;
      paramMsgGetRsp = "";
      break label290;
      paramMsgGetRsp = "";
      break label315;
      paramMsgGetRsp = "";
      break label352;
    }
  }
  
  public static KandianMsgBoxRedPntInfo getRedPntInfoFromSp()
  {
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo2 = (KandianMsgBoxRedPntInfo)kxm.a(localAppRuntime, "kandian_msg_box_sp_key_new", true);
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo1 = localKandianMsgBoxRedPntInfo2;
    if (localKandianMsgBoxRedPntInfo2 == null)
    {
      mhm localmhm1 = mhm.d();
      mhm localmhm2 = mhm.a();
      if (localmhm1 == null)
      {
        localKandianMsgBoxRedPntInfo1 = localKandianMsgBoxRedPntInfo2;
        if (localmhm2 == null) {}
      }
      else
      {
        localKandianMsgBoxRedPntInfo1 = new KandianMsgBoxRedPntInfo();
        localKandianMsgBoxRedPntInfo1.mSeq = -1L;
        localKandianMsgBoxRedPntInfo1.mNeedShowInFolder = false;
        if (localmhm2 != null)
        {
          localKandianMsgBoxRedPntInfo1.mMsgCnt += localmhm2.msgCount;
          localKandianMsgBoxRedPntInfo1.mUin = localmhm2.vi;
          localKandianMsgBoxRedPntInfo1.mMsgTime = System.currentTimeMillis();
          localKandianMsgBoxRedPntInfo1.mMsgType = 1;
          localmhm2.e(localAppRuntime);
        }
        if (localmhm1 != null)
        {
          localKandianMsgBoxRedPntInfo1.mMsgCnt += localmhm1.msgCount;
          localKandianMsgBoxRedPntInfo1.mMsgType = 2;
          localmhm1.X((QQAppInterface)localAppRuntime);
        }
        localKandianMsgBoxRedPntInfo1.asyncWriteToSP();
      }
    }
    return localKandianMsgBoxRedPntInfo1;
  }
  
  public void asyncWriteToSP()
  {
    kxm.b("kandian_msg_box_sp_key_new", this, true);
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
      paramObject = (KandianMsgBoxRedPntInfo)paramObject;
    } while ((this.mSeq == paramObject.mSeq) && (this.mMsgCnt == paramObject.mMsgCnt) && (this.mMsgTime == paramObject.mMsgTime) && (this.mUin == paramObject.mUin) && (this.mMsgType == paramObject.mMsgType) && (this.mNeedShowInFolder == paramObject.mNeedShowInFolder) && (this.mRedType == paramObject.mRedType) && (this.dataType == paramObject.dataType) && (this.sysMsgFrom == paramObject.sysMsgFrom) && (this.feedsType == paramObject.feedsType) && (this.messageType == paramObject.messageType) && (TextUtils.equals(this.mJumpUrl, paramObject.mJumpUrl)) && (TextUtils.equals(this.mIconUrl, paramObject.mIconUrl)) && (TextUtils.equals(this.mSummary, paramObject.mSummary)) && (TextUtils.equals(this.mOrangeWord, paramObject.mOrangeWord)) && (TextUtils.equals(this.mCardSummary, paramObject.mCardSummary)) && (TextUtils.equals(this.mArticlePicUrl, paramObject.mArticlePicUrl)) && (TextUtils.equals(this.mExtraData, paramObject.mExtraData)) && (TextUtils.equals(this.sysMsgID, paramObject.sysMsgID)) && (TextUtils.equals(this.feedsID, paramObject.feedsID)) && (this.isExpose == paramObject.isExpose));
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.mSeq + this.mUin + this.mMsgCnt + this.mSummary.hashCode());
  }
  
  public void removeFromSP()
  {
    kxm.af("kandian_msg_box_sp_key_new", true);
  }
  
  public String toString()
  {
    return "KandianMsgBoxRedPntInfo{mSeq=" + this.mSeq + ", mMsgCnt=" + this.mMsgCnt + ", mMsgTime=" + this.mMsgTime + ", mUin=" + this.mUin + ", mMsgType=" + this.mMsgType + ", mJumpUrl='" + this.mJumpUrl + '\'' + ", mIconUrl='" + this.mIconUrl + '\'' + ", mMsgId='" + this.mMsgId + '\'' + ", isRead=" + this.isRead + ", mNeedShowInFolder=" + this.mNeedShowInFolder + ", mRedType=" + this.mRedType + ", mSummary='" + this.mSummary + '\'' + ", mOrangeWord='" + this.mOrangeWord + '\'' + ", canDoAnimation=" + this.canDoAnimation + ", mCardSummary='" + this.mCardSummary + '\'' + ", mArticlePicUrl='" + this.mArticlePicUrl + '\'' + ", mExtraData='" + this.mExtraData + '\'' + ", isExpose='" + this.isExpose + '\'' + '}';
  }
  
  public void writeToSP()
  {
    kxm.c("kandian_msg_box_sp_key_new", this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo
 * JD-Core Version:    0.7.0.1
 */