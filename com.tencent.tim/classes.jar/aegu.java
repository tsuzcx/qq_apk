import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil.1;
import com.tencent.mobileqq.confess.ConfessMsgUtil.2;
import com.tencent.mobileqq.confess.ConfessMsgUtil.3;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class aegu
{
  public static final String bxf = acfp.m(2131704303);
  
  public static void A(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aegp.e(paramQQAppInterface, "redpoint_box_show", 0L);
    aegp.e(paramQQAppInterface, "redpoint_clear_time", anaz.gQ());
  }
  
  public static void B(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (akjp)paramQQAppInterface.getManager(160);
      RedTouchItem localRedTouchItem = ((akjp)localObject).a(10018);
      if ((paramBoolean) && (localRedTouchItem != null)) {
        localRedTouchItem.extMsgs = null;
      }
      ((akjp)localObject).RT(10018);
      localObject = ((aegs)paramQQAppInterface.getManager(269)).a();
      if ((localObject != null) && (((aehb)localObject).cMU > 0)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessMsgUtil", 4, String.format(Locale.getDefault(), "clearConfessFrdRecUnread no need to deal ! [toDelItem: %s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    return;
    boolean bool1;
    label125:
    boolean bool2;
    if (localObject != null) {
      if (((aehb)localObject).cMU != 0)
      {
        bool1 = true;
        ((aehb)localObject).cMU = 0;
        bool2 = bool1;
        if (paramBoolean)
        {
          bool2 = bool1 | ((aehb)localObject).agG();
          ((aehb)localObject).bxr = "";
          ((aehb)localObject).bxt = "";
          ((aehb)localObject).bxs = "";
          ((aehb)localObject).nTopicId = 0;
        }
        ThreadManager.post(new ConfessMsgUtil.2((aehb)localObject), 8, null, false);
      }
    }
    for (;;)
    {
      if (bool2) {
        ((aegq)paramQQAppInterface.getBusinessHandler(125)).a((aehb)localObject);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessMsgUtil", 4, String.format(Locale.getDefault(), "clearConfessFrdRecUnread toDelItem: %s, needUpdate: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2) }));
      return;
      bool1 = false;
      break label125;
      bool2 = false;
    }
  }
  
  public static boolean H(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramChatMessage.istroop != 1033) || (!paramChatMessage.isSend()))
    {
      bool1 = bool2;
      if (paramChatMessage.istroop == 1034)
      {
        bool1 = bool2;
        if (paramChatMessage.isSend()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ConfessInfo paramConfessInfo, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if ((paramConfessInfo.isSysMsg == 1) && (!TextUtils.equals(paramConfessInfo.confessorUinStr, str))) {
      return acfp.m(2131704300);
    }
    if (!TextUtils.equals(paramConfessInfo.confessorUinStr, str)) {
      return paramConfessInfo.confessorNick;
    }
    return aqgv.b(paramQQAppInterface, paramString, true);
  }
  
  public static im_msg_body.Elem a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = null;
    String str = paramMessageRecord.getExtInfoFromExtStr("ext_key_frd_chat_confess_info");
    if (TextUtils.isEmpty(str)) {}
    im_msg_body.Elem localElem;
    do
    {
      do
      {
        return localObject1;
        localObject2 = aegs.a.a(str);
      } while (localObject2 == null);
      localElem = new im_msg_body.Elem();
      localObject1 = new hummer_commelem.MsgElemInfo_servtype21();
      hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext localC2CConfessContext = new hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext();
      localC2CConfessContext.uint64_confessor_uin.set(Long.parseLong(((aegs.a)localObject2).strConfessorUin));
      localC2CConfessContext.uint64_confess_to_uin.set(Long.parseLong(((aegs.a)localObject2).strRecUin));
      localC2CConfessContext.uint64_send_uin.set(Long.parseLong(paramMessageRecord.senderuin));
      localC2CConfessContext.bytes_confess.set(ByteStringMicro.copyFromUtf8(((aegs.a)localObject2).strConfessorDesc));
      localC2CConfessContext.bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((aegs.a)localObject2).strConfessorNick));
      localC2CConfessContext.uint64_confess_time.set(((aegs.a)localObject2).confessTime);
      localC2CConfessContext.uint32_bg_type.set(((aegs.a)localObject2).nBGType);
      localC2CConfessContext.uint32_topic_id.set(((aegs.a)localObject2).nTopicId);
      localC2CConfessContext.uint32_confessor_sex.set(((aegs.a)localObject2).nConfessorSex);
      localC2CConfessContext.uint32_confess_num.set(((aegs.a)localObject2).nConfessNum);
      localC2CConfessContext.uint32_biz_type.set(((aegs.a)localObject2).nBizType);
      localC2CConfessContext.uint32_confess_to_sex.set(((aegs.a)localObject2).nGetConfessSex);
      ((hummer_commelem.MsgElemInfo_servtype21)localObject1).c2c_confess_ctx.set(localC2CConfessContext);
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(21);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype21)localObject1).toByteArray()));
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(2);
      localElem.common_elem.set((MessageMicro)localObject2);
      paramMessageRecord.removeExtInfoToExtStr("ext_key_frd_chat_confess_info");
      localObject1 = localElem;
    } while (!QLog.isColorLevel());
    QLog.i("ConfessMsgUtil", 2, String.format("bindC2CFirstMsgConfessInfoElem frdChatConfessJson:%s  frienduin:%s senderuin:%s", new Object[] { str, paramMessageRecord.frienduin, paramMessageRecord.senderuin }));
    return localElem;
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("key_confess_topicid", paramInt2);
    localIntent.putExtra("entrance", 1);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("enterConfessDetail topicId:%d confessUin:%s confessGender:%d recUin:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2 }));
    }
    if ((paramInt1 <= 0) || (!ChatActivityUtils.isValidUin(paramString1)) || (!ChatActivityUtils.isValidUin(paramString2))) {
      return;
    }
    paramQQAppInterface = (aegs)paramQQAppInterface.getManager(269);
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = null;
      if (paramQQAppInterface != null) {
        break label187;
      }
    }
    label187:
    for (paramQQAppInterface = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";; paramQQAppInterface = paramQQAppInterface.detailUrl)
    {
      paramString1 = String.format("&topicId=%d&fromEncodeUin=%s&fromGender=%d&toUin=%s", new Object[] { Integer.valueOf(paramInt1), ajri.encode(paramString1), Integer.valueOf(paramInt2), ajri.encode(paramString2) });
      paramString2 = new Intent(paramContext, QQBrowserActivity.class);
      paramString2.putExtra("url", paramQQAppInterface + paramString1);
      paramContext.startActivity(paramString2);
      return;
      paramQQAppInterface = paramQQAppInterface.b();
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentItemConfessMsg paramRecentItemConfessMsg, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramRecentItemConfessMsg == null)) {}
    for (;;)
    {
      return;
      if ((paramRecentItemConfessMsg.mType == 1032) && (TextUtils.equals(paramRecentItemConfessMsg.mUin, acbn.blL))) {
        B(paramQQAppInterface, paramBoolean);
      }
      while (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "clearConfessUnread");
        return;
        int i = paramQQAppInterface.a().e(paramRecentItemConfessMsg.qx(), paramRecentItemConfessMsg.ng(), paramRecentItemConfessMsg.mConfessInfo.topicId);
        if (paramBoolean) {
          paramQQAppInterface.b().a(acbn.blK, 1032, paramRecentItemConfessMsg.qx(), paramQQAppInterface.getCurrentAccountUin(), paramRecentItemConfessMsg.mType, paramRecentItemConfessMsg.mConfessInfo.topicId);
        }
        if (i > 0) {
          paramQQAppInterface.b().a(paramRecentItemConfessMsg.qx(), paramRecentItemConfessMsg.ng(), paramRecentItemConfessMsg.mConfessInfo.topicId, true, false);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (top.eD(paramInt1) != 1032)) {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo return. frdUin:%s uinType:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    }
    ConfessInfo localConfessInfo;
    boolean bool;
    do
    {
      return;
      localConfessInfo = ((aegs)paramQQAppInterface.getManager(269)).a().a(paramString, paramInt1, paramInt2);
      if (localConfessInfo != null)
      {
        paramMessageRecord.saveExtInfoToExtStr("ext_key_confess_info", localConfessInfo.toJsonStr());
        if (paramInt1 != 1033) {
          break;
        }
        bool = true;
        paramMessageRecord.setSelfIsConfessor(bool);
        paramMessageRecord.setConfessTopicId(paramInt2);
      }
    } while (!QLog.isColorLevel());
    if (localConfessInfo == null)
    {
      paramQQAppInterface = "null";
      label133:
      if (localConfessInfo != null) {
        break label204;
      }
    }
    label204:
    for (int i = -1;; i = localConfessInfo.confessorSex)
    {
      QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo friendUin:%s uinType:%d topicId:%d confessorNick:%s confessorSex:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramQQAppInterface, Integer.valueOf(i) }));
      return;
      bool = false;
      break;
      paramQQAppInterface = localConfessInfo.confessorNick;
      break label133;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo)
  {
    if (QLog.isColorLevel()) {
      if (paramConfessInfo != null) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ConfessMsgUtil", 2, String.format("addShieldSucTipsMessage frdUin:%s uinType:%d topicId:%d confessInfo==null:%b", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) }));
      if (paramConfessInfo != null) {
        break;
      }
      return;
    }
    Object localObject1 = ((aegs)paramQQAppInterface.getManager(269)).b();
    int i;
    long l;
    if (localObject1 == null)
    {
      i = 24;
      Object localObject2 = String.format(aegp.bwP, new Object[] { Integer.valueOf(i) });
      localObject1 = acfp.m(2131704301);
      i = ((String)localObject2).indexOf((String)localObject1);
      int j = ((String)localObject1).length();
      localObject1 = new ahwa(paramString, paramString, (String)localObject2, paramInt1, -5020, 655369, anaz.gQ());
      ((ahwa)localObject1).wording = ((String)localObject2);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 31);
      ((ahwa)localObject1).addHightlightItem(i, j + i, (Bundle)localObject2);
      paramString = paramQQAppInterface.b().f(paramString, paramInt1);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label336;
      }
      l = ((ChatMessage)paramString.get(paramString.size() - 1)).shmsgseq;
      label244:
      paramString = new MessageForUniteGrayTip();
      paramString.initGrayTipMsg(paramQQAppInterface, (ahwa)localObject1);
      paramString.isread = true;
      paramString.shmsgseq = l;
      paramString.mNeedTimeStamp = true;
      paramString.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramString.setConfessTopicId(paramInt2);
      if (paramInt1 != 1033) {
        break label355;
      }
    }
    label336:
    label355:
    for (bool = true;; bool = false)
    {
      paramString.setSelfIsConfessor(bool);
      paramString.saveExtInfoToExtStr("ext_key_confess_info", paramConfessInfo.toJsonStr());
      paramQQAppInterface.b().b(paramString, paramQQAppInterface.getCurrentAccountUin());
      return;
      i = ((aegp)localObject1).cMK;
      break;
      l = Math.abs(new Random().nextInt());
      break label244;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("setReadedSafely uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new ConfessMsgUtil.3(paramQQAppInterface, paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2), 8, null, false);
      return;
    }
    paramQQAppInterface.b().a(paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "addHolmesGrayTipsMessage " + paramString1 + " " + paramString2);
    }
    ahwa localahwa = new ahwa(paramString1, paramString1, paramString2, paramInt1, -5040, 655377, anaz.gQ());
    localahwa.wording = paramString2;
    String str = acfp.m(2131704298);
    int i = paramString2.indexOf(str);
    int j = str.length();
    paramString2 = new Bundle();
    paramString2.putInt("key_action", 34);
    localahwa.addHightlightItem(i, j + i, paramString2);
    paramString1 = paramQQAppInterface.b().f(paramString1, paramInt1);
    long l;
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      l = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
      paramString1 = new MessageForUniteGrayTip();
      paramString1.initGrayTipMsg(paramQQAppInterface, localahwa);
      paramString1.isread = true;
      paramString1.shmsgseq = l;
      paramString1.mNeedTimeStamp = true;
      paramString1.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramString1.setConfessTopicId(paramInt2);
      if (paramInt1 != 1033) {
        break label258;
      }
    }
    label258:
    for (boolean bool = true;; bool = false)
    {
      paramString1.setSelfIsConfessor(bool);
      paramQQAppInterface.b().b(paramString1, paramQQAppInterface.getCurrentAccountUin());
      return;
      l = Math.abs(new Random().nextInt());
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = aqft.pk(paramString2);
      if (paramConfessInfo != null) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ConfessMsgUtil", 2, String.format("addGrayTipsMessage frdUin:%s uinType:%d topicId:%d msg:%s confessInfo==null:%b", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject, Boolean.valueOf(bool) }));
      if (paramConfessInfo != null) {
        break;
      }
      return;
    }
    Object localObject = new ahwa(paramString1, paramString1, paramString2, paramInt1, -5020, 655376, anaz.gQ());
    ((ahwa)localObject).wording = paramString2;
    paramString1 = paramQQAppInterface.b().f(paramString1, paramInt1);
    long l;
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      l = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
      paramString1 = new MessageForUniteGrayTip();
      paramString1.initGrayTipMsg(paramQQAppInterface, (ahwa)localObject);
      paramString1.isread = true;
      paramString1.shmsgseq = l;
      paramString1.mNeedTimeStamp = true;
      paramString1.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramString1.setConfessTopicId(paramInt2);
      if (paramInt1 != 1033) {
        break label255;
      }
    }
    label255:
    for (bool = true;; bool = false)
    {
      paramString1.setSelfIsConfessor(bool);
      paramString1.saveExtInfoToExtStr("ext_key_confess_info", paramConfessInfo.toJsonStr());
      paramQQAppInterface.b().b(paramString1, paramQQAppInterface.getCurrentAccountUin());
      return;
      l = Math.abs(new Random().nextInt());
      break;
    }
  }
  
  public static void a(msg_comm.Msg paramMsg, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    label8:
    Object localObject2;
    StringBuilder localStringBuilder;
    if ((paramMessageRecord == null) || (paramQQAppInterface == null))
    {
      return;
    }
    else
    {
      localObject2 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("<---decodePttConfessElem: elems: ");
        if (localObject2 != null) {
          break label175;
        }
      }
    }
    label175:
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject2).size()))
    {
      QLog.d("ConfessMsgUtil", 2, localObject1);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label8;
      }
      localObject2 = ((List)localObject2).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label8;
      }
      localObject1 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if ((!((im_msg_body.Elem)localObject1).common_elem.has()) || (21 != ((im_msg_body.Elem)localObject1).common_elem.uint32_service_type.get())) {
        break;
      }
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(paramMessageRecord);
      a(paramMsg, (im_msg_body.Elem)localObject1, (List)localObject2, paramQQAppInterface);
      return;
    }
  }
  
  public static void a(msg_comm.Msg paramMsg, im_msg_body.Elem paramElem, List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramElem == null) || (paramList == null) || (paramQQAppInterface == null) || (paramList.size() <= 0)) {}
    Object localObject2;
    long l2;
    long l1;
    label311:
    label464:
    label470:
    label600:
    Object localObject3;
    String str1;
    label1031:
    label1059:
    label1087:
    label1115:
    label1143:
    long l3;
    label1548:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem app:" + paramQQAppInterface);
                  }
                  try
                  {
                    if ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 1)) {
                      break label600;
                    }
                    localObject2 = new hummer_commelem.MsgElemInfo_servtype21();
                    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
                    if ((((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_topic_id.has()) && (((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confessor_uin.has()) && (((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_confessor_nick.has()) && (((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_confessor_sex.has()))
                    {
                      paramElem = BaseApplicationImpl.sApplication.getRuntime().getAccount();
                      localObject1 = ((MessageRecord)paramList.get(0)).frienduin;
                      j = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_topic_id.get();
                      l2 = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confessor_uin.get();
                      paramQQAppInterface = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_confessor_nick.get().toStringUtf8();
                      k = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_confessor_sex.get();
                      if (((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_sysmsg_flag.has())
                      {
                        i = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_sysmsg_flag.get();
                        if (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_topic.has()) {
                          break label464;
                        }
                        paramMsg = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_topic.get().toStringUtf8();
                        bool = Long.toString(l2).equals(paramElem);
                        if (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confess_time.has()) {
                          break label2290;
                        }
                        l1 = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confess_time.get();
                        paramElem = paramMsg;
                        if (i == 1)
                        {
                          paramElem = paramMsg;
                          if (!bool)
                          {
                            paramElem = paramMsg;
                            if ((paramList.get(0) instanceof MessageForText)) {
                              paramElem = ((MessageForText)paramList.get(0)).msg;
                            }
                          }
                        }
                        if ((j > 0) && (l2 > 0L) && (!TextUtils.isEmpty(paramQQAppInterface)) && (!TextUtils.isEmpty(paramElem))) {
                          break label470;
                        }
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        paramElem = Long.toString(l2);
                        paramMsg = paramQQAppInterface;
                        if (paramQQAppInterface == null) {
                          paramMsg = "null";
                        }
                        QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem data err confessorUin:%s topicId:%d nick:%s", new Object[] { paramElem, Integer.valueOf(j), paramMsg }));
                      }
                    }
                  }
                  catch (InvalidProtocolBufferMicroException paramMsg)
                  {
                    boolean bool;
                    while (QLog.isColorLevel())
                    {
                      QLog.i("ConfessMsgUtil", 2, paramMsg.getMessage(), paramMsg);
                      return;
                      i = 0;
                      continue;
                      paramMsg = "";
                    }
                    paramMsg = paramList.iterator();
                    while (paramMsg.hasNext())
                    {
                      paramList = (MessageRecord)paramMsg.next();
                      paramList.saveExtInfoToExtStr("ext_key_confess_info", ConfessInfo.toJsonStr(j, l2, k, paramQQAppInterface, i, paramElem, l1));
                      paramList.setConfessTopicId(j);
                      paramList.setSelfIsConfessor(bool);
                    }
                  }
                  catch (Exception paramMsg) {}
                }
              } while (!QLog.isColorLevel());
              QLog.i("ConfessMsgUtil", 2, paramMsg.getMessage(), paramMsg);
              return;
            } while (!QLog.isColorLevel());
            QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confessorUin:%s topicId:%d frdUin:%s topic:%s", new Object[] { Long.toString(l2), Integer.valueOf(j), localObject1, paramElem }));
            return;
            if ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 2) || (paramQQAppInterface == null)) {
              break;
            }
            localObject2 = new hummer_commelem.MsgElemInfo_servtype21();
            ((hummer_commelem.MsgElemInfo_servtype21)localObject2).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
          } while (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.has());
          if ((QLog.isColorLevel()) && (((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.get()).bytes_confess.has())) {
            QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", new Object[] { ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.get()).bytes_confess.get().toStringUtf8() }));
          }
          paramElem = "";
          localObject3 = paramQQAppInterface.getCurrentAccountUin();
          paramList = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
          localObject1 = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
          if (TextUtils.equals((CharSequence)localObject3, paramList)) {
            paramElem = (im_msg_body.Elem)localObject1;
          }
          for (;;)
          {
            localObject2 = (hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.get();
            localObject3 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_to_uin.get());
            str1 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confessor_uin.get());
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_topic_id.get();
            l1 = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_send_uin.get();
            if ((TextUtils.isEmpty(paramElem)) || (!TextUtils.equals(paramList, String.valueOf(l1))) || (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject3))) {
              break;
            }
            paramList = (aegs)paramQQAppInterface.getManager(269);
            if (paramList.b(paramElem, (String)localObject3, str1, i) != 1) {
              break;
            }
            localObject1 = new aegs.a();
            ((aegs.a)localObject1).nTopicId = i;
            ((aegs.a)localObject1).nBGType = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_bg_type.get();
            ((aegs.a)localObject1).strRecUin = ((String)localObject3);
            ((aegs.a)localObject1).strConfessorUin = str1;
            ((aegs.a)localObject1).strConfessorDesc = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).bytes_confess.get().toStringUtf8();
            ((aegs.a)localObject1).strConfessorNick = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).bytes_confessor_nick.get().toStringUtf8();
            ((aegs.a)localObject1).strRecNick = paramQQAppInterface.getCurrentNickname();
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confessor_sex.has()) {
              break label2296;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confessor_sex.get();
            ((aegs.a)localObject1).nConfessorSex = i;
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_time.has()) {
              break label2302;
            }
            l1 = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_time.get();
            ((aegs.a)localObject1).confessTime = l1;
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confess_num.has()) {
              break label2308;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confess_num.get();
            ((aegs.a)localObject1).nConfessNum = i;
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_biz_type.has()) {
              break label2314;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_biz_type.get();
            ((aegs.a)localObject1).nBizType = i;
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confess_to_sex.has()) {
              break label2320;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confess_to_sex.get();
            ((aegs.a)localObject1).nGetConfessSex = i;
            l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get() - 1L;
            l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get() - 1L;
            paramList.a(paramElem, (aegs.a)localObject1, l1, l2);
            if (!QLog.isColorLevel()) {
              break;
            }
            l3 = anaz.gQ();
            QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem strConfessorDesc:" + ((aegs.a)localObject1).strConfessorDesc + " msgTime:" + l1 + " msgSeq:" + l2 + " nowTime" + l3);
            return;
            if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject1)) {
              paramElem = paramList;
            }
          }
        } while ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 4) || (paramQQAppInterface == null));
        paramList = new hummer_commelem.MsgElemInfo_servtype21();
        paramList.mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
      } while (!paramList.group_confess_ctx.has());
      if ((QLog.isColorLevel()) && (((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)paramList.group_confess_ctx.get()).bytes_topic.has())) {
        QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", new Object[] { ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)paramList.group_confess_ctx.get()).bytes_topic.get().toStringUtf8() }));
      }
      if ((!paramMsg.msg_head.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.has()) || (!((msg_comm.GroupInfo)((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.get()).group_code.has())) {
        break;
      }
      paramElem = String.valueOf(((msg_comm.GroupInfo)((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.get()).group_code.get());
      if (paramMsg.msg_head.group_info.group_type.get() != 127) {
        break label2329;
      }
      i = 1;
      break label2326;
      if (TextUtils.isEmpty(paramElem)) {
        break label2327;
      }
      localObject3 = (hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)paramList.group_confess_ctx.get();
      str1 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_send_uin.get());
    } while (!TextUtils.equals(str1, String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get())));
    paramList = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_to_uin.get());
    String str2 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confessor_uin.get());
    int j = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_topic_id.get();
    Object localObject1 = (aegs)paramQQAppInterface.getManager(269);
    int k = ((aegs)localObject1).a(paramElem, paramList, str1, str2, j);
    if ((i == 0) && (k == 1))
    {
      localObject2 = new aegs.b();
      ((aegs.b)localObject2).strGroupUin = paramElem;
      ((aegs.b)localObject2).nTopicId = j;
      ((aegs.b)localObject2).nBGType = (j % 4);
      ((aegs.b)localObject2).strRecUin = paramList;
      ((aegs.b)localObject2).strConfessorUin = str2;
      if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_topic.has()) {
        break label2335;
      }
      paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_topic.get().toStringUtf8();
      label1747:
      ((aegs.b)localObject2).strConfessorDesc = paramList;
      if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confessor_sex.has()) {
        break label2341;
      }
      i = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confessor_sex.get();
      label1774:
      ((aegs.b)localObject2).nConfessorSex = i;
      if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confessor_nick.has()) {
        break label2347;
      }
      paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confessor_nick.get().toStringUtf8();
      label1804:
      if (TextUtils.isEmpty(paramList)) {
        if (((aegs.b)localObject2).nConfessorSex == 1)
        {
          paramList = acfp.m(2131704299);
          label1827:
          ((aegs.b)localObject2).strConfessorNick = paramList;
          label1833:
          if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confess_to_nick.has()) {
            break label2353;
          }
          paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confess_to_nick.get().toStringUtf8();
          label1856:
          ((aegs.b)localObject2).strRecNick = paramList;
          if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_time.has()) {
            break label2359;
          }
          l1 = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_time.get();
          label1883:
          ((aegs.b)localObject2).confessTime = l1;
          if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confess_to_nick_type.has()) {
            break label2365;
          }
        }
      }
    }
    label2308:
    label2314:
    label2320:
    label2326:
    label2327:
    label2329:
    label2335:
    label2341:
    label2347:
    label2353:
    label2359:
    label2365:
    for (int i = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confess_to_nick_type.get();; i = 0)
    {
      ((aegs.b)localObject2).nRecNickType = i;
      ((aegs.b)localObject2).bxe = str1;
      l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get() - 1L;
      long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      paramMsg = paramQQAppInterface.b().f(paramElem, 1);
      l2 = -1L;
      l1 = l2;
      if (paramMsg != null)
      {
        l1 = l2;
        if (!paramMsg.isEmpty()) {
          l1 = ((ChatMessage)paramMsg.get(paramMsg.size() - 1)).shmsgseq;
        }
      }
      if ((l4 < l1 - 5L) && (l1 >= 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 in if lastseq:" + l1 + "  msgSeq:" + l4);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new ConfessMsgUtil.1((aegs)localObject1, paramElem, (aegs.b)localObject2, l3, l4), 250L);
        return;
        paramList = acfp.m(2131704302);
        break label1827;
        ((aegs.b)localObject2).strConfessorNick = paramList;
        break label1833;
      }
      ((aegs)localObject1).a(paramElem, (aegs.b)localObject2, l3, l3, l4);
      if (!QLog.isColorLevel()) {
        break;
      }
      l1 = anaz.gQ();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 2 strConfessorDesc:" + ((aegs.b)localObject2).strConfessorDesc + " msgTime:" + l3 + " msgSeq:" + l4 + " nowTime" + l1);
      return;
      if ((!paramMsg.msg_head.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.has())) {
        break;
      }
      ((aegs)localObject1).a(paramElem, paramList, str1, str2, j, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get());
      return;
      i = 0;
      paramElem = "";
      break label1548;
      label2290:
      l1 = 0L;
      break label311;
      label2296:
      i = 0;
      break label1031;
      label2302:
      l1 = 0L;
      break label1059;
      i = 0;
      break label1087;
      i = 0;
      break label1115;
      i = 0;
      break label1143;
      for (;;)
      {
        break label1548;
        break;
        i = 0;
      }
      paramList = "";
      break label1747;
      i = 0;
      break label1774;
      paramList = "";
      break label1804;
      paramList = "";
      break label1856;
      l1 = 0L;
      break label1883;
    }
  }
  
  public static void a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034)) {}
    for (int i = 1; i == 0; i = 0) {
      return;
    }
    Object localObject2 = paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info");
    Object localObject1 = new ConfessInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((ConfessInfo)localObject1).parseFromJsonStr((String)localObject2);
    }
    localObject2 = new hummer_commelem.MsgElemInfo_servtype21();
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_topic_id.set(((ConfessInfo)localObject1).topicId);
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confessor_uin.set(((ConfessInfo)localObject1).confessorUin);
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confess_time.set(((ConfessInfo)localObject1).confessTime);
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((ConfessInfo)localObject1).confessorNick));
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_confessor_sex.set(((ConfessInfo)localObject1).confessorSex);
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_sysmsg_flag.set(0);
    if (!TextUtils.isEmpty(((ConfessInfo)localObject1).topic)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_topic.set(ByteStringMicro.copyFromUtf8(((ConfessInfo)localObject1).topic));
      }
      localObject1 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(21);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype21)localObject2).toByteArray()));
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(1);
      paramElem.common_elem.set((MessageMicro)localObject1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfoElem frdUin:%s type:%d topicId:%d needBindTopic:%b", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.getConfessTopicId()), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public static void ad(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1032) && (acbn.blK.equals(paramMessageRecord.frienduin)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, String.format("invalidMsgOnDel senderUin:%s frdUin:%s", new Object[] { paramMessageRecord.senderuin, paramMessageRecord.frienduin }));
      }
      paramMessageRecord.saveExtInfoToExtStr("ext_key_confess_info", "");
    }
  }
  
  public static int ag(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1033) {
      paramInt2 = (0x200000 | paramInt2 << 3) >>> 3;
    }
    while (paramInt1 == 1034) {
      return paramInt2;
    }
    return 0;
  }
  
  public static boolean ag(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"))) {
      return false;
    }
    return true;
  }
  
  public static boolean ah(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.getConfessTopicId() > 0) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info")));
  }
  
  public static MessageRecord b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isSelfConfessor()) {}
    for (int i = 1033;; i = 1034)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.b().a(paramMessageRecord.senderuin, i, paramMessageRecord.getConfessTopicId());
      MessageRecord localMessageRecord = paramMessageRecord;
      if (localMessage != null) {
        localMessageRecord = paramQQAppInterface.b().a(paramMessageRecord.senderuin, i, localMessage.uniseq);
      }
      return localMessageRecord;
    }
  }
  
  public static im_msg_body.Elem b(MessageRecord paramMessageRecord)
  {
    Object localObject1 = null;
    String str = paramMessageRecord.getExtInfoFromExtStr("ext_key_group_chat_confess_info");
    if (TextUtils.isEmpty(str)) {}
    im_msg_body.Elem localElem;
    do
    {
      do
      {
        return localObject1;
        localObject2 = aegs.b.a(str);
      } while (localObject2 == null);
      localElem = new im_msg_body.Elem();
      localObject1 = new hummer_commelem.MsgElemInfo_servtype21();
      hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext localGroupConfessContext = new hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext();
      localGroupConfessContext.uint64_confessor_uin.set(Long.parseLong(((aegs.b)localObject2).strConfessorUin));
      localGroupConfessContext.uint64_confess_to_uin.set(Long.parseLong(((aegs.b)localObject2).strRecUin));
      localGroupConfessContext.uint64_send_uin.set(Long.parseLong(paramMessageRecord.senderuin));
      localGroupConfessContext.bytes_topic.set(ByteStringMicro.copyFromUtf8(((aegs.b)localObject2).strConfessorDesc));
      localGroupConfessContext.bytes_confess_to_nick.set(ByteStringMicro.copyFromUtf8(((aegs.b)localObject2).strRecNick));
      localGroupConfessContext.uint64_confess_time.set(((aegs.b)localObject2).confessTime);
      localGroupConfessContext.uint32_topic_id.set(((aegs.b)localObject2).nTopicId);
      localGroupConfessContext.uint32_confessor_sex.set(((aegs.b)localObject2).nConfessorSex);
      localGroupConfessContext.uint32_confess_to_nick_type.set(((aegs.b)localObject2).nRecNickType);
      localGroupConfessContext.bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((aegs.b)localObject2).strConfessorNick));
      ((hummer_commelem.MsgElemInfo_servtype21)localObject1).group_confess_ctx.set(localGroupConfessContext);
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(21);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype21)localObject1).toByteArray()));
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(4);
      localElem.common_elem.set((MessageMicro)localObject2);
      paramMessageRecord.removeExtInfoToExtStr("ext_key_group_chat_confess_info");
      localObject1 = localElem;
    } while (!QLog.isColorLevel());
    QLog.i("ConfessMsgUtil", 2, String.format("bindGroupFirstMsgConfessInfoElem groupChatConfessJson:%s  frienduin:%s senderuin:%s", new Object[] { str, paramMessageRecord.frienduin, paramMessageRecord.senderuin }));
    return localElem;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = (aegs)paramQQAppInterface.getManager(269);
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.lz(paramString)));
      paramString = paramQQAppInterface.a();
      if (paramString != null)
      {
        paramMessageRecord.saveExtInfoToExtStr("ext_key_frd_chat_confess_info", paramString.toJsonStr());
        paramQQAppInterface.M(paramString.strRecUin, paramString.strConfessorUin, paramString.nTopicId);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ConfessMsgUtil", 2, String.format("bindC2CFirstMsgConfessInfo ExtStr: %s", new Object[] { paramMessageRecord.extStr }));
  }
  
  public static void c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = (aegs)paramQQAppInterface.getManager(269);
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.lA(paramString)));
      aegs.b localb = paramQQAppInterface.a();
      if (localb != null)
      {
        paramMessageRecord.saveExtInfoToExtStr("ext_key_group_chat_confess_info", localb.toJsonStr());
        paramQQAppInterface.d(paramString, localb.strRecUin, localb.bxe, localb.strConfessorUin, localb.nTopicId);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ConfessMsgUtil", 2, String.format("bindGroupFirstMsgConfessInfo ExtStr: %s", new Object[] { paramMessageRecord.extStr }));
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "red_unread_clear_flag";; str = "blue_unread_clear_flag")
    {
      boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("confess_unread_file" + paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean(str, false);
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, "isConfessBoxUnreadCleared:" + bool + " isRed:" + paramBoolean);
      }
      return bool;
    }
  }
  
  public static void cJ(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "clearLebaBannerUnread");
    }
    if ((paramQQAppInterface != null) && (aegp.B(paramQQAppInterface, "redpoint_leba_show"))) {
      aegp.e(paramQQAppInterface, "redpoint_leba_show", 0L);
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "setClearConfessBoxUnreadFlag:" + paramBoolean1 + " isRed:" + paramBoolean2);
    }
    if (paramBoolean2) {}
    for (String str = "red_unread_clear_flag";; str = "blue_unread_clear_flag")
    {
      paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("confess_unread_file" + paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramQQAppInterface.getBoolean(str, false) != paramBoolean1) {
        paramQQAppInterface.edit().putBoolean(str, paramBoolean1).apply();
      }
      return;
    }
  }
  
  public static boolean e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((top.eD(paramInt1) == 1032) || (top.eD(paramInt3) == 1032)) {}
    for (int i = 1; (i == 0) || ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)); i = 0) {
      return true;
    }
    return false;
  }
  
  public static String g(String paramString, int paramInt1, int paramInt2)
  {
    return paramString + "&" + paramInt1 + "&" + paramInt2;
  }
  
  public static void g(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "checkInsertConfessCardMsg " + paramList.size());
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.isSend()) || (top.eD(localMessageRecord.istroop) != 1032) || (!ag(localMessageRecord))) {
        break label427;
      }
      Object localObject1 = new ConfessInfo();
      ((ConfessInfo)localObject1).parseFromJsonStr(localMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
      if ((localMessageRecord.istroop != 1033) || (localHashSet.contains(Integer.valueOf(localMessageRecord.getConfessTopicId())))) {
        break label427;
      }
      localHashSet.add(Integer.valueOf(localMessageRecord.getConfessTopicId()));
      Object localObject2 = paramQQAppInterface.a(localMessageRecord.istroop).b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId());
      if (localObject2 == null) {
        break label424;
      }
      j = 0;
      label220:
      if (j >= ((List)localObject2).size()) {
        break label424;
      }
      if (((MessageRecord)((List)localObject2).get(j)).getConfessTopicId() == localMessageRecord.getConfessTopicId())
      {
        i = 1;
        label255:
        if (i == 0)
        {
          localObject1 = ((ConfessInfo)localObject1).topic;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = anbi.a(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), localMessageRecord.senderuin, null, localMessageRecord.istroop, (byte)0, (byte)0, (short)0, (String)localObject1);
            ((MessageRecord)localObject2).setConfessTopicId(localMessageRecord.getConfessTopicId());
            ((MessageRecord)localObject2).setSelfIsConfessor(localMessageRecord.isSelfConfessor());
            ((MessageRecord)localObject2).saveExtInfoToExtStr("ext_key_confess_info", localMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
            ((MessageRecord)localObject2).time = (localMessageRecord.time - 1L);
            localArrayList.add(0, localObject2);
            if (QLog.isColorLevel()) {
              QLog.i("ConfessMsgUtil", 2, String.format("checkInsertConfessCardMsg B:%s topic:%s", new Object[] { localMessageRecord.frienduin, localObject1 }));
            }
          }
        }
      }
    }
    label424:
    label427:
    for (;;)
    {
      break;
      j += 1;
      break label220;
      if (localArrayList.size() > 0) {
        paramList.addAll(0, localArrayList);
      }
      return;
      break label255;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegu
 * JD-Core Version:    0.7.0.1
 */