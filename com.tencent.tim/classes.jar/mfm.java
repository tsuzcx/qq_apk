import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class mfm
  extends aquy
{
  mfm(mfl parammfl, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(aquz paramaquz)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Mfl.kR.size())
    {
      ((aquy)this.jdField_a_of_type_Mfl.kR.get(i)).onCancel(paramaquz);
      i += 1;
    }
    String str = paramaquz.getParams().getString("resId");
    this.jdField_a_of_type_Mfl.ed.remove(this.val$prefix + "_" + str);
    super.onCancel(paramaquz);
    this.jdField_a_of_type_Mfl.a("onCancel", paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onCancel");
    }
  }
  
  public void onDone(aquz paramaquz)
  {
    Object localObject = paramaquz.getParams();
    String str1 = ((Bundle)localObject).getString("resId");
    String str2 = ((Bundle)localObject).getString("prefix");
    if (paramaquz.errCode == 0)
    {
      localObject = new File(this.agy);
      if (!((File)localObject).exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData))
          {
            if (!((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData).res_md5.equals(aqhq.px(((File)localObject).getPath()).toLowerCase()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData check file md5  failed: id = " + str1);
              }
              if ((!aqhq.deleteFile(((File)localObject).getPath())) && (QLog.isColorLevel())) {
                QLog.d("ReadInJoyBaseResManager", 2, "MaterialData deleteFile file   failed: id = " + str1);
              }
              kma.a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, false, "check file md5 failed");
              return;
            }
            aqhq.W(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Mfl.U(str2, str1), false);
            this.jdField_a_of_type_Mfl.br.put(paramaquz.key, this.jdField_a_of_type_Mfl.U(str2, str1));
            this.jdField_a_of_type_Mfl.a(this.jdField_a_of_type_Mfl.mApp.getApp(), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            ((File)localObject).delete();
            this.jdField_a_of_type_Mfl.ed.remove(str2 + "_" + str1);
            this.jdField_a_of_type_Mfl.a(str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
            i = 0;
            if (i >= this.jdField_a_of_type_Mfl.kR.size()) {
              break;
            }
            ((aquy)this.jdField_a_of_type_Mfl.kR.get(i)).onDone(paramaquz);
            i += 1;
            continue;
          }
          aqhq.W(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_Mfl.aZ(str2), false);
          continue;
          try
          {
            aqhq.m(this.jdField_a_of_type_Mfl.U(str2, str1));
            if (!aqhq.fileExists((String)this.jdField_a_of_type_Mfl.br.get(paramaquz.key))) {
              continue;
            }
            aqhq.c((String)this.jdField_a_of_type_Mfl.br.get(paramaquz.key), this.jdField_a_of_type_Mfl.U(str2, str1), false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_Mfl.br.get(paramaquz.key) + " to :" + this.jdField_a_of_type_Mfl.U(str2, str1));
          }
          catch (Exception localException) {}
        }
        catch (Exception paramaquz)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(paramaquz));
          }
          return;
        }
        finally
        {
          ((File)localObject).delete();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyBaseResManager", 2, "t is the same url copy to another dir path failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide failed: id = " + str1);
          }
        }
      }
      this.jdField_a_of_type_Mfl.a("onDone", paramaquz);
      int i = paramaquz.errCode;
      long l1 = paramaquz.aua;
      long l2 = paramaquz.atZ;
      this.jdField_a_of_type_Mfl.q(new String[] { String.valueOf(i), str1, String.valueOf(l1 - l2) });
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "mDownloader downLoadFinish");
  }
  
  public void onProgress(aquz paramaquz)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Mfl.kR.size())
    {
      ((aquy)this.jdField_a_of_type_Mfl.kR.get(i)).onProgress(paramaquz);
      i += 1;
    }
    super.onProgress(paramaquz);
    this.jdField_a_of_type_Mfl.a("onProgress", paramaquz);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Mfl.kR.size())
    {
      ((aquy)this.jdField_a_of_type_Mfl.kR.get(i)).onStart(paramaquz);
      i += 1;
    }
    this.jdField_a_of_type_Mfl.a("onStart", paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mDownloader onStart");
    }
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfm
 * JD-Core Version:    0.7.0.1
 */