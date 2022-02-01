import android.support.v7.widget.RecyclerView.ViewHolder;

public class zzs
{
  public int a;
  public RecyclerView.ViewHolder a;
  public int b;
  public RecyclerView.ViewHolder b;
  public int c;
  public int d;
  
  private zzs(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder1;
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder2;
  }
  
  private zzs(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramViewHolder1, paramViewHolder2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public String toString()
  {
    return "ChangeInfo{oldHolder=" + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder + ", newHolder=" + this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder + ", fromX=" + this.jdField_a_of_type_Int + ", fromY=" + this.jdField_b_of_type_Int + ", toX=" + this.c + ", toY=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzs
 * JD-Core Version:    0.7.0.1
 */