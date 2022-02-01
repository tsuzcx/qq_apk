package dov.com.qq.im.aeeditor.module.clip.image;

import acfp;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import aqha;
import aqju;
import aqnm;
import axim;
import axiy;
import axji;
import axkv;
import axkw;
import axkx;
import axky;
import axkz;
import axla;
import axlb;
import axlc;
import axld;
import axog;
import axoj;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorClipPageTopBar;
import dov.com.qq.im.aeeditor.view.ClipThumbnailImageView;
import dov.com.qq.im.aeeditor.view.EditorClipView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import rpq;

public class AEEditorImageClipFragment
  extends AEEditorBaseFragment
  implements View.OnClickListener
{
  private static final String TAG = AEEditorImageClipFragment.class.getSimpleName();
  private static final double[] l = { 1.0D, 0.75D, 1.333333333333333D };
  private static final int[] tP = { 1080, 1080, 1920, 2560 };
  private ArrayList<String> FJ = new ArrayList();
  private boolean[] G = new boolean[9];
  private ImageView In;
  private ImageView Io;
  private ImageView Ip;
  private View ML;
  private RecyclerView O;
  private a jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment$a;
  private AEEditorClipPageTopBar jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar;
  private EditorClipView jdField_a_of_type_DovComQqImAeeditorViewEditorClipView;
  private long aCl;
  private TextView ahm;
  private boolean bLe = true;
  private FrameLayout cC;
  private boolean dvd = true;
  private boolean dve;
  private int eFS = -1;
  private int eFT;
  private int eFU;
  private int eFV = aqnm.getScreenWidth();
  private SparseArray<Bitmap> eg = new SparseArray();
  private SparseArray<View> eh = new SparseArray();
  private boolean mIsInited;
  private int[] tQ = new int[9];
  private int[] tR = new int[9];
  private int[] tS = new int[9];
  private int[] tT = new int[9];
  
  private void a(int paramInt1, int paramInt2, EditorClipView paramEditorClipView)
  {
    this.dvd = false;
    this.eFT = 0;
    this.eFU = 0;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    localValueAnimator.addUpdateListener(new axky(this, paramEditorClipView));
    localValueAnimator.setDuration(paramInt2);
    localValueAnimator.start();
    localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    localValueAnimator.addUpdateListener(new axkz(this, paramEditorClipView));
    localValueAnimator.setDuration(paramInt2);
    localValueAnimator.start();
    localValueAnimator.addListener(new axla(this, paramEditorClipView));
  }
  
  private void a(EditorPicInfo paramEditorPicInfo)
  {
    if (paramEditorPicInfo == null) {}
    double d3;
    double d4;
    do
    {
      return;
      double d1 = paramEditorPicInfo.x;
      double d2 = paramEditorPicInfo.w;
      d3 = paramEditorPicInfo.y;
      d4 = paramEditorPicInfo.h;
      paramEditorPicInfo.x = Math.max(paramEditorPicInfo.x, 0.0D);
      paramEditorPicInfo.x = Math.min(paramEditorPicInfo.x, 1.0D);
      if (paramEditorPicInfo.x < 0.001D) {
        paramEditorPicInfo.x = 0.0D;
      }
      paramEditorPicInfo.y = Math.max(paramEditorPicInfo.y, 0.0D);
      paramEditorPicInfo.y = Math.min(paramEditorPicInfo.y, 1.0D);
      if (paramEditorPicInfo.y < 0.001D) {
        paramEditorPicInfo.y = 0.0D;
      }
      paramEditorPicInfo.w = Math.min(paramEditorPicInfo.w, 1.0D - paramEditorPicInfo.x);
      paramEditorPicInfo.h = Math.min(paramEditorPicInfo.h, 1.0D - paramEditorPicInfo.y);
      if (Math.abs(d1 + d2 - 1.0D) < 0.001D) {
        paramEditorPicInfo.w = (1.0D - paramEditorPicInfo.x);
      }
    } while (Math.abs(d3 + d4 - 1.0D) >= 0.001D);
    paramEditorPicInfo.h = (1.0D - paramEditorPicInfo.y);
  }
  
  private boolean aOP()
  {
    boolean bool = false;
    int i = 0;
    int k;
    for (int j = 0; i < this.FJ.size(); j = k)
    {
      k = j;
      if (this.G[i] != 0) {
        k = j + 1;
      }
      i += 1;
    }
    if (j == 1) {
      bool = true;
    }
    return bool;
  }
  
  private boolean aOQ()
  {
    long l1 = System.currentTimeMillis();
    if (Math.abs(l1 - this.aCl) < 500L) {
      return true;
    }
    this.aCl = l1;
    return false;
  }
  
  private void aef(int paramInt)
  {
    int j = 0;
    if (!this.dvd) {}
    while (paramInt == this.eFS) {
      return;
    }
    this.eFS = paramInt;
    Object localObject = (View)this.eh.get(paramInt);
    int i;
    if (localObject == null)
    {
      i = Math.max(OfflineConfig.getPhonePerfLevel() - 1, 0);
      i = Math.max(this.tQ[paramInt] / tP[i], this.tR[paramInt] / tP[i]);
      localObject = m((String)this.FJ.get(paramInt), i + 1);
      Bitmap localBitmap = rpq.rotateBitmap((Bitmap)localObject, this.tT[paramInt]);
      if ((localObject != localBitmap) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
      if (localBitmap == null)
      {
        QQToast.a(getActivity(), "图片不存在或已经被删除", 1).show();
        return;
      }
      localObject = LayoutInflater.from(getActivity()).inflate(2131558606, this.cC, false);
      ((EditorClipView)((View)localObject).findViewById(2131365537)).setImageBitmap(localBitmap);
      ((EditorClipView)((View)localObject).findViewById(2131365537)).setClipWindowWidthChangeListener(new axkw(this));
      ((EditorClipView)((View)localObject).findViewById(2131365537)).setClipViewOperateListener(new axkx(this));
      this.eg.put(paramInt, localBitmap);
      this.eh.put(paramInt, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView = ((EditorClipView)((View)localObject).findViewById(2131365537));
      this.cC.removeAllViews();
      this.cC.addView((View)localObject);
      a((int)(this.eFV / l[this.tS[0]] - this.eFV / l[this.tS[paramInt]]) / 2, 10, this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView);
      this.tS[paramInt] = this.tS[0];
      localObject = this.In;
      if (om(paramInt))
      {
        i = 0;
        ((ImageView)localObject).setVisibility(i);
        localObject = this.Io;
        if (!om(paramInt)) {
          break label433;
        }
        i = 0;
        label386:
        ((ImageView)localObject).setVisibility(i);
        localObject = this.Ip;
        if (!om(paramInt)) {
          break label439;
        }
      }
      label433:
      label439:
      for (i = j;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar.setIndex(getRelativeIndex(paramInt));
        return;
        i = 8;
        break;
        i = 8;
        break label386;
      }
    }
  }
  
  private void aeg(int paramInt)
  {
    if (this.tS[0] == paramInt) {}
    while (!this.dvd) {
      return;
    }
    aeh(paramInt);
    int i = (int)(this.eFV / l[paramInt] - this.eFV / l[this.tS[0]]) / 2;
    this.tS[0] = paramInt;
    a(i, 300, this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView);
  }
  
  private void aeh(int paramInt)
  {
    ImageView localImageView = this.In;
    int i;
    if (paramInt == 0)
    {
      i = 2130837995;
      localImageView.setImageResource(i);
      localImageView = this.Io;
      if (paramInt != 1) {
        break label64;
      }
      i = 2130837997;
      label32:
      localImageView.setImageResource(i);
      localImageView = this.Ip;
      if (paramInt != 2) {
        break label71;
      }
    }
    label64:
    label71:
    for (paramInt = 2130837999;; paramInt = 2130838000)
    {
      localImageView.setImageResource(paramInt);
      return;
      i = 2130837996;
      break;
      i = 2130837998;
      break label32;
    }
  }
  
  private void bqd()
  {
    this.In.setOnClickListener(this);
    this.Io.setOnClickListener(this);
    this.Ip.setOnClickListener(this);
    this.ahm.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar.setClipPageTopBarClickListener(new axkv(this));
  }
  
  private void eLP()
  {
    this.FJ.clear();
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("PhotoConst.SELECTED_PATHS"))) {
      this.FJ.addAll(localBundle.getStringArrayList("PhotoConst.SELECTED_PATHS"));
    }
  }
  
  private void eLQ()
  {
    int i = aqnm.getScreenWidth();
    int j = aqnm.getScreenHeight();
    int k = axog.dip2px(getActivity(), 250.0F);
    i = Math.max((int)((i - (j - k) * 3 / 4.0F) / 2.0F), 0);
    this.cC.setPadding(i, 0, i, 0);
  }
  
  private void eLR()
  {
    axiy.e(TAG, "handleNextStep");
    ArrayList localArrayList = new ArrayList();
    axim.a().adV(this.FJ.size());
    int j = 0;
    int i = 0;
    Object localObject1;
    if (i < this.FJ.size())
    {
      if (this.G[i] == 0) {}
      while (!isFileExist((String)this.FJ.get(i)))
      {
        i += 1;
        break;
      }
      if (this.eh.get(i) != null)
      {
        localObject1 = (EditorClipView)((View)this.eh.get(i)).findViewById(2131365537);
        if (this.tS[0] == this.tS[i]) {
          localObject1 = ((EditorClipView)localObject1).a();
        }
      }
      for (;;)
      {
        ((EditorPicInfo)localObject1).picPath = ((String)this.FJ.get(i));
        ((EditorPicInfo)localObject1).originPicWidth = this.tQ[i];
        ((EditorPicInfo)localObject1).originPicHeight = this.tR[i];
        a((EditorPicInfo)localObject1);
        localArrayList.add(localObject1);
        axiy.e(TAG, "cropInfo::" + ((EditorPicInfo)localObject1).x + "," + ((EditorPicInfo)localObject1).y + "," + ((EditorPicInfo)localObject1).w + "," + ((EditorPicInfo)localObject1).h + "," + ((EditorPicInfo)localObject1).originPicWidth + "," + ((EditorPicInfo)localObject1).originPicHeight);
        j = 1;
        break;
        RectF localRectF1;
        RectF localRectF2;
        Object localObject2;
        if (l[this.tS[i]] < l[this.tS[0]])
        {
          localRectF1 = new RectF(((EditorClipView)localObject1).m());
          localRectF2 = new RectF(((EditorClipView)localObject1).n());
          localObject2 = new Matrix();
          ((Matrix)localObject2).setScale(1.0F, (float)(l[this.tS[i]] / l[this.tS[0]]), localRectF2.centerX(), localRectF2.centerY());
          ((Matrix)localObject2).mapRect(localRectF2);
          localObject1 = ((EditorClipView)localObject1).a(localRectF1, localRectF2);
        }
        else
        {
          localRectF1 = new RectF(((EditorClipView)localObject1).m());
          localRectF2 = new RectF(((EditorClipView)localObject1).n());
          localObject2 = new RectF(localRectF2);
          Matrix localMatrix = new Matrix();
          localMatrix.setScale(1.0F, (float)(l[this.tS[i]] / l[this.tS[0]]), localRectF2.centerX(), localRectF2.centerY());
          localMatrix.mapRect(localRectF2);
          if (localRectF1.height() > localRectF2.height())
          {
            f = 0.0F;
            if (localRectF2.top < localRectF1.top) {
              f = localRectF1.top - localRectF2.top;
            }
            for (;;)
            {
              localMatrix.reset();
              localMatrix.setTranslate(0.0F, f);
              localMatrix.mapRect(localRectF2);
              localObject1 = ((EditorClipView)localObject1).a(localRectF1, localRectF2);
              break;
              if (localRectF2.bottom > localRectF1.bottom) {
                f = localRectF1.bottom - localRectF2.bottom;
              }
            }
          }
          float f = 1.0F / ((localRectF2.height() - localRectF1.height()) / localRectF1.height() + 1.0F);
          localMatrix.reset();
          localMatrix.setScale(f, 1.0F, ((RectF)localObject2).centerX(), ((RectF)localObject2).centerY());
          localMatrix.mapRect((RectF)localObject2);
          localObject1 = ((EditorClipView)localObject1).a(localRectF1, (RectF)localObject2);
          ((EditorPicInfo)localObject1).y = 0.0D;
          ((EditorPicInfo)localObject1).h = 1.0D;
          continue;
          localObject1 = new EditorPicInfo();
          j = this.tQ[i];
          int k = this.tR[i];
          double d = l[this.tS[0]];
          if (1.0F * j / k < d)
          {
            ((EditorPicInfo)localObject1).x = 0.0D;
            ((EditorPicInfo)localObject1).y = ((k - j / d) / 2.0D / k);
            ((EditorPicInfo)localObject1).w = 1.0D;
            ((EditorPicInfo)localObject1).h = (j / d / k);
          }
          else
          {
            ((EditorPicInfo)localObject1).x = ((j - k * d) / 2.0D / j);
            ((EditorPicInfo)localObject1).y = 0.0D;
            ((EditorPicInfo)localObject1).w = (d * k / j);
            ((EditorPicInfo)localObject1).h = 1.0D;
          }
        }
      }
    }
    axiy.e(TAG, "cropInfo  end");
    if (j != 0)
    {
      localObject1 = new Bundle(getArguments());
      ((Bundle)localObject1).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", localArrayList);
      a().L(getModuleId(), (Bundle)localObject1);
      return;
    }
    QQToast.a(getActivity(), "图片不存在或已经被删除", 1).show();
  }
  
  private void eLS()
  {
    int i = 0;
    while (i < this.FJ.size())
    {
      localObject = (String)this.FJ.get(i);
      Size localSize = BitmapUtil.getImageSize((String)localObject);
      this.tQ[i] = localSize.getWidth();
      this.tR[i] = localSize.getHeight();
      this.tT[i] = BitmapUtil.getImageRotation((String)localObject);
      i += 1;
    }
    Object localObject = new LinearLayoutManager(getActivity());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.O.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment$a = new a();
    this.O.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment$a);
  }
  
  private void gV(View paramView)
  {
    this.cC = ((FrameLayout)paramView.findViewById(2131365534));
    this.In = ((ImageView)paramView.findViewById(2131376619));
    this.Io = ((ImageView)paramView.findViewById(2131376620));
    this.Ip = ((ImageView)paramView.findViewById(2131376621));
    this.ahm = ((TextView)paramView.findViewById(2131364673));
    this.O = ((RecyclerView)paramView.findViewById(2131379640));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar = ((AEEditorClipPageTopBar)paramView.findViewById(2131364674));
  }
  
  private int getRelativeIndex(int paramInt)
  {
    int j = 0;
    int i = 0;
    while (i <= paramInt)
    {
      int k = j;
      if (this.G[i] != 0) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private void initData()
  {
    int i;
    if ((this.tR[0] == 0) || (this.tQ[0] == 0)) {
      i = 0;
    }
    for (;;)
    {
      axoj.B(l[i]);
      Arrays.fill(this.tS, i);
      Arrays.fill(this.G, true);
      aeh(i);
      this.dve = false;
      this.eFS = -1;
      aef(0);
      return;
      if (this.tR[0] * 1.0F / this.tQ[0] >= 1.166666746139526D) {
        i = 1;
      } else if (this.tR[0] * 1.0F / this.tQ[0] <= 0.875D) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  private int lH(int paramInt)
  {
    int i = paramInt + 1;
    while (i < this.FJ.size())
    {
      if (this.G[i] != 0) {
        return i;
      }
      i += 1;
    }
    paramInt -= 1;
    for (;;)
    {
      if (paramInt < 0) {
        break label59;
      }
      i = paramInt;
      if (this.G[paramInt] != 0) {
        break;
      }
      paramInt -= 1;
    }
    label59:
    return 0;
  }
  
  private Bitmap m(String paramString, int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = paramInt;
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private boolean om(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.FJ.size())
      {
        if (this.G[i] == 0) {
          break label40;
        }
        bool1 = bool2;
        if (i == paramInt) {
          bool1 = true;
        }
      }
      return bool1;
      label40:
      i += 1;
    }
  }
  
  public boolean aOM()
  {
    if (!this.dve) {
      return false;
    }
    Object localObject = getActivity();
    localObject = aqha.a((Context)localObject, 230).setTitle(acfp.m(2131689963)).setMessage(((Context)localObject).getString(2131689964)).setPositiveButton(((Context)localObject).getString(2131689963), new axlc(this)).setNegativeButton(((Context)localObject).getString(2131689950), new axlb(this));
    if (localObject != null) {}
    try
    {
      if (!((aqju)localObject).isShowing()) {
        ((aqju)localObject).show();
      }
      label92:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label92;
    }
  }
  
  public String getModuleId()
  {
    return "AEEditorImageClip";
  }
  
  public boolean isFileExist(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131376619)
    {
      aeg(0);
      this.dve = true;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131376620)
      {
        aeg(1);
        this.dve = true;
      }
      else if (i == 2131376621)
      {
        aeg(2);
        this.dve = true;
      }
      else if (i == 2131364673)
      {
        eLR();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    axiy.i(TAG, "onCreate");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    axiy.i(TAG, "onCreateView");
    if (this.ML == null) {
      this.ML = paramLayoutInflater.inflate(2131558609, paramViewGroup, false);
    }
    if ((this.ML.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.ML.getParent()).removeView(this.ML);
    }
    paramLayoutInflater = this.ML;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axiy.i(TAG, "onDestroy");
    if (this.eg != null)
    {
      int i = 0;
      while (i < this.eg.size())
      {
        Bitmap localBitmap = (Bitmap)this.eg.valueAt(i);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        i += 1;
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!this.mIsInited)
    {
      eLP();
      gV(paramView);
      eLQ();
      eLS();
      initData();
      bqd();
      this.mIsInited = true;
    }
  }
  
  public class a
    extends RecyclerView.Adapter<AEEditorImageClipFragment.b>
  {
    a() {}
    
    @NonNull
    public AEEditorImageClipFragment.b a(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
      return new AEEditorImageClipFragment.b(AEEditorImageClipFragment.this, LayoutInflater.from(AEEditorImageClipFragment.this.getActivity()).inflate(2131558605, paramViewGroup, false));
    }
    
    public void a(@NonNull AEEditorImageClipFragment.b paramb, int paramInt)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = axog.dip2px(AEEditorImageClipFragment.this.getActivity(), 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = axog.dip2px(AEEditorImageClipFragment.this.getActivity(), 50.0F);
      localObject = URLDrawable.getDrawable("file://" + (String)AEEditorImageClipFragment.a(AEEditorImageClipFragment.this).get(paramInt), (URLDrawable.URLDrawableOptions)localObject);
      paramb.a.setImageDrawable((Drawable)localObject);
      if ((paramInt == 0) && (AEEditorImageClipFragment.c(AEEditorImageClipFragment.this)))
      {
        paramb.a.setIsSelected(true);
        AEEditorImageClipFragment.c(AEEditorImageClipFragment.this, false);
        paramb.setVisibility(AEEditorImageClipFragment.a(AEEditorImageClipFragment.this)[paramInt]);
        paramb.a.setOnClickListener(new axld(this, paramInt));
        EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
        return;
      }
      localObject = paramb.a;
      if (paramInt == AEEditorImageClipFragment.a(AEEditorImageClipFragment.this)) {}
      for (boolean bool = true;; bool = false)
      {
        ((ClipThumbnailImageView)localObject).setIsSelected(bool);
        break;
      }
    }
    
    public int getItemCount()
    {
      return AEEditorImageClipFragment.a(AEEditorImageClipFragment.this).size();
    }
  }
  
  public class b
    extends RecyclerView.ViewHolder
  {
    public ClipThumbnailImageView a;
    public View itemView;
    
    public b(View paramView)
    {
      super();
      this.itemView = paramView;
      this.jdField_a_of_type_DovComQqImAeeditorViewClipThumbnailImageView = ((ClipThumbnailImageView)paramView.findViewById(2131379639));
    }
    
    public void setVisibility(boolean paramBoolean)
    {
      ViewGroup.LayoutParams localLayoutParams = this.itemView.getLayoutParams();
      if (localLayoutParams != null)
      {
        if (!paramBoolean) {
          break label65;
        }
        localLayoutParams.height = axog.dip2px(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment.getActivity(), 50.0F);
        localLayoutParams.width = axog.dip2px(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment.getActivity(), 60.0F);
        this.itemView.setVisibility(0);
      }
      for (;;)
      {
        this.itemView.setLayoutParams(localLayoutParams);
        return;
        label65:
        localLayoutParams.height = 0;
        localLayoutParams.width = 0;
        this.itemView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment
 * JD-Core Version:    0.7.0.1
 */