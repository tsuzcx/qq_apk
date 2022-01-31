package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7cb.CommentConfig;
import tencent.im.oidb.cmd0x7cb.ConfigItem;
import tencent.im.oidb.cmd0x7cb.DateRequest;
import tencent.im.oidb.cmd0x7cb.RspBody;

public class DatingConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String aioApllyTips = null;
  public String aioFirstTips = null;
  public List cancelReasons = null;
  public HashMap othersConfigs = null;
  public int timeGap = 0;
  public DatingConfigItem timeRequestConfig = null;
  public int timeStamp = 0;
  
  public static DatingConfig createDatingConfig(cmd0x7cb.RspBody paramRspBody)
  {
    DatingConfig localDatingConfig = new DatingConfig();
    localDatingConfig.timeStamp = paramRspBody.uint32_time_stamp.get();
    localDatingConfig.timeGap = paramRspBody.uint32_time_gap.get();
    localDatingConfig.aioApllyTips = paramRspBody.str_attend_tips_to_A.get();
    localDatingConfig.aioFirstTips = paramRspBody.str_first_msg_tips.get();
    Object localObject1 = new HashMap();
    Iterator localIterator = paramRspBody.rpt_comment_configs.get().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (cmd0x7cb.CommentConfig)localIterator.next();
      int i = ((cmd0x7cb.CommentConfig)localObject2).uint32_appoint_subject.get();
      Object localObject3 = ((cmd0x7cb.CommentConfig)localObject2).rpt_msg_configs.get();
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        cmd0x7cb.ConfigItem localConfigItem = (cmd0x7cb.ConfigItem)((Iterator)localObject3).next();
        ((List)localObject2).add(new DatingConfigItem(localConfigItem.uint32_id.get(), localConfigItem.str_config.get()));
      }
      ((HashMap)localObject1).put(Integer.valueOf(i), localObject2);
    }
    localDatingConfig.othersConfigs = ((HashMap)localObject1);
    localObject1 = new ArrayList();
    localIterator = paramRspBody.rpt_cancle_config.get().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (cmd0x7cb.ConfigItem)localIterator.next();
      ((List)localObject1).add(new DatingConfigItem(((cmd0x7cb.ConfigItem)localObject2).uint32_id.get(), ((cmd0x7cb.ConfigItem)localObject2).str_config.get()));
    }
    localDatingConfig.cancelReasons = ((List)localObject1);
    paramRspBody = (cmd0x7cb.DateRequest)paramRspBody.msg_date_request.get();
    if (paramRspBody != null) {
      localDatingConfig.timeRequestConfig = new DatingConfigItem(paramRspBody.uint32_time.get(), paramRspBody.str_err_msg.get());
    }
    return localDatingConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingConfig
 * JD-Core Version:    0.7.0.1
 */