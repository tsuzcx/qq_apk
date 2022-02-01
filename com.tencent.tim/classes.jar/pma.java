import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqSubscription;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetInfoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetSearchFeedList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqForbidStory;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetForbiddenList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetForbiddenStates;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeWatched;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqVideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspForbidStory;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetForbiddenList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetForbiddenStates;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSyncVideoPublish;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspVideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.PicSpecs;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfoExt;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSourceTagInfo;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0xcc.SubMsgType0xcc.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xd0.SubMsgType0xd0.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xda.SubMsgType0xda.MsgBody;

public class pma
  extends accg
{
  public static final String atA = ppf.fQ("StorySvc.video_get_user_mask_states");
  public static final String atB = ppf.fQ("StorySvc.video_show_video_list");
  public static final String atC = ppf.fQ("StorySvc.get_official_recommend");
  public static final String atD = ppf.fQ("StorySvc.pgc_subscribe_operation");
  public static final String atE = ppf.fQ("StorySvc.pgc_person_page");
  public static final String atF = ppf.fQ("StorySvc.pgc_search_feedlist_get");
  public static final String atG = ppf.fQ("StorySvc.pgc_client_report");
  public static final String atH = ppf.fQ("StorySvc.video_aio_sync_publish");
  public static final String atI = ppf.fQ("StorySvc.get_video_reader_config");
  public static final String atJ = ppf.fQ("StorySvc.msgtab_node_feedback");
  public static final String atw = ppf.fQ("StorySvc.video_config_get");
  public static final String atx = ppf.fQ("StorySvc.video_config_set");
  public static final String aty = ppf.fQ("StorySvc.video_get_user_mask_list");
  public static final String atz = ppf.fQ("StorySvc.video_set_user_mask");
  
  public pma(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void aJ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    if (paramObject != null) {
      paramToServiceMsg = new qqstory_service.RspSetConfig();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.result.error_code.get() == 0)
        {
          notifyUI(1004, true, null);
          notifyUI(1019, true, null);
          if (i == 0)
          {
            notifyUI(1004, false, null);
            notifyUI(1019, false, null);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      i = 0;
    }
  }
  
  private void aK(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ram.d("QQStoryHandler", "handleGetForbidList");
    boolean bool2;
    int i;
    Object localObject;
    if (paramObject != null)
    {
      bool2 = paramToServiceMsg.extraData.getBoolean("isNotAllowed");
      i = paramToServiceMsg.extraData.getInt("count");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("tag");
      localObject = new qqstory_service.RspGetForbiddenList();
    }
    for (;;)
    {
      QQStoryUserInfo localQQStoryUserInfo;
      try
      {
        ((qqstory_service.RspGetForbiddenList)localObject).mergeFrom((byte[])paramObject);
        if (((qqstory_service.RspGetForbiddenList)localObject).result.error_code.get() == 0)
        {
          if (((qqstory_service.RspGetForbiddenList)localObject).is_end.get() != 0)
          {
            bool1 = true;
            paramFromServiceMsg = ((qqstory_service.RspGetForbiddenList)localObject).next_cookie.get().toByteArray();
            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.length == 0)) {
              break label340;
            }
            localObject = ((qqstory_service.RspGetForbiddenList)localObject).user_list.get();
            if (((List)localObject).size() >= i) {
              break label337;
            }
            bool1 = true;
            paramObject = new ArrayList();
            localObject = ((List)localObject).iterator();
            if (!((Iterator)localObject).hasNext()) {
              break label299;
            }
            qqstory_struct.UserInfo localUserInfo = (qqstory_struct.UserInfo)((Iterator)localObject).next();
            localQQStoryUserInfo = new QQStoryUserInfo();
            localQQStoryUserInfo.uin = (localUserInfo.uid.get() + "");
            localQQStoryUserInfo.setNick(aqgv.D(this.app, localQQStoryUserInfo.uin));
            if (!bool2) {
              break label290;
            }
            localQQStoryUserInfo.isAllowed = 1;
            label249:
            paramObject.add(localQQStoryUserInfo);
            continue;
          }
        }
        else if (i != 0) {}
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        i = 0;
      }
      for (;;)
      {
        notifyUI(1001, false, null);
        return;
        bool1 = false;
        break;
        label290:
        localQQStoryUserInfo.isInterested = 1;
        break label249;
        label299:
        notifyUI(1001, true, new Object[] { paramObject, paramFromServiceMsg, Boolean.valueOf(bool1), paramToServiceMsg });
        i = 1;
      }
      label337:
      continue;
      label340:
      boolean bool1 = true;
    }
  }
  
  private void aM(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("reqUin");
    pmb localpmb;
    if (paramObject != null)
    {
      localpmb = (pmb)this.app.getManager(181);
      paramToServiceMsg = new qqstory_service.RspGetForbiddenStates();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.result.error_code.get() == 0))
      {
        paramFromServiceMsg = localpmb.a(str);
        paramToServiceMsg = paramToServiceMsg.user_list.get();
        if (paramToServiceMsg.size() > 0)
        {
          paramToServiceMsg = (qqstory_struct.UserInfo)paramToServiceMsg.get(0);
          i = paramToServiceMsg.ext.his_story_forbidden.get();
          int j = paramToServiceMsg.ext.my_story_forbidden.get();
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new QQStoryUserInfo();
            paramToServiceMsg.uin = str;
            paramToServiceMsg.setNick(aqgv.D(this.app, str));
            localpmb.bR.put(str, paramToServiceMsg);
            paramToServiceMsg.isAllowed = j;
            paramToServiceMsg.isInterested = i;
            if (paramToServiceMsg.getStatus() == 1000)
            {
              localpmb.em.persist(paramToServiceMsg);
              notifyUI(1005, true, paramToServiceMsg);
              i = 1;
              if (i == 0) {
                notifyUI(1005, true, null);
              }
              return;
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = null;
        continue;
        localpmb.em.update(paramToServiceMsg);
        continue;
        paramToServiceMsg = paramFromServiceMsg;
        continue;
        int i = 0;
      }
    }
  }
  
  private void aN(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        paramToServiceMsg = new qqstory_service.RspGetUserVideoList();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (qqstory_struct.ErrorInfo)paramToServiceMsg.result.get();
        paramFromServiceMsg = paramToServiceMsg.video_list.get();
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramToServiceMsg.add(((qqstory_struct.StoryVideoDes)paramFromServiceMsg.next()).video_cover.get().toStringUtf8());
          continue;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
    for (;;)
    {
      if (i == 0) {
        notifyUI(1006, false, null);
      }
      return;
      notifyUI(1006, true, paramToServiceMsg);
      int i = 1;
    }
  }
  
  private void aO(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m;
    long l;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      m = 1;
      if (paramToServiceMsg != null) {
        break label317;
      }
      l = -1L;
      label20:
      if (paramFromServiceMsg != null) {
        break label336;
      }
      j = -1;
      label27:
      if (paramFromServiceMsg != null) {
        break label345;
      }
      paramToServiceMsg = "local data";
      label35:
      k = 0;
      n = 0;
      paramFromServiceMsg = paramToServiceMsg;
      i = j;
      if (!q(paramObject)) {
        break label388;
      }
    }
    for (;;)
    {
      try
      {
        localRspGetInfoCard = new qqstory_pgc.RspGetInfoCard();
        localRspGetInfoCard.mergeFrom((byte[])paramObject);
        paramObject = (qqstory_pgc.ErrorInfo)localRspGetInfoCard.result.get();
        i = paramObject.error_code.get();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        qqstory_pgc.RspGetInfoCard localRspGetInfoCard;
        label317:
        label336:
        label345:
        k = n;
        label388:
        i = j;
        continue;
      }
      try
      {
        paramFromServiceMsg = paramObject.error_desc.get().toStringUtf8();
        paramToServiceMsg = paramFromServiceMsg;
        try
        {
          if ((paramObject.error_code.get() == 0) && (localRspGetInfoCard.user.has()))
          {
            paramObject = UserInfo.convertFrom((qqstory_pgc.UserInfo)localRspGetInfoCard.user.get());
            j = 0;
            if (paramObject != null)
            {
              paramFromServiceMsg = paramObject;
              if (paramObject.checkData()) {}
            }
            else
            {
              j = 1;
              paramFromServiceMsg = null;
              pmb.showToast("QQStoryHandler handleGetPGCUserInfoCard user=" + null);
            }
            if (j != 0)
            {
              rar.b("story_check", "pgc_check", 0, 1, new String[] { atE });
              notifyUI(1009, true, paramFromServiceMsg);
              k = 1;
              j = k;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          k = n;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        k = n;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleGetPGCUserInfoCard isSuccess=" + true + " user:" + paramFromServiceMsg);
          j = k;
        }
        if (j == 0) {
          notifyUI(1009, false, null);
        }
        if (m == 0) {
          b(atE, l, i, paramToServiceMsg);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        k = 1;
        continue;
      }
      m = 0;
      break;
      l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
      break label20;
      j = paramFromServiceMsg.getBusinessFailCode();
      break label27;
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      break label35;
      rar.b("story_check", "pgc_check", 0, 0, new String[] { atE });
      continue;
      paramFromServiceMsg.printStackTrace();
      paramFromServiceMsg = paramToServiceMsg;
      j = k;
      paramToServiceMsg = paramFromServiceMsg;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleGetPGCUserInfoCard error_code=" + paramObject.error_code.get() + " user:" + localRspGetInfoCard.user.get());
      }
      j = 0;
    }
  }
  
  private void aP(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m;
    long l;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      m = 1;
      if (paramToServiceMsg != null) {
        break label235;
      }
      l = -1L;
      label20:
      if (paramFromServiceMsg != null) {
        break label254;
      }
      j = -1;
      label27:
      if (paramFromServiceMsg != null) {
        break label263;
      }
      paramToServiceMsg = "local data";
      label35:
      k = 0;
      n = 0;
      paramFromServiceMsg = paramToServiceMsg;
      i = j;
      if (!q(paramObject)) {
        break label442;
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject1 = new qqstory_pgc.RspGetSearchFeedList();
          ((qqstory_pgc.RspGetSearchFeedList)localObject1).mergeFrom((byte[])paramObject);
          paramObject = (qqstory_pgc.ErrorInfo)((qqstory_pgc.RspGetSearchFeedList)localObject1).result.get();
          i = paramObject.error_code.get();
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          Object localObject1;
          Object localObject2;
          label235:
          label254:
          k = n;
          label263:
          i = j;
          continue;
        }
        try
        {
          paramFromServiceMsg = paramObject.error_desc.get().toStringUtf8();
          paramToServiceMsg = paramFromServiceMsg;
          if (i != 0) {
            continue;
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          k = n;
          continue;
          continue;
          for (;;)
          {
            if (j != 1) {
              break label713;
            }
            bool = true;
            break;
            j = 0;
          }
          bool = false;
          continue;
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (((qqstory_pgc.RspGetSearchFeedList)localObject1).result_type.has())
          {
            k = ((qqstory_pgc.RspGetSearchFeedList)localObject1).result_type.get();
            paramFromServiceMsg = ((qqstory_pgc.RspGetSearchFeedList)localObject1).feed_list.get();
            paramObject = new ArrayList();
            j = 0;
            paramFromServiceMsg = paramFromServiceMsg.iterator();
            if (!paramFromServiceMsg.hasNext()) {
              continue;
            }
            localObject2 = UserInfo.convertFrom((qqstory_pgc.UserInfo)paramFromServiceMsg.next());
            if ((localObject2 != null) && (((UserInfo)localObject2).checkData())) {
              continue;
            }
            j = 1;
            pmb.showToast("QQStoryHandler handleGetPGCSearchFeedList user=" + localObject2);
            continue;
            m = 0;
            break;
            l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
            break label20;
            j = paramFromServiceMsg.getBusinessFailCode();
            break label27;
            paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
            break label35;
          }
          k = 2;
          continue;
          paramObject.add(localObject2);
          continue;
          if (j == 0) {
            continue;
          }
          rar.b("story_check", "pgc_check", 0, 1, new String[] { atF });
          if (!((qqstory_pgc.RspGetSearchFeedList)localObject1).is_end.has()) {
            break label707;
          }
          j = ((qqstory_pgc.RspGetSearchFeedList)localObject1).is_end.get();
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          k = n;
        }
      }
      if (!((qqstory_pgc.RspGetSearchFeedList)localObject1).next_cookie.has()) {
        break label719;
      }
      paramFromServiceMsg = ((qqstory_pgc.RspGetSearchFeedList)localObject1).next_cookie.get().toStringUtf8();
      localObject2 = new ArrayList();
      if (!((qqstory_pgc.RspGetSearchFeedList)localObject1).key_word_list.has()) {
        continue;
      }
      localObject1 = ((qqstory_pgc.RspGetSearchFeedList)localObject1).key_word_list.get().iterator();
      if (!((Iterator)localObject1).hasNext()) {
        continue;
      }
      ((List)localObject2).add(((ByteStringMicro)((Iterator)localObject1).next()).toStringUtf8());
      continue;
      paramFromServiceMsg.printStackTrace();
      paramFromServiceMsg = paramToServiceMsg;
      label442:
      paramToServiceMsg = paramFromServiceMsg;
      j = k;
      if (j == 0) {
        notifyUI(1010, false, null);
      }
      if (m == 0) {
        b(atF, l, i, paramToServiceMsg);
      }
      return;
      rar.b("story_check", "pgc_check", 0, 0, new String[] { atF });
    }
    notifyUI(1010, true, new Object[] { Integer.valueOf(k), paramObject, Boolean.valueOf(bool), paramFromServiceMsg, localObject2 });
    k = 1;
    for (j = k;; j = 0)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleGetPGCSearchFeedList isSuccess=" + true + " userInfoList:" + paramObject + " isEnd:" + bool + " nextCookie:" + paramFromServiceMsg);
          j = k;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        k = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleGetPGCSearchFeedList error_code=" + paramObject.error_code.get());
      }
    }
  }
  
  /* Error */
  private void aQ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +276 -> 277
    //   4: iconst_0
    //   5: istore 4
    //   7: aload_1
    //   8: ifnonnull +285 -> 293
    //   11: aconst_null
    //   12: astore 12
    //   14: iconst_3
    //   15: anewarray 275	java/lang/Object
    //   18: astore 13
    //   20: aload 13
    //   22: iconst_0
    //   23: iload 4
    //   25: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: aload 13
    //   31: iconst_1
    //   32: aload 12
    //   34: aastore
    //   35: aload_1
    //   36: ifnull +7 -> 43
    //   39: aload_2
    //   40: ifnonnull +268 -> 308
    //   43: iconst_1
    //   44: istore 7
    //   46: aload_1
    //   47: ifnonnull +267 -> 314
    //   50: ldc2_w 366
    //   53: lstore 9
    //   55: aload_2
    //   56: ifnonnull +277 -> 333
    //   59: iconst_m1
    //   60: istore 5
    //   62: aload_2
    //   63: ifnonnull +279 -> 342
    //   66: ldc_w 369
    //   69: astore_1
    //   70: iconst_0
    //   71: istore 6
    //   73: iconst_0
    //   74: istore 8
    //   76: aload_1
    //   77: astore_2
    //   78: iload 5
    //   80: istore 4
    //   82: aload_3
    //   83: invokestatic 372	pma:q	(Ljava/lang/Object;)Z
    //   86: ifeq +334 -> 420
    //   89: new 513	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspSubscription
    //   92: dup
    //   93: invokespecial 514	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspSubscription:<init>	()V
    //   96: astore 12
    //   98: aload 12
    //   100: aload_3
    //   101: checkcast 98	[B
    //   104: checkcast 98	[B
    //   107: invokevirtual 515	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspSubscription:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: pop
    //   111: aload 12
    //   113: getfield 516	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspSubscription:result	Lcom/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo;
    //   116: invokevirtual 382	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   119: checkcast 381	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo
    //   122: astore_3
    //   123: aload_3
    //   124: getfield 383	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo:error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: istore 4
    //   132: aload_3
    //   133: getfield 386	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo:error_desc	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   136: invokevirtual 178	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   139: invokevirtual 364	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   142: astore_2
    //   143: aload_2
    //   144: astore_1
    //   145: iload 4
    //   147: ifne +209 -> 356
    //   150: aload 12
    //   152: getfield 519	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspSubscription:is_subscribe	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   155: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   158: iconst_1
    //   159: if_icmpne +191 -> 350
    //   162: iconst_1
    //   163: istore 11
    //   165: aload 13
    //   167: iconst_2
    //   168: iload 11
    //   170: invokestatic 281	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   173: aastore
    //   174: aload_0
    //   175: sipush 1011
    //   178: iconst_1
    //   179: aload 13
    //   181: invokevirtual 122	pma:notifyUI	(IZLjava/lang/Object;)V
    //   184: iconst_1
    //   185: istore 6
    //   187: iload 6
    //   189: istore 5
    //   191: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +45 -> 239
    //   197: ldc_w 432
    //   200: iconst_2
    //   201: new 222	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 521
    //   211: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iconst_1
    //   215: invokevirtual 437	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   218: ldc_w 523
    //   221: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: iload 11
    //   226: invokevirtual 437	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   229: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: iload 6
    //   237: istore 5
    //   239: iload 5
    //   241: ifne +18 -> 259
    //   244: aload 13
    //   246: iconst_2
    //   247: aconst_null
    //   248: aastore
    //   249: aload_0
    //   250: sipush 1011
    //   253: iconst_0
    //   254: aload 13
    //   256: invokevirtual 122	pma:notifyUI	(IZLjava/lang/Object;)V
    //   259: iload 7
    //   261: ifne +15 -> 276
    //   264: aload_0
    //   265: getstatic 59	pma:atD	Ljava/lang/String;
    //   268: lload 9
    //   270: iload 4
    //   272: aload_1
    //   273: invokevirtual 445	pma:b	(Ljava/lang/String;JILjava/lang/String;)V
    //   276: return
    //   277: aload_1
    //   278: getfield 142	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   281: ldc_w 525
    //   284: iconst_0
    //   285: invokevirtual 528	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   288: istore 4
    //   290: goto -283 -> 7
    //   293: aload_1
    //   294: getfield 142	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   297: ldc_w 530
    //   300: invokevirtual 161	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: astore 12
    //   305: goto -291 -> 14
    //   308: iconst_0
    //   309: istore 7
    //   311: goto -265 -> 46
    //   314: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   317: aload_1
    //   318: getfield 142	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   321: ldc_w 452
    //   324: invokevirtual 456	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   327: lsub
    //   328: lstore 9
    //   330: goto -275 -> 55
    //   333: aload_2
    //   334: invokevirtual 461	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   337: istore 5
    //   339: goto -277 -> 62
    //   342: aload_2
    //   343: invokevirtual 464	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   346: astore_1
    //   347: goto -277 -> 70
    //   350: iconst_0
    //   351: istore 11
    //   353: goto -188 -> 165
    //   356: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +36 -> 395
    //   362: ldc_w 432
    //   365: iconst_2
    //   366: new 222	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 532
    //   376: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_3
    //   380: getfield 383	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo:error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   386: invokevirtual 469	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: iconst_0
    //   396: istore 5
    //   398: goto -159 -> 239
    //   401: astore_2
    //   402: iload 5
    //   404: istore 4
    //   406: iload 8
    //   408: istore 5
    //   410: aload_2
    //   411: invokevirtual 125	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   414: iload 5
    //   416: istore 6
    //   418: aload_1
    //   419: astore_2
    //   420: iload 6
    //   422: istore 5
    //   424: aload_2
    //   425: astore_1
    //   426: goto -187 -> 239
    //   429: astore_2
    //   430: iload 8
    //   432: istore 5
    //   434: goto -24 -> 410
    //   437: astore_2
    //   438: iload 8
    //   440: istore 5
    //   442: goto -32 -> 410
    //   445: astore_2
    //   446: iconst_1
    //   447: istore 5
    //   449: goto -39 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	pma
    //   0	452	1	paramToServiceMsg	ToServiceMsg
    //   0	452	2	paramFromServiceMsg	FromServiceMsg
    //   0	452	3	paramObject	Object
    //   5	400	4	i	int
    //   60	388	5	j	int
    //   71	350	6	k	int
    //   44	266	7	m	int
    //   74	365	8	n	int
    //   53	276	9	l	long
    //   163	189	11	bool	boolean
    //   12	292	12	localObject	Object
    //   18	237	13	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   89	132	401	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   132	143	429	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   150	162	437	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   165	184	437	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   356	395	437	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   191	235	445	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public static boolean q(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof byte[])) && (((byte[])paramObject).length > 0);
  }
  
  public void P(byte[] paramArrayOfByte)
  {
    String str3 = null;
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xcc. data == null");
      }
      return;
    }
    for (;;)
    {
      try
      {
        SubMsgType0xcc.MsgBody localMsgBody = new SubMsgType0xcc.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        int i = localMsgBody.uint32_msg_type.get();
        String str4 = localMsgBody.bytes_sub_type.get().toStringUtf8();
        String str5 = localMsgBody.bytes_msg_info.get().toStringUtf8();
        long l = 0L;
        if (localMsgBody.uint64_uin.has()) {
          l = localMsgBody.uint64_uin.get();
        }
        if (!localMsgBody.bytes_union_id.has()) {
          break label267;
        }
        paramArrayOfByte = localMsgBody.bytes_union_id.get().toStringUtf8();
        if (!localMsgBody.bytes_vid.has()) {
          break label255;
        }
        str1 = localMsgBody.bytes_vid.get().toStringUtf8();
        if (!localMsgBody.bytes_feed_id.has()) {
          break label261;
        }
        str2 = localMsgBody.bytes_feed_id.get().toStringUtf8();
        if (localMsgBody.bytes_cover_url.has()) {
          str3 = localMsgBody.bytes_cover_url.get().toStringUtf8();
        }
        a(new StoryPushMsg(i, str4, str5, l, paramArrayOfByte, str2, str1, str3));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xcc. merge exception:" + paramArrayOfByte.getMessage());
      return;
      label255:
      String str1 = null;
      continue;
      label261:
      String str2 = null;
      continue;
      label267:
      paramArrayOfByte = null;
    }
  }
  
  public void Q(byte[] paramArrayOfByte)
  {
    String str1 = null;
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xd0. data == null");
      }
    }
    do
    {
      return;
      try
      {
        SubMsgType0xd0.MsgBody localMsgBody = new SubMsgType0xd0.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        int i = localMsgBody.uint32_msg_type.get();
        String str2 = localMsgBody.bytes_sub_type.get().toStringUtf8();
        String str3 = localMsgBody.bytes_msg_info.get().toStringUtf8();
        paramArrayOfByte = str1;
        if (localMsgBody.bytes_cover_url.has()) {
          paramArrayOfByte = localMsgBody.bytes_cover_url.get().toStringUtf8();
        }
        paramArrayOfByte = new StoryPushMsg(i, str2, str3, 0L, "", null, paramArrayOfByte);
        long l = localMsgBody.uint64_hot_topic_id.get();
        if (l > 0L) {
          paramArrayOfByte.I.putLong("hot_topic_id", l);
        }
        str1 = localMsgBody.bytes_hot_topic_name.get().toStringUtf8();
        if (!TextUtils.isEmpty(str1)) {
          paramArrayOfByte.I.putString("hot_topic_name", str1);
        }
        l = localMsgBody.uint64_big_v_id.get();
        if (l > 0L) {
          paramArrayOfByte.I.putLong("big_v_id", l);
        }
        str1 = localMsgBody.bytes_big_v_union_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(str1)) {
          paramArrayOfByte.I.putString("big_v_union_id", str1);
        }
        i = localMsgBody.uint32_pgc_type.get();
        if (i > 0) {
          paramArrayOfByte.I.putInt("pgc_type", i);
        }
        str1 = localMsgBody.bytes_pgc_column_union_id.get().toStringUtf8();
        if (!TextUtils.isEmpty(str1)) {
          paramArrayOfByte.I.putString("pgc_column_union_id", str1);
        }
        if (!TextUtils.isEmpty(localMsgBody.bytes_link.get().toStringUtf8())) {
          paramArrayOfByte.I.putString("link", localMsgBody.bytes_link.get().toStringUtf8());
        }
        a(paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xd0. merge exception:" + paramArrayOfByte.getMessage());
  }
  
  public void R(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xda. data == null");
      }
      return;
    }
    for (;;)
    {
      SubMsgType0xda.MsgBody localMsgBody;
      int i;
      String str4;
      String str5;
      String str6;
      String str2;
      int j;
      Object localObject4;
      String str3;
      Object localObject5;
      try
      {
        localMsgBody = new SubMsgType0xda.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        i = localMsgBody.uint32_msg_type.get();
        str4 = localMsgBody.bytes_sub_type.get().toStringUtf8();
        str5 = localMsgBody.bytes_msg_info.get().toStringUtf8();
        str6 = localMsgBody.bytes_version_ctrl.get().toStringUtf8();
        if (localMsgBody.bytes_feed_id.has())
        {
          paramArrayOfByte = localMsgBody.bytes_feed_id.get().toStringUtf8();
          if (!localMsgBody.bytes_union_id.has()) {
            break label440;
          }
          str2 = localMsgBody.bytes_union_id.get().toStringUtf8();
          if (!localMsgBody.bytes_cover_url.has()) {
            break label566;
          }
          localObject1 = localMsgBody.bytes_cover_url.get().toStringUtf8();
          j = localMsgBody.uint32_comment_id.get();
          localObject4 = null;
          str3 = null;
          if (!localMsgBody.bytes_ext_info.has()) {
            break label549;
          }
          localObject5 = localMsgBody.bytes_ext_info.get().toStringUtf8();
          str1 = str3;
          localObject3 = localObject4;
          localObject2 = paramArrayOfByte;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      try
      {
        localObject5 = new JSONObject((String)localObject5);
        str1 = str3;
        localObject3 = localObject4;
        localObject2 = paramArrayOfByte;
        localObject4 = ((JSONObject)localObject5).optString("from_nick", null);
        str1 = str3;
        localObject3 = localObject4;
        localObject2 = paramArrayOfByte;
        str3 = ((JSONObject)localObject5).optString("vid", null);
        str1 = str3;
        localObject3 = localObject4;
        localObject2 = paramArrayOfByte;
        paramArrayOfByte = ((JSONObject)localObject5).optString("feed_id", paramArrayOfByte);
        str1 = str3;
        localObject3 = localObject4;
        localObject2 = paramArrayOfByte;
        localObject5 = ((JSONObject)localObject5).optString("cover_url", (String)localObject1);
        localObject3 = localObject5;
        localObject2 = str3;
        localObject1 = localObject4;
      }
      catch (Exception paramArrayOfByte)
      {
        label440:
        ram.w("Q.qqstory.protocol", "decode json fail", paramArrayOfByte);
        localObject4 = localObject3;
        paramArrayOfByte = (byte[])localObject2;
        localObject3 = localObject1;
        localObject1 = localObject4;
        localObject2 = str1;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqstory.protocol", 2, "handleStoryPush0xda 版本过低，notification被过滤了，version = " + str6 + ", type = " + i + ", subType = " + str4 + ", msgInfo = " + str5);
        continue;
      }
      if ((!TextUtils.isEmpty(str6)) && (AppSetting.bs(str6) >= 0))
      {
        a(new StoryPushMsg(i, str4, str5, 0L, "", paramArrayOfByte, str2, j, localObject3, (String)localObject1, (String)localObject2));
        if (!localMsgBody.bytes_icon_union_id.has()) {
          break;
        }
        paramArrayOfByte = localMsgBody.bytes_icon_union_id.get().toStringUtf8();
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          break;
        }
        pxq.V(paramArrayOfByte);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xda. merge exception:" + paramArrayOfByte.getMessage());
        return;
        paramArrayOfByte = null;
        continue;
        str2 = "";
        continue;
      }
      label549:
      Object localObject2 = null;
      String str1 = null;
      Object localObject3 = localObject1;
      Object localObject1 = str1;
      continue;
      label566:
      localObject1 = null;
    }
  }
  
  public byte a(FromServiceMsg paramFromServiceMsg, int paramInt, String paramString)
  {
    byte b1 = 0;
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      localObject = new oidb_sso.OIDBSSOPkg();
    }
    label393:
    label396:
    label402:
    for (;;)
    {
      int i;
      int m;
      int j;
      int k;
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          break label396;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("QQStoryHandler", 2, paramString + " handleGetTlvRsp ret=" + i);
        }
        if ((i != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          break label396;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        m = paramFromServiceMsg.length;
        j = 0;
        if (4 <= m)
        {
          localObject = String.valueOf(aqoj.getLongData(paramFromServiceMsg, 0));
          if ((localObject == null) || (!((String)localObject).equals(this.app.getAccount())))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQStoryHandler", 2, "handleGetTlvRsp uin error");
            }
            b1 = -1;
            return b1;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = (FromServiceMsg)localObject;
        continue;
        if (5 <= m) {
          i = paramFromServiceMsg[4];
        }
        if (7 <= m) {
          j = aqoj.b(paramFromServiceMsg, 5);
        }
        i = 7;
        k = 0;
      }
      if (k < j)
      {
        if (i + 4 > m) {
          break label393;
        }
        int n = aqoj.b(paramFromServiceMsg, i);
        int i1 = i + 2;
        i = aqoj.b(paramFromServiceMsg, i1);
        i1 += 2;
        byte b2 = b1;
        if ((n & 0xFFFF) == paramInt) {
          if (i != 0) {
            break label373;
          }
        }
        label373:
        for (b1 = 0;; b1 = (byte)aqoj.b(paramFromServiceMsg, i1))
        {
          b2 = b1;
          if (QLog.isColorLevel())
          {
            QLog.w("QQStoryHandler", 2, paramString + " handleGetTlvRsp value=" + b1);
            b2 = b1;
          }
          b1 = b2;
          i = i1 + i;
          k += 1;
          break;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label402;
        }
        return -1;
        break;
        b1 = 0;
      }
    }
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (paramStoryPushMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "onRecvStoryPush pushMsg nullException---------------");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "onRecvStoryPush pushMsg: " + paramStoryPushMsg);
      }
      if ((paramStoryPushMsg.type != 1) && (paramStoryPushMsg.type != 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.qqstory.protocol", 2, "6.6.0 comment and like, ignore, only accept 7.1.0 comment and like");
    return;
    notifyUI(1012, true, paramStoryPushMsg);
    qea.a().a(this.app, 2, paramStoryPushMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramFromServiceMsg, paramObject, "reqUserSetMsgTabOpen");
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramObject = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("QQStoryHandler", 2, paramString + " handleSetTlvRsp result" + i);
        }
        if (i != 0) {
          break label200;
        }
        if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
          if (4 <= paramFromServiceMsg.length)
          {
            paramFromServiceMsg = String.valueOf(aqoj.getLongData(paramFromServiceMsg, 0));
            if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.app.getAccount()))) {
              QLog.i("QQStoryHandler", 1, paramString + "uin error");
            }
          }
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      int i;
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = paramObject;
      }
      label200:
      QLog.w("QQStoryHandler", 1, paramString + " handleSetTlvRsp result" + i);
      rar.b("handleSetTlvRsp", paramString, 0, i, new String[] { "" });
    }
  }
  
  public void a(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    qqstory_service.ReqForbidStory localReqForbidStory = new qqstory_service.ReqForbidStory();
    Object localObject = localReqForbidStory.forbid_my_story;
    if (paramBoolean1)
    {
      i = 1;
      ((PBUInt32Field)localObject).set(i);
      localObject = localReqForbidStory.forbidden;
      if (!paramBoolean2) {
        break label127;
      }
    }
    label127:
    for (int i = j;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          ((List)localObject).add(Long.valueOf(Long.parseLong(str)));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i = 0;
      break;
    }
    localReqForbidStory.uid_list.set((List)localObject);
    localObject = createToServiceMsg(atz);
    ((ToServiceMsg)localObject).putWupBuffer(localReqForbidStory.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("isNotAllowed", paramBoolean1);
    ((ToServiceMsg)localObject).extraData.putBoolean("isAdd", paramBoolean2);
    ((ToServiceMsg)localObject).extraData.putStringArrayList("uins", paramArrayList);
    l((ToServiceMsg)localObject);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool = true;
    ram.a("QQStoryHandler", "getForbidList, cookie:%s, count:%s, isNotAllowed:%s, tag:%s", paramArrayOfByte, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString);
    Object localObject1 = new qqstory_service.ReqGetForbiddenList();
    if (paramArrayOfByte != null) {
      ((qqstory_service.ReqGetForbiddenList)localObject1).start_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((qqstory_service.ReqGetForbiddenList)localObject1).count.set(paramInt);
    Object localObject2 = ((qqstory_service.ReqGetForbiddenList)localObject1).forbid_my_story;
    int i;
    if (paramBoolean)
    {
      i = 1;
      ((PBUInt32Field)localObject2).set(i);
      localObject2 = createToServiceMsg(aty);
      ((ToServiceMsg)localObject2).putWupBuffer(((qqstory_service.ReqGetForbiddenList)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putBoolean("isNotAllowed", paramBoolean);
      localObject1 = ((ToServiceMsg)localObject2).extraData;
      if (paramArrayOfByte != null) {
        break label166;
      }
    }
    label166:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Bundle)localObject1).putBoolean("isFirst", paramBoolean);
      ((ToServiceMsg)localObject2).extraData.putInt("count", paramInt);
      ((ToServiceMsg)localObject2).extraData.putString("tag", paramString);
      l((ToServiceMsg)localObject2);
      return;
      i = 0;
      break;
    }
  }
  
  public void aH(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramFromServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
          break label435;
        }
        i = paramToServiceMsg.uint32_result.get();
        if (i != 0) {
          break label400;
        }
        long l = paramFromServiceMsg.getInt();
        paramFromServiceMsg.get();
        j = paramFromServiceMsg.getShort();
        if (!QLog.isColorLevel()) {
          break label441;
        }
        QLog.d("Q.qqstory.fourTab", 2, "handleNowTabIsOpen, request success, tlvCount = " + j + " uin:" + Long.valueOf(l));
      }
      catch (Exception paramToServiceMsg)
      {
        int j;
        int m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.fourTab", 2, "handleNowTabIsOpen exception: " + paramToServiceMsg.getMessage());
        return;
      }
      if ((paramFromServiceMsg.hasRemaining()) && (i < j))
      {
        k = paramFromServiceMsg.getShort();
        m = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.fourTab", 2, "handleNowTabIsOpen, TLV type: " + k + ",legnth: " + m);
        }
        if (k != -23476) {
          break label363;
        }
        i = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.fourTab", 2, "handleNowTabIsOpen nowTabOpenStatus is :" + i);
        }
        if (i != 0) {}
      }
      else
      {
        return;
      }
      try
      {
        paramToServiceMsg = new Integer[5];
        paramToServiceMsg[0] = Integer.valueOf(1);
        paramToServiceMsg[3] = Integer.valueOf(i - 1);
        this.app.a().a(paramToServiceMsg, true);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("Q.qqstory.fourTab", 2, "er : " + paramToServiceMsg.getMessage(), paramToServiceMsg);
        return;
      }
      label363:
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqstory.fourTab", 2, "handleNowTabIsOpen TLV error T: " + k);
        break label447;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.fourTab", 2, "handleNowTabIsOpen pkg_result: " + i);
        return;
        i = -1;
        continue;
        i = 0;
        continue;
      }
      label400:
      label435:
      label441:
      label447:
      i += 1;
    }
  }
  
  public void aI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = k;
    int i = j;
    if (paramObject != null)
    {
      paramToServiceMsg = new qqstory_service.RspGetConfig();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        m = k;
        i = j;
        if (paramToServiceMsg != null)
        {
          m = k;
          i = j;
          if (paramToServiceMsg.result.error_code.get() == 0) {
            if (paramToServiceMsg.user_config.has())
            {
              paramFromServiceMsg = (psr)psx.a(10);
              paramFromServiceMsg.fg(System.currentTimeMillis());
              localObject1 = paramToServiceMsg.user_config.get();
              paramObject = (pmb)this.app.getManager(181);
              localObject1 = ((List)localObject1).iterator();
              i = 0;
              j = 0;
              for (;;)
              {
                m = j;
                k = i;
                if (!((Iterator)localObject1).hasNext()) {
                  break label1064;
                }
                localObject2 = (qqstory_struct.UserConfig)((Iterator)localObject1).next();
                localObject3 = ((qqstory_struct.UserConfig)localObject2).config_key.get().toStringUtf8();
                if (!"netType".equals(localObject3)) {
                  break;
                }
                i = ((qqstory_struct.UserConfig)localObject2).config_value.get();
                notifyUI(1003, true, Integer.valueOf(i));
                paramObject.vK(i);
                i = j;
                j = 1;
                k = j;
                j = i;
                i = k;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        for (;;)
        {
          paramToServiceMsg = null;
          continue;
          boolean bool;
          if ("story_publish_flag_compress".equals(localObject3))
          {
            if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {}
            for (bool = true;; bool = false)
            {
              paramFromServiceMsg.n("story_publish_flag_compress", Boolean.valueOf(bool));
              k = i;
              i = j;
              j = k;
              break;
            }
          }
          if ("story_publish_flag_compress_configurable".equals(localObject3))
          {
            if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {}
            for (bool = true;; bool = false)
            {
              paramFromServiceMsg.n("story_publish_flag_compress_configurable", Boolean.valueOf(bool));
              k = i;
              i = j;
              j = k;
              break;
            }
          }
          if ("auto_play_type".equals(localObject3))
          {
            j = ((qqstory_struct.UserConfig)localObject2).config_value.get();
            notifyUI(1018, true, Integer.valueOf(j));
            paramObject.vL(j);
            k = 1;
            j = i;
            i = k;
          }
          else
          {
            if ("self_notify".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {}
              for (bool = true;; bool = false)
              {
                paramObject.rH(bool);
                k = i;
                i = j;
                j = k;
                break;
              }
            }
            if ("special_notify".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {}
              for (bool = true;; bool = false)
              {
                paramObject.rI(bool);
                k = i;
                i = j;
                j = k;
                break;
              }
            }
            if ("pub_allow_stranger".equals(localObject3))
            {
              switch (((qqstory_struct.UserConfig)localObject2).config_value.get())
              {
              default: 
                k = 10000;
              }
              for (;;)
              {
                paramFromServiceMsg.n("key_last_used_permission", Integer.valueOf(k));
                ram.b("QQStoryHandler", "get default permission from server. type is %d.", Integer.valueOf(k));
                k = i;
                i = j;
                j = k;
                break;
                k = 10000;
                continue;
                k = 10001;
                continue;
                k = 10002;
                continue;
                k = 10003;
                continue;
                k = 10004;
              }
            }
            if ("mainpage_auto_reqdata_interval".equals(localObject3))
            {
              long l = ((qqstory_struct.UserConfig)localObject2).config_value.get() * 1000;
              ram.b("Q.qqstory.home.position", "set disable autorefresh time:%d", Long.valueOf(l));
              paramFromServiceMsg.n("key_disable_auto_refresh_time", Long.valueOf(l));
              k = i;
              i = j;
              j = k;
            }
            else
            {
              if ("show_allow_stranger_state".equals(localObject3))
              {
                if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {}
                for (bool = true;; bool = false)
                {
                  paramObject.rK(bool);
                  k = i;
                  i = j;
                  j = k;
                  break;
                }
              }
              if ("allow_stranger_state".equals(localObject3))
              {
                if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {}
                for (bool = true;; bool = false)
                {
                  paramObject.rJ(bool);
                  k = i;
                  i = j;
                  j = k;
                  break;
                }
              }
              if ("allow_stranger_day_num".equals(localObject3))
              {
                paramObject.vM(((qqstory_struct.UserConfig)localObject2).config_value.get());
                k = i;
                i = j;
                j = k;
              }
              else
              {
                if ("show_auto_post2discovery".equals(localObject3))
                {
                  if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {}
                  for (bool = true;; bool = false)
                  {
                    paramObject.rL(bool);
                    k = i;
                    i = j;
                    j = k;
                    break;
                  }
                }
                if ("auto_post2discovery".equals(localObject3))
                {
                  if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {}
                  for (bool = true;; bool = false)
                  {
                    paramObject.rM(bool);
                    k = i;
                    i = j;
                    j = k;
                    break;
                  }
                }
                if ("proto_retry_list".equals(localObject3))
                {
                  localObject2 = ((qqstory_struct.UserConfig)localObject2).config_value_bytes.get().toStringUtf8();
                  paramFromServiceMsg.rf((String)localObject2);
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    QQStoryContext.a().a().re((String)localObject2);
                  }
                }
                k = i;
                i = j;
                j = k;
              }
            }
          }
        }
        k = 0;
        m = 0;
        label1064:
        if (paramToServiceMsg.pic_specs_list.has())
        {
          ((psr)psx.a(10)).fh(System.currentTimeMillis());
          paramObject = paramToServiceMsg.pic_specs_list.get();
          paramFromServiceMsg = new JSONObject();
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            localObject2 = (qqstory_struct.PicSpecs)paramObject.next();
            ram.d("Q.qqstory.protocol", "find specs in response " + ((qqstory_struct.PicSpecs)localObject2).pic_bid.get().toStringUtf8() + ", specs " + ((qqstory_struct.PicSpecs)localObject2).pic_spec.get());
            localObject1 = ((qqstory_struct.PicSpecs)localObject2).pic_bid.get().toStringUtf8();
            localObject2 = ((qqstory_struct.PicSpecs)localObject2).pic_spec.get();
            localObject3 = new JSONArray((Collection)localObject2);
            try
            {
              paramFromServiceMsg.put((String)localObject1, localObject3);
            }
            catch (JSONException localJSONException2)
            {
              ram.w("QQStoryHandler", "Invalid json format in " + (String)localObject1 + ", " + localObject2);
            }
          }
          psr.rm(paramFromServiceMsg.toString());
          ram.d("Q.qqstory.protocol", "get thumbnail config formatted in json " + paramFromServiceMsg.toString());
        }
        while (paramToServiceMsg.video_source_tag_list.has())
        {
          paramFromServiceMsg = paramToServiceMsg.video_source_tag_list.get();
          paramToServiceMsg = new JSONObject();
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          for (;;)
          {
            if (paramFromServiceMsg.hasNext())
            {
              localObject1 = (qqstory_struct.VideoSourceTagInfo)paramFromServiceMsg.next();
              i = ((qqstory_struct.VideoSourceTagInfo)localObject1).source_tag_type.get();
              paramObject = ((qqstory_struct.VideoSourceTagInfo)localObject1).jump_url.get().toStringUtf8();
              localObject1 = ((qqstory_struct.VideoSourceTagInfo)localObject1).wording.get().toStringUtf8();
              localObject2 = new JSONObject();
              try
              {
                ((JSONObject)localObject2).put("jump_url", paramObject);
                ((JSONObject)localObject2).put("wording", localObject1);
                paramToServiceMsg.put(String.valueOf(i), localObject2);
              }
              catch (JSONException localJSONException1)
              {
                ram.w("QQStoryHandler", "Invalid json format, tagType: " + i + ", jumpUrl: " + paramObject + ", wording: " + (String)localObject1);
              }
              continue;
              ram.d("Q.qqstory.protocol", "no thumbnail pic_specs_list found, check for day limitation");
              break;
            }
          }
          paramFromServiceMsg = (psr)psx.a(10);
          paramFromServiceMsg.fi(System.currentTimeMillis());
          paramFromServiceMsg.rh(paramToServiceMsg.toString());
          rpu.clearConfig();
          ram.b("QQStoryHandler", "video_source_tag_list format json : %s", paramToServiceMsg.toString());
        }
        i = k;
      }
    }
    if (i == 0) {
      notifyUI(1003, false, Integer.valueOf(-1));
    }
    if (m == 0) {
      notifyUI(1018, false, Integer.valueOf(-1));
    }
    notifyUI(1016, true, Integer.valueOf(0));
  }
  
  public void aL(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isAdd");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isNotAllowed");
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("uins");
    Object localObject;
    if (paramObject != null)
    {
      paramFromServiceMsg = (pmb)this.app.getManager(181);
      localObject = new qqstory_service.RspForbidStory();
    }
    label415:
    for (;;)
    {
      try
      {
        ((qqstory_service.RspForbidStory)localObject).mergeFrom((byte[])paramObject);
        if (((qqstory_service.RspForbidStory)localObject).result.error_code.get() == 0)
        {
          paramObject = paramToServiceMsg.iterator();
          if (!paramObject.hasNext()) {
            break label381;
          }
          localObject = (String)paramObject.next();
          if (!bool1) {
            break label308;
          }
          paramToServiceMsg = paramFromServiceMsg.a((String)localObject);
          if (paramToServiceMsg != null) {
            break label415;
          }
          paramToServiceMsg = new QQStoryUserInfo();
          paramToServiceMsg.uin = ((String)localObject);
          paramToServiceMsg.setNick(aqgv.D(this.app, (String)localObject));
          paramFromServiceMsg.bR.put(localObject, paramToServiceMsg);
          if (bool2)
          {
            paramToServiceMsg.isAllowed = 1;
            if (!paramFromServiceMsg.mj.contains(paramToServiceMsg)) {
              paramFromServiceMsg.mj.add(paramToServiceMsg);
            }
            label201:
            if (paramToServiceMsg.getStatus() != 1000) {
              break label296;
            }
            paramFromServiceMsg.em.persist(paramToServiceMsg);
            continue;
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      for (;;)
      {
        if (i == 0) {
          notifyUI(1002, false, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        }
        return;
        paramToServiceMsg.isInterested = 1;
        if (paramFromServiceMsg.mi.contains(paramToServiceMsg)) {
          break label201;
        }
        paramFromServiceMsg.mi.add(paramToServiceMsg);
        break label201;
        label296:
        paramFromServiceMsg.em.update(paramToServiceMsg);
        break;
        label308:
        paramToServiceMsg = paramFromServiceMsg.a((String)localObject);
        if (paramToServiceMsg == null) {
          break;
        }
        if (bool2)
        {
          paramToServiceMsg.isAllowed = 0;
          paramFromServiceMsg.mj.remove(paramToServiceMsg);
        }
        for (;;)
        {
          paramFromServiceMsg.em.update(paramToServiceMsg);
          paramFromServiceMsg.bR.remove(localObject);
          break;
          paramToServiceMsg.isInterested = 0;
          paramFromServiceMsg.mi.remove(paramToServiceMsg);
        }
        label381:
        notifyUI(1002, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        int i = 1;
      }
    }
  }
  
  /* Error */
  public void aR(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +207 -> 212
    //   8: iconst_1
    //   9: istore 7
    //   11: aload_1
    //   12: ifnonnull +206 -> 218
    //   15: ldc2_w 366
    //   18: lstore 9
    //   20: aload_2
    //   21: ifnonnull +216 -> 237
    //   24: iconst_m1
    //   25: istore 5
    //   27: aload_2
    //   28: ifnonnull +218 -> 246
    //   31: ldc_w 369
    //   34: astore_1
    //   35: iconst_0
    //   36: istore 6
    //   38: iconst_0
    //   39: istore 8
    //   41: aload_1
    //   42: astore_2
    //   43: iload 5
    //   45: istore 4
    //   47: aload_3
    //   48: invokestatic 372	pma:q	(Ljava/lang/Object;)Z
    //   51: ifeq +267 -> 318
    //   54: new 1159	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspReport
    //   57: dup
    //   58: invokespecial 1160	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspReport:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: aload_3
    //   64: checkcast 98	[B
    //   67: checkcast 98	[B
    //   70: invokevirtual 1161	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspReport:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   73: pop
    //   74: aload_2
    //   75: getfield 1162	com/tencent/biz/qqstory/network/pb/qqstory_pgc$RspReport:result	Lcom/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo;
    //   78: invokevirtual 382	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   81: checkcast 381	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo
    //   84: astore_3
    //   85: aload_3
    //   86: getfield 383	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo:error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   92: istore 4
    //   94: aload_3
    //   95: getfield 386	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo:error_desc	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   98: invokevirtual 178	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   101: invokevirtual 364	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   104: astore_2
    //   105: aload_2
    //   106: astore_1
    //   107: iload 4
    //   109: ifne +145 -> 254
    //   112: aload_0
    //   113: sipush 1015
    //   116: iconst_1
    //   117: iconst_2
    //   118: anewarray 275	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: iload 4
    //   125: invokestatic 500	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload_1
    //   132: aastore
    //   133: invokevirtual 122	pma:notifyUI	(IZLjava/lang/Object;)V
    //   136: iconst_1
    //   137: istore 6
    //   139: iload 6
    //   141: istore 5
    //   143: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +34 -> 180
    //   149: ldc_w 432
    //   152: iconst_2
    //   153: new 222	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 1164
    //   163: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iconst_1
    //   167: invokevirtual 437	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: iload 6
    //   178: istore 5
    //   180: iload 5
    //   182: ifne +12 -> 194
    //   185: aload_0
    //   186: sipush 1015
    //   189: iconst_0
    //   190: aconst_null
    //   191: invokevirtual 122	pma:notifyUI	(IZLjava/lang/Object;)V
    //   194: iload 7
    //   196: ifne +15 -> 211
    //   199: aload_0
    //   200: getstatic 71	pma:atG	Ljava/lang/String;
    //   203: lload 9
    //   205: iload 4
    //   207: aload_1
    //   208: invokevirtual 445	pma:b	(Ljava/lang/String;JILjava/lang/String;)V
    //   211: return
    //   212: iconst_0
    //   213: istore 7
    //   215: goto -204 -> 11
    //   218: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   221: aload_1
    //   222: getfield 142	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   225: ldc_w 452
    //   228: invokevirtual 456	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   231: lsub
    //   232: lstore 9
    //   234: goto -214 -> 20
    //   237: aload_2
    //   238: invokevirtual 461	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   241: istore 5
    //   243: goto -216 -> 27
    //   246: aload_2
    //   247: invokevirtual 464	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   250: astore_1
    //   251: goto -216 -> 35
    //   254: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +36 -> 293
    //   260: ldc_w 432
    //   263: iconst_2
    //   264: new 222	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 1166
    //   274: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_3
    //   278: getfield 383	com/tencent/biz/qqstory/network/pb/qqstory_pgc$ErrorInfo:error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   281: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   284: invokevirtual 469	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iconst_0
    //   294: istore 5
    //   296: goto -116 -> 180
    //   299: astore_2
    //   300: iload 5
    //   302: istore 4
    //   304: iload 8
    //   306: istore 5
    //   308: aload_2
    //   309: invokevirtual 125	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   312: iload 5
    //   314: istore 6
    //   316: aload_1
    //   317: astore_2
    //   318: iload 6
    //   320: istore 5
    //   322: aload_2
    //   323: astore_1
    //   324: goto -144 -> 180
    //   327: astore_2
    //   328: iload 8
    //   330: istore 5
    //   332: goto -24 -> 308
    //   335: astore_2
    //   336: iload 8
    //   338: istore 5
    //   340: goto -32 -> 308
    //   343: astore_2
    //   344: iconst_1
    //   345: istore 5
    //   347: goto -39 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	pma
    //   0	350	1	paramToServiceMsg	ToServiceMsg
    //   0	350	2	paramFromServiceMsg	FromServiceMsg
    //   0	350	3	paramObject	Object
    //   45	258	4	i	int
    //   25	321	5	j	int
    //   36	283	6	k	int
    //   9	205	7	m	int
    //   39	298	8	n	int
    //   18	215	9	l	long
    // Exception table:
    //   from	to	target	type
    //   54	94	299	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   94	105	327	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   112	136	335	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   254	293	335	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   143	176	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void aS(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l;
    label13:
    label21:
    boolean bool;
    if (paramToServiceMsg == null)
    {
      l = -1L;
      if (paramFromServiceMsg != null) {
        break label187;
      }
      if (paramFromServiceMsg != null) {
        break label195;
      }
      paramFromServiceMsg = "local data";
      bool = false;
      if (!q(paramObject)) {
        break label222;
      }
    }
    label187:
    label195:
    label222:
    while (!QLog.isColorLevel())
    {
      try
      {
        paramFromServiceMsg = new qqstory_service.RspSyncVideoPublish();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (qqstory_struct.ErrorInfo)paramFromServiceMsg.result.get();
        int i = paramFromServiceMsg.error_code.get();
        paramFromServiceMsg = paramFromServiceMsg.error_desc.get().toStringUtf8();
        if (i == 0) {
          bool = true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleSyncShortvideoToStory isSuccess = " + bool + ", errorDesc = " + paramFromServiceMsg + ", useTime = " + l);
        }
        paramToServiceMsg = (String)paramToServiceMsg.getAttribute("fakeVid");
        if (paramToServiceMsg != null) {
          ppg.e.q(paramToServiceMsg, bool);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.qqstory.protocol", 2, QLog.getStackTraceString(paramToServiceMsg));
        return;
      }
      l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
      break;
      paramFromServiceMsg.getBusinessFailCode();
      break label13;
      paramFromServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      break label21;
    }
    QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleSyncShortvideoToStory isSuccess = " + false + ", errorDesc = " + paramFromServiceMsg + ", useTime = " + l);
  }
  
  public void aT(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l;
    int i;
    if (paramToServiceMsg == null)
    {
      l = -1L;
      if (paramFromServiceMsg != null) {
        break label243;
      }
      i = -1;
      label16:
      if (paramFromServiceMsg != null) {
        break label252;
      }
    }
    int j;
    label243:
    label252:
    for (paramToServiceMsg = "local data";; paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg())
    {
      if (!q(paramObject)) {
        break label388;
      }
      paramFromServiceMsg = paramToServiceMsg;
      j = i;
      try
      {
        qqstory_service.RspVideoReaderConf localRspVideoReaderConf = new qqstory_service.RspVideoReaderConf();
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        localRspVideoReaderConf.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        paramObject = (qqstory_struct.ErrorInfo)localRspVideoReaderConf.result.get();
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        i = paramObject.error_code.get();
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        paramToServiceMsg = paramObject.error_desc.get().toStringUtf8();
        if (i != 0) {
          break label260;
        }
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        notifyUI(1017, true, new ply(this.app, (qqstory_struct.VideoReaderConf)localRspVideoReaderConf.reader_conf.get()));
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = paramToServiceMsg;
          j = i;
          QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleVideoReaderConfig errorCode = " + i + ", errorDesc = " + paramToServiceMsg + ", useTime = " + l);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          i = j;
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleVideoReaderConfig: " + QLog.getStackTraceString(paramObject) + ", useTime = " + l);
            i = j;
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
      }
      l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
      break;
      i = paramFromServiceMsg.getBusinessFailCode();
      break label16;
    }
    label388:
    for (;;)
    {
      label260:
      notifyUI(1017, false, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handleVideoReaderConfig errorCode = " + i + ", errorDesc = " + paramToServiceMsg + ", useTime = " + l);
      return;
    }
  }
  
  public void aU(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object[] arrayOfObject;
    int i;
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = null;
      arrayOfObject = new Object[3];
      arrayOfObject[1] = paramToServiceMsg;
      if (paramFromServiceMsg != null) {
        break label259;
      }
      i = -1;
      label24:
      if (paramFromServiceMsg != null) {
        break label268;
      }
      paramToServiceMsg = "local data";
      label32:
      localObject = paramToServiceMsg;
      j = i;
      if (q(paramObject))
      {
        paramFromServiceMsg = paramToServiceMsg;
        k = i;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new qqstory_service.RspMsgTabNodeWatched();
        paramFromServiceMsg = paramToServiceMsg;
        k = i;
        ((qqstory_service.RspMsgTabNodeWatched)localObject).mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramToServiceMsg;
        k = i;
        paramObject = (qqstory_struct.ErrorInfo)((qqstory_service.RspMsgTabNodeWatched)localObject).result.get();
        paramFromServiceMsg = paramToServiceMsg;
        k = i;
        i = paramObject.error_code.get();
        paramFromServiceMsg = paramToServiceMsg;
        k = i;
        paramToServiceMsg = paramObject.error_desc.get().toStringUtf8();
        if (i != 0) {
          continue;
        }
        localObject = paramToServiceMsg;
        j = i;
        paramFromServiceMsg = paramToServiceMsg;
        k = i;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = paramToServiceMsg;
          k = i;
          QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handlerMsgTabStoryNodeFeedback isSuccess=" + false);
          j = i;
          localObject = paramToServiceMsg;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        label259:
        label268:
        paramToServiceMsg.printStackTrace();
        localObject = paramFromServiceMsg;
        j = k;
        continue;
      }
      arrayOfObject[2] = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handlerMsgTabStoryNodeFeedback error_code=" + j + " errorDesc=" + (String)localObject);
      }
      return;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("unionId");
      break;
      i = paramFromServiceMsg.getBusinessFailCode();
      break label24;
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      break label32;
      localObject = paramToServiceMsg;
      j = i;
      paramFromServiceMsg = paramToServiceMsg;
      k = i;
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = paramToServiceMsg;
        k = i;
        QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler handlerMsgTabStoryNodeFeedback error_code=" + paramObject.error_code.get());
        localObject = paramToServiceMsg;
        j = i;
      }
    }
  }
  
  public void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    qqstory_pgc.ReqSubscription localReqSubscription = new qqstory_pgc.ReqSubscription();
    localReqSubscription.type.set(paramInt1, true);
    if (!TextUtils.isEmpty(paramString)) {
      localReqSubscription.union_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    }
    localReqSubscription.operation.set(paramInt2, true);
    localReqSubscription.from.set(paramInt3, true);
    ToServiceMsg localToServiceMsg = createToServiceMsg(atD);
    localToServiceMsg.extraData.putInt("userType", paramInt1);
    localToServiceMsg.extraData.putString("unionId", paramString);
    localToServiceMsg.putWupBuffer(localReqSubscription.toByteArray());
    l(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler editPGCSubscribeStatus type=" + paramInt1 + " unionId=" + paramString + " operation=" + paramInt2);
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramFromServiceMsg, paramObject, "reqUserGetEnableAlbumScan");
  }
  
  public void b(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "reportNetRspResult. cmd=" + paramString1 + " errorCode=" + paramInt + " errorMsg=" + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    rar.b("story_net", paramString1, 0, paramInt, new String[] { paramString2, String.valueOf(paramLong), rar.getNetworkType(null) });
  }
  
  public void blO()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.protocol", 2, "getQQStoryConfig");
    }
    qqstory_service.ReqGetConfig localReqGetConfig = new qqstory_service.ReqGetConfig();
    Object localObject = (psr)psx.a(10);
    long l2 = ((psr)localObject).dK();
    long l1 = ((psr)localObject).dL();
    long l3 = TimeUnit.DAYS.toMillis(1L);
    ram.d("Q.qqstory.protocol", "lastGetConfigTime " + l2 + ", " + System.currentTimeMillis());
    if (Math.abs(System.currentTimeMillis() - l2) > l3) {
      localReqGetConfig.get_pic_specs.set(1);
    }
    l2 = TimeUnit.DAYS.toMillis(1L);
    if (Math.abs(System.currentTimeMillis() - l1) > l2) {
      localReqGetConfig.get_video_tag_info.set(1);
    }
    localObject = createToServiceMsg(atw);
    ((ToServiceMsg)localObject).putWupBuffer(localReqGetConfig.toByteArray());
    l((ToServiceMsg)localObject);
  }
  
  public void c(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    qqstory_service.ReqMsgTabNodeWatched localReqMsgTabNodeWatched = new qqstory_service.ReqMsgTabNodeWatched();
    localReqMsgTabNodeWatched.node_type.set(paramInt1);
    localReqMsgTabNodeWatched.operation.set(paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      localReqMsgTabNodeWatched.unionID.set(ByteStringMicro.copyFromUtf8(paramString), true);
    }
    localReqMsgTabNodeWatched.recommend_id.set(paramLong);
    ToServiceMsg localToServiceMsg = createToServiceMsg(atJ);
    localToServiceMsg.extraData.putString("unionId", paramString);
    localToServiceMsg.putWupBuffer(localReqMsgTabNodeWatched.toByteArray());
    l(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "QQStoryHandler reqMsgTabStoryNodeFeedback unionId = " + paramString + ", nodeType = " + paramInt1 + ", operation = " + paramInt2 + ", recommendId = " + paramLong);
    }
  }
  
  public void f(FromServiceMsg paramFromServiceMsg)
  {
    byte b = a(paramFromServiceMsg, 42083, "reqUserGetMsgTabOpen");
    notifyUI(1024, true, Byte.valueOf(b));
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryHandler", 2, "handleMsgTabStoryIsOpen, msgTabStoryIsOpenTlvValue:" + b);
    }
  }
  
  public void g(FromServiceMsg paramFromServiceMsg)
  {
    int i = a(paramFromServiceMsg, 42215, "reqUserGetEnableAlbumScan");
    ((psr)psx.a(10)).n("sp_key_user_enable_album_scan", Integer.valueOf(i));
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryHandler", 2, "handleMsgTabStoryIsOpen, userEnableAlbumScanTlvValue:" + i);
    }
  }
  
  public void l(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.protocol", 2, "sendPbRequest. request is null.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "sendPbRequest. cmd=" + paramToServiceMsg.getServiceCmd());
    }
    paramToServiceMsg.extraData.putLong("extra_start_time", System.currentTimeMillis());
    super.sendPbReq(paramToServiceMsg);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return pmd.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "QQStoryHandle onReceive. cmd=" + str);
    }
    if (atw.equals(str)) {
      aI(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    label361:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (atx.equals(str))
            {
              aJ(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (aty.equals(str))
            {
              aK(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (atz.equals(str))
            {
              aL(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (atA.equals(str))
            {
              aM(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (atB.equals(str))
            {
              aN(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (atE.equals(str))
            {
              aO(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (atF.equals(str))
            {
              aP(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (atD.equals(str))
            {
              aQ(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (!"OidbSvc.0x480_9".equals(str)) {
              break;
            }
            if (paramToServiceMsg.extraData.getBoolean("reqFromQQStoryHandler"))
            {
              aH(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (paramToServiceMsg.extraData.getBoolean("reqUserGetMsgTabOpen"))
            {
              f(paramFromServiceMsg);
              return;
            }
          } while (!paramToServiceMsg.extraData.getBoolean("reqUserGetEnableAlbumScan"));
          g(paramFromServiceMsg);
          return;
          if (!"OidbSvc.0x4ff_9".equals(str)) {
            break label361;
          }
          if (!paramToServiceMsg.extraData.getBoolean("reqFromQQStoryHandler")) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQStoryHandler", 2, "CMD_SET_DETAIL_INFO : ");
        return;
        if (paramToServiceMsg.extraData.getBoolean("reqUserSetMsgTabOpen"))
        {
          a(paramFromServiceMsg, paramObject);
          return;
        }
      } while (!paramToServiceMsg.extraData.getBoolean("reqUserSetEnableAlbumScan"));
      b(paramFromServiceMsg, paramObject);
      return;
      if (atG.equals(str))
      {
        aR(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (atH.equals(str))
      {
        aS(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (atI.equals(str))
      {
        aT(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!atJ.equals(str));
    aU(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void p(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryHandler", 2, paramString + "value=" + paramInt1);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      short s = (short)paramInt1;
      Object localObject = new byte[13];
      aqoj.DWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      aqoj.Word2Byte((byte[])localObject, 5, (short)1);
      aqoj.q((byte[])localObject, 7, paramInt2);
      aqoj.Word2Byte((byte[])localObject, 9, (short)2);
      aqoj.Word2Byte((byte[])localObject, 11, s);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean(paramString, true);
      l((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QQStoryHandler", 2, paramString + " exception=", localException);
    }
  }
  
  public void qO(String paramString)
  {
    qqstory_service.ReqGetForbiddenStates localReqGetForbiddenStates = new qqstory_service.ReqGetForbiddenStates();
    Object localObject = new ArrayList();
    try
    {
      ((List)localObject).add(Long.valueOf(Long.parseLong(paramString)));
      localReqGetForbiddenStates.uid_list.set((List)localObject);
      localObject = createToServiceMsg(atA);
      ((ToServiceMsg)localObject).putWupBuffer(localReqGetForbiddenStates.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("reqUin", paramString);
      l((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void qP(String paramString)
  {
    qqstory_service.ReqVideoReaderConf localReqVideoReaderConf = new qqstory_service.ReqVideoReaderConf();
    localReqVideoReaderConf.vid.set(ByteStringMicro.copyFromUtf8(paramString), true);
    ToServiceMsg localToServiceMsg = createToServiceMsg(atI);
    localToServiceMsg.putWupBuffer(localReqVideoReaderConf.toByteArray());
    l(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryHandler", 2, "reqSyncShortvideoToStory() vid = " + paramString);
    }
  }
  
  public void vG(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryHandler", 2, "setNowTabIsOpen value=" + paramInt);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      short s = (short)paramInt;
      Object localObject = new byte[19];
      aqoj.DWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      aqoj.Word2Byte((byte[])localObject, 5, (short)2);
      aqoj.q((byte[])localObject, 7, 42060);
      aqoj.Word2Byte((byte[])localObject, 9, (short)2);
      aqoj.Word2Byte((byte[])localObject, 11, s);
      aqoj.q((byte[])localObject, 13, 40319);
      aqoj.Word2Byte((byte[])localObject, 15, (short)2);
      aqoj.Word2Byte((byte[])localObject, 17, (short)1);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromQQStoryHandler", true);
      l((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QQStoryHandler", 2, "setNowTabIsOpen ex", localException);
    }
  }
  
  public void vH(int paramInt)
  {
    p(paramInt, 42083, "reqUserSetMsgTabOpen");
  }
  
  public void vI(int paramInt)
  {
    p(paramInt, 42215, "reqUserSetEnableAlbumScan");
  }
  
  public void vJ(int paramInt)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    Object localObject = new qqstory_struct.UserConfig();
    ((qqstory_struct.UserConfig)localObject).config_key.set(ByteStringMicro.copyFromUtf8("auto_play_type"));
    ((qqstory_struct.UserConfig)localObject).config_value.set(paramInt);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localReqSetConfig.user_config.set(localArrayList);
    localObject = createToServiceMsg(atx);
    ((ToServiceMsg)localObject).putWupBuffer(localReqSetConfig.toByteArray());
    l((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pma
 * JD-Core Version:    0.7.0.1
 */