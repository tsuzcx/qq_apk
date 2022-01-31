package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class ChatBackgroundUpdateHandler
  extends BusinessHandler
{
  public static final int a = 8;
  public static final String a = "ChatBackgroundUpdateHandler";
  public static final String b = "last_pull_chatbackground_content_update_time";
  public static final String c = "";
  protected QQAppInterface b;
  
  protected ChatBackgroundUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = MobileQQ.getContext().getSharedPreferences("CHATBACKGROUNG", 0).getInt("CHATBACKGROUNDVERSION", 0);
    Object localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set("chatbg_json");
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(i);
    localArrayList.add(localObject);
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(8);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return localObject;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a()
  {
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject = this.b.a();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("3.4.0.607");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a());
    localReqBody.rpt_msg_reqappinfo.set(localArrayList);
    localReqBody.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ChatBackgroundUpdateHandler", 2, "sendPbReq called.");
    }
  }
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Iterator localIterator = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (localIterator.hasNext())
    {
      paramRspAppInfo = (ClubContentUpdateInfoPb.RspItemInfo)localIterator.next();
      String str1 = paramRspAppInfo.str_name.get();
      int i = paramRspAppInfo.uint_version.get();
      String str2 = paramRspAppInfo.str_extend.get();
      int j = paramRspAppInfo.uint_update_flag.get();
      String[] arrayOfString = str2.split("\\|\\|");
      paramRspAppInfo = "";
      if (arrayOfString.length > 0) {
        paramRspAppInfo = arrayOfString[0];
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatBackgroundUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", tip=" + paramRspAppInfo + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (EmoticonUtils.a(j))
      {
        new ChatBackgroundManagerImp(this.b).a(true);
        MobileQQ.getContext().getSharedPreferences("CHATBACKGROUNG", 0).edit().putInt("CHATBACKGROUNDVERSION", i).commit();
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatBackgroundUpdateHandler", 2, "onReceive called.");
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        paramToServiceMsg = new ClubContentUpdateInfoPb.RspBody();
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.int_result.get() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatBackgroundUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
        }
        else
        {
          paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
          if (paramToServiceMsg.hasNext()) {
            paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
          }
        }
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 8: 
          a(paramFromServiceMsg);
          continue;
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ChatBackgroundUpdateHandler
 * JD-Core Version:    0.7.0.1
 */