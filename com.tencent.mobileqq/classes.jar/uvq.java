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
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class uvq
  extends uur
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bbmh jdField_a_of_type_Bbmh;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public uvq(@NonNull uut paramuut)
  {
    super(paramuut);
  }
  
  private bbmh a()
  {
    bbmh localbbmh = new bbmh(a());
    localbbmh.a(aciy.a(50.0F, a()));
    localbbmh.a(true);
    localbbmh.c(false);
    localbbmh.f(-1);
    localbbmh.e(0);
    localbbmh.d(-15550475);
    localbbmh.g(3);
    localbbmh.jdField_f_of_type_Boolean = true;
    localbbmh.jdField_f_of_type_Int = 2;
    localbbmh.e(true);
    localbbmh.a(new uvt(this));
    return localbbmh;
  }
  
  private void i()
  {
    awqx.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    awje.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    awje.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    awje.x = 0;
    awje.E = 0;
    int i;
    vfh localvfh;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      awje.J = i;
      urk.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + awje.z + " CodecParam.mRecordTime" + awje.y);
      localvfh = new vfh(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localvfh.b = vfx.a(2);
      localActivity = this.jdField_a_of_type_Uwe.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localvfh.a = new vfn(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Uut.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((uur)((Iterator)localObject).next()).a(0, localvfh);
      }
      i = 0;
      break;
    }
    urk.d("EditVideoSave", "PUBLISH start ...");
    a(ajjy.a(2131638110), false, 0);
    a(2);
    Stream.of(localvfh).map(new ThreadOffFunction("EditVideoSave", 2)).map(new vfo()).map(new vfi((ury)this.jdField_a_of_type_Uut.a(ury.class))).map(new vfz(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new uvr(this, localvfh));
  }
  
  private void j()
  {
    urk.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + awje.z + " CodecParam.mRecordTime" + awje.y);
    awje.y = 5000;
    awje.z = 125;
    awje.x = 0;
    awje.E = 0;
    int i;
    vfh localvfh;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      awje.J = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localvfh = new vfh(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localvfh.b = vfx.a(2);
      localObject2 = this.jdField_a_of_type_Uwe.getActivity();
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      str = ((EditTakeVideoSource)localObject1).a();
      f = ((EditTakeVideoSource)localObject1).a() * 1.0F / ((EditTakeVideoSource)localObject1).b();
      if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localvfh.a = new vfn((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Uut.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((uur)((Iterator)localObject1).next()).a(0, localvfh);
      }
      i = 0;
      break;
    }
    urk.d("EditVideoSave", "PUBLISH start ...");
    a(ajjy.a(2131637986), false, 0);
    a(2);
    Object localObject2 = Stream.of(localvfh).map(new ThreadOffFunction("EditVideoSave", 2)).map(new vfk());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Uut.jdField_a_of_type_Uth != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Uut.jdField_a_of_type_Uth.a(0));
    }
    ((Stream)localObject1).map(new vfw()).map(new vfg()).map(new vfz(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new uvs(this, localvfh));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbmh == null) {
      return;
    }
    this.jdField_a_of_type_Bbmh.a();
    this.jdField_a_of_type_Bbmh.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bbmh.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bbmh.b(true);
    this.jdField_a_of_type_Bbmh.d(false);
    this.jdField_a_of_type_Bbmh.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_Uut.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long != -1L) {
          auts.a(l, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Uwe.a().postDelayed(new EditVideoSave.1(this), 500L);
          return;
          auts.a(l, -1);
        }
      }
      if (paramInt2 == 1)
      {
        g();
        auts.a(-1L, -1);
        StringBuilder localStringBuilder = new StringBuilder(ajjy.a(2131637991));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        bbmy.a(this.jdField_a_of_type_Uwe.a(), 1, localStringBuilder, 0).a();
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
    if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131495844);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131306298);
      this.jdField_a_of_type_Bbmh = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bbmh);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131304792)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bbmh.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Uwe.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvq
 * JD-Core Version:    0.7.0.1
 */