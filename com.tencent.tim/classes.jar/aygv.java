import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView;

class aygv
  implements MessageQueue.IdleHandler
{
  aygv(aygu paramaygu) {}
  
  public boolean queueIdle()
  {
    aygu.a(this.a, true);
    if ((this.a.jdField_a_of_type_Ayii == null) || (this.a.jdField_a_of_type_Ayii.getActivity() == null) || (this.a.jdField_a_of_type_Ayii.getActivity().getIntent() == null) || (this.a.jdField_a_of_type_Ayii.getActivity().getIntent().getExtras() == null)) {
      return false;
    }
    Object localObject = this.a.jdField_a_of_type_Ayii.getActivity().getIntent().getExtras();
    String str4 = ((Bundle)localObject).getString("share_url_target_url");
    String str1 = ((Bundle)localObject).getString("share_url_name");
    String str2 = ((Bundle)localObject).getString("share_url_text");
    String str3 = ((Bundle)localObject).getString("share_url_thumb_url");
    String str5 = ((Bundle)localObject).getString("struct_share_key_source_name");
    String str6 = ((Bundle)localObject).getString("struct_share_key_source_icon");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onResume : url = ");
      if (str4 != null) {
        break label424;
      }
      localObject = "null";
      label168:
      localStringBuilder = localStringBuilder.append((String)localObject).append(" , name = ");
      if (str1 != null) {
        break label430;
      }
      localObject = "null";
      label188:
      localStringBuilder = localStringBuilder.append((String)localObject).append(" , text = ");
      if (str2 != null) {
        break label435;
      }
      localObject = "null";
      label208:
      localStringBuilder = localStringBuilder.append((String)localObject).append(" , thumUrl = ");
      if (str3 != null) {
        break label440;
      }
      localObject = "null";
      label229:
      localStringBuilder = localStringBuilder.append((String)localObject).append(" , sourceName = ");
      if (str5 != null) {
        break label446;
      }
      localObject = "null";
      label250:
      localStringBuilder = localStringBuilder.append((String)localObject).append(" , sourceIconUrl = ");
      if (str6 != null) {
        break label452;
      }
    }
    label424:
    label430:
    label435:
    label440:
    label446:
    label452:
    for (localObject = "null";; localObject = str6)
    {
      QLog.d("Q.qqstory.publish.editEditVideoLinker", 2, (String)localObject);
      if (str4 == null) {
        break;
      }
      this.a.eRB();
      rar.a("video_shoot", "exp_linkbar", 1, 0, new String[] { "", "", "", "" });
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setShowShare(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.cXN = str5;
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.cXM = str6;
      localObject = new aypi(str4);
      ((aypi)localObject).zc = str1;
      ((aypi)localObject).aue = str2;
      ((aypi)localObject).auf = str3;
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setLinkerObject((aypi)localObject);
      this.a.b.a(Message.obtain(null, 15, 1, 0));
      return false;
      localObject = str4;
      break label168;
      localObject = str1;
      break label188;
      localObject = str2;
      break label208;
      localObject = str3;
      break label229;
      localObject = str5;
      break label250;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygv
 * JD-Core Version:    0.7.0.1
 */