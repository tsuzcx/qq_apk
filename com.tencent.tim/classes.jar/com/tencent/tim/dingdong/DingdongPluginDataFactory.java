package com.tencent.tim.dingdong;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.ContentElement;
import com.trunk.Qworkflow.Qworkflow.RemindTimer;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.Workflow;
import com.trunk.Qworkflow.Qworkflow.WorkflowContent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DingdongPluginDataFactory
{
  public static ScheduleSummaryData a(Qworkflow.Text paramText)
  {
    if (paramText.enum_type.get() == 3)
    {
      ScheduleSummaryData localScheduleSummaryData;
      Qworkflow.Workflow localWorkflow;
      for (;;)
      {
        Object localObject;
        String str;
        try
        {
          localScheduleSummaryData = new ScheduleSummaryData();
          localWorkflow = new Qworkflow.Workflow();
          localWorkflow.mergeFrom(paramText.bytes_content.get().toByteArray());
          if (!localWorkflow.msg_workflow_content.rpt_content_list.has()) {
            break;
          }
          paramText = localWorkflow.msg_workflow_content.rpt_content_list.get().iterator();
          if (!paramText.hasNext()) {
            break;
          }
          localObject = (Qworkflow.ContentElement)paramText.next();
          if ((!((Qworkflow.ContentElement)localObject).bytes_userdef.has()) || (!((Qworkflow.ContentElement)localObject).rpt_text_list.has()) || (((Qworkflow.Text)((Qworkflow.ContentElement)localObject).rpt_text_list.get(0)).enum_type.get() != 0)) {
            continue;
          }
          str = ((Qworkflow.Text)((Qworkflow.ContentElement)localObject).rpt_text_list.get(0)).bytes_content.get().toStringUtf8();
          localObject = ((Qworkflow.ContentElement)localObject).bytes_userdef.get().toStringUtf8();
          if ("loc".equals(localObject))
          {
            localScheduleSummaryData.location = str;
            continue;
          }
          if (!"mark".equals(localObject)) {
            break label241;
          }
        }
        catch (Exception paramText)
        {
          QLog.e("DingdongPluginProtoHelper", 1, "parseScheduleNotificationSummaryMsg error(-1):" + paramText.toString() + ".");
          return null;
        }
        localScheduleSummaryData.mark = str;
        continue;
        label241:
        if ("title".equals(localObject)) {
          localScheduleSummaryData.title = str;
        }
      }
      if (localWorkflow.msg_remind_timer.has())
      {
        localScheduleSummaryData.beginTime = localWorkflow.msg_remind_timer.uint64_start_time.get();
        localScheduleSummaryData.endTime = localWorkflow.msg_remind_timer.uint64_end_time.get();
        localScheduleSummaryData.offsetTime = localWorkflow.msg_remind_timer.uint32_remind_offset.get();
      }
      return localScheduleSummaryData;
    }
    return null;
  }
  
  public static class ScheduleSummaryData
    implements Serializable
  {
    public String authorUin;
    public long beginTime;
    public long endTime;
    public boolean hasAlarm;
    public int hasFetchedDetail;
    public String id;
    public String location;
    public String mark;
    public int offsetTime;
    public ArrayList<Long> repeatRange;
    public int repeatType;
    public int specialFlag;
    public String title;
    public String todoId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.dingdong.DingdongPluginDataFactory
 * JD-Core Version:    0.7.0.1
 */