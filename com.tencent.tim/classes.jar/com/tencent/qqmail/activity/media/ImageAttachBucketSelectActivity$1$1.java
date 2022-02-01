package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import java.util.List;

class ImageAttachBucketSelectActivity$1$1
  implements Runnable
{
  ImageAttachBucketSelectActivity$1$1(ImageAttachBucketSelectActivity.1 param1, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    ImageAttachBucketSelectActivity.access$000(this.this$1.this$0);
    int i;
    if (ImageAttachBucketSelectActivity.access$100(this.this$1.this$0) != null) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i < ImageAttachBucketSelectActivity.access$100(this.this$1.this$0).size())
      {
        localObject = (MediaItemInfo)ImageAttachBucketSelectActivity.access$100(this.this$1.this$0).get(i);
        Attach localAttach = ((MediaItemInfo)localObject).getAttach();
        if (ImageAttachBucketSelectActivity.access$200(this.this$1.this$0, (MediaItemInfo)localObject, this.val$key, this.val$url, this.val$path))
        {
          ImageAttachBucketSelectActivity.access$300(this.this$1.this$0);
          localAttach.getPreview().setMyDisk(this.val$path);
        }
      }
      else
      {
        if (ImageAttachBucketSelectActivity.access$400(this.this$1.this$0))
        {
          localObject = QMAttachManager.sharedInstance().getAttachMyDisk(((MediaItemInfo)ImageAttachBucketSelectActivity.access$100(this.this$1.this$0).get(ImageAttachBucketSelectActivity.access$500(this.this$1.this$0))).getAttach().getHashId(), 0);
          if (!((String)localObject).equals(""))
          {
            new QMShareFileDialogHelper(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131690586), (String)localObject, QMShareFileDialogHelper.SHARE_TYPE_IMG).createDialog().show();
            DataCollector.logEvent("Event_Share_Normal_Attach_From_Favorite");
            ImageAttachBucketSelectActivity.access$402(this.this$1.this$0, false);
          }
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.1.1
 * JD-Core Version:    0.7.0.1
 */