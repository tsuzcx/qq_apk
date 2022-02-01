import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.3;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.7;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.MsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoItem;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextLocation;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextMsgNode;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.f;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.xml.sax.XMLReader;

public class wvd
  implements View.OnClickListener, wvs
{
  private static volatile boolean bgg;
  private ClipData jdField_a_of_type_AndroidContentClipData;
  private Html.TagHandler jdField_a_of_type_AndroidTextHtml$TagHandler = new wvf(this);
  public ImageButton a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  private XEditTextEx.f jdField_a_of_type_ComTencentWidgetXEditTextEx$f = new wvk(this);
  private wvd.a jdField_a_of_type_Wvd$a;
  private ImageButton aj;
  private QQAppInterface app;
  private ClipData b;
  private Context context;
  private ImageButton g;
  private Map<String, Boolean> hF = new HashMap(40);
  private LinearLayout j;
  public View l;
  private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
  private Html.ImageGetter mImageGetter = new wve(this);
  private volatile boolean mIsFullScreenMode;
  private ImageButton n;
  
  static
  {
    if (!wvd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      bgg = true;
      return;
    }
  }
  
  public wvd(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
    this.context = paramBaseChatPie.mContext;
  }
  
  private void CR(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378434);
    if (localView != null)
    {
      if (!(localView.getParent() instanceof RedTouch)) {
        break label77;
      }
      ((View)localView.getParent()).setVisibility(paramInt);
    }
    for (;;)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378435);
      if (localView != null)
      {
        if (!(localView.getParent() instanceof RedTouch)) {
          break;
        }
        ((View)localView.getParent()).setVisibility(paramInt);
      }
      return;
      label77:
      localView.setVisibility(paramInt);
    }
    localView.setVisibility(paramInt);
  }
  
  private Editable a(String paramString)
  {
    paramString = (Editable)Html.fromHtml(paramString, this.mImageGetter, this.jdField_a_of_type_AndroidTextHtml$TagHandler);
    int i = paramString.length();
    int k;
    do
    {
      k = i - 1;
      if (k < 0) {
        break;
      }
      i = k;
    } while (paramString.charAt(k) == "\n".charAt(0));
    return a(paramString.subSequence(0, k + 1));
  }
  
  private MixedMsgInfo.MsgNode a(String paramString, MixedMsgInfo.TextLocation paramTextLocation)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = paramString;
    if (paramTextLocation == MixedMsgInfo.TextLocation.HEADER) {
      str = aofy.x(paramString, true);
    }
    paramString = str;
    if (paramTextLocation == MixedMsgInfo.TextLocation.TAILOR) {
      paramString = aofy.x(str, false);
    }
    return new MixedMsgInfo.TextMsgNode(paramString);
  }
  
  private String a(Spanned paramSpanned)
  {
    paramSpanned = a(paramSpanned);
    if (paramSpanned == null) {
      return "";
    }
    return paramSpanned.text();
  }
  
  private String a(XMLReader paramXMLReader, String paramString)
  {
    try
    {
      Object localObject = paramXMLReader.getClass().getDeclaredField("theNewElement");
      ((Field)localObject).setAccessible(true);
      paramXMLReader = ((Field)localObject).get(paramXMLReader);
      localObject = paramXMLReader.getClass().getDeclaredField("theAtts");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramXMLReader);
      paramXMLReader = localObject.getClass().getDeclaredField("data");
      paramXMLReader.setAccessible(true);
      paramXMLReader = (String[])paramXMLReader.get(localObject);
      Field localField = localObject.getClass().getDeclaredField("length");
      localField.setAccessible(true);
      int k = ((Integer)localField.get(localObject)).intValue();
      int i = 0;
      while (i < k)
      {
        localObject = paramXMLReader[(i * 5 + 1)];
        localField = paramXMLReader[(i * 5 + 4)];
        boolean bool = ((String)localObject).equalsIgnoreCase(paramString);
        if (bool) {
          return localField;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramXMLReader)
    {
      paramXMLReader.printStackTrace();
    }
  }
  
  private Map<Integer, String> a(Spanned paramSpanned)
  {
    int i = 0;
    HashMap localHashMap = new HashMap(20);
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramSpanned.getSpans(0, paramSpanned.length(), ImageSpan.class);
    int k = arrayOfImageSpan.length;
    while (i < k)
    {
      Object localObject = arrayOfImageSpan[i];
      int m = paramSpanned.getSpanStart(localObject);
      localObject = ((ImageSpan)localObject).getSource();
      if ((m >= 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        assert (localObject != null);
        localHashMap.put(Integer.valueOf(m), localObject);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private static boolean a(Editable paramEditable, String paramString)
  {
    if (TextUtils.isEmpty(paramEditable)) {}
    while (paramEditable.charAt(0) != paramString.charAt(0)) {
      return false;
    }
    return true;
  }
  
  private void aK()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getUIHandler().post(new FullScreenInputHelper.7(this));
  }
  
  private static boolean b(Editable paramEditable, String paramString)
  {
    if (TextUtils.isEmpty(paramEditable)) {}
    while (paramEditable.charAt(paramEditable.length() - 1) != paramString.charAt(0)) {
      return false;
    }
    return true;
  }
  
  private void bI()
  {
    anot.a(this.app, "dc00898", "", "", "0X800AD27", "0X800AD27", wg(), 0, "", "", "", "");
    zd(true);
    wja.bcL = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bGP();
    abrb.b(this.app, "full_screen_input", true);
    wja.bcM = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Apat != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Apat.dYw();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Apat.dYu();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Apat.cPD = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bJc();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().ciA();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Afef != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Afef.clearViews();
    }
    ((afdw)this.app.getManager(214)).HJ(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bHf();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bJb();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(8);
    this.j.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Pg());
    this.l.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().width = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(100);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(48);
    this.g.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, 0);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(wja.dp2px(24.0F, this.app.getApplication().getResources()), wja.dp2px(10.0F, this.app.getApplication().getResources()), wja.dp2px(24.0F, this.app.getApplication().getResources()), wja.dp2px(60.0F, this.app.getApplication().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bIX();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bJa();
    CR(8);
    cco();
    if (this.n != null) {
      this.n.setVisibility(0);
    }
    if (this.aj != null) {
      this.aj.setVisibility(0);
    }
  }
  
  private void ccn()
  {
    CR(0);
    if (this.n != null) {
      this.n.setVisibility(8);
    }
    if (this.aj != null) {
      this.aj.setVisibility(8);
    }
  }
  
  private void cco()
  {
    ViewStub localViewStub;
    if (this.n == null)
    {
      localViewStub = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362405);
      if (localViewStub != null)
      {
        this.n = ((ImageButton)localViewStub.inflate());
        this.n.setBackgroundResource(2130838215);
        this.n.setOnClickListener(this);
      }
    }
    if (this.aj == null)
    {
      localViewStub = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362406);
      if (localViewStub != null)
      {
        this.aj = ((ImageButton)localViewStub.inflate());
        this.aj.setBackgroundResource(2130850830);
        this.aj.setOnClickListener(this);
      }
    }
  }
  
  private void doOnPause() {}
  
  private void doOnResume() {}
  
  private boolean gt(int paramInt)
  {
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    if (((ImageSpan[])localEditable.getSpans(0, localEditable.length(), ImageSpan.class)).length + paramInt > 20)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getApp(), 2131696916, 0).show(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getApp().getResources().getDimensionPixelSize(2131299627));
      return true;
    }
    return false;
  }
  
  private String toHtml(Spanned paramSpanned, int paramInt)
  {
    Map localMap = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramSpanned.length())
    {
      char c = paramSpanned.charAt(i);
      String str;
      int k;
      if (c == "￼".charAt(0))
      {
        str = (String)localMap.get(Integer.valueOf(i + paramInt));
        k = i;
        if (!TextUtils.isEmpty(str))
        {
          localStringBuilder.append(hr(str));
          k = i;
        }
      }
      for (;;)
      {
        i = k + 1;
        break;
        if (c == '\n')
        {
          localStringBuilder.append(po());
          k = i;
        }
        else if (c == '\024')
        {
          k = i;
          if (i + 1 < paramSpanned.length())
          {
            i += 1;
            str = cC(paramSpanned.charAt(i));
            localStringBuilder.append(str);
            k = i;
            if (QLog.isColorLevel())
            {
              QLog.d("FullScreenInputHelper", 2, "[mix]getHtmlStr emotionTag: " + str);
              k = i;
            }
          }
        }
        else
        {
          localStringBuilder.append(c);
          k = i;
          if (QLog.isColorLevel())
          {
            QLog.d("FullScreenInputHelper", 2, "[mix]getHtmlStr char: " + c);
            k = i;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]getHtmlStr source: " + paramSpanned + " result: " + localStringBuilder);
    }
    return localStringBuilder.toString();
  }
  
  private int wg()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ;
    if ((i >= 1000) && (i <= 1038)) {
      return 3;
    }
    switch (i)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  private void zd(boolean paramBoolean)
  {
    this.mIsFullScreenMode = paramBoolean;
  }
  
  private void ze(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  public int[] C()
  {
    return new int[] { 5, 13, 9 };
  }
  
  public void Ck(int paramInt)
  {
    if (paramInt == 13) {
      doOnDestroy();
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        doOnResume();
        return;
      }
    } while (paramInt != 9);
    doOnPause();
  }
  
  public void H(ViewGroup paramViewGroup)
  {
    this.l = paramViewGroup.findViewById(2131367805);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramViewGroup.findViewById(2131367801));
    this.g = ((ImageButton)paramViewGroup.findViewById(2131368521));
    this.j = ((LinearLayout)paramViewGroup.findViewById(2131367818));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)paramViewGroup.findViewById(2131367802));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.enableTalkBack)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(acfp.m(2131706667));
      this.g.setContentDescription(acfp.m(2131706664));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new wvg(this) });
    if ((Build.VERSION.SDK_INT >= 23) && (!anlm.ayn()))
    {
      paramViewGroup = new wvh(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomInsertionActionModeCallback(paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomSelectionActionModeCallback(paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$f);
    bgg = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnDragListener(new wvi(this));
    paramViewGroup = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationOnScreen(paramViewGroup);
    paramViewGroup = ajcx.a(paramViewGroup[0], ImageSpan.class);
    ajcx.c(this);
    ajcx.z(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyboardShowListener(paramViewGroup);
  }
  
  public void K(boolean paramBoolean)
  {
    if (!isFullScreenMode()) {
      return;
    }
    zd(false);
    wja.bcL = false;
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bGP();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Ph()) {
        abrb.b(this.app, "full_screen_input", false);
      }
    }
    wja.bcM = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Apat.cPD = false;
    }
    ((afdw)this.app.getManager(214)).HJ(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
    this.j.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.wn(this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled());
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.g.setVisibility(8);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bHg();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -2;
    this.l.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, wja.dp2px(8.0F, this.app.getApplication().getResources()), 0, wja.dp2px(8.0F, this.app.getApplication().getResources()));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(wja.dp2px(14.0F, this.app.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(wja.dp2px(11.0F, this.app.getApplication().getResources()), wja.dp2px(6.0F, this.app.getApplication().getResources()), wja.dp2px(11.0F, this.app.getApplication().getResources()), wja.dp2px(6.0F, this.app.getApplication().getResources()));
      ccn();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, wja.dp2px(8.0F, this.app.getApplication().getResources()), 0, wja.dp2px(8.0F, this.app.getApplication().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(wja.dp2px(14.0F, this.app.getApplication().getResources()), 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(wja.dp2px(11.0F, this.app.getApplication().getResources()), wja.dp2px(6.0F, this.app.getApplication().getResources()), wja.dp2px(11.0F, this.app.getApplication().getResources()), wja.dp2px(6.0F, this.app.getApplication().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getUIHandler().postDelayed(new FullScreenInputHelper.3(this), 100L);
    ccq();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bJa();
    ccn();
  }
  
  boolean RX()
  {
    boolean bool2 = false;
    Object localObject1 = a();
    alkw.a((ClipboardManager)localObject1);
    localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
    Object localObject2 = ((ClipData)localObject1).getDescription();
    int i;
    if ((localObject2 != null) && (((ClipDescription)localObject2).getLabel() != null) && ("FullScreenInputHelper".equalsIgnoreCase(((ClipDescription)localObject2).getLabel().toString())))
    {
      i = 1;
      if ((i == 0) || (this.jdField_a_of_type_AndroidContentClipData == null)) {
        break label357;
      }
      if (localObject1 != null) {
        break label184;
      }
      i = 1;
    }
    label258:
    for (;;)
    {
      if (i != 0) {
        localObject1 = this.jdField_a_of_type_AndroidContentClipData;
      }
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((ClipData)localObject1).getItemCount() == 2)
        {
          bool1 = bool2;
          if (((ClipData)localObject1).getItemAt(1).getIntent() != null)
          {
            localObject1 = ((ClipData)localObject1).getItemAt(1).getIntent().getStringExtra("FullScreenInputHelper");
            localObject2 = a((String)localObject1);
            if (!gt(((ImageSpan[])((Editable)localObject2).getSpans(0, ((Editable)localObject2).length(), ImageSpan.class)).length)) {
              break label258;
            }
            bool1 = true;
          }
        }
      }
      return bool1;
      i = 0;
      break;
      label184:
      if ((this.b != null) && (((ClipData)localObject1).getItemAt(0).getText() != null) && (this.b.getItemAt(0).getText() != null) && (((ClipData)localObject1).getItemAt(0).getText().toString().equals(this.b.getItemAt(0).getText().toString())))
      {
        i = 1;
        continue;
        Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
        localEditable = localEditable.replace(Selection.getSelectionStart(localEditable), Selection.getSelectionEnd(localEditable), (CharSequence)localObject2, 0, ((Editable)localObject2).length());
        if (QLog.isColorLevel()) {
          QLog.d("FullScreenInputHelper", 2, "[mix] ClipBoard paste html: " + (String)localObject1 + " text: " + localObject2 + " result: " + localEditable);
        }
        return true;
      }
      else
      {
        label357:
        i = 0;
      }
    }
  }
  
  public void Z(List<String> paramList, boolean paramBoolean)
  {
    if (gt(paramList.size())) {
      return;
    }
    Editable localEditable1 = a("");
    Editable localEditable2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    int i = Selection.getSelectionStart(localEditable2);
    if ((i > 0) && (!localEditable2.subSequence(0, i).toString().endsWith("\n"))) {
      localEditable1.append("\n");
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localEditable1.append(a(hr(str))).append("\n");
      this.hF.put(str, Boolean.valueOf(paramBoolean));
    }
    if (localEditable2.subSequence(i, localEditable2.length()).toString().startsWith("\n")) {
      localEditable1.delete(localEditable1.length() - 1, localEditable1.length());
    }
    bgg = false;
    localEditable2.insert(i, localEditable1);
    i = Selection.getSelectionStart(localEditable2);
    if (localEditable2.charAt(i - 1) == "￼".charAt(0)) {
      Selection.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), i + 1);
    }
    bgg = true;
    ajcy.fa("0X800AE19", paramList.size());
  }
  
  ClipboardManager a()
  {
    return (ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity.getSystemService("clipboard");
  }
  
  Editable a(CharSequence paramCharSequence)
  {
    return aofr.c.newEditable(paramCharSequence);
  }
  
  public MixedMsgInfo a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
  }
  
  public MixedMsgInfo a(Spanned paramSpanned)
  {
    if (paramSpanned.length() <= 0) {
      return null;
    }
    MixedMsgInfo localMixedMsgInfo = new MixedMsgInfo();
    Object localObject1 = (ImageSpan[])paramSpanned.getSpans(0, paramSpanned.length(), ImageSpan.class);
    Object localObject2 = new SparseArray();
    int k = localObject1.length;
    int i = 0;
    Object localObject3;
    while (i < k)
    {
      localObject3 = localObject1[i];
      ((SparseArray)localObject2).append(paramSpanned.getSpanStart(localObject3), localObject3);
      i += 1;
    }
    k = 0;
    i = 0;
    if (k < ((SparseArray)localObject2).size())
    {
      localObject3 = (ImageSpan)((SparseArray)localObject2).valueAt(k);
      int i1 = paramSpanned.getSpanStart(localObject3);
      int m = paramSpanned.getSpanEnd(localObject3);
      String str = paramSpanned.subSequence(i, i1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "[mix]getMixedText ImageSpan: " + ((ImageSpan)localObject3).getSource() + " {start: " + i1 + " end: " + m + " all: " + paramSpanned.length() + "} prefix: " + str);
      }
      if (k == 0)
      {
        localObject1 = MixedMsgInfo.TextLocation.HEADER;
        label242:
        localMixedMsgInfo.a(a(str, (MixedMsgInfo.TextLocation)localObject1));
        localObject1 = ((ImageSpan)localObject3).getSource();
        localObject3 = (Boolean)this.hF.get(localObject1);
        if (localObject3 == null) {
          break label331;
        }
      }
      label331:
      for (boolean bool = ((Boolean)localObject3).booleanValue();; bool = false)
      {
        localMixedMsgInfo.a(new MixedMsgInfo.PhotoMsgNode(new MixedMsgInfo.PhotoItem((String)localObject1, bool)));
        k += 1;
        i = m;
        break;
        localObject1 = MixedMsgInfo.TextLocation.INLINE;
        break label242;
      }
    }
    localObject1 = paramSpanned.subSequence(i, paramSpanned.length()).toString();
    localMixedMsgInfo.a(a((String)localObject1, MixedMsgInfo.TextLocation.TAILOR));
    localObject2 = localMixedMsgInfo.text();
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]mixedMsgInfo size:" + localMixedMsgInfo.fx().size() + ", result: " + (String)localObject2 + " [start: " + i + " end: " + paramSpanned.length() + "] suffix: " + (String)localObject1);
    }
    return localMixedMsgInfo;
  }
  
  public boolean a(Editable paramEditable)
  {
    if (bgg) {
      this.jdField_a_of_type_Wvd$a.c(paramEditable);
    }
    try
    {
      this.jdField_a_of_type_Wvd$a.e(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      if (this.mIsFullScreenMode) {
        if (paramEditable.length() > 0)
        {
          ze(true);
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
      ze(false);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.OO()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Ph())) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  boolean aw(boolean paramBoolean)
  {
    Object localObject1 = a();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd();
    Object localObject3 = (Spanned)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().subSequence(i, k);
    Object localObject2 = toHtml((Spanned)localObject3, i);
    String str = a((Spanned)localObject3);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]ClipBoard CopyOrCut startIndex: " + i + " endIndex: " + k + " mixed: " + str + " text: " + localObject3 + " html: " + (String)localObject2 + " revert: " + a((String)localObject2));
    }
    localObject3 = ClipData.newPlainText("FullScreenInputHelper", str);
    Intent localIntent = new Intent();
    localIntent.putExtra("FullScreenInputHelper", (String)localObject2);
    ((ClipData)localObject3).addItem(new ClipData.Item(localIntent));
    this.jdField_a_of_type_AndroidContentClipData = ((ClipData)localObject3);
    this.b = ClipData.newPlainText("FullScreenInputHelper", str);
    localObject2 = this.b;
    alkw.a((ClipboardManager)localObject1, (ClipData)localObject2);
    ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      ((Editable)localObject1).delete(i, k);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(k);
    }
  }
  
  public void bIN()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bIN();
    this.hF.clear();
  }
  
  String cC(int paramInt)
  {
    return "<emotion id=\"" + paramInt + "\">";
  }
  
  public void ccp()
  {
    this.mGlobalLayoutListener = new wvj(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
  }
  
  public void ccq()
  {
    float f = Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint().getFontMetrics().bottom - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint().getFontMetrics().top);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxHeight(Math.round(f * 6.0F));
  }
  
  public void ccr()
  {
    this.hF.clear();
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (this.mGlobalLayoutListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[0]);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$f);
    }
    ajcx.c(null);
    ajcx.z(null);
  }
  
  Drawable e(Context paramContext, String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    ThumbWidthHeightDP localThumbWidthHeightDP = ThumbWidthHeightDP.getThumbWidthHeightDP(false);
    int i1 = localThumbWidthHeightDP.mMinWidth;
    int m = localThumbWidthHeightDP.mMinHeight;
    int i2 = localThumbWidthHeightDP.mMaxWidth;
    int i3 = localThumbWidthHeightDP.mMaxHeight;
    int k = localOptions.outWidth;
    int i = localOptions.outHeight;
    float f1;
    if ((k > 0) && (i > 0)) {
      if ((k < i1) || (i < m)) {
        if (k < i)
        {
          f1 = i1 / k;
          m = Math.min((int)(i * f1 + 0.5F), i3);
          i = m;
          k = i1;
          if (QLog.isColorLevel())
          {
            QLog.d("FullScreenInputHelper", 2, "scale1:" + f1);
            k = i1;
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      f1 = paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F;
      k = (int)(k * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
      localOptions.inSampleSize = Utils.calculateInSampleSize(localOptions, k, i);
      localOptions.inJustDecodeBounds = false;
      paramString = ThumbnailUtils.extractThumbnail(ahqz.b(paramString, localOptions, 1, 4), k, i, 2);
      paramContext = new BitmapDrawable(paramContext.getResources(), paramString);
      paramContext.setBounds(0, 0, k, i);
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "thumb drawable setBounds, w:" + k + ", h:" + i);
      }
      return paramContext;
      f1 = m / i;
      i1 = Math.min((int)(k * f1 + 0.5F), i2);
      break;
      if ((k >= i2) || (i >= i3))
      {
        if (k > i)
        {
          f1 = i2 / k;
          label382:
          if (k <= i) {
            break label492;
          }
        }
        label492:
        for (float f2 = m / i;; f2 = i1 / k)
        {
          f1 = Math.max(f1, f2);
          m = (int)(k * f1 + 0.5F);
          i1 = (int)(i * f1 + 0.5F);
          i = i1;
          k = m;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FullScreenInputHelper", 2, "scale2:" + f1);
          i = i1;
          k = m;
          break;
          f1 = i3 / i;
          break label382;
        }
        i = 99;
        k = 99;
      }
    }
  }
  
  public void f(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (bgg)
    {
      this.jdField_a_of_type_Wvd$a = new wvd.a(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "[mix] handleBeforeTextChange mTextChangeInfo: " + this.jdField_a_of_type_Wvd$a);
      }
    }
  }
  
  public int getPicCount()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    if ((localObject != null) && (((Spanned)localObject).length() > 0))
    {
      localObject = (ImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ImageSpan.class);
      if (localObject != null) {
        return localObject.length;
      }
    }
    return 0;
  }
  
  String hr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return "<img src=\"" + paramString + "\">";
  }
  
  public boolean isEmpty()
  {
    return TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
  }
  
  public boolean isFullScreenMode()
  {
    return this.mIsFullScreenMode;
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
      anot.a(this.app, "dc00898", "", "", "0X8009F36", "0X8009F36", wg(), 0, "", "", "", "");
      K(false);
      continue;
      anot.a(this.app, "dc00898", "", "", "0X8009F27", "0X8009F27", wg(), 0, "", "", "", "");
      bI();
      continue;
      anot.a(this.app, "dc00898", "", "", "0X800AD28", "0X800AD28", wg(), 0, "", "", "", "");
      if (getPicCount() > 0) {}
      for (int i = getPicCount();; i = 21)
      {
        ajcy.fa("0X800AE1A", i);
        if (isFullScreenMode()) {
          K(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.send();
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.k(Integer.valueOf(3));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.k(Integer.valueOf(4));
    }
  }
  
  public String pm()
  {
    String str = toHtml(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]getMixedMsgDraft result: " + str);
    }
    return str;
  }
  
  String po()
  {
    return "<newLine>";
  }
  
  public String pp()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    if (localObject == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = localObject.toString().replaceAll("￼", "[图片]");
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("FullScreenInputHelper", 2, "[mix]getMixedMsgInfoText result: " + str);
    return str;
  }
  
  public void xK(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]resetMixedMsgFromDraft draft: " + paramString);
    }
    paramString = a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramString);
  }
  
  static class a
  {
    private Editable b;
    private int bRL;
    private int bRM;
    private int bRN;
    private Editable c;
    private Editable d;
    private Editable e;
    private int type = -1;
    
    a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      this.b = new SpannableStringBuilder(paramCharSequence);
      this.bRL = paramInt1;
      this.bRM = paramInt2;
      this.bRN = paramInt3;
      try
      {
        this.type = cc();
        return;
      }
      catch (Throwable paramCharSequence)
      {
        paramCharSequence.printStackTrace();
      }
    }
    
    Editable b()
    {
      if (this.bRN <= 0) {}
      while (this.c == null) {
        return null;
      }
      return (Editable)this.c.subSequence(this.bRL, this.bRL + this.bRN);
    }
    
    void c(Editable paramEditable)
    {
      this.c = paramEditable;
    }
    
    int cc()
    {
      if (this.b.length() <= 0) {
        return -1;
      }
      Object localObject;
      if ((this.bRM > 0) && (this.bRN > 0))
      {
        this.d = ((Editable)this.b.subSequence(0, this.bRL));
        this.e = ((Editable)this.b.subSequence(this.bRL + this.bRM, this.b.length()));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("[mix]handle replace prefix: ");
          if (TextUtils.isEmpty(this.d)) {
            break label215;
          }
          ((StringBuilder)localObject).append(" prefix tail: ").append(this.d.charAt(this.d.length() - 1));
          ((StringBuilder)localObject).append(" suffix: ");
          if (TextUtils.isEmpty(this.e)) {
            break label225;
          }
          ((StringBuilder)localObject).append(" suffix head: ").append(this.e.charAt(0));
        }
        for (;;)
        {
          QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
          if ((!TextUtils.isEmpty(this.d)) || (!wvd.c(this.e, "￼"))) {
            break label235;
          }
          return 12;
          label215:
          ((StringBuilder)localObject).append("null");
          break;
          label225:
          ((StringBuilder)localObject).append("null");
        }
        label235:
        if ((TextUtils.isEmpty(this.e)) && (wvd.d(this.d, "￼"))) {
          return 13;
        }
        if ((wvd.d(this.d, "￼")) && (wvd.c(this.e, "\n")))
        {
          if ((this.e.length() >= 2) && (this.e.charAt(1) == "￼".charAt(0))) {
            return 14;
          }
          return 15;
        }
        if ((wvd.d(this.d, "\n")) && (wvd.c(this.e, "￼")))
        {
          if ((this.d.length() >= 2) && (this.d.charAt(this.d.length() - 2) == "￼".charAt(0))) {
            return 16;
          }
          return 17;
        }
        return -1;
      }
      if (this.bRM > 0)
      {
        this.d = ((Editable)this.b.subSequence(0, this.bRL));
        this.e = ((Editable)this.b.subSequence(this.bRL + this.bRM, this.b.length()));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("[mix]handle delete prefix: ");
          if (TextUtils.isEmpty(this.d)) {
            break label637;
          }
          ((StringBuilder)localObject).append(" prefix tail: ").append(this.d.charAt(this.d.length() - 1));
          ((StringBuilder)localObject).append(" suffix: ");
          if (TextUtils.isEmpty(this.e)) {
            break label647;
          }
          ((StringBuilder)localObject).append(" suffix head: ").append(this.e.charAt(0));
        }
        for (;;)
        {
          QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
          localObject = this.b.subSequence(this.bRL, this.bRL + this.bRM).toString();
          if ((((String)localObject).length() != 1) || (!((String)localObject).equals("\n"))) {
            break label737;
          }
          if ((!wvd.d(this.d, "￼")) || (!wvd.c(this.e, "￼"))) {
            break label657;
          }
          return 6;
          label637:
          ((StringBuilder)localObject).append("null");
          break;
          label647:
          ((StringBuilder)localObject).append("null");
        }
        label657:
        if ((!wvd.d(this.d, "￼")) && (!wvd.d(this.d, "\n")) && (wvd.c(this.e, "￼"))) {
          return 8;
        }
        if ((wvd.d(this.d, "￼")) && (!wvd.c(this.e, "￼")) && (!wvd.c(this.e, "\n"))) {
          return 7;
        }
        return -1;
        label737:
        if ((wvd.d(this.d, "￼")) && (wvd.c(this.e, "￼"))) {
          return 9;
        }
        if ((!wvd.d(this.d, "￼")) && (!wvd.d(this.d, "\n")) && (wvd.c(this.e, "￼"))) {
          return 10;
        }
        if ((wvd.d(this.d, "￼")) && (!wvd.c(this.e, "￼")) && (!wvd.c(this.e, "\n"))) {
          return 11;
        }
        return -1;
      }
      if (this.bRN > 0)
      {
        this.d = ((Editable)this.b.subSequence(0, this.bRL));
        this.e = ((Editable)this.b.subSequence(this.bRL, this.b.length()));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("[mix]handle add prefix: ");
          if (TextUtils.isEmpty(this.d)) {
            break label1032;
          }
          ((StringBuilder)localObject).append(" prefix tail: ").append(this.d.charAt(this.d.length() - 1));
          ((StringBuilder)localObject).append(" suffix: ");
          if (TextUtils.isEmpty(this.e)) {
            break label1042;
          }
          ((StringBuilder)localObject).append(" suffix head: ").append(this.e.charAt(0));
        }
        for (;;)
        {
          QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
          if ((!TextUtils.isEmpty(this.d)) || (!wvd.c(this.e, "￼"))) {
            break label1052;
          }
          return 0;
          label1032:
          ((StringBuilder)localObject).append("null");
          break;
          label1042:
          ((StringBuilder)localObject).append("null");
        }
        label1052:
        if ((TextUtils.isEmpty(this.e)) && (wvd.d(this.d, "￼"))) {
          return 1;
        }
        if ((wvd.d(this.d, "￼")) && (wvd.c(this.e, "\n")))
        {
          if ((this.e.length() >= 2) && (this.e.charAt(1) == "￼".charAt(0))) {
            return 2;
          }
          return 3;
        }
        if ((wvd.d(this.d, "\n")) && (wvd.c(this.e, "￼")))
        {
          if ((this.d.length() >= 2) && (this.d.charAt(this.d.length() - 2) == "￼".charAt(0))) {
            return 4;
          }
          return 5;
        }
        return -1;
      }
      return -1;
    }
    
    void e(EditText paramEditText)
    {
      int k = 2;
      if (this.c.length() <= 0) {
        return;
      }
      Editable localEditable = b();
      paramEditText = paramEditText.getText();
      int i = Selection.getSelectionStart(paramEditText);
      int j = i;
      if (this.bRL == this.b.length())
      {
        j = i;
        if (wvd.d(localEditable, "￼"))
        {
          localEditable.append("\n");
          j = i + 1;
        }
      }
      switch (this.type)
      {
      default: 
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("FullScreenInputHelper", 2, "[mix] handle other at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
          i = j;
        }
        break;
      }
      while (this.type != -1)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(this.d)) {
          localSpannableStringBuilder.append(this.d);
        }
        if (!TextUtils.isEmpty(localEditable)) {
          localSpannableStringBuilder.append(localEditable);
        }
        if (!TextUtils.isEmpty(this.e)) {
          localSpannableStringBuilder.append(this.e);
        }
        wvd.B(false);
        paramEditText.replace(0, paramEditText.length(), localSpannableStringBuilder);
        Selection.setSelection(paramEditText, Math.min(i, localSpannableStringBuilder.length()));
        wvd.B(true);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FullScreenInputHelper", 2, "[mix] handle add '_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
        }
        localEditable.append("\n");
        i = j;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[img]_' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
        }
        localEditable.insert(0, "\n");
        i = j + 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[img]_\\n[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
        }
        i = j;
        if (!wvd.c(localEditable, "\n"))
        {
          localEditable.insert(0, "\n");
          i = j + 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[img]_\\n[text]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
          }
          i = j;
          if (!wvd.c(localEditable, "\n"))
          {
            localEditable.insert(0, "\n");
            if (wvd.d(localEditable, "￼")) {}
            for (;;)
            {
              i = j + k;
              break;
              k = 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[img]\\n_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
            }
            i = j;
            if (!wvd.d(localEditable, "\n"))
            {
              localEditable.append("\n");
              i = j;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[text]\\n_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
              }
              i = j;
              if (!wvd.d(localEditable, "\n"))
              {
                localEditable.append("\n");
                i = j;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle del line '[img]_\\n_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                this.d.delete(this.d.length() - 1, this.d.length());
                i = j - 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle del line '[text]_\\n_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                this.d.delete(this.d.length() - 1, this.d.length());
                this.d.append("\n");
                i = j - 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle del line '[img]_\\n_[text]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                this.d.delete(this.d.length() - 1, this.d.length());
                i = j - 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle del '[img]_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                this.d.append("\n");
                i = j - 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle del '[text]_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                this.d.append("\n");
                i = j;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle del '[img]_[text]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                this.d.append("\n");
                i = j + 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                localEditable.append("\n");
                i = j + 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[img]_' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                localEditable.insert(0, "\n");
                i = j + 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[img]_\\n[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                }
                i = j;
                if (!wvd.c(localEditable, "\n"))
                {
                  localEditable.insert(0, "\n");
                  i = j + 1;
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[img]_\\n[text]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                  }
                  i = j;
                  if (!wvd.c(localEditable, "\n"))
                  {
                    localEditable.insert(0, "\n");
                    if (wvd.d(localEditable, "￼")) {}
                    for (;;)
                    {
                      i = j + k;
                      break;
                      k = 1;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[img]\\n_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                    }
                    i = j;
                    if (!wvd.d(localEditable, "\n"))
                    {
                      localEditable.append("\n");
                      i = j - 1;
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[text]\\n_[img]' at position: " + this.bRL + " prefix: " + this.d + " suffix: " + this.e);
                      }
                      i = j;
                      if (!wvd.d(localEditable, "\n"))
                      {
                        localEditable.append("\n");
                        i = j - 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    @NotNull
    public String toString()
    {
      return "<TextChangeInfo> {textBefore: " + this.b + " textAfter: " + this.c + " indexChange: " + this.bRL + " countAdded: " + this.bRN + " countDeleted: " + this.bRM + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvd
 * JD-Core Version:    0.7.0.1
 */