import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.ColorNoteController.1;
import com.tencent.mobileqq.colornote.ColorNoteController.2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.mobileqq.colornote.swipeback.SwipeBackLayout.b;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aeay
  implements aeem.a, SwipeBackLayout.b
{
  private static SparseArrayCompat<aecu> g;
  private aebg jdField_a_of_type_Aebg;
  private aedp jdField_a_of_type_Aedp;
  private aeei jdField_a_of_type_Aeei;
  private aeem jdField_a_of_type_Aeem;
  private SwipePostTableLayout jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  private boolean bSK = true;
  private boolean bSL;
  private boolean bSM = true;
  private boolean bSN;
  private Runnable gh = new ColorNoteController.1(this);
  private aedo mColorNoteStateNotice;
  
  public aeay(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public aeay(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, false, false, 2131165656);
  }
  
  public aeay(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, paramBoolean3, false, paramBoolean4, paramInt);
  }
  
  public aeay(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, @DrawableRes int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramSwipePostTableLayout != null) {
        break label124;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = new SwipePostTableLayout(paramContext);
      if (paramBoolean3)
      {
        if ((aeej.agw()) && ((!paramBoolean4) || (Build.VERSION.SDK_INT != 26))) {
          break label133;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setBackgroundResource(paramInt);
      }
    }
    for (;;)
    {
      this.bSM = paramBoolean2;
      if ((paramBoolean2) && (!paramBoolean1)) {
        this.mColorNoteStateNotice = new aedo();
      }
      this.jdField_a_of_type_Aedp = new aedp(paramContext);
      aebu.a();
      return;
      label124:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = paramSwipePostTableLayout;
      break;
      label133:
      paramSwipePostTableLayout = (Activity)paramContext;
      if (!paramBoolean3) {}
      for (paramBoolean3 = bool;; paramBoolean3 = false)
      {
        this.jdField_a_of_type_Aeem = new aeem(paramSwipePostTableLayout, paramBoolean3);
        this.jdField_a_of_type_Aeem.a(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setTranslucentConvertor(this.jdField_a_of_type_Aeem);
        if (!paramBoolean5) {
          break label212;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnSwipeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(false);
        break;
      }
      label212:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.post(new ColorNoteController.2(this));
    }
  }
  
  public aeay(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  private void GY(boolean paramBoolean)
  {
    boolean bool = true;
    int i = 0;
    if (this.jdField_a_of_type_Aebg != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.removeCallbacks(this.gh);
      }
      localObject = aebu.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_Aebg.setPivot(((Point)localObject).x, ((Point)localObject).y);
      }
      if ((!isColorNoteExist()) && ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.bTm))) {
        break label230;
      }
      if ((this.jdField_a_of_type_Aeem == null) || (this.jdField_a_of_type_Aeem.agx())) {
        break label145;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Aeei.onColorNoteAnimFinish();
      }
    }
    else
    {
      return;
    }
    this.bSL = true;
    this.jdField_a_of_type_Aeem.cWx();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.postDelayed(this.gh, 500L);
    return;
    label145:
    this.bSL = false;
    Object localObject = this.jdField_a_of_type_Aedp.c();
    if (localObject != null)
    {
      localObject = ((aebf)localObject).getColorNote();
      if ((localObject == null) || (((ColorNote)localObject).mServiceType != 16842752)) {}
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localObject = this.jdField_a_of_type_Aebg;
      aeei localaeei = this.jdField_a_of_type_Aeei;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) {}
      for (;;)
      {
        ((aebg)localObject).a(localaeei, paramBoolean, i);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.getScrollX();
      }
      label230:
      this.jdField_a_of_type_Aeei.onColorNoteAnimFinish();
      return;
    }
  }
  
  public static void Hb(boolean paramBoolean)
  {
    aebu.a().Hd(paramBoolean);
  }
  
  public static aecu a(ColorNote paramColorNote)
  {
    if (g == null) {
      cVx();
    }
    aecu localaecu = (aecu)g.get(paramColorNote.getServiceType());
    paramColorNote = localaecu;
    if (localaecu == null) {
      paramColorNote = (aecu)g.get(65536);
    }
    return paramColorNote;
  }
  
  public static boolean a(Context paramContext, ColorNote paramColorNote)
  {
    return a(paramContext, paramColorNote, null);
  }
  
  public static boolean a(Context paramContext, ColorNote paramColorNote, Bundle paramBundle)
  {
    boolean bool = false;
    switch (aebs.gV(paramColorNote.getServiceType()))
    {
    default: 
      paramBundle = null;
      if (paramBundle != null)
      {
        if (!aebs.h(paramColorNote)) {
          break label335;
        }
        anot.a(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", aeax.gU(aebs.gV(paramColorNote.getServiceType())), 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      Object localObject = paramColorNote;
      if (aebs.h(paramColorNote)) {
        localObject = aebs.b(paramColorNote);
      }
      paramBundle.b(paramContext, (ColorNote)localObject);
      bool = true;
      return bool;
      paramBundle = new aech(paramBundle);
      break;
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putBoolean("recent_note", aebs.h(paramColorNote));
      paramBundle = new aece((Bundle)localObject);
      break;
      paramBundle = new aecb();
      break;
      paramBundle = new aeby();
      break;
      paramBundle = new aebz();
      break;
      paramBundle = new aecd();
      break;
      paramBundle = new aebw();
      break;
      paramBundle = new aeca();
      break;
      paramBundle = new aecf();
      break;
      paramBundle = new aecc();
      break;
      paramBundle = new aecg();
      break;
      label335:
      anot.a(null, "dc00898", "", "", "0X800A749", "0X800A749", aeax.gT(paramColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
  
  public static boolean an(QQAppInterface paramQQAppInterface)
  {
    return aebu.a().agm();
  }
  
  public static void be(boolean paramBoolean, int paramInt)
  {
    ColorNoteSmallScreenService.be(paramBoolean, paramInt);
  }
  
  private static void cVx()
  {
    g = new SparseArrayCompat();
    g.put(65536, new aecs());
    g.put(16908289, new aecw());
  }
  
  public static void setCustomNightMode(Context paramContext, boolean paramBoolean)
  {
    aeee.e(paramContext, 6, paramBoolean);
  }
  
  public static void y(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aebu.a().z(paramQQAppInterface, paramBoolean);
  }
  
  public void GZ(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Aeem != null)) {
      this.jdField_a_of_type_Aeem.cWx();
    }
  }
  
  public void Ha(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(true);
    }
    if (this.bSL) {
      exitAnimation();
    }
  }
  
  public void Hc(boolean paramBoolean)
  {
    this.bSM = paramBoolean;
  }
  
  public void Hm(String paramString)
  {
    int i = aebs.cJ(paramString);
    if (aebs.jb(i)) {
      Hc(false);
    }
    while (aebs.ja(i))
    {
      cVy();
      return;
      Hc(true);
    }
    cVz();
  }
  
  public ColorNote a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new ColorNote.a().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
  }
  
  public SwipePostTableLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  }
  
  public void a(aeeg paramaeeg)
  {
    aebu.a().a(paramaeeg);
  }
  
  public void a(aeei paramaeei)
  {
    this.jdField_a_of_type_Aeei = paramaeei;
  }
  
  public void addHistoryNote()
  {
    if (this.jdField_a_of_type_Aedp != null) {
      aedc.q(this.jdField_a_of_type_Aedp.getColorNote());
    }
  }
  
  public void addToRecentNote()
  {
    if (this.mColorNoteStateNotice != null) {
      this.mColorNoteStateNotice.cVR();
    }
  }
  
  public boolean agh()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.bTl;
    }
    return false;
  }
  
  public boolean agi()
  {
    return this.bSM;
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.attachToActivity(paramActivity);
    }
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView1 = paramActivity.getChildAt(0);
    View localView2 = paramActivity.findViewById(16908290);
    paramActivity = localView2;
    if (localView2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ColorNoteController", 2, "can not find content view");
      }
      paramActivity = localView1;
    }
    this.jdField_a_of_type_Aedp.setContentView(paramActivity);
    this.jdField_a_of_type_Aebg = new aebg(paramActivity);
    this.jdField_a_of_type_Aebg.pm();
    aebu.a().registerBroadcast();
  }
  
  public void cVA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.cVA();
    }
  }
  
  public void cVB()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.cVB();
    }
  }
  
  public void cVC()
  {
    this.bSK = false;
  }
  
  public void cVD()
  {
    aebu.a().cVD();
  }
  
  public void cVy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.cVy();
    }
  }
  
  public void cVz()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.cVz();
    }
  }
  
  public boolean canAddColorNote()
  {
    if (this.jdField_a_of_type_Aedp != null) {
      return this.jdField_a_of_type_Aedp.canAddColorNote();
    }
    return false;
  }
  
  public void deleteColorNote()
  {
    if (this.jdField_a_of_type_Aedp != null)
    {
      this.jdField_a_of_type_Aedp.deleteColorNote();
      ColorNote localColorNote = this.jdField_a_of_type_Aedp.c().getColorNote();
      if (localColorNote != null)
      {
        aebu.a().o(localColorNote.mServiceType, localColorNote.mSubType, false);
        if (this.bSK)
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 2, localBaseApplication.getString(2131691723), 2000).show();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteController", 2, "delete color note from share entrance: " + localColorNote.getServiceType() + ", " + localColorNote.mSubType + ", " + localColorNote.mMainTitle);
        }
      }
    }
  }
  
  public void exitAnimation()
  {
    GY(false);
  }
  
  public void insertColorNote()
  {
    if (this.jdField_a_of_type_Aedp != null)
    {
      this.jdField_a_of_type_Aedp.insertColorNote();
      ColorNote localColorNote = this.jdField_a_of_type_Aedp.c().getColorNote();
      if (localColorNote != null)
      {
        aebu.a().o(localColorNote.mServiceType, localColorNote.mSubType, true);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteController", 2, "insert color note from share entrance: " + localColorNote.getServiceType() + ", " + localColorNote.mSubType + ", " + localColorNote.mMainTitle);
        }
      }
    }
  }
  
  public boolean isColorNoteExist()
  {
    if (this.jdField_a_of_type_Aedp != null) {
      return this.jdField_a_of_type_Aedp.isColorNoteExist();
    }
    return false;
  }
  
  public void j(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Aedp != null)
    {
      this.jdField_a_of_type_Aedp.j(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteController", 2, "update color note from share entrance: " + paramColorNote.getServiceType() + ", " + paramColorNote.mSubType + ", " + paramColorNote.mMainTitle);
      }
    }
  }
  
  public void onCannotAdd()
  {
    if (this.jdField_a_of_type_Aedp != null) {
      this.jdField_a_of_type_Aedp.onCannotAdd();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.onDestroy();
    }
    if (this.mColorNoteStateNotice != null) {
      this.mColorNoteStateNotice.Hm(this.bSN);
    }
    aebu.a().cVD();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.onPause();
    }
    if (this.mColorNoteStateNotice != null) {
      this.mColorNoteStateNotice.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.onResume();
    }
    if (this.mColorNoteStateNotice != null) {
      this.mColorNoteStateNotice.onResume();
    }
  }
  
  public void registerBroadcast()
  {
    aebu.a().registerBroadcast();
  }
  
  public void setOnColorNoteCurdListener(aeaz.b paramb)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnColorNoteCurdListener(paramb);
    }
    if (this.mColorNoteStateNotice != null) {
      this.mColorNoteStateNotice.setOnColorNoteCurdListener(paramb);
    }
    if (this.jdField_a_of_type_Aedp != null) {
      this.jdField_a_of_type_Aedp.setOnColorNoteCurdListener(paramb);
    }
    aebu.a().a(paramb);
  }
  
  public void setOnPageSwipeListener(SwipePostTableLayout.a parama)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnPageSwipeListener(parama);
    }
  }
  
  public void setServiceInfo(aebf paramaebf)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setServiceInfo(paramaebf);
    }
    if (this.mColorNoteStateNotice != null) {
      this.mColorNoteStateNotice.setServiceInfo(paramaebf);
    }
    this.jdField_a_of_type_Aedp.setServiceInfo(paramaebf);
  }
  
  public boolean shouldDisplayColorNote()
  {
    return aebu.a().getSyncState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeay
 * JD-Core Version:    0.7.0.1
 */