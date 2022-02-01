import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aimz
  implements View.OnClickListener
{
  public aimo a;
  public aimj c;
  private int ddU;
  private int ddV;
  private int ddW;
  private int ddX;
  private Drawable eB;
  private int itemHeight;
  public QQAppInterface mApp;
  private List<aevs> mDataList;
  private LayoutInflater mInflater;
  public LinearLayout mRootLayout;
  private int mTargetDensity;
  
  public aimz(Context paramContext)
  {
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.eB = paramContext.getResources().getDrawable(2130846249);
    this.mTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
    paramContext = paramContext.getResources();
    this.ddX = 3;
    this.ddU = wja.dp2px(1.0F, paramContext);
    this.ddV = this.ddU;
    this.ddW = aqnm.dpToPx(16.0F);
    this.itemHeight = wja.dp2px(114.0F, paramContext);
  }
  
  private int a(LinearLayout paramLinearLayout)
  {
    int i = 0;
    int k = 0;
    int m = paramLinearLayout.getChildCount();
    if (m == 0) {}
    int j;
    do
    {
      return k;
      j = 0;
      k = i;
    } while (j >= m);
    View localView = paramLinearLayout.getChildAt(j);
    if ((localView != null) && ((localView instanceof LinearLayout))) {
      i = ((LinearLayout)localView).getChildCount() + i;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  private aevs a(View paramView)
  {
    int i = paramView.getId();
    if ((i >= 0) && (i < this.mDataList.size())) {
      return (aevs)this.mDataList.get(i);
    }
    return null;
  }
  
  private View a(LinearLayout paramLinearLayout, int paramInt)
  {
    try
    {
      paramLinearLayout = (LinearLayout)paramLinearLayout.getChildAt(paramInt / this.ddX);
      if (paramLinearLayout == null)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("lineLayout == null  ", new Object[] { Integer.valueOf(paramInt) }));
        return null;
      }
      paramLinearLayout = paramLinearLayout.getChildAt(paramInt % this.ddX);
      return paramLinearLayout;
    }
    catch (Exception paramLinearLayout)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("findViewByIndex,index = ", new Object[] { Integer.valueOf(paramInt) }), paramLinearLayout);
    }
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if (paramView == null) {
      paramStringBuilder1.append(",headView == null");
    }
    int i;
    int j;
    do
    {
      return;
      paramView = paramView.findViewById(2131376042);
      if (paramView == null)
      {
        paramStringBuilder1.append(",qZone == null");
        return;
      }
      i = paramView.getTop();
      j = paramView.getHeight() + i;
      paramStringBuilder1.append(",qZoneTop = ").append(i).append(",qZoneBottom = ").append(j);
    } while (((paramFloat1 >= i) || (i >= paramFloat2)) && ((paramFloat1 >= j) || (j >= paramFloat2)));
    paramStringBuilder2.append(10000L).append("_").append(0).append("_").append(paramInt1).append("_").append(0).append("_").append(aims.ib(paramInt2)).append("_").append(paramString).append(";");
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if (paramView == null) {
      paramStringBuilder1.append(",headView == null");
    }
    int i;
    int j;
    do
    {
      return;
      paramView = paramView.findViewById(2131375019);
      if (paramView == null)
      {
        paramStringBuilder1.append(",qcircle == null");
        return;
      }
      if (!paramBoolean)
      {
        paramStringBuilder1.append(",no ShowQQCirle");
        return;
      }
      i = paramView.getTop();
      j = paramView.getHeight() + i;
      paramStringBuilder1.append(",qCircleTop = ").append(i).append(",qCircleBottom = ").append(j);
    } while (((paramFloat1 >= i) || (i >= paramFloat2)) && ((paramFloat1 >= j) || (j >= paramFloat2)));
    paramStringBuilder2.append(10004L).append("_").append(0).append("_").append(paramInt).append("_").append(0).append("_").append(0).append("_").append(paramString).append(";");
  }
  
  private void a(float paramFloat1, float paramFloat2, String paramString, View paramView, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramView = paramView.findViewById(2131379174);
    if (paramView == null)
    {
      paramStringBuilder1.append(",tableRoot == null");
      return;
    }
    int n = paramView.getTop();
    int i1 = this.mRootLayout.getChildCount();
    paramStringBuilder1.append(", r_top = ").append(n).append(", r_count = ").append(i1);
    int i = 0;
    label65:
    if (i < i1)
    {
      paramView = this.mRootLayout.getChildAt(i);
      if (paramView != null) {
        break label97;
      }
    }
    label97:
    int j;
    int k;
    label223:
    Object localObject;
    for (;;)
    {
      i += 1;
      break label65;
      break;
      if ((paramView instanceof LinearLayout))
      {
        j = paramView.getTop() + n;
        k = paramView.getHeight() + j;
        paramStringBuilder1.append(",").append(i).append(" v_top ").append(j).append(" v_bottom ").append(k);
        if (((paramFloat1 < j) && (j < paramFloat2)) || ((paramFloat1 < k) && (k < paramFloat2))) {}
        for (j = 1; (j != 0) && ((paramView instanceof LinearLayout)); j = 0)
        {
          paramView = (LinearLayout)paramView;
          int i2 = paramView.getChildCount();
          j = 0;
          if (j >= i2) {
            break label449;
          }
          localObject = paramView.getChildAt(j);
          if (localObject != null) {
            break label259;
          }
          paramStringBuilder1.append("itemView == null ");
          return;
        }
      }
    }
    label259:
    aevs localaevs = a((View)localObject);
    if ((localaevs == null) || (localaevs.a == null))
    {
      paramStringBuilder1.append(" item == null ||  item.info == null ");
      return;
    }
    paramStringBuilder1.append(localaevs.a.uiResId).append(",");
    long l = localaevs.a.uiResId;
    int i3 = ((View)localObject).getId();
    int m;
    if (this.a != null)
    {
      localObject = (aimr)this.a.ap().get(Long.valueOf(localaevs.a.uiResId));
      if (localObject != null)
      {
        m = ((aimr)localObject).redPointType;
        k = ((aimr)localObject).ddP;
      }
    }
    for (;;)
    {
      paramStringBuilder2.append(l).append("_").append(i3 + 1).append("_").append(m).append("_").append(k).append("_").append(0).append("_").append(paramString).append(";");
      j += 1;
      break label223;
      label449:
      break;
      k = 0;
      m = 0;
    }
  }
  
  private void a(int paramInt, LinearLayout paramLinearLayout)
  {
    for (;;)
    {
      try
      {
        int i = (paramInt + 1) % this.ddX;
        if (i != 0) {
          break label265;
        }
        i = this.ddX;
        j = paramInt / this.ddX;
        LinearLayout localLinearLayout = (LinearLayout)paramLinearLayout.getChildAt(j);
        if (localLinearLayout != null) {
          break label262;
        }
        localLinearLayout = new LinearLayout(paramLinearLayout.getContext());
        localLinearLayout.setWeightSum(this.ddX);
        Object localObject = new LinearLayout.LayoutParams(-1, this.itemHeight);
        if (j <= 0) {
          break label268;
        }
        j = this.ddV;
        ((LinearLayout.LayoutParams)localObject).setMargins(0, j, 0, 0);
        paramLinearLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
        localObject = new aina(paramLinearLayout.getContext(), this.mInflater);
        paramLinearLayout = ((aina)localObject).rootView;
        paramLinearLayout.setTag(localObject);
        paramLinearLayout.setId(paramInt);
        localObject = ((aina)localObject).a;
        if (localObject != null)
        {
          ((LebaRoundLayout)localObject).mRadius = this.ddW;
          ((LebaRoundLayout)localObject).ddZ = ic(paramInt);
          localObject = new LinearLayout.LayoutParams(0, this.itemHeight, 1.0F);
          if (i > 1)
          {
            i = this.ddU;
            ((LinearLayout.LayoutParams)localObject).setMargins(i, 0, 0, 0);
            localLinearLayout.addView(paramLinearLayout, (ViewGroup.LayoutParams)localObject);
          }
        }
        else
        {
          QLog.i("Q.lebatab.LebaTableLogic", 1, "rootLayout != null");
          continue;
        }
        i = 0;
      }
      catch (Exception paramLinearLayout)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, "addTableItem,index = " + paramInt, paramLinearLayout);
        return;
      }
      continue;
      label262:
      continue;
      label265:
      continue;
      label268:
      int j = 0;
    }
  }
  
  private void h(LinearLayout paramLinearLayout)
  {
    int i = a(paramLinearLayout);
    int j = this.mDataList.size();
    if (i != j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      this.mRootLayout.removeAllViews();
      localStringBuilder.append("removeAllViews");
      i = 0;
      while (i < j)
      {
        a(i, paramLinearLayout);
        localStringBuilder.append(" ").append(i);
        i += 1;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder.toString());
    }
  }
  
  private void i(LinearLayout paramLinearLayout)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    boolean bool1;
    boolean bool2;
    int i;
    label100:
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("1103".equals(localObject1)) || ("2101".equals(localObject1)))
    {
      bool1 = true;
      bool2 = ThemeUtil.isNowThemeIsNight(this.mApp, false, null);
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("bindDataToTable themeId %s isNeedWaterMark %b isNight = %b", new Object[] { localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      i = 0;
      if (i >= this.mDataList.size()) {
        return;
      }
      localObject1 = (aevs)this.mDataList.get(i);
      localObject2 = a(paramLinearLayout, i);
      if (localObject2 != null) {
        break label176;
      }
      QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView == null %d", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      i += 1;
      break label100;
      bool1 = false;
      break;
      label176:
      if (((View)localObject2).getTag() == null)
      {
        QLog.i("Q.lebatab.LebaTableLogic", 1, String.format("itemView.getTag() == null %d", new Object[] { Integer.valueOf(i) }));
      }
      else
      {
        localObject2 = (aina)((View)localObject2).getTag();
        aina.a locala = new aina.a();
        locala.d = ((aevs)localObject1);
        locala.app = this.mApp;
        locala.context = paramLinearLayout.getContext();
        locala.dm = this.eB;
        locala.ddY = this.mTargetDensity;
        locala.onClickListener = this;
        locala.b = this.a;
        locala.isNight = bool2;
        locala.index = i;
        locala.ckF = bool1;
        ((aina)localObject2).a(locala);
      }
    }
  }
  
  private int ic(int paramInt)
  {
    int i = 0;
    int k = 0;
    int j = k;
    if (this.mDataList != null)
    {
      if (this.mDataList.isEmpty()) {
        j = k;
      }
    }
    else {
      return j;
    }
    int m = this.mDataList.size();
    if (paramInt == 0) {
      i = 1;
    }
    j = i;
    if (paramInt == m - 1) {
      j = i | 0x4;
    }
    if (this.ddX > m) {}
    for (k = m - 1;; k = this.ddX - 1)
    {
      i = j;
      if (paramInt == k) {
        i = j | 0x2;
      }
      j = m % this.ddX;
      k = j;
      if (j == 0) {
        k = 3;
      }
      j = i;
      if (paramInt != m - k) {
        break;
      }
      return i | 0x8;
    }
  }
  
  private void lg(List<aevs> paramList)
  {
    if (this.mDataList == null) {
      this.mDataList = new ArrayList();
    }
    while (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        aevs localaevs = (aevs)localIterator.next();
        if ((localaevs != null) && (TextUtils.isEmpty(localaevs.bCo))) {
          this.mDataList.add(localaevs);
        }
      }
      this.mDataList.clear();
    }
    acgw.G(paramList, fn());
    if (!this.mDataList.isEmpty())
    {
      int j = this.mDataList.size() % this.ddX;
      if ((j > 0) && (j < this.ddX))
      {
        int i = 0;
        while (i < this.ddX - j)
        {
          this.mDataList.add(new aevs());
          i += 1;
        }
      }
    }
  }
  
  private void notifyDataSetChanged()
  {
    if (this.mRootLayout == null)
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "notifyDataSetChanged mRootLayout == null");
      return;
    }
    if ((this.mDataList == null) || (this.mDataList.isEmpty()))
    {
      dsU();
      return;
    }
    h(this.mRootLayout);
    i(this.mRootLayout);
  }
  
  public void a(float paramFloat1, float paramFloat2, View paramView1, View paramView2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((this.mRootLayout == null) || (paramView1 == null))
    {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "statExposure mRootLayout == null || lvView == null");
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str = ThemeUtil.getCurrentThemeId();
    paramFloat2 += paramView1.getHeight() - paramView1.getPaddingBottom() - paramView1.getPaddingTop();
    localStringBuilder1.append("reportExposure, e_top = ").append(paramFloat1).append(", e_bottom = ").append(paramFloat2);
    a(paramFloat1, paramFloat2, paramInt1, paramInt2, str, paramView2, localStringBuilder1, localStringBuilder2);
    a(paramFloat1, paramFloat2, paramInt3, paramBoolean, str, paramView2, localStringBuilder1, localStringBuilder2);
    a(paramFloat1, paramFloat2, str, paramView2, localStringBuilder1, localStringBuilder2);
    paramView1 = aims.a("plugin_exp");
    paramView1.cgp = localStringBuilder2.toString();
    anny.b(this.mApp, paramView1);
    QLog.i("Q.lebatab.LebaTableLogic", 1, localStringBuilder2);
  }
  
  public void dsU()
  {
    if (this.mRootLayout != null)
    {
      this.mRootLayout.setPadding(0, 0, 0, 0);
      this.mRootLayout.removeAllViews();
    }
  }
  
  public List<Integer> fn()
  {
    if (this.mApp != null) {
      return acgw.a(this.mApp, acgw.C(this.mApp));
    }
    return null;
  }
  
  public void lf(List<aevs> paramList)
  {
    lg(paramList);
    notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if (this.mDataList != null)
    {
      aevs localaevs = a(paramView);
      if ((localaevs != null) && (this.c != null))
      {
        aimq localaimq = new aimq();
        localaimq.bCg = true;
        localaimq.WP = localaevs.WP;
        localaimq.position = (paramView.getId() + 1);
        if ((paramView instanceof RedTouch))
        {
          localaimq.redPointType = aims.b((RedTouch)paramView);
          localaimq.ddP = aims.c((RedTouch)paramView);
        }
        this.c.a(paramView, localaevs, localaimq);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimz
 * JD-Core Version:    0.7.0.1
 */