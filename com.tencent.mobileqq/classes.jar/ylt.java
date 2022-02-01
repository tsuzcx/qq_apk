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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class ylt
  extends ynu
  implements View.OnClickListener, ytd
{
  int jdField_a_of_type_Int = 0;
  public Bitmap a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CropView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[5];
  public Bitmap b;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  TextView d;
  public boolean d;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  boolean jdField_f_of_type_Boolean = false;
  
  public ylt(@NonNull ynw paramynw)
  {
    super(paramynw);
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ynw == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Ynw.a.getBussinessId();
    } while (!QLog.isColorLevel());
    QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + i + ",hasModified" + paramBoolean);
  }
  
  private boolean b()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_Ynw.a.getBussinessId();
    if (i == 103) {
      this.jdField_a_of_type_Ynw.e();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
      }
      return bool;
      if (i == 11) {
        this.jdField_a_of_type_Ynw.e();
      } else {
        bool = false;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Ynw.a.getBussinessId();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropRectChanged , bussiId = " + i + ",hasModified" + paramBoolean);
    }
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_Ynw.a.getBussinessId();
    this.jdField_e_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",intercepte = " + false);
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_Ynw.a.getBussinessId();
    if ((i == 103) || (i == 11))
    {
      bool = true;
      this.jdField_a_of_type_Ynw.d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiBackPressed , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365211));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView = ((CropView)a(2131365333));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setCropListener(this);
      this.jdField_a_of_type_AndroidViewView = a(2131365329);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131365331);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365209));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364259));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131365332));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365328));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131365330));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131378208));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131370934));
    }
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      j();
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (localBitmap != this.jdField_a_of_type_Ynw.a())) {
      localBitmap.recycle();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_Ynw.a())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Ynw.a.getBussinessId() == 103)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698682);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (this.jdField_a_of_type_Ynw.a.getBussinessId() != 11) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131719483));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(2131719484));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(a(2131719485));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColor(2131167059));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a().getDrawable(2130850054));
    this.jdField_a_of_type_AndroidWidgetTextView.setMinWidth(AIOUtils.dp2px(62.0F, a()));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    bhbu.a("Grp_edu", "Grp_oral", "Oral_Photoedit_In", 0, 0, new String[] { this.jdField_a_of_type_Ynw.a.mExtra.getString("troop_uin", ""), "" });
  }
  
  private void k() {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 7) && (this.jdField_a_of_type_Ypg != null) && (this.jdField_a_of_type_Ypg.getActivity() != null)) {
      QQToast.a(this.jdField_a_of_type_Ypg.getActivity().getApplicationContext(), this.jdField_a_of_type_Ypg.getActivity().getResources().getString(2131719425), 0).a();
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    g();
    if (paramInt == 11) {
      if (!this.jdField_b_of_type_Boolean) {
        h();
      }
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    i();
  }
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    yye localyye = paramyya.jdField_a_of_type_Yye;
    localyye.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      paramyya.jdField_a_of_type_Yye.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      paramyya.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      ykw.b("0X80075E9", ykw.jdField_a_of_type_Int);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.b()) && (paramBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      this.jdField_f_of_type_Boolean = true;
    }
    for (;;)
    {
      c(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_b_of_type_Boolean)
    {
      if (!d()) {
        this.jdField_a_of_type_Ynw.a(0);
      }
      bool = true;
      ykw.b("0X80075D5");
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
      if ((this.jdField_a_of_type_Ynw.a != null) && (this.jdField_a_of_type_Ynw.a.mBusinessId == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 2);
      }
      if ((this.jdField_a_of_type_Ynw.a != null) && (this.jdField_a_of_type_Ynw.a.mBusinessId == 11)) {
        bhbu.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Renew", 0, 0, new String[] { this.jdField_a_of_type_Ynw.a.mExtra.getString("troop_uin", ""), "" });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if (this.jdField_a_of_type_Ynw.a.getBussinessId() == 103) {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      this.jdField_f_of_type_Boolean = false;
      b(this.jdField_f_of_type_Boolean);
      ykw.b("0X80075D3");
      continue;
      if ((this.jdField_a_of_type_Ynw.a != null) && (this.jdField_a_of_type_Ynw.a.mBusinessId == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 3);
      }
      if ((this.jdField_a_of_type_Ynw.a != null) && (this.jdField_a_of_type_Ynw.a.mBusinessId == 11)) {
        bhbu.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rotate", 0, 0, new String[] { this.jdField_a_of_type_Ynw.a.mExtra.getString("troop_uin", ""), "" });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a(270);
      ykw.b("0X80075D4");
      continue;
      if (!c())
      {
        if ((this.jdField_a_of_type_Ynw.a != null) && (this.jdField_a_of_type_Ynw.a.mBusinessId == 3)) {
          LpReportInfo_pf00064.allReport(615, 2, 4);
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a())
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
          this.jdField_a_of_type_Ynw.a(this.jdField_a_of_type_AndroidGraphicsBitmap, false);
          if (!b()) {
            this.jdField_a_of_type_Ynw.t();
          }
          ykw.b("0X80075D2");
          yye.a(this.jdField_a_of_type_ArrayOfInt);
          continue;
          if ((this.jdField_a_of_type_Ynw.a != null) && (this.jdField_a_of_type_Ynw.a.mBusinessId == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 5);
          }
          if ((this.jdField_a_of_type_Ynw.a != null) && (this.jdField_a_of_type_Ynw.a.mBusinessId == 11)) {
            bhbu.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rephotograph", 0, 0, new String[] { this.jdField_a_of_type_Ynw.a.mExtra.getString("troop_uin", ""), "" });
          }
          a();
          continue;
          k();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylt
 * JD-Core Version:    0.7.0.1
 */