import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class wub
  implements View.OnClickListener, wvs
{
  private final QQAppInterface app;
  private final BaseChatPie c;
  protected LinearLayout ha;
  private final BaseActivity mActivity;
  protected ImageView sD;
  protected ImageView sE;
  protected ImageView sF;
  protected ImageView sG;
  private final SessionInfo sessionInfo;
  private final MqqHandler uiHandler;
  protected View wz;
  
  public wub(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
    this.mActivity = paramBaseChatPie.a();
    this.uiHandler = paramBaseChatPie.getUIHandler();
    this.sessionInfo = paramBaseChatPie.a();
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt2, int paramInt3, int paramInt4)
  {
    this.sD = new ImageView(this.mActivity);
    this.sD.setId(2131364549);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    if (paramInt2 == 1) {
      ((LinearLayout.LayoutParams)localObject).setMargins(paramInt3, 0, 0, 0);
    }
    for (;;)
    {
      this.sD.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.sD.setOnClickListener(this);
      if (AppSetting.enableTalkBack) {
        this.sD.setContentDescription(acfp.m(2131703075));
      }
      localObject = new StateListDrawable();
      Drawable localDrawable = this.mActivity.getResources().getDrawable(2130839586);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = this.mActivity.getResources().getDrawable(2130839587);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      this.sD.setImageDrawable((Drawable)localObject);
      this.ha.addView(this.sD);
      if (paramBoolean1) {
        fB(paramInt1, paramInt3);
      }
      if (paramBoolean3) {
        fA(paramInt1, paramInt3);
      }
      ((wvy)this.c.a(11)).a(this.c, this.ha, paramBoolean4, paramInt1, paramInt1, paramInt3, paramInt4);
      if (paramBoolean5) {
        fD(paramInt1, paramInt3);
      }
      if (paramBoolean2) {
        fC(paramInt1, paramInt3);
      }
      return;
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    }
  }
  
  private void ccd()
  {
    anot.a(this.app, "CliOper", "", "", "0X80067F6", "0X80067F6", 0, 0, "", "", "", "");
    if (!aqiw.isNetSupport(this.mActivity))
    {
      QQToast.a(this.app.getApp(), 2131693404, 0).show(this.c.getTitleBarHeight());
      return;
    }
    Object localObject3 = ajlc.a().fH();
    if (((List)localObject3).size() == 0)
    {
      QQToast.a(this.app.getApp(), 2131700602, 0).show(this.c.getTitleBarHeight());
      return;
    }
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < ((List)localObject3).size())
      {
        localObject1 = (ChatMessage)((List)localObject3).get(i);
        if ((!(localObject1 instanceof MessageForMarketFace)) && (!(localObject1 instanceof MessageForPic))) {}
      }
      else
      {
        if (localObject1 != null) {
          break;
        }
        QLog.e("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, "add to custom face, no market face message or pic message selected");
        QQToast.a(this.app.getApp(), 2131700602, 0).show(this.c.getTitleBarHeight());
        return;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, "add to custom face, selected message=" + localObject1);
    }
    if ((localObject1 instanceof MessageForPic))
    {
      localObject1 = (MessageForPic)localObject1;
      localObject2 = aoop.getDrawable(aoop.a((akxw)localObject1, 1), -1, -1, null, null, false);
      ((URLDrawable)localObject2).setTag(localObject1);
      xtm.a(this.mActivity, this.app, (URLDrawable)localObject2, ((MessageForPic)localObject1).frienduin, this.mActivity.getResources().getDimensionPixelSize(2131299627), null, null);
      anot.a(this.app, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      this.c.a(false, null, false);
      return;
      if ((localObject1 instanceof MessageForMarketFace))
      {
        anot.a(this.app, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
        localObject3 = (MessageForMarketFace)localObject1;
        localObject1 = this.c.x;
        if (this.c.x != null)
        {
          this.c.x.setMessage(this.mActivity.getString(2131693099));
          this.c.x.show();
        }
        localObject2 = ((ajdg)this.app.getManager(14)).a(((MessageForMarketFace)localObject3).mMarkFaceMessage);
        EmoticonPackage localEmoticonPackage = ((ajdg)this.app.getManager(14)).b(((afpu)localObject2).e.epId);
        MarketFaceItemBuilder.o = (ChatMessage)localObject3;
        MarketFaceItemBuilder.b = (afpu)localObject2;
        if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
        {
          i = this.app.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
          int j = (int)(System.currentTimeMillis() / 1000L);
          if ((j - i > 86400) || (j < i))
          {
            localObject3 = new MarketFaceItemBuilder.a();
            ((MarketFaceItemBuilder.a)localObject3).a(6, this.app, this.mActivity, (afpu)localObject2, this.sessionInfo, (arhz)localObject1);
            afkd.a().a((afko)localObject3);
            ((afke)this.app.getManager(43)).ex(((afpu)localObject2).e.epId, afke.cRu);
          }
          else
          {
            MarketFaceItemBuilder.a(6, this.mActivity, this.app, localEmoticonPackage, (afpu)localObject2, this.sessionInfo, (arhz)localObject1);
          }
        }
        else
        {
          localObject3 = new MarketFaceItemBuilder.a();
          ((MarketFaceItemBuilder.a)localObject3).a(6, this.app, this.mActivity, (afpu)localObject2, this.sessionInfo, (arhz)localObject1);
          afkd.a().a((afko)localObject3);
          ((afke)this.app.getManager(43)).ex(((afpu)localObject2).e.epId, afke.cRu);
        }
      }
    }
  }
  
  private void cce()
  {
    int i = ajlc.a().getCheckedItemCount();
    anot.a(this.app, "CliOper", "", "", "0X80059B6", "0X80059B6", 0, 0, "", "", "", "");
    anot.a(this.app, "CliOper", "", "", ajgw.bRo, ajgw.bRo, 0, i, "", "", "", "");
    if ((ujt.U != null) && (ujt.U.isShowing())) {}
    do
    {
      return;
      localObject = ajlc.a().fH();
      if (((List)localObject).size() != 0) {
        break;
      }
      QQToast.a(this.app.getApp(), 2131700602, 0).show(this.c.getTitleBarHeight());
      anot.a(this.app, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "0", "", "", "");
    } while (this.sessionInfo.cZ != 1008);
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    anot.a(this.app, "dc00899", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X80064F9", "0X80064F9", 0, 0, (String)localObject, "1", "", "");
    return;
    ajlc.a().lx((List)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "checklist.size = " + ((List)localObject).size());
    }
    anot.a(this.app, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "" + ((List)localObject).size(), "", "", "");
    if (this.sessionInfo.cZ == 1008)
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      anot.a(this.app, "dc00899", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X80064F9", "0X80064F9", 0, 0, str, "0", "", "");
    }
    ujt.a(this.mActivity, this.app, (List)localObject);
  }
  
  private void fC(int paramInt1, int paramInt2)
  {
    this.sG = new ImageView(this.mActivity);
    this.sG.setId(2131364553);
    if (AppSetting.enableTalkBack) {
      this.sG.setContentDescription(acfp.m(2131703100));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.sG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.sG.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.mActivity.getResources().getDrawable(2130839543);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.mActivity.getResources().getDrawable(2130839543);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.sG.setImageDrawable((Drawable)localObject);
    this.ha.addView(this.sG);
  }
  
  private void fD(int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(this.mActivity);
    localImageView.setId(2131364552);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localImageView.setOnClickListener(this);
    if (AppSetting.enableTalkBack) {
      localImageView.setContentDescription(acfp.m(2131703076));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.mActivity.getResources().getDrawable(2130839671);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.mActivity.getResources().getDrawable(2130839671);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localImageView.setImageDrawable((Drawable)localObject);
    this.ha.addView(localImageView);
  }
  
  public int[] C()
  {
    return new int[0];
  }
  
  public void Ck(int paramInt) {}
  
  public void c(ChatMessage paramChatMessage)
  {
    int n = 0;
    int i3 = this.app.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i1 = this.mActivity.getApplicationContext().getResources().getDimensionPixelSize(2131299627) - 5;
    int i2 = aqnm.dpToPx(28.0F);
    paramChatMessage = (RelativeLayout)this.c.r().findViewById(2131364469);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOMultiActionHelper", 2, "createMulti");
    }
    int i4 = i3 / 37;
    if (this.wz == null)
    {
      this.wz = new View(this.mActivity);
      localObject = new RelativeLayout.LayoutParams(-1, i1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.wz.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.wz.setFocusableInTouchMode(true);
      this.wz.setFocusable(true);
      this.wz.setContentDescription("");
      if (this.sessionInfo.cZ == 1008) {
        this.wz.setOnClickListener(this);
      }
      paramChatMessage.addView(this.wz);
    }
    if (this.ha == null)
    {
      this.ha = new LinearLayout(this.mActivity);
      this.ha.setOrientation(0);
      localObject = new RelativeLayout.LayoutParams(-1, i1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i4, 0, i4, 0);
      this.ha.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramChatMessage.addView(this.ha);
    }
    this.ha.removeAllViews();
    this.ha.setId(2131362466);
    Object localObject = (wwu)this.c.a(40);
    ((wwu)localObject).a(this.ha, i1, paramChatMessage);
    paramChatMessage = (AIOLongShotHelper)this.c.a(15);
    if (paramChatMessage.RS())
    {
      if (!this.c.aey) {
        this.c.vi("");
      }
      ((wwu)localObject).ccH();
      paramChatMessage.a(this.mActivity, this.ha);
      ((wxo)this.c.a(53)).cdk();
      i = this.mActivity.getResources().getColor(2131167418);
      if (paramChatMessage.RS()) {
        i = Color.parseColor("#313546");
      }
      this.wz.setBackgroundColor(i);
      ccb();
      return;
    }
    boolean bool1;
    label434:
    boolean bool2;
    label450:
    boolean bool3;
    label466:
    boolean bool4;
    label482:
    boolean bool5;
    label498:
    label505:
    int j;
    label512:
    int k;
    label520:
    int m;
    if (wja.eU(1) == 0)
    {
      bool1 = true;
      if (this.sessionInfo.cZ == 1008) {
        break label603;
      }
      bool2 = true;
      if (this.sessionInfo.cZ == 1008) {
        break label609;
      }
      bool3 = true;
      if (this.sessionInfo.cZ == 1008) {
        break label615;
      }
      bool4 = true;
      if (this.sessionInfo.cZ == 1008) {
        break label621;
      }
      bool5 = true;
      if (!bool1) {
        break label627;
      }
      i = 1;
      if (!bool3) {
        break label632;
      }
      j = 1;
      if (!bool2) {
        break label637;
      }
      k = 1;
      if (!bool4) {
        break label643;
      }
      m = 1;
      label528:
      if (bool5) {
        n = 1;
      }
      j = n + (m + (i + 1 + j + k));
      if (j != 1) {
        break label649;
      }
    }
    label643:
    label649:
    for (int i = (i3 - i4 * 2 - i2) / 2;; i = (i3 - i4 * 2 - i2 * j) / (j - 1))
    {
      a(i2, bool1, bool2, bool3, bool4, bool5, j, i, i1 * 3 / 20);
      break;
      bool1 = false;
      break label434;
      label603:
      bool2 = false;
      break label450;
      label609:
      bool3 = false;
      break label466;
      label615:
      bool4 = false;
      break label482;
      label621:
      bool5 = false;
      break label498;
      label627:
      i = 0;
      break label505;
      label632:
      j = 0;
      break label512;
      label637:
      k = 0;
      break label520;
      m = 0;
      break label528;
    }
  }
  
  public void ccb()
  {
    if (this.ha != null) {
      this.ha.setVisibility(0);
    }
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)this.c.a(15);
    wwu localwwu = (wwu)this.c.a(40);
    if (!localAIOLongShotHelper.RS()) {
      localwwu.ccI();
    }
    if (this.wz != null)
    {
      this.wz.setVisibility(0);
      this.wz.setClickable(true);
    }
    this.c.bIf();
  }
  
  public void ccc()
  {
    if (this.ha != null) {
      this.ha.setVisibility(8);
    }
    ((wwu)this.c.a(40)).ccH();
    if (this.wz != null) {
      this.wz.setVisibility(8);
    }
    this.c.bIe();
  }
  
  public void fA(int paramInt1, int paramInt2)
  {
    this.sF = new ImageView(this.mActivity);
    this.sF.setId(2131364551);
    if (AppSetting.enableTalkBack) {
      this.sF.setContentDescription(acfp.m(2131703086));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.sF.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.sF.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.mActivity.getResources().getDrawable(2130839616);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.mActivity.getResources().getDrawable(2130839617);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.mActivity.getResources().getDrawable(2130839616);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.sF.setImageDrawable((Drawable)localObject);
    this.ha.addView(this.sF);
  }
  
  public void fB(int paramInt1, int paramInt2)
  {
    this.sE = new ImageView(this.mActivity);
    this.sE.setId(2131364548);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.sE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.sE.setOnClickListener(this);
    if (AppSetting.enableTalkBack) {
      this.sE.setContentDescription(acfp.m(2131703066));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.mActivity.getResources().getDrawable(2130839603);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.mActivity.getResources().getDrawable(2130839604);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.mActivity.getResources().getDrawable(2130839603);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.sE.setImageDrawable((Drawable)localObject);
    this.ha.addView(this.sE);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      cce();
      continue;
      ccd();
      continue;
      int i = ajlc.a().getCheckedItemCount();
      anot.a(this.app, "CliOper", "", "", ajgw.bRp, ajgw.bRp, 0, i, "", "", "", "");
      ((wwb)this.c.a(1)).a(this.c.a, false);
      continue;
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      if (localAIOLongShotHelper != null)
      {
        localAIOLongShotHelper.fd(paramView);
        continue;
        ((wwb)this.c.a(1)).aAL();
      }
    }
  }
  
  public void zb(boolean paramBoolean)
  {
    if (this.sE != null) {
      this.sE.setEnabled(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wub
 * JD-Core Version:    0.7.0.1
 */