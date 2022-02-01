import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonGuideBubbleView;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class wtk
  implements Handler.Callback, View.OnClickListener, wvr, wvs
{
  private aenf.c jdField_a_of_type_Aenf$c;
  private EmoticonGuideBubbleView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView;
  private final MqqHandler b;
  private BaseChatPie c;
  
  public wtk(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.b = new aurf(Looper.getMainLooper(), this);
  }
  
  private void a(aenf.c paramc)
  {
    if (paramc == null) {}
    String str;
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.c == null) || (!a(paramc)) || (this.c.a() == null));
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "realShowGuideBubble start.");
      }
      this.jdField_a_of_type_Aenf$c = paramc;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble  mGuideBubbleView is new create.");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView = new EmoticonGuideBubbleView(this.c.mContext);
      }
      str = paramc.a.Sw;
      if (ThemeUtil.isNowThemeIsNight(this.c.app, false, null)) {
        str = paramc.a.bzL;
      }
      bool = ThemeUtil.isNowThemeIsSimple(this.c.app, false, null);
    } while (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.a(this.c.i(), this.c.b, str, paramc.a.mWidth, paramc.a.mHeight, bool));
    anot.a(this.c.app, "dc00898", "", "", "0X800AD4C", "0X800AD4C", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.setOnClickListener(this);
    aqmj.z("key_show_emoticon_guide", Boolean.valueOf(false));
    this.b.removeCallbacksAndMessages(null);
    this.b.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private boolean a(aenf.c paramc)
  {
    if (paramc == null) {
      return false;
    }
    if ((((Boolean)aqmj.get("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) && (paramc.a.isOpen())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int[] C()
  {
    return new int[] { 9, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    cbH();
  }
  
  public void aex()
  {
    if (!((Boolean)aqmj.get("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AIOEmoticonGuideHelper.1(this));
  }
  
  public void cbH()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.getVisibility() == 0) && (this.c != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "removeGuideBubble ");
      }
      this.jdField_a_of_type_Aenf$c = null;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.z(this.c.i());
    }
    this.b.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      cbH();
    }
    while (paramMessage.what != 2) {
      return true;
    }
    a((aenf.c)paramMessage.obj);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((this.c == null) || (this.c.a() == null) || (this.jdField_a_of_type_Aenf$c == null)) {}
    label164:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.z(this.c.i());
      int i = this.jdField_a_of_type_Aenf$c.a.cNT;
      int k = this.jdField_a_of_type_Aenf$c.a.cNU;
      if (k == 1)
      {
        i = afky.hm(i);
        if (!afky.jr(i)) {}
      }
      else
      {
        for (;;)
        {
          if (i == -1) {
            break label164;
          }
          anot.a(this.c.app, "dc00898", "", "", "0X800AD4D", "0X800AD4D", 0, 0, "", "", "", "");
          this.c.a().hO(k, i);
          break;
          if (k == 2)
          {
            int j = afku.hj(i);
            i = j;
            if (afku.jl(j)) {
              continue;
            }
            break;
          }
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtk
 * JD-Core Version:    0.7.0.1
 */