import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWordkMoreView;
import com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.10;
import com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.11;
import com.tencent.mobileqq.troop.widget.CountdownTimeTask;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import mqq.os.MqqHandler;

public class aoeq
  extends ReportDialog
  implements Handler.Callback, anzt
{
  public static int dOm = 10;
  public static int dOn = 16;
  protected List<GPadInfo> GY;
  protected View HL;
  protected XListView V;
  protected RelativeLayout X;
  protected TextView ZV;
  protected aoee a;
  public GroupTeamWordkMoreView a;
  public CountdownTimeTask a;
  protected ImageButton aF;
  public EditText aR;
  protected long acU;
  protected long aoY;
  protected aodm b;
  protected ViewGroup bl;
  protected aodk c;
  protected boolean cLm = true;
  public boolean cLn;
  protected boolean cLo;
  public boolean ceC;
  public String cku = "";
  protected int dOd;
  public int dOl;
  protected Object eo = new Object();
  private Bitmap go;
  protected Activity mActivity;
  protected QQAppInterface mApp;
  protected boolean mIsEnd;
  public int mRequestCount;
  protected TextView nP;
  protected Handler uiHandler;
  
  public aoeq(Activity paramActivity, View paramView, QQAppInterface paramQQAppInterface, long paramLong)
  {
    super(paramActivity, 2131755579);
    this.jdField_a_of_type_Aoee = new aoez(this);
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.b = ((aodm)this.mApp.getBusinessHandler(143));
    this.acU = paramLong;
    cg(paramActivity);
    this.X = ((RelativeLayout)findViewById(2131377207));
    this.V = ((XListView)findViewById(2131377856));
    this.bl = ((ViewGroup)findViewById(2131370789));
    this.nP = ((TextView)findViewById(2131370791));
    this.ZV = ((TextView)findViewById(2131380916));
    this.HL = findViewById(2131364640);
    this.aF = ((ImageButton)findViewById(2131368696));
    this.uiHandler = new Handler(this);
    gT();
    dUn();
    g(paramActivity, paramQQAppInterface);
    this.mApp.addObserver(this.jdField_a_of_type_Aoee);
    hM(paramView);
  }
  
  private void dUn()
  {
    this.aF.setOnClickListener(new aoex(this));
    Button localButton = (Button)findViewById(2131363801);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new aoey(this));
  }
  
  /* Error */
  public void Jb(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 199	aoeq:ceC	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 155	aoeq:uiHandler	Landroid/os/Handler;
    //   18: iconst_1
    //   19: invokevirtual 203	android/os/Handler:sendEmptyMessage	(I)Z
    //   22: pop
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 109	aoeq:acU	J
    //   28: aload_1
    //   29: iconst_0
    //   30: bipush 50
    //   32: iconst_0
    //   33: invokevirtual 206	aoeq:b	(JLjava/lang/String;III)V
    //   36: goto -25 -> 11
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	aoeq
    //   0	44	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   14	36	39	finally
  }
  
  public void QK(boolean paramBoolean)
  {
    bx(false);
    if (paramBoolean)
    {
      if (this.X.getVisibility() != 0) {
        this.X.setVisibility(0);
      }
      this.bl.setVisibility(0);
      this.nP.setVisibility(0);
      this.V.setVisibility(8);
      this.nP.setText(this.mActivity.getString(2131699565, new Object[] { this.cku }));
      this.nP.setCompoundDrawablesWithIntrinsicBounds(0, 2130844540, 0, 0);
      return;
    }
    this.V.setVisibility(0);
    Drawable localDrawable = this.nP.getCompoundDrawables()[0];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    this.nP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.bl.setVisibility(8);
    this.nP.setVisibility(8);
  }
  
  protected void a(View paramView, boolean paramBoolean, Bitmap paramBitmap)
  {
    ThreadManager.post(new TroopTeamWorkFileSearchDialog.10(this, paramBitmap, paramView, paramBoolean), 8, null, true);
  }
  
  public void a(PadInfo paramPadInfo) {}
  
  public final void b(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        int i = this.mRequestCount;
        if (i > 0) {
          return;
        }
        if (TextUtils.isEmpty(paramString))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("TroopTeamWorkFileSearchDialog", 4, "doReqTroopFileSearch err keyWord =" + paramString);
          continue;
        }
        this.aoY = System.currentTimeMillis();
      }
      finally {}
      this.mRequestCount += 1;
      if (this.b != null) {
        this.b.a(paramLong, paramString, paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  public void b(View paramView, boolean paramBoolean, Bitmap paramBitmap)
  {
    ThreadManager.getUIHandler().post(new TroopTeamWorkFileSearchDialog.11(this, paramView, paramBoolean));
    if (paramBitmap != null) {
      paramBitmap.recycle();
    }
  }
  
  public void b(PadInfo paramPadInfo) {}
  
  protected float bw()
  {
    float f2 = this.aR.getWidth() - aqho.convertDpToPixel(this.mActivity, 20.0F);
    float f1 = f2;
    if (this.dOl > 0) {
      f1 = f2 - (this.aR.getPaint().measureText(fu(this.dOl)) + aqho.convertDpToPixel(this.mActivity, 16.0F));
    }
    f2 = f1;
    if (this.aF.getVisibility() == 0) {
      f2 = f1 - (this.aF.getWidth() + aqho.convertDpToPixel(this.mActivity, 8.0F));
    }
    return f2;
  }
  
  public void bx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.X.getVisibility() != 0) {
        this.X.setVisibility(0);
      }
      this.bl.setVisibility(0);
      this.nP.setVisibility(0);
      this.V.setVisibility(8);
      this.nP.setCompoundDrawablesWithIntrinsicBounds(2130839651, 0, 0, 0);
      this.nP.setText(2131696924);
      localDrawable = this.nP.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
      return;
    }
    this.V.setVisibility(0);
    Drawable localDrawable = this.nP.getCompoundDrawables()[0];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    this.nP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.bl.setVisibility(8);
    this.nP.setVisibility(8);
  }
  
  protected void cX(String paramString, boolean paramBoolean)
  {
    if (this.dOl <= 0) {
      this.ZV.setVisibility(8);
    }
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      TextPaint localTextPaint = this.aR.getPaint();
      float f = bw() - localTextPaint.measureText(paramString);
      if (f < 0.0F) {
        this.ZV.setVisibility(8);
      }
      while (QLog.isColorLevel())
      {
        QLog.e("zivonchen", 2, "resetResultNumTextVisible compareWidth = " + f + ", time = " + (System.currentTimeMillis() - l));
        return;
        if (paramBoolean)
        {
          this.ZV.setText(fu(this.dOl));
          this.ZV.setVisibility(0);
        }
      }
    }
  }
  
  protected void cg(Activity paramActivity)
  {
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    if (!VersionUtils.isHoneycomb()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
    for (;;)
    {
      setContentView(2131560107);
      findViewById(2131370833).setOnClickListener(new aoer(this));
      Object localObject = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).x = 0;
      ((WindowManager.LayoutParams)localObject).y = 0;
      ((WindowManager.LayoutParams)localObject).width = -1;
      ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject).gravity = 51;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getWindow().addFlags(67108864);
        int i = paramActivity.getResources().getColor(2131167361);
        if (ImmersiveUtils.a(getWindow(), true)) {
          i = paramActivity.getResources().getColor(2131167562);
        }
        new SystemBarCompact(this, true, i).init();
        localObject = (LinearLayout)findViewById(2131370833);
        ((LinearLayout)localObject).setFitsSystemWindows(true);
        ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(paramActivity), 0, 0);
      }
      return;
      getWindow().setBackgroundDrawable(new ColorDrawable(paramActivity.getResources().getColor(2131165865)));
    }
  }
  
  public void dUo()
  {
    if (this.X.getVisibility() != 0) {
      this.X.setVisibility(0);
    }
    this.bl.setVisibility(0);
    this.nP.setVisibility(0);
    this.V.setVisibility(8);
    this.nP.setText(this.mActivity.getString(2131696272));
    this.nP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  protected void dUp()
  {
    this.ZV.setVisibility(8);
    this.ceC = true;
    this.uiHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.shutdown();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
    }
    this.bl.setVisibility(8);
    this.nP.setVisibility(8);
    this.V.setVisibility(8);
    aurd.aO(this.aR);
  }
  
  protected void dUq()
  {
    if (this.ZV.getVisibility() != 0)
    {
      this.ZV.setText(fu(this.dOl));
      this.ZV.setVisibility(0);
      this.cLo = true;
      String str = oc(this.aR.getText().toString());
      if (!TextUtils.isEmpty(str))
      {
        this.aR.setText(str);
        this.aR.setSelection(str.length());
      }
    }
  }
  
  public void dismiss()
  {
    this.ceC = true;
    aurd.hide(this.aR);
    SingleLineHotwordTextView.release();
    if (this.GY != null)
    {
      this.GY.clear();
      this.GY = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.shutdown();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
    }
    if (this.uiHandler != null) {
      this.uiHandler.removeCallbacksAndMessages(null);
    }
    if (this.c != null)
    {
      this.c.dUi();
      this.c = null;
    }
    this.mApp.removeObserver(this.jdField_a_of_type_Aoee);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected String fu(int paramInt)
  {
    if (paramInt > 1000) {
      return this.mActivity.getString(2131699570);
    }
    return this.mActivity.getString(2131699568, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void g(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView = new GroupTeamWordkMoreView(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setBackgroundResource(2130838900);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setTextColor(paramActivity.getResources().getColor(2131167304));
    this.V.addFooterView(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(8);
    this.c = new aodk(this.mApp, this.mActivity, this, this.uiHandler);
    this.V.setAdapter(this.c);
    this.V.setOnScrollListener(new aoes(this));
    this.V.setOnTouchListener(new aoet(this));
    this.c.setOnClickListener(new aoeu(this));
  }
  
  protected void gT()
  {
    this.aR = ((EditText)findViewById(2131366542));
    this.aR.setHint(this.mActivity.getResources().getString(2131719280));
    this.aR.setImeOptions(3);
    this.aR.setOnEditorActionListener(new aoev(this));
    this.aR.addTextChangedListener(new aoew(this));
    this.aR.setSelection(0);
    this.aR.requestFocus();
  }
  
  public void hM(View paramView)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, view :" + paramView.getHeight() + "," + paramView.getWidth());
    }
    if (paramView == null) {}
    boolean bool;
    Object localObject1;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, isDrawingCacheEnabled");
      }
      bool = paramView.isDrawingCacheEnabled();
      if (!bool) {
        paramView.setDrawingCacheEnabled(true);
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, getDrawingCache");
        }
        localObject1 = paramView.getDrawingCache(true);
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
        }
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache exception, " + paramView.getMessage());
        }
      }
      finally
      {
        if (0 == 0)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, start thread");
    }
    try
    {
      localObject1 = Bitmap.createBitmap((Bitmap)localObject1);
      a(paramView, bool, (Bitmap)localObject1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "blurBitmap error", localOutOfMemoryError);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.ceC) {
      return true;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      bx(true);
      continue;
      bx(false);
      continue;
      QK(true);
      continue;
      QK(false);
      continue;
      bx(false);
      cX(this.aR.getText().toString(), true);
      if (this.X.getVisibility() != 0) {
        this.X.setVisibility(0);
      }
      if (this.cLn) {
        this.c.dUi();
      }
      if (this.cLm)
      {
        this.cLm = false;
        aurd.hide(this.aR);
      }
      tG(this.mIsEnd);
      this.c.mw(this.GY);
      this.c.notifyDataSetChanged();
      if (this.cLn) {
        this.cLn = false;
      }
      long l = System.currentTimeMillis() - this.aoY;
      paramMessage = this.aR.getText().toString().trim().toLowerCase();
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "REFRESH_LIST text = " + paramMessage + ", lastHotword = " + this.cku + ", time = " + l);
      }
      if ((!paramMessage.equals(this.cku)) && (l >= 800L))
      {
        this.cLn = true;
        this.cku = paramMessage;
        Jb(this.cku);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
      }
    }
  }
  
  protected String oc(String paramString)
  {
    float f = bw();
    TextPaint localTextPaint = this.aR.getPaint();
    if ((TextUtils.isEmpty(paramString)) || (localTextPaint.measureText(paramString) <= f)) {
      return paramString;
    }
    return paramString.substring(0, localTextPaint.breakText(paramString, true, f - localTextPaint.measureText("…"), null)) + "…";
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.uiHandler != null) {
      this.uiHandler.removeCallbacksAndMessages(null);
    }
    if ((this.go != null) && (!this.go.isRecycled()))
    {
      this.go.recycle();
      this.go = null;
    }
  }
  
  protected void tG(boolean paramBoolean)
  {
    if (this.V.getFirstVisiblePosition() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setText(2131720487);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.dmA();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setText(2131696924);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWordkMoreView.setTextLeftDrawable(2130839651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoeq
 * JD-Core Version:    0.7.0.1
 */