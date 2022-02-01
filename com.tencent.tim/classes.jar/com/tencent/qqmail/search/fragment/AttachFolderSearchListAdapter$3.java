package com.tencent.qqmail.search.fragment;

import android.view.View;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.attachment.view.AttachFolderThumbListener.UpdateTime;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.util.Locale;

class AttachFolderSearchListAdapter$3
  implements AttachFolderThumbListener.UpdateTime
{
  AttachFolderSearchListAdapter$3(AttachFolderSearchListAdapter paramAttachFolderSearchListAdapter) {}
  
  public boolean needRefreshImage(View paramView, int paramInt)
  {
    boolean bool2 = false;
    Attach localAttach = this.this$0.getItem(paramInt);
    boolean bool1 = bool2;
    int i;
    if (localAttach != null)
    {
      bool1 = bool2;
      if ((localAttach instanceof Attach))
      {
        localAttach = (Attach)localAttach;
        String str = localAttach.getViewMode();
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
      int j = AttachFolderSearchListAdapter.access$000(this.this$0, paramView);
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
      if (AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(localAttach.getName()))).name().toLowerCase(Locale.getDefault()).equals("image")) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListAdapter.3
 * JD-Core Version:    0.7.0.1
 */