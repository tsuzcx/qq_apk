import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.a;
import com.tencent.mobileqq.apollo.view.ApolloMainViewBinder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class acae
  extends acbg
  implements View.OnClickListener
{
  private static int ctP;
  private static int ctQ;
  private static int ctR;
  private static int ctS;
  TextView Qo;
  TextView Qp;
  private abza a;
  private int ctN = 4;
  private int ctO = 2;
  Button fH;
  QQAppInterface mApp;
  boolean mIsInit = false;
  ImageView xA;
  ImageView ya;
  
  public acae(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.mContext = paramContext;
    this.mBinderType = 0;
    this.mApp = paramQQAppInterface;
    this.mSessionInfo = paramSessionInfo;
  }
  
  public int Ad()
  {
    int j = 1;
    int k = this.ctN * this.ctO;
    int i = j;
    switch (this.awS)
    {
    case 2: 
    default: 
      i = 0;
    }
    int m;
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (this.xf == null);
        i = j;
      } while (this.xf.size() == 0);
      m = this.xf.size();
      if ((this.xf == null) || (m <= 0)) {
        break;
      }
      j = m / k + 0;
      i = j;
    } while (m % k == 0);
    return j + 1;
  }
  
  public void Eo(boolean paramBoolean)
  {
    this.mIsInit = paramBoolean;
  }
  
  public abzy a(String paramString)
  {
    return new acad(paramString);
  }
  
  public void a(abza paramabza)
  {
    this.a = paramabza;
  }
  
  public void ac(View paramView, int paramInt)
  {
    switch (this.awS)
    {
    case 2: 
    default: 
      return;
    case 1: 
      gm(paramView);
      return;
    case 0: 
      ad(paramView, paramInt);
      return;
    }
    gn(paramView);
  }
  
  public void ad(View paramView, int paramInt)
  {
    if (!(paramView instanceof ApolloLinearLayout)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "panel is not apolloLinearLayout");
      }
    }
    label1025:
    label1411:
    for (;;)
    {
      return;
      int n = this.ctN;
      int i1 = this.ctO;
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (j >= this.ctO) {
          break label1411;
        }
        LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(j);
        int k = 0;
        if (k < this.ctN)
        {
          View localView = localLinearLayout.getChildAt(k);
          ApolloLinearLayout.a locala = (ApolloLinearLayout.a)localView.getTag();
          int m = n * i1 * paramInt + i;
          if (this.xf == null) {
            break;
          }
          Object localObject1;
          label240:
          float f;
          label353:
          int i2;
          if (m < this.xf.size())
          {
            ApolloActionData localApolloActionData = ((abzy)this.xf.get(m)).c;
            locala.sk.setVisibility(0);
            if (((abzy)this.xf.get(m)).mType == 1)
            {
              localObject1 = new RedTouch(this.mContext, locala.sk).a(5).a();
              ((RedTouch)localObject1).e(((altq)this.mApp.getManager(36)).getAppInfoByPath("103100.103200"));
              locala.sk.setBackgroundResource(2130838683);
              locala.redTouch = ((RedTouch)localObject1);
              locala.name.setText(localApolloActionData.actionName);
              locala.d = ((abzy)this.xf.get(m));
              locala.d.mBinderType = 0;
              if (!TextUtils.isEmpty(localApolloActionData.iconUrl))
              {
                locala.g.setImageDrawable(abtn.a(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
                locala.g.setVisibility(0);
              }
              if (TextUtils.isEmpty(locala.d.bkj)) {
                break label1320;
              }
              if (XPanelContainer.evb != 0) {
                break label1095;
              }
              m = 1;
              locala.PW.setVisibility(0);
              locala.jw.setVisibility(0);
              locala.xZ.setVisibility(0);
              locala.PW.setText(locala.d.bkj);
              if (m == 0) {
                break label1101;
              }
              f = 3.0F;
              label404:
              i2 = wja.dp2px(f, this.mContext.getResources());
              localObject1 = (RelativeLayout.LayoutParams)locala.jw.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).topMargin = i2;
              ((RelativeLayout.LayoutParams)localObject1).width = (ApolloLinearLayout.cug - i2 * 2);
              locala.PW.setMaxHeight(ApolloLinearLayout.cug - i2 * 3);
              localObject1 = (RelativeLayout.LayoutParams)locala.PW.getLayoutParams();
              if (m == 0) {
                break label1108;
              }
              f = 2.0F;
              label486:
              ((RelativeLayout.LayoutParams)localObject1).topMargin = wja.dp2px(f, this.mContext.getResources());
              locala.xZ.setBackgroundResource(2130838521);
              if (locala.d.cue != 1) {
                break label1173;
              }
              if (m == 0) {
                break label1115;
              }
              locala.PW.setTextSize(8.0F);
              if (ctR == 0) {
                ctR = abju.d(locala.PW.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = ctR;
              label569:
              locala.PW.setTextColor(-4473925);
              locala.jw.setBackgroundDrawable(null);
              localObject1 = locala.jw;
              if (m == 0) {
                break label1313;
              }
              f = 3.0F;
              label604:
              ((RelativeLayout)localObject1).setPadding(0, 0, 0, wja.dp2px(f, this.mContext.getResources()));
              locala.PW.setMaxLines(3);
              label632:
              ApolloLinearLayout.setApolloActionIcon(locala.d.iconType, locala.d.c, locala);
              if ((localApolloActionData.personNum == 1) && ((this.mSessionInfo.cZ == 1) || (this.mSessionInfo.cZ == 3000))) {
                locala.xX.setVisibility(0);
              }
              m = this.ctO;
              i2 = this.ctN;
              int i3 = this.ctN;
              localObject1 = (RelativeLayout)localView;
              if ((this.cuv == -1) || (this.cuv != m * paramInt * i2 + i3 * j + k)) {
                break label1362;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloMainViewBinder", 2, new Object[] { "[updateBinderPanel] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.cuv), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId), ", pkgId=", Integer.valueOf(this.cud) });
              }
              if (locala.AU != null)
              {
                ((RelativeLayout)localObject1).removeView(locala.AU);
                locala.AU = null;
              }
              Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
              ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131363197);
              ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131363197);
              ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131363197);
              ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131363197);
              RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
              localRelativeLayout.setId(2131362766);
              localRelativeLayout.setBackgroundDrawable(null);
              ((RelativeLayout)localObject1).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject2);
              locala.AU = localRelativeLayout;
              localObject2 = new ImageView(this.mContext);
              ((ImageView)localObject2).setImageResource(2130838678);
              ((ImageView)localObject2).setVisibility(8);
              localRelativeLayout.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
              ((ImageView)localObject2).postDelayed(new ApolloMainViewBinder.1(this, (ImageView)localObject2, localRelativeLayout, (RelativeLayout)localObject1, locala), 200L);
              this.cuv = -1;
              localView.setContentDescription(localApolloActionData.actionName);
            }
          }
          for (;;)
          {
            i += 1;
            k += 1;
            break;
            locala.sk.setBackgroundDrawable(((abzy)this.xf.get(m)).a(this.mContext, this.mContext.getResources().getDisplayMetrics().density));
            break label240;
            label1095:
            m = 0;
            break label353;
            label1101:
            f = 5.0F;
            break label404;
            label1108:
            f = 5.0F;
            break label486;
            label1115:
            locala.PW.setMaxHeight(ApolloLinearLayout.cug - i2 * 2);
            locala.PW.setTextSize(12.0F);
            if (ctP == 0) {
              ctP = abju.d(locala.PW.getPaint());
            }
            ((RelativeLayout.LayoutParams)localObject1).width = ctP;
            break label569;
            label1173:
            if (m != 0)
            {
              locala.PW.setTextSize(7.0F);
              if (ctS == 0) {
                ctS = abju.d(locala.PW.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = ctS;
              label1217:
              localObject1 = locala.PW;
              if (m == 0) {
                break label1306;
              }
            }
            label1306:
            for (f = 7.0F;; f = 10.0F)
            {
              ((TextView)localObject1).setTextSize(f);
              locala.PW.setTextColor(-8947849);
              locala.jw.setBackgroundResource(2130838522);
              break;
              locala.PW.setTextSize(10.0F);
              if (ctQ == 0) {
                ctQ = abju.d(locala.PW.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = ctQ;
              break label1217;
            }
            label1313:
            f = 9.0F;
            break label604;
            label1320:
            locala.xZ.setBackgroundDrawable(null);
            locala.PW.setVisibility(8);
            locala.jw.setVisibility(8);
            locala.xZ.setVisibility(8);
            break label632;
            label1362:
            if (locala.AU == null) {
              break label1025;
            }
            ((RelativeLayout)localObject1).removeView(locala.AU);
            locala.AU = null;
            break label1025;
            localView.setContentDescription(null);
            localView.setOnClickListener(null);
          }
        }
        j += 1;
      }
    }
  }
  
  public View bQ()
  {
    switch (this.awS)
    {
    case 2: 
    default: 
      return new ApolloLinearLayout(this.mContext, null, this.mBinderType, this.ctN, this.ctO);
    case 0: 
      return new ApolloLinearLayout(this.mContext, null, this.mBinderType, this.ctN, this.ctO);
    case 1: 
      return LayoutInflater.from(this.mContext).inflate(2131558724, null);
    }
    return LayoutInflater.from(this.mContext).inflate(2131558719, null);
  }
  
  public void cGA()
  {
    if ((this.xA != null) && (this.Qo != null) && (this.Qo != null) && (this.Qp != null))
    {
      this.xA.setVisibility(4);
      this.ya.setVisibility(0);
      this.Qo.setVisibility(0);
      this.Qp.setVisibility(0);
    }
  }
  
  public void cGB()
  {
    if (this.xA != null) {
      this.xA.setVisibility(8);
    }
    if (this.fH != null) {
      this.fH.setClickable(true);
    }
  }
  
  public void gm(View paramView)
  {
    if (paramView == null) {
      return;
    }
    URLImageView localURLImageView1 = (URLImageView)paramView.findViewById(2131362776);
    URLImageView localURLImageView2 = (URLImageView)paramView.findViewById(2131362809);
    this.fH = ((Button)paramView.findViewById(2131362808));
    localURLImageView1.setVisibility(0);
    this.fH.setVisibility(0);
    if (this.mIsInit) {
      this.fH.setText(acfp.m(2131702608));
    }
    Object localObject = new ColorDrawable();
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", (Drawable)localObject, (Drawable)localObject);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_buttom_man_v2.png", (Drawable)localObject, (Drawable)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView1.getLayoutParams();
    localLayoutParams.height = ((int)(XPanelContainer.aLe - 85.0F * paramView.getResources().getDisplayMetrics().density));
    localLayoutParams.width = (localLayoutParams.height * 602 / 366);
    localLayoutParams.bottomMargin = ((int)(5.0F * paramView.getResources().getDisplayMetrics().density));
    localURLImageView1.setBackgroundDrawable(localURLDrawable);
    localURLImageView2.setBackgroundDrawable((Drawable)localObject);
    this.fH.setOnClickListener(this);
  }
  
  public void gn(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.Qp = ((TextView)paramView.findViewById(2131376641));
      if (this.Qp != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "panel is not jsonFail and panelView.class=" + paramView.getClass().getSimpleName());
    return;
    this.Qp.setVisibility(0);
    this.Qp.setOnClickListener(this);
    this.xA = ((ImageView)paramView.findViewById(2131369986));
    this.ya = ((ImageView)paramView.findViewById(2131369984));
    this.Qo = ((TextView)paramView.findViewById(2131369985));
  }
  
  public int gq(int paramInt)
  {
    if ((this.xf == null) || (paramInt < 0) || (paramInt >= this.xf.size())) {
      return -1;
    }
    return paramInt / (this.ctO * this.ctN);
  }
  
  public void ix(List<abzy> paramList)
  {
    this.xf = paramList;
  }
  
  public ArrayList<abzy> o(int paramInt)
  {
    if ((this.awS != 0) || (this.xf == null) || (this.xf.size() == 0)) {}
    do
    {
      return null;
      i = Ad();
    } while ((paramInt < 0) || (paramInt >= i));
    int i = this.ctN;
    int j = this.ctO * i;
    i = paramInt * j;
    ArrayList localArrayList = new ArrayList(this.ctN * this.ctO);
    paramInt = i;
    while ((paramInt < this.xf.size()) && (paramInt <= j + i - 1))
    {
      localArrayList.add(this.xf.get(paramInt));
      paramInt += 1;
    }
    return localArrayList;
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
      if (this.a != null)
      {
        this.a.cGx();
        if (this.mIsInit)
        {
          this.a.cGv();
        }
        else if (this.a != null)
        {
          paramView.setClickable(false);
          this.xA = ((ImageView)((View)paramView.getParent()).findViewById(2131379764));
          this.xA.setVisibility(0);
          this.a.onOpen();
          continue;
          if (this.a != null)
          {
            this.a.cGw();
            this.xA.setVisibility(0);
            this.ya.setVisibility(4);
            this.Qo.setVisibility(4);
            paramView.setVisibility(4);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
    this.mContext = null;
    this.xf = null;
    this.xA = null;
    this.fH = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acae
 * JD-Core Version:    0.7.0.1
 */