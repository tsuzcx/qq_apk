import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class ayhw
  extends aygy
{
  private boolean aCI;
  private String axW;
  private String shareGroupId;
  private TextView ys;
  
  public ayhw(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    if (this.shareGroupId != null) {}
    synchronized (this.b)
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      byte[] arrayOfByte = paramayqb.g.spreadGroupBytes;
      if (arrayOfByte != null) {}
      try
      {
        localVideoSpreadGroupList.mergeFrom(paramayqb.g.spreadGroupBytes);
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(this.shareGroupId));
        localVideoSpreadGroupList.visibility_sharegroup_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
        paramayqb.g.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
        ram.w("EditVideoShareGroup", "editVideoPrePublish fragment index = %d, share-group %s %s", new Object[] { Integer.valueOf(paramInt), this.shareGroupId, this.axW });
        paramayqb.g.putExtra("ignorePersonalPublish", Boolean.valueOf(this.aCI));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          ram.e("EditVideoShareGroup", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.shareGroupId = this.b.a.getStringExtra("shareGroupId");
    this.axW = this.b.a.getStringExtra("shareGroupName");
    this.aCI = this.b.a.getBooleanExtra("ignorePersonalPublish", false);
    ram.a("EditVideoShareGroup", "shareGroupId=%s, shareGroupName=%s, ignorePersonalPublish=%s", this.shareGroupId, this.axW, Boolean.valueOf(this.aCI));
    this.ys = ((TextView)y(2131378170));
    this.ys.setVisibility(0);
    this.ys.setText(this.axW);
    this.ys.setOnClickListener(new ayhx(this));
    if (this.shareGroupId == null)
    {
      ram.e("EditVideoShareGroup", "shareGroupId should not be null");
      a().a(0, null, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhw
 * JD-Core Version:    0.7.0.1
 */