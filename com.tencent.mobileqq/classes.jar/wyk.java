import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class wyk
  extends xan
{
  public int a;
  String a;
  
  private void b(int paramInt)
  {
    String str = aetu.a(alof.bk);
    Activity localActivity = this.jdField_a_of_type_Xby.getActivity();
    localActivity.getIntent().putExtra("image_path", str);
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditPicPartManager", 2, "reset2Camera begin " + this.jdField_a_of_type_Xby.getActivity() + " new path " + str);
    }
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Xby.a()).edit().putString("edit_pic_new_path", str).commit();
    Intent localIntent;
    if (paramInt == 101)
    {
      ComponentName localComponentName = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.camera.QQCameraActivity");
      localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("qcamera_photo_filepath", str);
    }
    for (;;)
    {
      try
      {
        localActivity.startActivityForResult(localIntent, 666);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      localIntent = new Intent();
      FileProvider7Helper.setSystemCapture(localActivity, new File(str), localIntent);
      localIntent.putExtra("android.intent.extra.quickCapture", true);
    }
    try
    {
      QQToast.a(localActivity, alud.a(2131704075), 0).a();
      localActivity.finish();
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("EditPicActivity.EditPicPartManager", 1, "reset2Camera err", localException1);
      }
    }
  }
  
  private void v()
  {
    String str1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("mCurrentTemplatePath");
    int i;
    String str2;
    if (!TextUtils.isEmpty(str1))
    {
      i = 1;
      if (i != 0)
      {
        i = b();
        str2 = a(str1);
        if (!a()) {
          break label75;
        }
      }
    }
    label75:
    for (str1 = "2";; str1 = "1")
    {
      b("pub_changeface", i, 0, new String[] { "1", str2, str1 });
      return;
      i = 0;
      break;
    }
  }
  
  private void w()
  {
    xlb localxlb = new xlb(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localxlb.b = xlr.a(2);
    localxlb.jdField_a_of_type_Xlf = new xlf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    localxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.actionType = 615;
    localxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.subactionType = 8;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((xal)((Iterator)localObject).next()).a(0, localxlb);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < localxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.size())
      {
        ((StringBuilder)localObject).append((String)localxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.get(i) + ",");
        i += 1;
      }
      if (((StringBuilder)localObject).length() > 0) {
        ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
      }
      localxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves5 = ((StringBuilder)localObject).toString();
      LpReportManager.getInstance().reportToPF00064(localxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064, true, false);
    }
    wxk.b("0X80076EA");
    wxe.d("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
    this.jdField_a_of_type_Xby.a(alud.a(2131704074), false, 500L);
    Stream.of(localxlb).map(new xld((wxs)a(wxs.class), null)).map(new ThreadOffFunction("EditPicActivity.EditPicPartManager", 2)).map(new xlp(wyi.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new wyl(this, localxlb));
  }
  
  public void a()
  {
    v();
    w();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 != -1) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      bdhb.d(this.jdField_a_of_type_JavaLangString);
      xrg.b(BaseApplication.getContext(), new File(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaLangString = null;
    }
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_Xby.a(-1, null, 2130772028, 0);
    case 101: 
    case 104: 
      do
      {
        return;
        paramIntent.setFlags(536870912);
        paramIntent.removeExtra(EditVideoParams.class.getName());
        paramActivity.startActivityForResult(paramIntent, 1000);
      } while (paramInt == 104);
      wxj.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
      return;
    case 8: 
      paramIntent.setClass(paramActivity, ReadInJoyDeliverUGCActivity.class);
      paramIntent.addFlags(603979776);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 103: 
      paramIntent.addFlags(603979776);
      paramIntent.putExtra("sub_business_id", 103);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 5: 
      paramIntent.setClassName("com.tencent.mobileqq", BlessSelectMemberActivity.class.getName());
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramIntent.putExtra("param_type", 9003);
      paramIntent.putExtra("param_only_friends", true);
      paramIntent.putExtra("param_donot_need_contacts", true);
      paramIntent.putExtra("param_title", paramActivity.getString(2131690565));
      paramIntent.putExtra("param_done_button_wording", paramActivity.getString(2131691089));
      paramIntent.putExtra("param_exit_animation", 1);
      paramIntent.putExtra("param_entrance", 15);
      paramIntent.putExtra("param_blesstype", 3);
      paramIntent.putExtra("thumbfile_send_path", paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"));
      paramActivity.startActivityForResult(paramIntent, 1001);
      return;
    case 6: 
      paramIntent.setFlags(536870912);
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramActivity.startActivityForResult(paramIntent, 1001);
      return;
    }
    paramActivity.setResult(-1, paramIntent);
    paramActivity.finish();
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new wyz(this, paramEditVideoParams.b);
    this.jdField_a_of_type_Wyz = ((wyz)localObject);
    localArrayList.add(localObject);
    localObject = new wzb(this, paramEditVideoParams.b);
    this.jdField_a_of_type_Wzb = ((wzb)localObject);
    localArrayList.add(localObject);
    localObject = new EditPicRawImage(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    localObject = new wyj(this);
    this.jdField_a_of_type_Wyj = ((wyj)localObject);
    localArrayList.add(localObject);
    localObject = new xba(this);
    this.jdField_a_of_type_Xba = ((xba)localObject);
    localArrayList.add(localObject);
    localObject = new xbg(this);
    this.jdField_a_of_type_Xbg = ((xbg)localObject);
    localArrayList.add(localObject);
    if (a(paramEditVideoParams.b, 16))
    {
      localObject = new EditVideoArtFilter(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.b, 1024))
    {
      localObject = new wym(this);
      this.jdField_a_of_type_Wym = ((wym)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.b, 262144))
    {
      localObject = new wxx(this);
      this.jdField_a_of_type_Wxx = ((wxx)localObject);
      localArrayList.add(localObject);
    }
    a(localArrayList);
    this.jdField_a_of_type_Int = paramEditVideoParams.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Xby.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    int j;
    int k;
    if ((i == 103) && (i == 103))
    {
      i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
      j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
      boolean bool = ((Intent)localObject).getBooleanExtra("camera_has_gesture_filter", false);
      k = ((Intent)localObject).getIntExtra("camera_capture_method", -1);
      if (i != 0) {
        break label372;
      }
      localObject = "0";
      if (j == -1) {
        break label379;
      }
      azqs.b(null, "dc00898", "", "", "0X80072C5", "0X80072C5", 0, 0, (String)localObject, "" + j, "", "");
      if (bool) {
        azqs.b(null, "dc00898", "", "", "0X80083B2", "0X80083B2", 0, 0, (String)localObject, "" + j, "", "");
      }
      wxk.b("0X80075E8");
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      ((HashMap)localObject).put("cameraFrontBack", "" + i);
      ((HashMap)localObject).put("templateId", "" + j);
      ((HashMap)localObject).put("photoCaptureMethod", "" + k);
      azri.a(BaseApplication.getContext()).a(null, "photo_send_from_shortvideo", true, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.e("EditPicActivity.EditPicPartManager", 2, "[ShortVideoMergeReport] tag=photo_send_from_shortvideo templateId=" + j + " camera=" + i);
      }
      return;
      label372:
      localObject = "1";
      break;
      label379:
      azqs.b(null, "dc00898", "", "", "0X80072C4", "0X80072C4", 0, 0, (String)localObject, "" + j, "", "");
    }
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_Xby.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditPicPartManager", 2, "giveUpEditVideo, is from camera" + i + " clear photo " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
      }
      new File(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()).delete();
      bdhj.a(this.jdField_a_of_type_Xby.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
      Intent localIntent = new Intent();
      localIntent.putExtra("p_e_r_c", true);
      localIntent.putExtra("camera_type", i);
      if (i == 103)
      {
        i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
        int j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
        if (i == 0)
        {
          localObject = "0";
          if (j == -1) {
            break label264;
          }
          azqs.b(null, "dc00898", "", "", "0X80072C6", "0X80072C6", 0, 0, (String)localObject, "" + j, "", "");
        }
        for (;;)
        {
          this.jdField_a_of_type_Xby.a(0, localIntent, 2130772028, 0);
          return;
          localObject = "1";
          break;
          label264:
          azqs.b(null, "dc00898", "", "", "0X80072C7", "0X80072C7", 0, 0, (String)localObject, "" + j, "", "");
        }
      }
      b(i);
      return;
    }
    this.jdField_a_of_type_Xby.a(-1, null, 2130772028, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyk
 * JD-Core Version:    0.7.0.1
 */