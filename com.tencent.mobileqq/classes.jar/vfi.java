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
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class vfi
  extends vhk
  implements View.OnClickListener, vnc
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
  
  public vfi(@NonNull vhm paramvhm)
  {
    super(paramvhm);
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vhm == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Vhm.a.a();
    } while (!QLog.isColorLevel());
    QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + i + ",hasModified" + paramBoolean);
  }
  
  private boolean b()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_Vhm.a.a();
    if (i == 103) {
      this.jdField_a_of_type_Vhm.e();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
      }
      return bool;
      if (i == 11) {
        this.jdField_a_of_type_Vhm.e();
      } else {
        bool = false;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Vhm.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropRectChanged , bussiId = " + i + ",hasModified" + paramBoolean);
    }
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_Vhm.a.a();
    this.jdField_e_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",intercepte = " + false);
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_Vhm.a.a();
    if ((i == 103) || (i == 11))
    {
      bool = true;
      this.jdField_a_of_type_Vhm.d();
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
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364740));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView = ((CropView)a(2131364850));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setCropListener(this);
      this.jdField_a_of_type_AndroidViewView = a(2131364846);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131364848);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364738));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131363858));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131364849));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364845));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131364847));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131376629));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131369948));
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
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (localBitmap != this.jdField_a_of_type_Vhm.a())) {
      localBitmap.recycle();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_Vhm.a())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Vhm.a.a() == 103)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699227);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (this.jdField_a_of_type_Vhm.a.a() != 11) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131720413));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(2131720414));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(a(2131720415));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColor(2131166885));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a().getDrawable(2130848977));
    this.jdField_a_of_type_AndroidWidgetTextView.setMinWidth(actj.a(62.0F, a()));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    bbbp.a("Grp_edu", "Grp_oral", "Oral_Photoedit_In", 0, 0, new String[] { this.jdField_a_of_type_Vhm.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
  }
  
  private void k() {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 7) && (this.jdField_a_of_type_Vix != null) && (this.jdField_a_of_type_Vix.getActivity() != null)) {
      bcql.a(this.jdField_a_of_type_Vix.getActivity().getApplicationContext(), this.jdField_a_of_type_Vix.getActivity().getResources().getString(2131720349), 0).a();
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
  
  public void a(int paramInt, @NonNull vsa paramvsa)
  {
    vse localvse = paramvsa.jdField_a_of_type_Vse;
    localvse.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      paramvsa.jdField_a_of_type_Vse.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      paramvsa.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      vej.b("0X80075E9", vej.jdField_a_of_type_Int);
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
        this.jdField_a_of_type_Vhm.a(0);
      }
      bool = true;
      vej.b("0X80075D5");
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364846: 
    case 2131364848: 
    case 2131364738: 
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.a != null) && (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 2);
          }
          if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.a != null) && (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 11)) {
            bbbp.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Renew", 0, 0, new String[] { this.jdField_a_of_type_Vhm.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidViewView.setEnabled(false);
          if (!this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.a.a() == 103)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          this.jdField_f_of_type_Boolean = false;
          b(this.jdField_f_of_type_Boolean);
          vej.b("0X80075D3");
          return;
          if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.a != null) && (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 3);
          }
          if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.a != null) && (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 11)) {
            bbbp.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rotate", 0, 0, new String[] { this.jdField_a_of_type_Vhm.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a(270);
          vej.b("0X80075D4");
          return;
        } while (c());
        if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.a != null) && (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 2, 4);
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = true;
      } while (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a());
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
      this.jdField_a_of_type_Vhm.a(this.jdField_a_of_type_AndroidGraphicsBitmap, false);
      if (!b()) {
        this.jdField_a_of_type_Vhm.t();
      }
      vej.b("0X80075D2");
      vse.a(this.jdField_a_of_type_ArrayOfInt);
      return;
    case 2131363858: 
      if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.a != null) && (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 5);
      }
      if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.a != null) && (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 11)) {
        bbbp.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rephotograph", 0, 0, new String[] { this.jdField_a_of_type_Vhm.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
      }
      a();
      return;
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfi
 * JD-Core Version:    0.7.0.1
 */