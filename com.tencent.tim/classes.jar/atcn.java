import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class atcn
  extends BaseAdapter
{
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new atco(this);
  private atcn.a jdField_a_of_type_Atcn$a;
  private Drawable dm;
  protected QQAppInterface mApp;
  private Context mContext;
  protected List<Object> mDataList;
  protected LayoutInflater mInflater;
  
  public atcn(QQAppInterface paramQQAppInterface, Context paramContext, List<aunr> paramList, atcn.a parama)
  {
    this.mApp = paramQQAppInterface;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mDataList = new ArrayList();
    if (paramList != null) {
      this.mDataList.addAll(paramList);
    }
    this.jdField_a_of_type_Atcn$a = parama;
    this.mContext = paramContext;
    this.dm = paramContext.getResources().getDrawable(2130846238);
  }
  
  private void a(RedTouch paramRedTouch, aunr paramaunr, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b = 0;; b = 1)
    {
      paramaunr.bo = b;
      if (QLog.isColorLevel()) {
        QLog.i("TimLebaListMgrAdapter", 2, "name: " + paramaunr.c.strResName + "  cCurFlag:" + paramaunr.bo);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      ((ackq)this.mApp.getBusinessHandler(31)).f(String.valueOf(paramaunr.c.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        altq localaltq = (altq)this.mApp.getManager(36);
        l = paramaunr.c.uiResId;
        localaltq.OS("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.dGB();
        }
      }
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Atcn$a != null) {
        this.jdField_a_of_type_Atcn$a.a(paramaunr);
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
  
  public void cS(List<aunr> paramList)
  {
    this.mDataList.clear();
    if (paramList != null) {
      this.mDataList.addAll(paramList);
    }
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
    aunr localaunr = (aunr)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((localaunr == null) || (localaunr.c == null))
    {
      localObject1 = paramView;
      localObject2 = paramView;
      paramView = (View)localObject1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    label170:
    label203:
    RedTouch localRedTouch;
    if (paramView == null)
    {
      localObject1 = new atcn.b();
      paramView = this.mInflater.inflate(2131559247, paramViewGroup, false);
      ((atcn.b)localObject1).aN = ((RelativeLayout)paramView.findViewById(2131370334));
      ((atcn.b)localObject1).fe = ((TextView)paramView.findViewById(2131370399));
      ((atcn.b)localObject1).aL = ((ImageView)paramView.findViewById(2131370398));
      ((atcn.b)localObject1).u = ((Switch)paramView.findViewById(2131364012));
      if (ThemeUtil.isDefaultTheme())
      {
        ((atcn.b)localObject1).aN.setBackgroundResource(2130851241);
        ((atcn.b)localObject1).fe.setTextColor(this.mContext.getResources().getColor(2131167311));
        paramView = new RedTouch(this.mApp.getApp().getApplicationContext(), paramView).c(100).a();
        paramView.setTag(localObject1);
        localRedTouch = (RedTouch)paramView;
        ((atcn.b)localObject1).u.setOnCheckedChangeListener(null);
        if (localaunr.bo != 0) {
          break label648;
        }
        ((atcn.b)localObject1).u.setChecked(true);
        ((atcn.b)localObject1).u.setContentDescription(localaunr.c.strResName);
        label251:
        ((atcn.b)localObject1).u.setOnCheckedChangeListener(new atcp(this, localRedTouch, localaunr));
        if (QLog.isColorLevel()) {
          QLog.i("TimLebaListMgrAdapter", 2, "getview name: " + localaunr.c.strResName + "  cCurFlag:" + localaunr.bo);
        }
        ((atcn.b)localObject1).fe.setText(localaunr.c.strResName);
        ((atcn.b)localObject1).b = localaunr;
        localObject2 = this.dm;
        int i = wja.dp2px(26.0F, this.mContext.getResources());
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((atcn.b)localObject1).aL.getLayoutParams();
        localLayoutParams.width = i;
        localLayoutParams.height = i;
        ((atcn.b)localObject1).aL.setLayoutParams(localLayoutParams);
        if (localaunr.icon == null) {
          break label686;
        }
        localObject2 = localaunr.icon;
      }
    }
    label648:
    label686:
    for (;;)
    {
      ((atcn.b)localObject1).aL.setImageDrawable((Drawable)localObject2);
      if (localObject2 != null) {
        ThemeUtil.setThemeFilter((Drawable)localObject2, ThemeUtil.curThemeId);
      }
      if (localaunr.bo == 1)
      {
        long l = localaunr.c.uiResId;
        a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      }
      for (;;)
      {
        if (AppSetting.enableTalkBack)
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            aqcl.Q(((atcn.b)localObject1).fe, false);
            aqcl.Q(((atcn.b)localObject1).u, false);
            aqcl.Q(((atcn.b)localObject1).aL, false);
            ((atcn.b)localObject1).aN.setContentDescription(((atcn.b)localObject1).fe.getText());
          }
          if (Build.VERSION.SDK_INT >= 14) {
            ((atcn.b)localObject1).aN.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
          }
          ((atcn.b)localObject1).aN.setOnClickListener(new atcq(this, localRedTouch, localaunr));
        }
        localObject2 = paramView;
        break;
        ((atcn.b)localObject1).aN.setBackgroundResource(2130851238);
        ((atcn.b)localObject1).fe.setTextColor(this.mContext.getResources().getColor(2131167304));
        break label170;
        localObject1 = (atcn.b)paramView.getTag();
        break label203;
        ((atcn.b)localObject1).u.setChecked(false);
        ((atcn.b)localObject1).u.setContentDescription(localaunr.c.strResName);
        break label251;
        ((RedTouch)paramView).dGB();
      }
    }
  }
  
  public void onPostThemeChanged() {}
  
  public static abstract interface a
  {
    public abstract void a(aunr paramaunr);
  }
  
  public static class b
  {
    public ImageView aL;
    public RelativeLayout aN;
    public aunr b;
    public TextView fe;
    public Switch u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcn
 * JD-Core Version:    0.7.0.1
 */