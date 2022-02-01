package com.tencent.qqmail.activity.compose;

import android.text.TextUtils;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;

class ComposeMailActivity$88$2
  implements Runnable
{
  ComposeMailActivity$88$2(ComposeMailActivity.88 param88, ArrayList paramArrayList) {}
  
  public void run()
  {
    ComposeMailActivity.access$10000(this.this$1.this$0).hide();
    String str;
    if ((this.val$cardIds != null) && (this.val$cardIds.size() > 0))
    {
      QMLog.log(4, "ComposeMailActivity", "batch load card list success:" + this.val$cardIds.toString());
      str = ComposeMailActivity.access$10400(this.this$1.this$0);
      if (!TextUtils.isEmpty(str)) {
        break label103;
      }
      ValidateHelper.assertInDebug("cardId: " + str, false);
    }
    label103:
    while (!str.equals(this.val$cardIds.get(0))) {
      return;
    }
    ComposeMailActivity.access$10502(this.this$1.this$0, ComposeMailActivity.access$2800(this.this$1.this$0).getCardDataByCardId(str));
    ComposeMailActivity.access$10600(this.this$1.this$0);
    this.this$1.this$0.composeMail.setCardData(ComposeMailActivity.access$10500(this.this$1.this$0));
    ComposeMailActivity.access$10700(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.88.2
 * JD-Core Version:    0.7.0.1
 */