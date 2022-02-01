import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class atjv
{
  protected BaseAdapter adapter;
  protected QQAppInterface app;
  protected Context context;
  protected int entrance;
  
  public atjv(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.adapter = paramBaseAdapter;
    this.entrance = paramInt;
  }
  
  public abstract View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, atdt.a parama, boolean paramBoolean3, int paramInt2);
  
  public abstract void destroy();
  
  public class a
  {
    public atiu a;
    public CheckBox checkBox;
    public boolean isSelected;
    public int position;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjv
 * JD-Core Version:    0.7.0.1
 */