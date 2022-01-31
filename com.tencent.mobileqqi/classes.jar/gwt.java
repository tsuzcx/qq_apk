import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class gwt
  extends AsyncTask
{
  public gwt(VideoPlayLogic paramVideoPlayLogic, TroopInfoManager paramTroopInfoManager) {}
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a();
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic)))
    {
      if (TroopFileUtils.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic)) == 0)
      {
        if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null) && (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isShowing() == true)) {
          VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).dismiss();
        }
        QQToast.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic), VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).getResources().getString(2131560679), 1).a();
        return;
      }
      if (TroopFileUtils.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic)) != 2)
      {
        if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null) && (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isShowing() == true)) {
          VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).dismiss();
        }
        DialogUtil.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic), 230, VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).getString(2131560332), VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).getString(2131560430), 2131561746, 2131560431, new gwu(this), new gwv(this)).show();
        return;
      }
      VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic);
      return;
    }
    if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null) && (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isShowing() == true)) {
      VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).dismiss();
    }
    new StructMsgForGeneralShare.GeneralClickHandler(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic), VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic), VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic)).a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic));
  }
  
  protected void onCancelled()
  {
    if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null) && (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isShowing() == true)) {
      VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gwt
 * JD-Core Version:    0.7.0.1
 */