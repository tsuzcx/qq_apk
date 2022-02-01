import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.1;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.4;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.5;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class yaa
  extends xzb
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bhhi jdField_a_of_type_Bhhi;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public yaa(@NonNull xzd paramxzd)
  {
    super(paramxzd);
  }
  
  private bhhi a()
  {
    bhhi localbhhi = new bhhi(a());
    localbhhi.a(AIOUtils.dp2px(50.0F, a()));
    localbhhi.a(true);
    localbhhi.c(false);
    localbhhi.g(-1);
    localbhhi.f(0);
    localbhhi.d(-15550475);
    localbhhi.i(3);
    localbhhi.jdField_f_of_type_Boolean = true;
    localbhhi.jdField_f_of_type_Int = 2;
    localbhhi.e(true);
    localbhhi.a(new yad(this));
    return localbhhi;
  }
  
  private void i()
  {
    bcef.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource;
    CodecParam.mRecordTime = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    CodecParam.mRecordFrames = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    yjh localyjh;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      CodecParam.mSaveMode = i;
      xvv.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      localyjh = new yjh(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localyjh.b = yjx.a(2);
      localActivity = this.jdField_a_of_type_Yan.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localyjh.a = new yjn(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Xzd.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((xzb)((Iterator)localObject).next()).a(0, localyjh);
      }
      i = 0;
      break;
    }
    xvv.d("EditVideoSave", "PUBLISH start ...");
    a(amtj.a(2131703026), false, 0);
    a(2);
    Stream.of(localyjh).map(new ThreadOffFunction("EditVideoSave", 2)).map(new yjo()).map(new yji((xwj)this.jdField_a_of_type_Xzd.a(xwj.class))).map(new yjz(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new yab(this, localyjh));
  }
  
  private void j()
  {
    xvv.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
    CodecParam.mRecordTime = 5000;
    CodecParam.mRecordFrames = 125;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    yjh localyjh;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      CodecParam.mSaveMode = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource;
      localyjh = new yjh(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localyjh.b = yjx.a(2);
      localObject2 = this.jdField_a_of_type_Yan.getActivity();
      i = ((EditTakeVideoSource)localObject1).getWidth();
      j = ((EditTakeVideoSource)localObject1).getHeight();
      str = ((EditTakeVideoSource)localObject1).getSourcePath();
      f = ((EditTakeVideoSource)localObject1).getWidth() * 1.0F / ((EditTakeVideoSource)localObject1).getHeight();
      if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localyjh.a = new yjn((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Xzd.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((xzb)((Iterator)localObject1).next()).a(0, localyjh);
      }
      i = 0;
      break;
    }
    xvv.d("EditVideoSave", "PUBLISH start ...");
    a(amtj.a(2131702905), false, 0);
    a(2);
    Object localObject2 = Stream.of(localyjh).map(new ThreadOffFunction("EditVideoSave", 2)).map(new yjk());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Xzd.jdField_a_of_type_Xxs != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Xzd.jdField_a_of_type_Xxs.a(0));
    }
    ((Stream)localObject1).map(new yjw()).map(new yjg()).map(new yjz(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new yac(this, localyjh));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhhi == null) {
      return;
    }
    this.jdField_a_of_type_Bhhi.a();
    this.jdField_a_of_type_Bhhi.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bhhi.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bhhi.b(true);
    this.jdField_a_of_type_Bhhi.d(false);
    this.jdField_a_of_type_Bhhi.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramIntent != null) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramIntent.getStringExtra("fakeId")))));
      this.jdField_a_of_type_Xzd.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Yan.a().postDelayed(new EditVideoSave.1(this), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        h();
        StringBuilder localStringBuilder = new StringBuilder(amtj.a(2131702910));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.jdField_a_of_type_Yan.a(), 1, localStringBuilder, 0).a();
        return;
      }
    } while (paramInt2 != 0);
    h();
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditRecordVideoSource))
    {
      i();
      return;
    }
    j();
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561794);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373009);
      this.jdField_a_of_type_Bhhi = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bhhi);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371413)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bhhi.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    h();
    super.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Yan.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yaa
 * JD-Core Version:    0.7.0.1
 */