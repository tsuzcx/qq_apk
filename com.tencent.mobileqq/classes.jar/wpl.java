import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public abstract class wpl<E>
  extends wox<E>
{
  protected static final String b;
  protected String a;
  protected boolean a;
  protected boolean b;
  
  static
  {
    jdField_b_of_type_JavaLangString = ajya.a(2131708869);
  }
  
  public wpl()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt);
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
    notifyItemChanged(getItemCount() - 1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return 0;
    }
    return 99999;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = 0;
    if ((paramViewHolder == null) || (paramInt >= getItemCount())) {
      return;
    }
    if ((paramViewHolder instanceof wpm))
    {
      paramViewHolder = (wpm)paramViewHolder;
      Object localObject = wpm.a(paramViewHolder);
      if (this.jdField_b_of_type_Boolean)
      {
        paramInt = 0;
        ((LinearLayout)localObject).setVisibility(paramInt);
        if ((!this.jdField_a_of_type_Boolean) || (getItemCount() <= a())) {
          break label117;
        }
        paramInt = 1;
        label68:
        if (paramInt == 0) {
          break label122;
        }
        wpm.a(paramViewHolder).start();
        label81:
        localObject = wpm.a(paramViewHolder);
        if (paramInt == 0) {
          break label134;
        }
      }
      label134:
      for (paramInt = i;; paramInt = 8)
      {
        ((ImageView)localObject).setVisibility(paramInt);
        wpm.a(paramViewHolder).setText(this.jdField_a_of_type_JavaLangString);
        return;
        paramInt = 8;
        break;
        label117:
        paramInt = 0;
        break label68;
        label122:
        wpm.a(paramViewHolder).stop();
        break label81;
      }
    }
    a(paramViewHolder, paramInt);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 99999) {
      return new wpm(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558675, paramViewGroup, false));
    }
    return a(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpl
 * JD-Core Version:    0.7.0.1
 */