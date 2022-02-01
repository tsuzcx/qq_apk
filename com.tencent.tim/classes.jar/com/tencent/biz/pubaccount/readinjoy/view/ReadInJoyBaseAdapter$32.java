package com.tencent.biz.pubaccount.readinjoy.view;

import acja;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kbp;
import kct;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyBaseAdapter$32
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.p.mSubscribeID))
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localObject instanceof QQAppInterface)) {
          break label181;
        }
        localObject = (QQAppInterface)localObject;
        if (localObject != null) {
          if (!((acja)((AppInterface)localObject).getManager(56)).f(Long.valueOf(this.p.mSubscribeID))) {
            break label151;
          }
        }
      }
      label151:
      for (Object localObject = "1";; localObject = "0")
      {
        this.aA.put("fans", localObject);
        String str2 = this.p.mSubscribeID;
        if (TextUtils.isEmpty(this.p.innerUniqueID)) {
          break;
        }
        localObject = this.p.innerUniqueID;
        kbp.a(null, str2, "0X80077B9", "0X80077B9", 0, 0, "", "", (String)localObject, kct.a(null, this.p.mSubscribeID, this.p.mVideoVid, this.p.innerUniqueID, this.aA), false);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video", 2, "report JSON fail");
          continue;
          String str1 = "0";
          continue;
          label181:
          str1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.32
 * JD-Core Version:    0.7.0.1
 */