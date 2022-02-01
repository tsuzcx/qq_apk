package com.tencent.av.ui;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;

class MultiVideoMembersListviewAvtivity$ListViewBaseAdapter$1
  implements Runnable
{
  MultiVideoMembersListviewAvtivity$ListViewBaseAdapter$1(MultiVideoMembersListviewAvtivity.a parama, MultiVideoMembersListviewAvtivity.a.a parama1, VideoController.b paramb) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity$a$a.oF == this.jdField_a_of_type_ComTencentAvVideoController$b.uin) && (this.jdField_a_of_type_ComTencentAvVideoController$b.faceBitmap == null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController$b.faceBitmap = this.b.p(String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController$b.uin));
      if (this.jdField_a_of_type_ComTencentAvVideoController$b.faceBitmap != null) {
        break label104;
      }
      if (this.b.a.mApp != null) {
        this.b.a.mApp.getHandler().postDelayed(new MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1.1(this), 1000L);
      }
    }
    return;
    label104:
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity$a$a.gA.setImageBitmap(this.jdField_a_of_type_ComTencentAvVideoController$b.faceBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */