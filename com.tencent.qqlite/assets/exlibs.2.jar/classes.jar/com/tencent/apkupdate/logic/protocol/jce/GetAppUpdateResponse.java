package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetAppUpdateResponse
  extends JceStruct
{
  static Map cache_appUpdateInfoGroup;
  static ArrayList cache_appUpdateInfoList;
  public Map appUpdateInfoGroup = null;
  public ArrayList appUpdateInfoList = null;
  public int ret = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    Object localObject;
    if (cache_appUpdateInfoList == null)
    {
      cache_appUpdateInfoList = new ArrayList();
      localObject = new AppUpdateInfo();
      cache_appUpdateInfoList.add(localObject);
    }
    this.appUpdateInfoList = ((ArrayList)paramJceInputStream.read(cache_appUpdateInfoList, 1, true));
    if (cache_appUpdateInfoGroup == null)
    {
      cache_appUpdateInfoGroup = new HashMap();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new AppUpdateInfo());
      cache_appUpdateInfoGroup.put(Integer.valueOf(0), localObject);
    }
    this.appUpdateInfoGroup = ((Map)paramJceInputStream.read(cache_appUpdateInfoGroup, 2, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.appUpdateInfoList, 1);
    if (this.appUpdateInfoGroup != null) {
      paramJceOutputStream.write(this.appUpdateInfoGroup, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateResponse
 * JD-Core Version:    0.7.0.1
 */