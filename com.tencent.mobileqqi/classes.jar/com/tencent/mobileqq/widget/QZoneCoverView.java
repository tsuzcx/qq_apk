package com.tencent.mobileqq.widget;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.util.ImageFilePathUtil;
import hlp;
import hlq;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class QZoneCoverView
  extends ProfilePhotoBoard
{
  public static final int D = 8;
  public static final int E = 10000;
  public static final int F = 300;
  protected static final int G = 2;
  protected static final int H = 3;
  protected static final int I = 4;
  protected static final int J = 5;
  protected static final int K = 6;
  protected static final int L = 7;
  protected static final int M = 8;
  public static final long a = 10000L;
  protected int N;
  protected int O;
  protected int P;
  private int Q;
  public Drawable a;
  public QQAppInterface a;
  protected CoverCacheData a;
  protected LinkedList a;
  protected Random a;
  protected int[] a;
  protected String b;
  protected LinkedList b;
  protected int[] b;
  protected String c;
  protected LinkedList c;
  protected boolean c;
  public String d;
  protected boolean d;
  protected boolean e;
  
  public QZoneCoverView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QZoneCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QZoneCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt2 >= 0)
    {
      localObject1 = localObject2;
      if (paramInt2 < this.jdField_b_of_type_JavaUtilLinkedList.size()) {
        localObject1 = (QZoneCoverView.PhotoInfo)this.jdField_b_of_type_JavaUtilLinkedList.get(paramInt2);
      }
    }
    if (localObject1 == null) {
      return;
    }
    ((QZoneCoverView.PhotoInfo)localObject1).e = paramInt1;
    ((QZoneCoverView.PhotoInfo)localObject1).f = paramInt2;
    if (!this.jdField_c_of_type_JavaUtilLinkedList.contains(localObject1)) {
      this.jdField_c_of_type_JavaUtilLinkedList.add(localObject1);
    }
    f();
  }
  
  private void a(LinkedList paramLinkedList)
  {
    int j = 0;
    int i;
    int k;
    QZoneCoverView.PhotoInfo localPhotoInfo;
    if (this.jdField_b_of_type_JavaUtilLinkedList != null)
    {
      i = this.jdField_b_of_type_JavaUtilLinkedList.size();
      if (j >= 3) {
        return;
      }
      k = this.jdField_a_of_type_ArrayOfInt[j];
      if ((k < 0) || (k >= i)) {
        break label100;
      }
      localPhotoInfo = (QZoneCoverView.PhotoInfo)this.jdField_b_of_type_JavaUtilLinkedList.get(k);
      label55:
      if (localPhotoInfo != null) {
        break label106;
      }
      this.jdField_a_of_type_ArrayOfInt[j] = -1;
    }
    for (;;)
    {
      if ((k != -1) && (this.jdField_a_of_type_ArrayOfInt[j] == -1)) {
        a(j);
      }
      j += 1;
      break;
      i = 0;
      break;
      label100:
      localPhotoInfo = null;
      break label55;
      label106:
      this.jdField_a_of_type_ArrayOfInt[j] = paramLinkedList.indexOf(localPhotoInfo);
      if (this.B == 3)
      {
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfInt[j] > 2)) {
          this.jdField_a_of_type_ArrayOfInt[j] = -1;
        } else if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfInt[j] > 0)) {
          this.jdField_a_of_type_ArrayOfInt[j] = -1;
        }
      }
      else if (this.B == 4) {
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfInt[j] > 7)) {
          this.jdField_a_of_type_ArrayOfInt[j] = -1;
        } else if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfInt[j] > 2)) {
          this.jdField_a_of_type_ArrayOfInt[j] = -1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "showDefaultPhotoWallBg|mDefaultCoverUrl = " + this.jdField_c_of_type_JavaLangString + ", bUseDefault = " + paramBoolean);
    }
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = -1;
      i += 1;
    }
    this.jdField_b_of_type_JavaUtilLinkedList.clear();
    this.jdField_c_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qzonecover.", 2, "MODE_CUSTOM");
      }
      if ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData != null) && ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type.endsWith("PhotoWallCover")) || (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type.endsWith("CustomCover")) || (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type.endsWith("CustomOldCover")))) {
        if (this.B != 2)
        {
          setPhotoBoardStyle(2);
          a(null, 0);
        }
      }
    }
    do
    {
      for (;;)
      {
        if (!Utils.a(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString))
        {
          this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, "change custom mCurLoadingOrShowingUrl = " + this.jdField_d_of_type_JavaLangString);
          }
          new hlq(this).start();
        }
        return;
        if (this.B != 5)
        {
          setPhotoBoardStyle(6);
          a(null, 0);
        }
      }
      if (!paramBoolean) {
        break;
      }
      setPhotoBoardStyle(1);
    } while (Utils.a(this.jdField_d_of_type_JavaLangString, "default_bg"));
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "set default bg");
    }
    try
    {
      localObject1 = getResources().getDrawable(2130839279);
      a((Drawable)localObject1, 0);
      if ((localObject1 != null) && (Utils.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
      {
        paramBoolean = true;
        setDrawCoverBgIconFlag(paramBoolean);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qzonecover.", 2, localOutOfMemoryError.toString());
          localObject1 = localObject2;
          continue;
          paramBoolean = false;
        }
      }
    }
    setPhotoBoardStyle(1);
    a(null, 0);
    setDrawCoverBgIconFlag(false);
  }
  
  private void b(LinkedList paramLinkedList)
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    int i = 0;
    QZoneCoverView.PhotoInfo localPhotoInfo1;
    label42:
    QZoneCoverView.PhotoInfo localPhotoInfo2;
    if (i < 8) {
      if (this.jdField_b_of_type_JavaUtilLinkedList.size() > i)
      {
        localPhotoInfo1 = (QZoneCoverView.PhotoInfo)this.jdField_b_of_type_JavaUtilLinkedList.get(i);
        if (paramLinkedList.size() <= i) {
          break label189;
        }
        localPhotoInfo2 = (QZoneCoverView.PhotoInfo)paramLinkedList.get(i);
        label60:
        if (Utils.a(localPhotoInfo1, localPhotoInfo2)) {
          break label195;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qzonecover.", 2, "showAlbumPhotoWallBg|firstChangedIndex = " + i);
      }
      if (i >= 0)
      {
        a(paramLinkedList);
        this.jdField_b_of_type_JavaUtilLinkedList.clear();
        this.jdField_b_of_type_JavaUtilLinkedList.addAll(paramLinkedList);
        i = this.jdField_b_of_type_JavaUtilLinkedList.size();
        int j = this.B;
        if (i >= 3) {
          setPhotoBoardStyle(4);
        }
        for (;;)
        {
          if (j == this.B) {
            break label210;
          }
          i = 0;
          while (i < 3)
          {
            this.jdField_a_of_type_ArrayOfInt[i] = -1;
            a(i);
            i += 1;
          }
          localPhotoInfo1 = null;
          break label42;
          label189:
          localPhotoInfo2 = null;
          break label60;
          label195:
          i += 1;
          break;
          setPhotoBoardStyle(3);
        }
      }
      label210:
      d();
      return;
      i = -1;
    }
  }
  
  private void g()
  {
    int k = this.jdField_b_of_type_JavaUtilLinkedList.size();
    int j;
    if (this.B == 4)
    {
      i = 0;
      j = -1;
      while ((j < 0) && (i < 3))
      {
        if (this.jdField_a_of_type_ArrayOfInt[i] == -1) {
          j = i;
        }
        i += 1;
      }
      i = j;
      if (j < 0)
      {
        j = this.jdField_a_of_type_JavaUtilRandom.nextInt(3);
        i = j;
        if (j != this.Q) {}
      }
    }
    for (int i = (this.Q + 1) % 3;; i = 0)
    {
      this.Q = i;
      k = Math.min(k, 8);
      j = this.N;
      this.N = -1;
      i = 1;
      while ((this.N < 0) && (i < k))
      {
        j = (j + i) % k;
        if ((this.jdField_a_of_type_ArrayOfInt[0] != j) && (this.jdField_a_of_type_ArrayOfInt[1] != j) && (this.jdField_a_of_type_ArrayOfInt[2] != j)) {
          this.N = j;
        }
        i += 1;
      }
      if ((this.Q >= 0) && (this.N >= 0)) {
        a(this.Q, this.N);
      }
      return;
    }
  }
  
  public CoverCacheData a()
  {
    return this.jdField_a_of_type_CooperationQzoneModelCoverCacheData;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "onPause()");
    }
    this.jdField_c_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 10000L);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "init() uin = " + paramString + ", nFlag = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.O = 0;
    this.jdField_c_of_type_Boolean = NetworkUtil.b(BaseApplication.getContext());
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_b_of_type_ArrayOfInt = new int[3];
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = -1;
      this.jdField_b_of_type_ArrayOfInt[i] = -1;
      i += 1;
    }
    this.jdField_d_of_type_JavaLangString = null;
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    i = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (i <= 240)
    {
      this.P = 60;
      this.B = 1;
      this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
      this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
      this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilRandom = new Random(Long.parseLong(paramQQAppInterface.a()));
      if (paramInt != 0) {
        break label266;
      }
      this.e = true;
      setPhotoBoardStyle(0);
    }
    label266:
    do
    {
      return;
      if (i <= 320)
      {
        this.P = 100;
        break;
      }
      this.P = 160;
      break;
      if (paramInt == 1)
      {
        paramQQAppInterface = (QZoneCover)paramQQAppInterface.a().createEntityManager().a(QZoneCover.class, paramString);
        if (paramQQAppInterface != null) {
          a(paramQQAppInterface.type, paramQQAppInterface.parseCoverInfo(), paramQQAppInterface.parsePhotoInfo(), this.jdField_a_of_type_JavaUtilLinkedList);
        }
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          a(false);
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.clear();
          this.e = false;
          paramQQAppInterface = Message.obtain();
          paramQQAppInterface.what = 2;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramQQAppInterface);
          return;
          b(this.jdField_a_of_type_JavaUtilLinkedList);
        }
      }
      if (paramInt == 2)
      {
        this.e = true;
        a(true);
        return;
      }
    } while (paramInt != 3);
    paramQQAppInterface = (QZoneCover)paramQQAppInterface.a().createEntityManager().a(QZoneCover.class, paramString);
    if (paramQQAppInterface != null) {
      a(paramQQAppInterface.type, paramQQAppInterface.parseCoverInfo(), paramQQAppInterface.parsePhotoInfo(), this.jdField_a_of_type_JavaUtilLinkedList);
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
      a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.e = true;
      return;
      b(this.jdField_a_of_type_JavaUtilLinkedList);
    }
  }
  
  public void a(QZoneCoverView.PhotoInfo paramPhotoInfo)
  {
    if (paramPhotoInfo == null) {}
    label132:
    label302:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramPhotoInfo.e == 0)
      {
        localObject1 = paramPhotoInfo.a();
        localObject2 = ImageFilePathUtil.a(BaseApplication.getContext(), (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label132;
        }
        paramPhotoInfo.d = 2;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qzonecover.", 2, "handleLoadPhoto| download fail, path is null, url = " + (String)localObject1);
        }
      }
      for (;;)
      {
        if ((paramPhotoInfo.d != 1) || ((this.B != 3) && (this.B != 4))) {
          break label302;
        }
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 7;
        ((Message)localObject1).obj = paramPhotoInfo;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        return;
        localObject1 = paramPhotoInfo.a(this.P);
        break;
        localObject2 = new File((String)localObject2);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
        {
          paramPhotoInfo.d = 1;
        }
        else if (paramPhotoInfo.d != 2)
        {
          File localFile = new File(((File)localObject2).getPath() + Long.toString(System.currentTimeMillis()));
          int i = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, localFile);
          if (i == 0)
          {
            if (localFile.renameTo((File)localObject2)) {
              paramPhotoInfo.d = 1;
            } else {
              paramPhotoInfo.d = 2;
            }
          }
          else
          {
            paramPhotoInfo.d = 2;
            if (QLog.isColorLevel()) {
              QLog.i("Q.qzonecover.", 2, "handleLoadPhoto| download fail, result = " + i + ", url = " + (String)localObject1);
            }
          }
        }
      }
    }
  }
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "update()|data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null)
    {
      a(paramCoverCacheData.type, paramCoverCacheData.urls, paramCoverCacheData.photoWall, this.jdField_a_of_type_JavaUtilLinkedList);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        break label140;
      }
      this.q = 6;
      a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      if ((this.jdField_a_of_type_CooperationQzoneModelCoverCacheData != null) && (Utils.a("PhotoWallCover", this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qzonecover.", 2, "need get req cover info");
        }
        paramCoverCacheData = Message.obtain();
        paramCoverCacheData.what = 2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCoverCacheData);
      }
      return;
      label140:
      b(this.jdField_a_of_type_JavaUtilLinkedList);
    }
  }
  
  protected void a(String paramString, Map paramMap, List paramList1, List paramList2)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|MulRelsotionUrl = ").append(paramMap).append("|vecUrls = ").append(paramList1);
      QLog.i("Q.qzonecover.", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_CooperationQzoneModelCoverCacheData == null) {
      this.jdField_a_of_type_CooperationQzoneModelCoverCacheData = new CoverCacheData();
    }
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.type = paramString;
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.urls = ((HashMap)paramMap);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.photoWall = ((ArrayList)paramList1);
    this.jdField_a_of_type_CooperationQzoneModelCoverCacheData.uin = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    paramList2.clear();
    if (Utils.a("default", paramString)) {
      this.jdField_c_of_type_JavaLangString = null;
    }
    do
    {
      do
      {
        return;
        if (Utils.a("PhotoWallCover", paramString))
        {
          int i;
          if (paramList1 != null) {
            i = paramList1.size();
          }
          while (j < i)
          {
            paramString = (Map)paramList1.get(j);
            if (paramString != null)
            {
              paramString = new QZoneCoverView.PhotoInfo(this, j, paramString);
              paramString.f = paramList2.size();
              paramList2.add(paramString);
            }
            j += 1;
            continue;
            i = 0;
          }
          this.jdField_c_of_type_JavaLangString = null;
          return;
        }
      } while (paramMap == null);
      this.jdField_c_of_type_JavaLangString = ((String)paramMap.get("HigeResolutionCover"));
    } while (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
    this.jdField_c_of_type_JavaLangString = ((String)paramMap.get("LowResolutionCover"));
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (!Utils.a(paramString, this.jdField_b_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qzonecover.", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ", isPause = " + this.jdField_a_of_type_Boolean);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.e = true;
    } while ((!paramBoolean) || (parammobile_sub_get_cover_rsp == null));
    this.jdField_d_of_type_Boolean = true;
    a(parammobile_sub_get_cover_rsp.type, parammobile_sub_get_cover_rsp.MulRelsotionUrl, parammobile_sub_get_cover_rsp.vecUrls, this.jdField_a_of_type_JavaUtilLinkedList);
    return;
    if (paramBoolean)
    {
      this.e = true;
      a(parammobile_sub_get_cover_rsp.type, parammobile_sub_get_cover_rsp.MulRelsotionUrl, parammobile_sub_get_cover_rsp.vecUrls, this.jdField_a_of_type_JavaUtilLinkedList);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)
      {
        this.q = 6;
        a(true);
      }
      for (;;)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
        return;
        b(this.jdField_a_of_type_JavaUtilLinkedList);
      }
    }
    if ((NetworkUtil.b(BaseApplication.getContext())) && (this.O < 3))
    {
      paramString = Message.obtain();
      paramString.what = 2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      return;
      if ((this.B == 1) || (this.B == 2) || (this.B == 5))
      {
        this.e = true;
        a(true);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "onResume()");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 30L);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
  }
  
  protected void b(QZoneCoverView.PhotoInfo paramPhotoInfo)
  {
    if ((paramPhotoInfo != null) && (paramPhotoInfo.e == 0)) {}
    for (;;)
    {
      URL localURL;
      try
      {
        Object localObject1 = new URL("qzone_cover", "original", paramPhotoInfo.a());
        if (localObject1 == null) {
          break label167;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839045);
        }
        localObject1 = URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (localObject1 != null)
        {
          a((Drawable)localObject1, paramPhotoInfo.e);
          this.jdField_a_of_type_ArrayOfInt[paramPhotoInfo.e] = paramPhotoInfo.f;
        }
        return;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qzonecover.", 2, localMalformedURLException1.toString());
        }
        localURL = null;
        continue;
      }
      if (paramPhotoInfo != null)
      {
        try
        {
          localURL = new URL("qzone_cover", "thumb", paramPhotoInfo.a(this.P));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, localMalformedURLException2.toString());
          }
        }
      }
      else
      {
        Object localObject2 = null;
        continue;
        label167:
        localObject2 = null;
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "onDestroy");
    }
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = -1;
      a(i);
      i += 1;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  protected void d()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("refreshPhotos").append("|mMode = ").append(this.B).append(", [").append(this.jdField_a_of_type_ArrayOfInt[0]).append(",").append(this.jdField_a_of_type_ArrayOfInt[1]).append(",").append(this.jdField_a_of_type_ArrayOfInt[2]).append("]");
      QLog.i("Q.qzonecover.", 2, localStringBuilder.toString());
    }
    if (this.B == 3) {
      if (this.jdField_a_of_type_ArrayOfInt[0] == -1) {
        a(0, 0);
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_JavaUtilLinkedList.size() == 0)) {
        e();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder(100);
        localStringBuilder.append("refreshPhotos").append("|deal: [").append(this.jdField_b_of_type_ArrayOfInt[0]).append(",").append(this.jdField_b_of_type_ArrayOfInt[1]).append(",").append(this.jdField_b_of_type_ArrayOfInt[2]).append("]");
        QLog.i("Q.qzonecover.", 2, localStringBuilder.toString());
      }
      return;
      if (this.B == 4)
      {
        int i = 0;
        while (i < 3)
        {
          this.jdField_b_of_type_ArrayOfInt[i] = this.jdField_a_of_type_ArrayOfInt[i];
          i += 1;
        }
        int j = 0;
        while (j < 3)
        {
          if (this.jdField_b_of_type_ArrayOfInt[j] == -1)
          {
            i = 0;
            int m;
            for (int k = -1; (k < 0) && (i < 3); k = m)
            {
              m = k;
              if (i != this.jdField_b_of_type_ArrayOfInt[0])
              {
                m = k;
                if (i != this.jdField_b_of_type_ArrayOfInt[1])
                {
                  m = k;
                  if (i != this.jdField_b_of_type_ArrayOfInt[2]) {
                    m = i;
                  }
                }
              }
              i += 1;
            }
            this.jdField_b_of_type_ArrayOfInt[j] = k;
            a(j, k);
          }
          j += 1;
        }
      }
    }
  }
  
  protected void e()
  {
    try
    {
      if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(3)) && (((this.B == 3) && (this.jdField_b_of_type_JavaUtilLinkedList.size() > 1)) || ((this.B == 4) && (this.jdField_b_of_type_JavaUtilLinkedList.size() > 3)))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 10000L);
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          boolean bool = this.jdField_a_of_type_AndroidOsHandler.hasMessages(6);
          if (!bool) {}
        }
        else
        {
          return;
        }
        if (this.jdField_c_of_type_JavaUtilLinkedList.size() > 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        } else {
          e();
        }
      }
      finally {}
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    boolean bool1 = false;
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        boolean bool2 = bool1;
        if (!bool1) {
          bool2 = super.handleMessage(paramMessage);
        }
        return bool2;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qzonecover.", 2, "handleMessage() MSG_REQ_ALBUM");
        }
        localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        if (localObject != null)
        {
          ((CardHandler)localObject).a(this.jdField_b_of_type_JavaLangString, 1);
          this.O += 1;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        bool1 = true;
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        if (this.jdField_c_of_type_Boolean) {
          g();
        }
        bool1 = true;
        continue;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder(100);
          ((StringBuilder)localObject).append("MSG_RESUME").append(", mPhotoListHasChanged = ").append(this.jdField_d_of_type_Boolean).append(", mTempList.size = ").append(this.jdField_a_of_type_JavaUtilLinkedList.size()).append(", mMode = ").append(this.B);
          QLog.i("Q.qzonecover.", 2, ((StringBuilder)localObject).toString());
        }
        if (this.jdField_d_of_type_Boolean) {
          if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0)
          {
            a(true);
            this.jdField_a_of_type_JavaUtilLinkedList.clear();
            this.jdField_d_of_type_Boolean = false;
          }
        }
        for (;;)
        {
          bool1 = true;
          break;
          b(this.jdField_a_of_type_JavaUtilLinkedList);
          break label256;
          if ((this.B == 3) || (this.B == 4)) {
            d();
          } else if (this.B == 1) {
            a(this.e);
          } else if ((this.B == 2) || (this.B == 5)) {
            a(true);
          } else if (this.B == 0) {
            setPhotoBoardStyle(0);
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
        this.jdField_d_of_type_JavaLangString = null;
        while (i < 3)
        {
          this.jdField_a_of_type_ArrayOfInt[i] = -1;
          a(i);
          i += 1;
        }
        bool1 = true;
      }
    case 6: 
      label256:
      if (this.jdField_c_of_type_JavaUtilLinkedList.size() <= 0) {
        break;
      }
    }
    for (Object localObject = (QZoneCoverView.PhotoInfo)this.jdField_c_of_type_JavaUtilLinkedList.remove(0);; localObject = null)
    {
      if (localObject != null) {
        new hlp(this, (QZoneCoverView.PhotoInfo)localObject).start();
      }
      for (;;)
      {
        bool1 = true;
        break;
        f();
      }
      if ((paramMessage.obj instanceof QZoneCoverView.PhotoInfo)) {
        b((QZoneCoverView.PhotoInfo)paramMessage.obj);
      }
      for (;;)
      {
        bool1 = true;
        break;
        if ((paramMessage.obj instanceof Drawable)) {
          a((Drawable)paramMessage.obj, paramMessage.arg1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QZoneCoverView
 * JD-Core Version:    0.7.0.1
 */