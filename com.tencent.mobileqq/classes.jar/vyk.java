import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class vyk
  extends wbp<SubscribeDraftBean>
  implements wcl
{
  public static int a;
  public static String a;
  private int jdField_b_of_type_Int = ImmersiveUtils.a(19.0F);
  private String jdField_b_of_type_JavaLangString;
  private int c = ImmersiveUtils.a(3.0F);
  
  static
  {
    jdField_a_of_type_JavaLangString = "SubscribeDraftAdapter";
    jdField_a_of_type_Int = ImmersiveUtils.a(4.0F);
  }
  
  public vyk(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 2;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubDraftChangeEvent.class);
    return localArrayList;
  }
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex() % 2 == 0) {
      paramRect.left = jdField_a_of_type_Int;
    }
    for (paramRect.right = (this.c / 2);; paramRect.right = jdField_a_of_type_Int)
    {
      paramRect.bottom = this.jdField_b_of_type_Int;
      return;
      paramRect.left = (this.c / 2);
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubDraftChangeEvent)) {
      b();
    }
  }
  
  public void a(wca paramwca)
  {
    if ((paramwca.d()) || (paramwca.c())) {
      b();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if ((a() != null) && (a() != null) && (((PublicFragmentActivity)a()).app != null))
    {
      this.jdField_b_of_type_JavaLangString = ((PublicFragmentActivity)a()).app.getAccount();
      if (wei.a().a(this.jdField_b_of_type_JavaLangString)) {
        wei.a().a(this.jdField_b_of_type_JavaLangString, new vyl(this));
      }
    }
    else
    {
      return;
    }
    a();
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof vym)) {
      ((vym)paramViewHolder).a((SubscribeDraftBean)b().get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new vym(this, new SubScribeDraftItemView(paramViewGroup.getContext(), this));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    wcj.a().b(this);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    wcj.a().a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vyk
 * JD-Core Version:    0.7.0.1
 */