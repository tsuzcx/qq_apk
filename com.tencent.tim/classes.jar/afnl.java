import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

class afnl
  implements AdapterView.OnItemClickListener
{
  afnl(afnh paramafnh) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QQAppInterface localQQAppInterface = this.this$0.a.app;
    long l = System.currentTimeMillis();
    aqmq.track(null, "AIO_EmoticonPanel_TabClick");
    Object localObject1 = this.this$0.a.zZ;
    if (localObject1 == null) {}
    while ((paramInt >= ((List)localObject1).size()) || (((afnp)this.this$0.a.a(8)).jv(paramInt)))
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "mOnItemClicked position: " + paramInt);
    }
    afnh.a(this.this$0, true);
    afnh.a(this.this$0, 1);
    this.this$0.a.a.setSelection(paramInt);
    boolean bool;
    label185:
    Object localObject2;
    Object localObject6;
    Object localObject4;
    label262:
    int i;
    Object localObject3;
    if ((((List)localObject1).size() > EmoticonPanelController.cSf) && (((afoo)((List)localObject1).get(EmoticonPanelController.cSf)).type == 8))
    {
      bool = true;
      EmoticonPanelController.bZh = bool;
      localObject2 = (afoo)((List)localObject1).get(paramInt);
      localObject1 = "";
      localObject6 = "";
      localObject4 = "";
      if (((afoo)localObject2).type != 8) {
        break label594;
      }
      localObject2 = acfp.m(2131705838);
      localObject1 = (ImageView)paramView.findViewById(2131377020);
      bool = false;
      if (localObject1 != null)
      {
        if (((ImageView)localObject1).getVisibility() != 0) {
          break label581;
        }
        bool = true;
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = localQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      ((SharedPreferences)localObject1).edit().putBoolean("isClickRecommendRedpoint", true).putBoolean("is_red_when_click_recommend", bool).apply();
      i = ((SharedPreferences)localObject1).getInt("recommendRuleId", -1);
      localObject3 = localQQAppInterface.getCurrentUin();
      if (!bool) {
        break label587;
      }
      localObject1 = "1";
      label339:
      VasWebviewUtil.reportCommercialDrainage((String)localObject3, "ep_mall", "0X8005798", "", 0, 0, 0, "", "", "", (String)localObject1, "", i + "", "", 0, 0, 0, 0);
      bool = false;
      localObject1 = "0X800AE0B";
      localObject3 = "0X8005798";
    }
    for (;;)
    {
      i = this.this$0.a.z(bool);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i != 0)) {
        anot.a(localQQAppInterface, "dc00898", "", "", (String)localObject1, (String)localObject1, i, 0, "1", "", "", "");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        anot.a(localQQAppInterface, "CliOper", "", "", "ep_mall", (String)localObject3, 0, 0, (String)localObject6, "", (String)localObject4, "");
      }
      if (EmoticonPanelController.cSe == paramInt) {
        break;
      }
      EmoticonPanelController.cSe = paramInt;
      this.this$0.a.MI(paramInt);
      if (AppSetting.enableTalkBack) {
        QQAppInterface.EI((String)localObject2);
      }
      aqmq.track("AIO_EmoticonPanel_TabClick", null);
      this.this$0.a.bZo = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonPanelMallHelper", 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - l));
      break;
      bool = false;
      break label185;
      label581:
      bool = false;
      break label262;
      label587:
      localObject1 = "";
      break label339;
      label594:
      if (((afoo)localObject2).type == 9)
      {
        localObject1 = "0X800AE0D";
        bool = false;
        localObject2 = acfp.m(2131705827);
        localObject3 = "0X8005797";
      }
      else if (((afoo)localObject2).type == 4)
      {
        localObject2 = acfp.m(2131705800);
        anot.a(localQQAppInterface, "dc00898", "", "", "0x800a56e", "0x800a56e", 0, 0, "", "", "", "");
        ((afna)this.this$0.a.a(2)).daC();
        bool = true;
        localObject1 = "0X800AE08";
        localObject3 = "0X8005799";
      }
      else
      {
        if (((afoo)localObject2).type != 7) {
          break label738;
        }
        localObject1 = "0X800AE07";
        localObject2 = acfp.m(2131705847);
        bool = true;
        localObject3 = "0X800579A";
      }
    }
    label738:
    Object localObject5;
    if (((afoo)localObject2).type == 6)
    {
      localObject4 = ((afoo)localObject2).d;
      if (localObject4 == null) {
        break label1151;
      }
      localObject2 = ((EmoticonPackage)localObject4).epId;
      if (((EmoticonPackage)localObject4).status == 2)
      {
        localObject1 = "0X800584E";
        label781:
        localObject3 = Integer.toString(this.this$0.a.cN((String)localObject2));
        localObject6 = acfp.m(2131705807) + ((EmoticonPackage)localObject4).name + acfp.m(2131705824);
        if (((EmoticonPackage)localObject4).status == 2) {
          break label1124;
        }
        localObject6 = (String)localObject6 + acfp.m(2131705850);
        localObject5 = localObject3;
        localObject4 = localObject1;
        localObject1 = localObject6;
        localObject3 = localObject2;
        localObject2 = localObject5;
      }
    }
    for (;;)
    {
      Object localObject7 = localObject1;
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject3 = localObject4;
      bool = false;
      localObject1 = "0X800AE0C";
      localObject2 = localObject7;
      localObject4 = localObject5;
      break;
      localObject1 = "0X80059B8";
      break label781;
      if (((afoo)localObject2).type == 11)
      {
        localObject2 = acfp.m(2131705848);
        localObject1 = (ImageView)paramView.findViewById(2131377020);
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setVisibility(8);
          localObject1 = this.this$0.a.mBaseChatPie;
          if ((localObject1 != null) && (((BaseChatPie)localObject1).b != null)) {
            ((BaseChatPie)localObject1).b.setShowRed(3, false);
          }
        }
        anot.a(localQQAppInterface, "dc00898", "", "", "0X800A36D", "0X800A36D", 0, 0, "", "", "", "");
        bool = true;
        localObject1 = "0X800AE0A";
        localObject3 = "";
        break;
      }
      if (((afoo)localObject2).type == 12)
      {
        localObject1 = "0X800AE09";
        bool = true;
        localObject3 = "";
        localObject2 = "";
        break;
      }
      if (((afoo)localObject2).type == 10)
      {
        bool = false;
        localObject1 = "0X800AE0C";
        localObject2 = "";
        localObject3 = "";
        break;
      }
      bool = true;
      localObject3 = "";
      localObject2 = "";
      break;
      label1124:
      localObject4 = localObject2;
      localObject5 = localObject1;
      localObject1 = localObject6;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject5;
      continue;
      label1151:
      localObject1 = "";
      localObject4 = "";
      localObject3 = "";
      localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnl
 * JD-Core Version:    0.7.0.1
 */