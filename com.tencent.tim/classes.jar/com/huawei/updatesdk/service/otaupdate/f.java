package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.a.b.d.a.d;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
{
  private static String a = "com.huawei.appmarket";
  private static b b;
  
  public static void a(b paramb)
  {
    b = paramb;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
    com.huawei.updatesdk.service.d.a.c.a(com.huawei.updatesdk.service.appmgr.bean.a.d(a), new a(null));
  }
  
  private static ApkUpgradeInfo b(List<ApkUpgradeInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (ApkUpgradeInfo)localIterator.next();
    } while ((a == null) || (!a.equals(paramList.getPackage_())));
    for (;;)
    {
      return paramList;
      paramList = null;
    }
  }
  
  static class a
    implements com.huawei.updatesdk.a.b.d.a.a
  {
    public void a(com.huawei.updatesdk.a.b.d.a.c paramc, d paramd) {}
    
    public void b(com.huawei.updatesdk.a.b.d.a.c paramc, d paramd)
    {
      if ((paramd instanceof com.huawei.updatesdk.service.appmgr.bean.b))
      {
        paramc = (com.huawei.updatesdk.service.appmgr.bean.b)paramd;
        if ((paramd.a() != 0) || (paramd.c() != 0)) {
          if (f.a() != null) {
            f.a().b(paramd.a());
          }
        }
      }
      while (f.a() == null)
      {
        do
        {
          do
          {
            return;
            if (((paramc.list_ != null) && (paramc.list_.size() != 0)) || ((paramc.notRcmList_ != null) && (paramc.notRcmList_.size() != 0))) {
              break;
            }
          } while (f.a() == null);
          f.a().a(paramd.a());
          return;
          paramc = f.a(paramc.list_);
        } while (f.a() == null);
        f.a().a(paramc);
        return;
      }
      f.a().a(paramd.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.f
 * JD-Core Version:    0.7.0.1
 */