package com.tencent.qqmail.attachment.util;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

class AttachOperateMore$6
  extends QMListPopupWindow
{
  AttachOperateMore$6(AttachOperateMore paramAttachOperateMore, Context paramContext, View paramView, ListAdapter paramListAdapter, ArrayList paramArrayList, long paramLong, String paramString)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    if (StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690582)))
    {
      AttachOperateMore.access$600(this.this$0, AttachOperateMore.access$400(this.this$0));
      DataCollector.logEvent("Event_Click_SaveAs_From_AttachDetail");
    }
    do
    {
      return;
      if (StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690570)))
      {
        AttachOperateMore.access$700(this.this$0, AttachOperateMore.access$400(this.this$0), this.val$downloadList);
        DataCollector.logEvent("Event_Attach_Save_To_Ftn_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690566)))
      {
        AttachOperateMore.access$700(this.this$0, AttachOperateMore.access$400(this.this$0), this.val$downloadList);
        DataCollector.logEvent("Event_Attach_Save_All_To_Ftn_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690550)))
      {
        AttachOperateMore.doMailSend(AttachOperateMore.access$100(this.this$0), AttachOperateMore.access$400(this.this$0).getAccountId(), AttachOperateMore.access$400(this.this$0).getMailId(), AttachOperateMore.access$400(this.this$0).getAttach());
        DataCollector.logEvent("Event_Attach_Send_Email_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690558)))
      {
        if (StringExtention.isNullOrEmpty(AttachOperateMore.access$400(this.this$0).getAttach().getPreview().getMyDisk())) {
          Toast.makeText(AttachOperateMore.access$100(this.this$0), AttachOperateMore.access$100(this.this$0).getString(2131692956), 0).show();
        }
        for (;;)
        {
          DataCollector.logEvent("Event_Attach_Open_Save_Path_From_AttachDetail");
          return;
          IntentUtil.openAttachFileLocation(AttachOperateMore.access$100(this.this$0), AttachOperateMore.access$400(this.this$0).getAttach().getPreview().getMyDisk());
        }
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690532)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.val$attachId }, true);
        AttachOperateMore.access$200(this.this$0).showSuccess(2131689776);
        DataCollector.logEvent("Event_Attach_Preview_AddFavorite");
        DataCollector.logEvent("Event_Attach_AddFavorite");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690535)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.val$attachId }, false);
        AttachOperateMore.access$200(this.this$0).showSuccess(2131691250);
        DataCollector.logEvent("Event_Attach_CancelFavorite");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690586)))
      {
        new QMShareFileDialogHelper(AttachOperateMore.access$100(this.this$0), AttachOperateMore.access$100(this.this$0).getString(2131690586), this.val$filePath, QMShareFileDialogHelper.SHARE_TYPE_NORMAL_ATT).createDialog().show();
        DataCollector.logEvent("Event_Share_Normal_Attach_From_Favorite");
        return;
      }
    } while (!StringUtils.equalsIgnoreCase(paramAdapterView, AttachOperateMore.access$100(this.this$0).getString(2131690572)));
    if (StringExtention.sizeStrToLong(AttachOperateMore.access$400(this.this$0).getAttach().getSize()) >= 1073741824L)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(QMApplicationContext.sharedInstance()).setTitle(2131690553)).setMessage(2131690575).addAction(2131696547, new AttachOperateMore.6.1(this))).create().show();
      return;
    }
    paramAdapterView = AttachSaveToWeiYunActivity.createIntent(AttachOperateMore.access$400(this.this$0).getAttach(), false, AttachOperateMore.access$400(this.this$0).getAccountId(), false, false, false);
    if (AttachOperateMore.access$800(this.this$0))
    {
      ((BaseActivityEx)AttachOperateMore.access$100(this.this$0)).startActivity(paramAdapterView);
      return;
    }
    ((FragmentActivity)AttachOperateMore.access$100(this.this$0)).startActivity(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachOperateMore.6
 * JD-Core Version:    0.7.0.1
 */