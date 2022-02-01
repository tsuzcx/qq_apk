import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class nhn
  extends BaseAdapter
{
  private boolean afx;
  private HorizontalListView d;
  private List<Integer> kb = new ArrayList();
  private Context mContext;
  private List<liw.a> mData;
  private int mItemWidth;
  
  public nhn(Context paramContext, HorizontalListView paramHorizontalListView, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.d = paramHorizontalListView;
    this.afx = paramBoolean;
    this.d.setOnItemClickListener(new nho(this, paramContext));
  }
  
  private void a(liw.a parama)
  {
    if (!this.kb.contains(Integer.valueOf(parama.businessId)))
    {
      kbp.a(null, "", "0X800992A", "0X800992A", 0, 0, "", "", "", "", false);
      this.kb.add(Integer.valueOf(parama.businessId));
    }
  }
  
  private void a(liw.a parama, View paramView)
  {
    nhn.a locala = (nhn.a)paramView.getTag();
    Object localObject = paramView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.mItemWidth;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    nhn.a.a(locala).setText(parama.businessName);
    nhn.a.b(locala).setText(awit.gL(parama.fansCount));
    paramView = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramView.mFailedDrawable = ((Drawable)localObject);
    paramView.mLoadingDrawable = ((Drawable)localObject);
    paramView = URLDrawable.getDrawable(parama.afm, paramView);
    nhn.a.a(locala).setImageDrawable(paramView);
    a(parama);
  }
  
  public void av(List<liw.a> paramList)
  {
    this.mData = paramList;
    paramList = BaseApplicationImpl.getApplication().getResources();
    if ((this.mData == null) || (this.mData.size() <= 2))
    {
      this.mItemWidth = ((int)((paramList.getDisplayMetrics().widthPixels - wja.dp2px(11.0F, paramList) - wja.dp2px(24, paramList)) * 0.5F));
      this.d.setOverScrollMode(2);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (this.mData.size() == 3)
      {
        this.mItemWidth = ((int)((paramList.getDisplayMetrics().widthPixels - wja.dp2px(15.0F, paramList) - wja.dp2px(24, paramList)) / 3.0F));
        this.d.setOverScrollMode(2);
      }
      else
      {
        this.mItemWidth = ((int)((paramList.getDisplayMetrics().widthPixels - wja.dp2px(15.0F, paramList) - wja.dp2px(12, paramList)) / 2.5F));
        this.d.setOverScrollMode(1);
      }
    }
  }
  
  public int getCount()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= this.mData.size()) {
      return null;
    }
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext);
      if (this.afx)
      {
        paramView = paramView.inflate(2131560470, paramViewGroup, false);
        localObject = new nhn.a(null);
        nhn.a.a((nhn.a)localObject, (ImageView)paramView.findViewById(2131364080));
        nhn.a.a((nhn.a)localObject, (TextView)paramView.findViewById(2131364081));
        nhn.a.b((nhn.a)localObject, (TextView)paramView.findViewById(2131364071));
        paramView.setTag(localObject);
      }
    }
    for (;;)
    {
      localObject = (liw.a)getItem(paramInt);
      if (localObject != null) {
        a((liw.a)localObject, paramView);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = paramView.inflate(2131561793, paramViewGroup, false);
      break;
    }
  }
  
  class a
  {
    private ImageView kA;
    private TextView th;
    private TextView ti;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhn
 * JD-Core Version:    0.7.0.1
 */