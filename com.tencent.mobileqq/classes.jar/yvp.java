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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class yvp
  extends yxr
  implements View.OnClickListener, zdj
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
  
  public yvp(@NonNull yxt paramyxt)
  {
    super(paramyxt);
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yxt == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Yxt.a.a();
    } while (!QLog.isColorLevel());
    QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + i + ",hasModified" + paramBoolean);
  }
  
  private boolean b()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_Yxt.a.a();
    if (i == 103) {
      this.jdField_a_of_type_Yxt.e();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
      }
      return bool;
      if (i == 11) {
        this.jdField_a_of_type_Yxt.e();
      } else {
        bool = false;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Yxt.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropRectChanged , bussiId = " + i + ",hasModified" + paramBoolean);
    }
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_Yxt.a.a();
    this.jdField_e_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",intercepte = " + false);
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_Yxt.a.a();
    if ((i == 103) || (i == 11))
    {
      bool = true;
      this.jdField_a_of_type_Yxt.d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiBackPressed , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365099));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView = ((CropView)a(2131365217));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setCropListener(this);
      this.jdField_a_of_type_AndroidViewView = a(2131365213);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131365215);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365097));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364161));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131365216));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365212));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131365214));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131378151));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131370781));
    }
  }
  
  private void g()
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
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (localBitmap != this.jdField_a_of_type_Yxt.a())) {
      localBitmap.recycle();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_Yxt.a())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Yxt.a.a() == 103)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698221);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (this.jdField_a_of_type_Yxt.a.a() != 11) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131718829));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(2131718830));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(a(2131718831));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColor(2131167023));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a().getDrawable(2130850044));
    this.jdField_a_of_type_AndroidWidgetTextView.setMinWidth(agej.a(62.0F, a()));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    bhju.a("Grp_edu", "Grp_oral", "Oral_Photoedit_In", 0, 0, new String[] { this.jdField_a_of_type_Yxt.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
  }
  
  private void k() {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 7) && (this.jdField_a_of_type_Yze != null) && (this.jdField_a_of_type_Yze.getActivity() != null)) {
      QQToast.a(this.jdField_a_of_type_Yze.getActivity().getApplicationContext(), this.jdField_a_of_type_Yze.getActivity().getResources().getString(2131718771), 0).a();
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    f();
    if (paramInt == 11) {
      if (!this.jdField_b_of_type_Boolean) {
        g();
      }
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    i();
  }
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    zil localzil = paramzih.jdField_a_of_type_Zil;
    localzil.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      paramzih.jdField_a_of_type_Zil.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      yuq.b("0X80075E9", yuq.jdField_a_of_type_Int);
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
        this.jdField_a_of_type_Yxt.a(0);
      }
      bool = true;
      yuq.b("0X80075D5");
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
      if ((this.jdField_a_of_type_Yxt != null) && (this.jdField_a_of_type_Yxt.a != null) && (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 2);
      }
      if ((this.jdField_a_of_type_Yxt != null) && (this.jdField_a_of_type_Yxt.a != null) && (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 11)) {
        bhju.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Renew", 0, 0, new String[] { this.jdField_a_of_type_Yxt.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if ((this.jdField_a_of_type_Yxt != null) && (this.jdField_a_of_type_Yxt.a.a() == 103)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      this.jdField_f_of_type_Boolean = false;
      b(this.jdField_f_of_type_Boolean);
      yuq.b("0X80075D3");
      continue;
      if ((this.jdField_a_of_type_Yxt != null) && (this.jdField_a_of_type_Yxt.a != null) && (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 3);
      }
      if ((this.jdField_a_of_type_Yxt != null) && (this.jdField_a_of_type_Yxt.a != null) && (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 11)) {
        bhju.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rotate", 0, 0, new String[] { this.jdField_a_of_type_Yxt.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a(270);
      yuq.b("0X80075D4");
      continue;
      if (!c())
      {
        if ((this.jdField_a_of_type_Yxt != null) && (this.jdField_a_of_type_Yxt.a != null) && (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 2, 4);
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a())
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
          this.jdField_a_of_type_Yxt.a(this.jdField_a_of_type_AndroidGraphicsBitmap, false);
          if (!b()) {
            this.jdField_a_of_type_Yxt.t();
          }
          yuq.b("0X80075D2");
          zil.a(this.jdField_a_of_type_ArrayOfInt);
          continue;
          if ((this.jdField_a_of_type_Yxt != null) && (this.jdField_a_of_type_Yxt.a != null) && (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 5);
          }
          if ((this.jdField_a_of_type_Yxt != null) && (this.jdField_a_of_type_Yxt.a != null) && (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 11)) {
            bhju.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rephotograph", 0, 0, new String[] { this.jdField_a_of_type_Yxt.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
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
 * Qualified Name:     yvp
 * JD-Core Version:    0.7.0.1
 */