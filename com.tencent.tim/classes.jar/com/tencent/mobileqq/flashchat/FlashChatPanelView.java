package com.tencent.mobileqq.flashchat;

import acfp;
import ahep;
import ahxs;
import ahyb;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import ujt;

public class FlashChatPanelView
  extends RichTextPanelView
  implements ahep
{
  private static final String NAME = acfp.m(2131706333);
  private ahyb jdField_a_of_type_Ahyb;
  private FlashChatTextEffectView jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView;
  private BaseChatPie mBaseChatPie;
  
  public FlashChatPanelView(Context paramContext, BaseChatPie paramBaseChatPie, ahyb paramahyb)
  {
    super(paramContext);
    this.mBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Ahyb = paramahyb;
    init();
  }
  
  private void init()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView(getContext(), this.mBaseChatPie, this, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.setPanelExtendHelper(this.jdField_a_of_type_Ahyb);
  }
  
  public void Af(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FlashChatManager localFlashChatManager = (FlashChatManager)this.mBaseChatPie.app.getManager(217);
      if (localFlashChatManager.cS().size() < 3) {
        localFlashChatManager.dmU();
      }
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.dna();
      Mh();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(2);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(4);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.kX.clear();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.dmY();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.dmZ();
  }
  
  public void Mh()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.Mh();
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public void h(View paramView, int paramInt1, int paramInt2)
  {
    if (!ahxs.de.get()) {}
    label128:
    do
    {
      return;
      Object localObject = new StringBuilder();
      FlashChatPanel.a locala = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.a(paramInt1);
      if ((locala != null) && (locala.b != null)) {}
      for (paramInt1 = locala.b.id;; paramInt1 = -1)
      {
        paramView = (FlashChatManager)this.mBaseChatPie.app.getManager(217);
        paramView.JU(((StringBuilder)localObject).toString());
        if (!this.mBaseChatPie.a.getText().toString().isEmpty()) {
          break label128;
        }
        if ((locala == null) || (locala.b == null) || (locala.b.id != -100001)) {
          break;
        }
        return;
      }
      localObject = FlashChatManager.lj(this.mBaseChatPie.a.getText().toString()).replaceAll("\\s", "");
      if (((String)localObject).length() > 20) {
        break;
      }
      paramView = paramView.a((String)localObject, 0, paramInt1);
    } while (paramView == null);
    this.mBaseChatPie.a.setText("");
    this.mBaseChatPie.a.setCompoundDrawables(null, null, null, null);
    this.mBaseChatPie.a.setTag(2131374473, null);
    this.mBaseChatPie.a.setSelection(0);
    ujt.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.mBaseChatPie.a(), paramView);
    anot.a(this.mBaseChatPie.app, "CliOper", "", "", "0X80094D6", "0X80094D6", 0, 0, "", "", "", "");
    this.mBaseChatPie.aey();
    return;
    QQToast.a(getContext(), acfp.m(2131706332), 0).show();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.kX.clear();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.dmY();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.dnb();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeCallbacksAndMessages(null);
    }
  }
  
  public void onHide()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(2);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.b.removeMessages(4);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.kX.clear();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.dmY();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.dmZ();
  }
  
  public void onShow()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.dna();
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView.Mh();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void x(View paramView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanelView
 * JD-Core Version:    0.7.0.1
 */