package com.tencent.token.ui;

import android.widget.EditText;
import com.tencent.token.cw;
import com.tencent.token.utils.x;

class xi
  implements Runnable
{
  xi(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public void run()
  {
    RealNameStep1InputNameIdActivity.access$2002(this.a, x.a(RealNameStep1InputNameIdActivity.access$2100(this.a), 960, 960, 153600));
    RealNameStep1InputNameIdActivity.access$2202(this.a, x.a(RealNameStep1InputNameIdActivity.access$2300(this.a), 960, 960, 153600));
    if (RealNameStep1InputNameIdActivity.access$1600(this.a) != AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE)
    {
      if (RealNameStep1InputNameIdActivity.access$1600(this.a) == AddFaceResultActivity.ADD_FACE_CAN_UPDATE_ZZB) {
        cw.a().a(0L, RealNameStep1InputNameIdActivity.access$1700(this.a), 4, RealNameStep1InputNameIdActivity.access$1800(this.a).getText().toString(), RealNameStep1InputNameIdActivity.access$1900(this.a).getText().toString(), RealNameStep1InputNameIdActivity.access$2400(this.a), RealNameStep1InputNameIdActivity.compressPicData(RealNameStep1InputNameIdActivity.access$2000(this.a)), RealNameStep1InputNameIdActivity.compressPicData(RealNameStep1InputNameIdActivity.access$2200(this.a)), RealNameStep1InputNameIdActivity.access$2500(this.a), RealNameStep1InputNameIdActivity.access$2600(this.a), RealNameStep1InputNameIdActivity.access$2700(this.a));
      }
      return;
    }
    cw.a().a(0L, RealNameStep1InputNameIdActivity.access$1700(this.a), RealNameStep1InputNameIdActivity.access$000(this.a), RealNameStep1InputNameIdActivity.access$1800(this.a).getText().toString(), RealNameStep1InputNameIdActivity.access$1900(this.a).getText().toString(), RealNameStep1InputNameIdActivity.access$2400(this.a), RealNameStep1InputNameIdActivity.compressPicData(RealNameStep1InputNameIdActivity.access$2000(this.a)), RealNameStep1InputNameIdActivity.compressPicData(RealNameStep1InputNameIdActivity.access$2200(this.a)), RealNameStep1InputNameIdActivity.access$2500(this.a), RealNameStep1InputNameIdActivity.access$2600(this.a), RealNameStep1InputNameIdActivity.access$2700(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xi
 * JD-Core Version:    0.7.0.1
 */