import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
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
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class wxb
  extends wwc
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bepe jdField_a_of_type_Bepe;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public wxb(@NonNull wwe paramwwe)
  {
    super(paramwwe);
  }
  
  private bepe a()
  {
    bepe localbepe = new bepe(a());
    localbepe.a(aekt.a(50.0F, a()));
    localbepe.a(true);
    localbepe.c(false);
    localbepe.f(-1);
    localbepe.e(0);
    localbepe.d(-15550475);
    localbepe.g(3);
    localbepe.jdField_f_of_type_Boolean = true;
    localbepe.jdField_f_of_type_Int = 2;
    localbepe.e(true);
    localbepe.a(new wxe(this));
    return localbepe;
  }
  
  private void i()
  {
    azmj.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    azds.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    azds.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    azds.x = 0;
    azds.E = 0;
    int i;
    xgs localxgs;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      azds.J = i;
      wsv.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + azds.z + " CodecParam.mRecordTime" + azds.y);
      localxgs = new xgs(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localxgs.b = xhi.a(2);
      localActivity = this.jdField_a_of_type_Wxp.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localxgs.a = new xgy(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Wwe.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((wwc)((Iterator)localObject).next()).a(0, localxgs);
      }
      i = 0;
      break;
    }
    wsv.d("EditVideoSave", "PUBLISH start ...");
    a(alpo.a(2131704278), false, 0);
    a(2);
    Stream.of(localxgs).map(new ThreadOffFunction("EditVideoSave", 2)).map(new xgz()).map(new xgt((wtj)this.jdField_a_of_type_Wwe.a(wtj.class))).map(new xhk(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new wxc(this, localxgs));
  }
  
  private void j()
  {
    wsv.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + azds.z + " CodecParam.mRecordTime" + azds.y);
    azds.y = 5000;
    azds.z = 125;
    azds.x = 0;
    azds.E = 0;
    int i;
    xgs localxgs;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      azds.J = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localxgs = new xgs(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localxgs.b = xhi.a(2);
      localObject2 = this.jdField_a_of_type_Wxp.getActivity();
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      str = ((EditTakeVideoSource)localObject1).a();
      f = ((EditTakeVideoSource)localObject1).a() * 1.0F / ((EditTakeVideoSource)localObject1).b();
      if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localxgs.a = new xgy((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Wwe.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((wwc)((Iterator)localObject1).next()).a(0, localxgs);
      }
      i = 0;
      break;
    }
    wsv.d("EditVideoSave", "PUBLISH start ...");
    a(alpo.a(2131704154), false, 0);
    a(2);
    Object localObject2 = Stream.of(localxgs).map(new ThreadOffFunction("EditVideoSave", 2)).map(new xgv());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Wwe.jdField_a_of_type_Wus != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Wwe.jdField_a_of_type_Wus.a(0));
    }
    ((Stream)localObject1).map(new xhh()).map(new xgr()).map(new xhk(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new wxd(this, localxgs));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bepe == null) {
      return;
    }
    this.jdField_a_of_type_Bepe.a();
    this.jdField_a_of_type_Bepe.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bepe.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bepe.b(true);
    this.jdField_a_of_type_Bepe.d(false);
    this.jdField_a_of_type_Bepe.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_Wwe.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long != -1L) {
          axlc.a(l, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Wxp.a().postDelayed(new EditVideoSave.1(this), 500L);
          return;
          axlc.a(l, -1);
        }
      }
      if (paramInt2 == 1)
      {
        g();
        axlc.a(-1L, -1);
        StringBuilder localStringBuilder = new StringBuilder(alpo.a(2131704159));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.jdField_a_of_type_Wxp.a(), 1, localStringBuilder, 0).a();
        return;
      }
    } while (paramInt2 != 0);
    g();
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561624);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372312);
      this.jdField_a_of_type_Bepe = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bepe);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370758)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bepe.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Wxp.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxb
 * JD-Core Version:    0.7.0.1
 */