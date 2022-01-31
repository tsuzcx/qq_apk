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

public class xbk
  extends xal
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  betn jdField_a_of_type_Betn;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public xbk(@NonNull xan paramxan)
  {
    super(paramxan);
  }
  
  private betn a()
  {
    betn localbetn = new betn(a());
    localbetn.a(aepi.a(50.0F, a()));
    localbetn.a(true);
    localbetn.c(false);
    localbetn.f(-1);
    localbetn.e(0);
    localbetn.d(-15550475);
    localbetn.g(3);
    localbetn.jdField_f_of_type_Boolean = true;
    localbetn.jdField_f_of_type_Int = 2;
    localbetn.e(true);
    localbetn.a(new xbn(this));
    return localbetn;
  }
  
  private void i()
  {
    azqs.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    azib.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    azib.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    azib.x = 0;
    azib.E = 0;
    int i;
    xlb localxlb;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      azib.J = i;
      wxe.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + azib.z + " CodecParam.mRecordTime" + azib.y);
      localxlb = new xlb(this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localxlb.b = xlr.a(2);
      localActivity = this.jdField_a_of_type_Xby.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localxlb.a = new xlh(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Xan.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((xal)((Iterator)localObject).next()).a(0, localxlb);
      }
      i = 0;
      break;
    }
    wxe.d("EditVideoSave", "PUBLISH start ...");
    a(alud.a(2131704290), false, 0);
    a(2);
    Stream.of(localxlb).map(new ThreadOffFunction("EditVideoSave", 2)).map(new xli()).map(new xlc((wxs)this.jdField_a_of_type_Xan.a(wxs.class))).map(new xlt(this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new xbl(this, localxlb));
  }
  
  private void j()
  {
    wxe.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + azib.z + " CodecParam.mRecordTime" + azib.y);
    azib.y = 5000;
    azib.z = 125;
    azib.x = 0;
    azib.E = 0;
    int i;
    xlb localxlb;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      azib.J = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localxlb = new xlb(this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localxlb.b = xlr.a(2);
      localObject2 = this.jdField_a_of_type_Xby.getActivity();
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      str = ((EditTakeVideoSource)localObject1).a();
      f = ((EditTakeVideoSource)localObject1).a() * 1.0F / ((EditTakeVideoSource)localObject1).b();
      if ((this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localxlb.a = new xlh((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Xan.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((xal)((Iterator)localObject1).next()).a(0, localxlb);
      }
      i = 0;
      break;
    }
    wxe.d("EditVideoSave", "PUBLISH start ...");
    a(alud.a(2131704166), false, 0);
    a(2);
    Object localObject2 = Stream.of(localxlb).map(new ThreadOffFunction("EditVideoSave", 2)).map(new xle());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Xan.jdField_a_of_type_Wzb != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Xan.jdField_a_of_type_Wzb.a(0));
    }
    ((Stream)localObject1).map(new xlq()).map(new xla()).map(new xlt(this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new xbm(this, localxlb));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Betn == null) {
      return;
    }
    this.jdField_a_of_type_Betn.a();
    this.jdField_a_of_type_Betn.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Betn.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Betn.b(true);
    this.jdField_a_of_type_Betn.d(false);
    this.jdField_a_of_type_Betn.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_Xan.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long != -1L) {
          axpl.a(l, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Xby.a().postDelayed(new EditVideoSave.1(this), 500L);
          return;
          axpl.a(l, -1);
        }
      }
      if (paramInt2 == 1)
      {
        g();
        axpl.a(-1L, -1);
        StringBuilder localStringBuilder = new StringBuilder(alud.a(2131704171));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.jdField_a_of_type_Xby.a(), 1, localStringBuilder, 0).a();
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
    if ((this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561642);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372332);
      this.jdField_a_of_type_Betn = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Betn);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370777)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Betn.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Xby.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbk
 * JD-Core Version:    0.7.0.1
 */