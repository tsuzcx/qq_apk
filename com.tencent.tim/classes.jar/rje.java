import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.text.SimpleDateFormat;
import java.util.Date;

public class rje
  extends rja
{
  protected EditVideoParams a;
  public String mTime;
  
  public rje(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  public rje(int paramInt1, String paramString, int paramInt2, EditVideoParams paramEditVideoParams)
  {
    super(paramInt1, paramString, paramInt2);
    this.a = paramEditVideoParams;
  }
  
  public boolean LD()
  {
    return true;
  }
  
  @NonNull
  public rja.a a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new rje.a(paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends rja.a> c()
  {
    return rje.a.class;
  }
  
  class a
    extends rja.a<rje>
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
    
    public void a(rje paramrje, int paramInt)
    {
      super.a(paramrje, paramInt);
      paramrje = new SimpleDateFormat("HH:mm");
      ((rje)this.jdField_a_of_type_Rja).mTime = paramrje.format(new Date());
      ram.d("TimeFilterData", "TimeFilterData time:" + ((rje)this.jdField_a_of_type_Rja).mTime);
      a(this.no, ((rje)this.jdField_a_of_type_Rja).mTime.charAt(0));
      a(this.np, ((rje)this.jdField_a_of_type_Rja).mTime.charAt(1));
      a(this.nq, ((rje)this.jdField_a_of_type_Rja).mTime.charAt(3));
      a(this.nr, ((rje)this.jdField_a_of_type_Rja).mTime.charAt(4));
      int i = rpq.getWindowScreenHeight(this.mItemView.getContext());
      if (((this.jdField_a_of_type_Rje.a != null) && (this.jdField_a_of_type_Rje.a.asi == 10)) || ((this.jdField_a_of_type_Rje.a != null) && (this.jdField_a_of_type_Rje.a.asi == 12)))
      {
        if (this.jdField_a_of_type_Rje.a.a.getWidth() / this.jdField_a_of_type_Rje.a.a.getHeight() > aqgz.getWidth() / aqgz.getHeight())
        {
          paramInt = (int)(aqgz.getWidth() * this.jdField_a_of_type_Rje.a.a.getHeight() / this.jdField_a_of_type_Rje.a.a.getWidth());
          if (paramInt > i / 3 * 2 + aqcx.dip2px(this.mItemView.getContext(), 75.0F))
          {
            this.mItemView.setPadding(0, i / 3 * 2, 0, 0);
            return;
          }
          i = aqcx.dip2px(this.mItemView.getContext(), 75.0F);
          this.mItemView.setPadding(0, paramInt - i, 0, 0);
          return;
        }
        this.mItemView.setPadding(0, i / 3 * 2, 0, 0);
        return;
      }
      this.mItemView.setPadding(0, i / 3 * 2, 0, 0);
    }
    
    protected View b(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      return LayoutInflater.from(paramContext).inflate(2131561984, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rje
 * JD-Core Version:    0.7.0.1
 */