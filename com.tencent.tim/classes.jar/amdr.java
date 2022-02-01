import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.2;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.3;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.IBrowserViewHolder;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.Gallery;
import com.tencent.richmediabrowser.view.page.Gallery.LayoutParams;
import com.tencent.theme.SkinnableBitmapDrawable;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class amdr
  extends amdo
  implements View.OnClickListener, ausj.e
{
  public ImageView Di;
  public TextView Kk;
  public TextView Ya;
  public String aWg;
  public ImageButton al;
  public amcw b;
  public TextView bN;
  public boolean biI;
  public ImageView eM;
  MessageQueue.IdleHandler f = new amdu(this);
  public Runnable hu;
  public RelativeLayout lM;
  public String mFilePath;
  public SeekBar s;
  
  public amdr(Activity paramActivity, amcw paramamcw)
  {
    super(paramActivity, paramamcw);
    this.b = paramamcw;
  }
  
  private void Q(long paramLong, int paramInt1, int paramInt2)
  {
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramLong, paramInt1, paramInt2);
    }
    this.b.P(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if ((this.mContext == null) || (this.mContext.isFinishing()) || (this.b.getGallery() == null)) {
      return;
    }
    Object localObject3 = this.b.getGallery().getSelectedView();
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject1 = null;
    int j;
    int i;
    label119:
    Matrix localMatrix;
    if ((localObject3 != null) && ((((View)localObject3).getTag() instanceof amdr.a)))
    {
      localObject1 = ((amdr.a)((View)localObject3).getTag()).urlImageView;
      j = ((View)localObject3).getWidth();
      int k = ((View)localObject3).getHeight();
      if (j >= k * 2)
      {
        i = 1;
        if (k < j * 2) {
          break label349;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label394;
        }
        localMatrix = new Matrix();
        localMatrix.set(this.b.getGallery().getChildMatrix((View)localObject3));
        localObject3 = new Rect(((View)localObject3).getLeft(), ((View)localObject3).getTop(), ((View)localObject3).getRight(), ((View)localObject3).getBottom());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((GalleryUrlImageView)localObject1).getRegionBmp((Rect)localObject3, localMatrix, this.b.getGallery().getWidth(), this.b.getGallery().getHeight());
        if (localObject1 == null) {
          break label400;
        }
        i = rvx.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i) }));
        if (localObject1 == null)
        {
          i = rvx.a(paramUri, this.mContext, 3, localSparseArray);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i) }));
        }
        ThreadManager.getUIHandler().post(new AIOFilePictureView.2(this, i, localSparseArray, paramArrayList));
        if (i > 0) {
          this.aWg = paramUri.getPath();
        }
        adjv.Ld(i);
        return;
      }
      catch (Throwable localThrowable)
      {
        label349:
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "checkQQCode exception :" + localThrowable.getMessage());
      }
      i = 0;
      break;
      j = 0;
      break label119;
      label394:
      Object localObject2 = null;
      continue;
      label400:
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramRichMediaBrowserInfo.orientation == -2) {}
    try
    {
      paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramString);
      this.b.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      amcw.updateRotation(this.galleryView, paramURLDrawable, paramRichMediaBrowserInfo.orientation);
      this.b.onLoadFinish(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + paramString.getMessage());
        paramRichMediaBrowserInfo.orientation = 1;
      }
    }
  }
  
  private void a(File paramFile, AIOFilePictureData paramAIOFilePictureData)
  {
    File localFile = paramFile;
    if (paramFile == null) {
      localFile = new amco().a(paramAIOFilePictureData, 20);
    }
    if (localFile == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 1, "setItemClickListenerForFile: error, file is null.");
      return;
    }
    if (!CheckPermission.isHasStoragePermission(this.mContext))
    {
      CheckPermission.requestStorePermission(this.mContext, null);
      return;
    }
    ahav.by(this.mContext, localFile.getAbsolutePath());
  }
  
  private boolean a(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealThumbImage()");
    Object localObject2 = new amco();
    if (((amco)localObject2).a(paramAIOFilePictureData, 16) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aoop.TRANSPARENT;
      localObject2 = ((amco)localObject2).a(paramAIOFilePictureData, 16);
      paramAIOFilePictureData = null;
      try
      {
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramAIOFilePictureData = (AIOFilePictureData)localObject1;
        ((URLDrawable)localObject1).downloadImediatly();
        paramAIOFilePictureData = (AIOFilePictureData)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOFilePictureData != null) && (paramAIOFilePictureData.getStatus() == 1))
      {
        paramAIOFilePictureData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOFilePictureData);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(aoop.TRANSPARENT);
    return true;
  }
  
  private boolean avL()
  {
    return (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder());
  }
  
  private boolean b(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealErrorImage()");
    if (paramAIOFilePictureData.bim)
    {
      paramGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
      return true;
    }
    return false;
  }
  
  private void dMR()
  {
    AIOFilePictureData localAIOFilePictureData = this.b.a();
    if ((localAIOFilePictureData != null) && (new amco().a(localAIOFilePictureData, 20)))
    {
      if (localAIOFilePictureData.size > 0L) {
        Px(String.format(Locale.CHINA, this.mContext.getString(2131697154), new Object[] { ahbj.g(localAIOFilePictureData.size) }));
      }
    }
    else {
      return;
    }
    Px(this.mContext.getString(2131697151));
  }
  
  public void OR(boolean paramBoolean)
  {
    super.OR(paramBoolean);
    if ((this.b.a() != null) && (this.b.a().agC()))
    {
      this.b.a().cCe = false;
      return;
    }
    showContentView(false);
    this.b.a().dMs();
  }
  
  public void OS(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.Kk != null)
    {
      if (paramBoolean) {
        dMR();
      }
      localTextView = this.Kk;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void OT(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.al != null)
    {
      localImageButton = this.al;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public void OU(boolean paramBoolean)
  {
    if (this.al != null) {
      this.al.setEnabled(paramBoolean);
    }
  }
  
  public void Px(String paramString)
  {
    if (this.Kk != null) {
      this.Kk.setText(paramString);
    }
  }
  
  public boolean SH()
  {
    if (super.SH())
    {
      AIOFilePictureData localAIOFilePictureData = this.b.a();
      if (localAIOFilePictureData != null)
      {
        amco localamco = new amco();
        File localFile2 = localamco.a(localAIOFilePictureData, 20);
        File localFile1 = localFile2;
        if (localFile2 == null) {
          localFile1 = localamco.a(localAIOFilePictureData, 18);
        }
        if ((localFile1 != null) || (!amcj.a().avz())) {
          break label67;
        }
      }
    }
    label67:
    while ((amcj.a().avz()) || (amcj.a().avB())) {
      return false;
    }
    return true;
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile)
  {
    this.d.setItemClickListenerV2(new amdt(this, paramAIOFilePictureData, paramFile));
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile, int paramInt)
  {
    if ((this.mContext != null) && (this.mContext.getIntent() != null)) {
      this.mContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramFile != null)
    {
      aqly.a(2, localArrayList1);
      if ((PicShareToWX.a().isEnable()) && (PicShareToWX.a().A(paramFile))) {
        aqly.a(9, localArrayList1);
      }
      aqly.a(27, localArrayList1);
      aqly.a(144, localArrayList1);
      aqly.a(39, localArrayList2);
      aqly.a(6, localArrayList2);
      if ((amcj.a().avF()) && (!TextUtils.isEmpty(amcj.a().yO()))) {
        aqly.a(54, localArrayList2);
      }
      if (this.biI) {
        aqly.a(52, localArrayList2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOFilePictureView.3(this, paramFile, localArrayList2));
    }
    for (;;)
    {
      a(paramAIOFilePictureData, paramFile);
      paramAIOFilePictureData = this.b.a(paramAIOFilePictureData, this.mContext);
      if (paramAIOFilePictureData != null) {
        this.d.setIntentForStartForwardRecentActivity(paramAIOFilePictureData);
      }
      this.d.setActionSheetItems(localArrayList1, localArrayList2);
      this.d.show();
      return;
      if ((amcj.a().avF()) && (!TextUtils.isEmpty(amcj.a().yO()))) {
        aqly.a(54, localArrayList2);
      }
    }
  }
  
  public boolean avK()
  {
    if ((this.mContext.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (amcj.a().IB() == 3) || (amcj.a().IB() == 2)) {}
    for (int i = 1;; i = 0)
    {
      Bundle localBundle = this.mContext.getIntent().getExtras();
      if (((i == 0) && ((amcj.a().IB() != 4) || (!localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) || (top.eD(amcj.a().Iz()) == 1032) || (top.eD(amcj.a().Iz()) == 1044) || (amcj.a().Iz() == 1037)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean back()
  {
    return super.back();
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.biI = paramIntent.getExtras().getBoolean("extra.OCR", false);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public boolean c(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.c(paramRichMediaBrowserInfo);
  }
  
  void ceJ()
  {
    AIOFilePictureData localAIOFilePictureData = this.b.a();
    Object localObject2;
    Object localObject1;
    if (localAIOFilePictureData != null)
    {
      amco localamco = new amco();
      localObject2 = localamco.a(localAIOFilePictureData, 20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localamco.a(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localamco.a(localAIOFilePictureData, 16);
      }
      if (localObject2 != null) {}
    }
    else
    {
      return;
    }
    this.mFilePath = ((File)localObject2).getAbsolutePath();
    int i = 99;
    int j;
    boolean bool;
    int k;
    switch (amcj.a().IB())
    {
    default: 
      j = 0;
      bool = false;
      k = 0;
      localObject1 = EditPicActivity.a(this.mContext, ((File)localObject2).getAbsolutePath(), true, true, true, true, true, 2, i, 7);
      ((Intent)localObject1).putExtra("uintype", amcj.a().Iz());
      ((Intent)localObject1).putExtra("open_chatfragment", true);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
      ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
      if (bool) {
        ((Intent)localObject1).putExtra("key_help_forward_pic", bool);
      }
      if (j != 0) {
        ((Intent)localObject1).putExtra("key_allow_multiple_forward_from_limit", false);
      }
      if (avL())
      {
        localObject2 = RichMediaBrowserManager.getInstance().getProvider().getForwardData(localAIOFilePictureData.msgId, localAIOFilePictureData.subId, amcj.a().Iz());
        if (localObject2 != null)
        {
          ((Intent)localObject2).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          localObject2 = (ForwardFileInfo)((Intent)localObject2).getParcelableExtra("fileinfo");
          if (localObject2 != null) {
            ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
          }
        }
      }
      ((Intent)localObject1).putExtra("not_forward", true);
      if (k != 0) {
        this.mContext.startActivityForResult((Intent)localObject1, k);
      }
      break;
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
      return;
      i = 125;
      j = 0;
      bool = true;
      k = 19002;
      break;
      i = 126;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 127;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 128;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 129;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 130;
      j = 0;
      bool = true;
      k = 19000;
      break;
      this.mContext.startActivity((Intent)localObject1);
    }
  }
  
  public void dMS()
  {
    AIOFilePictureData localAIOFilePictureData = this.b.a();
    if ((localAIOFilePictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      if (!aqiw.isNetSupport(this.mContext))
      {
        QQToast.a(this.mContext, this.mContext.getString(2131695432), 0).show();
        updateUI();
      }
    }
    else {
      return;
    }
    if (localAIOFilePictureData.bip)
    {
      QQToast.a(this.mContext, this.mContext.getString(2131694128), 0).show();
      updateUI();
      return;
    }
    if (localAIOFilePictureData.biq) {
      updateUI();
    }
    long l = agmx.fJ();
    if ((localAIOFilePictureData.mFileSize > l) && (ahav.amK())) {
      try
      {
        ahav.b(false, this.mContext, new amds(this, localAIOFilePictureData));
        return;
      }
      catch (Throwable localThrowable)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "showFlowDialog throwable = " + localThrowable.getMessage());
        return;
      }
    }
    this.b.P(localThrowable.msgId, localThrowable.subId, 2);
    RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localThrowable.msgId, localThrowable.subId, 20);
    if (this.b.getGallery() != null)
    {
      this.b.getGallery().enableDoubleTap(true);
      this.b.getGallery().enableScaleGesture(true);
    }
    updateUI();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GalleryUrlImageView localGalleryUrlImageView;
    TextView localTextView;
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof amdr.a)))
    {
      this.galleryView = ((RelativeLayout)paramView);
      paramView = (amdr.a)paramView.getTag();
      localGalleryUrlImageView = paramView.urlImageView;
      localTextView = paramView.dM;
      paramViewGroup = paramView.Dj;
      localTextView.setVisibility(8);
      paramViewGroup.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)localGalleryUrlImageView.getLayoutParams();
      paramView.width = -1;
      paramView.height = -1;
      localGalleryUrlImageView.setLayoutParams(paramView);
    }
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    for (;;)
    {
      initContentView();
      this.Di.setVisibility(8);
      localRichMediaBrowserInfo = this.b.getItem(paramInt);
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
        break;
      }
      return localGalleryUrlImageView;
      this.galleryView = new RelativeLayout(this.mContext);
      this.galleryView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      localGalleryUrlImageView = new GalleryUrlImageView(this.mContext);
      localGalleryUrlImageView.setId(2131368820);
      localGalleryUrlImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      paramView.addRule(14);
      this.galleryView.addView(localGalleryUrlImageView, paramView);
      localTextView = new TextView(this.mContext);
      localTextView.setTextSize(2, 8.0F);
      localTextView.setTextColor(-1);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(3, 2131366690);
      paramView.addRule(14);
      paramView.topMargin = wja.dp2px(4.0F, this.mContext.getResources());
      this.galleryView.addView(localTextView, paramView);
      paramViewGroup = new ImageView(this.mContext);
      paramViewGroup.setId(2131366690);
      paramView = new RelativeLayout.LayoutParams(120, 120);
      paramView.addRule(14);
      this.galleryView.addView(paramViewGroup, paramView);
      localTextView.setVisibility(8);
      paramViewGroup.setVisibility(8);
    }
    AIOFilePictureData localAIOFilePictureData;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if (localRichMediaBrowserInfo.baseData.getType() == 102)
    {
      paramView = this.b.a();
      if ((paramView == null) || (paramView.baseData == null) || (paramView.baseData.getType() != 102) || (((AIOBrowserBaseData)paramView.baseData).msgId != ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).msgId) || (paramView.isReport)) {
        break label791;
      }
      anot.a(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
      paramView.isReport = true;
      localAIOFilePictureData = (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      localObject3 = new amco();
      localGalleryUrlImageView.setPosition(paramInt);
      localGalleryUrlImageView.setImageInfo(localRichMediaBrowserInfo);
      localGalleryUrlImageView.setIgnoreLayout(false);
      localGalleryUrlImageView.setContentDescription(this.mContext.getString(2131692611));
      localObject4 = (URLDrawable)this.b.mActiveDrawable.get(Integer.valueOf(paramInt));
      String str1 = ((amco)localObject3).a(localAIOFilePictureData, 20);
      String str2 = ((amco)localObject3).a(localAIOFilePictureData, 18);
      String str3 = ((amco)localObject3).a(localAIOFilePictureData, 16);
      localObject1 = "";
      paramView = (View)localObject1;
      if (localObject4 != null)
      {
        paramView = (View)localObject1;
        if (((URLDrawable)localObject4).getURL() != null) {
          paramView = ((URLDrawable)localObject4).getURL().toString();
        }
      }
      if ((localObject4 == null) || (((URLDrawable)localObject4).getStatus() != 1) || (TextUtils.isEmpty(paramView)) || ((!paramView.equals(str1)) && (!paramView.equals(str2)) && (!paramView.equals(str3)))) {
        break label827;
      }
      localGalleryUrlImageView.setImageDrawable((Drawable)localObject4);
      paramView = ((amco)localObject3).a(localAIOFilePictureData, 20);
      localObject1 = ((URLDrawable)localObject4).getURL().toString();
      this.b.onLoadFinish(paramInt, true);
      if (((String)localObject1).equals(paramView)) {
        localGalleryUrlImageView.setOriginalImage(true);
      }
      if (localRichMediaBrowserInfo.orientation == -2) {
        localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(((URLDrawable)localObject4).getURL().getFile());
      }
      paramView = this.b;
      amcw.updateRotation(this.galleryView, (URLDrawable)localObject4, localRichMediaBrowserInfo.orientation);
    }
    for (;;)
    {
      paramView = new amdr.a();
      paramView.urlImageView = localGalleryUrlImageView;
      paramView.dM = localTextView;
      paramView.Dj = paramViewGroup;
      this.galleryView.setTag(paramView);
      return this.galleryView;
      label791:
      anot.a(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
      break;
      label827:
      localObject4 = ((amco)localObject3).a(localAIOFilePictureData, 20);
      if (localObject4 != null)
      {
        paramView = null;
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.mScreenWidthPx;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.mScreenHeightPx;
        if (((amco)localObject3).a(localAIOFilePictureData, 16) != null)
        {
          localObject3 = URLDrawable.getFileDrawable(localAIOFilePictureData.aVW, null);
          ((URLDrawable)localObject3).downloadImediatly();
        }
        for (((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject3);; ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
          try
          {
            localObject1 = URLDrawable.getFileDrawable(((File)localObject4).getAbsolutePath(), (URLDrawable.URLDrawableOptions)localObject1);
            paramView = (View)localObject1;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
            }
          }
          if (paramView == null) {
            break;
          }
          paramView.setTag(Integer.valueOf(1));
          this.b.mActiveDrawable.put(Integer.valueOf(paramInt), paramView);
          localObject1 = ((File)localObject4).getAbsolutePath();
          localGalleryUrlImageView.setGalleryImageListener(new amdv(this, localRichMediaBrowserInfo, (String)localObject1, paramView, localAIOFilePictureData, localGalleryUrlImageView));
          this.hu = wja.a(this.Di, paramView);
          if ((this.hu == null) && (paramView.getStatus() == 1)) {
            a(localRichMediaBrowserInfo, (String)localObject1, paramView, paramInt);
          }
          localGalleryUrlImageView.setImageDrawable(paramView);
          break;
        }
      }
      localObject4 = ((amco)localObject3).a(localAIOFilePictureData, 18);
      if (localObject4 != null)
      {
        if (localObject4 != null) {}
        paramView = null;
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.mScreenWidthPx;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.mScreenHeightPx;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
        try
        {
          localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
          paramView = (View)localObject2;
          ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
          paramView = (View)localObject2;
          ((URLDrawable)localObject2).downloadImediatly();
          paramView = (View)localObject2;
          if (paramView != null) {
            this.b.mActiveDrawable.put(Integer.valueOf(paramInt), paramView);
          }
          if ((paramView != null) && (paramView.getStatus() == 1)) {
            if (localRichMediaBrowserInfo.orientation != -2) {}
          }
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(((File)localObject4).getAbsolutePath());
            localObject2 = this.b;
            amcw.updateRotation(this.galleryView, paramView, localRichMediaBrowserInfo.orientation);
            localGalleryUrlImageView.setImageDrawable(paramView);
            this.b.onLoadFinish(paramInt, true);
            continue;
            localThrowable2 = localThrowable2;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + localException.getMessage());
              localRichMediaBrowserInfo.orientation = 1;
            }
          }
          if ((!a(localAIOFilePictureData, localGalleryUrlImageView)) && (!b(localAIOFilePictureData, localGalleryUrlImageView))) {
            a(localGalleryUrlImageView);
          }
          Q(localAIOFilePictureData.msgId, localAIOFilePictureData.subId, 18);
        }
      }
      else if (((amco)localObject3).a(localAIOFilePictureData, 16) != null)
      {
        if ((!a(localAIOFilePictureData, localGalleryUrlImageView)) && (!b(localAIOFilePictureData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        Q(localAIOFilePictureData.msgId, localAIOFilePictureData.subId, 18);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): url is " + ((amco)localObject3).a(localAIOFilePictureData, 16) + ", file type is " + 16);
      }
      else
      {
        if ((!ahbr.b(localAIOFilePictureData.picWidth, localAIOFilePictureData.picHeight, localAIOFilePictureData.mFileSize)) && (localAIOFilePictureData.bWF != 1))
        {
          if (localAIOFilePictureData.bim) {
            a(localGalleryUrlImageView);
          }
          for (;;)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): No pic");
            break;
            a(localGalleryUrlImageView);
            Q(localAIOFilePictureData.msgId, localAIOFilePictureData.subId, 18);
          }
        }
        paramView = BaseApplicationImpl.getApplication().getResources().getDrawable(2130845125);
        paramViewGroup.setVisibility(0);
        paramViewGroup.setImageDrawable(paramView);
        localTextView.setVisibility(0);
        localTextView.setText(2131693640);
        this.b.a().dMn();
      }
    }
  }
  
  public void initContentView()
  {
    if (this.contentView == null)
    {
      this.contentView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559358, null));
      this.lM = ((RelativeLayout)this.contentView.findViewById(2131377628));
      this.bN = ((TextView)this.contentView.findViewById(2131373689));
      this.eM = ((ImageView)this.contentView.findViewById(2131364690));
      this.s = ((SeekBar)this.contentView.findViewById(2131377919));
      this.Ya = ((TextView)this.contentView.findViewById(2131366691));
      this.Di = ((ImageView)this.contentView.findViewById(2131370810));
      this.eM.setOnClickListener(this);
      this.al = ((ImageButton)this.contentView.findViewById(2131374889));
      this.al.setOnClickListener(this);
      this.Kk = ((TextView)this.contentView.findViewById(2131374892));
      this.Kk.setOnClickListener(this);
      OT(avK());
      this.aD = ((ImageButton)this.contentView.findViewById(2131374885));
      if (this.aD != null) {
        this.aD.setOnClickListener(this);
      }
      this.an = ((ImageButton)this.contentView.findViewById(2131374887));
      if (this.an != null) {
        this.an.setOnClickListener(this);
      }
      this.k = ((ImageButton)this.contentView.findViewById(2131374888));
      this.k.setOnClickListener(this);
      if (ayxa.isLiuHaiUseValid())
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
        localLayoutParams.addRule(10, -1);
        localLayoutParams.topMargin = ayxa.sNotchHeight;
      }
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.b.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 102))
      {
        this.b.back();
        continue;
        localObject = this.b.a();
        if (localObject != null)
        {
          if (RichMediaBrowserManager.getInstance().getProvider() != null) {
            RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOFilePictureData)localObject).msgId, ((AIOFilePictureData)localObject).subId, 20);
          }
          this.b.P(((AIOFilePictureData)localObject).msgId, ((AIOFilePictureData)localObject).subId, 0);
          updateUI();
          continue;
          dML();
          continue;
          dMS();
          continue;
          ceJ();
          this.b.dMx();
          continue;
          dMK();
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryFilePicView", 0, "onClick qq_gallery_danmaku_view ");
          }
          localObject = this.b.a();
          if (localObject != null) {
            MiniChatActivity.a(this.mContext, amcj.a().Iz(), amcj.a().yM(), false, 26, ((AIOFilePictureData)localObject).shmsgseq, 0L);
          }
          this.b.dMB();
        }
      }
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject = (URLDrawable)this.b.mActiveDrawable.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      if (((URLDrawable)localObject).getStatus() == 3) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    AIOFilePictureData localAIOFilePictureData;
    do
    {
      do
      {
        do
        {
          return null;
        } while ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 102));
        localAIOFilePictureData = (AIOFilePictureData)paramRichMediaBrowserInfo.baseData;
        amco localamco = new amco();
        localObject = localamco.a(localAIOFilePictureData, 20);
        paramRichMediaBrowserInfo = (RichMediaBrowserInfo)localObject;
        if (localObject == null)
        {
          paramRichMediaBrowserInfo = localamco.a(localAIOFilePictureData, 18);
          if (paramRichMediaBrowserInfo == null) {}
        }
        else
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
          paramRichMediaBrowserInfo = URLDrawable.getDrawable(paramRichMediaBrowserInfo, (URLDrawable.URLDrawableOptions)localObject);
          paramRichMediaBrowserInfo.setTag(Integer.valueOf(1));
          paramRichMediaBrowserInfo.startDownload();
          this.b.mActiveDrawable.put(Integer.valueOf(paramInt), paramRichMediaBrowserInfo);
          return null;
        }
        paramRichMediaBrowserInfo = localamco.a(localAIOFilePictureData, 16);
        if (paramRichMediaBrowserInfo == null) {
          break;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
        URLDrawable.getDrawable(paramRichMediaBrowserInfo, (URLDrawable.URLDrawableOptions)localObject).startDownload();
      } while ((!aqiw.isWifiConnected(this.mContext)) || (localAIOFilePictureData.mFileSize > agmx.fL()) || (RichMediaBrowserManager.getInstance().getProvider() == null));
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOFilePictureData.msgId, localAIOFilePictureData.subId, 18);
      return null;
    } while ((!aqiw.isWifiConnected(this.mContext)) || (localAIOFilePictureData.mFileSize > agmx.fL()));
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOFilePictureData.msgId, localAIOFilePictureData.subId, 18);
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
    return null;
  }
  
  public void onDismissOperations()
  {
    this.b.updateSystemUIVisablity();
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    Looper.myQueue().addIdleHandler(this.f);
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    showContentView(false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if ((paramView != null) && ((paramView.getTag() instanceof amdr.a)))
    {
      paramAdapterView = (amdr.a)paramView.getTag();
      if (paramAdapterView.urlImageView != null)
      {
        paramView = paramAdapterView.urlImageView;
        Drawable localDrawable = paramView.getDrawable();
        paramAdapterView = this.b.a();
        if ((paramAdapterView != null) && (!paramView.isOriginalImage()) && ((localDrawable instanceof SkinnableBitmapDrawable)) && (paramAdapterView.istroop == 1) && (paramAdapterView.size > agmx.fL()) && (this.b.getGallery() != null))
        {
          this.b.getGallery().enableDoubleTap(false);
          this.b.getGallery().enableScaleGesture(false);
        }
        if (paramAdapterView != null)
        {
          paramView = new amco();
          if ((paramView.a(paramAdapterView, 20) == null) && (paramView.a(paramAdapterView, 18) == null) && (paramView.a(paramAdapterView, 16) == null) && ((ahbr.b(paramAdapterView.picWidth, paramAdapterView.picHeight, paramAdapterView.mFileSize)) || (paramAdapterView.bWF == 1))) {
            this.b.a().dMn();
          }
        }
      }
      updateUI();
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof amdr.a)))
    {
      paramView = ((amdr.a)paramView.getTag()).urlImageView.getDrawable();
      if (URLDrawable.class.isInstance(paramView)) {}
    }
    else
    {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void showActionSheet(int paramInt)
  {
    super.showActionSheet(paramInt);
    AIOFilePictureData localAIOFilePictureData = this.b.a();
    Object localObject2;
    if (localAIOFilePictureData != null)
    {
      amco localamco = new amco();
      localObject2 = localamco.a(localAIOFilePictureData, 20);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localamco.a(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localamco.a(localAIOFilePictureData, 16);
      }
      if ((localObject2 != null) || (!amcj.a().avz())) {}
    }
    else
    {
      return;
    }
    a(localAIOFilePictureData, (File)localObject2, paramInt);
  }
  
  public void updateUI()
  {
    super.updateUI();
    AIOFilePictureData localAIOFilePictureData = this.b.a();
    if (localAIOFilePictureData != null) {}
    switch (localAIOFilePictureData.status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "updateUI status is error, status = " + localAIOFilePictureData.status);
      return;
    case 1: 
      OS(false);
      OP(false);
      OT(false);
      OQ(false);
      this.b.onLoadStart(this.b.getSelectedIndex(), localAIOFilePictureData.progress);
      return;
    case 2: 
      this.b.onLoadFinish(this.b.getSelectedIndex(), true);
      OS(false);
      OP(false);
      OT(false);
      OQ(false);
      this.bN.setText(acfp.m(2131702221) + localAIOFilePictureData.progress / 100 + "%");
      this.s.setProgress(localAIOFilePictureData.progress / 100);
      this.lM.setVisibility(0);
      return;
    }
    this.lM.setVisibility(8);
    OP(SH());
    OQ(c(this.b.getSelectedItem()));
    boolean bool;
    amco localamco;
    if (!ahbj.fileExistsAndNotEmpty(localAIOFilePictureData.aVY))
    {
      bool = true;
      OS(bool);
      OT(true);
      localamco = new amco();
      if (localAIOFilePictureData.mFileSize <= 10485760L) {
        break label324;
      }
      OU(false);
    }
    for (;;)
    {
      this.b.onLoadFinish(this.b.getSelectedIndex(), true);
      return;
      bool = false;
      break;
      label324:
      if ((localamco.a(localAIOFilePictureData, 18) != null) || (localamco.a(localAIOFilePictureData, 20) != null)) {
        OU(true);
      } else {
        OU(false);
      }
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getItem(paramInt);
    Object localObject;
    TextView localTextView;
    AIOFilePictureData localAIOFilePictureData;
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 102) && (this.galleryView != null) && ((paramView.getTag() instanceof amdr.a)))
    {
      paramString1 = (amdr.a)paramView.getTag();
      paramView = paramString1.urlImageView;
      localObject = paramString1.Dj;
      localTextView = paramString1.dM;
      localAIOFilePictureData = (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      paramString1 = new amco();
      ((ImageView)localObject).setVisibility(8);
      localTextView.setVisibility(8);
      if (!localAIOFilePictureData.bim) {
        break label362;
      }
      paramString1 = paramView.getDrawable();
      if (!URLDrawable.class.isInstance(paramString1)) {
        break label652;
      }
      paramString1 = (URLDrawable)paramString1;
      paramString2 = paramString1.getURL().getRef();
    }
    for (;;)
    {
      if ((paramString2 == null) && (ahbj.fileExistsAndNotEmpty(localAIOFilePictureData.aVW)))
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mLoadingDrawable = aoop.TRANSPARENT;
        paramString1.mFailedDrawable = aoop.TRANSPARENT;
        paramString1 = URLDrawable.getDrawable(new File(localAIOFilePictureData.aVW), paramString1);
        if (paramString1 != null)
        {
          paramView.setImageDrawable(paramString1);
          paramString1.downloadImediatly();
        }
      }
      label362:
      do
      {
        do
        {
          return;
        } while ((paramString1 != null) && (paramString2 != null) && (("PART".equals(paramString2)) || ("DISPLAY".equals(paramString2))));
        if ((ahbr.b(localAIOFilePictureData.picWidth, localAIOFilePictureData.picHeight, localAIOFilePictureData.mFileSize)) || (localAIOFilePictureData.bWF == 1))
        {
          paramString1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130845125);
          ((ImageView)localObject).setVisibility(0);
          ((ImageView)localObject).setImageDrawable(paramString1);
          localTextView.setVisibility(0);
          localTextView.setText(2131693640);
          this.b.a().dMn();
        }
        for (;;)
        {
          this.b.onLoadFinish(paramInt, false);
          this.b.a().pG();
          return;
          paramView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
        }
        localObject = paramString1.a(localAIOFilePictureData, 18);
      } while (localObject == null);
      paramString2 = paramString1.a(localAIOFilePictureData, 18);
      paramString1 = paramString2;
      if (paramBoolean) {
        paramString1 = paramString2 + "#PART";
      }
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      paramString2.mUseExifOrientation = false;
      paramString2.mPlayGifImage = true;
      paramString2 = URLDrawable.getDrawable((File)localObject, paramString2);
      paramString2.setTag(Integer.valueOf(1));
      if (paramString2.getStatus() == 1) {
        if (localRichMediaBrowserInfo.orientation != -2) {}
      }
      for (;;)
      {
        try
        {
          localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(((File)localObject).getAbsolutePath());
          paramView.setImageDrawable(paramString2);
          this.b.onLoadFinish(paramInt, true);
          paramView = this.b;
          amcw.updateRotation(this.galleryView, paramString2, localRichMediaBrowserInfo.orientation);
          paramString2 = aqhq.estimateFileType(localAIOFilePictureData.aVX);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
          this.b.a().dLE();
          return;
        }
        catch (Exception localException)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + localException.getMessage());
          localRichMediaBrowserInfo.orientation = 1;
          continue;
        }
        paramString2.setTag(Integer.valueOf(1));
        paramString2.startDownload();
        paramView.setDecodingDrawble(paramString2);
      }
      label652:
      paramString2 = null;
      paramString1 = null;
    }
  }
  
  class a
    extends IBrowserViewHolder
  {
    public ImageView Dj;
    public TextView dM;
    public GalleryUrlImageView urlImageView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdr
 * JD-Core Version:    0.7.0.1
 */