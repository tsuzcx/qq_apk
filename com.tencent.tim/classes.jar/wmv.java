import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.PokePanel.a;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class wmv
  extends BaseAdapter
{
  private PokePanel a;
  View.OnClickListener dI;
  private Context mContext;
  ArrayList<PokePanel.a> qe = new ArrayList();
  
  public wmv(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private int getColumnNum()
  {
    if ((this.qe == null) || (this.qe.size() == 0)) {}
    while ((this.qe.size() <= 3) || ((this.qe.size() > 3) && (this.qe.size() <= 6)) || (this.qe.size() <= 6)) {
      return 3;
    }
    return 4;
  }
  
  public void a(PokePanel paramPokePanel)
  {
    this.a = paramPokePanel;
  }
  
  public ArrayList<PokePanel.a> bG()
  {
    return this.qe;
  }
  
  public void c(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = this.qe.iterator();
    for (;;)
    {
      PokePanel.a locala;
      if (localIterator.hasNext())
      {
        locala = (PokePanel.a)localIterator.next();
        if (!paramString.equals("poke.item.effect.")) {
          break label63;
        }
        if (locala.resId == paramInt) {
          locala.bep = paramBoolean1;
        }
      }
      else
      {
        return;
      }
      notifyDataSetChanged();
      continue;
      label63:
      if (paramString.equals("poke.item.res."))
      {
        if (locala.resId == paramInt)
        {
          locala.beo = paramBoolean2;
          locala.bep = paramBoolean1;
          return;
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void cY(ArrayList<PokePanel.a> paramArrayList)
  {
    this.qe.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.qe != null)
    {
      int i = getColumnNum();
      return (this.qe.size() + i - 1) / i;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.qe != null) && (this.qe.size() > paramInt)) {
      return this.qe.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = getColumnNum();
    Object localObject2;
    int i;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = new LinearLayout(this.mContext, null);
      ((LinearLayout)localObject2).setOrientation(0);
      paramView = LayoutInflater.from(this.mContext);
      i = 0;
      localObject1 = localObject2;
      if (i >= j) {
        break label225;
      }
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
      if (paramView != null) {
        break label1011;
      }
      paramView = LayoutInflater.from(this.mContext);
    }
    label225:
    label615:
    label877:
    label1011:
    for (;;)
    {
      Object localObject3 = LayoutInflater.from(this.mContext).inflate(2131558935, null);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new wmv.a();
      ((wmv.a)localObject1).sk = ((ImageView)((View)localObject3).findViewById(2131368847));
      ((wmv.a)localObject1).sl = ((ImageView)((View)localObject3).findViewById(2131367211));
      ((wmv.a)localObject1).Il = ((TextView)((View)localObject3).findViewById(2131379420));
      ((wmv.a)localObject1).sm = ((ImageView)((View)localObject3).findViewById(2131366753));
      ((wmv.a)localObject1).P = ((ProgressBar)((View)localObject3).findViewById(2131370803));
      ((wmv.a)localObject1).sn = ((ImageView)((View)localObject3).findViewById(2131366081));
      ((View)localObject3).setTag(localObject1);
      i += 1;
      break;
      localObject1 = paramView;
      paramView = (ViewGroup)localObject1;
      PokePanel.a locala;
      if (paramInt == 0)
      {
        paramView.setPadding(wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(14.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()));
        i = 0;
        if (i >= j) {
          break label981;
        }
        int k = j * paramInt + i;
        localObject2 = paramView.getChildAt(i);
        localObject3 = (wmv.a)((View)localObject2).getTag();
        if (k >= this.qe.size()) {
          break label890;
        }
        locala = (PokePanel.a)this.qe.get(k);
        ((wmv.a)localObject3).sk.setVisibility(0);
        ((wmv.a)localObject3).sk.setImageDrawable(locala.drawable);
        ((ClickedWaveView)((wmv.a)localObject3).sk).setCustomDrawable(locala.drawable);
        Object localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("type", locala.bPs);
        ((Bundle)localObject4).putInt("id", locala.resId);
        ((Bundle)localObject4).putString("name", locala.name);
        ((Bundle)localObject4).putInt("feeType", locala.feeType);
        ((Bundle)localObject4).putBoolean("isShowDownload", locala.beo);
        ((Bundle)localObject4).putBoolean("isShowLoading", locala.bep);
        ((Bundle)localObject4).putString("minVersion", locala.minVersion);
        ((ClickedWaveView)((wmv.a)localObject3).sk).setExtraInfo((Bundle)localObject4);
        ((ClickedWaveView)((wmv.a)localObject3).sk).setOnTouchReceive(this.a);
        if (!(locala.drawable instanceof URLDrawable)) {
          break label761;
        }
        localObject4 = (URLDrawable)locala.drawable;
        if (((URLDrawable)localObject4).getStatus() == 2) {
          ((URLDrawable)localObject4).restartDownload();
        }
        ((wmv.a)localObject3).Il.setText(locala.name);
        if (!locala.beg) {
          break label796;
        }
        ((wmv.a)localObject3).sl.setVisibility(0);
        if (locala.feeType != 4) {
          break label809;
        }
        ((wmv.a)localObject3).sm.setVisibility(0);
        ((wmv.a)localObject3).sm.setImageDrawable(this.mContext.getResources().getDrawable(2130848280));
        if (!locala.beo) {
          break label864;
        }
        ((wmv.a)localObject3).sn.setVisibility(0);
        ((wmv.a)localObject3).sn.setTag(Integer.valueOf(locala.resId));
        if (!locala.bep) {
          break label877;
        }
        ((wmv.a)localObject3).P.setVisibility(0);
        ((View)localObject2).setContentDescription(locala.name);
        ((View)localObject2).setEnabled(true);
        aqcl.Q((View)localObject2, true);
      }
      for (;;)
      {
        aqcl.Q(((wmv.a)localObject3).Il, false);
        i += 1;
        break label290;
        paramView.setPadding(wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(7.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()));
        break;
        label761:
        if (!(locala.drawable instanceof CustomFrameAnimationDrawable)) {
          break label546;
        }
        ((wmv.a)localObject3).P.setVisibility(8);
        ((CustomFrameAnimationDrawable)locala.drawable).start();
        break label546;
        ((wmv.a)localObject3).sl.setVisibility(8);
        break label576;
        if (locala.feeType == 5)
        {
          ((wmv.a)localObject3).sm.setVisibility(0);
          ((wmv.a)localObject3).sm.setImageDrawable(this.mContext.getResources().getDrawable(2130848279));
          break label615;
        }
        ((wmv.a)localObject3).sm.setVisibility(8);
        break label615;
        ((wmv.a)localObject3).sn.setVisibility(8);
        break label648;
        ((wmv.a)localObject3).P.setVisibility(8);
        break label665;
        label890:
        ((wmv.a)localObject3).sk.setVisibility(4);
        ((wmv.a)localObject3).sk.setBackgroundDrawable(null);
        ((wmv.a)localObject3).Il.setText(null);
        ((wmv.a)localObject3).sl.setVisibility(8);
        ((wmv.a)localObject3).sm.setVisibility(8);
        ((wmv.a)localObject3).P.setVisibility(8);
        ((wmv.a)localObject3).sn.setVisibility(8);
        ((wmv.a)localObject3).sn.setTag(null);
        ((View)localObject2).setEnabled(false);
        aqcl.Q((View)localObject2, false);
      }
      ((View)localObject1).setOnLongClickListener(null);
      aqcl.Q((View)localObject1, false);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
  }
  
  public void w(View.OnClickListener paramOnClickListener)
  {
    this.dI = paramOnClickListener;
  }
  
  public class a
  {
    TextView Il;
    ProgressBar P;
    ImageView sk;
    ImageView sl;
    ImageView sm;
    ImageView sn;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmv
 * JD-Core Version:    0.7.0.1
 */