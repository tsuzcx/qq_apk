package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EPJsonTask
  implements TaskInterface
{
  public static int a;
  public static int b;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  private EmoticonController.ProgressHandler jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private ArrayList b;
  private int c;
  private int d = jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = jdField_a_of_type_Int + 1;
  }
  
  public EPJsonTask(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
    Object localObject1;
    String str1;
    int j;
    label96:
    label115:
    int n;
    label134:
    int k;
    try
    {
      localObject1 = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      str1 = ((JSONObject)localObject1).getString("id");
      localObject2 = ((JSONObject)localObject1).getString("name");
      if (!((JSONObject)localObject1).has("mark")) {
        break label1278;
      }
      paramArrayOfByte = ((JSONObject)localObject1).getString("mark");
      if (!((JSONObject)localObject1).has("type")) {
        break label1273;
      }
      j = ((JSONObject)localObject1).getInt("type");
      if (!((JSONObject)localObject1).has("feetype")) {
        break label1267;
      }
      m = ((JSONObject)localObject1).getInt("feetype");
      if (!((JSONObject)localObject1).has("updateTime")) {
        break label1261;
      }
      n = ((JSONObject)localObject1).getInt("updateTime");
      bool2 = false;
      k = 0;
      i = k;
      bool1 = bool2;
      if (((JSONObject)localObject1).has("ringtype"))
      {
        localObject3 = ((JSONObject)localObject1).getString("ringtype");
        if (!"1".equals(localObject3)) {
          break label749;
        }
        bool1 = true;
        i = k;
      }
      if ((!((JSONObject)localObject1).has("type")) || (1 != j)) {
        break label1255;
      }
      k = 3;
      label200:
      i = 0;
      if (((JSONObject)localObject1).has("downloadcount")) {
        i = ((JSONObject)localObject1).getInt("downloadcount");
      }
      localEmoticonPackage.name = ((String)localObject2);
      localEmoticonPackage.mark = paramArrayOfByte;
      localEmoticonPackage.type = j;
      localEmoticonPackage.mobileFeetype = m;
      localEmoticonPackage.hasSound = bool1;
      localEmoticonPackage.downloadCount = i;
      localEmoticonPackage.jobType = k;
      if (this.d != jdField_b_of_type_Int) {
        localEmoticonPackage.localVersion = n;
      }
      if ((localEmoticonPackage.mobileFeetype != 1) && (!localEmoticonPackage.isRecommendation) && (localEmoticonPackage.jobType != 1)) {
        break label775;
      }
      localEmoticonPackage.wordingId = 1L;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        boolean bool2;
        boolean bool1;
        Object localObject3;
        localJSONException.printStackTrace();
        localObject1 = localJSONException.toString();
        this.c = 11008;
        paramArrayOfByte = (byte[])localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.emoji.EmoDown", 2, "PARSE_EMOTICON_JSON fail 01 result=" + this.c + " RESULT_CODE_JSON_PARSE_FAIL " + " ep=" + localEmoticonPackage.epId + " exception=" + localJSONException.toString());
          paramArrayOfByte = (byte[])localObject1;
        }
        return paramArrayOfByte;
        localEmoticonPackage.wordingId = -1L;
      }
    }
    catch (Exception localException)
    {
      label315:
      label749:
      do
      {
        localException.printStackTrace();
        localObject1 = localException.toString();
        this.c = 11008;
        paramArrayOfByte = (byte[])localObject1;
      } while (!QLog.isColorLevel());
      label524:
      QLog.d("Q.emoji.EmoDown", 2, "PARSE_EMOTICON_JSON fail 02 result=" + this.c + " RESULT_CODE_JSON_PARSE_FAIL " + " ep=" + localEmoticonPackage.epId + " exception=" + localException.toString());
      label775:
      return localObject1;
    }
    localEmoticonManager.a(localEmoticonPackage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "PARSE_EMOTICON_JSON epId[" + str1 + "]name[" + (String)localObject2 + "]mark[" + paramArrayOfByte + "]type[" + j + "]feetype[" + m + "]");
    }
    localObject3 = ((JSONObject)localObject1).getJSONArray("imgs");
    int i3 = ((JSONArray)localObject3).length();
    int i = 1;
    int m = 0;
    for (;;)
    {
      String str2;
      String str3;
      if (m < i3)
      {
        paramArrayOfByte = ((JSONArray)localObject3).getJSONObject(m);
        str2 = paramArrayOfByte.getString("id");
        str3 = paramArrayOfByte.getString("name");
        if (!paramArrayOfByte.has("wWidthInPhone")) {
          break label1250;
        }
      }
      label1039:
      label1250:
      for (j = paramArrayOfByte.getInt("wWidthInPhone");; j = 0)
      {
        if (paramArrayOfByte.has("wHeightInPhone")) {}
        for (int i1 = paramArrayOfByte.getInt("wHeightInPhone");; i1 = 0)
        {
          int i2;
          if (paramArrayOfByte.has("keywords"))
          {
            localObject1 = paramArrayOfByte.getJSONArray("keywords");
            if (str3 != null) {
              ((JSONArray)localObject1).put(str3);
            }
            paramArrayOfByte = paramArrayOfByte.getJSONArray("keywords").toString();
            localObject2 = localEmoticonManager.a(str1, str2);
            i2 = 0;
            if (localObject2 != null) {
              break label1039;
            }
            n = i2;
            localObject1 = localObject2;
            if (this.d != jdField_b_of_type_Int)
            {
              localObject2 = new Emoticon();
              ((Emoticon)localObject2).eId = str2;
              ((Emoticon)localObject2).epId = str1;
              ((Emoticon)localObject2).name = str3;
              ((Emoticon)localObject2).width = j;
              ((Emoticon)localObject2).height = i1;
              ((Emoticon)localObject2).keywords = paramArrayOfByte;
              j = 1;
              this.jdField_a_of_type_Boolean = true;
              n = i2;
              localObject1 = localObject2;
              i = j;
              if (EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage))
              {
                this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
                n = 1;
                i = j;
                localObject1 = localObject2;
              }
            }
          }
          for (;;)
          {
            ((Emoticon)localObject1).isSound = localEmoticonPackage.hasSound;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            if ((i != 0) && (n == 0)) {
              localEmoticonManager.a((Emoticon)localObject1);
            }
            if (!QLog.isColorLevel()) {
              break label1285;
            }
            QLog.d("Q.emoji.EmoDown", 2, "emoticon eId[" + str2 + "]eName[" + str3 + "]");
            break label1285;
            i = k;
            bool1 = bool2;
            if (!"2".equals(localObject3)) {
              break;
            }
            i = 1;
            bool1 = bool2;
            break;
            localObject3 = localEmoticonManager.b(str1);
            if (localObject3 != null)
            {
              localEmoticonPackage.wordingId = ((EmoticonPackage)localObject3).wordingId;
              break label315;
            }
            paramArrayOfByte = "[" + str3 + "]";
            break label524;
            if ((!str2.equals(localException.eId)) || (!str1.equals(localException.epId)) || (!str3.equals(localException.name)))
            {
              localException.eId = str2;
              localException.epId = str1;
              localException.name = str3;
              localException.width = j;
              localException.height = i1;
              localException.keywords = paramArrayOfByte;
              i = 1;
              this.jdField_a_of_type_Boolean = true;
              n = i2;
              localObject1 = localException;
            }
            else
            {
              j = 0;
              if (!paramArrayOfByte.equals(localException.keywords))
              {
                j = 1;
                localException.keywords = paramArrayOfByte;
              }
              if (localException.encryptKey != null)
              {
                n = i2;
                localObject1 = localException;
                i = j;
                if (localException.encryptKey.length() != 0) {}
              }
              else
              {
                this.jdField_a_of_type_Boolean = true;
                n = i2;
                localObject1 = localException;
                i = j;
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Int = i3;
          if (k == 3)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Int = 100;
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_b_of_type_Int = 0;
          }
          this.c = 0;
          return null;
        }
      }
      label1255:
      k = i;
      break label200;
      label1261:
      n = 0;
      break label134;
      label1267:
      m = 0;
      break label115;
      label1273:
      j = 0;
      break label96;
      label1278:
      paramArrayOfByte = "";
      break;
      label1285:
      m += 1;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    String str = EmosmUtils.getEmosmJsonUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    DownloadInfo localDownloadInfo = new DownloadInfo(str, null, 1);
    HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDownloadInfo, null, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
    Object localObject2;
    if ((localDownloadInfo.i != null) && (localDownloadInfo.i.contains("gzip")))
    {
      localObject1 = Utils.a(localDownloadInfo.a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("GET_EMOTICON_JSON data=");
        if (localObject1 != null) {
          break label330;
        }
        localObject2 = "NULL";
        label94:
        QLog.d("Q.emoji.EmoDown", 2, localObject2 + " epId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " url[" + str + "]");
      }
      if ((localDownloadInfo.jdField_b_of_type_Int != 0) || (localObject1 == null) || (localObject1.length <= 0)) {
        break label339;
      }
    }
    for (Object localObject1 = a((byte[])localObject1);; localObject1 = null)
    {
      if ((this.c == 11008) && (Utils.e()) && (Utils.b() > 1048576L)) {
        FileUtils.a(AppConstants.an + "err" + File.separator + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + ".json", localDownloadInfo.a, false);
      }
      if (this.d != jdField_b_of_type_Int) {
        EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.c);
      }
      if ((this.c != 0) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler != null) && (localDownloadInfo != null))
      {
        localDownloadInfo.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.a("param_error", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.a("param_step", 1);
      }
      return;
      localObject1 = localDownloadInfo.a;
      break;
      label330:
      localObject2 = Integer.valueOf(localObject1.length);
      break label94;
      label339:
      this.c = EmosmUtils.checkResultCode(localDownloadInfo.jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if ((paramProgressHandler != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler = paramProgressHandler;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPJsonTask
 * JD-Core Version:    0.7.0.1
 */