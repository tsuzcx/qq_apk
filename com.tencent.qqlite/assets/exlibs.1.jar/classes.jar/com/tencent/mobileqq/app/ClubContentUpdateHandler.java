package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClubContentUpdateHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "ClubContentUpdateHandler";
  public static final int b = 2;
  public static final String b = "ClubContentUpdate.Req";
  public static final int c = 3;
  public static final String c = "last_pull_club_content_update_time";
  public static final int d = 6;
  public static final String d = "last_pull_chatbackground_content_update_time";
  public static final int e = 7;
  public static final String e = "ChatBg_Json";
  private ArrayList a = new ArrayList();
  protected QQAppInterface b;
  
  ClubContentUpdateHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  private void c() {}
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(ClubContentJsonTask.d.e);
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(ClubContentJsonTask.a(this.b.getApplication().getApplicationContext(), ClubContentJsonTask.d.d));
    localArrayList.add(localObject);
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
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
    localArrayList.add(d());
    localArrayList.add(b());
    localArrayList.add(c());
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
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if ((str1.equals(ClubContentJsonTask.b.e)) && (i > ClubContentJsonTask.a(this.b.getApplication().getApplicationContext(), ClubContentJsonTask.b.d))) {
        ClubContentJsonTask.a(this.b, ClubContentJsonTask.b, i);
      }
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
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(ClubContentJsonTask.b.e);
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(ClubContentJsonTask.a(this.b.getApplication().getApplicationContext(), ClubContentJsonTask.b.d));
    localArrayList.add(localObject);
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(7);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return localObject;
  }
  
  public void b()
  {
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject = this.b.a();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("3.4.0.607");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(e());
    localReqBody.rpt_msg_reqappinfo.set(localArrayList);
    localReqBody.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called.");
    }
  }
  
  public void b(ClubContentUpdateHandler.ClubContentUpdateListener paramClubContentUpdateListener)
  {
    this.a.remove(paramClubContentUpdateListener);
  }
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
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
        break label485;
      }
    }
    label485:
    for (paramRspAppInfo = paramRspAppInfo[0];; paramRspAppInfo = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", tip=" + paramRspAppInfo + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (str1.equals(ClubContentJsonTask.c.e))
      {
        if (i <= ClubContentJsonTask.a(this.b.getApplication().getApplicationContext(), ClubContentJsonTask.c.d)) {
          break;
        }
        ClubContentJsonTask.a(this.b, ClubContentJsonTask.c, i);
        break;
      }
      if (str1.equals(ClubContentJsonTask.a.e))
      {
        if (i <= ClubContentJsonTask.a(this.b.getApplication().getApplicationContext(), ClubContentJsonTask.a.d)) {
          break;
        }
        ClubContentJsonTask.a(this.b, ClubContentJsonTask.a, i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ClubContentUpdateHandler", 2, "AIO Yellow Finger json updated.");
        break;
      }
      if (str1.equals(ClubContentJsonTask.d.e))
      {
        if (i > ClubContentJsonTask.a(this.b.getApplication().getApplicationContext(), ClubContentJsonTask.d.d)) {
          ClubContentJsonTask.a(this.b, ClubContentJsonTask.d, i);
        }
        paramRspAppInfo = (EmoticonManagerImp)this.b.getManager(13);
        if (paramRspAppInfo != null) {
          paramRspAppInfo.a(i);
        }
      }
      for (;;)
      {
        return;
        if (str1.contains("_json"))
        {
          if (!EmoticonUtils.a(j)) {
            break;
          }
          ((EmoticonManager)this.b.getManager(13)).b(str1.replace("_json", "").trim(), i, paramRspAppInfo, j);
          break;
        }
        ((EmoticonManager)this.b.getManager(13)).a(str1, i, paramRspAppInfo, j);
        localHashMap.put(str1, Integer.valueOf(j));
        break;
        paramRspAppInfo = this.a.iterator();
        while (paramRspAppInfo.hasNext()) {
          ((ClubContentUpdateHandler.ClubContentUpdateListener)paramRspAppInfo.next()).a(localHashMap);
        }
      }
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
            QLog.d("ClubContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          c();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label214;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 1: 
          b(paramFromServiceMsg);
          break;
        case 2: 
          c(paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      continue;
      a(paramFromServiceMsg);
      continue;
      d(paramFromServiceMsg);
      continue;
      label214:
      return;
      i = 0;
      break;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject = ((BubbleManager)this.b.getManager(40)).a();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i < ((JSONArray)localObject).length()) {
          try
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
            localReqItemInfo.str_name.set("bubble_" + localJSONObject.getString("id"));
            localReqItemInfo.uint_version.set(localJSONObject.getInt("version"));
            localArrayList.add(localReqItemInfo);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(2);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return localObject;
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    if (paramRspAppInfo.hasNext())
    {
      Object localObject1 = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      Object localObject2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject1).str_name.get();
      int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject1).uint_version.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + (String)localObject2 + ", version=" + j);
      }
      for (;;)
      {
        int i;
        try
        {
          int k = Integer.parseInt(((String)localObject2).substring(((String)localObject2).indexOf("_") + 1));
          localObject1 = (BubbleManager)this.b.getManager(40);
          localObject2 = ((BubbleManager)localObject1).a();
          if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
            break;
          }
          i = 0;
          if (i >= ((JSONArray)localObject2).length()) {
            break;
          }
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
          if ((localJSONObject.getInt("id") != k) || (j <= localJSONObject.getInt("version"))) {
            break label215;
          }
          ((BubbleManager)localObject1).a(k, "version.json");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        break;
        label215:
        i += 1;
      }
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo d()
  {
    Object localObject = ((EmoticonManager)this.b.getManager(13)).b();
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
            break label340;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label340:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(ClubContentJsonTask.c.e);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(ClubContentJsonTask.a(this.b.getApplication().getApplicationContext(), ClubContentJsonTask.c.d));
      localArrayList.add(localObject);
      localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(ClubContentJsonTask.a.e);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(ClubContentJsonTask.a(this.b.getApplication().getApplicationContext(), ClubContentJsonTask.a.d));
      localArrayList.add(localObject);
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
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
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", tip=" + paramRspAppInfo + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if ((str1.equals("ChatBg_Json")) && (EmoticonUtils.a(j)))
      {
        ((ChatBackgroundManager)this.b.getManager(50)).a(true);
        this.b.a().getSharedPreferences("CHATBACKGROUNG", 0).edit().putInt("CHATBACKGROUNDVERSION", i).commit();
      }
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo e()
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.b.a().getSharedPreferences("CHATBACKGROUNG", 0).getInt("CHATBACKGROUNDVERSION", 0);
    Object localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set("ChatBg_Json");
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(i);
    localArrayList.add(localObject);
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(6);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler
 * JD-Core Version:    0.7.0.1
 */