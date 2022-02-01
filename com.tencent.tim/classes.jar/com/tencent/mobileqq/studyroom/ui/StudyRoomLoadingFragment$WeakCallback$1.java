package com.tencent.mobileqq.studyroom.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

class StudyRoomLoadingFragment$WeakCallback$1
  implements Runnable
{
  StudyRoomLoadingFragment$WeakCallback$1(StudyRoomLoadingFragment.a parama) {}
  
  public void run()
  {
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)StudyRoomLoadingFragment.a.a(this.this$0).get();
    if ((localStudyRoomLoadingFragment == null) || (localStudyRoomLoadingFragment.getActivity() == null)) {
      return;
    }
    QQToast.a(localStudyRoomLoadingFragment.getActivity().getApplicationContext(), 1, 2131701106, 0).show();
    StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
    localStudyRoomLoadingFragment.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.1
 * JD-Core Version:    0.7.0.1
 */