package dov.com.qq.im.aeeditor.module.edit;

import acfp;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import aoll;
import aolm;
import aomi;
import aqgw;
import aqhq;
import aqiw;
import axic;
import axim;
import axip;
import axir;
import axiy;
import axiz;
import axjj.b.a;
import axjj.b.b;
import axjm;
import axjp;
import axjp.a;
import axki;
import axkj;
import axkn;
import axko;
import axkq;
import axkr;
import axks;
import axls;
import axlu;
import axlv;
import axlw;
import axlx;
import axly;
import axlz;
import axma;
import axmb;
import axmr;
import axmw;
import axmz;
import axnk;
import axnl;
import axnm;
import axnw;
import axnw.a;
import axof;
import ayva;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.ImageExportConfig;
import com.tencent.tavcut.exporter.ImageExporter;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.FaceInfo;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageInfo;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageStylizeRequest;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageStylizeResponse;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.a;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.b;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar.a;
import dov.com.qq.im.aeeditor.module.toolbar.ImageEditToolBar.a;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import dov.com.qq.im.aeeditor.view.NumberIndicator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class AEEditorImageEditFragment
  extends AEEditorCommonEditFragment
  implements Handler.Callback, ViewPager.OnPageChangeListener, AEEditorFilterControlPanel.b, ImageEditToolBar.a
{
  private static final String TAG = AEEditorImageEditFragment.class.getSimpleName();
  private ArrayList<String> FK = new ArrayList();
  private ArrayList<String> FL;
  private List<axjm> MQ = new ArrayList();
  private axki jdField_a_of_type_Axki = new axki();
  private axmz jdField_a_of_type_Axmz = new axmz();
  private axnk jdField_a_of_type_Axnk = axnl.a();
  private ImageExporter jdField_a_of_type_ComTencentTavcutExporterImageExporter;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private AEEditorImagePagerAdapter jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter;
  private AEEditorImageViewPager jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager;
  private NumberIndicator jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
  private long aCm;
  private long aCn;
  axjp.a b = new axlz(this);
  axjp.a c = new axma(this);
  private boolean cSH;
  private String cVp = "";
  private boolean dvl;
  private boolean dvm;
  private boolean dvn;
  private int eFP;
  private int eFW;
  private SparseArray<axkq> ei = new SparseArray();
  private aoll i;
  private List<String> imagePaths = new ArrayList();
  private HashMap<String, ArrayList<String>> ri = new HashMap();
  
  private String HW()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e(TAG, 1, "app is null");
      return "";
    }
    String str = localAppRuntime.getAccount();
    return ((TicketManager)localAppRuntime.getManager(2)).getPskey(str, "shadowai.qq.com");
  }
  
  private int Re()
  {
    return this.jdField_a_of_type_Axnk.Rl();
  }
  
  private String a(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    Object localObject = new AEImageStylizeReqData.ImageStylizeResponse();
    try
    {
      ((AEImageStylizeReqData.ImageStylizeResponse)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        try
        {
          int j = ((AEImageStylizeReqData.ImageStylizeResponse)localObject).code.get();
          axiy.i(TAG, "comics response: code=" + j + ", msg=" + ((AEImageStylizeReqData.ImageStylizeResponse)localObject).msg.get());
          axim.a().l(1000, paramLong + "", "lut_comics", j);
          if (!((AEImageStylizeReqData.ImageStylizeResponse)localObject).imageRawData.has()) {
            break label207;
          }
          paramArrayOfByte = ((AEImageStylizeReqData.ImageStylizeResponse)localObject).imageRawData.get().toByteArray();
          paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
          localObject = axjj.b.a.cVd + File.separator + paramInt + "_comicResult.jpg";
          FileUtil.createFile((String)localObject);
          BitmapUtil.saveBitmap(paramArrayOfByte, 100, (String)localObject);
          BitmapUtils.recycle(paramArrayOfByte);
          return localObject;
        }
        catch (Exception paramArrayOfByte)
        {
          axiy.e(TAG, paramArrayOfByte.toString());
        }
        paramArrayOfByte = paramArrayOfByte;
        paramArrayOfByte.printStackTrace();
      }
    }
    label207:
    return "";
  }
  
  private void a(int paramInt, axkq paramaxkq)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.6(this, paramInt, paramaxkq));
  }
  
  private Bitmap ab(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    float f = 1.0F;
    if (k > j) {
      if (k > 736) {
        f = 736.0F / k;
      }
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f, f);
      return Bitmap.createBitmap(paramBitmap, 0, 0, j, k, localMatrix, true);
      if (j > 736) {
        f = 736.0F / j;
      }
    }
  }
  
  private void aek(int paramInt)
  {
    axiy.i(TAG, "updateImageFilterByIndex: " + paramInt);
    if ((this.jdField_a_of_type_Axmz.lJ(paramInt) == 0) && (this.jdField_a_of_type_Axmz.lI(paramInt) == 0))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.render(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Axmz.oo(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setAEKitAIFilter(paramInt, this.jdField_a_of_type_Axmz.a(paramInt).getLutPath(), this.jdField_a_of_type_Axmz.a(paramInt).getLutStrengt(), this.jdField_a_of_type_Axmz.a(paramInt).getAdjustParam(), (int)(this.jdField_a_of_type_Axmz.a(paramInt).getSmoothLevel() * 100.0F), this.jdField_a_of_type_Axmz.a(paramInt).getGlowStrength());
      return;
    }
    if (this.jdField_a_of_type_Axmz.op(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, this.jdField_a_of_type_Axmz.a(paramInt).HT());
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(paramInt, this.jdField_a_of_type_Axmz.gT(paramInt));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(paramInt, this.jdField_a_of_type_Axmz.A(paramInt));
  }
  
  private void ael(int paramInt)
  {
    if (paramInt >= 1) {
      aek(paramInt - 1);
    }
    if (paramInt < getImageCount() - 1) {
      aek(paramInt + 1);
    }
  }
  
  private boolean cY()
  {
    if (this.imagePaths == null) {
      return false;
    }
    Iterator localIterator = this.imagePaths.iterator();
    while (localIterator.hasNext()) {
      if (!new File((String)localIterator.next()).exists()) {
        return false;
      }
    }
    return true;
  }
  
  private Bitmap cropBitmap(String paramString, CropConfig paramCropConfig)
  {
    m = 1;
    k = 0;
    try
    {
      localObject = BitmapUtil.getImageSize(paramString, false);
      Size localSize = Util.constrainMaxSize((Size)localObject, this.jdField_a_of_type_Axnk.getMaxImageDecodeSize());
      n = ((Size)localObject).getWidth() / localSize.getWidth();
      if (((Size)localObject).getWidth() % localSize.getWidth() != 0) {
        break label358;
      }
      j = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        Logger.e(paramString);
        return null;
        j = 270;
        continue;
        j = 180;
        continue;
        j = 90;
      }
    }
    catch (Error paramString)
    {
      for (;;)
      {
        int n;
        Logger.e(paramString);
        continue;
        continue;
        for (;;)
        {
          j += n;
          if (j > 0) {
            break label340;
          }
          j = m;
          break;
          j = 1;
        }
        int j = k;
      }
    }
    localObject = BitmapUtil.decodeBitmap(paramString, j);
    if (!isValidBitmap((Bitmap)localObject)) {
      return null;
    }
    j = k;
    switch (new ExifInterface(paramString).getAttributeInt("Orientation", 1))
    {
    case 4: 
    case 5: 
    case 7: 
      paramString = new Matrix();
      paramString.postRotate(j);
      paramString = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
      localObject = Bitmap.createBitmap((int)(paramString.getWidth() * paramCropConfig.getWidth()), (int)(paramString.getHeight() * paramCropConfig.getHeight()), paramString.getConfig());
      new Canvas((Bitmap)localObject).drawBitmap(paramString, new Rect((int)(paramString.getWidth() * paramCropConfig.getX()), (int)(paramString.getHeight() * paramCropConfig.getY()), (int)(paramString.getWidth() * (paramCropConfig.getX() + paramCropConfig.getWidth())), (int)(paramString.getHeight() * (paramCropConfig.getY() + paramCropConfig.getHeight()))), new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new Paint());
      return localObject;
    }
  }
  
  private HashMap<String, LocalMediaInfo> d(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      LocalMediaInfo localLocalMediaInfo = axof.e(str);
      if (this.ri != null) {
        localLocalMediaInfo.aiTextLabel = ((ArrayList)this.ri.get(str));
      }
      localHashMap.put(str, localLocalMediaInfo);
    }
    return localHashMap;
  }
  
  private byte[] e(Bitmap paramBitmap)
  {
    boolean bool = false;
    Object localObject2 = new ByteArrayOutputStream();
    axiy.i(TAG, "before: " + System.currentTimeMillis());
    Object localObject1 = ab(paramBitmap);
    BitmapUtils.recycle(paramBitmap);
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
    axiy.i(TAG, "after: " + System.currentTimeMillis());
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    paramBitmap = new AEImageStylizeReqData.ImageStylizeRequest();
    paramBitmap.stylizeType.set(1, true);
    paramBitmap.imgInfo.setHasFlag(true);
    paramBitmap.imgInfo.imgWidth.set(((Bitmap)localObject1).getWidth());
    paramBitmap.imgInfo.imgHeight.set(((Bitmap)localObject1).getHeight());
    paramBitmap.imgInfo.imageRawData.set(ByteStringMicro.copyFrom((byte[])localObject2), true);
    localObject2 = axic.b((Bitmap)localObject1);
    BitmapUtils.recycle((Bitmap)localObject1);
    if ((localObject2 == null) || (((PTFaceAttr)localObject2).getAllFacePoints() == null) || (((PTFaceAttr)localObject2).getAllFacePoints().isEmpty())) {
      paramBitmap.imgInfo.hasFace.set(false);
    }
    for (;;)
    {
      paramBitmap.setHasFlag(true);
      return paramBitmap.toByteArray();
      localObject1 = ((PTFaceAttr)localObject2).getAllFacePoints().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          AEImageStylizeReqData.FaceInfo localFaceInfo = new AEImageStylizeReqData.FaceInfo();
          localFaceInfo.setHasFlag(true);
          j = 0;
          while (j < ((List)localObject2).size())
          {
            localFaceInfo.pos.add(Float.valueOf(((PointF)((List)localObject2).get(j)).x));
            localFaceInfo.pos.add(Float.valueOf(((PointF)((List)localObject2).get(j)).y));
            j += 1;
          }
          paramBitmap.imgInfo.faceInfos.add(localFaceInfo);
        }
      }
      int j = paramBitmap.imgInfo.faceInfos.size();
      localObject1 = paramBitmap.imgInfo.hasFace;
      if (j > 0) {
        bool = true;
      }
      ((PBBoolField)localObject1).set(bool);
      paramBitmap.imgInfo.faceNum.set(j);
    }
  }
  
  private void eMA()
  {
    AEEditorApplyAllLoadingView localAEEditorApplyAllLoadingView = new AEEditorApplyAllLoadingView(getActivity());
    this.cD.addView(localAEEditorApplyAllLoadingView);
  }
  
  private void eMv()
  {
    axiy.i(TAG, "showImages");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = new AEEditorImagePagerAdapter(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.imagePaths, this.MQ, new axls(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setTotalCount(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.getCount());
    NumberIndicator localNumberIndicator = this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.getCount() > 0) {}
    for (int j = 1;; j = 0)
    {
      localNumberIndicator.setCurrentIndex(j);
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter);
      return;
    }
  }
  
  private void eMw()
  {
    if (!TextUtils.isEmpty(HW()))
    {
      axiy.i(TAG, "psKey not empty.");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    axlw localaxlw = new axlw(this);
    localTicketManager.GetPskey((String)localObject, 16L, new String[] { "shadowai.qq.com" }, localaxlw);
  }
  
  private void eMx()
  {
    axiy.i(TAG, "initTAVCutSession");
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = new TAVCutImageSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setMinIntermediateRenderSize(this.jdField_a_of_type_Axnk.Rj());
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Axnk.Rk());
    localSessionConfig.setMaxImageDecodeSize(this.jdField_a_of_type_Axnk.getMaxImageDecodeSize());
    Object localObject = new StickerEditViewIconConfig();
    ((StickerEditViewIconConfig)localObject).setDeleteIconResId(2130837975);
    ((StickerEditViewIconConfig)localObject).setEditIconResId(2130837973);
    ((StickerEditViewIconConfig)localObject).setZoomIconResId(2130837976);
    localSessionConfig.setStickerEditViewIconConfig((StickerEditViewIconConfig)localObject);
    localObject = new ArrayList();
    int j = 0;
    while (j < this.MQ.size())
    {
      ((List)localObject).add(((axjm)this.MQ.get(j)).cropConfig);
      j += 1;
    }
    localSessionConfig.setImageInitCropConfigs((List)localObject);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setImagePaths(this.imagePaths);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setStickerOperationCallback(new axlx(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.init(getActivity());
  }
  
  private void eMy()
  {
    if ((!this.dvm) && (!TextUtils.isEmpty(this.cVo)) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null) && (this.dvn))
    {
      this.dvm = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.ade(this.cVo);
    }
  }
  
  private int getImageCount()
  {
    return this.imagePaths.size();
  }
  
  private static boolean isValidBitmap(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private void jw(View paramView)
  {
    axiy.i(TAG, "initViews");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager = ((AEEditorImageViewPager)paramView.findViewById(2131381929));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator = ((NumberIndicator)paramView.findViewById(2131372581));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnPageChangeListener(this);
  }
  
  private void k(Bitmap paramBitmap, int paramInt)
  {
    aoll localaoll = new aoll();
    localaoll.f = new axly(this, paramInt);
    localaoll.bZ = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/ImageStylize";
    localaoll.mHttpMethod = 1;
    localaoll.mExcuteTimeLimit = 30000L;
    localaoll.X = e(paramBitmap);
    localaoll.dPo = 0;
    localaoll.u.put("Content-Type", "application/proto; charset=UTF-8");
    localaoll.u.put("Accept", "application/proto");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      QLog.e(TAG, 1, "app is null");
      return;
    }
    paramBitmap = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    String str = paramBitmap.getSkey((String)localObject);
    paramBitmap = paramBitmap.getPskey((String)localObject, "shadowai.qq.com");
    if (!TextUtils.isEmpty(paramBitmap)) {
      localaoll.u.put("Cookie", "uin=" + (String)localObject + ";pskey=" + paramBitmap);
    }
    for (;;)
    {
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      getActivity().getAppInterface().getNetEngine(0).a(localaoll);
      this.i = localaoll;
      return;
      eMw();
      localaoll.u.put("Cookie", "uin=" + (String)localObject + ";skey=" + str);
    }
  }
  
  public String HV()
  {
    return acfp.m(2131689956);
  }
  
  protected int Rd()
  {
    return 0;
  }
  
  protected axmw a()
  {
    return new axlv(this);
  }
  
  protected axnw.a a()
  {
    return new axmb(this);
  }
  
  protected AEEditorFilterControlPanel.a a()
  {
    return this;
  }
  
  protected AEEditorToolBar.a a()
  {
    return this;
  }
  
  public void a(int paramInt, String paramString, float paramFloat, AEEditorFilterBean paramAEEditorFilterBean)
  {
    eMs();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(true);
    if (aOT()) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.Yz(true);
    }
    float f = this.jdField_a_of_type_Axmz.c(this.eFP, paramInt, paramFloat);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f);
    this.jdField_a_of_type_Axmz.a(this.eFP, paramString, f, paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(this.eFP);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(this.eFP, paramString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(this.eFP, f);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(this.eFP, null);
    axip.a().a().rd.put(Integer.valueOf(this.eFP), paramAEEditorFilterBean.getSid());
    axip.a().a().re.put(Integer.valueOf(this.eFP), Float.valueOf(paramFloat));
  }
  
  public boolean aOM()
  {
    if (!this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.mediaChanged()) {
      return false;
    }
    return super.aOM();
  }
  
  protected boolean aOT()
  {
    return this.imagePaths.size() > 1;
  }
  
  protected boolean aOU()
  {
    return true;
  }
  
  public boolean aOV()
  {
    Object localObject = this.jdField_a_of_type_Axki.a((String)this.imagePaths.get(this.eFP));
    boolean bool;
    if ((localObject != null) && ((localObject instanceof axks)))
    {
      axiy.i(TAG, "onAIFilterRequest: has cache");
      bool = ((axks)localObject).bGa;
      axiy.i(TAG, "onAIFilterRequest: needRequest=" + bool);
      if (!bool) {
        break label155;
      }
      eMp();
      localObject = new axkr((String)this.imagePaths.get(this.eFP), this.MQ, this.eFP);
      ((axkr)localObject).a(this.b);
      axjp.a().a(getActivity().getAppInterface(), getActivity(), (axkj)localObject);
    }
    for (;;)
    {
      if (bool) {
        break label282;
      }
      return true;
      bool = true;
      break;
      label155:
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.select(1);
      if (aOT()) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.Yz(true);
      }
      this.jdField_a_of_type_Axmz.b(this.eFP, (axkn)localObject);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(this.eFP, null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setAEKitAIFilter(this.eFP, ((axkn)localObject).getLutPath(), ((axkn)localObject).getLutStrengt(), ((axkn)localObject).getAdjustParam(), (int)(((axkn)localObject).getSmoothLevel() * 100.0F), ((axkn)localObject).getGlowStrength());
      aO(new String[] { "智能滤镜label", ((axkn)localObject).getSceneLabel(), "智能滤镜errCode", "0" });
    }
    label282:
    return false;
  }
  
  public boolean aOW()
  {
    int j = this.eFP;
    axkq localaxkq = (axkq)this.ei.get(j);
    if (localaxkq == null)
    {
      if (!aqiw.isNetworkAvailable())
      {
        QQToast.a(getActivity(), getActivity().getResources().getString(2131691488), 1).show();
        return false;
      }
      this.dvl = false;
      eMq();
      axic.a(new AEEditorImageEditFragment.4(this, j), false, "GLThread-changeFaceSingle");
      return false;
    }
    a(j, localaxkq);
    return true;
  }
  
  protected void applyCurrentSticker()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.eFP);
    }
  }
  
  public void eMB()
  {
    eMs();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(false);
    if (aOT()) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.Yz(true);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(this.eFP);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(this.eFP, null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(this.eFP, null);
    this.jdField_a_of_type_Axmz.aeo(this.eFP);
    if (this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.getVisibility() != 0) {
      this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
    }
  }
  
  public void eMC()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(4);
  }
  
  public void eMD()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
  }
  
  public void eME() {}
  
  public void eMF()
  {
    this.jdField_a_of_type_Axnw.a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.eFP);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.coy();
  }
  
  protected void eMl()
  {
    axiy.i(TAG, "initImageInfos");
    Object localObject1 = new ArrayList();
    Object localObject2 = getArguments();
    if (((Bundle)localObject2).containsKey("AEEditorConstants_CLIPPED_PIC_INFOS")) {
      localObject1 = (List)((Bundle)localObject2).getSerializable("AEEditorConstants_CLIPPED_PIC_INFOS");
    }
    for (;;)
    {
      this.MQ = new ArrayList();
      this.imagePaths = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EditorPicInfo)((Iterator)localObject1).next();
        CropConfig localCropConfig = new CropConfig((float)((EditorPicInfo)localObject2).x, (float)((EditorPicInfo)localObject2).y, (float)((EditorPicInfo)localObject2).w, (float)((EditorPicInfo)localObject2).h);
        this.imagePaths.add(((EditorPicInfo)localObject2).picPath);
        this.MQ.add(new axjm(((EditorPicInfo)localObject2).picPath, (int)((EditorPicInfo)localObject2).originPicWidth, (int)((EditorPicInfo)localObject2).originPicHeight, localCropConfig));
      }
      axiy.e(TAG, "no image crop infos");
    }
    this.eFW = Re();
    this.jdField_a_of_type_Axmz.init(this.imagePaths.size());
    this.cSH = axiz.aOK();
  }
  
  protected void eMm()
  {
    axjp.a().eLJ();
  }
  
  protected void eMn()
  {
    this.dvl = true;
  }
  
  public void eMo()
  {
    axiy.i(TAG, "exportImages");
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession == null)
    {
      axiy.e(TAG, "exportImages error: session is null");
      return;
    }
    if (!cY())
    {
      QQToast.a(getActivity(), "图片不存在或被删除", 0).show();
      return;
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.10(this));
    Object localObject1 = axjj.b.b.cVf;
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    if (this.FL != null)
    {
      this.FL.clear();
      this.FL = null;
    }
    for (this.FL = new ArrayList();; this.FL = new ArrayList())
    {
      int j = 0;
      while (j < this.imagePaths.size())
      {
        localObject2 = new File((String)this.imagePaths.get(j));
        localObject2 = (String)localObject1 + File.separator + "output_" + j + "_" + System.currentTimeMillis() + "_" + ayva.getFileNameWithoutExtension(((File)localObject2).getName()) + ".jpg";
        this.FL.add(localObject2);
        if (this.ri != null)
        {
          ArrayList localArrayList = (ArrayList)this.ri.get(String.valueOf(j));
          if (localArrayList != null)
          {
            this.ri.remove(String.valueOf(j));
            this.ri.put(localObject2, localArrayList);
          }
        }
        j += 1;
      }
    }
    localObject1 = new ImageExportConfig();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.eFP);
    if (this.eFW == 0) {
      this.eFW = Re();
    }
    ((ImageExportConfig)localObject1).setMaxExportSize(Re());
    ((ImageExportConfig)localObject1).setMaxIntermediateRenderSize(Re());
    ((ImageExportConfig)localObject1).setQuality(this.jdField_a_of_type_Axnk.Rm());
    ((ImageExportConfig)localObject1).setOutputPath(this.FL);
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getExporter((ImageExportConfig)localObject1);
    this.FK.clear();
    this.aCm = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter.export(new axlu(this));
  }
  
  protected void eMr()
  {
    this.dvn = true;
    eMy();
  }
  
  public void eMz()
  {
    int k = 0;
    axiy.i(TAG, "onApplyAll current position = " + this.eFP);
    axim.a().eKL();
    Object localObject1;
    Object localObject2;
    int j;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.aOX())
    {
      localObject1 = this.imagePaths.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = this.jdField_a_of_type_Axki.a((String)localObject2);
          if ((localObject2 != null) && ((localObject2 instanceof axks)))
          {
            axiy.i(TAG, "onAIFilterRequest: has cache");
            if (!((axkn)localObject2).bGa) {
              continue;
            }
            j = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        eMp();
        localObject1 = new axko(this.imagePaths, this.MQ, this.eFP, this.jdField_a_of_type_Axki.a((String)this.imagePaths.get(this.eFP)));
        ((axko)localObject1).a(this.c);
        axjp.a().a(getActivity().getAppInterface(), getActivity(), (axkj)localObject1);
      }
      do
      {
        return;
        j = 1;
        break;
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(false);
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.select(1);
        localObject1 = new StringBuilder();
        j = k;
        while (j < getImageCount())
        {
          localObject2 = (axks)this.jdField_a_of_type_Axki.a((String)this.imagePaths.get(j));
          this.jdField_a_of_type_Axmz.b(j, (axkn)localObject2);
          ((StringBuilder)localObject1).append(((axks)localObject2).getSceneLabel() + "|");
          j += 1;
        }
        jQ("智能滤镜label", ((StringBuilder)localObject1).toString());
        aek(this.eFP);
        ael(this.eFP);
        eMA();
        return;
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.aOY())
        {
          this.jdField_a_of_type_Axmz.eMT();
          ael(this.eFP);
          eMA();
          return;
        }
      } while (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.aOZ());
      this.jdField_a_of_type_Axmz.aen(this.eFP);
      ael(this.eFP);
      eMA();
      return;
      j = 0;
    }
  }
  
  public int getLayoutResourceId()
  {
    return 2131558611;
  }
  
  public String getModuleId()
  {
    return "AEEditorImageEdit";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    axiy.i(TAG, "onCreate");
    super.onCreate(paramBundle);
    eMw();
  }
  
  public void onDestroy()
  {
    axiy.i(TAG, "onDestroy");
    super.onDestroy();
    aqhq.delete(axjj.b.a.cVd, false);
  }
  
  public void onDestroyView()
  {
    axiy.i(TAG, "onDestroyView");
    super.onDestroyView();
    if (this.i != null) {
      getActivity().getAppInterface().getNetEngine(0).b(this.i);
    }
    this.eFP = 0;
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.eMG();
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = null;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = null;
    }
    this.jdField_a_of_type_Axmz.reset();
    this.imagePaths.clear();
    this.MQ.clear();
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.eFP);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    boolean bool = true;
    axiy.i(TAG, "onPageSelected: " + paramInt);
    this.eFP = paramInt;
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setCurrentIndex(this.eFP);
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setCurrentIndex(paramInt + 1);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.select(this.jdField_a_of_type_Axmz.lI(this.eFP));
    AEEditorFilterControlPanel localAEEditorFilterControlPanel;
    if ((this.jdField_a_of_type_Axmz.on(this.eFP)) || (this.jdField_a_of_type_Axmz.oo(this.eFP)) || (this.jdField_a_of_type_Axmz.op(this.eFP)))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(false);
      if (aOT())
      {
        localAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel;
        if (this.jdField_a_of_type_Axmz.op(this.eFP)) {
          break label183;
        }
      }
    }
    for (;;)
    {
      localAEEditorFilterControlPanel.Yz(bool);
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(true);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(this.jdField_a_of_type_Axmz.A(this.eFP));
      break;
      label183:
      bool = false;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    axiy.i(TAG, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    axiy.i(TAG, "init");
    this.e = new aqgw(Looper.getMainLooper(), this);
    eMx();
    eMy();
    this.jdField_a_of_type_Axmz.reset();
    jw(paramView);
    eMv();
    if ((TextUtils.isEmpty(this.cVo)) && (aOu()))
    {
      if (!axmr.a().aPa()) {
        break label228;
      }
      axiy.i(TAG, "single image + first time : aifilter auto request");
      aOV();
      eMu();
    }
    for (;;)
    {
      aO(new String[] { "设备级别", axnm.Ic(), "图片最小预览尺寸", String.valueOf(this.jdField_a_of_type_Axnk.Rj()), "图片最大预览尺寸", String.valueOf(this.jdField_a_of_type_Axnk.Rk()), "图片导出质量", this.jdField_a_of_type_Axnk.Rm() + "%", "图片最大导出尺寸", String.valueOf(this.eFW) });
      return;
      label228:
      axiy.e(TAG, "single image + first time : aifilter res not ready, do not request");
    }
  }
  
  public void v(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(this.eFP, paramFloat);
    this.jdField_a_of_type_Axmz.w(this.eFP, paramFloat);
    this.jdField_a_of_type_Axmz.f(this.eFP, paramInt, paramFloat);
    axip.a().a().re.put(Integer.valueOf(this.eFP), Float.valueOf(paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment
 * JD-Core Version:    0.7.0.1
 */