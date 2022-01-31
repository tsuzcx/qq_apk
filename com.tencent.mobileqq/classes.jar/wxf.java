import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wxf
  extends wwc
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public wxf(@NonNull wwe paramwwe)
  {
    super(paramwwe);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wwe.a.a("shareGroupId");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Wwe.a.a("shareGroupName");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Wwe.a.a("shareGroupType", 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Wwe.a.a("groupUin", -1L);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Wwe.a.a("ignorePersonalPublish", false);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Wwe.a.a("add_video_source", 0);
    wsv.a("EditVideoShareGroup", "shareGroupId=%s, shareGroupName=%s, ignorePersonalPublish=%s, source=%d", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131376505));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new wxg(this));
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      wsv.e("EditVideoShareGroup", "shareGroupId should not be null");
      a().a(0, null, 0, 0);
    }
  }
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {}
    synchronized (this.jdField_a_of_type_Wwe)
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      byte[] arrayOfByte = paramxgs.a.spreadGroupBytes;
      if (arrayOfByte != null) {}
      try
      {
        localVideoSpreadGroupList.mergeFrom(paramxgs.a.spreadGroupBytes);
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
        localVideoSpreadGroupList.visibility_sharegroup_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
        paramxgs.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
        if (this.jdField_a_of_type_Int == 1) {
          paramxgs.a.putExtra("groupUin", Long.valueOf(this.jdField_a_of_type_Long));
        }
        wsv.d("EditVideoShareGroup", "editVideoPrePublish fragment index = %d, share-group %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) });
        paramxgs.a.putExtra("ignorePersonalPublish", Boolean.valueOf(this.jdField_a_of_type_Boolean));
        paramxgs.a.putExtra("add_video_source", Integer.valueOf(this.jdField_b_of_type_Int));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          wsv.c("EditVideoShareGroup", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxf
 * JD-Core Version:    0.7.0.1
 */