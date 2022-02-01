import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.TroopManager.c;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.AppInfo;

public class uqn
  implements View.OnClickListener
{
  public uqn(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject3;
    if ((localObject1 instanceof oidb_0xea4.AppInfo))
    {
      localObject3 = (oidb_0xea4.AppInfo)localObject1;
      localObject1 = ((oidb_0xea4.AppInfo)localObject3).url.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label47;
      }
    }
    label47:
    label192:
    label833:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = ((oidb_0xea4.AppInfo)localObject3).appid.get();
      Object localObject2;
      if ((l == 1101236949L) && (aerd.c().mIsEnable) && (this.this$0.a.mIsFreezed == 1) && (this.this$0.a.isOwnerOrAdim()))
      {
        boolean bool = TroopManager.c.iC(this.this$0.a.groupFreezeReason);
        if (this.this$0.a.bOwner)
        {
          localObject2 = this.this$0;
          localObject3 = this.this$0.a.troopUin;
          if (bool)
          {
            i = 15;
            String str1 = VipUtils.a(0, i).toString();
            String str2 = acfp.m(2131703757);
            uqo localuqo = new uqo(this, bool);
            if (!bool) {
              break label250;
            }
            localObject1 = "0X800A57F";
            if (!bool) {
              break label257;
            }
            i = 1;
            label199:
            VipUtils.a((Context)localObject2, (String)localObject3, str1, str2, localuqo, (String)localObject1, i, bool);
          }
        }
        for (;;)
        {
          anot.a(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
          break;
          i = 8;
          break label154;
          label250:
          localObject1 = "0X8009E38";
          break label192;
          i = 3;
          break label199;
          VipUtils.O(this.this$0, bool);
        }
      }
      int i = ((oidb_0xea4.AppInfo)localObject3).push_red_point.get();
      if (MiniAppLauncher.isMiniAppUrl((String)localObject1))
      {
        localObject1 = apuh.a((String)localObject1, l, i, this.this$0.a, this.this$0.app, true);
        MiniAppLauncher.startMiniApp(this.this$0, (String)localObject1, 2010, apuh.a(this.this$0.b, this.this$0.a.troopUin), null);
        apuh.a((oidb_0xea4.AppInfo)localObject3, "click", this.this$0.a.troopUin);
        label366:
        if (i != 0)
        {
          ((oidb_0xea4.AppInfo)localObject3).push_red_point.set(0);
          ((TextView)paramView.findViewById(2131362863)).setVisibility(8);
          aptr.K(this.this$0.app, this.this$0.a.troopUin, (int)l);
        }
        aqfr.b("Grp_app_new", "grpData_admin", "app_clk", 0, 0, new String[] { this.this$0.a.troopUin, aqfr.a(this.this$0.a), String.valueOf(l) });
        if (l != 0L) {
          break label782;
        }
        localObject1 = "app_clk";
        MiniProgramLpReportDC04239.reportByQQqunInfo("qun", "qun_info", "click_more", this.this$0.a.troopUin);
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label833;
        }
        aqfr.b("Grp_app_new", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.this$0.a.troopUin, aqfr.a(this.this$0.a) });
        break;
        if ((((String)localObject1).startsWith("http")) || (((String)localObject1).startsWith("https")))
        {
          localObject2 = new Intent(this.this$0, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", apuh.a((String)localObject1, l, i, this.this$0.a, this.this$0.app, true));
          ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.this$0.startActivity((Intent)localObject2);
          break label366;
        }
        if (!((String)localObject1).startsWith("mqqapi")) {
          break label366;
        }
        localObject2 = apuh.a((String)localObject1, l, i, this.this$0.a, this.this$0.app, true);
        localObject1 = localObject2;
        if (l == 1105981808L)
        {
          localObject1 = rnw.a(this.this$0.getIntent(), (String)localObject2, null);
          rar.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
        }
        localObject2 = new Intent(this.this$0, JumpActivity.class);
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        this.this$0.startActivity((Intent)localObject2);
        break label366;
        if (l == 1L) {
          localObject1 = "clk_file";
        } else if (l == 2L) {
          localObject1 = "clk_album";
        } else if (l == 1101236949L) {
          localObject1 = "clk_notice";
        } else {
          localObject1 = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqn
 * JD-Core Version:    0.7.0.1
 */