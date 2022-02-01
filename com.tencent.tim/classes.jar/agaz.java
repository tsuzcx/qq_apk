import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class agaz
  extends abeg
{
  private List<agba> re;
  
  public agaz(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public agbb a(int paramInt)
  {
    if ((this.re != null) && (this.re.size() > paramInt)) {
      return (agbb)this.re.get(paramInt);
    }
    return null;
  }
  
  public void c(agbb paramagbb)
  {
    if (getCount() == 0) {
      this.re = new ArrayList();
    }
    this.re.add(0, paramagbb);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.re != null) {
      return this.re.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l3 = System.currentTimeMillis();
    View localView;
    agaz.a locala;
    agbb localagbb;
    long l1;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559326, null);
      locala = new agaz.a();
      locala.pQ = ((ImageView)localView.findViewById(2131367680));
      locala.Sc = ((TextView)localView.findViewById(2131367703));
      localView.setTag(locala);
      long l2 = System.currentTimeMillis();
      localagbb = a(paramInt);
      l1 = l2;
      if (localagbb != null)
      {
        locala.uin = localagbb.bGh;
        locala.pQ.setImageBitmap(a(1, localagbb.bGh));
        l1 = System.currentTimeMillis() - l2;
        str = localagbb.userNick;
        if (str != null) {
          break label236;
        }
        paramView = localagbb.bGh;
      }
    }
    for (;;)
    {
      locala.Sc.setText(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l3) + ", faceBitmap = " + l1);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      locala = (agaz.a)paramView.getTag();
      localView = paramView;
      break;
      label236:
      paramView = str;
      if (TextUtils.isEmpty(str.trim())) {
        paramView = localagbb.bGh;
      }
    }
  }
  
  public void kE(List<agba> paramList)
  {
    this.re = new ArrayList(paramList);
    notifyDataSetChanged();
  }
  
  static class a
    extends abeg.a
  {
    TextView Sc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agaz
 * JD-Core Version:    0.7.0.1
 */