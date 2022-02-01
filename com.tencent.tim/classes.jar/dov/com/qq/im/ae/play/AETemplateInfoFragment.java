package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awtn.d.a;
import axcg;
import axcj;
import axhe;
import axhf;
import axhg;
import axhh;
import axic;
import axig;
import axij;
import axim;
import axis;
import axiw;
import axiy;
import axja;
import ayom;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import vnk;

public class AETemplateInfoFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, vnk
{
  public static final String aTZ = awtn.d.a.cTa;
  private ArrayList<String> FH = new ArrayList();
  private ImageView Ig;
  private ImageView Ih;
  private List<String> ME;
  private IVideoShelfPlayer jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer;
  private VideoShelfTemplate jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate;
  private a jdField_a_of_type_DovComQqImAePlayAETemplateInfoFragment$a;
  private FrameLayout aD;
  private Dialog aI;
  private TextView ahd;
  private TextView ahe;
  private TextureView c;
  private String cUi;
  private String cUq;
  private String cUr = "";
  private String cUs;
  private String cUt;
  private ArrayList<String> dQ;
  private boolean duA;
  private boolean duB;
  private boolean duC;
  private boolean duy = true;
  private boolean duz = true;
  private int eER;
  private ViewGroup fe;
  private Dialog g;
  private Bitmap hm;
  private String mMaterialPath;
  private List<NodeGroup> mNodeGroupList = new ArrayList();
  private boolean mSurfaceReady;
  private TextView mTipsTextView;
  private TextView mTitleTextView;
  private int screenHeight;
  private int screenWidth;
  
  static
  {
    File localFile = new File(aTZ);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static void W(Context paramContext, Intent paramIntent)
  {
    paramIntent.addFlags(67108864);
    paramIntent.addFlags(536870912);
    paramIntent.putExtra("VIDEO_STORY_FROM_TYPE", bI(paramContext));
    PublicFragmentActivity.b.start(paramContext, paramIntent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
  }
  
  private void Yi(boolean paramBoolean)
  {
    int i = 0;
    Log.i("AETemplateInfoFragment", "未合成视频，将直接实时预览。");
    axiy.i("AETemplateInfoFragment", "未合成视频，将直接实时预览。");
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from", true);
    HashMap localHashMap;
    Iterator localIterator1;
    if (!paramBoolean)
    {
      paramBoolean = true;
      localIntent.putExtra("isNeedEditButton", paramBoolean);
      localIntent.putExtra("usePagPreview", true);
      localIntent.putExtra("videoOutWidth", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth());
      localIntent.putExtra("videoOutHeight", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
      localIntent.putExtra("pagFilePath", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath());
      localIntent.putExtra("audioFilePath", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getAudioPath());
      localIntent.putExtra("MaterialPath", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath());
      localIntent.putExtra("MaterialName", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoName());
      localIntent.putExtra("loc_play_show_tab_name", this.cUr);
      localIntent.putExtra("loc_play_show_material_id", this.cUi);
      localIntent.putExtra("loc_play_show_take_same_name", this.cUs);
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bI(getActivity()));
      localIntent.putStringArrayListExtra("PhotoList", this.dQ);
      localIntent.putExtra("MaterialId", this.cUi);
      eJU();
      localHashMap = new HashMap();
      localIterator1 = this.mNodeGroupList.iterator();
    }
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label399;
      }
      Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          NodeItem localNodeItem = (NodeItem)localIterator2.next();
          if ((this.dQ != null) && (i < this.dQ.size()))
          {
            localObject = (String)this.dQ.get(i);
            if (localNodeItem.type == 2)
            {
              localObject = sE((String)this.dQ.get(i));
              this.FH.add(localObject);
            }
            localHashMap.put(localObject, localNodeItem.indexLayerForPag);
            i += 1;
            continue;
            paramBoolean = false;
            break;
          }
        }
      }
    }
    label399:
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("nodeImgList", localHashMap);
    localIntent.putExtras((Bundle)localObject);
    AEVideoShelfPreviewFragment.i(getActivity(), localIntent, 1);
  }
  
  private String a(VideoShelfTemplate paramVideoShelfTemplate)
  {
    int i = 0;
    if (paramVideoShelfTemplate == null) {}
    Object localObject1;
    do
    {
      return "";
      localObject1 = paramVideoShelfTemplate.getTipTemplate();
    } while ((localObject1 == null) || (localObject1.length == 0));
    int j = localObject1[0];
    Object localObject2 = getResources();
    paramVideoShelfTemplate = "";
    if (localObject2 != null) {
      paramVideoShelfTemplate = String.format("需选择%d张图片", new Object[] { Integer.valueOf(j) });
    }
    if (j == 0) {
      paramVideoShelfTemplate = "";
    }
    if (localObject1.length > 1) {
      i = localObject1[1];
    }
    if (i > 0)
    {
      localObject1 = "可修改文字";
      if ((TextUtils.isEmpty(paramVideoShelfTemplate)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!this.duA)) {
        break label150;
      }
    }
    label150:
    for (localObject2 = " ";; localObject2 = "")
    {
      return paramVideoShelfTemplate + (String)localObject2 + (String)localObject1;
      localObject1 = "";
      break;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString2);
    localIntent.putExtra("MaterialId", paramString3);
    localIntent.putExtra("MaterialName", paramString4);
    localIntent.putExtra("loc_play_show_tab_name", paramString1);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bI(paramContext));
    localIntent.putExtra("loc_play_show_take_same_name", paramString5);
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
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
  
  private void acC(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.ME == null) || (this.ME.isEmpty())) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.screenWidth, this.screenHeight);
    } while (localBitmap == null);
    axis.a().ai("ae_preference_k_qudong_last_crazy_face_photo", paramString, 0);
    showLoading(true);
    long l = System.currentTimeMillis();
    this.duy = false;
    pauseVideo();
    axic.a(localBitmap, this.ME, new axhh(this, paramString, localBitmap, l));
  }
  
  private void acD(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate = TemplateParser.parse(getActivity(), paramString);
      }
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      axiy.w("AETemplateInfoFragment", "loadTemplate Error!");
    }
  }
  
  private void acE(String paramString) {}
  
  private void adO(int paramInt)
  {
    axja.y(getActivity(), paramInt);
  }
  
  private void akG()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.isPlaying())
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.stop();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo done");
      }
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setSurface(null);
          this.eER = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.getCurrentPosition();
          eJO();
          this.duy = false;
          this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer = null;
          return;
          QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is not playing");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          axiy.e("AETemplateInfoFragment", "mVideoPlayer.setSurface(null) raise exception: ", localException);
        }
      }
    }
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is null");
  }
  
  public static int bI(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return ((Activity)paramContext).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
    }
    return axcg.a.getId();
  }
  
  private void eJM()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.isPlaying())
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.pause();
        eJO();
      }
    }
    else {
      return;
    }
    this.duy = true;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.start();
    eJN();
  }
  
  private void eJN()
  {
    this.Ih.setVisibility(8);
  }
  
  private void eJO()
  {
    this.Ih.setVisibility(0);
  }
  
  private void eJP()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath())))
    {
      axiy.w("AETemplateInfoFragment", "onNext template Error!");
      return;
    }
    if (this.duC)
    {
      eJQ();
      return;
    }
    int k = 0;
    int j = 0;
    int m;
    for (int i = 0; k < this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().size(); i = m)
    {
      int n = j;
      m = i;
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(k) != null)
      {
        n = j;
        m = i;
        if (((MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(k)).getNodeList() != null)
        {
          m = 0;
          if (m < ((MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(k)).getNodeList().size())
          {
            if (((MaskNodeItem)((MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(k)).getNodeList().get(m)).getType() != 1) {
              i += 1;
            }
            for (;;)
            {
              m += 1;
              break;
              j += 1;
            }
          }
          m = i;
          n = j;
        }
      }
      k += 1;
      j = n;
    }
    boolean bool;
    if (j > 0)
    {
      bool = true;
      this.duB = bool;
      if ((j <= 0) || (i != 0)) {
        break label262;
      }
    }
    label262:
    for (j = i1;; j = 0)
    {
      if (j == 0) {
        break label267;
      }
      eJV();
      return;
      bool = false;
      break;
    }
    label267:
    adO(i);
  }
  
  private void eJQ()
  {
    if (!aOD())
    {
      QQToast.a(getActivity(), getActivity().getString(2131689996), 0).show();
      return;
    }
    if (axis.a().c("key_first_change_face_click_flag", true, 0))
    {
      axis.a().n("key_first_change_face_click_flag", false, 0);
      eJR();
      return;
    }
    axcj.a(getActivity(), 1024, axcg.B.getId(), null);
  }
  
  private void eJR()
  {
    if (this.aI != null) {
      if (this.aI.isShowing()) {
        this.aI.dismiss();
      }
    }
    for (;;)
    {
      if (!this.aI.isShowing()) {
        this.aI.show();
      }
      return;
      this.aI = new ReportDialog(getActivity(), 2131756467);
      this.aI.setCancelable(true);
      this.aI.setCanceledOnTouchOutside(true);
      this.aI.setContentView(2131558571);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2131167654);
      localObject = URLDrawable.getDrawable("https://dl.url.cn/myapp/qq_desk/qqrm/videofilter/Pturenwu/tipss.png", (URLDrawable.URLDrawableOptions)localObject);
      URLImageView localURLImageView = (URLImageView)this.aI.findViewById(2131369565);
      TextView localTextView = (TextView)this.aI.findViewById(2131380522);
      localURLImageView.setImageDrawable((Drawable)localObject);
      this.aI.show();
      localTextView.setOnClickListener(new axhf(this));
    }
  }
  
  private void eJS()
  {
    if ((this.aI != null) && (this.aI.isShowing())) {
      this.aI.dismiss();
    }
  }
  
  private void eJT()
  {
    showLoading(true);
    Yi(false);
    showLoading(false);
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
        Object localObject = (MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(i);
        NodeGroup localNodeGroup = new NodeGroup();
        localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject).getNodeGroupID();
        localObject = ((MaskNodeGroup)localObject).getNodeList();
        localNodeGroup.nodeItemList = new ArrayList();
        int j = 0;
        while (j < ((List)localObject).size())
        {
          MaskNodeItem localMaskNodeItem = (MaskNodeItem)((List)localObject).get(j);
          NodeItem localNodeItem = new NodeItem();
          localNodeItem.nodeID = localMaskNodeItem.getNodeID();
          localNodeItem.type = localMaskNodeItem.getType();
          localNodeItem.nodeGroupID = localMaskNodeItem.getNodeGroupID();
          localNodeItem.zIndex = localMaskNodeItem.getZIndex();
          localNodeItem.indexLayerForPag = localMaskNodeItem.getIndexLayerForPag();
          localNodeGroup.nodeItemList.add(localNodeItem);
          j += 1;
        }
        this.mNodeGroupList.add(localNodeGroup);
        i += 1;
      }
    }
  }
  
  private void eJV()
  {
    AEVideoShelfEditFragment.a(getActivity(), this.cUr, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath(), this.cUi, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoName(), this.dQ, 1, this.cUs);
  }
  
  private void eJW()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate != null)
    {
      eJX();
      rp();
    }
  }
  
  private void eJX()
  {
    if (this.duz)
    {
      this.mTitleTextView.setText(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getName());
      this.mTipsTextView.setText(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getTip());
      return;
    }
    this.mTitleTextView.setText(this.cUq);
    getActivity().findViewById(2131365729).setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTipsTextView.getLayoutParams();
    this.mTipsTextView.setLines(2);
    localLayoutParams.height = ((int)(32.0F * this.mTipsTextView.getContext().getResources().getDisplayMetrics().density));
    this.mTipsTextView.setLayoutParams(localLayoutParams);
    this.mTipsTextView.setText(a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate));
  }
  
  private void eJY()
  {
    axiy.w("AETemplateInfoFragment", "onPlayError!");
  }
  
  private void eJZ()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null) {
      dRB();
    }
  }
  
  private void eKa()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---surfaceTextureDestroyed");
    this.mSurfaceReady = false;
    akG();
  }
  
  private void h(SurfaceTexture paramSurfaceTexture)
  {
    int j = 1;
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---surfaceTextureAvailable");
    this.mSurfaceReady = true;
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) && (!TextUtils.isEmpty(this.mMaterialPath))) {
      acD(this.mMaterialPath);
    }
    label164:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer == null)
        {
          if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVersion() != 1)) {
            break label164;
          }
          i = j;
          if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoPath() != null)
          {
            if (FileUtils.exists(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoPath())) {
              break label164;
            }
            i = j;
          }
          if (i != 0)
          {
            localObject = new PagShelfPlayer();
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer = ((IVideoShelfPlayer)localObject);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setSurface(new Surface(paramSurfaceTexture));
          eJW();
          return;
        }
        Object localObject = new VideoShelfPlayer();
        continue;
        int i = 0;
      }
      catch (PagNotSupportSystemException paramSurfaceTexture)
      {
        axiy.e("AETemplateInfoFragment", paramSurfaceTexture.getMessage());
        acE("pag版本过低");
        return;
      }
    }
  }
  
  private void initData()
  {
    this.screenWidth = ayom.getWindowScreenWidth(getActivity());
    this.screenHeight = ayom.getWindowScreenHeight(getActivity());
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      this.mMaterialPath = localIntent.getStringExtra("MaterialPath");
      this.cUi = localIntent.getStringExtra("MaterialId");
      this.cUq = localIntent.getStringExtra("MaterialName");
      this.cUr = localIntent.getStringExtra("loc_play_show_tab_name");
      this.cUs = localIntent.getStringExtra("loc_play_show_take_same_name");
    }
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) && (!TextUtils.isEmpty(this.mMaterialPath))) {
      acD(this.mMaterialPath);
    }
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate != null)
    {
      this.ME = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getCrazyFaceList();
      if ((this.ME == null) || (this.ME.isEmpty())) {
        break label251;
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      this.duC = bool;
      if (this.duC)
      {
        this.cUt = axis.a().t("ae_preference_k_qudong_last_crazy_face_photo", null, 0);
        if (!TextUtils.isEmpty(this.cUt))
        {
          int i = getActivity().getResources().getDimensionPixelSize(2131296384);
          int j = getActivity().getResources().getDimensionPixelSize(2131296385);
          this.hm = BitmapUtils.decodeSampleBitmap(getActivity(), this.cUt, j, i);
        }
      }
      OfflineFileUpdater.setHttpClient(new axig());
      OfflineFileUpdater.checkOfflineFile();
      return;
    }
  }
  
  private void initView()
  {
    View localView = getView();
    this.ahd = ((TextView)localView.findViewById(2131372347));
    this.Ig = ((ImageView)localView.findViewById(2131369040));
    this.fe = ((ViewGroup)localView.findViewById(2131370225));
    this.ahd.setOnClickListener(this);
    this.fe.setOnClickListener(this);
    this.mTitleTextView = ((TextView)localView.findViewById(2131379769));
    this.mTipsTextView = ((TextView)localView.findViewById(2131379724));
    this.ahe = ((TextView)localView.findViewById(2131373408));
    if (isDebugVersion())
    {
      this.ahe.setVisibility(0);
      this.ahe.setText("0(fps)");
      this.ahe.setTextColor(-65536);
    }
    this.Ih = ((ImageView)localView.findViewById(2131373409));
    this.c = ((TextureView)localView.findViewById(2131373575));
    this.c.setKeepScreenOn(true);
    this.aD = ((FrameLayout)localView.findViewById(2131373403));
    this.aD.getViewTreeObserver().addOnGlobalLayoutListener(new axhe(this));
    this.c.setOnClickListener(this);
    this.c.setSurfaceTextureListener(new b(this));
    this.jdField_a_of_type_DovComQqImAePlayAETemplateInfoFragment$a = new a(this);
    if (this.duC)
    {
      if (this.hm != null)
      {
        this.fe.setVisibility(0);
        this.Ig.setImageBitmap(this.hm);
        this.ahd.setTextColor(-16777216);
        this.ahd.setBackgroundResource(2130837920);
        this.ahd.setText(2131690006);
        this.mTipsTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.mTipsTextView.setText(2131690003);
    this.mTipsTextView.setVisibility(0);
  }
  
  private boolean isDebugVersion()
  {
    return false;
  }
  
  private void pauseVideo()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.isPlaying())
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.pause();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo done");
        eJO();
        return;
      }
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is not playing");
      return;
    }
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is null");
  }
  
  private void rp()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.reset();
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setVideoShelfPlayerListener(this.jdField_a_of_type_DovComQqImAePlayAETemplateInfoFragment$a);
    String str2 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoPath();
    String str1 = null;
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer instanceof PagShelfPlayer))
    {
      str2 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath();
      str1 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getAudioPath();
    }
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.isFromAssets())
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setDataSource(getActivity().getAssets(), str2);
      if ((str1 != null) && (FileUtils.exists(str1))) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(true), getActivity().getAssets(), str1 });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.prepare();
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.seekTo(this.eER);
      if (!this.duy) {
        break;
      }
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.start();
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---mVideoPlayer.start() in playVideo");
      return;
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setDataSource(str2);
      if ((str1 != null) && (FileUtils.exists(str1))) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(false), str1 });
      }
    }
  }
  
  private String sE(String paramString)
  {
    Object localObject1 = new File(paramString);
    Object localObject2 = new File(awtn.d.a.PATH);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    String str = ((File)localObject2).getPath() + File.separator + "crop_" + ((File)localObject1).getName();
    localObject1 = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
    if (!BitmapUtils.isLegal((Bitmap)localObject1)) {}
    do
    {
      return paramString;
      localObject2 = axij.b((Bitmap)localObject1, paramString);
      localObject1 = localObject2;
      if (((Bitmap)localObject2).getWidth() == 1)
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject2).getHeight() == 1) {
          localObject1 = BitmapUtils.scaleBitmap((Bitmap)localObject2, 2.0F, true);
        }
      }
      localObject2 = new boolean[1];
      localObject2[0] = 0;
      axic.a((Bitmap)localObject1, new axhg(this, (boolean[])localObject2, str), true);
    } while (localObject2[0] == 0);
    return str;
  }
  
  private void showLoading(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label76;
      }
      if (this.g == null)
      {
        this.g = new ReportDialog(localFragmentActivity, 2131756467);
        this.g.setCancelable(false);
        this.g.setCanceledOnTouchOutside(false);
        this.g.setContentView(2131559761);
      }
      this.g.show();
    }
    label76:
    while ((this.g == null) || (!this.g.isShowing())) {
      return;
    }
    this.g.dismiss();
  }
  
  public void dRB()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onPlayComplete");
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null) {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.seekTo(0);
    }
    eJO();
    this.duy = false;
    if (isDebugVersion()) {
      this.ahe.setText("0(fps)");
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558558;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1024) && (paramInt2 == -1)) {
      acC(paramIntent.getExtras().getString("take_photo_path"));
    }
  }
  
  public void onBackPressed()
  {
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    if (axiw.Y(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364098: 
        onBackPressed();
        break;
      case 2131372347: 
        eJP();
        if (!this.duC) {
          axim.a().eKW();
        } else {
          axim.a().eKX();
        }
        break;
      case 2131370225: 
        acC(this.cUt);
        axim.a().eKY();
        break;
      case 2131373575: 
        eJM();
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onDestroy");
    akG();
    super.onDestroy();
    eJS();
    BitmapUtils.recycle(this.hm);
    Iterator localIterator = this.FH.iterator();
    while (localIterator.hasNext()) {
      FileUtils.delete((String)localIterator.next());
    }
    if (QLog.isDebugVersion()) {
      QLog.d("AETemplateInfoFragment", 4, "submit clear temp files task");
    }
    ThreadManagerV2.excute(new AETemplateInfoFragment.2(this), 64, null, false);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {}
    while (paramIntent.getIntExtra("pic_result_back_type", -1) != 0) {
      return;
    }
    this.dQ = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    if ((aOD()) && (!this.duB))
    {
      eJT();
      return;
    }
    eJV();
  }
  
  public void onPause()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onPause");
    super.onPause();
    this.duy = false;
    pauseVideo();
  }
  
  public void onResume()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onResume");
    super.onResume();
    eJZ();
  }
  
  public void onUpdateRate(long paramLong)
  {
    if (isDebugVersion()) {
      this.ahe.setText(paramLong + "(fps)");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.vg.setTitle("模板详情");
    if (!FeatureManager.Features.PAG.init())
    {
      axiy.e("AETemplateInfoFragment", "pag相关so未初始化成功");
      QQToast.a(getActivity(), "pag相关so未初始化成功", 0).show();
      return;
    }
    initData();
    initView();
  }
  
  static class a
    implements IVideoShelfPlayerListener
  {
    private WeakReference<AETemplateInfoFragment> mRef;
    
    public a(AETemplateInfoFragment paramAETemplateInfoFragment)
    {
      this.mRef = new WeakReference(paramAETemplateInfoFragment);
    }
    
    public void onChangVideoSize(int paramInt1, int paramInt2) {}
    
    public void onCompletion()
    {
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---PlayerListener onCompletion");
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        ((AETemplateInfoFragment)this.mRef.get()).dRB();
      }
    }
    
    public boolean onError(int paramInt, String paramString, Object paramObject)
    {
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---PlayerListener onError errCode=" + paramInt + ", msg=" + paramString);
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        AETemplateInfoFragment.b((AETemplateInfoFragment)this.mRef.get());
      }
      return true;
    }
    
    public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer) {}
    
    public void onUpdateRate(long paramLong)
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        ((AETemplateInfoFragment)this.mRef.get()).onUpdateRate(paramLong);
      }
    }
  }
  
  static class b
    implements TextureView.SurfaceTextureListener
  {
    private WeakReference<AETemplateInfoFragment> mRef;
    
    public b(AETemplateInfoFragment paramAETemplateInfoFragment)
    {
      this.mRef = new WeakReference(paramAETemplateInfoFragment);
    }
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureAvailable");
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        AETemplateInfoFragment.a((AETemplateInfoFragment)this.mRef.get(), paramSurfaceTexture);
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureDestroyed");
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        AETemplateInfoFragment.c((AETemplateInfoFragment)this.mRef.get());
      }
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureSizeChanged");
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETemplateInfoFragment
 * JD-Core Version:    0.7.0.1
 */