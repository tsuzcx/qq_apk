package com.tencent.mobileqq.portal;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FormalView$4
  implements Runnable
{
  FormalView$4(FormalView paramFormalView, List paramList) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$list.size())
    {
      PortalManager.ComboNumber localComboNumber = (PortalManager.ComboNumber)this.val$list.get(i);
      if (localComboNumber != null)
      {
        PortalManager.d(localComboNumber.numberImageMD5, "hb_icon_path");
        if (QLog.isColorLevel()) {
          QLog.d("FormalView", 2, "setComboNumberList, preload p=" + localComboNumber);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView.4
 * JD-Core Version:    0.7.0.1
 */