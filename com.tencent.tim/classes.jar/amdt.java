import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.presenter.IProvider;
import java.io.File;

class amdt
  implements ShareActionSheet.OnItemClickListener
{
  amdt(amdr paramamdr, AIOFilePictureData paramAIOFilePictureData, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.this$0.d.dismiss();
    int i = paramActionSheetItem.action;
    String str = paramActionSheetItem.argus;
    switch (i)
    {
    }
    for (;;)
    {
      i = -1;
      for (;;)
      {
        anot.a(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", i, 0, "", "", "", "");
        return;
        if (!amdr.a(this.this$0)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.a.msgId, this.a.subId, 0);
        if (this.a.istroop == 1) {}
        for (boolean bool = true;; bool = false)
        {
          amdk.c(this.this$0.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        int j = 1;
        i = j;
        if (amdr.a(this.this$0))
        {
          paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.a.msgId, this.a.subId, 0);
          if (this.a.istroop == 1) {}
          for (bool = true;; bool = false)
          {
            amdk.c(this.this$0.mContext, paramActionSheetItem, bool);
            i = j;
            break;
          }
          i = paramActionSheetItem.uinType;
          paramActionSheetItem = paramActionSheetItem.uin;
          if (!amdr.a(this.this$0)) {
            break;
          }
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.a.msgId, this.a.subId, 0);
          if (this.a.istroop == 1) {}
          for (bool = true;; bool = false)
          {
            amdk.a(this.this$0.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
            i = -1;
            break;
          }
          if (!amdr.a(this.this$0)) {
            break;
          }
          RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.a.msgId);
          anot.a(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          QQToast.a(this.this$0.mContext, 2, this.this$0.mContext.getString(2131693980), 0).show();
          i = -1;
          continue;
          j = 6;
          i = j;
          if (amdr.a(this.this$0))
          {
            RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.a.msgId);
            QQToast.a(this.this$0.mContext, this.this$0.mContext.getString(2131694101), 0).show();
            i = j;
            continue;
            j = 11;
            i = j;
            if (amdr.a(this.this$0))
            {
              i = j;
              if ((RichMediaBrowserManager.getInstance().getProvider() instanceof amcl))
              {
                ((amcl)RichMediaBrowserManager.getInstance().getProvider()).ge(this.a.msgId);
                QQToast.a(this.this$0.mContext, this.this$0.mContext.getString(2131700601), 0).show();
                i = j;
                continue;
                i = 2;
                amdr.a(this.this$0, this.S, this.a);
                continue;
                j = 3;
                i = j;
                if (amdr.a(this.this$0))
                {
                  RichMediaBrowserManager.getInstance().getProvider().favorite(this.a.msgId);
                  i = j;
                  continue;
                  paramShareActionSheet = amcj.a().yM();
                  paramActionSheetItem = paramShareActionSheet;
                  if (TextUtils.isEmpty(paramShareActionSheet)) {
                    paramActionSheetItem = amcj.a().yO();
                  }
                  amdl.a(this.this$0.mContext, amcj.a().Iz(), amcj.a().yO(), paramActionSheetItem, this.a.time, this.a.shmsgseq, this.a.istroop, false);
                  i = 7;
                  continue;
                  i = 8;
                  OCRPerformFragment.b(this.this$0.mContext, this.S.getAbsolutePath(), 1, this.a.istroop, this.a.md5);
                }
              }
            }
          }
        }
      }
      paramShareActionSheet = new Intent();
      paramShareActionSheet.putExtra("preResult", str);
      if (aqiu.ms(this.a.issend)) {}
      for (paramActionSheetItem = amcj.a().yP();; paramActionSheetItem = amcj.a().yO())
      {
        amdl.b(this.this$0.mContext, this.this$0.aWg, this.a.peerType, true, paramActionSheetItem, null, null, this.a.aWa, 1, amcj.a().yP(), amcj.a().yO(), paramShareActionSheet);
        anot.a(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        break;
      }
      paramShareActionSheet = new Intent();
      paramShareActionSheet.putExtra("preResult", str);
      if (aqiu.ms(this.a.issend)) {}
      for (paramActionSheetItem = amcj.a().yP();; paramActionSheetItem = amcj.a().yO())
      {
        amdl.b(this.this$0.mContext, this.this$0.aWg, this.a.peerType, true, paramActionSheetItem, null, null, this.a.aWa, 2, amcj.a().yP(), amcj.a().yO(), paramShareActionSheet);
        i = 10;
        break;
      }
      PicShareToWX.a(this.S.getPath(), this.this$0.mContext, 1);
      anot.a(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdt
 * JD-Core Version:    0.7.0.1
 */