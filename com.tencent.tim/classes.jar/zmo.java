import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zmo
  extends BaseAdapter
{
  private static final String TAG = zmo.class.getSimpleName();
  private QQAppInterface app;
  private aurf b;
  private Context mContext;
  private List<zls> uB = new ArrayList();
  
  public zmo(Context paramContext, aurf paramaurf, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.b = paramaurf;
    this.app = paramQQAppInterface;
  }
  
  boolean af(String paramString1, String paramString2)
  {
    return paramString1.toLowerCase(Locale.US).contains(paramString2.toLowerCase(Locale.US));
  }
  
  public int getCount()
  {
    return this.uB.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.uB.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    zls localzls = (zls)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, 2131559539, null);
      paramView = new zmo.a(null);
      paramView.text = ((TextView)localView.findViewById(2131379401));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.text.setText(localzls.keyword);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      zmo.a locala = (zmo.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
    }
  }
  
  public void zy(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "loadHistory, keyword = " + paramString);
    }
    if (paramString == null) {
      return;
    }
    String[] arrayOfString = aqht.w(this.app.getCurrentAccountUin());
    this.uB.clear();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (af(str, paramString)) {
          this.uB.add(new zls(str));
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "loadHistory, keyword = " + paramString + ", histories = " + this.uB.toString());
    }
    this.b.sendEmptyMessage(3);
  }
  
  static class a
  {
    public TextView text;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmo
 * JD-Core Version:    0.7.0.1
 */