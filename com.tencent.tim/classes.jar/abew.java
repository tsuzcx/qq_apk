import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class abew
  extends BaseAdapter
{
  private aimo jdField_a_of_type_Aimo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private HashSet<Long> aL = new HashSet(30);
  QQAppInterface app;
  String bfw = "";
  private int cob;
  private int coc;
  Context context;
  private List<aevs> data;
  private Drawable dm;
  private LayoutInflater inflater;
  View.OnClickListener mOnClickListener;
  int mTargetDensity;
  
  public abew(Context paramContext, List<aevs> paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, ListView paramListView, View.OnClickListener paramOnClickListener)
  {
    this.context = paramContext;
    this.data = paramList;
    this.app = paramQQAppInterface;
    this.cob = paramInt1;
    this.coc = paramInt2;
    this.mOnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.inflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.dm = paramContext.getResources().getDrawable(2130846238);
    this.mTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Aimo != null)
    {
      zjo.b localb = new zjo.b();
      localb.app = this.app;
      localb.context = this.context;
      localb.redTouch = paramRedTouch;
      localb.Lg = paramLong;
      localb.bal = paramString;
      this.jdField_a_of_type_Aimo.a(localb);
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_").append(paramInt1);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_").append(paramInt2);
      return;
    }
    if ((this.jdField_a_of_type_Aimo != null) && (this.jdField_a_of_type_Aimo.ap() != null))
    {
      paramLong = (aimr)this.jdField_a_of_type_Aimo.ap().get(paramLong);
      if (paramLong == null) {}
    }
    for (paramLong = Integer.valueOf(paramLong.redPointType);; paramLong = null)
    {
      paramStringBuilder = paramStringBuilder.append("_");
      if (paramLong == null) {}
      for (paramInt1 = 0;; paramInt1 = paramLong.intValue())
      {
        paramStringBuilder.append(paramInt1);
        return;
      }
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, Map<Long, Integer> paramMap)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_").append(0);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_").append(0);
      return;
    }
    Integer localInteger = null;
    if (paramMap != null) {
      localInteger = (Integer)paramMap.get(paramLong);
    }
    paramLong = paramStringBuilder.append("_");
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      paramLong.append(i);
      return;
    }
  }
  
  public void a(aimo paramaimo)
  {
    this.jdField_a_of_type_Aimo = paramaimo;
  }
  
  public Map<Long, Integer> aa()
  {
    if ((this.data == null) || (this.data.isEmpty())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.data.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      aevs localaevs = (aevs)localIterator.next();
      if ((localaevs == null) || (localaevs.a == null) || (b(localaevs))) {
        break label114;
      }
      localHashMap.put(Long.valueOf(localaevs.a.uiResId), Integer.valueOf(i));
      i += 1;
    }
    label114:
    for (;;)
    {
      break;
      return localHashMap;
    }
  }
  
  protected boolean b(aevs paramaevs)
  {
    return !TextUtils.isEmpty(paramaevs.bCo);
  }
  
  public void bQ(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.aL.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.aL.iterator();
      Map localMap = aa();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong.longValue() != 10004L) || (paramBoolean))
        {
          localStringBuilder.append(localLong);
          a(localLong, localStringBuilder, localMap);
          a(localLong, localStringBuilder, paramInt1, paramInt2);
          if (localIterator.hasNext()) {
            localStringBuilder.append(";");
          }
        }
      }
      anot.a(this.app, "CliOper", "", "", "trends_plugin", "old_plugin_exp", 0, 0, "", "", "", localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, localStringBuilder.toString());
      }
    }
    this.aL.clear();
  }
  
  public int getCount()
  {
    if (this.data == null) {
      return 0;
    }
    return this.data.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.data == null) || (paramInt >= this.data.size()) || (paramInt < 0)) {
      return null;
    }
    return (aevs)this.data.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    if (TextUtils.isEmpty(((aevs)this.data.get(paramInt)).bCo)) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    if (getItem(paramInt) == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    aevs localaevs = (aevs)getItem(paramInt);
    int i = getItemViewType(paramInt);
    Object localObject3;
    if (i == 0) {
      if (paramView == null)
      {
        localObject1 = this.inflater.inflate(this.cob, null);
        localObject2 = new abew.a();
        ((abew.a)localObject2).aN = ((RelativeLayout)((View)localObject1).findViewById(2131370334));
        ((abew.a)localObject2).Pt = ((TextView)((View)localObject1).findViewById(2131370399));
        ((abew.a)localObject2).e = ((ThemeImageView)((View)localObject1).findViewById(2131370398));
        ((abew.a)localObject2).e.setMaskShape(auvj.euM);
        ((abew.a)localObject2).arrowIcon = ((ImageView)((View)localObject1).findViewById(2131362981));
        localObject1 = new RedTouch(this.context, (View)localObject1).c(36).a();
        ((View)localObject1).setTag(localObject2);
        if ((localaevs != null) && (localaevs.a != null)) {
          ((abew.a)localObject2).Pt.setText(localaevs.a.strResName);
        }
        ((abew.a)localObject2).Pt.setTextColor(this.context.getResources().getColor(2131167311));
        localObject3 = this.dm;
        if ((localaevs == null) || (localaevs.a == null)) {
          break label673;
        }
        if (TextUtils.isEmpty(localaevs.a.strResURL)) {
          break label658;
        }
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = wja.dp2px(26.0F, this.context.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.dm;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.dm;
        localObject3 = URLDrawable.getDrawable(localaevs.a.strResURL, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject3).setTargetDensity(this.mTargetDensity);
        if (((URLDrawable)localObject3).getStatus() == 2) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((abew.a)localObject2).e.setImageDrawable((Drawable)localObject3);
        ((abew.a)localObject2).f = localaevs;
        if ((localaevs != null) && (localaevs.a != null))
        {
          a((RedTouch)localObject1, localaevs.a.uiResId, localaevs.a.strPkgName);
          if (!this.aL.contains(Long.valueOf(localaevs.a.uiResId))) {
            this.aL.add(Long.valueOf(localaevs.a.uiResId));
          }
        }
        if ((AppSetting.enableTalkBack) && (localaevs != null) && (localaevs.a != null) && (!TextUtils.isEmpty(localaevs.a.strResName))) {
          aqcl.changeAccessibilityForView((View)localObject1, localaevs.a.strResName, Button.class.getName());
        }
      }
    }
    label658:
    label673:
    while (i != 1) {
      for (;;)
      {
        if (localObject1 != null)
        {
          ((View)localObject1).setOnClickListener(this.mOnClickListener);
          ((View)localObject1).setTag(-1, Integer.valueOf(paramInt));
        }
        localObject2 = this.app.a();
        if ((localaevs != null) && (localaevs.a != null) && (localaevs.a.uiResId == 770L) && (localObject2 != null)) {
          ((acgu)localObject2).cJA();
        }
        if (paramInt == 0)
        {
          if (!this.aL.contains(Long.valueOf(10000L))) {
            this.aL.add(Long.valueOf(10000L));
          }
          if (!this.aL.contains(Long.valueOf(10004L))) {
            this.aL.add(Long.valueOf(10004L));
          }
        }
        break;
        localObject2 = (abew.a)paramView.getTag();
        localObject1 = paramView;
        continue;
        ((abew.a)localObject2).e.setImageDrawable(this.dm);
        continue;
        ((abew.a)localObject2).e.setImageDrawable(this.dm);
      }
    }
    if (paramView == null) {}
    for (Object localObject2 = this.inflater.inflate(this.coc, null);; localObject2 = paramView)
    {
      boolean bool = anlm.ayn();
      ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      localObject3 = ((View)localObject2).findViewById(2131365360);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      i = wja.dp2px(12.0F, this.context.getResources());
      localObject1 = ((View)localObject3).getLayoutParams();
      if (bool) {
        i = 0;
      }
      ((ViewGroup.LayoutParams)localObject1).height = i;
      localObject1 = localObject2;
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void hN(List<aevs> paramList)
  {
    this.data = paramList;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    if (!b((aevs)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onPostThemeChanged()
  {
    notifyDataSetChanged();
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((((View)localObject).getTag(-1) != null) && ((((View)localObject).getTag(-1) instanceof Integer)))
          {
            if (((Integer)((View)localObject).getTag(-1)).intValue() == 0)
            {
              if (!this.aL.contains(Long.valueOf(10000L))) {
                this.aL.add(Long.valueOf(10000L));
              }
              if (!this.aL.contains(Long.valueOf(10004L))) {
                this.aL.add(Long.valueOf(10004L));
              }
            }
            else
            {
              int j = ((Integer)((View)localObject).getTag(-1)).intValue();
              if ((j == this.data.size() - 1) && (j >= 0)) {
                localObject = (aevs)this.data.get(j);
              }
            }
          }
          else if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof abew.a)))
          {
            localObject = (abew.a)((View)localObject).getTag();
            if ((localObject != null) && (((abew.a)localObject).f != null) && (((abew.a)localObject).f.a != null))
            {
              long l = ((abew.a)localObject).f.a.uiResId;
              if (!this.aL.contains(Long.valueOf(l))) {
                this.aL.add(Long.valueOf(l));
              }
            }
          }
        }
      }
    }
  }
  
  public class a
  {
    public TextView Pt;
    public RelativeLayout aN;
    public ImageView arrowIcon;
    public ThemeImageView e;
    public aevs f;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abew
 * JD-Core Version:    0.7.0.1
 */