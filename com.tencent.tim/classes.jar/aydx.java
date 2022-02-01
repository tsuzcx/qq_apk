import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView.a;
import java.util.ArrayList;

public class aydx
  extends aygy
  implements View.OnClickListener, CropNewView.a
{
  View Ne;
  CropNewView a;
  boolean aGC = false;
  public boolean aGD = false;
  boolean aGE = false;
  boolean aGF = false;
  int bpC = 0;
  ViewGroup cr;
  public Bitmap cx;
  public Bitmap cy;
  int[] dV = new int[5];
  boolean mHasInit = false;
  boolean mIsActive = false;
  TextView mRightBtn;
  View oA;
  View oB;
  TextView yd;
  TextView ye;
  TextView yf;
  
  public aydx(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private boolean KT()
  {
    boolean bool = false;
    int i = this.b.a.tg();
    if (i == 103)
    {
      this.b.bsX();
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private boolean KU()
  {
    int i = this.b.a.tg();
    this.aGE = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",intercepte = " + false);
    }
    return false;
  }
  
  private boolean KV()
  {
    boolean bool = false;
    int i = this.b.a.tg();
    if (i == 103)
    {
      bool = true;
      this.b.bsV();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiBackPressed , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private void bsk()
  {
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.cr = ((ViewGroup)y(2131365416));
      this.cr.setOnClickListener(this);
      if (this.b.ok != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.cr.getLayoutParams();
        localLayoutParams.bottomMargin = aqnm.dip2px(56.5F);
        this.cr.setLayoutParams(localLayoutParams);
      }
      this.a = ((CropNewView)y(2131365537));
      this.oA = y(2131365532);
      this.oA.setOnClickListener(this);
      this.oB = y(2131365535);
      this.oB.setOnClickListener(this);
      this.yd = ((TextView)y(2131365414));
      this.yd.setOnClickListener(this);
      this.Ne = y(2131364230);
      this.Ne.setOnClickListener(this);
      this.ye = ((TextView)y(2131365536));
      this.mRightBtn = ((TextView)y(2131365533));
      this.mRightBtn.setOnClickListener(this);
      this.yf = ((TextView)y(2131378911));
      this.a.setCropListener(this);
    }
  }
  
  private void bsl()
  {
    if (this.b.a.tg() == 103)
    {
      this.yd.setEnabled(false);
      if ((this.yd instanceof TextView)) {
        this.yd.setText(2131701437);
      }
      this.ye.setVisibility(8);
    }
  }
  
  private void bsm() {}
  
  private void onHide()
  {
    this.mIsActive = false;
    this.cr.setVisibility(8);
    this.cx = null;
    this.cy = null;
  }
  
  private void onShow()
  {
    this.mIsActive = true;
    this.cr.setVisibility(0);
    if (!this.aGD)
    {
      this.yd.setEnabled(false);
      this.ye.setVisibility(8);
    }
    for (;;)
    {
      bsl();
      this.oA.setEnabled(false);
      this.a.setImageBitmap(this.cx);
      this.cy = this.cx;
      return;
      this.ye.setVisibility(0);
    }
  }
  
  private void tu(boolean paramBoolean)
  {
    if (this.b == null) {}
    int i;
    do
    {
      return;
      i = this.b.a.tg();
    } while (!QLog.isColorLevel());
    QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + i + ",hasModified" + paramBoolean);
  }
  
  private void tv(boolean paramBoolean)
  {
    this.b.a.tg();
  }
  
  public void Ff(int paramInt)
  {
    if (paramInt == 1) {
      this.oB.setEnabled(false);
    }
    while (paramInt != 2) {
      return;
    }
    this.oB.setEnabled(true);
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    ayqh localayqh = paramayqb.jdField_a_of_type_Ayqh;
    localayqh.bsR += this.bpC;
    if (this.aGC)
    {
      paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      ras.bw("0X80075E9", ras.bpo);
    }
  }
  
  public boolean aQu()
  {
    return this.aGC;
  }
  
  public void eNo()
  {
    this.yd.setEnabled(true);
    this.oA.setEnabled(true);
    this.aGF = true;
    tv(this.aGF);
  }
  
  public boolean onBackPressed()
  {
    if (this.mIsActive)
    {
      if (!KV()) {
        this.b.changeState(0);
      }
      ras.sp("0X80075D5");
      aklz.cN("0X800AAE5", 0);
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131365532: 
    case 2131365535: 
    case 2131365414: 
      boolean bool2;
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            this.a.eSw();
            this.oA.setEnabled(false);
            if (!this.aGD) {
              this.yd.setEnabled(false);
            }
            if ((this.b != null) && (this.b.a.tg() == 103)) {
              this.yd.setEnabled(false);
            }
            this.aGF = false;
            tu(this.aGF);
            ras.sp("0X80075D3");
            aklz.cN("0X800AAE3", 0);
            continue;
            eNo();
            this.a.eSx();
            ras.sp("0X80075D4");
            aklz.cN("0X800AAE4", 0);
          }
        } while (KU());
        this.bpC += 1;
        this.aGC = true;
        bool2 = this.a.aQM();
        if (QLog.isColorLevel()) {
          QLog.d("EditPicCrop", 2, "crop remove face items" + bool2);
        }
      } while (!bool2);
      if (this.b.bQ != null)
      {
        this.b.bQ.remove(ayjn.TAG);
        this.b.bQ.remove("DynamicFaceLayer");
        this.b.bQ.remove(ayjw.TAG);
        this.b.bQ.remove("VoteLayer");
        this.b.bQ.remove("InteractPasterLayer");
      }
      this.cx = this.a.aZ();
      ayva.a().as(this.cx);
      if (this.b.a.asi != 1) {
        break;
      }
    }
    for (;;)
    {
      this.b.e(this.cx, bool1);
      if (!KT()) {
        this.b.bte();
      }
      ras.sp("0X80075D2");
      aklz.cN("0X800AAE6", 0);
      ayqh.i(this.dV);
      break;
      this.a.eSv();
      onBackPressed();
      break;
      bsm();
      break;
      bool1 = false;
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    bsk();
    if (paramInt == 11) {
      if (!this.mIsActive) {
        onShow();
      }
    }
    while (!this.mIsActive) {
      return;
    }
    onHide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydx
 * JD-Core Version:    0.7.0.1
 */