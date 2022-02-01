import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.2;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ylg
  implements ylv, yma
{
  public static final int a;
  private static ylg jdField_a_of_type_Ylg;
  long jdField_a_of_type_Long;
  protected Handler a;
  bmte jdField_a_of_type_Bmte = new ylh(this);
  protected SlideShowProcessor a;
  protected List<WeakReference<Activity>> a;
  protected yli a;
  private ylk jdField_a_of_type_Ylk;
  private int jdField_b_of_type_Int = 20999;
  private List<SlideItemInfo> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private int jdField_c_of_type_Int;
  private List<LocalMediaInfo> jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private int jdField_d_of_type_Int = 21;
  private List<SlideItemInfo> jdField_d_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_Int = DisplayUtil.dip2px(BaseApplicationImpl.getApplication(), 62.0F);
  }
  
  public ylg()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor = new SlideShowProcessor();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a();
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager create, ", new Exception());
    }
  }
  
  public static ylg a()
  {
    if (jdField_a_of_type_Ylg == null) {
      jdField_a_of_type_Ylg = new ylg();
    }
    return jdField_a_of_type_Ylg;
  }
  
  private void a(Activity paramActivity, List<String> paramList, yli paramyli, int paramInt)
  {
    paramList = (SlideItemInfo)a().get(0);
    if (paramList.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_Yli = paramyli;
      if (((this.jdField_c_of_type_Int == 13) || (this.jdField_c_of_type_Int == 11) || (this.jdField_c_of_type_Int == 12) || (this.jdField_d_of_type_Int == 22)) && (((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
        a();
      }
      if (this.jdField_a_of_type_Ylk != null) {
        this.jdField_a_of_type_Ylk.c();
      }
      int j = -1;
      paramyli = "";
      int i = j;
      paramList = paramyli;
      if (this.jdField_b_of_type_JavaUtilList.size() > 0)
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.jdField_b_of_type_JavaUtilList.get(0);
        i = j;
        paramList = paramyli;
        if (localSlideItemInfo != null)
        {
          i = localSlideItemInfo.jdField_a_of_type_Int;
          paramList = localSlideItemInfo.jdField_a_of_type_JavaLangString;
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(this.jdField_b_of_type_JavaUtilList, this, paramActivity, this.jdField_a_of_type_AndroidOsHandler, paramInt, i, paramList);
      return;
    }
    bnsr.a(paramActivity, paramList.jdField_b_of_type_JavaLangString, paramList.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, (int)paramList.jdField_b_of_type_Long, (int)paramList.jdField_c_of_type_Long, 120, 10023, 0, "", "", false, 11, 14, null);
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
      paramContext = yld.a(paramContext).a(((SlideItemInfo)paramList.get(0)).jdField_e_of_type_JavaLangString);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((QIMMusicConfigManager)bmql.a(2)).a(((yle)paramContext.get(0)).jdField_a_of_type_Int, ((yle)paramContext.get(0)).jdField_b_of_type_Int);
        if (paramContext != null)
        {
          paramList = (bmtm)bmql.a().c(8);
          if ((paramList != null) && (!paramList.b(paramContext)))
          {
            paramList.a(paramContext, this.jdField_a_of_type_Bmte);
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
      localObject1 = (yln)QQStoryContext.a().getBusinessHandler(1);
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
          if ((!((yln)localObject1).a(localSlideItemInfo.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo.jdField_b_of_type_JavaLangString))) {
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
      if ((l2 <= this.jdField_b_of_type_Int) || (ykt.a().b() == 22)) {
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
      yln localyln = (yln)QQStoryContext.a().getBusinessHandler(1);
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
            if (!localyln.a(localSlideItemInfo.jdField_b_of_type_JavaLangString))
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
                  localLocalMediaInfo = localyln.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                  if (localLocalMediaInfo != null)
                  {
                    FileUtil.deleteFile(localLocalMediaInfo.path);
                    localyln.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
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
                localLocalMediaInfo = localyln.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
                if (localLocalMediaInfo != null) {
                  FileUtil.deleteFile(localLocalMediaInfo.path);
                }
                localyln.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
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
  
  public void a(Activity paramActivity, yli paramyli, int paramInt)
  {
    Object localObject1 = ylj.a(a());
    if ((paramActivity == null) || (localObject1 == null) || (((List)localObject1).isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "activity == null || imgPathList == null");
      }
    }
    boolean bool;
    SlideItemInfo localSlideItemInfo;
    do
    {
      return;
      bool = paramActivity instanceof NewPhotoListActivity;
      if (a(paramActivity))
      {
        a(paramActivity, (List)localObject1, paramyli, paramInt);
        return;
      }
      if ((((List)localObject1).size() != 1) || (this.jdField_d_of_type_Int == 22)) {
        break;
      }
      localSlideItemInfo = (SlideItemInfo)a().get(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo.jdField_b_of_type_JavaLangString);
      paramInt = 99;
      if (paramActivity.getIntent() != null) {
        paramInt = paramActivity.getIntent().getIntExtra("entrance_type", 99);
      }
      if (localSlideItemInfo.jdField_b_of_type_Int == 0)
      {
        paramyli = EditPicActivity.a(paramActivity, localSlideItemInfo.jdField_b_of_type_JavaLangString, true, true, true, true, true, false, false, false, 2, paramInt, 0, false, null);
        paramyli.putExtra("media_info", localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        paramyli.putExtra("extra_edit_video_from", 2);
        paramActivity.startActivityForResult(paramyli, 10002);
        paramActivity = new StringBuilder();
        if (bool) {}
        for (paramInt = 0;; paramInt = 1)
        {
          xwa.a("video_edit", "edit_local", 0, 0, new String[] { paramInt + "" });
          return;
        }
      }
    } while (localSlideItemInfo.jdField_b_of_type_Int != 1);
    paramyli = new StringBuilder();
    if (bool) {}
    Object localObject2;
    int j;
    for (int i = 0;; i = 1)
    {
      xwa.a("video_edit", "edit_local", 0, 1, new String[] { i + "" });
      i = 0;
      paramyli = null;
      localObject1 = null;
      bool = false;
      localObject2 = null;
      Intent localIntent = paramActivity.getIntent();
      if (localIntent != null)
      {
        i = localIntent.getIntExtra("shareGroupType", 0);
        paramyli = localIntent.getStringExtra("shareGroupId");
        localObject1 = localIntent.getStringExtra("shareGroupName");
        bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
        localIntent.putExtra("extra_edit_video_from", 3);
        localObject2 = bmqi.a(localIntent);
      }
      j = 10002;
      if (a().b() == 22) {
        j = 10001;
      }
      bnsr.a(paramActivity, localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, (int)localSlideItemInfo.jdField_b_of_type_Long, (int)localSlideItemInfo.jdField_c_of_type_Long, paramInt, j, i, paramyli, (String)localObject1, bool, 3, 2, (Bundle)localObject2);
      return;
    }
    this.jdField_a_of_type_Yli = paramyli;
    if (((this.jdField_c_of_type_Int == 13) || (this.jdField_c_of_type_Int == 11) || (this.jdField_c_of_type_Int == 12) || (this.jdField_d_of_type_Int == 22)) && (((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
      a();
    }
    paramyli = this.jdField_b_of_type_JavaUtilList.iterator();
    i = 0;
    if (paramyli.hasNext())
    {
      localObject1 = (SlideItemInfo)paramyli.next();
      if ((localObject1 == null) || (((SlideItemInfo)localObject1).jdField_b_of_type_Int != 1)) {
        break label856;
      }
      i += 1;
    }
    label837:
    label843:
    label849:
    label856:
    for (;;)
    {
      break;
      int m = this.jdField_b_of_type_JavaUtilList.size();
      int k;
      if (this.jdField_a_of_type_Ylk != null)
      {
        this.jdField_a_of_type_Ylk.c();
        if (!(paramActivity instanceof NewPhotoListActivity)) {
          break label837;
        }
        j = 1;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_c_of_type_Int != 11) {
          break label843;
        }
        k = 0;
        label628:
        if (j == 0) {
          break label849;
        }
      }
      for (paramyli = "0";; paramyli = "1")
      {
        xwa.a("pic_choose_slides", "clk_create", k, 0, new String[] { paramyli, this.jdField_b_of_type_JavaUtilList.size() + "", m - i + "", i + "" });
        a(paramActivity, this.jdField_b_of_type_JavaUtilList);
        g();
        j = -1;
        localObject1 = "";
        i = j;
        paramyli = (yli)localObject1;
        if (this.jdField_b_of_type_JavaUtilList.size() > 0)
        {
          localObject2 = (SlideItemInfo)this.jdField_b_of_type_JavaUtilList.get(0);
          i = j;
          paramyli = (yli)localObject1;
          if (localObject2 != null)
          {
            i = ((SlideItemInfo)localObject2).jdField_a_of_type_Int;
            paramyli = ((SlideItemInfo)localObject2).jdField_a_of_type_JavaLangString;
          }
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(this.jdField_b_of_type_JavaUtilList, this, paramActivity, this.jdField_a_of_type_AndroidOsHandler, paramInt, i, paramyli);
        return;
        j = 0;
        break;
        k = 1;
        break label628;
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
        paramList = ylj.a(paramList, paramHashMap, localArrayList);
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
        paramList = ylj.a(paramList, paramHashMap, (List)localObject);
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      }
      ((List)localObject).clear();
      if (this.jdField_a_of_type_Ylk != null) {
        this.jdField_a_of_type_Ylk.a();
      }
      if (paramBoolean) {
        d(this.jdField_b_of_type_JavaUtilList);
      }
      label292:
      return;
    }
  }
  
  public void a(@NonNull vil paramvil)
  {
    if (paramvil == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SlideShowPhotoListManager", 2, "setData StoryAlbum AlbumId : " + paramvil.a() + " mTransId=" + paramvil.jdField_a_of_type_JavaLangString);
      }
      Object localObject = new ArrayList();
      HashMap localHashMap = new HashMap();
      this.jdField_c_of_type_JavaUtilList.clear();
      Iterator localIterator = paramvil.a().iterator();
      while (localIterator.hasNext())
      {
        vim localvim = (vim)localIterator.next();
        LocalMediaInfo localLocalMediaInfo = localvim.a();
        localHashMap.put(localvim.jdField_a_of_type_JavaLangString, localLocalMediaInfo);
        if (localvim.a())
        {
          ((List)localObject).add(localvim.jdField_a_of_type_JavaLangString);
          localLocalMediaInfo.selectStatus = 1;
        }
        localLocalMediaInfo.mAlbumName = paramvil.jdField_b_of_type_JavaLangString;
        localLocalMediaInfo.mTransId = paramvil.jdField_a_of_type_JavaLangString;
        localLocalMediaInfo.mTextId = paramvil.jdField_b_of_type_Int;
        localLocalMediaInfo.mTextStr = paramvil.jdField_b_of_type_JavaLangString;
        this.jdField_c_of_type_JavaUtilList.add(localLocalMediaInfo);
      }
      a((List)localObject, localHashMap);
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SlideItemInfo)((Iterator)localObject).next()).jdField_a_of_type_Vil = paramvil;
      }
    }
  }
  
  public void a(ykv paramykv)
  {
    Object localObject = QQStoryContext.a();
    String str;
    LocalMediaInfo localLocalMediaInfo;
    MediaScanner localMediaScanner;
    if (paramykv.jdField_a_of_type_Int == 0)
    {
      str = paramykv.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = paramykv.jdField_b_of_type_JavaLangString;
      localLocalMediaInfo.mMimeType = "video";
      localLocalMediaInfo.mAudioPath = paramykv.c;
      localLocalMediaInfo.mHasAudioTrack = paramykv.jdField_a_of_type_Boolean;
      localLocalMediaInfo.mSampleRate = paramykv.jdField_b_of_type_Int;
      localMediaScanner = MediaScanner.getInstance(BaseApplicationImpl.getContext());
    }
    for (;;)
    {
      try
      {
        localMediaScanner.buildAndUpdateVideo(localLocalMediaInfo);
        localObject = (yln)((AppInterface)localObject).getBusinessHandler(1);
        ((yln)localObject).a(str, localLocalMediaInfo);
        if (((yln)localObject).a() == null) {
          ((yln)localObject).a(paramykv.jdField_a_of_type_AndroidMediaMediaFormat);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult RESULT_SUCC  hasAudioTrack:" + localLocalMediaInfo.mHasAudioTrack);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult " + paramykv);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.e("SlideShowPhotoListManager", 1, "pic2video err", localThrowable);
        continue;
      }
      if (paramykv.jdField_a_of_type_Int == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SlideShowPhotoListManager", 2, "onImage2VideoResult cancel" + paramykv);
        }
        xwa.a("actAlbumResult", new String[] { paramykv.jdField_a_of_type_Int + "" });
      }
      else if (paramykv.jdField_a_of_type_Int == 5)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult fail load");
        }
        xwa.a("actAlbumResult", new String[] { paramykv.jdField_a_of_type_Int + "" });
        a(((AppInterface)localObject).getApp(), amtj.a(2131713296));
      }
      else if (paramykv.jdField_a_of_type_Int == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowPhotoListManager", 2, "result audio fail");
        }
        xwa.a("actAlbumResult", new String[] { paramykv.jdField_a_of_type_Int + "" });
        a(((AppInterface)localObject).getApp(), amtj.a(2131713295));
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.b();
        }
        if (this.jdField_a_of_type_Ylk != null) {
          this.jdField_a_of_type_Ylk.e();
        }
      }
      else
      {
        xwa.a("actAlbumResult", new String[] { paramykv.jdField_a_of_type_Int + "" });
      }
    }
  }
  
  public void a(ylk paramylk)
  {
    this.jdField_a_of_type_Ylk = paramylk;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ylk != null) {
      this.jdField_a_of_type_Ylk.d();
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
      if ((localActivity != null) && (((localActivity instanceof NewPhotoListActivity)) || ((localActivity instanceof NewPhotoPreviewActivity))))
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
    yln localyln = (yln)QQStoryContext.a().getBusinessHandler(1);
    if (localyln != null) {
      localyln.a();
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
    if (this.jdField_a_of_type_Ylk != null) {
      this.jdField_a_of_type_Ylk.e();
    }
  }
  
  protected void g()
  {
    yln localyln = (yln)QQStoryContext.a().getBusinessHandler(1);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)localIterator.next();
        if (localyln.a(localSlideItemInfo.jdField_b_of_type_JavaLangString) == null) {
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
    this.jdField_a_of_type_Ylk.a();
    f();
    d(localList);
    this.jdField_a_of_type_Ylk.b();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Ylk != null) {
      this.jdField_a_of_type_Ylk.e();
    }
    if (this.jdField_a_of_type_Yli != null) {
      this.jdField_a_of_type_Yli.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylg
 * JD-Core Version:    0.7.0.1
 */