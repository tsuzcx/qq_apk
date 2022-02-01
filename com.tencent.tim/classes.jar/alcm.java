import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate.1;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate.2;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReq;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReqBatch;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRsp;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRspBatch;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alcm
  implements andh
{
  public QQAppInterface app;
  int flag = 0;
  
  public alcm(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void NW(String paramString)
    throws Exception
  {
    paramString = aG(paramString);
    if (paramString != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramString);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      aqhq.a(new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList").getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
  }
  
  private SummaryCardUpdate.SUpdateReq a(int paramInt, String paramString)
  {
    SummaryCardUpdate.SUpdateReq localSUpdateReq = new SummaryCardUpdate.SUpdateReq();
    localSUpdateReq.cmd.set(paramInt);
    localSUpdateReq.uin.set(this.app.getLongAccountUin());
    localSUpdateReq.version.set(paramString);
    localSUpdateReq.client_version.set("3.4.4");
    localSUpdateReq.platform.set(109);
    if (paramInt == 5) {
      localSUpdateReq.appname.set("fun_call");
    }
    return localSUpdateReq;
  }
  
  private List<ProfileLabelTypeInfo> aG(String paramString)
    throws JSONException
  {
    Object localObject1 = null;
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson labelConfigJsonData length is :" + paramString.length());
      }
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        Object localObject2 = paramString.optJSONObject(i);
        localObject1 = new ProfileLabelTypeInfo();
        ((ProfileLabelTypeInfo)localObject1).typeId = ((JSONObject)localObject2).optString("id");
        ((ProfileLabelTypeInfo)localObject1).typeName = ((JSONObject)localObject2).optString("name");
        ((ProfileLabelTypeInfo)localObject1).typeInfo = ((JSONObject)localObject2).optString("classinfo");
        localObject2 = ((JSONObject)localObject2).optJSONArray("taglist");
        int j = 0;
        int m = ((JSONArray)localObject2).length();
        while (j < m)
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = ((ProfileLabelTypeInfo)localObject1).typeId;
          ((ProfileLabelTypeInfo)localObject1).labels.add(localProfileLabelInfo);
          j += 1;
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      localObject1 = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "downloadLabelConfigJson the new typeList size =" + localArrayList.size());
        localObject1 = localArrayList;
      }
    }
    return localObject1;
  }
  
  private boolean atn()
  {
    return false;
  }
  
  private boolean ato()
  {
    boolean bool2 = false;
    try
    {
      long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getLong("specialcareCheckUpdateTime", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendSpecialCareUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label191;
        }
      }
      label191:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        if (l2 <= l1)
        {
          boolean bool3 = new File(BaseApplicationImpl.getApplication().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json").exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean atp()
  {
    try
    {
      long l1 = this.app.getPreferences().getLong("nextCheckUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendTemplateCheckUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label149;
        }
      }
      label149:
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
  
  private boolean atq()
  {
    boolean bool2 = false;
    try
    {
      long l1 = this.app.getPreferences().getLong("nextCheckLabelUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendCheckLabelUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label190;
        }
      }
      label190:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        localObject = new File(aqep.aW(this.app.getApplication()));
        if (l2 <= l1)
        {
          boolean bool3 = ((File)localObject).exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean atr()
  {
    return false;
  }
  
  /* Error */
  private void y(File paramFile)
  {
    // Byte code:
    //   0: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 148
    //   8: iconst_2
    //   9: new 150	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 350
    //   19: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 320	java/io/File:exists	()Z
    //   26: invokevirtual 308	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_1
    //   36: invokevirtual 320	java/io/File:exists	()Z
    //   39: ifeq +98 -> 137
    //   42: new 352	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 354	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: astore 4
    //   52: aload 4
    //   54: astore_3
    //   55: new 30	java/io/ByteArrayOutputStream
    //   58: dup
    //   59: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   62: astore 5
    //   64: aload 4
    //   66: astore_3
    //   67: sipush 4096
    //   70: newarray byte
    //   72: astore 6
    //   74: aload 4
    //   76: astore_3
    //   77: aload 4
    //   79: aload 6
    //   81: iconst_0
    //   82: sipush 4096
    //   85: invokevirtual 360	java/io/InputStream:read	([BII)I
    //   88: istore_2
    //   89: iload_2
    //   90: iconst_m1
    //   91: if_icmpeq +47 -> 138
    //   94: aload 4
    //   96: astore_3
    //   97: aload 5
    //   99: aload 6
    //   101: iconst_0
    //   102: iload_2
    //   103: invokevirtual 364	java/io/ByteArrayOutputStream:write	([BII)V
    //   106: goto -32 -> 74
    //   109: astore_3
    //   110: aload 4
    //   112: astore_1
    //   113: aload_3
    //   114: astore 4
    //   116: aload_1
    //   117: astore_3
    //   118: ldc 148
    //   120: iconst_1
    //   121: ldc_w 366
    //   124: aload 4
    //   126: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 371	java/io/InputStream:close	()V
    //   137: return
    //   138: aload 4
    //   140: astore_3
    //   141: aload 4
    //   143: invokevirtual 371	java/io/InputStream:close	()V
    //   146: aload 4
    //   148: astore_3
    //   149: aload_1
    //   150: new 49	java/io/File
    //   153: dup
    //   154: aload_0
    //   155: getfield 19	alcm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   158: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   161: invokestatic 346	aqep:aW	(Landroid/content/Context;)Ljava/lang/String;
    //   164: invokespecial 347	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: invokevirtual 375	java/io/File:renameTo	(Ljava/io/File;)Z
    //   170: pop
    //   171: aload 4
    //   173: astore_3
    //   174: new 159	java/lang/String
    //   177: dup
    //   178: aload 5
    //   180: invokevirtual 72	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   183: ldc_w 377
    //   186: invokespecial 380	java/lang/String:<init>	([BLjava/lang/String;)V
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull +21 -> 212
    //   194: aload 4
    //   196: astore_3
    //   197: aload_1
    //   198: invokevirtual 163	java/lang/String:length	()I
    //   201: ifle +11 -> 212
    //   204: aload 4
    //   206: astore_3
    //   207: aload_0
    //   208: aload_1
    //   209: invokespecial 382	alcm:NW	(Ljava/lang/String;)V
    //   212: aload 4
    //   214: ifnull -77 -> 137
    //   217: aload 4
    //   219: invokevirtual 371	java/io/InputStream:close	()V
    //   222: return
    //   223: astore_1
    //   224: ldc 148
    //   226: iconst_1
    //   227: ldc_w 366
    //   230: aload_1
    //   231: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: return
    //   235: astore_1
    //   236: aload 4
    //   238: astore_3
    //   239: aload_1
    //   240: invokevirtual 323	java/lang/Exception:printStackTrace	()V
    //   243: goto -72 -> 171
    //   246: astore_1
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 371	java/io/InputStream:close	()V
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: ldc 148
    //   260: iconst_1
    //   261: ldc_w 366
    //   264: aload_1
    //   265: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: return
    //   269: astore_3
    //   270: ldc 148
    //   272: iconst_1
    //   273: ldc_w 366
    //   276: aload_3
    //   277: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: goto -25 -> 255
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_3
    //   286: goto -39 -> 247
    //   289: astore 4
    //   291: aconst_null
    //   292: astore_1
    //   293: goto -177 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	alcm
    //   0	296	1	paramFile	File
    //   88	15	2	i	int
    //   54	43	3	localObject1	Object
    //   109	5	3	localException1	Exception
    //   117	135	3	localObject2	Object
    //   269	8	3	localException2	Exception
    //   285	1	3	localObject3	Object
    //   50	187	4	localObject4	Object
    //   289	1	4	localException3	Exception
    //   62	117	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   72	28	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   55	64	109	java/lang/Exception
    //   67	74	109	java/lang/Exception
    //   77	89	109	java/lang/Exception
    //   97	106	109	java/lang/Exception
    //   141	146	109	java/lang/Exception
    //   174	190	109	java/lang/Exception
    //   197	204	109	java/lang/Exception
    //   207	212	109	java/lang/Exception
    //   239	243	109	java/lang/Exception
    //   217	222	223	java/lang/Exception
    //   149	171	235	java/lang/Exception
    //   55	64	246	finally
    //   67	74	246	finally
    //   77	89	246	finally
    //   97	106	246	finally
    //   118	129	246	finally
    //   141	146	246	finally
    //   149	171	246	finally
    //   174	190	246	finally
    //   197	204	246	finally
    //   207	212	246	finally
    //   239	243	246	finally
    //   133	137	257	java/lang/Exception
    //   251	255	269	java/lang/Exception
    //   42	52	283	finally
    //   42	52	289	java/lang/Exception
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject1;
    if (!apI()) {
      localObject1 = null;
    }
    String str1;
    String str2;
    ReqItem localReqItem;
    int i;
    do
    {
      return localObject1;
      localObject1 = this.app.getPreferences();
      long l = System.currentTimeMillis();
      ((SharedPreferences)localObject1).edit().putLong("nextCheckUpdateTimeMillis", l + 3600000L).commit();
      str1 = ((SharedPreferences)localObject1).getString("cardTemplateVersion", "0");
      str2 = ((SharedPreferences)localObject1).getString("profileLabelVersion", "0");
      Object localObject2 = ((SharedPreferences)localObject1).getString("profileFuncallVersion", "0");
      String str3 = ((SharedPreferences)localObject1).getString("WebviewCGIWhitelistVersion", "0");
      localReqItem = new ReqItem();
      localReqItem.eServiceID = 122;
      localObject1 = new SummaryCardUpdate.SUpdateReqBatch();
      SummaryCardUpdate.SUpdateReq localSUpdateReq;
      if ((this.flag & 0x1) != 0)
      {
        localSUpdateReq = a(3, str1);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.flag & 0x2) != 0)
      {
        localSUpdateReq = a(4, str2);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.flag & 0x4) != 0)
      {
        localSUpdateReq = a(5, (String)localObject2);
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add(localSUpdateReq);
      }
      if ((this.flag & 0x8) != 0)
      {
        localObject2 = a(5, (String)localObject2);
        ((SummaryCardUpdate.SUpdateReq)localObject2).appname.set("special_remind");
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add((MessageMicro)localObject2);
      }
      if ((this.flag & 0x10) != 0)
      {
        localObject2 = a(6, str3);
        ((SummaryCardUpdate.SUpdateReq)localObject2).appname.set("white_list");
        ((SummaryCardUpdate.SUpdateReqBatch)localObject1).reqs.add((MessageMicro)localObject2);
      }
      localObject1 = ((SummaryCardUpdate.SUpdateReqBatch)localObject1).toByteArray();
      paramInt = localObject1.length;
      i = paramInt + 4;
      localObject2 = new byte[i];
      System.arraycopy(aqcz.intToByte(i), 0, localObject2, 0, 4);
      System.arraycopy(localObject1, 0, localObject2, 4, paramInt);
      localReqItem.vecParam = ((byte[])localObject2);
      localObject1 = localReqItem;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "getCheckUpdateItemData uin=" + this.app.getLongAccountUin() + ",cardVersion=" + str1 + "labelVersion=" + str2 + ",client_version=" + "3.4.4" + ",dataLen=" + i);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      int i = paramRespItem.cResult;
      Object localObject = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "handleCheckUpdateItemData result=" + i + ",dataLen=" + localObject.length);
      }
      if (i == 2) {
        for (;;)
        {
          try
          {
            if (localObject.length <= 4) {
              break;
            }
            i = (int)aqoj.getLongData((byte[])localObject, 0);
            paramRespItem = new byte[i - 4];
            aqoj.copyData(paramRespItem, 0, (byte[])localObject, 4, i - 4);
            localObject = new SummaryCardUpdate.SUpdateRspBatch();
            ((SummaryCardUpdate.SUpdateRspBatch)localObject).mergeFrom(paramRespItem);
            if (((SummaryCardUpdate.SUpdateRspBatch)localObject).rsps.size() < 0)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate SUpdateRspBatch have no rsp");
              return;
            }
            paramRespItem = ((SummaryCardUpdate.SUpdateRspBatch)localObject).rsps.get().iterator();
            if (!paramRespItem.hasNext()) {
              break;
            }
            localObject = (SummaryCardUpdate.SUpdateRsp)paramRespItem.next();
            if (localObject == null) {
              continue;
            }
            i = ((SummaryCardUpdate.SUpdateRsp)localObject).cmd.get();
            if (i == 3)
            {
              e((SummaryCardUpdate.SUpdateRsp)localObject);
              continue;
            }
            if (i != 4) {
              break label242;
            }
          }
          catch (Exception paramRespItem)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate Exception msg=" + paramRespItem.getMessage());
            }
            paramRespItem.printStackTrace();
            return;
          }
          d((SummaryCardUpdate.SUpdateRsp)localObject);
          continue;
          label242:
          if (i == 5)
          {
            if ((((SummaryCardUpdate.SUpdateRsp)localObject).appname != null) && (((SummaryCardUpdate.SUpdateRsp)localObject).appname.get().equals("special_remind"))) {
              b((SummaryCardUpdate.SUpdateRsp)localObject);
            } else {
              a((SummaryCardUpdate.SUpdateRsp)localObject);
            }
          }
          else if (i == 6) {
            c((SummaryCardUpdate.SUpdateRsp)localObject);
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleCheckUpdateItemData respitem is null");
    }
  }
  
  public void a(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    paramSUpdateRsp.buff.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleFunCallRsp data code=" + i + ",version=" + str1 + ",url=" + str2 + ",interval=" + j);
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate code == 0" + j);
      }
      return;
    }
    arts.a().a("SummaryCardUpdate.EM_RT_FUN_CALL", 100, i, this.app.getCurrentAccountUin(), 1000277, acfp.m(2131709919), true);
  }
  
  public boolean apI()
  {
    boolean bool1 = false;
    boolean bool3 = atp();
    boolean bool4 = atq();
    boolean bool5 = atn();
    boolean bool6 = ato();
    boolean bool2 = atr();
    int j = this.flag;
    if (bool3)
    {
      i = 1;
      this.flag = (i | j);
      j = this.flag;
      if (!bool4) {
        break label163;
      }
      i = 2;
      label63:
      this.flag = (i | j);
      j = this.flag;
      if (!bool5) {
        break label168;
      }
      i = 4;
      label82:
      this.flag = (i | j);
      j = this.flag;
      if (!bool6) {
        break label173;
      }
      i = 8;
      label102:
      this.flag = (i | j);
      j = this.flag;
      if (!bool2) {
        break label178;
      }
    }
    label163:
    label168:
    label173:
    label178:
    for (int i = 16;; i = 0)
    {
      this.flag = (i | j);
      if ((bool3) || (bool4) || (bool5) || (bool6) || (bool2)) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label63;
      i = 0;
      break label82;
      i = 0;
      break label102;
    }
  }
  
  public void b(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str2 = paramSUpdateRsp.version.get();
    String str1 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSpecialCareRsp data code=" + i + ",version=" + str2 + ",url=" + str1 + ",interval=" + j);
    }
    if (i == 0)
    {
      paramSUpdateRsp = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      str2 = paramSUpdateRsp.getString("specialcare_config", "");
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        paramSUpdateRsp.edit().putLong("specialcareCheckUpdateTime", l1 + l2).commit();
      }
      if ((str1 != null) && (!str1.equals(str2)))
      {
        paramSUpdateRsp.edit().putString("specialcare_config", str1).commit();
        paramSUpdateRsp.edit().putBoolean("special_care_red_point_one", true).commit();
        paramSUpdateRsp.edit().putBoolean("special_care_red_point_two", true).commit();
        ThreadManager.post(new ProfileCardCheckUpdate.1(this), 5, null, true);
      }
      return;
    }
    arts.a().a("SummaryCardUpdate.EM_RT_SPECIAL_REMIND", 100, i, this.app.getCurrentAccountUin(), 1000277, acfp.m(2131709954), true);
  }
  
  public void c(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp) {}
  
  public void d(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryLabelRsp data code=" + i + ",version=" + str1 + ",url=" + str2 + ",interval=" + j);
    }
    if (i == 0)
    {
      paramSUpdateRsp = this.app.getPreferences();
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        paramSUpdateRsp.edit().putLong("nextCheckLabelUpdateTimeMillis", l1 + l2).commit();
      }
      if ((!paramSUpdateRsp.getString("profileLabelVersion", "0").equals(str1)) && (str2 != null)) {
        gV(str2, str1);
      }
      return;
    }
    arts.a().a("SummaryCardUpdate.EM_RT_SUMMARY_LABEL", 100, i, this.app.getCurrentAccountUin(), 1000277, acfp.m(2131709924), true);
  }
  
  public void e(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryUpdateRsp data code=" + i + ",version=" + str1 + ",url=" + str2 + ",interval=" + j);
    }
    if (i == 0)
    {
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (j >= 0))
      {
        paramSUpdateRsp = this.app.getPreferences().edit();
        paramSUpdateRsp.putLong("nextCheckUpdateTimeMillis", System.currentTimeMillis() + j * 1000);
        paramSUpdateRsp.putString("cardTemplateServerUrl", str2);
        paramSUpdateRsp.putString("cardTemplateServerVersion", str1);
        paramSUpdateRsp.commit();
      }
      return;
    }
    arts.a().a("SummaryCardUpdate.EM_RT_SUMMARY_UPDATE", 100, i, this.app.getCurrentAccountUin(), 1000277, acfp.m(2131709944), true);
  }
  
  public void gV(String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new ProfileCardCheckUpdate.2(this, paramString1, paramString2), 128, null, false);
  }
  
  public int mT()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alcm
 * JD-Core Version:    0.7.0.1
 */