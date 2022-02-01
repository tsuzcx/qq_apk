package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import acfp;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiw;
import axov;
import axqg;
import axtq;
import aymz;
import ayna;
import aync;
import aynd;
import ayne;
import aynh;
import aynm;
import ayom;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import java.util.List;
import mqq.os.MqqHandler;
import ram;
import rar;
import wja;

public class FaceListPage
  extends RelativeLayout
  implements View.OnClickListener
{
  private int OE;
  private aymz jdField_a_of_type_Aymz;
  private aynh jdField_a_of_type_Aynh;
  private aynm jdField_a_of_type_Aynm;
  private a jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a;
  private InformationFaceAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter;
  private LocationFaceAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
  private NormalFaceAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
  private ViewGroup cw;
  private ViewGroup cx;
  private ViewGroup cy;
  private ViewGroup cz;
  private axqg e;
  private boolean hasReport;
  public boolean isShowing;
  private ListView m;
  public int mPosition;
  private ProgressBar mProgressBar;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private ImageView nn;
  private TextView yB;
  private TextView yC;
  
  public FaceListPage(Context paramContext, axqg paramaxqg, a parama)
  {
    super(paramContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a = parama;
    this.e = paramaxqg;
    init();
  }
  
  private boolean LA()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void buN()
  {
    ram.d("FaceListPage", "FacePackage is LocationFacePackage");
    if (!(this.jdField_a_of_type_Aymz instanceof aynd)) {
      return;
    }
    aynd localaynd = (aynd)this.jdField_a_of_type_Aymz;
    if (!localaynd.items.isEmpty())
    {
      this.cw.setVisibility(4);
      this.cx.setVisibility(4);
      this.m.setVisibility(0);
      this.jdField_a_of_type_Aynh.notifyDataSetChanged();
      return;
    }
    if (localaynd.aIg)
    {
      this.cw.setVisibility(4);
      this.m.setVisibility(4);
      this.cx.setVisibility(0);
      this.cy.setVisibility(4);
      this.cz.setVisibility(0);
      return;
    }
    this.cw.setVisibility(4);
    this.m.setVisibility(4);
    this.cx.setVisibility(0);
    this.cy.setVisibility(0);
    this.cz.setVisibility(4);
  }
  
  private void buO()
  {
    boolean bool2 = true;
    ram.d("FaceListPage", "FacePackage is NormalFacePackage " + this.jdField_a_of_type_Aymz);
    Object localObject = this.jdField_a_of_type_Aymz;
    if (localObject == null) {}
    while (!(localObject instanceof ayne)) {
      return;
    }
    ayne localayne = (ayne)localObject;
    if ((localayne.oT != null) && (!localayne.oT.isEmpty())) {
      ram.d("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localayne.aAG)))
      {
        ram.d("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localayne.hY();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FaceListPage.2(this, localayne, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
  
  private void c(aymz paramaymz)
  {
    if ((paramaymz instanceof ayne))
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter = new NormalFaceAdapter(super.getContext(), this);
      }
      this.jdField_a_of_type_Aynh = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
    }
    for (;;)
    {
      if (!(paramaymz instanceof aync))
      {
        View localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, ayom.dip2px(getContext(), 10.0F)));
        localView.setVisibility(4);
        this.m.addHeaderView(localView);
        localView = new View(getContext());
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, ayom.dip2px(getContext(), 36.0F)));
        localView.setVisibility(4);
        this.m.addFooterView(localView);
      }
      if (this.jdField_a_of_type_Aynh != null)
      {
        this.jdField_a_of_type_Aynh.brY = this.mPosition;
        this.jdField_a_of_type_Aynh.a(this.e);
        this.jdField_a_of_type_Aynh.d(paramaymz);
        this.m.setAdapter(this.jdField_a_of_type_Aynh);
      }
      return;
      if ((paramaymz instanceof aynd))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter == null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter = new LocationFaceAdapter(super.getContext(), this);
        }
        this.jdField_a_of_type_Aynh = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
      }
      else if ((paramaymz instanceof ayna))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter == null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter = new InformationFaceAdapter(super.getContext(), this);
        }
        this.jdField_a_of_type_Aynh = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter;
      }
      else if ((paramaymz instanceof aync))
      {
        if (this.jdField_a_of_type_Aynm == null) {
          this.jdField_a_of_type_Aynm = new aynm(super.getContext(), this);
        }
        this.jdField_a_of_type_Aynh = this.jdField_a_of_type_Aynm;
      }
      else
      {
        ram.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void eSP()
  {
    ram.d("FaceListPage", "FacePackage is InformationFacePackage");
    if (!(this.jdField_a_of_type_Aymz instanceof ayna)) {
      return;
    }
    if (!((ayna)this.jdField_a_of_type_Aymz).items.isEmpty())
    {
      this.cw.setVisibility(4);
      this.cx.setVisibility(4);
      this.m.setVisibility(0);
      this.jdField_a_of_type_Aynh.notifyDataSetChanged();
      return;
    }
    this.cw.setVisibility(4);
    this.m.setVisibility(4);
    this.cx.setVisibility(0);
    this.cy.setVisibility(0);
    this.cz.setVisibility(4);
  }
  
  private void eSQ()
  {
    this.m.setVisibility(0);
  }
  
  private void init()
  {
    this.OE = wja.dp2px(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561835, this);
    this.nn = ((ImageView)super.findViewById(2131366663));
    this.yB = ((TextView)super.findViewById(2131366664));
    this.mProgressBar = ((ProgressBar)super.findViewById(2131373659));
    this.m = ((ListView)super.findViewById(2131366650));
    this.cw = ((RelativeLayout)super.findViewById(2131366643));
    this.cx = ((RelativeLayout)super.findViewById(2131370844));
    this.cy = ((LinearLayout)super.findViewById(2131370849));
    this.cz = ((LinearLayout)super.findViewById(2131370840));
    this.yC = ((TextView)findViewById(2131366061));
    this.yC.setOnClickListener(this);
    this.cy.setOnClickListener(this);
  }
  
  public void adC(String paramString)
  {
    int k = 0;
    aymz localaymz = this.jdField_a_of_type_Aymz;
    int j = k;
    int n;
    int i;
    if (localaymz != null)
    {
      n = localaymz.tu();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localaymz.getFaceCount())
      {
        String str = localaymz.cc(i);
        ram.d("FaceListPage", "selectByName : " + paramString + str);
        if ((str != null) && (str.contains(paramString))) {
          j = i / n;
        }
      }
      else
      {
        this.m.setSelection(j);
        return;
      }
      i += 1;
    }
  }
  
  public void b(aymz paramaymz)
  {
    if (!LA()) {
      this.mUiHandler.post(new FaceListPage.1(this, paramaymz));
    }
    do
    {
      return;
      if (paramaymz == null) {
        break;
      }
      ram.d("FaceListPage", "onChange,FacePkgInfo:" + paramaymz.toString());
      if ((this.jdField_a_of_type_Aymz == null) || (!this.jdField_a_of_type_Aymz.getType().equals(paramaymz.getType()))) {
        c(paramaymz);
      }
      this.jdField_a_of_type_Aymz = paramaymz;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Aymz.getType()))
      {
        buO();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_Aymz.getType()))
      {
        buN();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_Aymz.getType()))
      {
        eSP();
        return;
      }
    } while (!"InteractFacePackage".equals(this.jdField_a_of_type_Aymz.getType()));
    eSQ();
    return;
    ram.d("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Aymz = null;
    this.jdField_a_of_type_Aynh.d(null);
    this.m.setVisibility(4);
    this.cw.setVisibility(4);
    this.cx.setVisibility(4);
    this.yB.setText("");
    this.mProgressBar.setMax(1);
    this.mProgressBar.setProgress(0);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.yC) {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a != null)
      {
        ((axtq)axov.a(14)).hk(this.jdField_a_of_type_Aymz.id, 4);
        if (((ayne)this.jdField_a_of_type_Aymz).isDownloading) {
          break label115;
        }
        ram.d("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Aymz.id);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a.fM(this.jdField_a_of_type_Aymz.id);
        this.yC.setText(acfp.m(2131706032));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label115:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a.cancel(this.jdField_a_of_type_Aymz.id);
      continue;
      if ((paramView == this.cy) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a != null))
      {
        this.cx.setVisibility(0);
        this.cy.setVisibility(4);
        this.cz.setVisibility(0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a.bsI();
      }
    }
  }
  
  public void onShow()
  {
    if (this.jdField_a_of_type_Aymz == null) {
      ram.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Aymz.getType())) {
            break;
          }
          localObject = (aynd)this.jdField_a_of_type_Aymz;
        } while ((!((aynd)localObject).items.isEmpty()) || (((aynd)localObject).aIg) || (this.hasReport));
        if (aqiw.isNetworkAvailable(super.getContext())) {
          rar.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.hasReport = true;
          return;
          rar.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Aymz.getType()));
      localObject = (ayne)this.jdField_a_of_type_Aymz;
      ((axtq)axov.a(14)).hk(((ayne)localObject).id, 4);
    } while ((!aqiw.isWifiEnabled(getContext())) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a == null) || (((ayne)localObject).isDownloading) || (!((ayne)localObject).oT.isEmpty()));
    ram.b("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a.fM(((ayne)localObject).id);
    rar.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public static abstract interface a
  {
    public abstract void bsI();
    
    public abstract void cancel(String paramString);
    
    public abstract void fM(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */