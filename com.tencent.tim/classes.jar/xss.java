import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.AppRuntime;

class xss
  implements AdapterView.OnItemClickListener
{
  xss(xsk paramxsk, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, xuf paramxuf) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.this$0.c.dismiss();
      switch (((ShareActionSheetBuilder.b)localObject).b.action)
      {
      }
      for (;;)
      {
        localObject = this.this$0.b.c();
        if ((localObject == null) || (((xuf)localObject).e == null) || (!AIOShortVideoData.class.isInstance(((xuf)localObject).e))) {
          break;
        }
        localObject = (AIOShortVideoData)((xuf)localObject).e;
        if (((AIOShortVideoData)localObject).mBusiType != 0) {
          break label641;
        }
        anot.a(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        break;
        i = 1;
        xsk.a(this.this$0, this.a);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
        }
        localObject = avpw.d.a();
        ((avpw.d)localObject).cMP = this.this$0.aWf;
        avpw.c(xsk.t(this.this$0), (avpw.d)localObject, this.val$file.getAbsolutePath(), 10001);
        anot.a(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        continue;
        xsk.a(this.this$0, this.a, this.val$file, this.val$from, this.c);
        continue;
        anot.a(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.this$0.bWR, 0, "", "", "", "");
        String str = this.this$0.QE;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.this$0.mFriendUin;
        }
        xsk.a(xsk.u(this.this$0), this.this$0.mCurType, this.this$0.mFriendUin, (String)localObject, this.a.time, this.a.shmsgseq, this.a.istroop, false);
        i = 6;
        continue;
        int j = 3;
        i = j;
        if (this.this$0.a.asBinder().pingBinder())
        {
          localObject = this.this$0.a.getForwardData(this.a.id, this.a.subId, this.this$0.mCurType);
          i = j;
          if (localObject != null)
          {
            aviz.a((Intent)localObject).b(xsk.v(this.this$0), BaseApplicationImpl.getApplication().getRuntime().getAccount());
            avjg.a(null, 3, 0, this.a.istroop);
            avjg.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
            i = j;
            continue;
            i = 7;
            xsk.b(this.this$0, this.a);
            continue;
            j = 6;
            i = j;
            if (this.this$0.a.asBinder().pingBinder())
            {
              this.this$0.a.saveToWeiyun(this.a.id);
              QQToast.a(xsk.w(this.this$0), xsk.x(this.this$0).getString(2131694101), 0).show();
              i = j;
            }
          }
        }
      }
      label641:
      if (((AIOShortVideoData)localObject).mBusiType == 1) {
        anot.a(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xss
 * JD-Core Version:    0.7.0.1
 */