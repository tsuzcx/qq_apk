package com.tencent.mobileqq.apollo.process.ui.framework;

import ablw;
import abmt;
import abos;
import aboz;
import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import auru;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class FrameworkView
  extends RelativeLayout
{
  public ablw a;
  public abos a;
  public CmGameStartChecker.StartCheckParam b;
  protected auru e;
  public WeakReference<Activity> mActivityRef;
  
  public FrameworkView(Context paramContext)
  {
    super(paramContext);
    this.mActivityRef = new WeakReference((Activity)paramContext);
  }
  
  public FrameworkView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext);
    this.mActivityRef = new WeakReference((Activity)paramContext);
    this.b = paramStartCheckParam;
  }
  
  public boolean YW()
  {
    if ((this.b == null) || (this.b.gameId == 3112) || (this.b.gameId == 4698)) {}
    aboz localaboz;
    do
    {
      do
      {
        return false;
        if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.YP())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("cmframe_FrameworkView", 2, "isShowExitGuide current game start not success:" + this.b.gameId);
      return false;
      localaboz = abmt.a();
    } while ((localaboz == null) || (!localaboz.YR()));
    return true;
  }
  
  public void a(abos paramabos, auru paramauru, ablw paramablw, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_Abos = paramabos;
    this.e = paramauru;
    this.jdField_a_of_type_Ablw = paramablw;
    this.b = paramStartCheckParam;
  }
  
  public void cEh() {}
  
  public void caS()
  {
    if ((this.b != null) && (this.b.disableMinGame)) {
      if ((this.mActivityRef.get() != null) && ((this.mActivityRef.get() instanceof ApolloGameActivity))) {
        ((ApolloGameActivity)this.mActivityRef.get()).cEP();
      }
    }
    do
    {
      do
      {
        return;
        QLog.i("cmframe_FrameworkView", 1, "[onBackEvent]");
      } while ((this.jdField_a_of_type_Abos == null) || (!this.jdField_a_of_type_Abos.YM()));
      QLog.d("cmframe_FrameworkView", 1, "[onBackEvent] apollo game is running");
      this.jdField_a_of_type_Abos.caS();
    } while (this.mActivityRef.get() == null);
    ((Activity)this.mActivityRef.get()).overridePendingTransition(0, 0);
  }
  
  public abstract void resetView();
  
  public void unbind()
  {
    try
    {
      if ((this.mActivityRef != null) && (this.mActivityRef.get() != null))
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)this.mActivityRef.get()).findViewById(2131377555);
        if (localRelativeLayout != null) {
          localRelativeLayout.removeView(this);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmframe_FrameworkView", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView
 * JD-Core Version:    0.7.0.1
 */