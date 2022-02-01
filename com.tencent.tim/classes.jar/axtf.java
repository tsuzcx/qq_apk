import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class axtf
  implements aprb.a, pub.c
{
  WeakReference<ayho> J;
  axtf.a jdField_a_of_type_Axtf$a;
  TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
  EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  SosoInterface.a jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a;
  pub.d jdField_b_of_type_Pub$d = null;
  double bo = 0.0D;
  double bp = 0.0D;
  ArrayList<TroopBarPOI> kd = new ArrayList();
  ArrayList<TroopBarPOI> nv = new ArrayList();
  
  public axtf(axtf.a parama)
  {
    this.jdField_a_of_type_Axtf$a = parama;
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
  
  public ayho a()
  {
    if (this.J != null) {
      return (ayho)this.J.get();
    }
    return null;
  }
  
  public TroopBarPOI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
  }
  
  public void a(int paramInt, pub.d paramd, List<TroopBarPOI> paramList)
  {
    ram.d("FacePoiManager", "onPOIListRequestResult.");
    this.jdField_b_of_type_Pub$d = paramd;
    boolean bool;
    if ((paramInt == 0) && (paramd != null)) {
      if (!paramd.Cz())
      {
        bool = true;
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
        ram.b("FacePoiManager", "onPOIListRequestResult, CurrentPOIList : %s , CurrentPOI : %s .", this.kd, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        this.jdField_a_of_type_Axtf$a.a(true, bool, this.kd, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      rar.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Axtf$a.a(false, false, null, null);
    }
  }
  
  public void a(ayho paramayho, String paramString)
  {
    this.J = new WeakReference(paramayho);
    q(this.nv, paramString);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((3 != paramInt) || (paramJSONObject != null)) {}
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
          break label244;
        }
        bool = true;
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.kd == null) {
          this.kd = new ArrayList();
        }
        if ((paramBundle == null) || (!paramBundle.getBoolean("refresh_all_poi"))) {
          break label250;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label229;
        }
        this.kd.clear();
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FacePoiManager", 2, paramJSONObject.toString());
        return;
      }
      if (i < paramJSONObject.length())
      {
        this.kd.add(new TroopBarPOI(paramJSONObject.getJSONObject(i)));
        if ((paramInt != 0) && (i == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.kd.get(0));
        }
      }
      else
      {
        this.jdField_a_of_type_Axtf$a.a(true, bool, this.kd, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        return;
        this.jdField_a_of_type_Axtf$a.a(false, false, null, null);
        return;
        label229:
        i = 0;
        continue;
      }
      i += 1;
      continue;
      label244:
      boolean bool = false;
      continue;
      label250:
      paramInt = 0;
    }
  }
  
  public void b(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramTroopBarPOI;
  }
  
  public void bmN()
  {
    if (this.jdField_b_of_type_Pub$d != null) {
      this.jdField_b_of_type_Pub$d.bmN();
    }
  }
  
  public void btk()
  {
    ram.d("FacePoiManager", "requestPoiList");
    pub localpub = (pub)psx.a(9);
    pua localpua = pub.a();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {
      localpua = rpb.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    }
    if (localpua != null) {
      localpub.a(localpua, this.jdField_b_of_type_Pub$d, this);
    }
  }
  
  public void btm()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a != null)
    {
      SosoInterface.c(this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
      this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a = null;
      this.bo = 0.0D;
      this.bp = 0.0D;
    }
  }
  
  public void d(boolean paramBoolean, Activity paramActivity)
  {
    ram.d("FacePoiManager", "requestSosoPoi");
    this.jdField_a_of_type_Axtf$a.d(2, new String[0]);
    new alxd(paramActivity, new axtg(this, paramBoolean)).Qj();
  }
  
  public ArrayList<TroopBarPOI> eL()
  {
    return this.kd;
  }
  
  public void onCancel()
  {
    if (this.J != null)
    {
      ayho localayho = (ayho)this.J.get();
      if (localayho != null) {
        localayho.bsG();
      }
    }
  }
  
  public boolean os(int paramInt)
  {
    return (this.kd == null) || (paramInt < 0) || (paramInt >= this.kd.size());
  }
  
  public void q(List<TroopBarPOI> paramList, String paramString)
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
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<TroopBarPOI> paramArrayList, TroopBarPOI paramTroopBarPOI);
    
    public abstract void d(int paramInt, String... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtf
 * JD-Core Version:    0.7.0.1
 */