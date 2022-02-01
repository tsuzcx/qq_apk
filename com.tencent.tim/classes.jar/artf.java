import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class artf
  extends BaseAdapter
  implements View.OnClickListener
{
  @NonNull
  private List<AppInfo> JB = new ArrayList();
  private List<Integer> JC;
  private final IphoneTitleBarFragment b;
  private boolean dcZ;
  private Activity mActivity;
  private QQAppInterface mApp;
  
  public artf(IphoneTitleBarFragment paramIphoneTitleBarFragment, QQAppInterface paramQQAppInterface)
  {
    this.b = paramIphoneTitleBarFragment;
    this.mActivity = paramIphoneTitleBarFragment.getActivity();
    this.mApp = paramQQAppInterface;
    this.JC = new ArrayList();
  }
  
  private void a(int paramInt, View paramView, artf.a parama)
  {
    parama.position = paramInt;
    parama.Kf.setOnClickListener(this);
    AppInfo localAppInfo = (AppInfo)this.JB.get(paramInt);
    String str = localAppInfo.getName();
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    parama.aam.setText(paramView.trim());
    parama.acY.setText(localAppInfo.DG());
    parama.W.setChecked(false);
    a(parama, localAppInfo);
  }
  
  private void a(artf.a parama)
  {
    parama.W.setVisibility(8);
    parama.Gp.setVisibility(0);
  }
  
  private void a(artf.a parama, View paramView)
  {
    parama.Kf = paramView.findViewById(2131370160);
    parama.W = ((CheckBox)paramView.findViewById(2131372074));
    parama.Gp = ((ImageView)paramView.findViewById(2131368528));
    parama.aam = ((TextView)paramView.findViewById(2131362860));
    parama.acY = ((TextView)paramView.findViewById(2131362866));
    parama.Gq = ((ImageView)paramView.findViewById(2131362850));
    parama.Ke = paramView.findViewById(2131371162);
  }
  
  private void a(artf.a parama, AppInfo paramAppInfo)
  {
    Object localObject1 = paramAppInfo.getIconUrl();
    Object localObject2 = this.mActivity.getResources().getDrawable(2130838758);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
      parama.Ke.setVisibility(0);
    }
    for (;;)
    {
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
      localObject2 = parama.Gq.getLayoutParams();
      localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject2).height;
      localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject2).width;
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
        ((URLDrawable)localObject1).setTag(aqbn.d(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height, rpq.dip2px(this.mActivity, 6.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(aqbn.a);
        parama.Gq.setImageDrawable((Drawable)localObject1);
        label135:
        parama.W.setChecked(paramAppInfo.aHE());
        return;
        parama.Ke.setVisibility(8);
      }
      catch (Throwable localThrowable)
      {
        break label135;
      }
    }
  }
  
  private void b(artf.a parama)
  {
    parama.W.setVisibility(0);
    parama.Gp.setVisibility(8);
  }
  
  private void iM(View paramView)
  {
    artf.a locala = (artf.a)paramView.getTag();
    if (this.dcZ)
    {
      paramView = (CheckBox)paramView.findViewById(2131372074);
      boolean bool;
      if (!paramView.isChecked())
      {
        bool = true;
        paramView.setChecked(bool);
        if (!paramView.isChecked()) {
          break label157;
        }
        this.JC.add(Integer.valueOf(locala.position));
        label65:
        if (this.JC.size() <= 0) {
          break label180;
        }
        this.b.rightViewText.setEnabled(true);
      }
      for (;;)
      {
        paramView = (AppInfo)this.JB.get(locala.position);
        if (paramView != null) {
          paramView.setChecked(bool);
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorityControlAdapter", 2, "onLayoutAppItemClick: invoked.  mCheckedPositions: " + this.JC);
        }
        return;
        bool = false;
        break;
        label157:
        int i = locala.position;
        this.JC.remove(Integer.valueOf(i));
        break label65;
        label180:
        this.b.rightViewText.setEnabled(false);
      }
    }
    paramView = (AppInfo)this.JB.get(locala.position);
    AuthorityControlAppDetailsFragment.a(this.mActivity, paramView);
  }
  
  public boolean aHb()
  {
    return this.dcZ;
  }
  
  public void elG()
  {
    this.JC.clear();
    notifyDataSetChanged();
  }
  
  public void elH()
  {
    this.dcZ = true;
    this.JC.clear();
    Iterator localIterator = this.JB.iterator();
    while (localIterator.hasNext()) {
      ((AppInfo)localIterator.next()).setChecked(false);
    }
    notifyDataSetChanged();
  }
  
  public void elI()
  {
    this.dcZ = false;
    notifyDataSetChanged();
  }
  
  @NonNull
  public List<AppInfo> gR()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.JC.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((i < this.JB.size()) && (i >= 0)) {
        localArrayList.add((AppInfo)this.JB.get(i));
      }
    }
    return localArrayList;
  }
  
  public int getCount()
  {
    return this.JB.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.JB.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new artf.a(null);
      localView = LayoutInflater.from(this.mActivity).inflate(2131558759, null);
      a(paramView, localView);
      localView.setTag(paramView);
      a(paramInt, localView, paramView);
      if (!this.dcZ) {
        break label98;
      }
      b(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      artf.a locala = (artf.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
      break;
      label98:
      a(paramView);
    }
  }
  
  public void nl(@NonNull List<AppInfo> paramList)
  {
    this.JB = paramList;
  }
  
  public void nm(List<AppInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.JB.iterator();
    label124:
    for (;;)
    {
      AppInfo localAppInfo1;
      if (localIterator1.hasNext())
      {
        localAppInfo1 = (AppInfo)localIterator1.next();
        Iterator localIterator2 = paramList.iterator();
        AppInfo localAppInfo2;
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          localAppInfo2 = (AppInfo)localIterator2.next();
        } while (localAppInfo1.getId() != localAppInfo2.getId());
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label124;
        }
        localArrayList.add(localAppInfo1);
        break;
        this.JB.clear();
        this.JB.addAll(localArrayList);
        return;
      }
    }
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
      iM(paramView);
    }
  }
  
  static class a
  {
    ImageView Gp;
    ImageView Gq;
    public View Ke;
    View Kf;
    CheckBox W;
    TextView aam;
    TextView acY;
    int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artf
 * JD-Core Version:    0.7.0.1
 */