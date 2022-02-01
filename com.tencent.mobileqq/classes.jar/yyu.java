import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class yyu
  extends yxr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public yyu(@NonNull yxt paramyxt)
  {
    super(paramyxt);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Yxt.a.a("shareGroupId");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Yxt.a.a("shareGroupName");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Yxt.a.a("shareGroupType", 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Yxt.a.a("groupUin", -1L);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Yxt.a.a("ignorePersonalPublish", false);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Yxt.a.a("add_video_source", 0);
    yuk.a("EditVideoShareGroup", "shareGroupId=%s, shareGroupName=%s, ignorePersonalPublish=%s, source=%d", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377490));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new yyv(this));
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      yuk.e("EditVideoShareGroup", "shareGroupId should not be null");
      a().a(0, null, 0, 0);
    }
  }
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {}
    synchronized (this.jdField_a_of_type_Yxt)
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      byte[] arrayOfByte = paramzih.a.spreadGroupBytes;
      if (arrayOfByte != null) {}
      try
      {
        localVideoSpreadGroupList.mergeFrom(paramzih.a.spreadGroupBytes);
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
        localVideoSpreadGroupList.visibility_sharegroup_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
        paramzih.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
        if (this.jdField_a_of_type_Int == 1) {
          paramzih.a.putExtra("groupUin", Long.valueOf(this.jdField_a_of_type_Long));
        }
        yuk.d("EditVideoShareGroup", "editVideoPrePublish fragment index = %d, share-group %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) });
        paramzih.a.putExtra("ignorePersonalPublish", Boolean.valueOf(this.jdField_a_of_type_Boolean));
        paramzih.a.putExtra("add_video_source", Integer.valueOf(this.jdField_b_of_type_Int));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          yuk.c("EditVideoShareGroup", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyu
 * JD-Core Version:    0.7.0.1
 */