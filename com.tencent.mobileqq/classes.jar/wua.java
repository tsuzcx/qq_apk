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
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class wua
  extends wwc
  implements View.OnClickListener, xbu
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
  
  public wua(@NonNull wwe paramwwe)
  {
    super(paramwwe);
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wwe == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Wwe.a.a();
    } while (!QLog.isColorLevel());
    QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + i + ",hasModified" + paramBoolean);
  }
  
  private boolean b()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_Wwe.a.a();
    if (i == 103) {
      this.jdField_a_of_type_Wwe.e();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
      }
      return bool;
      if (i == 11) {
        this.jdField_a_of_type_Wwe.e();
      } else {
        bool = false;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Wwe.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropRectChanged , bussiId = " + i + ",hasModified" + paramBoolean);
    }
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_Wwe.a.a();
    this.jdField_e_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",intercepte = " + false);
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_Wwe.a.a();
    if ((i == 103) || (i == 11))
    {
      bool = true;
      this.jdField_a_of_type_Wwe.d();
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
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364819));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView = ((CropView)a(2131364937));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setCropListener(this);
      this.jdField_a_of_type_AndroidViewView = a(2131364932);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131364935);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364817));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131363915));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131364936));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364931));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131364933));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131377137));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131370214));
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
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (localBitmap != this.jdField_a_of_type_Wwe.a())) {
      localBitmap.recycle();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_Wwe.a())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Wwe.a.a() == 103)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699573);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (this.jdField_a_of_type_Wwe.a.a() != 11) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131720951));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(2131720952));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(a(2131720953));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColor(2131166932));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a().getDrawable(2130849408));
    this.jdField_a_of_type_AndroidWidgetTextView.setMinWidth(aekt.a(62.0F, a()));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    bdaj.a("Grp_edu", "Grp_oral", "Oral_Photoedit_In", 0, 0, new String[] { this.jdField_a_of_type_Wwe.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
  }
  
  private void k() {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 7) && (this.jdField_a_of_type_Wxp != null) && (this.jdField_a_of_type_Wxp.getActivity() != null)) {
      QQToast.a(this.jdField_a_of_type_Wxp.getActivity().getApplicationContext(), this.jdField_a_of_type_Wxp.getActivity().getResources().getString(2131720885), 0).a();
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
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    xgw localxgw = paramxgs.jdField_a_of_type_Xgw;
    localxgw.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      paramxgs.jdField_a_of_type_Xgw.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      paramxgs.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      wtb.b("0X80075E9", wtb.jdField_a_of_type_Int);
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
        this.jdField_a_of_type_Wwe.a(0);
      }
      bool = true;
      wtb.b("0X80075D5");
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364932: 
    case 2131364935: 
    case 2131364817: 
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_Wwe != null) && (this.jdField_a_of_type_Wwe.a != null) && (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 2);
          }
          if ((this.jdField_a_of_type_Wwe != null) && (this.jdField_a_of_type_Wwe.a != null) && (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 11)) {
            bdaj.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Renew", 0, 0, new String[] { this.jdField_a_of_type_Wwe.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidViewView.setEnabled(false);
          if (!this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          if ((this.jdField_a_of_type_Wwe != null) && (this.jdField_a_of_type_Wwe.a.a() == 103)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          this.jdField_f_of_type_Boolean = false;
          b(this.jdField_f_of_type_Boolean);
          wtb.b("0X80075D3");
          return;
          if ((this.jdField_a_of_type_Wwe != null) && (this.jdField_a_of_type_Wwe.a != null) && (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 3);
          }
          if ((this.jdField_a_of_type_Wwe != null) && (this.jdField_a_of_type_Wwe.a != null) && (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 11)) {
            bdaj.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rotate", 0, 0, new String[] { this.jdField_a_of_type_Wwe.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a(270);
          wtb.b("0X80075D4");
          return;
        } while (c());
        if ((this.jdField_a_of_type_Wwe != null) && (this.jdField_a_of_type_Wwe.a != null) && (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 2, 4);
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = true;
      } while (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a());
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
      this.jdField_a_of_type_Wwe.a(this.jdField_a_of_type_AndroidGraphicsBitmap, false);
      if (!b()) {
        this.jdField_a_of_type_Wwe.t();
      }
      wtb.b("0X80075D2");
      xgw.a(this.jdField_a_of_type_ArrayOfInt);
      return;
    case 2131363915: 
      if ((this.jdField_a_of_type_Wwe != null) && (this.jdField_a_of_type_Wwe.a != null) && (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 5);
      }
      if ((this.jdField_a_of_type_Wwe != null) && (this.jdField_a_of_type_Wwe.a != null) && (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 11)) {
        bdaj.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rephotograph", 0, 0, new String[] { this.jdField_a_of_type_Wwe.a.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
      }
      a();
      return;
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wua
 * JD-Core Version:    0.7.0.1
 */