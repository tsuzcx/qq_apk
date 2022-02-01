import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.humrecognition.BubbleTextView;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import java.io.File;

public class ayep
  extends aygy
  implements Handler.Callback, axrq
{
  private axrh jdField_a_of_type_Axrh = new ayer(this);
  private axsc jdField_a_of_type_Axsc;
  private BubbleTextView jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView;
  private auru jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
  private axro jdField_b_of_type_Axro = (axro)axov.a().c(8);
  private axsf jdField_b_of_type_Axsf = (axsf)axov.a().c(10);
  private boolean dwr;
  public boolean dyL;
  private MusicItemInfo f;
  private Handler.Callback m = new ayes(this);
  private RelativeLayout oh;
  private auru r;
  
  public ayep(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private void eQU()
  {
    this.jdField_b_of_type_Aygz.a(Message.obtain(null, 3, 1, 0));
  }
  
  private void eQV()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "popupRecognitionBubble: invoked. info: mHumMusicItemInfo = " + this.f);
    }
    Object localObject = acfp.m(2131705468) + System.getProperty("line.separator") + axrr.a(this.f);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.initView();
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.measure(0, 0);
    int i = this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.getMeasuredWidth() / 2;
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131364112);
    ((RelativeLayout.LayoutParams)localObject).setMargins(372 - i, 0, 0, 4);
    try
    {
      this.oh.addView(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView, (ViewGroup.LayoutParams)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EditRecognitionPart", 2, "popupRecognitionBubble: Failed. info: exception = ", localThrowable);
    }
  }
  
  private void eQW()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "removeRecognitionBubble: invoked.");
    }
    try
    {
      this.oh.removeView(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EditRecognitionPart", 2, "removeRecognitionBubble: Failed. info: exception = ", localThrowable);
    }
  }
  
  private void eQY()
  {
    if (this.jdField_b_of_type_Axro.b(this.f))
    {
      eQU();
      this.jdField_b_of_type_Axro.a(this.f, this.jdField_b_of_type_Aygz.RS());
      this.jdField_b_of_type_Aygz.b.eRm();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setVisibility(8);
      eQW();
      this.jdField_b_of_type_Axsf.b(this);
      return;
      if (!this.f.mHasCopyright)
      {
        String str = acfp.m(2131705472) + this.f.mMusicName + acfp.m(2131705471);
        QQToast.a(getContext(), 0, str, 0).show();
        if (QLog.isColorLevel()) {
          QLog.d("EditRecognitionPart", 2, "url:" + this.f.mUrl + " playable:" + this.f.mHasCopyright);
        }
      }
      else
      {
        this.jdField_b_of_type_Axro.a(this.f, this.jdField_a_of_type_Axrh);
      }
    }
  }
  
  private void j(MusicItemInfo paramMusicItemInfo)
  {
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    ((QIMMusicConfigManager)axov.a().c(2)).a(paramMusicItemInfo, true);
  }
  
  public File T()
  {
    String str = this.jdField_b_of_type_Aygz.a.Iq();
    if (!TextUtils.isEmpty(str)) {
      return new File(str);
    }
    return null;
  }
  
  public float cf()
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_b_of_type_Aygz.a.b();
    float f1;
    if (localLocalMediaInfo == null) {
      f1 = 0.0F;
    }
    float f2;
    do
    {
      return f1;
      f2 = (float)Math.floor(localLocalMediaInfo.mDuration);
      f1 = f2;
    } while (!QLog.isColorLevel());
    QLog.i("EditRecognitionPart", 2, "getAudioDuration: invoked. info: duration = " + f2);
    return f2;
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    super.d(paramInt1, paramInt2, paramObject);
    eQW();
  }
  
  void eQX()
  {
    aqju localaqju = aqha.a((Activity)getContext(), 2131700437);
    localaqju.setNegativeButton(2131721058, new ayet(this));
    localaqju.setPositiveButton(2131721079, new ayeu(this));
    localaqju.show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return false;
        this.f = ((MusicItemInfo)paramMessage.obj);
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: no match. mHumMusicItemInfo = " + this.f);
        }
      } while ((this.f == null) || (this.f.mType == 7));
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setOnClickListener(new ayeq(this));
      eQV();
      this.dwr = true;
      return false;
    }
    eQU();
    this.jdField_b_of_type_Axro.a(this.f);
    this.jdField_b_of_type_Aygz.b.eRm();
    return false;
  }
  
  public void i(MusicItemInfo paramMusicItemInfo)
  {
    Message localMessage = this.jdField_b_of_type_Auru.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramMusicItemInfo;
    this.jdField_b_of_type_Auru.sendMessage(localMessage);
    if (paramMusicItemInfo != null) {
      this.dwr = true;
    }
    arxa.a().showToast(acfp.m(2131705473) + paramMusicItemInfo);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onActivityResult: invoked. info: requestCode = " + paramInt1 + " resultCode = " + paramInt2 + "data = " + paramIntent);
    }
    if ((paramInt1 == 131) && (paramInt2 == -1) && (paramIntent != null)) {
      this.jdField_b_of_type_Aygz.b.eRm();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onCreate: ");
    }
    this.oh = ((RelativeLayout)y(2131364110));
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView = new BubbleTextView(getContext());
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setPadding(rpq.dip2px(getContext(), 10.0F), rpq.dip2px(getContext(), 10.0F), rpq.dip2px(getContext(), 10.0F), rpq.dip2px(getContext(), 10.0F));
    this.jdField_b_of_type_Axsf.a(this);
    if (this.dyL)
    {
      arxa.a().showToast(acfp.m(2131705470));
      this.r = new auru(ThreadManager.getSubThreadLooper(), this.m);
      this.r.sendEmptyMessage(110);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onDestroy: ");
    }
    this.jdField_b_of_type_Axsf.b(this);
    if (this.r != null) {
      this.r.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Axrh = null;
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onPause: ");
    }
    this.jdField_b_of_type_Axro.Zx();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onStop: mIsFinishRecognition = " + this.dwr);
    }
    this.dwr = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayep
 * JD-Core Version:    0.7.0.1
 */