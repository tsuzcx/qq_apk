package com.tencent.av.ui.chatroom;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import ijv;
import ily;
import iwu;
import izm;
import java.util.List;
import jfy;
import jfz;
import jfz.a;
import jgf;
import jgg;

public class VideoChatRoomContainer
  extends RelativeLayout
  implements jfz.a
{
  private EditText H;
  private boolean Ze;
  private SystemAndEmojiEmoticonPanelWithActionBar jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar;
  private jfy jdField_a_of_type_Jfy;
  private int ayT;
  private jfz b;
  private LinearLayout dk;
  private LinearLayout dl;
  private LinearLayout dm;
  private ImageView gS;
  VideoAppInterface mApp;
  private int mLayoutMode;
  protected ListView mList;
  
  public VideoChatRoomContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoChatRoomContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoChatRoomContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void bx(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131559898, this);
    this.dk = ((LinearLayout)localView.findViewById(2131370144));
    this.dl = ((LinearLayout)localView.findViewById(2131365382));
    this.jdField_a_of_type_Jfy = new jfy(paramContext);
    this.mList = ((ListView)this.dl.findViewById(16908298));
    this.mList.setAdapter(this.jdField_a_of_type_Jfy);
    this.H = ((EditText)this.dl.findViewById(2131369279));
    this.H.setFilters(new InputFilter[] { new InputFilter.LengthFilter(40) });
    this.gS = ((ImageView)this.dl.findViewById(2131366374));
    this.dm = ((LinearLayout)this.dk.findViewById(2131366381));
    setFitsSystemWindows(true);
  }
  
  private void by(Context paramContext)
  {
    this.b = jfz.a((Activity)paramContext).a(this).a((VideoChatRoomListView)this.mList).a(this.H).a(this.gS).a();
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar = new SystemAndEmojiEmoticonPanelWithActionBar(getContext(), this.b);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setId(2131373958);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setVisibility(0);
    this.dm.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar, paramContext);
    this.b.a(this.dm);
  }
  
  private void init(Context paramContext)
  {
    bx(paramContext);
    by(paramContext);
  }
  
  public void C(int paramInt, long paramLong)
  {
    if (this.b == null) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      post(new VideoChatRoomContainer.1(this, paramInt, paramLong));
      return;
      O(0, false);
      continue;
      O(this.ayT, false);
    }
  }
  
  public void O(int paramInt, boolean paramBoolean)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.dk.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt) {
      localMarginLayoutParams.bottomMargin = paramInt;
    }
    if (paramBoolean) {
      this.dk.setLayoutParams(localMarginLayoutParams);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatRoomUtil", 4, "updateContextViewLayoutBottomMargin, bottomMargin[" + paramInt + "], forceRequestLayout[" + paramBoolean + "]");
    }
  }
  
  public void a(VideoLayerUI paramVideoLayerUI, int paramInt)
  {
    int k = 1;
    int j = 0;
    int i;
    label65:
    label121:
    int m;
    if (paramInt == 1)
    {
      if (xi())
      {
        paramInt = 0;
        i = 0;
        paramVideoLayerUI = (ViewGroup.MarginLayoutParams)this.dl.getLayoutParams();
        if (paramVideoLayerUI.leftMargin != i)
        {
          paramVideoLayerUI.leftMargin = i;
          j = 1;
        }
        if (paramVideoLayerUI.rightMargin == paramInt) {
          break label243;
        }
        paramVideoLayerUI.rightMargin = paramInt;
        paramInt = k;
        if ((paramInt != 0) && (getVisibility() == 0)) {
          this.dl.setLayoutParams(paramVideoLayerUI);
        }
        return;
      }
      if ((paramVideoLayerUI == null) || (paramVideoLayerUI.a.length <= 1) || (paramVideoLayerUI.a[1] == null)) {
        break label249;
      }
      if (paramVideoLayerUI.a[1].getVisibility() == 0)
      {
        paramInt = 1;
        m = paramVideoLayerUI.a[1].getWidth();
        i = paramInt;
      }
    }
    for (paramInt = m;; paramInt = 0)
    {
      if (i != 0) {}
      switch (paramVideoLayerUI.getPosition())
      {
      default: 
        paramInt = 0;
        i = 0;
      }
      for (;;)
      {
        break;
        paramInt = 0;
        break label121;
        paramInt = 0;
        i = 0;
        continue;
        i = paramInt;
        paramInt = 0;
        continue;
        i = 0;
      }
      if (paramInt == 3)
      {
        paramInt = 0;
        i = 0;
        break;
      }
      if (paramInt == 4)
      {
        paramInt = 0;
        i = 0;
        break;
      }
      if (paramInt == 2) {}
      paramInt = 0;
      i = 0;
      break;
      label243:
      paramInt = j;
      break label65;
      label249:
      i = 0;
    }
  }
  
  public void d(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    ns(this.ayT);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((AVActivity)getContext()).findViewById(2131373974) != null) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.b.clearFocus();
      if (QLog.isColorLevel()) {
        QLog.w("ChatRoomUtil", 2, "doodle hase show, so not accept dispatchEvent");
      }
      return false;
    }
    if (this.mApp.b().b().Ql)
    {
      this.b.clearFocus();
      g(119, Integer.valueOf(2));
      return false;
    }
    if (VideoController.a().b().isRecording)
    {
      iwu.b(this.mApp, 1022, 2131697970);
      return false;
    }
    boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool2) && (this.b.xh()))
    {
      paramMotionEvent = (InputMethodManager)getContext().getSystemService("input_method");
      if (paramMotionEvent == null) {
        break label231;
      }
    }
    label231:
    for (boolean bool1 = paramMotionEvent.isActive();; bool1 = false)
    {
      this.b.avY();
      if (QLog.isColorLevel()) {
        QLog.w("ChatRoomUtil", 2, "dispatchTouchEvent, 拦截了touch消息, isSoftInputActive[" + bool1 + "]");
      }
      return bool2;
      if ((!bool2) && (this.b.xg())) {
        this.b.avV();
      }
      return bool2;
    }
  }
  
  protected void g(int paramInt, Object paramObject)
  {
    igd.aJ("VideoChatRoomContainer", "notifyEvent :" + paramInt + "|" + paramObject);
    this.mApp.l(new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void kr(String paramString)
  {
    Object localObject = jgf.a();
    ((jgf)localObject).setType(1);
    ((jgf)localObject).setContent(paramString);
    ((jgf)localObject).ks(this.mApp.getCurrentAccountUin());
    this.jdField_a_of_type_Jfy.a((jgf)localObject);
    this.mList.setSelection(this.jdField_a_of_type_Jfy.getCount() - 1);
    localObject = getContext();
    if ((localObject instanceof AVActivity))
    {
      localObject = (AVActivity)localObject;
      if (((AVActivity)localObject).a != null) {
        ((AVActivity)localObject).a.kt(paramString);
      }
    }
  }
  
  public void l(List<jgf> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Jfy.k(paramList, paramBoolean);
    this.mList.setSelection(this.jdField_a_of_type_Jfy.getCount() - 1);
  }
  
  public int mr()
  {
    int j = 0;
    int i;
    if (this.b.xg()) {
      i = this.dm.getHeight();
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (!this.b.xh());
      i = j;
    } while (this.b.Zd);
    return ily.aoW;
  }
  
  public void ns(int paramInt)
  {
    boolean bool2 = true;
    int n = 0;
    boolean bool1 = this.b.xf();
    int i;
    int j;
    label42:
    AVActivity localAVActivity;
    int k;
    if (this.Ze != bool1)
    {
      i = 1;
      this.Ze = bool1;
      if (this.ayT == paramInt) {
        break label227;
      }
      j = 1;
      this.ayT = paramInt;
      localAVActivity = null;
      Context localContext = getContext();
      if (!(localContext instanceof AVActivity)) {
        break label254;
      }
      localAVActivity = (AVActivity)localContext;
      k = localAVActivity.lI();
      if (this.mLayoutMode == k) {
        break label232;
      }
      paramInt = 1;
      label89:
      this.mLayoutMode = k;
    }
    for (int m = paramInt;; m = 0)
    {
      bool1 = bool2;
      if (i == 0)
      {
        bool1 = bool2;
        if (j == 0)
        {
          if (m == 0) {
            break label237;
          }
          bool1 = bool2;
        }
      }
      label123:
      paramInt = this.ayT;
      i = this.b.mq();
      if ((i != 0) && (i != 7))
      {
        paramInt = n;
        if (this.b.Zd)
        {
          if (i != 4) {
            break label243;
          }
          paramInt = n;
        }
      }
      for (;;)
      {
        O(paramInt, bool1);
        if ((localAVActivity != null) && (m != 0)) {
          a(localAVActivity.b, k);
        }
        if ((bool1) && (localAVActivity != null) && (localAVActivity.mControlUI != null)) {
          localAVActivity.mControlUI.auZ();
        }
        return;
        i = 0;
        break;
        label227:
        j = 0;
        break label42;
        label232:
        paramInt = 0;
        break label89;
        label237:
        bool1 = false;
        break label123;
        label243:
        paramInt = this.ayT;
      }
      label254:
      k = 1;
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.b.xg())
    {
      this.b.avV();
      return true;
    }
    if (this.b.xh())
    {
      this.b.avY();
      return true;
    }
    return false;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void q(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((getVisibility() == 8) && (this.b != null))
    {
      if (this.b.xg()) {
        this.b.avV();
      }
    }
    else {
      return;
    }
    this.b.avY();
  }
  
  public boolean xh()
  {
    return (this.b != null) && (this.b.xh());
  }
  
  public boolean xi()
  {
    return (this.mApp.ch(3)) && (((ijv)this.mApp.a(3)).a() != null);
  }
  
  public void z(MotionEvent paramMotionEvent)
  {
    Object localObject = getContext();
    if ((localObject instanceof AVActivity))
    {
      localObject = (AVActivity)localObject;
      if ((((AVActivity)localObject).b != null) && (((AVActivity)localObject).b.mGestureDetector != null))
      {
        ((AVActivity)localObject).b.mTargetIndex = -1;
        ((AVActivity)localObject).b.mGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomContainer
 * JD-Core Version:    0.7.0.1
 */