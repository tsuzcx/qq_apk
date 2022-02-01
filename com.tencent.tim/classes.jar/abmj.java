import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class abmj
  extends BaseAdapter
{
  public Context mContext;
  private List<ApolloGameData> sc = new ArrayList();
  private List<String> wq = new ArrayList();
  
  public abmj(abmi.d paramd, Context paramContext)
  {
    if (paramd != null)
    {
      this.sc = paramd.sc;
      this.wq = paramd.wq;
    }
    this.mContext = paramContext;
  }
  
  public int getCount()
  {
    return this.sc.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.sc.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      paramView = new abmj.a();
      localView = LayoutInflater.from(this.mContext).inflate(2131558995, null);
      localView.setPadding(0, 0, 0, 0);
      paramView.k = ((CornerImageView)localView.findViewById(2131369753));
      paramView.l = ((CornerImageView)localView.findViewById(2131369754));
      paramView.PQ = ((TextView)localView.findViewById(2131380711));
      paramView.xv = ((ImageView)localView.findViewById(2131369755));
      float f = jll.dp2px(this.mContext, 5.0F);
      paramView.k.setRadius(f);
      paramView.l.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
      localView.setTag(paramView);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ((int)jll.dp2px(this.mContext, 103.0F));
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((int)jll.dp2px(this.mContext, 58.0F));
      localObject1 = (ApolloGameData)this.sc.get(paramInt);
      localObject2 = URLDrawable.getDrawable(((ApolloGameData)localObject1).listCoverUrl, (URLDrawable.URLDrawableOptions)localObject2);
      paramView.k.setImageDrawable((Drawable)localObject2);
      paramView.k.setTag(Integer.valueOf(((ApolloGameData)localObject1).gameId));
      if (!((ApolloGameData)localObject1).isGameApp) {
        break label363;
      }
      paramView.xv.setVisibility(0);
      paramView.xv.setImageResource(2130838584);
    }
    for (;;)
    {
      localObject1 = (String)this.wq.get(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramView.l.setVisibility(0);
        paramView.PQ.setVisibility(0);
        paramView.PQ.setText((CharSequence)localObject1);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (abmj.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
      label363:
      paramView.xv.setVisibility(8);
    }
  }
  
  class a
  {
    public TextView PQ;
    public CornerImageView k;
    public CornerImageView l;
    public ImageView xv;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmj
 * JD-Core Version:    0.7.0.1
 */