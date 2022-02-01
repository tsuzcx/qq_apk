package com.tencent.qqmail.activity.reademl;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.utilities.ui.QMTips;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

class QMReadEmlActivity$16
  extends QMListPopupWindow
{
  QMReadEmlActivity$16(QMReadEmlActivity paramQMReadEmlActivity, Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    QMLog.log(4, "QMReadEmlActivity", "click eml action:" + paramAdapterView);
    if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690582)))
    {
      KvHelper.eventEmlClickSelfSaveAs(new double[0]);
      QMReadEmlActivity.access$4300(this.this$0);
    }
    do
    {
      return;
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690570)))
      {
        KvHelper.eventEmlClickSelfSaveToFtn(new double[0]);
        QMReadEmlActivity.access$4400(this.this$0, (MailBigAttach)QMReadEmlActivity.access$3300(this.this$0), false);
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690550)))
      {
        KvHelper.eventEmlClickSelfSendTo(new double[0]);
        QMReadEmlActivity.access$4500(this.this$0, QMReadEmlActivity.access$3300(this.this$0));
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690558)))
      {
        KvHelper.eventEmlClickSelfOpenDir(new double[0]);
        if (StringExtention.isNullOrEmpty(QMReadEmlActivity.access$3300(this.this$0).getPreview().getMyDisk()))
        {
          Toast.makeText(QMApplicationContext.sharedInstance(), this.this$0.getString(2131692956), 0).show();
          return;
        }
        IntentUtil.openAttachFileLocation(this.this$0.getActivity(), QMReadEmlActivity.access$3300(this.this$0).getPreview().getMyDisk());
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690532)))
      {
        KvHelper.eventEmlClickSelfFavourite(new double[0]);
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { QMReadEmlActivity.access$3400(this.this$0) }, true);
        QMReadEmlActivity.access$4600(this.this$0).showSuccess(2131689776);
        return;
      }
    } while (!StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690535)));
    KvHelper.eventEmlClickSelfDelFavourite(new double[0]);
    QMAttachManager.sharedInstance().favoriteAttach(new long[] { QMReadEmlActivity.access$3400(this.this$0) }, false);
    QMReadEmlActivity.access$4600(this.this$0).showSuccess(2131691250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.16
 * JD-Core Version:    0.7.0.1
 */