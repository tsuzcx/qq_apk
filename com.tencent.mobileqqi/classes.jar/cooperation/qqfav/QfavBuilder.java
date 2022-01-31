package cooperation.qqfav;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import ibg;

public class QfavBuilder
  implements ibg
{
  private Intent a;
  
  public QfavBuilder(int paramInt)
  {
    this.a = new Intent();
    this.a.putExtra("nType", paramInt);
  }
  
  public QfavBuilder(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public static QfavBuilder a(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3)
  {
    return new QfavBuilder(7).a("sLocation", paramString2).a("sBrief", paramString3).a("sPublisher", paramString1).a("fLatitude", paramFloat1).a("fLongitude", paramFloat2);
  }
  
  public static QfavBuilder a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = QfavUtil.a(paramArrayOfByte);
    paramString1 = QfavUtil.a(paramArrayOfByte[0], paramString1);
    paramString2 = QfavUtil.a(paramArrayOfByte[1], paramString2);
    paramString3 = QfavUtil.a(paramArrayOfByte[2], paramString3);
    paramString4 = QfavUtil.a(paramArrayOfByte[3], paramString4);
    paramString5 = QfavUtil.a(paramArrayOfByte[4], paramString5);
    paramString6 = QfavUtil.a(paramArrayOfByte[5], paramString6);
    return new QfavBuilder(6).a("nLinkType", paramInt).a("sTitle", paramString1).a("sUrl", paramString2).a("sPublisher", paramString3).a("sBrief", paramString4).a("sPath", paramString5).a("sResUrl", paramString6);
  }
  
  public static QfavBuilder a(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = QfavUtil.a(paramArrayOfByte);
    return new QfavBuilder(6).a("nLinkType", paramInt).a("sTitle", paramArrayOfByte[0]).a("sUrl", paramArrayOfByte[1]).a("sPublisher", paramArrayOfByte[2]).a("sBrief", paramArrayOfByte[3]).a("sPath", paramArrayOfByte[4]).a("sResUrl", paramArrayOfByte[5]);
  }
  
  public static QfavBuilder a(Entity paramEntity)
  {
    return new QfavBuilder(2).c(paramEntity);
  }
  
  public static QfavBuilder a(String paramString)
  {
    return new QfavBuilder(1).a("sText", paramString);
  }
  
  public static QfavBuilder a(String paramString1, int paramInt, String paramString2)
  {
    return new QfavBuilder(4).a("sPath", paramString1).a("nDuration", paramInt).a("sBrief", paramString2);
  }
  
  public static QfavBuilder a(String paramString1, int paramInt, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    paramInt = QfavUtil.b(paramInt);
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if ((4 == paramInt) || (5 == paramInt)) {
        paramString2 = String.valueOf(paramLong1);
      }
      return new QfavBuilder(2).a("sMD5", paramString1).a("sPath", paramString3).a("nPicType", paramInt).a("sPicId", paramString2).a("lSize", paramLong2);
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    if ((paramActivity == null) || (paramIntent == null)) {
      return;
    }
    if (!paramIntent.getBooleanExtra("bFailed", false))
    {
      if (paramIntent.getBooleanExtra("bFirstAdd", false)) {}
      QfavUtil.a(paramActivity, 2131560778, 2);
      return;
    }
    QfavUtil.a(paramActivity, 2131560785, 1);
  }
  
  public static QfavBuilder b(Entity paramEntity)
  {
    return new QfavBuilder(8).c(paramEntity);
  }
  
  public static QfavBuilder b(String paramString)
  {
    return new QfavBuilder(6).a("sUrl", paramString);
  }
  
  public static QfavBuilder c(String paramString)
  {
    return new QfavBuilder(2).a("sPath", paramString);
  }
  
  public Intent a()
  {
    return this.a;
  }
  
  public QfavBuilder a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.a.putExtra("nAuthorType", paramInt).putExtra("lUin", paramLong1).putExtra("sName", paramString1).putExtra("lGroupUin", paramLong2).putExtra("sGroupName", paramString2);
    return this;
  }
  
  public QfavBuilder a(long paramLong, String paramString)
  {
    this.a.putExtra("nAuthorType", 1).putExtra("lUin", paramLong).putExtra("sName", paramString);
    return this;
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    return a(Long.valueOf(paramQQAppInterface.a()).longValue(), paramQQAppInterface.e());
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {
      return this;
    }
    return a(paramQQAppInterface, paramMessageRecord.senderuin, paramMessageRecord.frienduin, paramMessageRecord.issend, paramMessageRecord.istroop);
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    int i = QfavUtil.a(paramInt2);
    String str2 = "";
    long l6 = 0L;
    Object localObject4 = "";
    long l5 = 0L;
    String str1;
    long l4;
    Object localObject2;
    long l3;
    Object localObject1;
    long l2;
    Object localObject3;
    if (TextUtils.isEmpty(paramString1))
    {
      i = 1;
      paramInt2 = 0;
      str1 = paramString2;
      l4 = l5;
      localObject2 = localObject4;
      l3 = l6;
      localObject1 = str2;
      try
      {
        if (!MsgUtils.a(paramInt1)) {
          break label319;
        }
        l4 = l5;
        localObject2 = localObject4;
        l3 = l6;
        localObject1 = str2;
        paramString1 = paramQQAppInterface.e();
        l4 = l5;
        localObject2 = localObject4;
        l3 = l6;
        localObject1 = paramString1;
        l1 = Long.valueOf(paramQQAppInterface.a()).longValue();
        l2 = l5;
        localObject3 = localObject4;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          label126:
          l2 = l3;
          label244:
          long l1 = l4;
          label299:
          label319:
          paramString1 = (String)localObject1;
          label386:
          paramQQAppInterface = (QQAppInterface)localObject2;
          paramString2.printStackTrace();
          l3 = l1;
          continue;
          localObject4 = str1;
          continue;
          localObject4 = paramString2;
        }
      }
      if (1000 == paramInt2)
      {
        l4 = l2;
        localObject2 = localObject3;
        l3 = l1;
        localObject1 = paramString1;
        localObject4 = (FriendManager)paramQQAppInterface.getManager(8);
        if (localObject4 != null)
        {
          l4 = l2;
          localObject2 = localObject3;
          l3 = l1;
          localObject1 = paramString1;
          localObject4 = ((FriendManager)localObject4).g(str1);
          l4 = l2;
          localObject2 = localObject3;
          l3 = l1;
          localObject1 = paramString1;
          localObject3 = ContactUtils.a(paramQQAppInterface, (String)localObject4, true);
          l4 = l2;
          localObject2 = localObject3;
          l3 = l1;
          localObject1 = paramString1;
          l2 = Long.valueOf((String)localObject4).longValue();
          localObject1 = localObject3;
          if (paramInt2 != 1004)
          {
            localObject2 = localObject1;
            l3 = l2;
            if (paramInt2 != 3000) {}
          }
          else if (paramInt2 == 1004)
          {
            paramString2 = str1;
          }
          try
          {
            localObject2 = ContactUtils.b(paramQQAppInterface, paramString2);
            localObject1 = localObject2;
            l3 = Long.valueOf(paramString2).longValue();
            paramQQAppInterface = (QQAppInterface)localObject2;
            l2 = l1;
            return a(i, l2, paramString1, l3, paramQQAppInterface);
          }
          catch (Exception paramString2)
          {
            for (;;)
            {
              paramQQAppInterface = (QQAppInterface)localObject1;
              l3 = l2;
              l2 = l1;
              l1 = l3;
            }
          }
          if (paramInt2 != 1006) {
            break label747;
          }
          l2 = l5;
          localObject3 = localObject4;
          l1 = l6;
          paramString1 = str2;
          if (str1 == null) {
            break label718;
          }
          l4 = l5;
          localObject2 = localObject4;
          l3 = l6;
          localObject1 = str2;
          paramString1 = ContactUtils.b(paramQQAppInterface, str1, paramInt2);
          l1 = 0L;
          l2 = l5;
          localObject3 = localObject4;
          break label718;
          l4 = l5;
          localObject2 = localObject4;
          l3 = l6;
          localObject1 = str2;
          paramString1 = ContactUtils.b(paramQQAppInterface, paramString2, paramInt2);
          l4 = l5;
          localObject2 = localObject4;
          l3 = l6;
          localObject1 = paramString1;
          l1 = Long.valueOf(paramString2).longValue();
          l2 = l5;
          localObject3 = localObject4;
          break label718;
        }
      }
    }
    for (;;)
    {
      label445:
      l4 = l5;
      localObject2 = localObject4;
      l3 = l6;
      localObject1 = str2;
      paramString1 = ContactUtils.b(paramQQAppInterface, str1, 0);
      l4 = l5;
      localObject2 = localObject4;
      l3 = l6;
      localObject1 = paramString1;
      l1 = Long.valueOf(str1).longValue();
      if (1 == paramInt2)
      {
        l4 = l5;
        localObject2 = localObject4;
        l3 = l1;
        localObject1 = paramString1;
      }
      for (localObject3 = ContactUtils.a(paramQQAppInterface, paramString2, true);; localObject3 = ContactUtils.b(paramQQAppInterface, paramString2))
      {
        l4 = l5;
        localObject2 = localObject3;
        l3 = l1;
        localObject1 = paramString1;
        l2 = Long.valueOf(paramString2).longValue();
        break;
        l4 = l5;
        localObject2 = localObject4;
        l3 = l1;
        localObject1 = paramString1;
      }
      label718:
      label747:
      do
      {
        l4 = l5;
        localObject2 = localObject4;
        l3 = l6;
        localObject1 = str2;
        paramString1 = ContactUtils.b(paramQQAppInterface, str1, paramInt2);
        l4 = l5;
        localObject2 = localObject4;
        l3 = l6;
        localObject1 = paramString1;
        l1 = Long.valueOf(str1).longValue();
        l2 = l5;
        localObject3 = localObject4;
        do
        {
          localObject1 = localObject3;
          break label244;
          do
          {
            localObject2 = localObject3;
            l3 = l2;
            break label299;
            str1 = paramString1;
            break;
          } while ((2 != i) && (3 != i));
          if (1 == paramInt2) {
            break label126;
          }
        } while (1000 != paramInt2);
        break label126;
        if ((paramInt2 == 1004) || (paramInt2 == 1000)) {
          break label386;
        }
        if (paramInt2 == 1) {
          break label445;
        }
      } while (paramInt2 != 3000);
    }
  }
  
  public QfavBuilder a(String paramString, float paramFloat)
  {
    this.a.putExtra(paramString, paramFloat);
    return this;
  }
  
  public QfavBuilder a(String paramString, int paramInt)
  {
    this.a.putExtra(paramString, paramInt);
    return this;
  }
  
  public QfavBuilder a(String paramString, long paramLong)
  {
    this.a.putExtra(paramString, paramLong);
    return this;
  }
  
  public QfavBuilder a(String paramString1, String paramString2)
  {
    this.a.putExtra(paramString1, paramString2);
    return this;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    Object localObject = null;
    if (!a(paramActivity, paramString, -1, null))
    {
      paramString = localObject;
      if (0 == 0) {
        paramString = this.a;
      }
      QfavUtil.a(paramActivity, paramString.getIntExtra("nReasonInt", 2131560785), 1);
      return;
    }
    QfavUtil.a(paramActivity, 2131560778, 2);
    QfavUtil.a(paramActivity, paramString, true);
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    if (paramActivity == null) {
      return false;
    }
    this.a.putExtra("nOperation", 0);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null)
    {
      paramIntent.putExtras(this.a);
      switch (paramIntent.getIntExtra("nType", 0))
      {
      }
    }
    String str;
    do
    {
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
      paramIntent = this.a;
      break;
      str = paramIntent.getStringExtra("sPath");
    } while ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!QfavUtil.a(str, paramIntent.getLongExtra("lSize", -1L))));
    paramIntent.putExtra("nReasonInt", 2131560830);
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "QfavBuilder.add: picture too big [" + str + "]");
    }
    QfavReport.a(null, "Net_AddFav", 3, 3, -3);
    return false;
  }
  
  public QfavBuilder b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return a(paramQQAppInterface, paramMessageRecord).a("lCreateTime", paramMessageRecord.time * 1000L);
  }
  
  public void b(Activity paramActivity, String paramString)
  {
    Object localObject = null;
    if (!a(paramActivity, paramString, -1, null))
    {
      paramString = localObject;
      if (0 == 0) {
        paramString = this.a;
      }
      QQToast.a(paramActivity, 1, paramString.getIntExtra("nReasonInt", 2131560785), 2000).b(0);
      return;
    }
    QQToast.a(paramActivity, 2, 2131560778, 2000).b(0);
    QfavUtil.a(paramActivity, paramString, true);
  }
  
  public QfavBuilder c(Entity paramEntity)
  {
    this.a.putExtra("cvEntityContents", QfavUtil.a(paramEntity, ""));
    this.a.putExtra("sEntityClassName", paramEntity.getClass().getName());
    return this;
  }
  
  public QfavBuilder d(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      this.a.putExtra("nAuthorType", 1).putExtra("lUin", l);
      return this;
    }
    catch (Exception paramString) {}
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavBuilder
 * JD-Core Version:    0.7.0.1
 */