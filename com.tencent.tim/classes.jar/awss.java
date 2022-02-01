import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class awss
  extends QIMEffectCameraCaptureUnit
{
  private String cSn;
  private boolean drh;
  private int eCt;
  
  public awss(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.jdField_b_of_type_Aybv = new aybv(10004, 8, 2);
    this.byT = 6;
  }
  
  private void cM(Activity paramActivity)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.x(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    avpw.c(paramActivity, localAppRuntime.getAccount(), localIntent, -1);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    ayby localayby = new ayby.a().a(101).b(2).b();
    this.jdField_b_of_type_Aybv.a(localayby);
    j(paramLocalMediaInfo);
    aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_b_of_type_Aybv, this.bO, this.byT);
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    super.a(paramh);
    aybw localaybw = new aybw.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is()).a(2).b(101).b();
    this.jdField_b_of_type_Aybv.a(localaybw);
    aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramh, this.jdField_b_of_type_Aybv, this.bO, this.byT);
  }
  
  public void coy()
  {
    super.coy();
    this.yh.setVisibility(8);
  }
  
  public void eES()
  {
    Bundle localBundle = this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras();
    this.drh = localBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.eCt = localBundle.getInt("ARG_DD_CATEGORY_ID");
    this.cSn = localBundle.getString("ARG_DD_ITEM_ID");
  }
  
  public int getLayoutId()
  {
    return 2131561110;
  }
  
  protected List<View> hE()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.yh);
    return localArrayList;
  }
  
  public void initContainerView()
  {
    super.initContainerView();
    if (this.drh) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.S(102, this.eCt, this.cSn);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Activity localActivity;
    Object localObject2;
    Object localObject1;
    switch (paramInt1)
    {
    default: 
    case 10004: 
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        localActivity = this.jdField_a_of_type_Aycb.getActivity();
        paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
        if (paramInt1 != 1002) {
          break;
        }
        cM(localActivity);
        localObject2 = paramIntent.getStringExtra("forward_source_to_qzone");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label579;
        }
        localObject1 = paramIntent.getStringExtra("set_user_callback");
      } while (localObject1 == null);
    }
    for (;;)
    {
      boolean bool;
      try
      {
        localObject1 = Class.forName((String)localObject1).newInstance();
        if (!(localObject1 instanceof aaqj)) {
          break label573;
        }
        localObject1 = (aaqj)localObject1;
        ((aaqj)localObject1).setRefer((String)localObject2);
        localObject2 = paramIntent.getStringExtra("key_content");
        bool = paramIntent.getBooleanExtra("forward_to_qzone_to_enable_edit", false);
        awtf.a(this.jdField_a_of_type_Aycb.getActivity(), paramIntent, this.c, this.jdField_a_of_type_Ayca, null, (aaqj)localObject1, (String)localObject2, 1, null, bool, null, false);
        localActivity.finish();
        if (this.jdField_a_of_type_Axoo != null)
        {
          this.jdField_a_of_type_Axoo.onStop();
          this.jdField_a_of_type_Axoo.apk();
        }
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.Xx(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QIMQuickShootEffectCameraCaptureUnit", 2, "initComponentParamData:exp =" + localThrowable);
        localObject1 = localObject2;
        continue;
      }
      if (paramInt1 == 1003)
      {
        paramIntent = ((PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY)).thumbPath;
        localObject1 = new Intent(localActivity, QQStoryMainActivity.class);
        ((Intent)localObject1).putExtra("new_video_extra_info", paramIntent);
        localActivity.startActivity((Intent)localObject1);
        localActivity.finish();
      }
      else
      {
        awtf.a(this.jdField_a_of_type_Aycb.getActivity(), paramIntent, this.c, this.jdField_a_of_type_Ayca, new awst(this, localActivity, paramIntent));
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = this.jdField_a_of_type_Aycb.getActivity();
          paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
          if (paramInt1 == 1002)
          {
            cM((Activity)localObject1);
            paramIntent.putExtra("open_leba_tab_fragment", true);
            ((Activity)localObject1).setResult(-1, paramIntent);
            ((Activity)localObject1).finish();
            return;
          }
          if (paramInt1 != 1003) {
            break;
          }
          paramIntent = ((PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY)).thumbPath;
          localObject2 = new Intent((Context)localObject1, QQStoryMainActivity.class);
          ((Intent)localObject2).putExtra("new_video_extra_info", paramIntent);
          ((Activity)localObject1).startActivity((Intent)localObject2);
          ((Activity)localObject1).finish();
          return;
        }
        if (paramInt2 != 0) {
          break;
        }
        bool = false;
        if (paramIntent != null) {
          bool = paramIntent.getBooleanExtra("mark_from_artfilter_bridge_activity", false);
        }
        if ((bool) || (paramIntent != null) || (!(this.jdField_a_of_type_Aycb.getActivity() instanceof SplashActivity))) {
          break;
        }
        if (this.jdField_a_of_type_Axoo != null)
        {
          this.jdField_a_of_type_Axoo.onStop();
          this.jdField_a_of_type_Axoo.apk();
        }
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.Xx(false);
        return;
        label573:
        localObject1 = null;
        continue;
        label579:
        localObject1 = null;
      }
    }
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    this.yh.setOnClickListener(this);
    this.yh.setVisibility(0);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awss
 * JD-Core Version:    0.7.0.1
 */