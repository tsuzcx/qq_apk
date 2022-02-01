import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.1;
import dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.2;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;
import java.util.ArrayList;
import java.util.List;

public class awsv
  extends QIMEffectCameraCaptureUnit
{
  private int ciS = 10013;
  private int videoSource;
  
  public awsv(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.jdField_b_of_type_Aybv = new aybv(this.ciS, 106, 12);
    this.byT = 10;
  }
  
  private String Hq()
  {
    int i;
    switch (this.eCw)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      return String.valueOf(i);
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private Intent a(Activity paramActivity, Class<?> paramClass, PublishParam paramPublishParam, Intent paramIntent)
  {
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("arg_video_source", this.videoSource);
    if (paramActivity.getIntent().getExtras() != null) {
      paramClass.putExtras(paramActivity.getIntent().getExtras());
    }
    if (paramIntent != null)
    {
      paramActivity = paramIntent.getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
      if (paramActivity != null) {
        paramClass.putParcelableArrayListExtra("key_read_in_joy_video_upload_report", paramActivity);
      }
    }
    if (paramPublishParam != null)
    {
      paramClass.putExtra(PublishParam.BUNDLE_EXTRA_KEY, paramPublishParam);
      paramClass.putExtra("arg_video_duration", paramPublishParam.videoDuration);
      paramClass.putExtra("arg_video_path", paramPublishParam.videoFilePath);
      paramClass.putExtra("arg_video_cover", paramPublishParam.thumbPath);
      paramClass.putExtra("arg_video_width", paramPublishParam.videoWidth);
      paramClass.putExtra("arg_video_height", paramPublishParam.videoHeight);
      paramClass.putExtra("captureMode", Hq());
    }
    return paramClass;
  }
  
  private void aFZ()
  {
    int i = this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("key_max_duration", 60);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(i * 1000);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setMaxDuration(i * 1000);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
    ThreadManager.excute(new QIMReadinjoyEffectsCameraCaptureUnit.2(this), 64, null, true);
  }
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
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
        break label171;
      }
      bool2 = true;
      localObject = new ayby.a().a(false).e(bool1).f(bool2).g(true).h(this.cAD).b();
      localBundle = this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras();
      this.jdField_b_of_type_Aybv.a((ayby)localObject);
      this.videoSource = 2;
      localObject = this.jdField_a_of_type_Aycb.getActivity().getIntent();
      if (!this.cAD) {
        break label177;
      }
    }
    label171:
    label177:
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
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("video_refer", "READINJOY_VIDEO");
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
    localIntent.putExtra("readinjoy_video", true);
    localIntent.putExtra("needTheme", false);
    localIntent.putExtra("needVideoWording", true);
    localIntent.putExtra("needVideoDoodle", true);
    localIntent.putExtra("entrance_type", this.jdField_b_of_type_Aybv.mEntranceType);
    localIntent.putExtra("edit_video_type", this.ciS);
    this.videoSource = 1;
    paramActivity.startActivityForResult(localIntent, this.ciS);
  }
  
  public void coy()
  {
    super.coy();
    this.yh.setVisibility(8);
  }
  
  protected void eEY()
  {
    ThreadManager.post(new QIMReadinjoyEffectsCameraCaptureUnit.1(this, this.jdField_a_of_type_Aycb.getActivity()), 5, null, true);
  }
  
  public void eFj()
  {
    rma.a().bvr();
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    Intent localIntent = new Intent(localActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtras(this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras());
    localIntent.putExtra("qq_sub_business_id", this.jdField_b_of_type_Aybv.EP);
    localIntent.putExtra("entrance_type", this.jdField_b_of_type_Aybv.mEntranceType);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("from_readinjoy_slideshow", true);
    localIntent.putExtra("ALBUM_NAME", aqfx.RECENT_ALBUM_NAME);
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
    localIntent.putExtra("report_first_exposure", true);
    localActivity.startActivityForResult(localIntent, this.ciS);
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
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if ((paramInt1 == 10013) && (paramInt2 == -1) && (paramIntent != null))
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      axro localaxro = (axro)axov.a().c(8);
      if (localaxro != null) {
        localaxro.eOq();
      }
      localActivity.startActivityForResult(a(localActivity, ReadInJoyDeliverVideoActivity.class, localPublishParam, paramIntent), 111);
      return;
    }
    if (paramInt1 == 111)
    {
      localActivity.setResult(paramInt2, paramIntent);
      localActivity.finish();
      return;
    }
    ram.w("Q.readinjoy.video_QIMReadinjoyEffectsCameraCaptureUnit", "onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370835) {
      aG(this.jdField_a_of_type_Aycb.getActivity());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    this.yh.setOnClickListener(this);
    aFZ();
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsv
 * JD-Core Version:    0.7.0.1
 */