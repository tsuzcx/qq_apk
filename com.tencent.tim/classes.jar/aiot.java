import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aiot
  extends ainv
{
  public aiot(ListenTogetherPlayFragment paramListenTogetherPlayFragment) {}
  
  protected void O(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.getId().equals(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      if (paramString2 != null) {
        break label120;
      }
    }
    for (;;)
    {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetLyric %s %d", new Object[] { paramString1, Integer.valueOf(i) }));
      this.this$0.lyric = paramString2;
      ListenTogetherPlayFragment.a(this.this$0, paramString1, this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.status, paramString2);
      return;
      label120:
      i = paramString2.length();
    }
  }
  
  protected void S(int paramInt, String paramString1, String paramString2)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin.equals(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onListenTogetherJoinedCountChange msg=%s", new Object[] { paramString2 }));
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.bPm = paramString2;
    if (paramInt == 1)
    {
      this.this$0.jdField_a_of_type_Aink.LM(paramString1);
      return;
    }
    ListenTogetherPlayFragment.a(this.this$0, ListenTogetherPlayFragment.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.bPm);
  }
  
  protected void c(ISong paramISong)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.equals(paramISong)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onPlayMusicChange %s", new Object[] { paramISong }));
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong = paramISong;
    this.this$0.lyric = null;
    ListenTogetherPlayFragment.a(this.this$0, paramISong);
  }
  
  protected void cW(int paramInt, String paramString)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onPauseListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    QQToast.a(localFragmentActivity, 2131695347, 1).show();
  }
  
  protected void cX(int paramInt, String paramString)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onResumeListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    QQToast.a(localFragmentActivity, 2131695351, 1).show();
  }
  
  protected void cY(int paramInt, String paramString)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onCutListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    QQToast.a(localFragmentActivity, 2131695324, 1).show();
  }
  
  protected void cZ(int paramInt, String paramString)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onChangePlayModeListenTogetherFail [%s, %d]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    QQToast.a(localFragmentActivity, 2131695348, 1).show();
  }
  
  protected void d(ListenTogetherSession paramListenTogetherSession)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin.equals(paramListenTogetherSession.uin)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onUIModuleNeedRefresh session=%s", new Object[] { paramListenTogetherSession }));
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = paramListenTogetherSession;
    MusicInfo localMusicInfo = paramListenTogetherSession.b();
    if ((paramListenTogetherSession.deR != 2) || (paramListenTogetherSession.status == 3) || (paramListenTogetherSession.status == 4) || (localMusicInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogetherPlayFragment", 2, "onExit");
      }
      QQToast.a(localFragmentActivity, 2131695338, 1).show();
      this.this$0.getActivity().finish();
      return;
    }
    c(localMusicInfo);
    ListenTogetherPlayFragment.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.getId(), paramListenTogetherSession.status, this.this$0.lyric);
  }
  
  protected void d(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (!this.this$0.isAdded())) {}
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetGroupJoinedUsers uin=%s num=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    ListenTogetherPlayFragment.a(this.this$0, paramList, this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.bPm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiot
 * JD-Core Version:    0.7.0.1
 */