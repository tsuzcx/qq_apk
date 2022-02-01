import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class apld
  extends aplb<apld.a, apkq>
{
  private Context mContext;
  private View mHeaderView;
  private LayoutInflater mLayoutInflater;
  
  public apld(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public apld.a a(ViewGroup paramViewGroup)
  {
    return new apld.a(this.mHeaderView);
  }
  
  public void a(View paramView, apld.a parama) {}
  
  public void a(apld.a parama, apkq paramapkq, int paramInt) {}
  
  public void setHeaderView(View paramView)
  {
    this.mHeaderView = paramView;
  }
  
  public static class a
    extends aplc.a<apkt>
  {
    public a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apld
 * JD-Core Version:    0.7.0.1
 */