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

public class vhz
  extends vhk
  implements View.OnClickListener, baic, bfpt, tex
{
  double jdField_a_of_type_Double = 0.0D;
  long jdField_a_of_type_Long = 0L;
  akuo jdField_a_of_type_Akuo;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  WeakReference<vie> jdField_a_of_type_MqqUtilWeakReference;
  tey jdField_a_of_type_Tey = null;
  vrx jdField_a_of_type_Vrx = null;
  double jdField_b_of_type_Double = 0.0D;
  View jdField_b_of_type_AndroidViewView = null;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  ArrayList<TroopBarPOI> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  View c = null;
  View d = null;
  
  public vhz(@NonNull vhm paramvhm)
  {
    super(paramvhm);
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
      aavt localaavt = (aavt)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localaavt != null)
      {
        localaavt.a = false;
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
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368429));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375696);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131375719);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365677));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365678));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368472)).setText(ajya.a(2131703850));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371810));
      g();
      j();
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new via(this));
      this.jdField_a_of_type_Vrx = new vrx(a());
      this.jdField_a_of_type_Vrx.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Vrx);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
  }
  
  public void X_()
  {
    i();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131373349));
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
      } while (!(paramObject instanceof vgl));
      paramObject = (vgl)paramObject;
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramObject.jdField_a_of_type_Vie);
      paramObject = paramObject.jdField_a_of_type_JavaLangString;
      a(this.jdField_b_of_type_JavaUtilArrayList, paramObject);
    } while (this.jdField_a_of_type_Vrx == null);
    this.jdField_a_of_type_Vrx.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    this.jdField_a_of_type_Vrx.notifyDataSetChanged();
  }
  
  public void a(int paramInt, tey paramtey, List<TroopBarPOI> paramList)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult.");
    this.jdField_a_of_type_Tey = paramtey;
    if (!isValidate()) {
      return;
    }
    boolean bool;
    if ((paramInt == 0) && (paramtey != null)) {
      if (!paramtey.a())
      {
        bool = true;
        b(bool);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramList.get(0));
        }
        if ((this.jdField_a_of_type_Tey != null) && (this.jdField_a_of_type_Tey.b())) {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a());
        }
        ved.a("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult, CurrentPOIList : %s , CurrentPOI : %s .", this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_a_of_type_Vrx != null)
        {
          this.jdField_a_of_type_Vrx.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_Vrx.notifyDataSetChanged();
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
        paramtey = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
        label221:
        a(1, new String[] { paramtey });
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      vei.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
      bool = false;
      break;
      label267:
      a(true, false);
      break label193;
      label276:
      paramtey = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c;
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
      if (AppSetting.d) {}
      return;
      a(2131717923);
      continue;
      a(2131717924);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        bcql.a(a(), paramVarArgs[0], 1).a();
        continue;
        a(2131717925);
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
        if (this.jdField_a_of_type_Vrx != null)
        {
          this.jdField_a_of_type_Vrx.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_Vrx.notifyDataSetChanged();
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
    ved.b("Q.qqstory.publish.edit.EditVideoPoi", "requestSosoPoi");
    a(2, new String[0]);
    if (this.jdField_a_of_type_AndroidViewViewStub != null) {
      new avtl((Activity)this.jdField_a_of_type_AndroidViewViewStub.getContext(), new vic(this, paramBoolean)).a();
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
  
  protected void b(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131375055);
    if (paramBoolean)
    {
      localTextView.setText(2131719806);
      return;
    }
    localTextView.setText(2131719801);
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
        this.jdField_a_of_type_Vhm.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void f()
  {
    ved.b("Q.qqstory.publish.edit.EditVideoPoi", "requestPoiList");
    tes localtes = (tes)tcz.a(9);
    ter localter = vyl.a(this.jdField_a_of_type_Vhm.a);
    if (localter != null) {
      localtes.a(localter, this.jdField_a_of_type_Tey, this);
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559459, null, false));
    }
    aavt localaavt = new aavt();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localaavt);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new vib(this));
  }
  
  void i()
  {
    if (this.jdField_a_of_type_Akuo != null)
    {
      SosoInterface.b(this.jdField_a_of_type_Akuo);
      this.jdField_a_of_type_Akuo = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  protected void j()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(a()).inflate(2131559459, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131375053);
      TextView localTextView1 = (TextView)this.d.findViewById(2131375055);
      TextView localTextView2 = (TextView)this.d.findViewById(2131375062);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131375056);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131719801);
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
    case 2131368429: 
      paramView = (vie)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramView != null) {
        paramView.a();
      }
      b();
      return;
    case 2131375696: 
    case 2131375719: 
      this.jdField_a_of_type_Vhm.a(4, this.jdField_a_of_type_MqqUtilWeakReference.get());
      return;
    }
    f();
    a(false, true);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (this.jdField_a_of_type_Vrx == null)) {
      return;
    }
    paramView = this.jdField_a_of_type_Vhm;
    if (this.jdField_a_of_type_Vhm.a())
    {
      paramAdapterView = "2";
      paramView.a("change_poi", 0, 0, new String[] { paramAdapterView });
      vej.a("0X80076D0");
      vej.b("0X80075E5");
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_Vrx.notifyDataSetChanged();
      paramView = (vie)this.jdField_a_of_type_MqqUtilWeakReference.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhz
 * JD-Core Version:    0.7.0.1
 */