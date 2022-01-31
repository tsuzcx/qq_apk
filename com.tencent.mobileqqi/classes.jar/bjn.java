import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.ui.MultiVideoEnterPage;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TYPE;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bjn
  extends GAudioUIObserver
{
  public bjn(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onServiceConnected");
    }
    super.a();
    if (this.a.jdField_a_of_type_Long != 0L)
    {
      Object localObject = String.valueOf(this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject);
      if ((this.a.jdField_a_of_type_ArrayOfLong != null) && (this.a.jdField_a_of_type_ArrayOfLong.length == 0) && (this.a.jdField_b_of_type_Int == 0))
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a((String)localObject);
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (localObject != null))
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 96: 
      if (this.a.jdField_b_of_type_JavaLangRunnable == null) {
        this.a.jdField_b_of_type_JavaLangRunnable = new bkd(this.a);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 30000L);
      return;
    case 97: 
    case 98: 
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long = 0L;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int = 0;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().f = false;
      this.a.a(paramLong, paramInt, false, -1);
      return;
    case 90: 
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI", 2, "go on stage success");
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI", 2, "CameraNum=" + this.a.k);
      }
      if (this.a.k > 1) {
        this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(105) });
      this.a.M();
      this.a.d(true);
      return;
    case 91: 
    case 92: 
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI", 2, "go on stage failed");
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(false, false, null);
      this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.a.h(2131232201);
      this.a.d(false);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_POST_SELF_VIDEO_FAIL, true);
      ReportController.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "Go Off Stage");
    }
    this.a.d(false);
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onCreateRoomSuc-->GroupID=" + paramLong);
    }
    super.a(paramLong);
    this.a.d(false);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().q = true;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().p = true;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().r = true;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e) {
      this.a.z();
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onInviteSomeoneEnter-->firstUin=" + paramLong + " length=" + paramInt);
    }
    super.a(paramLong, paramInt);
    this.a.g = paramInt;
    this.a.a(paramLong, 68, true, -1);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    super.a(paramLong1, paramLong2, paramBoolean);
    int j;
    int i;
    if (paramBoolean)
    {
      j = 6;
      i = 7;
      this.a.a(paramLong2, i, false, j);
      if (paramLong2 != Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) {
        break label73;
      }
    }
    label73:
    while ((!paramBoolean) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().r))
    {
      return;
      i = 8;
      j = 7;
      break;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 0L) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int != 0))
    {
      localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      paramBoolean = bool2;
      if (!this.a.a(false, true, false, false)) {
        paramBoolean = true;
      }
      localSessionInfo.p = paramBoolean;
      return;
    }
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!this.a.a(false, true, true, true)) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      localSessionInfo.p = paramBoolean;
      return;
    }
  }
  
  protected void a(long paramLong, ArrayList paramArrayList)
  {
    super.a(paramLong, paramArrayList);
    if ((this.a.jdField_c_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPage != null))
    {
      if (paramArrayList.size() == 0) {
        MultiVideoCtrlLayerUI.a(this.a, true);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPage.a(paramArrayList);
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    if (!this.a.jdField_c_of_type_Boolean) {}
    while (paramLong != this.a.jdField_b_of_type_Long) {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.l = false;
      MultiVideoCtrlLayerUI.a(this.a, true);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.b(2, paramLong);
  }
  
  protected void a(long paramLong, long[] paramArrayOfLong)
  {
    boolean bool = false;
    super.a(paramLong, paramArrayOfLong);
    this.a.a(paramArrayOfLong[0], 5, false, 2);
    String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramArrayOfLong[0] == Long.valueOf(str).longValue()) {}
    while (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) {
      return;
    }
    paramArrayOfLong = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!this.a.a(true, true, true, true)) {
      bool = true;
    }
    paramArrayOfLong.p = bool;
  }
  
  protected void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    super.a(paramLong, paramArrayOfLong, paramBoolean);
    if (this.a.jdField_a_of_type_Long != paramLong) {
      return;
    }
    if (paramArrayOfLong[0] == Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().a).longValue()) {
      paramBoolean = false;
    }
    for (;;)
    {
      this.a.a(paramArrayOfLong[0], 0, paramBoolean, 0);
      return;
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
  }
  
  protected void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    String str1 = paramArrayOfString[0];
    float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427662);
    String str2;
    if (i == 1)
    {
      paramArrayOfString = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131560211);
      if (paramString.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
        break label253;
      }
      str2 = this.a.a(paramString);
      f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427665);
      str1 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.a.jdField_a_of_type_AndroidWidgetTextView, f);
      str2 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), str2, this.a.jdField_a_of_type_AndroidWidgetTextView, f);
    }
    for (this.a.jdField_b_of_type_JavaLangString = (str2 + this.a.jdField_a_of_type_AndroidContentResResources.getString(2131560208) + str1 + paramArrayOfString);; this.a.jdField_b_of_type_JavaLangString = (this.a.jdField_a_of_type_AndroidContentResResources.getString(2131560209) + str1 + paramArrayOfString))
    {
      this.a.a(Long.valueOf(paramString).longValue(), 82, true, -1);
      return;
      paramArrayOfString = String.format(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131560210), new Object[] { Integer.valueOf(i) });
      break;
      label253:
      str1 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.a.jdField_a_of_type_AndroidWidgetTextView, f);
    }
  }
  
  protected void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    super.a(paramArrayOfLong, paramBoolean);
    if (paramBoolean) {}
    for (int i = 10;; i = 11)
    {
      this.a.a(paramArrayOfLong[0], 2, false, i);
      return;
    }
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    super.b(paramLong);
    this.a.d(false);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new bjo(this), 500L);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e) {
      this.a.z();
    }
  }
  
  protected void b(long paramLong, long[] paramArrayOfLong)
  {
    super.a(paramLong, paramArrayOfLong);
    if ((paramArrayOfLong[0] == this.a.d) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "onMemberVideoOut-->Server  gooffstahe ,must close local video");
      }
      this.a.B();
    }
    this.a.a(paramArrayOfLong[0], 6, false, 3);
  }
  
  protected void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onDestroyUI");
    }
    super.c(paramLong);
    if (this.a.jdField_a_of_type_Long == paramLong) {
      MultiVideoCtrlLayerUI.a(this.a, true);
    }
  }
  
  protected void c(long paramLong, long[] paramArrayOfLong)
  {
    super.c(paramLong, paramArrayOfLong);
    this.a.a(paramArrayOfLong[0], 1, true, 1);
  }
  
  protected void e(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onFirstFrameDataComeIn");
    }
    if (this.a.jdField_b_of_type_JavaLangRunnable == null) {
      this.a.jdField_b_of_type_JavaLangRunnable = new bkd(this.a);
    }
    if (this.a.jdField_c_of_type_JavaLangRunnable == null) {
      this.a.jdField_c_of_type_JavaLangRunnable = new bkc(this.a);
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103) });
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_c_of_type_JavaLangRunnable);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_c_of_type_JavaLangRunnable, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjn
 * JD-Core Version:    0.7.0.1
 */