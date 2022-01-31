package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class EPRecommendTask
  extends AsyncTask
{
  QQAppInterface a;
  
  public EPRecommendTask(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public String a(String... paramVarArgs)
  {
    Iterator localIterator = null;
    SharedPreferences localSharedPreferences = null;
    Object localObject2 = paramVarArgs[0];
    String str = paramVarArgs[1];
    for (;;)
    {
      try
      {
        localObject2 = new DownloadInfo((String)localObject2, null, 1);
        ((DownloadInfo)localObject2).jdField_b_of_type_Boolean = true;
        HttpDownloadUtil.a(this.a, (DownloadInfo)localObject2, null, null);
        if ((((DownloadInfo)localObject2).i == null) || (!((DownloadInfo)localObject2).i.contains("gzip"))) {
          continue;
        }
        paramVarArgs = Utils.a(((DownloadInfo)localObject2).a);
        try
        {
          if ((((DownloadInfo)localObject2).jdField_b_of_type_Int != 16) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
            continue;
          }
          localSharedPreferences = this.a.getApplication().getSharedPreferences("mobileQQi", 0);
          localObject2 = localSharedPreferences.getString("emosm_recommend_tab_json_s", "");
          if ((!((String)localObject2).equals("")) && (localObject2 != "")) {
            continue;
          }
          localSharedPreferences.edit().putString("emosm_recommend_tab_json_s", "[{\"name\":\"QQ表情超清版\",\"packageId\":\"10278\"},{\"name\":\"大拇哥\",\"packageId\":\"10548\"},{\"name\":\"暴走漫画\",\"packageId\":\"10335\"},{\"name\":\"炮炮兵乐\",\"packageId\":\"10475\"},{\"name\":\"驴小毛\",\"packageId\":\"10020\"},{\"name\":\"babyQ\",\"packageId\":\"10188\"},{\"name\":\"冷兔耍贱篇\",\"packageId\":\"10326\"}]").commit();
          localIterator = EmoticonUtils.a("[{\"name\":\"QQ表情超清版\",\"packageId\":\"10278\"},{\"name\":\"大拇哥\",\"packageId\":\"10548\"},{\"name\":\"暴走漫画\",\"packageId\":\"10335\"},{\"name\":\"炮炮兵乐\",\"packageId\":\"10475\"},{\"name\":\"驴小毛\",\"packageId\":\"10020\"},{\"name\":\"babyQ\",\"packageId\":\"10188\"},{\"name\":\"冷兔耍贱篇\",\"packageId\":\"10326\"}]").iterator();
          if (!localIterator.hasNext()) {
            continue;
          }
          new EPCoverTask((EmoticonPackage)localIterator.next(), this.a).a();
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1)
        {
          paramVarArgs = "[{\"name\":\"QQ表情超清版\",\"packageId\":\"10278\"},{\"name\":\"大拇哥\",\"packageId\":\"10548\"},{\"name\":\"暴走漫画\",\"packageId\":\"10335\"},{\"name\":\"炮炮兵乐\",\"packageId\":\"10475\"},{\"name\":\"驴小毛\",\"packageId\":\"10020\"},{\"name\":\"babyQ\",\"packageId\":\"10188\"},{\"name\":\"冷兔耍贱篇\",\"packageId\":\"10326\"}]";
        }
      }
      catch (Exception localException3)
      {
        Object localObject1;
        paramVarArgs = localSharedPreferences;
        continue;
      }
      QLog.d("Q.emoji.EmoDown", 2, localException1.getMessage());
      localObject1 = paramVarArgs;
      return localObject1;
      paramVarArgs = ((DownloadInfo)localObject2).a;
      continue;
      if ((str != null) && (str.equals("2")))
      {
        EmoticonUtils.a(this.a, paramVarArgs);
        return "[{\"name\":\"QQ表情超清版\",\"packageId\":\"10278\"},{\"name\":\"大拇哥\",\"packageId\":\"10548\"},{\"name\":\"暴走漫画\",\"packageId\":\"10335\"},{\"name\":\"炮炮兵乐\",\"packageId\":\"10475\"},{\"name\":\"驴小毛\",\"packageId\":\"10020\"},{\"name\":\"babyQ\",\"packageId\":\"10188\"},{\"name\":\"冷兔耍贱篇\",\"packageId\":\"10326\"}]";
      }
      paramVarArgs = new String(paramVarArgs, "utf-8");
      if (paramVarArgs != null) {
        try
        {
          localObject1 = EmoticonUtils.a(paramVarArgs);
          if (localObject1 != null)
          {
            this.a.getApplication().getSharedPreferences("mobileQQi", 0).edit().putString("emosm_recommend_tab_json_s", paramVarArgs).commit();
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              new EPCoverTask((EmoticonPackage)((Iterator)localObject1).next(), this.a).a();
              continue;
            }
          }
        }
        catch (Exception localException2) {}
      }
    }
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPRecommendTask
 * JD-Core Version:    0.7.0.1
 */