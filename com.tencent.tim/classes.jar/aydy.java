import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager.3;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class aydy
  extends aygz
  implements amdf.a, aviz.a
{
  private Intent ax;
  
  private static void a(aydy paramaydy)
  {
    for (;;)
    {
      int i;
      try
      {
        paramaydy = ((aydg)paramaydy.a(aydg.class)).a();
        int j;
        if (!paramaydy.a().isEmpty())
        {
          paramaydy = paramaydy.a.a();
          j = paramaydy.type;
          k = paramaydy.subType;
          i = -1;
        }
        switch (j)
        {
        case 0: 
          anot.a(null, "dc00898", "", "", "0X800A7C2", "0X800A7C2", i, 0, "", "", "", "");
          return;
        }
      }
      catch (Exception paramaydy)
      {
        int k;
        ram.w("EditPicActivity.EditPicPartManager", "编辑涂鸦上报失败");
        return;
      }
      switch (k)
      {
      default: 
        break;
      case -1: 
        i = 2;
        break;
      case -2148308: 
        i = 3;
        break;
      case -1009097: 
        i = 4;
        break;
      case -8136876: 
        i = 5;
        break;
      case -13338378: 
        i = 6;
        break;
      case -16777216: 
        i = 12;
        continue;
        i = 1;
        continue;
        switch (k)
        {
        default: 
          break;
        case 1: 
          i = 7;
          break;
        case 2: 
          i = 8;
          break;
        case 3: 
          i = 9;
          break;
        case 4: 
          i = 10;
          break;
        case 5: 
          i = 11;
          continue;
          i = -1;
        }
        break;
      }
    }
  }
  
  private void a(Observer<ayqb> paramObserver)
  {
    ayqb localayqb = new ayqb(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localayqb.aAU = ayqu.ce(2);
    localayqb.jdField_a_of_type_Ayqh = new ayqh(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath());
    localayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.actionType = 615;
    localayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.subactionType = 8;
    Object localObject = this.lu.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((aygy)((Iterator)localObject).next()).a(0, localayqb);
    }
    localObject = localayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_text_filter_text");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (!TextUtils.isEmpty(localayqb.g.videoDoodleDescription)) {
        break label335;
      }
    }
    label335:
    StringBuilder localStringBuilder;
    PublishVideoEntry localPublishVideoEntry;
    for (localayqb.g.videoDoodleDescription = ((String)localObject);; localPublishVideoEntry.videoDoodleDescription += (String)localObject)
    {
      localayqb.g.putExtra("composite_key_capturemode", Integer.valueOf(QD()));
      localayqb.g.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th()));
      ras.sp("0X80076EA");
      ram.w("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
      this.jdField_a_of_type_Ayii.a(acfp.m(2131705449), false, 500L);
      Stream.of(localayqb).map(new ThreadOffFunction("EditPicActivity.EditPicPartManager", 2)).map(new ayqe((aydg)a(aydg.class), null)).map(new ayqs(aydw.azs + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new ayqq()).map(new ayqw(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
      localStringBuilder = new StringBuilder();
      localPublishVideoEntry = localayqb.g;
    }
  }
  
  private void bso()
  {
    String str1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("mCurrentTemplatePath");
    int i;
    int j;
    label34:
    String str2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() == 104)
    {
      i = 1;
      if (TextUtils.isEmpty(str1)) {
        break label136;
      }
      j = 1;
      if (j != 0)
      {
        j = tk();
        str2 = gd(str1);
        if (!La()) {
          break label141;
        }
      }
    }
    label136:
    label141:
    for (str1 = "2";; str1 = "1")
    {
      d("pub_changeface", j, 0, new String[] { "1", str2, str1 });
      if (i != 0) {
        rar.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      if (Ld()) {
        rar.a("video_edit", "pub_local", 0, 0, new String[0]);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label34;
    }
  }
  
  private void ey(Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_Ayii.getActivity();
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ausj localausj = ausj.d(localActivity);
    localausj.addButton(2131694752);
    localausj.addButton(2131694762);
    localausj.addButton(2131694750);
    localausj.addCancelButton(2131721058);
    localausj.a(new ayeb(this, localausj, paramIntent, str, localActivity));
    localausj.show();
  }
  
  private void ok(long paramLong)
  {
    if (this.jdField_a_of_type_Ayii != null)
    {
      Activity localActivity = this.jdField_a_of_type_Ayii.getActivity();
      if (localActivity != null) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new EditPicPartManager.3(this, localActivity), paramLong);
      }
    }
  }
  
  private void wT(int paramInt)
  {
    String str = wmj.hp(acbn.SDCARD_IMG_CAMERA);
    Activity localActivity = this.jdField_a_of_type_Ayii.getActivity();
    localActivity.getIntent().putExtra("image_path", str);
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditPicPartManager", 2, "reset2Camera begin " + this.jdField_a_of_type_Ayii.getActivity() + " new path " + str);
    }
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Ayii.getContext()).edit().putString("edit_pic_new_path", str).commit();
    Intent localIntent = new Intent();
    FileProvider7Helper.setSystemCapture(localActivity, new File(str), localIntent);
    localIntent.putExtra("android.intent.extra.quickCapture", true);
    try
    {
      localActivity.startActivityForResult(localIntent, 666);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      QQToast.a(localActivity, acfp.m(2131705455), 0).show();
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
  
  public void OM(boolean paramBoolean)
  {
    if (paramBoolean) {
      ok(1000L);
    }
  }
  
  public void WC(boolean paramBoolean)
  {
    if (paramBoolean) {
      ok(1000L);
    }
  }
  
  protected SimpleObserver<ayqb> a()
  {
    return new aydz(this);
  }
  
  void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_Ayii.a(-1, null, 2130772067, 0, true);
      return;
    case 101: 
      paramIntent.setFlags(536870912);
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramActivity.startActivityForResult(paramIntent, 1000);
      rar.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
      return;
    case 7: 
      if (QLog.isColorLevel())
      {
        Object localObject = paramIntent.getComponent();
        String str = ((ComponentName)localObject).getClassName();
        localObject = ((ComponentName)localObject).getPackageName();
        QLog.i("EditPicActivity.EditPicPartManager", 2, String.format(Locale.getDefault(), "gotoActivityForBusiness [%s, %s]", new Object[] { str, localObject }));
      }
      paramIntent.addFlags(603979776);
      paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 6: 
      paramIntent.setFlags(536870912);
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramActivity.startActivityForResult(paramIntent, 1001);
      return;
    case 103: 
      paramIntent.addFlags(603979776);
      paramIntent.putExtra("sub_business_id", 103);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 8: 
      paramIntent.setClass(paramActivity, ReadInJoyDeliverUGCActivity.class);
      paramIntent.addFlags(603979776);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    }
    paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1050);
    if ((this.jdField_a_of_type_Ayii.getActivity() != null) && (this.jdField_a_of_type_Ayii.getActivity().getIntent() != null) && (this.jdField_a_of_type_Ayii.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_Ayii.a(-1, null, 2130772067, 0, true);
      return;
    }
    this.jdField_a_of_type_Ayii.a(-1, paramIntent, 2130772067, 0, true);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ayfh(this, paramEditVideoParams.aCQ);
    this.jdField_b_of_type_Ayfh = ((ayfh)localObject);
    localArrayList.add(localObject);
    localObject = new ayeh(this);
    this.jdField_a_of_type_Ayeh = ((ayeh)localObject);
    localArrayList.add(localObject);
    localObject = new ayfw(this, paramEditVideoParams.aCQ);
    this.jdField_a_of_type_Ayfw = ((ayfw)localObject);
    localArrayList.add(localObject);
    localObject = new EditPicRawImage(this, paramEditVideoParams.aCQ);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    localObject = new aydx(this);
    this.jdField_a_of_type_Aydx = ((aydx)localObject);
    localArrayList.add(localObject);
    localObject = new ayhn(this);
    this.jdField_a_of_type_Ayhn = ((ayhn)localObject);
    localArrayList.add(localObject);
    localObject = new ayhp(this);
    this.jdField_a_of_type_Ayhp = ((ayhp)localObject);
    localArrayList.add(localObject);
    if (r(paramEditVideoParams.aCQ, 128))
    {
      localObject = new EditVideoArtFilter(this);
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
      localArrayList.add(localObject);
    }
    if ((r(paramEditVideoParams.aCQ, 1)) && (F(paramEditVideoParams.aCQ, 274877906944L)) && (paramEditVideoParams.asi == 1) && (((DynamicTextConfigManager)axov.a(7)).aPN()))
    {
      localObject = new ayft(this, paramEditVideoParams.mFrom);
      this.jdField_a_of_type_Ayft = ((ayft)localObject);
      localArrayList.add(localObject);
    }
    if (r(paramEditVideoParams.aCQ, 8192))
    {
      localObject = new ayec(this);
      this.jdField_a_of_type_Ayec = ((ayec)localObject);
      localArrayList.add(localObject);
    }
    if (r(paramEditVideoParams.aCQ, 67108864))
    {
      localObject = new ayic(this);
      this.jdField_a_of_type_Ayic = ((ayic)localObject);
      localArrayList.add(localObject);
    }
    if (r(paramEditVideoParams.aCQ, 131072))
    {
      localObject = new ayhi(this);
      this.jdField_a_of_type_Ayhi = ((ayhi)localObject);
      localArrayList.add(localObject);
    }
    if (r(paramEditVideoParams.aCQ, 8388608))
    {
      localObject = new ayhw(this);
      this.jdField_a_of_type_Ayhw = ((ayhw)localObject);
      localArrayList.add(localObject);
    }
    if (r(paramEditVideoParams.aCQ, 268435456))
    {
      localObject = new ayil(this);
      this.jdField_a_of_type_Ayil = ((ayil)localObject);
      localArrayList.add(localObject);
      localObject = new ayoy(this);
      this.jdField_a_of_type_Ayoy = ((ayoy)localObject);
      localArrayList.add(localObject);
      localObject = new aygn(this, this.jdField_a_of_type_Ayil, this.jdField_a_of_type_Ayoy);
      this.jdField_a_of_type_Aygn = ((aygn)localObject);
      localArrayList.add(localObject);
    }
    if ((paramEditVideoParams.asi == 1) && (r(paramEditVideoParams.aCQ, 131072))) {
      localArrayList.add(new ayew(this));
    }
    if (r(paramEditVideoParams.aCQ, 33554432))
    {
      localObject = new aygu(this);
      this.jdField_b_of_type_Aygu = ((aygu)localObject);
      localArrayList.add(localObject);
    }
    if (F(paramEditVideoParams.aCQ, 34359738368L))
    {
      localObject = new aygt(this);
      this.jdField_a_of_type_Aygt = ((aygt)localObject);
      localArrayList.add(localObject);
    }
    int i;
    if (r(paramEditVideoParams.aCQ, 16384))
    {
      if (paramEditVideoParams.mExtra != null) {
        break label709;
      }
      i = -1;
      if (i != -1) {
        break label724;
      }
      ram.e("EditPicActivity.EditPicPartManager", "pic curType have not set but it use BUSINESS_QQ ID, that is illegal!!");
    }
    for (;;)
    {
      this.lu = localArrayList;
      return;
      label709:
      i = paramEditVideoParams.mExtra.getInt("uintype", -1);
      break;
      label724:
      this.jdField_b_of_type_Aydc = new aydc(this, i, false);
      localArrayList.add(this.jdField_b_of_type_Aydc);
    }
  }
  
  public void bsX()
  {
    super.bsX();
    this.jdField_a_of_type_Ayii.a(acfp.m(2131705450), false, 500L);
  }
  
  public void bsn()
  {
    bso();
    a(a());
  }
  
  public void bsq()
  {
    Object localObject = this.jdField_a_of_type_Ayii.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    int j;
    int k;
    if ((i == 103) && (i == 103))
    {
      i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
      j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
      k = ((Intent)localObject).getIntExtra("camera_capture_method", -1);
      if (i != 0) {
        break label315;
      }
      localObject = "0";
      if (j == -1) {
        break label323;
      }
      anot.a(null, "dc00898", "", "", "0X8007376", "0X8007376", 0, 0, (String)localObject, "" + j, "", "");
      ras.sp("0X80075E8");
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      ((HashMap)localObject).put("cameraFrontBack", "" + i);
      ((HashMap)localObject).put("templateId", "" + j);
      ((HashMap)localObject).put("photoCaptureMethod", "" + k);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "photo_send_from_shortvideo", true, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.e("EditPicActivity.EditPicPartManager", 2, "[ShortVideoMergeReport] tag=photo_send_from_shortvideo templateId=" + j + " camera=" + i);
      }
      ((axpr)axov.a(5)).cT(this.jdField_a_of_type_Ayii.getActivity());
      return;
      label315:
      localObject = "1";
      break;
      label323:
      anot.a(null, "dc00898", "", "", "0X8007375", "0X8007375", 0, 0, (String)localObject, "" + j, "", "");
    }
  }
  
  protected void bsr()
  {
    Object localObject = this.jdField_a_of_type_Ayii.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    int j;
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditPicPartManager", 2, "giveUpEditVideo, is from camera" + i + " clear photo " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath());
      }
      new File(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath()).delete();
      aqhu.cn(this.jdField_a_of_type_Ayii.getContext(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath());
      Intent localIntent = new Intent();
      localIntent.putExtra("p_e_r_c", true);
      localIntent.putExtra("camera_type", i);
      if (i == 103)
      {
        i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
        j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
        if (i == 0)
        {
          localObject = "0";
          if (j == -1) {
            break label318;
          }
          anot.a(null, "dc00898", "", "", "0X80072C6", "0X80072C6", 0, 0, (String)localObject, "" + j, "", "");
          label235:
          this.jdField_a_of_type_Ayii.a(0, localIntent, 2130772067, 0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 1)
      {
        i = QD();
        rar.b("time_edit", 1, (int)(System.currentTimeMillis() - iY()), new String[] { rar.bY(i), "1", "", "" });
      }
      return;
      localObject = "1";
      break;
      label318:
      anot.a(null, "dc00898", "", "", "0X80072C7", "0X80072C7", 0, 0, (String)localObject, "" + j, "", "");
      break label235;
      wT(i);
      continue;
      this.jdField_a_of_type_Ayii.a(0, null, 2130772067, 0);
    }
  }
  
  public void d(Error paramError)
  {
    ram.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Ayii.bpm();
    QQToast.a(this.jdField_a_of_type_Ayii.getContext(), acfp.m(2131705452) + paramError, 0).show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      this.w = paramIntent;
    }
    if (paramInt1 == 18001) {
      if (paramInt2 == -1) {
        AIOLongShotHelper.y(this.jdField_a_of_type_Ayii.getActivity(), paramIntent);
      }
    }
    while ((paramInt1 != 18002) || (paramInt2 != -1))
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
      this.jdField_a_of_type_Ayii.a(-1, this.ax, 2130772067, 0, false);
      this.ax = null;
      return;
    }
    this.jdField_a_of_type_Ayii.a(-1, this.ax, 2130772067, 0, false);
    this.ax = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydy
 * JD-Core Version:    0.7.0.1
 */