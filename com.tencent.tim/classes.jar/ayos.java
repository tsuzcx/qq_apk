import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ayos
  extends ayoq
{
  public String mTime;
  
  public ayos(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  public boolean LD()
  {
    return true;
  }
  
  @NonNull
  public ayoq.a a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new ayos.a(paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends ayoq.a> c()
  {
    return ayos.a.class;
  }
  
  class a
    extends ayoq.a<ayos>
  {
    private ImageView no = (ImageView)this.mItemView.findViewById(2131368675);
    private ImageView np = (ImageView)this.mItemView.findViewById(2131368676);
    private ImageView nq = (ImageView)this.mItemView.findViewById(2131371859);
    private ImageView nr = (ImageView)this.mItemView.findViewById(2131371860);
    
    private a(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      super(paramViewGroup);
    }
    
    void a(ImageView paramImageView, char paramChar)
    {
      switch (paramChar)
      {
      default: 
        return;
      case '0': 
        paramImageView.setImageResource(2130847556);
        return;
      case '1': 
        paramImageView.setImageResource(2130847557);
        return;
      case '2': 
        paramImageView.setImageResource(2130847558);
        return;
      case '3': 
        paramImageView.setImageResource(2130847559);
        return;
      case '4': 
        paramImageView.setImageResource(2130847560);
        return;
      case '5': 
        paramImageView.setImageResource(2130847561);
        return;
      case '6': 
        paramImageView.setImageResource(2130847562);
        return;
      case '7': 
        paramImageView.setImageResource(2130847563);
        return;
      case '8': 
        paramImageView.setImageResource(2130847564);
        return;
      }
      paramImageView.setImageResource(2130847565);
    }
    
    public void a(ayos paramayos, int paramInt)
    {
      super.a(paramayos, paramInt);
      paramayos = new SimpleDateFormat("HH:mm");
      ((ayos)this.jdField_a_of_type_Ayoq).mTime = paramayos.format(new Date());
      ram.d("TimeFilterData", "TimeFilterData time:" + ((ayos)this.jdField_a_of_type_Ayoq).mTime);
      a(this.no, ((ayos)this.jdField_a_of_type_Ayoq).mTime.charAt(0));
      a(this.np, ((ayos)this.jdField_a_of_type_Ayoq).mTime.charAt(1));
      a(this.nq, ((ayos)this.jdField_a_of_type_Ayoq).mTime.charAt(3));
      a(this.nr, ((ayos)this.jdField_a_of_type_Ayoq).mTime.charAt(4));
      paramInt = rpq.getWindowScreenHeight(this.mItemView.getContext());
      this.mItemView.setPadding(0, paramInt / 3 * 2, 0, 0);
    }
    
    protected View b(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      return LayoutInflater.from(paramContext).inflate(2131561984, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayos
 * JD-Core Version:    0.7.0.1
 */