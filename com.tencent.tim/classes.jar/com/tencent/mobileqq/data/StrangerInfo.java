package com.tencent.mobileqq.data;

import android.text.TextUtils;
import android.util.Base64;
import appoint.define.appoint_define.CommonLabel;
import appoint.define.appoint_define.PublisherInfo;
import aqmu;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StrangerInfo
  extends Entity
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  public int age;
  public int charm;
  public int charmLevel;
  public int chatFlag;
  public int chatupCount;
  public String constellation;
  public String distance;
  public int gender;
  public int godFlag;
  public String interestNameStr;
  @notColumn
  public ArrayList<String> interestNames = new ArrayList();
  public String interestTypeStr;
  @notColumn
  public ArrayList<Integer> interestTypes = new ArrayList();
  @notColumn
  public boolean isNewVisitor;
  public int lableId;
  public byte[] lableMsgLast;
  public byte[] lableMsgPre;
  public int marriage;
  public String nickName;
  public int profession;
  public int pubNumber;
  public int recentVisitorTime;
  public int recommend;
  public byte[] strangerDeclare;
  @notColumn
  public String timeStr;
  public long tinyId;
  public long uin;
  public String vipInfo;
  
  public static StrangerInfo convertFrom(appoint_define.PublisherInfo paramPublisherInfo)
  {
    long l2 = 0L;
    JSONObject localJSONObject1 = null;
    int j = 0;
    if (paramPublisherInfo == null) {
      return null;
    }
    StrangerInfo localStrangerInfo = new StrangerInfo();
    int i;
    label65:
    label89:
    label113:
    Object localObject1;
    label137:
    label162:
    label188:
    label213:
    label237:
    long l1;
    if (paramPublisherInfo.uint32_age.has())
    {
      i = paramPublisherInfo.uint32_age.get();
      localStrangerInfo.age = i;
      if (!paramPublisherInfo.uint32_charm.has()) {
        break label747;
      }
      i = paramPublisherInfo.uint32_charm.get();
      localStrangerInfo.charm = i;
      if (!paramPublisherInfo.uint32_charm_level.has()) {
        break label752;
      }
      i = paramPublisherInfo.uint32_charm_level.get();
      localStrangerInfo.charmLevel = i;
      if (!paramPublisherInfo.uint32_chatflag.has()) {
        break label757;
      }
      i = paramPublisherInfo.uint32_chatflag.get();
      localStrangerInfo.chatFlag = i;
      if (!paramPublisherInfo.uint32_chatup_count.has()) {
        break label762;
      }
      i = paramPublisherInfo.uint32_chatup_count.get();
      localStrangerInfo.chatupCount = i;
      if (!paramPublisherInfo.str_constellation.has()) {
        break label767;
      }
      localObject1 = paramPublisherInfo.str_constellation.get();
      localStrangerInfo.constellation = ((String)localObject1);
      if (!paramPublisherInfo.str_distance.has()) {
        break label775;
      }
      localObject1 = paramPublisherInfo.str_distance.get();
      localStrangerInfo.distance = ((String)localObject1);
      if (!paramPublisherInfo.uint32_gender.has()) {
        break label783;
      }
      i = paramPublisherInfo.uint32_gender.get();
      localStrangerInfo.gender = i;
      if (!paramPublisherInfo.uint32_godflag.has()) {
        break label788;
      }
      i = paramPublisherInfo.uint32_godflag.get();
      localStrangerInfo.godFlag = i;
      if (!paramPublisherInfo.uint64_tinyid.has()) {
        break label793;
      }
      l1 = paramPublisherInfo.uint64_tinyid.get();
      label261:
      localStrangerInfo.tinyId = l1;
      if (!paramPublisherInfo.bytes_nickname.has()) {
        break label798;
      }
      localObject1 = paramPublisherInfo.bytes_nickname.get().toStringUtf8();
      label289:
      localStrangerInfo.nickName = ((String)localObject1);
      if (!paramPublisherInfo.uint32_marriage.has()) {
        break label806;
      }
      i = paramPublisherInfo.uint32_marriage.get();
      label314:
      localStrangerInfo.marriage = i;
      if (!paramPublisherInfo.uint32_profession.has()) {
        break label811;
      }
      i = paramPublisherInfo.uint32_profession.get();
      label338:
      localStrangerInfo.profession = i;
      if (!paramPublisherInfo.uint32_recent_vistor_time.has()) {
        break label816;
      }
      i = paramPublisherInfo.uint32_recent_vistor_time.get();
      label362:
      localStrangerInfo.recentVisitorTime = i;
      if (!paramPublisherInfo.str_vipinfo.has()) {
        break label821;
      }
      localObject1 = paramPublisherInfo.str_vipinfo.get();
      label387:
      localStrangerInfo.vipInfo = ((String)localObject1);
      if (!paramPublisherInfo.uint32_recommend.has()) {
        break label829;
      }
      i = paramPublisherInfo.uint32_recommend.get();
      label412:
      localStrangerInfo.recommend = i;
      if (!paramPublisherInfo.uint32_pub_number.has()) {
        break label834;
      }
      i = paramPublisherInfo.uint32_pub_number.get();
      label436:
      localStrangerInfo.pubNumber = i;
      l1 = l2;
      if (paramPublisherInfo.uint64_friend_uin.has()) {
        l1 = paramPublisherInfo.uint64_friend_uin.get();
      }
      localStrangerInfo.uin = l1;
      if (!paramPublisherInfo.bytes_stranger_declare.has()) {
        break label839;
      }
      localObject1 = Base64.decode(paramPublisherInfo.bytes_stranger_declare.get().toByteArray(), 0);
      label495:
      localStrangerInfo.strangerDeclare = ((byte[])localObject1);
      if ((!paramPublisherInfo.uint32_history_flag.has()) || (paramPublisherInfo.uint32_history_flag.get() != 1)) {
        break label845;
      }
      localStrangerInfo.isNewVisitor = false;
      label529:
      if (!paramPublisherInfo.msg_common_label.has()) {
        break label854;
      }
      paramPublisherInfo = (appoint_define.CommonLabel)paramPublisherInfo.msg_common_label.get();
      label550:
      if (paramPublisherInfo == null) {
        break label1054;
      }
      i = j;
      if (paramPublisherInfo.uint32_lable_id.has()) {
        i = paramPublisherInfo.uint32_lable_id.get();
      }
      localStrangerInfo.lableId = i;
      if (!paramPublisherInfo.bytes_lable_msg_pre.has()) {
        break label859;
      }
      localObject1 = paramPublisherInfo.bytes_lable_msg_pre.get().toByteArray();
      label602:
      localStrangerInfo.lableMsgPre = ((byte[])localObject1);
      if (!paramPublisherInfo.bytes_lable_msg_last.has()) {
        break label865;
      }
      localObject1 = paramPublisherInfo.bytes_lable_msg_last.get().toByteArray();
      label631:
      localStrangerInfo.lableMsgLast = ((byte[])localObject1);
      if (!paramPublisherInfo.rpt_interst_name.has()) {
        break label871;
      }
      localObject1 = paramPublisherInfo.rpt_interst_name.get();
    }
    label657:
    Object localObject2;
    JSONObject localJSONObject2;
    JSONArray localJSONArray;
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        localJSONObject2 = new JSONObject();
        localJSONArray = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            String str = ((ByteStringMicro)((Iterator)localObject1).next()).toStringUtf8();
            ((ArrayList)localObject2).add(str);
            localJSONArray.put(str);
            continue;
            i = 0;
            break;
            label747:
            i = 0;
            break label65;
            label752:
            i = 0;
            break label89;
            label757:
            i = 0;
            break label113;
            label762:
            i = 0;
            break label137;
            label767:
            localObject1 = "";
            break label162;
            label775:
            localObject1 = "";
            break label188;
            label783:
            i = 0;
            break label213;
            label788:
            i = 0;
            break label237;
            label793:
            l1 = 0L;
            break label261;
            label798:
            localObject1 = "";
            break label289;
            label806:
            i = 0;
            break label314;
            label811:
            i = 0;
            break label338;
            label816:
            i = 0;
            break label362;
            label821:
            localObject1 = "";
            break label387;
            label829:
            i = 0;
            break label412;
            label834:
            i = 0;
            break label436;
            label839:
            localObject1 = null;
            break label495;
            label845:
            localStrangerInfo.isNewVisitor = true;
            break label529;
            label854:
            paramPublisherInfo = null;
            break label550;
            label859:
            localObject1 = null;
            break label602;
            label865:
            localObject1 = null;
            break label631;
            label871:
            localObject1 = null;
            break label657;
          }
        }
        localStrangerInfo.interestNames = ((ArrayList)localObject2);
      }
    }
    try
    {
      localJSONObject2.put("interestNames", localJSONArray);
      localStrangerInfo.interestNameStr = localJSONObject2.toString();
      localObject1 = localJSONObject1;
      if (paramPublisherInfo.rpt_interst_type.has()) {
        localObject1 = paramPublisherInfo.rpt_interst_type.get();
      }
      if (localObject1 != null)
      {
        paramPublisherInfo = new ArrayList();
        localJSONObject1 = new JSONObject();
        localObject2 = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          i = ((Integer)((Iterator)localObject1).next()).intValue();
          paramPublisherInfo.add(Integer.valueOf(i));
          ((JSONArray)localObject2).put(i);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException.printStackTrace();
        }
      }
      localStrangerInfo.interestTypes = paramPublisherInfo;
    }
    try
    {
      localJSONObject1.put("interestTypes", localObject2);
      localStrangerInfo.interestTypeStr = localJSONObject1.toString();
      label1054:
      if (localStrangerInfo.recentVisitorTime > 0)
      {
        paramPublisherInfo = aqmu.a(localStrangerInfo.recentVisitorTime * 1000L, true, "yyyy-MM-dd");
        localStrangerInfo.timeStr = paramPublisherInfo;
        return localStrangerInfo;
      }
    }
    catch (JSONException paramPublisherInfo)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          paramPublisherInfo.printStackTrace();
          continue;
          paramPublisherInfo = "";
        }
      }
    }
  }
  
  public void postRead()
  {
    super.postRead();
    if (this.recentVisitorTime > 0) {
      this.timeStr = aqmu.a(this.recentVisitorTime * 1000L, true, "yyyy-MM-dd");
    }
    int i;
    if (!TextUtils.isEmpty(this.interestNameStr)) {
      try
      {
        JSONArray localJSONArray1 = new JSONObject(this.interestNameStr).getJSONArray("interestNames");
        if (localJSONArray1 != null)
        {
          i = 0;
          while (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            if (!TextUtils.isEmpty(str)) {
              this.interestNames.add(str);
            }
            i += 1;
          }
        }
        if (TextUtils.isEmpty(this.interestTypeStr)) {
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException1.printStackTrace();
        }
      }
    } else {
      try
      {
        JSONArray localJSONArray2 = new JSONObject(this.interestTypeStr).getJSONArray("interestTypes");
        if (localJSONArray2 != null)
        {
          i = 0;
          while (i < localJSONArray2.length())
          {
            this.interestTypes.add(Integer.valueOf(localJSONArray2.getInt(i)));
            i += 1;
          }
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (Class localClass = getClass(); localClass != Entity.class; localClass = localClass.getSuperclass())
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfField[i];
        if (Modifier.isStatic(((Field)localObject).getModifiers())) {}
        for (;;)
        {
          i += 1;
          break;
          if (!((Field)localObject).isAccessible()) {
            ((Field)localObject).setAccessible(true);
          }
          String str = ((Field)localObject).getName();
          try
          {
            localObject = ((Field)localObject).get(this);
            localStringBuilder.append(',');
            localStringBuilder.append(str);
            localStringBuilder.append('=');
            localStringBuilder.append(localObject);
          }
          catch (Exception localException) {}
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.StrangerInfo
 * JD-Core Version:    0.7.0.1
 */