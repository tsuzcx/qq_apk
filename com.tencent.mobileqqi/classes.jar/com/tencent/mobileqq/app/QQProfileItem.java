package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileListResult;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ReqBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.RspBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.UpdateProfileList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ValueBit;

public class QQProfileItem
  implements CheckUpdateItemInterface
{
  private static final int jdField_a_of_type_Int = 65535;
  private static final long jdField_a_of_type_Long = 4294967295L;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 6;
  private static final int h = 7;
  private static final int i = 8;
  private static final int j = 9;
  private static final int k = 10;
  private static final int l = 11;
  private QvipSpecialCareManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = null;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
  
  public QQProfileItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new String();
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, "len = " + paramInt);
    }
    int m = 0;
    while (m < paramInt)
    {
      int n = paramArrayOfByte[m];
      int i1 = paramArrayOfByte[m];
      String str = (String)localObject + "0123456789ABCDEF".charAt(n >> 4 & 0xF) + "" + "0123456789ABCDEF".charAt(i1 & 0xF) + " ";
      localObject = str;
      if ((m + 1) % 8 == 0)
      {
        str = str + " ";
        localObject = str;
        if ((m + 1) % 16 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(paramString, 2, str);
          }
          localObject = "";
        }
      }
      m += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, (String)localObject);
    }
  }
  
  private void a(Oidb_0x5e0.RspBody paramRspBody)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = paramRspBody.rpt_msg_contentItem.get();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(((List)localObject1).size());
    if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateRspBody called contentitemlist size = " + ((List)localObject1).size() + " overFlag:" + bool);
      }
      Friends[] arrayOfFriends = new Friends[((List)localObject1).size()];
      Object localObject6 = new ArrayList();
      int m;
      int n;
      long l1;
      Object localObject3;
      label597:
      label1262:
      long l2;
      if (localObject1 != null)
      {
        Iterator localIterator1 = ((List)localObject1).iterator();
        m = 0;
        n = m;
        if (!localIterator1.hasNext()) {
          break label2563;
        }
        localObject1 = (Oidb_0x5e0.ContentItem)localIterator1.next();
        if (((Oidb_0x5e0.ContentItem)localObject1).uint32_update_profile_id.has()) {}
        switch (((Oidb_0x5e0.ContentItem)localObject1).uint32_update_profile_id.get())
        {
        default: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          label1233:
          label1498:
          label1503:
          label1508:
          do
          {
            for (;;)
            {
              break;
              if (((Oidb_0x5e0.ContentItem)localObject1).msg_nicknamefiled.has())
              {
                localObject1 = (Oidb_0x5e0.NickNameFiled)((Oidb_0x5e0.ContentItem)localObject1).msg_nicknamefiled.get();
                n = m;
                if (localObject1 != null)
                {
                  n = m;
                  if (((Oidb_0x5e0.NickNameFiled)localObject1).uint64_uin.has())
                  {
                    l1 = ((Oidb_0x5e0.NickNameFiled)localObject1).uint64_uin.get();
                    localObject1 = ((Oidb_0x5e0.NickNameFiled)localObject1).bytes_value.get().toStringUtf8();
                    if (QLog.isColorLevel()) {
                      QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  Nick：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 昵称 = " + Utils.a((String)localObject1));
                    }
                    arrayOfFriends[m] = localFriendsManagerImp.a(l1 + "", (String)localObject1);
                    n = m + 1;
                  }
                }
                m = n;
                continue;
                if (((Oidb_0x5e0.ContentItem)localObject1).msg_genderfiled.has())
                {
                  localObject1 = (Oidb_0x5e0.GenderFiled)((Oidb_0x5e0.ContentItem)localObject1).msg_genderfiled.get();
                  l1 = ((Oidb_0x5e0.GenderFiled)localObject1).uint64_uin.get();
                  localObject3 = localFriendsManagerImp.a(l1 + "");
                  int i1;
                  if (localObject3 != null)
                  {
                    i1 = ((Oidb_0x5e0.GenderFiled)localObject1).uint32_gender.get();
                    if (i1 != 1) {
                      break label597;
                    }
                    n = 0;
                  }
                  for (;;)
                  {
                    ((Card)localObject3).shGender = ((short)n);
                    localFriendsManagerImp.a((Card)localObject3);
                    if (QLog.isColorLevel()) {
                      QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  sex: uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " sex = " + n);
                    }
                    break;
                    if (i1 == 2)
                    {
                      n = 1;
                    }
                    else
                    {
                      n = i1;
                      if (i1 == 0) {
                        n = 2;
                      }
                    }
                  }
                  if (((Oidb_0x5e0.ContentItem)localObject1).msg_friendremark.has())
                  {
                    localObject1 = (Oidb_0x5e0.FriendRemark)((Oidb_0x5e0.ContentItem)localObject1).msg_friendremark.get();
                    if ((localObject1 != null) && (((Oidb_0x5e0.FriendRemark)localObject1).uint64_uin.has()))
                    {
                      l1 = ((Oidb_0x5e0.FriendRemark)localObject1).uint64_uin.get();
                      localObject1 = ((Oidb_0x5e0.FriendRemark)localObject1).bytes_value.get().toStringUtf8();
                      if (QLog.isColorLevel()) {
                        QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate Remark：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 备注内容 = " + Utils.a((String)localObject1));
                      }
                      localFriendsManagerImp.a(l1 + "", (String)localObject1, (byte)1);
                    }
                    continue;
                    continue;
                    if (((Oidb_0x5e0.ContentItem)localObject1).msg_groupname.has())
                    {
                      localObject1 = (Oidb_0x5e0.GroupName)((Oidb_0x5e0.ContentItem)localObject1).msg_groupname.get();
                      if ((localObject1 != null) && (((Oidb_0x5e0.GroupName)localObject1).uint64_group_uin.has()))
                      {
                        l1 = ((Oidb_0x5e0.GroupName)localObject1).uint64_group_uin.get();
                        localObject1 = ((Oidb_0x5e0.GroupName)localObject1).bytes_value.get().toStringUtf8();
                        localObject3 = localFriendsManagerImp.a(l1 + "");
                        if (localObject3 != null)
                        {
                          ((TroopInfo)localObject3).troopname = ((String)localObject1);
                          ((ArrayList)localObject6).add(localObject3);
                          if (QLog.isColorLevel()) {
                            QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate TroopName：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 群名称内容 = " + Utils.a((String)localObject1));
                          }
                        }
                      }
                      continue;
                      if (((Oidb_0x5e0.ContentItem)localObject1).msg_friend_teamlist.has())
                      {
                        localObject1 = (Oidb_0x5e0.FriendTeamList)((Oidb_0x5e0.ContentItem)localObject1).msg_friend_teamlist.get();
                        if ((localObject1 != null) && (((Oidb_0x5e0.FriendTeamList)localObject1).uint32_update_flag.has()) && (((Oidb_0x5e0.FriendTeamList)localObject1).uint32_update_flag.get() == 1))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate GroupList：uin = ");
                          }
                          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true);
                        }
                        continue;
                        if (((Oidb_0x5e0.ContentItem)localObject1).msg_value_bit.has())
                        {
                          localObject1 = (Oidb_0x5e0.ValueBit)((Oidb_0x5e0.ContentItem)localObject1).msg_value_bit.get();
                          n = m;
                          int i3;
                          int i2;
                          int i4;
                          if (localObject1 != null)
                          {
                            n = m;
                            if (((Oidb_0x5e0.ValueBit)localObject1).uint64_uin.has())
                            {
                              l1 = ((Oidb_0x5e0.ValueBit)localObject1).uint64_uin.get();
                              localObject3 = localFriendsManagerImp.c(Long.toString(l1));
                              i3 = 0;
                              i2 = 0;
                              i1 = 0;
                              if (localObject3 != null)
                              {
                                i3 = ((Friends)localObject3).qqVipInfo;
                                i2 = ((Friends)localObject3).superQqInfo;
                                i1 = ((Friends)localObject3).superVipInfo;
                              }
                              if ((((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().size() >= 3))
                              {
                                n = ((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().byteAt(0);
                                i4 = ((Oidb_0x5e0.ValueBit)localObject1).bytes_identity_flag.get().byteAt(2);
                                if (localObject3 != null)
                                {
                                  int i5 = ((Friends)localObject3).qqVipInfo;
                                  if ((n & 0xFC) == 0) {
                                    break label1498;
                                  }
                                  n = 1;
                                  ((Friends)localObject3).qqVipInfo = (n << 24 | i5);
                                  i5 = ((Friends)localObject3).qqVipInfo;
                                  if ((i4 & 0x60) == 0) {
                                    break label1503;
                                  }
                                  n = 1;
                                  ((Friends)localObject3).qqVipInfo = (n << 24 | i5);
                                }
                              }
                              if ((((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.get().size() >= 5))
                              {
                                n = ((Oidb_0x5e0.ValueBit)localObject1).bytes_ext_flag.get().byteAt(5);
                                if (localObject3 != null)
                                {
                                  i4 = ((Friends)localObject3).superVipInfo;
                                  if ((n & 0x20) == 0) {
                                    break label1508;
                                  }
                                }
                              }
                            }
                          }
                          for (n = 1;; n = 0)
                          {
                            ((Friends)localObject3).superVipInfo = (n << 24 | i4);
                            n = m;
                            if (localObject3 != null) {
                              if ((((Friends)localObject3).superVipInfo == i1) && (((Friends)localObject3).qqVipInfo == i3))
                              {
                                n = m;
                                if (((Friends)localObject3).superQqInfo == i2) {}
                              }
                              else
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d("ProfileService.CheckUpdateReq", 2, "find a vip user uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " superVipInfo = " + ((Friends)localObject3).superVipInfo + " qqVipInfo = " + ((Friends)localObject3).qqVipInfo + " superQqInfo = " + ((Friends)localObject3).superQqInfo);
                                }
                                arrayOfFriends[m] = localObject3;
                                n = m + 1;
                              }
                            }
                            m = n;
                            break;
                            n = 0;
                            break label1233;
                            n = 0;
                            break label1262;
                          }
                          if (((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.has())
                          {
                            localObject1 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.get();
                            n = m;
                            if (localObject1 != null)
                            {
                              n = m;
                              if (((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.has())
                              {
                                localObject1 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject1).bytes_value.get().toByteArray());
                                n = m;
                                if (((ByteBuffer)localObject1).remaining() > 8)
                                {
                                  l1 = ((ByteBuffer)localObject1).getInt();
                                  l2 = ((ByteBuffer)localObject1).getInt();
                                  localObject3 = new byte[((ByteBuffer)localObject1).getShort() & 0xFFFF];
                                  ((ByteBuffer)localObject1).get((byte[])localObject3);
                                  arrayOfFriends[m] = localFriendsManagerImp.a(Long.toString(l1 & 0xFFFFFFFF), (byte[])localObject3, l2 & 0xFFFFFFFF);
                                  n = m + 1;
                                }
                              }
                            }
                            m = n;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          } while (!((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.has());
          localObject3 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject1).msg_general_buffer.get();
          if ((localObject3 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.has()))
          {
            localObject1 = new Oidb_0x5d0.SnsUpateBuffer();
            if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          break;
        }
      }
      for (;;)
      {
        Object localObject5;
        try
        {
          ((Oidb_0x5d0.SnsUpateBuffer)localObject1).mergeFrom(((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.get().toByteArray());
          if ((localObject1 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject1).uint64_uin.has()) && (((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_uin32_idlist.has()))
          {
            Iterator localIterator2 = ((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_uin32_idlist.get().iterator();
            if (!localIterator2.hasNext()) {
              break label2063;
            }
            if (((Integer)localIterator2.next()).intValue() != 4051) {
              continue;
            }
            localObject5 = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject1).uint64_uin.get());
            if (QLog.isColorLevel())
            {
              if (((String)localObject5).length() < 4) {
                break label3284;
              }
              localObject3 = ((String)localObject5).substring(((String)localObject5).length() - 4);
              QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit : shd: " + (String)localObject3);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject5, localObject5);
            continue;
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject2 = null;
          continue;
          if ((localObject2 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject2).uint64_uin.has()) && (((Oidb_0x5d0.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.has()))
          {
            localObject3 = ((Oidb_0x5d0.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.get().iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject3).next();
              if ((localObject5 == null) || (!((Oidb_0x5d0.SnsUpdateItem)localObject5).uint32_update_sns_type.has()) || (!((Oidb_0x5d0.SnsUpdateItem)localObject5).bytes_value.has()) || (((Oidb_0x5d0.SnsUpdateItem)localObject5).uint32_update_sns_type.get() != 13568)) {
                continue;
              }
              l1 = ((Oidb_0x5d0.SnsUpateBuffer)localObject2).uint64_uin.get();
              localObject5 = ((Oidb_0x5d0.SnsUpdateItem)localObject5).bytes_value.get().toStringUtf8();
              this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(String.valueOf(l1), (String)localObject5);
              continue;
            }
          }
        }
        label2063:
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
            localObject3 = localFriendsManagerImp.a(String.valueOf(l1));
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new ExtensionInfo();
              ((ExtensionInfo)localObject2).uin = String.valueOf(l1);
            }
            ((ExtensionInfo)localObject2).pendantId = l2;
            ((ExtensionInfo)localObject2).timestamp = System.currentTimeMillis();
            localFriendsManagerImp.a((ExtensionInfo)localObject2);
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
            n = ((ByteBuffer)localObject2).getInt();
            localObject3 = localFriendsManagerImp.a(String.valueOf(l1));
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new ExtensionInfo();
              ((ExtensionInfo)localObject2).uin = String.valueOf(l1);
            }
            if (((ExtensionInfo)localObject2).uVipFont != n)
            {
              ((ExtensionInfo)localObject2).uVipFont = n;
              ((ExtensionInfo)localObject2).timestamp = System.currentTimeMillis();
              localFriendsManagerImp.a((ExtensionInfo)localObject2);
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Font, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + n);
            }
          }
        }
        break;
        n = 0;
        label2563:
        if (((ArrayList)localObject6).size() > 0) {
          localObject2 = localFriendsManagerImp.a();
        }
        for (;;)
        {
          try
          {
            ((EntityTransaction)localObject2).a();
            localObject3 = ((ArrayList)localObject6).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localFriendsManagerImp.b((TroopInfo)((Iterator)localObject3).next());
              continue;
            }
            if (((Friends)localObject6).isShield()) {
              continue;
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            ((EntityTransaction)localObject2).b();
            if ((!bool) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)) {
              break label3106;
            }
            localObject5 = localFriendsManagerImp.b();
            localObject2 = new ArrayList();
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
            localObject5 = ((ArrayList)localObject5).iterator();
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject6 = (Friends)((Iterator)localObject5).next();
            if ((((Friends)localObject6).isShield()) && (!((ConcurrentHashMap)localObject4).containsKey(((Friends)localObject6).uin)))
            {
              ((Friends)localObject6).setShieldFlag(false);
              ((ArrayList)localObject2).add(localObject6);
              continue;
              ((EntityTransaction)localObject2).c();
              ((EntityTransaction)localObject2).b();
              continue;
            }
          }
          finally
          {
            ((EntityTransaction)localObject2).b();
          }
          if (((ConcurrentHashMap)localObject4).containsKey(((Friends)localObject6).uin))
          {
            ((Friends)localObject6).setShieldFlag(true);
            ((ArrayList)localObject2).add(localObject6);
          }
        }
        m = 0;
        while (m < n)
        {
          if (arrayOfFriends[m] != null) {
            ((ArrayList)localObject2).add(arrayOfFriends[m]);
          }
          m += 1;
        }
        Object localObject4 = new Friends[((ArrayList)localObject2).size()];
        ((ArrayList)localObject2).toArray((Object[])localObject4);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + n + " includeShield:" + localObject4.length);
        }
        localFriendsManagerImp.a((Friends[])localObject4, localObject4.length);
        for (;;)
        {
          localObject2 = paramRspBody.rpt_msg_ProfileListResult.get();
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (Oidb_0x5e0.ProfileListResult)((Iterator)localObject2).next();
            if ((((Oidb_0x5e0.ProfileListResult)localObject4).uint32_result.has()) && (((Oidb_0x5e0.ProfileListResult)localObject4).uint32_result.get() == 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileService.CheckUpdateReq", 2, "get result =" + ((Oidb_0x5e0.ProfileListResult)localObject4).uint32_result.get());
              }
              if ((((Oidb_0x5e0.ProfileListResult)localObject4).uint32_update_profile_id.has()) && (((Oidb_0x5e0.ProfileListResult)localObject4).uint32_new_content_timestamp.has()))
              {
                m = ((Oidb_0x5e0.ProfileListResult)localObject4).uint32_update_profile_id.get();
                n = ((Oidb_0x5e0.ProfileListResult)localObject4).uint32_new_content_timestamp.get();
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + m, n).commit();
              }
            }
          }
          label3106:
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + n);
          }
          localFriendsManagerImp.a(arrayOfFriends, n);
        }
        if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1))
        {
          this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
          return;
        }
        if (paramRspBody.bytes_svrcontext.has())
        {
          this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramRspBody.bytes_svrcontext.get();
          paramRspBody = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(110));
          paramRspBody.a(false, 1);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
        return;
        label3284:
        localObject4 = localObject5;
      }
    }
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::getCheckUpdateItemData called");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 101;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject1 = new long[11];
    int m = 0;
    while (m < 11)
    {
      localObject1[m] = ((SharedPreferences)localObject2).getLong("inccheckupdatetimeStamp" + Integer.toString(m), 0L);
      m += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder(50);
      m = 0;
      while (m < 11)
      {
        ((StringBuilder)localObject2).append(Long.toString(localObject1[m])).append(" ");
        m += 1;
      }
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new Oidb_0x5e0.UpdateProfileList();
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_need_content.set(0);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_update_profile_id.set(1);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_friendlist_type.set(1);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_get_content_timestamp.set((int)localObject1[1]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList1 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList1.uint32_need_content.set(0);
    localUpdateProfileList1.uint32_update_profile_id.set(2);
    localUpdateProfileList1.uint32_friendlist_type.set(1);
    localUpdateProfileList1.uint32_get_content_timestamp.set((int)localObject1[2]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList2 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList2.uint32_need_content.set(0);
    localUpdateProfileList2.uint32_update_profile_id.set(3);
    localUpdateProfileList2.uint32_friendlist_type.set(0);
    localUpdateProfileList2.uint32_get_content_timestamp.set((int)localObject1[3]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList3 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList3.uint32_need_content.set(0);
    localUpdateProfileList3.uint32_update_profile_id.set(8);
    localUpdateProfileList3.uint32_friendlist_type.set(1);
    localUpdateProfileList3.uint32_get_content_timestamp.set((int)localObject1[8]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList4 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList4.uint32_need_content.set(0);
    localUpdateProfileList4.uint32_update_profile_id.set(5);
    localUpdateProfileList4.uint32_friendlist_type.set(0);
    localUpdateProfileList4.uint32_get_content_timestamp.set((int)localObject1[5]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList5 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList5.uint32_need_content.set(1);
    localUpdateProfileList5.uint32_update_profile_id.set(6);
    localUpdateProfileList5.uint32_friendlist_type.set(0);
    localUpdateProfileList5.uint32_get_content_timestamp.set((int)localObject1[6]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList6 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList6.uint32_need_content.set(0);
    localUpdateProfileList6.uint32_update_profile_id.set(7);
    localUpdateProfileList6.uint32_friendlist_type.set(1);
    localUpdateProfileList6.uint32_get_content_timestamp.set((int)localObject1[7]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList7 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList7.uint32_need_content.set(0);
    localUpdateProfileList7.uint32_update_profile_id.set(9);
    localUpdateProfileList7.uint32_friendlist_type.set(1);
    localUpdateProfileList7.uint32_get_content_timestamp.set((int)localObject1[9]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList8 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList8.uint32_need_content.set(0);
    localUpdateProfileList8.uint32_update_profile_id.set(10);
    localUpdateProfileList8.uint32_friendlist_type.set(1);
    localUpdateProfileList8.uint32_get_content_timestamp.set((int)localObject1[10]);
    localObject1 = new Oidb_0x5e0.ReqBody();
    if (this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro != null) {
      ((Oidb_0x5e0.ReqBody)localObject1).bytes_svrcontext.set(this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro);
    }
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add((MessageMicro)localObject2);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList1);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList2);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList3);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList4);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList5);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList6);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList7);
    ((Oidb_0x5e0.ReqBody)localObject1).rpt_msg_update_profile_list.add(localUpdateProfileList8);
    localReqItem.vecParam = ((Oidb_0x5e0.ReqBody)localObject1).toByteArray();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateItemData called item.cResult = " + paramRespItem.cResult);
    }
    Oidb_0x5e0.RspBody localRspBody;
    if ((paramRespItem.eServiceID == 101) && (paramRespItem.cResult == 2))
    {
      paramRespItem = paramRespItem.vecUpdate;
      localRspBody = new Oidb_0x5e0.RspBody();
    }
    try
    {
      paramRespItem = (Oidb_0x5e0.RspBody)localRspBody.mergeFrom(paramRespItem);
      if (paramRespItem == null) {
        return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQProfileItem
 * JD-Core Version:    0.7.0.1
 */