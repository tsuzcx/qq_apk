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
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class yoj
  extends ynu
  implements View.OnClickListener, bghi, AdapterView.OnItemClickListener, wlq
{
  double jdField_a_of_type_Double = 0.0D;
  long jdField_a_of_type_Long = 0L;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  WeakReference<yoo> jdField_a_of_type_MqqUtilWeakReference;
  wlr jdField_a_of_type_Wlr = null;
  yxx jdField_a_of_type_Yxx = null;
  double jdField_b_of_type_Double = 0.0D;
  View jdField_b_of_type_AndroidViewView = null;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  ArrayList<TroopBarPOI> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  View c = null;
  View d = null;
  
  public yoj(@NonNull ynw paramynw)
  {
    super(paramynw);
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
      ajje localajje = (ajje)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localajje != null)
      {
        localajje.a = false;
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
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369231));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377180);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131377204);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366181));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366182));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369278)).setText(anvx.a(2131703321));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372999));
      h();
      j();
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new yok(this));
      this.jdField_a_of_type_Yxx = new yxx(a());
      this.jdField_a_of_type_Yxx.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Yxx);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
  }
  
  public void T_()
  {
    i();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131374694));
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
      } while (!(paramObject instanceof ymw));
      paramObject = (ymw)paramObject;
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramObject.jdField_a_of_type_Yoo);
      paramObject = paramObject.jdField_a_of_type_JavaLangString;
      a(this.jdField_b_of_type_JavaUtilArrayList, paramObject);
    } while (this.jdField_a_of_type_Yxx == null);
    this.jdField_a_of_type_Yxx.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    this.jdField_a_of_type_Yxx.notifyDataSetChanged();
  }
  
  public void a(int paramInt, wlr paramwlr, List<TroopBarPOI> paramList)
  {
    ykq.b("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult.");
    this.jdField_a_of_type_Wlr = paramwlr;
    if (!isValidate()) {
      return;
    }
    boolean bool;
    if ((paramInt == 0) && (paramwlr != null)) {
      if (!paramwlr.a())
      {
        bool = true;
        b(bool);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramList.get(0));
        }
        if ((this.jdField_a_of_type_Wlr != null) && (this.jdField_a_of_type_Wlr.b())) {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a());
        }
        ykq.a("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult, CurrentPOIList : %s , CurrentPOI : %s .", this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_a_of_type_Yxx != null)
        {
          this.jdField_a_of_type_Yxx.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_Yxx.notifyDataSetChanged();
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
        paramwlr = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
        label221:
        a(1, new String[] { paramwlr });
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      ykv.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
      bool = false;
      break;
      label267:
      a(true, false);
      break label193;
      label276:
      paramwlr = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c;
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
      a(2131717182);
      continue;
      a(2131717183);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        QQToast.a(a(), paramVarArgs[0], 1).a();
        continue;
        a(2131717184);
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
        if (this.jdField_a_of_type_Yxx != null)
        {
          this.jdField_a_of_type_Yxx.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_Yxx.notifyDataSetChanged();
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
    ykq.b("Q.qqstory.publish.edit.EditVideoPoi", "requestSosoPoi");
    a(2, new String[0]);
    if (this.jdField_a_of_type_AndroidViewViewStub != null) {
      new bbhq((Activity)this.jdField_a_of_type_AndroidViewViewStub.getContext(), new yom(this, paramBoolean)).a();
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
    TextView localTextView = (TextView)this.d.findViewById(2131376460);
    if (paramBoolean)
    {
      localTextView.setText(2131719000);
      return;
    }
    localTextView.setText(2131718995);
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
        this.jdField_a_of_type_Ynw.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void g()
  {
    ykq.b("Q.qqstory.publish.edit.EditVideoPoi", "requestPoiList");
    wll localwll = (wll)wjs.a(9);
    wlk localwlk = zeh.a(this.jdField_a_of_type_Ynw.a);
    if (localwlk != null) {
      localwll.a(localwlk, this.jdField_a_of_type_Wlr, this);
    }
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559689, null, false));
    }
    ajje localajje = new ajje();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localajje);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new yol(this));
  }
  
  void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null)
    {
      SosoInterface.removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  protected void j()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(a()).inflate(2131559689, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131376458);
      TextView localTextView1 = (TextView)this.d.findViewById(2131376460);
      TextView localTextView2 = (TextView)this.d.findViewById(2131376466);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131376461);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131718995);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yoo localyoo = (yoo)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localyoo != null) {
        localyoo.a();
      }
      b();
      continue;
      this.jdField_a_of_type_Ynw.a(4, this.jdField_a_of_type_MqqUtilWeakReference.get());
      continue;
      g();
      a(false, true);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (this.jdField_a_of_type_Yxx == null)) {
      return;
    }
    paramView = this.jdField_a_of_type_Ynw;
    if (this.jdField_a_of_type_Ynw.a())
    {
      paramAdapterView = "2";
      paramView.a("change_poi", 0, 0, new String[] { paramAdapterView });
      ykw.a("0X80076D0");
      ykw.b("0X80075E5");
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_Yxx.notifyDataSetChanged();
      paramView = (yoo)this.jdField_a_of_type_MqqUtilWeakReference.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yoj
 * JD-Core Version:    0.7.0.1
 */