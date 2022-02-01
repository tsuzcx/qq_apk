package com.tencent.tim.dingdong;

import atni;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.Timespan;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class MessageForDingdongSchedule
  extends ChatMessage
{
  @notColumn
  public long changedBeginTime;
  @notColumn
  public long changedEndTime;
  @notColumn
  public boolean isPartRecall;
  @notColumn
  public int notificationType;
  @notColumn
  protected DingdongPluginDataFactory.ScheduleSummaryData summaryData;
  
  private String getTipsByType(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = localQQAppInterface.getApplication().getString(2131692789);
    if (6 == this.notificationType) {
      return localQQAppInterface.getApplication().getString(2131719197);
    }
    if (4 == this.notificationType) {
      return localQQAppInterface.getApplication().getString(2131719196);
    }
    return str;
  }
  
  public boolean canShowInAIO()
  {
    return (5 == this.notificationType) || (6 == this.notificationType) || (4 == this.notificationType) || (3 == this.notificationType) || (2 == this.notificationType);
  }
  
  public void doParse()
  {
    Qworkflow.ScheduleChangeNotification localScheduleChangeNotification = new Qworkflow.ScheduleChangeNotification();
    Object localObject;
    try
    {
      localScheduleChangeNotification.mergeFrom(this.msgData);
      this.notificationType = localScheduleChangeNotification.enum_change_type.get();
      this.summaryData = DingdongPluginDataFactory.a((Qworkflow.Text)localScheduleChangeNotification.msg_summary.get());
      this.summaryData.repeatType = localScheduleChangeNotification.enum_repeated_type.get();
      if (localScheduleChangeNotification.msg_changed_timespan.has())
      {
        this.changedBeginTime = localScheduleChangeNotification.msg_changed_timespan.uint64_start_time.get();
        this.changedEndTime = localScheduleChangeNotification.msg_changed_timespan.uint64_end_time.get();
      }
      if ((this.summaryData.repeatType <= 1) || (!localScheduleChangeNotification.msg_changed_timespan.has())) {
        break label643;
      }
      localObject = localScheduleChangeNotification.rpt_msg_repeated_effective_timespan.get();
      this.summaryData.repeatRange = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Qworkflow.Timespan localTimespan = (Qworkflow.Timespan)((Iterator)localObject).next();
        this.summaryData.repeatRange.add(Long.valueOf(localTimespan.uint64_start_time.get()));
        this.summaryData.repeatRange.add(Long.valueOf(localTimespan.uint64_end_time.get()));
        continue;
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(MessageForDingdongSchedule.class.getSimpleName(), 1, "doParse error:" + localException.toString() + ".");
    }
    long l1;
    if ((this.changedEndTime == -1L) && (this.summaryData.repeatRange.size() > 0))
    {
      l1 = ((Long)this.summaryData.repeatRange.get(this.summaryData.repeatRange.size() - 1)).longValue();
      if (l1 == -1L) {
        break label692;
      }
      if (atni.a(this.summaryData.repeatRange, this.summaryData.repeatType, this.summaryData.beginTime, NetConnInfoCenter.getServerTimeMillis(), l1)) {
        break label692;
      }
    }
    for (;;)
    {
      if ((this.changedEndTime == -1L) && (i != 0)) {
        if ((this.summaryData.repeatRange != null) && (this.summaryData.repeatRange.size() > 0))
        {
          this.notificationType = 6;
          this.isPartRecall = true;
        }
      }
      for (;;)
      {
        this.summaryData.id = localException.bytes_workflow_id.get().toStringUtf8();
        this.summaryData.authorUin = String.valueOf(localException.uint64_author_uin.get());
        if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          break;
        }
        if (((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin().equals(this.summaryData.authorUin)) {
          this.issend = 1;
        }
        this.msg = (getTipsByType(this.notificationType) + this.summaryData.title);
        return;
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTimeInMillis(this.summaryData.beginTime);
        ((Calendar)localObject).set(11, 0);
        ((Calendar)localObject).set(12, 0);
        ((Calendar)localObject).set(13, 0);
        ((Calendar)localObject).set(14, 0);
        l1 = this.summaryData.beginTime - ((Calendar)localObject).getTimeInMillis();
        long l2 = this.summaryData.endTime;
        long l3 = this.summaryData.beginTime;
        this.summaryData.beginTime = (this.changedBeginTime + l1);
        this.summaryData.endTime = (l1 + this.changedBeginTime + (l2 - l3));
        continue;
        label643:
        if (this.summaryData.repeatType == 1)
        {
          this.summaryData.beginTime = localException.uint64_start_time.get();
          this.summaryData.endTime = localException.uint64_end_time.get();
        }
      }
      int i = 0;
      continue;
      label692:
      i = 1;
    }
  }
  
  public DingdongPluginDataFactory.ScheduleSummaryData getSummaryData()
  {
    if (!this.mIsParsed) {
      doParse();
    }
    if (this.summaryData == null) {
      this.summaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
    }
    return this.summaryData;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite() {}
  
  public void scheduleC2CdataReport()
  {
    if (5 == this.notificationType) {
      atni.gN("0X8006528", 1);
    }
    if (6 == this.notificationType) {
      atni.gN("0X8006529", 1);
    }
    if (4 == this.notificationType) {
      atni.gN("0X800652A", 1);
    }
    if (3 == this.notificationType) {
      atni.gN("0X800652A", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.dingdong.MessageForDingdongSchedule
 * JD-Core Version:    0.7.0.1
 */