import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.util.ArrayList;

public class amqy
  extends ampt
{
  private long ajM;
  private long ajT;
  private int cao;
  public final PublicAccountInfo e;
  private int fromType = -1;
  private String keyword;
  
  public amqy(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, int paramInt)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.fromType = paramInt;
    this.e = paramPublicAccountInfo;
    if (paramQQAppInterface.a().a().kG(this.e.getUin()))
    {
      this.ajM = amjz.ajB;
      return;
    }
    this.ajM = amjz.ajC;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public Object S()
  {
    return Long.valueOf(this.e.uin);
  }
  
  public void UA(int paramInt)
  {
    this.cao = paramInt;
  }
  
  public PublicAccountInfo a()
  {
    return this.e;
  }
  
  protected long au(String paramString)
  {
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    long l2 = amxk.b(paramString, this.e.name, 1073741824L);
    long l1 = l2;
    if (l2 != -9223372036854775808L) {
      l1 = (l2 & 0x0) >> 20 | 0xFFFFFFFF & l2 | (0x0 & l2) >> 26;
    }
    if (l1 > this.ajT) {
      this.ajT = l1;
    }
    for (int i = 1;; i = 0)
    {
      if (this.ajT != -9223372036854775808L)
      {
        if (this.ajM != amjz.ajB) {
          break label232;
        }
        this.ajT |= 0x100000;
        if (!this.e.isOffLine)
        {
          this.ajT |= 0x0;
          if (this.e.clickCount >= 3) {
            if (this.e.clickCount >= 128) {
              break label247;
            }
          }
        }
      }
      label232:
      label247:
      for (this.ajT |= (this.e.clickCount & 0x7F) << 32;; this.ajT |= 0x0)
      {
        if (i != 0) {
          this.ajT |= 0x0;
        }
        if (this.e.certifiedGrade == 1L) {
          this.ajT |= 0x80000000;
        }
        return this.ajT;
        this.ajT |= 0x80000;
        break;
      }
    }
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    Object localObject2 = paramView.getContext();
    if (localObject2 == null) {}
    label133:
    label212:
    label883:
    label888:
    label891:
    for (;;)
    {
      return;
      if ((localObject2 instanceof UniteSearchActivity))
      {
        amxk.b("all_result", "clk_public_uin", new String[] { "" + this.keyword });
        amub.a(null, 0, this.fromType, "0X8009D51", 0, 0, this.e.getUin(), null);
      }
      String str = this.e.getUin();
      aqiy.bk(null, "pubAcc_aio_open", str);
      Object localObject1 = (acja)this.app.getManager(56);
      if (acbn.blN.equals(str))
      {
        ogj.c((Context)localObject2, "from_search_result", 1, true);
        amxk.a(this.keyword, 50, 0, paramView, str, this.e.isOffLine, this.fromType);
        aclj.Q(this.app, this.keyword);
        amxk.a(this.keyword, 50, paramView, false);
        if ((!(localObject2 instanceof BaseActivity)) || (this.cao <= 0)) {
          continue;
        }
        localObject1 = null;
        if (!(localObject2 instanceof UniteSearchActivity)) {
          break label812;
        }
        localObject1 = "0X8006570";
        paramView = "0X8005D1C";
      }
      for (;;)
      {
        if (paramView == null) {
          break label891;
        }
        localObject2 = ((BaseActivity)localObject2).app;
        if (this.fromType == 12)
        {
          anot.b((QQAppInterface)localObject2, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 1, 0, this.cao + "", "", str, this.keyword);
          paramView = kbq.a();
          localObject1 = this.e.name;
          if (this.e.extendType == 2) {
            break label883;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramView.a((QQAppInterface)localObject2, str, (String)localObject1, bool);
          return;
          if (acbn.blS.equals(str))
          {
            ocp.b((Context)localObject2, this.app);
            break label133;
          }
          if ((TextUtils.equals("2290230341", str)) && (QZoneMsgActivity.e((Context)localObject2, this.app))) {
            break label133;
          }
          if (acbn.blO.equals(str))
          {
            KandianSubscribeManager.e((Context)localObject2, 3, 2);
            break label133;
          }
          if (acbn.blP.equals(str))
          {
            KandianDailyManager.bV((Context)localObject2);
            break label133;
          }
          if (("2747277822".equals(str)) && (ahty.anY()))
          {
            ahua.es((Context)localObject2);
            this.app.a().h("2747277822", 1008, false);
            break label133;
          }
          if (MiniGamePublicAccountHelper.shouldOpenWebFragment(str))
          {
            MiniGamePublicAccountHelper.launchMiniGamePublicAccount((Context)localObject2);
            this.app.a().h(acbn.blT, 1008, false);
            break label133;
          }
          if (TextUtils.equals("3046055438", str))
          {
            kee.d(this.app, (Context)localObject2, str, ((Context)localObject2).getResources().getString(2131692999));
            this.app.a().h("3046055438", 1008, false);
            break label133;
          }
          if (((localObject1 != null) && (((acja)localObject1).f(Long.valueOf(str)))) || ((localObject1 == null) && (ocp.c(this.app, str))))
          {
            Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
            int i = 1008;
            if (this.e.extendType == 2)
            {
              localIntent.putExtra("chat_subType", 1);
              i = 0;
            }
            if (TextUtils.isEmpty(str))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
              return;
            }
            localIntent.putExtra("uin", str);
            localIntent.putExtra("uintype", i);
            localIntent.putExtra("uinname", this.e.name);
            localIntent.putExtra("selfSet_leftViewText", ((Context)localObject2).getString(2131691039));
            aalb.bwg = true;
            aalb.cT(localIntent);
            ((Context)localObject2).startActivity(localIntent);
            this.e.clickCount += 1;
            if (localObject1 == null) {
              break label133;
            }
            ((acja)localObject1).c(this.e);
            break label133;
          }
          if (TextUtils.isEmpty(str))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
            return;
          }
          localObject1 = new Intent(paramView.getContext(), AccountDetailActivity.class);
          ((Intent)localObject1).putExtra("uin", str);
          ((Intent)localObject1).putExtra("source", 4);
          ((Context)localObject2).startActivity((Intent)localObject1);
          break label133;
          if (!(localObject2 instanceof PublicAcntSearchActivity)) {
            break label888;
          }
          localObject1 = "0X8006588";
          paramView = "0X8005D1E";
          break label212;
          kbp.a((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", str, paramView, paramView, 0, 0, this.cao + "", "", this.keyword, "", false);
          break label283;
        }
        paramView = null;
      }
    }
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    SpannableString localSpannableString = new amxa(new ArrayList(), getKeyword()).a(amxk.g(this.e.summary));
    Object localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getUin()
  {
    return this.e.getUin();
  }
  
  public int lk()
  {
    return 0;
  }
  
  public int pG()
  {
    return 1;
  }
  
  public String za()
  {
    return this.e.name;
  }
  
  public String zb()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqy
 * JD-Core Version:    0.7.0.1
 */