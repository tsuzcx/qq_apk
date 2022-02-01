import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardXingquBuluo;
import com.tencent.biz.addContactTroopView.TroopCardXingquBuluo.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item3;

public class joe
  extends BaseAdapter
{
  public joe(TroopCardXingquBuluo paramTroopCardXingquBuluo) {}
  
  public int getCount()
  {
    if (this.a.fJ != null) {
      return this.a.fJ.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new TroopCardXingquBuluo.a();
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131560043, paramViewGroup, false);
      paramView.hj = ((ImageView)localView.findViewById(2131368905));
      paramView.nl = ((TextView)localView.findViewById(2131379561));
      paramView.nn = ((TextView)localView.findViewById(2131379516));
      paramView.no = ((TextView)localView.findViewById(2131379472));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = (searchtab.Item3)this.a.fJ.get(paramInt);
      int i = wja.dp2px(30.0F, this.a.getResources());
      URLDrawable localURLDrawable = URLDrawable.getDrawable(((searchtab.Item3)localObject).str_img_url.get(), i, i);
      paramView.hj.setImageDrawable(localURLDrawable);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
        localURLDrawable.restartDownload();
      }
      paramView.nl.setText(((searchtab.Item3)localObject).str_name.get());
      paramView.nn.setText(((searchtab.Item3)localObject).str_desc1.get());
      paramView.no.setText(((searchtab.Item3)localObject).str_desc2.get());
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (TroopCardXingquBuluo.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     joe
 * JD-Core Version:    0.7.0.1
 */