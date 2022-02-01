import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class abes
  extends BaseAdapter
{
  private abes.a jdField_a_of_type_Abes$a;
  private abes.b jdField_a_of_type_Abes$b;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new abev(this);
  private boolean bCg;
  private int coa;
  private Drawable dm;
  private Drawable er;
  protected HashMap<String, Drawable> ig;
  protected QQAppInterface mApp;
  private Context mContext;
  protected List<Object> mDataList;
  protected LayoutInflater mInflater;
  int mTargetDensity;
  
  public abes(QQAppInterface paramQQAppInterface, Context paramContext, List<aevs> paramList, abes.a parama, abes.b paramb)
  {
    this.mApp = paramQQAppInterface;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mDataList = new ArrayList();
    if (paramList != null) {
      this.mDataList.addAll(paramList);
    }
    this.jdField_a_of_type_Abes$a = parama;
    this.jdField_a_of_type_Abes$b = paramb;
    cBl();
    this.ig = new HashMap();
    this.mContext = paramContext;
    this.dm = paramContext.getResources().getDrawable(2130846238);
    this.er = paramContext.getResources().getDrawable(2130846249);
    this.mTargetDensity = this.mContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, aevs paramaevs, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b = 0;; b = 1)
    {
      paramaevs.bo = b;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramaevs.a.strResName + "  cCurFlag:" + paramaevs.bo);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      zjq.a().a(this.mApp, paramaevs.a.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((ackq)this.mApp.getBusinessHandler(31)).f(String.valueOf(paramaevs.a.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        altq localaltq = (altq)this.mApp.getManager(36);
        l = paramaevs.a.uiResId;
        localaltq.OS("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.dGB();
        }
      }
      cBl();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Abes$b != null) {
        this.jdField_a_of_type_Abes$b.c(paramaevs);
      }
      return;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((altq)this.mApp.getManager(36)).getAppInfoByPath(paramString);
    paramRedTouch.e(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((altq)this.mApp.getManager(36)).i(paramAppInfo);
  }
  
  private void cBl()
  {
    if (this.jdField_a_of_type_Abes$a == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.coa = 0;
      localArrayList = new ArrayList();
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof aevs))
        {
          localObject = (aevs)localObject;
          if ((this.jdField_a_of_type_Abes$a.a((aevs)localObject)) && (((aevs)localObject).bWG) && (((aevs)localObject).a.cCanChangeState != 0)) {
            localArrayList.add(localObject);
          } else {
            this.coa += 1;
          }
        }
      }
      this.mDataList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new acgw.a());
    this.mDataList.addAll(localArrayList);
    ds(localArrayList);
  }
  
  private void ds(ArrayList<aevs> paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((aevs)paramArrayList.get(0)).cPu = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((aevs)paramArrayList.get(i)).cPu = 3;
        i += 1;
      }
    case 1: 
      ((aevs)paramArrayList.get(0)).cPu = 0;
      return;
    }
    ((aevs)paramArrayList.get(0)).cPu = 1;
    ((aevs)paramArrayList.get(1)).cPu = 2;
    return;
    ((aevs)paramArrayList.get(paramArrayList.size() - 1)).cPu = 2;
  }
  
  public void Dx(boolean paramBoolean)
  {
    this.bCg = paramBoolean;
  }
  
  public void cS(List<aevs> paramList)
  {
    this.mDataList.clear();
    if (paramList != null) {
      this.mDataList.addAll(paramList);
    }
    cBl();
    this.ig.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.mDataList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mDataList.size())) {
      return this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aevs localaevs = (aevs)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((localaevs == null) || (localaevs.a == null))
    {
      localObject1 = paramView;
      localObject2 = paramView;
      paramView = (View)localObject1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    label173:
    label206:
    RedTouch localRedTouch;
    label254:
    String str;
    label362:
    label379:
    int i;
    if (paramView == null)
    {
      localObject2 = new abes.c();
      paramView = this.mInflater.inflate(2131559247, paramViewGroup, false);
      ((abes.c)localObject2).aN = ((RelativeLayout)paramView.findViewById(2131370334));
      ((abes.c)localObject2).fe = ((TextView)paramView.findViewById(2131370399));
      ((abes.c)localObject2).aL = ((ImageView)paramView.findViewById(2131370398));
      ((abes.c)localObject2).u = ((Switch)paramView.findViewById(2131364012));
      if (ThemeUtil.isDefaultTheme())
      {
        ((abes.c)localObject2).aN.setBackgroundResource(2130851241);
        ((abes.c)localObject2).fe.setTextColor(this.mContext.getResources().getColor(2131167311));
        paramView = new RedTouch(this.mApp.getApp().getApplicationContext(), paramView).c(100).a();
        paramView.setTag(localObject2);
        localRedTouch = (RedTouch)paramView;
        ((abes.c)localObject2).u.setOnCheckedChangeListener(null);
        if (localaevs.bo != 0) {
          break label777;
        }
        ((abes.c)localObject2).u.setChecked(true);
        ((abes.c)localObject2).u.setContentDescription(localaevs.a.strResName);
        ((abes.c)localObject2).u.setOnCheckedChangeListener(new abet(this, localRedTouch, localaevs));
        if (QLog.isColorLevel()) {
          QLog.i("LebaListMgrAdapter", 2, "getview name: " + localaevs.a.strResName + "  cCurFlag:" + localaevs.bo);
        }
        ((abes.c)localObject2).fe.setText(localaevs.a.strResName);
        ((abes.c)localObject2).e = localaevs;
        if (!this.bCg) {
          break label805;
        }
        localObject1 = this.er;
        if (!this.bCg) {
          break label814;
        }
        str = localaevs.a.strGridIconUrl;
        if (!this.bCg) {
          break label827;
        }
        i = wja.dp2px(32.0F, this.mContext.getResources());
        label401:
        Object localObject3 = (RelativeLayout.LayoutParams)((abes.c)localObject2).aL.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).width = i;
        ((RelativeLayout.LayoutParams)localObject3).height = i;
        ((abes.c)localObject2).aL.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = localObject1;
        if (localaevs != null)
        {
          localObject3 = localObject1;
          if (localaevs.a != null)
          {
            localObject3 = localObject1;
            if (!TextUtils.isEmpty(str))
            {
              localObject3 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
              ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
              ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
              localObject3 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject3);
              ((URLDrawable)localObject3).setTargetDensity(this.mTargetDensity);
              if (((URLDrawable)localObject3).getStatus() == 2) {
                ((URLDrawable)localObject3).restartDownload();
              }
              ((Drawable)localObject3).setColorFilter(-1, PorterDuff.Mode.DST_IN);
            }
          }
        }
        ((abes.c)localObject2).aL.setImageDrawable((Drawable)localObject3);
        if (localObject3 != null) {
          ThemeUtil.setThemeFilter((Drawable)localObject3, ThemeUtil.curThemeId);
        }
        if (localaevs.bo != 1) {
          break label845;
        }
        long l = localaevs.a.uiResId;
        a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      }
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          aqcl.Q(((abes.c)localObject2).fe, false);
          aqcl.Q(((abes.c)localObject2).u, false);
          aqcl.Q(((abes.c)localObject2).aL, false);
          ((abes.c)localObject2).aN.setContentDescription(((abes.c)localObject2).fe.getText());
        }
        if (Build.VERSION.SDK_INT >= 14) {
          ((abes.c)localObject2).aN.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
        }
        ((abes.c)localObject2).aN.setOnClickListener(new abeu(this, localRedTouch, localaevs));
      }
      localObject2 = paramView;
      break;
      ((abes.c)localObject2).aN.setBackgroundResource(2130851238);
      ((abes.c)localObject2).fe.setTextColor(this.mContext.getResources().getColor(2131167304));
      break label173;
      localObject2 = (abes.c)paramView.getTag();
      break label206;
      label777:
      ((abes.c)localObject2).u.setChecked(false);
      ((abes.c)localObject2).u.setContentDescription(localaevs.a.strResName);
      break label254;
      label805:
      localObject1 = this.dm;
      break label362;
      label814:
      str = localaevs.a.strResURL;
      break label379;
      label827:
      i = wja.dp2px(26.0F, this.mContext.getResources());
      break label401;
      label845:
      ((RedTouch)paramView).dGB();
    }
  }
  
  public void onPostThemeChanged() {}
  
  public static abstract interface a
  {
    public abstract boolean a(aevs paramaevs);
  }
  
  public static abstract interface b
  {
    public abstract void c(aevs paramaevs);
  }
  
  public static class c
  {
    public ImageView aL;
    public RelativeLayout aN;
    public aevs e;
    public TextView fe;
    public Switch u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abes
 * JD-Core Version:    0.7.0.1
 */