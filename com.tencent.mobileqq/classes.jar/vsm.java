import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.dataline.activities.PrinterActivity;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;

public class vsm
  implements ActionSheet.OnButtonClickListener
{
  public vsm(AIOGalleryScene paramAIOGalleryScene, ActionSheet paramActionSheet, AIOImageData paramAIOImageData, File paramFile, AIORichMediaInfo paramAIORichMediaInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_JavaIoFile)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramView.equals(AIOGalleryScene.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435887)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_Forward_Contacts", 0);
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, AIOGalleryScene.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.i) {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
        }
      }
      else if (paramView.equals(AIOGalleryScene.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435897)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_Forward_Qzone", 0);
        AIOGalleryUtils.a(AIOGalleryScene.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.j, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.i) {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
        }
      }
      else if (paramView.equals(AIOGalleryScene.q(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435906)))
      {
        if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b + "__qzone_pic_permission__" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d, -1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b).longValue()) == 0)
        {
          paramView = new QQCustomDialog(AIOGalleryScene.r(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), 2131624516);
          paramView.setContentView(2130968855);
          paramView.setTitle(AIOGalleryScene.s(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131429887));
          paramView.setMessage(AIOGalleryScene.t(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131429889));
          paramView.setNegativeButton(AIOGalleryScene.u(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131429890), new vsn(this));
          paramView.setCanceledOnTouchOutside(false);
          paramView.setCancelable(false);
          paramView.show();
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, "40", "1");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_Forward_Grpalbum", 0);
          AIOGalleryUtils.a(AIOGalleryScene.w(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c, -1);
        }
      }
      else if (paramView.equals(AIOGalleryScene.x(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435893)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_save", 0);
        AIOGalleryUtils.a(AIOGalleryScene.y(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.i) {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
        }
      }
      else if (paramView.equals(AIOGalleryScene.z(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435890)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.g);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
      }
      else
      {
        if (paramView.equals(AIOGalleryScene.A(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435891))) {
          for (;;)
          {
            try
            {
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.f);
              if (paramView != null) {
                break label884;
              }
              QfavBuilder.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(AIOGalleryScene.B(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b);
              QfavReport.a(null, 40, 3);
            }
            catch (RemoteException paramView)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AIOGalleryScene", 2, "", paramView);
              }
              QQToast.a(AIOGalleryScene.D(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getApplicationContext(), AIOGalleryScene.E(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131434515), 0).a();
            }
            break;
            label884:
            new QfavBuilder(paramView).a(AIOGalleryScene.C(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b);
          }
        }
        if (paramView.equals(AIOGalleryScene.F(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435898)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.s();
        }
        else
        {
          Object localObject;
          if (paramView.equals(AIOGalleryScene.G(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131427681)))
          {
            paramView = new Intent(AIOGalleryScene.H(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), PrinterActivity.class);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(this.jdField_a_of_type_JavaIoFile.getPath());
            paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
            paramView.putExtra(AlbumConstants.h, 55);
            AIOGalleryScene.I(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).startActivityForResult(paramView, 55);
          }
          else if (paramView.equals(AIOGalleryScene.J(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435899)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.t();
          }
          else if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_JavaLangString))
          {
            ScanOcrActivity.a(AIOGalleryScene.K(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
          }
          else if (paramView.equals(AIOGalleryScene.L(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435886)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonFromGroup_Manager", 2, "action sheet add to favorite.");
            }
            paramView = new Bundle();
            paramView.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.h);
            localObject = new vso(this);
            QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", paramView, (EIPCResultCallback)localObject);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.i) {
              VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
            }
          }
          else if (paramView.equals(AIOGalleryScene.N(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131430138)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonFromGroup_Manager", 2, "action sheet share weiyun.");
            }
            paramView = new Bundle();
            paramView.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.h);
            QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", paramView, null);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.i) {
              VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
            }
          }
          else if ((paramView.equals(AIOGalleryScene.O(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131433029))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.i))
          {
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "6", "", "", "", "", 0, 0, 0, 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsm
 * JD-Core Version:    0.7.0.1
 */