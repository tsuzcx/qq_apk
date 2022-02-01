import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardSameCity;
import com.tencent.biz.addContactTroopView.TroopCardSameCity.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item2;

public class jod
  extends BaseAdapter
{
  public jod(TroopCardSameCity paramTroopCardSameCity) {}
  
  public int getCount()
  {
    if (this.a.fI != null) {
      return this.a.fI.size();
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
    TroopCardSameCity.a locala;
    searchtab.Item2 localItem2;
    int j;
    int k;
    String str;
    int i;
    if (paramView == null)
    {
      locala = new TroopCardSameCity.a();
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131560042, paramViewGroup, false);
      locala.hj = ((ImageView)paramView.findViewById(2131368905));
      locala.nl = ((TextView)paramView.findViewById(2131379561));
      locala.nm = ((TextView)paramView.findViewById(2131379437));
      paramView.setTag(locala);
      localItem2 = (searchtab.Item2)this.a.fI.get(paramInt);
      j = wja.dp2px(38.0F, this.a.getResources());
      k = wja.dp2px(57.0F, this.a.getResources());
      str = localItem2.str_img_url.get();
      i = 1;
      if (jqc.isValidUrl(str)) {
        break label381;
      }
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("//"))) {
        break label336;
      }
      str = "http:" + str;
      ReportControllerImpl.a(null, "dc00899", "Q..urldrawable", "", "url_no_head", "", 0, 0, "TroopCardSameCity", "" + str, "", "");
      i = 1;
      label231:
      if (i == 0) {
        break label447;
      }
    }
    for (;;)
    {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(str, j, k);
        locala.hj.setImageDrawable(localURLDrawable);
        if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
          localURLDrawable.restartDownload();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        label336:
        label381:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q..urldrawable", 2, "URLDrawable.getDrawable() Exception.", localIllegalArgumentException);
        ReportControllerImpl.a(null, "dc00899", "Q..urldrawable", "", "url_illegal", "", 0, 1, "TroopCardSameCity", "" + str, "", "");
        continue;
      }
      locala.nl.setText(localItem2.str_name.get());
      locala.nm.setText(localItem2.str_desc.get());
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (TroopCardSameCity.a)paramView.getTag();
      break;
      i = 0;
      ReportControllerImpl.a(null, "dc00899", "Q..urldrawable", "", "url_illegal", "", 0, 0, "TroopCardSameCity", "" + str, "", "");
      break label231;
      label447:
      locala.hj.setImageDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jod
 * JD-Core Version:    0.7.0.1
 */