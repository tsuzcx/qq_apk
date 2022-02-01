import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.ColorSelectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class aqpk
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private aqpk.d a;
  public aqpk.e a;
  private int ayA = -1;
  private int ebu;
  private ArrayList<aqpk.a> mData = new ArrayList();
  private LayoutInflater mInflater;
  public Drawable mLoadingDrawable;
  
  public aqpk(Context paramContext, aqpk.d paramd)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Aqpk$d = paramd;
    this.jdField_a_of_type_Aqpk$e = new aqpk.e();
    this.mLoadingDrawable = paramContext.getResources().getDrawable(2130847948);
    this.ebu = aqcx.dip2px(paramContext, 2.0F);
  }
  
  public void XI(int paramInt)
  {
    int i = this.ayA;
    this.ayA = paramInt;
    if (i > 0) {
      notifyItemChanged(i);
    }
    if (this.ayA > 0) {
      notifyItemChanged(this.ayA);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Aqpk$e.setSelect(-1);
    }
  }
  
  public aqpk.a a(int paramInt)
  {
    return (aqpk.a)this.mData.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mData.size();
  }
  
  public long getItemId(int paramInt)
  {
    aqpk.a locala = (aqpk.a)this.mData.get(paramInt);
    if (locala.type == 3) {
      return locala.value;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((aqpk.a)this.mData.get(paramInt)).type;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new aqpl(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (aqpk.a)this.mData.get(paramInt);
    switch (((aqpk.a)localObject1).type)
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        if ((paramViewHolder instanceof aqpk.g))
        {
          localObject2 = (aqpk.g)paramViewHolder;
          if (((aqpk.g)localObject2).mType == 1) {
            ((aqpk.g)localObject2).mTitle.setText(((aqpk.a)localObject1).title);
          }
        }
      }
    } while (!(paramViewHolder instanceof aqpk.c));
    Object localObject2 = (aqpk.c)paramViewHolder;
    ((aqpk.c)localObject2).mPosition = paramInt;
    Object localObject3 = (GridLayoutManager.LayoutParams)((aqpk.c)localObject2).itemView.getLayoutParams();
    if (paramInt % 3 == 0)
    {
      ((GridLayoutManager.LayoutParams)localObject3).rightMargin = 0;
      label139:
      if (paramInt != this.ayA) {
        break label213;
      }
      ((aqpk.c)localObject2).Fg.setVisibility(0);
    }
    for (;;)
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.mLoadingDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.mLoadingDrawable;
      localObject1 = URLDrawable.getDrawable(((aqpk.a)localObject1).previewUrl, (URLDrawable.URLDrawableOptions)localObject3);
      ((aqpk.c)localObject2).wx.setImageDrawable((Drawable)localObject1);
      break;
      ((GridLayoutManager.LayoutParams)localObject3).rightMargin = this.ebu;
      break label139;
      label213:
      ((aqpk.c)localObject2).Fg.setVisibility(8);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new aqpk.g(this.mInflater.inflate(2131562082, paramViewGroup, false), 1);
    case 3: 
      return new aqpk.c(this.mInflater.inflate(2131562083, paramViewGroup, false), this, this.jdField_a_of_type_Aqpk$d);
    case 2: 
      return new aqpk.f(this.mInflater.inflate(2131562085, paramViewGroup, false), this.jdField_a_of_type_Aqpk$d, this.jdField_a_of_type_Aqpk$e, this);
    }
    return new aqpk.g(this.mInflater.inflate(2131562081, paramViewGroup, false), 4);
  }
  
  public void setData(List<aqpk.a> paramList, boolean paramBoolean)
  {
    this.mData.clear();
    this.mData.addAll(paramList);
    if (paramBoolean) {
      this.mData.add(new aqpk.a(4, null, 0, null));
    }
    notifyDataSetChanged();
  }
  
  public static class a
  {
    public String previewUrl;
    public String title;
    public int type;
    public int value;
    
    public a(int paramInt1, String paramString1, int paramInt2, String paramString2)
    {
      this.type = paramInt1;
      this.title = paramString1;
      this.value = paramInt2;
      this.previewUrl = paramString2;
    }
  }
  
  public static abstract class b
    extends RecyclerView.OnScrollListener
  {
    private boolean bna;
    
    public abstract void aSa();
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      if (paramInt == 0)
      {
        paramInt = localGridLayoutManager.findLastCompletelyVisibleItemPosition();
        if ((((aqpk)paramRecyclerView.getAdapter()).a(paramInt).type == 4) && (this.bna)) {
          aSa();
        }
      }
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (paramInt2 > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bna = bool;
        return;
      }
    }
  }
  
  public static class c
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    ImageView Fg;
    aqpk.d b;
    aqpk c;
    public int mPosition;
    ImageView wx;
    
    public c(View paramView, aqpk paramaqpk, aqpk.d paramd)
    {
      super();
      this.c = paramaqpk;
      this.wx = ((ImageView)paramView.findViewById(2131364888));
      this.Fg = ((ImageView)paramView.findViewById(2131364889));
      paramView.setOnClickListener(this);
      this.b = paramd;
    }
    
    public void onClick(View paramView)
    {
      this.c.XI(this.mPosition);
      if (this.b != null) {
        this.b.a(this.c.a(this.mPosition));
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(aqpk.a parama);
  }
  
  public static class e
    extends BaseAdapter
  {
    public static final int[] pc = { 0, -16777216, -51904, -41579, -2992688, -15808515, -16268201, -12464 };
    public int cVo = -1;
    
    public int getCount()
    {
      return pc.length;
    }
    
    public Object getItem(int paramInt)
    {
      return Integer.valueOf(pc[paramInt]);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562084, paramViewGroup, false);
      }
      for (;;)
      {
        ColorSelectView localColorSelectView = (ColorSelectView)paramView.findViewById(2131364903);
        ImageView localImageView = (ImageView)paramView.findViewById(2131364901);
        if (paramInt == 0)
        {
          localColorSelectView.setVisibility(8);
          localImageView.setVisibility(0);
          if (this.cVo == paramInt) {}
          for (int i = 2130847943;; i = 2130847942)
          {
            localImageView.setImageResource(i);
            EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
            return paramView;
          }
        }
        localColorSelectView.setVisibility(0);
        localImageView.setVisibility(8);
        localColorSelectView.setColor(pc[paramInt]);
        if (this.cVo == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          localColorSelectView.setSelect(bool);
          break;
        }
      }
    }
    
    public void setSelect(int paramInt)
    {
      this.cVo = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public static class f
    extends RecyclerView.ViewHolder
    implements AdapterView.OnItemClickListener
  {
    aqpk.d jdField_b_of_type_Aqpk$d;
    aqpk.e jdField_b_of_type_Aqpk$e;
    aqpk c;
    HorizontalListView z;
    
    public f(View paramView, aqpk.d paramd, aqpk.e parame, aqpk paramaqpk)
    {
      super();
      this.z = ((HorizontalListView)paramView.findViewById(2131364902));
      this.jdField_b_of_type_Aqpk$e = parame;
      this.z.setAdapter(this.jdField_b_of_type_Aqpk$e);
      this.z.setOnItemClickListener(this);
      this.jdField_b_of_type_Aqpk$d = paramd;
      this.c = paramaqpk;
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      this.jdField_b_of_type_Aqpk$e.setSelect(paramInt);
      this.c.XI(-1);
      if (this.jdField_b_of_type_Aqpk$d != null)
      {
        aqpk.a locala = new aqpk.a(2, null, ((Integer)this.jdField_b_of_type_Aqpk$e.getItem(paramInt)).intValue(), null);
        this.jdField_b_of_type_Aqpk$d.a(locala);
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public static class g
    extends RecyclerView.ViewHolder
  {
    TextView mTitle;
    int mType;
    
    public g(View paramView, int paramInt)
    {
      super();
      this.mType = paramInt;
      if (paramInt == 1) {
        this.mTitle = ((TextView)paramView.findViewById(2131364904));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpk
 * JD-Core Version:    0.7.0.1
 */