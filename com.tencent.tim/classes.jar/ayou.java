import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ayou
  extends ayoq
{
  public final int bss;
  
  public ayou(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.bss = paramInt2;
  }
  
  @NonNull
  public ayoq.a a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new ayou.a(paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends ayoq.a> c()
  {
    return ayou.a.class;
  }
  
  public String toString()
  {
    switch (this.bsq)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return "";
    case 0: 
      return "normal";
    case 3: 
      return "slow";
    case 2: 
      return "fast";
    case 9: 
      return "very slow";
    case 8: 
      return "little fast";
    }
    return "rewind";
  }
  
  public class a
    extends ayoq.a<ayou>
  {
    public final ImageView ns = (ImageView)this.mItemView.findViewById(2131368820);
    public final TextView yE = (TextView)this.mItemView.findViewById(2131379401);
    public final TextView yF = (TextView)this.mItemView.findViewById(2131379482);
    
    a(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      super(paramViewGroup);
    }
    
    public void a(ayou paramayou, int paramInt)
    {
      super.a(paramayou, paramInt);
      if ((this.jdField_a_of_type_Ayoq != null) && (((ayou)this.jdField_a_of_type_Ayoq).bss != 0) && (((ayou)this.jdField_a_of_type_Ayoq).aAH != null))
      {
        this.ns.setVisibility(0);
        this.ns.setImageResource(((ayou)this.jdField_a_of_type_Ayoq).bss);
        this.yE.setVisibility(0);
        this.yE.setText(((ayou)this.jdField_a_of_type_Ayoq).aAH);
        this.yF.setText(((ayou)this.jdField_a_of_type_Ayoq).aAI);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayou
 * JD-Core Version:    0.7.0.1
 */