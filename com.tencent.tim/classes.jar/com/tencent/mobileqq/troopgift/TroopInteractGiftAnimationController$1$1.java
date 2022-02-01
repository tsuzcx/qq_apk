package com.tencent.mobileqq.troopgift;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import apsz;
import aptj;
import apxr;
import apxs;
import apxt;
import apxu;
import apxx;
import apya;
import apyc;
import apyd;
import aqcx;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TroopInteractGiftAnimationController$1$1
  implements Runnable
{
  TroopInteractGiftAnimationController$1$1(TroopInteractGiftAnimationController.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.bX == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInteractGiftAnimationController", 2, "TroopGiftUtil.getInteractConfig = null, packageId: " + this.a.cqu);
      }
    }
    for (;;)
    {
      return;
      if (this.bX.optInt("type", 2) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        if (this.a.this$0.c != null) {
          break label156;
        }
        this.a.this$0.c = new SpriteVideoView(this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mContext, bool);
        this.a.this$0.c.setCenterCrop(true);
        if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.hp != null) {
          break label158;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TroopInteractGiftAnimationController", 2, "mTroopChatPie.bgAnimationLayout == null");
        return;
      }
      label156:
      continue;
      label158:
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.hp.removeAllViews();
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.hp.addView(this.a.this$0.c, -1, this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.bYK);
      this.a.this$0.dXR = 0;
      this.a.this$0.aYG = true;
      if ((this.a.c.interactState != 2) && (this.a.cSV))
      {
        this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton = new TroopGiftActionButton(this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mContext, this.bX, new apxs(this));
        this.a.this$0.c.setOnProgressChangedListener(new apxt(this));
        localObject1 = new RelativeLayout.LayoutParams(aqcx.dip2px(this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mContext, 175.0F), aqcx.dip2px(this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mContext, 175.0F));
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.bYK - aqcx.dip2px(this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mContext, 85.0F));
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = (-aqcx.dip2px(this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mContext, 25.0F));
        ((RelativeLayout.LayoutParams)localObject1).addRule(11);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        this.a.this$0.cV.addView(this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton, (ViewGroup.LayoutParams)localObject1);
      }
      Object localObject1 = aptj.a(this.a.c);
      Object localObject3 = this.bX.optJSONObject("animation1");
      Object localObject2 = this.bX.optJSONObject("animation2");
      JSONObject localJSONObject = this.bX.optJSONObject("animation3");
      int i = ((JSONObject)localObject3).optInt("duration");
      int j = ((JSONObject)localObject2).optInt("duration");
      int k = localJSONObject.optInt("duration");
      int m = (int)(this.a.c.alreadyPlayMicroseconds / 1000L);
      int n = (int)(this.a.c.playTotalMicroseconds / 1000L);
      if ((this.a.c.interactState == 2) || (!this.a.cSV))
      {
        localObject3 = (String)localObject1 + ((JSONObject)localObject3).optString("videoPath", "1.mp4");
        this.a.this$0.c.a((String)localObject3, new apxu(this, n, i, (String)localObject1, (JSONObject)localObject2, j, localJSONObject));
      }
      while (this.a.c.interactState == 0)
      {
        this.a.a.b(this.a.c.frienduin, this.a.c.interactId, this.a.c.animationPackageId, new apyd(this));
        return;
        if (m < i)
        {
          localObject3 = (String)localObject1 + ((JSONObject)localObject3).optString("videoPath", "1.mp4");
          this.a.this$0.c.a((String)localObject3, m, new apxx(this, i, (String)localObject1, (JSONObject)localObject2, j, localJSONObject));
          this.a.this$0.a(this.a.c, i - m - 300);
        }
        else if (m < i + j)
        {
          localObject2 = (String)localObject1 + ((JSONObject)localObject2).optString("videoPath", "2.mp4");
          this.a.this$0.c.a((String)localObject2, m - i, new apya(this, i, j, (String)localObject1, localJSONObject));
          this.a.this$0.a(this.a.c, i + j - m - 300);
        }
        else if (m < i + j + k)
        {
          localObject1 = (String)localObject1 + localJSONObject.optString("videoPath", "3.mp4");
          this.a.this$0.c.a((String)localObject1, m - i - j, new apyc(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1
 * JD-Core Version:    0.7.0.1
 */