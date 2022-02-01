import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class rwk
  extends BaseAdapter
{
  private rwk.a a;
  private List<rwo> po = new ArrayList();
  
  public void a(rwk.a parama)
  {
    this.a = parama;
  }
  
  public List<rwo> cl()
  {
    return this.po;
  }
  
  public int getCount()
  {
    return this.po.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.po.size()) {
      return this.po.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    rwo localrwo = (rwo)getItem(paramInt);
    Object localObject1;
    if (localrwo == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560593, null);
      localObject1 = new rwk.b(paramView);
      paramView.setTag(localObject1);
      localObject2 = new GradientDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((GradientDrawable)localObject2).setColor(-16777216);
        label97:
        ((GradientDrawable)localObject2).setCornerRadius(aqnm.dpToPx(6.0F));
        paramView.setBackgroundDrawable((Drawable)localObject2);
        label114:
        paramView.setOnTouchListener(new rwl(this, paramView.getBackground(), localrwo));
        ((rwk.b)localObject1).ju.setOnClickListener(new rwm(this, localrwo));
        ((rwk.b)localObject1).nO.setOnClickListener(new rwn(this, localrwo));
        localObject2 = paramView.getContext().getString(2131717189, new Object[] { localrwo.mDeviceName, localrwo.mAppName });
        ((rwk.b)localObject1).zB.setText((CharSequence)localObject2);
        if (!TextUtils.isEmpty(localrwo.aCQ)) {
          break label293;
        }
        ((rwk.b)localObject1).zC.setVisibility(8);
        label230:
        if (localrwo.xN != 1) {
          break label329;
        }
        ((rwk.b)localObject1).iconView.setImageResource(2130847870);
        ((rwk.b)localObject1).nO.setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      ((GradientDrawable)localObject2).setColor(paramView.getResources().getColor(2131167462));
      break label97;
      localObject1 = (rwk.b)paramView.getTag();
      break label114;
      label293:
      localObject2 = paramView.getContext().getString(2131717190, new Object[] { localrwo.aCQ });
      ((rwk.b)localObject1).zC.setText((CharSequence)localObject2);
      break label230;
      label329:
      if (localrwo.xN == 2)
      {
        ((rwk.b)localObject1).iconView.setImageResource(2130847869);
        ((rwk.b)localObject1).nO.setVisibility(0);
      }
      else if (localrwo.xN == 3)
      {
        ((rwk.b)localObject1).iconView.setImageResource(2130847871);
        ((rwk.b)localObject1).nO.setVisibility(8);
      }
    }
  }
  
  public void setDataSource(List<rwo> paramList)
  {
    this.po.clear();
    this.po.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void a(rwo paramrwo);
    
    public abstract void b(rwo paramrwo);
    
    public abstract void c(rwo paramrwo);
  }
  
  public static class b
  {
    ImageView iconView;
    ImageView ju;
    ImageView nO;
    TextView zB;
    TextView zC;
    
    public b(View paramView)
    {
      this.iconView = ((ImageView)paramView.findViewById(2131365817));
      this.nO = ((ImageView)paramView.findViewById(2131367020));
      this.nO.setContentDescription(acfp.m(2131707922));
      this.ju = ((ImageView)paramView.findViewById(2131364681));
      this.ju.setContentDescription(acfp.m(2131707921));
      this.zB = ((TextView)paramView.findViewById(2131371087));
      this.zC = ((TextView)paramView.findViewById(2131373521));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwk
 * JD-Core Version:    0.7.0.1
 */