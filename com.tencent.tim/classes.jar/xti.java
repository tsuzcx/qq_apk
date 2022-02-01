import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.AppRuntime;

class xti
  implements AdapterView.OnItemClickListener
{
  xti(xsk paramxsk, AIOImageData paramAIOImageData, xuf paramxuf, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.this$0.c.dismiss();
    localObject = ((ShareActionSheetBuilder.b)localObject).b;
    int i = ((ShareActionSheetBuilder.ActionSheetItem)localObject).action;
    localObject = ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus;
    switch (i)
    {
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 67: 
    case 68: 
    default: 
      i = 0;
    }
    for (;;)
    {
      label163:
      anot.a(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      break;
      i = 12;
      xsk.a(this.this$0, this.a);
      continue;
      i = 1;
      xsk.a(this.this$0, this.c);
      continue;
      this.this$0.reportData("Pic_Forward_Qzone", 0);
      xtm.a(xsk.n(this.this$0), this.this$0.aWf, this.this$0.aRJ, this.this$0.bWP, this.c, this.this$0.biK, this.this$0.QE);
      if (this.this$0.biJ)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
        i = 4;
        continue;
        i = 5;
        xsk.b(this.this$0, this.a);
        continue;
        i = 2;
        xsk.a(this.this$0, this.a, this.c, this.S);
        continue;
        Intent localIntent = new Intent();
        localIntent.putExtra("preResult", (String)localObject);
        this.this$0.a(this.this$0.aWg, this.a.istroop, this.a.bjg, this.a.send_uin, this.a.md5, this.a.aWj, this.a.uuid, 1, localIntent);
        anot.a(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        continue;
        localIntent = new Intent();
        localIntent.putExtra("preResult", (String)localObject);
        this.this$0.a(this.this$0.aWg, this.a.istroop, this.a.bjg, this.a.send_uin, this.a.md5, this.a.aWj, this.a.uuid, 2, localIntent);
        i = 10;
        continue;
        i = 3;
        xsk.a(this.this$0, this.c, this.S);
        continue;
        i = 8;
        OCRResultActivity.n(xsk.o(this.this$0), this.S.getAbsolutePath(), 1);
        continue;
        i = 6;
        xsk.c(this.this$0, this.a);
        continue;
        localObject = this.this$0.QE;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          localObject = this.this$0.mFriendUin;
        }
        for (;;)
        {
          anot.a(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.this$0.bWR, 0, "", "", "", "");
          xsk.a(xsk.p(this.this$0), this.this$0.mCurType, this.this$0.mFriendUin, (String)localObject, this.a.time, this.a.shmsgseq, this.a.istroop, false);
          i = 7;
          break label163;
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((this.this$0.a == null) || (localObject == null)) {
            break;
          }
          if (this.a.bdq)
          {
            this.this$0.a.safetyReport(this.this$0.mCurType, true, this.a.TI, this.a.aWk, ((AppRuntime)localObject).getAccount(), this.a.content);
            i = 0;
            break label163;
          }
          this.this$0.a.safetyReport(this.this$0.mCurType, false, this.a.send_uin, this.a.aWk, ((AppRuntime)localObject).getAccount(), this.a.content);
          i = 0;
          break label163;
          PicShareToWX.a(this.S.getPath(), xsk.q(this.this$0), 1);
          anot.a(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
          break;
        }
      }
      else
      {
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xti
 * JD-Core Version:    0.7.0.1
 */