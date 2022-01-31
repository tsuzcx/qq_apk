import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoPoi.4;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class wwr
  extends wwc
  implements View.OnClickListener, bcgo, bhqp, utp
{
  double jdField_a_of_type_Double = 0.0D;
  long jdField_a_of_type_Long = 0L;
  amle jdField_a_of_type_Amle;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  WeakReference<www> jdField_a_of_type_MqqUtilWeakReference;
  utq jdField_a_of_type_Utq = null;
  xgp jdField_a_of_type_Xgp = null;
  double jdField_b_of_type_Double = 0.0D;
  View jdField_b_of_type_AndroidViewView = null;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  ArrayList<TroopBarPOI> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  View c = null;
  View d = null;
  
  public wwr(@NonNull wwe paramwwe)
  {
    super(paramwwe);
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  private TroopBarPOI a(List<TroopBarPOI> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramList.next();
      if (localTroopBarPOI.c.equals(paramString)) {
        return localTroopBarPOI;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      acmr localacmr = (acmr)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localacmr != null)
      {
        localacmr.a = false;
        new Handler(Looper.getMainLooper()).postDelayed(new EditVideoPoi.4(this), 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  private void a(List<TroopBarPOI> paramList, String paramString)
  {
    String str = TroopBarPOI.a(paramString);
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramString = a(this.jdField_a_of_type_JavaUtilArrayList, str);
      paramList = paramString;
      if (paramString == null)
      {
        paramList = new TroopBarPOI("-1", "", str, 0, "", 0, "");
        this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramList;
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368613));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376189);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131376213);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365761));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365762));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368659)).setText(alpo.a(2131704222));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372128));
      g();
      j();
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new wws(this));
      this.jdField_a_of_type_Xgp = new xgp(a());
      this.jdField_a_of_type_Xgp.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Xgp);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131373798));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      break;
    }
    do
    {
      do
      {
        return;
        k();
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        a(true);
      } while (!(paramObject instanceof wvd));
      paramObject = (wvd)paramObject;
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramObject.jdField_a_of_type_Www);
      paramObject = paramObject.jdField_a_of_type_JavaLangString;
      a(this.jdField_b_of_type_JavaUtilArrayList, paramObject);
    } while (this.jdField_a_of_type_Xgp == null);
    this.jdField_a_of_type_Xgp.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    this.jdField_a_of_type_Xgp.notifyDataSetChanged();
  }
  
  public void a(int paramInt, utq paramutq, List<TroopBarPOI> paramList)
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult.");
    this.jdField_a_of_type_Utq = paramutq;
    if (!isValidate()) {
      return;
    }
    boolean bool;
    if ((paramInt == 0) && (paramutq != null)) {
      if (!paramutq.a())
      {
        bool = true;
        b(bool);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramList.get(0));
        }
        if ((this.jdField_a_of_type_Utq != null) && (this.jdField_a_of_type_Utq.b())) {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a());
        }
        wsv.a("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult, CurrentPOIList : %s , CurrentPOI : %s .", this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_a_of_type_Xgp != null)
        {
          this.jdField_a_of_type_Xgp.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_Xgp.notifyDataSetChanged();
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label267;
          }
          a(false, false);
        }
        label193:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
          break label287;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c)) {
          break label276;
        }
        paramutq = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
        label221:
        a(1, new String[] { paramutq });
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      wta.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
      bool = false;
      break;
      label267:
      a(true, false);
      break label193;
      label276:
      paramutq = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c;
      break label221;
      label287:
      a(0, new String[0]);
      continue;
      a(3, new String[0]);
    }
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (AppSetting.c) {}
      return;
      a(2131718298);
      continue;
      a(2131718299);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        QQToast.a(a(), paramVarArgs[0], 1).a();
        continue;
        a(2131718300);
        continue;
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || (TextUtils.isEmpty(paramVarArgs[0]))) {
          break;
        }
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
      }
    }
    a(0, new String[0]);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (!isValidate()) {}
    while (3 != paramInt) {
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("result");
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "poiList = " + paramJSONObject);
        }
        if (paramJSONObject == null) {
          continue;
        }
        if (paramJSONObject.optInt("isend", -1) != 1) {
          break label334;
        }
        bool = true;
        b(bool);
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if ((paramBundle == null) || (!paramBundle.getBoolean("refresh_all_poi"))) {
          break label340;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label319;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.publish.edit.EditVideoPoi", 2, paramJSONObject.toString());
        continue;
        paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c;
        continue;
        a(0, new String[0]);
        return;
      }
      if (i < paramJSONObject.length())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(i)));
        if ((paramInt != 0) && (i == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        }
      }
      else
      {
        if (this.jdField_a_of_type_Xgp != null)
        {
          this.jdField_a_of_type_Xgp.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_Xgp.notifyDataSetChanged();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
            a(1, new String[] { paramJSONObject });
            return;
          }
        }
        a(3, new String[0]);
        return;
        label319:
        i = 0;
        continue;
      }
      i += 1;
      continue;
      label334:
      boolean bool = false;
      continue;
      label340:
      paramInt = 0;
    }
  }
  
  void a(boolean paramBoolean)
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoPoi", "requestSosoPoi");
    a(2, new String[0]);
    if (this.jdField_a_of_type_AndroidViewViewStub != null) {
      new axlk((Activity)this.jdField_a_of_type_AndroidViewViewStub.getContext(), new wwu(this, paramBoolean)).a();
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public boolean a()
  {
    return b();
  }
  
  public void af_()
  {
    i();
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131375536);
    if (paramBoolean)
    {
      localTextView.setText(2131720332);
      return;
    }
    localTextView.setText(2131720327);
  }
  
  protected boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_Wwe.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void f()
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoPoi", "requestPoiList");
    utk localutk = (utk)urr.a(9);
    utj localutj = xnd.a(this.jdField_a_of_type_Wwe.a);
    if (localutj != null) {
      localutk.a(localutj, this.jdField_a_of_type_Utq, this);
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559511, null, false));
    }
    acmr localacmr = new acmr();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localacmr);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new wwt(this));
  }
  
  void i()
  {
    if (this.jdField_a_of_type_Amle != null)
    {
      SosoInterface.b(this.jdField_a_of_type_Amle);
      this.jdField_a_of_type_Amle = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  protected void j()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(a()).inflate(2131559511, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131375534);
      TextView localTextView1 = (TextView)this.d.findViewById(2131375536);
      TextView localTextView2 = (TextView)this.d.findViewById(2131375542);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131375537);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131720327);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeFooterView(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368613: 
      paramView = (www)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramView != null) {
        paramView.a();
      }
      b();
      return;
    case 2131376189: 
    case 2131376213: 
      this.jdField_a_of_type_Wwe.a(4, this.jdField_a_of_type_MqqUtilWeakReference.get());
      return;
    }
    f();
    a(false, true);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (this.jdField_a_of_type_Xgp == null)) {
      return;
    }
    paramView = this.jdField_a_of_type_Wwe;
    if (this.jdField_a_of_type_Wwe.a())
    {
      paramAdapterView = "2";
      paramView.a("change_poi", 0, 0, new String[] { paramAdapterView });
      wtb.a("0X80076D0");
      wtb.b("0X80075E5");
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_Xgp.notifyDataSetChanged();
      paramView = (www)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label190;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c)) {
        break label179;
      }
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
      label139:
      a(1, new String[] { paramAdapterView });
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
    }
    for (;;)
    {
      b();
      return;
      paramAdapterView = "1";
      break;
      label179:
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c;
      break label139;
      label190:
      a(0, new String[0]);
      if (paramView != null) {
        paramView.a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwr
 * JD-Core Version:    0.7.0.1
 */