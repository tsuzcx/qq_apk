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

public class yot
  extends ynu
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bisa jdField_a_of_type_Bisa;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public yot(@NonNull ynw paramynw)
  {
    super(paramynw);
  }
  
  private bisa a()
  {
    bisa localbisa = new bisa(a());
    localbisa.a(AIOUtils.dp2px(50.0F, a()));
    localbisa.a(true);
    localbisa.c(false);
    localbisa.g(-1);
    localbisa.f(0);
    localbisa.d(-15550475);
    localbisa.i(3);
    localbisa.jdField_f_of_type_Boolean = true;
    localbisa.jdField_f_of_type_Int = 2;
    localbisa.e(true);
    localbisa.a(new yow(this));
    return localbisa;
  }
  
  private void i()
  {
    bdla.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource;
    CodecParam.mRecordTime = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    CodecParam.mRecordFrames = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    yya localyya;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      CodecParam.mSaveMode = i;
      ykq.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      localyya = new yya(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localyya.b = yyq.a(2);
      localActivity = this.jdField_a_of_type_Ypg.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localyya.a = new yyg(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Ynw.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ynu)((Iterator)localObject).next()).a(0, localyya);
      }
      i = 0;
      break;
    }
    ykq.d("EditVideoSave", "PUBLISH start ...");
    a(anvx.a(2131703377), false, 0);
    a(2);
    Stream.of(localyya).map(new ThreadOffFunction("EditVideoSave", 2)).map(new yyh()).map(new yyb((ylc)this.jdField_a_of_type_Ynw.a(ylc.class))).map(new yys(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new you(this, localyya));
  }
  
  private void j()
  {
    ykq.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
    CodecParam.mRecordTime = 5000;
    CodecParam.mRecordFrames = 125;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    yya localyya;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      CodecParam.mSaveMode = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource;
      localyya = new yya(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localyya.b = yyq.a(2);
      localObject2 = this.jdField_a_of_type_Ypg.getActivity();
      i = ((EditTakeVideoSource)localObject1).getWidth();
      j = ((EditTakeVideoSource)localObject1).getHeight();
      str = ((EditTakeVideoSource)localObject1).getSourcePath();
      f = ((EditTakeVideoSource)localObject1).getWidth() * 1.0F / ((EditTakeVideoSource)localObject1).getHeight();
      if ((this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localyya.a = new yyg((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Ynw.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ynu)((Iterator)localObject1).next()).a(0, localyya);
      }
      i = 0;
      break;
    }
    ykq.d("EditVideoSave", "PUBLISH start ...");
    a(anvx.a(2131703256), false, 0);
    a(2);
    Object localObject2 = Stream.of(localyya).map(new ThreadOffFunction("EditVideoSave", 2)).map(new yyd());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Ynw.jdField_a_of_type_Yml != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Ynw.jdField_a_of_type_Yml.a(0));
    }
    ((Stream)localObject1).map(new yyp()).map(new yxz()).map(new yys(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new yov(this, localyya));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisa == null) {
      return;
    }
    this.jdField_a_of_type_Bisa.a();
    this.jdField_a_of_type_Bisa.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bisa.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bisa.b(true);
    this.jdField_a_of_type_Bisa.d(false);
    this.jdField_a_of_type_Bisa.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_Ynw.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Ypg.a().postDelayed(new EditVideoSave.1(this), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        h();
        StringBuilder localStringBuilder = new StringBuilder(anvx.a(2131703261));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.jdField_a_of_type_Ypg.a(), 1, localStringBuilder, 0).a();
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
    if ((this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditRecordVideoSource))
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561862);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373219);
      this.jdField_a_of_type_Bisa = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bisa);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371598)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bisa.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    h();
    super.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Ypg.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yot
 * JD-Core Version:    0.7.0.1
 */