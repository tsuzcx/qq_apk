import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import java.io.File;

class ameq
  implements ShareActionSheet.OnItemClickListener
{
  ameq(amem paramamem, AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    int i;
    label763:
    do
    {
      return;
      this.this$0.d.dismiss();
      int j = paramActionSheetItem.action;
      switch (j)
      {
      }
      for (;;)
      {
        i = 0;
        for (;;)
        {
          paramActionSheetItem = this.this$0.b.getSelectedItem();
          if ((paramActionSheetItem == null) || (paramActionSheetItem.baseData == null) || (!AIOVideoData.class.isInstance(paramActionSheetItem.baseData))) {
            break;
          }
          paramActionSheetItem = (AIOVideoData)paramActionSheetItem.baseData;
          if (paramActionSheetItem.mBusiType != 0) {
            break label763;
          }
          anot.a(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
          return;
          i = 1;
          amem.a(this.this$0, this.a, j, paramActionSheetItem);
          continue;
          paramActionSheetItem = avpw.d.a();
          paramActionSheetItem.cMP = amcj.a().yP();
          avpw.c(this.this$0.mContext, paramActionSheetItem, this.val$file.getAbsolutePath(), 10001);
          anot.a(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          i = 4;
          continue;
          amem.a(this.this$0, this.a, this.val$file, this.val$from, this.e);
          i = 0;
          continue;
          anot.a(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", amcj.a().IB(), 0, "", "", "", "");
          paramShareActionSheet = amcj.a().yM();
          paramActionSheetItem = paramShareActionSheet;
          if (TextUtils.isEmpty(paramShareActionSheet)) {
            paramActionSheetItem = amcj.a().yO();
          }
          amdl.a(this.this$0.mContext, amcj.a().Iz(), amcj.a().yO(), paramActionSheetItem, this.a.time, this.a.shmsgseq, this.a.istroop, false);
          i = 6;
          continue;
          i = 3;
          amem.a(this.this$0, this.a);
          continue;
          i = 7;
          amem.b(this.this$0, this.a);
          continue;
          j = 6;
          i = j;
          if (RichMediaBrowserManager.getInstance().getProvider() != null)
          {
            i = j;
            if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
            {
              RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.a.msgId);
              QQToast.a(this.this$0.mContext, this.this$0.mContext.getString(2131694101), 0).show();
              i = j;
              continue;
              paramShareActionSheet = new Intent(this.this$0.mContext, ScannerActivity.class);
              paramShareActionSheet.putExtra("detectType", 1);
              paramShareActionSheet.putExtra("preResult", paramActionSheetItem.argus);
              paramShareActionSheet.putExtra("QRDecode", true);
              amdl.b(this.this$0.mContext, amem.a(this.this$0), this.a.istroop, false, this.a.senderUin, "", "", "", 1, amcj.a().yP(), amcj.a().yO(), paramShareActionSheet);
              amem.a(this.this$0, "0X800ACB7", this.a.istroop);
              i = 0;
            }
          }
        }
        paramShareActionSheet = new Intent(this.this$0.mContext, ScannerActivity.class);
        paramShareActionSheet.putExtra("detectType", 2);
        paramShareActionSheet.putExtra("preResult", paramActionSheetItem.argus);
        paramShareActionSheet.putExtra("QRDecode", true);
        amdl.b(this.this$0.mContext, amem.a(this.this$0), this.a.istroop, false, this.a.senderUin, "", "", "", 2, amcj.a().yP(), amcj.a().yO(), paramShareActionSheet);
        amem.a(this.this$0, "0X800ACB8", this.a.istroop);
      }
    } while (paramActionSheetItem.mBusiType != 1);
    anot.a(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ameq
 * JD-Core Version:    0.7.0.1
 */