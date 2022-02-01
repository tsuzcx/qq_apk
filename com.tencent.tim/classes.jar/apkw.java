import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder;

public class apkw
  extends aplp<ArithmeticViewHolder, apkl>
{
  private ArithmeticViewHolder a;
  private LayoutInflater mLayoutInflater;
  
  public apkw(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public ArithmeticViewHolder a(ViewGroup paramViewGroup)
  {
    this.a = new ArithmeticViewHolder(this.e, this.mLayoutInflater.inflate(2131561740, paramViewGroup, false));
    return this.a;
  }
  
  public void a(View paramView, ArithmeticViewHolder paramArithmeticViewHolder) {}
  
  public void a(apkl paramapkl)
  {
    if (this.a != null) {
      this.a.RQ(true);
    }
  }
  
  public void a(ArithmeticViewHolder paramArithmeticViewHolder, apkl paramapkl, int paramInt)
  {
    paramArithmeticViewHolder.a(paramapkl, paramInt);
    if (this.e.Ls() != 0) {
      paramArithmeticViewHolder.itemView.setPadding(this.e.Ls(), 0, this.e.Ls(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkw
 * JD-Core Version:    0.7.0.1
 */