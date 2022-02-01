package com.tencent.mobileqq.model;

import ajdg;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonManager$25
  implements Runnable
{
  public EmoticonManager$25(ajdg paramajdg, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend, int paramInt) {}
  
  public void run()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "recommendresp is null");
      }
      return;
    }
    this.this$0.cS.put(this.val$businessType, this.a);
    int i = this.a.int32_exposure_num.get();
    if (i > 0) {
      ajdg.dif = i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo maxexposenum = " + ajdg.dif);
    }
    List localList = this.a.st_new_tab_info.get();
    if ((localList != null) && (QLog.isColorLevel())) {
      QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo recommend emotion num = " + localList.size());
    }
    ajdg.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.25
 * JD-Core Version:    0.7.0.1
 */