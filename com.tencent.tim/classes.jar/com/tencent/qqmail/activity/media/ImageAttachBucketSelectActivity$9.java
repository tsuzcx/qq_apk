package com.tencent.qqmail.activity.media;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;
import org.apache.commons.lang3.StringUtils;

class ImageAttachBucketSelectActivity$9
  extends QMListPopupWindow
{
  ImageAttachBucketSelectActivity$9(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity, Context paramContext, View paramView, ListAdapter paramListAdapter, MediaItemInfo paramMediaItemInfo, String paramString)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690558))) {
      if (StringExtention.isNullOrEmpty(this.val$info.getAttach().getPreview().getMyDisk()))
      {
        Toast.makeText(this.this$0.getActivity(), this.this$0.getString(2131692956), 0).show();
        DataCollector.logEvent("Event_Attach_Open_Save_Path_From_AttachDetail");
      }
    }
    do
    {
      return;
      IntentUtil.openAttachFileLocation(this.this$0.getActivity(), this.val$info.getAttach().getPreview().getMyDisk());
      break;
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690583)))
      {
        ImageAttachBucketSelectActivity.access$1700(this.this$0, this.val$info);
        DataCollector.logEvent("Event_Attach_Save_Photo_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690584)))
      {
        ImageAttachBucketSelectActivity.access$1800(this.this$0);
        DataCollector.logEvent("Event_Attach_Save_Photo_All_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690570)))
      {
        ImageAttachBucketSelectActivity.access$1900(this.this$0, ImageAttachBucketSelectActivity.access$1500(this.this$0).getCurrentItem(), false);
        DataCollector.logEvent("Event_Attach_Save_To_Ftn_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690566)))
      {
        ImageAttachBucketSelectActivity.access$1900(this.this$0, -1, true);
        DataCollector.logEvent("Event_Attach_Save_All_To_Ftn_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690550)))
      {
        ImageAttachBucketSelectActivity.access$2000(this.this$0, this.val$info.getMailId(), this.val$info.getAttach());
        DataCollector.logEvent("Event_Attach_Send_Email_From_AttachDetail");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690532)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.val$info.getAttach().getHashId() }, true);
        this.this$0.getTips().showSuccess(2131689776);
        DataCollector.logEvent("Event_Attach_Preview_AddFavorite");
        DataCollector.logEvent("Event_Attach_AddFavorite");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690535)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.val$info.getAttach().getHashId() }, false);
        this.this$0.getTips().showSuccess(2131691250);
        DataCollector.logEvent("Event_Attach_CancelFavorite");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690586)))
      {
        if (this.val$info.getAttach().isBigAttach())
        {
          new QMShareFileDialogHelper(this.this$0.getActivity(), this.this$0.getString(2131692325), this.val$info.getAttach().getPreview().getDownloadUrl(), QMShareFileDialogHelper.SHARE_TYPE_BIG_ATT, this.val$info.getAttach().getHashId()).createDialog().show();
          DataCollector.logEvent("Event_Share_Big_Attach_From_AttachDetail");
          return;
        }
        new QMShareFileDialogHelper(this.this$0.getActivity(), this.this$0.getString(2131690586), this.val$filePath, QMShareFileDialogHelper.SHARE_TYPE_IMG).createDialog().show();
        DataCollector.logEvent("Event_Share_Normal_Attach_From_Favorite");
        return;
      }
    } while (!StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131690572)));
    ImageAttachBucketSelectActivity.access$2100(this.this$0, this.val$info.getAttach());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.9
 * JD-Core Version:    0.7.0.1
 */