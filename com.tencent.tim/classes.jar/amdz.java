import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.presenter.IProvider;

class amdz
  implements ShareActionSheet.OnItemClickListener
{
  amdz(amdw paramamdw, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.this$0.d.dismiss();
    int i;
    switch (paramActionSheetItem.action)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
      return;
      int j = 1;
      i = j;
      if (amdw.a(this.this$0))
      {
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.a.msgId, this.a.subId, 0);
        if (this.a.istroop == 1) {}
        for (boolean bool = true;; bool = false)
        {
          amdk.c(this.this$0.mContext, paramActionSheetItem, bool);
          i = j;
          break;
        }
        if (!amdw.a(this.this$0)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.a.msgId, this.a.subId, 0);
        if (this.a.istroop == 1) {}
        for (bool = true;; bool = false)
        {
          amdk.c(this.this$0.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        i = paramActionSheetItem.uinType;
        paramActionSheetItem = paramActionSheetItem.uin;
        if (amdw.a(this.this$0))
        {
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.a.msgId, this.a.subId, 0);
          if (this.a.istroop != 1) {
            break label385;
          }
        }
        label385:
        for (bool = true;; bool = false)
        {
          amdk.a(this.this$0.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
          i = -1;
          break;
        }
        if (!amdw.a(this.this$0)) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.a.msgId);
        anot.a(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(this.this$0.mContext, 2, this.this$0.mContext.getString(2131693980), 0).show();
        i = -1;
        continue;
        j = 5;
        i = j;
        if (amdw.a(this.this$0))
        {
          RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.a.msgId);
          QQToast.a(this.this$0.mContext, this.this$0.mContext.getString(2131694101), 0).show();
          i = j;
          continue;
          i = 2;
          amdw.a(this.this$0, this.a);
          continue;
          j = 3;
          i = j;
          if (amdw.a(this.this$0))
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
            i = 6;
            continue;
            paramActionSheetItem = paramActionSheetItem.argus;
            paramShareActionSheet = new Intent();
            paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
            if (aqiu.ms(this.a.isSend)) {}
            for (paramActionSheetItem = amcj.a().yP();; paramActionSheetItem = amcj.a().yO())
            {
              amdl.b(this.this$0.mContext, this.this$0.bZM, this.a.peerType, true, paramActionSheetItem, null, null, this.a.fileUuid, 1, amcj.a().yP(), amcj.a().yO(), paramShareActionSheet);
              anot.a(null, "dc00898", "", "", "0X800AD47", "0X800AD47", amdw.a(this.this$0, this.a.peerType), 0, "", "", "", "");
              i = 8;
              break;
            }
            paramActionSheetItem = paramActionSheetItem.argus;
            paramShareActionSheet = new Intent();
            paramShareActionSheet.putExtra("preResult", paramActionSheetItem);
            if (aqiu.ms(this.a.isSend)) {}
            for (paramActionSheetItem = amcj.a().yP();; paramActionSheetItem = amcj.a().yO())
            {
              amdl.b(this.this$0.mContext, this.this$0.bZM, this.a.peerType, true, paramActionSheetItem, null, null, this.a.fileUuid, 2, amcj.a().yP(), amcj.a().yO(), paramShareActionSheet);
              anot.a(null, "dc00898", "", "", "0X800AD48", "0X800AD48", amdw.a(this.this$0, this.a.peerType), 0, "", "", "", "");
              i = 9;
              break;
            }
            i = 7;
            ahav.F(this.this$0.mContext, this.a.mFilePath);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdz
 * JD-Core Version:    0.7.0.1
 */