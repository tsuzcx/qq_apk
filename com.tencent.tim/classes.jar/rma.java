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
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.b;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
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

public class rma
  implements SlideShowProcessor.b, rmn.b
{
  private static rma jdField_a_of_type_Rma;
  public static final int btm = riw.dip2px(BaseApplicationImpl.getApplication(), 62.0F);
  long Cm;
  axrh jdField_a_of_type_Axrh = new rmb(this);
  protected SlideShowProcessor a;
  protected rma.a a;
  private rmd jdField_a_of_type_Rmd;
  private int btn;
  private int bto = 21;
  private List<SlideItemInfo> fl = new CopyOnWriteArrayList();
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private List<SlideItemInfo> mItemList = new CopyOnWriteArrayList();
  private List<LocalMediaInfo> mMediaList = new CopyOnWriteArrayList();
  private int mTotalDuration = 20999;
  protected List<WeakReference<Activity>> pa = new CopyOnWriteArrayList();
  
  public rma()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor = new SlideShowProcessor();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.init();
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager create, ", new Exception());
    }
  }
  
  public static rma a()
  {
    if (jdField_a_of_type_Rma == null) {
      jdField_a_of_type_Rma = new rma();
    }
    return jdField_a_of_type_Rma;
  }
  
  private void a(Activity paramActivity, List<String> paramList, rma.a parama, int paramInt)
  {
    paramList = (SlideItemInfo)getPhotoList().get(0);
    if (paramList.mediaType == 0)
    {
      this.jdField_a_of_type_Rma$a = parama;
      if (((this.btn == 13) || (this.btn == 11) || (this.btn == 12) || (this.bto == 22)) && (((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
        bvp();
      }
      if (this.jdField_a_of_type_Rmd != null) {
        this.jdField_a_of_type_Rmd.bvw();
      }
      int j = -1;
      parama = "";
      int i = j;
      paramList = parama;
      if (this.mItemList.size() > 0)
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.mItemList.get(0);
        i = j;
        paramList = parama;
        if (localSlideItemInfo != null)
        {
          i = localSlideItemInfo.mTextId;
          paramList = localSlideItemInfo.mTextStr;
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(this.mItemList, this, paramActivity, this.mHandler, paramInt, i, paramList);
      return;
    }
    aytv.a(paramActivity, paramList.mSrcPath, paramList.d, (int)paramList.startTime, (int)paramList.endTime, 120, 10023, 0, "", "", false, 11, 14, null);
  }
  
  private void bd(Context paramContext, String paramString)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new SlideShowPhotoListManager.2(this, paramContext, paramString));
  }
  
  private void c(Context paramContext, List<SlideItemInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramContext = rly.a(paramContext).S(((SlideItemInfo)paramList.get(0)).mTransId);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((QIMMusicConfigManager)axov.a(2)).a(((rly.a)paramContext.get(0)).tagId, ((rly.a)paramContext.get(0)).itemId);
        if (paramContext != null)
        {
          paramList = (axro)axov.a().c(8);
          if ((paramList != null) && (!paramList.b(paramContext)))
          {
            paramList.a(paramContext, this.jdField_a_of_type_Axrh);
            if (QLog.isColorLevel()) {
              QLog.d("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager preloadMusic mItemId=" + paramContext.mItemId);
            }
          }
        }
      }
    }
  }
  
  private void eX(List<SlideItemInfo> paramList)
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
      l = ((SlideItemInfo)localObject2).dU() + l;
    }
    label348:
    label359:
    for (;;)
    {
      break label67;
      if (l > this.mTotalDuration)
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
      localObject1 = (rmf)QQStoryContext.c().getBusinessHandler(1);
      localObject2 = new ArrayList();
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label348;
        }
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowPhotoListManager", 2, "info : " + localSlideItemInfo + "  info.mSrcPath : " + localSlideItemInfo.mSrcPath);
        }
        if ((localSlideItemInfo != null) && (!TextUtils.isEmpty(localSlideItemInfo.mSrcPath)))
        {
          if (localSlideItemInfo.mediaType == 1)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SlideShowPhotoListManager", 2, "convertToVideoBatch mediaType is video, error");
            return;
          }
          if ((!((rmf)localObject1).fv(localSlideItemInfo.mSrcPath)) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.fw(localSlideItemInfo.mSrcPath))) {
            ((List)localObject2).add(localSlideItemInfo);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a((List)localObject2, this);
      return;
    }
  }
  
  private void eY(List<SlideItemInfo> paramList)
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
      l1 = localSlideItemInfo.dU() + l1;
    }
    label177:
    for (;;)
    {
      break;
      l2 = 0L;
      label95:
      if ((l2 <= this.mTotalDuration) || (rlr.a().tG() == 22)) {
        if (paramList != null) {
          eZ(paramList);
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
  
  private void eZ(@NonNull List<SlideItemInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor != null)
    {
      rmf localrmf = (rmf)QQStoryContext.c().getBusinessHandler(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
        if ((localSlideItemInfo != null) && (!TextUtils.isEmpty(localSlideItemInfo.mSrcPath)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SlideShowPhotoListManager", 2, "convertToVideo path = " + localSlideItemInfo.mSrcPath);
          }
          long l = localSlideItemInfo.dU();
          if (l > this.mTotalDuration - 2000)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SlideShowPhotoListManager", 2, "Duration too max: convertToVideoInternal durationValid=" + l);
            }
            localSlideItemInfo.aIN = false;
          }
          else
          {
            boolean bool = localSlideItemInfo.aIN;
            localSlideItemInfo.aIN = false;
            LocalMediaInfo localLocalMediaInfo;
            if (!localrmf.fv(localSlideItemInfo.mSrcPath))
            {
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.fw(localSlideItemInfo.mSrcPath))
              {
                this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.i("SlideShowPhotoListManager", 2, "[hasAlreadyRunning=true]convertToVideo path = " + localSlideItemInfo.mSrcPath);
                }
                if ((bool) && (localSlideItemInfo.mediaType == 1))
                {
                  this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.sC(localSlideItemInfo.mSrcPath);
                  localLocalMediaInfo = localrmf.b(localSlideItemInfo.mSrcPath);
                  if (localLocalMediaInfo != null)
                  {
                    ahbj.deleteFile(localLocalMediaInfo.path);
                    localrmf.sB(localSlideItemInfo.mSrcPath);
                  }
                  this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
                }
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.i("SlideShowPhotoListManager", 2, "[hasCachedMediaInfo=true]convertToVideo path = " + localSlideItemInfo.mSrcPath);
              }
              if ((bool) && (localSlideItemInfo.mediaType == 1))
              {
                localLocalMediaInfo = localrmf.b(localSlideItemInfo.mSrcPath);
                if (localLocalMediaInfo != null) {
                  ahbj.deleteFile(localLocalMediaInfo.path);
                }
                localrmf.sB(localSlideItemInfo.mSrcPath);
                this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(localSlideItemInfo, this);
              }
            }
          }
        }
        else if (localSlideItemInfo != null)
        {
          localSlideItemInfo.aIN = false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "combine video mConvertProcessor is null");
    }
  }
  
  private boolean g(List<SlideItemInfo> paramList1, List<SlideItemInfo> paramList2)
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
      localHashSet.add(((SlideItemInfo)paramList1.next()).mSrcPath);
    }
    if (localHashSet.size() != paramList2.size()) {
      return true;
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext()) {
      if (!localHashSet.contains(((SlideItemInfo)paramList1.next()).mSrcPath)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean o(Activity paramActivity)
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
  
  public boolean LI()
  {
    return g(this.fl, this.mItemList);
  }
  
  public void a(Activity paramActivity, rma.a parama, int paramInt)
  {
    Object localObject1 = rmc.ax(getPhotoList());
    if ((paramActivity == null) || (localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "activity == null || imgPathList == null");
      }
      return;
    }
    boolean bool1 = paramActivity instanceof NewPhotoListActivity;
    if (o(paramActivity)) {
      a(paramActivity, (List)localObject1, parama, paramInt);
    }
    label67:
    Object localObject2;
    int i;
    for (;;)
    {
      if (awsy.dsn)
      {
        awsy.dsn = true;
        paramActivity = ShortVideoUtils.a(awsy.bV);
        if (a().tG() != 21) {
          break;
        }
        rar.a("clk_mode", 10002, 0, new String[] { paramActivity, "0", "", "" });
        return;
        if ((((List)localObject1).size() == 1) && (this.bto != 22))
        {
          SlideItemInfo localSlideItemInfo = (SlideItemInfo)getPhotoList().get(0);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.sC(localSlideItemInfo.mSrcPath);
          if (localSlideItemInfo.mediaType == 0)
          {
            parama = null;
            paramInt = 99;
            if (paramActivity.getIntent() != null)
            {
              parama = paramActivity.getIntent().getStringExtra("shareGroupId");
              paramInt = paramActivity.getIntent().getIntExtra("entrance_type", 99);
            }
            boolean bool2 = TextUtils.isEmpty(parama);
            parama = EditPicActivity.a(paramActivity, localSlideItemInfo.mSrcPath, true, true, true, true, true, true, bool2, bool2, 1, paramInt, 0, false, null);
            parama.putExtra("media_info", localSlideItemInfo.d);
            parama.putExtra("extra_edit_video_from", 2);
            paramActivity.startActivityForResult(parama, 10002);
            paramActivity = new StringBuilder();
            if (bool1) {}
            for (paramInt = 0;; paramInt = 1)
            {
              rar.a("video_edit", "edit_local", 0, 0, new String[] { paramInt + "" });
              if (awsy.dso) {
                break;
              }
              awsy.dso = true;
              paramInt = 0;
              if (awsy.Mp != -1L) {
                paramInt = (int)(System.currentTimeMillis() - awsy.Mp);
              }
              rar.a("time_shoot", 10002, paramInt, new String[] { String.valueOf(2), "0", "", "" });
              break;
            }
          }
          if (localSlideItemInfo.mediaType == 1)
          {
            parama = new StringBuilder();
            if (bool1) {}
            for (paramInt = 0;; paramInt = 1)
            {
              rar.a("video_edit", "edit_local", 0, 1, new String[] { paramInt + "" });
              paramInt = 0;
              parama = null;
              localObject1 = null;
              bool1 = false;
              localObject2 = null;
              Intent localIntent = paramActivity.getIntent();
              if (localIntent != null)
              {
                paramInt = localIntent.getIntExtra("shareGroupType", 0);
                parama = localIntent.getStringExtra("shareGroupId");
                localObject1 = localIntent.getStringExtra("shareGroupName");
                bool1 = localIntent.getBooleanExtra("ignorePersonalPublish", false);
                localIntent.putExtra("extra_edit_video_from", 3);
                localObject2 = axom.e(localIntent);
              }
              i = 10002;
              if (a().tG() == 22) {
                i = 10001;
              }
              aytv.a(paramActivity, localSlideItemInfo.mSrcPath, localSlideItemInfo.d, (int)localSlideItemInfo.startTime, (int)localSlideItemInfo.endTime, 103, i, paramInt, parama, (String)localObject1, bool1, 3, 1, (Bundle)localObject2);
              if (awsy.dso) {
                break;
              }
              awsy.dso = true;
              paramInt = 0;
              if (awsy.Mp != -1L) {
                paramInt = (int)(System.currentTimeMillis() - awsy.Mp);
              }
              long l = localSlideItemInfo.d.mDuration;
              if (a().tG() != 21) {
                break;
              }
              rar.a("time_shoot", 10002, paramInt, new String[] { String.valueOf(2), String.valueOf(l), "", "" });
              break;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_Rma$a = parama;
          if (((this.btn == 13) || (this.btn == 11) || (this.btn == 12) || (this.bto == 22)) && (((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))) {
            bvp();
          }
          parama = this.mItemList.iterator();
          i = 0;
          label772:
          if (parama.hasNext())
          {
            localObject1 = (SlideItemInfo)parama.next();
            if ((localObject1 == null) || (((SlideItemInfo)localObject1).mediaType != 1)) {
              break label1099;
            }
            i += 1;
          }
        }
      }
    }
    label1080:
    label1086:
    label1092:
    label1099:
    for (;;)
    {
      break label772;
      int m = this.mItemList.size();
      int j;
      label850:
      int k;
      if (this.jdField_a_of_type_Rmd != null)
      {
        this.jdField_a_of_type_Rmd.bvw();
        if (!(paramActivity instanceof NewPhotoListActivity)) {
          break label1080;
        }
        j = 1;
        this.Cm = System.currentTimeMillis();
        if (this.btn != 11) {
          break label1086;
        }
        k = 0;
        label869:
        if (j == 0) {
          break label1092;
        }
      }
      for (parama = "0";; parama = "1")
      {
        rar.a("pic_choose_slides", "clk_create", k, 0, new String[] { parama, this.mItemList.size() + "", m - i + "", i + "" });
        c(paramActivity, this.mItemList);
        bvt();
        j = -1;
        localObject1 = "";
        i = j;
        parama = (rma.a)localObject1;
        if (this.mItemList.size() > 0)
        {
          localObject2 = (SlideItemInfo)this.mItemList.get(0);
          i = j;
          parama = (rma.a)localObject1;
          if (localObject2 != null)
          {
            i = ((SlideItemInfo)localObject2).mTextId;
            parama = ((SlideItemInfo)localObject2).mTextStr;
          }
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.a(this.mItemList, this, paramActivity, this.mHandler, paramInt, i, parama);
        break label67;
        break;
        j = 0;
        break label850;
        k = 1;
        break label869;
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
    paramIntent = (SlideItemInfo)this.mItemList.get(i);
    paramIntent.startIndex = n;
    paramIntent.endIndex = i1;
    paramIntent.scrollX = i2;
    if (Math.abs(k - paramIntent.startTime) >= 50L)
    {
      i = 1;
      label123:
      if (Math.abs(m - paramIntent.endTime) < 50L) {
        break label261;
      }
    }
    for (;;)
    {
      boolean bool = i | 0x0 | j;
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "isOperateClip : " + bool + "  startTime : " + k + "  slideInfo.startTime : " + paramIntent.startTime + " endTime : " + m + "  slideInfo.endTime : " + paramIntent.endTime);
      }
      if (!bool) {
        break;
      }
      paramIntent.aIN = bool;
      paramIntent.startTime = k;
      paramIntent.endTime = m;
      return;
      i = 0;
      break label123;
      label261:
      j = 0;
    }
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
        localArrayList.addAll(this.mItemList);
        paramList = rmc.a(paramList, paramHashMap, localArrayList);
        this.mItemList.clear();
        this.mItemList.addAll(paramList);
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
      localObject = this.mMediaList.iterator();
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
      ((List)localObject).addAll(this.mItemList);
      this.mItemList.clear();
      if (paramHashMap.size() > 0)
      {
        paramList = rmc.a(paramList, paramHashMap, (List)localObject);
        this.mItemList.addAll(paramList);
      }
      ((List)localObject).clear();
      if (this.jdField_a_of_type_Rmd != null) {
        this.jdField_a_of_type_Rmd.update();
      }
      if (paramBoolean) {
        eY(this.mItemList);
      }
      label292:
      return;
    }
  }
  
  public void a(rmd paramrmd)
  {
    this.jdField_a_of_type_Rmd = paramrmd;
  }
  
  public void b(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    a(paramList, paramHashMap, true);
  }
  
  public void bf(Activity paramActivity)
  {
    this.pa.add(new WeakReference(paramActivity));
  }
  
  public void blB()
  {
    if (this.jdField_a_of_type_Rmd != null) {
      this.jdField_a_of_type_Rmd.blB();
    }
    if (this.jdField_a_of_type_Rma$a != null) {
      this.jdField_a_of_type_Rma$a.blB();
    }
  }
  
  public void bvp()
  {
    Iterator localIterator = this.pa.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && ((localActivity instanceof EditVideoActivity)))
      {
        localActivity.finish();
        this.pa.remove(localActivity);
      }
    }
  }
  
  public void bvq()
  {
    Iterator localIterator = this.pa.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (((localActivity instanceof NewPhotoListActivity)) || ((localActivity instanceof NewPhotoPreviewActivity))))
      {
        localActivity.finish();
        this.pa.remove(localActivity);
      }
    }
  }
  
  public void bvr()
  {
    bvs();
    rmf localrmf = (rmf)QQStoryContext.c().getBusinessHandler(1);
    if (localrmf != null) {
      localrmf.clear();
    }
    this.mItemList.clear();
    this.mMediaList.clear();
    SlideShowProcessor.clearCache();
  }
  
  public void bvs()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.stopAll();
    }
    if (this.jdField_a_of_type_Rmd != null) {
      this.jdField_a_of_type_Rmd.blB();
    }
  }
  
  protected void bvt()
  {
    rmf localrmf = (rmf)QQStoryContext.c().getBusinessHandler(1);
    Iterator localIterator = this.mItemList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        SlideItemInfo localSlideItemInfo = (SlideItemInfo)localIterator.next();
        if (localrmf.b(localSlideItemInfo.mSrcPath) == null) {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowPhotoListManager", 2, "checkIsNeedRetrySendConvert allFinish=false picInfo.mPath =" + localSlideItemInfo.mSrcPath);
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
        eY(this.mItemList);
      }
      return;
    }
  }
  
  public void bvu()
  {
    bvs();
    eX(this.mItemList);
  }
  
  public void bvv()
  {
    List localList = a().getPhotoList();
    if (QLog.isColorLevel())
    {
      localObject1 = "before : \n";
      i = 0;
      while (i < localList.size())
      {
        localObject1 = (String)localObject1 + " path : " + ((SlideItemInfo)localList.get(i)).mSrcPath + " startTime : " + ((SlideItemInfo)localList.get(i)).startTime + " endTime : " + ((SlideItemInfo)localList.get(i)).endTime + " mDuration : " + ((SlideItemInfo)localList.get(i)).mDuration + " isOperateClip : " + ((SlideItemInfo)localList.get(i)).aIN + "\n";
        i += 1;
      }
      QLog.d("SlideShowPhotoListManager", 2, (String)localObject1);
    }
    Object localObject1 = localList.iterator();
    long l;
    for (int i = 0; ((Iterator)localObject1).hasNext(); i = (int)(((SlideItemInfo)localObject2).mDuration + l))
    {
      localObject2 = (SlideItemInfo)((Iterator)localObject1).next();
      l = i;
    }
    if (i <= this.mTotalDuration - 500) {
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
        if (localSlideItemInfo.mediaType == 1)
        {
          i = 0;
          for (;;)
          {
            if (i < ((List)localObject1).size())
            {
              if (localSlideItemInfo.mDuration < ((SlideItemInfo)((List)localObject1).get(i)).mDuration) {
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
    int k = this.mTotalDuration - 500 - (i - j) * 2000 - ((List)localObject1).size() * 2000;
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "leftTime : " + k + "   videoCount : " + ((List)localObject1).size());
    }
    Object localObject2 = ((List)localObject1).iterator();
    for (i = 0; ((Iterator)localObject2).hasNext(); i = (int)(localSlideItemInfo.mDuration + l))
    {
      localSlideItemInfo = (SlideItemInfo)((Iterator)localObject2).next();
      l = i;
    }
    int m = ((List)localObject1).size();
    j = 0;
    while (j < ((List)localObject1).size())
    {
      localObject2 = (SlideItemInfo)((List)localObject1).get(j);
      int n = (int)(((float)((SlideItemInfo)localObject2).mDuration - 2000.0F) / (i - m * 2000) * k) + 2000;
      if ((Math.abs(n - ((SlideItemInfo)localObject2).endTime) > 50L) || (Math.abs(((SlideItemInfo)localObject2).startTime) > 50L))
      {
        ((SlideItemInfo)localObject2).aIN = true;
        ((SlideItemInfo)localObject2).aIO = true;
      }
      ((SlideItemInfo)localObject2).endTime = n;
      ((SlideItemInfo)localObject2).startTime = 0L;
      ((SlideItemInfo)localObject2).startIndex = 0;
      ((SlideItemInfo)localObject2).endIndex = 0;
      ((SlideItemInfo)localObject2).scrollX = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "eachTime <= info.mDuration, i : " + j + "  leftTime : " + k + "  mDuration : " + ((SlideItemInfo)localObject2).mDuration);
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = "after : \n";
      i = 0;
      while (i < localList.size())
      {
        localObject1 = (String)localObject1 + " path : " + ((SlideItemInfo)localList.get(i)).mSrcPath + " startTime : " + ((SlideItemInfo)localList.get(i)).startTime + " endTime : " + ((SlideItemInfo)localList.get(i)).endTime + " mDuration : " + ((SlideItemInfo)localList.get(i)).mDuration + " isOperateClip : " + ((SlideItemInfo)localList.get(i)).aIN + "\n";
        i += 1;
      }
      QLog.d("SlideShowPhotoListManager", 2, (String)localObject1);
    }
    this.jdField_a_of_type_Rmd.update();
    bvs();
    eY(localList);
    this.jdField_a_of_type_Rmd.bvv();
  }
  
  public void c(rlt paramrlt)
  {
    Object localObject = QQStoryContext.c();
    String str;
    LocalMediaInfo localLocalMediaInfo;
    MediaScanner localMediaScanner;
    if (paramrlt.mResult == 0)
    {
      str = paramrlt.aBm;
      localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = paramrlt.mFile;
      localLocalMediaInfo.mMimeType = "video";
      localLocalMediaInfo.mAudioPath = paramrlt.aBn;
      localLocalMediaInfo.mHasAudioTrack = paramrlt.mHasAudioTrack;
      localLocalMediaInfo.mSampleRate = paramrlt.bth;
      localMediaScanner = MediaScanner.getInstance(BaseApplicationImpl.getContext());
    }
    for (;;)
    {
      try
      {
        localMediaScanner.buildAndUpdateVideo(localLocalMediaInfo);
        localObject = (rmf)((AppInterface)localObject).getBusinessHandler(1);
        ((rmf)localObject).a(str, localLocalMediaInfo);
        if (((rmf)localObject).getMediaFormat() == null) {
          ((rmf)localObject).c(paramrlt.mMediaFormat);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult RESULT_SUCC  hasAudioTrack:" + localLocalMediaInfo.mHasAudioTrack);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult " + paramrlt);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.e("SlideShowPhotoListManager", 1, "pic2video err", localThrowable);
        continue;
      }
      if (paramrlt.mResult == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SlideShowPhotoListManager", 2, "onImage2VideoResult cancel" + paramrlt);
        }
        rar.g("actAlbumResult", new String[] { paramrlt.mResult + "" });
      }
      else if (paramrlt.mResult == 5)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult fail load");
        }
        rar.g("actAlbumResult", new String[] { paramrlt.mResult + "" });
        bd(((AppInterface)localObject).getApp(), acfp.m(2131714624));
      }
      else if (paramrlt.mResult == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowPhotoListManager", 2, "result audio fail");
        }
        rar.g("actAlbumResult", new String[] { paramrlt.mResult + "" });
        bd(((AppInterface)localObject).getApp(), acfp.m(2131714623));
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor.stopAll();
        }
        if (this.jdField_a_of_type_Rmd != null) {
          this.jdField_a_of_type_Rmd.blB();
        }
      }
      else
      {
        rar.g("actAlbumResult", new String[] { paramrlt.mResult + "" });
      }
    }
  }
  
  public List<LocalMediaInfo> ci()
  {
    return this.mMediaList;
  }
  
  public List<SlideItemInfo> cj()
  {
    return this.fl;
  }
  
  public void eW(List<SlideItemInfo> paramList)
  {
    this.fl.clear();
    this.fl.addAll(paramList);
  }
  
  public List<SlideItemInfo> getPhotoList()
  {
    return this.mItemList;
  }
  
  public void l(@NonNull pkd parampkd)
  {
    if (parampkd == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SlideShowPhotoListManager", 2, "setData StoryAlbum AlbumId : " + parampkd.getID() + " mTransId=" + parampkd.mTransId);
      }
      Object localObject = new ArrayList();
      HashMap localHashMap = new HashMap();
      this.mMediaList.clear();
      Iterator localIterator = parampkd.bD().iterator();
      while (localIterator.hasNext())
      {
        pkd.a locala = (pkd.a)localIterator.next();
        LocalMediaInfo localLocalMediaInfo = locala.a();
        localHashMap.put(locala.mPath, localLocalMediaInfo);
        if (locala.Ig())
        {
          ((List)localObject).add(locala.mPath);
          localLocalMediaInfo.selectStatus = 1;
        }
        localLocalMediaInfo.mAlbumName = parampkd.mAlbumName;
        localLocalMediaInfo.mTransId = parampkd.mTransId;
        localLocalMediaInfo.mTextId = parampkd.mTextId;
        localLocalMediaInfo.mTextStr = parampkd.mAlbumName;
        this.mMediaList.add(localLocalMediaInfo);
      }
      a((List)localObject, localHashMap);
      localObject = this.mItemList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SlideItemInfo)((Iterator)localObject).next()).f = parampkd;
      }
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SlideShowPhotoListManager", 2, "onResume");
    }
  }
  
  public void resetUI()
  {
    this.mItemList.clear();
    this.mMediaList.clear();
  }
  
  public void setData(List<SlideItemInfo> paramList)
  {
    this.mItemList.clear();
    this.mItemList.addAll(paramList);
  }
  
  public int tF()
  {
    return this.btn;
  }
  
  public int tG()
  {
    return this.bto;
  }
  
  public void tU(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rmd != null) {
      this.jdField_a_of_type_Rmd.bvx();
    }
  }
  
  public void xJ(int paramInt)
  {
    this.mTotalDuration = paramInt;
  }
  
  public void xK(int paramInt)
  {
    this.btn = paramInt;
  }
  
  public void xL(int paramInt)
  {
    this.bto = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void blB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rma
 * JD-Core Version:    0.7.0.1
 */