package com.tencent.qqmail.card.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.card.model.QMCardPara;
import com.tencent.qqmail.utilities.ui.QMEditDialog.EditBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class CardPreviewFragment$13
  implements DialogInterface.OnClickListener
{
  CardPreviewFragment$13(CardPreviewFragment paramCardPreviewFragment, QMEditDialog.EditBuilder paramEditBuilder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$0.hideKeyBoard();
    paramDialogInterface = this.val$builder.getData();
    Iterator localIterator = CardPreviewFragment.access$1300(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      QMCardPara localQMCardPara = (QMCardPara)localIterator.next();
      String str = (String)paramDialogInterface.get(localQMCardPara.getName());
      if ((str != null) && (!str.equals(localQMCardPara.getValue())))
      {
        CardPreviewFragment.access$2402(this.this$0, true);
        localQMCardPara.setValue(str);
      }
    }
    if (CardPreviewFragment.access$2400(this.this$0))
    {
      CardPreviewFragment.access$2300(this.this$0);
      CardPreviewFragment.access$2500(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.13
 * JD-Core Version:    0.7.0.1
 */