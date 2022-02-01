import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class afpo
  extends BaseAdapter
{
  private static int MAX_ITEM_SIZE = 6;
  private List<Object> Ak;
  private String bEF;
  private String bEG;
  private URLDrawable.URLDrawableListener c;
  private Context mContext;
  private Drawable mDefaultDrawable;
  private String uin;
  
  public afpo(Context paramContext, List<Object> paramList, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext;
    this.Ak = paramList;
    this.c = paramURLDrawableListener;
    this.mDefaultDrawable = paramDrawable;
    this.uin = paramString1;
    this.bEF = paramString2;
    this.bEG = paramString3;
  }
  
  public int getCount()
  {
    if (this.Ak != null)
    {
      int i = this.Ak.size();
      if (i > MAX_ITEM_SIZE) {
        return MAX_ITEM_SIZE + 1;
      }
      return i + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (paramInt < getCount() - 1)
    {
      localObject3 = (IPSiteModel.Goods)this.Ak.get(paramInt);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(2131559288, null, false);
        localObject1 = new afpo.a(null);
        ((afpo.a)localObject1).aN = ((RelativeLayout)paramView);
        ((afpo.a)localObject1).yq = ((ImageView)paramView.findViewById(2131362436));
        ((afpo.a)localObject1).title = ((TextView)paramView.findViewById(2131362437));
        ((afpo.a)localObject1).desc = ((TextView)paramView.findViewById(2131362435));
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (localObject3 != null)
        {
          ((afpo.a)localObject1).yq.setImageDrawable(aqnl.a(((IPSiteModel.Goods)localObject3).cover, this.c, this.mDefaultDrawable));
          ((afpo.a)localObject1).title.setText(((IPSiteModel.Goods)localObject3).name);
          localObject2 = "0";
          if (!TextUtils.isEmpty(((IPSiteModel.Goods)localObject3).saleNum)) {
            localObject2 = ((IPSiteModel.Goods)localObject3).saleNum;
          }
          ((afpo.a)localObject1).desc.setText((String)localObject2 + acfp.m(2131707486));
          ((afpo.a)localObject1).aN.setOnClickListener(new afpp(this, (IPSiteModel.Goods)localObject3));
          localObject2 = paramView;
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
      return localObject2;
      localObject1 = (afpo.a)paramView.getTag();
      break;
      paramView = (IPSiteModel.Goods)this.Ak.get(0);
      localObject2 = new RelativeLayout(this.mContext);
      ((RelativeLayout)localObject2).setBackgroundColor(Color.parseColor("#fafafa"));
      localObject1 = new AbsListView.LayoutParams(wja.dp2px(75.0F, this.mContext.getResources()), wja.dp2px(75.0F, this.mContext.getResources()));
      ((RelativeLayout)localObject2).setMinimumWidth(wja.dp2px(75.0F, this.mContext.getResources()));
      ((RelativeLayout)localObject2).setMinimumHeight(wja.dp2px(75.0F, this.mContext.getResources()));
      ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.mContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.mContext);
      ((TextView)localObject3).setId(2131362445);
      ((TextView)localObject3).setTextSize(12.0F);
      ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject3).setText(acfp.m(2131707487));
      ((TextView)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setImageResource(2130847984);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131362445);
      localLayoutParams.addRule(15);
      localLayoutParams.leftMargin = wja.dp2px(2.0F, this.mContext.getResources());
      localImageView.setLayoutParams(localLayoutParams);
      ((RelativeLayout)localObject1).addView((View)localObject3);
      ((RelativeLayout)localObject1).addView(localImageView);
      ((RelativeLayout)localObject2).addView((View)localObject1);
      ((RelativeLayout)localObject2).setOnClickListener(new afpq(this, paramView));
    }
  }
  
  class a
  {
    RelativeLayout aN;
    TextView desc;
    TextView title;
    ImageView yq;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpo
 * JD-Core Version:    0.7.0.1
 */