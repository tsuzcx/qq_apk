package dov.com.qq.im.ae.album.logic;

import android.content.Intent;
import anot;
import awuv;
import awvf;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;
import mqq.util.WeakReference;
import ztu;

public class AEPhotoListLogicDefault$1
  implements Runnable
{
  public AEPhotoListLogicDefault$1(awvf paramawvf, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.btt) {
      PhotoUtils.a(((awuv)this.this$0.bu.get()).getActivity(), this.val$intent, this.rP, this.this$0.a.hw, this.this$0.mPhotoCommonData.currentQualityType, false);
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.lM, 0, this.aWv, this.aWw, "", "");
      anfr.akV = System.currentTimeMillis();
      return;
      PhotoUtils.a(((awuv)this.this$0.bu.get()).getActivity(), this.val$intent, this.rP, this.this$0.mPhotoCommonData.currentQualityType, this.this$0.a.bjL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.1
 * JD-Core Version:    0.7.0.1
 */