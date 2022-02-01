import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet.10;
import com.tencent.widget.ActionSheet.5;
import com.tencent.widget.ActionSheet.6;
import com.tencent.widget.ActionSheet.7;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ausj
  extends ReportDialog
{
  private List<Integer> Lh = new ArrayList();
  private ausj.b jdField_a_of_type_Ausj$b;
  private ausj.f jdField_a_of_type_Ausj$f;
  private TranslateAnimation animation;
  private ausj.c jdField_b_of_type_Ausj$c;
  private ausj.e jdField_b_of_type_Ausj$e;
  private boolean djT;
  private int esn;
  private int eso;
  private View.OnClickListener gF;
  private ausj.a l;
  private HashMap<CharSequence, ausi> mActionMenuMap = new HashMap();
  private RelativeLayout mActionView;
  private int mAnimationTime = 300;
  private View.OnClickListener mBtnClickListener = new ausp(this);
  private CharSequence mCancelText;
  private boolean mCloseAutoRead;
  public LinearLayout mContentContainer;
  private ArrayList<Pair<CharSequence, Integer>> mContents;
  private Context mContext;
  private int mCurrentSelectedViewId = -1;
  public View.OnClickListener mDefaultDismissListener = new ausq(this);
  private boolean mDismissFinish = true;
  private Handler mHandler;
  private boolean mHasCustomeHeader;
  private HashMap<Integer, Integer> mIconsLayoutLeftMap = new HashMap();
  private HashMap<Integer, Drawable> mIconsLeftMap = new HashMap();
  private HashMap<Integer, Drawable> mIconsMap = new HashMap();
  private LayoutInflater mInflater;
  private boolean mIsMenuMode;
  public boolean mIsReady;
  private CharSequence mMainTitle;
  private SparseArray<View> mRadioButtonMap;
  private boolean mRadioGroupMode;
  protected Resources mResources;
  private ViewGroup mRootView;
  private CharSequence mSecondaryTitle;
  private boolean mShowAnimation = true;
  protected boolean mSupportBottomRadius;
  private HashMap<Integer, String> mTextColorMap = new HashMap();
  private HashSet<Integer> mUncheckeable;
  public Object mUserData;
  private TextView mainTitleText;
  private View.OnClickListener onBottomCancelListener;
  private Map<Integer, ausj.d> pM = new HashMap();
  private Map<Integer, URLDrawable> pN = new HashMap();
  
  protected ausj(Context paramContext)
  {
    this(paramContext, false, false);
  }
  
  protected ausj(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true, -1, null);
  }
  
  @TargetApi(14)
  protected ausj(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramContext, 2131755428);
    Window localWindow = getWindow();
    if (Build.VERSION.SDK_INT >= 14) {
      localWindow.setDimAmount(0.5F);
    }
    this.mContext = paramContext;
    this.mIsMenuMode = paramBoolean1;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mResources = paramContext.getResources();
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramBoolean3) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localWindow.addFlags(67108864);
    }
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      localWindow.setFlags(1024, 1024);
    }
    ImmersiveUtils.clearCoverForStatus(localWindow, true);
    paramContext = this.mInflater;
    if (paramInt != -1)
    {
      this.mRootView = ((ViewGroup)paramContext.inflate(paramInt, null));
      if (paramLayoutParams == null) {
        break label360;
      }
      super.setContentView(this.mRootView, paramLayoutParams);
    }
    for (;;)
    {
      this.mActionView = ((RelativeLayout)this.mRootView.findViewById(2131362000));
      this.mContentContainer = ((LinearLayout)this.mRootView.findViewById(2131362008));
      this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
      this.mActionView.setOnClickListener(null);
      this.onBottomCancelListener = this.mDefaultDismissListener;
      return;
      paramInt = 2131558463;
      break;
      label360:
      super.setContentView(this.mRootView);
    }
  }
  
  public static ausj a(Context paramContext, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = new ausj(paramContext, false, false, true, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  public static ausj a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ausj(paramContext, false, true, paramBoolean, -1, null);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  private CharSequence a(CharSequence paramCharSequence, Drawable paramDrawable)
  {
    paramCharSequence = new SpannableStringBuilder("icon" + paramCharSequence);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramDrawable = new VerticalCenterImageSpan(paramDrawable, 0);
    paramDrawable.setPadding(aqnm.dip2px(6.5F), aqnm.dip2px(6.5F));
    paramCharSequence.setSpan(paramDrawable, 0, "icon".length(), 18);
    return paramCharSequence;
  }
  
  private void a(Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if ((paramPair == null) || (paramTextView == null)) {}
    URLDrawable localURLDrawable;
    do
    {
      do
      {
        do
        {
          return;
        } while ((((Integer)paramPair.second).intValue() != 10) || (paramPair.first == null));
        a((CharSequence)paramPair.first, new ausl(this, paramTextView));
      } while (!this.pN.containsKey(Integer.valueOf(((CharSequence)paramPair.first).hashCode())));
      localURLDrawable = (URLDrawable)this.pN.get(Integer.valueOf(((CharSequence)paramPair.first).hashCode()));
    } while (localURLDrawable == null);
    QLog.i("ActionSheet", 1, "prepareContentViews " + localURLDrawable);
    if (localURLDrawable.getStatus() == 1)
    {
      paramTextView.setText(a((CharSequence)paramPair.first, localURLDrawable));
      return;
    }
    a(localURLDrawable, paramPair, paramTextView);
  }
  
  private void a(URLDrawable paramURLDrawable, Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if ((paramURLDrawable == null) || (paramPair == null) || (paramTextView == null)) {
      return;
    }
    paramURLDrawable.setURLDrawableListener(new ausm(this, paramTextView, paramPair));
    paramURLDrawable.setDownloadListener(new ausn(this));
    ThreadManagerV2.executeOnSubThread(new ActionSheet.5(this, paramURLDrawable));
  }
  
  private void a(CharSequence paramCharSequence, ausj.d paramd)
  {
    if ((paramCharSequence == null) || (paramd == null)) {
      return;
    }
    int i = paramCharSequence.hashCode();
    this.pM.put(Integer.valueOf(i), paramd);
  }
  
  public static ausj b(Context paramContext)
  {
    paramContext = new ausj(paramContext, false, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  public static ausj c(Context paramContext)
  {
    paramContext = new ausj(paramContext, false, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  public static ausj d(Context paramContext)
  {
    paramContext = new ausj(paramContext, true, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  public static ausj e(Context paramContext)
  {
    paramContext = new ausj(paramContext, true, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  private void prepareContentViews()
  {
    if (this.mIsReady) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.mMainTitle != null)
    {
      localObject1 = this.mInflater.inflate(jV(), null);
      ((View)localObject1).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130837648));
      ((View)localObject1).setOnClickListener(new ausk(this));
      this.mainTitleText = ((TextView)((View)localObject1).findViewById(2131362018));
      this.mainTitleText.setVisibility(0);
      this.mainTitleText.setMaxLines(2147483647);
      this.mainTitleText.setText(this.mMainTitle);
      this.mainTitleText.setContentDescription(this.mMainTitle);
      if (this.mSecondaryTitle != null)
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131362015);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.mSecondaryTitle);
        ((TextView)localObject2).setContentDescription(this.mSecondaryTitle);
      }
      this.mContentContainer.addView((View)localObject1, 0);
    }
    for (int i = 1;; i = 0)
    {
      if (this.mHasCustomeHeader) {
        i = 1;
      }
      if (this.mContents != null)
      {
        int j = i + this.mContents.size();
        int k = this.mContents.size();
        if ((k != this.Lh.size()) && (this.Lh.size() != 0)) {
          throw new IllegalArgumentException("buttons size and custom ids size not match");
        }
        i = 0;
        if (i < k)
        {
          localObject1 = (Pair)this.mContents.get(i);
          View localView;
          Object localObject3;
          if (((Integer)((Pair)localObject1).second).intValue() == 65537)
          {
            localView = this.mInflater.inflate(jW(), null);
            localObject2 = (TextView)localView.findViewById(2131362005);
            localObject3 = (TextView)localView.findViewById(2131379000);
            Object localObject4 = ((CharSequence)((Pair)localObject1).first).toString();
            int m = ((String)localObject4).indexOf('\n');
            if ((m >= 0) && (m < ((CharSequence)((Pair)localObject1).first).length()))
            {
              ((TextView)localObject2).setText(((String)localObject4).substring(0, m));
              ((TextView)localObject3).setText(((String)localObject4).substring(m + 1));
              localView.findViewById(2131364103).setContentDescription(((TextView)localObject2).getText());
              label408:
              aqcl.changeAccessibilityForView(localView.findViewById(2131364103), LinearLayout.class.getName());
              label425:
              a((Pair)localObject1, (TextView)localObject2);
              if ((this.mActionMenuMap != null) && (this.mActionMenuMap.size() > 0))
              {
                localObject3 = (ausi)this.mActionMenuMap.get(((Pair)localObject1).first);
                if ((localObject3 != null) && (((ausi)localObject3).viewid != 0)) {
                  ((TextView)localObject2).setId(((ausi)localObject3).viewid);
                }
              }
              localObject3 = (ImageView)localView.findViewById(2131362016);
              localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject4).rightMargin = aqcx.dip2px(this.mContext, 15.0F);
              ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              if (!this.mIconsMap.containsKey(Integer.valueOf(i))) {
                break label1011;
              }
              ((ImageView)localObject3).setVisibility(0);
              ((ImageView)localObject3).setImageDrawable((Drawable)this.mIconsMap.get(Integer.valueOf(i)));
              label574:
              localObject3 = (ImageView)localView.findViewById(2131362017);
              localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
              if ((this.mIconsLayoutLeftMap.containsKey(Integer.valueOf(i))) && (((Integer)this.mIconsLayoutLeftMap.get(Integer.valueOf(i))).intValue() == 0))
              {
                ((RelativeLayout.LayoutParams)localObject4).width = aqcx.dip2px(this.mContext, 28.0F);
                ((RelativeLayout.LayoutParams)localObject4).height = aqcx.dip2px(this.mContext, 28.0F);
                ((RelativeLayout.LayoutParams)localObject4).addRule(15);
              }
              ((RelativeLayout.LayoutParams)localObject4).rightMargin = aqcx.dip2px(this.mContext, 5.0F);
              ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              if (!this.mIconsLeftMap.containsKey(Integer.valueOf(i))) {
                break label1027;
              }
              ((ImageView)localObject3).setVisibility(0);
              ((ImageView)localObject3).setImageDrawable((Drawable)this.mIconsLeftMap.get(Integer.valueOf(i)));
              label729:
              if (((Integer)((Pair)localObject1).second).intValue() != 9) {
                break label1043;
              }
              if (this.mTextColorMap.containsKey(Integer.valueOf(i))) {
                ((TextView)localObject2).setTextColor(Color.parseColor((String)this.mTextColorMap.get(Integer.valueOf(i))));
              }
              label781:
              if ((!this.mSupportBottomRadius) || (j <= 1) || (i != k - 1) || (this.mCancelText != null)) {
                break label1066;
              }
              localObject1 = getSelectorByType(4);
              label814:
              localView.setBackgroundDrawable((Drawable)localObject1);
              if (i >= this.Lh.size()) {
                break label1163;
              }
              localView.setId(((Integer)this.Lh.get(i)).intValue());
              label855:
              localView.setOnClickListener(this.mBtnClickListener);
              this.mContentContainer.addView(localView);
              if (this.mRadioGroupMode)
              {
                if (this.mRadioButtonMap == null) {
                  this.mRadioButtonMap = new SparseArray();
                }
                this.mRadioButtonMap.append(i, localView);
                if (i != this.mCurrentSelectedViewId) {
                  break label1172;
                }
                localView.findViewById(2131362006).setVisibility(0);
                updateRadioGroupButtonDesc((TextView)localObject2, true);
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
            break label408;
            localView = this.mInflater.inflate(2131558466, null);
            localObject2 = (TextView)localView.findViewById(2131362005);
            ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
            aqcl.changeAccessibilityForView((View)localObject2, Button.class.getName());
            break label425;
            label1011:
            ((ImageView)localObject3).setImageDrawable(null);
            ((ImageView)localObject3).setVisibility(8);
            break label574;
            label1027:
            ((ImageView)localObject3).setImageDrawable(null);
            ((ImageView)localObject3).setVisibility(8);
            break label729;
            label1043:
            ((TextView)localObject2).setTextColor(getActionButtonColorByType(((Integer)((Pair)localObject1).second).intValue()));
            break label781;
            label1066:
            if ((i == 0) && (j == k) && (j == 1))
            {
              localObject1 = getSelectorByType(0);
              break label814;
            }
            if ((i == 0) && (j == k) && (j > 1))
            {
              if (this.djT)
              {
                localObject1 = getSelectorByType(1);
                break label814;
              }
              localObject1 = getSelectorByType(3);
              break label814;
            }
            if ((i == k - 1) && (j > 1))
            {
              localObject1 = getSelectorByType(0);
              break label814;
            }
            localObject1 = getSelectorByType(3);
            break label814;
            label1163:
            localView.setId(i);
            break label855;
            label1172:
            updateRadioGroupButtonDesc((TextView)localObject2, false);
          }
        }
      }
      if (this.mCancelText != null)
      {
        localObject1 = this.mInflater.inflate(jX(), null);
        if (this.esn != 0)
        {
          localObject2 = (Button)((View)localObject1).findViewById(2131362003);
          ((Button)localObject2).setVisibility(0);
          ((Button)localObject2).setText(this.esn);
          ((Button)localObject2).setTextColor(this.eso);
          ((Button)localObject2).setContentDescription(this.mCancelText);
          if (this.gF != null) {
            ((Button)localObject2).setOnClickListener(this.gF);
          }
        }
        localObject2 = (Button)((View)localObject1).findViewById(2131362004);
        ((Button)localObject2).setOnClickListener(this.onBottomCancelListener);
        ((Button)localObject2).setText(this.mCancelText);
        ((Button)localObject2).setContentDescription(this.mCancelText);
        this.mContentContainer.addView((View)localObject1);
      }
      this.mIsReady = true;
      return;
    }
  }
  
  private void updateRadioGroupButtonDesc(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramTextView.setContentDescription(getContext().getString(2131692132) + paramTextView.getText());
      return;
    }
    paramTextView.setContentDescription(getContext().getString(2131692134) + paramTextView.getText());
  }
  
  public void Wc(boolean paramBoolean)
  {
    this.djT = paramBoolean;
  }
  
  public ausi a(int paramInt)
  {
    return a(getContent(paramInt));
  }
  
  public ausi a(CharSequence paramCharSequence)
  {
    if (this.mActionMenuMap == null) {
      return null;
    }
    return (ausi)this.mActionMenuMap.get(paramCharSequence);
  }
  
  public void a(ausi paramausi, int paramInt)
  {
    if (paramausi == null) {
      return;
    }
    this.mActionMenuMap.put(paramausi.content, paramausi);
    addButton(paramausi.content, paramInt);
  }
  
  public void a(ausj.a parama)
  {
    this.l = parama;
  }
  
  public void a(ausj.b paramb)
  {
    this.jdField_a_of_type_Ausj$b = paramb;
  }
  
  public void a(ausj.c paramc)
  {
    this.jdField_b_of_type_Ausj$c = paramc;
  }
  
  public void a(ausj.e parame)
  {
    this.jdField_b_of_type_Ausj$e = parame;
  }
  
  public void a(ausj.f paramf)
  {
    this.jdField_a_of_type_Ausj$f = paramf;
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, @IdRes int paramInt2)
  {
    this.Lh.add(Integer.valueOf(paramInt2));
    addButton(paramCharSequence, paramInt1);
  }
  
  public void addButton(int paramInt)
  {
    addButton(this.mResources.getText(paramInt), 0);
  }
  
  public void addButton(int paramInt1, int paramInt2)
  {
    addButton(this.mResources.getText(paramInt1), paramInt2);
  }
  
  public void addButton(CharSequence paramCharSequence)
  {
    addButton(paramCharSequence, 0);
  }
  
  public void addButton(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.mContents.contains(paramCharSequence)) {
        this.mContents.add(paramCharSequence);
      }
      if (this.mRadioGroupMode) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void addButton(CharSequence paramCharSequence, int paramInt, String paramString)
  {
    if (paramCharSequence != null)
    {
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      if (TextUtils.isEmpty(paramString)) {
        paramInt = 0;
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.mContents.contains(paramCharSequence)) {
        this.mContents.add(paramCharSequence);
      }
      if (paramInt == 9) {
        this.mTextColorMap.put(Integer.valueOf(this.mContents.size() - 1), paramString);
      }
      if (this.mRadioGroupMode) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void addButtonWithIcon(CharSequence paramCharSequence, Drawable paramDrawable, int paramInt)
  {
    if (this.mContents == null) {
      this.mContents = new ArrayList();
    }
    paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
    if (!this.mContents.contains(paramCharSequence)) {
      this.mContents.add(paramCharSequence);
    }
    this.mIconsMap.put(Integer.valueOf(this.mContents.size() - 1), paramDrawable);
  }
  
  public void addButtonWithRightIcon(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mContents == null) {
      this.mContents = new ArrayList();
    }
    Object localObject = this.mResources.getDrawable(paramInt1);
    if (localObject == null) {}
    do
    {
      return;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString + "icon");
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
      ((VerticalCenterImageSpan)localObject).setPadding(wja.dp2px(10.0F, this.mResources), 0);
      localSpannableStringBuilder.setSpan(localObject, paramString.length(), localSpannableStringBuilder.length(), 18);
      paramString = new Pair(localSpannableStringBuilder, Integer.valueOf(paramInt2));
    } while (this.mContents.contains(paramString));
    this.mContents.add(paramString);
  }
  
  public void addCancelButton(int paramInt)
  {
    addCancelButton(this.mResources.getText(paramInt));
  }
  
  public void addCancelButton(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.mCancelText = paramCharSequence;
    }
  }
  
  public void addRadioButton(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    addRadioButton(this.mResources.getText(paramInt1), paramInt2, paramBoolean);
  }
  
  public void addRadioButton(int paramInt, boolean paramBoolean)
  {
    addRadioButton(paramInt, 0, paramBoolean);
  }
  
  public void addRadioButton(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    addRadioButton(paramCharSequence, paramInt, paramBoolean, true);
  }
  
  public void addRadioButton(CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCharSequence != null)
    {
      if ((!this.mRadioGroupMode) && (this.mContents != null) && (this.mContents.size() > 0)) {
        throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
      }
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.mContents.contains(paramCharSequence)) {
        this.mContents.add(paramCharSequence);
      }
      if (paramBoolean2) {
        break label139;
      }
      if (this.mUncheckeable == null) {
        this.mUncheckeable = new HashSet();
      }
      this.mUncheckeable.add(Integer.valueOf(this.mContents.size() - 1));
    }
    for (;;)
    {
      this.mRadioGroupMode = true;
      return;
      label139:
      if (paramBoolean1) {
        this.mCurrentSelectedViewId = (this.mContents.size() - 1);
      }
    }
  }
  
  public void addRadioButton(CharSequence paramCharSequence, boolean paramBoolean)
  {
    addRadioButton(paramCharSequence, 0, paramBoolean);
  }
  
  public void addView(View paramView)
  {
    this.mContentContainer.addView(paramView);
  }
  
  public void addViewCustomeTitle(View paramView)
  {
    this.mHasCustomeHeader = true;
    this.mContentContainer.addView(paramView);
  }
  
  public void bk(int paramInt1, int paramInt2, @IdRes int paramInt3)
  {
    this.Lh.add(Integer.valueOf(paramInt3));
    addButton(paramInt1, paramInt2);
  }
  
  public void clear()
  {
    this.mIsReady = false;
    this.mContents.clear();
    this.mActionMenuMap.clear();
    this.mIconsMap.clear();
    this.mIconsLeftMap.clear();
    this.mIconsLayoutLeftMap.clear();
    this.mTextColorMap.clear();
    this.mActionView.removeAllViews();
  }
  
  public void clearAllRadioBtnCheckStatus()
  {
    this.mCurrentSelectedViewId = -1;
    if (this.mRadioButtonMap == null) {}
    for (;;)
    {
      return;
      int j = this.mRadioButtonMap.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)this.mRadioButtonMap.valueAt(i);
        if (localView != null)
        {
          localView.findViewById(2131362006).setVisibility(8);
          updateRadioGroupButtonDesc((TextView)localView.findViewById(2131362005), false);
        }
        i += 1;
      }
    }
  }
  
  public void dismiss()
  {
    if (this.jdField_b_of_type_Ausj$e != null) {
      this.jdField_b_of_type_Ausj$e.onDismissOperations();
    }
    if (this.mDismissFinish)
    {
      this.mDismissFinish = false;
      this.mHandler.postDelayed(new ActionSheet.7(this), 0L);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((this.mCloseAutoRead) && (paramAccessibilityEvent.getEventType() == 32)) {
      return true;
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  protected int getActionButtonColorByType(int paramInt)
  {
    switch (0xFFFF & paramInt)
    {
    default: 
      return this.mResources.getColor(2131165226);
    case 0: 
      return this.mResources.getColor(2131165226);
    case 1: 
      return this.mResources.getColor(2131165226);
    case 2: 
      return this.mResources.getColor(2131165226);
    case 4: 
      return this.mResources.getColor(2131165226);
    case 3: 
      return this.mResources.getColor(2131165230);
    case 5: 
      return this.mResources.getColor(2131165226);
    case 6: 
      return this.mResources.getColor(2131165226);
    case 7: 
      return this.mResources.getColor(2131165226);
    }
    return this.mResources.getColor(2131165906);
  }
  
  public RelativeLayout getActionContentView()
  {
    return this.mActionView;
  }
  
  public String getContent(int paramInt)
  {
    if ((this.mContents != null) && (paramInt < this.mContents.size()))
    {
      Pair localPair = (Pair)this.mContents.get(paramInt);
      if (localPair != null) {
        return ((CharSequence)localPair.first).toString();
      }
    }
    return null;
  }
  
  public ViewGroup getRootView()
  {
    return this.mRootView;
  }
  
  public Drawable getSelectorByType(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.mResources.getDrawable(2130837647);
    case 1: 
      return this.mResources.getDrawable(2130837675);
    case 0: 
      return this.mResources.getDrawable(2130837644);
    case 3: 
      return this.mResources.getDrawable(2130837647);
    }
    return this.mResources.getDrawable(2130837651);
  }
  
  protected int jV()
  {
    return 2131558467;
  }
  
  protected int jW()
  {
    return 2131558468;
  }
  
  protected int jX()
  {
    return 2131558465;
  }
  
  public void jm(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      return;
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject);
      if (localURLDrawable != null) {
        ThreadManagerV2.executeOnSubThread(new ActionSheet.10(this, localURLDrawable));
      }
      if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1))
      {
        localObject = new Pair(paramString1, Integer.valueOf(10));
        paramString2 = (String)localObject;
        if (localURLDrawable != null) {
          this.pN.put(Integer.valueOf(paramString1.hashCode()), localURLDrawable);
        }
      }
      for (paramString2 = (String)localObject; !this.mContents.contains(paramString2); paramString2 = new Pair(a(paramString1, localURLDrawable), Integer.valueOf(10)))
      {
        this.mContents.add(paramString2);
        return;
      }
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mIsMenuMode) {}
    try
    {
      dismiss();
      label11:
      return super.onPrepareOptionsMenu(paramMenu);
    }
    catch (Exception localException)
    {
      break label11;
    }
  }
  
  public void setActionContentView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.mActionView.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.mActionView.addView(paramView, localLayoutParams);
    }
  }
  
  public void setAnimationTime(int paramInt)
  {
    if (paramInt > 0) {
      this.mAnimationTime = paramInt;
    }
  }
  
  public void setCloseAutoRead(boolean paramBoolean)
  {
    this.mCloseAutoRead = paramBoolean;
  }
  
  public void setContentView(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setContentView(View paramView)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setMainTitle(int paramInt)
  {
    setMainTitle(this.mResources.getText(paramInt));
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.mMainTitle = paramCharSequence;
    }
  }
  
  public void setOnBottomCancelListener(View.OnClickListener paramOnClickListener)
  {
    this.onBottomCancelListener = paramOnClickListener;
  }
  
  public void setOutsideDismissEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mRootView.setOnClickListener(this.mDefaultDismissListener);
      return;
    }
    this.mRootView.setOnClickListener(null);
  }
  
  public void setOutsideDismissEnableCompat(boolean paramBoolean)
  {
    if ((this.mRootView != null) && (this.mRootView.getChildAt(0) != null))
    {
      if (paramBoolean) {
        this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
      }
    }
    else {
      return;
    }
    this.mRootView.getChildAt(0).setOnClickListener(null);
  }
  
  public void setRadioButtonChecked(int paramInt)
  {
    if ((paramInt >= 0) && (this.mContents != null) && (paramInt < this.mContents.size()))
    {
      this.mCurrentSelectedViewId = paramInt;
      if (this.mRadioButtonMap != null)
      {
        View localView = (View)this.mRadioButtonMap.get(this.mCurrentSelectedViewId);
        if (localView != null)
        {
          localView.findViewById(2131362006).setVisibility(0);
          updateRadioGroupButtonDesc((TextView)localView.findViewById(2131362005), true);
        }
      }
    }
  }
  
  public void setSecondaryTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.mSecondaryTitle = paramCharSequence;
    }
  }
  
  public void setSupportBottomRadius(boolean paramBoolean)
  {
    this.mSupportBottomRadius = paramBoolean;
  }
  
  public void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void show()
  {
    this.mRootView.setVisibility(0);
    super.show();
    prepareContentViews();
    this.mHandler.postDelayed(new ActionSheet.6(this), 0L);
  }
  
  /* Error */
  public void superDismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 912	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 918	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 918	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 918	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   20: aload_1
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	ausj
    //   9	1	1	localException	Exception
    //   15	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	9	java/lang/Exception
    //   0	4	15	finally
  }
  
  public void updateAllButton()
  {
    this.mIsReady = false;
    this.mContentContainer.removeAllViews();
    prepareContentViews();
  }
  
  public void updateButton(int paramInt, CharSequence paramCharSequence)
  {
    updateButton(paramInt, paramCharSequence, 0);
  }
  
  public void updateButton(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramInt1 >= 0) && (this.mContents != null) && (paramInt1 < this.mContents.size()))
    {
      Object localObject = this.mContentContainer.findViewById(paramInt1);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131362005);
        if ((localObject != null) && (TextView.class.isInstance(localObject)))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setText(paramCharSequence);
          ((TextView)localObject).setTextColor(getActionButtonColorByType(paramInt2));
          paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt2));
          this.mContents.set(paramInt1, paramCharSequence);
        }
      }
    }
  }
  
  public void updateUI()
  {
    this.mIsReady = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    this.mActionView.invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void OnClick(View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void OnClick(View paramView, int paramInt, String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void onDismiss();
  }
  
  static abstract interface d {}
  
  public static abstract interface e
  {
    public abstract void onDismissOperations();
  }
  
  public static abstract interface f
  {
    public abstract void onPreShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausj
 * JD-Core Version:    0.7.0.1
 */