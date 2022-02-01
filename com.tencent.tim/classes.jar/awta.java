import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.ChangeFace;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMTribeEffectsCameraCaptureUnit.1;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class awta
  extends QIMEffectCameraCaptureUnit
{
  public static int eCL = 60000;
  
  public awta(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.jdField_b_of_type_Aybv = new aybv(10012, 105, 11);
    this.byT = 9;
  }
  
  private void a(TribeVideoPublishParams paramTribeVideoPublishParams)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = ((ayzs)axov.a(3)).a();
    if (localPtvTemplateInfo != null)
    {
      paramTribeVideoPublishParams.changeFace = new TribeVideoPublishParams.ChangeFace();
      paramTribeVideoPublishParams.changeFace.id = localPtvTemplateInfo.id;
      paramTribeVideoPublishParams.changeFace.type = localPtvTemplateInfo.name;
    }
    if ((AdvancedProviderView)this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(AdvancedProviderView.class) != null) {
      paramTribeVideoPublishParams.beauty = AdvancedProviderView.QU();
    }
  }
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
    if (aniq.dFI > 2000000)
    {
      locale.TT(2000000);
      aniq.dFI = 2000000;
      ram.d("QIMTribeEffectsCameraCaptureUnit", "maxrate:" + aniq.dFI);
    }
    locale.Ow(false);
    return locale;
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    boolean bool1;
    boolean bool2;
    label36:
    Object localObject;
    Bundle localBundle;
    if (this.jdField_b_of_type_Aybv.mEntranceType != 102)
    {
      bool1 = true;
      if (this.jdField_b_of_type_Aybv.mEntranceType == 102) {
        break label166;
      }
      bool2 = true;
      localObject = new ayby.a().a(false).e(bool1).f(bool2).g(true).h(this.cAD).b();
      localBundle = this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras();
      this.jdField_b_of_type_Aybv.a((ayby)localObject);
      localObject = this.jdField_a_of_type_Aycb.getActivity().getIntent();
      if (!this.cAD) {
        break label172;
      }
    }
    label166:
    label172:
    for (int i = 2;; i = -1)
    {
      ((Intent)localObject).putExtra("extra_transiton_src_from", i);
      aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_b_of_type_Aybv, this.bO, this.byT, localBundle);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label36;
    }
  }
  
  public void aG(Activity paramActivity)
  {
    Bundle localBundle = paramActivity.getIntent().getExtras();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 24);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("video_refer", "tribe");
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
    localIntent.putExtras(localBundle);
    localIntent.putExtra("entrance_type", this.jdField_b_of_type_Aybv.mEntranceType);
    localIntent.putExtra("edit_video_type", 10012);
    paramActivity.startActivityForResult(localIntent, 10012);
  }
  
  public void coy()
  {
    super.coy();
    this.yh.setVisibility(8);
  }
  
  protected void eEY()
  {
    ThreadManager.post(new QIMTribeEffectsCameraCaptureUnit.1(this, this.jdField_a_of_type_Aycb.getActivity()), 5, null, true);
  }
  
  public void eFj()
  {
    rma.a().bvr();
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    Intent localIntent = new Intent(localActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 24);
    localIntent.putExtras(this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras());
    localIntent.putExtra("qq_sub_business_id", this.jdField_b_of_type_Aybv.EP);
    localIntent.putExtra("entrance_type", this.jdField_b_of_type_Aybv.mEntranceType);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("from_tribe_slideshow", true);
    localIntent.putExtra("ALBUM_NAME", aqfx.RECENT_ALBUM_NAME);
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
    localIntent.putExtra("report_first_exposure", true);
    localActivity.startActivityForResult(localIntent, 10012);
    localActivity.overridePendingTransition(2130772367, 2130772002);
  }
  
  public ArrayList<Integer> eG()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(0));
    localArrayList.add(Integer.valueOf(2));
    return localArrayList;
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      if (paramInt1 != aorb.dRv) {
        break label87;
      }
      if (paramInt2 != -1) {
        break;
      }
    } while (paramIntent == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("result", paramIntent.getStringExtra("result"));
    localActivity.setResult(-1, localIntent);
    localActivity.finish();
    return;
    label87:
    if ((paramInt1 == 10012) && (paramInt2 == -1))
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      TribeVideoPublishParams localTribeVideoPublishParams = (TribeVideoPublishParams)paramIntent.getSerializableExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY);
      localIntent = new Intent();
      localIntent.putExtra("thumbPath", localPublishParam.thumbPath);
      localIntent.putExtra("videoPath", localPublishParam.videoFilePath);
      localIntent.putExtra("fakeVid", localPublishParam.fakeVid);
      localIntent.putExtra("videoDoodleDescription", localPublishParam.videoDoodleDescription);
      paramInt1 = paramIntent.getIntExtra("theme_id", -1);
      paramIntent = paramIntent.getStringExtra("theme_name");
      localIntent.putExtra("theme_id", paramInt1);
      localIntent.putExtra("theme_name", paramIntent);
      a(localTribeVideoPublishParams);
      localIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, localTribeVideoPublishParams);
      paramIntent = (axro)axov.a().c(8);
      if (paramIntent != null) {
        paramIntent.eOq();
      }
      paramIntent = localActivity.getIntent().getExtras().getString("options");
      localIntent.setClass(localActivity, TroopBarPublishActivity.class);
      localIntent.putExtra("options", paramIntent);
      localIntent.putExtra("captureMode", this.eCw);
      localActivity.startActivityForResult(localIntent, aorb.dRv);
      return;
    }
    ram.w("QIMTribeEffectsCameraCaptureUnit", "onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aG(this.jdField_a_of_type_Aycb.getActivity());
    }
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
    this.yh.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(true);
    Object localObject1 = aorf.d(this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras());
    if (localObject1 != null) {
      eCL = ((JSONObject)localObject1).optInt("needVideoTimeLimit", 10) * 1000;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(eCL);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setMaxDuration(eCL);
    localObject1 = this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras();
    try
    {
      Object localObject2 = ((Bundle)localObject1).getString("options");
      if (QLog.isColorLevel()) {
        QLog.d("QIMTribeEffectsCameraCaptureUnit", 2, "onVideoCaptured option: " + (String)localObject2);
      }
      localObject2 = new JSONObject((String)localObject2);
      boolean bool1 = ((JSONObject)localObject2).optBoolean("needVideoDoodle", false);
      boolean bool2 = ((JSONObject)localObject2).optBoolean("needVideoWording", false);
      ((Bundle)localObject1).putBoolean("needVideoDoodle", bool1);
      ((Bundle)localObject1).putBoolean("needVideoWording", bool2);
      this.jdField_a_of_type_Aycb.getActivity().getIntent().putExtras((Bundle)localObject1);
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QIMTribeEffectsCameraCaptureUnit", 2, "onVideoCaptured: " + localException);
    }
    return localView;
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awta
 * JD-Core Version:    0.7.0.1
 */