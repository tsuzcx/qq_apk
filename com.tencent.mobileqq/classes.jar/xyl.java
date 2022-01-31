import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class xyl
  extends NearFieldDiscussObserver
{
  public xyl(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int j = ((Integer)paramObject[0]).intValue();
    int i = -1;
    if (paramObject.length == 3) {
      i = ((Integer)paramObject[2]).intValue();
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CreateFaceToFaceDiscussionActivity", 2, "onGetNearFieldDiscussInfo " + paramBoolean + " mSessionId=" + this.a.jdField_a_of_type_Int + " sessionId=" + j);
    }
    if (paramBoolean)
    {
      paramObject = (String)paramObject[1];
      if (j == this.a.jdField_a_of_type_Int)
      {
        if ((i != 0) || (!DiscussionInfo.isValidDisUin(paramObject))) {
          break label256;
        }
        this.a.finish();
        localObject = ContactUtils.a(this.a.app, this.a.getActivity().getApplicationContext(), paramObject);
        localIntent = AIOUtils.a(new Intent(this.a.getActivity(), SplashActivity.class), null);
        localIntent.putExtra("uin", paramObject);
        localIntent.putExtra("uintype", 3000);
        localIntent.putExtra("uinname", (String)localObject);
        localIntent.putExtra("isBack2Root", true);
        this.a.startActivity(localIntent);
      }
    }
    label256:
    while (j != this.a.jdField_a_of_type_Int)
    {
      Object localObject;
      Intent localIntent;
      return;
      if ((i == 2) || (i == 1))
      {
        this.a.finish();
        localObject = AIOUtils.a(new Intent(this.a.getActivity(), SplashActivity.class), null);
        ((Intent)localObject).putExtra("uin", paramObject);
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("uinname", ContactUtils.j(this.a.app, this.a.app.getCurrentAccountUin()) + "创建的群");
        ((Intent)localObject).putExtra("isBack2Root", true);
        this.a.startActivity((Intent)localObject);
        ReportController.b(this.a.app, "dc00899", "Grp_create", "", "f2f", "cre_suc", 0, 0, paramObject, "", "", "");
        return;
      }
      CreateFaceToFaceDiscussionActivity.a(this.a, 1, this.a.getString(2131437179));
      return;
    }
    CreateFaceToFaceDiscussionActivity.b(this.a, 1, this.a.getString(2131437179));
  }
  
  protected void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, nearfield_discuss.BusiRespHead paramBusiRespHead, int paramInt3, int paramInt4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, "NearFieldDiscussObserver isSuccess = " + paramBoolean + " ; interval = " + paramInt1);
    }
    Object localObject;
    if (paramBoolean)
    {
      if (paramInt1 > 0) {
        this.a.jdField_a_of_type_Long = (paramInt1 * 1000);
      }
      if ((paramBusiRespHead != null) && (paramBusiRespHead.int32_reply_code.get() != 0))
      {
        if (!this.a.jdField_c_of_type_Boolean)
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
      paramBusiRespHead = "";
      localObject = paramBusiRespHead;
      if (paramList != null)
      {
        localObject = paramBusiRespHead;
        if (paramLong != 0L)
        {
          localObject = paramBusiRespHead;
          if (paramInt4 != 0)
          {
            Iterator localIterator = paramList.iterator();
            localObject = paramBusiRespHead;
            if (localIterator.hasNext())
            {
              localObject = (nearfield_discuss.UserProfile)localIterator.next();
              if (((nearfield_discuss.UserProfile)localObject).uint64_uin.get() != paramLong) {
                break label1088;
              }
              paramBusiRespHead = ((nearfield_discuss.UserProfile)localObject).str_nick.get();
            }
          }
        }
      }
    }
    label1088:
    for (;;)
    {
      break;
      switch (paramInt4)
      {
      default: 
        if (this.a.jdField_a_of_type_JavaUtilList == null)
        {
          this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
          label364:
          this.a.jdField_a_of_type_JavaUtilList.add(this.a.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile);
          if (paramList != null) {
            this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
          }
          if ((paramList == null) && (QLog.isColorLevel())) {
            QLog.i("CreateFaceToFaceDiscussionActivity", 2, "usrList == null");
          }
          if (this.a.jdField_a_of_type_Xyo != null)
          {
            this.a.jdField_a_of_type_Xyo.notifyDataSetChanged();
            this.a.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
          }
          if (this.a.d)
          {
            this.a.d = false;
            CreateFaceToFaceDiscussionActivity.a(this.a);
            paramList = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramList, this.a.jdField_a_of_type_Long);
          }
        }
        break;
      }
      for (;;)
      {
        ((Animatable)this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.a.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
        CreateFaceToFaceDiscussionActivity.a(this.a).setText(this.a.getString(2131435499));
        CreateFaceToFaceDiscussionActivity.a(this.a).setContentDescription(this.a.getString(2131435499));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131435971));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.a.getString(2131435971));
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.getString(2131435973));
        this.a.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.a.getString(2131435973));
        this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.a.getResources().getColor(2131494236));
        this.a.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838491);
        this.a.jdField_a_of_type_AndroidWidgetButton.setText("立即创建");
        this.a.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setText(this.a.getString(2131435978));
        break;
        this.a.jdField_b_of_type_Boolean = false;
        this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setText(this.a.getString(2131435980, new Object[] { localObject }));
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.getString(2131435976));
        this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
        this.a.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.a.getString(2131435976));
        this.a.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838491);
        break;
        this.a.jdField_b_of_type_Boolean = true;
        this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setText(this.a.getString(2131435979, new Object[] { localObject }));
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.getString(2131435977));
        this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
        this.a.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.a.getString(2131435977));
        this.a.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838491);
        break;
        this.a.jdField_a_of_type_JavaUtilList.clear();
        break label364;
        if (!this.a.jdField_c_of_type_Boolean)
        {
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "请稍后再试", 1).a();
          if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
            this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 600L);
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, "on push | isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (((Integer)((Object[])(Object[])paramObject)[0]).intValue() == this.a.jdField_a_of_type_Int) && (this.a.isResume()))
    {
      if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyl
 * JD-Core Version:    0.7.0.1
 */