package cooperation.qqfav;

import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class QfavSrvAddrProvider
{
  public static final int a = 0;
  public static final int b = 4;
  public static final int c = 5;
  public static final int d = 6;
  public static final String d = "QfavSrvAddrList_FavIp";
  public static final String e = "QfavSrvAddrList_PicPlatformIp";
  public static final String f = "QfavSrvAddrList_UploadPicIp";
  public static final String g = "com.tencent.receiver.qfav.srvaddr";
  public static final String h = "com.tencent.receiver.qfav.srvaddr.type";
  protected String a = null;
  protected String b = null;
  protected String c = null;
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    Object localObject = BaseApplicationImpl.a();
    int i;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavSrvAddrList", i);
      if (localObject != null) {
        break label32;
      }
    }
    label32:
    while ((paramFileStoragePushFSSvcList == null) || (paramFileStoragePushFSSvcList.domainIpChannel == null) || (paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists == null))
    {
      return;
      i = 0;
      break;
    }
    paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.iterator();
    while (paramFileStoragePushFSSvcList.hasNext())
    {
      DomainIpList localDomainIpList = (DomainIpList)paramFileStoragePushFSSvcList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      if ((localDomainIpList.uDomain_type == 4) || (localDomainIpList.uDomain_type == 5) || (localDomainIpList.uDomain_type == 6))
      {
        if ((localDomainIpList.vIplist != null) && (localDomainIpList.vIplist.size() != 0))
        {
          i = 0;
          while (i < localDomainIpList.vIplist.size())
          {
            DomainIpInfo localDomainIpInfo = (DomainIpInfo)localDomainIpList.vIplist.get(i);
            localStringBuilder.append(NetworkUtil.a(localDomainIpInfo.uIp)).append(":").append(localDomainIpInfo.uPort);
            if (i < localDomainIpList.vIplist.size() - 1) {
              localStringBuilder.append("|");
            }
            i += 1;
          }
        }
      }
      else {
        switch (localDomainIpList.uDomain_type)
        {
        default: 
          break;
        case 4: 
          this.a = localStringBuilder.toString();
          ((SharedPreferences)localObject).edit().putString("QfavSrvAddrList_FavIp", this.a).commit();
          break;
        case 5: 
          this.c = localStringBuilder.toString();
          ((SharedPreferences)localObject).edit().putString("QfavSrvAddrList_UploadPicIp", this.c).commit();
          break;
        case 6: 
          this.b = localStringBuilder.toString();
          ((SharedPreferences)localObject).edit().putString("QfavSrvAddrList_PicPlatformIp", this.b).commit();
        }
      }
    }
    paramFileStoragePushFSSvcList = new Intent("com.tencent.receiver.qfav.srvaddr");
    paramFileStoragePushFSSvcList.putExtra("com.tencent.receiver.qfav.srvaddr.type", 0);
    BaseApplicationImpl.a().sendBroadcast(paramFileStoragePushFSSvcList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavSrvAddrProvider
 * JD-Core Version:    0.7.0.1
 */