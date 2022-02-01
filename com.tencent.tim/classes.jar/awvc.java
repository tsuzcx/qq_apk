import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.1;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.4;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.5;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.6;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.7;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.8;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.9;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class awvc<K extends awur>
  extends awva<K>
  implements awva.a, awva.b, awva.c
{
  protected float DC;
  protected float DD;
  protected final boolean baw = axiz.aOK();
  private String cTl;
  protected String cTm;
  protected String cTn = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
  private boolean dsI = true;
  private boolean dsJ = true;
  protected boolean dsK;
  private ArrayList<LocalMediaInfo> mAllImages = new ArrayList();
  protected Map<String, awun> qx = new HashMap();
  
  protected awvc(K paramK)
  {
    super(paramK);
    this.jdField_a_of_type_Awva$c = this;
    this.jdField_a_of_type_Awva$a = this;
    this.jdField_a_of_type_Awva$b = this;
  }
  
  private ArrayList<String> X()
  {
    return this.mPhotoCommonData.selectedPhotoList;
  }
  
  private void XI(boolean paramBoolean)
  {
    if ((this.bu == null) || (this.bu.get() == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(4);
      ((awur)this.bu.get()).HR.setImageDrawable(h());
      ((awur)this.bu.get()).mq.setVisibility(0);
    } while (!aNN());
    ((awur)this.bu.get()).c.setVisibility(8);
    return;
    ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setVisibility(0);
    ((awur)this.bu.get()).mq.setVisibility(8);
  }
  
  private void a(int paramInt, awur.c paramc)
  {
    boolean bool1 = true;
    axiy.d("AEPhotoListLogicBase", "handlePhotoItemClick, position = " + paramInt);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.mAllImages.get(paramInt);
    if ((!paramc.mCheckBox.isChecked()) && (paramc.mMaskView.getVisibility() == 8))
    {
      axiy.d("AEPhotoListLogicBase", "没有选中，没有focus，点击后变选中且focus, position = " + paramInt);
      if ((X() != null) && (X().size() >= this.mPhotoCommonData.maxSelectNum))
      {
        axiy.d("AEPhotoListLogicBase", "handlePhotoItemClick, exceededPhotoLimit");
        a(localLocalMediaInfo, paramc);
      }
    }
    label206:
    do
    {
      return;
      a(paramc);
      a(localLocalMediaInfo, paramc);
      adm(paramInt);
      bool1 = aNI();
      if (!bool1) {
        ((awur)this.bu.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 1);
      }
      if (bool1)
      {
        paramInt = 0;
        adn(paramInt);
        paramc = localLocalMediaInfo.path;
        if (bool1) {
          break label206;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        s(paramc, bool1, false);
        return;
        paramInt = 600;
        break;
      }
      if ((paramc.mCheckBox.isChecked()) && (paramc.mMaskView.getVisibility() == 8))
      {
        axiy.d("AEPhotoListLogicBase", "选中，没有focus，点击后变选中且focus, position = " + paramInt);
        a(paramc);
        boolean bool2 = aNI();
        adm(paramInt);
        if (!bool2) {
          ((awur)this.bu.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 1);
        }
        paramc = localLocalMediaInfo.path;
        if (!bool2) {}
        for (;;)
        {
          s(paramc, bool1, false);
          return;
          bool1 = false;
        }
      }
      if ((paramc.mCheckBox.isChecked()) && (paramc.mMaskView.getVisibility() == 0))
      {
        if (X().size() > 1)
        {
          axiy.d("AEPhotoListLogicBase", "选中，有focus，选中的图大于一张，点击后变未选中且无focus, position = " + paramInt);
          b(paramc);
          b(localLocalMediaInfo, paramc);
          eGy();
          return;
        }
        axiy.d("AEPhotoListLogicBase", "选中，有focus，选中的图只有这一张，点击后变未选但有focus, position = " + paramInt);
        b(localLocalMediaInfo, paramc);
        ((awur)this.bu.get()).jdField_a_of_type_Awur$a.notifyDataSetChanged();
        return;
      }
    } while ((paramc.mCheckBox.isChecked()) || (paramc.mMaskView.getVisibility() != 0));
    axiy.d("AEPhotoListLogicBase", "没有选中，有focus，点击后变选中且focus, position = " + paramInt);
    a(localLocalMediaInfo, paramc);
    adn(0);
  }
  
  private void a(awur.c paramc)
  {
    paramc.mMaskView.setVisibility(0);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, awur.c paramc)
  {
    axiy.d("AEPhotoListLogicBase", "[setSelected], photoPath=" + paramLocalMediaInfo.path);
    paramc.a.onClick(paramc.mSelectedBtn);
  }
  
  private boolean aNI()
  {
    return ((awur)this.bu.get()).b.aNI();
  }
  
  private boolean aNL()
  {
    return !X().isEmpty();
  }
  
  private boolean aNM()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mPhotoCommonData != null)
    {
      bool1 = bool2;
      if (this.mPhotoCommonData.selectedPhotoList != null)
      {
        bool1 = bool2;
        if (this.mPhotoCommonData.selectedPhotoList.size() > 1) {
          bool1 = axis.a().c("sp_key_ae_ratio_toasted", true, 0);
        }
      }
    }
    return bool1;
  }
  
  private boolean aNN()
  {
    if (X() == null) {}
    String str;
    do
    {
      do
      {
        return true;
      } while (TextUtils.isEmpty(this.cTm));
      str = this.cTm;
      localObject = new LinkedList(this.mAllImages);
    } while (CollectionUtils.isEmpty((Collection)localObject));
    Object localObject = ((List)localObject).iterator();
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
    } while ((localLocalMediaInfo == null) || (TextUtils.isEmpty(localLocalMediaInfo.path)) || (!localLocalMediaInfo.path.equals(str)) || (localLocalMediaInfo.mediaWidth != localLocalMediaInfo.mediaHeight));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void adm(int paramInt)
  {
    if (!this.cTl.equals(((LocalMediaInfo)this.mAllImages.get(paramInt)).path))
    {
      axiy.d("AEPhotoListLogicBase", "!currentFocusedImagePath.equals(mAllImages.get(position).path), position = " + paramInt);
      int i = d(this.mAllImages, this.cTl);
      this.cTl = ((LocalMediaInfo)this.mAllImages.get(paramInt)).path;
      if (i >= 0) {
        ((awur)this.bu.get()).jdField_a_of_type_Awur$a.notifyItemChanged(i);
      }
    }
  }
  
  private void adn(int paramInt)
  {
    if (X().size() == 1)
    {
      if (paramInt > 0) {
        ((awur)this.bu.get()).E.postDelayed(new AEPhotoListLogicBase.7(this), paramInt);
      }
    }
    else {
      return;
    }
    ((awur)this.bu.get()).jdField_a_of_type_Awur$a.notifyDataSetChanged();
  }
  
  private void ado(int paramInt)
  {
    if (paramInt == 1) {
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131689941), 1).show();
    }
    while (paramInt != 2) {
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131689942), 1).show();
  }
  
  private void b(awur.c paramc)
  {
    paramc.mMaskView.setVisibility(8);
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, awur.c paramc)
  {
    paramc.a.onClick(paramc.mSelectedBtn);
    axiy.d("AEPhotoListLogicBase", "cancelSelected image.path = " + paramLocalMediaInfo.path);
    acd(paramLocalMediaInfo.path);
  }
  
  private int d(ArrayList<LocalMediaInfo> paramArrayList, String paramString)
  {
    int j;
    if ((paramArrayList == null) || (paramString == null))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label52;
      }
      j = i;
      if (((LocalMediaInfo)paramArrayList.get(i)).path.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label52:
    return -1;
  }
  
  private boolean d(ArrayList<String> paramArrayList, String paramString)
  {
    return paramArrayList.contains(paramString);
  }
  
  private void dQ(String paramString, boolean paramBoolean)
  {
    eGz();
    this.cTm = paramString;
    ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageBitmap(BitmapUtils.decodeSampledBitmapFromFileCheckExif(paramString, 1440, 1440));
    this.DC = ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.bh();
    this.DD = ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.bY();
    adp(((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.QF());
    awun localawun = a(paramString);
    if ((localawun != null) && (localawun.matrix != null) && (d(this.mPhotoCommonData.selectedPhotoList, paramString))) {
      ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setImageMatrix(localawun.matrix);
    }
    for (;;)
    {
      if (paramBoolean) {
        ((awur)this.bu.get()).b.eGs();
      }
      if (!aNN()) {
        break;
      }
      ((awur)this.bu.get()).c.setVisibility(8);
      return;
      acd(paramString);
    }
    ((awur)this.bu.get()).c.setVisibility(0);
  }
  
  private void eGy()
  {
    String str;
    int i;
    if (!X().isEmpty())
    {
      axiy.d("AEPhotoListLogicBase", "mPhotoCommonData.selectedPhotoList.size() = " + X().size());
      str = (String)X().get(X().size() - 1);
      i = 0;
      if (i >= this.mAllImages.size()) {
        break label161;
      }
      if (!((LocalMediaInfo)this.mAllImages.get(i)).path.equals(str)) {
        break label154;
      }
    }
    for (;;)
    {
      axiy.d("AEPhotoListLogicBase", "!mPhotoCommonData.selectedPhotoList.isEmpty(), lastImagePosition = " + i);
      if (i >= 0)
      {
        this.cTl = str;
        s(str, false, false);
        ((awur)this.bu.get()).jdField_a_of_type_Awur$a.notifyItemChanged(i);
      }
      return;
      label154:
      i += 1;
      break;
      label161:
      i = -1;
    }
  }
  
  private URLDrawable h()
  {
    return aoop.getDrawable("https://downv6.qq.com/shadow_qqcamera/Android/image/ae_camera_circle_no_photo_tip_light.png");
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.getItem(paramInt);
    Intent localIntent = ((awur)this.bu.get()).getActivity().getIntent();
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
    if (QAlbumUtil.getMediaType(paramView) == 0) {
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
    }
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((awur)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition();
    if (this.mPhotoCommonData.needMediaInfo)
    {
      if (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(paramView.path)) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramView.path, paramView);
      }
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
    }
    localIntent.setClass(((awur)this.bu.get()).getActivity(), ((awur)this.bu.get()).getJumpActivity());
    localIntent.addFlags(603979776);
    return localIntent;
  }
  
  @Nullable
  protected awun a(@NonNull String paramString)
  {
    axiy.d("AEPhotoListLogicBase", "[queryPhotoCropInfo]");
    if ((this.qx == null) || (this.qx.size() == 0)) {
      return null;
    }
    return (awun)this.qx.get(paramString);
  }
  
  protected EditorPicInfo a(@NonNull String paramString)
  {
    axiy.d("AEPhotoListLogicBase", "[prepareEditorPicInfo]");
    Object localObject = a(paramString);
    if ((localObject == null) || (((awun)localObject).a == null))
    {
      localObject = new EditorPicInfo();
      Size localSize = BitmapUtil.getImageSize(paramString);
      ((EditorPicInfo)localObject).picPath = paramString;
      ((EditorPicInfo)localObject).originPicWidth = localSize.getWidth();
      ((EditorPicInfo)localObject).originPicHeight = localSize.getHeight();
      return localObject;
    }
    return ((awun)localObject).a;
  }
  
  public void a(int paramInt, awur.c paramc, awur.b paramb)
  {
    if (this.mPhotoCommonData.maxSelectNum > 100) {
      paramc.mCheckBox.setTextSize(10.0F);
    }
    paramc.a = paramb;
    Object localObject1;
    label300:
    int i;
    if (this.dsI)
    {
      this.dsI = false;
      this.cTl = ((LocalMediaInfo)this.mAllImages.get(paramInt)).path;
      paramc.mMaskView.setVisibility(0);
      if ((!this.mPhotoListData.isSingleMode) && (paramc.mSelectedBtn != null)) {
        paramc.mSelectedBtn.setVisibility(0);
      }
      paramc.a.setPosition(paramInt);
      paramc.a.setCheckBox(paramc.mCheckBox);
      paramc.itemView.setOnClickListener(new awvd(this, paramInt, paramc));
      localObject1 = paramc.mImageView;
      ((ImageView)localObject1).setAdjustViewBounds(false);
      paramb = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.getItem(paramInt);
      Object localObject2 = QAlbumUtil.createContentDescription(0, paramb, paramInt);
      paramc.itemView.setContentDescription((CharSequence)localObject2);
      if (paramb != null)
      {
        paramc.mImageViewPanoramaIcon.setVisibility(4);
        if ((!this.mPhotoListData.showGifTypeIcon) || (!((awur)this.bu.get()).isGif(paramb))) {
          break label696;
        }
        if (paramc.mImageType == null)
        {
          paramc.mImageType = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.newImageTypeView();
          paramc.mImageType.setText("GIF");
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout)paramc.itemView).addView(paramc.mImageType, (ViewGroup.LayoutParams)localObject2);
        }
        paramc.mImageType.setVisibility(0);
        i = AlbumThumbDownloader.THUMB_WIDHT;
        paramb.thumbHeight = i;
        paramb.thumbWidth = i;
        localObject2 = paramc.mDrawable;
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(paramb.path);
        if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(localStringBuilder.toString())))
        {
          localObject2 = QAlbumUtil.generateAlbumThumbURL(paramb);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "photoGridAdapter,getView(),image url :" + ((URL)localObject2).toString());
          }
          localObject2 = aoop.getDrawable((URL)localObject2, ((awur)this.bu.get()).jdField_a_of_type_Awur$a.colorDrawable, ((awur)this.bu.get()).jdField_a_of_type_Awur$a.mDefaultPhotoDrawable);
          ((URLDrawable)localObject2).setTag(paramb);
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((URLImageView)localObject1).setURLDrawableDownListener(((awur)this.bu.get()).jdField_a_of_type_Awur$a);
          paramc.mDrawable = ((URLDrawable)localObject2);
        }
        i = paramb.selectStatus;
        if (i != 1) {
          break label715;
        }
        paramc.mCheckBox.setCheckedNumber(this.mPhotoCommonData.selectedPhotoList.indexOf(paramb.path) + 1);
        if (paramc.itemView.getBackground() != null) {
          paramc.itemView.setBackgroundDrawable(null);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        localObject1 = QAlbumUtil.createContentDescriptionWithCheckBox(0, paramb, paramInt, paramc.mCheckBox.isChecked());
        paramc.mCheckBox.setContentDescription((CharSequence)localObject1);
      }
      paramb.visableTime = SystemClock.uptimeMillis();
      paramb.listViewPosition = paramInt;
      a(paramc, paramb);
      if ((this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) || (i == 1) || (this.mPhotoListData.isSingleMode)) {
        break label761;
      }
      paramc.mImageView.setAlpha(0.3F);
      return;
      paramb = paramc.mMaskView;
      if (this.cTl.equals(((LocalMediaInfo)this.mAllImages.get(paramInt)).path)) {}
      for (i = 0;; i = 8)
      {
        paramb.setVisibility(i);
        break;
      }
      label696:
      if (paramc.mImageType == null) {
        break label300;
      }
      paramc.mImageType.setVisibility(8);
      break label300;
      label715:
      if (i == 3)
      {
        paramc.mCheckBox.setChecked(false);
      }
      else
      {
        paramc.mCheckBox.setChecked(false);
        if (paramc.itemView.getBackground() != null) {
          paramc.itemView.setBackgroundDrawable(null);
        }
      }
    }
    label761:
    paramc.mImageView.setAlpha(1.0F);
  }
  
  protected void a(awur.c paramc, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected void a(@NonNull String paramString, @NonNull awun paramawun)
  {
    axiy.d("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], inner");
    this.qx.put(paramString, paramawun);
  }
  
  protected void a(@NonNull String paramString, @NonNull EditorPicInfo paramEditorPicInfo, Matrix paramMatrix)
  {
    axiy.d("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo]");
    if (this.qx == null)
    {
      axiy.d("AEPhotoListLogicBase", "[addOrUpdatePhotoCropInfo], cropInfoMap=null");
      return;
    }
    awun localawun = a(paramString);
    if (localawun != null) {}
    for (;;)
    {
      localawun.a = paramEditorPicInfo;
      localawun.matrix = paramMatrix;
      a(paramString, localawun);
      return;
      localawun = new awun();
    }
  }
  
  public void aF(View paramView, int paramInt) {}
  
  public void aG(View paramView, int paramInt)
  {
    paramView = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.getItem(paramInt);
    if (paramView == null) {}
    do
    {
      return;
      ((awur)this.bu.get()).getActivity().getIntent();
      localObject1 = QAlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(paramView.path))
      {
        localObject2 = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        ((HashMap)localObject1).put(paramView.path, localObject2);
      }
      ((awur)this.bu.get()).recordLastPos(paramView.path);
    } while (this.mPhotoListData.isSingleMode);
    paramView = ((awur)this.bu.get()).getActivity().getIntent();
    paramView.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    paramView.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    Object localObject1 = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.getItem(paramInt);
    paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
    paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
    PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((awur)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition();
    Object localObject2 = this.mPhotoCommonData.selectedMediaInfoHashMap;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
    }
    paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
    paramView.setClass(((awur)this.bu.get()).getActivity(), ((awur)this.bu.get()).getJumpActivity());
    paramView.addFlags(603979776);
    ((awur)this.bu.get()).startActivity(paramView);
    ((awur)this.bu.get()).getActivity().finish();
    QAlbumUtil.anim(((awur)this.bu.get()).getActivity(), true, true);
  }
  
  public void aH(View paramView, int paramInt) {}
  
  protected void acd(@NonNull String paramString)
  {
    axiy.d("AEPhotoListLogicBase", "[removePhotoCropInfo]");
    if ((this.qx != null) && (this.qx.size() > 0)) {
      this.qx.remove(paramString);
    }
  }
  
  protected void adp(int paramInt)
  {
    if (paramInt == 1)
    {
      ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setGestureEnabled(true);
      ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMinZoom(this.DD);
    }
    while (paramInt != 2) {
      return;
    }
    ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setGestureEnabled(false);
    ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMinZoom(this.DC);
  }
  
  public void b(int paramInt, awur.c paramc, awur.b paramb)
  {
    if (this.mPhotoCommonData.maxSelectNum > 100) {
      paramc.mCheckBox.setTextSize(10.0F);
    }
    paramc.itemView.setOnClickListener(new awve(this, paramc, paramInt));
    LocalMediaInfo localLocalMediaInfo;
    label195:
    int i;
    if (aNL())
    {
      paramc.mMaskView.setVisibility(0);
      paramc.a = paramb;
      if (paramc.mSelectedBtn != null) {
        paramc.mSelectedBtn.setOnClickListener(paramc.a);
      }
      if ((!this.mPhotoListData.isSingleMode) && (this.mPhotoListData.isSupportVideoCheckbox) && (paramc.mSelectedBtn != null)) {
        paramc.mSelectedBtn.setVisibility(0);
      }
      paramc.a.setPosition(paramInt);
      paramc.a.setCheckBox(paramc.mCheckBox);
      ImageView localImageView = paramc.mImageView;
      localImageView.setAdjustViewBounds(false);
      localLocalMediaInfo = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.getItem(paramInt);
      paramb = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
      paramc.itemView.setContentDescription(paramb);
      if (!localLocalMediaInfo.isSystemMeidaStore) {
        break label537;
      }
      paramb = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
      i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      URLDrawable localURLDrawable = paramc.mDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(paramb)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + paramb.toString());
        }
        paramb = aoop.getDrawable(paramb, ((awur)this.bu.get()).jdField_a_of_type_Awur$a.colorDrawable, ((awur)this.bu.get()).jdField_a_of_type_Awur$a.mDefaultPhotoDrawable);
        paramb.setTag(localLocalMediaInfo);
        localImageView.setImageDrawable(paramb);
        ((URLImageView)localImageView).setURLDrawableDownListener(((awur)this.bu.get()).jdField_a_of_type_Awur$a);
        paramc.mDrawable = paramb;
        if (localURLDrawable != null) {
          localURLDrawable.cancelDownload();
        }
      }
      paramb = paramc.mTextView;
      if ((localLocalMediaInfo.isSystemMeidaStore) || (localLocalMediaInfo.mDuration > 0L)) {
        break label549;
      }
      paramb.setVisibility(8);
      paramb = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      if (paramb != null) {
        paramb.queryMediaInfoDuration(this, localLocalMediaInfo, paramInt);
      }
      label406:
      i = localLocalMediaInfo.selectStatus;
      if (i != 1) {
        break label569;
      }
      paramc.mCheckBox.setCheckedNumber(this.mPhotoCommonData.selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1);
      if (paramc.itemView.getBackground() != null) {
        paramc.itemView.setBackgroundDrawable((Drawable)null);
      }
    }
    for (;;)
    {
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      if ((this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) || (i == 1) || (this.mPhotoListData.isSingleMode)) {
        break label618;
      }
      paramc.mImageView.setAlpha(0.3F);
      return;
      paramc.mMaskView.setVisibility(8);
      break;
      label537:
      paramb = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
      break label195;
      label549:
      paramb.setVisibility(0);
      paramb.setText(AbstractPhotoListActivity.formatTimeToString(localLocalMediaInfo.mDuration));
      break label406;
      label569:
      if (i == 3)
      {
        paramc.mCheckBox.setChecked(false);
      }
      else
      {
        paramc.mCheckBox.setChecked(false);
        if (paramc.itemView.getBackground() != null) {
          paramc.itemView.setBackgroundDrawable((Drawable)null);
        }
      }
    }
    label618:
    paramc.mImageView.setAlpha(1.0F);
  }
  
  public void bq(float paramFloat)
  {
    ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setAlpha(paramFloat);
  }
  
  public void bu(ArrayList<LocalMediaInfo> paramArrayList)
  {
    this.mAllImages = paramArrayList;
    if (!TextUtils.isEmpty(this.cTm))
    {
      XI(false);
      return;
    }
    LinkedList localLinkedList = new LinkedList(paramArrayList);
    if (CollectionUtils.isEmpty(localLinkedList))
    {
      XI(false);
      return;
    }
    int i = 0;
    if (i < localLinkedList.size())
    {
      paramArrayList = (LocalMediaInfo)localLinkedList.get(i);
      if (paramArrayList == null) {}
      while (aqfy.getMediaType(paramArrayList) != 0)
      {
        i += 1;
        break;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      if ((paramArrayList != null) && (this.dsJ) && (i >= 0))
      {
        this.dsJ = false;
        if ((this.bu != null) && (this.bu.get() != null))
        {
          s(paramArrayList.path, true, true);
          ((awur)this.bu.get()).E.post(new AEPhotoListLogicBase.1(this, i));
        }
      }
      XI(bool);
      return;
      i = -1;
      paramArrayList = null;
    }
  }
  
  public void c(int paramInt, awur.c paramc, awur.b paramb) {}
  
  public View cG()
  {
    View localView = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.mInflater.inflate(2131558550, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((awur)this.bu.get()).mImageWidth, ((awur)this.bu.get()).mImageHeight));
    return localView;
  }
  
  public View cH()
  {
    View localView = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.mInflater.inflate(2131558551, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(((awur)this.bu.get()).mImageWidth, ((awur)this.bu.get()).mImageHeight));
    return localView;
  }
  
  public View cI()
  {
    ImageView localImageView = new ImageView(((awur)this.bu.get()).getActivity());
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(((awur)this.bu.get()).mImageWidth, ((awur)this.bu.get()).mImageHeight));
    localImageView.setBackgroundColor(-16777216);
    localImageView.setImageResource(2130842319);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    return localImageView;
  }
  
  public void cw(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean))
    {
      this.dsK = false;
      ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setVisibility(8);
      if (aNN()) {
        ((awur)this.bu.get()).c.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    ((awur)this.bu.get()).c.setVisibility(0);
  }
  
  public void doOnDestroy()
  {
    if (!this.mPhotoListData.backPressed) {
      AlbumThumbManager.getInstance(((awur)this.bu.get()).getActivity()).clear();
    }
    if (((awur)this.bu.get()).jdField_a_of_type_Awur$a != null)
    {
      int i = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.getItemCount();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.mPhotoCommonData.albumId, Integer.valueOf(i));
    }
    if (((awur)this.bu.get()).queryPhotoTask != null) {
      ((awur)this.bu.get()).queryPhotoTask.cancel(true);
    }
    if (this.qx != null) {
      this.qx.clear();
    }
    this.cTm = null;
    close();
  }
  
  public void doOnResume()
  {
    if (this.mPhotoListData.needQueryTask)
    {
      ((awur)this.bu.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.9(this));
      return;
    }
    this.mPhotoListData.needQueryTask = true;
  }
  
  public void eGv()
  {
    if (((awur)this.bu.get()).b.aNJ()) {
      ((awur)this.bu.get()).b.eGs();
    }
  }
  
  protected void eGz()
  {
    if (!TextUtils.isEmpty(this.cTm))
    {
      if (!d(this.mPhotoCommonData.selectedPhotoList, this.cTm)) {
        break label91;
      }
      EditorPicInfo localEditorPicInfo = a(this.cTm);
      localEditorPicInfo = ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a(localEditorPicInfo);
      Matrix localMatrix = ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.getImageMatrix();
      if ((localEditorPicInfo != null) && (localMatrix != null)) {
        a(this.cTm, localEditorPicInfo, localMatrix);
      }
    }
    return;
    label91:
    acd(this.cTm);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    Object localObject = this.mPhotoCommonData.selectedPhotoList;
    HashMap localHashMap1 = this.mPhotoCommonData.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    if (this.mPhotoCommonData.needMediaInfo)
    {
      HashMap localHashMap2 = new HashMap(localHashMap1);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = null;
        if (this.mPhotoCommonData.allMediaInfoHashMap != null) {
          localObject = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
        }
        if (localObject != null)
        {
          localHashMap2.put(str, localObject);
        }
        else
        {
          localObject = (LocalMediaInfo)localHashMap1.get(str);
          if (localObject != null) {
            localHashMap2.put(str, localObject);
          }
        }
      }
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap2);
    }
  }
  
  void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    }
    for (;;)
    {
      if (this.mPhotoCommonData.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      PhotoListBaseData.sPhotoListFirstPos = ((GridLayoutManager)((awur)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition();
      paramIntent.setClass(((awur)this.bu.get()).getActivity(), ((awur)this.bu.get()).getJumpActivity());
      paramIntent.addFlags(603979776);
      startPhotoPreviewActivity(paramIntent);
      QAlbumUtil.anim(((awur)this.bu.get()).getActivity(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.mPhotoListData.currentPhotoPath);
    }
  }
  
  String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    return ((awur)this.bu.get()).getResources().getString(2131696894, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> getLocalMediaInfos()
  {
    int i = -1;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    List localList2 = QAlbumUtil.getAlbumMedias(((awur)this.bu.get()).getActivity(), this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.mPhotoListData.filter, this.mPhotoListData.filterVideoDurationLimit);
    aqip.endPile("PEAK", "getAlbumMedias");
    List localList1 = localList2;
    if (localList2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      localList1 = null;
    }
    return localList1;
  }
  
  public void handleVideoEncodeSucceed(Message paramMessage) {}
  
  public void initData(Intent paramIntent)
  {
    this.mPhotoListData.isRecodeLastAlbumPath = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.mPhotoListData.isRecodeLastAlbumPath) && (l1 - l2 < 60000L))
      {
        this.mPhotoCommonData.albumName = QAlbumUtil.sLastAlbumName;
        this.mPhotoCommonData.albumId = QAlbumUtil.sLastAlbumId;
      }
      if (this.mPhotoCommonData.albumId == null)
      {
        this.mPhotoCommonData.albumId = "$RecentAlbumId";
        this.mPhotoCommonData.albumName = null;
      }
      this.mPhotoListData.isSupportVideoCheckbox = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.mPhotoListData.showGifTypeIcon = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.mPhotoCommonData.selectedPhotoList = ((ArrayList)localObject);
      }
      if (this.mPhotoCommonData.selectedPhotoList == null) {
        this.mPhotoCommonData.selectedPhotoList = new ArrayList();
      }
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      }
      localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.mPhotoCommonData.selectedPhotoList.size() == ((HashMap)localObject).size()))
      {
        this.mPhotoCommonData.selectedMediaInfoHashMap.clear();
        this.mPhotoCommonData.selectedMediaInfoHashMap.putAll((Map)localObject);
      }
      this.mPhotoCommonData.selectedIndex = new ArrayList();
      this.mPhotoCommonData.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.mPhotoListData.maxVideoNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.mPhotoListData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      if (this.mPhotoCommonData.maxSelectNum > 1) {
        this.mPhotoListData.isSingleMode = false;
      }
      this.mPhotoListData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.mPhotoListData.filter = MediaFileFilter.getFilter(this.mPhotoListData.showMediaType);
      this.mPhotoListData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.mPhotoListData.filterVideoGif)
      {
        this.mPhotoListData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
        this.mPhotoListData.showMediaType = 1;
      }
      this.mPhotoListData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      this.mPhotoListData.isShowCamera = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if (this.mPhotoListData.isShowCamera) {
        this.mPhotoListData.showCameraInVideo = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
      }
      this.mPhotoListData.photoListStartPos = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
      paramIntent.removeExtra("PHOTOLIST_START_POSITION");
      if (!this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.needMediaInfo = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
      }
      this.mPhotoListData.filterVideoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      if (this.mPhotoListData.showMediaType != 2) {
        break label608;
      }
    }
    label608:
    for (paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;; paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      this.cTn = paramIntent;
      return;
      this.mPhotoCommonData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.mPhotoCommonData.albumId = paramIntent.getStringExtra("ALBUM_ID");
      break;
    }
  }
  
  public void jk(View paramView)
  {
    int i = ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.QF();
    if (aNM())
    {
      axis.a().n("sp_key_ae_ratio_toasted", false, 0);
      ado(i);
    }
    label81:
    String str;
    EditorPicInfo localEditorPicInfo;
    double d;
    if (i == 1)
    {
      adp(2);
      if ((this.mPhotoCommonData == null) || (this.mPhotoCommonData.selectedPhotoList == null)) {
        break label482;
      }
      paramView = this.mPhotoCommonData.selectedPhotoList.iterator();
      if (!paramView.hasNext()) {
        break label482;
      }
      str = (String)paramView.next();
      Size localSize = BitmapUtil.getImageSize(str);
      localEditorPicInfo = new EditorPicInfo();
      localEditorPicInfo.picPath = str;
      localEditorPicInfo.originPicWidth = localSize.getWidth();
      localEditorPicInfo.originPicHeight = localSize.getHeight();
      d = localEditorPicInfo.originPicWidth * 1.0D / localEditorPicInfo.originPicHeight;
      if (i != 1) {
        break label372;
      }
      if (d > 0.333333343267441D) {
        break label268;
      }
      d = 1.0D * (localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth / 0.333333343267441D) / 2.0D / localEditorPicInfo.originPicHeight;
      localEditorPicInfo.x = 0.0D;
      localEditorPicInfo.y = d;
      localEditorPicInfo.w = 1.0D;
      localEditorPicInfo.h = (1.0D * (localEditorPicInfo.originPicWidth / 0.333333343267441D) / localEditorPicInfo.originPicHeight);
    }
    for (;;)
    {
      a(str, localEditorPicInfo, null);
      break label81;
      if (i != 2) {
        break;
      }
      adp(1);
      break;
      label268:
      if (d >= 1.777777791023254D)
      {
        localEditorPicInfo.x = (1.0D * (localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight * 1.777777791023254D) / 2.0D / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.w = (1.0D * (localEditorPicInfo.originPicHeight * 1.777777791023254D) / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.h = 1.0D;
      }
      else
      {
        localEditorPicInfo.x = 0.0D;
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.w = 1.0D;
        localEditorPicInfo.h = 1.0D;
        continue;
        label372:
        if (i == 2) {
          if (d < 1.0D)
          {
            localEditorPicInfo.x = 0.0D;
            localEditorPicInfo.y = (1.0D * (localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth) / 2.0D / localEditorPicInfo.originPicHeight);
            localEditorPicInfo.w = 1.0D;
            localEditorPicInfo.h = d;
          }
          else
          {
            localEditorPicInfo.x = (1.0D * (localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight) / 2.0D / localEditorPicInfo.originPicWidth);
            localEditorPicInfo.y = 0.0D;
            localEditorPicInfo.w = d;
            localEditorPicInfo.h = 1.0D;
          }
        }
      }
    }
    label482:
    ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.eGA();
  }
  
  public void jl(View paramView)
  {
    paramView = this.mPhotoCommonData.selectedPhotoList;
    if ((paramView.size() == 0) && (!TextUtils.isEmpty(this.cTm))) {
      paramView.add(this.cTm);
    }
    eGz();
    paramView = new ArrayList();
    Object localObject = new LinkedList(this.mPhotoCommonData.selectedPhotoList);
    int i = 0;
    if (i < ((List)localObject).size())
    {
      String str = (String)((List)localObject).get(i);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        awun localawun = a(str);
        if ((localawun != null) && (localawun.a != null) && (new File(str).exists())) {
          paramView.add(localawun.a);
        }
      }
    }
    if (CollectionUtils.isEmpty(paramView))
    {
      QQToast.a(((awur)this.bu.get()).getActivity(), 2131689982, 0).show();
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", paramView);
    i = axcg.y.getId();
    if (axcg.az(((awur)this.bu.get()).getActivity().getIntent())) {
      i = axcg.A.getId();
    }
    axjh.a(((awur)this.bu.get()).getActivity(), 0, (Bundle)localObject, i);
  }
  
  public boolean needVedio()
  {
    return true;
  }
  
  public void onAlbumListShown(boolean paramBoolean)
  {
    super.onAlbumListShown(paramBoolean);
    if (paramBoolean) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.mPhotoCommonData.albumName)) || (this.cTn.equals(this.mPhotoCommonData.albumName)));
      this.cTn = this.mPhotoCommonData.albumName;
      ((awur)this.bu.get()).b.eGs();
    } while (CollectionUtils.isEmpty(this.mAllImages));
    ((awur)this.bu.get()).jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(0, 0);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.mPhotoCommonData.selectedPhotoList;
    if (this.mPhotoListData.isSingleMode) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
      }
      localLocalMediaInfo = ((awur)this.bu.get()).jdField_a_of_type_Awur$a.getItem(paramInt);
      i = localLocalMediaInfo.selectStatus;
      if ((i == 1) || (paramView.size() < this.mPhotoCommonData.maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.mPhotoListData.lastTimeShowToast < 1000L);
    QQToast.a(((awur)this.bu.get()).getActivity(), getExceedMaxSelectNumStr(localLocalMediaInfo), 0).show(((awur)this.bu.get()).mTitleBarHeight);
    paramCheckBox.setChecked(false);
    this.mPhotoListData.lastTimeShowToast = l;
    return;
    boolean bool1;
    label209:
    Object localObject;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label606;
      }
      bool1 = true;
      paramCheckBox = localLocalMediaInfo.path;
      if (!bool1) {
        break label612;
      }
      localObject = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((this.mPhotoListData.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localObject = this.mPhotoListData;
        ((PhotoListBaseData)localObject).videoSelectedCnt += 1;
        if (this.mPhotoListData.videoSelectedCnt == 1) {
          this.mPhotoListData.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject = this.mPhotoListData;
        ((PhotoListBaseData)localObject).gifSelectedCount += 1;
      }
      paramView.add(paramCheckBox);
      this.mPhotoCommonData.selectedIndex.add(localLocalMediaInfo.position);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      paramView = ((awur)this.bu.get()).getActivity().getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (paramView != null) {
        break label829;
      }
      paramView = new LinkedHashMap();
      QAlbumUtil.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramView);
    }
    label537:
    label829:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((GridLayoutManager)((awur)this.bu.get()).E.getLayoutManager()).findFirstVisibleItemPosition()));
      paramView = QAlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      if (this.jdField_a_of_type_Awva$d != null) {
        this.jdField_a_of_type_Awva$d.onSelectionChange(bool1, localLocalMediaInfo);
      }
      ((awur)this.bu.get()).updateCheckbox(paramInt, bool1);
      paramView = (awur)this.bu.get();
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.selectLimitRemind(bool1);
        return;
        i = 1;
        break;
        label606:
        bool1 = false;
        break label209;
        label612:
        localObject = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
        if ((this.mPhotoListData.isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
        {
          localObject = this.mPhotoListData;
          ((PhotoListBaseData)localObject).videoSelectedCnt -= 1;
          if (this.mPhotoListData.videoSelectedCnt == 1) {
            this.mPhotoListData.selectedVideoInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject = this.mPhotoListData;
          ((PhotoListBaseData)localObject).gifSelectedCount -= 1;
        }
        paramView.remove(paramCheckBox);
        this.mPhotoCommonData.selectedIndex.remove(localLocalMediaInfo.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        paramView = (HashMap)QAlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = QAlbumUtil.sSelectItemAlbum;
        if (!paramView.containsKey(paramCheckBox)) {
          break label537;
        }
        paramView.remove(paramCheckBox);
        break label537;
      }
    }
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void onPreviewBtnClick(View paramView)
  {
    enterPhotoPreviewActivity(false, ((awur)this.bu.get()).getActivity().getIntent());
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    if ((this.bu.get() == null) || (((awur)this.bu.get()).getActivity() == null)) {
      return false;
    }
    ((awur)this.bu.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.4(this));
    Object localObject;
    if (paramList == null)
    {
      if ((!this.mPhotoListData.isShowCamera) || (!this.mPhotoCommonData.albumId.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.mPhotoListData.showCameraInVideo)
        {
          localObject = paramList;
          if (!this.mPhotoCommonData.albumId.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      ((awur)this.bu.get()).jdField_a_of_type_Awur$a.setPhotoList((List)localObject);
      ((awur)this.bu.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.5(this));
      return false;
    }
    if (((this.mPhotoListData.isShowCamera) && (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))) || ((this.mPhotoListData.showCameraInVideo) && (this.mPhotoCommonData.albumId.equals("$VideoAlbumId"))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    ((awur)this.bu.get()).jdField_a_of_type_Awur$a.setPhotoList(paramList);
    boolean bool = paramList.isEmpty();
    ((awur)this.bu.get()).getActivity().runOnUiThread(new AEPhotoListLogicBase.6(this, bool));
    return true;
  }
  
  public void onScrollStart(int paramInt)
  {
    if (paramInt == 1)
    {
      this.dsK = true;
      ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setVisibility(0);
      ((awur)this.bu.get()).c.setVisibility(8);
    }
  }
  
  public void onSendBtnClick(View paramView) {}
  
  public void onTitleBtnCancelClick(View paramView)
  {
    QAlbumUtil.clearSelectItemInfo();
    ((awur)this.bu.get()).getActivity().finish();
    QAlbumUtil.anim(((awur)this.bu.get()).getActivity(), false, false);
  }
  
  public void postInitUI() {}
  
  public void processQueryResult(List<LocalMediaInfo> paramList) {}
  
  protected void s(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      dQ(paramString, paramBoolean1);
      return;
    }
    ((awur)this.bu.get()).jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.post(new AEPhotoListLogicBase.8(this, paramString, paramBoolean1));
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    ((awur)this.bu.get()).startActivity(paramIntent);
    ((awur)this.bu.get()).getActivity().finish();
  }
  
  public void updateButton()
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    String str;
    if (this.mPhotoListData.customSendBtnText != null)
    {
      str = this.mPhotoListData.customSendBtnText;
      if (localArrayList.size() <= 0) {
        break label94;
      }
    }
    label94:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new StringBuilder().append(str).append("(").append(localArrayList.size()).append(")").toString();
      }
      return;
      str = ((awur)this.bu.get()).getString(2131696878);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvc
 * JD-Core Version:    0.7.0.1
 */