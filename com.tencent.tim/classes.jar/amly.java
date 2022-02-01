import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class amly
  extends BaseAdapter
{
  public static final String TAG = amly.class.getSimpleName();
  public amqk a;
  public int aNK;
  public long ajO;
  public int fromType;
  public List<amql> mDatas;
  public HorizontalListView w;
  public float zr;
  public float zs;
  
  public amly(amqk paramamqk, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.a = paramamqk;
    this.fromType = paramInt;
    this.w = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new amlz(this, paramHorizontalListView));
  }
  
  public amql a(int paramInt)
  {
    return (amql)this.mDatas.get(paramInt);
  }
  
  public int getCount()
  {
    if (this.mDatas == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.a.moreUrl)) {
      return this.mDatas.size();
    }
    return this.mDatas.size() + 1;
  }
  
  public List<amql> getData()
  {
    return this.mDatas;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == this.mDatas.size()) && (!TextUtils.isEmpty(this.a.moreUrl))) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    case 1: 
      localObject2 = (amqn)this.mDatas.get(paramInt);
      label86:
      float f;
      if (paramView == null)
      {
        localObject1 = new amym(paramViewGroup, 0);
        paramView = ((amym)localObject1).getView();
        paramView.setTag(localObject1);
        f = this.a.showType;
        f = (float)(aqgz.getWidth() - aqcx.dip2px(paramView.getContext(), 13.5F)) / (f + 0.5F);
        this.zr = (aqcx.dip2px(this.w.getContext(), 3.0F) + f);
        switch (((amqn)localObject2).a.imageType)
        {
        default: 
          this.zs = (f * 136.0F / 220.0F);
        }
      }
      for (;;)
      {
        ((amym)localObject1).getView().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
        ((amqn)localObject2).a((amyk)localObject1);
        ((amym)localObject1).getView().measure(1073741824, 0);
        this.aNK = Math.max(((amym)localObject1).getView().getMeasuredHeight(), this.aNK);
        this.w.getLayoutParams().height = this.aNK;
        this.ajO = ((amqn)localObject2).ajO;
        break;
        localObject1 = (amym)paramView.getTag();
        break label86;
        this.zs = (f * 136.0F / 220.0F);
        continue;
        this.zs = f;
        continue;
        this.zs = (228.0F * f / 162.0F);
        continue;
        this.zs = f;
      }
    }
    Object localObject1 = paramView;
    if (paramView == null) {
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560029, paramViewGroup, false);
    }
    Object localObject2 = new FrameLayout.LayoutParams(-1, (int)this.zs);
    ((FrameLayout.LayoutParams)localObject2).topMargin = aqcx.dip2px(paramViewGroup.getContext(), 6.0F);
    paramView = (LinearLayout)((View)localObject1).findViewById(2131365322);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131371944);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131371971);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundResource(2130839634);
      localTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((ImageView)localObject2).setImageResource(2130843188);
    }
    for (;;)
    {
      localTextView.setText(this.a.au);
      ((View)localObject1).setOnClickListener(new amma(this, paramViewGroup));
      paramView = (View)localObject1;
      break;
      paramView.setBackgroundResource(2130839633);
      localTextView.setTextColor(Color.parseColor("#737373"));
      ((ImageView)localObject2).setImageResource(2130843187);
    }
  }
  
  public void setData(List<amql> paramList)
  {
    this.mDatas = paramList;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amly
 * JD-Core Version:    0.7.0.1
 */