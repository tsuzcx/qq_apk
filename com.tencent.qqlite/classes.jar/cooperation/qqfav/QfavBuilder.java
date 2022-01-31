package cooperation.qqfav;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import fmy;
import fmz;
import fna;
import fnb;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class QfavBuilder
  implements fmy
{
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public QfavBuilder(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentIntent = new Intent();
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nType", paramInt);
  }
  
  public QfavBuilder(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  private Dialog a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    String str3 = paramActivity.getResources().getString(paramInt1);
    Object localObject = paramActivity.getResources().getString(paramInt2);
    String str2 = paramActivity.getResources().getString(paramInt3);
    String str1 = paramActivity.getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject, new Object[] { paramString });; paramString = (String)localObject)
    {
      paramActivity = new Dialog(paramActivity, 2131624120);
      paramActivity.setContentView(2130903135);
      localObject = (TextView)paramActivity.findViewById(2131296912);
      if (localObject != null) {
        ((TextView)localObject).setText(str3);
      }
      localObject = (TextView)paramActivity.findViewById(2131296473);
      if (localObject != null) {
        ((TextView)localObject).setText(paramString);
      }
      paramString = (TextView)paramActivity.findViewById(2131296915);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)paramActivity.findViewById(2131296916);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return paramActivity;
    }
  }
  
  public static QfavBuilder a(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3)
  {
    return new QfavBuilder(7).b("sLocation", paramString2).b("sBrief", paramString3).b("sPublisher", paramString1).a("fLatitude", paramFloat1).a("fLongitude", paramFloat2);
  }
  
  public static QfavBuilder a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramArrayOfByte = QfavUtil.a(paramArrayOfByte);
    paramString1 = QfavUtil.a(paramArrayOfByte[0], paramString1);
    paramString2 = QfavUtil.a(paramArrayOfByte[1], paramString2);
    paramString3 = QfavUtil.a(paramArrayOfByte[2], paramString3);
    paramString4 = QfavUtil.a(paramArrayOfByte[3], paramString4);
    paramString5 = QfavUtil.a(paramArrayOfByte[4], paramString5);
    paramString6 = QfavUtil.a(paramArrayOfByte[5], paramString6);
    paramString1 = new QfavBuilder(6).a("nLinkType", paramInt).b("sTitle", paramString1).b("sUrl", paramString2).b("sPublisher", paramString3).b("sBrief", paramString4).b("sPath", paramString5).b("sResUrl", paramString6);
    if (paramBoolean) {}
    for (long l = 4L;; l = 1L) {
      return paramString1.a("lCategory", l);
    }
  }
  
  public static QfavBuilder a(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = QfavUtil.a(paramArrayOfByte);
    return new QfavBuilder(6).a("nLinkType", paramInt).b("sTitle", paramArrayOfByte[0]).b("sUrl", paramArrayOfByte[1]).b("sPublisher", paramArrayOfByte[2]).b("sBrief", paramArrayOfByte[3]).b("sPath", paramArrayOfByte[4]).b("sResUrl", paramArrayOfByte[5]);
  }
  
  public static QfavBuilder a(Entity paramEntity)
  {
    return new QfavBuilder(2).c(paramEntity);
  }
  
  public static QfavBuilder a(String paramString)
  {
    return new QfavBuilder(6).b("sUrl", paramString);
  }
  
  public static QfavBuilder a(String paramString1, int paramInt, String paramString2)
  {
    return new QfavBuilder(4).b("sPath", paramString1).a("nDuration", paramInt).b("sBrief", paramString2);
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
      return new QfavBuilder(2).b("sMD5", paramString1).b("sPath", paramString3).a("nPicType", paramInt).b("sPicId", paramString2).a("lSize", paramLong2);
    }
  }
  
  public static QfavBuilder a(String paramString1, String paramString2)
  {
    return new QfavBuilder(1).b("sText", paramString2).b("sTitle", paramString1);
  }
  
  public static QfavBuilder a(ArrayList paramArrayList, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, String paramString3)
  {
    paramArrayList = new QfavBuilder(8).a("sPathList", paramArrayList).b("sTitle", paramString1).a("bOnlyPic", paramBoolean1).b("sText", paramString2).a("bAppShare", paramBoolean2).a("lAppId", paramLong).b("sAppName", paramString3);
    if (paramBoolean2) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramArrayList.a("lCategory", paramLong);
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    if ((paramActivity == null) || (paramIntent == null)) {
      return;
    }
    if (!paramIntent.getBooleanExtra("bFailed", false))
    {
      if (paramIntent.getBooleanExtra("bFirstAdd", false)) {
        QfavUtil.a(paramActivity, false, null, null);
      }
      QfavUtil.a(paramActivity, 2131362677, 2);
      return;
    }
    QfavUtil.a(paramActivity, 2131362684, 1);
  }
  
  public static QfavBuilder b(Entity paramEntity)
  {
    return new QfavBuilder(8).c(paramEntity);
  }
  
  public static QfavBuilder b(String paramString)
  {
    return new QfavBuilder(2).b("sPath", paramString);
  }
  
  public Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public QfavBuilder a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nAuthorType", paramInt).putExtra("lUin", paramLong1).putExtra("sName", paramString1).putExtra("lGroupUin", paramLong2).putExtra("sGroupName", paramString2);
    return this;
  }
  
  public QfavBuilder a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nAuthorType", 1).putExtra("lUin", paramLong).putExtra("sName", paramString);
    return this;
  }
  
  public QfavBuilder a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    return a(Long.valueOf(paramQQAppInterface.a()).longValue(), paramQQAppInterface.c());
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
        paramString1 = paramQQAppInterface.c();
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
    this.jdField_a_of_type_AndroidContentIntent.putExtra(paramString, paramFloat);
    return this;
  }
  
  public QfavBuilder a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra(paramString, paramInt);
    return this;
  }
  
  public QfavBuilder a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra(paramString, paramLong);
    return this;
  }
  
  public QfavBuilder a(String paramString, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentIntent.putStringArrayListExtra(paramString, paramArrayList);
    return this;
  }
  
  public QfavBuilder a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra(paramString, paramBoolean);
    return this;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    IPluginManager localIPluginManager = (IPluginManager)localAppRuntime.getManager(25);
    int i;
    if (((localAppRuntime instanceof QQAppInterface)) && (localIPluginManager.a())) {
      i = 1;
    }
    for (;;)
    {
      if (!a(paramActivity, paramString, -1, null)) {
        if (0 != 0) {
          break label114;
        }
      }
      label114:
      for (paramString = this.jdField_a_of_type_AndroidContentIntent;; paramString = null)
      {
        QfavUtil.a(paramActivity, paramString.getIntExtra("nReasonInt", 2131362684), 1);
        do
        {
          return;
          if (((localAppRuntime instanceof QQAppInterface)) || (IPluginManager.a("qqfav.apk"))) {
            break label119;
          }
          i = 2;
          break;
        } while (i != 0);
        QfavUtil.a(paramActivity, 2131362677, 2);
        QfavUtil.a(paramActivity, paramString, true);
        return;
      }
      label119:
      i = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    String str = FileUtil.a(paramFileManagerEntity.fileName);
    int m = 6;
    if (paramChatMessage == null) {
      m = 7;
    }
    int j = -1;
    int i = j;
    switch (paramFileManagerEntity.cloudType)
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.fileName.getBytes().length >= 256)
    {
      QfavUtil.a(paramActivity, 2131362687, 1);
      QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80010, m, i, str, null);
      return;
      if (3000 == paramFileManagerEntity.peerType)
      {
        i = 106;
      }
      else
      {
        i = 3;
        continue;
        i = paramFileManagerEntity.busId;
        continue;
        i = 25;
      }
    }
    int i1 = FileManagerUtil.a(paramFileManagerEntity);
    switch (i1)
    {
    case 3: 
    default: 
      QfavUtil.a(paramActivity, 2131362685, 1);
      QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80003, m, i, str, null);
      return;
    case 1: 
      if ((paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        QfavUtil.a(paramActivity, 2131362686, 1);
        QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        return;
      }
      break;
    case 4: 
      if ((104 == paramFileManagerEntity.busId) && (paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        QfavUtil.a(paramActivity, 2131362686, 1);
        QfavReport.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        return;
      }
      break;
    }
    Object localObject;
    if (paramChatMessage != null)
    {
      a(paramQQAppInterface, paramChatMessage);
      localObject = "";
      paramChatMessage = (ChatMessage)localObject;
    }
    label388:
    int k;
    switch (i1)
    {
    default: 
      paramChatMessage = (ChatMessage)localObject;
    case 3: 
      localObject = new ContentValues();
      ((ContentValues)localObject).put("fileUuId", paramChatMessage);
      ((ContentValues)localObject).put("fileCloudType", Integer.valueOf(i1));
      ((ContentValues)localObject).put("fileSize", Long.valueOf(paramFileManagerEntity.fileSize));
      ((ContentValues)localObject).put("fileName", paramFileManagerEntity.fileName);
      ((ContentValues)localObject).put("fileMd5", paramFileManagerEntity.strFileMd5);
      ((ContentValues)localObject).put("filePath", paramFileManagerEntity.strFilePath);
      ((ContentValues)localObject).put("fileThumbPath", paramFileManagerEntity.strThumbPath);
      ((ContentValues)localObject).put("filePeerType", Integer.valueOf(paramFileManagerEntity.peerType));
      this.jdField_a_of_type_AndroidContentIntent.putExtra("fileContents", (Parcelable)localObject);
      a(paramActivity, paramQQAppInterface.getAccount());
      QfavReport.a(paramQQAppInterface, "User_AddFav", 6, 0, m, i, str, null);
      return;
      paramChatMessage = paramFileManagerEntity.selfUin;
      localObject = paramFileManagerEntity.peerUin;
      if (paramFileManagerEntity.bSend)
      {
        k = 1;
        label560:
        int n = 0;
        switch (paramFileManagerEntity.peerType)
        {
        default: 
          j = n;
          if (!paramFileManagerEntity.bSend)
          {
            paramChatMessage = paramFileManagerEntity.peerUin;
            j = n;
          }
          label629:
          if (TextUtils.isEmpty(paramChatMessage))
          {
            paramChatMessage = paramQQAppInterface.a();
            k = 1;
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      a(paramQQAppInterface, paramChatMessage, (String)localObject, k, j);
      break;
      k = 0;
      break label560;
      j = 1;
      break label629;
      j = 3000;
      break label629;
      j = 1004;
      break label629;
      paramChatMessage = paramFileManagerEntity.Uuid;
      break label388;
      paramChatMessage = paramFileManagerEntity.strTroopFilePath;
      break label388;
      paramChatMessage = paramFileManagerEntity.WeiYunFileId;
      break label388;
    }
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    if (paramActivity == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nOperation", 0);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("lCollectTime", System.currentTimeMillis());
    label72:
    Object localObject;
    if (paramIntent != null)
    {
      paramIntent.putExtras(this.jdField_a_of_type_AndroidContentIntent);
      switch (paramIntent.getIntExtra("nType", 0))
      {
      default: 
        localObject = BaseApplicationImpl.a.a();
        IPluginManager localIPluginManager = (IPluginManager)((AppRuntime)localObject).getManager(25);
        if (((localObject instanceof QQAppInterface)) && (localIPluginManager.a()))
        {
          this.jdField_a_of_type_AndroidAppDialog = a(paramActivity, 2131363278, 2131363283, 2131362801, 2131363459, (float)Math.round(25.673103332519531D) / 100.0F + "", new fmz(this), new fna(this, paramActivity, paramString, paramInt));
          this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new fnb(this));
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      paramIntent = this.jdField_a_of_type_AndroidContentIntent;
      break;
      localObject = paramIntent.getStringExtra("sPath");
      if ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!QfavUtil.a((String)localObject, paramIntent.getLongExtra("lSize", -1L)))) {
        break label72;
      }
      paramIntent.putExtra("nReasonInt", 2131362732);
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "QfavBuilder.add: picture too big [" + (String)localObject + "]");
      }
      QfavReport.a(null, "Net_AddFav", 3, 3, -3);
      return false;
      QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
    }
  }
  
  public QfavBuilder b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return a(paramQQAppInterface, paramMessageRecord).a("lCreateTime", paramMessageRecord.time * 1000L);
  }
  
  public QfavBuilder b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra(paramString1, paramString2);
    return this;
  }
  
  public void b(Activity paramActivity, String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    IPluginManager localIPluginManager = (IPluginManager)localAppRuntime.getManager(25);
    if (((localAppRuntime instanceof QQAppInterface)) && (localIPluginManager.a())) {}
    for (int i = 1;; i = 0)
    {
      if (!a(paramActivity, paramString, -1, null)) {
        if (0 != 0) {
          break label102;
        }
      }
      label102:
      for (paramString = this.jdField_a_of_type_AndroidContentIntent;; paramString = null)
      {
        QQToast.a(paramActivity, 1, paramString.getIntExtra("nReasonInt", 2131362684), 2000).b(0);
        do
        {
          return;
        } while (i == 1);
        QQToast.a(paramActivity, 2, 2131362677, 2000).b(0);
        return;
      }
    }
  }
  
  public QfavBuilder c(Entity paramEntity)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("cvEntityContents", QfavUtil.a(paramEntity, ""));
    this.jdField_a_of_type_AndroidContentIntent.putExtra("sEntityClassName", paramEntity.getClass().getName());
    return this;
  }
  
  public QfavBuilder c(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("nAuthorType", 1).putExtra("lUin", l);
      return this;
    }
    catch (Exception paramString) {}
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavBuilder
 * JD-Core Version:    0.7.0.1
 */