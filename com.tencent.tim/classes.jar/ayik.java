import android.app.Activity;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

class ayik
  implements MessageQueue.IdleHandler
{
  ayik(ayij paramayij) {}
  
  public boolean queueIdle()
  {
    ayij.a(this.b, true);
    if ((this.b.jdField_a_of_type_Ayii == null) || (this.b.jdField_a_of_type_Ayii.getActivity() == null) || (this.b.jdField_a_of_type_Ayii.getActivity().getIntent() == null) || (this.b.jdField_a_of_type_Ayii.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.b.b.a;
    String str1 = ((EditVideoParams)localObject).getStringExtra("vip_forward_uid");
    String str2 = ((EditVideoParams)localObject).getStringExtra("vip_forward_vid");
    String str3 = ((EditVideoParams)localObject).getStringExtra("vip_forward_feedid");
    String str4 = ((EditVideoParams)localObject).getStringExtra("vip_forward_name");
    localObject = ((EditVideoParams)localObject).getStringExtra("vip_forward_avatrname");
    ayij.a(this.b, new pty());
    ayij.a(this.b).styleType = 5;
    ayij.a(this.b).a = new pty.a();
    ayij.a(this.b).a.avo = str1;
    ayij.a(this.b).a.vid = str2;
    ayij.a(this.b).a.feedID = str3;
    ayij.a(this.b).a.nickName = str4;
    ayij.a(this.b).a.headUrl = ((String)localObject);
    this.b.eRB();
    this.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView.setLinkInfo(ayij.a(this.b));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayik
 * JD-Core Version:    0.7.0.1
 */