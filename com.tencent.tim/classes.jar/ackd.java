import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ContentItem;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.FriendRemark;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.FriendTeamList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GenderFiled;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GeneralBuffer;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GroupName;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.NickNameFiled;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileInfo;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileListResult;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileTvInfo;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ReqBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.RspBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.UpdateProfileList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ValueBit;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.MutualMarkData;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.ReqBody;
import tencent.intimate_relation.intimate_relation.IntimateInfo;

public class ackd
  implements andh
{
  private final QQAppInterface app;
  private ByteStringMicro b;
  
  public ackd(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.b = null;
    P(this.app, "775_hot_friend_new_boat_clear_version");
    P(this.app, "top_position_and_disturb_clear_version");
    P(this.app, "check_message_preview_version_clear");
  }
  
  public static void P(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProfileItem", 2, "checkNewBoatUpdateVersion");
      }
      paramQQAppInterface = paramQQAppInterface.getPreferences();
      if (!paramQQAppInterface.getBoolean(paramString, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProfileItem", 2, "checkNewBoatUpdateVersion clear");
        }
        paramQQAppInterface = paramQQAppInterface.edit();
        paramQQAppInterface.putBoolean(paramString, true);
        paramQQAppInterface.putLong("inccheckupdatetimeStamp9", 0L);
        paramQQAppInterface.commit();
      }
    }
  }
  
  public static void a(long paramLong, String paramString, acdu paramacdu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoName uin = " + paramLong + ",nickName = " + paramString);
    }
    Object localObject = paramacdu.getDiscussList();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
        DiscussionMemberInfo localDiscussionMemberInfo = paramacdu.a(localDiscussionInfo.uin, Long.toString(paramLong));
        if ((localDiscussionMemberInfo != null) && (ay(paramString, localDiscussionMemberInfo.memberName)))
        {
          localDiscussionMemberInfo.memberName = paramString;
          if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoName discussMem.memberName = " + localDiscussionMemberInfo.memberName + ",discussMem.inteRemark = " + localDiscussionMemberInfo.inteRemark + ",discussionUin = " + localDiscussionInfo.uin);
          }
          localArrayList.add(localDiscussionMemberInfo);
        }
      }
      if (localArrayList.size() > 0)
      {
        paramacdu.iH(localArrayList);
        paramString = new HashMap();
        paramString.put("count", String.valueOf(localArrayList.size()));
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "updateDiscussMemberNick", true, 0L, 0L, paramString, "", true);
      }
    }
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new String();
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, "len = " + paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfByte[i];
      int k = paramArrayOfByte[i];
      String str = (String)localObject + "0123456789ABCDEF".charAt(j >> 4 & 0xF) + "" + "0123456789ABCDEF".charAt(k & 0xF) + " ";
      localObject = str;
      if ((i + 1) % 8 == 0)
      {
        str = str + " ";
        localObject = str;
        if ((i + 1) % 16 == 0)
        {
          if (QLog.isColorLevel()) {
            localStringBuilder.append(str + "\n");
          }
          localObject = "";
        }
      }
      i += 1;
    }
    QLog.d(paramString, 2, localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, (String)localObject);
    }
  }
  
  private void a(Oidb_0x5e0.RspBody paramRspBody)
  {
    acff localacff = (acff)this.app.getManager(51);
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    Object localObject1 = paramRspBody.rpt_msg_contentItem.get();
    this.app.a().bJ.addAndGet(((List)localObject1).size());
    if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1)) {}
    label1549:
    label1578:
    label4179:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateRspBody called contentitemlist size = " + ((List)localObject1).size() + " overFlag:" + bool);
      }
      Friends[] arrayOfFriends = new Friends[((List)localObject1).size()];
      int j = 0;
      int i = 0;
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      Object localObject3 = null;
      if (localObject1 != null)
      {
        Iterator localIterator1 = ((List)localObject1).iterator();
        j = i;
        if (localIterator1.hasNext())
        {
          localObject1 = (Oidb_0x5e0.ContentItem)localIterator1.next();
          if (!((Oidb_0x5e0.ContentItem)localObject1).uint32_update_profile_id.has()) {
            break label6488;
          }
          switch (((Oidb_0x5e0.ContentItem)localObject1).uint32_update_profile_id.get())
          {
          case 8: 
          case 14: 
          default: 
            label348:
            if ((localObject3 != null) && (!TextUtils.isEmpty(((aczr.a)localObject3).friendUin)))
            {
              localObject1 = (aczr)this.app.getManager(199);
              if (localObject1 != null) {
                ((aczr)localObject1).a((aczr.a)localObject3);
              }
              ((aczr.a)localObject3).clearData();
            }
            break;
          }
        }
      }
      label855:
      label6488:
      for (;;)
      {
        break;
        if (!((Oidb_0x5e0.ContentItem)localObject1).msg_nicknamefiled.has()) {
          break label348;
        }
        localObject1 = (Oidb_0x5e0.NickNameFiled)((Oidb_0x5e0.ContentItem)localObject1).msg_nicknamefiled.get();
        j = i;
        Object localObject6;
        Object localObject7;
        if (localObject1 != null)
        {
          j = i;
          if (((Oidb_0x5e0.NickNameFiled)localObject1).uint64_uin.has())
          {
            l1 = ((Oidb_0x5e0.NickNameFiled)localObject1).uint64_uin.get();
            localObject5 = ((Oidb_0x5e0.NickNameFiled)localObject1).bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  Nick：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 昵称 = " + aqft.pk((String)localObject5));
            }
            localObject6 = localacff.e(Long.toString(l1));
            localObject1 = null;
            if (localObject6 != null) {
              localObject1 = ((Friends)localObject6).name;
            }
            localObject7 = localacff.a(l1 + "", (String)localObject5);
            arrayOfFriends[i] = localObject7;
            if ((localObject6 != null) && (((Friends)localObject6).isFriend()) && (ay((String)localObject5, (String)localObject1))) {
              localArrayList5.add(localObject7);
            }
            j = i + 1;
          }
        }
        i = j;
        break label348;
        if (!((Oidb_0x5e0.ContentItem)localObject1).msg_genderfiled.has()) {
          break label348;
        }
        Object localObject5 = (Oidb_0x5e0.GenderFiled)((Oidb_0x5e0.ContentItem)localObject1).msg_genderfiled.get();
        long l1 = ((Oidb_0x5e0.GenderFiled)localObject5).uint64_uin.get();
        localObject1 = localacff.b(l1 + "");
        if (localObject1 != null)
        {
          j = ((Oidb_0x5e0.GenderFiled)localObject5).uint32_gender.get();
          if (j != 1) {
            break label855;
          }
          j = 0;
        }
        for (;;)
        {
          ((Card)localObject1).shGender = ((short)j);
          if (aqft.equalsWithNullCheck(this.app.getCurrentAccountUin(), String.valueOf(l1)))
          {
            localObject5 = (ajpj)this.app.getManager(106);
            if (localObject5 != null) {
              ((ajpj)localObject5).Rk(((Card)localObject1).shGender);
            }
          }
          localacff.a((Card)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  sex: uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " sex = " + j);
          }
          break;
          if (j == 2)
          {
            j = 1;
          }
          else if (j == 0)
          {
            j = 2;
            continue;
            if (!((Oidb_0x5e0.ContentItem)localObject1).msg_friendremark.has()) {
              break;
            }
            localObject1 = (Oidb_0x5e0.FriendRemark)((Oidb_0x5e0.ContentItem)localObject1).msg_friendremark.get();
            if ((localObject1 != null) && (((Oidb_0x5e0.FriendRemark)localObject1).uint64_uin.has()))
            {
              l1 = ((Oidb_0x5e0.FriendRemark)localObject1).uint64_uin.get();
              localObject5 = ((Oidb_0x5e0.FriendRemark)localObject1).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate Remark：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 备注内容 = " + aqft.pk((String)localObject5));
              }
              localObject6 = localacff.e(Long.toString(l1));
              localObject1 = null;
              if (localObject6 != null) {
                localObject1 = ((Friends)localObject6).remark;
              }
              localObject7 = localacff.b(l1 + "", (String)localObject5);
              if ((localObject6 != null) && (((Friends)localObject6).isFriend()) && (az((String)localObject5, (String)localObject1))) {
                localArrayList4.add(localObject7);
              }
            }
            break;
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject1).msg_groupname.has()) {
              break;
            }
            localObject1 = (Oidb_0x5e0.GroupName)((Oidb_0x5e0.ContentItem)localObject1).msg_groupname.get();
            if ((localObject1 != null) && (((Oidb_0x5e0.GroupName)localObject1).uint64_group_uin.has()))
            {
              l1 = ((Oidb_0x5e0.GroupName)localObject1).uint64_group_uin.get();
              localObject1 = ((Oidb_0x5e0.GroupName)localObject1).bytes_value.get().toStringUtf8();
              localObject5 = localTroopManager.b(l1 + "");
              if (localObject5 != null)
              {
                ((TroopInfo)localObject5).troopname = ((String)localObject1);
                localArrayList3.add(localObject5);
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate TroopName：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 群名称内容 = " + aqft.pk((String)localObject1));
                }
              }
            }
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject1).msg_friend_teamlist.has()) {
              break;
            }
            localObject1 = (Oidb_0x5e0.FriendTeamList)((Oidb_0x5e0.ContentItem)localObject1).msg_friend_teamlist.get();
            if ((localObject1 != null) && (((Oidb_0x5e0.FriendTeamList)localObject1).uint32_update_flag.has()) && (((Oidb_0x5e0.FriendTeamList)localObject1).uint32_update_flag.get() == 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate GroupList：uin = ");
              }
              ((FriendListHandler)this.app.getBusinessHandler(1)).EQ(true);
            }
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject1).msg_value_bit.has()) {
              break;
            }
            localObject1 = (Oidb_0x5e0.ValueBit)((Oidb_0x5e0.ContentItem)localObject1).msg_value_bit.get();
            j = i;
            int n;
            int m;
            int k;
            int i1;
            if (localObject1 != null)
            {
              j = i;
              if (((Oidb_0x5e0.ValueBit)localObject1).uint64_uin.has())
              {
                l1 = ((Oidb_0x5e0.ValueBit)localObject1).uint64_uin.get();
                localObject5 = localacff.e(Long.toString(l1));
                n = 0;
                m = 0;
                k = 0;
                if (localObject5 != null)
                {
                  n = ((Friends)localObject5).qqVipInfo;
                  m = ((Friends)localObject5).superQqInfo;
                  k = ((Friends)localObject5).superVipInfo;
                }
                if ((((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().size() >= 3))
                {
                  j = ((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().byteAt(0);
                  i1 = ((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().byteAt(2);
                  if (localObject5 != null)
                  {
                    int i2 = ((Friends)localObject5).qqVipInfo;
                    if ((j & 0xFC) == 0) {
                      break label1816;
                    }
                    j = 1;
                    ((Friends)localObject5).qqVipInfo = (j << 24 | i2);
                    i2 = ((Friends)localObject5).qqVipInfo;
                    if ((i1 & 0x60) == 0) {
                      break label1821;
                    }
                    j = 1;
                    ((Friends)localObject5).qqVipInfo = (j << 24 | i2);
                  }
                }
                if ((((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.get().size() >= 5))
                {
                  j = ((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.get().byteAt(5);
                  if (localObject5 != null)
                  {
                    i1 = ((Friends)localObject5).superVipInfo;
                    if ((j & 0x20) == 0) {
                      break label1826;
                    }
                  }
                }
              }
            }
            for (j = 1;; j = 0)
            {
              ((Friends)localObject5).superVipInfo = (j << 24 | i1);
              j = i;
              if (localObject5 != null) {
                if ((((Friends)localObject5).superVipInfo == k) && (((Friends)localObject5).qqVipInfo == n))
                {
                  j = i;
                  if (((Friends)localObject5).superQqInfo == m) {}
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "find a vip user uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " superVipInfo = " + ((Friends)localObject5).superVipInfo + " qqVipInfo = " + ((Friends)localObject5).qqVipInfo + " superQqInfo = " + ((Friends)localObject5).superQqInfo);
                  }
                  arrayOfFriends[i] = localObject5;
                  j = i + 1;
                }
              }
              i = j;
              break;
              j = 0;
              break label1549;
              j = 0;
              break label1578;
            }
            if (!((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.has()) {
              break;
            }
            localObject1 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.get();
            long l2;
            if ((localObject1 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.has()))
            {
              localObject1 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.get().toByteArray());
              if (((ByteBuffer)localObject1).remaining() > 8)
              {
                l1 = ((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF;
                l2 = ((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF;
                localObject6 = new byte[((ByteBuffer)localObject1).getShort() & 0xFFFF];
                ((ByteBuffer)localObject1).get((byte[])localObject6);
                localObject5 = localacff.a(Long.toString(l1));
                localObject1 = localObject5;
                if (localObject5 == null)
                {
                  localObject1 = new ExtensionInfo();
                  ((ExtensionInfo)localObject1).uin = Long.toString(l1);
                }
                if (((ExtensionInfo)localObject1).richTime != l2)
                {
                  ((ExtensionInfo)localObject1).setRichBuffer((byte[])localObject6, l2);
                  ((ExtensionInfo)localObject1).isAdded2C2C = SignatureManager.a(this.app, Long.toString(l1), ((ExtensionInfo)localObject1).getRichStatus());
                  localacff.a((ExtensionInfo)localObject1);
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "insertSignMsgIfNeeded from QQProfileItem uin = " + l1 + " result = " + ((ExtensionInfo)localObject1).isAdded2C2C);
                  }
                }
              }
            }
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.has()) {
              break;
            }
            localObject1 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.get();
            if ((localObject1 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.has())) {
              localObject7 = new Oidb_0x5d0.SnsUpateBuffer();
            }
            for (;;)
            {
              Iterator localIterator2;
              try
              {
                ((Oidb_0x5d0.SnsUpateBuffer)localObject7).mergeFrom(((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.get().toByteArray());
                if ((localObject7 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.has()) && (((Oidb_0x5d0.SnsUpateBuffer)localObject7).rpt_uin32_idlist.has()))
                {
                  localObject6 = ((Oidb_0x5d0.SnsUpateBuffer)localObject7).rpt_uin32_idlist.get().iterator();
                  if (!((Iterator)localObject6).hasNext()) {
                    break label3047;
                  }
                  if (((Integer)((Iterator)localObject6).next()).intValue() != 4051) {
                    continue;
                  }
                  localObject5 = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get());
                  if (QLog.isColorLevel())
                  {
                    if (((String)localObject5).length() < 4) {
                      break label6478;
                    }
                    localObject1 = ((String)localObject5).substring(((String)localObject5).length() - 4);
                    QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit : shd: " + (String)localObject1);
                  }
                  this.app.a().hk.put(localObject5, localObject5);
                  continue;
                }
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                localObject7 = null;
                continue;
                if ((localObject7 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.has()) && (((Oidb_0x5d0.SnsUpateBuffer)localObject7).rpt_msg_sns_update_item.has()))
                {
                  localObject2 = ((Oidb_0x5d0.SnsUpateBuffer)localObject7).rpt_msg_sns_update_item.get();
                  l1 = ((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get();
                  localIterator2 = ((List)localObject2).iterator();
                  localObject5 = null;
                  if (localIterator2.hasNext())
                  {
                    Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)localIterator2.next();
                    localObject6 = localObject5;
                    if (localSnsUpdateItem != null)
                    {
                      localObject6 = localObject5;
                      if (localSnsUpdateItem.uint32_update_sns_type.has())
                      {
                        localObject6 = localObject5;
                        if (localSnsUpdateItem.bytes_value.has())
                        {
                          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13578)
                          {
                            localObject2 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(l1), 13578, 18);
                            if (!localSnsUpdateItem.bytes_value.has())
                            {
                              ((FriendsStatusUtil.UpdateFriendStatusItem)localObject2).aT(null);
                              FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject2, null);
                              continue;
                            }
                            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject2).aT(localSnsUpdateItem.bytes_value.get().toByteArray());
                            continue;
                          }
                          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13579)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("QQProfileItem", 2, "get do not disturb push");
                            }
                            localObject2 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(l1), 13579, 19);
                            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject2).aU(localSnsUpdateItem.bytes_value.get().toByteArray());
                            FriendsStatusUtil.a(this.app, (FriendsStatusUtil.UpdateFriendStatusItem)localObject2, null);
                            continue;
                          }
                          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13568) {
                            abbf.a(String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get()), localSnsUpdateItem.bytes_value.get().toStringUtf8(), this.app);
                          }
                          localObject2 = localObject5;
                          if (localObject5 == null)
                          {
                            localObject5 = localacff.a(String.valueOf(l1));
                            localObject2 = localObject5;
                            if (localObject5 == null)
                            {
                              localObject2 = new SpecialCareInfo();
                              ((SpecialCareInfo)localObject2).uin = String.valueOf(String.valueOf(l1));
                            }
                          }
                          j = localSnsUpdateItem.uint32_update_sns_type.get();
                          localObject5 = localSnsUpdateItem.bytes_value.get().toStringUtf8();
                          FriendListHandler.a((SpecialCareInfo)localObject2, j, (String)localObject5);
                          if (QLog.isColorLevel()) {
                            QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody uin=" + ((SpecialCareInfo)localObject2).uin + ", itemtype=" + j + ",itemVal=" + (String)localObject5);
                          }
                          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13575)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("HotFriend_ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody uin= " + l1);
                            }
                            String str = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get());
                            byte[] arrayOfByte = localSnsUpdateItem.bytes_value.get().toByteArray();
                            localObject6 = localacff.a(str);
                            localObject5 = localObject6;
                            if (localObject6 == null)
                            {
                              localObject5 = new ExtensionInfo();
                              ((ExtensionInfo)localObject5).uin = str;
                            }
                            FriendListHandler.a(str, arrayOfByte, (ExtensionInfo)localObject5);
                            localacff.a((ExtensionInfo)localObject5);
                            localArrayList2.add(((ExtensionInfo)localObject5).uin);
                          }
                          localObject6 = localObject2;
                          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13581)
                          {
                            localObject5 = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get());
                            if (TextUtils.isEmpty(localSnsUpdateItem.bytes_value.get().toStringUtf8()))
                            {
                              localHashMap.put(localObject5, Boolean.valueOf(false));
                              localObject5 = localObject2;
                              continue;
                            }
                            localHashMap.put(localObject5, Boolean.valueOf(true));
                            localObject6 = localObject2;
                          }
                        }
                      }
                    }
                    localObject2 = localObject6;
                    continue;
                  }
                  if ((localObject5 != null) && ((((SpecialCareInfo)localObject5).getStatus() != 1000) || (((SpecialCareInfo)localObject5).globalSwitch != 0))) {
                    localArrayList1.add(localObject5);
                  }
                }
              }
              label3047:
              break;
              if (!((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.has()) {
                break;
              }
              Object localObject2 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.get();
              l2 = 0L;
              l1 = l2;
              if (localObject2 != null)
              {
                l1 = l2;
                if (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()) {
                  l1 = ((Oidb_0x5e0.GeneralBuffer)localObject2).uint64_uin.get();
                }
              }
              if ((localObject2 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()))
              {
                localObject2 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.get().toByteArray());
                if (((ByteBuffer)localObject2).remaining() >= 8)
                {
                  l2 = ((ByteBuffer)localObject2).getLong();
                  localObject5 = localacff.a(String.valueOf(l1));
                  localObject2 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject2 = new ExtensionInfo();
                    ((ExtensionInfo)localObject2).uin = String.valueOf(l1);
                  }
                  ((ExtensionInfo)localObject2).pendantId = l2;
                  ((ExtensionInfo)localObject2).timestamp = System.currentTimeMillis();
                  localacff.a((ExtensionInfo)localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Pendant, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + ((ExtensionInfo)localObject2).pendantId);
                  }
                }
              }
              break;
              if (!((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.has()) {
                break;
              }
              localObject2 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.get();
              l2 = 0L;
              l1 = l2;
              if (localObject2 != null)
              {
                l1 = l2;
                if (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()) {
                  l1 = ((Oidb_0x5e0.GeneralBuffer)localObject2).uint64_uin.get();
                }
              }
              if ((localObject2 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()))
              {
                localObject2 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.get().toByteArray());
                if (((ByteBuffer)localObject2).remaining() >= 4)
                {
                  j = ((ByteBuffer)localObject2).getInt();
                  localObject5 = localacff.a(String.valueOf(l1));
                  localObject2 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject2 = new ExtensionInfo();
                    ((ExtensionInfo)localObject2).uin = String.valueOf(l1);
                  }
                  if (((ExtensionInfo)localObject2).uVipFont != j)
                  {
                    ((ExtensionInfo)localObject2).uVipFont = j;
                    ((ExtensionInfo)localObject2).timestamp = System.currentTimeMillis();
                    localacff.a((ExtensionInfo)localObject2);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Font, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + j);
                  }
                }
              }
              break;
              if (!((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.has()) {
                break;
              }
              localObject2 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.get();
              l2 = 0L;
              l1 = l2;
              if (localObject2 != null)
              {
                l1 = l2;
                if (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()) {
                  l1 = ((Oidb_0x5e0.GeneralBuffer)localObject2).uint64_uin.get();
                }
              }
              if ((localObject2 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()))
              {
                localObject2 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.get().toByteArray());
                if (((ByteBuffer)localObject2).remaining() >= 4)
                {
                  j = ((ByteBuffer)localObject2).getInt();
                  localObject5 = localacff.a(String.valueOf(l1));
                  localObject2 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject2 = new ExtensionInfo();
                    ((ExtensionInfo)localObject2).uin = String.valueOf(l1);
                  }
                  if (((ExtensionInfo)localObject2).colorRingId != j)
                  {
                    ((ExtensionInfo)localObject2).colorRingId = j;
                    ((ExtensionInfo)localObject2).timestamp = System.currentTimeMillis();
                    localacff.a((ExtensionInfo)localObject2);
                    aqpr.af(((ExtensionInfo)localObject2).uin, 1, this.app.getCurrentAccountUin());
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get colorRing, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + j);
                  }
                }
              }
              break;
              if (!((Oidb_0x5e0.ContentItem)localObject2).msg_profile_info.has()) {
                break;
              }
              localObject2 = (Oidb_0x5e0.ProfileInfo)((Oidb_0x5e0.ContentItem)localObject2).msg_profile_info.get();
              l1 = ((Oidb_0x5e0.ProfileInfo)localObject2).uint64_uin.get();
              localObject5 = ((Oidb_0x5e0.ProfileInfo)localObject2).rpt_msg_profile_info.get();
              if (localObject3 == null)
              {
                localObject2 = new aczr.a(l1);
                localObject6 = (abhh)this.app.getManager(153);
                localObject7 = ((abhh)localObject6).b(l1 + "");
                localIterator2 = ((List)localObject5).iterator();
                j = 0;
                label3930:
                if (!localIterator2.hasNext()) {
                  break label5308;
                }
                localObject3 = (Oidb_0x5e0.ProfileTvInfo)localIterator2.next();
                k = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint32_field_id.get();
                ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint32_field_type.get();
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "Check update for profile field uin: " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ",field: " + k + ", int_value: " + 0L);
                }
                switch (k)
                {
                default: 
                  k = j;
                }
              }
              for (;;)
              {
                j = k;
                for (;;)
                {
                  break label3930;
                  ((aczr.a)localObject3).clearData();
                  ((aczr.a)localObject3).friendUin = Long.toString(l1);
                  localObject2 = localObject3;
                  break;
                  l2 = (int)((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4179;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloVipLevel == l2) {
                    break label4179;
                  }
                  ((ApolloBaseInfo)localObject7).apolloVipLevel = ((int)l2);
                  j = 1;
                  continue;
                  l2 = (int)((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4179;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloVipFlag == l2) {
                    break label4179;
                  }
                  ((ApolloBaseInfo)localObject7).apolloVipFlag = ((int)l2);
                  j = 1;
                  continue;
                  l2 = (int)((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4179;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloStatus == l2) {
                    break label4179;
                  }
                  ((ApolloBaseInfo)localObject7).apolloStatus = ((int)l2);
                  j = 1;
                  continue;
                  l2 = (int)((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4179;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).cmshow3dFlag == l2) {
                    break label4179;
                  }
                  ((ApolloBaseInfo)localObject7).cmshow3dFlag = ((int)l2);
                  j = 1;
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4179;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloServerTS == l2) {
                    break label4179;
                  }
                  ((ApolloBaseInfo)localObject7).apolloServerTS = l2;
                  j = 1;
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (l2 >= NetConnInfoCenter.getServerTime()) {
                    break label4179;
                  }
                  k = j;
                  if (localObject7 == null) {
                    break label4179;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloSignValidTS == l2) {
                    break label4179;
                  }
                  ((ApolloBaseInfo)localObject7).apolloLocalSignTs = ((ApolloBaseInfo)localObject7).apolloSignValidTS;
                  ((ApolloBaseInfo)localObject7).apolloSignValidTS = l2;
                  ((ApolloBaseInfo)localObject7).apolloSignStr = "";
                  j = 1;
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  if (((ApolloBaseInfo)localObject7).apolloAISwitch != (int)l2)
                  {
                    ((ApolloBaseInfo)localObject7).apolloAISwitch = ((int)l2);
                    if (String.valueOf(l1).equals(this.app.getCurrentUin())) {
                      ((abhh)localObject6).gB((int)l2, 3);
                    }
                    j = 1;
                  }
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4179;
                  }
                  QLog.d("ProfileService.CheckUpdateReq", 2, "apollo aiSwitch profileupdate :" + l2);
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  localObject5 = ((acff)this.app.getManager(51)).a(Long.toString(l1));
                  localObject3 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject3 = new ExtensionInfo();
                    ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                  }
                  if ((((ExtensionInfo)localObject3).uVipFont != ku.h(l2)) || (((ExtensionInfo)localObject3).vipFontType != ku.c(l2)))
                  {
                    ((ExtensionInfo)localObject3).uVipFont = ku.h(l2);
                    ((ExtensionInfo)localObject3).vipFontType = ku.c(l2);
                    ((ExtensionInfo)localObject3).timestamp = System.currentTimeMillis();
                    localacff.a((ExtensionInfo)localObject3);
                  }
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4179;
                  }
                  QLog.d("QQProfileItem", 2, "update, Get Font, uin=" + l1 + ", id=" + ((ExtensionInfo)localObject3).uVipFont + ", type = " + ((ExtensionInfo)localObject3).vipFontType);
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  localObject5 = ((acff)this.app.getManager(51)).a(Long.toString(l1));
                  localObject3 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject3 = new ExtensionInfo();
                    ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                  }
                  if (((ExtensionInfo)localObject3).magicFont != l2)
                  {
                    ((ExtensionInfo)localObject3).magicFont = ((int)l2);
                    ((ExtensionInfo)localObject3).timestamp = System.currentTimeMillis();
                    localacff.a((ExtensionInfo)localObject3);
                  }
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4179;
                  }
                  QLog.d("QQProfileItem", 2, "update, Get magic font, uin= " + l1 + ", magicfont = " + ((ExtensionInfo)localObject3).magicFont);
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  localObject5 = ((acff)this.app.getManager(51)).a(Long.toString(l1));
                  localObject3 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject3 = new ExtensionInfo();
                    ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                    ((ExtensionInfo)localObject3).fontEffect = -1;
                  }
                  if (((ExtensionInfo)localObject3).fontEffect != l2)
                  {
                    ((ExtensionInfo)localObject3).fontEffect = ((int)l2);
                    ((ExtensionInfo)localObject3).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
                    localacff.a((ExtensionInfo)localObject3);
                  }
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4179;
                  }
                  QLog.d("QQProfileItem", 2, "update, Get font effect, uin= " + l1 + ", fontEffect = " + ((ExtensionInfo)localObject3).fontEffect + ", updateTime = " + ((ExtensionInfo)localObject3).fontEffectLastUpdateTime);
                  continue;
                  ((aczr.a)localObject2).RL = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  continue;
                  ((aczr.a)localObject2).RM = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  continue;
                  ((aczr.a)localObject2).RN = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                }
                l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                localObject5 = ((acff)this.app.getManager(51)).a(Long.toString(l1));
                localObject3 = localObject5;
                if (localObject5 == null)
                {
                  localObject3 = new ExtensionInfo();
                  ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                }
                k = j;
                if (((ExtensionInfo)localObject3).latestPLUpdateTimestamp != l2)
                {
                  ((ExtensionInfo)localObject3).latestPLUpdateTimestamp = l2;
                  localacff.a((ExtensionInfo)localObject3);
                  k = j;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("QQProfileItem", 2, "update uin=" + l1 + " latestplNewsTs=" + l2);
                    k = j;
                  }
                }
              }
              if (j != 0) {
                ((abhh)localObject6).a((ApolloBaseInfo)localObject7);
              }
              localObject3 = localObject2;
              break;
              if (!((Oidb_0x5e0.ContentItem)localObject2).msg_intimate_info.has()) {
                break;
              }
              ajok.a(this.app, (intimate_relation.IntimateInfo)((Oidb_0x5e0.ContentItem)localObject2).msg_intimate_info.get());
              break;
              if (!((Oidb_0x5e0.ContentItem)localObject2).msg_ext_sns_frd_data.has()) {
                break;
              }
              wky.a(this.app, (Oidb_0xd50.ExtSnsFrdData)((Oidb_0x5e0.ContentItem)localObject2).msg_ext_sns_frd_data.get());
              break;
              if (!((Oidb_0x5e0.ContentItem)localObject2).msg_mutual_mark_data.has()) {
                break;
              }
              ajnp.a(this.app, (Oidb_0xd6b.MutualMarkData)((Oidb_0x5e0.ContentItem)localObject2).msg_mutual_mark_data.get());
              break;
              localObject2 = (acdu)this.app.getManager(53);
              if (localArrayList5.size() > 0)
              {
                localObject3 = localArrayList5.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject5 = (Friends)((Iterator)localObject3).next();
                  localObject6 = ((Friends)localObject5).name;
                  a(Long.parseLong(((Friends)localObject5).uin), (String)localObject6, (acdu)localObject2);
                }
              }
              if (localArrayList4.size() > 0)
              {
                localObject3 = localArrayList4.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject5 = (Friends)((Iterator)localObject3).next();
                  localObject6 = ((Friends)localObject5).remark;
                  b(Long.parseLong(((Friends)localObject5).uin), (String)localObject6, (acdu)localObject2);
                }
              }
              if (localArrayList3.size() > 0) {
                localObject2 = localacff.a();
              }
              for (;;)
              {
                try
                {
                  ((EntityTransaction)localObject2).begin();
                  localObject3 = localArrayList3.iterator();
                  if (((Iterator)localObject3).hasNext())
                  {
                    localTroopManager.i((TroopInfo)((Iterator)localObject3).next());
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                  ((EntityTransaction)localObject2).end();
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody, bulkSaveOrUpdateSpecialCareInfos,size=" + localArrayList1.size());
                  }
                  if (localArrayList1.size() > 0)
                  {
                    localacff.iO(localArrayList1);
                    ((FriendListHandler)this.app.getBusinessHandler(1)).notifyUI(99, true, new Object[] { Boolean.valueOf(true), localArrayList1 });
                  }
                  if (localHashMap.size() > 0)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("tag_hidden_chat", 2, new Object[] { "0x5e0 size", Integer.valueOf(localHashMap.size()) });
                    }
                    FriendsStatusUtil.b(localHashMap, this.app);
                    if (localArrayList2.size() > 0) {
                      ((FriendListHandler)this.app.getBusinessHandler(1)).notifyUI(107, true, localArrayList2);
                    }
                    if ((!bool) || (this.app.a().bJ.get() == 0)) {
                      break label6333;
                    }
                    localObject5 = localacff.cq();
                    localObject2 = new ArrayList();
                    localObject4 = this.app.a().hk;
                    localObject5 = ((ArrayList)localObject5).iterator();
                    if (!((Iterator)localObject5).hasNext()) {
                      break;
                    }
                    localObject6 = (Friends)((Iterator)localObject5).next();
                    if ((!((Friends)localObject6).isShield()) || (((ConcurrentHashMap)localObject4).containsKey(((Friends)localObject6).uin))) {
                      break label5953;
                    }
                    ((Friends)localObject6).setShieldFlag(false);
                    ((ArrayList)localObject2).add(localObject6);
                    continue;
                    ((EntityTransaction)localObject2).commit();
                    ((EntityTransaction)localObject2).end();
                    continue;
                  }
                }
                finally
                {
                  ((EntityTransaction)localObject2).end();
                }
                QLog.d("tag_hidden_chat", 2, "0x5e0 size 0");
                continue;
                if ((!((Friends)localObject6).isShield()) && (((ConcurrentHashMap)localObject4).containsKey(((Friends)localObject6).uin)))
                {
                  ((Friends)localObject6).setShieldFlag(true);
                  ((ArrayList)localObject2).add(localObject6);
                }
              }
              i = 0;
              while (i < j)
              {
                if (arrayOfFriends[i] != null) {
                  ((ArrayList)localObject2).add(arrayOfFriends[i]);
                }
                i += 1;
              }
              Object localObject4 = new Friends[((ArrayList)localObject2).size()];
              ((ArrayList)localObject2).toArray((Object[])localObject4);
              if (QLog.isColorLevel()) {
                QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + j + " includeShield:" + localObject4.length);
              }
              localacff.a((Friends[])localObject4, localObject4.length);
              for (;;)
              {
                localObject4 = paramRspBody.rpt_msg_ProfileListResult.get();
                if (localObject4 == null) {
                  break label6386;
                }
                localObject2 = this.app.getPreferences().edit();
                localObject4 = ((List)localObject4).iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (Oidb_0x5e0.ProfileListResult)((Iterator)localObject4).next();
                  if ((((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.has()) && (((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.get() == 0))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ProfileService.CheckUpdateReq", 2, "get result =" + ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.get());
                    }
                    if ((((Oidb_0x5e0.ProfileListResult)localObject5).uint32_update_profile_id.has()) && (((Oidb_0x5e0.ProfileListResult)localObject5).uint32_new_content_timestamp.has()))
                    {
                      i = ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_update_profile_id.get();
                      j = ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_new_content_timestamp.get();
                      ((SharedPreferences.Editor)localObject2).putLong("inccheckupdatetimeStamp" + i, j);
                      if (QLog.isColorLevel()) {
                        QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody profileid:" + i + " uint32_new_content_timestamp =" + j);
                      }
                    }
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + j);
                }
                localacff.a(arrayOfFriends, j);
              }
              ((SharedPreferences.Editor)localObject2).commit();
              label6386:
              if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1))
              {
                this.b = null;
                this.app.a().hk.clear();
                this.app.a().bJ.set(0);
              }
              while (!paramRspBody.bytes_svrcontext.has()) {
                return;
              }
              this.b = paramRspBody.bytes_svrcontext.get();
              ((FriendListHandler)this.app.getBusinessHandler(1)).aW(false, 1);
              return;
              localObject2 = localObject5;
            }
          }
        }
      }
    }
  }
  
  public static boolean ay(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (!paramString1.equals(paramString2)) {
          bool1 = true;
        }
      }
    }
    if ((QLog.isColorLevel()) && (bool1)) {
      QLog.d("QQProfileItem", 2, "checkShouldUpdateDiscussinMemberInfoByName newFriendName = " + paramString1 + ",oldFriendName = " + paramString2 + ",result = " + bool1);
    }
    return bool1;
  }
  
  public static boolean az(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!paramString1.equals(paramString2)) {
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (TextUtils.isEmpty(paramString1))
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(paramString2)) {
        bool2 = true;
      }
    }
    if ((QLog.isColorLevel()) && (bool2)) {
      QLog.d("QQProfileItem", 2, "checkShouldUpdateDiscussinMemberInfoByRemark ,newRemark = " + paramString1 + ",oldRemark = " + paramString2 + ",result = " + bool2);
    }
    return bool2;
  }
  
  public static void b(long paramLong, String paramString, acdu paramacdu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoRemark uin = " + paramLong + ",remarkName = " + paramString);
    }
    Object localObject = paramacdu.getDiscussList();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
        DiscussionMemberInfo localDiscussionMemberInfo = paramacdu.a(localDiscussionInfo.uin, Long.toString(paramLong));
        if ((localDiscussionMemberInfo != null) && (az(paramString, localDiscussionMemberInfo.inteRemark)))
        {
          localDiscussionMemberInfo.inteRemark = paramString;
          if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoRemark discussMem.memberName = " + localDiscussionMemberInfo.memberName + ",discussMem.inteRemark = " + localDiscussionMemberInfo.inteRemark + ",discussionUin = " + localDiscussionInfo.uin);
          }
          localArrayList.add(localDiscussionMemberInfo);
        }
      }
      if (localArrayList.size() > 0)
      {
        paramacdu.iH(localArrayList);
        paramString = new HashMap();
        paramString.put("count", String.valueOf(localArrayList.size()));
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "updateDiscussMemberRemark", true, 0L, 0L, paramString, "", true);
      }
    }
  }
  
  public ReqItem a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::getCheckUpdateItemData called checkUpdateType:" + paramInt);
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 101;
    Object localObject1 = this.app.getPreferences();
    Object localObject2 = new long[19];
    int i = 0;
    while (i < 19)
    {
      localObject2[i] = (((SharedPreferences)localObject1).getLong("inccheckupdatetimeStamp" + Integer.toString(i), 0L) - 0L);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(50);
      i = 0;
      while (i < 19)
      {
        ((StringBuilder)localObject1).append(Long.toString(localObject2[i])).append(" ");
        i += 1;
      }
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject1).toString());
    }
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList2 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList2.uint32_need_content.set(0);
    localUpdateProfileList2.uint32_update_profile_id.set(1);
    localUpdateProfileList2.uint32_friendlist_type.set(1);
    localUpdateProfileList2.uint32_get_content_timestamp.set((int)localObject2[1]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList3 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList3.uint32_need_content.set(0);
    localUpdateProfileList3.uint32_update_profile_id.set(2);
    localUpdateProfileList3.uint32_friendlist_type.set(1);
    localUpdateProfileList3.uint32_get_content_timestamp.set((int)localObject2[2]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList4 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList4.uint32_need_content.set(0);
    localUpdateProfileList4.uint32_update_profile_id.set(3);
    localUpdateProfileList4.uint32_friendlist_type.set(0);
    localUpdateProfileList4.uint32_get_content_timestamp.set((int)localObject2[3]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList1 = null;
    if (!((FriendListHandler)this.app.getBusinessHandler(1)).ZX())
    {
      localObject1 = new Oidb_0x5e0.UpdateProfileList();
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_need_content.set(0);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_update_profile_id.set(13);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_friendlist_type.set(1);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_get_content_timestamp.set((int)localObject2[13]);
    }
    for (;;)
    {
      localUpdateProfileList1 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList1.uint32_need_content.set(0);
      localUpdateProfileList1.uint32_update_profile_id.set(5);
      localUpdateProfileList1.uint32_friendlist_type.set(0);
      localUpdateProfileList1.uint32_get_content_timestamp.set((int)localObject2[5]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList5 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList5.uint32_need_content.set(1);
      localUpdateProfileList5.uint32_update_profile_id.set(6);
      localUpdateProfileList5.uint32_friendlist_type.set(0);
      localUpdateProfileList5.uint32_get_content_timestamp.set((int)localObject2[6]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList6 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList6.uint32_need_content.set(0);
      localUpdateProfileList6.uint32_update_profile_id.set(7);
      localUpdateProfileList6.uint32_friendlist_type.set(1);
      localUpdateProfileList6.uint32_get_content_timestamp.set((int)localObject2[7]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList7 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList7.uint32_need_content.set(0);
      localUpdateProfileList7.uint32_update_profile_id.set(9);
      localUpdateProfileList7.uint32_friendlist_type.set(1);
      localUpdateProfileList7.uint32_get_content_timestamp.set((int)localObject2[9]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList8 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList8.uint32_need_content.set(0);
      localUpdateProfileList8.uint32_update_profile_id.set(10);
      localUpdateProfileList8.uint32_friendlist_type.set(1);
      localUpdateProfileList8.uint32_get_content_timestamp.set((int)localObject2[10]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList9 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList9.uint32_need_content.set(0);
      localUpdateProfileList9.uint32_update_profile_id.set(11);
      localUpdateProfileList9.uint32_friendlist_type.set(1);
      localUpdateProfileList9.uint32_get_content_timestamp.set((int)localObject2[11]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList10 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList10.uint32_need_content.set(0);
      localUpdateProfileList10.uint32_update_profile_id.set(12);
      localUpdateProfileList10.uint32_friendlist_type.set(1);
      localUpdateProfileList10.uint32_get_content_timestamp.set((int)localObject2[12]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList11 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList11.uint32_need_content.set(0);
      localUpdateProfileList11.uint32_update_profile_id.set(15);
      localUpdateProfileList11.uint32_friendlist_type.set(1);
      localUpdateProfileList11.uint32_get_content_timestamp.set((int)localObject2[15]);
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42003));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(41999));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42980));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27059));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27206));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27210));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42230));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27201));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(40530));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27254));
      Object localObject3 = (aczr)this.app.getManager(199);
      if ((localObject3 != null) && (((aczr)localObject3).adh()))
      {
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42099));
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(40556));
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(20015));
        if (QLog.isColorLevel()) {
          QLog.d("QQProfileItem", 2, "ClassicHeadActivity Params is add");
        }
      }
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27218));
      localObject3 = new Oidb_0x5e0.UpdateProfileList();
      ((Oidb_0x5e0.UpdateProfileList)localObject3).uint32_need_content.set(0);
      ((Oidb_0x5e0.UpdateProfileList)localObject3).uint32_update_profile_id.set(16);
      ((Oidb_0x5e0.UpdateProfileList)localObject3).uint32_friendlist_type.set(1);
      ((Oidb_0x5e0.UpdateProfileList)localObject3).uint32_get_content_timestamp.set((int)localObject2[16]);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdateItemData IDX_INTIMATE_FIELD_LIST time::" + (int)localObject2[16]);
      }
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList12 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList12.uint32_need_content.set(0);
      localUpdateProfileList12.uint32_update_profile_id.set(17);
      localUpdateProfileList12.uint32_friendlist_type.set(1);
      localUpdateProfileList12.uint32_get_content_timestamp.set((int)localObject2[17]);
      Object localObject4 = new Oidb_0xd50.ReqBody();
      ((Oidb_0xd50.ReqBody)localObject4).appid.set(10002L);
      ((Oidb_0xd50.ReqBody)localObject4).req_music_switch.set(1);
      ((Oidb_0xd50.ReqBody)localObject4).req_ksing_switch.set(1);
      ((Oidb_0xd50.ReqBody)localObject4).req_mutualmark_lbsshare.set(1);
      if (QLog.isColorLevel()) {
        QLog.d("QQProfileItem", 2, new Object[] { "getCheckUpdateItemData: invoked. ", " req lbs share profile. ", "此处很可能触发增量资料更新限频逻辑，会导致状态刷新不及时。（消息tab外显图标未刷新等等问题）" });
      }
      ((Oidb_0xd50.ReqBody)localObject4).req_mutualmark_alienation.set(1);
      localUpdateProfileList12.msg_0xd50_req.set((MessageMicro)localObject4);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdateItemData profileid:17, " + (int)localObject2[17]);
      }
      localObject4 = new Oidb_0x5e0.UpdateProfileList();
      ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_need_content.set(0);
      ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_update_profile_id.set(18);
      ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_friendlist_type.set(1);
      ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_get_content_timestamp.set((int)localObject2[18]);
      Oidb_0xd6b.ReqBody localReqBody = new Oidb_0xd6b.ReqBody();
      localReqBody.start_time.set((int)localObject2[18]);
      ((Oidb_0x5e0.UpdateProfileList)localObject4).msg_0xd6b_req.set(localReqBody);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdateItemData profileid:18, " + (int)localObject2[18]);
      }
      localObject2 = new Oidb_0x5e0.ReqBody();
      if (this.b != null) {
        ((Oidb_0x5e0.ReqBody)localObject2).bytes_svrcontext.set(this.b);
      }
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList2);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList3);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList4);
      if (localObject1 != null) {
        ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add((MessageMicro)localObject1);
      }
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList1);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList5);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList6);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList7);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList8);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList9);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList10);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList11);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add((MessageMicro)localObject3);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList12);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add((MessageMicro)localObject4);
      if (paramInt == 8) {
        ((Oidb_0x5e0.ReqBody)localObject2).uint32_forced_update.set(1);
      }
      localReqItem.vecParam = ((Oidb_0x5e0.ReqBody)localObject2).toByteArray();
      return localReqItem;
      localObject1 = localUpdateProfileList1;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileService.CheckUpdateReq", 2, "skip rich status check update");
        localObject1 = localUpdateProfileList1;
      }
    }
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateItemData called item.cResult = " + paramRespItem.cResult);
    }
    Object localObject;
    int i;
    if ((paramRespItem.eServiceID == 101) && (paramRespItem.cResult == 2))
    {
      paramRespItem = paramRespItem.vecUpdate;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handleCheckUpdateItemData pbdata.length=");
        if (paramRespItem == null) {
          break label121;
        }
        i = paramRespItem.length;
      }
    }
    for (;;)
    {
      QLog.d("QQProfileItem", 2, i);
      localObject = new Oidb_0x5e0.RspBody();
      try
      {
        paramRespItem = (Oidb_0x5e0.RspBody)((Oidb_0x5e0.RspBody)localObject).mergeFrom(paramRespItem);
        if (paramRespItem == null)
        {
          return;
          label121:
          i = 0;
        }
      }
      catch (Exception paramRespItem)
      {
        for (;;)
        {
          paramRespItem.printStackTrace();
          paramRespItem = null;
        }
        a(paramRespItem);
      }
    }
  }
  
  public int mT()
  {
    return 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackd
 * JD-Core Version:    0.7.0.1
 */