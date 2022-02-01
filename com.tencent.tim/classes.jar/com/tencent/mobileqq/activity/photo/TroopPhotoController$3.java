package com.tencent.mobileqq.activity.photo;

import apru;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zri;
import ztd;

public class TroopPhotoController$3
  implements Runnable
{
  public TroopPhotoController$3(ztd paramztd, zri paramzri, String paramString) {}
  
  public void run()
  {
    if (!this.this$0.iu(this.this$0.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin)) {
      this.this$0.jdField_b_of_type_Apru.Tx(this.this$0.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    }
    Iterator localIterator = this.this$0.rN.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.ts == this.e.ts) {
        this.this$0.rN.remove(localTroopClipPic);
      }
    }
    this.this$0.uK.remove(this.e);
    this.this$0.b(this.e);
    ztd.showToast(this.baQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.3
 * JD-Core Version:    0.7.0.1
 */