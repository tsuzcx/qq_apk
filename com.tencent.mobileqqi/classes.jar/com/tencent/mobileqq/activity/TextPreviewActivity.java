package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;
import com.tencent.widget.ScrollView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(11)
public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static long a = 0L;
  public static final String a = "uin_type";
  public static final boolean a = true;
  public static final String b = "content";
  public static final String c = "uniseq";
  public static final String d = "peeruin";
  public static final String e = "bubbleId";
  public static final String f = "scrollToBubble";
  public int a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ContainerView jdField_a_of_type_ComTencentMobileqqWidgetContainerView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  public String g = null;
  private String h;
  
  public TextPreviewActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(TextView paramTextView)
  {
    try
    {
      Object localObject = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject).setAccessible(true);
      paramTextView = ((Field)localObject).get(paramTextView);
      if (paramTextView == null) {
        return;
      }
      localObject = Class.forName("android.widget.Editor");
      if (localObject != null)
      {
        localObject = ((Class)localObject).getDeclaredMethod("performLongClick", new Class[] { Boolean.TYPE });
        if (localObject != null)
        {
          ((Method)localObject).invoke(paramTextView, new Object[] { Boolean.valueOf(false) });
          return;
        }
      }
    }
    catch (Exception paramTextView)
    {
      paramTextView.printStackTrace();
    }
  }
  
  public static void a(String paramString1, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString2 = paramQQAppInterface.a().a(paramString2, paramInt, paramLong);
    } while (paramString2 == null);
    if ((paramBoolean) && (((paramString2 instanceof MessageForMixedMsg)) || ((paramString2 instanceof MessageForLongMsg))))
    {
      QfavBuilder.b(paramString2).b(paramQQAppInterface, paramString2).b(paramActivity, paramQQAppInterface.getAccount());
      QfavReport.a(paramQQAppInterface, 66, 8);
      return;
    }
    QfavBuilder.a(paramString1).b(paramQQAppInterface, paramString2).b(paramActivity, paramQQAppInterface.getAccount());
    QfavReport.a(paramQQAppInterface, 66, 1);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView == null)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    Object localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getLocalVisibleRect((Rect)localObject);
    int i = (int)(((Rect)localObject).left + this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getWidth() / 2.0F);
    int j = (int)(((Rect)localObject).top + this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getHeight() / 2.0F);
    long l = System.currentTimeMillis();
    localObject = MotionEvent.obtain(l, l, 0, i, j, 1.0F, 1.0F, 0, 0.0F, 0.0F, 0, 0);
    MotionEvent localMotionEvent = MotionEvent.obtain(l, 30L + l, 1, i, j, 1.0F, 1.0F, 0, 0.0F, 0.0F, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.onTouchEvent((MotionEvent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.onTouchEvent(localMotionEvent);
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.sendAccessibilityEvent(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.showContextMenu();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView);
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
    this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView.right += arrayOfInt[0];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    int i = paramView.bottom;
    paramView.bottom = (arrayOfInt[1] + i);
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (a(this.jdField_a_of_type_AndroidViewView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label90;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a()) {
        break label82;
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label82:
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
      continue;
      label90:
      if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 1)) {
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this))
        {
          int i = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getX() - (int)paramMotionEvent.getX();
          int j = (int)this.jdField_a_of_type_AndroidViewMotionEvent.getY() - (int)paramMotionEvent.getY();
          if ((i * i + j * j < 10000) && (paramMotionEvent.getEventTime() - this.jdField_a_of_type_AndroidViewMotionEvent.getEventTime() < 200L))
          {
            this.jdField_a_of_type_AndroidViewMotionEvent = null;
            finish();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setLayerType(0, null);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setLayerType(0, null);
    }
  }
  
  public void finish()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    if (this.h != null) {}
    for (int i = this.h.length();; i = 0)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(i), "", "");
      super.finish();
      overridePendingTransition(0, 2130968601);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131231122)
    {
      d();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004063", "0X8004063", 0, 0, "", "", "", "");
      return;
    }
    if (i == 2131231124)
    {
      a(this.h, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.g, this.jdField_a_of_type_Int, jdField_a_of_type_Long, true);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004064", "0X8004064", 0, 0, "", "", "", "");
      return;
    }
    boolean bool;
    if (i == 2131231126)
    {
      paramView = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (paramView == null) {
        break label770;
      }
      if (paramView.a("100005.100003") != -1) {
        bool = true;
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("bubbleId", this.jdField_b_of_type_Int);
      localIntent.putExtra("scrollToBubble", true);
      VasWebviewUtil.a(this, "http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027", 64L, localIntent, false, -1);
      int j;
      label236:
      int k;
      label250:
      int m;
      if (bool)
      {
        if (paramView.a("100005.100001") == -1) {
          break label450;
        }
        j = 1;
        if (paramView.a("100005.100002") == -1) {
          break label455;
        }
        k = 1;
        if (paramView.a("100005.100006") == -1) {
          break label461;
        }
        m = 1;
        label264:
        bool = ((FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a;
        i = 0;
        if (bool)
        {
          if (paramView.a("100005.100011") == -1) {
            break label467;
          }
          i = 1;
        }
        label301:
        if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0))) {
          if (paramView.a("100005") == -1) {
            break label472;
          }
        }
      }
      label450:
      label455:
      label461:
      label467:
      label472:
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          BusinessInfoCheckUpdateItem.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "100005", false);
          ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005");
        }
        ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005.100003");
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "BigTextPage", "bubble_enter", 0, 0, "", "", "", "");
        return;
        bool = false;
        break;
        j = 0;
        break label236;
        k = 0;
        break label250;
        m = 0;
        break label264;
        i = 0;
        break label301;
      }
      if (i != 2131231130) {
        break;
      }
      paramView = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (paramView != null) {
        if (paramView.a("100005.100011") != -1) {
          bool = true;
        }
      }
      for (;;)
      {
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("updateFlag", bool);
        VasWebviewUtil.a(this, VasWebviewConstants.CHAT_FONT_MARKET_HOME_URL, 4096L, localIntent, false, -1);
        if (bool)
        {
          if (paramView.a("100005.100001") == -1) {
            break label737;
          }
          i = 1;
          label571:
          if (paramView.a("100005.100002") == -1) {
            break label742;
          }
          j = 1;
          label584:
          if (paramView.a("100005.100006") == -1) {
            break label747;
          }
          k = 1;
          label598:
          if (paramView.a("100005.100003") == -1) {
            break label753;
          }
          m = 1;
          label612:
          if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
            if (paramView.a("100005") == -1) {
              break label759;
            }
          }
        }
        label737:
        label742:
        label747:
        label753:
        label759:
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            BusinessInfoCheckUpdateItem.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "100005", false);
            ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005");
          }
          ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005.100011");
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "BigTextPage", "font_enter", 0, 0, "", "", "", "");
          return;
          bool = false;
          break;
          i = 0;
          break label571;
          j = 0;
          break label584;
          k = 0;
          break label598;
          m = 0;
          break label612;
        }
        bool = false;
      }
      label770:
      bool = false;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903091);
    paramBundle = getIntent();
    this.g = paramBundle.getStringExtra("peeruin");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("uin_type", 0);
    this.jdField_b_of_type_Int = ((int)paramBundle.getLongExtra("bubbleId", 0L));
    this.h = paramBundle.getStringExtra("content");
    long l = paramBundle.getLongExtra("uniseq", 0L);
    if (jdField_a_of_type_Long != l)
    {
      ContainerView.jdField_a_of_type_Float = 0.0F;
      jdField_a_of_type_Long = l;
    }
    try
    {
      paramBundle = ((BitmapDrawable)findViewById(2131231119).getBackground()).getBitmap();
      if (paramBundle != null)
      {
        localObject1 = new Matrix();
        ((Matrix)localObject1).postRotate(180.0F);
        paramBundle = new BitmapDrawable(Bitmap.createBitmap(paramBundle, 0, 0, paramBundle.getWidth(), paramBundle.getHeight(), (Matrix)localObject1, true));
        findViewById(2131231120).setBackgroundDrawable(paramBundle);
      }
    }
    catch (OutOfMemoryError paramBundle)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        continue;
        boolean bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)findViewById(2131231118));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131231117));
    this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_a_of_type_ComTencentWidgetScrollView);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231121);
    paramBundle = (TextView)findViewById(2131231126);
    localObject1 = (TextView)findViewById(2131231130);
    localObject2 = findViewById(2131231129);
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) && ((getAppRuntime() instanceof QQAppInterface))) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    }
    localObject3 = (FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41);
    if (localObject3 != null)
    {
      bool = ((FontManager)localObject3).a;
      if (!bool)
      {
        ((TextView)localObject1).setVisibility(8);
        ((View)localObject2).setVisibility(8);
      }
      for (;;)
      {
        paramBundle.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231127));
        paramBundle = (BubbleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle.a(this.jdField_b_of_type_Int));
        paramBundle = (TextView)findViewById(2131231122);
        localObject1 = findViewById(2131231123);
        localObject2 = (TextView)findViewById(2131231124);
        localObject3 = findViewById(2131231125);
        paramBundle.setVisibility(0);
        ((View)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((View)localObject3).setVisibility(0);
        paramBundle.setOnClickListener(this);
        ((TextView)localObject2).setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setLayerType(1, null);
          this.jdField_a_of_type_ComTencentWidgetScrollView.setLayerType(1, null);
        }
        paramBundle = new QQText(this.h, 13, 32, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramBundle);
        return;
        ((TextView)localObject1).setOnClickListener(this);
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity
 * JD-Core Version:    0.7.0.1
 */