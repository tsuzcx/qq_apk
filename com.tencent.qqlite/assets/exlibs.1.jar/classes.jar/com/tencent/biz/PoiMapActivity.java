package com.tencent.biz;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import js;
import jt;
import ju;
import jv;
import jw;
import jx;
import jz;
import ka;
import kb;
import kc;
import kd;
import ke;
import ki;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiMapActivity
  extends QQMapActivity
  implements View.OnClickListener
{
  protected float a;
  protected int a;
  public View.OnClickListener a;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new ke(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new js(this);
  protected View a;
  public EditText a;
  public ImageButton a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  protected TextView a;
  protected AuthorizeConfig a;
  protected PoiMapActivity.PoiMapNameTask a;
  PoiMapActivity.SearchResultAdapter jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new jt(this);
  public XListView a;
  public final String a;
  public List a;
  public boolean a;
  public PoiMapActivity.PoiTab[] a;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "全部", "写字楼", "小区", "商家" };
  protected int b;
  protected View b;
  protected RelativeLayout b;
  public String b;
  protected boolean b;
  public String[] b;
  protected int c;
  protected View c;
  public String c;
  public boolean c;
  public int d;
  View d;
  protected String d;
  public boolean d;
  public int e;
  protected View e;
  public boolean e;
  public int f;
  protected boolean f;
  protected final int g;
  public boolean g;
  public int h;
  
  public PoiMapActivity()
  {
    this.jdField_a_of_type_JavaLangString = "PoiMapActivity";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 20;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new jv(this);
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298562));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297520);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131298576);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131298571);
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    Object localObject = super.findViewById(2131298566);
    ((View)localObject).setContentDescription(getString(2131362644));
    ((View)localObject).setVisibility(0);
    ((View)localObject).setOnClickListener(this);
    if (this.jdField_h_of_type_Boolean)
    {
      a("rec_locate", "pageview_all", "", "", "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.findViewById(2131297243).setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.findViewById(2131297244).setVisibility(0);
      ((View)localObject).setVisibility(8);
      if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_o_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoAnchor(2);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewView = super.findViewById(2131296934);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298577));
      localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131297962);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      return;
      a("share_locate", "pageview_all", "", "", "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131298430).setVisibility(8);
      g();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab == null) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length)) {
      return;
    }
    this.jdField_f_of_type_Int = paramInt;
    int j = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i = 0;
    label30:
    if (i < j)
    {
      if (i != paramInt) {
        break label67;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i].a(true);
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i].b(true);
    }
    for (;;)
    {
      i += 1;
      break label30;
      break;
      label67:
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i].a(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareSearch");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("category", paramString2);
    localIntent.putExtra("page", paramInt3);
    localIntent.putExtra("count", paramInt4);
    localIntent.putExtra("coordinate", 1);
    if ((paramInt3 == 0) && (TextUtils.isEmpty(paramString1))) {
      if (TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra("requireMyLbs", 1);
      }
    }
    for (;;)
    {
      super.sendBroadcast(localIntent);
      return;
      localIntent.putExtra("requireMyLbs", 0);
    }
  }
  
  public void a(PoiMapActivity.POI paramPOI)
  {
    this.p = paramPOI.jdField_b_of_type_JavaLangString;
    this.jdField_o_of_type_JavaLangString = paramPOI.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_Int = paramPOI.jdField_a_of_type_Int;
    this.jdField_e_of_type_Int = paramPOI.jdField_b_of_type_Int;
    this.q = paramPOI.f;
    this.jdField_b_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_b_of_type_Boolean = true;
    int j = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i = 0;
    if (i < j)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i].a(-1, false);
      }
    }
    a(0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(new GeoPoint(paramPOI.jdField_a_of_type_Int, paramPOI.jdField_b_of_type_Int));
  }
  
  protected void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle)
  {
    if (paramLocationResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch null");
      }
      return;
    }
    int i1 = paramLocationResp.ec.get();
    boolean bool1;
    String str1;
    int k;
    int m;
    int n;
    String str2;
    int i;
    ArrayList localArrayList;
    if (paramLocationResp.is_foreign.get() == 1)
    {
      bool1 = true;
      this.jdField_g_of_type_Boolean = bool1;
      str1 = paramBundle.getString("keyword");
      k = paramBundle.getInt("latitude");
      m = paramBundle.getInt("longitude");
      n = paramBundle.getInt("page");
      str2 = paramBundle.getString("category");
      bool1 = false;
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch error:" + i1);
        }
        QQToast.a(this, super.getString(2131364329), 0).a();
      }
      i = 0;
      j = 0;
      paramBundle = null;
      if (i1 != 0) {
        break label1288;
      }
      localArrayList = new ArrayList();
      if (!this.jdField_g_of_type_Boolean) {
        break label852;
      }
      paramBundle = new GeoPoint(k, m);
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask != null) {
        break label716;
      }
    }
    for (;;)
    {
      PoiMapActivity.POI localPOI;
      try
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = new PoiMapActivity.PoiMapNameTask(this);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a(paramBundle);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
        paramBundle = new PoiMapActivity.POI(this);
        paramBundle.jdField_a_of_type_JavaLangString = super.getResources().getString(2131364335);
        paramBundle.jdField_b_of_type_JavaLangString = "";
        this.p = paramBundle.jdField_b_of_type_JavaLangString;
        paramBundle.jdField_a_of_type_Int = k;
        paramBundle.jdField_b_of_type_Int = m;
        paramBundle.jdField_d_of_type_JavaLangString = "";
        localArrayList.add(paramBundle);
        i = 1;
        if (!paramLocationResp.poilist.has()) {
          break label1209;
        }
        paramBundle = paramLocationResp.poilist.get();
        if (paramBundle.size() <= 0) {
          break label1153;
        }
        i = 1;
        bool1 = true;
        localObject = paramBundle.iterator();
        j = i;
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break label1215;
        }
        LBSShare.POI localPOI1 = (LBSShare.POI)((Iterator)localObject).next();
        localPOI = new PoiMapActivity.POI(this);
        if (!localPOI1.name.has()) {
          break label1161;
        }
        paramBundle = localPOI1.name.get();
        localPOI.jdField_a_of_type_JavaLangString = paramBundle;
        if (!localPOI1.shop_url.has()) {
          break label1167;
        }
        paramBundle = localPOI1.shop_url.get();
        localPOI.jdField_d_of_type_JavaLangString = paramBundle;
        if (!TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) {
          a("share_locate", "view_share_tuan", "", "", "", "");
        }
        if (!localPOI1.addr.has()) {
          break label1173;
        }
        paramBundle = localPOI1.addr.get();
        localPOI.jdField_b_of_type_JavaLangString = paramBundle;
        if (!localPOI1.lat.has()) {
          break label1179;
        }
        j = localPOI1.lat.get();
        localPOI.jdField_a_of_type_Int = j;
        if (!localPOI1.lng.has()) {
          break label1185;
        }
        j = localPOI1.lng.get();
        localPOI.jdField_b_of_type_Int = j;
        if (!localPOI1.id.has()) {
          break label1191;
        }
        paramBundle = localPOI1.id.get();
        localPOI.jdField_c_of_type_JavaLangString = paramBundle;
        if (!localPOI1.shop_url_quan.has()) {
          break label1197;
        }
        paramBundle = localPOI1.shop_url_quan.get();
        localPOI.e = paramBundle;
        if ((TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(localPOI.e))) {
          a("share_locate", "view_quan", "", "", "", "");
        }
        if (!localPOI1.dpid.has()) {
          break label1203;
        }
        paramBundle = localPOI1.dpid.get();
        localPOI.f = paramBundle;
        if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals(localPOI.jdField_c_of_type_JavaLangString))) {
          continue;
        }
        localArrayList.add(localPOI);
        continue;
        bool1 = false;
      }
      catch (RejectedExecutionException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
        continue;
      }
      label716:
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a = paramBundle;
      Object localObject = ((ThreadPoolExecutor)PoiMapActivity.PoiMapNameTask.THREAD_POOL_EXECUTOR).getQueue();
      if ((localObject != null) && (((BlockingQueue)localObject).size() > 0)) {
        ((BlockingQueue)localObject).removeAll((Collection)localObject);
      }
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.getStatus() != AsyncTask.Status.FINISHED)
      {
        if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.isCancelled()) {
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.cancel(true);
        }
      }
      else
      {
        try
        {
          localObject = new PoiMapActivity.PoiMapNameTask(this);
          ((PoiMapActivity.PoiMapNameTask)localObject).a(paramBundle);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = ((PoiMapActivity.PoiMapNameTask)localObject);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
        }
        catch (RejectedExecutionException paramBundle) {}
        if (QLog.isColorLevel())
        {
          QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
          continue;
          label852:
          i = j;
          if (paramLocationResp.mylbs.has())
          {
            localObject = (LBSShare.POI)paramLocationResp.mylbs.get();
            localPOI = new PoiMapActivity.POI(this);
            if (((LBSShare.POI)localObject).name.has())
            {
              paramBundle = ((LBSShare.POI)localObject).name.get();
              label907:
              localPOI.jdField_a_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).shop_url.has()) {
                break label1104;
              }
              paramBundle = ((LBSShare.POI)localObject).shop_url.get();
              label933:
              localPOI.jdField_d_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).addr.has()) {
                break label1110;
              }
              paramBundle = ((LBSShare.POI)localObject).addr.get();
              label959:
              localPOI.jdField_b_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).lat.has()) {
                break label1116;
              }
              i = ((LBSShare.POI)localObject).lat.get();
              label985:
              localPOI.jdField_a_of_type_Int = i;
              if (!((LBSShare.POI)localObject).lng.has()) {
                break label1121;
              }
              i = ((LBSShare.POI)localObject).lng.get();
              label1011:
              localPOI.jdField_b_of_type_Int = i;
              if ((!this.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))) {
                break label1126;
              }
              localPOI.jdField_a_of_type_JavaLangString = this.jdField_o_of_type_JavaLangString;
              localPOI.jdField_d_of_type_JavaLangString = "";
              localPOI.jdField_b_of_type_JavaLangString = this.p;
              localPOI.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
              localPOI.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
            }
            for (;;)
            {
              localArrayList.add(localPOI);
              i = 1;
              break;
              paramBundle = super.getResources().getString(2131364335);
              break label907;
              label1104:
              paramBundle = "";
              break label933;
              label1110:
              paramBundle = "";
              break label959;
              label1116:
              i = 0;
              break label985;
              label1121:
              i = 0;
              break label1011;
              label1126:
              localPOI.jdField_a_of_type_JavaLangString = super.getResources().getString(2131364335);
              this.p = localPOI.jdField_b_of_type_JavaLangString;
            }
            label1153:
            i = 0;
            bool1 = false;
            continue;
            label1161:
            paramBundle = "";
            continue;
            label1167:
            paramBundle = "";
            continue;
            label1173:
            paramBundle = "";
            continue;
            label1179:
            j = 0;
            continue;
            label1185:
            j = 0;
            continue;
            label1191:
            paramBundle = "";
            continue;
            label1197:
            paramBundle = "";
            continue;
            label1203:
            paramBundle = "";
          }
        }
      }
    }
    label1209:
    boolean bool2 = false;
    int j = i;
    label1215:
    if (paramLocationResp.next.has())
    {
      i = paramLocationResp.next.get();
      paramLocationResp = localArrayList;
      bool1 = bool2;
    }
    for (;;)
    {
      if (j == 0) {}
      for (bool2 = true;; bool2 = false)
      {
        runOnUiThread(new ju(this, bool1, str2, str1, paramLocationResp, i, k, m, n, bool2));
        return;
        i = 0;
        break;
      }
      label1288:
      j = 0;
      paramLocationResp = paramBundle;
    }
  }
  
  protected void a(GeoPoint paramGeoPoint)
  {
    int i = paramGeoPoint.getLatitudeE6();
    int j = paramGeoPoint.getLongitudeE6();
    super.a(paramGeoPoint);
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "lat=" + i + ", lon=" + j);
    }
    this.jdField_o_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = i;
    this.jdField_e_of_type_Int = j;
    this.jdField_b_of_type_Boolean = false;
    j = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    i = 0;
    if (i < j)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean = false;
        if (this.jdField_f_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(-1, false);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
        continue;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i].a(-1, true);
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.jdField_f_of_type_Int].b(true);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131364328));
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_h_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, paramString, "", 0, 20);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void a(String paramString, List paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_c_of_type_Boolean = paramBoolean;
      this.jdField_e_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label150;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363165));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
      if (this.jdField_h_of_type_Int == 0) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        a("share_locate", "click_sch", paramString, "0", "", "");
        break;
      }
      a("share_locate", "click_sch", paramString, "1", "", "");
      break;
      label150:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_Int != paramInt1) && (this.jdField_e_of_type_Int != paramInt2)) {}
    label130:
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          break label130;
        }
        if (this.jdField_b_of_type_ArrayOfJavaLangString[paramInt1].equals(paramString))
        {
          paramString = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[paramInt1];
          if (paramInt3 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramString.a(paramArrayList, bool, paramInt4, paramBoolean);
            if ((paramInt1 != 0) || (!this.jdField_f_of_type_Boolean)) {
              break;
            }
            if ((paramArrayList == null) || (paramArrayList.size() <= 1)) {
              break label113;
            }
            this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(1, true);
            return;
          }
          label113:
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, true);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void b()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    int i = this.jdField_d_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130903613);
    Object localObject = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject).setDuration(300L);
    jw localjw = new jw(this, localTranslateAnimation, localDialog, i, (TranslateAnimation)localObject);
    localTranslateAnimation.setAnimationListener(localjw);
    ((TranslateAnimation)localObject).setAnimationListener(localjw);
    localDialog.setOnDismissListener(new jx(this, (TranslateAnimation)localObject, localInputMethodManager));
    this.jdField_e_of_type_AndroidViewView = localDialog.findViewById(2131296567);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131297962));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ki(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131297955));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new jz(this));
    ((Button)localDialog.findViewById(2131298430)).setOnClickListener(new ka(this, localDialog));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131296868));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131296866));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new kb(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131298730));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(super.getResources().getDrawable(2130837660));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter = new PoiMapActivity.SearchResultAdapter(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new kc(this, localInputMethodManager));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new kd(this, localDialog));
    if (1 == OfflineDownloader.a(getApplicationContext())) {}
    for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  protected void c()
  {
    a("share_locate", "click_rec_return", "", "", "", "");
  }
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    double d1 = ((GeoPoint)localObject).getLatitudeE6() / 1000000.0D;
    double d2 = ((GeoPoint)localObject).getLongitudeE6() / 1000000.0D;
    String str2 = String.valueOf(d1) + "," + String.valueOf(d2);
    String str3;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = "0";
      str3 = this.jdField_f_of_type_Int + 1 + "";
      if (!this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.jdField_f_of_type_Int].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean) {
        break label195;
      }
    }
    label195:
    for (String str1 = "2";; str1 = "1")
    {
      a("share_locate", "click_send", str2, (String)localObject, str3, str1);
      if (this.jdField_g_of_type_Boolean)
      {
        a("rec_locate", "send_googlestation", "", "", "", "");
        a("rec_locate", "send_foursquare", "", "", "", "");
      }
      return;
      localObject = this.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  protected void e()
  {
    a("rec_locate", "click_view", "", "", "", "");
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("poi_category", "");
    Object localObject1;
    String[] arrayOfString;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = null;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          try
          {
            int j;
            localObject3 = localObject1.getJSONObject(i);
            str = ((JSONObject)localObject3).getString("name");
            localObject3 = ((JSONObject)localObject3).getString("id");
            localObject2[i] = str;
            arrayOfString[i] = localObject3;
            i += 1;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            i = 1;
          }
          localJSONException2 = localJSONException2;
          localJSONException2.printStackTrace();
        }
      }
      if ((localObject1 != null) && (localObject1.length() > 0))
      {
        j = localObject1.length();
        localObject2 = new String[j];
        arrayOfString = new String[j];
        i = 0;
        if (i >= j) {
          break label198;
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      String str;
      if (i == 0)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = localJSONException2;
        this.jdField_b_of_type_ArrayOfJavaLangString = arrayOfString;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabName:" + this.jdField_a_of_type_ArrayOfJavaLangString.toString());
      }
      return;
      label198:
      i = 0;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131298578));
    if (this.jdField_o_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.k.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (FrameLayout)super.findViewById(2131298579);
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab = new PoiMapActivity.PoiTab[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.weight = 1.0F;
    int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int i = 0;
    while (i < j)
    {
      PoiMapActivity.PoiTab localPoiTab = new PoiMapActivity.PoiTab(this, this, this.jdField_a_of_type_ArrayOfJavaLangString[i], i);
      if (i == 0)
      {
        localPoiTab.a(true);
        localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Int = 0;
      }
      if (i == j - 1) {
        localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.a();
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i] = localPoiTab;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView, localLayoutParams1);
      ((FrameLayout)localObject).addView(localPoiTab.jdField_a_of_type_ComTencentWidgetXListView, localLayoutParams2);
      i += 1;
    }
  }
  
  protected void h()
  {
    super.h();
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    q();
    if (this.jdField_h_of_type_Boolean)
    {
      a("rec_locate", "click_locate_rec", "", "", "", "");
      return;
    }
    a("share_locate", "click_locate_share", "", "", "", "");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Int = super.getResources().getColor(2131427497);
    this.jdField_b_of_type_Int = super.getResources().getColor(2131427469);
    this.jdField_c_of_type_Int = Color.rgb(0, 121, 255);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    f();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity
 * JD-Core Version:    0.7.0.1
 */