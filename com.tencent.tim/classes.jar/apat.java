import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import java.util.List;
import java.util.Observer;

public class apat
  extends apab
{
  apac jdField_a_of_type_Apac = new apac();
  apag jdField_a_of_type_Apag = new apag();
  apas jdField_a_of_type_Apas = new apas();
  apmz jdField_a_of_type_Apmz = new apmz();
  public boolean aPY;
  public long aqG;
  public long aqH;
  apaq b;
  public boolean cPD;
  protected GestureDetector mGestureDetector;
  public boolean valid;
  
  public apat()
  {
    this.jdField_b_of_type_Apaq = new apaq();
  }
  
  public int Le()
  {
    if (this.bvv) {
      return this.jdField_b_of_type_Apaq.Ld();
    }
    return 0;
  }
  
  public int Lf()
  {
    if ((this.bvv) && (this.jdField_a_of_type_Apmz != null)) {
      return this.jdField_a_of_type_Apmz.Lf();
    }
    return -1;
  }
  
  public void Rv(boolean paramBoolean)
  {
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.bvv)
    {
      localObject = null;
      if (!this.jdField_a_of_type_Apmz.aBm()) {
        break label65;
      }
      localObject = this.jdField_a_of_type_Apmz;
      if (localObject != null)
      {
        localObject = ((apab)localObject).cx();
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (!paramBoolean) {
            break label101;
          }
          localLayoutParams.addRule(3, 2131380368);
        }
      }
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(localLayoutParams);
      return;
      label65:
      if (this.jdField_a_of_type_Apas.aAK())
      {
        localObject = this.jdField_a_of_type_Apas;
        break;
      }
      if (!this.jdField_a_of_type_Apag.aAI()) {
        break;
      }
      localObject = this.jdField_a_of_type_Apag;
      break;
      label101:
      int i = apmz.a(this.fs, new int[] { 2131374819, 2131374907, 2131374902 });
      if (i > 0) {
        localLayoutParams.addRule(3, i);
      }
    }
  }
  
  public void Ww(int paramInt)
  {
    if (this.bvv) {
      this.jdField_a_of_type_Apmz.WR(paramInt);
    }
  }
  
  public void Wx(int paramInt)
  {
    if (this.bvv) {
      this.jdField_a_of_type_Apmz.onScroll();
    }
  }
  
  public void Wy(int paramInt)
  {
    if (this.bvv) {
      this.jdField_b_of_type_Apaq.Wu(paramInt);
    }
  }
  
  public apag a()
  {
    return this.jdField_a_of_type_Apag;
  }
  
  public apmz a()
  {
    return this.jdField_a_of_type_Apmz;
  }
  
  public void a(Observer paramObserver)
  {
    if (this.bvv)
    {
      this.jdField_b_of_type_Apaq.d = paramObserver;
      this.jdField_a_of_type_Apmz.d = paramObserver;
      this.jdField_a_of_type_Apas.d = paramObserver;
      this.jdField_a_of_type_Apac.d = paramObserver;
    }
  }
  
  public boolean aAJ()
  {
    if (this.bvv) {
      return this.jdField_b_of_type_Apaq.aAJ();
    }
    return false;
  }
  
  public boolean aAK()
  {
    if (this.bvv) {
      return this.jdField_a_of_type_Apas.aAK();
    }
    return false;
  }
  
  public boolean aAL()
  {
    return this.jdField_a_of_type_Apmz.aAL();
  }
  
  public boolean aAM()
  {
    if (this.bvv) {
      return this.jdField_a_of_type_Apmz.aAM();
    }
    return false;
  }
  
  public boolean aAN()
  {
    if (this.bvv) {
      return this.jdField_a_of_type_Apmz.aBm();
    }
    return false;
  }
  
  public boolean aAO()
  {
    if (this.bvv) {
      return this.jdField_a_of_type_Apag.aAI();
    }
    return false;
  }
  
  public boolean aAP()
  {
    return (aAN()) || (aAK()) || (aAO());
  }
  
  protected void cbf()
  {
    this.mGestureDetector = null;
    this.jdField_b_of_type_Apaq.uninit();
    this.jdField_a_of_type_Apmz.uninit();
    this.jdField_a_of_type_Apas.uninit();
    this.jdField_a_of_type_Apac.uninit();
    this.jdField_a_of_type_Apag.uninit();
    this.valid = false;
    this.aqG = 0L;
    this.aqH = 0L;
    this.aPY = false;
  }
  
  public void dYs()
  {
    if ((this.bvv) && (!this.cPD)) {
      this.jdField_a_of_type_Apmz.dYs();
    }
  }
  
  public void dYt()
  {
    if ((this.bvv) && (!this.cPD)) {
      this.jdField_a_of_type_Apas.dYq();
    }
  }
  
  public void dYu()
  {
    if (this.bvv) {
      this.jdField_a_of_type_Apmz.dYu();
    }
  }
  
  public void dYv()
  {
    this.valid = false;
  }
  
  public void dYw()
  {
    this.jdField_a_of_type_Apac.dYi();
  }
  
  public void fG(long paramLong)
  {
    if (this.bvv) {
      this.jdField_a_of_type_Apmz.fG(paramLong);
    }
  }
  
  public void j(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.valid = true;
    this.aqG = paramLong1;
    this.aqH = paramLong2;
    this.aPY = paramBoolean;
  }
  
  public boolean lX(int paramInt)
  {
    if (this.bvv) {
      return this.jdField_a_of_type_Apmz.lX(paramInt);
    }
    return false;
  }
  
  public void mL(List<TroopAIONotifyItem> paramList)
  {
    this.jdField_a_of_type_Apas.mL(paramList);
  }
  
  public void mM(List<ChatMessage> paramList)
  {
    if ((this.bvv) && (!this.cPD)) {
      this.jdField_a_of_type_Apmz.mM(paramList);
    }
  }
  
  protected void onInit()
  {
    this.jdField_b_of_type_Apaq.a(this.app, this.context, this.j, this.sessionInfo, this.fs, this.jdField_a_of_type_Wki, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Apmz.a(this.app, this.context, this.j, this.sessionInfo, this.fs, this.jdField_a_of_type_Wki, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Apas.a(this.app, this.context, this.j, this.sessionInfo, this.fs, this.jdField_a_of_type_Wki, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Apac.a(this.app, this.context, this.j, this.sessionInfo, this.fs, this.jdField_a_of_type_Wki, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Apag.a(this.app, this.context, this.j, this.sessionInfo, this.fs, this.jdField_a_of_type_Wki, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Apag.a(this);
    this.mGestureDetector = new GestureDetector(this.context, new apau(this));
    this.valid = false;
    this.aqG = 0L;
    this.aqH = 0L;
    this.aPY = false;
  }
  
  public void onPause()
  {
    this.jdField_b_of_type_Apaq.cPB = false;
  }
  
  public void onResume()
  {
    this.jdField_b_of_type_Apaq.cPB = true;
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.bvv) && (this.mGestureDetector != null)) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    dYw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apat
 * JD-Core Version:    0.7.0.1
 */