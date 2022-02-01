package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kxm;
import ljc;
import lup;
import meu;
import meu.a;
import meu.b;
import meu.c;
import mev;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ActiveZoneFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedExpInfo;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedScrollStateInfo;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsCtxFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsExpFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureEvent;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ReqBody;
import wja;

public class UserOperationModule$4
  implements Runnable
{
  public UserOperationModule$4(ljc paramljc, meu parammeu, Context paramContext) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject3;
    try
    {
      oidb_cmd0xde0.ReqBody localReqBody = new oidb_cmd0xde0.ReqBody();
      localObject1 = new oidb_cmd0xde0.ActiveZoneFeature();
      ((oidb_cmd0xde0.ActiveZoneFeature)localObject1).top.set(this.a.dj[0]);
      ((oidb_cmd0xde0.ActiveZoneFeature)localObject1).bottom.set(this.a.dj[1]);
      localReqBody.active_zone.set((MessageMicro)localObject1);
      localObject1 = new oidb_cmd0xde0.FeedsCtxFeature();
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_device_id.set(kxm.iT());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_device_model.set(mev.getDeviceModel());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_enter_reason.set(this.a.aQT);
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_headset.set(mev.ar(this.I));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_lightness.set((float)mev.a(this.I));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_network_type.set(ljc.a(this.this$0));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_power.set((float)mev.r());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_screen_info.set(mev.Y(this.I));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_volume.set((float)mev.b(this.I));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).timestamp.set(System.currentTimeMillis() / 1000L);
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject1).ctx_scene.set(this.a.uQ);
      localReqBody.ctx_feature.set((MessageMicro)localObject1);
      localObject1 = new StringBuilder("UserActionCollector: ");
      localObject2 = new oidb_cmd0xde0.GestureFeature();
      localIterator = new ArrayList(this.a.iF).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label581;
        }
        localObject4 = (meu.c)localIterator.next();
        ((StringBuilder)localObject1).append(localObject4 + "\n");
        localObject3 = new oidb_cmd0xde0.GestureEvent();
        if (TextUtils.isEmpty(((meu.c)localObject4).agu)) {
          break;
        }
        ((oidb_cmd0xde0.GestureEvent)localObject3).ges_click_point.set(((meu.c)localObject4).agu);
        ((oidb_cmd0xde0.GestureFeature)localObject2).gesture_event.add((MessageMicro)localObject3);
      }
      ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_direction.set(((meu.c)localObject4).direction);
    }
    catch (Exception localException)
    {
      wja.a("UserOperationModule", "report exception!", localException);
      return;
    }
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_distance.set((float)((meu.c)localObject4).va);
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_mills.set(((meu.c)localObject4).vb);
    ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_speed.set(((meu.c)localObject4).jA);
    if (!TextUtils.isEmpty(((meu.c)localObject4).agt)) {
      ((oidb_cmd0xde0.GestureEvent)localObject3).ges_scroll_downNup.set(((meu.c)localObject4).agt);
    }
    Object localObject4 = ((meu.c)localObject4).kP.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      meu.b localb = (meu.b)((Iterator)localObject4).next();
      oidb_cmd0xde0.FeedScrollStateInfo localFeedScrollStateInfo = new oidb_cmd0xde0.FeedScrollStateInfo();
      localFeedScrollStateInfo.enter_active_zone_speed.set((float)localb.aY);
      if (!TextUtils.isEmpty(localb.feedID)) {
        localFeedScrollStateInfo.feeds_id.set(localb.feedID);
      }
      localFeedScrollStateInfo.start_top.set(localb.aQY);
      localFeedScrollStateInfo.start_bottom.set(localb.aRa);
      localFeedScrollStateInfo.stop_top.set(localb.aQZ);
      localFeedScrollStateInfo.stop_bottom.set(localb.aRb);
      ((oidb_cmd0xde0.GestureEvent)localObject3).get_scroll_feeds_info.add(localFeedScrollStateInfo);
    }
    label581:
    localException.usr_gesture_feature.set((MessageMicro)localObject2);
    Object localObject2 = new oidb_cmd0xde0.FeedsExpFeature();
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_chnl_duration.set(this.a.cL());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_first_scrn_duration.set(this.a.cJ());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_last_scrn_duration.set(this.a.cK());
    ((oidb_cmd0xde0.FeedsExpFeature)localObject2).is_user_active.set(this.a.amh);
    Iterator localIterator = this.a.iE.iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (meu.a)localIterator.next();
      localObject4 = new oidb_cmd0xde0.FeedExpInfo();
      if (!TextUtils.isEmpty(((meu.a)localObject3).feedID)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).feeds_id.set(((meu.a)localObject3).feedID);
      }
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_duration.set(((meu.a)localObject3).uV);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_duration_in_active_zone.set(((meu.a)localObject3).uW);
      if (!TextUtils.isEmpty(((meu.a)localObject3).ags)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_orientation.set(((meu.a)localObject3).ags);
      }
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).exp_pos_in_list.set(((meu.a)localObject3).aQX);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).feed_card_height.set(((meu.a)localObject3).viewHeight);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_clicked.set(((meu.a)localObject3).isClick);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_first_scrn.set(((meu.a)localObject3).amj);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).is_last_scrn.set(((meu.a)localObject3).amk);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).style.set(((meu.a)localObject3).style);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).word_cnt_for_display.set(((meu.a)localObject3).aQW);
      ((oidb_cmd0xde0.FeedExpInfo)localObject4).read_duratiion.set(((meu.a)localObject3).uU);
      if (!TextUtils.isEmpty(((meu.a)localObject3).agr)) {
        ((oidb_cmd0xde0.FeedExpInfo)localObject4).rec_reason.set(((meu.a)localObject3).agr);
      }
      ((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_feeds.add((MessageMicro)localObject4);
    }
    localException.feeds_exp_feature.set((MessageMicro)localObject2);
    ((StringBuilder)localObject1).append("\nFeedsExpInfo : ").append("stayDuration : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_chnl_duration.get()).append(", hasOpt : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).is_user_active.get()).append(", enter2Scroll : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_first_scrn_duration.get()).append(", scroll2exit : ").append(((oidb_cmd0xde0.FeedsExpFeature)localObject2).exp_last_scrn_duration.get()).append(", ").append(this.a.iE);
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, ((StringBuilder)localObject1).toString());
    }
    ToServiceMsg localToServiceMsg = lup.makeOIDBPkg("OidbSvc.0xde0", 3552, 0, localException.toByteArray());
    this.this$0.sendPbReq(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.4
 * JD-Core Version:    0.7.0.1
 */