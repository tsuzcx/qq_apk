package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import avpw;
import awfs;
import awfs.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.model.PublishEventTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class QzoneMoodPlugin$1
  implements Runnable
{
  public QzoneMoodPlugin$1(awfs paramawfs, ArrayList paramArrayList1, String paramString1, int paramInt, Activity paramActivity, String paramString2, ArrayList paramArrayList2, PublishEventTag paramPublishEventTag) {}
  
  public void run()
  {
    Object localObject2;
    if ((this.Fp != null) && (!this.Fp.isEmpty()))
    {
      if (awfs.g().isEmpty()) {
        awfs.a(this.this$0);
      }
      localObject1 = awfs.g().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (awfs.a)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((awfs.a)localObject2).Fv == null) || (((awfs.a)localObject2).bS == null) || (!((awfs.a)localObject2).Fv.equalsIgnoreCase(this.cPR)));
    }
    for (Object localObject1 = ((awfs.a)localObject2).bS;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = this.Fp.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
          String str = (String)((HashMap)localObject1).get(localResultRecord.uin);
          if (!TextUtils.isEmpty(str)) {
            localResultRecord.name = str;
          }
        }
      }
      if (this.eAw == 1)
      {
        avpw.b(this.val$activity, this.this$0.f.mRuntime.a().getCurrentAccountUin(), this.cPS, this.Fq, this.Fp, this.a, -1);
        return;
      }
      avpw.a(this.val$activity, this.this$0.f.mRuntime.a().getCurrentAccountUin(), this.cPS, this.Fq, this.Fp, this.a, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneMoodPlugin.1
 * JD-Core Version:    0.7.0.1
 */