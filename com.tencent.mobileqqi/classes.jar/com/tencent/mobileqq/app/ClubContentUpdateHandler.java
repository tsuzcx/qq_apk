package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.EmoticonWording;
import com.tencent.mobileqq.emoticonview.EmoticonWording.DownloadWordingJsonTask;
import com.tencent.mobileqq.model.EmoticonManager;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class ClubContentUpdateHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "ClubContentUpdateHandler";
  public static final int b = 2;
  public static final String b = "ClubContentUpdate.Req";
  public static final int c = 3;
  public static final String c = "last_pull_club_content_update_time";
  private ArrayList a = new ArrayList();
  protected QQAppInterface b;
  
  ClubContentUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  private void b()
  {
    Context localContext = this.b.getApplication().getApplicationContext();
    if (!EmoticonWording.a(localContext))
    {
      int i = EmoticonWording.a(localContext);
      new EmoticonWording.DownloadWordingJsonTask().execute(new Object[] { this.b.getApplication().getApplicationContext(), Integer.valueOf(i) });
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    Object localObject = ((EmoticonManager)this.b.getManager(12)).b();
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if ((localEmoticonPackage.jobType == 0) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.b(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label276;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label276:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set("wording_json");
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(EmoticonWording.a(this.b.getApplication().getApplicationContext()));
      localArrayList.add(localObject);
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
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
    localReqBody.str_clientver.set("6.0.2.6602");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a());
    localReqBody.rpt_msg_reqappinfo.set(localArrayList);
    localReqBody.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called.");
    }
  }
  
  public void a(ClubContentUpdateHandler.ClubContentUpdateListener paramClubContentUpdateListener)
  {
    if ((paramClubContentUpdateListener != null) && (!this.a.contains(paramClubContentUpdateListener))) {
      this.a.add(paramClubContentUpdateListener);
    }
  }
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramRspAppInfo.iterator();
    String str1;
    int i;
    String str2;
    int j;
    if (localIterator.hasNext())
    {
      paramRspAppInfo = (ClubContentUpdateInfoPb.RspItemInfo)localIterator.next();
      str1 = paramRspAppInfo.str_name.get();
      i = paramRspAppInfo.uint_version.get();
      str2 = paramRspAppInfo.str_extend.get();
      j = paramRspAppInfo.uint_update_flag.get();
      paramRspAppInfo = str2.split("\\|\\|");
      if (paramRspAppInfo.length <= 0) {
        break label365;
      }
    }
    label365:
    for (paramRspAppInfo = paramRspAppInfo[0];; paramRspAppInfo = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", tip=" + paramRspAppInfo + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (str1.equals("wording_json"))
      {
        if (i <= EmoticonWording.a(this.b.getApplication().getApplicationContext())) {
          break;
        }
        new EmoticonWording.DownloadWordingJsonTask().execute(new Object[] { this.b.getApplication().getApplicationContext(), Integer.valueOf(i) });
        break;
      }
      if (str1.contains("_json"))
      {
        if (!EmoticonUtils.a(j)) {
          break;
        }
        ((EmoticonManager)this.b.getManager(12)).b(str1.replace("_json", "").trim(), i, paramRspAppInfo, j);
        break;
      }
      ((EmoticonManager)this.b.getManager(12)).a(str1, i, paramRspAppInfo, j);
      localHashMap.put(str1, Integer.valueOf(j));
      break;
      paramRspAppInfo = this.a.iterator();
      while (paramRspAppInfo.hasNext()) {
        ((ClubContentUpdateHandler.ClubContentUpdateListener)paramRspAppInfo.next()).a(localHashMap);
      }
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ClubContentUpdate.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "onReceive called.");
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void b(ClubContentUpdateHandler.ClubContentUpdateListener paramClubContentUpdateListener)
  {
    this.a.remove(paramClubContentUpdateListener);
  }
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo) {}
  
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
            QLog.d("ClubContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          b();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label178;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 1: 
          a(paramFromServiceMsg);
          break;
        case 2: 
          b(paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      continue;
      label178:
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler
 * JD-Core Version:    0.7.0.1
 */