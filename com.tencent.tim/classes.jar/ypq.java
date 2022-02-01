import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ypq
  extends RecyclerView.Adapter<ypq.b>
{
  ypn jdField_a_of_type_Ypn;
  ypq.c jdField_a_of_type_Ypq$c;
  Context context;
  List<ypn> sV;
  
  public ypq(Context paramContext, List<ypn> paramList, ypq.c paramc)
  {
    this.context = paramContext;
    this.sV = paramList;
    this.jdField_a_of_type_Ypq$c = paramc;
  }
  
  private void a(ypq.b paramb, ypn paramypn)
  {
    paramb.hi.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramypn.aZt, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramypn.aZs, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.context.getResources().getColor(2131167461);
    int j = this.context.getResources().getColor(2131167311);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramypn.isSelected) {
      paramb.nk.setTextColor(i);
    }
    for (;;)
    {
      paramb.nk.setText(paramypn.itemName);
      paramb.hi.setImageDrawable((Drawable)localObject);
      paramb.a.setUnselectedColor(str);
      paramb.a.setSelectedColor(paramypn.color);
      paramb.a.setSelected(paramypn.isSelected);
      anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramypn.itemName, "", "");
      return;
      paramb.nk.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public void Es(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    ypn localypn = (ypn)this.sV.get(paramInt);
    localypn.isSelected = true;
    if (this.jdField_a_of_type_Ypn == null) {
      this.jdField_a_of_type_Ypn = localypn;
    }
    for (;;)
    {
      notifyDataSetChanged();
      anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localypn.itemName, "", "");
      return;
      if (this.jdField_a_of_type_Ypn != localypn)
      {
        this.jdField_a_of_type_Ypn.isSelected = false;
        this.jdField_a_of_type_Ypn = localypn;
      }
    }
  }
  
  public ypq.b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ypq.b(LayoutInflater.from(this.context).inflate(2131560045, null));
  }
  
  public void a(ypq.b paramb, int paramInt)
  {
    a(paramb, (ypn)this.sV.get(paramInt));
    paramb.a.setOnClickListener(new ypr(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    if (this.sV != null) {
      return this.sV.size();
    }
    return 0;
  }
  
  public static class a
    extends RecyclerView.ItemDecoration
  {
    private int caA;
    private int space;
    
    public a(int paramInt1, int paramInt2)
    {
      this.space = paramInt1;
      this.caA = paramInt2;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      paramRect.right = this.space;
      if (paramRecyclerView.getChildPosition(paramView) == 0) {
        paramRect.left = this.caA;
      }
    }
  }
  
  static class b
    extends RecyclerView.ViewHolder
  {
    public BubbleLayout a;
    public ImageView hi;
    public TextView nk;
    
    public b(View paramView)
    {
      super();
      this.nk = ((TextView)paramView.findViewById(2131373494));
      this.hi = ((ImageView)paramView.findViewById(2131373489));
      this.a = ((BubbleLayout)paramView.findViewById(2131373488));
    }
  }
  
  public static abstract interface c
  {
    public abstract void onItemClick(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypq
 * JD-Core Version:    0.7.0.1
 */