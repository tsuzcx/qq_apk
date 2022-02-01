package com.tencent.qqmail.attachment.activity;

import android.view.View;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.attachment.view.AttachFolderThumbListener.UpdateTime;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.util.Locale;

class AttachFolderListAdapter$1
  implements AttachFolderThumbListener.UpdateTime
{
  AttachFolderListAdapter$1(AttachFolderListAdapter paramAttachFolderListAdapter) {}
  
  public boolean needRefreshImage(View paramView, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = this.this$0.getItem(paramInt);
    boolean bool1 = bool2;
    int i;
    if (localObject != null)
    {
      bool1 = bool2;
      if ((localObject instanceof Attach))
      {
        localObject = (Attach)localObject;
        String str = ((Attach)localObject).getViewMode();
        if ((str == null) || (str.equals(""))) {
          break label109;
        }
        if (!str.equals("img")) {
          break label145;
        }
        i = 1;
      }
    }
    label145:
    for (;;)
    {
      int j = AttachFolderListAdapter.access$000(this.this$0, paramView);
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (j == paramInt) {
          bool1 = true;
        }
      }
      return bool1;
      label109:
      if (AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(((Attach)localObject).getName()))).name().toLowerCase(Locale.getDefault()).equals("image")) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListAdapter.1
 * JD-Core Version:    0.7.0.1
 */