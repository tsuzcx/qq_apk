package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiw;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import ram;
import rar;
import rgn;
import rik;
import rim;
import rin;
import riq;
import wja;

public class FaceListPage
  extends RelativeLayout
  implements View.OnClickListener
{
  private int OE;
  private FacePanel.a jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$a;
  private LocationFaceAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
  private NormalFaceAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
  private rik jdField_a_of_type_Rik;
  private riq jdField_a_of_type_Riq;
  private a b;
  private ViewGroup cw;
  private ViewGroup cx;
  private ViewGroup cy;
  private ViewGroup cz;
  private boolean hasReport;
  private ListView m;
  public int mPosition;
  private ProgressBar mProgressBar;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private ImageView nn;
  private TextView yB;
  private TextView yC;
  
  public FaceListPage(Context paramContext, FacePanel.a parama, a parama1)
  {
    super(paramContext);
    this.b = parama1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$a = parama;
    init();
  }
  
  private boolean LA()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void buN()
  {
    ram.d("FaceListPage", "FacePackage is LocationFacePackage");
    rim localrim = (rim)this.jdField_a_of_type_Rik;
    if (!localrim.items.isEmpty())
    {
      this.cw.setVisibility(4);
      this.cx.setVisibility(4);
      this.m.setVisibility(0);
      this.jdField_a_of_type_Riq.notifyDataSetChanged();
      return;
    }
    if (localrim.aIg)
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
    ram.d("FaceListPage", "FacePackage is NormalFacePackage");
    rin localrin = (rin)this.jdField_a_of_type_Rik;
    if (!localrin.oT.isEmpty()) {
      ram.d("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localrin.aAG))
        {
          ram.d("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localrin.LC();
        }
      }
      if (bool2)
      {
        ram.d("FaceListPage", "FacePkg is already download.show face list.");
        this.mProgressBar.setMax(1);
        this.mProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.m.setVisibility(4);
      this.cx.setVisibility(4);
      this.cw.setVisibility(0);
      String str = (String)this.nn.getTag(2131379238);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Rik.aAD)))
      {
        this.nn.setTag(2131379238, this.jdField_a_of_type_Rik.aAD);
        rgn.a().a(super.getContext(), this.nn, this.jdField_a_of_type_Rik.aAD, this.OE, this.OE, null);
      }
      TextView localTextView = this.yB;
      if (TextUtils.isEmpty(localrin.name)) {}
      for (str = "";; str = localrin.name)
      {
        localTextView.setText(str);
        if (!localrin.isDownloading) {
          break;
        }
        this.mProgressBar.setMax(localrin.brW);
        this.mProgressBar.setProgress(localrin.brX);
        this.yC.setBackgroundColor(0);
        this.mProgressBar.setVisibility(0);
        return;
      }
      this.mProgressBar.setMax(1);
      this.mProgressBar.setProgress(0);
      this.yC.setBackgroundResource(2130847359);
      this.mProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void c(rik paramrik)
  {
    if ((paramrik instanceof rin))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter = new NormalFaceAdapter(super.getContext());
      }
      this.jdField_a_of_type_Riq = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Riq != null)
      {
        this.jdField_a_of_type_Riq.brY = this.mPosition;
        this.jdField_a_of_type_Riq.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$a);
        this.jdField_a_of_type_Riq.d(paramrik);
        this.m.setAdapter(this.jdField_a_of_type_Riq);
      }
      return;
      if ((paramrik instanceof rim))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter = new LocationFaceAdapter(super.getContext());
        }
        this.jdField_a_of_type_Riq = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
      }
      else
      {
        ram.e("FaceListPage", "FacePackage is illegal.");
      }
    }
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
  
  public void b(rik paramrik)
  {
    if (!LA()) {
      this.mUiHandler.post(new FaceListPage.1(this, paramrik));
    }
    do
    {
      return;
      if (paramrik == null) {
        break;
      }
      ram.d("FaceListPage", "onChange,FacePkgInfo:" + paramrik.toString());
      if ((this.jdField_a_of_type_Rik == null) || (!this.jdField_a_of_type_Rik.getType().equals(paramrik.getType()))) {
        c(paramrik);
      }
      this.jdField_a_of_type_Rik = paramrik;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Rik.getType()))
      {
        buO();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Rik.getType()));
    buN();
    return;
    ram.d("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Rik = null;
    this.jdField_a_of_type_Riq.d(null);
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
      if (this.b != null)
      {
        if (((rin)this.jdField_a_of_type_Rik).isDownloading) {
          break label83;
        }
        ram.d("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Rik.id);
        this.b.fM(this.jdField_a_of_type_Rik.id);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      this.b.cancel(this.jdField_a_of_type_Rik.id);
      continue;
      if ((paramView == this.cy) && (this.b != null))
      {
        this.cx.setVisibility(0);
        this.cy.setVisibility(4);
        this.cz.setVisibility(0);
        this.b.bsI();
      }
    }
  }
  
  public void onShow()
  {
    if (this.jdField_a_of_type_Rik == null) {
      ram.w("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Rik.getType())) {
            break;
          }
          localObject = (rim)this.jdField_a_of_type_Rik;
        } while ((!((rim)localObject).items.isEmpty()) || (((rim)localObject).aIg) || (this.hasReport));
        if (aqiw.isNetworkAvailable(super.getContext())) {
          rar.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.hasReport = true;
          return;
          rar.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Rik.getType()));
      localObject = (rin)this.jdField_a_of_type_Rik;
    } while ((!aqiw.isWifiEnabled(getContext())) || (this.b == null) || (((rin)localObject).isDownloading) || (!((rin)localObject).oT.isEmpty()));
    ram.b("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.b.fM(((rin)localObject).id);
    rar.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public static abstract interface a
  {
    public abstract void bsI();
    
    public abstract void cancel(String paramString);
    
    public abstract void fM(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */