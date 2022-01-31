package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("AuthSvr.ThemeAuth".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString1, String paramString2) {}
  
  @TargetApi(9)
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth res.isSuccess=" + paramFromServiceMsg.isSuccess() + ",data=" + PkgTools.b((byte[])paramObject));
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler
 * JD-Core Version:    0.7.0.1
 */