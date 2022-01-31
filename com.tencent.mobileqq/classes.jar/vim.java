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

public class vim
  extends vhn
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bcpf jdField_a_of_type_Bcpf;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public vim(@NonNull vhp paramvhp)
  {
    super(paramvhp);
  }
  
  private bcpf a()
  {
    bcpf localbcpf = new bcpf(a());
    localbcpf.a(actn.a(50.0F, a()));
    localbcpf.a(true);
    localbcpf.c(false);
    localbcpf.f(-1);
    localbcpf.e(0);
    localbcpf.d(-15550475);
    localbcpf.g(3);
    localbcpf.jdField_f_of_type_Boolean = true;
    localbcpf.jdField_f_of_type_Int = 2;
    localbcpf.e(true);
    localbcpf.a(new vip(this));
    return localbcpf;
  }
  
  private void i()
  {
    axqw.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    axik.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    axik.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    axik.x = 0;
    axik.E = 0;
    int i;
    vsd localvsd;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      axik.J = i;
      veg.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + axik.z + " CodecParam.mRecordTime" + axik.y);
      localvsd = new vsd(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localvsd.b = vst.a(2);
      localActivity = this.jdField_a_of_type_Vja.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localvsd.a = new vsj(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Vhp.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((vhn)((Iterator)localObject).next()).a(0, localvsd);
      }
      i = 0;
      break;
    }
    veg.d("EditVideoSave", "PUBLISH start ...");
    a(ajyc.a(2131703895), false, 0);
    a(2);
    Stream.of(localvsd).map(new ThreadOffFunction("EditVideoSave", 2)).map(new vsk()).map(new vse((veu)this.jdField_a_of_type_Vhp.a(veu.class))).map(new vsv(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new vin(this, localvsd));
  }
  
  private void j()
  {
    veg.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + axik.z + " CodecParam.mRecordTime" + axik.y);
    axik.y = 5000;
    axik.z = 125;
    axik.x = 0;
    axik.E = 0;
    int i;
    vsd localvsd;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      axik.J = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localvsd = new vsd(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localvsd.b = vst.a(2);
      localObject2 = this.jdField_a_of_type_Vja.getActivity();
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      str = ((EditTakeVideoSource)localObject1).a();
      f = ((EditTakeVideoSource)localObject1).a() * 1.0F / ((EditTakeVideoSource)localObject1).b();
      if ((this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localvsd.a = new vsj((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Vhp.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((vhn)((Iterator)localObject1).next()).a(0, localvsd);
      }
      i = 0;
      break;
    }
    veg.d("EditVideoSave", "PUBLISH start ...");
    a(ajyc.a(2131703771), false, 0);
    a(2);
    Object localObject2 = Stream.of(localvsd).map(new ThreadOffFunction("EditVideoSave", 2)).map(new vsg());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Vhp.jdField_a_of_type_Vgd != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Vhp.jdField_a_of_type_Vgd.a(0));
    }
    ((Stream)localObject1).map(new vss()).map(new vsc()).map(new vsv(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new vio(this, localvsd));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpf == null) {
      return;
    }
    this.jdField_a_of_type_Bcpf.a();
    this.jdField_a_of_type_Bcpf.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpf.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bcpf.b(true);
    this.jdField_a_of_type_Bcpf.d(false);
    this.jdField_a_of_type_Bcpf.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_Vhp.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long != -1L) {
          avtb.a(l, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Vja.a().postDelayed(new EditVideoSave.1(this), 500L);
          return;
          avtb.a(l, -1);
        }
      }
      if (paramInt2 == 1)
      {
        g();
        avtb.a(-1L, -1);
        StringBuilder localStringBuilder = new StringBuilder(ajyc.a(2131703776));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        bcpw.a(this.jdField_a_of_type_Vja.a(), 1, localStringBuilder, 0).a();
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
    if ((this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561435);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371995);
      this.jdField_a_of_type_Bcpf = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpf);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370453)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bcpf.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Vja.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vim
 * JD-Core Version:    0.7.0.1
 */