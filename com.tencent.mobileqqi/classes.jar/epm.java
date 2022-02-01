import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.view.View;
import android.widget.GridView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussObserver;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;

public class epm
  extends NearFieldDiscussObserver
{
  public epm(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (paramBoolean)
    {
      paramObject = (String)paramObject[1];
      if (i == this.a.jdField_b_of_type_Int)
      {
        if (!DiscussionInfo.isValidDisUin(paramObject)) {
          break label180;
        }
        this.a.finish();
        str = ContactUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a().getApplicationContext(), paramObject);
        localIntent = new Intent(this.a.a(), ChatActivity.class);
        localIntent.putExtra("uin", paramObject);
        localIntent.putExtra("uintype", 3000);
        localIntent.putExtra("uinname", str);
        localIntent.putExtra("isBack2Root", true);
        localIntent.addFlags(67108864);
        this.a.startActivity(localIntent);
      }
    }
    label180:
    while (i != this.a.jdField_b_of_type_Int)
    {
      String str;
      Intent localIntent;
      return;
      CreateFaceToFaceDiscussionActivity.a(this.a, 1, this.a.getString(2131561774));
      return;
    }
    CreateFaceToFaceDiscussionActivity.b(this.a, 1, this.a.getString(2131561774));
  }
  
  protected void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, nearfield_discuss.BusiRespHead paramBusiRespHead)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, "NearFieldDiscussObserver isSuccess = " + paramBoolean + " ; interval = " + paramInt1);
    }
    if (paramBoolean)
    {
      if (paramInt1 > 0) {
        this.a.jdField_a_of_type_Long = (paramInt1 * 1000);
      }
      if ((paramBusiRespHead != null) && (paramBusiRespHead.int32_reply_code.get() != 0))
      {
        if (!this.a.jdField_b_of_type_Boolean)
        {
          paramList = paramBusiRespHead.str_result.get();
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramList, 0).a();
          ((Animatable)this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
          if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
            this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 600L);
        }
        if (QLog.isColorLevel()) {
          QLog.i("CreateFaceToFaceDiscussionActivity", 2, "head.int32_reply_code = " + paramBusiRespHead.int32_reply_code.get());
        }
        return;
      }
      if (this.a.jdField_a_of_type_JavaUtilList == null)
      {
        this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.a.jdField_a_of_type_JavaUtilList.add(this.a.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile);
        if (paramList != null) {
          this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
        if ((paramList == null) && (QLog.isColorLevel())) {
          QLog.i("CreateFaceToFaceDiscussionActivity", 2, "usrList == null");
        }
        if (this.a.jdField_a_of_type_Epq != null)
        {
          this.a.jdField_a_of_type_Epq.notifyDataSetChanged();
          this.a.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
        }
        if (this.a.c)
        {
          this.a.c = false;
          CreateFaceToFaceDiscussionActivity.a(this.a);
          paramList = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramList, this.a.jdField_a_of_type_Long);
        }
      }
    }
    for (;;)
    {
      ((Animatable)this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.a.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      this.a.jdField_a_of_type_JavaUtilList.clear();
      break;
      if (!this.a.jdField_b_of_type_Boolean)
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131559019), 1).a();
        if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 600L);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, "on push | isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (((Integer)((Object[])(Object[])paramObject)[0]).intValue() == this.a.jdField_b_of_type_Int) && (this.a.isResume()))
    {
      if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epm
 * JD-Core Version:    0.7.0.1
 */