package com.tencent.mobileqq.profile;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReq;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRsp;
import com.tencent.qphone.base.util.QLog;
import get;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProfileCardCheckUpdate
  implements CheckUpdateItemInterface
{
  public static final String a = "ProfileCard.ProfileCardCheckUpdate";
  private static final String b = "nextCheckUpdateTimeMillis";
  private static final String c = "cardTemplateVersion";
  public QQAppInterface a;
  
  public ProfileCardCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  public int a()
  {
    return 3;
  }
  
  public ReqItem a()
  {
    Object localObject1 = this.a.getPreferences();
    long l = System.currentTimeMillis();
    ((SharedPreferences)localObject1).edit().putLong("nextCheckUpdateTimeMillis", l + 3600000L).commit();
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 111;
    Object localObject2 = new SummaryCardUpdate.SUpdateReq();
    ((SummaryCardUpdate.SUpdateReq)localObject2).cmd.set(3);
    ((SummaryCardUpdate.SUpdateReq)localObject2).uin.set(this.a.getLongAccountUin());
    localObject1 = ((SharedPreferences)localObject1).getString("cardTemplateVersion", "0");
    ((SummaryCardUpdate.SUpdateReq)localObject2).version.set((String)localObject1);
    ((SummaryCardUpdate.SUpdateReq)localObject2).client_version.set("6.0.2");
    ((SummaryCardUpdate.SUpdateReq)localObject2).platform.set(109);
    localObject2 = ((SummaryCardUpdate.SUpdateReq)localObject2).toByteArray();
    int i = localObject2.length;
    int j = i + 4;
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(a(j), 0, arrayOfByte, 0, 4);
    System.arraycopy(localObject2, 0, arrayOfByte, 4, i);
    localReqItem.vecParam = arrayOfByte;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "getCheckUpdateItemData uin=" + this.a.getLongAccountUin() + ",version=" + (String)localObject1 + ",client_version=" + "6.0.2" + ",dataLen=" + j);
    }
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      i = paramRespItem.cResult;
      paramRespItem = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "handleCheckUpdateItemData result=" + i + ",dataLen=" + paramRespItem.length);
      }
      if (i != 2) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        int i;
        if (paramRespItem.length > 4)
        {
          i = (int)PkgTools.a(paramRespItem, 0);
          Object localObject = new byte[i - 4];
          PkgTools.a((byte[])localObject, 0, paramRespItem, 4, i - 4);
          paramRespItem = new SummaryCardUpdate.SUpdateRsp();
          paramRespItem.mergeFrom((byte[])localObject);
          if (paramRespItem != null)
          {
            i = paramRespItem.code.get();
            localObject = paramRespItem.version.get();
            String str = paramRespItem.url.get();
            int j = paramRespItem.interv.get();
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate SUpdateRsp data code=" + i + ",version=" + (String)localObject + ",url=" + str + ",interval=" + j);
            }
            if (i == 0)
            {
              paramRespItem = this.a.getPreferences();
              if (j >= 0)
              {
                long l1 = System.currentTimeMillis();
                long l2 = j * 1000;
                paramRespItem.edit().putLong("nextCheckUpdateTimeMillis", l1 + l2).commit();
              }
              if ((!paramRespItem.getString("cardTemplateVersion", "0").equals(localObject)) && (str != null)) {
                a(str, (String)localObject);
              }
            }
          }
        }
        return;
      }
      catch (Exception paramRespItem)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate Exception msg=" + paramRespItem.getMessage());
        }
        paramRespItem.printStackTrace();
        return;
      }
    }
    QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleCheckUpdateItemData respitem is null");
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManager.a(new get(this, paramString1, paramString2));
  }
  
  public boolean a()
  {
    try
    {
      long l1 = this.a.getPreferences().getLong("nextCheckUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendTemplateCheckUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label146;
        }
      }
      label146:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool);
        if (l2 <= l1) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate
 * JD-Core Version:    0.7.0.1
 */