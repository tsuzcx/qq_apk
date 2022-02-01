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
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class aawu
  extends achz
{
  public aawu(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  protected void R(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int j = ((Integer)paramObject[0]).intValue();
    int i = -1;
    if (paramObject.length == 3) {
      i = ((Integer)paramObject[2]).intValue();
    }
    if (this.this$0.c != null)
    {
      this.this$0.c.dismiss();
      this.this$0.c = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CreateFaceToFaceDiscussionActivity", 2, "onGetNearFieldDiscussInfo " + paramBoolean + " mSessionId=" + this.this$0.aea + " sessionId=" + j);
    }
    if (paramBoolean)
    {
      paramObject = (String)paramObject[1];
      if (j == this.this$0.aea)
      {
        if ((i != 0) || (!DiscussionInfo.isValidDisUin(paramObject))) {
          break label256;
        }
        this.this$0.finish();
        localObject = aqgv.b(this.this$0.app, this.this$0.getActivity().getApplicationContext(), paramObject);
        localIntent = wja.a(new Intent(this.this$0.getActivity(), SplashActivity.class), null);
        localIntent.putExtra("uin", paramObject);
        localIntent.putExtra("uintype", 3000);
        localIntent.putExtra("uinname", (String)localObject);
        localIntent.putExtra("isBack2Root", true);
        this.this$0.startActivity(localIntent);
      }
    }
    label256:
    while (j != this.this$0.aea)
    {
      Object localObject;
      Intent localIntent;
      return;
      if ((i == 2) || (i == 1))
      {
        this.this$0.finish();
        localObject = wja.a(new Intent(this.this$0.getActivity(), SplashActivity.class), null);
        ((Intent)localObject).putExtra("uin", paramObject);
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("uinname", aqgv.n(this.this$0.app, this.this$0.app.getCurrentAccountUin()) + acfp.m(2131704519));
        ((Intent)localObject).putExtra("isBack2Root", true);
        this.this$0.startActivity((Intent)localObject);
        anot.a(this.this$0.app, "dc00899", "Grp_create", "", "f2f", "cre_suc", 0, 0, paramObject, "", "", "");
        return;
      }
      CreateFaceToFaceDiscussionActivity.a(this.this$0, 1, this.this$0.getString(2131693401));
      return;
    }
    CreateFaceToFaceDiscussionActivity.b(this.this$0, 1, this.this$0.getString(2131693401));
  }
  
  protected void S(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, "on push | isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (((Integer)((Object[])(Object[])paramObject)[0]).intValue() == this.this$0.aea) && (this.this$0.isResume()))
    {
      if (this.this$0.mHandler.hasMessages(0)) {
        this.this$0.mHandler.removeMessages(0);
      }
      this.this$0.mHandler.sendEmptyMessage(0);
    }
  }
  
  protected void a(boolean paramBoolean, List<nearfield_discuss.UserProfile> paramList, int paramInt1, int paramInt2, nearfield_discuss.BusiRespHead paramBusiRespHead, int paramInt3, int paramInt4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, "NearFieldDiscussObserver isSuccess = " + paramBoolean + " ; interval = " + paramInt1);
    }
    Object localObject;
    if (paramBoolean)
    {
      if (paramInt1 > 0) {
        this.this$0.mInterval = (paramInt1 * 1000);
      }
      if ((paramBusiRespHead != null) && (paramBusiRespHead.int32_reply_code.get() != 0))
      {
        if (!this.this$0.bAB)
        {
          paramList = paramBusiRespHead.str_result.get();
          QQToast.a(this.this$0.mContext, paramList, 0).show();
          ((Animatable)this.this$0.mProgressDrawable).stop();
          this.this$0.progress.setVisibility(4);
          if (this.this$0.mHandler.hasMessages(1)) {
            this.this$0.mHandler.removeMessages(1);
          }
          this.this$0.mHandler.sendEmptyMessageDelayed(1, 600L);
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
                break label1094;
              }
              paramBusiRespHead = ((nearfield_discuss.UserProfile)localObject).str_nick.get();
            }
          }
        }
      }
    }
    label1094:
    for (;;)
    {
      break;
      switch (paramInt4)
      {
      default: 
        if (this.this$0.vx == null)
        {
          this.this$0.vx = new ArrayList();
          label364:
          this.this$0.vx.add(this.this$0.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile);
          if (paramList != null) {
            this.this$0.vx.addAll(paramList);
          }
          if ((paramList == null) && (QLog.isColorLevel())) {
            QLog.i("CreateFaceToFaceDiscussionActivity", 2, "usrList == null");
          }
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$a != null)
          {
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$a.notifyDataSetChanged();
            this.this$0.k.setVisibility(0);
          }
          if (this.this$0.bAD)
          {
            this.this$0.bAD = false;
            CreateFaceToFaceDiscussionActivity.a(this.this$0);
            paramList = this.this$0.mHandler.obtainMessage(0);
            this.this$0.mHandler.sendMessageDelayed(paramList, this.this$0.mInterval);
          }
        }
        break;
      }
      for (;;)
      {
        ((Animatable)this.this$0.mProgressDrawable).stop();
        this.this$0.progress.setBackgroundDrawable(null);
        this.this$0.progress.setVisibility(8);
        return;
        CreateFaceToFaceDiscussionActivity.a(this.this$0).setText(this.this$0.getString(2131689891));
        CreateFaceToFaceDiscussionActivity.a(this.this$0).setContentDescription(this.this$0.getString(2131689891));
        this.this$0.OB.setText(this.this$0.getString(2131719419));
        this.this$0.OB.setContentDescription(this.this$0.getString(2131719419));
        this.this$0.OC.setText(this.this$0.getString(2131719420));
        this.this$0.OC.setContentDescription(this.this$0.getString(2131719420));
        this.this$0.fo.setTextColor(this.this$0.getResources().getColor(2131167335));
        this.this$0.fo.setBackgroundResource(2130839524);
        this.this$0.fo.setText(acfp.m(2131704518));
        this.this$0.OD.setVisibility(0);
        this.this$0.OD.setText(this.this$0.getString(2131719424));
        break;
        this.this$0.aCH = false;
        this.this$0.fo.setVisibility(0);
        this.this$0.OD.setVisibility(0);
        this.this$0.OD.setText(this.this$0.getString(2131719426, new Object[] { localObject }));
        this.this$0.fo.setText(this.this$0.getString(2131719422));
        this.this$0.fo.setTextColor(-1);
        this.this$0.fo.setContentDescription(this.this$0.getString(2131719422));
        this.this$0.fo.setBackgroundResource(2130839524);
        break;
        this.this$0.aCH = true;
        this.this$0.fo.setVisibility(0);
        this.this$0.OD.setVisibility(0);
        this.this$0.OD.setText(this.this$0.getString(2131719425, new Object[] { localObject }));
        this.this$0.fo.setText(this.this$0.getString(2131719423));
        this.this$0.fo.setTextColor(-1);
        this.this$0.fo.setContentDescription(this.this$0.getString(2131719423));
        this.this$0.fo.setBackgroundResource(2130839524);
        break;
        this.this$0.vx.clear();
        break label364;
        if (!this.this$0.bAB)
        {
          QQToast.a(this.this$0.mContext, acfp.m(2131704516), 1).show();
          if (this.this$0.mHandler.hasMessages(1)) {
            this.this$0.mHandler.removeMessages(1);
          }
          this.this$0.mHandler.sendEmptyMessageDelayed(1, 600L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawu
 * JD-Core Version:    0.7.0.1
 */