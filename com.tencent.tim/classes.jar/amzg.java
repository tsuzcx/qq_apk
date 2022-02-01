import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class amzg
  implements amxx
{
  private TextView Zt;
  private TextView desc;
  private View root;
  
  public amzg(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    this.root = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt1, paramViewGroup, false);
    paramViewGroup = (ImageView)this.root.findViewById(2131368820);
    if ((paramViewGroup != null) && (paramInt2 > 0)) {
      paramViewGroup.setImageResource(paramInt2);
    }
    this.Zt = ((TextView)this.root.findViewById(2131370083));
    this.desc = ((TextView)this.root.findViewById(2131365748));
    if (paramInt3 == 12) {
      this.desc.setText(acfp.m(2131714139) + obt.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext()) + acfp.m(2131714138));
    }
  }
  
  public TextView R()
  {
    return this.Zt;
  }
  
  public TextView getTitleView()
  {
    return null;
  }
  
  public View getView()
  {
    return this.root;
  }
  
  public List<amxy> gh()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzg
 * JD-Core Version:    0.7.0.1
 */