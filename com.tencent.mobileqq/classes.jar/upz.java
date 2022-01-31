import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class upz<M, VH extends upy<M>>
  extends RecyclerView.Adapter<upy<M>>
{
  protected Context a;
  protected View a;
  protected upw a;
  protected upx a;
  protected View b;
  
  public upz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      i = 1;
    }
    int j = i;
    if (this.b != null) {
      j = i + 1;
    }
    return j;
  }
  
  public final upy a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new upy(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Upw != null) {
        paramViewGroup.itemView.setOnClickListener(new uqa(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Upx != null) {
        paramViewGroup.itemView.setOnLongClickListener(new uqb(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new upy(this.b);
      } else {
        paramViewGroup = b(paramViewGroup, paramInt);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the header view is null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyDataSetChanged();
  }
  
  public void a(upw paramupw)
  {
    this.jdField_a_of_type_Upw = paramupw;
  }
  
  public void a(upx paramupx)
  {
    this.jdField_a_of_type_Upx = paramupx;
  }
  
  public final void a(upy paramupy, int paramInt)
  {
    switch (paramupy.getItemViewType())
    {
    default: 
      b(paramupy, paramInt);
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return 0;
    }
    return 1;
  }
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void b(VH paramVH, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upz
 * JD-Core Version:    0.7.0.1
 */