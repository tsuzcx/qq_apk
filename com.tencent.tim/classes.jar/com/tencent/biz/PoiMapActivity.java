package com.tencent.biz;

import acfp;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqcx;
import aqlx;
import aqnc;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.DPBiz;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.proto.lbsshare.LBSShare.Shop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import jml;
import jms;
import jmt;
import jmu;
import jmv;
import jmw;
import jmx;
import jmy;
import jmz;
import jna;
import jnb;
import jnc;
import jnd;
import jne;
import jnf;
import jng;
import jnh;
import jni;
import jnj;
import jnk;
import jqc;
import org.apache.http.client.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import swb;
import swb.a;

public class PoiMapActivity
  extends QQMapActivity
  implements View.OnClickListener, swb.a
{
  public EditText I;
  protected ImageButton O;
  public final String TAG = "PoiMapActivity";
  public String Tk;
  public String Tl;
  protected String Tm;
  public String Tn;
  protected boolean Tn;
  public String To;
  public final ViewTreeObserver.OnPreDrawListener a;
  protected e a;
  g a;
  protected swb a;
  public f[] a;
  protected int aBJ;
  protected int aBK;
  protected int aBL;
  public int aBM;
  public int aBN;
  public int aBO;
  public int aBP;
  protected int aBQ;
  protected final int aBR = 20;
  public int aBS;
  public int aBT;
  public int aBU;
  public int aBV;
  protected int aBW;
  protected int aBX;
  public int aBY;
  public int aBZ;
  protected int aCa;
  String[] aY = { acfp.m(2131709789), acfp.m(2131709788), acfp.m(2131709790), acfp.m(2131709786) };
  String[] aZ = { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  public boolean aaB = true;
  protected boolean aaC;
  protected boolean aaD;
  public boolean aaE;
  public boolean aaF;
  protected boolean aaG = true;
  public boolean aaH;
  protected boolean aaI;
  protected boolean aaJ = true;
  protected View ac;
  protected jml authConfig;
  protected int blueColor;
  public View.OnClickListener ce = new jmv(this);
  View.OnKeyListener d = new jmt(this);
  protected LinearLayout dn;
  protected RelativeLayout ex;
  XListView f;
  protected ImageView hb;
  protected ImageView hc;
  protected View iA;
  public View iB;
  protected float ip;
  public View iy;
  private View iz;
  View.OnTouchListener m = new jnb(this);
  protected int mBgColor;
  protected AbsListView.e mOnSearchScrollListener = new jmu(this);
  public LinearLayout mRootView;
  public List<b> mSearchResultList = new ArrayList();
  View mTitleBar;
  protected TextView nh;
  protected int textBlack;
  protected int textGray;
  
  public PoiMapActivity()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new jmw(this);
  }
  
  public void P(int paramInt, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.pinView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.pinView.getLayoutParams();
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (localLayoutParams.topMargin += paramInt;; localLayoutParams.topMargin = paramInt)
    {
      this.pinView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void a(b paramb)
  {
    this.aOX = paramb.Tr;
    this.aOW = paramb.name;
    this.Tm = paramb.pid;
    this.aBM = paramb.lat;
    this.aBN = paramb.lon;
    this.aBO = this.aBM;
    this.aBP = this.aBN;
    this.aOY = paramb.Tu;
    this.Tk = paramb.pid;
    this.aaD = true;
    int j = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f.length;
    int i = 0;
    if (i < j)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[0].jdField_a_of_type_ComTencentBizPoiMapActivity$c.lq(false);
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[0].R(0, false);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[i].R(-1, false);
      }
    }
    nU(0);
    this.b.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(paramb.lat / 1000000.0D, paramb.lon / 1000000.0D)));
  }
  
  public void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp)
  {
    if (paramGetShopsByIdsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetShareShopDetail null");
      }
    }
    int i;
    label64:
    label122:
    label252:
    do
    {
      do
      {
        return;
        i = paramGetShopsByIdsResp.ec.get();
        if (i != 0) {
          break;
        }
      } while (!paramGetShopsByIdsResp.shops.has());
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramGetShopsByIdsResp.shops.get().iterator();
      LBSShare.DPBiz localDPBiz;
      j localj;
      if (localIterator.hasNext())
      {
        localDPBiz = (LBSShare.DPBiz)localIterator.next();
        localj = new j();
        localj.type = 1;
        if (!localDPBiz.id.has()) {
          break label372;
        }
        paramGetShopsByIdsResp = localDPBiz.id.get();
        localj.id = paramGetShopsByIdsResp;
        if (!localDPBiz.name.has()) {
          break label378;
        }
        paramGetShopsByIdsResp = localDPBiz.name.get();
        localj.name = paramGetShopsByIdsResp;
        if (!localDPBiz.logo.has()) {
          break label384;
        }
        paramGetShopsByIdsResp = localDPBiz.logo.get();
        localj.logo = paramGetShopsByIdsResp;
        if (!localDPBiz.url.has()) {
          break label390;
        }
        paramGetShopsByIdsResp = localDPBiz.url.get();
        localj.url = paramGetShopsByIdsResp;
        if (!localDPBiz.avg_price.has()) {
          break label396;
        }
        paramGetShopsByIdsResp = localDPBiz.avg_price.get();
        localj.Ty = paramGetShopsByIdsResp;
        if (!localDPBiz.biz_zone.has()) {
          break label402;
        }
        paramGetShopsByIdsResp = localDPBiz.biz_zone.get();
        localj.Tz = paramGetShopsByIdsResp;
        if (!localDPBiz.category.has()) {
          break label408;
        }
        paramGetShopsByIdsResp = localDPBiz.category.get();
        localj.category = paramGetShopsByIdsResp;
        if (!localDPBiz.has_quan.has()) {
          break label414;
        }
        i = localDPBiz.has_quan.get();
        localj.aCl = i;
        if (!localDPBiz.has_tuan.has()) {
          break label419;
        }
        i = localDPBiz.has_tuan.get();
        localj.aCk = i;
        if (!localDPBiz.rate.has()) {
          break label424;
        }
      }
      for (i = localDPBiz.rate.get();; i = 0)
      {
        localj.aCm = i;
        localArrayList.add(localj);
        break label64;
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
        i = 0;
        break label304;
        i = 0;
        break label330;
      }
    } while (!QLog.isColorLevel());
    label148:
    label174:
    label200:
    label226:
    label372:
    label378:
    QLog.i("PoiMapActivity", 2, "onGetShareShopDetail error:" + i);
    label278:
    label304:
    label330:
    return;
  }
  
  public void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle)
  {
    if (paramLocationResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch null");
      }
      return;
    }
    int i2 = paramLocationResp.ec.get();
    boolean bool1;
    String str1;
    int k;
    int n;
    int i1;
    String str2;
    int i;
    ArrayList localArrayList;
    if (paramLocationResp.is_foreign.get() == 1)
    {
      bool1 = true;
      this.aaI = bool1;
      this.aCa = paramLocationResp.is_ark.get();
      str1 = paramBundle.getString("keyword");
      k = paramBundle.getInt("latitude");
      n = paramBundle.getInt("longitude");
      i1 = paramBundle.getInt("page");
      str2 = paramBundle.getString("category");
      this.jdField_Tn_of_type_JavaLangString = paramBundle.getString("imei");
      this.To = paramLocationResp.search_id.get();
      bool1 = false;
      if (i2 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch error:" + i2);
        }
        QQToast.a(this, super.getString(2131695216), 0).show();
      }
      i = 0;
      j = 0;
      paramBundle = null;
      if (i2 != 0) {
        break label1594;
      }
      localArrayList = new ArrayList();
      if (!this.aaI) {
        break label936;
      }
      paramBundle = new GeoPoint(k, n);
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$e != null) {
        break label792;
      }
    }
    for (;;)
    {
      Object localObject;
      LBSShare.POI localPOI;
      b localb;
      try
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$e = new e();
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$e.d(paramBundle);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$e.execute(new Void[0]);
        paramBundle = new b();
        paramBundle.name = super.getResources().getString(2131697026);
        paramBundle.Tr = "";
        this.aOX = paramBundle.Tr;
        paramBundle.lat = k;
        paramBundle.lon = n;
        paramBundle.Ts = "";
        localArrayList.add(paramBundle);
        i = 1;
        if (!paramLocationResp.poilist.has()) {
          break label1515;
        }
        paramBundle = paramLocationResp.poilist.get();
        if (paramBundle.size() <= 0) {
          break label1237;
        }
        i = 1;
        bool1 = true;
        localObject = paramBundle.iterator();
        j = i;
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break label1521;
        }
        localPOI = (LBSShare.POI)((Iterator)localObject).next();
        localb = new b();
        if (!localPOI.name.has()) {
          break label1245;
        }
        paramBundle = localPOI.name.get();
        localb.name = paramBundle;
        if (!localPOI.addr.has()) {
          break label1251;
        }
        paramBundle = localPOI.addr.get();
        localb.Tr = paramBundle;
        if (!localPOI.lat.has()) {
          break label1257;
        }
        j = localPOI.lat.get();
        localb.lat = j;
        if (!localPOI.lng.has()) {
          break label1263;
        }
        j = localPOI.lng.get();
        localb.lon = j;
        if (!localPOI.id.has()) {
          break label1269;
        }
        paramBundle = localPOI.id.get();
        localb.pid = paramBundle;
        if (!"group_activity".equals(this.mFrom)) {
          break label1275;
        }
        localb.Ts = "";
        localb.Tt = "";
        localb.aCe = 0;
        localb.Tv = "";
        localb.Tw = "";
        localb.Tx = "";
        localb.Tu = "";
        if (!TextUtils.isEmpty(localb.Ts)) {
          report("share_locate", "view_share_tuan", "", "", "", "");
        }
        if ((TextUtils.isEmpty(localb.Ts)) && (!TextUtils.isEmpty(localb.Tt))) {
          report("share_locate", "view_quan", "", "", "", "");
        }
        if ((!this.aaD) || (TextUtils.isEmpty(this.Tm)) || (!this.Tm.equals(localb.pid))) {
          break label1504;
        }
        if (!localArrayList.isEmpty())
        {
          paramBundle = (b)localArrayList.get(0);
          if ((this.aOW.equals(paramBundle.name)) && (this.aOX.equals(paramBundle.Tr))) {
            localArrayList.remove(0);
          }
        }
        localArrayList.add(0, localb);
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
      label792:
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$e.c = paramBundle;
      if (PlatformUtil.version() >= 11)
      {
        localObject = ((ThreadPoolExecutor)e.THREAD_POOL_EXECUTOR).getQueue();
        if ((localObject != null) && (((BlockingQueue)localObject).size() > 0)) {
          ((BlockingQueue)localObject).removeAll((Collection)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$e.getStatus() != AsyncTask.Status.FINISHED)
      {
        if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$e.isCancelled()) {
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$e.cancel(true);
        }
      }
      else
      {
        try
        {
          localObject = new e();
          ((e)localObject).d(paramBundle);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$e = ((e)localObject);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$e.execute(new Void[0]);
        }
        catch (RejectedExecutionException paramBundle) {}
        if (QLog.isColorLevel())
        {
          QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
          continue;
          label936:
          i = j;
          if (paramLocationResp.mylbs.has())
          {
            localObject = (LBSShare.POI)paramLocationResp.mylbs.get();
            localb = new b();
            if (((LBSShare.POI)localObject).name.has())
            {
              paramBundle = ((LBSShare.POI)localObject).name.get();
              label991:
              localb.name = paramBundle;
              if (!((LBSShare.POI)localObject).shop_url.has()) {
                break label1188;
              }
              paramBundle = ((LBSShare.POI)localObject).shop_url.get();
              label1017:
              localb.Ts = paramBundle;
              if (!((LBSShare.POI)localObject).addr.has()) {
                break label1194;
              }
              paramBundle = ((LBSShare.POI)localObject).addr.get();
              label1043:
              localb.Tr = paramBundle;
              if (!((LBSShare.POI)localObject).lat.has()) {
                break label1200;
              }
              i = ((LBSShare.POI)localObject).lat.get();
              label1069:
              localb.lat = i;
              if (!((LBSShare.POI)localObject).lng.has()) {
                break label1205;
              }
              i = ((LBSShare.POI)localObject).lng.get();
              label1095:
              localb.lon = i;
              if ((!this.aaD) || (TextUtils.isEmpty(this.aOW))) {
                break label1210;
              }
              localb.name = this.aOW;
              localb.Ts = "";
              localb.Tr = this.aOX;
              localb.lat = this.aBM;
              localb.lon = this.aBN;
            }
            for (;;)
            {
              localArrayList.add(localb);
              i = 1;
              break;
              paramBundle = super.getResources().getString(2131697026);
              break label991;
              label1188:
              paramBundle = "";
              break label1017;
              label1194:
              paramBundle = "";
              break label1043;
              label1200:
              i = 0;
              break label1069;
              label1205:
              i = 0;
              break label1095;
              label1210:
              localb.name = super.getResources().getString(2131697026);
              this.aOX = localb.Tr;
            }
            label1237:
            i = 0;
            bool1 = false;
            continue;
            label1245:
            paramBundle = "";
            continue;
            label1251:
            paramBundle = "";
            continue;
            label1257:
            j = 0;
            continue;
            label1263:
            j = 0;
            continue;
            label1269:
            paramBundle = "";
            continue;
            label1275:
            if (localPOI.shop_url.has())
            {
              paramBundle = localPOI.shop_url.get();
              localb.Ts = paramBundle;
              if (!localPOI.shop_url_quan.has()) {
                break label1468;
              }
              paramBundle = localPOI.shop_url_quan.get();
              localb.Tt = paramBundle;
              if (!localPOI.shop_count.has()) {
                break label1474;
              }
              j = localPOI.shop_count.get();
              localb.aCe = j;
              if (!localPOI.shangquan_url.has()) {
                break label1480;
              }
              paramBundle = localPOI.shangquan_url.get();
              localb.Tv = paramBundle;
              if (!localPOI.shangquan_wording.has()) {
                break label1486;
              }
              paramBundle = localPOI.shangquan_wording.get();
              localb.Tw = paramBundle;
              if (!localPOI.POI_preview_url.has()) {
                break label1492;
              }
              paramBundle = localPOI.POI_preview_url.get();
              localb.Tx = paramBundle;
              if (!localPOI.dpid.has()) {
                break label1498;
              }
            }
            label1295:
            label1321:
            label1348:
            label1375:
            label1401:
            for (paramBundle = localPOI.dpid.get();; paramBundle = "")
            {
              localb.Tu = paramBundle;
              break;
              paramBundle = "";
              break label1295;
              paramBundle = "";
              break label1321;
              j = 0;
              break label1348;
              paramBundle = "";
              break label1375;
              paramBundle = "";
              break label1401;
              paramBundle = "";
              break label1427;
            }
            label1427:
            label1468:
            label1474:
            label1480:
            label1486:
            label1492:
            label1498:
            label1504:
            localArrayList.add(localb);
          }
        }
      }
    }
    label1515:
    boolean bool2 = false;
    int j = i;
    label1521:
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
        runOnUiThread(new PoiMapActivity.12(this, bool1, str2, str1, paramLocationResp, i, k, n, i1, bool2));
        return;
        i = 0;
        break;
      }
      label1594:
      j = 0;
      paramLocationResp = paramBundle;
    }
  }
  
  public void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle)
  {
    if (paramNearByShopsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareShop null");
      }
    }
    int i;
    label109:
    label245:
    label375:
    do
    {
      do
      {
        return;
        i = paramNearByShopsResp.ec.get();
        if (i != 0) {
          break;
        }
        paramBundle.getInt("begin", 0);
        if (paramNearByShopsResp.next_begin.has()) {
          paramNearByShopsResp.next_begin.get();
        }
        if (paramNearByShopsResp.total.has()) {
          paramNearByShopsResp.total.get();
        }
      } while (!paramNearByShopsResp.poilist.has());
      paramBundle = new ArrayList();
      Iterator localIterator = paramNearByShopsResp.poilist.get().iterator();
      LBSShare.Shop localShop;
      a locala;
      if (localIterator.hasNext())
      {
        localShop = (LBSShare.Shop)localIterator.next();
        locala = new a();
        locala.type = 1;
        if (!localShop.id.has()) {
          break label417;
        }
        paramNearByShopsResp = localShop.id.get();
        locala.id = paramNearByShopsResp;
        if (!localShop.name.has()) {
          break label423;
        }
        paramNearByShopsResp = localShop.name.get();
        locala.name = paramNearByShopsResp;
        if (!localShop.logo.has()) {
          break label429;
        }
        paramNearByShopsResp = localShop.logo.get();
        locala.logo = paramNearByShopsResp;
        if (!localShop.url.has()) {
          break label435;
        }
        paramNearByShopsResp = localShop.url.get();
        locala.url = paramNearByShopsResp;
        if (!localShop.detail.has()) {
          break label441;
        }
        paramNearByShopsResp = localShop.detail.get();
        locala.detail = paramNearByShopsResp;
        if (!localShop.discount.has()) {
          break label447;
        }
        paramNearByShopsResp = localShop.discount.get();
        locala.Tp = paramNearByShopsResp;
        if (!localShop.price.has()) {
          break label453;
        }
        paramNearByShopsResp = localShop.price.get();
        locala.price = paramNearByShopsResp;
        if (!localShop.soldnum.has()) {
          break label459;
        }
        paramNearByShopsResp = localShop.soldnum.get();
        locala.Tq = paramNearByShopsResp;
        if (!localShop.has_tuan.has()) {
          break label465;
        }
        i = localShop.has_tuan.get();
        locala.aCk = i;
        if (!localShop.has_quan.has()) {
          break label470;
        }
      }
      for (i = localShop.has_quan.get();; i = 0)
      {
        locala.aCl = i;
        paramBundle.add(locala);
        break label109;
        break;
        paramNearByShopsResp = "";
        break label167;
        paramNearByShopsResp = "";
        break label193;
        paramNearByShopsResp = "";
        break label219;
        paramNearByShopsResp = "";
        break label245;
        paramNearByShopsResp = "";
        break label271;
        paramNearByShopsResp = "";
        break label297;
        paramNearByShopsResp = "";
        break label323;
        paramNearByShopsResp = "";
        break label349;
        i = 0;
        break label375;
      }
    } while (!QLog.isColorLevel());
    label167:
    label193:
    label219:
    label349:
    QLog.i("PoiMapActivity", 2, "onGetLbsShareShop error:" + i);
    label271:
    label297:
    label323:
    label453:
    label459:
    label465:
    label470:
    return;
  }
  
  public void a(ArrayList<b> paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((this.aBM != paramInt1) && (this.aBN != paramInt2)) {}
    label142:
    label159:
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f.length;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          break label159;
        }
        if (this.aZ[paramInt1].equals(paramString))
        {
          paramString = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[paramInt1];
          if (paramInt3 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramString.a(paramArrayList, bool, paramInt4, paramBoolean);
            if ((paramInt1 != 0) || (!this.aaG)) {
              break;
            }
            if ((paramArrayList == null) || (paramArrayList.size() <= 1)) {
              break label142;
            }
            this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[0].R(0, true);
            if (this.aZD) {
              break;
            }
            report("share_locate", "pageview_all", this.To, this.jdField_Tn_of_type_JavaLangString, "", "");
            return;
          }
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[0].R(0, true);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void ayl()
  {
    this.aaH = false;
    ReportDialog localReportDialog = new ReportDialog(this);
    localReportDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    int i = this.mTitleBar.getHeight();
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.mRootView.startAnimation((Animation)localObject1);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setSoftInputMode(36);
    localReportDialog.setContentView(2131563018);
    Object localObject2 = localReportDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    jnc localjnc = new jnc(this, (TranslateAnimation)localObject1, localReportDialog, i, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(localjnc);
    ((TranslateAnimation)localObject2).setAnimationListener(localjnc);
    localReportDialog.setOnDismissListener(new jnd(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.iA = localReportDialog.findViewById(2131377546);
    this.I = ((EditText)localReportDialog.findViewById(2131366542));
    this.I.addTextChangedListener(new h());
    this.I.setSelection(0);
    this.I.requestFocus();
    this.I.setOnKeyListener(this.d);
    this.O = ((ImageButton)localReportDialog.findViewById(2131368696));
    this.O.setOnClickListener(new jne(this));
    localObject1 = (Button)localReportDialog.findViewById(2131363801);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new jnf(this, localReportDialog));
    this.nh = ((TextView)localReportDialog.findViewById(2131372437));
    this.ex = ((RelativeLayout)localReportDialog.findViewById(2131377207));
    this.ex.setOnClickListener(new jng(this, localReportDialog));
    this.f = ((XListView)localReportDialog.findViewById(2131377779));
    this.f.setBackgroundDrawable(super.getResources().getDrawable(2130838900));
    this.f.setDividerHeight(0);
    this.mSearchResultList.clear();
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$g = new g(this);
    this.f.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$g);
    this.f.setOnScrollListener(this.mOnSearchScrollListener);
    this.f.setOnTouchListener(new jnh(this, localInputMethodManager));
    this.f.setOnItemClickListener(new jni(this, localReportDialog));
    if (1 == jqc.getNetWorkType()) {}
    for (this.jdField_Tn_of_type_Boolean = true;; this.jdField_Tn_of_type_Boolean = false)
    {
      this.aaC = true;
      swb.report("search", hz());
      return;
    }
  }
  
  public void aym()
  {
    if (this.aZD)
    {
      report("rec_locate", "click_rec_return", "", "", "", "");
      return;
    }
    report("share_locate", "click_rec_return", this.To, this.jdField_Tn_of_type_JavaLangString, "", "");
  }
  
  public void ayn()
  {
    Object localObject1;
    double d1;
    if ((this.mapView.getMap() != null) && (this.mapView.getMap().getCameraPosition() != null) && (this.mapView.getMap().getCameraPosition().target != null))
    {
      localObject1 = this.mapView.getMap().getCameraPosition().target;
      d1 = ((LatLng)localObject1).getLatitude();
      localObject1 = String.valueOf(((LatLng)localObject1).getLongitude());
    }
    for (String str1 = String.valueOf(d1);; str1 = "")
    {
      String str2 = str1 + "," + (String)localObject1 + "," + this.To + "," + this.jdField_Tn_of_type_JavaLangString;
      Object localObject2;
      Object localObject3;
      label194:
      int i;
      if (TextUtils.isEmpty(this.Tk))
      {
        localObject2 = "0";
        String str3 = this.aBQ + 1 + "";
        if (!this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[this.aBQ].jdField_a_of_type_ComTencentBizPoiMapActivity$c.aaM) {
          break label374;
        }
        localObject3 = "2";
        report("share_locate", "click_send", str2, (String)localObject2, str3, (String)localObject3);
        if (this.aaI)
        {
          report("rec_locate", "send_googlestation", "", "", "", "");
          report("rec_locate", "send_foursquare", "", "", "", "");
        }
        localObject2 = getIntent();
        if (((Intent)localObject2).getIntExtra("uintype", 0) == 1008)
        {
          localObject3 = new Intent("com.tencent.biz.pubaccount.locationResultAction");
          ((Intent)localObject3).putExtra("latitude", str1);
          ((Intent)localObject3).putExtra("longitude", (String)localObject1);
          ((Intent)localObject3).putExtra("name", this.aOX);
          sendBroadcast((Intent)localObject3, "com.tencent.tim.msg.permission.pushnotify");
        }
        i = ((Intent)localObject2).getIntExtra("sessionType", 1);
        if (i != 1) {
          break label382;
        }
        localObject1 = "group";
      }
      for (;;)
      {
        swb.report("send_location", hz(), (String)localObject1);
        return;
        localObject2 = this.Tk;
        break;
        label374:
        localObject3 = "1";
        break label194;
        label382:
        if (i == 0) {
          localObject1 = "person";
        } else if (i == 3000) {
          localObject1 = "disc_group";
        } else {
          localObject1 = "other";
        }
      }
      localObject1 = "";
    }
  }
  
  public void ayo()
  {
    report("rec_locate", "click_view", "", "", "", "");
  }
  
  protected void ayp()
  {
    this.authConfig = jml.a();
    Object localObject2 = this.authConfig.H("poi_category", "");
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
        this.aY = localJSONException2;
        this.aZ = arrayOfString;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabName:" + this.aY.toString());
      }
      return;
      label198:
      i = 0;
    }
  }
  
  public void ayq()
  {
    this.aBU = super.getResources().getDimensionPixelSize(2131297917);
    this.aBV = super.getResources().getDimensionPixelSize(2131297926);
    this.aBY = super.getResources().getDimensionPixelSize(2131297920);
    this.aBZ = super.getResources().getDimensionPixelSize(2131297919);
    this.aBW = super.getResources().getDimensionPixelSize(2131297912);
    this.aBX = super.getResources().getDimensionPixelSize(2131297913);
    this.dn = ((LinearLayout)super.findViewById(2131373465));
    this.iy.setBackgroundColor(this.mBgColor);
    this.dn.setBackgroundDrawable(null);
    this.dn.setBackgroundResource(this.aBJ);
    if (this.aZJ)
    {
      this.dn.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.tW.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.tW.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (FrameLayout)super.findViewById(2131373457);
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f = new f[this.aY.length];
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.weight = 1.0F;
    int j = this.aY.length;
    int i = 0;
    while (i < j)
    {
      f localf = new f(this, this.aY[i], i);
      if (i == 0)
      {
        localf.setSelect(true);
        localf.jdField_a_of_type_ComTencentBizPoiMapActivity$c.selectPos = 0;
      }
      if (i == j - 1) {
        localf.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.ayw();
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[i] = localf;
      this.dn.addView(localf.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView, localLayoutParams1);
      ((FrameLayout)localObject).addView(localf.mListView, localLayoutParams2);
      i += 1;
    }
    if (this.mapView != null) {
      this.mapView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
    if (this.pinView != null) {
      this.pinView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
  }
  
  public void ayr()
  {
    super.ayr();
  }
  
  public void ays()
  {
    if (this.aaB) {}
    while ((this.aBU <= 0) || (this.aBT <= 0)) {
      return;
    }
    aqnc localaqnc = new aqnc(Integer.valueOf(this.aBT + this.aBU), Integer.valueOf(this.aBT), new jmx(this));
    localaqnc.setDuration(200L);
    localaqnc.setFillAfter(true);
    localaqnc.setAnimationListener(new jmy(this));
    this.tW.startAnimation(localaqnc);
  }
  
  public void ayt()
  {
    if (!this.aaB) {}
    while ((this.aBU <= 0) || (this.aBT <= 0)) {
      return;
    }
    aqnc localaqnc = new aqnc(Integer.valueOf(this.aBT), Integer.valueOf(this.aBT + this.aBU), new jmz(this));
    localaqnc.setDuration(200L);
    localaqnc.setFillAfter(true);
    localaqnc.setAnimationListener(new jna(this));
    this.tW.startAnimation(localaqnc);
  }
  
  public void ayu()
  {
    super.ayu();
    String str = "{" + "\"id\":\"" + this.Tk + "\"," + "\"title\":\"" + this.aOW + "\"," + "\"address\":\"" + this.aOX + "\"," + "\"location\":{" + "\"lat\":\"" + this.aBO * 1.0F / 1000000.0D + "\"," + "\"lon\":\"" + this.aBP * 1.0F / 1000000.0D + "\"" + "}" + "}";
    Intent localIntent = new Intent();
    localIntent.putExtra("result", str);
    setResult(-1, localIntent);
    finish();
  }
  
  public void ayv()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("onHideRoute:");
          if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null)
          {
            bool = true;
            QLog.d("Q.qqmap", 2, bool);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null)
          {
            this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.remove();
            this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = null;
            this.mapView.invalidate();
          }
          return;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqmap", 2, "onHideRoute:", localException);
      }
      bool = false;
    }
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareSearch");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("category", paramString2);
    localIntent.putExtra("page", paramInt3);
    localIntent.putExtra("count", paramInt4);
    localIntent.putExtra("coordinate", 1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "getSearchDataFromServer:lat=" + paramInt1 + ",lon=" + paramInt2 + ",keyword=" + paramString1 + ",category=" + paramString2 + ",page=" + paramInt3 + ",count=" + paramInt4);
    }
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
  
  protected void b(String paramString, List<b> paramList, boolean paramBoolean)
  {
    if (this.mSearchResultList == null)
    {
      this.mSearchResultList = new ArrayList();
      this.aaE = paramBoolean;
      this.aaF = false;
      if (!this.mSearchResultList.isEmpty()) {
        break label216;
      }
      this.nh.setText(getString(2131719279));
      this.nh.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$g.notifyDataSetChanged();
      return;
      if (this.aBS == 0) {
        this.mSearchResultList.clear();
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.mSearchResultList.addAll(paramList);
        if (this.aZD)
        {
          report("share_locate", "click_sch", paramString, "0", "", "");
          break;
        }
        report("share_locate", "click_sch", paramString, "0", this.To, this.jdField_Tn_of_type_JavaLangString);
        break;
      }
      if (this.aZD)
      {
        report("share_locate", "click_sch", paramString, "1", "", "");
        break;
      }
      report("share_locate", "click_sch", paramString, "1", this.To, this.jdField_Tn_of_type_JavaLangString);
      break;
      label216:
      this.nh.setVisibility(8);
      this.f.setVisibility(0);
    }
  }
  
  public void c(GeoPoint paramGeoPoint)
  {
    int i = paramGeoPoint.getLatitudeE6();
    int j = paramGeoPoint.getLongitudeE6();
    if ((this.aBM == i) && (this.aBN == j)) {
      return;
    }
    super.c(paramGeoPoint);
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "lat=" + i + ", lon=" + j);
    }
    this.aOW = "";
    this.aBM = i;
    this.aBN = j;
    this.aBO = this.aBM;
    this.aBP = this.aBN;
    this.aaD = false;
    j = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f.length;
    i = 0;
    if (i < j)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[0].jdField_a_of_type_ComTencentBizPoiMapActivity$c.lq(false);
        if (this.aaG) {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[0].R(-1, false);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[0].R(0, false);
        continue;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[i].R(-1, true);
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[this.aBQ].lr(true);
  }
  
  protected String hz()
  {
    switch ()
    {
    default: 
      return "others";
    case 1: 
      return "Wifi";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    }
    return "4g";
  }
  
  public void i(List<LatLng> paramList, int paramInt)
  {
    Object localObject;
    if (paramList != null)
    {
      ayv();
      localObject = this.b.addPolyline(new PolylineOptions().addAll(paramList).width(aqcx.dip2px(this, 7.0F)).color(Color.parseColor("#389dff")));
      if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null)
      {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = ((Polyline)localObject);
        bTo();
        this.EZ.setText(swb.c(paramInt));
      }
    }
    for (;;)
    {
      bTx();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new LatLng(this.k.getLatitudeE6() / 1000000.0D, this.k.getLongitudeE6() / 1000000.0D));
      if ((paramList != null) && (paramList.size() > 0)) {
        ((ArrayList)localObject).addAll(paramList);
      }
      ((ArrayList)localObject).add(new LatLng(this.latitude, this.longitude));
      swb.a((List)localObject, this.mapView, aqcx.dip2px(this, 42.0F));
      this.mapView.invalidate();
      return;
      QQToast.a(this, 0, acfp.m(2131709787), 0).show(getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  public void initView()
  {
    this.mRootView = ((LinearLayout)super.findViewById(2131374929));
    this.ac = super.findViewById(2131377783);
    this.iy = super.findViewById(2131373454);
    this.iz = super.findViewById(2131371121);
    this.hc = ((ImageView)super.findViewById(2131373460));
    this.hc.setContentDescription(getString(2131697030));
    this.hc.setVisibility(0);
    this.hc.setOnClickListener(this);
    if (this.aZD)
    {
      report("rec_locate", "pageview_all", "", "", "", "");
      this.ac.setVisibility(8);
      this.iy.setVisibility(8);
      this.tX.setVisibility(0);
      this.dr.setOnClickListener(this);
      if (!TextUtils.isEmpty(this.aOW))
      {
        this.EX.setText(this.aOW);
        this.EX.setVisibility(0);
        this.EY.setText(this.aOV);
        this.mapView.getMap().getUiSettings().setLogoPosition(2);
      }
    }
    for (;;)
    {
      Object localObject = (FrameLayout.LayoutParams)this.iz.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = (this.aBU + this.aBV);
      this.iz.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mTitleBar = super.findViewById(2131379769);
      this.hb = ((ImageView)super.findViewById(2131367552));
      super.findViewById(2131363801).setVisibility(8);
      localObject = (EditText)this.ac.findViewById(2131366542);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnTouchListener(this.m);
      return;
      this.EX.setVisibility(8);
      break;
      this.ac.setVisibility(0);
      this.iy.setVisibility(0);
      this.tX.setVisibility(8);
      ayq();
      if (!"group_activity".equals(this.mFrom))
      {
        this.mapView.getMap().setOnMapClickListener(new jms(this));
        this.iB = this.iy.findViewById(2131373462);
        this.iB.setOnClickListener(this);
      }
    }
  }
  
  public Intent j()
  {
    super.j();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((this.mapView != null) && (this.mapView.getMap() != null) && (this.mapView.getMap().getCameraPosition() != null) && (this.mapView.getMap().getCameraPosition().target != null))
    {
      LatLng localLatLng = this.mapView.getMap().getCameraPosition().target;
      localBundle.putString("latitude", String.valueOf(localLatLng.getLatitude()));
      localBundle.putString("longitude", String.valueOf(localLatLng.getLongitude()));
    }
    localBundle.putString("poiId", this.Tk);
    localBundle.putBoolean("isForien", this.aaI);
    localBundle.putInt("isArk", this.aCa);
    localBundle.putString("description", this.location);
    localBundle.putString("latSpan", String.valueOf(this.aBM));
    localBundle.putString("lngSpan", String.valueOf(this.aBN));
    if ((TextUtils.isEmpty(this.aOW)) || (this.aOW.equals(getString(2131697026)))) {
      this.aOW = getString(2131695485);
    }
    if (TextUtils.isEmpty(this.aOX)) {
      this.aOX = "Unknown Address";
    }
    localBundle.putString("title", this.aOW);
    localBundle.putString("summary", this.aOX);
    localBundle.putString("dianping_id", this.aOY);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public void kR(String paramString)
  {
    this.f.setVisibility(8);
    this.nh.setVisibility(0);
    this.nh.setText(getString(2131697022));
    this.Tl = paramString;
    this.aBS = 0;
    this.aaE = false;
    this.aaF = false;
    b(this.aBM, this.aBN, paramString, "", 0, 20);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$g.notifyDataSetChanged();
  }
  
  public void nU(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f == null) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f.length)) {
      return;
    }
    this.aBQ = paramInt;
    int j = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f.length;
    int i = 0;
    label30:
    if (i < j)
    {
      if (i != paramInt) {
        break label67;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[i].setSelect(true);
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[i].lr(true);
    }
    for (;;)
    {
      i += 1;
      break label30;
      break;
      label67:
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$f[i].setSelect(false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131373460: 
    case 2131373462: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.aZD) {
          if (this.k != null)
          {
            bTx();
            if (this.b != null) {
              this.b.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(this.k.getLatitudeE6() / 1000000.0D, this.k.getLongitudeE6() / 1000000.0D)));
            }
            label114:
            if (!this.aZD) {
              break label168;
            }
            report("rec_locate", "click_locate_rec", "", "", "", "");
          }
        }
        for (;;)
        {
          this.hc.setImageResource(2130843233);
          break;
          xR(true);
          break label114;
          xR(true);
          break label114;
          label168:
          report("share_locate", "click_locate_share", "", "", "", "");
        }
        if (!this.aaB) {
          ays();
        }
      }
    }
    GeoPoint localGeoPoint = new GeoPoint((int)(this.latitude * 1000000.0D), (int)(this.longitude * 1000000.0D));
    if (Build.VERSION.SDK_INT >= 23) {
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
      }
    }
    for (;;)
    {
      swb.report("navigation_click");
      swb.cY("click_navig", "0");
      break;
      this.jdField_a_of_type_Swb.a(this.k, localGeoPoint, this.mSelfPoiName, this.aOW);
      continue;
      this.jdField_a_of_type_Swb.a(this.k, localGeoPoint, this.mSelfPoiName, this.aOW);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    paramBundle = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    this.textGray = super.getResources().getColor(2131167379);
    this.textBlack = super.getResources().getColor(2131167304);
    this.aBJ = 2130851238;
    this.aBK = 2130839639;
    this.aBL = 2130844727;
    if ("1103".equals(paramBundle)) {}
    for (this.mBgColor = super.getResources().getColor(2131166163);; this.mBgColor = super.getResources().getColor(2131166162))
    {
      this.blueColor = Color.rgb(0, 121, 255);
      this.ip = super.getResources().getDisplayMetrics().density;
      this.aaJ = getIntent().getBooleanExtra("is_need_destroy_broadcast", true);
      this.jdField_a_of_type_Swb = new swb(this);
      this.jdField_a_of_type_Swb.a(this);
      ayp();
      initView();
      return;
    }
  }
  
  public void onMapScrollEnd(GeoPoint paramGeoPoint)
  {
    super.onMapScrollEnd(paramGeoPoint);
    if (!this.aZD) {
      report("share_locate", "drag_location", this.To, this.jdField_Tn_of_type_JavaLangString, "", "");
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint)
  {
    this.hc.setImageResource(2130843231);
  }
  
  public void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean yb()
  {
    return this.aaJ;
  }
  
  public boolean yc()
  {
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null;
  }
  
  public class TabView
    extends RelativeLayout
  {
    public int aCj;
    public View iE;
    public View iF;
    public TextView nj;
    public String tabName;
    
    public TabView(Context paramContext, String paramString, int paramInt)
    {
      super();
      this.aCj = paramInt;
      this.tabName = paramString;
      this.nj = new TextView(paramContext);
      this.nj.setTextSize(16.0F);
      this.nj.setText(paramString);
      this.nj.setTextColor(PoiMapActivity.this.textGray);
      paramString = new RelativeLayout.LayoutParams(-2, -2);
      paramString.addRule(13, -1);
      addView(this.nj, paramString);
      this.iE = new View(paramContext);
      this.iE.setBackgroundColor(PoiMapActivity.this.blueColor);
      paramString = new RelativeLayout.LayoutParams(-2, (int)(3.0F * PoiMapActivity.this.ip));
      paramString.addRule(12, -1);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131297918);
      paramString.rightMargin = paramInt;
      paramString.leftMargin = paramInt;
      this.iE.setVisibility(4);
      addView(this.iE, paramString);
      this.iF = new View(paramContext);
      this.iF.setBackgroundDrawable(null);
      this.iF.setBackgroundResource(PoiMapActivity.this.aBL);
      paramContext = new RelativeLayout.LayoutParams((int)(2.0F * PoiMapActivity.this.ip), (int)(20.0F * PoiMapActivity.this.ip));
      paramContext.addRule(15, -1);
      paramContext.addRule(11, -1);
      addView(this.iF, paramContext);
      setOnClickListener(PoiMapActivity.this.ce);
    }
    
    public void ayw()
    {
      this.iF.setVisibility(4);
    }
    
    public void setSelect(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.nj.setTextColor(PoiMapActivity.this.textBlack);
        this.iE.setVisibility(0);
        return;
      }
      this.nj.setTextColor(PoiMapActivity.this.textGray);
      this.iE.setVisibility(4);
    }
  }
  
  public class a
    extends PoiMapActivity.i
  {
    public String Tp;
    public String Tq;
    public String detail;
    public String price;
    
    public a()
    {
      super();
    }
  }
  
  public class b
  {
    public String Tr;
    public String Ts;
    public String Tt;
    public String Tu;
    public String Tv;
    public String Tw;
    public String Tx;
    public int aCe;
    public int lat;
    public int lon;
    public String name;
    public String pid;
    
    public b() {}
  }
  
  public class c
    extends BaseAdapter
  {
    public boolean aaM;
    protected TextView addressTextView;
    public boolean hasMore;
    public ArrayList<PoiMapActivity.b> ji = new ArrayList();
    public int page;
    public int selectPos = -1;
    
    public c() {}
    
    public void Q(int paramInt, boolean paramBoolean)
    {
      if (paramInt >= this.ji.size()) {}
      PoiMapActivity.b localb;
      do
      {
        do
        {
          do
          {
            return;
          } while (paramInt == this.selectPos);
          this.selectPos = paramInt;
          notifyDataSetChanged();
        } while ((paramInt == -1) || (!paramBoolean));
        localb = a(paramInt);
      } while (localb == null);
      PoiMapActivity.this.aOW = localb.name;
      PoiMapActivity.this.aOX = localb.Tr;
      PoiMapActivity.a(PoiMapActivity.this, localb.Tu);
      PoiMapActivity.this.Tk = localb.pid;
      PoiMapActivity.this.aBO = localb.lat;
      PoiMapActivity.this.aBP = localb.lon;
      QQMapView.isSelectPoiListItem = true;
      PoiMapActivity.a(PoiMapActivity.this).animateCamera(CameraUpdateFactory.newLatLng(new LatLng(localb.lat / 1000000.0D, localb.lon / 1000000.0D)));
    }
    
    public PoiMapActivity.b a(int paramInt)
    {
      int i = paramInt;
      if (this.aaM) {
        i = paramInt + 1;
      }
      if ((i >= this.ji.size()) || (i < 0)) {
        return null;
      }
      return (PoiMapActivity.b)this.ji.get(i);
    }
    
    public void b(ArrayList<PoiMapActivity.b> paramArrayList, boolean paramBoolean, int paramInt)
    {
      if (paramInt == this.page)
      {
        this.ji.addAll(paramArrayList);
        this.hasMore = paramBoolean;
        this.page += 1;
        notifyDataSetChanged();
      }
    }
    
    public int getCount()
    {
      int j = 1;
      int i = 1;
      if (this.aaM)
      {
        j = this.ji.size();
        if (this.hasMore) {}
        for (;;)
        {
          return i + (j - 1);
          i = 0;
        }
      }
      int k = this.ji.size();
      if (this.hasMore) {}
      for (i = j;; i = 0) {
        return i + k;
      }
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        localObject1 = new PoiMapActivity.d(PoiMapActivity.this);
        paramView = LayoutInflater.from(PoiMapActivity.this).inflate(2131560163, null);
        ((PoiMapActivity.d)localObject1).iC = paramView.findViewById(2131378167);
        ((PoiMapActivity.d)localObject1).hd = ((ImageView)paramView.findViewById(2131378166));
        ((PoiMapActivity.d)localObject1).nameTextView = ((TextView)paramView.findViewById(2131372209));
        ((PoiMapActivity.d)localObject1).addrTextView = ((TextView)paramView.findViewById(2131362250));
        ((PoiMapActivity.d)localObject1).chooseView = paramView.findViewById(2131377941);
        ((PoiMapActivity.d)localObject1).iD = paramView.findViewById(2131371952);
        ((PoiMapActivity.d)localObject1).detailView = paramView.findViewById(2131365779);
        ((PoiMapActivity.d)localObject1).he = ((ImageView)paramView.findViewById(2131378165));
        ((PoiMapActivity.d)localObject1).hf = ((ImageView)paramView.findViewById(2131380438));
        ((PoiMapActivity.d)localObject1).hg = ((ImageView)paramView.findViewById(2131375373));
        paramView.setTag(localObject1);
        if ((paramInt != this.ji.size()) && ((!this.aaM) || (paramInt != this.ji.size() - 1))) {
          break label247;
        }
        ((PoiMapActivity.d)localObject1).iD.setVisibility(0);
        ((PoiMapActivity.d)localObject1).detailView.setVisibility(8);
      }
      for (Object localObject1 = paramView;; localObject1 = null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject1 = (PoiMapActivity.d)paramView.getTag();
        break;
        label247:
        localObject2 = a(paramInt);
        if ((paramInt == 0) && (!this.aaM)) {
          this.addressTextView = ((PoiMapActivity.d)localObject1).addrTextView;
        }
        if (localObject2 != null) {
          break label285;
        }
      }
      label285:
      ((PoiMapActivity.d)localObject1).iD.setVisibility(8);
      ((PoiMapActivity.d)localObject1).hd.setImageDrawable(null);
      ((PoiMapActivity.d)localObject1).iC.setVisibility(8);
      ((PoiMapActivity.d)localObject1).detailView.setVisibility(0);
      ((PoiMapActivity.d)localObject1).detailView.setBackgroundDrawable(null);
      ((PoiMapActivity.d)localObject1).detailView.setBackgroundResource(PoiMapActivity.this.aBJ);
      ((PoiMapActivity.d)localObject1).nameTextView.setText(((PoiMapActivity.b)localObject2).name);
      ((PoiMapActivity.d)localObject1).addrTextView.setText(((PoiMapActivity.b)localObject2).Tr);
      Object localObject2 = ((PoiMapActivity.b)localObject2).name + ((PoiMapActivity.b)localObject2).Tr;
      if (paramInt == this.selectPos)
      {
        ((PoiMapActivity.d)localObject1).nameTextView.setTextColor(PoiMapActivity.this.blueColor);
        ((PoiMapActivity.d)localObject1).addrTextView.setTextColor(PoiMapActivity.this.blueColor);
        ((PoiMapActivity.d)localObject1).chooseView.setVisibility(0);
      }
      for (localObject1 = (String)localObject2 + PoiMapActivity.this.getString(2131697028);; localObject1 = (String)localObject2 + PoiMapActivity.this.getString(2131697029))
      {
        paramView.setContentDescription((CharSequence)localObject1);
        localObject1 = paramView;
        break;
        ((PoiMapActivity.d)localObject1).nameTextView.setTextColor(PoiMapActivity.this.textBlack);
        ((PoiMapActivity.d)localObject1).addrTextView.setTextColor(PoiMapActivity.this.textGray);
        ((PoiMapActivity.d)localObject1).chooseView.setVisibility(4);
      }
    }
    
    public void kS(String paramString)
    {
      if ((!this.aaM) && (this.addressTextView != null) && (!TextUtils.isEmpty(paramString))) {
        this.addressTextView.setText(paramString);
      }
    }
    
    public void lq(boolean paramBoolean)
    {
      this.aaM = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public class d
  {
    public TextView addrTextView;
    public View chooseView;
    public View detailView;
    public ImageView hd;
    public ImageView he;
    public ImageView hf;
    public ImageView hg;
    public View iC;
    public View iD;
    public TextView nameTextView;
    
    public d() {}
  }
  
  public class e
    extends AsyncTask<Void, Void, String>
  {
    protected HttpClient a;
    protected GeoPoint c;
    protected GeoPoint d;
    
    public e() {}
    
    public void d(GeoPoint paramGeoPoint)
    {
      this.d = paramGeoPoint;
    }
    
    protected String doInBackground(Void... paramVarArgs)
    {
      PoiMapActivity.this.aOX = "Unknown Address";
      int i = 0;
      if (i < 3)
      {
        if ((isCancelled()) || (this.d.getLatitudeE6() != PoiMapActivity.this.aBM) || (this.d.getLongitudeE6() != PoiMapActivity.this.aBN))
        {
          localObject = "Unknown Address";
          label60:
          return localObject;
        }
        paramVarArgs = aqlx.a(PoiMapActivity.this.getApplicationContext(), this.d.getLatitudeE6() / 1000000.0D, this.d.getLongitudeE6() / 1000000.0D, 3, this.a);
        PoiMapActivity.this.report("rec_locate", "call_googlestation", "", "", "", "");
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append(i).append(" time: ReverseGeocode.getFromLocation, address: ");
          if (paramVarArgs != null) {
            break label187;
          }
        }
        label187:
        for (Object localObject = "";; localObject = paramVarArgs)
        {
          QLog.i("fetch_address", 2, (String)localObject);
          if (paramVarArgs != null)
          {
            localObject = paramVarArgs;
            if (paramVarArgs.length() > 0) {
              break label60;
            }
          }
          i += 1;
          break;
        }
      }
      return "Unknown Address";
    }
    
    protected void onCancelled()
    {
      if ((this.c != null) && (this.c.getLatitudeE6() == PoiMapActivity.this.aBM) && (this.c.getLongitudeE6() == PoiMapActivity.this.aBN))
      {
        e locale = new e(PoiMapActivity.this);
        locale.d(this.c);
        PoiMapActivity.this.a = locale;
        PoiMapActivity.this.a.execute(new Void[0]);
        this.c = null;
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      if ((this.d.getLatitudeE6() != PoiMapActivity.this.aBM) || (this.d.getLongitudeE6() != PoiMapActivity.this.aBN)) {
        return;
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (String str = "Unknown Address";; str = paramString)
      {
        PoiMapActivity.this.aOX = paramString;
        PoiMapActivity.this.runOnUiThread(new PoiMapActivity.PoiMapNameTask.1(this, str));
        if (this.c == null) {
          break;
        }
        paramString = new e(PoiMapActivity.this);
        paramString.d(this.c);
        PoiMapActivity.this.a = paramString;
        PoiMapActivity.this.a.execute(new Void[0]);
        this.c = null;
        return;
      }
    }
  }
  
  public class f
  {
    public PoiMapActivity.TabView a;
    public PoiMapActivity.c a;
    final int aCf = 1;
    final int aCg = 2;
    final int aCh = 3;
    final int aCi = 4;
    public int aCj;
    public int lat;
    public int lon;
    public XListView mListView;
    public TextView ni;
    
    public f(Context paramContext, String paramString, int paramInt)
    {
      this.aCj = paramInt;
      this.ni = ((TextView)((PoiMapActivity)paramContext).findViewById(2131373458));
      this.ni.setTextColor(PoiMapActivity.this.textGray);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView = new PoiMapActivity.TabView(PoiMapActivity.this, paramContext, paramString, paramInt);
      this.mListView = new XListView(paramContext);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$c = new PoiMapActivity.c(PoiMapActivity.this);
      this.mListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$c);
      this.mListView.setDivider(null);
      this.mListView.setVisibility(4);
      this.mListView.setOnItemClickListener(new jnj(this, PoiMapActivity.this));
      this.mListView.setOnScrollListener(new jnk(this, PoiMapActivity.this));
    }
    
    public void R(int paramInt, boolean paramBoolean)
    {
      if (PoiMapActivity.this.aaD)
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.Q(paramInt, paramBoolean);
        return;
      }
      if (this.aCj == 0) {
        if ((paramInt > 0) && (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.aaM) && (PoiMapActivity.this.aaG)) {
          PoiMapActivity.this.aaG = false;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.Q(paramInt, paramBoolean);
        return;
        if (paramInt == -1) {}
      }
    }
    
    public void a(ArrayList<PoiMapActivity.b> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      if (paramBoolean2) {
        nV(3);
      }
      do
      {
        return;
        if (paramArrayList == null)
        {
          nV(1);
          return;
        }
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.b(paramArrayList, paramBoolean1, paramInt);
      } while (PoiMapActivity.this.aBQ != this.aCj);
      this.mListView.setVisibility(0);
      nV(4);
    }
    
    public void kS(String paramString)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.kS(paramString);
    }
    
    public void lr(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PoiMapActivity", 2, "POI list update isfirst = " + paramBoolean);
      }
      if ((this.lat != PoiMapActivity.this.aBM) || (this.lon != PoiMapActivity.this.aBN) || (!paramBoolean))
      {
        if (paramBoolean)
        {
          nV(2);
          this.mListView.setVisibility(4);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.ji.clear();
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.page = 0;
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.hasMore = false;
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.notifyDataSetChanged();
        }
        PoiMapActivity.this.b(PoiMapActivity.this.aBM, PoiMapActivity.this.aBN, "", PoiMapActivity.this.aZ[this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.aCj], this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.page, 20);
        this.lat = PoiMapActivity.this.aBM;
        this.lon = PoiMapActivity.this.aBN;
      }
    }
    
    public void nV(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.ni.setVisibility(0);
        this.ni.setText(PoiMapActivity.this.getString(2131695216));
        return;
      case 2: 
        this.ni.setVisibility(0);
        this.ni.setText(PoiMapActivity.this.getString(2131697022));
        return;
      case 3: 
        this.ni.setVisibility(0);
        this.ni.setText(PoiMapActivity.this.getString(2131697025));
        return;
      }
      this.ni.setVisibility(8);
    }
    
    public void setSelect(boolean paramBoolean)
    {
      if (paramBoolean) {
        if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$c.getCount() > 0)
        {
          this.mListView.setVisibility(0);
          nV(4);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.setSelect(paramBoolean);
        return;
        this.mListView.setVisibility(4);
      }
    }
  }
  
  public class g
    extends BaseAdapter
  {
    protected LayoutInflater mInflater;
    
    public g(Context paramContext)
    {
      this.mInflater = LayoutInflater.from(paramContext);
    }
    
    public int getCount()
    {
      if (PoiMapActivity.this.mSearchResultList == null) {
        return 0;
      }
      if (PoiMapActivity.this.aaE) {
        return PoiMapActivity.this.mSearchResultList.size() + 1;
      }
      return PoiMapActivity.this.mSearchResultList.size();
    }
    
    public Object getItem(int paramInt)
    {
      if (PoiMapActivity.this.mSearchResultList == null) {
        return null;
      }
      return PoiMapActivity.this.mSearchResultList.get(paramInt);
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
        paramView = new PoiMapActivity.d(PoiMapActivity.this);
        localView = LayoutInflater.from(PoiMapActivity.this).inflate(2131560163, null);
        paramView.nameTextView = ((TextView)localView.findViewById(2131372209));
        paramView.addrTextView = ((TextView)localView.findViewById(2131362250));
        paramView.chooseView = localView.findViewById(2131377941);
        paramView.chooseView.setVisibility(4);
        paramView.iD = localView.findViewById(2131371952);
        paramView.detailView = localView.findViewById(2131365779);
        paramView.iC = localView.findViewById(2131378167);
        localView.setTag(paramView);
        paramView.iC.setVisibility(8);
        if (paramInt != PoiMapActivity.this.mSearchResultList.size()) {
          break label195;
        }
        paramView.iD.setVisibility(0);
        paramView.detailView.setVisibility(8);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        Object localObject = (PoiMapActivity.d)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label195:
        paramView.iD.setVisibility(8);
        paramView.detailView.setVisibility(0);
        localObject = (PoiMapActivity.b)getItem(paramInt);
        if (localObject != null)
        {
          paramView.nameTextView.setText(((PoiMapActivity.b)localObject).name);
          paramView.addrTextView.setText(((PoiMapActivity.b)localObject).Tr);
        }
      }
    }
  }
  
  public class h
    implements TextWatcher
  {
    protected h() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = PoiMapActivity.this.I.getText().toString().trim();
      if (TextUtils.isEmpty(paramEditable))
      {
        PoiMapActivity.this.O.setVisibility(8);
        PoiMapActivity.this.f.setVisibility(8);
        PoiMapActivity.this.mSearchResultList.clear();
        PoiMapActivity.this.a.notifyDataSetChanged();
        return;
      }
      PoiMapActivity.this.O.setVisibility(0);
      PoiMapActivity.this.kR(paramEditable);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public abstract class i
  {
    public int aCk;
    public int aCl;
    public String id;
    public String logo;
    public String name;
    public int type;
    public String url;
    
    public i() {}
  }
  
  public class j
    extends PoiMapActivity.i
  {
    public String Ty;
    public String Tz;
    public int aCm;
    public String category;
    
    public j()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity
 * JD-Core Version:    0.7.0.1
 */