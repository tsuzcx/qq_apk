import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class aksl
  extends BaseAdapter
{
  private aksl.a a;
  private boolean cut;
  private boolean cuu;
  private Drawable fh;
  private QQAppInterface mApp;
  private Context mContext;
  private ArrayList<AutoReplyText> yq;
  
  public aksl(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.fh = paramDrawable;
    this.yq = new ArrayList();
    this.cut = false;
    this.cuu = false;
  }
  
  private void Sl(int paramInt)
  {
    if (paramInt == 2147483647) {
      break label6;
    }
    label6:
    while (!asI()) {
      return;
    }
    Object localObject = this.yq.iterator();
    int j = 0;
    int k = 0;
    int i = 0;
    label30:
    AutoReplyText localAutoReplyText;
    boolean bool;
    label110:
    int m;
    if (((Iterator)localObject).hasNext())
    {
      localAutoReplyText = (AutoReplyText)((Iterator)localObject).next();
      if (localAutoReplyText.getTextId() == paramInt)
      {
        if (localAutoReplyText.getExtra().getBoolean("AutoReplyAdapter:in_use", false)) {
          i = 1;
        }
        ((Iterator)localObject).remove();
        if (this.a != null)
        {
          aksl.a locala = this.a;
          if (localAutoReplyText.getTextId() == 2147483647)
          {
            bool = true;
            locala.a(localAutoReplyText, bool);
          }
        }
        else
        {
          m = j;
          j = 1;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      m = k;
      k = j;
      j = i;
      i = m;
      break label30;
      bool = false;
      break label110;
      if (localAutoReplyText.mTextId != 2147483647)
      {
        localAutoReplyText.mTextId = j;
        m = j + 1;
        j = k;
        k = i;
        i = m;
        continue;
        if ((i != 0) && (!this.yq.isEmpty()))
        {
          localObject = (AutoReplyText)this.yq.get(0);
          if (localObject != null) {
            nR(((AutoReplyText)localObject).getTextId());
          }
        }
        if (k == 0) {
          break;
        }
        this.cuu = true;
        notifyDataSetChanged();
        return;
      }
      m = i;
      i = j;
      j = k;
      k = m;
    }
  }
  
  private aksl.b a(LayoutInflater paramLayoutInflater, int paramInt, View paramView, ViewGroup paramViewGroup, AutoReplyText paramAutoReplyText)
  {
    if ((paramView == null) || (paramView.getTag() == null) || (paramView.getVisibility() == 8))
    {
      paramView = paramLayoutInflater.inflate(2131558447, paramViewGroup, false);
      paramLayoutInflater = paramView.findViewById(2131365985);
      if (ThemeUtil.isDefaultTheme())
      {
        paramInt = 0;
        paramLayoutInflater.setVisibility(paramInt);
        if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null))) {
          paramView.findViewById(2131377145).setBackgroundResource(2130839695);
        }
        paramView.findViewById(2131370365).setPadding(0, 0, 0, 0);
        paramView.findViewById(2131377328).setVisibility(8);
        paramViewGroup = (TextView)paramView.findViewById(2131370387);
        paramViewGroup.setEditableFactory(new aksn(this, paramViewGroup));
        paramLayoutInflater = new aksl.b(null);
        paramLayoutInflater.bu = paramView;
        paramLayoutInflater.WI = paramViewGroup;
        paramLayoutInflater.Ca = ((ImageView)paramView.findViewById(2131377302));
        paramLayoutInflater.FC = paramView.findViewById(2131366136);
        paramLayoutInflater.FD = paramView.findViewById(2131366137);
        paramLayoutInflater.FE = paramView.findViewById(2131379438);
        paramLayoutInflater.bu.setTag(paramLayoutInflater);
        label200:
        paramLayoutInflater.Ca.setOnClickListener(new akso(this, paramAutoReplyText));
        paramLayoutInflater.FC.setOnClickListener(new aksp(this, paramAutoReplyText));
        boolean bool = paramAutoReplyText.getExtra().getBoolean("AutoReplyAdapter:in_use", false);
        if (paramAutoReplyText.getTextId() != 2147483647) {
          break label557;
        }
        paramInt = 1;
        label259:
        paramView = AutoReplyText.trimRawString(paramAutoReplyText.getRawText(), true);
        int i = (int)(paramLayoutInflater.WI.getTextSize() / paramLayoutInflater.WI.getPaint().density);
        paramView = aofy.a(paramView, paramLayoutInflater.WI.getPaint(), 3, i, ankt.SCREEN_WIDTH - ankt.dip2px(67.0F), true);
        if (QLog.isColorLevel()) {
          QLog.d("AutoReplyAdapter", 2, "Truncate subText: " + paramView);
        }
        paramViewGroup = new aofk(paramView, 3, i);
        paramLayoutInflater.WI.setText(paramViewGroup);
        paramLayoutInflater.WI.setContentDescription(paramViewGroup);
        paramLayoutInflater.Ca.setContentDescription(new aofk(acfp.m(2131702978) + paramView, 3, i));
        paramLayoutInflater.FD.setOnClickListener(new aksq(this, paramAutoReplyText, bool));
        paramLayoutInflater.bu.findViewById(2131377145).setOnClickListener(new aksr(this, paramAutoReplyText));
        paramViewGroup = paramLayoutInflater.Ca;
        if (!bool) {
          break label562;
        }
        paramView = this.fh;
        label475:
        paramViewGroup.setImageDrawable(paramView);
        paramView = paramLayoutInflater.bu;
        if (paramInt == 0) {
          break label567;
        }
      }
    }
    label557:
    label562:
    label567:
    for (paramInt = 0;; paramInt = ankt.dip2px(200.0F))
    {
      paramView.setTag(-3, Integer.valueOf(paramInt));
      paramView = (RelativeLayout.LayoutParams)paramLayoutInflater.FE.getLayoutParams();
      if (paramView.leftMargin > 0)
      {
        paramView.leftMargin = 0;
        paramLayoutInflater.FE.setLayoutParams(paramView);
      }
      return paramLayoutInflater;
      paramInt = 8;
      break;
      paramLayoutInflater = (aksl.b)paramView.getTag();
      paramLayoutInflater.bu = paramView;
      break label200;
      paramInt = 0;
      break label259;
      paramView = null;
      break label475;
    }
  }
  
  private View a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558450, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131365360);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
    if (getItemViewType(paramInt) == 0)
    {
      localMarginLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131298887);
      localMarginLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131298884);
      paramViewGroup.setText(2131690667);
      paramViewGroup.setContentDescription(this.mContext.getString(2131690667));
    }
    for (;;)
    {
      paramViewGroup.setLayoutParams(localMarginLayoutParams);
      return paramLayoutInflater;
      localMarginLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131298887);
      localMarginLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131298884);
      paramViewGroup.setText(2131690673);
      paramViewGroup.setContentDescription(this.mContext.getString(2131690673));
    }
  }
  
  private void an(View paramView, int paramInt)
  {
    if (paramInt == 2147483647) {}
    while ((paramView == null) || (!asI())) {
      return;
    }
    akss localakss = new akss(this, paramView, paramView.getMeasuredHeight());
    localakss.setAnimationListener(new akst(this, paramInt));
    localakss.setDuration(150L);
    paramView.startAnimation(localakss);
  }
  
  private boolean asI()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  private View b(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558445, paramViewGroup, false);
    paramLayoutInflater.setOnClickListener(new aksm(this));
    return paramLayoutInflater;
  }
  
  private void dDo()
  {
    HashSet localHashSet = new HashSet(this.yq);
    this.yq.clear();
    this.yq.addAll(localHashSet);
    Collections.sort(this.yq);
  }
  
  public void a(@Nullable aksl.a parama)
  {
    this.a = parama;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public boolean asJ()
  {
    return this.cuu;
  }
  
  public void b(@Nullable AutoReplyText paramAutoReplyText)
  {
    if ((!asI()) || (paramAutoReplyText == null) || (paramAutoReplyText.getTextId() == 2147483647)) {
      return;
    }
    Iterator localIterator = this.yq.iterator();
    Object localObject = null;
    if (localIterator.hasNext())
    {
      AutoReplyText localAutoReplyText = (AutoReplyText)localIterator.next();
      if ((localAutoReplyText == null) || (localAutoReplyText.getTextId() != paramAutoReplyText.getTextId())) {
        break label157;
      }
      localIterator.remove();
      localObject = localAutoReplyText;
    }
    label157:
    for (;;)
    {
      break;
      paramAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", false);
      if ((localObject != null) && (localObject.getExtra().getBoolean("AutoReplyAdapter:in_use", false))) {
        paramAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", true);
      }
      this.yq.add(paramAutoReplyText);
      if (this.a != null) {
        this.a.a(paramAutoReplyText);
      }
      dDo();
      this.cuu = true;
      notifyDataSetChanged();
      return;
    }
  }
  
  public ArrayList<AutoReplyText> dn()
  {
    return this.yq;
  }
  
  public int getCount()
  {
    if (this.cut) {
      return this.yq.size() + 1 + 1 + 1;
    }
    return 0;
  }
  
  @Nullable
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= this.yq.size())) {
      return this.yq.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 1;
    int i;
    if ((paramInt >= 0) && (paramInt < 1)) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        if (paramInt == this.yq.size() + 1) {
          return 3;
        }
        if (paramInt < 1) {
          break;
        }
        i = j;
      } while (paramInt <= this.yq.size());
      i = j;
    } while (paramInt != this.yq.size() + 1 + 1);
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if ((getItemViewType(paramInt) == 0) || (getItemViewType(paramInt) == 4)) {
      paramView = a(localLayoutInflater, paramInt, paramViewGroup);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (getItemViewType(paramInt) == 3)
      {
        paramView = b(localLayoutInflater, paramInt, paramViewGroup);
      }
      else
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)getItem(paramInt);
        if (localAutoReplyText != null) {
          paramView = a(localLayoutInflater, paramInt, paramView, paramViewGroup, localAutoReplyText).bu;
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (paramInt != 0) && (paramInt != getCount() - 1);
  }
  
  public void lK(List<AutoReplyText> paramList)
  {
    int i;
    if (asI())
    {
      this.yq.clear();
      if ((paramList == null) || (paramList.isEmpty())) {
        break label108;
      }
      this.yq.addAll(paramList);
      paramList = paramList.iterator();
      i = 0;
      while (paramList.hasNext())
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)paramList.next();
        if (localAutoReplyText.isChecked()) {
          i = localAutoReplyText.mTextId;
        }
        localAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", false);
      }
      dDo();
    }
    for (;;)
    {
      notifyDataSetChanged();
      nR(i);
      this.cuu = false;
      return;
      label108:
      i = 0;
    }
  }
  
  public void nR(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (asI())
    {
      Iterator localIterator = this.yq.iterator();
      localObject1 = null;
      if (localIterator.hasNext())
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)localIterator.next();
        Object localObject3 = localObject1;
        Bundle localBundle;
        if (localAutoReplyText != null)
        {
          localBundle = localAutoReplyText.getExtra();
          bool = localBundle.getBoolean("AutoReplyAdapter:in_use", false);
          if (bool) {
            localObject1 = localAutoReplyText;
          }
          if (localAutoReplyText.getTextId() == paramInt)
          {
            localObject3 = localObject1;
            if (bool) {
              break label128;
            }
            localBundle.putBoolean("AutoReplyAdapter:in_use", true);
            localObject2 = localObject1;
            localObject1 = localAutoReplyText;
          }
        }
        for (;;)
        {
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          localBundle.putBoolean("AutoReplyAdapter:in_use", false);
          localObject3 = localObject1;
          label128:
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      if (localObject2 != null) {
        if (localObject1 == null) {
          break label178;
        }
      }
    }
    label178:
    for (boolean bool = true;; bool = false)
    {
      this.cuu = bool;
      if (this.a != null) {
        this.a.a(localObject2, localObject1);
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public void setShow(boolean paramBoolean)
  {
    if (asI())
    {
      this.cut = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AutoReplyText paramAutoReplyText);
    
    public abstract void a(AutoReplyText paramAutoReplyText1, AutoReplyText paramAutoReplyText2);
    
    public abstract void a(AutoReplyText paramAutoReplyText, boolean paramBoolean);
    
    public abstract void b(@Nullable AutoReplyText paramAutoReplyText, boolean paramBoolean);
  }
  
  static class b
  {
    ImageView Ca;
    View FC;
    View FD;
    View FE;
    TextView WI;
    View bu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksl
 * JD-Core Version:    0.7.0.1
 */