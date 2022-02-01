import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Map;

public class aupo
{
  private QQAppInterface app;
  private Context context;
  private Map<Integer, aupf> po = new HashMap();
  
  public aupo(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
  }
  
  public aupf a(int paramInt, BaseAdapter paramBaseAdapter)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramBaseAdapter = localObject;
    }
    for (;;)
    {
      if ((paramBaseAdapter != null) && (!this.po.containsKey(Integer.valueOf(paramInt)))) {
        this.po.put(Integer.valueOf(paramInt), paramBaseAdapter);
      }
      return paramBaseAdapter;
      paramBaseAdapter = new aupl(this.app, this.context, paramBaseAdapter);
      continue;
      paramBaseAdapter = new aupq(this.app, this.context, paramBaseAdapter);
      continue;
      paramBaseAdapter = new aupn(this.app, this.context, paramBaseAdapter);
    }
  }
  
  public aupf a(aupm paramaupm, BaseAdapter paramBaseAdapter)
  {
    int i = paramaupm.getViewType();
    if (this.po.get(Integer.valueOf(i)) == null) {
      return a(i, paramBaseAdapter);
    }
    return (aupf)this.po.get(Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupo
 * JD-Core Version:    0.7.0.1
 */