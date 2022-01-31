import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class uui<M, VH extends uuh<M>>
  extends RecyclerView.Adapter<uuh<M>>
{
  protected Context a;
  protected View a;
  protected uuf a;
  protected uug a;
  protected View b;
  
  public uui(Context paramContext)
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
  
  public final uuh a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new uuh(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Uuf != null) {
        paramViewGroup.itemView.setOnClickListener(new uuj(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Uug != null) {
        paramViewGroup.itemView.setOnLongClickListener(new uuk(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new uuh(this.b);
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
  
  public void a(uuf paramuuf)
  {
    this.jdField_a_of_type_Uuf = paramuuf;
  }
  
  public void a(uug paramuug)
  {
    this.jdField_a_of_type_Uug = paramuug;
  }
  
  public final void a(uuh paramuuh, int paramInt)
  {
    switch (paramuuh.getItemViewType())
    {
    default: 
      b(paramuuh, paramInt);
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
 * Qualified Name:     uui
 * JD-Core Version:    0.7.0.1
 */