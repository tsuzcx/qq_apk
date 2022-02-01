import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class kqt
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private HashSet<Long> N;
  private kqr jdField_a_of_type_Kqr;
  private mih jdField_a_of_type_Mih;
  private ListView g;
  private String jumpUrl;
  private View mContentView;
  private Context mContext;
  private HorizontalListView mListView;
  private TextView oL;
  private TextView oM;
  
  private void aGa()
  {
    if ((this.jdField_a_of_type_Mih != null) && (this.jdField_a_of_type_Mih.ld != null))
    {
      int i = this.mListView.getFirstVisiblePosition();
      while (i <= this.mListView.getLastVisiblePosition())
      {
        if ((i >= 1) && (i <= this.jdField_a_of_type_Mih.ld.size()))
        {
          mih.b localb = (mih.b)this.jdField_a_of_type_Mih.ld.get(i - 1);
          lbz.a().h(Long.valueOf(localb.businessId));
          this.N.add(Long.valueOf(localb.businessId));
        }
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    } while (TextUtils.isEmpty(this.jumpUrl));
    kxm.aJ(this.mContext, this.jumpUrl);
    str3 = "";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "" + kxm.aMw);
        if (!aqiw.isWifiConnected(this.mContext)) {
          continue;
        }
        str1 = "2";
        localJSONObject.put("network_type", str1);
        str1 = localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        String str1;
        localJSONException.printStackTrace();
        String str2 = str3;
        continue;
      }
      kbp.a(null, "", "0X8008451", "0X8008451", 0, 0, "", "", "", str1, false);
      break;
      str1 = "1";
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_Kqr.getCount() - 1)) {}
    mih.b localb;
    do
    {
      do
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
      } while ((this.jdField_a_of_type_Mih == null) || (this.jdField_a_of_type_Mih.ld == null) || (paramInt < 1) || (paramInt > this.jdField_a_of_type_Mih.ld.size()));
      localb = (mih.b)this.jdField_a_of_type_Mih.ld.get(paramInt - 1);
    } while ((localb == null) || (TextUtils.isEmpty(localb.businessUrl)));
    kxm.aJ(this.mContext, localb.businessUrl);
    str3 = "";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "" + kxm.aMw);
        if (!aqiw.isWifiConnected(this.mContext)) {
          continue;
        }
        str1 = "2";
        localJSONObject.put("network_type", str1);
        str1 = localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        String str1;
        localJSONException.printStackTrace();
        String str2 = str3;
        continue;
      }
      kbp.a(null, "", "0X8008450", "0X8008450", 0, 0, String.valueOf(localb.businessId), String.valueOf(paramInt - 1), String.valueOf(localb.aTk), str1, false);
      localb.aTk = 0;
      lbz.a().a(this.jdField_a_of_type_Mih);
      this.jdField_a_of_type_Kqr.setData(this.jdField_a_of_type_Mih.ld);
      refreshUI();
      break;
      str1 = "1";
    }
  }
  
  public void refreshUI()
  {
    if ((this.jdField_a_of_type_Mih == null) || (this.jdField_a_of_type_Mih.ld == null) || (this.jdField_a_of_type_Mih.ld.size() == 0))
    {
      this.mContentView.setVisibility(8);
      if (this.g != null) {
        this.g.removeHeaderView(this.mContentView);
      }
      return;
    }
    this.mContentView.setVisibility(0);
    if ((this.g != null) && (this.g.getHeaderViewsCount() < 1)) {
      this.g.addHeaderView(this.mContentView);
    }
    if ((this.oL != null) && (this.jdField_a_of_type_Mih.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mih.a.aiK))) {
      this.oL.setText(this.jdField_a_of_type_Mih.a.aiK);
    }
    if ((this.oM != null) && (this.jdField_a_of_type_Mih.b != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mih.b.url)))
    {
      this.oM.setVisibility(0);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Mih.b.aiK)) {
        this.oM.setText(this.jdField_a_of_type_Mih.b.aiK);
      }
      this.jumpUrl = this.jdField_a_of_type_Mih.b.url;
    }
    for (;;)
    {
      this.jdField_a_of_type_Kqr.notifyDataSetChanged();
      return;
      if (this.oM != null)
      {
        this.oM.setVisibility(8);
        this.jumpUrl = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqt
 * JD-Core Version:    0.7.0.1
 */