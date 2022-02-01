import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profile.lifeachivement.LayerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.AlphaClickableTextView;
import java.util.ArrayList;
import java.util.List;

public class alea
  extends RecyclerView.Adapter<alea.b>
{
  alea.c a;
  Context context;
  List<aled> jl = new ArrayList();
  
  public alea(Context paramContext, List<aled> paramList, alea.c paramc)
  {
    this.context = paramContext;
    if (paramList != null) {
      this.jl = paramList;
    }
    this.a = paramc;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementAdapter", 2, "LifeAchivementAdapter itemClickListener = " + this.a + ",listener = " + paramc);
    }
  }
  
  private void a(alea.b paramb, aled paramaled)
  {
    if (!TextUtils.isEmpty(paramaled.iconUrl))
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramaled.iconUrl, null);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
      {
        localURLDrawable.setAutoDownload(true);
        localURLDrawable.startDownload(true);
      }
      paramb.a.setImageDrawable(localURLDrawable);
    }
    if (paramaled.type == 2)
    {
      paramb.um.setVisibility(0);
      paramb.um.setText("+" + paramaled.dsD);
      paramb.b.setVisibility(4);
    }
    for (;;)
    {
      paramb.content.setText(paramaled.title);
      return;
      if (paramaled.type == 1)
      {
        paramb.um.setVisibility(4);
        paramb.b.setVisibility(4);
      }
      else
      {
        paramb.um.setVisibility(4);
        paramb.b.setVisibility(0);
        a(paramb.b, paramaled.hasPraised, paramaled.dsC);
      }
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    paramTextView.setText(alee.eL(paramInt));
    if (paramBoolean) {}
    for (paramInt = 2130846695;; paramInt = 2130846694)
    {
      Drawable localDrawable = paramTextView.getResources().getDrawable(paramInt);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(wja.dp2px(2.0F, paramTextView.getResources()));
      return;
    }
  }
  
  public alea.b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new alea.b(LayoutInflater.from(this.context).inflate(2131561565, paramViewGroup, false));
  }
  
  public aled a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jl != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jl.size()) {
        localObject1 = (aled)this.jl.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public void a(alea.b paramb, int paramInt)
  {
    a(paramb, (aled)this.jl.get(paramInt));
    paramb.a.setOnClickListener(new aleb(this, paramInt));
    paramb.b.setOnClickListener(new alec(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
  }
  
  public void f(List<aled> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.jl.clear();
      if (paramInt <= 10) {
        break label151;
      }
      this.jl.addAll(paramList.subList(0, 10));
      paramList = new aled();
      paramList.title = this.context.getResources().getString(2131701301);
      paramList.iconUrl = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
      paramList.dsD = (paramInt - 10);
      paramList.type = 2;
      this.jl.add(paramList);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramList = new aled();
        paramList.title = this.context.getResources().getString(2131701295);
        paramList.iconUrl = "https://downv6.qq.com/qq_relation/life_achivement/add_badge_v2.png";
        paramList.type = 1;
        this.jl.add(0, paramList);
      }
      notifyDataSetChanged();
      return;
      label151:
      this.jl.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    if (this.jl != null) {
      return this.jl.size();
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
    public LayerImageView a;
    public AlphaClickableRelativeLayout b;
    public AlphaClickableTextView b;
    public TextView content;
    public TextView um;
    
    public b(View paramView)
    {
      super();
      this.jdField_b_of_type_ComTencentWidgetAlphaClickableRelativeLayout = ((AlphaClickableRelativeLayout)paramView.findViewById(2131368946));
      this.a = ((LayerImageView)paramView.findViewById(2131361953));
      this.um = ((TextView)paramView.findViewById(2131361954));
      this.content = ((TextView)paramView.findViewById(2131361952));
      this.jdField_b_of_type_ComTencentWidgetAlphaClickableTextView = ((AlphaClickableTextView)paramView.findViewById(2131361955));
      this.jdField_b_of_type_ComTencentWidgetAlphaClickableRelativeLayout.Wd(false);
      this.jdField_b_of_type_ComTencentWidgetAlphaClickableTextView.setEnabled(true);
    }
  }
  
  public static abstract interface c
  {
    public abstract void ao(View paramView, int paramInt);
    
    public abstract void ap(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alea
 * JD-Core Version:    0.7.0.1
 */