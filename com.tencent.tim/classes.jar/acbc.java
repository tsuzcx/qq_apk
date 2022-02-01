import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.a;
import com.tencent.mobileqq.apollo.view.ApolloSlaveViewBinder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class acbc
  extends acbg
  implements View.OnClickListener
{
  private static int ctP;
  private static int ctQ;
  private static int ctR;
  private static int ctS;
  private int ctN = 2;
  private int ctO = 2;
  private QQAppInterface mApp;
  Context mContext;
  
  public acbc(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.mContext = paramContext;
    this.mBinderType = 4;
    this.mSessionInfo = paramSessionInfo;
    this.mApp = paramQQAppInterface;
  }
  
  private void ad(View paramView, int paramInt)
  {
    if (!(paramView instanceof ApolloLinearLayout)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "panel is not apolloLinearLayout");
      }
    }
    label525:
    label1322:
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
          break label1322;
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
          label311:
          float f;
          label362:
          int i2;
          Object localObject1;
          if (m < this.xf.size())
          {
            ApolloActionData localApolloActionData = ((abzy)this.xf.get(m)).c;
            locala.ju.setBackgroundResource(2130838681);
            locala.sk.setVisibility(0);
            locala.sk.setBackgroundDrawable(((abzy)this.xf.get(m)).a(this.mContext, this.mContext.getResources().getDisplayMetrics().density));
            locala.name.setText(localApolloActionData.actionName);
            locala.d = ((abzy)this.xf.get(m));
            if (!TextUtils.isEmpty(localApolloActionData.iconUrl))
            {
              locala.g.setImageDrawable(abtn.a(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
              locala.g.setVisibility(0);
            }
            if (!TextUtils.isEmpty(locala.d.bkj)) {
              if (XPanelContainer.evb == 0)
              {
                m = 1;
                locala.PW.setVisibility(0);
                locala.jw.setVisibility(0);
                locala.xZ.setVisibility(0);
                locala.PW.setText(locala.d.bkj);
                if (m == 0) {
                  break label1012;
                }
                f = 3.0F;
                i2 = wja.dp2px(f, this.mContext.getResources());
                localObject1 = (RelativeLayout.LayoutParams)locala.jw.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject1).topMargin = i2;
                ((RelativeLayout.LayoutParams)localObject1).width = (ApolloLinearLayout.cug - i2 * 2);
                locala.PW.setMaxHeight(ApolloLinearLayout.cug - i2 * 3);
                localObject1 = (RelativeLayout.LayoutParams)locala.PW.getLayoutParams();
                if (m == 0) {
                  break label1019;
                }
                f = 2.0F;
                label444:
                ((RelativeLayout.LayoutParams)localObject1).topMargin = wja.dp2px(f, this.mContext.getResources());
                locala.xZ.setBackgroundResource(2130838521);
                if (locala.d.cue != 1) {
                  break label1084;
                }
                if (m == 0) {
                  break label1026;
                }
                locala.PW.setTextSize(8.0F);
                if (ctR == 0) {
                  ctR = abju.d(locala.PW.getPaint());
                }
                ((RelativeLayout.LayoutParams)localObject1).width = ctR;
                locala.PW.setTextColor(-4473925);
                locala.jw.setBackgroundDrawable(null);
                localObject1 = locala.jw;
                if (m == 0) {
                  break label1224;
                }
                f = 3.0F;
                label560:
                ((RelativeLayout)localObject1).setPadding(0, 0, 0, wja.dp2px(f, this.mContext.getResources()));
                locala.PW.setMaxLines(3);
                label588:
                ApolloLinearLayout.setApolloActionIcon(locala.d.iconType, locala.d.c, locala);
                if ((localApolloActionData.personNum == 1) && ((this.mSessionInfo.cZ == 1) || (this.mSessionInfo.cZ == 3000))) {
                  locala.xX.setVisibility(0);
                }
                m = this.ctO;
                i2 = this.ctN;
                int i3 = this.ctN;
                localObject1 = (RelativeLayout)localView;
                if ((this.cuv == -1) || (this.cuv != m * paramInt * i2 + i3 * j + k)) {
                  break label1273;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloSlaveViewBinder", 2, new Object[] { "[updateBinderPanel] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.cuv), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId), ", pkgId=", Integer.valueOf(this.cud) });
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
                ((ImageView)localObject2).postDelayed(new ApolloSlaveViewBinder.1(this, (ImageView)localObject2, localRelativeLayout, (RelativeLayout)localObject1, locala), 200L);
                this.cuv = -1;
                label981:
                localView.setContentDescription(localApolloActionData.actionName);
              }
            }
          }
          for (;;)
          {
            i += 1;
            k += 1;
            break;
            m = 0;
            break label311;
            label1012:
            f = 5.0F;
            break label362;
            label1019:
            f = 5.0F;
            break label444;
            locala.PW.setMaxHeight(ApolloLinearLayout.cug - i2 * 2);
            locala.PW.setTextSize(12.0F);
            if (ctP == 0) {
              ctP = abju.d(locala.PW.getPaint());
            }
            ((RelativeLayout.LayoutParams)localObject1).width = ctP;
            break label525;
            label1084:
            if (m != 0)
            {
              locala.PW.setTextSize(7.0F);
              if (ctS == 0) {
                ctS = abju.d(locala.PW.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = ctS;
              label1128:
              localObject1 = locala.PW;
              if (m == 0) {
                break label1217;
              }
            }
            label1217:
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
              break label1128;
            }
            label1224:
            f = 9.0F;
            break label560;
            locala.xZ.setBackgroundDrawable(null);
            locala.PW.setVisibility(8);
            locala.jw.setVisibility(8);
            locala.xZ.setVisibility(8);
            break label588;
            label1273:
            if (locala.AU == null) {
              break label981;
            }
            ((RelativeLayout)localObject1).removeView(locala.AU);
            locala.AU = null;
            break label981;
            localView.setContentDescription(null);
            localView.setOnClickListener(null);
          }
        }
        j += 1;
      }
    }
  }
  
  public int Ad()
  {
    int k = this.ctN * this.ctO;
    int i;
    if ((this.xf == null) || (this.xf.size() == 0)) {
      i = 1;
    }
    int m;
    int j;
    do
    {
      return i;
      m = this.xf.size();
      j = 0 + m / k;
      i = j;
    } while (m % k == 0);
    return j + 1;
  }
  
  public abzy a(String paramString)
  {
    return new acad(paramString);
  }
  
  public void ac(View paramView, int paramInt)
  {
    ad(paramView, paramInt);
  }
  
  public View bQ()
  {
    return new ApolloLinearLayout(this.mContext, null, this.mBinderType, this.ctN, this.ctO);
  }
  
  public int gq(int paramInt)
  {
    if ((this.xf == null) || (paramInt < 0) || (paramInt >= this.xf.size())) {
      return -1;
    }
    return paramInt / (this.ctO * this.ctN);
  }
  
  public ArrayList<abzy> o(int paramInt)
  {
    if ((this.awS != 9) || (this.xf == null) || (this.xf.size() == 0)) {}
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
  
  public void onClick(View paramView) {}
  
  public void onDestroy()
  {
    this.xf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbc
 * JD-Core Version:    0.7.0.1
 */