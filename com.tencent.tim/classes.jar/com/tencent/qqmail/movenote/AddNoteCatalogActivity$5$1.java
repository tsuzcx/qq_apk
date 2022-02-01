package com.tencent.qqmail.movenote;

import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.ui.QMTips;

class AddNoteCatalogActivity$5$1
  implements Runnable
{
  AddNoteCatalogActivity$5$1(AddNoteCatalogActivity.5 param5, Object paramObject) {}
  
  private void showDialog(String paramString)
  {
    QMUIDialog.MessageDialogBuilder localMessageDialogBuilder = new QMUIDialog.MessageDialogBuilder(this.this$1.this$0.getActivity());
    ((QMUIDialog.MessageDialogBuilder)localMessageDialogBuilder.setTitle(2131696407)).setMessage(paramString);
    localMessageDialogBuilder.addAction(2131696547, new AddNoteCatalogActivity.5.1.1(this));
    localMessageDialogBuilder.show();
  }
  
  private void showTips(String paramString)
  {
    this.this$1.this$0.getTips().showError(paramString);
  }
  
  public void run()
  {
    String str = this.this$1.this$0.getString(2131696406);
    QMCGIError localQMCGIError;
    if ((this.val$object != null) && ((this.val$object instanceof QMCGIError)))
    {
      localQMCGIError = (QMCGIError)this.val$object;
      if (localQMCGIError.appCode == -111) {
        showDialog(this.this$1.this$0.getString(2131696410));
      }
    }
    else
    {
      return;
    }
    if (localQMCGIError.appCode == -112)
    {
      showDialog("分类名不能包含~!#$%^&*()=+|\\[]{};':\",?/<>等字符");
      return;
    }
    if (localQMCGIError.appCode == -113)
    {
      showTips(this.this$1.this$0.getString(2131696404));
      return;
    }
    if (localQMCGIError.appCode == -116)
    {
      showTips(this.this$1.this$0.getString(2131696405));
      return;
    }
    showTips(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.AddNoteCatalogActivity.5.1
 * JD-Core Version:    0.7.0.1
 */