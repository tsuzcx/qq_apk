import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.component.base.ComponentPageView;

public class tvh
  extends yds
{
  private boolean c;
  
  public tvh(ComponentPageView paramComponentPageView)
  {
    super(paramComponentPageView);
  }
  
  private boolean b()
  {
    return alpo.a(2131698344).equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public void R_()
  {
    this.c = true;
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new tvi(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560552, paramViewGroup, false));
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof tvi))
    {
      paramViewHolder = (tvi)paramViewHolder;
      if (!this.b)
      {
        tvi.a(paramViewHolder).setVisibility(8);
        tvi.b(paramViewHolder).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    label71:
    ImageView localImageView;
    if ((this.jdField_a_of_type_Boolean) && (getItemCount() > a()))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label134;
      }
      tvi.a(paramViewHolder).start();
      localImageView = tvi.a(paramViewHolder);
      if (paramInt == 0) {
        break label146;
      }
    }
    label134:
    label146:
    for (paramInt = 0;; paramInt = 8)
    {
      localImageView.setVisibility(paramInt);
      if ((!this.c) || (!b())) {
        break label152;
      }
      tvi.a(paramViewHolder).setVisibility(8);
      tvi.b(paramViewHolder).setVisibility(0);
      tyj.a("", 22, 12L);
      return;
      paramInt = 0;
      break;
      tvi.a(paramViewHolder).stop();
      break label71;
    }
    label152:
    tvi.a(paramViewHolder).setVisibility(0);
    tvi.a(paramViewHolder).setText(this.jdField_a_of_type_JavaLangString);
    tvi.b(paramViewHolder).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvh
 * JD-Core Version:    0.7.0.1
 */