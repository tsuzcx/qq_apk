import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class rjg
  extends rja
{
  public final int bss;
  
  public rjg(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.bss = paramInt2;
  }
  
  @NonNull
  public rja.a a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new rjg.a(paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends rja.a> c()
  {
    return rjg.a.class;
  }
  
  public class a
    extends rja.a<rjg>
  {
    public final ImageView ns = (ImageView)this.mItemView.findViewById(2131368820);
    public final TextView yE = (TextView)this.mItemView.findViewById(2131379401);
    public final TextView yF = (TextView)this.mItemView.findViewById(2131379482);
    
    a(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      super(paramViewGroup);
    }
    
    public void a(rjg paramrjg, int paramInt)
    {
      super.a(paramrjg, paramInt);
      if ((this.jdField_a_of_type_Rja != null) && (((rjg)this.jdField_a_of_type_Rja).bss != 0) && (((rjg)this.jdField_a_of_type_Rja).aAH != null))
      {
        this.ns.setVisibility(0);
        this.ns.setImageResource(((rjg)this.jdField_a_of_type_Rja).bss);
        this.yE.setVisibility(0);
        this.yE.setText(((rjg)this.jdField_a_of_type_Rja).aAH);
        this.yF.setText(((rjg)this.jdField_a_of_type_Rja).aAI);
        return;
      }
      this.ns.setVisibility(4);
      this.yE.setVisibility(4);
      this.yF.setText("");
    }
    
    protected View b(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      return LayoutInflater.from(paramContext).inflate(2131561854, paramViewGroup, false);
    }
    
    public void buT()
    {
      super.buT();
      this.yE.setVisibility(4);
      this.ns.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjg
 * JD-Core Version:    0.7.0.1
 */