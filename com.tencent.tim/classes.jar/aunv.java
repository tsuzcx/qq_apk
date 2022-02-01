import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aunv
  extends BaseAdapter
{
  protected List<aupm> Ld = new ArrayList();
  private aupf.b jdField_a_of_type_Aupf$b;
  private final aupo jdField_a_of_type_Aupo;
  protected QQAppInterface app;
  protected Context context;
  private View.OnClickListener onClickListener;
  private View.OnLongClickListener onLongClickListener;
  
  public aunv(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.jdField_a_of_type_Aupo = new aupo(this.app, paramContext);
  }
  
  public aupm a(int paramInt)
  {
    return (aupm)this.Ld.get(paramInt);
  }
  
  public void a(aupf.b paramb)
  {
    this.jdField_a_of_type_Aupf$b = paramb;
  }
  
  public int getCount()
  {
    return this.Ld.size();
  }
  
  public long getItemId(int paramInt)
  {
    return a(paramInt).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((aupm)this.Ld.get(paramInt)).getViewType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aupm localaupm = (aupm)this.Ld.get(paramInt);
    aupf localaupf = this.jdField_a_of_type_Aupo.a(localaupm, this);
    paramView = localaupf.a(paramInt, localaupm, paramView, paramViewGroup, this.onClickListener, this.onLongClickListener);
    localaupf.a(this.jdField_a_of_type_Aupf$b);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    aupo localaupo = this.jdField_a_of_type_Aupo;
    return 3;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public List<aupm> hq()
  {
    return this.Ld;
  }
  
  public void od(List<? extends aupm> paramList)
  {
    this.Ld.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.Ld.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunv
 * JD-Core Version:    0.7.0.1
 */