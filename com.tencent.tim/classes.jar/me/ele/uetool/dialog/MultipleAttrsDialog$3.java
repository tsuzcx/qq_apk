package me.ele.uetool.dialog;

import android.view.View;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;

final class MultipleAttrsDialog$3
  implements ElementItem.ChangeCallBack
{
  public void callBack(Element paramElement, Object paramObject)
  {
    float f1 = 1.0F;
    try
    {
      float f2 = Float.valueOf((String)paramObject).floatValue();
      f1 = f2;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
    paramElement.getView().setAlpha(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.3
 * JD-Core Version:    0.7.0.1
 */