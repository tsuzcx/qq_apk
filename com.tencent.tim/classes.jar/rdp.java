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
import com.tencent.mobileqq.activity.contacts.base.Contacts.a;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rdp
  extends rdb
  implements View.OnClickListener, aprb.a, AdapterView.c, pub.c
{
  ViewStub A;
  long BN = 0L;
  WeakReference<rdu> J;
  TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
  rkk jdField_a_of_type_Rkk = null;
  SosoInterface.a jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a;
  pub.d jdField_b_of_type_Pub$d = null;
  double bo = 0.0D;
  double bp = 0.0D;
  PullRefreshHeader d;
  LinearLayout eY;
  LinearLayout eZ;
  public XListView i = null;
  ArrayList<TroopBarPOI> kd = new ArrayList();
  ArrayList<TroopBarPOI> nv = new ArrayList();
  View oJ;
  View oK = null;
  View oL = null;
  View oM = null;
  TextView yq = null;
  
  public rdp(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  private TroopBarPOI a(List<TroopBarPOI> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramList.next();
      if (localTroopBarPOI.name.equals(paramString)) {
        return localTroopBarPOI;
      }
    }
    return null;
  }
  
  private void bsQ()
  {
    if (this.oJ == null)
    {
      this.oJ = this.A.inflate();
      this.yq = ((TextView)this.oJ.findViewById(2131369579));
      this.yq.setOnClickListener(this);
      this.oK = this.oJ.findViewById(2131377804);
      this.oL = this.oJ.findViewById(2131377834);
      this.eY = ((LinearLayout)this.oJ.findViewById(2131366440));
      this.eZ = ((LinearLayout)this.oJ.findViewById(2131366441));
      this.eZ.setOnClickListener(this);
      this.oK.setOnClickListener(this);
      this.oL.setOnClickListener(this);
      ((TextView)this.oJ.findViewById(2131369627)).setText(acfp.m(2131705616));
      this.i = ((XListView)this.oJ.findViewById(2131373455));
      btl();
      btn();
      this.i.setOnScrollListener(new rdq(this));
      this.jdField_a_of_type_Rkk = new rkk(getContext());
      this.jdField_a_of_type_Rkk.a(this.kd, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.i.setAdapter(this.jdField_a_of_type_Rkk);
      this.i.setOnItemClickListener(this);
    }
  }
  
  private void q(List<TroopBarPOI> paramList, String paramString)
  {
    String str = TroopBarPOI.oB(paramString);
    if (paramList != null)
    {
      this.kd.clear();
      this.kd.addAll(paramList);
      paramString = a(this.kd, str);
      paramList = paramString;
      if (paramString == null)
      {
        paramList = new TroopBarPOI("-1", "", str, 0, "", 0, "");
        this.kd.add(paramList);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramList;
      this.kd.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.kd.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    }
  }
  
  private void xd(int paramInt)
  {
    if (this.d != null)
    {
      Contacts.a locala = (Contacts.a)this.d.getTag();
      if (locala != null)
      {
        locala.bpP = false;
        new Handler(Looper.getMainLooper()).postDelayed(new EditVideoPoi.4(this), 800L);
        if (paramInt == 0) {
          this.BN = System.currentTimeMillis();
        }
        this.d.tT(paramInt);
      }
    }
  }
  
  protected boolean Lj()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.oJ != null)
    {
      bool1 = bool2;
      if (this.oJ.getVisibility() == 0)
      {
        this.jdField_b_of_type_Rdc.changeState(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(int paramInt, pub.d paramd, List<TroopBarPOI> paramList)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult.");
    this.jdField_b_of_type_Pub$d = paramd;
    if (!isValidate()) {
      return;
    }
    boolean bool;
    if ((paramInt == 0) && (paramd != null)) {
      if (!paramd.Cz())
      {
        bool = true;
        tG(bool);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramList.get(0));
        }
        if ((this.jdField_b_of_type_Pub$d != null) && (this.jdField_b_of_type_Pub$d.IZ())) {
          this.nv.clear();
        }
        this.nv.addAll(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          q(this.nv, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.AU());
        }
        ram.b("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult, CurrentPOIList : %s , CurrentPOI : %s .", this.kd, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_a_of_type_Rkk != null)
        {
          this.jdField_a_of_type_Rkk.a(this.kd, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_Rkk.notifyDataSetChanged();
          if (!this.kd.isEmpty()) {
            break label267;
          }
          au(false, false);
        }
        label193:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
          break label287;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name)) {
          break label276;
        }
        paramd = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;
        label221:
        d(1, new String[] { paramd });
      }
    }
    for (;;)
    {
      int j = paramInt;
      if (paramInt == 0) {
        j = 0;
      }
      rar.b("edit_video", "poi_list_success", 0, j, new String[0]);
      return;
      bool = false;
      break;
      label267:
      au(true, false);
      break label193;
      label276:
      paramd = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name;
      break label221;
      label287:
      d(0, new String[0]);
      continue;
      d(3, new String[0]);
    }
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
      int j;
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
        tG(bool);
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.kd == null) {
          this.kd = new ArrayList();
        }
        if ((paramBundle == null) || (!paramBundle.getBoolean("refresh_all_poi"))) {
          break label340;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label319;
        }
        this.kd.clear();
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.publish.edit.EditVideoPoi", 2, paramJSONObject.toString());
        continue;
        paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name;
        continue;
        d(0, new String[0]);
        return;
      }
      if (j < paramJSONObject.length())
      {
        this.kd.add(new TroopBarPOI(paramJSONObject.getJSONObject(j)));
        if ((paramInt != 0) && (j == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.kd.get(0));
        }
      }
      else
      {
        if (this.jdField_a_of_type_Rkk != null)
        {
          this.jdField_a_of_type_Rkk.a(this.kd, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_Rkk.notifyDataSetChanged();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;
            d(1, new String[] { paramJSONObject });
            return;
          }
        }
        d(3, new String[0]);
        return;
        label319:
        j = 0;
        continue;
      }
      j += 1;
      continue;
      label334:
      boolean bool = false;
      continue;
      label340:
      paramInt = 0;
    }
  }
  
  void au(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.eZ.setVisibility(4);
      this.eY.setVisibility(4);
      this.i.setVisibility(0);
      return;
    }
    this.i.setVisibility(4);
    if (paramBoolean2)
    {
      this.eZ.setVisibility(4);
      this.eY.setVisibility(0);
      return;
    }
    this.eY.setVisibility(4);
    this.eZ.setVisibility(0);
  }
  
  public void btk()
  {
    ram.d("Q.qqstory.publish.edit.EditVideoPoi", "requestPoiList");
    pub localpub = (pub)psx.a(9);
    pua localpua = rpb.a(this.jdField_b_of_type_Rdc.a);
    if (localpua != null) {
      localpub.a(localpua, this.jdField_b_of_type_Pub$d, this);
    }
  }
  
  protected void btl()
  {
    if (this.d == null) {
      this.d = ((PullRefreshHeader)LayoutInflater.from(getContext()).inflate(2131559847, null, false));
    }
    Contacts.a locala = new Contacts.a();
    this.d.setTag(locala);
    this.i.setOverscrollHeader(null);
    this.i.setOverScrollHeader(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.i.setOverScrollListener(new rdr(this));
  }
  
  void btm()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a != null)
    {
      SosoInterface.c(this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
      this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a = null;
      this.bo = 0.0D;
      this.bp = 0.0D;
    }
  }
  
  protected void btn()
  {
    if (this.oM == null)
    {
      this.oM = LayoutInflater.from(getContext()).inflate(2131559847, null);
      ImageView localImageView = (ImageView)this.oM.findViewById(2131377034);
      TextView localTextView1 = (TextView)this.oM.findViewById(2131377036);
      TextView localTextView2 = (TextView)this.oM.findViewById(2131377043);
      ProgressBar localProgressBar = (ProgressBar)this.oM.findViewById(2131377037);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131720482);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.i.getFooterViewsCount() > 0) {
      this.i.removeFooterView(this.oM);
    }
    this.i.addFooterView(this.oM);
  }
  
  protected void d(int paramInt, String... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {}
      return;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        QQToast.a(getContext(), paramVarArgs[0], 1).show();
        continue;
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || (TextUtils.isEmpty(paramVarArgs[0]))) {
          break;
        }
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          d(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
      }
    }
    d(0, new String[0]);
  }
  
  public boolean onBackPressed()
  {
    return Lj();
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
      rdu localrdu = (rdu)this.J.get();
      if (localrdu != null) {
        localrdu.bsG();
      }
      Lj();
      continue;
      this.jdField_b_of_type_Rdc.r(4, this.J.get());
      continue;
      btk();
      au(false, true);
    }
  }
  
  public void onCreate()
  {
    this.A = ((ViewStub)y(2131375231));
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.kd == null) || (paramInt < 0) || (paramInt >= this.kd.size()) || (this.jdField_a_of_type_Rkk == null)) {
      return;
    }
    paramView = this.jdField_b_of_type_Rdc;
    if (this.jdField_b_of_type_Rdc.La())
    {
      paramAdapterView = "2";
      paramView.c("change_poi", 0, 0, new String[] { paramAdapterView });
      ras.so("0X80076D0");
      ras.sp("0X80075E5");
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.kd.get(paramInt));
      this.jdField_a_of_type_Rkk.notifyDataSetChanged();
      paramView = (rdu)this.J.get();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label190;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name)) {
        break label179;
      }
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;
      label139:
      d(1, new String[] { paramAdapterView });
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
    }
    for (;;)
    {
      Lj();
      return;
      paramAdapterView = "1";
      break;
      label179:
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name;
      break label139;
      label190:
      d(0, new String[0]);
      if (paramView != null) {
        paramView.a(null);
      }
    }
  }
  
  public void onStop()
  {
    btm();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if ((this.oJ != null) && (this.oJ.getVisibility() == 0)) {
        this.oJ.setVisibility(8);
      }
      break;
    }
    do
    {
      do
      {
        return;
        bsQ();
        this.oJ.setVisibility(0);
        tF(true);
      } while (!(paramObject instanceof rcc.e));
      paramObject = (rcc.e)paramObject;
      this.J = new WeakReference(paramObject.b);
      paramObject = paramObject.location;
      q(this.nv, paramObject);
    } while (this.jdField_a_of_type_Rkk == null);
    this.jdField_a_of_type_Rkk.a(this.kd, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    this.jdField_a_of_type_Rkk.notifyDataSetChanged();
  }
  
  void tF(boolean paramBoolean)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoPoi", "requestSosoPoi");
    d(2, new String[0]);
    if (this.A != null) {
      new alxd((Activity)this.A.getContext(), new rds(this, paramBoolean)).Qj();
    }
  }
  
  protected void tG(boolean paramBoolean)
  {
    if (this.oM == null) {
      return;
    }
    TextView localTextView = (TextView)this.oM.findViewById(2131377036);
    if (paramBoolean)
    {
      localTextView.setText(2131720487);
      return;
    }
    localTextView.setText(2131720482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdp
 * JD-Core Version:    0.7.0.1
 */