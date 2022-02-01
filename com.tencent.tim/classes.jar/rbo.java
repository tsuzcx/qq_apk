import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class rbo
  extends rdb
  implements View.OnClickListener, CropView.a
{
  CropView a;
  boolean aGC = false;
  public boolean aGD = false;
  boolean aGE = false;
  boolean aGF = false;
  int bpC = 0;
  ViewGroup cr;
  ViewGroup ct;
  public Bitmap cx;
  public Bitmap cy;
  int[] dV = new int[5];
  TextView dx;
  boolean mHasInit = false;
  boolean mIsActive = false;
  TextView mRightBtn;
  View oA;
  View oB;
  TextView yd;
  TextView ye;
  TextView yf;
  TextView yg;
  
  public rbo(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  private boolean KT()
  {
    boolean bool = true;
    int i = this.b.a.tg();
    if (i == 103) {
      this.b.bsX();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
      }
      return bool;
      if (i == 11) {
        this.b.bsX();
      } else {
        bool = false;
      }
    }
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
    if ((i == 103) || (i == 11))
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView = ((CropView)y(2131365537));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setCropListener(this);
      this.oA = y(2131365532);
      this.oA.setOnClickListener(this);
      this.oB = y(2131365535);
      this.oB.setOnClickListener(this);
      this.yd = ((TextView)y(2131365414));
      this.yd.setOnClickListener(this);
      this.dx = ((TextView)y(2131364230));
      this.dx.setOnClickListener(this);
      this.ye = ((TextView)y(2131365536));
      this.ct = ((ViewGroup)y(2131365531));
      this.ct.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView);
      this.mRightBtn = ((TextView)y(2131365533));
      this.mRightBtn.setOnClickListener(this);
      this.yf = ((TextView)y(2131378911));
      this.yg = ((TextView)y(2131371319));
    }
  }
  
  private void bsl()
  {
    if (this.b.a.tg() == 103)
    {
      this.yd.setEnabled(false);
      this.yg.setVisibility(8);
      if ((this.yd instanceof TextView)) {
        this.yd.setText(2131701437);
      }
      this.ye.setVisibility(8);
    }
    while (this.b.a.tg() != 11) {
      return;
    }
    this.ye.setVisibility(8);
    this.yg.setVisibility(0);
    this.yd.setText(getString(2131721294));
    this.dx.setText(getString(2131721295));
    this.yg.setText(getString(2131721296));
    this.yd.setTextColor(getResources().getColor(2131167335));
    this.yd.setBackgroundDrawable(getResources().getDrawable(2130851043));
    this.yd.setMinWidth(wja.dp2px(62.0F, getResources()));
    this.yd.setGravity(17);
    aqfr.b("Grp_edu", "Grp_oral", "Oral_Photoedit_In", 0, 0, new String[] { this.b.a.mExtra.getString("troop_uin", ""), "" });
  }
  
  private void bsm() {}
  
  private void onHide()
  {
    this.mIsActive = false;
    this.cr.setVisibility(8);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.getBitmap();
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (localBitmap != this.b.W())) {
      localBitmap.recycle();
    }
    if ((this.cx != null) && (!this.cx.isRecycled()) && (this.cx != this.b.W())) {
      this.cx.recycle();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.clear();
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.cx);
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
    int i = this.b.a.tg();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropRectChanged , bussiId = " + i + ",hasModified" + paramBoolean);
    }
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    rkq localrkq = paramrkm.jdField_a_of_type_Rkq;
    localrkq.bsR += this.bpC;
    if (this.aGC)
    {
      paramrkm.jdField_a_of_type_Rkq.aIG = this.aGC;
      paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      ras.bw("0X80075E9", ras.bpo);
    }
  }
  
  public boolean onBackPressed()
  {
    boolean bool = false;
    if (this.mIsActive)
    {
      if (!KV()) {
        this.b.changeState(0);
      }
      bool = true;
      ras.sp("0X80075D5");
    }
    return bool;
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
      if ((this.b != null) && (this.b.a != null) && (this.b.a.asi == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 2);
      }
      if ((this.b != null) && (this.b.a != null) && (this.b.a.asi == 11)) {
        aqfr.b("Grp_edu", "Grp_oral", "Oral_Photoedit_Renew", 0, 0, new String[] { this.b.a.mExtra.getString("troop_uin", ""), "" });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.cx);
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
      continue;
      if ((this.b != null) && (this.b.a != null) && (this.b.a.asi == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 3);
      }
      if ((this.b != null) && (this.b.a != null) && (this.b.a.asi == 11)) {
        aqfr.b("Grp_edu", "Grp_oral", "Oral_Photoedit_Rotate", 0, 0, new String[] { this.b.a.mExtra.getString("troop_uin", ""), "" });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.rotate(270);
      ras.sp("0X80075D4");
      continue;
      if (!KU())
      {
        if ((this.b != null) && (this.b.a != null) && (this.b.a.asi == 3)) {
          LpReportInfo_pf00064.allReport(615, 2, 4);
        }
        this.bpC += 1;
        this.aGC = true;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.Ls())
        {
          this.cx = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.getBitmap();
          this.b.e(this.cx, false);
          if (!KT()) {
            this.b.bte();
          }
          ras.sp("0X80075D2");
          rkq.i(this.dV);
          continue;
          if ((this.b != null) && (this.b.a != null) && (this.b.a.asi == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 5);
          }
          if ((this.b != null) && (this.b.a != null) && (this.b.a.asi == 11)) {
            aqfr.b("Grp_edu", "Grp_oral", "Oral_Photoedit_Rephotograph", 0, 0, new String[] { this.b.a.mExtra.getString("troop_uin", ""), "" });
          }
          onBackPressed();
          continue;
          bsm();
        }
      }
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
  
  public void t(Bitmap paramBitmap)
  {
    if ((paramBitmap != this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.Y()) && (paramBitmap != this.cx) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  public void tw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.yd.setEnabled(true);
      this.oA.setEnabled(true);
      this.aGF = true;
    }
    for (;;)
    {
      tv(paramBoolean);
      return;
      this.yd.setEnabled(false);
      this.oA.setEnabled(false);
    }
  }
  
  public void wS(int paramInt)
  {
    if ((paramInt == 7) && (this.jdField_a_of_type_Rel != null) && (this.jdField_a_of_type_Rel.getActivity() != null)) {
      QQToast.a(this.jdField_a_of_type_Rel.getActivity().getApplicationContext(), this.jdField_a_of_type_Rel.getActivity().getResources().getString(2131721220), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbo
 * JD-Core Version:    0.7.0.1
 */