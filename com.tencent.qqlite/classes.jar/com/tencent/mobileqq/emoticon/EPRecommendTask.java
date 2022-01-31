package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class EPRecommendTask
  extends AsyncTask
{
  public static final String a = "1";
  public static final String b = "http://imgcache.qq.com/club/item/parcel/android_tab.json";
  public static final String c = "2";
  public static final String d = "http://imgcache.qq.com/club/item/parcel/android_magictab.json";
  QQAppInterface a;
  
  public EPRecommendTask(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public String a(String... paramVarArgs)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = EmosmUtils.insertMtype("VIP_emosm", paramVarArgs[0]);
    paramVarArgs = paramVarArgs[1];
    if (paramVarArgs == null)
    {
      localObject1 = localObject2;
      return localObject1;
    }
    for (;;)
    {
      Object localObject5;
      try
      {
        localObject5 = new File(AppConstants.aN + "tab" + paramVarArgs + ".tmp");
        DownloadTask localDownloadTask = new DownloadTask((String)localObject1, (File)localObject5);
        localDownloadTask.h = true;
        localObject1 = localObject2;
        if (DownloaderFactory.a(localDownloadTask, this.a) != 0) {
          break;
        }
        localObject5 = FileUtils.a((File)localObject5);
        localObject1 = localObject2;
        if (localObject5 == null) {
          break;
        }
        if ((paramVarArgs == null) || (!"2".equals(paramVarArgs))) {
          break label159;
        }
        EmoticonUtils.a(this.a, (byte[])localObject5);
        return null;
      }
      catch (Exception localException1)
      {
        paramVarArgs = localObject4;
        localObject1 = paramVarArgs;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, localException1.getMessage());
      return paramVarArgs;
      label159:
      paramVarArgs = new String((byte[])localObject5, "utf-8");
      if (paramVarArgs != null) {
        try
        {
          Object localObject3 = EmoticonUtils.a(paramVarArgs);
          if (localObject3 != null)
          {
            this.a.getApplication().getSharedPreferences("QQLite", 0).edit().putString("emosm_recommend_tab_json", paramVarArgs).commit();
            localObject1 = (EmojiManager)this.a.getManager(39);
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((EmojiManager)localObject1).a((EmoticonPackage)((Iterator)localObject3).next());
            }
          }
        }
        catch (Exception localException2) {}
      }
    }
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPRecommendTask
 * JD-Core Version:    0.7.0.1
 */