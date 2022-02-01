import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aorm
{
  private static String TAG = "TribeTitlePrefixPanelView";
  private aorm.c a;
  private ListView u;
  
  public aorm(Context paramContext, ListView paramListView)
  {
    this.u = paramListView;
    this.a = new aorm.c(paramContext);
    this.u.setAdapter(this.a);
  }
  
  public void a(aorm.b paramb)
  {
    if (this.a != null) {
      this.a.a(paramb);
    }
  }
  
  public void mF(List<aorm.d> paramList)
  {
    if (this.a != null) {
      this.a.cX(paramList);
    }
  }
  
  static class a
    implements View.OnClickListener
  {
    private aorm.b a;
    private aorm.c b;
    
    public a(aorm.c paramc)
    {
      this.b = paramc;
    }
    
    public void a(aorm.b paramb)
    {
      this.a = paramb;
    }
    
    public void onClick(View paramView)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      aorm.c.a(this.b, i);
      if (this.a != null) {
        this.a.a((aorm.d)aorm.c.a(this.b).get(i));
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(aorm.d paramd);
  }
  
  static class c
    extends BaseAdapter
  {
    private List<aorm.d> Hg;
    private List<aorm.d> Hh;
    private aorm.a a;
    private Context mContext;
    private int mSelectedPosition;
    
    public c(Context paramContext)
    {
      this.mContext = paramContext;
      this.Hg = new ArrayList();
      this.Hh = new ArrayList();
      this.a = new aorm.a(this);
    }
    
    private void Wc(int paramInt)
    {
      this.mSelectedPosition = paramInt;
      dWE();
      notifyDataSetChanged();
    }
    
    private void dWE()
    {
      this.Hh.clear();
      int i = 0;
      while (i < this.Hg.size())
      {
        if (this.mSelectedPosition != i) {
          this.Hh.add(this.Hg.get(i));
        }
        i += 1;
      }
    }
    
    private void hQ(View paramView)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setCornerRadius(aqnm.dip2px(17.0F));
      localGradientDrawable.setColor(Color.parseColor("#FBFBFB"));
      localGradientDrawable.setStroke(1, Color.parseColor("#E7E7EE"));
      paramView.setBackgroundDrawable(localGradientDrawable);
    }
    
    public void a(aorm.b paramb)
    {
      if (this.a != null) {
        this.a.a(paramb);
      }
    }
    
    public void cX(List<aorm.d> paramList)
    {
      this.Hg.clear();
      this.Hg.addAll(paramList);
      if (QLog.isColorLevel()) {
        QLog.d(aorm.TAG, 2, new Object[] { "mPrefixList size: ", Integer.valueOf(this.Hg.size()) });
      }
      this.mSelectedPosition = 0;
      dWE();
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.Hh != null) {
        return this.Hh.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return this.Hh.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        paramView = new aorm.e(null);
        localView = LayoutInflater.from(this.mContext).inflate(2131560113, paramViewGroup, false);
        paramView.X = ((RelativeLayout)localView.findViewById(2131373549));
        paramView.prefixTV = ((TextView)localView.findViewById(2131373551));
        localView.setTag(paramView);
        localObject = (aorm.d)this.Hh.get(paramInt);
        if (localObject != null) {
          paramView.prefixTV.setText(((aorm.d)localObject).cmI + ((aorm.d)localObject).cmJ + ((aorm.d)localObject).cmK);
        }
        hQ(paramView.X);
        if (paramInt >= this.mSelectedPosition) {
          break label198;
        }
        paramView.X.setTag(Integer.valueOf(paramInt));
      }
      for (;;)
      {
        paramView.X.setOnClickListener(this.a);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (aorm.e)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label198:
        paramView.X.setTag(Integer.valueOf(paramInt + 1));
      }
    }
  }
  
  public static class d
  {
    public String cmI;
    public String cmJ;
    public String cmK;
    
    public void ak(JSONObject paramJSONObject)
      throws JSONException, NumberFormatException
    {
      this.cmI = paramJSONObject.optString("left");
      this.cmJ = paramJSONObject.optString("text");
      this.cmK = paramJSONObject.optString("right");
    }
    
    public boolean isValid()
    {
      return (!TextUtils.isEmpty(this.cmI)) && (!TextUtils.isEmpty(this.cmJ)) && (!TextUtils.isEmpty(this.cmK));
    }
  }
  
  static class e
  {
    public RelativeLayout X;
    public TextView prefixTV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aorm
 * JD-Core Version:    0.7.0.1
 */