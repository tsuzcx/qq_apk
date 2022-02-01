package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import aett.a;
import aeue;
import agrd.a;
import agrj.a;
import agxu;
import agya;
import agyb;
import ahav;
import ahcc;
import ahcu;
import ahcw;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arhz;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kwstudio.office.preview.TdsReaderView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsDebugView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SimpleFileViewer
  extends agxu
{
  private View CU;
  private View CV;
  private View CW;
  private View CX;
  private View CY;
  private arhz P;
  private TextView SI;
  private TextView SJ;
  private TextView SK;
  private TextView SL;
  private TextView SM;
  private TextView SN;
  public ahcu a;
  public ahcw a;
  private TdsReaderView b;
  AsyncImageView jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private TbsReaderView jdField_c_of_type_ComTencentTbsReaderTbsReaderView;
  private boolean cfO = true;
  private RelativeLayout jH;
  
  public SimpleFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject2 = this.mContext.getString(2131693026);
    Object localObject1 = this.mContext.getString(2131693019);
    Object localObject3 = ahcc.fd();
    Iterator localIterator;
    Object localObject4;
    if ((localObject3 != null) && (((List)localObject3).size() == 2)) {
      if (this.cfO)
      {
        localIterator = ((List)localObject3).iterator();
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (!localIterator.hasNext()) {
          break label265;
        }
        localObject3 = (aett.a)localIterator.next();
        if ((((aett.a)localObject3).getType() != 0) || (TextUtils.isEmpty(((aett.a)localObject3).getText())) || (TextUtils.isEmpty(((aett.a)localObject3).getTextColor()))) {
          break label329;
        }
        localObject2 = ((aett.a)localObject3).getText();
        localObject1 = ((aett.a)localObject3).getTextColor();
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localIterator = ((List)localObject3).iterator();
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject4 = localObject2;
      localObject3 = localObject1;
      if (localIterator.hasNext())
      {
        localObject3 = (aett.a)localIterator.next();
        if ((((aett.a)localObject3).getType() != 1) || (TextUtils.isEmpty(((aett.a)localObject3).getText())) || (TextUtils.isEmpty(((aett.a)localObject3).getTextColor()))) {
          break label316;
        }
        localObject2 = ((aett.a)localObject3).getText();
        localObject1 = ((aett.a)localObject3).getTextColor();
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = localObject2;
        localObject4 = localObject1;
        label265:
        localObject1 = (ausj)auss.a(this.mContext, null);
        ((ausj)localObject1).setMainTitle((CharSequence)localObject3);
        ((ausj)localObject1).addButton(localObject4, 5);
        ((ausj)localObject1).addCancelButton(2131721058);
        ((ausj)localObject1).a(new agyb(this, paramQQAppInterface, paramTeamWorkFileImportInfo, (ausj)localObject1));
        ((ausj)localObject1).show();
        return;
        label316:
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      label329:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private boolean a(View paramView1, View paramView2, boolean paramBoolean)
  {
    if (paramView1 == null)
    {
      this.CV = paramView2;
      if ((this.jH == null) && (paramView2 != null))
      {
        if (paramView2.getParent() != null) {
          ((ViewGroup)paramView2.getParent()).removeAllViews();
        }
        if (paramBoolean) {}
        for (paramView1 = new GestureRelativeLayout(this.mContext);; paramView1 = new RelativeLayout(this.mContext))
        {
          this.jH = paramView1;
          paramView1 = new RelativeLayout.LayoutParams(-1, -1);
          this.jH.addView(paramView2, 0, paramView1);
          return true;
        }
      }
    }
    else if ((this.jH != null) && (paramView1 != null) && (paramView2 != null) && (paramView1.hashCode() != paramView2.hashCode()))
    {
      int i = this.jH.indexOfChild(paramView1);
      if (i >= 0)
      {
        this.jH.removeView(paramView1);
        paramView1 = new RelativeLayout.LayoutParams(-1, -1);
        this.jH.addView(paramView2, i, paramView1);
        this.CV = paramView2;
        return true;
      }
    }
    return false;
  }
  
  private void dky()
  {
    ViewGroup localViewGroup = (ViewGroup)this.CS.getParent();
    if ((localViewGroup != null) && (this.jH != null))
    {
      localViewGroup.removeAllViews();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localViewGroup.addView(this.jH, 0, localLayoutParams);
    }
  }
  
  public void G(View.OnClickListener paramOnClickListener)
  {
    if (this.SN == null) {
      this.SN = ((TextView)this.CS.findViewById(2131368218));
    }
    this.SN.setVisibility(0);
    this.SN.setOnClickListener(paramOnClickListener);
  }
  
  public void JI(boolean paramBoolean)
  {
    this.cfO = paramBoolean;
  }
  
  public void JK(boolean paramBoolean)
  {
    super.JK(paramBoolean);
    if (paramBoolean) {
      JQ(false);
    }
  }
  
  public void JQ(boolean paramBoolean)
  {
    int i = 0;
    if (this.SM != null)
    {
      if (this.kp == null) {
        break label49;
      }
      if ((paramBoolean) && (this.kp.getVisibility() != 0)) {
        this.SM.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.SM.setVisibility(8);
    return;
    label49:
    TextView localTextView = this.SM;
    if (paramBoolean) {}
    for (;;)
    {
      localTextView.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public void JR(boolean paramBoolean)
  {
    TextView localTextView = this.SJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void JS(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.SN != null)
    {
      localTextView = this.SN;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void Jr(String paramString)
  {
    if (this.SI.getMeasuredWidth() <= 0)
    {
      this.SI.post(new SimpleFileViewer.1(this, paramString));
      return;
    }
    this.SI.setText(ahav.a(paramString, false, this.SI.getMeasuredWidth(), this.SI.getPaint(), 2));
  }
  
  public void Js(String paramString)
  {
    this.SJ.setText(paramString);
  }
  
  public void Jt(String paramString)
  {
    this.SK.setText(paramString);
  }
  
  public void Ju(String paramString)
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
  }
  
  public void Jv(String paramString)
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramString);
  }
  
  public void Jw(String paramString)
  {
    RelativeLayout localRelativeLayout = this.jH;
    if ((localRelativeLayout == null) || (this.CV == null)) {}
    while (!TdsDebugView.mC(paramString)) {
      return;
    }
    if (this.CW == null) {
      this.CW = new TdsDebugView(this.mContext, new agya(this));
    }
    if (localRelativeLayout.indexOfChild(this.CW) < 0)
    {
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      paramString.topMargin = ((int)this.mContext.getResources().getDimension(2131299627));
      localRelativeLayout.addView(this.CW, paramString);
    }
    this.CW.setVisibility(0);
  }
  
  public void Jx(String paramString)
  {
    if (this.P == null)
    {
      this.P = new arhz(this.mContext);
      this.P.setCancelable(false);
    }
    if (!this.P.isShowing())
    {
      this.P.setMessage(paramString);
      this.P.show();
    }
  }
  
  public void OO(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void OP(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void OQ(int paramInt)
  {
    View localView;
    if (this.CY != null)
    {
      localView = this.CY;
      if (paramInt <= 0) {
        break label24;
      }
    }
    label24:
    for (paramInt = 0;; paramInt = 4)
    {
      localView.setVisibility(paramInt);
      return;
    }
  }
  
  public void a(SpannableString paramSpannableString)
  {
    this.SK.setMovementMethod(LinkMovementMethod.getInstance());
    this.SK.setText(paramSpannableString);
    this.SK.setHighlightColor(17170445);
  }
  
  public void a(String paramString, agrd.a parama)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.4(this, paramString, parama));
  }
  
  public void a(String paramString, agrj.a parama)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.6(this, paramString, parama));
  }
  
  public boolean amE()
  {
    return (this.jH != null) && (this.CV != null) && (this.CX != null) && (this.CX.getVisibility() == 0) && (this.jH.getVisibility() == 0) && (this.CX.getVisibility() == 0);
  }
  
  public void b(String paramString, agrd.a parama)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.5(this, paramString, parama));
  }
  
  public void b(String paramString, agrj.a parama)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.7(this, paramString, parama));
  }
  
  public View ca()
  {
    if ((this.jH != null) && (this.CV != null))
    {
      QLog.e("FileBrowserViewBase", 2, "getInnerFileView : tbs not null");
      this.CS = this.jH;
    }
    return this.CS;
  }
  
  public View cb()
  {
    return this.CX;
  }
  
  public void cj(String paramString, boolean paramBoolean)
  {
    if (this.SL == null) {
      this.SL = ((TextView)this.CS.findViewById(2131364706));
    }
    TextView localTextView = this.SL;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      this.SL.setText(paramString);
      return;
    }
  }
  
  public void d(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.jH != null)
    {
      this.jdField_a_of_type_Ahcw = new ahcw(this.mContext, this.jH, paramTeamWorkFileImportInfo, aeue.a());
      this.jdField_a_of_type_Ahcw.show();
    }
  }
  
  public void dkq()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.CS == null)
    {
      this.CS = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131561061, this.mRootView, false);
      this.CU = this.CS;
      this.SK = ((TextView)this.CS.findViewById(2131367040));
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.CS.findViewById(2131364246));
      this.SI = ((TextView)this.CS.findViewById(2131367034));
      this.SJ = ((TextView)this.CS.findViewById(2131367029));
      this.SF = ((TextView)this.CS.findViewById(2131372657));
      this.SM = ((TextView)this.CS.findViewById(2131361960));
    }
  }
  
  public void dkv()
  {
    if ((this.CX != null) && (this.CX.getVisibility() == 0)) {
      this.CX.setVisibility(8);
    }
  }
  
  public void dkw()
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.3(this));
  }
  
  public void dkx()
  {
    if ((this.P != null) && (this.P.isShowing())) {
      this.P.dismiss();
    }
  }
  
  public void dkz()
  {
    if (this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView != null) {
      this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView.onStop();
    }
    if (this.b != null) {
      this.b.onStop();
    }
  }
  
  public void e(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.jH != null)
    {
      this.jdField_a_of_type_Ahcu = new ahcu(this.mContext, this.jH, paramTeamWorkFileImportInfo);
      this.jdField_a_of_type_Ahcu.show();
    }
  }
  
  public void f(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    paramTeamWorkFileImportInfo.dNQ = 3;
    ThreadManager.getUIHandler().post(new SimpleFileViewer.2(this, paramTeamWorkFileImportInfo));
  }
  
  public void g(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (this.SM != null)
    {
      this.SM.setText(paramString);
      this.SM.setOnClickListener(paramOnClickListener);
      JQ(true);
    }
  }
  
  public void ig(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView != null) {
      this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void ih(int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void showTip(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.SK.getText())))
    {
      this.SK.setVisibility(0);
      return;
    }
    this.SK.setVisibility(8);
  }
  
  public class GestureRelativeLayout
    extends RelativeLayout
  {
    private GestureDetector mDetector = new GestureDetector(paramContext, new a(null));
    
    public GestureRelativeLayout(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public GestureRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (this.mDetector != null) {
        this.mDetector.onTouchEvent(paramMotionEvent);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    class a
      implements GestureDetector.OnGestureListener
    {
      private a() {}
      
      public boolean onDown(MotionEvent paramMotionEvent)
      {
        return false;
      }
      
      public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
      {
        return false;
      }
      
      public void onLongPress(MotionEvent paramMotionEvent) {}
      
      public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
      {
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
        {
          paramMotionEvent1 = SimpleFileViewer.this.cb();
          if (paramFloat2 <= 0.0F) {
            break label97;
          }
          if (paramMotionEvent1 != null) {
            paramMotionEvent1.setVisibility(8);
          }
          if (SimpleFileViewer.this.jdField_a_of_type_Ahcw != null) {
            SimpleFileViewer.this.jdField_a_of_type_Ahcw.Kk(true);
          }
          if (SimpleFileViewer.this.jdField_a_of_type_Ahcu != null) {
            SimpleFileViewer.this.jdField_a_of_type_Ahcu.Kk(true);
          }
        }
        label97:
        do
        {
          do
          {
            return false;
          } while (paramFloat2 >= 0.0F);
          if (paramMotionEvent1 != null) {
            paramMotionEvent1.setVisibility(0);
          }
          if (SimpleFileViewer.this.jdField_a_of_type_Ahcw != null) {
            SimpleFileViewer.this.jdField_a_of_type_Ahcw.show(true);
          }
        } while (SimpleFileViewer.this.jdField_a_of_type_Ahcu == null);
        SimpleFileViewer.this.jdField_a_of_type_Ahcu.show(true);
        return false;
      }
      
      public void onShowPress(MotionEvent paramMotionEvent) {}
      
      public boolean onSingleTapUp(MotionEvent paramMotionEvent)
      {
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer
 * JD-Core Version:    0.7.0.1
 */