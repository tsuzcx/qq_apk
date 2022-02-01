import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class wpo
  extends BaseAdapter
{
  public boolean Fg;
  public int TL = 4;
  public int bQb;
  public View.OnClickListener dI;
  Context mContext;
  public ArrayList<aqxo> qe;
  
  public wpo(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int getCount()
  {
    if (this.qe != null) {
      return (this.qe.size() + this.TL - 1) / this.TL;
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
    int j = this.TL;
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = new LinearLayout(this.mContext, null);
      ((LinearLayout)localObject2).setOrientation(0);
      paramView = LayoutInflater.from(this.mContext);
      i = 0;
      while (i < this.TL)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = LayoutInflater.from(this.mContext);
        }
        ((LinearLayout)localObject2).addView(LayoutInflater.from(this.mContext).inflate(2131561181, null), (ViewGroup.LayoutParams)localObject3);
        i += 1;
        paramView = (View)localObject1;
      }
      paramView = (View)localObject2;
    }
    for (;;)
    {
      localObject2 = (ViewGroup)paramView;
      if (paramInt == 0) {
        ((ViewGroup)localObject2).setPadding(wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(14.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()));
      }
      int k;
      for (;;)
      {
        i = 0;
        for (;;)
        {
          if (i >= this.TL) {
            break label403;
          }
          k = j * paramInt + i;
          localObject3 = (ChangeVoiceView)((ViewGroup)localObject2).getChildAt(i);
          if (localObject3 != null) {
            break;
          }
          QLog.e("ChangeVoiceListAdapter", 1, "getView view == null,view=" + ((ViewGroup)localObject2).getChildAt(i));
          i += 1;
        }
        ((ViewGroup)localObject2).setPadding(wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(7.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()));
      }
      ((ChangeVoiceView)localObject3).aeE = this.bQb;
      if ((this.qe != null) && (k < this.qe.size())) {}
      for (localObject1 = (aqxo)this.qe.get(k);; localObject1 = null)
      {
        ((ChangeVoiceView)localObject3).a((aqxo)localObject1);
        if (this.Fg) {
          ((ChangeVoiceView)localObject3).cao();
        }
        if (localObject1 != null)
        {
          ((ChangeVoiceView)localObject3).setOnClickListener(this.dI);
          break;
        }
        ((ChangeVoiceView)localObject3).setOnClickListener(null);
        break;
        label403:
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpo
 * JD-Core Version:    0.7.0.1
 */