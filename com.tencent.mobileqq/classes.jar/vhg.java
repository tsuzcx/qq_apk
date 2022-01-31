import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.2;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class vhg
  implements vhv, via
{
  public static final int a;
  private static vhg jdField_a_of_type_Vhg;
  long jdField_a_of_type_Long;
  protected Handler a;
  bhim jdField_a_of_type_Bhim = new vhh(this);
  protected SlideShowProcessor a;
  protected List<WeakReference<Activity>> a;
  protected vhi a;
  private vhk jdField_a_of_type_Vhk;
  private int jdField_b_of_type_Int = 20999;
  private List<SlideItemInfo> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private int jdField_c_of_type_Int;
  private List<LocalMediaInfo> jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private int jdField_d_of_type_Int = 21;
  private List<SlideItemInfo> jdField_d_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_Int = vct.a(BaseApplicationImpl.getApplication(), 62.0F);
  }
  
  public vhg()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor = new SlideShowProcessor();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a();
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager create, ", new Exception());
    }
  }
  
  public static vhg a()
  {
    if (jdField_a_of_type_Vhg == null) {
      jdField_a_of_type_Vhg = new vhg();
    }
    return jdField_a_of_type_Vhg;
  }
  
  private void a(Activity paramActivity, List<String> paramList, vhi paramvhi, int paramInt)
  {
    paramList = (SlideItemInfo)a().get(0);
    if (paramList.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_Vhi = paramvhi;
      if (((this.jdField_c_of_type_Int == 13) || (this.jdField_c_of_type_Int == 11) || (this.jdField_c_of_type_Int == 12) || (this.jdField_d_of_type_Int == 22)) && (((paramActivity instanceof PhotoListActivity)) || ((paramActivity instanceof PhotoPreviewActivity)) || ((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
        a();
      }
      if (this.jdField_a_of_type_Vhk != null) {
        this.jdField_a_of_type_Vhk.e();
      }
      int j = -1;
      paramvhi = "";
      int i = j;
      paramList = paramvhi;
      if (this.jdField_b_of_type_JavaUtilList.size() > 0)
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.jdField_b_of_type_JavaUtilList.get(0);
        i = j;
        paramList = paramvhi;
        if (localSlideItemInfo != null)
        {
          i = localSlideItemInfo.jdField_a_of_type_Int;
          paramList = localSlideItemInfo.jdField_a_of_type_JavaLangString;
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(this.jdField_b_of_type_JavaUtilList, this, paramActivity, this.jdField_a_of_type_AndroidOsHandler, paramInt, i, paramList);
      return;
    }
    biys.a(paramActivity, paramList.jdField_b_of_type_JavaLangString, paramList.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, (int)paramList.jdField_b_of_type_Long, (int)paramList.jdField_c_of_type_Long, 120, 10023, 0, "", "", false, 11, 14, null);
  }
  
  private void a(Context paramContext, String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SlideShowPhotoListManager.2(this, paramContext, paramString));
  }
  
  private void a(Context paramContext, List<SlideItemInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramContext = vhd.a(paramContext).a(((SlideItemInfo)paramList.get(0)).jdField_e_of_type_JavaLangString);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((QIMMusicConfigManager)bhfm.a(2)).a(((vhe)paramContext.get(0)).jdField_a_of_type_Int, ((vhe)paramContext.get(0)).jdField_b_of_type_Int);
        if (paramContext != null)
        {
          paramList = (bhiu)bhfm.a().c(8);
          if ((paramList != null) && (!paramList.b(paramContext)))
          {
            paramList.a(paramContext, this.jdField_a_of_type_Bhim);
            if (QLog.isColorLevel()) {
              QLog.d("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager preloadMusic mItemId=" + paramContext.mItemId);
            }
          }
        }
      }
    }
  }
  
  private boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.getIntent() != null)
      {
        bool1 = bool2;
        if (paramActivity.getIntent().getIntExtra("edit_video_type", 10002) == 10023) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(List<SlideItemInfo> paramList1, List<SlideItemInfo> paramList2)
  {
    if (paramList1 == paramList2) {
      return false;
    }
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    if (paramList1.size() != paramList2.size()) {
      return true;
    }
    HashSet localHashSet = new HashSet();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext()) {
      localHashSet.add(((SlideItemInfo)paramList1.next()).jdField_b_of_type_JavaLangString);
    }
    if (localHashSet.size() != paramList2.size()) {
      return true;
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext()) {
      if (!localHashSet.contains(((SlideItemInfo)paramList1.next()).jdField_b_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  private void c(List<SlideItemInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "convertToVideoBatch size : " + paramList.size());
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SlideShowPhotoListManager", 2, "combine video newInfoList is null");
      }
      return;
    }
    Object localObject1 = paramList.iterator();
    long l = 0L;
    label67:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
      if (localObject2 == null) {
        break label359;
      }
      l = ((SlideItemInfo)localObject2).a() + l;
    }
    label348:
    label359:
    for (;;)
    {
      break label67;
      if (l > this.jdField_b_of_type_Int)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SlideShowPhotoListManager", 2, "Duration too max: convertToVideo totalDuration=" + l);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("SlideShowPhotoListManager", 2, "combine video mConvertProcessor is null");
        return;
      }
      localObject1 = (vhn)QQStoryContext.a().getBusinessHandler(1);
      localObject2 = new ArrayList();
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label348;
        }
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowPhotoListManager", 2, "info : " + localSlideItemInfo + "  info.mSrcPath : " + localSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        if ((localSlideItemInfo != null) && (!TextUtils.isEmpty(localSlideItemInfo.jdField_b_of_type_JavaLangString)))
        {
          if (localSlideItemInfo.jdField_b_of_type_Int == 1)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SlideShowPhotoListManager", 2, "convertToVideoBatch mediaType is video, error");
            return;
          }
          if ((!((vhn)localObject1).a(localSlideItemInfo.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo.jdField_b_of_type_JavaLangString))) {
            ((List)localObject2).add(localSlideItemInfo);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a((List)localObject2, this);
      return;
    }
  }
  
  private void d(List<SlideItemInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "convertToVideo size : " + paramList.size());
    }
    long l2;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label95;
      }
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)localIterator.next();
      if (localSlideItemInfo == null) {
        break label177;
      }
      l1 = localSlideItemInfo.a() + l1;
    }
    label177:
    for (;;)
    {
      break;
      l2 = 0L;
      label95:
      if ((l2 <= this.jdField_b_of_type_Int) || (vgt.a().b() == 22)) {
        if (paramList != null) {
          e(paramList);
        }
      }
      while (!QLog.isColorLevel())
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("SlideShowPhotoListManager", 2, "newInfoList is null");
        return;
      }
      QLog.d("SlideShowPhotoListManager", 2, "Duration too max: convertToVideo totalDuration=" + l2);
      return;
    }
  }
  
  private void e(@NonNull List<SlideItemInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor != null)
    {
      vhn localvhn = (vhn)QQStoryContext.a().getBusinessHandler(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
        if ((localSlideItemInfo != null) && (!TextUtils.isEmpty(localSlideItemInfo.jdField_b_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SlideShowPhotoListManager", 2, "convertToVideo path = " + localSlideItemInfo.jdField_b_of_type_JavaLangString);
          }
          long l = localSlideItemInfo.a();
          if (l > this.jdField_b_of_type_Int - 2000)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SlideShowPhotoListManager", 2, "Duration too max: convertToVideoInternal durationValid=" + l);
            }
            localSlideItemInfo.jdField_b_of_type_Boolean = false;
          }
          else
          {
            boolean bool = localSlideItemInfo.jdField_b_of_type_Boolean;
            localSlideItemInfo.jdField_b_of_type_Boolean = false;
            LocalMediaInfo localLocalMediaInfo;
            if (!localvhn.a(localSlideItemInfo.jdField_b_of_type_JavaLangString))
            {
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo.jdField_b_of_type_JavaLangString))
              {
                this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.i("SlideShowPhotoListManager", 2, "[hasAlreadyRunning=true]convertToVideo path = " + localSlideItemInfo.jdField_b_of_type_JavaLangString);
                }
                if ((bool) && (localSlideItemInfo.jdField_b_of_type_Int == 1))
                {
                  this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                  localLocalMediaInfo = localvhn.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                  if (localLocalMediaInfo != null)
                  {
                    apdh.c(localLocalMediaInfo.path);
                    localvhn.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                  }
                  this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
                }
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.i("SlideShowPhotoListManager", 2, "[hasCachedMediaInfo=true]convertToVideo path = " + localSlideItemInfo.jdField_b_of_type_JavaLangString);
              }
              if ((bool) && (localSlideItemInfo.jdField_b_of_type_Int == 1))
              {
                localLocalMediaInfo = localvhn.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                if (localLocalMediaInfo != null) {
                  apdh.c(localLocalMediaInfo.path);
                }
                localvhn.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
              }
            }
          }
        }
        else if (localSlideItemInfo != null)
        {
          localSlideItemInfo.jdField_b_of_type_Boolean = false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "combine video mConvertProcessor is null");
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public List<SlideItemInfo> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && ((localActivity instanceof EditVideoActivity)))
      {
        localActivity.finish();
        this.jdField_a_of_type_JavaUtilList.remove(localActivity);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramActivity));
  }
  
  public void a(Activity paramActivity, vhi paramvhi, int paramInt)
  {
    Object localObject1 = vhj.a(a());
    if ((paramActivity == null) || (localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "activity == null || imgPathList == null");
      }
      return;
    }
    int i;
    if (((paramActivity instanceof PhotoListActivity)) || ((paramActivity instanceof NewPhotoListActivity)))
    {
      i = 1;
      label61:
      if (!a(paramActivity)) {
        break label147;
      }
      a(paramActivity, (List)localObject1, paramvhi, paramInt);
    }
    label78:
    Object localObject2;
    for (;;)
    {
      if (bheq.y)
      {
        bheq.y = true;
        paramActivity = ShortVideoUtils.a(bheq.jdField_a_of_type_JavaUtilHashSet);
        if (a().b() != 21) {
          break;
        }
        urp.a("clk_mode", 10002, 0, new String[] { paramActivity, "0", "", "" });
        return;
        i = 0;
        break label61;
        label147:
        if ((((List)localObject1).size() == 1) && (this.jdField_d_of_type_Int != 22))
        {
          SlideItemInfo localSlideItemInfo = (SlideItemInfo)a().get(0);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
          boolean bool;
          if (localSlideItemInfo.jdField_b_of_type_Int == 0)
          {
            paramvhi = null;
            paramInt = 99;
            if (paramActivity.getIntent() != null)
            {
              paramvhi = paramActivity.getIntent().getStringExtra("shareGroupId");
              paramInt = paramActivity.getIntent().getIntExtra("entrance_type", 99);
            }
            bool = TextUtils.isEmpty(paramvhi);
            paramvhi = EditPicActivity.a(paramActivity, localSlideItemInfo.jdField_b_of_type_JavaLangString, true, true, true, true, true, true, bool, bool, 1, paramInt, 0, false, null);
            paramvhi.putExtra("media_info", localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
            paramvhi.putExtra("extra_edit_video_from", 2);
            paramActivity.startActivityForResult(paramvhi, 10002);
            paramActivity = new StringBuilder();
            if (i != 0) {}
            for (paramInt = 0;; paramInt = 1)
            {
              urp.a("video_edit", "edit_local", 0, 0, new String[] { paramInt + "" });
              if (bheq.z) {
                break;
              }
              bheq.z = true;
              paramInt = 0;
              if (bheq.jdField_a_of_type_Long != -1L) {
                paramInt = (int)(System.currentTimeMillis() - bheq.jdField_a_of_type_Long);
              }
              urp.a("time_shoot", 10002, paramInt, new String[] { String.valueOf(2), "0", "", "" });
              break;
            }
          }
          if (localSlideItemInfo.jdField_b_of_type_Int == 1)
          {
            paramvhi = new StringBuilder();
            if (i != 0) {}
            for (paramInt = 0;; paramInt = 1)
            {
              urp.a("video_edit", "edit_local", 0, 1, new String[] { paramInt + "" });
              paramInt = 0;
              paramvhi = null;
              localObject1 = null;
              bool = false;
              localObject2 = null;
              Intent localIntent = paramActivity.getIntent();
              if (localIntent != null)
              {
                paramInt = localIntent.getIntExtra("shareGroupType", 0);
                paramvhi = localIntent.getStringExtra("shareGroupId");
                localObject1 = localIntent.getStringExtra("shareGroupName");
                bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
                localIntent.putExtra("extra_edit_video_from", 3);
                localObject2 = bhfd.a(localIntent);
              }
              i = 10002;
              if (a().b() == 22) {
                i = 10001;
              }
              biys.a(paramActivity, localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, (int)localSlideItemInfo.jdField_b_of_type_Long, (int)localSlideItemInfo.jdField_c_of_type_Long, 103, i, paramInt, paramvhi, (String)localObject1, bool, 3, 1, (Bundle)localObject2);
              if (bheq.z) {
                break;
              }
              bheq.z = true;
              paramInt = 0;
              if (bheq.jdField_a_of_type_Long != -1L) {
                paramInt = (int)(System.currentTimeMillis() - bheq.jdField_a_of_type_Long);
              }
              long l = localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
              if (a().b() != 21) {
                break;
              }
              urp.a("time_shoot", 10002, paramInt, new String[] { String.valueOf(2), String.valueOf(l), "", "" });
              break;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_Vhi = paramvhi;
          if (((this.jdField_c_of_type_Int == 13) || (this.jdField_c_of_type_Int == 11) || (this.jdField_c_of_type_Int == 12) || (this.jdField_d_of_type_Int == 22)) && (((paramActivity instanceof PhotoListActivity)) || ((paramActivity instanceof PhotoPreviewActivity)) || ((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
            a();
          }
          paramvhi = this.jdField_b_of_type_JavaUtilList.iterator();
          i = 0;
          label803:
          if (paramvhi.hasNext())
          {
            localObject1 = (SlideItemInfo)paramvhi.next();
            if ((localObject1 == null) || (((SlideItemInfo)localObject1).jdField_b_of_type_Int != 1)) {
              break label1137;
            }
            i += 1;
          }
        }
      }
    }
    label907:
    label1118:
    label1124:
    label1130:
    label1137:
    for (;;)
    {
      break label803;
      int m = this.jdField_b_of_type_JavaUtilList.size();
      int j;
      label888:
      int k;
      if (this.jdField_a_of_type_Vhk != null)
      {
        this.jdField_a_of_type_Vhk.e();
        if ((!(paramActivity instanceof PhotoListActivity)) && (!(paramActivity instanceof NewPhotoListActivity))) {
          break label1118;
        }
        j = 1;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_c_of_type_Int != 11) {
          break label1124;
        }
        k = 0;
        if (j == 0) {
          break label1130;
        }
      }
      for (paramvhi = "0";; paramvhi = "1")
      {
        urp.a("pic_choose_slides", "clk_create", k, 0, new String[] { paramvhi, this.jdField_b_of_type_JavaUtilList.size() + "", m - i + "", i + "" });
        a(paramActivity, this.jdField_b_of_type_JavaUtilList);
        g();
        j = -1;
        localObject1 = "";
        i = j;
        paramvhi = (vhi)localObject1;
        if (this.jdField_b_of_type_JavaUtilList.size() > 0)
        {
          localObject2 = (SlideItemInfo)this.jdField_b_of_type_JavaUtilList.get(0);
          i = j;
          paramvhi = (vhi)localObject1;
          if (localObject2 != null)
          {
            i = ((SlideItemInfo)localObject2).jdField_a_of_type_Int;
            paramvhi = ((SlideItemInfo)localObject2).jdField_a_of_type_JavaLangString;
          }
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(this.jdField_b_of_type_JavaUtilList, this, paramActivity, this.jdField_a_of_type_AndroidOsHandler, paramInt, i, paramvhi);
        break label78;
        break;
        j = 0;
        break label888;
        k = 1;
        break label907;
      }
    }
  }
  
  public void a(Intent paramIntent, Map<String, LocalMediaInfo> paramMap)
  {
    int j = 1;
    if ((paramIntent == null) || (paramMap == null)) {
      return;
    }
    int i = paramIntent.getIntExtra("video_index", 0);
    int n = paramIntent.getIntExtra("start_index", 0);
    int i1 = paramIntent.getIntExtra("end_index", 0);
    int i2 = paramIntent.getIntExtra("scroll_x", 0);
    int k = paramIntent.getIntExtra("start_time", 0);
    int m = paramIntent.getIntExtra("end_time", 0);
    paramIntent = (SlideItemInfo)this.jdField_b_of_type_JavaUtilList.get(i);
    paramIntent.jdField_e_of_type_Int = n;
    paramIntent.f = i1;
    paramIntent.jdField_d_of_type_Int = i2;
    if (Math.abs(k - paramIntent.jdField_b_of_type_Long) >= 50L)
    {
      i = 1;
      label123:
      if (Math.abs(m - paramIntent.jdField_c_of_type_Long) < 50L) {
        break label261;
      }
    }
    for (;;)
    {
      boolean bool = i | 0x0 | j;
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "isOperateClip : " + bool + "  startTime : " + k + "  slideInfo.startTime : " + paramIntent.jdField_b_of_type_Long + " endTime : " + m + "  slideInfo.endTime : " + paramIntent.jdField_c_of_type_Long);
      }
      if (!bool) {
        break;
      }
      paramIntent.jdField_b_of_type_Boolean = bool;
      paramIntent.jdField_b_of_type_Long = k;
      paramIntent.jdField_c_of_type_Long = m;
      return;
      i = 0;
      break label123;
      label261:
      j = 0;
    }
  }
  
  public void a(List<SlideItemInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if (QLog.isColorLevel())
    {
      if ((paramList == null) || (paramHashMap == null)) {
        break label113;
      }
      QLog.e("SlideShowPhotoListManager", 2, "setData selectedPhotoList = " + paramList.size() + " mediaMap=" + paramHashMap.size());
    }
    for (;;)
    {
      if ((paramList != null) && (paramHashMap != null))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.jdField_b_of_type_JavaUtilList);
        paramList = vhj.a(paramList, paramHashMap, localArrayList);
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      }
      return;
      label113:
      QLog.e("SlideShowPhotoListManager", 2, "setData selectedPhotoList = " + paramList + " mediaMap=" + paramHashMap);
    }
  }
  
  public void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap, boolean paramBoolean)
  {
    Object localObject;
    label77:
    LocalMediaInfo localLocalMediaInfo;
    if (QLog.isColorLevel())
    {
      if ((paramList != null) && (paramHashMap != null)) {
        QLog.e("SlideShowPhotoListManager", 2, "onItemsSelectChanged selectedPhotoList = " + paramList.size() + " mediaMap=" + paramHashMap.size());
      }
    }
    else
    {
      if ((paramList == null) || (paramHashMap == null)) {
        break label292;
      }
      localObject = this.jdField_c_of_type_JavaUtilList.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label203;
      }
      localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((String)localIterator.next()).equals(localLocalMediaInfo.path));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localLocalMediaInfo.selectStatus = 1;
        break label77;
        QLog.e("SlideShowPhotoListManager", 2, "onItemsSelectChanged selectedPhotoList = " + paramList + " mediaMap=" + paramHashMap);
        break;
      }
      localLocalMediaInfo.selectStatus = 2;
      break label77;
      label203:
      localObject = new ArrayList();
      ((List)localObject).addAll(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList.clear();
      if (paramHashMap.size() > 0)
      {
        paramList = vhj.a(paramList, paramHashMap, (List)localObject);
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      }
      ((List)localObject).clear();
      if (this.jdField_a_of_type_Vhk != null) {
        this.jdField_a_of_type_Vhk.a();
      }
      if (paramBoolean) {
        d(this.jdField_b_of_type_JavaUtilList);
      }
      label292:
      return;
    }
  }
  
  public void a(@NonNull sdf paramsdf)
  {
    if (paramsdf == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SlideShowPhotoListManager", 2, "setData StoryAlbum AlbumId : " + paramsdf.a() + " mTransId=" + paramsdf.jdField_a_of_type_JavaLangString);
      }
      Object localObject = new ArrayList();
      HashMap localHashMap = new HashMap();
      this.jdField_c_of_type_JavaUtilList.clear();
      Iterator localIterator = paramsdf.a().iterator();
      while (localIterator.hasNext())
      {
        sdg localsdg = (sdg)localIterator.next();
        LocalMediaInfo localLocalMediaInfo = localsdg.a();
        localHashMap.put(localsdg.jdField_a_of_type_JavaLangString, localLocalMediaInfo);
        if (localsdg.a())
        {
          ((List)localObject).add(localsdg.jdField_a_of_type_JavaLangString);
          localLocalMediaInfo.selectStatus = 1;
        }
        localLocalMediaInfo.mAlbumName = paramsdf.jdField_b_of_type_JavaLangString;
        localLocalMediaInfo.mTransId = paramsdf.jdField_a_of_type_JavaLangString;
        localLocalMediaInfo.mTextId = paramsdf.jdField_b_of_type_Int;
        localLocalMediaInfo.mTextStr = paramsdf.jdField_b_of_type_JavaLangString;
        this.jdField_c_of_type_JavaUtilList.add(localLocalMediaInfo);
      }
      a((List)localObject, localHashMap);
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SlideItemInfo)((Iterator)localObject).next()).jdField_a_of_type_Sdf = paramsdf;
      }
    }
  }
  
  public void a(vgv paramvgv)
  {
    Object localObject = QQStoryContext.a();
    String str;
    LocalMediaInfo localLocalMediaInfo;
    agak localagak;
    if (paramvgv.jdField_a_of_type_Int == 0)
    {
      str = paramvgv.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = paramvgv.jdField_b_of_type_JavaLangString;
      localLocalMediaInfo.mMimeType = "video";
      localLocalMediaInfo.mAudioPath = paramvgv.c;
      localLocalMediaInfo.mHasAudioTrack = paramvgv.jdField_a_of_type_Boolean;
      localLocalMediaInfo.mSampleRate = paramvgv.jdField_b_of_type_Int;
      localagak = agak.a(BaseApplicationImpl.getContext());
    }
    for (;;)
    {
      try
      {
        localagak.b(localLocalMediaInfo);
        localObject = (vhn)((AppInterface)localObject).getBusinessHandler(1);
        ((vhn)localObject).a(str, localLocalMediaInfo);
        if (((vhn)localObject).a() == null) {
          ((vhn)localObject).a(paramvgv.jdField_a_of_type_AndroidMediaMediaFormat);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult RESULT_SUCC  hasAudioTrack:" + localLocalMediaInfo.mHasAudioTrack);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult " + paramvgv);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.e("SlideShowPhotoListManager", 1, "pic2video err", localThrowable);
        continue;
      }
      if (paramvgv.jdField_a_of_type_Int == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SlideShowPhotoListManager", 2, "onImage2VideoResult cancel" + paramvgv);
        }
        urp.a("actAlbumResult", new String[] { paramvgv.jdField_a_of_type_Int + "" });
      }
      else if (paramvgv.jdField_a_of_type_Int == 5)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult fail load");
        }
        urp.a("actAlbumResult", new String[] { paramvgv.jdField_a_of_type_Int + "" });
        a(((AppInterface)localObject).getApp(), ajjy.a(2131648403));
      }
      else if (paramvgv.jdField_a_of_type_Int == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowPhotoListManager", 2, "result audio fail");
        }
        urp.a("actAlbumResult", new String[] { paramvgv.jdField_a_of_type_Int + "" });
        a(((AppInterface)localObject).getApp(), ajjy.a(2131648402));
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.b();
        }
        if (this.jdField_a_of_type_Vhk != null) {
          this.jdField_a_of_type_Vhk.g();
        }
      }
      else
      {
        urp.a("actAlbumResult", new String[] { paramvgv.jdField_a_of_type_Int + "" });
      }
    }
  }
  
  public void a(vhk paramvhk)
  {
    this.jdField_a_of_type_Vhk = paramvhk;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vhk != null) {
      this.jdField_a_of_type_Vhk.f();
    }
  }
  
  public boolean a()
  {
    return a(this.jdField_d_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public List<LocalMediaInfo> b()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (((localActivity instanceof PhotoListActivity)) || ((localActivity instanceof PhotoPreviewActivity)) || ((localActivity instanceof NewPhotoListActivity)) || ((localActivity instanceof NewPhotoPreviewActivity))))
      {
        localActivity.finish();
        this.jdField_a_of_type_JavaUtilList.remove(localActivity);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(List<SlideItemInfo> paramList)
  {
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    a(paramList, paramHashMap, true);
  }
  
  public List<SlideItemInfo> c()
  {
    return this.jdField_d_of_type_JavaUtilList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SlideShowPhotoListManager", 2, "onResume");
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void d()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  public void e()
  {
    f();
    vhn localvhn = (vhn)QQStoryContext.a().getBusinessHandler(1);
    if (localvhn != null) {
      localvhn.a();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    SlideShowProcessor.c();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.b();
    }
    if (this.jdField_a_of_type_Vhk != null) {
      this.jdField_a_of_type_Vhk.g();
    }
  }
  
  protected void g()
  {
    vhn localvhn = (vhn)QQStoryContext.a().getBusinessHandler(1);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)localIterator.next();
        if (localvhn.a(localSlideItemInfo.jdField_b_of_type_JavaLangString) == null) {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowPhotoListManager", 2, "checkIsNeedRetrySendConvert allFinish=false picInfo.mPath =" + localSlideItemInfo.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowPhotoListManager", 2, "checkIsNeedRetrySendConvert allFinish=false send convert request...");
        }
        d(this.jdField_b_of_type_JavaUtilList);
      }
      return;
    }
  }
  
  public void h()
  {
    f();
    c(this.jdField_b_of_type_JavaUtilList);
  }
  
  public void i()
  {
    List localList = a().a();
    if (QLog.isColorLevel())
    {
      localObject1 = "before : \n";
      i = 0;
      while (i < localList.size())
      {
        localObject1 = (String)localObject1 + " path : " + ((SlideItemInfo)localList.get(i)).jdField_b_of_type_JavaLangString + " startTime : " + ((SlideItemInfo)localList.get(i)).jdField_b_of_type_Long + " endTime : " + ((SlideItemInfo)localList.get(i)).jdField_c_of_type_Long + " mDuration : " + ((SlideItemInfo)localList.get(i)).jdField_a_of_type_Long + " isOperateClip : " + ((SlideItemInfo)localList.get(i)).jdField_b_of_type_Boolean + "\n";
        i += 1;
      }
      QLog.d("SlideShowPhotoListManager", 2, (String)localObject1);
    }
    Object localObject1 = localList.iterator();
    long l;
    for (int i = 0; ((Iterator)localObject1).hasNext(); i = (int)(((SlideItemInfo)localObject2).jdField_a_of_type_Long + l))
    {
      localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
      l = i;
    }
    if (i <= this.jdField_b_of_type_Int - 500) {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "totalDuration : " + i);
      }
    }
    SlideItemInfo localSlideItemInfo;
    do
    {
      return;
      localObject1 = new ArrayList();
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localSlideItemInfo = (SlideItemInfo)((Iterator)localObject2).next();
        if (localSlideItemInfo.jdField_b_of_type_Int == 1)
        {
          i = 0;
          for (;;)
          {
            if (i < ((List)localObject1).size())
            {
              if (localSlideItemInfo.jdField_a_of_type_Long < ((SlideItemInfo)((List)localObject1).get(i)).jdField_a_of_type_Long) {
                ((List)localObject1).add(i, localSlideItemInfo);
              }
            }
            else
            {
              if (i != ((List)localObject1).size()) {
                break;
              }
              ((List)localObject1).add(localSlideItemInfo);
              break;
            }
            i += 1;
          }
        }
      }
    } while (((List)localObject1).size() == 0);
    i = localList.size();
    int j = ((List)localObject1).size();
    int k = this.jdField_b_of_type_Int - 500 - (i - j) * 2000 - ((List)localObject1).size() * 2000;
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "leftTime : " + k + "   videoCount : " + ((List)localObject1).size());
    }
    Object localObject2 = ((List)localObject1).iterator();
    for (i = 0; ((Iterator)localObject2).hasNext(); i = (int)(localSlideItemInfo.jdField_a_of_type_Long + l))
    {
      localSlideItemInfo = (SlideItemInfo)((Iterator)localObject2).next();
      l = i;
    }
    int m = ((List)localObject1).size();
    j = 0;
    while (j < ((List)localObject1).size())
    {
      localObject2 = (SlideItemInfo)((List)localObject1).get(j);
      int n = (int)(((float)((SlideItemInfo)localObject2).jdField_a_of_type_Long - 2000.0F) / (i - m * 2000) * k) + 2000;
      if ((Math.abs(n - ((SlideItemInfo)localObject2).jdField_c_of_type_Long) > 50L) || (Math.abs(((SlideItemInfo)localObject2).jdField_b_of_type_Long) > 50L))
      {
        ((SlideItemInfo)localObject2).jdField_b_of_type_Boolean = true;
        ((SlideItemInfo)localObject2).jdField_c_of_type_Boolean = true;
      }
      ((SlideItemInfo)localObject2).jdField_c_of_type_Long = n;
      ((SlideItemInfo)localObject2).jdField_b_of_type_Long = 0L;
      ((SlideItemInfo)localObject2).jdField_e_of_type_Int = 0;
      ((SlideItemInfo)localObject2).f = 0;
      ((SlideItemInfo)localObject2).jdField_d_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "eachTime <= info.mDuration, i : " + j + "  leftTime : " + k + "  mDuration : " + ((SlideItemInfo)localObject2).jdField_a_of_type_Long);
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = "after : \n";
      i = 0;
      while (i < localList.size())
      {
        localObject1 = (String)localObject1 + " path : " + ((SlideItemInfo)localList.get(i)).jdField_b_of_type_JavaLangString + " startTime : " + ((SlideItemInfo)localList.get(i)).jdField_b_of_type_Long + " endTime : " + ((SlideItemInfo)localList.get(i)).jdField_c_of_type_Long + " mDuration : " + ((SlideItemInfo)localList.get(i)).jdField_a_of_type_Long + " isOperateClip : " + ((SlideItemInfo)localList.get(i)).jdField_b_of_type_Boolean + "\n";
        i += 1;
      }
      QLog.d("SlideShowPhotoListManager", 2, (String)localObject1);
    }
    this.jdField_a_of_type_Vhk.a();
    f();
    d(localList);
    this.jdField_a_of_type_Vhk.b();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Vhk != null) {
      this.jdField_a_of_type_Vhk.g();
    }
    if (this.jdField_a_of_type_Vhi != null) {
      this.jdField_a_of_type_Vhi.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhg
 * JD-Core Version:    0.7.0.1
 */