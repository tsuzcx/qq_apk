import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class knw
  extends ReportDialog
  implements View.OnClickListener
{
  private knw.a jdField_a_of_type_Knw$a;
  private knw.b jdField_a_of_type_Knw$b;
  private int aKl = -1;
  private List<GiftServiceBean> data = new ArrayList();
  private LinearLayout du;
  private LinearLayout dv;
  private ListView listView;
  
  public knw(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755579);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131560396);
    this.listView = ((ListView)findViewById(2131370951));
    this.du = ((LinearLayout)findViewById(2131370962));
    this.jdField_a_of_type_Knw$b = new knw.b();
    this.listView.setAdapter(this.jdField_a_of_type_Knw$b);
    this.listView.setOnItemClickListener(new knx(this));
    this.du = ((LinearLayout)findViewById(2131370962));
    this.dv = ((LinearLayout)findViewById(2131370968));
    this.dv.setOnClickListener(this);
    odc.a(this.du, wja.dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    odc.a(this.listView, wja.dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, knw.a parama, String paramString)
  {
    this.data = paramList;
    this.jdField_a_of_type_Knw$a = parama;
    this.jdField_a_of_type_Knw$b.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        parama = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(parama.t)) && (parama.t.equals(paramString))) {
          this.aKl = i;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(GiftServiceBean paramGiftServiceBean);
  }
  
  class b
    extends BaseAdapter
  {
    b() {}
    
    public int getCount()
    {
      return knw.a(knw.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return knw.a(knw.this).get(paramInt);
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
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560395, null);
        paramView = new knw.c(knw.this);
        paramView.text = ((TextView)localView.findViewById(2131380966));
        paramView.ik = ((ImageView)localView.findViewById(2131369702));
        localView.setTag(paramView);
        localObject = (GiftServiceBean)getItem(paramInt);
        paramView.text.setText(((GiftServiceBean)localObject).t);
        if (knw.a(knw.this) != paramInt) {
          break label143;
        }
        paramView.ik.setBackgroundResource(2130843722);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (knw.c)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label143:
        paramView.ik.setBackgroundResource(2130843723);
      }
    }
  }
  
  class c
  {
    ImageView ik;
    TextView text;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knw
 * JD-Core Version:    0.7.0.1
 */