package com.tencent.biz;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.view.animation.Animation;
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
import bmn;
import bmo;
import bmp;
import bmq;
import bmr;
import bms;
import bmt;
import bmu;
import bmv;
import bmw;
import bmx;
import bmy;
import bna;
import bnb;
import bnc;
import bnd;
import bne;
import bni;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.DPBiz;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.proto.lbsshare.LBSShare.Shop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new bmo(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bmw(this);
  protected View a;
  public EditText a;
  public ImageButton a;
  public ImageView a;
  public RelativeLayout a;
  protected TextView a;
  protected AuthorizeConfig a;
  PoiMapActivity.SearchResultAdapter jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter;
  public PoiMapActivity.ShopListAdapter a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new bmp(this);
  protected XListView a;
  public final String a;
  public List a;
  public boolean a;
  public PoiMapActivity.PoiTab[] a;
  public String[] a;
  protected int b;
  protected View b;
  protected RelativeLayout b;
  protected TextView b;
  public XListView b;
  public String b;
  public boolean b;
  String[] b;
  protected int c;
  protected View c;
  public String c;
  protected boolean c;
  public int d;
  public View d;
  protected String d;
  public boolean d;
  public int e;
  protected View e;
  public boolean e;
  public int f;
  View f;
  public boolean f;
  protected final int g;
  protected View g;
  protected boolean g;
  protected final int h;
  public int i = 0;
  public int j;
  public int k;
  
  public PoiMapActivity()
  {
    this.jdField_a_of_type_JavaLangString = "PoiMapActivity";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 10;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 20;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bmr(this);
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "全部", "写字楼", "小区", "商家" };
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131233239));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131230947);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131233257);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131233247);
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    Object localObject = super.findViewById(2131233242);
    ((View)localObject).setOnClickListener(this);
    if (this.jdField_h_of_type_Boolean)
    {
      a("rec_locate", "pageview_all", "", "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_h_of_type_AndroidViewView.findViewById(2131231872).setVisibility(0);
      this.jdField_h_of_type_AndroidViewView.findViewById(2131231873).setVisibility(0);
      ((View)localObject).setVisibility(8);
      if ((this.jdField_f_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_o_of_type_JavaLangString);
      }
      i();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setOnTouchListener(new bmn(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLogoAnchor(2);
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidViewView = super.findViewById(2131230941);
      super.findViewById(2131233084).setVisibility(8);
      localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131233085);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      localObject = (ImageView)super.findViewById(2131231458);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      return;
      a("share_locate", "pageview_all", "", "", "");
      g();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab == null) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length)) {
      return;
    }
    this.jdField_f_of_type_Int = paramInt;
    int n = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int m = 0;
    label30:
    if (m < n)
    {
      if (m != paramInt) {
        break label67;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[m].a(true);
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[m].b(true);
    }
    for (;;)
    {
      m += 1;
      break label30;
      break;
      label67:
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[m].a(false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareShop");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("coordinate", 0);
    localIntent.putExtra("begin", paramInt3);
    localIntent.putExtra("count", paramInt4);
    super.sendBroadcast(localIntent);
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
    this.jdField_c_of_type_Boolean = true;
    int n = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int m = 0;
    if (m < n)
    {
      if (m == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
      }
      for (;;)
      {
        m += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[m].a(-1, false);
      }
    }
    a(0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(new GeoPoint(paramPOI.jdField_a_of_type_Int, paramPOI.jdField_b_of_type_Int));
  }
  
  protected void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp)
  {
    if (paramGetShopsByIdsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetShareShopDetail null");
      }
    }
    int m;
    label122:
    label252:
    do
    {
      do
      {
        return;
        m = paramGetShopsByIdsResp.ec.get();
        if (m != 0) {
          break;
        }
      } while (!paramGetShopsByIdsResp.shops.has());
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramGetShopsByIdsResp.shops.get().iterator();
      if (localIterator.hasNext())
      {
        LBSShare.DPBiz localDPBiz = (LBSShare.DPBiz)localIterator.next();
        PoiMapActivity.SingleShops localSingleShops = new PoiMapActivity.SingleShops(this);
        localSingleShops.jdField_a_of_type_Int = 1;
        if (localDPBiz.id.has())
        {
          paramGetShopsByIdsResp = localDPBiz.id.get();
          localSingleShops.h = paramGetShopsByIdsResp;
          if (!localDPBiz.name.has()) {
            break label378;
          }
          paramGetShopsByIdsResp = localDPBiz.name.get();
          localSingleShops.e = paramGetShopsByIdsResp;
          if (!localDPBiz.logo.has()) {
            break label384;
          }
          paramGetShopsByIdsResp = localDPBiz.logo.get();
          localSingleShops.f = paramGetShopsByIdsResp;
          if (!localDPBiz.url.has()) {
            break label390;
          }
          paramGetShopsByIdsResp = localDPBiz.url.get();
          localSingleShops.g = paramGetShopsByIdsResp;
          if (!localDPBiz.avg_price.has()) {
            break label396;
          }
          paramGetShopsByIdsResp = localDPBiz.avg_price.get();
          localSingleShops.jdField_b_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.biz_zone.has()) {
            break label402;
          }
          paramGetShopsByIdsResp = localDPBiz.biz_zone.get();
          localSingleShops.jdField_c_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.category.has()) {
            break label408;
          }
          paramGetShopsByIdsResp = localDPBiz.category.get();
          localSingleShops.jdField_a_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.has_quan.has()) {
            break label414;
          }
          m = localDPBiz.has_quan.get();
          localSingleShops.jdField_c_of_type_Int = m;
          if (!localDPBiz.has_tuan.has()) {
            break label419;
          }
          m = localDPBiz.has_tuan.get();
          localSingleShops.jdField_b_of_type_Int = m;
          if (!localDPBiz.rate.has()) {
            break label424;
          }
        }
        for (m = localDPBiz.rate.get();; m = 0)
        {
          localSingleShops.jdField_d_of_type_Int = m;
          localArrayList.add(localSingleShops);
          break;
          paramGetShopsByIdsResp = "";
          break label122;
          paramGetShopsByIdsResp = "";
          break label148;
          paramGetShopsByIdsResp = "";
          break label174;
          paramGetShopsByIdsResp = "";
          break label200;
          paramGetShopsByIdsResp = "";
          break label226;
          paramGetShopsByIdsResp = "";
          break label252;
          paramGetShopsByIdsResp = "";
          break label278;
          m = 0;
          break label304;
          m = 0;
          break label330;
        }
      }
      a(localArrayList);
      return;
    } while (!QLog.isColorLevel());
    label148:
    label174:
    label200:
    label226:
    label378:
    QLog.i("PoiMapActivity", 2, "onGetShareShopDetail error:" + m);
    label278:
    label304:
    label330:
    return;
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
    int i4 = paramLocationResp.ec.get();
    String str1 = paramBundle.getString("keyword");
    int i1 = paramBundle.getInt("latitude");
    int i2 = paramBundle.getInt("longitude");
    int i3 = paramBundle.getInt("page");
    String str2 = paramBundle.getString("category");
    if (i4 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch error:" + i4);
      }
      QQToast.a(this, super.getString(2131562066), 0).a();
    }
    int m = 0;
    int n = 0;
    paramBundle = null;
    ArrayList localArrayList;
    if (i4 == 0)
    {
      localArrayList = new ArrayList();
      m = n;
      Object localObject;
      PoiMapActivity.POI localPOI;
      label227:
      label253:
      LBSShare.POI localPOI1;
      if (paramLocationResp.mylbs.has())
      {
        localObject = (LBSShare.POI)paramLocationResp.mylbs.get();
        localPOI = new PoiMapActivity.POI(this);
        if (((LBSShare.POI)localObject).name.has())
        {
          paramBundle = ((LBSShare.POI)localObject).name.get();
          localPOI.jdField_a_of_type_JavaLangString = paramBundle;
          if (!((LBSShare.POI)localObject).shop_url.has()) {
            break label785;
          }
          paramBundle = ((LBSShare.POI)localObject).shop_url.get();
          localPOI.jdField_d_of_type_JavaLangString = paramBundle;
          if (!((LBSShare.POI)localObject).addr.has()) {
            break label791;
          }
          paramBundle = ((LBSShare.POI)localObject).addr.get();
          localPOI.jdField_b_of_type_JavaLangString = paramBundle;
          if (!((LBSShare.POI)localObject).lat.has()) {
            break label797;
          }
          m = ((LBSShare.POI)localObject).lat.get();
          label279:
          localPOI.jdField_a_of_type_Int = m;
          if (!((LBSShare.POI)localObject).lng.has()) {
            break label802;
          }
          m = ((LBSShare.POI)localObject).lng.get();
          label305:
          localPOI.jdField_b_of_type_Int = m;
          if ((!this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))) {
            break label807;
          }
          localPOI.jdField_a_of_type_JavaLangString = this.jdField_o_of_type_JavaLangString;
          localPOI.jdField_d_of_type_JavaLangString = "";
          localPOI.jdField_b_of_type_JavaLangString = this.p;
          localPOI.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
          localPOI.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
          label371:
          localArrayList.add(localPOI);
          m = 1;
        }
      }
      else
      {
        if (!paramLocationResp.poilist.has()) {
          break label882;
        }
        paramBundle = paramLocationResp.poilist.get();
        if (paramBundle.size() <= 0) {
          break label952;
        }
        m = 1;
        localObject = paramBundle.iterator();
        label418:
        n = m;
        if (!((Iterator)localObject).hasNext()) {
          break label885;
        }
        localPOI1 = (LBSShare.POI)((Iterator)localObject).next();
        localPOI = new PoiMapActivity.POI(this);
        if (!localPOI1.name.has()) {
          break label834;
        }
        paramBundle = localPOI1.name.get();
        label473:
        localPOI.jdField_a_of_type_JavaLangString = paramBundle;
        if (!localPOI1.shop_url.has()) {
          break label840;
        }
        paramBundle = localPOI1.shop_url.get();
        label499:
        localPOI.jdField_d_of_type_JavaLangString = paramBundle;
        if (!TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) {
          a("share_locate", "view_share_tuan", "", "", "");
        }
        if (!localPOI1.addr.has()) {
          break label846;
        }
        paramBundle = localPOI1.addr.get();
        label551:
        localPOI.jdField_b_of_type_JavaLangString = paramBundle;
        if (!localPOI1.lat.has()) {
          break label852;
        }
        n = localPOI1.lat.get();
        label578:
        localPOI.jdField_a_of_type_Int = n;
        if (!localPOI1.lng.has()) {
          break label858;
        }
        n = localPOI1.lng.get();
        label606:
        localPOI.jdField_b_of_type_Int = n;
        if (!localPOI1.id.has()) {
          break label864;
        }
        paramBundle = localPOI1.id.get();
        label633:
        localPOI.jdField_c_of_type_JavaLangString = paramBundle;
        if (!localPOI1.shop_url_quan.has()) {
          break label870;
        }
        paramBundle = localPOI1.shop_url_quan.get();
        label659:
        localPOI.e = paramBundle;
        if ((TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(localPOI.e))) {
          a("share_locate", "view_quan", "", "", "");
        }
        if (!localPOI1.dpid.has()) {
          break label876;
        }
      }
      label785:
      label791:
      label797:
      label802:
      label807:
      label834:
      label840:
      label846:
      label852:
      label858:
      label864:
      label870:
      label876:
      for (paramBundle = localPOI1.dpid.get();; paramBundle = "")
      {
        localPOI.f = paramBundle;
        if ((this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals(localPOI.jdField_c_of_type_JavaLangString))) {
          break label418;
        }
        localArrayList.add(localPOI);
        break label418;
        paramBundle = super.getResources().getString(2131561545);
        break;
        paramBundle = "";
        break label227;
        paramBundle = "";
        break label253;
        m = 0;
        break label279;
        m = 0;
        break label305;
        localPOI.jdField_a_of_type_JavaLangString = super.getResources().getString(2131561545);
        this.p = localPOI.jdField_b_of_type_JavaLangString;
        break label371;
        paramBundle = "";
        break label473;
        paramBundle = "";
        break label499;
        paramBundle = "";
        break label551;
        n = 0;
        break label578;
        n = 0;
        break label606;
        paramBundle = "";
        break label633;
        paramBundle = "";
        break label659;
      }
      label882:
      n = m;
      label885:
      if (paramLocationResp.next.has()) {
        m = paramLocationResp.next.get();
      }
    }
    for (paramLocationResp = localArrayList;; paramLocationResp = paramBundle)
    {
      if (n == 0) {}
      for (boolean bool = true;; bool = false)
      {
        runOnUiThread(new bmq(this, str1, paramLocationResp, m, i1, i2, str2, i3, bool));
        return;
        m = 0;
        break;
      }
      label952:
      break;
      n = 0;
    }
  }
  
  protected void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle)
  {
    if (paramNearByShopsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareShop null");
      }
    }
    int m;
    label79:
    label113:
    label249:
    label380:
    do
    {
      return;
      m = paramNearByShopsResp.ec.get();
      if (m == 0)
      {
        int i2 = paramBundle.getInt("begin", 0);
        int n;
        LBSShare.Shop localShop;
        PoiMapActivity.GeneralShops localGeneralShops;
        if (paramNearByShopsResp.next_begin.has())
        {
          m = paramNearByShopsResp.next_begin.get();
          if (!paramNearByShopsResp.total.has()) {
            break label430;
          }
          n = paramNearByShopsResp.total.get();
          paramBundle = null;
          if (!paramNearByShopsResp.poilist.has()) {
            break label496;
          }
          paramBundle = new ArrayList();
          Iterator localIterator = paramNearByShopsResp.poilist.get().iterator();
          if (!localIterator.hasNext()) {
            break label496;
          }
          localShop = (LBSShare.Shop)localIterator.next();
          localGeneralShops = new PoiMapActivity.GeneralShops(this);
          localGeneralShops.jdField_a_of_type_Int = 1;
          if (!localShop.id.has()) {
            break label436;
          }
          paramNearByShopsResp = localShop.id.get();
          localGeneralShops.h = paramNearByShopsResp;
          if (!localShop.name.has()) {
            break label442;
          }
          paramNearByShopsResp = localShop.name.get();
          localGeneralShops.e = paramNearByShopsResp;
          if (!localShop.logo.has()) {
            break label448;
          }
          paramNearByShopsResp = localShop.logo.get();
          localGeneralShops.f = paramNearByShopsResp;
          if (!localShop.url.has()) {
            break label454;
          }
          paramNearByShopsResp = localShop.url.get();
          localGeneralShops.g = paramNearByShopsResp;
          if (!localShop.detail.has()) {
            break label460;
          }
          paramNearByShopsResp = localShop.detail.get();
          localGeneralShops.jdField_a_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.discount.has()) {
            break label466;
          }
          paramNearByShopsResp = localShop.discount.get();
          localGeneralShops.jdField_b_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.price.has()) {
            break label472;
          }
          paramNearByShopsResp = localShop.price.get();
          localGeneralShops.jdField_c_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.soldnum.has()) {
            break label478;
          }
          paramNearByShopsResp = localShop.soldnum.get();
          localGeneralShops.jdField_d_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.has_tuan.has()) {
            break label484;
          }
          i1 = localShop.has_tuan.get();
          localGeneralShops.jdField_b_of_type_Int = i1;
          if (!localShop.has_quan.has()) {
            break label490;
          }
        }
        for (int i1 = localShop.has_quan.get();; i1 = 0)
        {
          localGeneralShops.jdField_c_of_type_Int = i1;
          paramBundle.add(localGeneralShops);
          break label113;
          m = 0;
          break;
          n = 0;
          break label79;
          paramNearByShopsResp = "";
          break label171;
          paramNearByShopsResp = "";
          break label197;
          paramNearByShopsResp = "";
          break label223;
          paramNearByShopsResp = "";
          break label249;
          paramNearByShopsResp = "";
          break label275;
          paramNearByShopsResp = "";
          break label301;
          paramNearByShopsResp = "";
          break label327;
          paramNearByShopsResp = "";
          break label353;
          i1 = 0;
          break label380;
        }
        a(paramBundle, n, i2, m);
        return;
      }
    } while (!QLog.isColorLevel());
    label171:
    label197:
    label223:
    label353:
    label484:
    label490:
    label496:
    QLog.i("PoiMapActivity", 2, "onGetLbsShareShop error:" + m);
    label275:
    label301:
    label327:
    label460:
    label466:
    label472:
    label478:
    return;
  }
  
  protected void a(GeoPoint paramGeoPoint)
  {
    int m = paramGeoPoint.getLatitudeE6();
    int n = paramGeoPoint.getLongitudeE6();
    super.a(paramGeoPoint);
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "lat=" + m + ", lon=" + n);
    }
    this.jdField_o_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = m;
    this.jdField_e_of_type_Int = n;
    this.jdField_c_of_type_Boolean = false;
    n = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    m = 0;
    if (m < n)
    {
      if (m == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean = false;
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(-1, false);
        }
      }
      for (;;)
      {
        m += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
        continue;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[m].a(-1, true);
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.jdField_f_of_type_Int].b(true);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131562298));
    this.jdField_c_of_type_JavaLangString = paramString;
    this.i = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, paramString, "", 0, 20);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, "");
  }
  
  public void a(String paramString, List paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_f_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label146;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131562494));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
      if (this.i == 0) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        a("share_locate", "click_sch", paramString, "0", "");
        break;
      }
      a("share_locate", "click_sch", paramString, "1", "");
      break;
      label146:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, true, 0, 0, false);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131561722));
    this.k = super.getResources().getDimensionPixelSize(2131427572);
    j();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayList == null) {
      return;
    }
    boolean bool;
    if ((paramInt3 > 0) && (paramInt3 < paramInt1)) {
      bool = true;
    }
    for (;;)
    {
      if (paramInt2 == 0)
      {
        if ((paramInt1 <= 0) || (this.jdField_d_of_type_AndroidViewView == null)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131561520, new Object[] { String.valueOf(paramInt1) }));
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, true, paramInt2, paramInt3, bool);
        if (paramInt1 < 3)
        {
          this.k = (super.getResources().getDimensionPixelSize(2131427572) * paramInt1);
          return;
          bool = false;
        }
        else
        {
          this.k = this.j;
          return;
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, false, paramInt2, paramInt3, bool);
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
            if ((paramInt1 != 0) || (!this.jdField_g_of_type_Boolean)) {
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
    int m = this.jdField_f_of_type_AndroidViewView.getHeight();
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -m);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject1);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130903945);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -m, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    bmx localbmx = new bmx(this, (TranslateAnimation)localObject1, localDialog, m, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(localbmx);
    ((TranslateAnimation)localObject2).setAnimationListener(localbmx);
    localDialog.setOnDismissListener(new bmy(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.jdField_g_of_type_AndroidViewView = localDialog.findViewById(2131231116);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131233085));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bni(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new bna(this));
    localObject1 = (Button)localDialog.findViewById(2131233084);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new bnb(this, localDialog));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131231403));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131231401));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bnc(this, localDialog));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131234405));
    this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundDrawable(super.getResources().getDrawable(2130837729));
    this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter = new PoiMapActivity.SearchResultAdapter(this, this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new bnd(this, localInputMethodManager));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bne(this, localDialog));
    if (1 == OfflineDownloader.a(getApplicationContext())) {}
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  protected void b(String paramString)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getShareShopDetail");
    localIntent.putExtra("shop_id", paramString);
    super.sendBroadcast(localIntent);
  }
  
  protected void c()
  {
    a("share_locate", "click_rec_return", "", "", "");
  }
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    double d1 = ((GeoPoint)localObject).getLatitudeE6() / 1000000.0D;
    double d2 = ((GeoPoint)localObject).getLongitudeE6() / 1000000.0D;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (localObject = "0";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      a("share_locate", "click_send", String.valueOf(d2), String.valueOf(d1), (String)localObject);
      return;
    }
  }
  
  protected void e()
  {
    a("rec_locate", "click_view", "", "", "");
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("poi_category", "");
    Object localObject1;
    String[] arrayOfString;
    int m;
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
            int n;
            localObject3 = localObject1.getJSONObject(m);
            str = ((JSONObject)localObject3).getString("name");
            localObject3 = ((JSONObject)localObject3).getString("id");
            localObject2[m] = str;
            arrayOfString[m] = localObject3;
            m += 1;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            m = 1;
          }
          localJSONException2 = localJSONException2;
          localJSONException2.printStackTrace();
        }
      }
      if ((localObject1 != null) && (localObject1.length() > 0))
      {
        n = localObject1.length();
        localObject2 = new String[n];
        arrayOfString = new String[n];
        m = 0;
        if (m >= n) {
          break label198;
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      String str;
      if (m == 0)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = localJSONException2;
        this.jdField_b_of_type_ArrayOfJavaLangString = arrayOfString;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabName:" + this.jdField_a_of_type_ArrayOfJavaLangString.toString());
      }
      return;
      label198:
      m = 0;
    }
  }
  
  public void g()
  {
    Object localObject = (LinearLayout)super.findViewById(2131233258);
    if (this.jdField_o_of_type_Boolean)
    {
      ((LinearLayout)localObject).setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.m.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = (FrameLayout)super.findViewById(2131233259);
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab = new PoiMapActivity.PoiTab[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    localObject = new LinearLayout.LayoutParams(-2, -1);
    new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    int n = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int m = 0;
    while (m < n)
    {
      localObject = new PoiMapActivity.PoiTab(this, this, this.jdField_a_of_type_ArrayOfJavaLangString[m], m);
      if (m == 0)
      {
        ((PoiMapActivity.PoiTab)localObject).a(true);
        ((PoiMapActivity.PoiTab)localObject).jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Int = 0;
      }
      if (m == n - 1) {
        ((PoiMapActivity.PoiTab)localObject).jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.a();
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[m] = localObject;
      m += 1;
    }
  }
  
  protected void h()
  {
    super.h();
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  protected void i()
  {
    this.j = super.getResources().getDimensionPixelSize(2131427570);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131233252);
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131233253);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131233255));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131233254));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131233256));
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter = new PoiMapActivity.ShopListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bms(this));
    if (!TextUtils.isEmpty(this.q)) {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(this.q);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bmt(this));
      return;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a();
    }
  }
  
  protected void j()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.k);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new bmu(this));
    this.jdField_d_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  public void k()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.k);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new bmv(this));
    this.jdField_d_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131233242: 
      r();
      if (this.jdField_h_of_type_Boolean)
      {
        a("rec_locate", "click_locate_rec", "", "", "");
        return;
      }
      a("share_locate", "click_locate_share", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      k();
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      a("rec_locate", "click_near_food", "", "", "");
      return;
      j();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Int = super.getResources().getColor(2131362097);
    this.jdField_b_of_type_Int = super.getResources().getColor(2131362070);
    this.jdField_c_of_type_Int = Color.rgb(0, 121, 255);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    f();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity
 * JD-Core Version:    0.7.0.1
 */