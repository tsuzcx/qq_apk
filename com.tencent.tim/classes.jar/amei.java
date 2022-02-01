import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import java.io.File;

class amei
  implements ShareActionSheet.OnItemClickListener
{
  amei(amea paramamea, AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int j = paramActionSheetItem.action;
    paramShareActionSheet = paramActionSheetItem.argus;
    if (j != 72) {
      this.this$0.d.dismiss();
    }
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    label920:
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      return;
      i = 12;
      amea.a(this.this$0, this.b);
      continue;
      i = 1;
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Contacts", 0);
      }
      paramShareActionSheet = new amda.a();
      paramShareActionSheet.action = j;
      if (j == 72)
      {
        paramShareActionSheet.uin = paramActionSheetItem.uin;
        paramShareActionSheet.uinType = paramActionSheetItem.uinType;
      }
      amda localamda = amea.a(this.this$0);
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.d;
      Activity localActivity = this.this$0.mContext;
      if (this.this$0.biJ) {}
      for (paramActionSheetItem = "biz_src_jc_groupgif";; paramActionSheetItem = "biz_src_jc_photo")
      {
        localamda.a(localRichMediaBrowserInfo, localActivity, paramShareActionSheet, 100500, paramActionSheetItem);
        if (this.this$0.biJ) {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
        }
        if (!amcj.a().avB()) {
          break label920;
        }
        ajlg.report("0X8009ABA");
        i = 1;
        break;
      }
      i = 4;
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Qzone", 0);
      }
      amdf.a(this.this$0.mContext, amcj.a().yP(), amcj.a().yN(), this.this$0.bWP, this.d, this.this$0.biK, amcj.a().yM());
      if (this.this$0.biJ)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
        i = 4;
        continue;
        i = 5;
        amea.b(this.this$0, this.b);
        continue;
        i = 2;
        amea.a(this.this$0, this.b, this.d, this.S);
        continue;
        paramActionSheetItem = new Intent();
        paramActionSheetItem.putExtra("preResult", paramShareActionSheet);
        amdl.b(this.this$0.mContext, this.this$0.aWg, this.b.istroop, this.b.bjg, this.b.send_uin, this.b.md5, this.b.aWj, this.b.uuid, 1, amcj.a().yP(), amcj.a().yO(), paramActionSheetItem);
        anot.a(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        continue;
        paramActionSheetItem = new Intent();
        paramActionSheetItem.putExtra("preResult", paramShareActionSheet);
        amdl.b(this.this$0.mContext, this.this$0.aWg, this.b.istroop, this.b.bjg, this.b.send_uin, this.b.md5, this.b.aWj, this.b.uuid, 2, amcj.a().yP(), amcj.a().yO(), paramActionSheetItem);
        i = 10;
        continue;
        i = 3;
        amea.a(this.this$0, this.d, this.S);
        continue;
        i = 8;
        OCRPerformFragment.b(this.this$0.mContext, this.S.getAbsolutePath(), 1, this.b.istroop, this.b.md5);
        continue;
        i = 6;
        amea.c(this.this$0, this.b);
        continue;
        i = 7;
        amea.d(this.this$0, this.b);
        continue;
        amea.e(this.this$0, this.b);
        i = 0;
        continue;
        PicShareToWX.a(this.S.getPath(), this.this$0.mContext, 1);
        anot.a(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amei
 * JD-Core Version:    0.7.0.1
 */