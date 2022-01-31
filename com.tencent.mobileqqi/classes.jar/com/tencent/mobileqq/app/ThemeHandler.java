package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.theme.ThemeAuth.ReqBody;
import com.tencent.pb.theme.ThemeAuth.RspBody;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1ReqAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1RspAuth;
import com.tencent.pb.theme.ThemeAuth.ThemeFileInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class ThemeHandler
  extends BusinessHandler
{
  public static final String a = "Theme.ThemeHandler";
  
  ThemeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private HashMap a(String paramString)
  {
    paramString = FileUtils.a(paramString);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while ((i < 3) && (i < paramString.size()))
    {
      String str1 = (String)paramString.get(new Random().nextInt(paramString.size() - 1));
      String str2 = str1.substring(str1.substring(0, str1.lastIndexOf(47)).lastIndexOf('/') + 1);
      if ((str2 != null) && (str2.length() > 0) && (!localHashMap.containsKey(str2)))
      {
        String str3 = FileUtils.a(str1, "MD5");
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme getRandomFileMd5 file=" + str1 + ",key=" + str2 + ",md5=" + str3);
        }
        if ((str3 != null) && (str3.length() > 0)) {
          localHashMap.put(str2, str3);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a()
  {
    Object localObject1 = ThemeUtil.getUserCurrentThemeId(this.a);
    Object localObject2 = ThemeUtil.getUserCurrentThemeVersion(this.a);
    Object localObject3 = SkinEngine.getInstances().getSkinRootPath();
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "Theme Auth themeId=" + (String)localObject1 + ",version=" + (String)localObject2 + ",currentThemeResPath=" + (String)localObject3);
    }
    if ((localObject1 != null) && (!((String)localObject1).equals("1000")) && (localObject2 != null) && (((String)localObject2).length() > 0) && (localObject3 != null)) {
      try
      {
        ThemeAuth.SubCmd0x1ReqAuth localSubCmd0x1ReqAuth = new ThemeAuth.SubCmd0x1ReqAuth();
        localSubCmd0x1ReqAuth.uint32_op_type.set(1);
        localSubCmd0x1ReqAuth.uint32_theme_id.set(Integer.parseInt((String)localObject1));
        localSubCmd0x1ReqAuth.str_theme_version.set((String)localObject2);
        localSubCmd0x1ReqAuth.str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
        localObject1 = a((String)localObject3).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "Theme file Info,Filepath=" + (String)((Map.Entry)localObject2).getKey() + ",FileMd5=" + (String)((Map.Entry)localObject2).getValue());
          }
          localObject3 = new ThemeAuth.ThemeFileInfo();
          ((ThemeAuth.ThemeFileInfo)localObject3).str_file_path.set((String)((Map.Entry)localObject2).getKey());
          ((ThemeAuth.ThemeFileInfo)localObject3).str_file_md5.set((String)((Map.Entry)localObject2).getValue());
          localSubCmd0x1ReqAuth.rpt_msg_topic_file_info.add((MessageMicro)localObject3);
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme Auth send Exception:" + localException.getMessage());
        }
        localException.printStackTrace();
      }
    }
    localObject1 = new ThemeAuth.ReqBody();
    ((ThemeAuth.ReqBody)localObject1).uint32_sub_cmd.set(1);
    ((ThemeAuth.ReqBody)localObject1).int32_plat_id.set(109);
    ((ThemeAuth.ReqBody)localObject1).str_qq_version.set("6.0.0.6500");
    ((ThemeAuth.ReqBody)localObject1).uint32_qq_version.set(Integer.parseInt("6500"));
    ((ThemeAuth.ReqBody)localObject1).msg_subcmd0x1_req_auth.set(localException);
    ((ThemeAuth.ReqBody)localObject1).setHasFlag(true);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "AuthSvr.ThemeAuth");
    localToServiceMsg.putWupBuffer(((ThemeAuth.ReqBody)localObject1).toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "Theme Auth send request");
    }
    b(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("AuthSvr.ThemeAuth".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth res.isSuccess=" + paramFromServiceMsg.isSuccess() + ",data=" + PkgTools.b((byte[])paramObject));
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        try
        {
          paramToServiceMsg = new ThemeAuth.RspBody();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg.uint32_sub_cmd.has()) && (paramToServiceMsg.uint32_sub_cmd.get() == 1))
          {
            i = ((ThemeAuth.SubCmd0x1RspAuth)paramToServiceMsg.msg_subcmd0x1_rsp_auth.get()).int32_result.get();
            if (QLog.isColorLevel()) {
              QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, authResult=" + i);
            }
            if ((i >= 1) && (i <= 4))
            {
              if (QLog.isColorLevel()) {
                QLog.i("Theme.ThemeHandler", 2, "");
              }
              ThemeUtil.setCurrentThemeIdVersion(this.a, "1000", "0");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth error, rspBody=" + paramToServiceMsg);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth Exception=" + paramToServiceMsg.getMessage());
          }
          paramToServiceMsg.printStackTrace();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler
 * JD-Core Version:    0.7.0.1
 */