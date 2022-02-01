package dov.com.qq.im.ae.play;

import aczy;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arht;
import aurs;
import awtn;
import awtn.d.a;
import awtn.d.b;
import axhi;
import axhj;
import axhk;
import axhl;
import axhm;
import axhn;
import axho;
import axhp;
import axhq;
import axic;
import axid;
import axih;
import axih.a;
import axij;
import axim;
import axiw;
import axiy;
import azbq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import rox;
import vnk;
import wja;

public class AEVideoShelfEditFragment
  extends PublicBaseFragment
  implements View.OnClickListener, EditTextViewer.a, EditTextViewer.b, FaceImageViewer.a, ScaleMoveImageViewer.a, vnk
{
  private static double dq = 0.3D;
  private static int eES = 200;
  private static PowerManager.WakeLock wakeLock;
  private ArrayList<String> FI;
  private View MD;
  private View ME;
  private RecyclerView N;
  private axih.a jdField_a_of_type_Axih$a = new axhl(this);
  private axih jdField_a_of_type_Axih;
  private VideoShelfEngine jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine;
  private VideoShelfTemplate jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate;
  private long aBQ;
  private long aBR;
  private int aVc;
  private TextView ahf;
  private SparseIntArray am = new SparseIntArray();
  arht b;
  private HashSet<ScaleMoveImageViewer> bX = new HashSet();
  private HashSet<EditTextViewer> bY = new HashSet();
  private HashSet<FaceImageViewer> bZ = new HashSet();
  private Boolean bb = Boolean.valueOf(false);
  private final String cUA = "1";
  private final String cUB = "2";
  private String cUi;
  private String cUr;
  private String cUs;
  private String cUw;
  private String cUx;
  private String cUy;
  private final String cUz = "0";
  private int eET;
  private int eEU;
  private int eEV;
  private int eEW;
  private List<Bitmap> eL = new ArrayList();
  private Dialog g;
  private RelativeLayout gt;
  private String mAudioPath;
  private Bitmap mBackgroundBitmap;
  private ImageView mBackgroundImageView;
  private Dialog mDialog;
  private List<NodeGroup> mNodeGroupList = new ArrayList();
  private double mProgress;
  private Timer mTimer = new Timer();
  private Map<String, Bitmap> qJ = new HashMap();
  
  private void A(int paramInt, String paramString, boolean paramBoolean)
  {
    this.eEW = paramInt;
    FaceImageViewer localFaceImageViewer = a(this.eEW);
    if (localFaceImageViewer == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        Bitmap localBitmap2 = (Bitmap)this.qJ.get(paramString);
        localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          localBitmap1 = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
          this.qJ.put(paramString, localBitmap1);
        }
      } while (!BitmapUtils.isLegal(localBitmap1));
      Bitmap localBitmap1 = axij.b(localBitmap1, paramString);
      paramString = localBitmap1;
      if (localBitmap1.getWidth() == 1)
      {
        paramString = localBitmap1;
        if (localBitmap1.getHeight() == 1) {
          paramString = BitmapUtils.scaleBitmap(localBitmap1, 2.0F, true);
        }
      }
      localFaceImageViewer.setNodeBitmap(paramString);
      localFaceImageViewer.setImageBitmap(paramString);
      localFaceImageViewer.setImageSelected(true);
      localFaceImageViewer.setMovable(true);
      localFaceImageViewer.setScaleType(ImageView.ScaleType.MATRIX);
      localFaceImageViewer.eKw();
      axic.a(new AEVideoShelfEditFragment.9(this, localFaceImageViewer, paramString), false, "");
    } while (!paramBoolean);
    adQ(localFaceImageViewer.getNodeGroupID());
  }
  
  private void B(int paramInt, String paramString, boolean paramBoolean)
  {
    ScaleMoveImageViewer localScaleMoveImageViewer = a(paramInt);
    if (localScaleMoveImageViewer == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        Bitmap localBitmap2 = (Bitmap)this.qJ.get(paramString);
        localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          localBitmap1 = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
          this.qJ.put(paramString, localBitmap1);
        }
      } while (!BitmapUtils.isLegal(localBitmap1));
      Bitmap localBitmap1 = axij.b(localBitmap1, paramString);
      paramString = localBitmap1;
      if (localBitmap1.getWidth() == 1)
      {
        paramString = localBitmap1;
        if (localBitmap1.getHeight() == 1) {
          paramString = BitmapUtils.scaleBitmap(localBitmap1, 2.0F, true);
        }
      }
      localScaleMoveImageViewer.setNodeBitmap(paramString);
      localScaleMoveImageViewer.setImageBitmap(paramString);
      localScaleMoveImageViewer.setImageSelected(true);
      localScaleMoveImageViewer.setMovable(true);
      localScaleMoveImageViewer.eKw();
    } while (!paramBoolean);
    adQ(localScaleMoveImageViewer.getNodeGroupID());
  }
  
  private void Yj(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Log.i("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      axiy.i("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.cUy == null)) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("from", true);
      localIntent.putExtra("MaterialId", this.cUi);
      localIntent.putExtra("FinalVideoPath", this.cUy);
      localIntent.putExtra("usePagPreview", paramBoolean);
      localIntent.putExtra("MaterialPath", this.cUx);
      localIntent.putExtra("MaterialName", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoName());
      localIntent.putStringArrayListExtra("PhotoList", this.FI);
      localIntent.putExtra("loc_play_show_tab_name", this.cUr);
      localIntent.putExtra("loc_play_show_material_id", this.cUi);
      localIntent.putExtra("loc_play_show_take_same_name", this.cUs);
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.bI(getActivity()));
      localIntent.putExtra("isNeedEditButton", true);
      ev(localIntent);
      this.bb = Boolean.valueOf(false);
      return;
    }
    eKg();
  }
  
  private static Bitmap a(RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2)
  {
    if (paramRelativeLayout == null) {
      return null;
    }
    paramRelativeLayout.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramRelativeLayout.draw(new Canvas(localBitmap));
    paramRelativeLayout = Bitmap.createScaledBitmap(localBitmap, paramInt1 / 4, paramInt2 / 4, false);
    localBitmap.recycle();
    return paramRelativeLayout;
  }
  
  private arht a()
  {
    arht localarht = new arht(getActivity());
    localarht.YE(wja.dp2px(50.0F, getActivity().getResources()));
    localarht.setDrawImageFillView(true);
    localarht.setShowStroke(false);
    localarht.setTextColor(-1);
    localarht.setBackgroundColor(0);
    localarht.setProgressColor(-15550475);
    localarht.setProgressStrokeWidth(3);
    localarht.dbf = true;
    localarht.mAnimationStep = 2;
    localarht.TM(true);
    localarht.a(new axhm(this));
    return localarht;
  }
  
  private NodeItem a(NodeGroup paramNodeGroup, int paramInt)
  {
    paramNodeGroup = paramNodeGroup.nodeItemList.iterator();
    while (paramNodeGroup.hasNext())
    {
      NodeItem localNodeItem = (NodeItem)paramNodeGroup.next();
      if (paramInt == localNodeItem.nodeID) {
        return localNodeItem;
      }
    }
    return null;
  }
  
  private FaceImageViewer a(int paramInt)
  {
    Iterator localIterator = this.bZ.iterator();
    while (localIterator.hasNext())
    {
      FaceImageViewer localFaceImageViewer = (FaceImageViewer)localIterator.next();
      if (localFaceImageViewer.getNodeID() == paramInt) {
        return localFaceImageViewer;
      }
    }
    return null;
  }
  
  private ScaleMoveImageViewer a(int paramInt)
  {
    Iterator localIterator = this.bX.iterator();
    while (localIterator.hasNext())
    {
      ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)localIterator.next();
      if (localScaleMoveImageViewer.getNodeID() == paramInt) {
        return localScaleMoveImageViewer;
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString1);
    localIntent.putExtra("MaterialId", paramString2);
    localIntent.putExtra("MaterialName", paramString3);
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt2);
    PublicFragmentActivity.b.startForResult(paramActivity, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class, paramInt1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, int paramInt, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString2);
    localIntent.putExtra("MaterialId", paramString3);
    localIntent.putExtra("MaterialName", paramString4);
    localIntent.putExtra("loc_play_show_tab_name", paramString1);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.bI(paramContext));
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt);
    localIntent.putExtra("loc_play_show_take_same_name", paramString5);
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class);
  }
  
  private void a(NodeGroup paramNodeGroup)
  {
    if ((this.mBackgroundBitmap != null) && (!this.mBackgroundBitmap.isRecycled())) {
      this.mBackgroundBitmap.recycle();
    }
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return;
    }
    paramNodeGroup = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath() + File.separator + paramNodeGroup.nodeDefaultMaskCoverImage;
    this.mBackgroundBitmap = axij.b(BitmapUtils.decodeSampleBitmap(getActivity(), paramNodeGroup, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()), paramNodeGroup);
    this.mBackgroundImageView.setImageBitmap(this.mBackgroundBitmap);
  }
  
  private void a(FaceImageViewer paramFaceImageViewer, Bitmap paramBitmap)
  {
    paramBitmap = axic.detectFace(paramBitmap, 0.1666666666666667D);
    int i = paramBitmap.getFaceCount();
    Object localObject1 = new ArrayList();
    paramBitmap = paramBitmap.getFaceInfoList().iterator();
    Object localObject2;
    while (paramBitmap.hasNext())
    {
      localObject2 = (FaceInfo)paramBitmap.next();
      CosFunUtil.scale(((FaceInfo)localObject2).points, 1.0D / 0.1666666666666667D);
      FaceOffUtil.getFullCoords(((FaceInfo)localObject2).points, 1.5F);
      Object localObject3 = (PointF)((FaceInfo)localObject2).points.get(99);
      PointF localPointF = (PointF)((FaceInfo)localObject2).points.get(103);
      localObject3 = new axid((int)((PointF)localObject3).x, (int)((PointF)localObject3).y, (int)localPointF.x, (int)localPointF.y);
      ((axid)localObject3).angles = ((FaceInfo)localObject2).angles;
      ((List)localObject1).add(localObject3);
    }
    axiy.d("AEVideoShelfEditFrag", "[PlayShow] onFaceImageChanged faceCount = " + i);
    if (i >= 1)
    {
      paramBitmap = (axid)((List)localObject1).get(0);
      localObject2 = ((List)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (axid)((Iterator)localObject2).next();
        if (((axid)localObject1).getArea() <= paramBitmap.getArea()) {
          break label285;
        }
        paramBitmap = (Bitmap)localObject1;
      }
    }
    label285:
    for (;;)
    {
      break;
      aurs.runOnUiThread(new AEVideoShelfEditFragment.10(this, paramFaceImageViewer, paramBitmap));
      return;
      aurs.runOnUiThread(new AEVideoShelfEditFragment.11(this));
      return;
    }
  }
  
  private void a(FaceImageViewer paramFaceImageViewer, axid paramaxid)
  {
    float f1 = 1.0F;
    float f5 = paramFaceImageViewer.getWidth();
    float f6 = paramFaceImageViewer.getHeight();
    float f2 = (float)Math.toDegrees(paramaxid.angles[2]);
    float f3 = f5 / 2.0F;
    float f4 = (paramaxid.mFace.left + paramaxid.mFace.right) / 2;
    f6 /= 2.0F;
    float f7 = (paramaxid.mFace.top + paramaxid.mFace.bottom) / 2;
    float f8 = paramaxid.mFace.width();
    if (f8 > 0.0F) {
      f1 = f5 / f8;
    }
    paramFaceImageViewer.g(f1, f2 * 1.0F, f3 - f4, f6 - f7);
  }
  
  private boolean aOD()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFileName() != null) && (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath() != null) && (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoType() == 1) && (!OfflineConfig.isNotSuptPagRealTime())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean aOE()
  {
    Object localObject4 = null;
    int k = 0;
    Iterator localIterator = this.bX.iterator();
    Object localObject2 = null;
    int j = 0;
    Object localObject3;
    Object localObject1;
    int i;
    if (localIterator.hasNext())
    {
      localObject3 = (ScaleMoveImageViewer)localIterator.next();
      localObject1 = localObject2;
      i = j;
      if (!((ScaleMoveImageViewer)localObject3).aOF())
      {
        if (localObject2 != null) {
          break label90;
        }
        localObject1 = localObject3;
        i = 1;
      }
    }
    label192:
    for (;;)
    {
      localObject2 = localObject1;
      j = i;
      if (i != 0) {
        break;
      }
      ((ScaleMoveImageViewer)localObject3).eKu();
      localObject2 = localObject1;
      j = i;
      break;
      label90:
      if (localObject2.getNodeGroupID() > ((ScaleMoveImageViewer)localObject3).getNodeGroupID())
      {
        localObject1 = localObject3;
        i = 1;
        continue;
        localIterator = this.bZ.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (FaceImageViewer)localIterator.next();
          localObject1 = localObject4;
          i = k;
          if (!((FaceImageViewer)localObject3).aOF())
          {
            if (localObject4 != null) {
              break label192;
            }
            localObject1 = localObject3;
            i = 1;
          }
        }
        for (;;)
        {
          localObject4 = localObject1;
          k = i;
          if (i != 0) {
            break;
          }
          ((FaceImageViewer)localObject3).eKu();
          localObject4 = localObject1;
          k = i;
          break;
          if (localObject4.getNodeGroupID() > ((FaceImageViewer)localObject3).getNodeGroupID())
          {
            localObject1 = localObject3;
            i = 1;
            continue;
            if ((j != 0) && (localObject2 != null)) {}
            for (i = Math.max(localObject2.getNodeGroupID(), -1);; i = -1)
            {
              if ((k != 0) && (localObject4 != null)) {
                Math.max(localObject4.getNodeGroupID(), i);
              }
              return true;
            }
          }
          else
          {
            i = 1;
            localObject1 = localObject4;
          }
        }
      }
      else
      {
        i = 1;
        localObject1 = localObject2;
      }
    }
  }
  
  private Bitmap aU()
  {
    Bitmap localBitmap2;
    if ((this.eET > 0) && (this.aVc > 0))
    {
      localBitmap2 = Bitmap.createBitmap(this.eET, this.aVc, Bitmap.Config.ARGB_8888);
      if (!BitmapUtils.isLegal(localBitmap2))
      {
        Log.e("AEVideoShelfEditFrag", "CenterView bitmap is null");
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap2);
      localBitmap1 = localBitmap2;
      if (this.gt != null) {
        this.gt.draw(localCanvas);
      }
    }
    for (Bitmap localBitmap1 = localBitmap2;; localBitmap1 = null) {
      return localBitmap1;
    }
  }
  
  public static void ad(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(536870918, AEVideoShelfEditFragment.class.getSimpleName());
      wakeLock.acquire();
      axiy.i("AEVideoShelfEditFrag", "keepScreenOn!");
      return;
    }
    if (wakeLock != null)
    {
      wakeLock.release();
      wakeLock = null;
    }
    axiy.i("AEVideoShelfEditFrag", "keepScreenOff!");
  }
  
  private void adP(int paramInt)
  {
    NodeGroup localNodeGroup = (NodeGroup)this.mNodeGroupList.get(paramInt);
    this.gt.removeAllViews();
    Iterator localIterator = this.bX.iterator();
    paramInt = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (ScaleMoveImageViewer)localIterator.next();
      if ((((ScaleMoveImageViewer)localObject).getNodeGroupID() != localNodeGroup.nodeGroupID) || (((ScaleMoveImageViewer)localObject).a().zIndex >= 10000)) {
        break label462;
      }
      this.gt.addView((View)localObject);
      paramInt = 1;
    }
    label462:
    for (;;)
    {
      break;
      localIterator = this.bY.iterator();
      while (localIterator.hasNext())
      {
        localObject = (EditTextViewer)localIterator.next();
        if ((((EditTextViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject).a().zIndex < 10000)) {
          this.gt.addView((View)localObject);
        }
      }
      localIterator = this.bZ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FaceImageViewer)localIterator.next();
        if ((((FaceImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).a().zIndex < 10000)) {
          this.gt.addView((View)localObject);
        }
      }
      a(localNodeGroup);
      this.gt.addView(this.mBackgroundImageView);
      localIterator = this.bX.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ScaleMoveImageViewer)localIterator.next();
        if ((((ScaleMoveImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject).a().zIndex >= 10000))
        {
          this.gt.addView((View)localObject);
          paramInt = 1;
        }
      }
      localIterator = this.bY.iterator();
      while (localIterator.hasNext())
      {
        localObject = (EditTextViewer)localIterator.next();
        if ((((EditTextViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject).a().zIndex >= 10000)) {
          this.gt.addView((View)localObject);
        }
      }
      localIterator = this.bZ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FaceImageViewer)localIterator.next();
        if ((((FaceImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).a().zIndex >= 10000)) {
          this.gt.addView((View)localObject);
        }
      }
      if (paramInt != 0)
      {
        this.ME.setVisibility(0);
        return;
      }
      this.ME.setVisibility(8);
      return;
    }
  }
  
  private void adQ(int paramInt)
  {
    this.N.postDelayed(new AEVideoShelfEditFragment.19(this, paramInt), 100L);
  }
  
  private void adR(int paramInt)
  {
    if (this.N != null)
    {
      axih localaxih = (axih)this.N.getAdapter();
      Bitmap localBitmap = aU();
      if ((localaxih != null) && (BitmapUtils.isLegal(localBitmap)))
      {
        localaxih.f(paramInt, localBitmap);
        localaxih.eKx();
      }
    }
  }
  
  /* Error */
  private String b(int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 556	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 866	dov/com/qq/im/ae/play/AEVideoShelfEditFragment:cUw	Ljava/lang/String;
    //   11: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: getstatic 569	java/io/File:separator	Ljava/lang/String;
    //   17: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 868
    //   23: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokestatic 874	java/lang/System:currentTimeMillis	()J
    //   29: invokevirtual 877	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: ldc_w 879
    //   35: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_1
    //   39: invokevirtual 677	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc_w 881
    //   45: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 575	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 4
    //   53: new 566	java/io/File
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 883	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 886	java/io/File:createNewFile	()Z
    //   67: pop
    //   68: new 888	java/io/FileOutputStream
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 891	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore_3
    //   77: aload_2
    //   78: getstatic 897	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload_3
    //   84: invokevirtual 901	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   87: pop
    //   88: aload_3
    //   89: invokevirtual 904	java/io/FileOutputStream:flush	()V
    //   92: aload_3
    //   93: invokevirtual 907	java/io/FileOutputStream:close	()V
    //   96: aload 4
    //   98: areturn
    //   99: astore 5
    //   101: ldc_w 295
    //   104: new 556	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 909
    //   114: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 5
    //   119: invokevirtual 910	java/io/IOException:toString	()Ljava/lang/String;
    //   122: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 575	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 913	axiy:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: goto -63 -> 68
    //   134: astore_3
    //   135: aload_3
    //   136: invokevirtual 916	java/io/FileNotFoundException:printStackTrace	()V
    //   139: ldc_w 295
    //   142: new 556	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 918
    //   152: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_3
    //   156: invokevirtual 919	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   159: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 575	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 913	axiy:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aconst_null
    //   169: astore_3
    //   170: goto -93 -> 77
    //   173: astore_2
    //   174: aload_2
    //   175: invokevirtual 920	java/lang/Exception:printStackTrace	()V
    //   178: ldc_w 295
    //   181: new 556	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 922
    //   191: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: invokevirtual 923	java/lang/Exception:toString	()Ljava/lang/String;
    //   198: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 575	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 913	axiy:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aconst_null
    //   208: areturn
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 924	java/io/IOException:printStackTrace	()V
    //   214: ldc_w 295
    //   217: new 556	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 926
    //   227: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_2
    //   231: invokevirtual 910	java/io/IOException:toString	()Ljava/lang/String;
    //   234: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 575	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 913	axiy:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -151 -> 92
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 924	java/io/IOException:printStackTrace	()V
    //   251: ldc_w 295
    //   254: new 556	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 928
    //   264: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 910	java/io/IOException:toString	()Ljava/lang/String;
    //   271: invokevirtual 564	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 575	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 913	axiy:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload 4
    //   282: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	AEVideoShelfEditFragment
    //   0	283	1	paramInt	int
    //   0	283	2	paramBitmap	Bitmap
    //   62	31	3	localObject1	Object
    //   134	22	3	localFileNotFoundException	java.io.FileNotFoundException
    //   169	1	3	localObject2	Object
    //   51	230	4	str	String
    //   99	19	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   63	68	99	java/io/IOException
    //   68	77	134	java/io/FileNotFoundException
    //   77	88	173	java/lang/Exception
    //   88	92	209	java/io/IOException
    //   92	96	246	java/io/IOException
  }
  
  private void b(ViewGroup paramViewGroup, int paramInt)
  {
    NodeGroup localNodeGroup = (NodeGroup)this.mNodeGroupList.get(paramInt);
    paramViewGroup.removeAllViews();
    Object localObject1 = this.bX.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ScaleMoveImageViewer)((Iterator)localObject1).next();
      if ((((ScaleMoveImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject2).a().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        d((ImageView)localObject2, this.eET, this.aVc);
      }
    }
    localObject1 = this.bY.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      if ((((EditTextViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject2).a().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        d((ImageView)localObject2, this.eET, this.aVc);
      }
    }
    localObject1 = this.bZ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FaceImageViewer)((Iterator)localObject1).next();
      if ((((FaceImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).a().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        d((ImageView)localObject2, this.eET, this.aVc);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath() + File.separator + localNodeGroup.nodeDefaultMaskCoverImage;
    localObject1 = axij.b(BitmapUtils.decodeSampleBitmap(getActivity(), (String)localObject1, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()), (String)localObject1);
    Object localObject2 = new ImageView(getActivity());
    ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
    paramViewGroup.addView((View)localObject2);
    int i;
    float f;
    if (localObject1 != null)
    {
      paramInt = ((Bitmap)localObject1).getWidth();
      i = ((Bitmap)localObject1).getHeight();
      f = paramInt / i;
      if (f >= this.eET / this.eET) {
        break label550;
      }
      i = this.eET;
      paramInt = (int)(this.eET / f);
    }
    for (;;)
    {
      ((ImageView)localObject2).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824));
      ((ImageView)localObject2).layout((this.eET - i) / 2, (this.aVc - paramInt) / 2, (i + this.eET) / 2, (paramInt + this.aVc) / 2);
      localObject1 = this.bX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ScaleMoveImageViewer)((Iterator)localObject1).next();
        if ((((ScaleMoveImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject2).a().zIndex >= 10000))
        {
          paramViewGroup.addView((View)localObject2);
          d((ImageView)localObject2, this.eET, this.aVc);
        }
      }
      label550:
      paramInt = this.aVc;
      i = (int)(this.aVc * f);
    }
    localObject1 = this.bY.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      if ((((EditTextViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject2).a().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        d((ImageView)localObject2, this.eET, this.aVc);
      }
    }
    localObject1 = this.bZ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FaceImageViewer)((Iterator)localObject1).next();
      if ((((FaceImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).a().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        d((ImageView)localObject2, this.eET, this.aVc);
      }
    }
  }
  
  private void b(RelativeLayout paramRelativeLayout, int paramInt)
  {
    if (this.N != null)
    {
      axih localaxih = (axih)this.N.getAdapter();
      paramRelativeLayout = a(paramRelativeLayout, paramRelativeLayout.getWidth(), paramRelativeLayout.getHeight());
      if ((localaxih != null) && (BitmapUtils.isLegal(paramRelativeLayout)))
      {
        localaxih.f(paramInt, paramRelativeLayout);
        localaxih.eKx();
      }
    }
  }
  
  static boolean bn(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return aczy.bd(paramContext);
  }
  
  public static int d(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  private void d(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    NodeItem localNodeItem = null;
    int i;
    int j;
    if ((paramImageView instanceof ScaleMoveImageViewer))
    {
      localNodeItem = ((ScaleMoveImageViewer)paramImageView).a();
      if (localNodeItem != null)
      {
        i = (int)(localNodeItem.maskRect.left * paramInt1);
        j = (int)(localNodeItem.maskRect.top * paramInt2);
        paramInt1 = (int)(localNodeItem.maskRect.right * paramInt1);
        paramInt2 = (int)(localNodeItem.maskRect.bottom * paramInt2);
        paramImageView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - j, 1073741824));
        paramImageView.layout(i, j, paramInt1, paramInt2);
        if (!(paramImageView instanceof ScaleMoveImageViewer)) {
          break label179;
        }
        ((ScaleMoveImageViewer)paramImageView).lv(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
      }
    }
    label179:
    do
    {
      return;
      if ((paramImageView instanceof FaceImageViewer))
      {
        localNodeItem = ((FaceImageViewer)paramImageView).a();
        break;
      }
      if (!(paramImageView instanceof EditTextViewer)) {
        break;
      }
      localNodeItem = ((EditTextViewer)paramImageView).a();
      break;
      if ((paramImageView instanceof FaceImageViewer))
      {
        ((FaceImageViewer)paramImageView).lv(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
        return;
      }
    } while (!(paramImageView instanceof EditTextViewer));
    ((EditTextViewer)paramImageView).lv(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
    paramInt1 = getResources().getDimensionPixelSize(2131296881);
    ((EditTextViewer)paramImageView).setActionBarHeight(paramInt1);
  }
  
  private void dismissProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
  }
  
  private void eH(int paramInt, String paramString)
  {
    B(paramInt, paramString, true);
  }
  
  private void eJU()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().size())
      {
        Object localObject1 = (MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(i);
        NodeGroup localNodeGroup = new NodeGroup();
        localNodeGroup.nodeCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupCoverImage();
        localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject1).getNodeGroupID();
        localNodeGroup.nodeDefaultMaskCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupMaskImage();
        localObject1 = ((MaskNodeGroup)localObject1).getNodeList();
        localNodeGroup.nodeItemList = new ArrayList();
        int j = 0;
        if (j < ((List)localObject1).size())
        {
          Object localObject2 = (MaskNodeItem)((List)localObject1).get(j);
          NodeItem localNodeItem = new NodeItem();
          localNodeItem.nodeID = ((MaskNodeItem)localObject2).getNodeID();
          Object localObject3 = ((MaskNodeItem)localObject2).getNodeDefaultMaskCoverImage();
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            if (((MaskNodeItem)localObject2).getType() == 1) {
              localNodeItem.coverURL = null;
            }
          }
          for (;;)
          {
            localObject3 = ((MaskNodeItem)localObject2).getMaskRect();
            localNodeItem.maskRect.set(localObject3[0], localObject3[1], localObject3[0] + localObject3[2], localObject3[1] + localObject3[3]);
            localNodeItem.once = true;
            localNodeItem.type = ((MaskNodeItem)localObject2).getType();
            localNodeItem.nodeGroupID = ((MaskNodeItem)localObject2).getNodeGroupID();
            localNodeItem.zIndex = ((MaskNodeItem)localObject2).getZIndex();
            localNodeItem.indexLayerForPag = ((MaskNodeItem)localObject2).getIndexLayerForPag();
            localNodeItem.nodeTextMaxCount = ((MaskNodeItem)localObject2).getNodeTextMaxCount();
            if (!TextUtils.isEmpty(localNodeItem.coverURL))
            {
              String str = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath() + File.separator + localNodeItem.coverURL;
              localNodeItem.bitmap = BitmapUtils.decodeSampleBitmap(getActivity(), str, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
              localNodeItem.bitmap = axij.b(localNodeItem.bitmap, str);
            }
            if (((MaskNodeItem)localObject2).getNodeTextGroup() != null)
            {
              localNodeItem.nodeTextGroup.copyFrom(((MaskNodeItem)localObject2).getNodeTextGroup());
              if (TextUtils.isEmpty(localNodeItem.nodeTextGroup.fmtstr))
              {
                localNodeItem.nodeTextGroup.fmtstr = "请输入文字";
                if ((localNodeItem.type == 1) && (localNodeItem.bitmap != null) && (!localNodeItem.bitmap.isRecycled()))
                {
                  localNodeItem.bitmap.recycle();
                  localNodeItem.bitmap = null;
                }
              }
              if ((TextUtils.isEmpty(localNodeItem.coverURL)) && (localNodeItem.type == 1) && (localNodeItem.bitmap != null) && (!localNodeItem.bitmap.isRecycled()))
              {
                localNodeItem.bitmap.recycle();
                localNodeItem.bitmap = null;
              }
              localNodeItem.nodeTextGroup.width = ((int)(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth() * localObject3[2]));
              localObject2 = localNodeItem.nodeTextGroup;
              float f = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight();
              ((NodeText)localObject2).height = ((int)(localObject3[3] * f));
              localNodeItem.nodeTextGroup.fontSize = (localNodeItem.nodeTextGroup.fontSize * this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth() / 720.0F);
            }
            this.eL.add(localNodeItem.bitmap);
            localNodeGroup.nodeItemList.add(localNodeItem);
            j += 1;
            break;
            localNodeItem.coverURL = localNodeGroup.nodeDefaultMaskCoverImage;
            continue;
            localNodeItem.coverURL = ((String)localObject3);
          }
        }
        this.mNodeGroupList.add(localNodeGroup);
        i += 1;
      }
    }
  }
  
  private void eKb()
  {
    Window localWindow = getActivity().getWindow();
    if (localWindow != null) {
      localWindow.setSoftInputMode(48);
    }
  }
  
  private void eKc()
  {
    if ((this.FI == null) || (this.FI.isEmpty())) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.FI.size())
      {
        String str = (String)this.FI.get(i);
        this.qJ.put(str, BitmapUtils.decodeSampleBitmap(getActivity(), str, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()));
        i += 1;
      }
    }
  }
  
  private void eKd()
  {
    this.mBackgroundImageView = new ImageView(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.mBackgroundImageView.setLayoutParams(localLayoutParams);
  }
  
  private void eKe()
  {
    this.am.clear();
    Iterator localIterator1 = this.mNodeGroupList.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
      while (localIterator2.hasNext())
      {
        NodeItem localNodeItem = (NodeItem)localIterator2.next();
        Object localObject;
        if (localNodeItem.type == 0)
        {
          localObject = new ScaleMoveImageViewer(getActivity());
          ((ScaleMoveImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new axho(this, (ScaleMoveImageViewer)localObject, localNodeItem));
          ((ScaleMoveImageViewer)localObject).setOnSaveScrollInfoListener(this);
          ((ScaleMoveImageViewer)localObject).setNodeInfo(localNodeItem);
          ((ScaleMoveImageViewer)localObject).setMovable(false);
          ((ScaleMoveImageViewer)localObject).setImageSelected(false);
          this.bX.add(localObject);
          if ((this.FI != null) && (i < this.FI.size()))
          {
            B(localNodeItem.nodeID, (String)this.FI.get(i), false);
            this.am.put(localNodeItem.nodeID, i);
            i += 1;
          }
        }
        else
        {
          if (localNodeItem.type == 1)
          {
            localObject = new EditTextViewer(getActivity());
            ((EditTextViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new axhp(this, (EditTextViewer)localObject, localNodeItem));
            ((EditTextViewer)localObject).setOnSaveTextInfoListener(this);
            ((EditTextViewer)localObject).setOnDownloadDialogListener(this);
            ((EditTextViewer)localObject).setNodeInfo(localNodeItem);
            if (localNodeItem.bitmap != null) {
              ((EditTextViewer)localObject).setImageBitmap(localNodeItem.bitmap);
            }
            for (;;)
            {
              ((EditTextViewer)localObject).setNodeBitmap(localNodeItem.bitmap);
              ((EditTextViewer)localObject).setTextSelected(true);
              ((EditTextViewer)localObject).setMaterialId(this.cUi);
              this.bY.add(localObject);
              break;
              Bitmap localBitmap = ((EditTextViewer)localObject).aV();
              if ((localBitmap != null) && (!localBitmap.isRecycled()))
              {
                ((EditTextViewer)localObject).setImageBitmap(localBitmap);
                localNodeItem.bitmap = localBitmap;
                ((EditTextViewer)localObject).setImageBitmap(localNodeItem.bitmap);
              }
            }
          }
          if (localNodeItem.type == 2)
          {
            localObject = new FaceImageViewer(getActivity());
            ((FaceImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new axhq(this, (FaceImageViewer)localObject, localNodeItem));
            ((FaceImageViewer)localObject).setOnSaveScrollInfoListener(this);
            ((FaceImageViewer)localObject).setNodeInfo(localNodeItem);
            ((FaceImageViewer)localObject).setMovable(false);
            ((FaceImageViewer)localObject).setImageSelected(false);
            this.bZ.add(localObject);
            if ((this.FI != null) && (i < this.FI.size()))
            {
              A(localNodeItem.nodeID, (String)this.FI.get(i), false);
              this.am.put(localNodeItem.nodeID, i);
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private void eKf()
  {
    Object localObject1 = new File(this.cUw);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).list();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          localObject2 = new File(this.cUw, (String)localObject2);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          i += 1;
        }
      }
    }
  }
  
  private void eKg()
  {
    Log.i("AEVideoShelfEditFrag", "未合成视频，将直接实时预览。");
    axiy.i("AEVideoShelfEditFrag", "未合成视频，将直接实时预览。");
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return;
    }
    new axhj(this).execute(new Void[0]);
  }
  
  private void eKh()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setVideoFrameItemList(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getFrameList());
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setNodeGroupItemList(this.mNodeGroupList);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setVideoTemplateType(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoTemplateType());
    String str = null;
    switch (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVersion())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setSrcPath(str);
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setOutputVideoPath(ShortVideoUtils.zL());
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setCallback(new a(this));
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setLutPath(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getFilterLutPath());
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getWatermarkRect() != null) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setWatermarkRect(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getWatermarkRect());
      }
      this.bb = Boolean.valueOf(true);
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.save(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
      return;
      str = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoPath();
      continue;
      str = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath();
    }
  }
  
  private void eKk()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null)) {
      return;
    }
    this.cUy = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath();
    this.mAudioPath = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getAudioPath();
    Object localObject1 = new File(this.mAudioPath);
    boolean bool = bn(BaseApplicationImpl.getContext());
    label97:
    StringBuilder localStringBuilder;
    if ((((File)localObject1).exists()) && (this.mAudioPath != null) && (this.mAudioPath.toLowerCase().endsWith(".m4a")))
    {
      if (!bool) {
        break label281;
      }
      localObject1 = awtn.sx(awtn.getCameraPath());
      localStringBuilder = new StringBuilder().append("outputDir: ").append((String)localObject1);
      if (!new File((String)localObject1).exists()) {
        break label310;
      }
    }
    label281:
    label310:
    for (Object localObject2 = " exist";; localObject2 = " not exist")
    {
      axiy.i("AEVideoShelfEditFrag", (String)localObject2);
      this.mTimer = new Timer();
      this.mTimer.schedule(new AEVideoShelfEditFragment.16(this), 0L, eES);
      if (azbq.c(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath(), this.mAudioPath, (String)localObject1, 0) == 0)
      {
        localObject2 = new File(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath());
        if (((File)localObject2).exists())
        {
          axiy.i("AEVideoShelfEditFrag", "finishAudioVideoMerge done!");
          ((File)localObject2).delete();
        }
        this.cUy = ((String)localObject1);
      }
      this.mTimer.cancel();
      this.mTimer = null;
      if ((!bool) || (this.cUy == null)) {
        break;
      }
      rox.a(BaseApplication.getContext(), new File(this.cUy));
      return;
      localObject1 = awtn.sx(awtn.d.b.cTe + File.separator);
      break label97;
    }
  }
  
  private void ev(Intent paramIntent)
  {
    if (this.eEV == 3)
    {
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
      return;
    }
    AEVideoShelfPreviewFragment.i(getActivity(), paramIntent, 2);
  }
  
  private void goNext()
  {
    if (aOE())
    {
      if (!aOD()) {
        eKh();
      }
    }
    else {
      return;
    }
    Yj(true);
  }
  
  private void hideLoading()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()) && (this.g != null) && (this.g.isShowing())) {
      this.g.dismiss();
    }
  }
  
  @TargetApi(14)
  private void iZ()
  {
    this.mDialog = new ReportDialog(getActivity());
    Object localObject = this.mDialog.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject).setDimAmount(0.0F);
      }
    }
    this.mDialog.requestWindowFeature(1);
    this.mDialog.setContentView(2131562035);
    localObject = (ImageView)this.mDialog.findViewById(2131373659);
    this.b = a();
    ((ImageView)localObject).setImageDrawable(this.b);
    ((TextView)this.mDialog.findViewById(2131371989)).setText(2131690013);
    this.mDialog.setCancelable(true);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setOnCancelListener(new axhk(this));
    this.b.setProgress(0);
  }
  
  private void initData()
  {
    Intent localIntent = getActivity().getIntent();
    if (localIntent == null) {
      return;
    }
    this.eEV = localIntent.getIntExtra("jump_in_from", 0);
    this.cUr = localIntent.getStringExtra("loc_play_show_tab_name");
    this.cUx = localIntent.getStringExtra("MaterialPath");
    this.cUi = localIntent.getStringExtra("MaterialId");
    this.FI = localIntent.getStringArrayListExtra("PhotoList");
    this.cUs = localIntent.getStringExtra("loc_play_show_take_same_name");
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate = TemplateParser.parse(getActivity(), this.cUx);
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null)
    {
      axiy.w("AEVideoShelfEditFrag", "parse template Error!");
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine = new VideoShelfEngine(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVersion());
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null)
      {
        axiy.w("AEVideoShelfEditFrag", "init Engine Error!");
        return;
      }
    }
    catch (PagNotSupportSystemException localPagNotSupportSystemException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine = null;
        axiy.e("AEVideoShelfEditFrag", localPagNotSupportSystemException.getMessage());
        aurs.runOnUiThread(new AEVideoShelfEditFragment.4(this), 2000L);
      }
      new axhn(this).execute(new Void[0]);
    }
  }
  
  private void initView()
  {
    this.MD = getActivity().findViewById(2131363222);
    this.ahf = ((TextView)getActivity().findViewById(2131363974));
    this.ahf.setText(2131689999);
    this.ahf.setOnClickListener(this);
    this.MD.setOnClickListener(this);
    this.ME = getActivity().findViewById(2131366209);
    this.ME.setOnClickListener(this);
    this.gt = ((RelativeLayout)getActivity().findViewById(2131364397));
    this.N = ((RecyclerView)getActivity().findViewById(2131363677));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    localLinearLayoutManager.setOrientation(0);
    this.N.addItemDecoration(new b(d(getActivity(), 12.0F)));
    this.N.setLayoutManager(localLinearLayoutManager);
    this.gt.getViewTreeObserver().addOnGlobalLayoutListener(new axhi(this));
    iZ();
  }
  
  private void jo(View paramView)
  {
    int i = ((NodeGroup)this.mNodeGroupList.get(this.eEU)).nodeGroupID;
    if (this.bX != null)
    {
      Iterator localIterator = this.bX.iterator();
      while (localIterator.hasNext())
      {
        ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)localIterator.next();
        if (localScaleMoveImageViewer.getNodeGroupID() == i) {
          localScaleMoveImageViewer.onClick(paramView);
        }
      }
    }
  }
  
  private static void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  private void showLoading(String paramString)
  {
    Object localObject = getActivity();
    if ((localObject != null) && (!((FragmentActivity)localObject).isFinishing()))
    {
      if (this.g == null)
      {
        this.g = new ReportDialog((Context)localObject, 2131756467);
        this.g.setCancelable(false);
        this.g.setCanceledOnTouchOutside(false);
        this.g.setContentView(2131559761);
      }
      localObject = (TextView)this.g.findViewById(2131373180);
      if (TextUtils.isEmpty(paramString)) {
        break label98;
      }
      ((TextView)localObject).setText(paramString);
    }
    for (;;)
    {
      this.g.show();
      return;
      label98:
      ((TextView)localObject).setText(2131696924);
    }
  }
  
  private void showProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.show();
    }
  }
  
  private void updateProgress(int paramInt)
  {
    if (this.b == null) {
      return;
    }
    this.b.stopAnimating();
    this.b.setProgress(paramInt);
    this.b.setShowText(true);
    this.b.setShowImage(false);
    this.b.setText(paramInt + "%");
  }
  
  public void a(NodeItem paramNodeItem)
  {
    int k = 0;
    NodeGroup localNodeGroup = new NodeGroup();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mNodeGroupList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.mNodeGroupList.get(i)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.mNodeGroupList.get(i);
      }
      i += 1;
    }
    while (j < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).matrix.set(paramNodeItem.matrix);
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).cropBitmap = paramNodeItem.cropBitmap;
      }
      j += 1;
    }
  }
  
  public void b(NodeItem paramNodeItem)
  {
    int k = 0;
    NodeGroup localNodeGroup = new NodeGroup();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mNodeGroupList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.mNodeGroupList.get(i)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.mNodeGroupList.get(i);
      }
      i += 1;
    }
    while (j < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).cropBitmap = paramNodeItem.cropBitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
      }
      j += 1;
    }
  }
  
  public void c(NodeItem paramNodeItem)
  {
    adQ(paramNodeItem.nodeGroupID);
  }
  
  public void eKi()
  {
    showLoading(getResources().getString(2131690008));
  }
  
  public void eKj()
  {
    hideLoading();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    getActivity().finish();
  }
  
  public void onCancelCompleted()
  {
    axiy.i("AEVideoShelfEditFrag", "Merge Video step onCancelCompleted");
    this.aBR = 0L;
    aurs.runOnUiThread(new AEVideoShelfEditFragment.18(this));
  }
  
  public void onClick(View paramView)
  {
    if (axiw.Y(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if (i == 2131363222)
      {
        onBackPressed();
      }
      else if (i == 2131363974)
      {
        goNext();
        axim.a().eKF();
      }
      else if (i == 2131366209)
      {
        jo(paramView);
      }
    }
  }
  
  public void onCompleted()
  {
    axiy.i("AEVideoShelfEditFrag", "Merge Video step onCompleted");
    if (this.aBR > 0L) {}
    for (long l = System.currentTimeMillis() - this.aBR;; l = 0L)
    {
      this.aBR = 0L;
      eKk();
      aurs.runOnUiThread(new AEVideoShelfEditFragment.15(this, l));
      Yj(false);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558557, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.N.setAdapter(null);
    if (this.jdField_a_of_type_Axih != null) {
      this.jdField_a_of_type_Axih.eKs();
    }
    this.jdField_a_of_type_Axih = null;
    if ((this.mBackgroundBitmap != null) && (!this.mBackgroundBitmap.isRecycled())) {
      this.mBackgroundBitmap.recycle();
    }
    if (this.MD != null) {
      this.MD.setOnClickListener(null);
    }
    if (this.ahf != null) {
      this.ahf.setOnClickListener(null);
    }
    if (this.ME != null) {
      this.ME.setOnClickListener(null);
    }
    Iterator localIterator = this.eL.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Bitmap)localIterator.next();
      if (BitmapUtils.isLegal((Bitmap)localObject)) {
        ((Bitmap)localObject).recycle();
      }
    }
    localIterator = this.qJ.entrySet().iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)((Map.Entry)localIterator.next()).getValue());
    }
    this.qJ.clear();
    localIterator = this.bX.iterator();
    while (localIterator.hasNext()) {
      ((ScaleMoveImageViewer)localIterator.next()).eKs();
    }
    localIterator = this.bY.iterator();
    while (localIterator.hasNext())
    {
      localObject = (EditTextViewer)localIterator.next();
      ((EditTextViewer)localObject).eKs();
      ((EditTextViewer)localObject).setOnDownloadDialogListener(null);
    }
    localIterator = this.bZ.iterator();
    while (localIterator.hasNext()) {
      ((FaceImageViewer)localIterator.next()).eKs();
    }
    dismissProgressDialog();
    ad(getActivity(), false);
    super.onDestroy();
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    this.aBR = 0L;
    aurs.runOnUiThread(new AEVideoShelfEditFragment.17(this));
    axiy.w("AEVideoShelfEditFrag", "Merge Video step onError");
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {
      break label9;
    }
    label9:
    label162:
    for (;;)
    {
      return;
      if (paramIntent.getIntExtra("pic_result_back_type", -1) == 1)
      {
        String str = paramIntent.getStringExtra("PhotoConst.SELECTED_PATHS");
        int i = paramIntent.getIntExtra("pic_choose_in_node_id", 0);
        paramIntent = a((NodeGroup)this.mNodeGroupList.get(this.eEU), i);
        if (paramIntent == null) {
          break;
        }
        if (paramIntent.type == 0) {
          eH(i, str);
        }
        for (;;)
        {
          if ((TextUtils.isEmpty(str)) || (this.am.indexOfKey(i) < 0)) {
            break label162;
          }
          i = this.am.get(i);
          if ((this.FI == null) || (i < 0) || (i >= this.FI.size())) {
            break;
          }
          this.FI.remove(i);
          this.FI.add(i, str);
          return;
          if (paramIntent.type == 2) {
            A(i, str, true);
          }
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.bb.booleanValue()) {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.cancelSave();
    }
  }
  
  public void onProgress(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.aBQ > 200L)
    {
      aurs.runOnUiThread(new AEVideoShelfEditFragment.14(this, paramInt));
      this.aBQ = l;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.bX.iterator();
    while (localIterator.hasNext()) {
      ((ScaleMoveImageViewer)localIterator.next()).eKw();
    }
    localIterator = this.bY.iterator();
    while (localIterator.hasNext()) {
      EditTextViewer localEditTextViewer = (EditTextViewer)localIterator.next();
    }
    localIterator = this.bZ.iterator();
    while (localIterator.hasNext()) {
      ((FaceImageViewer)localIterator.next()).eKw();
    }
    eKf();
  }
  
  public void onStartGenerate()
  {
    axiy.i("AEVideoShelfEditFrag", "Merge Video step onStartGenerate");
    this.aBR = System.currentTimeMillis();
    aurs.runOnUiThread(new AEVideoShelfEditFragment.13(this));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initData();
    initView();
    eKb();
    this.cUw = awtn.d.a.cTb;
    paramView = new File(this.cUw);
    if (!paramView.exists()) {
      paramView.mkdirs();
    }
  }
  
  public class OffscreenCaptureRunnable
    implements Runnable
  {
    private OffscreenCaptureRunnable() {}
    
    public void run()
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(AEVideoShelfEditFragment.this.getActivity());
      AEVideoShelfEditFragment.m(localRelativeLayout, AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this).getLeft(), AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this).getTop(), AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this), AEVideoShelfEditFragment.b(AEVideoShelfEditFragment.this));
      int i = 0;
      if (i < AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this).getItemCount())
      {
        if (i == 0) {
          AEVideoShelfEditFragment.d(AEVideoShelfEditFragment.this, i);
        }
        for (;;)
        {
          i += 1;
          break;
          AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this, localRelativeLayout, i);
          AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this, localRelativeLayout, i);
        }
      }
      localRelativeLayout.removeAllViews();
      if (AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this) != null) {
        AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this).a(AEVideoShelfEditFragment.a(AEVideoShelfEditFragment.this));
      }
    }
  }
  
  static class a
    implements VideoShelfEngine.Callback
  {
    private WeakReference<AEVideoShelfEditFragment> mRef;
    
    public a(AEVideoShelfEditFragment paramAEVideoShelfEditFragment)
    {
      this.mRef = new WeakReference(paramAEVideoShelfEditFragment);
    }
    
    public void onCancelCompleted()
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        ((AEVideoShelfEditFragment)this.mRef.get()).onCancelCompleted();
      }
    }
    
    public void onCompleted()
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        ((AEVideoShelfEditFragment)this.mRef.get()).onCompleted();
      }
    }
    
    public void onError(int paramInt1, int paramInt2, String paramString)
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        ((AEVideoShelfEditFragment)this.mRef.get()).onError(paramInt1, paramInt2, paramString);
      }
    }
    
    public void onProgress(int paramInt)
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        ((AEVideoShelfEditFragment)this.mRef.get()).onProgress(paramInt);
      }
    }
    
    public void onStartGenerate()
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        ((AEVideoShelfEditFragment)this.mRef.get()).onStartGenerate();
      }
    }
  }
  
  public class b
    extends RecyclerView.ItemDecoration
  {
    private int space;
    
    public b(int paramInt)
    {
      this.space = paramInt;
    }
    
    public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      super.getItemOffsets(paramRect, paramInt, paramRecyclerView);
      if (paramInt == 0) {
        paramRect.left = this.space;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment
 * JD-Core Version:    0.7.0.1
 */