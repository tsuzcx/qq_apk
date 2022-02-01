package com.tencent.mobileqq.studyroom.ui;

import android.view.View;
import android.view.ViewGroup;
import mqq.util.WeakReference;

class StudyRoomLoadingFragment$WeakCallback$2
  implements Runnable
{
  StudyRoomLoadingFragment$WeakCallback$2(StudyRoomLoadingFragment.a parama, View paramView) {}
  
  public void run()
  {
    StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)StudyRoomLoadingFragment.a.a(this.this$0).get();
    if (localStudyRoomLoadingFragment != null)
    {
      View localView = localStudyRoomLoadingFragment.getView();
      if ((localView instanceof ViewGroup)) {
        ((ViewGroup)localView).addView(this.val$view);
      }
      StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment.WeakCallback.2
 * JD-Core Version:    0.7.0.1
 */