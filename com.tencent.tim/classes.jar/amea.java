import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.RemoteException;
import android.support.annotation.RequiresApi;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.3;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.9;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
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
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class amea
  extends amdo
  implements View.OnClickListener, ausj.e
{
  public ImageView Di;
  public TextView Kk;
  public TextView Ya;
  public amea.b a;
  public String aWg;
  public long aiz;
  public ImageButton al;
  private amda b;
  public TextView bN;
  public int bWP = 1;
  public boolean biI;
  public boolean biJ;
  public boolean biK;
  public ImageView eM;
  MessageQueue.IdleHandler f = new amee(this);
  public Runnable hu;
  public LinearLayout kh;
  public RelativeLayout lM;
  public String mFilePath;
  private URLDrawable mRawDrawable;
  private int mRawDrawablePosition = -1;
  public TextView mTextView;
  public ArrayList<String> qJ = new ArrayList();
  public SeekBar s;
  
  public amea(Activity paramActivity, amda paramamda)
  {
    super(paramActivity, paramamda);
    this.b = paramamda;
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
    if ((localObject3 != null) && ((((View)localObject3).getTag() instanceof amea.a)))
    {
      localObject1 = ((amea.a)((View)localObject3).getTag()).urlImageView;
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
          break label395;
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
          break label401;
        }
        i = rvx.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i) }));
        if (localObject1 == null)
        {
          i = rvx.a(paramUri, this.mContext, 3, localSparseArray);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i) }));
        }
        ThreadManager.getUIHandler().post(new AIOPictureView.9(this, i, localSparseArray, paramArrayList));
        if (i > 0) {
          this.aWg = paramUri.getPath();
        }
        adjv.Ld(i);
        return;
      }
      catch (Throwable localThrowable)
      {
        label349:
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "checkQQCode exception :" + localThrowable.getMessage());
      }
      i = 0;
      break;
      j = 0;
      break label119;
      label395:
      Object localObject2 = null;
      continue;
      label401:
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private void a(ausj paramausj, File paramFile)
  {
    if ((top.eD(amcj.a().Iz()) == 1032) && (paramFile != null)) {
      paramausj.addButton(2131694762);
    }
    paramausj.addCancelButton(2131694179);
    paramausj.a(new ameh(this, paramausj));
    paramausj.show();
    paramausj.a(this);
  }
  
  private void a(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject3 = new amcs();
    Object localObject2 = ((amcs)localObject3).a(paramAIOPictureData, 4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ((amcs)localObject3).a(paramAIOPictureData, 2);
    }
    if ((localObject1 == null) && (amcj.a().avz())) {
      return;
    }
    if (localObject1 != null) {
      this.mFilePath = ((File)localObject1).getPath();
    }
    localObject2 = ausj.d(this.mContext);
    if (top.eD(amcj.a().Iz()) != 1032)
    {
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      if (localObject1 != null)
      {
        a((ArrayList)localObject2, paramAIOPictureData, (File)localObject1, (ArrayList)localObject3, (File)localObject1);
        if ((paramAIOPictureData.imageBizType == 4) && (!this.biJ) && (!paramAIOPictureData.isSend)) {
          aqly.a(66, (ArrayList)localObject3);
        }
        a(paramAIOPictureData, paramRichMediaBrowserInfo, (File)localObject1);
        if (this.mContext != null)
        {
          localObject1 = this.mContext.getIntent();
          if (!this.biJ) {
            break label348;
          }
          paramAIOPictureData = "biz_src_jc_groupgif";
          label180:
          ((Intent)localObject1).putExtra("big_brother_source_key", paramAIOPictureData);
        }
        if ((amcj.a().Iz() != 1037) && (top.eD(amcj.a().Iz()) != 1044))
        {
          if (this.b != null) {
            break label355;
          }
          paramAIOPictureData = null;
          label225:
          if (paramAIOPictureData == null) {
            break label371;
          }
          paramAIOPictureData.putExtra("key_new_img_shareactionsheet", 1);
          paramAIOPictureData.putExtra("k_dataline", true);
          this.d.setIntentForStartForwardRecentActivity(paramAIOPictureData);
        }
      }
      for (;;)
      {
        this.d.setActionSheetItems((List)localObject2, (List)localObject3);
        this.d.show();
        return;
        if ((amcj.a().avB()) || (amcj.a().Iz() == 1037) || (!amcj.a().avF()) || (TextUtils.isEmpty(amcj.a().yO())) || (top.eD(amcj.a().Iz()) == 1044)) {
          break;
        }
        aqly.a(54, (ArrayList)localObject3);
        break;
        label348:
        paramAIOPictureData = "biz_src_jc_photo";
        break label180;
        label355:
        paramAIOPictureData = this.b.a(paramRichMediaBrowserInfo, this.mContext);
        break label225;
        label371:
        this.d.setIntentForStartForwardRecentActivity(null);
        QLog.e("AIOPictureView", 2, "showActionSheetForPic setIntentForStartForwardRecentActivity get null intent");
      }
    }
    a((ausj)localObject2, (File)localObject1);
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    try
    {
      paramRichMediaBrowserInfo = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
      if (RichMediaBrowserManager.getInstance().getProvider() != null)
      {
        paramRichMediaBrowserInfo = RichMediaBrowserManager.getInstance().getProvider().getFavorateParams(paramRichMediaBrowserInfo.msgId, paramRichMediaBrowserInfo.subId);
        if (paramRichMediaBrowserInfo == null) {
          aviz.b(paramFile.getAbsolutePath()).b(this.mContext, amcj.a().yP());
        }
        for (;;)
        {
          avjg.a(null, 40, 3);
          return;
          new aviz(paramRichMediaBrowserInfo).b(this.mContext, amcj.a().yP());
        }
      }
      return;
    }
    catch (RemoteException paramRichMediaBrowserInfo)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "ACTION_GALLERY_PIC_FAVORITE exception = " + paramRichMediaBrowserInfo.getMessage());
      QQToast.a(this.mContext.getApplicationContext(), this.mContext.getString(2131694176), 0).show();
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramRichMediaBrowserInfo.orientation == -2) {}
    try
    {
      paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramString);
      paramURLDrawable.setTag(Integer.valueOf(1));
      this.b.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      paramString = this.b;
      amda.updateRotation(this.galleryView, paramURLDrawable, paramRichMediaBrowserInfo.orientation);
      this.b.onLoadFinish(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + paramString.getMessage());
        paramRichMediaBrowserInfo.orientation = 1;
      }
    }
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, AIOPictureData paramAIOPictureData, File paramFile1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, File paramFile2)
  {
    if ((amcj.a().Iz() != 1037) && (top.eD(amcj.a().Iz()) != 1044)) {
      aqly.a(2, paramArrayList1);
    }
    aqly.a(27, paramArrayList1);
    if ((PicShareToWX.a().isEnable()) && (PicShareToWX.a().A(paramFile1))) {
      aqly.a(9, paramArrayList1);
    }
    if (this.biJ)
    {
      aqly.a(48, paramArrayList2);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if (!ahwy.a().aoe()) {
      aqly.a(39, paramArrayList2);
    }
    if (!this.biJ) {
      aqly.a(6, paramArrayList2);
    }
    if ((amcj.a().Iz() != 1037) && (top.eD(amcj.a().Iz()) != 1044))
    {
      if ((amcj.a().avF()) && (!TextUtils.isEmpty(amcj.a().yO())) && (!amcj.a().avB())) {
        aqly.a(54, paramArrayList2);
      }
      if (this.biI) {
        aqly.a(52, paramArrayList2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOPictureView.3(this, paramFile2, paramArrayList2));
    }
  }
  
  private boolean a(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage()");
    amcs localamcs = new amcs();
    if (localamcs.a(paramAIOPictureData, 8) != null)
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
      if ((paramAIOPictureData.EP == 1) && ((paramAIOPictureData.bWU & 0x2) == 2)) {
        ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
      }
      Object localObject1 = null;
      try
      {
        localObject2 = URLDrawable.getDrawable(localamcs.a(paramAIOPictureData, 8), (URLDrawable.URLDrawableOptions)localObject2);
        localObject1 = localObject2;
        ((URLDrawable)localObject2).downloadImediatly();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): url is " + localamcs.a(paramAIOPictureData, 8) + ", file type is " + 8);
      }
      if ((localObject1 != null) && (localObject1.getStatus() == 1))
      {
        localObject1.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(localObject1);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set temp image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(aoop.TRANSPARENT);
    return true;
  }
  
  private void b(AIOPictureData paramAIOPictureData)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet add to favorite.");
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_md5", paramAIOPictureData.md5);
    paramAIOPictureData = new amek(this);
    QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", localBundle, paramAIOPictureData);
    if (this.biJ) {
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void b(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    if (!CheckPermission.isHasStoragePermission(this.mContext))
    {
      CheckPermission.requestStorePermission(this.mContext, null);
      return;
    }
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_save", 0);
    }
    amcs localamcs = new amcs();
    if ((localamcs.a(paramAIOPictureData, 4) == null) && (localamcs.a(paramAIOPictureData, 4)) && (AppNetConnInfo.isNetSupport())) {
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOPictureData.size > 29360128L)) {
        a(1, paramAIOPictureData, paramRichMediaBrowserInfo);
      }
    }
    for (;;)
    {
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().reportData(paramFile.getAbsolutePath(), 55);
      }
      if (this.biJ) {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
      }
      if (amcj.a().avB()) {
        ajlg.report("0X8009ABB");
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "ACTION_GALLERY_PIC_SAVE");
      return;
      this.b.a(paramAIOPictureData);
      this.b.P(paramAIOPictureData.msgId, paramAIOPictureData.subId, 3);
      updateUI();
      continue;
      amdf.a(this.mContext, paramFile, Utils.Crc64String(paramFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
    }
  }
  
  private boolean b(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealThumbImage()");
    Object localObject2 = new amcs();
    if (((amcs)localObject2).a(paramAIOPictureData, 1) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aoop.TRANSPARENT;
      if ((paramAIOPictureData.EP == 1) && ((paramAIOPictureData.bWU & 0x2) == 2)) {
        ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
      }
      localObject2 = ((amcs)localObject2).a(paramAIOPictureData, 1);
      paramAIOPictureData = null;
      try
      {
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramAIOPictureData = (AIOPictureData)localObject1;
        ((URLDrawable)localObject1).downloadImediatly();
        paramAIOPictureData = (AIOPictureData)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOPictureData != null) && (paramAIOPictureData.getStatus() == 1))
      {
        paramAIOPictureData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOPictureData);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private void c(AIOPictureData paramAIOPictureData)
  {
    if (LocalMultiProcConfig.getInt4Uin(amcj.a().yP() + "__qzone_pic_permission__" + amcj.a().yM(), -1, Long.valueOf(amcj.a().yP()).longValue()) == 0)
    {
      paramAIOPictureData = new aqju(this.mContext, 2131756467);
      paramAIOPictureData.setContentView(2131559151);
      paramAIOPictureData.setTitle(this.mContext.getString(2131699885));
      paramAIOPictureData.setMessage(this.mContext.getString(2131699883));
      paramAIOPictureData.setNegativeButton(this.mContext.getString(2131699884), new amel(this));
      paramAIOPictureData.setCanceledOnTouchOutside(false);
      paramAIOPictureData.setCancelable(false);
      paramAIOPictureData.show();
      QZoneClickReport.startReportImediately(amcj.a().yP(), "40", "1");
      return;
    }
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Grpalbum", 0);
    }
    amdf.a(this.mContext, amcj.a().yP(), amcj.a().yM(), amcj.a().yN(), paramAIOPictureData.aVW, paramAIOPictureData.uuid, paramAIOPictureData.timestamp, -1);
  }
  
  private boolean c(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    boolean bool = false;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealErrorImage()");
    if ((paramAIOPictureData.bin) || (paramAIOPictureData.bim) || (paramAIOPictureData.bio))
    {
      paramGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
      this.b.onLoadFinish(this.b.getSelectedIndex(), false);
      bool = true;
    }
    return bool;
  }
  
  private void d(AIOPictureData paramAIOPictureData)
  {
    if (this.biJ)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet share weiyun.");
      localBundle = new Bundle();
      localBundle.putString("pic_md5", paramAIOPictureData.md5);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", localBundle, null);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
    }
    while ((paramAIOPictureData.msgId <= 0L) || (RichMediaBrowserManager.getInstance().getProvider() == null) || (!RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Bundle localBundle;
      return;
    }
    RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(paramAIOPictureData.msgId);
    QQToast.a(this.mContext, this.mContext.getString(2131694101), 0).show();
  }
  
  private void dMR()
  {
    Object localObject = this.b.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (new amcs().a((AIOPictureData)localObject, 4))
      {
        if (((AIOPictureData)localObject).size <= 0L) {
          break label98;
        }
        Px(String.format(Locale.CHINA, this.mContext.getString(2131697154), new Object[] { ahbj.g(((AIOPictureData)localObject).size) }));
      }
    }
    return;
    label98:
    Px(this.mContext.getString(2131697151));
  }
  
  private void dMV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPictureView", 2, "onClick qq_gallery_danmaku_view ");
    }
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
      MiniChatActivity.a(this.mContext, amcj.a().Iz(), amcj.a().yM(), false, 26, ((AIOPictureData)localRichMediaBrowserInfo.baseData).shmsgseq, 0L);
    }
    this.b.dMB();
  }
  
  private void dMW()
  {
    Object localObject = this.b.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      switch (((AIOPictureData)localObject).status)
      {
      }
    }
    for (;;)
    {
      this.b.P(((AIOPictureData)localObject).msgId, ((AIOPictureData)localObject).subId, 0);
      updateUI();
      return;
      if (RichMediaBrowserManager.getInstance().getProvider() != null)
      {
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).msgId, ((AIOPictureData)localObject).subId, 4);
        continue;
        if (RichMediaBrowserManager.getInstance().getProvider() != null)
        {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).msgId, ((AIOPictureData)localObject).subId, 2);
          continue;
          if (RichMediaBrowserManager.getInstance().getProvider() != null) {
            RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).msgId, ((AIOPictureData)localObject).subId, 24);
          }
        }
      }
    }
  }
  
  private void dMX()
  {
    Object localObject = this.b.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (!TextUtils.isEmpty(((AIOPictureData)localObject).templateId))
      {
        aywz.aa(this.mContext, ((AIOPictureData)localObject).templateId);
        anot.a(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 1, 0, "", "", ((AIOPictureData)localObject).templateId, "");
      }
    }
  }
  
  private void e(AIOPictureData paramAIOPictureData)
  {
    String str = amcj.a().yM();
    if (TextUtils.isEmpty(str)) {
      str = amcj.a().yO();
    }
    for (;;)
    {
      anot.a(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", amcj.a().IB(), 0, "", "", "", "");
      amdl.a(this.mContext, amcj.a().Iz(), amcj.a().yO(), str, paramAIOPictureData.time, paramAIOPictureData.shmsgseq, paramAIOPictureData.istroop, false);
      return;
    }
  }
  
  private void f(AIOPictureData paramAIOPictureData)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      if (paramAIOPictureData.bdq) {
        RichMediaBrowserManager.getInstance().getProvider().safetyReport(amcj.a().Iz(), true, paramAIOPictureData.TI, paramAIOPictureData.aWk, localAppRuntime.getAccount(), paramAIOPictureData.content);
      }
    }
    else {
      return;
    }
    RichMediaBrowserManager.getInstance().getProvider().safetyReport(amcj.a().Iz(), false, paramAIOPictureData.send_uin, paramAIOPictureData.aWk, localAppRuntime.getAccount(), paramAIOPictureData.content);
  }
  
  public void OR(boolean paramBoolean)
  {
    super.OR(paramBoolean);
    if (this.b.agC())
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
  
  public void OY(boolean paramBoolean)
  {
    int j = 0;
    if (this.kh != null)
    {
      Object localObject = this.b.getSelectedItem();
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((RichMediaBrowserInfo)localObject).baseData != null)
          {
            i = j;
            if (((RichMediaBrowserInfo)localObject).baseData.getType() == 100)
            {
              i = j;
              if (!amcj.a().avE())
              {
                i = j;
                if (!amcj.a().avB())
                {
                  i = j;
                  if (alwy.auJ())
                  {
                    i = j;
                    if (ShortVideoUtils.awO())
                    {
                      AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
                      long l = localAIOPictureData.msgId;
                      i = j;
                      if (!TextUtils.isEmpty(localAIOPictureData.templateId))
                      {
                        this.kh.setVisibility(0);
                        localObject = this.mContext.getString(2131694171);
                        if (!TextUtils.isEmpty(localAIOPictureData.templateName)) {
                          localObject = localAIOPictureData.templateName;
                        }
                        this.mTextView.setText((CharSequence)localObject);
                        if (this.aiz != l)
                        {
                          anot.a(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 1, 0, "", "", localAIOPictureData.templateId, "");
                          this.aiz = l;
                        }
                        i = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (i == 0) {
        this.kh.setVisibility(8);
      }
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
    Object localObject;
    if (super.SH())
    {
      localObject = this.b.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
      {
        AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
        amcs localamcs = new amcs();
        localObject = localamcs.a(localAIOPictureData, 4);
        if (localObject != null) {
          break label109;
        }
        localObject = localamcs.a(localAIOPictureData, 2);
      }
    }
    label109:
    for (;;)
    {
      if ((localObject == null) && (amcj.a().avz())) {
        return false;
      }
      return (!amcj.a().avz()) && (!amcj.a().avB());
    }
  }
  
  public AIOPictureData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100)) {
      return (AIOPictureData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    d(aqha.a(this.mContext, 230, this.mContext.getString(2131718936), this.mContext.getString(2131718935), new amec(this, paramInt, paramObject), new amed(this)));
  }
  
  public void a(amea.b paramb)
  {
    this.a = paramb;
  }
  
  public void a(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    this.d.setItemClickListenerV2(new amei(this, paramAIOPictureData, paramRichMediaBrowserInfo, paramFile));
    this.d.setCancelListener(new amej(this));
  }
  
  public boolean avK()
  {
    if ((this.mContext.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (amcj.a().IB() == 3) || (amcj.a().IB() == 2) || (amcj.a().IB() == 6)) {}
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
    Object localObject = this.b.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (((AIOPictureData)localObject).status == 2)
      {
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).msgId, ((AIOPictureData)localObject).subId, 4);
        }
        this.b.P(((AIOPictureData)localObject).msgId, ((AIOPictureData)localObject).subId, 0);
      }
    }
    return super.back();
  }
  
  public void buildComplete()
  {
    super.buildComplete();
    a(new ameb(this));
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    paramIntent = paramIntent.getExtras();
    this.biK = paramIntent.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.bWP = paramIntent.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.biJ = paramIntent.getBoolean("group.emo.big.preview", false);
    this.biI = paramIntent.getBoolean("extra.OCR", false);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  void ceJ()
  {
    Object localObject1 = this.b.getSelectedItem();
    Object localObject2;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
      amcs localamcs = new amcs();
      localObject2 = localamcs.a(localAIOPictureData, 4);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localamcs.a(localAIOPictureData, 2);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localamcs.a(localAIOPictureData, 1);
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
  
  public void clearTheOuchCache()
  {
    this.b.mActiveDrawable.clear();
    if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
      this.mRawDrawable.cancelDownload(true);
    }
    this.mRawDrawable = null;
    this.mRawDrawablePosition = -1;
  }
  
  public void d(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.mContext != null) && (!this.mContext.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  public void dMS()
  {
    Object localObject = this.b.getSelectedItem();
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      this.b.P(((AIOPictureData)localObject).msgId, ((AIOPictureData)localObject).subId, 2);
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(((AIOPictureData)localObject).msgId, ((AIOPictureData)localObject).subId, 4);
      updateUI();
    }
  }
  
  public void fG(long paramLong)
  {
    super.fG(paramLong);
    AIOPictureData localAIOPictureData = a();
    if ((localAIOPictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      int i = RichMediaBrowserManager.getInstance().getProvider().getSaveFileProgress(localAIOPictureData.msgId, localAIOPictureData.subId);
      if ((i < 0) || (i >= 100)) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "onRevokeMsg isSaving:" + bool);
      if (bool) {
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(localAIOPictureData.msgId, localAIOPictureData.subId, 24);
      }
      return;
    }
  }
  
  @RequiresApi(api=4)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GalleryUrlImageView localGalleryUrlImageView;
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof amea.a)))
    {
      this.galleryView = ((RelativeLayout)paramView);
      localGalleryUrlImageView = ((amea.a)paramView.getTag()).urlImageView;
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
      this.galleryView.addView(localGalleryUrlImageView, paramView);
    }
    AIOPictureData localAIOPictureData;
    Object localObject2;
    if (localRichMediaBrowserInfo.baseData.getType() == 100)
    {
      localAIOPictureData = (AIOPictureData)localRichMediaBrowserInfo.baseData;
      localObject2 = new amcs();
      paramView = this.b.a();
      if ((paramView != null) && ((paramView.baseData instanceof AIOPictureData)))
      {
        paramViewGroup = (AIOPictureData)paramView.baseData;
        if ((paramViewGroup.getType() != 100) || (paramViewGroup.msgId != localAIOPictureData.msgId) || (paramViewGroup.subId != localAIOPictureData.subId) || (paramView.isReport)) {
          break label800;
        }
        anot.a(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
        paramView.isReport = true;
      }
    }
    boolean bool2;
    boolean bool1;
    Object localObject1;
    for (;;)
    {
      localGalleryUrlImageView.setPosition(paramInt);
      localGalleryUrlImageView.setImageInfo(localRichMediaBrowserInfo);
      localGalleryUrlImageView.setIgnoreLayout(false);
      localGalleryUrlImageView.setContentDescription(this.mContext.getString(2131692611));
      bool2 = false;
      bool1 = false;
      localObject1 = null;
      paramView = null;
      paramViewGroup = (URLDrawable)this.b.mActiveDrawable.get(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1))
      {
        localGalleryUrlImageView.setImageDrawable(paramViewGroup);
        paramView = ((amcs)localObject2).a(localAIOPictureData, 4);
        localObject1 = paramViewGroup.getURL().toString();
        if (((String)localObject1).equals(paramView)) {
          localGalleryUrlImageView.setOriginalImage(true);
        }
        if (localRichMediaBrowserInfo.orientation == -2) {}
        try
        {
          localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramViewGroup.getURL().getFile());
          paramView = this.b;
          amda.updateRotation(this.galleryView, paramViewGroup, localRichMediaBrowserInfo.orientation);
          if (localGalleryUrlImageView.isOriginalImage())
          {
            paramView = localAIOPictureData.aVY;
            paramView = aqhq.estimateFileType(paramView);
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): cache url is " + (String)localObject1 + ", cache type is " + ((amcs)localObject2).a(localAIOPictureData, paramViewGroup.getURL().getFile()) + ",extName = + " + paramView);
            if ((localAIOPictureData.bjc) && (RichMediaBrowserManager.getInstance().getProvider() != null)) {
              RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOPictureData.msgId, localAIOPictureData.subId, 2);
            }
            bool1 = true;
            if (!localGalleryUrlImageView.isOriginalImage()) {
              break label892;
            }
            paramView = "original";
            paramInt = 1;
            if (paramInt != 0)
            {
              paramInt = localRichMediaBrowserInfo.hashCode();
              this.b.Uo(paramInt);
              paramViewGroup = this.b.a();
              paramViewGroup.Uc(paramInt);
              paramViewGroup.j(paramInt, localAIOPictureData.width, localAIOPictureData.height);
              paramViewGroup.bP(paramInt, avfp.ns(localAIOPictureData.mImageType));
              if (localAIOPictureData.bjd) {
                paramViewGroup.Ue(paramInt);
              }
              if (paramView != null)
              {
                paramViewGroup.dE(paramInt, paramView);
                paramViewGroup.bO(paramInt, bool1);
              }
            }
            paramView = localAIOPictureData.msgId + "_" + localAIOPictureData.subId;
            if ((!this.qJ.contains(paramView)) && (RichMediaBrowserManager.getInstance().getProvider() != null))
            {
              RichMediaBrowserManager.getInstance().getProvider().payFlow(localAIOPictureData.msgId, localAIOPictureData.subId);
              this.qJ.add(paramView);
            }
            paramView = new amea.a();
            paramView.urlImageView = localGalleryUrlImageView;
            this.galleryView.setTag(paramView);
            return this.galleryView;
            label800:
            anot.a(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + paramView.getMessage());
            localRichMediaBrowserInfo.orientation = 0;
            continue;
            paramView = localAIOPictureData.aVX;
            continue;
            label892:
            paramView = "large";
          }
        }
      }
    }
    Object localObject3 = ((amcs)localObject2).a(localAIOPictureData, 4);
    int i;
    if (localObject3 != null)
    {
      if (localObject3 != null)
      {
        i = 1;
        label922:
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mRequestWidth = this.mScreenWidthPx;
        paramViewGroup.mRequestHeight = this.mScreenHeightPx;
        if (((amcs)localObject2).a(localAIOPictureData, 1) == null) {
          break label1175;
        }
        paramView = URLDrawable.getFileDrawable(localAIOPictureData.aVW, null);
        paramView.downloadImediatly();
        paramViewGroup.mLoadingDrawable = paramView;
        label972:
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "TYPE_ORIGINAL_IMAGE");
        paramViewGroup.mPlayGifImage = true;
        paramViewGroup.mUseExifOrientation = false;
        paramViewGroup.mDecodeFileStrategy = 2;
        if ((localAIOPictureData.EP == 1) && ((localAIOPictureData.bWU & 0x2) == 2)) {
          paramViewGroup.mUseAutoScaleParams = false;
        }
        paramView = null;
        localObject1 = ((amcs)localObject2).a(localAIOPictureData, 4);
      }
      try
      {
        paramViewGroup = URLDrawable.getDrawable((String)localObject1, paramViewGroup);
        paramView = paramViewGroup;
        paramViewGroup.setTag(Integer.valueOf(1));
        paramView = paramViewGroup;
      }
      catch (Throwable paramViewGroup)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
          continue;
          bool1 = false;
          continue;
          paramView = "large";
        }
      }
      paramViewGroup = ((File)localObject3).getAbsolutePath();
      localGalleryUrlImageView.setGalleryImageListener(new amef(this, localRichMediaBrowserInfo, paramViewGroup, paramView, localAIOPictureData, localGalleryUrlImageView));
      this.hu = wja.a(this.Di, paramView);
      if ((this.hu == null) && (paramView.getStatus() == 1)) {
        a(localRichMediaBrowserInfo, paramViewGroup, paramView, paramInt);
      }
      localGalleryUrlImageView.setImageDrawable(paramView);
      if (!paramView.isDownloadStarted()) {
        break label1917;
      }
      if (BaseApplicationImpl.sImageCache.get(paramView.getURL().toString()) != null)
      {
        bool1 = true;
        if (i == 0) {
          break label1212;
        }
        paramView = "original";
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramInt = 1;
        break;
        i = 0;
        break label922;
        label1175:
        paramViewGroup.mLoadingDrawable = aoop.TRANSPARENT;
        break label972;
        label1212:
        File localFile = ((amcs)localObject2).a(localAIOPictureData, 2);
        if (localFile != null)
        {
          if (localObject3 != null)
          {
            i = 1;
            label1242:
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.mScreenWidthPx;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.mScreenHeightPx;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aoop.TRANSPARENT;
            ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
            ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
            ((URLDrawable.URLDrawableOptions)localObject3).mDecodeFileStrategy = 2;
            if ((localAIOPictureData.EP == 1) && ((localAIOPictureData.bWU & 0x2) == 2)) {
              ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
            }
            paramViewGroup = null;
            if (i == 0) {
              break label1507;
            }
            paramView = ((amcs)localObject2).a(localAIOPictureData, 4);
          }
          try
          {
            paramView = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject3);
            paramViewGroup = paramView;
            paramView.setTag(Integer.valueOf(1));
            paramViewGroup = paramView;
            paramView.downloadImediatly();
            paramViewGroup = paramView;
            paramView = (View)localObject1;
            bool1 = bool2;
            if (paramViewGroup != null)
            {
              paramView = (View)localObject1;
              bool1 = bool2;
              if (paramViewGroup.isDownloadStarted())
              {
                if (BaseApplicationImpl.sImageCache.get(paramViewGroup.getURL().toString()) == null) {
                  break label1574;
                }
                bool1 = true;
                if (i == 0) {
                  break label1580;
                }
                paramView = "original";
              }
            }
            if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1)) {
              if (localRichMediaBrowserInfo.orientation != -2) {}
            }
          }
          catch (Throwable paramView)
          {
            for (;;)
            {
              try
              {
                localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(localFile.getAbsolutePath());
                this.b.mActiveDrawable.put(Integer.valueOf(paramInt), paramViewGroup);
                localObject1 = this.b;
                amda.updateRotation(this.galleryView, paramViewGroup, localRichMediaBrowserInfo.orientation);
                localGalleryUrlImageView.setImageDrawable(paramViewGroup);
                this.b.onLoadFinish(paramInt, true);
                paramInt = 1;
                break;
                i = 0;
                break label1242;
                label1507:
                localObject2 = ((amcs)localObject2).a(localAIOPictureData, 2);
                paramView = (View)localObject2;
                if (!localAIOPictureData.bjc) {
                  continue;
                }
                paramView = (String)localObject2 + "#PART";
                continue;
                paramView = paramView;
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
                continue;
                label1574:
                bool1 = false;
                continue;
                label1580:
                paramView = "large";
              }
              catch (Exception localException)
              {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + localException.getMessage());
                localRichMediaBrowserInfo.orientation = 1;
                continue;
              }
              if ((!a(localAIOPictureData, localGalleryUrlImageView)) && (!b(localAIOPictureData, localGalleryUrlImageView)) && (!c(localAIOPictureData, localGalleryUrlImageView))) {
                a(localGalleryUrlImageView);
              }
              Q(localAIOPictureData.msgId, localAIOPictureData.subId, 2);
            }
          }
        }
      }
      if (((amcs)localObject2).a(localAIOPictureData, 8) != null)
      {
        if ((!a(localAIOPictureData, localGalleryUrlImageView)) && (!b(localAIOPictureData, localGalleryUrlImageView)) && (!c(localAIOPictureData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        Q(localAIOPictureData.msgId, localAIOPictureData.subId, 2);
        paramInt = 1;
        break;
      }
      if (((amcs)localObject2).a(localAIOPictureData, 1) != null)
      {
        if ((!b(localAIOPictureData, localGalleryUrlImageView)) && (!c(localAIOPictureData, localGalleryUrlImageView))) {
          a(localGalleryUrlImageView);
        }
        Q(localAIOPictureData.msgId, localAIOPictureData.subId, 2);
        paramInt = 1;
        break;
      }
      if ((localAIOPictureData.bin) || (localAIOPictureData.bim) || (localAIOPictureData.bio))
      {
        if (c(localAIOPictureData, localGalleryUrlImageView)) {
          break label1912;
        }
        a(localGalleryUrlImageView);
        paramInt = 0;
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): No pic");
      a(localGalleryUrlImageView);
      Q(localAIOPictureData.msgId, localAIOPictureData.subId, 2);
      label1912:
      paramInt = 0;
      break;
      label1917:
      paramView = null;
      bool1 = false;
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
      this.kh = ((LinearLayout)this.contentView.findViewById(2131364216));
      this.mTextView = ((TextView)this.contentView.findViewById(2131364217));
      this.kh.setOnClickListener(this);
      this.kh.setVisibility(8);
      this.eM.setOnClickListener(this);
      this.aD = ((ImageButton)this.contentView.findViewById(2131374885));
      this.aD.setOnClickListener(this);
      this.al = ((ImageButton)this.contentView.findViewById(2131374889));
      this.al.setOnClickListener(this);
      this.an = ((ImageButton)this.contentView.findViewById(2131374887));
      this.an.setOnClickListener(this);
      this.Kk = ((TextView)this.contentView.findViewById(2131374892));
      this.Kk.setOnClickListener(this);
      this.k = ((ImageButton)this.contentView.findViewById(2131374888));
      this.k.setOnClickListener(this);
      if (ayxa.isLiuHaiUseValid())
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
        localLayoutParams.addRule(10, -1);
        localLayoutParams.topMargin = ayxa.sNotchHeight;
      }
      OQ(c(this.b.getSelectedItem()));
      OT(avK());
      OP(SH());
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void notifyImageModelDataChanged()
  {
    super.notifyImageModelDataChanged();
    clearTheOuchCache();
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
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) && (((AIOPictureData)((RichMediaBrowserInfo)localObject).baseData).EP == 3))
      {
        this.b.back();
        continue;
        dMW();
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
        dMV();
        continue;
        if ((this.mContext instanceof AIOGalleryActivity))
        {
          localObject = (AIOGalleryActivity)this.mContext;
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (!aczy.bd(this.mContext)) {
              ((AIOGalleryActivity)localObject).requestPermissions(new ameg(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
            } else {
              dMX();
            }
          }
          else {
            dMX();
          }
        }
        else
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "onClick, activity:" + this.mContext);
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    clearTheOuchCache();
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
    while ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
      return null;
    }
    AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
    amcs localamcs = new amcs();
    localObject = localamcs.a(localAIOPictureData, 4);
    if (localObject == null)
    {
      paramRichMediaBrowserInfo = localamcs.a(localAIOPictureData, 2);
      if (paramRichMediaBrowserInfo == null) {}
    }
    for (;;)
    {
      int i;
      if (localObject != null)
      {
        i = 1;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
        if ((localAIOPictureData.EP == 1) && ((localAIOPictureData.bWU & 0x2) == 2)) {
          ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        }
        if ((i != 0) || (!localAIOPictureData.bjc)) {
          break label261;
        }
      }
      label261:
      for (paramRichMediaBrowserInfo = URLDrawable.getDrawable(localamcs.a(localAIOPictureData, 2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject);; paramRichMediaBrowserInfo = URLDrawable.getDrawable(paramRichMediaBrowserInfo, (URLDrawable.URLDrawableOptions)localObject))
      {
        paramRichMediaBrowserInfo.setTag(Integer.valueOf(1));
        paramRichMediaBrowserInfo.startDownload();
        this.b.mActiveDrawable.put(Integer.valueOf(paramInt), paramRichMediaBrowserInfo);
        return null;
        i = 0;
        break;
      }
      if ((localAIOPictureData.bin) || (localAIOPictureData.bim) || (localAIOPictureData.bio)) {
        break;
      }
      if (localamcs.a(localAIOPictureData, 1) != null)
      {
        paramRichMediaBrowserInfo = URLDrawable.URLDrawableOptions.obtain();
        paramRichMediaBrowserInfo.mLoadingDrawable = aoop.TRANSPARENT;
        paramRichMediaBrowserInfo.mFailedDrawable = aoop.TRANSPARENT;
        if ((localAIOPictureData.EP == 1) && ((localAIOPictureData.bWU & 0x2) == 2)) {
          paramRichMediaBrowserInfo.mUseAutoScaleParams = false;
        }
        URLDrawable.getDrawable(localamcs.a(localAIOPictureData, 1), paramRichMediaBrowserInfo).startDownload();
        if ((!aqiw.isWifiConnected(this.mContext)) || (avfp.ns(localAIOPictureData.mImageType)) || (RichMediaBrowserManager.getInstance().getProvider() == null)) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOPictureData.msgId, localAIOPictureData.subId, 2);
        return null;
      }
      if ((!aqiw.isWifiConnected(this.mContext)) || (avfp.ns(localAIOPictureData.mImageType)) || (RichMediaBrowserManager.getInstance().getProvider() == null)) {
        break;
      }
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOPictureData.msgId, localAIOPictureData.subId, 2);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
      return null;
      paramRichMediaBrowserInfo = (RichMediaBrowserInfo)localObject;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    clearTheOuchCache();
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.b.mActiveDrawable.get(Integer.valueOf(paramInt));
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.b.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
    if (paramInt == this.mRawDrawablePosition)
    {
      if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
        this.mRawDrawable.cancelDownload(true);
      }
      this.mRawDrawable = null;
      this.mRawDrawablePosition = -1;
    }
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
    OY(false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if ((paramView != null) && ((paramView.getTag() instanceof amea.a)))
    {
      paramAdapterView = (amea.a)paramView.getTag();
      if (paramAdapterView.urlImageView != null)
      {
        paramView = paramAdapterView.urlImageView;
        paramAdapterView = paramView.getDrawable();
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
        if ((!paramView.isOriginalImage()) && (localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100))
        {
          paramView = (AIOPictureData)localRichMediaBrowserInfo.baseData;
          if (((paramAdapterView instanceof SkinnableBitmapDrawable)) && (paramView.istroop == 1) && (paramView.size > agmx.fL()) && (this.b.getGallery() != null))
          {
            this.b.getGallery().enableDoubleTap(false);
            this.b.getGallery().enableScaleGesture(false);
          }
        }
      }
      updateUI();
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof amea.a)))
    {
      paramView = ((amea.a)paramView.getTag()).urlImageView.getDrawable();
      if (URLDrawable.class.isInstance(paramView)) {}
    }
    else
    {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (paramInt == this.mRawDrawablePosition)
    {
      if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
        this.mRawDrawable.cancelDownload(true);
      }
      this.mRawDrawable = null;
      this.mRawDrawablePosition = -1;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "destory rawDrawable, position: " + paramInt);
    }
    if ((paramView != null) && ((paramView.getTag() instanceof amea.a)))
    {
      paramView = ((amea.a)paramView.getTag()).urlImageView.getDrawable();
      if ((paramRichMediaBrowserInfo != null) && ((paramView instanceof URLDrawable)) && (this.b.a() != null)) {
        this.b.a().exit(paramRichMediaBrowserInfo.hashCode());
      }
    }
    if (this.b.a() != null) {
      this.b.a().exit();
    }
  }
  
  public void onscaleBegin(int paramInt, Drawable paramDrawable, URLDrawable paramURLDrawable, GalleryUrlImageView paramGalleryUrlImageView)
  {
    if (((paramDrawable instanceof URLDrawable)) && (((URLDrawable)paramDrawable).isFakeSize()) && (paramURLDrawable == null))
    {
      paramDrawable = ((URLDrawable)paramDrawable).getURL();
      if (("file".equals(paramDrawable.getProtocol())) && (paramDrawable.getRef() == null))
      {
        if ((paramInt != this.mRawDrawablePosition) || (this.mRawDrawable == null)) {
          break label113;
        }
        paramDrawable = this.mRawDrawable;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "use exist raw drawable");
      }
    }
    while (paramDrawable.getStatus() == 1)
    {
      paramGalleryUrlImageView.setIgnoreLayout(true);
      paramGalleryUrlImageView.setImageDrawable(paramDrawable);
      paramGalleryUrlImageView.setIgnoreLayout(false);
      return;
      label113:
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "rawDrawable is exist");
      paramDrawable = paramDrawable.toString() + "#" + "NOSAMPLE";
      paramURLDrawable = URLDrawable.URLDrawableOptions.obtain();
      paramURLDrawable.mUseExifOrientation = false;
      paramURLDrawable.mUseMemoryCache = false;
      paramDrawable = URLDrawable.getDrawable(paramDrawable, paramURLDrawable);
      paramDrawable.setTag(Integer.valueOf(2));
      this.mRawDrawable = paramDrawable;
      this.mRawDrawablePosition = paramInt;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "create rawDrawable, position:" + paramInt);
    }
    paramGalleryUrlImageView.setDecodingDrawble(paramDrawable);
    paramDrawable.startDownload();
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof amea.a)))
    {
      paramView = ((amea.a)paramView.getTag()).urlImageView;
      paramViewGroup = paramView.getDrawable();
      URLDrawable localURLDrawable = paramView.mDecoding;
      if (((paramViewGroup instanceof URLDrawable)) && (((URLDrawable)paramViewGroup).isFakeSize()) && (localURLDrawable == null)) {
        onscaleBegin(paramInt, paramViewGroup, localURLDrawable, paramView);
      }
    }
  }
  
  public void showActionSheet(int paramInt)
  {
    super.showActionSheet(paramInt);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100))
    {
      a((AIOPictureData)localRichMediaBrowserInfo.baseData, localRichMediaBrowserInfo);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "showActionSheet, from:" + paramInt);
    }
  }
  
  public void updateCache(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.b.mActiveDrawable.get(Integer.valueOf(paramInt)) != null) {
      this.b.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
  }
  
  public void updateUI()
  {
    super.updateUI();
    AIOPictureData localAIOPictureData = a();
    if (localAIOPictureData != null) {}
    switch (localAIOPictureData.status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "updateUI status is error, status = " + localAIOPictureData.status);
      return;
    case 1: 
      OS(false);
      OP(false);
      OT(false);
      this.b.onLoadStart(this.b.getSelectedIndex(), localAIOPictureData.progress);
      return;
    case 2: 
      this.b.onLoadFinish(this.b.getSelectedIndex(), true);
      OS(false);
      OP(false);
      OQ(false);
      OT(false);
      this.s.setProgress(localAIOPictureData.progress / 100);
      this.bN.setText(acfp.m(2131702213) + localAIOPictureData.progress / 100 + "%");
      this.lM.setVisibility(0);
      return;
    case 3: 
      this.b.onLoadFinish(this.b.getSelectedIndex(), true);
      OS(false);
      OP(false);
      OQ(false);
      OT(false);
      this.s.setProgress(localAIOPictureData.progress / 100);
      this.bN.setText(acfp.m(2131702197) + localAIOPictureData.progress / 100 + "%");
      this.lM.setVisibility(0);
      return;
    }
    this.b.onLoadFinish(this.b.getSelectedIndex(), true);
    this.lM.setVisibility(8);
    OP(SH());
    OQ(c(this.b.getSelectedItem()));
    OT(avK());
    OY(true);
    amcs localamcs = new amcs();
    if ((localamcs.a(localAIOPictureData, 2) != null) || (localamcs.a(localAIOPictureData, 4) != null)) {
      OU(true);
    }
    while ((localamcs.a(localAIOPictureData, 4)) && (localamcs.a(localAIOPictureData, 4) == null))
    {
      OS(true);
      return;
      OU(false);
    }
    OS(false);
  }
  
  public void updateView(int paramInt, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getItem(paramInt);
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject1;
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100) && (this.galleryView != null) && ((this.galleryView.getTag() instanceof amea.a)))
    {
      localObject3 = ((amea.a)this.galleryView.getTag()).urlImageView;
      localObject2 = (AIOPictureData)localRichMediaBrowserInfo.baseData;
      localObject4 = new amcs();
      if (!((AIOPictureData)localObject2).bim) {
        break label213;
      }
      localObject1 = ((GalleryUrlImageView)localObject3).getDrawable();
      if (!URLDrawable.class.isInstance(localObject1)) {
        break label727;
      }
      localObject1 = (URLDrawable)localObject1;
      localObject2 = ((URLDrawable)localObject1).getURL().getRef();
    }
    for (;;)
    {
      if ((localObject1 == null) || (localObject2 == null) || ((!"PART".equals(localObject2)) && (!"DISPLAY".equals(localObject2))))
      {
        ((GalleryUrlImageView)localObject3).setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
        this.b.onLoadFinish(paramInt, false);
        this.b.a().pG();
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      return;
      label213:
      File localFile = ((amcs)localObject4).a((AIOPictureData)localObject2, 2);
      if (localFile != null)
      {
        localObject1 = ((amcs)localObject4).a((AIOPictureData)localObject2, 2);
        if (!paramBoolean) {
          break label724;
        }
        localObject1 = (String)localObject1 + "#PART";
      }
      label724:
      for (;;)
      {
        try
        {
          localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(localFile.getAbsolutePath());
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): read orientation:" + localRichMediaBrowserInfo.orientation);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          if (((AIOPictureData)localObject2).EP == 3)
          {
            localObject4 = ((amcs)localObject4).a((AIOPictureData)localObject2, 1);
            if (localObject4 != null)
            {
              localObject4 = URLDrawable.getDrawable((File)localObject4, null);
              if (((URLDrawable)localObject4).getStatus() == 1)
              {
                localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
                localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
              }
            }
          }
          localURLDrawableOptions.mUseExifOrientation = false;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject4 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
          ((URLDrawable)localObject4).setTag(Integer.valueOf(1));
          if ((((URLDrawable)localObject4).getStatus() == 1) && (!((AIOPictureData)localObject2).bjc)) {
            if (localRichMediaBrowserInfo.orientation != -2) {}
          }
        }
        catch (Exception localException2)
        {
          try
          {
            localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(localFile.getAbsolutePath());
            ((GalleryUrlImageView)localObject3).setImageDrawable((Drawable)localObject4);
            this.b.onLoadFinish(paramInt, true);
            localObject3 = this.b;
            amda.updateRotation(this.galleryView, (URLDrawable)localObject4, localRichMediaBrowserInfo.orientation);
            localObject3 = aqhq.estimateFileType(((AIOPictureData)localObject2).aVX);
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + (String)localObject1 + ",extName = " + (String)localObject3);
            ((AIOPictureData)localObject2).bjc = paramBoolean;
            this.b.a().dLE();
            return;
            localException2 = localException2;
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + localException2.getMessage());
          }
          catch (Exception localException1)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + localException1.getMessage());
            localRichMediaBrowserInfo.orientation = 1;
            continue;
          }
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "setDecodingDrawble");
          ((URLDrawable)localObject4).setTag(Integer.valueOf(1));
          ((URLDrawable)localObject4).startDownload();
          ((GalleryUrlImageView)localObject3).setDecodingDrawble((URLDrawable)localObject4);
          continue;
        }
        if (((amcs)localObject4).a((AIOPictureData)localObject2, 1) == null) {
          break;
        }
        ((GalleryUrlImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(((amcs)localObject4).a((AIOPictureData)localObject2, 1), URLDrawable.URLDrawableOptions.obtain()));
        return;
      }
      label727:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public class a
    extends IBrowserViewHolder
  {
    public GalleryUrlImageView urlImageView;
    
    public a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amea
 * JD-Core Version:    0.7.0.1
 */