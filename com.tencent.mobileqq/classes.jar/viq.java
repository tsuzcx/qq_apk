import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class viq
  extends vhn
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public viq(@NonNull vhp paramvhp)
  {
    super(paramvhp);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vhp.a.a("shareGroupId");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Vhp.a.a("shareGroupName");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Vhp.a.a("shareGroupType", 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Vhp.a.a("groupUin", -1L);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Vhp.a.a("ignorePersonalPublish", false);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Vhp.a.a("add_video_source", 0);
    veg.a("EditVideoShareGroup", "shareGroupId=%s, shareGroupName=%s, ignorePersonalPublish=%s, source=%d", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131376004));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vir(this));
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      veg.e("EditVideoShareGroup", "shareGroupId should not be null");
      a().a(0, null, 0, 0);
    }
  }
  
  public void a(int paramInt, @NonNull vsd paramvsd)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {}
    synchronized (this.jdField_a_of_type_Vhp)
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      byte[] arrayOfByte = paramvsd.a.spreadGroupBytes;
      if (arrayOfByte != null) {}
      try
      {
        localVideoSpreadGroupList.mergeFrom(paramvsd.a.spreadGroupBytes);
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
        localVideoSpreadGroupList.visibility_sharegroup_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
        paramvsd.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
        if (this.jdField_a_of_type_Int == 1) {
          paramvsd.a.putExtra("groupUin", Long.valueOf(this.jdField_a_of_type_Long));
        }
        veg.d("EditVideoShareGroup", "editVideoPrePublish fragment index = %d, share-group %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) });
        paramvsd.a.putExtra("ignorePersonalPublish", Boolean.valueOf(this.jdField_a_of_type_Boolean));
        paramvsd.a.putExtra("add_video_source", Integer.valueOf(this.jdField_b_of_type_Int));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          veg.c("EditVideoShareGroup", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     viq
 * JD-Core Version:    0.7.0.1
 */