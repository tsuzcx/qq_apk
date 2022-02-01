package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x6cd.MessageRec;
import tencent.im.oidb.cmd0x6cd.RedpointInfo;
import tencent.im.oidb.cmd0x6cd.RepointExtraInfo;

public class RedTouchItem
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  public byte[] bytes;
  public String configVersion;
  public int count;
  public long curSeq;
  public List<RedTouchItemExtMsg> extMsgs = new ArrayList();
  public long fromId;
  public String icon;
  public boolean isClosed;
  public int lastRecvTime;
  public int passThroughLevel;
  public long receiveTime;
  public int redtouchType;
  public int taskId;
  public String tips;
  public boolean unReadFlag = true;
  public int validTimeRemained;
  
  public static RedTouchItem getRedTouchItem(cmd0x6cd.RedpointInfo paramRedpointInfo)
  {
    if ((paramRedpointInfo == null) || (!paramRedpointInfo.uint32_taskid.has()) || (!paramRedpointInfo.uint64_cur_seq.has())) {
      return null;
    }
    RedTouchItem localRedTouchItem = new RedTouchItem();
    int i;
    long l;
    label77:
    label101:
    label125:
    Object localObject1;
    label149:
    label173:
    label221:
    label246:
    Object localObject2;
    if (paramRedpointInfo.uint32_taskid.has())
    {
      i = paramRedpointInfo.uint32_taskid.get();
      localRedTouchItem.taskId = i;
      if (!paramRedpointInfo.uint64_cur_seq.has()) {
        break label504;
      }
      l = paramRedpointInfo.uint64_cur_seq.get();
      localRedTouchItem.curSeq = l;
      if (!paramRedpointInfo.enum_redpoint_type.has()) {
        break label509;
      }
      i = paramRedpointInfo.enum_redpoint_type.get();
      localRedTouchItem.redtouchType = i;
      if (!paramRedpointInfo.uint64_from_id.has()) {
        break label514;
      }
      l = paramRedpointInfo.uint64_from_id.get();
      localRedTouchItem.fromId = l;
      if (!paramRedpointInfo.uint32_last_recv_time.has()) {
        break label519;
      }
      i = paramRedpointInfo.uint32_last_recv_time.get();
      localRedTouchItem.lastRecvTime = i;
      if (!paramRedpointInfo.int32_remained_time.has()) {
        break label524;
      }
      i = paramRedpointInfo.int32_remained_time.get();
      localRedTouchItem.validTimeRemained = i;
      localRedTouchItem.receiveTime = System.currentTimeMillis();
      localRedTouchItem.configVersion = paramRedpointInfo.str_config_version.get();
      if (!paramRedpointInfo.msg_redpoint_extra_info.has()) {
        break label529;
      }
      localObject1 = (cmd0x6cd.RepointExtraInfo)paramRedpointInfo.msg_redpoint_extra_info.get();
      if (localObject1 != null)
      {
        if (!((cmd0x6cd.RepointExtraInfo)localObject1).uint32_count.has()) {
          break label535;
        }
        i = ((cmd0x6cd.RepointExtraInfo)localObject1).uint32_count.get();
        localRedTouchItem.count = i;
        if (!((cmd0x6cd.RepointExtraInfo)localObject1).str_icon_url.has()) {
          break label540;
        }
        localObject2 = ((cmd0x6cd.RepointExtraInfo)localObject1).str_icon_url.get();
        label273:
        localRedTouchItem.icon = ((String)localObject2);
        if (!((cmd0x6cd.RepointExtraInfo)localObject1).str_tips.has()) {
          break label547;
        }
        localObject2 = ((cmd0x6cd.RepointExtraInfo)localObject1).str_tips.get();
        label301:
        localRedTouchItem.tips = ((String)localObject2);
        if (!((cmd0x6cd.RepointExtraInfo)localObject1).bytes_data.has()) {
          break label554;
        }
        localObject1 = ((cmd0x6cd.RepointExtraInfo)localObject1).bytes_data.get().toByteArray();
        label332:
        localRedTouchItem.bytes = ((byte[])localObject1);
      }
      if ((!paramRedpointInfo.rpt_msg_unread_msg.has()) || (paramRedpointInfo.rpt_msg_unread_msg.get().size() <= 0)) {
        break label575;
      }
      localObject1 = paramRedpointInfo.rpt_msg_unread_msg.get().iterator();
      label378:
      if (!((Iterator)localObject1).hasNext()) {
        break label575;
      }
      paramRedpointInfo = (cmd0x6cd.MessageRec)((Iterator)localObject1).next();
      localObject2 = new RedTouchItemExtMsg();
      if (!paramRedpointInfo.uint64_seq.has()) {
        break label560;
      }
      l = paramRedpointInfo.uint64_seq.get();
      label426:
      ((RedTouchItemExtMsg)localObject2).seq = l;
      if (!paramRedpointInfo.uint32_time.has()) {
        break label565;
      }
      i = paramRedpointInfo.uint32_time.get();
      label450:
      ((RedTouchItemExtMsg)localObject2).time = i;
      if (!paramRedpointInfo.bytes_content.has()) {
        break label570;
      }
    }
    label514:
    label519:
    label524:
    label529:
    label535:
    label540:
    label547:
    label554:
    label560:
    label565:
    label570:
    for (paramRedpointInfo = paramRedpointInfo.bytes_content.get().toByteArray();; paramRedpointInfo = null)
    {
      ((RedTouchItemExtMsg)localObject2).bytesData = paramRedpointInfo;
      localRedTouchItem.extMsgs.add(localObject2);
      break label378;
      i = 0;
      break;
      label504:
      l = 0L;
      break label77;
      label509:
      i = 0;
      break label101;
      l = 0L;
      break label125;
      i = 0;
      break label149;
      i = 0;
      break label173;
      localObject1 = null;
      break label221;
      i = 0;
      break label246;
      localObject2 = "";
      break label273;
      localObject2 = "";
      break label301;
      localObject1 = null;
      break label332;
      l = 0L;
      break label426;
      i = 0;
      break label450;
    }
    label575:
    return localRedTouchItem;
  }
  
  public String toString()
  {
    return "RedTouchItem{hash=" + hashCode() + ", taskId=" + this.taskId + ", curSeq=" + this.curSeq + ", redtouchType=" + this.redtouchType + ", count=" + this.count + ", icon='" + this.icon + '\'' + ", tips='" + this.tips + '\'' + ", fromId=" + this.fromId + ", lastRecvTime=" + this.lastRecvTime + ", receiveTime=" + this.receiveTime + ", validTimeRemained=" + this.validTimeRemained + ", unReadFlag=" + this.unReadFlag + ", passThroughLevel=" + this.passThroughLevel + ", configVersion='" + this.configVersion + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedTouchItem
 * JD-Core Version:    0.7.0.1
 */